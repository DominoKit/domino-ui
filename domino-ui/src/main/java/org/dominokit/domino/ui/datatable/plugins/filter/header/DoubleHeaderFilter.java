package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.DoubleBox;

public class DoubleHeaderFilter<T> extends DelayedHeaderFilterInput<DoubleBox, T> {

    private DoubleBox doubleBox;

    public DoubleHeaderFilter() {
    }

    public DoubleHeaderFilter(String placeholder) {
        super(placeholder);
    }

    public static <T> DoubleHeaderFilter<T> create() {
        return new DoubleHeaderFilter<>();
    }

    public static <T> DoubleHeaderFilter<T> create(String placeholder) {
        return new DoubleHeaderFilter<>(placeholder);
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return doubleBox.getInputElement().element();
    }

    @Override
    protected DoubleBox createValueBox() {
        this.doubleBox = DoubleBox.create();
        return this.doubleBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.doubleBox.isEmpty();
    }

    @Override
    protected String getValue() {
        return this.doubleBox.getValue() + "";
    }

    @Override
    protected FilterTypes getType() {
        return FilterTypes.DOUBLE;
    }

    @Override
    public void clear() {
        doubleBox.pauseChangeHandlers();
        doubleBox.clear();
        doubleBox.getInputElement().element().value = "";
        doubleBox.resumeChangeHandlers();
    }
}
