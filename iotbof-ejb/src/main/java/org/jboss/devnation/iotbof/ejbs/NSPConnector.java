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
import javax.ejb.TimedObject;
import javax.ejb.Timer;
import javax.inject.Inject;
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
public class NSPConnector implements TimedObject {
   private static final Logger logger = Logger.getLogger(NSPConnector.class);
   private ConcurrentHashMap<String, Endpoint> endpoints = new ConcurrentHashMap<>();

   /**
    * The NSP domain name used when communicating with the server
    *
    */
   @Resource(name = "java:global/NSPDomain")
   private String domain = "domain";
   @Resource(name = "java:global/NotificationCallbackURL")
   private URL notificationURL;

   /**
    * The NSP communication interface
    * @see org.jboss.devnation.iotbof.weld.WeldProducerMethods#getNSPImplementation()
    */
   @Inject
   private INSP nspApi;
   private boolean hasNotificationHandler;

   /**
    * Default constructor.
    */
   public NSPConnector() {
   }

   @PostConstruct
   public void postConstruct() {
      // Validate the domain
      if (domain == null)
         throw new IllegalStateException("The domain field is null");

      // Step 1, query the server to validate connection configuration
      String serverInfo = nspApi.getServerInfo();
      logger.infof("Connected to NSP server %s\n", serverInfo);
   }

   @PreDestroy
   public void preDestroy() {

   }

   public Set<String> getEndpointNames() {
      return endpoints.keySet();
   }

   public List<Endpoint> getEndpoints() {
      return new ArrayList<>(endpoints.values());
   }

   public Endpoint getEndpoint(String name) {
      return endpoints.get(name);
   }

   public void reload(IProgress progress) {
      List<Endpoint> eps = nspApi.queryEndpoints(domain, false);
      int count;
      endpoints.clear();
      if (eps != null) {
         count = eps.size();
         logger.infof("Found %d endpoints\n", count);
         for (int n = 0; n < count; n ++) {
            Endpoint ep = eps.get(n);
            String name = ep.getName();
            progress.updateProgress(n, count, "Loading: "+name);
            logger.infof("Loading %s endpoint\n", name);
            endpoints.put(name, ep);
            List<EndpointResource> ers = nspApi.queryEndpointResources(domain, name);
            for (EndpointResource er : ers) {
               logger.infof("Loading %s%s resource\n", name, er.getUri());
               String value = NSPClient.queryEndpointResourceValue(domain, name, er.getUri(), false, false);
               logger.infof("%s(%s)=%s\n", name, er.getUri(), value);
               er.setValue(value);
               // Step 3, register for updates
               if (er.getObs().equalsIgnoreCase("true") && hasNotificationHandler) {
                  nspApi.subscribeEndpointResource(domain, name, er.getUri());
                  logger.infof("Requested updates for: %s(%s)", name, er.getUri());
               }
            }
            ep.setResources(ers);
         }
         progress.updateProgress(count, count, "Completed loading");
      }
   }

   public String getServerInfo() {
      return nspApi.getServerInfo();
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

   @Override
   public void ejbTimeout(Timer timer) {
      logger.infof("ejbTimeout, info=%s\n", timer.getInfo());

   }
}
