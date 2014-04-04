package org.jboss.devnation.iotbof.beans;
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

import org.jboss.devnation.iotbof.events.INotificationService;
import org.jboss.devnation.iotbof.events.NspAsyncResponse;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@ManagedBean
@RequestScoped
public class NotificationServiceView {
   @Inject
   private INotificationService notificationService;

   public List<NspAsyncResponse> getAllResponses() {
      ArrayList<NspAsyncResponse> all = new ArrayList<>(notificationService.getAllAsyncResponses());
      return all;
   }
}
