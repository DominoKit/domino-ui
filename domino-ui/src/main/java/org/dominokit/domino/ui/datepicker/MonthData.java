package org.dominokit.domino.ui.datepicker;

import elemental2.core.JsDate;
import elemental2.dom.DomGlobal;

import java.util.Date;

public class MonthData {

    private final int daysCount;
    private final int fullYear;
    private final Date date;

    public MonthData(Date date) {
        this.date = date;
        JsDate zeroDayDate = new JsDate(this.date.getYear() + 1900, this.date.getMonth() + 1, 0);
        this.daysCount = zeroDayDate.getDate();
        this.fullYear = zeroDayDate.getFullYear();
    }

    public MonthData getMonthBefore() {
        if (this.date.getMonth() == 0) {
            return new MonthData(new Date(this.date.getYear() - 1, 11,1));
        } else {
            return new MonthData(new Date(this.date.getYear(), this.date.getMonth() - 1,1));
        }
    }

    public MonthData getMonthAfter() {
        if (this.date.getMonth() == 11) {
            return new MonthData(new Date(this.date.getYear() + 1, 0,1));
        } else {
            return new MonthData(new Date(this.date.getYear(), this.date.getMonth() + 1,1));
        }
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public int getDaysCount() {
        return daysCount;
    }

    public int getFullYear() {
        return fullYear;
    }

}
