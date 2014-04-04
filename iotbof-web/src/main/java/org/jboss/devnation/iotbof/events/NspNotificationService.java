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


import org.jboss.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Path("/events")
public class NspNotificationService implements INotificationService {
   private static final Logger logger = Logger.getLogger(NspNotificationService.class);
   private static ConcurrentHashMap<String, NspAsyncResponse> asyncResponseMap = new ConcurrentHashMap<>();

   @Inject
   Event<NspNotificationMsg> notificationMsgEvent;
   @Inject
   Event<NspAsyncResponse> asyncResponseEvent;

   public NspNotificationService() {
      logger.infof("NspNotificationService.ctor, %s\n", this);
   }

   @Override
   public Collection<NspAsyncResponse> getAllAsyncResponses() {
      Collection<NspAsyncResponse> all = asyncResponseMap.values();
      logger.infof("getAllAsyncResponses count=%d\n", all.size());
      return all;
   }

   @Override
   public NspAsyncResponse getAsyncResponse(String id) {
      NspAsyncResponse response = asyncResponseMap.get(id);
      logger.infof("getAsyncResponse(%s): %s\n", id, response);
      return response;
   }

   @PUT
   @Path("/send")
   @Consumes("application/json")
   public Response handleNotification(NspNotificationMsg msg) {
      logger.infof("handleNotification: %s\n", msg);
      notificationMsgEvent.fire(msg);
      Response response = Response.ok("{}", MediaType.APPLICATION_JSON_TYPE).build();
      List<NspAsyncResponse> asyncResponses = msg.getAsyncResponses();
      if(asyncResponses != null && asyncResponses.size() > 0) {
         for (NspAsyncResponse ar : asyncResponses) {
            asyncResponseMap.put(ar.getId(), ar);
            logger.infof("Added AsyncResponse: %s, count=%d", ar.getId(), asyncResponseMap.size());
            asyncResponseEvent.fire(ar);
         }
      }
      return response;
   }

   @PUT
   @Path("/send")
   @Consumes("text/*")
   public Response handlePing(String msg) {
	  System.out.printf("handlePing: msg=%s\n", msg);
      Response response = Response.ok("OK", MediaType.TEXT_PLAIN_TYPE).build();
      System.out.printf("Response.headers: %s\n", response.getHeaders());
      return response;
   }

   @GET
   @Path("{info:.*}")
   @Consumes("text/*")
   public Response handleUnknown(@PathParam("info") String info) {
	  System.out.printf("handleUnknown: info=%s\n", info);
      Response response = Response.ok("OK", MediaType.TEXT_PLAIN_TYPE).build();
      System.out.printf("Response.headers: %s\n", response.getHeaders());
      return response;
   }


}
