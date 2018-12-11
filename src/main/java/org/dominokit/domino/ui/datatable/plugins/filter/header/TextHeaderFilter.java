package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.TextBox;

public class TextHeaderFilter<T> extends DelayedHeaderFilterInput<TextBox, T>{

    private TextBox textBox;

    public TextHeaderFilter() {
    }

    public TextHeaderFilter(String placeholder) {
        super(placeholder);
    }

    public static <T> TextHeaderFilter<T> create() {
        return new TextHeaderFilter<>();
    }

    public static <T> TextHeaderFilter<T> create(String placeholder) {
        return new TextHeaderFilter<>(placeholder);
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return this.textBox.getInputElement().asElement();
    }

    @Override
    protected TextBox createValueBox() {
        this.textBox = TextBox.create();
        return this.textBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.textBox.isEmpty();
    }

    @Override
    protected String getValue() {
        return this.textBox.getValue();
    }

    public TextBox getTextBox() {
        return textBox;
    }

    @Override
    protected FilterTypes getType() {
        return FilterTypes.STRING;
    }

    @Override
    public void clear() {
        textBox.pauseChangeHandlers();
        textBox.clear();
        textBox.resumeChangeHandlers();
    }
}
