package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.BigDecimalBox;

public class DecimalHeaderFilter<T> extends DelayedHeaderFilterInput<BigDecimalBox, T> {

    private BigDecimalBox decimalBox;

    public static <T> DecimalHeaderFilter<T> create() {
        return new DecimalHeaderFilter<>();
    }

    @Override
    protected HTMLInputElement getInputElement() {
        return decimalBox.getInputElement().asElement();
    }

    @Override
    protected BigDecimalBox createValueBox() {
        this.decimalBox = BigDecimalBox.create();
        return this.decimalBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.decimalBox.isEmpty();
    }

    @Override
    protected String getValue() {
        return this.decimalBox.getValue()+"";
    }

    @Override
    protected FilterTypes getType() {
        return FilterTypes.DECIMAL;
    }

    @Override
    public void clear() {
        decimalBox.pauseChangeHandlers();
        decimalBox.clear();
        decimalBox.getInputElement().asElement().value = "";
        decimalBox.resumeChangeHandlers();
    }
}
