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

import org.jboss.devnation.iotbof.events.NspAsyncResponse;
import org.junit.Test;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class TestAsyncResponse {
   @Test
   public void testIdParsing() {
      NspAsyncResponse response = new NspAsyncResponse();
      response.setId("{\"async-response-id\":\"54696#mbed-ethernet-1DE41@domain/3/0/2\"}");
      String[] parts = response.getIdParts();
      for(NspAsyncResponse.IDParts p : NspAsyncResponse.IDParts.values()) {
         System.out.printf("%s = %s\n", p.name(), parts[p.ordinal()]);
      }
   }
}
