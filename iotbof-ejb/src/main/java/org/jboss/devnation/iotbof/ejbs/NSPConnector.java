package org.jboss.devnation.iotbof.ejbs;
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jboss.devnation.iotbof.rest.Endpoint;
import org.jboss.devnation.iotbof.rest.EndpointResource;
import org.jboss.devnation.iotbof.rest.INSP;
import org.jboss.devnation.iotbof.rest.NSPClient;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingEnumeration;
import javax.ws.rs.NotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A singleton ejb that initializes the connections to the NSP and provides
 * information about the devices connected to the NSP
<subsystem xmlns="urn:jboss:domain:naming:2.0">
   <bindings>
      <simple name="java:global/NSPDomain" value="domain" type="java.lang.String"/>
      <simple name="java:global/NSPURL" value="http://red-hat-summit.cloudapp.net:8081/" type="java.net.URL"/>
      <simple name="java:global/NotificationCallbackURL" value="http://reponsehost:port/events/..." type="java.net.URL"/>
   </bindings>
</subsystem>
 */
@Singleton
@Startup
public class NSPConnector {
   private static final Logger logger = Logger.getLogger(NSPConnector.class);
   private ConcurrentHashMap<String, Endpoint> endpoints = new ConcurrentHashMap<>();

   /**
    * The NSP domain name used when communicating with the server
    *
    */
   @Resource(name = "java:global/NSPDomain")
   private String domain = "domain";
   /**
    *
    */
   @Resource(name = "java:global/NSPURL")
   private String nspURL;
   /**
    * The location of the resteasy service which notification callbacks
    */
   @Resource(name = "java:global/NotificationCallbackURL")
   private URL notificationURL;

   /**
    * The NSP communication interface
    * @see org.jboss.devnation.iotbof.weld.WeldProducerMethods#getNSPImplementation()
    */
   @Inject
   private INSP nspApi;
   private String serverInfo;
   private boolean hasNotificationHandler;

   /**
    * Default constructor.
    */
   public NSPConnector() {
   }

   @PostConstruct
   public void postConstruct() {
      try {
         InitialContext ctx = new InitialContext();
         Context global = (Context) ctx.lookup("java:global");
         NamingEnumeration<NameClassPair> listing = global.list("");
         System.out.printf("java:global listing:\n");
         while(listing.hasMore()) {
            NameClassPair ncp = listing.next();
            System.out.printf("+++ %s: %s\n", ncp.getName(), ncp.getClassName());
         }
      } catch (Exception e) {
         throw new IllegalStateException(e);
      }
      // Validate the domain
      if (domain == null)
         throw new IllegalStateException("The domain field is null");

      // Step 1, query the server to validate connection configuration
      serverInfo = nspApi.getServerInfo();
      logger.infof("Connected to NSP server %s\n", serverInfo);
   }

   @PreDestroy
   public void preDestroy() {

   }

   /**
    *
    * @return A set of all loaded endpoint names. This may be empty if no endpoints have been loaded.
    */
   public Set<String> getEndpointNames() {
      return endpoints.keySet();
   }

   /**
    * @return a list of all loaded endpoint. This may be empty if no endpoints have been loaded.
    */
   public List<Endpoint> getEndpoints() {
      return new ArrayList<>(endpoints.values());
   }

   /**
    * Lookup an endpoint by its name
    * @param name the endpoint name
    * @return the endpoint if found, null if the name does not map to a loaded endpoint
    */
   public Endpoint getEndpoint(String name) {
      return endpoints.get(name);
   }

   /**
    * This reloads all of the NSP server endpoints and their associated resources
    * @param progress a callback interface to pass the load progress to
    */
   public void reload(IProgress progress) {
      List<Endpoint> eps = nspApi.queryEndpoints(domain, false);
      int count;
      int task, taskCount;
      endpoints.clear();
      if (eps != null) {
         count = eps.size();
         taskCount = count;
         task = 0;
         logger.infof("Found %d endpoints\n", count);
         for (int n = 0; n < count; n ++) {
            Endpoint ep = eps.get(n);
            String name = ep.getName();
            progress.updateProgress(task, taskCount, "Loading: "+name);
            logger.infof("Loading %s endpoint\n", name);
            endpoints.put(name, ep);
            task ++;
            List<EndpointResource> ers = nspApi.queryEndpointResources(domain, name);
            taskCount += ers.size();
            progress.updateProgress(task, taskCount, "Loading resources for:"+name);
            for (EndpointResource er : ers) {
               String msg = String.format("Loading %s%s resource\n", name, er.getUri());
               progress.updateProgress(task, taskCount, msg);
               logger.info(msg);
               try {
                  String value = NSPClient.queryEndpointResourceValue(domain, name, er.getUri(), false, false);
                  logger.infof("%s(%s)=%s\n", name, er.getUri(), value);
                  er.setValue(value);
                  // Step 3, register for updates
                  if (er.getObs().equalsIgnoreCase("true") && hasNotificationHandler) {
                     nspApi.subscribeEndpointResource(domain, name, er.getUri());
                     logger.infof("Requested updates for: %s(%s)", name, er.getUri());
                  }
               } catch (Exception e) {
                  msg = String.format("Failed to load %s%s resource, err=\n", name, er.getUri(), e.getMessage());
                  logger.warn(msg);
               }
               task ++;
               progress.updateProgress(task, taskCount, msg);
            }
            ep.setResources(ers);
         }
         progress.updateProgress(taskCount, taskCount, "Completed loading");
      }
   }

   /**
    * Get the URL of the NSP server rest interface
    * @return URL of the NSP server rest interface
    */
   public String getNspURL() {
      return nspURL;
   }
   /**
    * Get the NSP server version string
    * @return the NSP server version string
    */
   public String getServerInfo() {
      return serverInfo;
   }

   public void enableNotificationHandler() {
      hasNotificationHandler = false;
      if (notificationURL != null) {
         nspApi.setNotificationHandler(domain, notificationURL.toExternalForm());
         logger.infof("domain(%s), setNotificationHandler to %s\n", domain, notificationURL);
         hasNotificationHandler = true;
      } else {
         logger.warn("No binding for java:global/NotificationCallbackURL found");
      }
   }

   public String setEndpointResource(Endpoint endpoint, EndpointResource resource, String value) {
      logger.infof("domain(%s), setResource(%s:%s) to %s\n", domain, endpoint.getName(), resource.getUri(), value);
      String ok = NSPClient.setEndpointResourceValue(domain, endpoint.getName(), resource.getUri(), value);
      logger.infof("setEndpointResource returned %s\n", ok);
      return ok;
   }

   public String getNotificationHandler() {
      String handler = null;
      try {
         handler = nspApi.getNotificationHandler("domain");
         System.out.printf("handler: %s\n", handler);
      } catch (NotFoundException e) {
         System.out.printf("No handler registered\n");
      }
      return handler;
   }
}
