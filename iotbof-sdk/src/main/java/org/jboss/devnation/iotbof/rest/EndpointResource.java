package org.jboss.devnation.iotbof.rest;

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

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class EndpointResource {
   private String uri;
   private String rt;
   private String iface;
   private String obs;
   private String type;
   private String value;
   private String resolvedValue;
   private EndpointResourceType fullType;

   public String getUri() {
      return uri;
   }

   public void setUri(String uri) {
      this.uri = uri;
      this.fullType = new EndpointResourceType(uri);
   }

   public String getRt() {
      return rt;
   }

   public void setRt(String rt) {
      this.rt = rt;
   }

   @XmlElement(name = "if")
   public String getIface() {
      return iface;
   }

   public void setIface(String iface) {
      this.iface = iface;
   }

   public String getObs() {
      return obs;
   }

   public void setObs(String obs) {
      this.obs = obs;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getValue() {
      return value;
   }

   public void setValue(String value) {
      this.value = value;
      if(hasAsyncValue() == false)
         resolvedValue = value;
   }

   public String getResolvedValue() {
      return resolvedValue;
   }

   public void setResolvedValue(String resolvedValue) {
      this.resolvedValue = resolvedValue;
   }

   public EndpointResourceType getFullType() {
      return fullType;
   }

   public boolean hasAsyncValue() {
      boolean hasAsyncValue = false;
      if(value != null) {
         hasAsyncValue = value.contains("async-response-id");
      }
      return hasAsyncValue;
   }

   @Override
   public String toString() {
      return "EndpointResource{" +
         "uri='" + uri + '\'' +
         ", rt='" + rt + '\'' +
         ", if='" + iface + '\'' +
         ", obs='" + obs + '\'' +
         ", type='" + type + '\'' +
         ", value='" + value + '\'' +
         ", resolvedValue='" + resolvedValue + '\'' +
         '}';
   }
}
