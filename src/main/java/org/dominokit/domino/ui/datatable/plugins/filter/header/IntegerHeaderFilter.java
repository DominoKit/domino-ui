package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.IntegerBox;

public class IntegerHeaderFilter<T> extends DelayedHeaderFilterInput<IntegerBox, T> {

    private IntegerBox integerBox;

    public IntegerHeaderFilter() {
    }

    public IntegerHeaderFilter(String placeholder) {
        super(placeholder);
    }

    public static <T> IntegerHeaderFilter<T> create() {
        return new IntegerHeaderFilter<>();
    }

    public static <T> IntegerHeaderFilter<T> create(String placeholder) {
        return new IntegerHeaderFilter<>(placeholder);
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return integerBox.getInputElement().asElement();
    }

    @Override
    protected IntegerBox createValueBox() {
        this.integerBox = IntegerBox.create();
        return this.integerBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.integerBox.isEmpty();
    }

    @Override
    protected String getValue() {
        return this.integerBox.getValue()+"";
    }

    @Override
    protected FilterTypes getType() {
        return FilterTypes.INTEGER;
    }

    @Override
    public void clear() {
        integerBox.pauseChangeHandlers();
        integerBox.clear();
        integerBox.getInputElement().asElement().value = "";
        integerBox.resumeChangeHandlers();
    }
}
