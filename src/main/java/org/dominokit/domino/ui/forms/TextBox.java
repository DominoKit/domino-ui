package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.jboss.gwt.elemento.core.Elements;

public class TextBox extends ValueBox<TextBox, HTMLInputElement, String> {

    private static final String TEXT = "text";


    public TextBox() {
        this(TEXT, "");
    }

    public TextBox(String placeholder) {
        this(TEXT, placeholder);
    }

    public TextBox(String type, String placeholder) {
        super(type, placeholder);
    }

    @Override
    protected HTMLInputElement createElement(String type, String placeholder) {
        return Elements.input(type).css("form-control")
                .attr("placeholder", placeholder).asElement();
    }

    public static TextBox create() {
        return new TextBox();
    }

    public static TextBox create(String placeholder) {
        return new TextBox(placeholder);
    }

    public static TextBox password(String placeholder) {
        return new TextBox("password", placeholder);
    }

    @Override
    public boolean isEmpty() {
        return getValue().isEmpty();
    }

    @Override
    public void setValue(String value) {
        inputElement.value = value;
    }

    @Override
    public String getValue() {
        return inputElement.value;
    }

    @Override
    public String getPlaceholder() {
        return inputElement.placeholder;
    }

    @Override
    public TextBox setPlaceholder(String placeholder) {
        inputElement.placeholder = placeholder;
        return this;
    }

    public TextBox setType(String type) {
        inputElement.type = type;
        return this;
    }
}
