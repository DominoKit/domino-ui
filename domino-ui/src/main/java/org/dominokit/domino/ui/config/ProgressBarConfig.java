package org.dominokit.domino.ui.config;

public interface ProgressBarConfig extends ComponentConfig {

    default String getDefaultProgressExpression(){
        return "{percent}%";
    }

    default String evaluateProgressBarExpression(String expression, int percent, double value, double maxValue){
        return expression
                .replace("{percent}", percent + "")
                .replace("{value}", value + "")
                .replace("{maxValue}", maxValue + "");
    }
}
