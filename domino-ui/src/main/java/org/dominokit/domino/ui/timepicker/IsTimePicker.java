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
package org.dominokit.domino.ui.timepicker;

import java.util.Date;
import java.util.Set;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.TimePickerLabels;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

/**
 * Defines the behavior and properties of a time picker component. Implementations of this interface
 * should provide the functionality to select and display time.
 *
 * <p><b>Example Usage:</b>
 *
 * <pre>
 * IsTimePicker timePicker = ...; // Some implementation of IsTimePicker
 * Date selectedDate = timePicker.getDate();
 * String formattedTime = timePicker.formattedTime();
 * </pre>
 *
 * @see TimePickerLabels
 * @see HasLabels
 * @see DateTimeFormatInfo
 */
public interface IsTimePicker extends HasLabels<TimePickerLabels> {

  /**
   * Retrieves the selected date and time from the time picker.
   *
   * @return the {@link Date} representing the selected time
   */
  Date getDate();

  /**
   * Retrieves the date and time format information used by the time picker.
   *
   * @return the {@link DateTimeFormatInfo} used for formatting date and time
   */
  DateTimeFormatInfo getDateTimeFormatInfo();

  /**
   * Binds a {@link TimePickerViewListener} to listen for time picker related events.
   *
   * @param listener the listener to be added
   */
  void bindTimePickerViewListener(TimePickerViewListener listener);

  /**
   * Unbinds a previously bound {@link TimePickerViewListener}.
   *
   * @param listener the listener to be removed
   */
  void unbindTimePickerViewListener(TimePickerViewListener listener);

  /**
   * Retrieves all the time selection listeners currently bound to the time picker.
   *
   * @return a set of {@link TimeSelectionListener} bound to the time picker
   */
  Set<TimeSelectionListener> getTimeSelectionListeners();

  /**
   * Retrieves the time style of the time picker.
   *
   * @return the {@link TimeStyle} of the time picker
   */
  TimeStyle getTimeStyle();

  /**
   * Checks if the current time is in the PM.
   *
   * @return {@code true} if the selected time is PM, otherwise {@code false}
   */
  boolean isPm();

  /**
   * Checks if the time picker is in 24 hours format.
   *
   * @return {@code true} if the time picker is in 24 hours format, otherwise {@code false}
   */
  boolean is24Hours();

  /**
   * Checks if the time picker displays seconds.
   *
   * @return {@code true} if the time picker shows seconds, otherwise {@code false}
   */
  boolean isShowSeconds();

  /**
   * Retrieves the formatted time string based on the current selection and format settings.
   *
   * @return a formatted time string
   */
  String formattedTime();
}
