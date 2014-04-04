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

import org.jboss.devnation.iotbof.ejbs.NSPConnector;
import org.jboss.devnation.iotbof.events.INotificationService;
import org.jboss.devnation.iotbof.events.NspAsyncResponse;
import org.jboss.devnation.iotbof.rest.Endpoint;
import org.jboss.devnation.iotbof.rest.EndpointResource;
import org.jboss.logging.Logger;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * JSF managed bean wrapper for an Endpoint
 * @see org.jboss.devnation.iotbof.rest.Endpoint
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Named("endpointView")
@ViewScoped
public class EndpointView {
   private static Logger logger = Logger.getLogger(EndpointView.class);

   private static NSPConnector nspConnector;
   private static INotificationService notificationService;
   private Endpoint endpoint;

   static void setConnector(NSPConnector nspConnector) {
      EndpointView.nspConnector = nspConnector;
   }
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

   /**
    * Attempt to resolve any async values seen in the resources
    * @return list of EndpointResource
    */
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

   /**
    * The commandLink action target that a
    * @return
    */
   public String action() {
      String action = "asyncresponse";
      FacesContext context = FacesContext.getCurrentInstance();
      ExternalContext externalContext = context.getExternalContext();
      Map<String, String> parameterMap = externalContext.getRequestParameterMap();
      String asyncID = parameterMap.get("asyncID");
      String resURI = parameterMap.get("resURI");
      //
      logger.infof("Trying to resolve async response for: %s", asyncID);
      NspAsyncResponse asyncResponse = notificationService.getAsyncResponse(asyncID);
      if(asyncResponse == null) {
         //
         logger.infof("Failed, requesting resource value...\n");
         String value = nspConnector.queryEndpointResourceValue(endpoint.getName(), resURI, true, false);
         EndpointResource resource = endpoint.getResource(resURI);
         resource.setResolvedValue(value);
         // ? Need a different action?
         action = "asyncresponse";
      }
      return action;
   }

   public String toString() {
      return endpoint.toString();
   }
}
