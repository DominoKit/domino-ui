package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.Elements;

public class DoubleBox extends AbstractValueBox<DoubleBox, HTMLInputElement, Double> {

    private static final String TEXT = "text";

    public DoubleBox() {
        this(TEXT, "");
    }

    public DoubleBox(String label) {
        this(TEXT, label);
    }

    public DoubleBox(String type, String label) {
        super(type, label);
        init(this);
        ElementUtil.decimalOnly(this);
    }

    public static DoubleBox create() {
        return new DoubleBox();
    }

    public static DoubleBox create(String label) {
        return new DoubleBox(label);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void clearValue() {
        withValue(0.0);
    }

    @Override
    protected void doSetValue(Double value) {
        getInputElement().asElement().value = Double.toString(value);
    }

    @Override
    public Double value() {
        return Double.parseDouble(getInputElement().asElement().value);
    }

    public DoubleBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return Double.toString(value());
    }
}
