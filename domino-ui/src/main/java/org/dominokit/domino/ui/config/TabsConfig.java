package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;

import java.util.function.Supplier;

public interface TabsConfig extends ComponentConfig {

    default Supplier<Icon<?>> getDefaultTabCloseIcon(){
        return Icons.ALL::close_mdi;
    }
}
