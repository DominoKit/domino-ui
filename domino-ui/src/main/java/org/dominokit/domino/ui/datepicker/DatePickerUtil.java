package org.dominokit.domino.ui.datepicker;

import elemental2.core.JsDate;

public class DatePickerUtil {

    public static int getValidMonthDate(int year, int month, int date){
        int days = getMonthDays(year, month);

        if (date > days) {
            return 1;
        } else {
            return date;
        }
    }

    public static int getMonthDays(int year, int month){
        JsDate jsDateCalc = new JsDate(year, month, 32);
        return (32 - (jsDateCalc.getDate()));
    }
}
