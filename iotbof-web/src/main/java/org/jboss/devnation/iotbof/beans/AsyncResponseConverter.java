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

import org.jboss.devnation.iotbof.events.INotificationService;
import org.jboss.devnation.iotbof.events.NspAsyncResponse;
import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import static org.jboss.devnation.iotbof.events.NspAsyncResponse.IDParts.EndpointName;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@FacesConverter("AsyncResponseConverter")
public class AsyncResponseConverter implements Converter {
   private static Logger logger = Logger.getLogger(AsyncResponseConverter.class);
   private static INotificationService notificationService;

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
      String id = extractID(value);

      logger.infof("getAsObject, value=%s, id=%s\n", value, id);
      NspAsyncResponse response = notificationService.getAsyncResponse(id);
      if(response == null) {
         FacesMessage fm = new FacesMessage();
         fm.setDetail("Failed to lookup AsyncResponse for: " + value);
         fm.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ConverterException(fm);
      }
      // Extract the endpoint name from the response id
      String[] idparts = response.getIdParts();
      if(idparts == null) {
         FacesMessage fm = new FacesMessage();
         fm.setDetail("Unable to parse async-response-id into (\\d+)#([^@]+)@.*: " + value);
         fm.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ConverterException(fm);
      }
      String endpointName = idparts[EndpointName.ordinal()];
      return new AsyncResponseView(endpointName, response);
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      logger.infof("getAsString, value=%s\n", value);
      if(value == null)
         return null;

      AsyncResponseView view = AsyncResponseView.class.cast(value);
      return view.getResponse().getId();
   }
}
