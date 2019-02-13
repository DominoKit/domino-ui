package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.FloatBox;

public class FloatHeaderFilter<T> extends DelayedHeaderFilterInput<FloatBox, T> {

    private FloatBox floatBox;

    public FloatHeaderFilter() {
    }

    public FloatHeaderFilter(String placeholder) {
        super(placeholder);
    }

    public static <T> FloatHeaderFilter<T> create() {
        return new FloatHeaderFilter<>();
    }

    public static <T> FloatHeaderFilter<T> create(String placeholder) {
        return new FloatHeaderFilter<>(placeholder);
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return floatBox.getInputElement().asElement();
    }

    @Override
    protected FloatBox createValueBox() {
        this.floatBox = FloatBox.create();
        return this.floatBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.floatBox.isEmpty();
    }

    @Override
    protected String getValue() {
        return this.floatBox.getValue()+"";
    }

    @Override
    protected FilterTypes getType() {
        return FilterTypes.FLOAT;
    }

    @Override
    public void clear() {
        floatBox.pauseChangeHandlers();
        floatBox.clear();
        floatBox.getInputElement().asElement().value = "";
        floatBox.resumeChangeHandlers();
    }
}
