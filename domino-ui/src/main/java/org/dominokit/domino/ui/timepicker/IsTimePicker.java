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

/** IsTimePicker interface. */
public interface IsTimePicker extends HasLabels<TimePickerLabels> {
  /**
   * getDate.
   *
   * @return a {@link java.util.Date} object
   */
  Date getDate();

  /**
   * getDateTimeFormatInfo.
   *
   * @return a {@link org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo} object
   */
  DateTimeFormatInfo getDateTimeFormatInfo();

  /**
   * bindTimePickerViewListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.timepicker.TimePickerViewListener} object
   */
  void bindTimePickerViewListener(TimePickerViewListener listener);

  /**
   * unbindTimePickerViewListener.
   *
   * @param listener a {@link org.dominokit.domino.ui.timepicker.TimePickerViewListener} object
   */
  void unbindTimePickerViewListener(TimePickerViewListener listener);

  /**
   * getTimeSelectionListeners.
   *
   * @return a {@link java.util.Set} object
   */
  Set<TimeSelectionListener> getTimeSelectionListeners();

  /**
   * getTimeStyle.
   *
   * @return a {@link org.dominokit.domino.ui.timepicker.TimeStyle} object
   */
  TimeStyle getTimeStyle();

  /**
   * isPm.
   *
   * @return a boolean
   */
  boolean isPm();

  /**
   * is24Hours.
   *
   * @return a boolean
   */
  boolean is24Hours();

  /**
   * isShowSeconds.
   *
   * @return a boolean
   */
  boolean isShowSeconds();

  /**
   * formattedTime.
   *
   * @return a {@link java.lang.String} object
   */
  String formattedTime();
}
