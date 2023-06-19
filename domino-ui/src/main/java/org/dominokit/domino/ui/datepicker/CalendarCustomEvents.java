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
package org.dominokit.domino.ui.datepicker;

import elemental2.dom.CustomEvent;
import elemental2.dom.CustomEventInit;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

class CalendarCustomEvents {

  public static final String DUI_CALENDAR_DATE_SELECTION_CHANGED =
      "dui-calendar-date-selection-changed";
  public static final String SELECT_YEAR_MONTH = "dui-calendar-select-year-month";
  public static final String DATE_NAVIGATION_CHANGED = "dui-calendar-date-navigation-changed";

  public static CustomEvent<JsPropertyMap<Double>> dateSelectionChanged(Long timestamp) {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    JsPropertyMap<Double> stringJsPropertyMap = Js.uncheckedCast(JsPropertyMap.of());
    stringJsPropertyMap.set("timestamp", (double) timestamp);
    initOptions.setBubbles(true);

    initOptions.setDetail(stringJsPropertyMap);
    return new CustomEvent<>(DUI_CALENDAR_DATE_SELECTION_CHANGED, initOptions);
  }

  public static CustomEvent<JsPropertyMap<Double>> selectYearMonth() {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    initOptions.setBubbles(true);

    return new CustomEvent<>(SELECT_YEAR_MONTH, initOptions);
  }

  public static CustomEvent<JsPropertyMap<Double>> dateNavigationChanged(long timestamp) {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    JsPropertyMap<Double> stringJsPropertyMap = Js.uncheckedCast(JsPropertyMap.of());
    stringJsPropertyMap.set("timestamp", (double) timestamp);
    initOptions.setBubbles(true);

    initOptions.setDetail(stringJsPropertyMap);
    return new CustomEvent<>(DATE_NAVIGATION_CHANGED, initOptions);
  }

  public static class UpdateDateEventData {

    private final long timestamp;

    public UpdateDateEventData(CustomEvent<JsPropertyMap<Double>> event) {
      JsPropertyMap<Double> detail = event.detail;
      this.timestamp = detail.get("timestamp").longValue();
    }

    public static UpdateDateEventData of(CustomEvent<?> event) {
      return new UpdateDateEventData(Js.uncheckedCast(event));
    }

    public long getTimestamp() {
      return timestamp;
    }
  }
}
