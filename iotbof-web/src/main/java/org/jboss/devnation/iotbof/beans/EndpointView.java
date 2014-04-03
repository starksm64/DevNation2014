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

import org.jboss.devnation.iotbof.rest.Endpoint;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Named("endpointView")
@ViewScoped
public class EndpointView {
   private Endpoint endpoint;

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

   public String toString() {
      return endpoint.toString();
   }
}
