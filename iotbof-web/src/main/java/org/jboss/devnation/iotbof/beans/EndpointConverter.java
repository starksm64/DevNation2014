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
import org.jboss.devnation.iotbof.rest.Endpoint;
import org.jboss.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@FacesConverter("EndpointConverter")
public class EndpointConverter implements Converter {
   private static Logger logger = Logger.getLogger(EndpointConverter.class);
   // @EJB does not work!!
   private static NSPConnector nspConnector;

   /**
    * Used to populate the NSPConnector since injection does not work
    * @param connector
    */
   static void setConnector(NSPConnector connector) {
      EndpointConverter.nspConnector = connector;
   }
   static NSPConnector getConnector() {
      return nspConnector;
   }

   public EndpointConverter() {
      logger.infof("EndpointConverter.ctor, %s\n", this);
   }

   @Override
   public Object getAsObject(FacesContext context, UIComponent component, String value) {
      logger.infof("getAsObject, value=%s\n", value);
      Endpoint ep = nspConnector.getEndpoint(value);
      if(ep == null) {
         FacesMessage fm = new FacesMessage();
         fm.setDetail("Failed to lookup Endpoint for: " + value);
         fm.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ConverterException(fm);
      }
      return new EndpointView(ep);
   }

   @Override
   public String getAsString(FacesContext context, UIComponent component, Object value) {
      logger.infof("getAsString, value=%s\n", value);
      if(value == null)
         return null;

      EndpointView ep = EndpointView.class.cast(value);
      return ep.getEndpoint().getName();
   }
}
