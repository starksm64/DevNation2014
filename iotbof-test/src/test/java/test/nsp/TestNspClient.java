package test.nsp;

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
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class TestNspClient {
   @Test
   public void testRegisterNotificationHandler() {
      NSPClient.setBasicAuthentication("admin", "secret");
      Invocation invocation = NSPClient.registerNotificationHandler("domain", "http://127.0.0.1:9091/jbiotevents");
      Response response = invocation.invoke();
      System.out.printf("testRegisterNotificationHandler, %s\n", response.getStatusInfo());
   }

   @Test
   public void queryEndpointResourceValues() throws Exception {
      NSPClient.setBasicAuthentication("admin", "secret");
      INSP nspApi = NSPClient.buildINSPProxy();
      List<Endpoint> endpoints = nspApi.queryEndpoints("domain", true);
      System.out.printf("Endpoints: %s\n", endpoints);
      for(Endpoint ep : endpoints) {
         String epName = ep.getName();
         List<EndpointResource> epres = nspApi.queryEndpointResources("domain", epName);
         System.out.printf("%s Resource Values:\n", epName);
         for(EndpointResource er : epres) {
            String value = NSPClient.queryEndpointResourceValue("domain", epName, er.getUri(), false, false);
            System.out.printf("\t%s\n", value);
         }
      }
   }

}
