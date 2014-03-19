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

import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class NspRegistration {
   private String ep;
   private String ept;
   private List<NspResource> resources;

   public String getEp() {
      return ep;
   }

   public void setEp(String ep) {
      this.ep = ep;
   }

   public String getEpt() {
      return ept;
   }

   public void setEpt(String ept) {
      this.ept = ept;
   }

   public List<NspResource> getResources() {
      return resources;
   }

   public void setResources(List<NspResource> resources) {
      this.resources = resources;
   }

@Override
public String toString() {
	return "NspRegistration [ep=" + ep + ", ept=" + ept + ", resources="
			+ resources + "]";
}
   
}
