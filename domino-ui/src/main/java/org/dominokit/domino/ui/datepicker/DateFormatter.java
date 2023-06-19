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

import java.util.Date;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;

public interface DateFormatter {

  DateFormatter DEFAULT = new DefaultFormatter();

  /**
   * parse the date string with strict formatting, if the date string does not match the date
   * pattern this method should throw {@link IllegalArgumentException}
   *
   * @param pattern String date pattern
   * @param dtfi {@link DateTimeFormatInfo}
   * @param dateString String date value
   * @return Date
   */
  Date parseStrict(String pattern, DateTimeFormatInfo dtfi, String dateString);

  /**
   * parse the date string and produce a {@link Date} object
   *
   * @param pattern String date pattern
   * @param dtfi {@link DateTimeFormatInfo}
   * @param dateString String date value
   * @return Date
   */
  Date parse(String pattern, DateTimeFormatInfo dtfi, String dateString);

  /**
   * Convert a date object into a date string with the specified pattern and {@link
   * DateTimeFormatInfo}
   *
   * @param pattern String date pattern
   * @param dtfi {@link DateTimeFormatInfo}
   * @param date {@link Date}
   * @return String formatted date
   */
  String format(String pattern, DateTimeFormatInfo dtfi, Date date);

  /**
   * An internal implementation of the {@link DateFormatter} that used GWT {@link DateTimeFormat} to
   * format and parse the date.
   */
  class DefaultFormatter extends DateTimeFormat implements DateFormatter {

    protected DefaultFormatter() {
      super(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT).getPattern());
    }

    /** {@inheritDoc} */
    @Override
    public Date parseStrict(String pattern, DateTimeFormatInfo dtfi, String value) {
      return getFormat(pattern, dtfi).parseStrict(value);
    }
    /** {@inheritDoc} */
    @Override
    public Date parse(String pattern, DateTimeFormatInfo dtfi, String value) {
      return getFormat(pattern, dtfi).parse(value);
    }
    /** {@inheritDoc} */
    @Override
    public String format(String pattern, DateTimeFormatInfo dtfi, Date date) {
      return getFormat(pattern, dtfi).format(date);
    }
  }
}
