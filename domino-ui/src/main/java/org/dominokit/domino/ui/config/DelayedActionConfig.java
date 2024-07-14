/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.config;

public interface DelayedActionConfig extends ComponentConfig {

  /**
   * Use to globally configure the delayed actions delay.
   *
   * @return the delay in milliseconds, default to 200ms
   */
  default int getDelayedExecutionDefaultDelay() {
    return 200;
  }

  default int getDefaultSelectableBoxTypeAheadDelay() {
    return 1000;
  }

  default int getSuggestBoxTypeAheadDelay() {
    return getDefaultSelectableBoxTypeAheadDelay();
  }

  default int getSelectBoxTypeAheadDelay() {
    return getDefaultSelectableBoxTypeAheadDelay();
  }

  default int getDefaultNotificationDuration() {
    return 4000;
  }

  default int getDateBoxDefaultInputParseDelay() {
    return getDelayedExecutionDefaultDelay();
  }
}
