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

/**
 * Resource types for ObjectID.LWM2MServer
  * @see org.jboss.devnation.iotbof.rest.ObjectID#LWM2MServer
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public enum LWM2MServerResourceType implements IResourceType {
   ShortServerID("R"),
   Lifetime("RW"),
   DefaultMinimumPeriod("RW"),
   DefaultMaximumPeriod("RW"),
   Disable("E"),
   DisableTimeout("RW"),
   NotificationStoring("RW"),
   Binding("RW"),
   RegistrationUpdateTrigger("E")
   ;

   private LWM2MServerResourceType(String accessType) {
      this.accessType = accessType;
   }
   private String accessType;

   @Override
   public int getID() {
      return ordinal();
   }

   @Override
   public String getAccessType() {
      return accessType;
   }

   @Override
   public String getDescription() {
      return name();
   }

   public static LWM2MServerResourceType valueOf(int id) {
      return LWM2MServerResourceType.values()[id];
   }

}
