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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimePickerHourConversionTest {

  @Test
  public void testToDisplayHourConvertsMidnightToTwelve() {
    assertEquals(12, TimePickerHourConversion.toDisplayHour(0));
    assertEquals(12, TimePickerHourConversion.toDisplayHour(12));
    assertEquals(1, TimePickerHourConversion.toDisplayHour(13));
    assertEquals(11, TimePickerHourConversion.toDisplayHour(23));
  }

  @Test
  public void testToDateHourKeepsNoonAndConvertsMidnight() {
    assertEquals(0, TimePickerHourConversion.toDateHour(12, TimePeriod.AM));
    assertEquals(12, TimePickerHourConversion.toDateHour(12, TimePeriod.PM));
    assertEquals(1, TimePickerHourConversion.toDateHour(1, TimePeriod.AM));
    assertEquals(13, TimePickerHourConversion.toDateHour(1, TimePeriod.PM));
  }

  @Test
  public void testToTimePeriodMatchesTwentyFourHourClock() {
    assertEquals(TimePeriod.AM, TimePickerHourConversion.toTimePeriod(0));
    assertEquals(TimePeriod.PM, TimePickerHourConversion.toTimePeriod(12));
    assertEquals(TimePeriod.PM, TimePickerHourConversion.toTimePeriod(23));
  }
}
