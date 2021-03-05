package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.forms.BigDecimalBox;

/**
 * BigDecimal column header filter component that is rendered as a {@link BigDecimalBox} component
 * @param <T> type of data table records
 */
public class DecimalHeaderFilter<T> extends DelayedHeaderFilterInput<BigDecimalBox, T> {

    private BigDecimalBox decimalBox;

    public DecimalHeaderFilter() {
    }

    /**
     * Create and instance with custom placeholder
     * @param placeholder String
     */
    public DecimalHeaderFilter(String placeholder) {
        super(placeholder);
    }

    /**
     * create a new instance
     */
    public static <T> DecimalHeaderFilter<T> create() {
        return new DecimalHeaderFilter<>();
    }

    /**
     * creates a new instance with custom placeholder
     * @param placeholder String
     * @param <T> type of the data table records
     * @return new instance
     */
    public static <T> DecimalHeaderFilter<T> create(String placeholder) {
        return new DecimalHeaderFilter<>(placeholder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement getInputElement() {
        return decimalBox.getInputElement().element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigDecimalBox createValueBox() {
        this.decimalBox = BigDecimalBox.create();
        return this.decimalBox;
    }

    @Override
    protected boolean isEmpty() {
        return this.decimalBox.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getValue() {
        return this.decimalBox.getValue()+"";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FilterTypes getType() {
        return FilterTypes.DECIMAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        decimalBox.pauseChangeHandlers();
        decimalBox.clear();
        decimalBox.getInputElement().element().value = "";
        decimalBox.resumeChangeHandlers();
    }

    /**
     *
     * @return the {@link BigDecimalBox} wrapped inside this filter component
     */
    public BigDecimalBox getDecimalBox() {
        return decimalBox;
    }
}
