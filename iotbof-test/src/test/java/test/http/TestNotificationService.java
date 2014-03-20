package test.http;
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

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class TestNotificationService {

   @Test
   public void testSendPing() {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target("http://localhost:8081/iotbof-web/events/send");
      Entity<String> msg = Entity.entity("Hello", MediaType.TEXT_PLAIN_TYPE);
      Response response = target.request().put(msg);
      MultivaluedMap<String, String> headers = response.getStringHeaders();
      System.out.printf("Status: %s\n", response.getStatusInfo());
      System.out.printf("ResponseHeaders: %s\n", headers.values());
   }

   @Test
   public void testSendJsonEvent() {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target("http://localhost:8081/iotbof-web/events/send");
      Entity<String> msg = Entity.entity("{\"reg-updates\":[{\"ep\":\"lwm2m-example-2\"}]}", MediaType.APPLICATION_JSON_TYPE);
      Response response = target.request().put(msg);
      MultivaluedMap<String, String> headers = response.getStringHeaders();
      System.out.printf("Status: %s\n", response.getStatusInfo());
      System.out.printf("ResponseHeaders: %s\n", headers.values());
   }
   @Test
   public void testSendJsonEvent2() {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target("http://localhost:8081/iotbof-web/events/send");
      Entity<String> msg = Entity.entity("{\"notifications\":[{\"ep\":\"lwm2m-example-2\",\"path\":\"/4/0/2\",\"payload\":\"LTk0\"},{\"ep\":\"lwm2m-example-2\",\"path\":\"/3/0/7\",\"payload\":\"MzMy\"}],\"reg-updates\":[{\"ep\":\"lwm2m-example-1\"}]}", MediaType.APPLICATION_JSON_TYPE);
      Response response = target.request().put(msg);
      MultivaluedMap<String, String> headers = response.getStringHeaders();
      System.out.printf("Status: %s\n", response.getStatusInfo());
      System.out.printf("ResponseHeaders: %s\n", headers.values());
   }
}
