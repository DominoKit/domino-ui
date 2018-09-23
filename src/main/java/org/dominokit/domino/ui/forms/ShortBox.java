package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.Elements;

public class ShortBox extends AbstractValueBox<ShortBox, HTMLInputElement, Short> {

    private static final String TEXT = "text";

    public ShortBox() {
        this(TEXT, "");
    }

    public ShortBox(String label) {
        this(TEXT, label);
    }

    public ShortBox(String type, String label) {
        super(type, label);
        init(this);
        ElementUtil.numbersOnly(this);
    }

    public static ShortBox create() {
        return new ShortBox();
    }

    public static ShortBox create(String label) {
        return new ShortBox(label);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void clearValue() {
        withValue((short)0);
    }

    @Override
    protected void doSetValue(Short value) {
        getInputElement().asElement().value = Short.toString(value);
    }

    @Override
    public Short value() {
        return Short.parseShort(getInputElement().asElement().value);
    }

    public ShortBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return Short.toString(value());
    }
}
