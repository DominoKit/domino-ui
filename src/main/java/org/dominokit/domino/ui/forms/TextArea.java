package org.dominokit.domino.ui.forms;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.jboss.gwt.elemento.core.Elements;

public class TextArea extends AbstractValueBox<TextArea, HTMLTextAreaElement, String> {

    private EventListener autosizeListener = evt -> adjustHeight();
    private int rows;

    public TextArea() {
        this("");
        init(this);
    }

    public TextArea(String label) {
        super("", label);
        setRows(4);
        init(this);
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
    protected void doSetValue(String value) {
        getInputElement().asElement().value = value;
    }

    @Override
    protected void clearValue() {
        withValue("");
    }

    @Override
    public String value() {
        return getInputElement().asElement().value;
    }

    public TextArea autoSize() {
        getInputElement().addEventListener("input", autosizeListener);
        getInputElement().style().setOverFlow("hidden");
        updateRows(1);
        return this;
    }

    public TextArea fixedSize() {
        getInputElement().removeEventListener("input", autosizeListener);
        getInputElement().style().setOverFlow("");
        setRows(rows);
        return this;
    }

    private void adjustHeight() {
        getInputElement().style().setHeight("auto");
        getInputElement().style().setHeight(getInputElement().asElement().scrollHeight + "px");
    }

    @Override
    public String getStringValue() {
        return value();
    }
}