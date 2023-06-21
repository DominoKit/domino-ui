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

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

class TimePickerCustomEvents {

  /**
   * Constant <code>DUI_TIMEPICKER_TIME_SELECTION_CHANGED="dui-timepicker-time-selection-changed"
   * </code>
   */
  public static final String DUI_TIMEPICKER_TIME_SELECTION_CHANGED =
      "dui-timepicker-time-selection-changed";

  /**
   * timeSelectionChanged.
   *
   * @param timestamp a {@link java.lang.Long} object
   * @return a {@link elemental2.dom.CustomEvent} object
   */
  public static CustomEvent<JsPropertyMap<Double>> timeSelectionChanged(Long timestamp) {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    JsPropertyMap<Double> stringJsPropertyMap = Js.uncheckedCast(JsPropertyMap.of());
    stringJsPropertyMap.set("timestamp", (double) timestamp);
    initOptions.setBubbles(true);

    initOptions.setDetail(stringJsPropertyMap);
    return new CustomEvent<>(DUI_TIMEPICKER_TIME_SELECTION_CHANGED, initOptions);
  }

  public static class UpdateTimeEventData {

    private final long timestamp;

    public UpdateTimeEventData(CustomEvent<JsPropertyMap<Double>> event) {
      JsPropertyMap<Double> detail = event.detail;
      this.timestamp = detail.get("timestamp").longValue();
    }

    public static UpdateTimeEventData of(CustomEvent<?> event) {
      return new UpdateTimeEventData(Js.uncheckedCast(event));
    }

    public long getTimestamp() {
      return timestamp;
    }
  }
}
