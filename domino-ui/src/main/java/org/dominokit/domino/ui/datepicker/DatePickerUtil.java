package org.dominokit.domino.ui.datepicker;

import elemental2.core.JsDate;

/**
 * A utility class for {@link DatePicker}
 */
public class DatePickerUtil {

    /**
     * Returns a valid day of month
     *
     * @param year  the year of the month
     * @param month the month
     * @param date  the current date
     * @return the valid day of month
     */
    public static int getValidMonthDate(int year, int month, int date) {
        int days = getMonthDays(year, month);

        if (date > days) {
            return 1;
        } else {
            return date;
        }
    }

    /**
     * Returns the number of days for a month at specific year
     *
     * @param year  the year
     * @param month the month
     * @return the number of days
     */
    public static int getMonthDays(int year, int month) {
        JsDate jsDateCalc = new JsDate(year, month, 32);
        return (32 - (jsDateCalc.getDate()));
    }
}
