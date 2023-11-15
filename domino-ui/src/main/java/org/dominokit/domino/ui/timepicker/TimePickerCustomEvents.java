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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/** Utility class for creating and handling custom events related to time picker. */
class TimePickerCustomEvents {

  /** The name of the custom event for time selection change. */
  public static final String DUI_TIMEPICKER_TIME_SELECTION_CHANGED =
      "dui-timepicker-time-selection-changed";

  /**
   * Creates a custom event for time selection change.
   *
   * @param timestamp The timestamp representing the selected time.
   * @return A custom event for time selection change.
   */
  public static CustomEvent<JsPropertyMap<Double>> timeSelectionChanged(Long timestamp) {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    JsPropertyMap<Double> stringJsPropertyMap = Js.uncheckedCast(JsPropertyMap.of());
    stringJsPropertyMap.set("timestamp", (double) timestamp);
    initOptions.setBubbles(true);

    initOptions.setDetail(stringJsPropertyMap);
    return new CustomEvent<>(DUI_TIMEPICKER_TIME_SELECTION_CHANGED, initOptions);
  }

  /** A data class to hold the data from a custom event related to time selection change. */
  public static class UpdateTimeEventData {

    private final long timestamp;

    public UpdateTimeEventData(CustomEvent<JsPropertyMap<Double>> event) {
      JsPropertyMap<Double> detail = event.detail;
      this.timestamp = detail.get("timestamp").longValue();
    }

    /**
     * Creates an instance of UpdateTimeEventData from a custom event.
     *
     * @param event The custom event.
     * @return An instance of UpdateTimeEventData.
     */
    public static UpdateTimeEventData of(CustomEvent<?> event) {
      return new UpdateTimeEventData(Js.uncheckedCast(event));
    }

    /**
     * Gets the timestamp representing the selected time.
     *
     * @return The timestamp.
     */
    public long getTimestamp() {
      return timestamp;
    }
  }
}
