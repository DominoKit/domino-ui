package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.jboss.gwt.elemento.core.Elements;

public class TextBox extends AbstractValueBox<TextBox, HTMLInputElement, String> {

    private static final String TEXT = "text";

    public TextBox() {
        this(TEXT, "");
    }

    public TextBox(String label) {
        this(TEXT, label);
    }

    public TextBox(String type, String label) {
        super(type, label);
        init(this);
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
    protected void clearValue() {
        value("");
    }

    @Override
    protected void doSetValue(String value) {
        getInputElement().asElement().value = value;
    }

    @Override
    public String getValue() {
        return getInputElement().asElement().value;
    }

    public TextBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return getValue();
    }
}
