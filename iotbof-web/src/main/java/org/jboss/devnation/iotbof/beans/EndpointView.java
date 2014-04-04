package org.jboss.devnation.iotbof.beans;
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

import org.jboss.devnation.iotbof.events.INotificationService;
import org.jboss.devnation.iotbof.events.NspAsyncResponse;
import org.jboss.devnation.iotbof.rest.Endpoint;
import org.jboss.devnation.iotbof.rest.EndpointResource;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Named("endpointView")
@ViewScoped
public class EndpointView {
   private static INotificationService notificationService;
   private Endpoint endpoint;

   static void setNotificationService(INotificationService notificationService) {
      EndpointView.notificationService = notificationService;
   }

   public EndpointView() {
   }
   public EndpointView(Endpoint endpoint) {
      this.endpoint = endpoint;
   }

   public Endpoint getEndpoint() {
      return endpoint;
   }

   public void setEndpoint(Endpoint endpoint) {
      this.endpoint = endpoint;
   }

   public List<EndpointResource> getResources() {
      List<EndpointResource> resources = endpoint.getResources();
      // Try to resolve any async response values
      if(notificationService != null) {
         for (EndpointResource resource : resources) {
            if(resource.hasAsyncValue()) {
               String asyncID = resource.getValue();
               String id = AsyncResponseConverter.extractID(asyncID);
               NspAsyncResponse asyncResponse = notificationService.getAsyncResponse(id);
               if(asyncResponse != null) {
                  resource.setResolvedValue(asyncResponse.decodePayload());
               }
            }
         }
      }
      return resources;
   }

   public String toString() {
      return endpoint.toString();
   }
}
