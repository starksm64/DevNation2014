package test.nsp;

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

import org.jboss.devnation.iotbof.rest.INSP;
import org.jboss.devnation.iotbof.rest.NSPClient;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class TestINSPNotification {
   private static INSP nspApi;

   @BeforeClass
   public static void classInit() {
      NSPClient.setBasicAuthentication("admin", "secret");
      nspApi = NSPClient.buildINSPProxy();
   }

   /**
    * Test setting a notification callback url. The notification callback handler must be running for this to succeed.
    * @throws Exception
    */
   @Test
   public void setNotificationHandler() throws Exception {
      String msg = nspApi.setNotificationHandler("domain", "http://dmz.starkinternational.com:8081/iotbof-web/events/send");
      System.out.printf("Msg: %s\n", msg);
   }
}
