package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;

import java.util.function.Supplier;

public interface SpinConfig extends ComponentConfig {

    default Supplier<Icon<?>> getDefaultBackIconSupplier(){
        return Icons.ALL::chevron_left_mdi;
    }

    default Supplier<Icon<?>> getDefaultForwardIconSupplier(){
        return Icons.ALL::chevron_right_mdi;
    }

    default Supplier<Icon<?>> getDefaultUpIconSupplier(){
        return Icons.ALL::chevron_up_mdi;
    }

    default Supplier<Icon<?>> getDefaultDownIconSupplier(){
        return Icons.ALL::chevron_down_mdi;
    }
}
