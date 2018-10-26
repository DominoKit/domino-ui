package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.ShortBox;

public class ShortHeaderFilter<T> extends DelayedHeaderFilterInput<ShortBox, T> {

    private ShortBox shortBox;

    public static <T> ShortHeaderFilter<T> create() {
        return new ShortHeaderFilter<>();
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return shortBox.getInputElement().asElement();
    }

    @Override
    protected ShortBox createValueBox() {
        this.shortBox = ShortBox.create();
        return this.shortBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.shortBox.isEmpty();
    }

    @Override
    protected String getValue() {
        return this.shortBox.getValue()+"";
    }

    @Override
    protected FilterTypes getType() {
        return FilterTypes.SHORT;
    }

    @Override
    public void clear() {
        shortBox.pauseChangeHandlers();
        shortBox.clear();
        shortBox.getInputElement().asElement().value = "";
        shortBox.resumeChangeHandlers();
    }
}
