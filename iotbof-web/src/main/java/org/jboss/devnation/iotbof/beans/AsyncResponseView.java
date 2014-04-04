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

import org.jboss.devnation.iotbof.events.AsyncID;
import org.jboss.devnation.iotbof.events.NspAsyncResponse;
import org.jboss.devnation.iotbof.rest.EndpointResource;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Named
@ViewScoped
public class AsyncResponseView {
   private AsyncID asyncID;
   /** Set if the response is found */
   private NspAsyncResponse response;
   /** Set if the response is not found and resource value was reloaded */
   private EndpointResource resource;

   public AsyncResponseView() {
   }
   public AsyncResponseView(AsyncID asyncID, EndpointResource resource) {
      this.asyncID = asyncID;
      this.resource = resource;
   }
   public AsyncResponseView(AsyncID asyncID, NspAsyncResponse response) {
      this.asyncID = asyncID;
      this.response = response;
   }

   public AsyncID getAsyncID() {
      return asyncID;
   }

   public void setAsyncID(AsyncID asyncID) {
      this.asyncID = asyncID;
   }

   public NspAsyncResponse getResponse() {
      return response;
   }

   public void setResponse(NspAsyncResponse response) {
      this.response = response;
   }

   public EndpointResource getResource() {
      return resource;
   }

   public void setResource(EndpointResource resource) {
      this.resource = resource;
   }
}
