package org.jboss.devnation.iotbof.events;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class AsyncID {
   public static enum IDParts {
      NID,
      EndpointName,
      Domain,
      URI
   }

   private static Pattern idpattern = Pattern.compile("(\\d+)#([^@]+)@([^/]+)(.*)");
   private String id;
   private String[] idParts;

   public AsyncID(String id) {
      this.id = id;
   }

   public String[] getIdParts() {
      if(idParts != null)
         return idParts;

      // Split the 54696#mbed-ethernet-1DE41@domain/3/0/2 into (nid)#(epname)@(domain)(uri)
      Matcher m = idpattern.matcher(id);
      if(m.matches() == false)
         return null;
      idParts = new String[m.groupCount()];
      for(int n = 1; n <= m.groupCount(); n ++) {
         idParts[n-1] = m.group(n);
      }
      return idParts;
   }

   public String getId() {
      return id;
   }
   public String getNID() {
      String[] parts = getIdParts();
      return parts[IDParts.NID.ordinal()];
   }
   public String getDomain() {
      String[] parts = getIdParts();
      return parts[IDParts.Domain.ordinal()];
   }
   public String getEndpointName() {
      String[] parts = getIdParts();
      return parts[IDParts.EndpointName.ordinal()];
   }
   public String getURI() {
      String[] parts = getIdParts();
      return parts[IDParts.URI.ordinal()];
   }

   public String toString() {
      return String.format("{Domain=%s,nid=%s,EP=%s,URI=%s}", getDomain(), getNID(), getEndpointName(), getURI());
   }
}
