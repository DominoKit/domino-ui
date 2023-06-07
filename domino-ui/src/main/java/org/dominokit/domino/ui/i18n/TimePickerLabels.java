package org.dominokit.domino.ui.i18n;

public interface TimePickerLabels extends Labels {
    default String hour(){
        return "Hour";
    }

    default String minute(){
        return "Minutes";
    }

    default String seconds(){
        return "Seconds";
    }

    default String ampm(){
        return "AM/PM";
    }

    default String timePickerInvalidTimeFormat(){
        return "Invalid time format";
    }
}
