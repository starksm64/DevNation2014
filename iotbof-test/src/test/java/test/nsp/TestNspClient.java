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
import org.junit.Ignore;
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

   /**
    * Query a value that returns an async-response-id and try requerying with the sync=true flag.
    * This test is ignored as it relies on a fixed endpoint that does not exist in general.
    * @throws Exception
    */
   @Test
   @Ignore("relies on mbed-ethernet-1DE41 endpoint")
   public void queryEndpointResourceAsyncValue() throws Exception {
      System.out.printf("Testing for query of value with an async return\n");
      String name = "mbed-ethernet-1DE41";
      String dimmerURI = "/311/0/5851";
      NSPClient.setBasicAuthentication("admin", "secret");

      String dimmer = NSPClient.queryEndpointResourceValue("domain", name, dimmerURI, false, false);
      System.out.printf("Dimmer value:%s\n", dimmer);
      if(dimmer.contains("async-response-id")) {
         System.out.printf("Requerying with sync=true\n", dimmer);
         dimmer = NSPClient.queryEndpointResourceValue("domain", name, dimmerURI, true, false);
         System.out.printf("Dimmer value:%s\n", dimmer);
      }
   }

   @Test
   @Ignore("relies on mbed-ethernet-1DE41 endpoint")
   public void queryMbedTemperature() {
      NSPClient.setBasicAuthentication("admin", "secret");
      String temp = NSPClient.queryEndpointResourceValue("domain", "mbed-ethernet-1DE41", "/303/0/5700", false, false);
      System.out.printf("mbed-ethernet-1DE41 temp is: %s\n", temp);
   }
}
