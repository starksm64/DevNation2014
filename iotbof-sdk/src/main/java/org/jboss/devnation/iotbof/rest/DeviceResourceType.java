package org.jboss.devnation.iotbof.rest;/*
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
 * Resource types for ObjectID.Device
 * @see org.jboss.devnation.iotbof.rest.ObjectID#Device
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public enum DeviceResourceType implements IResourceType {
   Manufacturer("R"),
   ModelNumber("R"),
   SerialNumber("R"),
   FirmwareVersion("R"),
   Reboot("R"),
   FactoryReset("R"),
   AvailablePowerSources("E"),
   PowerSourceVoltage("R"),
   PowerSourceCurrent("R"),
   BatteryLevel("R"),
   MemoryFree("R"),
   ErrorCode("R"),
   ResetErrorCode("R"),
   CurrentTime("RW"),
   UTCOffset("RW"),
   Timezone("RW"),
   SupportedBindingAndModes("R")
   ;

   private DeviceResourceType(String accessType) {
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

   public static DeviceResourceType valueOf(int id) {
      return DeviceResourceType.values()[id];
   }
}
