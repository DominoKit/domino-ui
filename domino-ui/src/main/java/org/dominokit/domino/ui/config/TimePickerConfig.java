package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;

import java.util.function.Supplier;

public interface TimePickerConfig extends ComponentConfig {
    default Supplier<Icon<?>> defaultTimeBoxIcon(){
        return Icons::clock_outline;
    }
}
