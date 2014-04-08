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

import org.jboss.resteasy.client.jaxrs.BasicAuthentication;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class NSPClient {

   /**
    * The URL of the NSP rest interface
    */
   private static String BASEURL = "http://red-hat-summit.cloudapp.net:8080/";
   /**
    * The path relative to BASEURL for registering notification callbacks
    */
   private static final String NOTIFICATION_PUSH_URL = "/notification/push-url";
   /**
    * The authentication information to use
    */
   private static BasicAuthentication basicAuth;

   /**
    * A debugging filter
    */
   public static class ClientLoggingFilter
            implements ClientRequestFilter, ClientResponseFilter {
      @Override
      public void filter(ClientRequestContext requestContext) throws IOException {
         URI uri = requestContext.getUri();
         String method = requestContext.getMethod();
         System.out.printf("+++ Request(%s) to: %s\n--- Headers:\n", method, uri);
         MultivaluedMap<String, Object> headers = requestContext.getHeaders();
         for (String key : headers.keySet()) {
            System.out.printf("\t%s: %s\n", key, headers.getFirst(key));
         }
         System.out.printf("--- End Headers:\n");
         Object body = requestContext.getEntity();
         System.out.printf("%s\n--- End Body:\n", body);
      }

      @Override
      public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
         URI uri = requestContext.getUri();
         Response.StatusType status = responseContext.getStatusInfo();
         System.out.printf("+++ Response from: %s, status=%s\n--- Headers:\n", uri, status);
         MultivaluedMap<String, String> headers = responseContext.getHeaders();
         for (String key : headers.keySet()) {
            System.out.printf("\t%s: %s\n", key, headers.getFirst(key));
         }
         System.out.printf("--- End Headers:\n");
         /*
         InputStream is = responseContext.getEntityStream();
         InputStreamReader isr = new InputStreamReader(is);
         BufferedReader br = new BufferedReader(isr);
         String line = br.readLine();
         while( line != null ) {
            System.out.printf("%s\n", line);
            line = br.readLine();
         }
         */
      }
   }

   public static String getBaseURL() {
      return BASEURL;
   }
   public static void setBaseURL(String url) {
      BASEURL = url;
   }
   public static void setBasicAuthentication(String username, String password) {
      basicAuth = new BasicAuthentication(username, password);
   }

   public static Invocation registerNotificationHandler(@PathParam("domain") String domain, String callbackURL) {
      ResteasyClientBuilder rsb = new ResteasyClientBuilder();
      Client rsc = rsb.build();
      WebTarget target = rsc.target(BASEURL+"/"+domain+NOTIFICATION_PUSH_URL);
      if(basicAuth != null)
         target.register(basicAuth);
      target.register(new ClientLoggingFilter());
      Entity<String> callback = Entity.entity(callbackURL, MediaType.TEXT_PLAIN_TYPE);
      Invocation invocation = target.request().buildPut(callback);

      return invocation;
   }

   /**
    * Obtain the value of an endpoint resource. Duplicated from the INSP interface as the NSP server does not
    * like uri encoded path parameters
    *
    * @param domain - the domain name
    * @param endpoint - the endpoint name
    * @param resourcePath - the relative path of the resource to access the value of
    * @param sync -
    * @param cacheOnly -
    * @return
    */
   @Path("/{domain}/endpoints/{endpoint}{resourcePath}")
   public static String queryEndpointResourceValue(@PathParam("domain") String domain,
                                       @PathParam("endpoint") String endpoint,
                                       @PathParam("resourcePath") String resourcePath,
                                       @DefaultValue("false") @QueryParam("sync") boolean sync,
                                       @DefaultValue("false") @QueryParam("cacheOnly") boolean cacheOnly)
         throws InterruptedException, ExecutionException, TimeoutException {
      return queryEndpointResourceValue(domain, endpoint, resourcePath, sync, cacheOnly, 1, TimeUnit.MINUTES);
   }
   public static String queryEndpointResourceValue(@PathParam("domain") String domain,
                                       @PathParam("endpoint") String endpoint,
                                       @PathParam("resourcePath") String resourcePath,
                                       @DefaultValue("false") @QueryParam("sync") boolean sync,
                                       @DefaultValue("false") @QueryParam("cacheOnly") boolean cacheOnly,
                                       int timeout, TimeUnit unit)
         throws InterruptedException, ExecutionException, TimeoutException {

      ResteasyClientBuilder rsb = new ResteasyClientBuilder();
      Client rsc = rsb.build();
      WebTarget target = rsc.target(BASEURL+"/"+domain+"/endpoints/"+endpoint+resourcePath)
         .queryParam("sync", sync)
         .queryParam("cacheOnly", cacheOnly);

      if(basicAuth != null)
         target.register(basicAuth);
      target.register(new ClientLoggingFilter());
      Future<String> future = target.request().async().get(String.class);
      String value = future.get(timeout, unit);
      return value;
   }
   @Path("/{domain}/endpoints/{endpoint}{resourcePath}")
   public static String setEndpointResourceValue(@PathParam("domain") String domain,
                                 @PathParam("endpoint") String endpoint,
                                 @PathParam("resourcePath") String resourcePath, String value) {
      ResteasyClientBuilder rsb = new ResteasyClientBuilder();
      Client rsc = rsb.build();
      WebTarget target = rsc.target(BASEURL+"/"+domain+"/endpoints/"+endpoint+resourcePath);

      if(basicAuth != null)
         target.register(basicAuth);
      target.register(new ClientLoggingFilter());
      Entity<String> putValue = Entity.entity(value, MediaType.TEXT_PLAIN_TYPE);
      Response response = target.request().put(putValue);
      Object responseEntity = response.getEntity();
      String responseValue = null;
      if(responseEntity != null)
         responseValue = responseEntity.toString();
      return responseValue;

   }

   @PUT
   @Path("/{domain}/subscriptions/{endpoint}{resourcePath}")
   @Produces("application/json")
   public static String subscribeEndpointResource(@PathParam("domain")String domain,
                                    @PathParam("endpoint") String endpoint,
                                    @PathParam("resourcePath") String resourcePath)
      throws InterruptedException, ExecutionException, TimeoutException {
      return subscribeEndpointResource(domain, endpoint, resourcePath, 10, TimeUnit.SECONDS);
   }
   public static String subscribeEndpointResource(@PathParam("domain")String domain,
                                    @PathParam("endpoint") String endpoint,
                                    @PathParam("resourcePath") String resourcePath,
                                    int timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
      ResteasyClientBuilder rsb = new ResteasyClientBuilder();
      Client rsc = rsb.build();
      WebTarget target = rsc.target(BASEURL+"/"+domain+"/subscriptions/"+endpoint+resourcePath);

      if(basicAuth != null)
         target.register(basicAuth);
      target.register(new ClientLoggingFilter());
      Entity<String> putValue = Entity.entity("", MediaType.TEXT_PLAIN_TYPE);
      Future<String> future = target.request().async().put(putValue, String.class);
      String value = future.get(timeout, unit);
      return value;
   }

   public static INSP buildINSPProxy() {
      return buildINSPProxy(BASEURL);
   }

   /**
    * Factory method to create the INSP interface proxy
    * @param baseURL - the NSP server base rest url
    * @return INSP proxy implementation
    */
   public static INSP buildINSPProxy(String baseURL) {
      ResteasyClientBuilder rsb = new ResteasyClientBuilder();
      ResteasyClient rsc = rsb.disableTrustManager().build();
      ResteasyWebTarget target = rsc.target(baseURL);
      if(basicAuth != null)
         target.register(basicAuth);
      target.register(new ClientLoggingFilter());

      final INSP proxy = target.proxy(INSP.class);
      /* Wrap the generated proxy in our own implementation to override the following methods where uri encoding does
      not work:
         queryEndpointResourceValue
         subscribeEndpointResource
      */
      INSP wrapper = new INSP() {
         @GET
         @Path("/")
         @Produces("text/plain")
         public String getServerInfo() {
            return proxy.getServerInfo();
         }

         @GET
         @Path("/{domain}/endpoints")
         @Produces("application/json")
         public List<Endpoint> queryEndpoints(String domain, @DefaultValue("true") boolean stale) {
            return proxy.queryEndpoints(domain, stale);
         }

         @GET
         @Path("/{domain}/endpoints")
         @Produces("application/json")
         public String queryEndpointsByType(String domain, String endptType, @DefaultValue("true") boolean stale) {
            return proxy.queryEndpointsByType(domain, endptType, stale);
         }

         @GET
         @Path("/{domain}/endpoints/{endpoint}")
         @Produces("application/json")
         public List<EndpointResource> queryEndpointResources(String domain, String endpoint) {
            return proxy.queryEndpointResources(domain, endpoint);
         }

         @GET
         @Path("/{domain}/endpoints/{endpoint}{resourcePath}")
         @Produces("application/json")
         public String queryEndpointResourceValue(String domain, String endpoint, String resourcePath, @DefaultValue("false") boolean sync, @DefaultValue("false") boolean cacheOnly) {
            try {
               return NSPClient.queryEndpointResourceValue(domain, endpoint, resourcePath, sync, cacheOnly, 10, TimeUnit.SECONDS);
            } catch (InterruptedException|ExecutionException|TimeoutException e) {
               throw new ProcessingException("", e);
            }
         }

         @PUT
         @Path("/{domain}/subscriptions/{endpoint}{resourcePath}")
         @Produces("application/json")
         public String subscribeEndpointResource(String domain, String endpoint, String resourcePath) {
            try {
               return NSPClient.subscribeEndpointResource(domain, endpoint, resourcePath, 10, TimeUnit.SECONDS);
            } catch (InterruptedException|ExecutionException|TimeoutException e) {
               throw new ProcessingException("", e);
            }
         }

         @PUT
         @Path("/{domain}/notification/push-url")
         @Consumes("text/plain")
         public String setNotificationHandler(String domain, String pushURL) {
            return proxy.setNotificationHandler(domain, pushURL);
         }

         @GET
         @Path("{domain}/notification/push-url")
         @Produces("text/plain")
         public String getNotificationHandler(String domain) {
            return proxy.getNotificationHandler(domain);
         }
      };
      return wrapper;
   }
}
