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
package test.nsp;

import org.jboss.devnation.iotbof.rest.Endpoint;
import org.jboss.devnation.iotbof.rest.EndpointResource;
import org.jboss.devnation.iotbof.rest.INSP;
import org.jboss.devnation.iotbof.rest.NSPClient;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class TestINSP {
   private static INSP nspApi;

   @BeforeClass
   public static void classInit() {
      NSPClient.setBasicAuthentication("admin", "secret");
      nspApi = NSPClient.buildINSPProxy();
   }

   @Test
   public void queryServerInfo() {
      String serverInfo = nspApi.getServerInfo();
      System.out.printf("ServerInfo: %s\n", serverInfo);
   }

   @Test
   public void queryNSP() throws Exception {
      List<Endpoint> endpoints = nspApi.queryEndpoints("domain", true);
      System.out.printf("Endpoints: %s\n", endpoints);
   }

   @Test
   public void queryNSPResources() throws Exception {
      List<Endpoint> endpoints = nspApi.queryEndpoints("domain", true);
      System.out.printf("Endpoints: %s\n", endpoints);
      for(Endpoint ep : endpoints) {
         List<EndpointResource> epres = nspApi.queryEndpointResources("domain", ep.getName());
         System.out.printf("%s\n\t%s\n", ep.getName(), epres);
      }
   }

   @Test
   public void queryEndpointResourceValues() throws Exception {
      List<Endpoint> endpoints = nspApi.queryEndpoints("domain", true);
      System.out.printf("Endpoints: %s\n", endpoints);
      for(Endpoint ep : endpoints) {
         String epName = ep.getName();
         List<EndpointResource> epres = nspApi.queryEndpointResources("domain", epName);
         System.out.printf("%s Resource Values:\n", epName);
         for(EndpointResource er : epres) {
            // Fails with NotFoundException due to URL encoding of uri
            try {
               nspApi.queryEndpointResourceValue("domain", epName, er.getUri(), false, false);
               System.out.printf("\t%s\n", epName, epres);
            } catch (NotFoundException e) {

            }
         }
      }
   }

   @Test
   public void getNotificationHandler() {
      try {
         String handler = nspApi.getNotificationHandler("domain");
         System.out.printf("handler: %s\n", handler);
      } catch (NotFoundException e) {
         System.out.printf("No handler registered\n");
      }
   }
}
