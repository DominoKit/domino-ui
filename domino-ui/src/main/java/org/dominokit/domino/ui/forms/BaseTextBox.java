package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.elements.DataListElement;
import org.dominokit.domino.ui.elements.OptionElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public abstract class BaseTextBox<T extends BaseTextBox<T>> extends TextInputFormField<T, HTMLInputElement, String> {

    public BaseTextBox() {
        setDefaultValue("");
    }

    public BaseTextBox(String label) {
        this();
        setLabel(label);
    }

    @Override
    protected DominoElement<HTMLInputElement> createInputElement(String type) {
        return input(type).addCss(dui_field_input).toDominoElement();
    }

    @Override
    public String getStringValue() {
        return getValue();
    }

    @Override
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().element().value = value;
        } else {
            getInputElement().element().value = "";
        }
    }

    @Override
    public String getValue() {
        String value = getInputElement().element().value;
        if (value.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return value;
    }
}
