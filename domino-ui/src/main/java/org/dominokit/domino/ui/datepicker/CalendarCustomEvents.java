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

/**
 * Utility class to manage and create custom events related to calendar operations.
 *
 * <p>Usage example:
 *
 * <pre>
 * CustomEvent event = CalendarCustomEvents.dateSelectionChanged(1634048882000L);
 * </pre>
 */
class CalendarCustomEvents {

  /** Event fired when the date selection is changed in the calendar. */
  public static final String DUI_CALENDAR_DATE_SELECTION_CHANGED =
      "dui-calendar-date-selection-changed";

  /** Event fired when year or month is selected in the calendar. */
  public static final String SELECT_YEAR_MONTH = "dui-calendar-select-year-month";

  /** Event fired when navigating to a different date in the calendar. */
  public static final String DATE_NAVIGATION_CHANGED = "dui-calendar-date-navigation-changed";

  /**
   * Creates a custom event for a date selection change.
   *
   * @param timestamp The timestamp of the date that was selected.
   * @return The created custom event.
   */
  public static CustomEvent<JsPropertyMap<Double>> dateSelectionChanged(Long timestamp) {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    JsPropertyMap<Double> stringJsPropertyMap = Js.uncheckedCast(JsPropertyMap.of());
    stringJsPropertyMap.set("timestamp", (double) timestamp);
    initOptions.setBubbles(true);

    initOptions.setDetail(stringJsPropertyMap);
    return new CustomEvent<>(DUI_CALENDAR_DATE_SELECTION_CHANGED, initOptions);
  }

  /**
   * Creates a custom event indicating a year or month selection.
   *
   * @return The created custom event.
   */
  public static CustomEvent<JsPropertyMap<Double>> selectYearMonth() {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    initOptions.setBubbles(true);

    return new CustomEvent<>(SELECT_YEAR_MONTH, initOptions);
  }

  /**
   * Creates a custom event indicating a navigation change to a different date.
   *
   * @param timestamp The timestamp of the new navigated date.
   * @return The created custom event.
   */
  public static CustomEvent<JsPropertyMap<Double>> dateNavigationChanged(long timestamp) {
    CustomEventInit<JsPropertyMap<Double>> initOptions = Js.uncheckedCast(CustomEventInit.create());
    JsPropertyMap<Double> stringJsPropertyMap = Js.uncheckedCast(JsPropertyMap.of());
    stringJsPropertyMap.set("timestamp", (double) timestamp);
    initOptions.setBubbles(true);

    initOptions.setDetail(stringJsPropertyMap);
    return new CustomEvent<>(DATE_NAVIGATION_CHANGED, initOptions);
  }

  /** Inner class to encapsulate event data related to date updates. */
  public static class UpdateDateEventData {

    private final long timestamp;

    /**
     * Constructor for creating an instance of UpdateDateEventData.
     *
     * @param event The custom event from which data will be extracted.
     */
    public UpdateDateEventData(CustomEvent<JsPropertyMap<Double>> event) {
      JsPropertyMap<Double> detail = event.detail;
      this.timestamp = detail.get("timestamp").longValue();
    }

    /**
     * Factory method to create an instance of UpdateDateEventData.
     *
     * @param event The custom event.
     * @return An instance of {@link UpdateDateEventData}.
     */
    public static UpdateDateEventData of(CustomEvent<?> event) {
      return new UpdateDateEventData(Js.uncheckedCast(event));
    }

    /**
     * Retrieves the timestamp from the event data.
     *
     * @return The timestamp.
     */
    public long getTimestamp() {
      return timestamp;
    }
  }
}
