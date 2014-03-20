package test.org.jboss.devnation.iotbof;

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

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.devnation.iotbof.events.NspNotificationService;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@RunWith(Arquillian.class)
public class WebTestCase {
   @Deployment(testable = false)
   public static WebArchive createNotTestableDeployment() {
      WebArchive war = ShrinkWrap.create(WebArchive.class);
      war.addClass(NspNotificationService.class);
      return war;
   }

   @Test
   public void testPing(@ArquillianResource URL baseURL) throws Exception {
      URL sendURL = new URL(baseURL, "/send");
      System.out.printf("Testing %s\n", sendURL);
      HttpURLConnection httpConn = (HttpURLConnection) sendURL.openConnection();
      httpConn.setRequestMethod("PUT");
      httpConn.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
      Object content = httpConn.getContent();
      String msg = httpConn.getResponseMessage();
      System.out.printf("Received %s; msg=%s\n", content, msg);
   }
}
