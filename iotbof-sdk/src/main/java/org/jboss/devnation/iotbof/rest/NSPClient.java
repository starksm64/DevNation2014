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

import javax.ws.rs.DefaultValue;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class NSPClient {

   private static String BASEURL = "http://red-hat-summit.cloudapp.net:8080/";
   private static final String NOTIFICATION_PUSH_URL = "/notification/push-url";
   private static BasicAuthentication basicAuth;

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
    * Obtain the value of an endpoint resource
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
                                       @DefaultValue("false") @QueryParam("cacheOnly") boolean cacheOnly) {

      ResteasyClientBuilder rsb = new ResteasyClientBuilder();
      Client rsc = rsb.build();
      WebTarget target = rsc.target(BASEURL+"/"+domain+"/endpoints/"+endpoint+resourcePath)
         .queryParam("sync", sync)
         .queryParam("cacheOnly", cacheOnly);

      if(basicAuth != null)
         target.register(basicAuth);
      target.register(new ClientLoggingFilter());
      String value = target.request().get(String.class);

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

   public static INSP buildINSPProxy() {
      return buildINSPProxy(BASEURL);
   }
   public static INSP buildINSPProxy(String baseURL) {
      ResteasyClientBuilder rsb = new ResteasyClientBuilder();
      ResteasyClient rsc = rsb.disableTrustManager().build();
      ResteasyWebTarget target = rsc.target(baseURL);
      if(basicAuth != null)
         target.register(basicAuth);
      target.register(new ClientLoggingFilter());

      return target.proxy(INSP.class);
   }
}
