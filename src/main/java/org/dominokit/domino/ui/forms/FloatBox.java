package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.Elements;

public class FloatBox extends AbstractValueBox<FloatBox, HTMLInputElement, Float> {

    private static final String TEXT = "text";

    public FloatBox() {
        this(TEXT, "");
    }

    public FloatBox(String label) {
        this(TEXT, label);
    }

    public FloatBox(String type, String label) {
        super(type, label);
        init(this);
        ElementUtil.decimalOnly(this);
    }

    public static FloatBox create() {
        return new FloatBox();
    }

    public static FloatBox create(String label) {
        return new FloatBox(label);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void clearValue() {
        withValue(0.0F);
    }

    @Override
    protected void doSetValue(Float value) {
        getInputElement().asElement().value = Float.toString(value);
    }

    @Override
    public Float value() {
        return Float.parseFloat(getInputElement().asElement().value);
    }

    public FloatBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return Float.toString(value());
    }
}
