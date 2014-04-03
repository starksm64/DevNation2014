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
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public enum ConnectivityMonitoringResourceType implements IResourceType {
   NetworkBearer("R"),
   AvailableNetworkBearer("R"),
   RadioSignalStrength("R"),
   LinkQuality("R"),
   IPAddresses("R"),
   RouterIPAddresses("R"),
   LinkUtilization("R"),
   AccessPointName("R"),
   CellID("R"),
   ServingMobileNetworkCode("R"),
   ServingMobileCountryCode("R")
   ;

   private ConnectivityMonitoringResourceType(String accessType) {
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

   public static ConnectivityMonitoringResourceType valueOf(int id) {
      return ConnectivityMonitoringResourceType.values()[id];
   }
}
