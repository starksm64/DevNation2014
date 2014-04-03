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
 * Object ids from OMA-TS-LightweightM2M V1_0_20131210-C and
 * IPSO Application Framework Objects Aug 13 2013 draft.

 *
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public enum ObjectID {
   // LWM2M objects
   LWM2MSecurity(0),
   LWM2MServer(1),
   AccessControl(2),
   Device(3),
   ConnectivityMonitoring(4),
   Firmware(5),
   Location(6),
   ConnectivityStatistics(7),
   IPSO_START(199),
   // IPSO application objects
   IPSODigitalInput(200),
   IPSODigitalOutput(201),
   IPSOAnalogueInput(202),
   IPSOAnalogueOutput(203),
   IPSOGenericSensor(300),
   IPSOLuminositySensor(301),
   IPSOPresenceSensor(302),
   IPSOTemperatureSensor(303),
   IPSOHumiditySensor(304),
   IPSOPowerMeasurement(305),
   IPSOActuator(306),
   IPSOSetPoint(308),
   IPSOFrenchTICInfo(309),
   IPSOLoadControl(310),
   IPSOLightControl(311),
   IPSOPowerControl(312),
   IPSOAccelerometer(313)
   ;

   private int oid;
   private ObjectID(int oid) {
      this.oid = oid;
   }
   public int getOid() {
      return oid;
   }

   public static ObjectID valueOf(int id) {
      for(ObjectID oid : values()) {
         if(oid.getOid() == id)
            return oid;
      }
      return null;
   }
}
