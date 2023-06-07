package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;

import java.util.function.Supplier;

public interface SpinConfig extends ComponentConfig {

    default Supplier<Icon<?>> getDefaultBackIconSupplier(){
        return Icons::chevron_left;
    }

    default Supplier<Icon<?>> getDefaultForwardIconSupplier(){
        return Icons::chevron_right;
    }

    default Supplier<Icon<?>> getDefaultUpIconSupplier(){
        return Icons::chevron_up;
    }

    default Supplier<Icon<?>> getDefaultDownIconSupplier(){
        return Icons::chevron_down;
    }
}
