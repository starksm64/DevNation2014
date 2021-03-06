package org.jboss.devnation.iotbof.events;/*
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

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Provider
public class LoggerFilter implements ContainerRequestFilter {
   public LoggerFilter() {
      System.out.printf("LoggerFilter initialized\n");
   }
   @Override
   public void filter(ContainerRequestContext requestContext) throws IOException {
      System.out.printf("uri=%s, method=%s\n", requestContext.getUriInfo(), requestContext.getMethod());
   }
}
