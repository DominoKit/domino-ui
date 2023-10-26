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
 * The {@code TimePickerLabels} interface provides labels for time picker components and messages.
 *
 * <p>Usage Example:
 *
 * <pre><code>
 * TimePicker timePicker = new TimePicker();
 * timePicker.setHourLabel(timePickerLabels.hour());
 * timePicker.setMinuteLabel(timePickerLabels.minute());
 * timePicker.setSecondLabel(timePickerLabels.seconds());
 * </code></pre>
 *
 * @see Labels
 */
public interface TimePickerLabels extends Labels {

  /**
   * Gets the label for the "Hour" field in the time picker.
   *
   * @return The label for the "Hour" field.
   */
  default String hour() {
    return "Hour";
  }

  /**
   * Gets the label for the "Minutes" field in the time picker.
   *
   * @return The label for the "Minutes" field.
   */
  default String minute() {
    return "Minutes";
  }

  /**
   * Gets the label for the "Seconds" field in the time picker.
   *
   * @return The label for the "Seconds" field.
   */
  default String seconds() {
    return "Seconds";
  }

  /**
   * Gets the label for the "AM/PM" field in the time picker.
   *
   * @return The label for the "AM/PM" field.
   */
  default String ampm() {
    return "AM/PM";
  }

  /**
   * Gets the error message for an invalid time format in the time picker.
   *
   * @return The error message for an invalid time format.
   */
  default String timePickerInvalidTimeFormat() {
    return "Invalid time format";
  }
}
