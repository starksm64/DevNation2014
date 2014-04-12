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


import org.jboss.devnation.iotbof.ejbs.NSPConnector;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The REST callback handler that processes the push notifications from the NSP server
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Path("/events")
public class NspNotificationService implements INotificationService {
   private static final Logger logger = Logger.getLogger(NspNotificationService.class);
   private static ConcurrentHashMap<String, NspAsyncResponse> asyncResponseMap = new ConcurrentHashMap<>();
   private static AtomicInteger counter = new AtomicInteger(0);

   @EJB
   NSPConnector nspConnector;
   @Inject
   Event<NspNotification> notificationMsgEvent;
   @Inject
   Event<NspAsyncResponse> asyncResponseEvent;
   @Inject
   Event<NspRegistration> registrationEvent;

   public NspNotificationService() {

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
      int count = counter.incrementAndGet();
      logger.infof("Begin handleNotification(%d): %s\n", count, msg);

      List<NspNotification> notifications = msg.getNotifications();
      Date receivedTime = new Date();
      processNotification(notifications, receivedTime);
      Response response = Response.ok().build();
      List<NspAsyncResponse> asyncResponses = msg.getAsyncResponses();
      processAsync(asyncResponses, receivedTime);
      List<NspRegistration> registrations = msg.getRegistrations();
      processRegistrations(registrations, receivedTime);
      List<NspRegistrationUpdate> registrationUpdates = msg.getRegistrationUpdates();
      logger.infof("End handleNotification(%d)\n", count);
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


   private void processNotification(List<NspNotification> notifications, Date receivedTime) {
      if(notifications == null || notifications.size() == 0)
         return;

      logger.infof("Sending %d NspNotifications\n", notifications.size());
      for(NspNotification notify : notifications) {
         notify.setReceiveTime(receivedTime);
         notificationMsgEvent.fire(notify);
      }
   }
   private void processAsync(List<NspAsyncResponse> asyncResponses, Date receivedTime) {
      if(asyncResponses == null || asyncResponses.size() == 0)
         return;

      logger.infof("Sending %d NspAsyncResponse\n", asyncResponses.size());
      for (NspAsyncResponse ar : asyncResponses) {
         ar.setReceiveTime(receivedTime);
         asyncResponseMap.put(ar.getId(), ar);
         logger.infof("Added AsyncResponse: %s, count=%d", ar.getId(), asyncResponseMap.size());
         asyncResponseEvent.fire(ar);
      }
   }
   private void processRegistrations(List<NspRegistration> registrations, Date receivedTime) {
      if(registrations == null || registrations.size() == 0)
         return;

      for(NspRegistration reg : registrations) {
         String endpoint = reg.getEp();
         List<NspResource> resources = reg.getResources();
         List<String> observableResources = new ArrayList<>();
         for(NspResource res : resources) {
            if(res.isObservable())
               observableResources.add(res.getPath());
         }
         nspConnector.updateRegistrations(endpoint, observableResources);
      }
   }
}
