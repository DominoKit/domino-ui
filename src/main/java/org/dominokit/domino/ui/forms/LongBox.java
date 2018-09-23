package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.Elements;

public class LongBox extends AbstractValueBox<LongBox, HTMLInputElement, Long> {

    private static final String TEXT = "text";

    public LongBox() {
        this(TEXT, "");
    }

    public LongBox(String label) {
        this(TEXT, label);
    }

    public LongBox(String type, String label) {
        super(type, label);
        init(this);
        ElementUtil.numbersOnly(this);
    }

    public static LongBox create() {
        return new LongBox();
    }

    public static LongBox create(String label) {
        return new LongBox(label);
    }

    @Override
    protected HTMLInputElement createInputElement(String type) {
        return Elements.input(type).css("form-control").asElement();
    }

    @Override
    protected void clearValue() {
        withValue(0L);
    }

    @Override
    protected void doSetValue(Long value) {
        getInputElement().asElement().value = Long.toString(value);
    }

    @Override
    public Long value() {
        return Long.parseLong(getInputElement().asElement().value);
    }

    public LongBox setType(String type) {
        getInputElement().asElement().type = type;
        return this;
    }

    @Override
    public String getStringValue() {
        return Long.toString(value());
    }
}
