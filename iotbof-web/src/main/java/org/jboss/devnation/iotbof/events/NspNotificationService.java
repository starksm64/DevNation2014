package org.jboss.devnation.iotbof.events;
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


import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Path("/events")
public class NspNotificationService {
   @PUT
   @Path("/send")
   @Consumes("application/json")
   public Response handleNotification(NspNotificationMsg msg) {
	  System.out.printf("handleNotification: %s\n", msg);
      return Response.status(200).build();
   }

   @PUT
   @Path("/send")
   @Consumes("text/*")
   public Response handlePing(String msg) {
	  System.out.printf("handlePing: %s\n", msg);
      return Response.status(200).build();
   }
}
