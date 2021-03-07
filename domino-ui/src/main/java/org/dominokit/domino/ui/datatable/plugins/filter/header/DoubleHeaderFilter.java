package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.BigDecimalBox;
import org.dominokit.domino.ui.forms.DoubleBox;

/**
 * BigDecimal column header filter component that is rendered as a {@link DoubleBox} component
 * @param <T> type of data table records
 */
public class DoubleHeaderFilter<T> extends DelayedHeaderFilterInput<DoubleBox, T> {

    private DoubleBox doubleBox;

    /**
     * Default constructor
     */
    public DoubleHeaderFilter() {
    }

    /**
     * Create and instance with custom placeholder
     * @param placeholder String
     */
    public DoubleHeaderFilter(String placeholder) {
        super(placeholder);
    }

    /**
     * create a new instance
     */
    public static <T> DoubleHeaderFilter<T> create() {
        return new DoubleHeaderFilter<>();
    }

    /**
     * creates a new instance with custom placeholder
     * @param placeholder String
     * @param <T> type of the data table records
     * @return new instance
     */
    public static <T> DoubleHeaderFilter<T> create(String placeholder) {
        return new DoubleHeaderFilter<>(placeholder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement getInputElement() {
        return doubleBox.getInputElement().element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected DoubleBox createValueBox() {
        this.doubleBox = DoubleBox.create();
        return this.doubleBox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEmpty() {
        return this.doubleBox.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getValue() {
        return this.doubleBox.getValue() + "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FilterTypes getType() {
        return FilterTypes.DOUBLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        doubleBox.pauseChangeHandlers();
        doubleBox.clear();
        doubleBox.getInputElement().element().value = "";
        doubleBox.resumeChangeHandlers();
    }

    /**
     *
     * @return the {@link DoubleBox} wrapped in this component
     */
    public DoubleBox getDoubleBox() {
        return doubleBox;
    }
}
