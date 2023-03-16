package org.dominokit.domino.ui.i18n;

public interface SearchLabels extends Labels {
    default String getStartTyping(){
        return "START TYPING...";
    }
}
