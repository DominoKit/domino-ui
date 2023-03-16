package org.dominokit.domino.ui.config;

public interface SearchConfig extends ComponentConfig {

    default int getAutoSearchDelay(){
        return 200;
    }
}
