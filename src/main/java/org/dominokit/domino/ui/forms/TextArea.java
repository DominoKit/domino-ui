package org.dominokit.domino.ui.forms;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class TextArea extends AbstractValueBox<TextArea, HTMLTextAreaElement, String> {

    private EventListener autosizeListener = evt -> adjustHeight();
    private int rows;
    private boolean autoSize = false;

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
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().asElement().value = value;
            if (autoSize) {
                if (isAttached()) {
                    adjustHeight();
                } else {
                    onAttached(mutationRecord -> adjustHeight());
                }
            }
        } else {
            getInputElement().asElement().value = "";
        }
    }

    @Override
    protected void clearValue() {
        value("");
    }

    @Override
    public String getValue() {
        return getInputElement().asElement().value;
    }

    public TextArea autoSize() {
        getInputElement().addEventListener("input", autosizeListener);
        getInputElement().style().setOverFlow("hidden");
        updateRows(1);
        this.autoSize = true;
        return this;
    }

    public TextArea fixedSize() {
        getInputElement().removeEventListener("input", autosizeListener);
        getInputElement().style().setOverFlow("");
        setRows(rows);
        this.autoSize = false;
        return this;
    }

    private void adjustHeight() {
        getInputElement().style().setHeight("auto");
        int scrollHeight = getInputElement().asElement().scrollHeight;
        if (scrollHeight < 34) {
            scrollHeight = 34;
        }
        getInputElement().style().setHeight(scrollHeight + "px");
    }

    @Override
    public String getStringValue() {
        return getValue();
    }
}