package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.LongBox;

public class LongHeaderFilter<T> extends DelayedHeaderFilterInput<LongBox, T> {

    private LongBox longBox;

    public LongHeaderFilter() {
    }

    public LongHeaderFilter(String placeholder) {
        super(placeholder);
    }

    public static <T> LongHeaderFilter<T> create() {
        return new LongHeaderFilter<>();
    }

    public static <T> LongHeaderFilter<T> create(String placeholder) {
        return new LongHeaderFilter<>(placeholder);
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return longBox.getInputElement().asElement();
    }

    @Override
    protected LongBox createValueBox() {
        this.longBox = LongBox.create();
        return this.longBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.longBox.isEmpty();
    }

    @Override
    protected String getValue() {
        return this.longBox.getValue()+"";
    }

    @Override
    protected FilterTypes getType() {
        return FilterTypes.LONG;
    }

    @Override
    public void clear() {
        longBox.pauseChangeHandlers();
        longBox.clear();
        longBox.getInputElement().asElement().value = "";
        longBox.resumeChangeHandlers();
    }
}
