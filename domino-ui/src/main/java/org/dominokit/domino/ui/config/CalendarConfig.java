package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;

import java.util.function.Supplier;

public interface CalendarConfig extends ComponentConfig {

    default Supplier<Icon<?>> defaultCalendarNextIcon(){
        return Icons::chevron_right;
    }
    default Supplier<Icon<?>> defaultCalendarPreviousIcon(){
        return Icons::chevron_left;
    }

    default Supplier<Icon<?>> defaultDateBoxIcon(){
        return Icons::calendar;
    }
}
