package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class TextBox extends AbstractTextBox<TextBox, HTMLInputElement> {

    private static final String TEXT = "text";

    public TextBox() {
        this(TEXT, "");
    }

    public TextBox(String label) {
        this(TEXT, label);
    }

    public TextBox(String type, String label) {
        super(type, label);
    }

    public static TextBox create() {
        return new TextBox();
    }

    public static TextBox create(String label) {
        return new TextBox(label);
    }

    public static TextBox password(String label) {
        return new TextBox("password", label);
    }

    public static TextBox password() {
        return new TextBox("password", "");
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    public boolean isEmpty() {
        return getValue().isEmpty();
    }

    @Override
    protected void clearValue() {
        setValue("");
    }

    @Override
    protected void doSetValue(String value) {
        getInputElement().value = value;
    }

    @Override
    public String getValue() {
        return getInputElement().value;
    }

    public TextBox setType(String type) {
        getInputElement().type = type;
        return this;
    }
}
