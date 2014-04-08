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

import org.jboss.devnation.iotbof.events.AsyncID.IDParts;
import org.jboss.devnation.iotbof.rest.EndpointResourceType;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class NspAsyncResponse {
   // A string like '{"async-response-id":"54696#mbed-ethernet-1DE41@domain/3/0/2"}'
   private String id;
   private AsyncID asyncID;
   private String status;
   private String error;
   private String ct;
   private String maxAge;
   private String payload;

   /**
    *
    * @return
    */
   public String[] getIdParts() {
      return asyncID.getIdParts();
   }

   /**
    * Decode the base64 encoded payload
    * @see DatatypeConverter#parseBase64Binary(String)
    * @return
    */
   public String decodePayload() {
      if(payload != null) {
         byte[] frombase64 = DatatypeConverter.parseBase64Binary(payload);
         return new String(frombase64);
      }
      return null;
   }

   public String getPayload() {
      return payload;
   }

   public void setPayload(String payload) {
      this.payload = payload;
   }

   public String getId() {
      return id;
   }
   public String getEndpoint() {
      return getIdParts()[IDParts.EndpointName.ordinal()];
   }
   public String getUri() {
      return getIdParts()[IDParts.URI.ordinal()];
   }
   public EndpointResourceType getResourceType() {
      return new EndpointResourceType(getUri());
   }

   public void setId(String id) {
      this.id = id;
      asyncID = new AsyncID(id);
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getError() {
      return error;
   }

   public void setError(String error) {
      this.error = error;
   }

   public String getCt() {
      return ct;
   }

   public void setCt(String ct) {
      this.ct = ct;
   }

   @XmlElement(name = "max-age")
   public String getMaxAge() {
      return maxAge;
   }

   public void setMaxAge(String maxAge) {
      this.maxAge = maxAge;
   }

   public String toString() {
      return String.format("async-id=%s, status=%s, payload=%s, maxAge=%s", id, status, payload, maxAge);
   }
}
