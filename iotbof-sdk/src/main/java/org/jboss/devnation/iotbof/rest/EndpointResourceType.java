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
 * Translate the resource uri into its /{Object ID}/{Object instance}/{Resource ID} into an ObjectID;resouce enum pair
 * The type of resource enum can depend on the ObjectID
 *
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class EndpointResourceType {
   private ObjectID id;
   private IResourceType resID;

   /**
    * Given a partial resource uri path of the form /{Object ID}/{Object instance}/{Resource ID}, where each
    * part is a number, create an ObjectID, ResourceID pair
    * @param uri - /{Object ID}/{Object instance}/{Resource ID}
    */
   public EndpointResourceType(String uri) {
      // Split the uri into the number parts
      String[] parts = uri.split("/");
      if(parts.length != 4) {
         // Handle the '/gps/loc' uri specially
         if(!uri.equals("/gps/loc"))
            throw new IllegalArgumentException(String.format("uri('%s') was not of the form /oid/oinst/resid", uri));
         // Map to Location,SensorValue
         id = ObjectID.Location;
         resID = ResourceID.SensorValue;
      } else {
         int oid = Integer.parseInt(parts[1]);
         int resid = Integer.parseInt(parts[3]);
         id = ObjectID.valueOf(oid);
         // The resource enum type depends on the ObjectID type
         if(oid > ObjectID.IPSO_START.getOid()) {
            resID = ResourceID.valueOf(resid);
         } else {
            // Handle the object specific LWM2M resources
            switch (id) {

               case LWM2MSecurity:
                  break;
               case LWM2MServer:
                  resID = LWM2MServerResourceType.valueOf(resid);
                  break;
               case AccessControl:
                  break;
               case Device:
                  resID = DeviceResourceType.valueOf(resid);
                  break;
               case ConnectivityMonitoring:
                  resID = ConnectivityMonitoringResourceType.valueOf(resid);
                  break;
               case Firmware:
                  break;
               case Location:
                  break;
               case ConnectivityStatistics:
                  break;
            }
         }
         if(id == null)
            throw new IllegalArgumentException(String.format("Failed to map(%d) to ObjectID", oid));
         if(resID == null)
            throw new IllegalArgumentException(String.format("Failed to map(oid=%d,resid=%d) to resource", oid, resid));
      }
   }

   public ObjectID getId() {
      return id;
   }
   public String getObjectName() {
      return id.name();
   }

   public IResourceType getResID() {
      return resID;
   }

   public String getResourceName() {
      return resID.name();
   }
   public String getResourceAccessType() {
      return resID.getAccessType();
   }
   public String getResourceDescription() {
      return resID.getDescription();
   }

   public String toString() {
      return String.format("%s/%s", id.name(), resID.name());
   }

   public boolean isEditable() {
      return resID.getAccessType().contains("W");
   }
}
