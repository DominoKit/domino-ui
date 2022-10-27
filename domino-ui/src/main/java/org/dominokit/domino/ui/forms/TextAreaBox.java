package org.dominokit.domino.ui.forms;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLTextAreaElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.*;

public class TextAreaBox extends CountableInputFormField<TextAreaBox, HTMLTextAreaElement, String>{

    private EventListener autosizeListener = evt -> adjustHeight();
    private int rows;
    private boolean autoSize = false;

    public static TextAreaBox create(){
        return new TextAreaBox();
    }

    public static TextAreaBox create(String label){
        return new TextAreaBox(label);
    }

    public TextAreaBox() {
        setRows(4);
        addCss(FORM_TEXT_AREA);
        wrapperElement.appendChild(DominoElement.div().addCss(FORM_TEXT_AREA_GAP));
        onAttached(mutationRecord -> adjustHeight());
        setDefaultValue("");
        getInputElement().setAttribute("data-scroll", "0");
        getInputElement().addEventListener("scroll", evt -> getInputElement().element().setAttribute("data-scroll", getInputElement().element().scrollTop));
    }

    public TextAreaBox(String label) {
        this();
        setLabel(label);
    }

    public TextAreaBox setRows(int rows) {
        this.rows = rows;
        updateRows(rows);
        return this;
    }

    private void updateRows(int rows) {
        getInputElement().setAttribute("rows", rows + "");
    }

    @Override
    public String getStringValue() {
        return getValue();
    }

    @Override
    protected DominoElement<HTMLTextAreaElement> createInputElement(String type) {
        return DominoElement.textarea()
                .addCss(FIELD_INPUT);
    }

    /** {@inheritDoc} */
    @Override
    protected void doSetValue(String value) {
        if (nonNull(value)) {
            getInputElement().element().value = value;
            if (isAttached()) {
                adjustHeight();
            }
        } else {
            getInputElement().element().value = "";
        }
    }

    /**
     * The TextArea will start with initial number of rows and will automatically grow if more lines
     * are added instead of showing scrollbars
     */
    public TextAreaBox autoSize() {
        getInputElement().addEventListener("input", autosizeListener);
        getInputElement().style().setOverFlow("hidden");
        updateRows(1);
        this.autoSize = true;
        return this;
    }

    /**
     * The TextArea will show scrollbars when the text rows exceeds the rows from {@link
     * #setRows(int)}
     *
     * @return same TextArea instance
     */
    public TextAreaBox fixedSize() {
        getInputElement().removeEventListener("input", autosizeListener);
        getInputElement().style().setOverFlow("");
        setRows(rows);
        this.autoSize = false;
        return this;
    }

    private void adjustHeight() {
        getInputElement().style().setHeight("auto");
        int scrollHeight = getInputElement().element().scrollHeight;
        if (scrollHeight < 30) {
            scrollHeight = 22;
        }
        if (autoSize) {
            getInputElement().style().setHeight(scrollHeight + "px");
        }
    }

    @Override
    public String getType() {
        return "text";
    }

    @Override
    public String getValue() {
        String value = getInputElement().element().value;
        if (value.isEmpty() && isEmptyAsNull()) {
            return null;
        }
        return value;
    }

    @Override
    public String getName() {
        return getInputElement().element().name;
    }

    @Override
    public TextAreaBox setName(String name) {
        getInputElement().element().name = name;
        return this;
    }
}
