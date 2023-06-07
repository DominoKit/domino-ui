package org.dominokit.domino.ui.datepicker;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.nonNull;

public class CalendarInitConfig {

    private final Set<CalendarPlugin> plugins = new HashSet<>();
    public CalendarInitConfig() {
    }

    public static CalendarInitConfig create(){
        return new CalendarInitConfig();
    }

    public CalendarInitConfig addPlugin(CalendarPlugin plugin){
        if(nonNull(plugin)){
            this.plugins.add(plugin);
        }
        return this;
    }
    public CalendarInitConfig removePlugin(CalendarPlugin plugin){
        if(nonNull(plugin)){
            this.plugins.remove(plugin);
        }
        return this;
    }

    public Set<CalendarPlugin> getPlugins() {
        return plugins;
    }
}
