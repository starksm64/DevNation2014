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
import java.util.List;

/**
 * A singleton ejb that initializes the connections to the NSP and provides
 * information about the devices connected to the NSP
 */
@Singleton
@Startup
public class NSPConnector {
   private static final Logger logger = Logger.getLogger(NSPConnector.class);

   @Resource(name = "java:global/NSPDomain")
   private String domain = "domain";
   @Inject
   private INSP nspApi;

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
      // Step 2, query the server for the available endpoints
      reload();
   }

   @PreDestroy
   public void preDestroy() {

   }

   public void reload() {
      List<Endpoint> endpoints = nspApi.queryEndpoints(domain, false);
      int count = 0;
      if (endpoints != null) {
         count = endpoints.size();
         logger.infof("Found %d endpoints\n", count);
         for (Endpoint ep : endpoints) {
            List<EndpointResource> ers = nspApi.queryEndpointResources(domain, ep.getName());
            String name = ep.getName();
            for (EndpointResource er : ers) {
               String value = NSPClient.queryEndpointResourceValue(domain, name, er.getUri(), false, false);
               logger.infof("%s(%s)=%s\n", name, er.getUri(), value);
               // Step 3, register for updates
               if (er.getObs().equalsIgnoreCase("true")) {
                  logger.infof("Would request updates for: %s(%s)", name, er.getUri());
               }
            }
         }
      }
   }

   public String getServerInfo() {
      return nspApi.getServerInfo();
   }
}
