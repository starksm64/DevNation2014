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

import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class Endpoint {
   private String name;
   private String type;
   private String status;
   private List<EndpointResource> resources;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public List<EndpointResource> getResources() {
      return resources;
   }
   public void setResources(List<EndpointResource> resources) {
      this.resources = resources;
   }

   @Override
   public String toString() {
      int count = resources != null ? resources.size() : 0;
      return String.format("Endpoint{name=%s,type=%s,status=%s,resCount=%d}", name, type, status, count);
   }

   public EndpointResource getResource(String resURI) {
      for(EndpointResource resource : resources) {
         if(resource.getUri().equals(resURI))
            return resource;
      }
      return null;
   }
}
