package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.FIELD_INPUT;

public class TextBox extends TextInputFormField<TextBox, HTMLInputElement, String> {

    public static TextBox create(){
        return new TextBox();
    }

    public static TextBox create(String label){
        return new TextBox(label);
    }

    public TextBox() {
        setDefaultValue("");
    }

    public TextBox(String label) {
        this();
        setLabel(label);
    }

    @Override
    public String getType() {
        return "text";
    }

    @Override
    protected DominoElement<HTMLInputElement> createInputElement(String type) {
        return DominoElement.input(type)
                .addCss(FIELD_INPUT);
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
