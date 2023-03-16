package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.utils.DominoUIConfig;

public interface HasComponentConfig<T extends ComponentConfig> {
    default T getConfig() {
        return (T) DominoUIConfig.CONFIG.getUIConfig();
    }
}
