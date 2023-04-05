package org.dominokit.domino.ui.i18n;

public interface PickersLabels extends Labels {

    default String clear(){
        return "CLEAR";
    }

    default String now(){
        return "NOW";
    }

    default String close(){
        return "CLOSE";
    }

}
