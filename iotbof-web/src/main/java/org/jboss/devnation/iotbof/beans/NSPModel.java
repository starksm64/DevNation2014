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

import org.jboss.devnation.iotbof.ejbs.IProgress;
import org.jboss.devnation.iotbof.ejbs.NSPConnector;
import org.jboss.devnation.iotbof.events.AsyncID;
import org.jboss.devnation.iotbof.events.INotificationService;
import org.jboss.devnation.iotbof.events.NspAsyncResponse;
import org.jboss.devnation.iotbof.events.NspNotificationMsg;
import org.jboss.devnation.iotbof.rest.Endpoint;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
@Named("nspmodel")
@ApplicationScoped
public class NSPModel implements IProgress {
   private static Logger logger = Logger.getLogger(NSPModel.class);

   @EJB
   private NSPConnector nspConnector;
   @Inject
   private INotificationService notificationService;
   /** */
   private List<Endpoint> endpoints;
   /** */
   private ArrayList<NspNotificationMsg> notificationMsgs = new ArrayList<>();
   private ProgressBarBean progressBar = new ProgressBarBean();
   private boolean notificationsEnabled;
   private boolean showLog;

   @PostConstruct
   private void init() {
      logger.infof("Initializing, %s", this);
      // Initialize the EndpointConverter, AsyncResponseConverter
      EndpointConverter.setConnector(nspConnector);
      AsyncResponseConverter.setNotificationService(notificationService);
      AsyncResponseConverter.setConnector(nspConnector);
      EndpointView.setNotificationService(notificationService);
      EndpointView.setConnector(nspConnector);
      // See if notifications are enabled
      try {
         String handler = nspConnector.getNotificationHandler();
         notificationsEnabled = handler != null;
         logger.infof("Notification callback handler is enabled at: %s\n", handler);
      } catch (NotFoundException e) {
         logger.infof("Notification callback handler is NOT enabled\n");
         notificationsEnabled = false;
      }
      // Warn if notifications handler is not enabled.
      if(notificationsEnabled == false) {
         FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Notifications are currently disabled",
            "You need to enable notifications from the home page to receive asynchronous values");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
   }

   public String reload() {
      logger.infof("Reloading endpoints");
      progressBar.startProcess();
      // Load the current NSP endpoints
      nspConnector.reload(this);
      endpoints = nspConnector.getEndpoints();
      logger.infof("Initialized with the following endpoints: %s\n", endpoints);
      return null;
   }

   public boolean isShowLog() {
      return showLog;
   }
   public void setShowLog(boolean showLog) {
      this.showLog = showLog;
   }
   public void toggleShowLog() {
      showLog = !showLog;
   }

   public boolean isNotificationsEnabled() {
      return notificationsEnabled;
   }

   public void enableNotifications() {
      logger.infof("Reloading endpoints");
      // Enable callbacks to the NspNotificationService
      try {
         nspConnector.enableNotificationHandler();
         notificationsEnabled = true;
         logger.infof("Notifications are enabled");
      } catch (Exception e) {
         notificationsEnabled = false;
         logger.warn("Notifications could not be enabled");
         FacesContext context = FacesContext.getCurrentInstance();
         FacesMessage msg = new FacesMessage("Failed to register for notifications, "+e.getMessage());
         msg.setSeverity(FacesMessage.SEVERITY_WARN);
         context.addMessage(null, msg);
         FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("appMessages");
      }
   }

   @Override
   public void updateProgress(int current, int max, String msg) {
      int pct = current * 100 / max;
      progressBar.setCurrent(pct);
      progressBar.addMessage(msg);
      FacesContext context = FacesContext.getCurrentInstance();
      context.addMessage(null, new FacesMessage(msg));
   }
   public int getProgress() {
      return progressBar.getCurrentValue();
   }
   public List<String> getProgressMessages() {
      return progressBar.getMessages();
   }

   public void onComplete() {
      logger.infof("Adding completed message, %d endpoints\n", endpoints.size());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
         "Loading Completed", "Loading Completed"));
    }

   public List<Endpoint> getEndpoints() {
      logger.infof("Returning %d endpoints\n", getEndpointsSize());
      return endpoints;
   }

   public String getConnectionStatus() {
      String serverInfo = nspConnector.getServerInfo();
      String nspURL = nspConnector.getNspURL();
      return String.format("Connected to: %s @ %s", serverInfo, nspURL);
   }

   public ProgressBarBean getProgressBar() {
      return progressBar;
   }
   public int getEndpointsSize() {
      int size = endpoints != null ? endpoints.size() : 0;
      return size;
   }
   public List<NspNotificationMsg> getNotificationMsgs() {
      return notificationMsgs;
   }

   public void clearNotifications() {
      notificationMsgs.clear();
   }

   public void receiveNotificationMsg(@Observes NspNotificationMsg msg) {
      logger.infof("receiveNotificationMsg, %s\n", msg);
      notificationMsgs.add(msg);
   }
   public void receiveAsyncResponse(@Observes NspAsyncResponse msg) {
      logger.infof("receiveAsyncResponse, %s\n", msg.getId());
      FacesContext context = FacesContext.getCurrentInstance();
      if(context != null) {
         String[] idParts = msg.getIdParts();
         String epname = idParts[AsyncID.IDParts.EndpointName.ordinal()];
         String uri = idParts[AsyncID.IDParts.URI.ordinal()];
         String detail = String.format("Updated %s, %s, status=%s", epname, uri, msg.getStatus());
         FacesMessage fmsg = new FacesMessage(msg.getId(), detail);
         fmsg.setSeverity(FacesMessage.SEVERITY_INFO);
         context.addMessage(null, fmsg);
      }
   }
}
