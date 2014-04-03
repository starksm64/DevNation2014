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

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * The REST interface model into the ARM NanoService bridge
 *
 * @author Scott stark (sstark@redhat.com) (C) 2011 Red Hat Inc.
 * @version $Revision:$
 */
public interface INSP {

   /**
    * Query the NSP server for its version information
    * @return a server version string
    */
   @GET
   @Path("/")
   @Produces("text/plain")
   public String getServerInfo();

   @GET
   @Path("/{domain}/endpoints")
   @Produces("application/json")
   public List<Endpoint> queryEndpoints(@PathParam("domain") String domain,
                                @DefaultValue("true") @QueryParam("stale") boolean stale);
   @GET
   @Path("/{domain}/endpoints")
   @Produces("application/json")
   public String queryEndpointsByType(@PathParam("domain") String domain,
                                @QueryParam("type") String endptType,
                                @DefaultValue("true") @QueryParam("stale") boolean stale);

   @GET
   @Path("/{domain}/endpoints/{endpoint}")
   @Produces("application/json")
   public List<EndpointResource> queryEndpointResources(@PathParam("domain") String domain, @PathParam("endpoint") String endpoint);

   /**
    * Obtain the value of an endpoint resource
    *
    * @param domain - the domain name
    * @param endpoint - the endpoint name
    * @param resourcePath - the relative path of the resource to access the value of
    * @param sync - indicate whether this request is synchronous or asynchronous
    * @param cacheOnly - if true then response will come only from cache
    * @return the resource value as a string
    */
   @GET
   @Path("/{domain}/endpoints/{endpoint}{resourcePath}")
   @Produces("application/json")
   public String queryEndpointResourceValue(@PathParam("domain") String domain,
                                       @PathParam("endpoint") String endpoint,
                                       @PathParam("resourcePath") String resourcePath,
                                       @DefaultValue("false") @QueryParam("sync") boolean sync,
                                       @DefaultValue("false") @QueryParam("cacheOnly") boolean cacheOnly);

   @PUT
   @Path("/{domain}/subscriptions/{endpoint}{resourcePath}")
   @Produces("application/json")
   public String subscribeEndpointResource(@PathParam("domain") String domain,
                                       @PathParam("endpoint") String endpoint,
                                       @PathParam("resourcePath") String resourcePath);

   @PUT
   @Path("/{domain}/notification/push-url")
   @Consumes("text/plain")
   public String setNotificationHandler(@PathParam("domain") String domain, String pushURL);

   @GET
   @Path("{domain}/notification/push-url")
   @Produces("text/plain")
   public String getNotificationHandler(@PathParam("domain") String domain);

}
