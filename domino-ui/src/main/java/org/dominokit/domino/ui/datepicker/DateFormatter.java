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

/**
 * Represents a formatter for handling date values. This interface allows the parsing and formatting
 * of date strings based on specific patterns and localization information.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * DateTimeFormatInfo formatInfo = ...; // Get appropriate format info
 * String formattedDate = DateFormatter.DEFAULT.format("yyyy-MM-dd", formatInfo, new Date());
 * </pre>
 */
public interface DateFormatter {

  /** A default formatter instance for general use. */
  DateFormatter DEFAULT = new DefaultFormatter();

  /**
   * Parses the provided date string using the specified pattern and date-time format information.
   * This method is strict and will throw exceptions if the format isn't strictly adhered to.
   *
   * @param pattern The date pattern to use.
   * @param dtfi The date-time format information.
   * @param dateString The date string to parse.
   * @return A parsed Date object.
   */
  Date parseStrict(String pattern, DateTimeFormatInfo dtfi, String dateString);

  /**
   * Parses the provided date string using the specified pattern and date-time format information.
   *
   * @param pattern The date pattern to use.
   * @param dtfi The date-time format information.
   * @param dateString The date string to parse.
   * @return A parsed Date object.
   */
  Date parse(String pattern, DateTimeFormatInfo dtfi, String dateString);

  /**
   * Formats the provided date based on the specified pattern and date-time format information.
   *
   * @param pattern The date pattern to use.
   * @param dtfi The date-time format information.
   * @param date The date to format.
   * @return A formatted date string.
   */
  String format(String pattern, DateTimeFormatInfo dtfi, Date date);

  /**
   * Default implementation of the {@link DateFormatter} interface, which utilizes the {@link
   * DateTimeFormat} for its operations.
   */
  class DefaultFormatter extends DateTimeFormat implements DateFormatter {

    /** Constructs the default formatter based on the predefined short date format. */
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
