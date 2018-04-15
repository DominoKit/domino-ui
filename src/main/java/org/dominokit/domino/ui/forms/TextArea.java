package org.dominokit.domino.ui.forms;

import elemental2.dom.CSSProperties;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.jboss.gwt.elemento.core.Elements;

public class TextArea extends ValueBox<TextArea, HTMLTextAreaElement, String> {

    private EventListener autosizeListener = evt -> adjustHeight();
    private int rows;

    public TextArea() {
        this("");
    }

    public TextArea(String placeholder) {
        super(placeholder);
        setRows(4);
    }

    @Override
    protected HTMLTextAreaElement createElement(String type, String placeholder) {
        return Elements.textarea().css("form-control no-resize")
                .attr("placeholder", placeholder).asElement();
    }

    public static TextArea create() {
        return new TextArea();
    }

    public static TextArea create(String placeholder) {
        return new TextArea(placeholder);
    }

    public TextArea setRows(int rows) {
        this.rows = rows;
        updateRows(rows);
        return this;
    }

    private void updateRows(int rows) {
        inputElement.setAttribute("rows", rows + "");
    }

    @Override
    public void setValue(String value) {
        inputElement.value = value;
    }

    @Override
    public String getValue() {
        return inputElement.value;
    }

    public TextArea autoSize() {
        inputElement.addEventListener("input", autosizeListener);
        inputElement.style.overflow = "hidden";
        updateRows(1);
        return this;
    }

    public TextArea fixedSize() {
        inputElement.removeEventListener("input", autosizeListener);
        inputElement.style.overflow = "";
        setRows(rows);
        return this;
    }

    private void adjustHeight() {
        inputElement.style.height = CSSProperties.HeightUnionType.of("auto");
        inputElement.style.height = CSSProperties.HeightUnionType.of(inputElement.scrollHeight + "px");
    }

    @Override
    public boolean isEmpty() {
        return getValue().isEmpty();
    }

    @Override
    public String getPlaceholder() {
        return inputElement.getAttribute("placeholder");
    }

    @Override
    public TextArea setPlaceholder(String placeholder) {
        inputElement.setAttribute("placeholder", placeholder);
        return this;
    }

    @Override
    public HTMLTextAreaElement getInputElement() {
        return inputElement;
    }

}