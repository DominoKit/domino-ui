package org.dominokit.domino.ui.forms;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class TextArea extends AbstractValueBox<TextArea, HTMLTextAreaElement, String> {

    private EventListener autosizeListener = evt -> adjustHeight();
    private int rows;
    private boolean autoSize = false;
    private boolean emptyAsNull;
    private boolean floating;

    public TextArea() {
        this("");
    }

    public TextArea(String label) {
        super("", label);
        setRows(4);
        css("auto-height");
        onAttached(mutationRecord -> adjustHeight());
    }

    public static TextArea create() {
        return new TextArea();
    }

    public static TextArea create(String label) {
        return new TextArea(label);
    }

    @Override
    protected HTMLTextAreaElement createInputElement(String type) {
        return Elements.textarea().css("no-resize").asElement();
    }

    public TextArea setRows(int rows) {
        this.rows = rows;
        updateRows(rows);
        return this;
    }

    private void updateRows(int rows) {
        if (rows > 1) {
            floating = isFloating();
            floating();
        } else {
            if (floating) {
                floating();
            } else {
                nonfloating();
            }
        }
        getInputElement().setAttribute("rows", rows + "");
    }

    @Override
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().asElement().value = value;
                if (isAttached()) {
                    adjustHeight();
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
        String value = getInputElement().asElement().value;
        if (value.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return value;
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
        if (scrollHeight < 30) {
            scrollHeight = 22;
        }
        if (autoSize) {
            getInputElement().style().setHeight(scrollHeight + "px");
        }
    }

    @Override
    public String getStringValue() {
        return getValue();
    }

    public TextArea setEmptyAsNull(boolean emptyAsNull) {
        this.emptyAsNull = emptyAsNull;
        return this;
    }

    public boolean isEmptyAsNull() {
        return emptyAsNull;
    }

    @Override
    protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
        return new InputAutoValidator<>(getInputElement(), autoValidate);
    }

}