package org.jboss.devnation.iotbof.beans;/*
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

import java.util.Date;

/**
 * @author Scott Stark (sstark@redhat.com) (C) 2014 Red Hat Inc.
 */
public class ProgressBarBean {
   private boolean buttonRendered = true;
   private boolean enabled = false;
   private Long startTime;
   private int current;

   public ProgressBarBean() {
   }

   public String startProcess() {
      setEnabled(true);
      setButtonRendered(false);
      setStartTime(new Date().getTime());
      return null;
   }

   public int getCurrentValue() {
      if (isEnabled()) {
         return current;
      }

      if (startTime == null) {
         return -1;
      }
      return 101;
   }
   public void setCurrent(int current) {
      this.current = current;
   }

   public boolean isEnabled() {
      return enabled;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public Long getStartTime() {
      return startTime;
   }

   public void setStartTime(Long startTime) {
      this.startTime = startTime;
   }

   public boolean isButtonRendered() {
      return buttonRendered;
   }

   public void setButtonRendered(boolean buttonRendered) {
      this.buttonRendered = buttonRendered;
   }
}