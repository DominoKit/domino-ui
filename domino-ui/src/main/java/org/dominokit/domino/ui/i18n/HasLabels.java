package org.dominokit.domino.ui.i18n;

import org.dominokit.domino.ui.utils.DominoUIConfig;

public interface HasLabels<T extends Labels> {

    default T getLabels(){
        return (T) DominoUIConfig.CONFIG.getDominoUILabels();
    }
}
