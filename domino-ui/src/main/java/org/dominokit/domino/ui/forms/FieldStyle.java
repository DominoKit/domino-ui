package org.dominokit.domino.ui.forms;

public interface FieldStyle {

    FieldStyle ROUNDED = () -> "rounded";

    FieldStyle LINED = () -> "lined";


    String getStyle();

    default void apply(ValueBox valueBox){
        FieldStyle fieldStyle = valueBox.getFieldStyle();
        valueBox.removeCss(fieldStyle.getStyle());
        valueBox.css(getStyle());
    }
}
