package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.jboss.elemento.Elements;

import static java.util.Objects.nonNull;

/**
 * A component that take/provide a single line String values
 */
public class TextBox extends AbstractValueBox<TextBox, HTMLInputElement, String> {

    private static final String TEXT = "text";
    private boolean emptyAsNull;

    /**
     *
     */
    public TextBox() {
        this(TEXT, "");
    }

    /**
     *
     * @param label String
     */
    public TextBox(String label) {
        this(TEXT, label);
    }

    /**
     *
     * @param type String html input element type
     * @param label String
     */
    public TextBox(String type, String label) {
        super(type, label);
    }

    /**
     *
     * @return new TextBox instance
     */
    public static TextBox create() {
        return new TextBox();
    }

    /**
     *
     * @param label String
     * @return new TextBox instance
     */
    public static TextBox create(String label) {
        return new TextBox(label);
    }

    /**
     * Creates a password field, input type <b>password</b>
     * @param label String label
     * @return  new TextBox instance
     */
    public static TextBox password(String label) {
        return new TextBox("password", label);
    }

    /**
     * Creates a password field, input type <b>password</b>
     * @return  new TextBox instance
     */
    public static TextBox password() {
        return new TextBox("password", "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void clearValue() {
        value("");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().element().value = value;
        } else {
            getInputElement().element().value = "";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        String value = getInputElement().element().value;
        if (value.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return value;
    }

    /**
     *
     * @param type String html input type
     * @return same TextBox instance
     */
    public TextBox setType(String type) {
        getInputElement().element().type = type;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getStringValue() {
        return getValue();
    }

    /**
     *
     * @param emptyAsNull boolean, if true empty value will be considered null otherwise its normal empty String
     * @return same TextBox instance
     */
    public TextBox setEmptyAsNull(boolean emptyAsNull) {
        this.emptyAsNull = emptyAsNull;
        return this;
    }

    /**
     *
     * @return boolean, true is {@link #setEmptyAsNull(boolean)}
     */
    public boolean isEmptyAsNull() {
        return emptyAsNull;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new InputAutoValidator<>(getInputElement(), autoValidate);
    }
}
