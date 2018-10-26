package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.DoubleBox;

public class DoubleHeaderFilter<T> extends DelayedHeaderFilterInput<DoubleBox, T> {

    private DoubleBox doubleBox;

    public static <T> DoubleHeaderFilter<T> create() {
        return new DoubleHeaderFilter<>();
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return doubleBox.getInputElement().asElement();
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
        doubleBox.getInputElement().asElement().value = "";
        doubleBox.resumeChangeHandlers();
    }
}
