/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 */
package org.dominokit.domino.ui.accessibility;

import com.google.gwt.junit.client.GWTTestCase;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.datepicker.CalendarDay;
import org.dominokit.domino.ui.datepicker.CalendarMonth;

public class CalendarAccessibilityTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "org.dominokit.domino.ui.DominoUI";
  }

  public void testCalendarMonthExposesGridAndGridCellSemantics() {
    Calendar calendar = Calendar.create();
    final CalendarMonth[] month = new CalendarMonth[1];
    calendar.withCalendarMonth((source, value) -> month[0] = value);

    CalendarDay day = month[0].getMonthViewDays().get(0);

    assertEquals("grid", month[0].getAttribute("role"));
    assertEquals("gridcell", day.getAttribute("role"));
    assertEquals("false", day.getAttribute("aria-selected"));
    assertEquals("-1", day.getAttribute("tabindex"));
  }
}
