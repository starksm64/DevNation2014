package org.jboss.devnation.iotbof.weld;/*
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

import org.jboss.devnation.iotbof.rest.INSP;
import org.jboss.devnation.iotbof.rest.NSPClient;
import org.jboss.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import java.net.URL;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class WeldProducerMethods {
   private static final Logger logger = Logger.getLogger(WeldProducerMethods.class);

   @Resource(name="java:global/NSPURL")
  	private static URL nspURL;

   @Produces
   public static INSP getNSPImplementation() {
      logger.infof("nspURL=%s\n", nspURL);
      NSPClient.setBasicAuthentication("admin", "secret");
      INSP impl = NSPClient.buildINSPProxy();
      return impl;
   }
}
