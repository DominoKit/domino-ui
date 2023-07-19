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
package org.dominokit.domino.ui.i18n;

/**
 * TimePickerLabels interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface TimePickerLabels extends Labels {
  /**
   * hour.
   *
   * @return a {@link java.lang.String} object
   */
  default String hour() {
    return "Hour";
  }

  /**
   * minute.
   *
   * @return a {@link java.lang.String} object
   */
  default String minute() {
    return "Minutes";
  }

  /**
   * seconds.
   *
   * @return a {@link java.lang.String} object
   */
  default String seconds() {
    return "Seconds";
  }

  /**
   * ampm.
   *
   * @return a {@link java.lang.String} object
   */
  default String ampm() {
    return "AM/PM";
  }

  /**
   * timePickerInvalidTimeFormat.
   *
   * @return a {@link java.lang.String} object
   */
  default String timePickerInvalidTimeFormat() {
    return "Invalid time format";
  }
}
