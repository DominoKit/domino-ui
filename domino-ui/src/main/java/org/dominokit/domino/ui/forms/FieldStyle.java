package org.dominokit.domino.ui.forms;

/**
 * An enum to list the types of fields styles
 */
public interface FieldStyle {

    /**
     * Fields are styles with rounded borders
     */
    FieldStyle ROUNDED = () -> "rounded";

    /**
     * Fields are styles with bottom border line and greyed boxed area.
     * this is the default style
     */
    FieldStyle LINED = () -> "lined";


    /**
     *
     * @return String name of the style css class
     */
    String getStyle();

    /**
     * Applies the style on an element
     * @param valueBox {@link ValueBox}
     */
    default void apply(ValueBox valueBox){
        FieldStyle fieldStyle = valueBox.getFieldStyle();
        valueBox.removeCss(fieldStyle.getStyle());
        valueBox.css(getStyle());
    }
}
