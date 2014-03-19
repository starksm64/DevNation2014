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

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class NspNotificationMsg {
   private List<NspNotification> notifications;
   private List<NspRegistration> registrations;
   private List<NspRegistrationUpdate> registrationUpdates;
   private List<NspAsyncResponse> asyncResponses;

   public List<NspNotification> getNotifications() {
      return notifications;
   }

   public void setNotifications(List<NspNotification> notifications) {
      this.notifications = notifications;
   }

   public List<NspRegistration> getRegistrations() {
      return registrations;
   }

   public void setRegistrations(List<NspRegistration> registrations) {
      this.registrations = registrations;
   }

   @XmlElement(name = "reg-updates")
   public List<NspRegistrationUpdate> getRegistrationUpdates() {
      return registrationUpdates;
   }

   public void setRegistrationUpdates(List<NspRegistrationUpdate> registrationUpdates) {
      this.registrationUpdates = registrationUpdates;
   }

   @XmlElement(name = "async-responses")
   public List<NspAsyncResponse> getAsyncResponses() {
      return asyncResponses;
   }

   public void setAsyncResponses(List<NspAsyncResponse> asyncResponses) {
      this.asyncResponses = asyncResponses;
   }

@Override
public String toString() {
	return "NspNotificationMsg [notifications=" + notifications
			+ ", registrations=" + registrations + ", registrationUpdates="
			+ registrationUpdates + ", asyncResponses=" + asyncResponses + "]";
}

}
