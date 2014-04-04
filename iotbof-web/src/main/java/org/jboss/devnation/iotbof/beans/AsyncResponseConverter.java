package org.jboss.devnation.iotbof.beans;/*
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
import org.jboss.devnation.iotbof.events.AsyncID;
import org.jboss.devnation.iotbof.events.INotificationService;
import org.jboss.devnation.iotbof.events.NspAsyncResponse;
import org.jboss.devnation.iotbof.rest.Endpoint;
import org.jboss.devnation.iotbof.rest.EndpointResource;
import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.util.Map;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@FacesConverter("AsyncResponseConverter")
public class AsyncResponseConverter implements Converter {
   private static Logger logger = Logger.getLogger(AsyncResponseConverter.class);
   private static NSPConnector nspConnector;
   private static INotificationService notificationService;

   static void setConnector(NSPConnector nspConnector) {
      AsyncResponseConverter.nspConnector = nspConnector;
   }
   static void setNotificationService(INotificationService service) {
      AsyncResponseConverter.notificationService = service;
   }

   /**
    * Extract the id portion {"async-response-id":"54696#mbed-ethernet-1DE41@domain/3/0/2"}
    * @param value
    * @return
    */
   static String extractID(String value) {
      String[] parts = value.split("\"");
      String id = parts[3];
      return id;
   }

   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
      ExternalContext externalContext = context.getExternalContext();
      Map<String, String> parameterMap = externalContext.getRequestParameterMap();
      String resolveParam = parameterMap.get("resolve");
      boolean resolve = true;
      if(resolveParam != null)
         resolve = Boolean.valueOf(resolveParam);
      String id = extractID(value);
      AsyncID asyncID = new AsyncID(id);
      logger.infof("getAsObject, value=%s, asyncID=%s\n", value, asyncID);
      NspAsyncResponse response = notificationService.getAsyncResponse(id);
      String endpointName = asyncID.getEndpointName();
      AsyncResponseView responseView;
      if(response == null && resolve) {
         logger.infof("Failed, requesting resource value...\n");
         String resURI = asyncID.getURI();
         Endpoint endpoint = nspConnector.getEndpoint(endpointName);
         String rvalue = nspConnector.queryEndpointResourceValue(endpointName, resURI, true, false);
         EndpointResource resource = endpoint.getResource(resURI);
         resource.setResolvedValue(rvalue);
         responseView = new AsyncResponseView(asyncID, resource);
      } else if(response == null) {
         FacesMessage msg = new FacesMessage(String.format("Failed to load resource value, %s", asyncID));
         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
         context.addMessage(null, msg);
         throw new ConverterException(msg);
      } else {
         responseView = new AsyncResponseView(asyncID, response);
      }
      return responseView;
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      logger.infof("getAsString, value=%s\n", value);
      if(value == null)
         return null;

      AsyncResponseView view = AsyncResponseView.class.cast(value);
      return view.getAsyncID().getId();
   }
}
