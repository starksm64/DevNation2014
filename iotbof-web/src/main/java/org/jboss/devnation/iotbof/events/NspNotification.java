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

import org.jboss.devnation.iotbof.rest.EndpointResourceType;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class NspNotification {
   private String ep;
   private String dm;
   private String path;
   private String ct;
   private Date receiveTime;

   /**
    * base64-encoded-payload
    */
   private String payload;
   private String timestamp;
   private String maxAge;

   public String getEp() {
      return ep;
   }

   public void setEp(String ep) {
      this.ep = ep;
   }

   public String getDm() {
      return dm;
   }

   public void setDm(String dm) {
      this.dm = dm;
   }

   public String getPath() {
      return path;
   }

   public void setPath(String path) {
      this.path = path;
   }

   public String getCt() {
      return ct;
   }

   public void setCt(String ct) {
      this.ct = ct;
   }

   public String getPayload() {
      return payload;
   }

   public void setPayload(String payload) {
      this.payload = payload;
   }

   public Date getReceiveTime() {
      return receiveTime;
   }

   public void setReceiveTime(Date receiveTime) {
      this.receiveTime = receiveTime;
   }

   /**
    * Decode the base64 encoded payload
    *
    * @return
    * @see javax.xml.bind.DatatypeConverter#parseBase64Binary(String)
    */
   public String decodePayload() {
      if (payload != null) {
         byte[] frombase64 = DatatypeConverter.parseBase64Binary(payload);
         return new String(frombase64);
      }
      return null;
   }

   public String getTimestamp() {
      return timestamp;
   }

   public void setTimestamp(String timestamp) {
      this.timestamp = timestamp;
   }

   public EndpointResourceType getResourceType() {
      return new EndpointResourceType(getPath());
   }

   @XmlElement(name = "max-age")
   public String getMaxAge() {
      return maxAge;
   }

   public void setMaxAge(String maxAge) {
      this.maxAge = maxAge;
   }

   @Override
   public String toString() {
      return "NspNotification [ep=" + ep + ", dm=" + dm + ", path=" + path
         + ", ct=" + ct + ", payload=" + payload + ", timestamp="
         + timestamp + ", maxAge=" + maxAge + "]";
   }


}
