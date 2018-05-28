package org.dominokit.domino.ui.forms;

import elemental2.dom.CSSProperties;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class TextArea extends AbstractTextBox<TextArea, HTMLTextAreaElement> {

    private EventListener autosizeListener = evt -> adjustHeight();
    private int rows;

    public TextArea() {
        this("");
    }

    public TextArea(String label) {
        super("", label);
        setRows(4);
    }

    public static TextArea create() {
        return new TextArea();
    }

    public static TextArea create(String label) {
        return new TextArea(label);
    }

    @Override
    protected HTMLTextAreaElement createInputElement(String type) {
        return Elements.textarea().css("form-control no-resize").asElement();
    }

    public TextArea setRows(int rows) {
        this.rows = rows;
        updateRows(rows);
        return this;
    }

    private void updateRows(int rows) {
        getInputElement().setAttribute("rows", rows + "");
    }

    @Override
    public void setValue(String value) {
        getInputElement().value = value;
        if (nonNull(value) && !value.isEmpty())
            floatLabel();
        else
            unfloatLabel();
    }

    @Override
    protected void clearValue() {
        setValue("");
    }

    @Override
    public String getValue() {
        return getInputElement().value;
    }

    public TextArea autoSize() {
        getInputElement().addEventListener("input", autosizeListener);
        getInputElement().style.overflow = "hidden";
        updateRows(1);
        return this;
    }

    public TextArea fixedSize() {
        getInputElement().removeEventListener("input", autosizeListener);
        getInputElement().style.overflow = "";
        setRows(rows);
        return this;
    }

    private void adjustHeight() {
        getInputElement().style.height = CSSProperties.HeightUnionType.of("auto");
        getInputElement().style.height = CSSProperties.HeightUnionType.of(getInputElement().scrollHeight + "px");
    }

    @Override
    public boolean isEmpty() {
        return getValue().isEmpty();
    }
}