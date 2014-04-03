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
import org.jboss.devnation.iotbof.rest.EndpointResource;
import org.jboss.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@ManagedBean
@ViewScoped
public class EndpointResourceView implements Serializable {
   private static final Logger logger = Logger.getLogger(EndpointResourceView.class);
   private static final long serialVersionUID = 1;

   private String resourceURI;
   private String endpointName;
   private transient Endpoint endpoint;
   private transient EndpointResource resource;
   private String editValue;
   @EJB
   private NSPConnector nspConnector;

   public EndpointResourceView() {
   }

   public void init() {
      System.out.printf("Restoring endpoint(%s)...\n", this, endpointName);
      endpoint = nspConnector.getEndpoint(endpointName);
      if(endpoint == null) {
         FacesMessage fm = new FacesMessage();
         fm.setDetail("Failed to lookup Endpoint for: " + endpointName);
         fm.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ConverterException(fm);
      }
      resource = endpoint.getResource(resourceURI);
      editValue = resource.getValue();
   }

   public String getResourceURI() {
      return resourceURI;
   }

   public void setResourceURI(String resourceURI) {
      this.resourceURI = resourceURI;
   }

   public String getEndpointName() {
      return endpointName;
   }

   public void setEndpointName(String endpointName) {
      this.endpointName = endpointName;
   }

   public Endpoint getEndpoint() {
      return endpoint;
   }

   public EndpointResource getResource() {
      return resource;
   }

   public String getResourceName() {
      return String.format("%s/%s", resource.getFullType().getObjectName(), resource.getFullType().getResourceName());
   }

   public String getEditValue() {
      logger.infof("getEditValue()=%s\n", editValue);
      return editValue;
   }

   public void setEditValue(String editValue) {
      logger.infof("setEditValue(%s)\n", editValue);
      this.editValue = editValue;
   }

   public void save(ActionEvent event) {
      String ok = nspConnector.setEndpointResource(endpoint, resource, editValue);
      resource.setValue(editValue);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Saved value, msg=" + ok));
   }
}
