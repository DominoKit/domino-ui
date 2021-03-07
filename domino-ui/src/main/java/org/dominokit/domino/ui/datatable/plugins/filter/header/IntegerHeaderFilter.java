package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.IntegerBox;

/**
 * Integer number column header filter component that is rendered as a {@link IntegerBox} component
 * @param <T> type of data table records
 */
public class IntegerHeaderFilter<T> extends DelayedHeaderFilterInput<IntegerBox, T> {

    private IntegerBox integerBox;

    /**
     * Default constructor
     */
    public IntegerHeaderFilter() {
    }

    /**
     * Create and instance with custom placeholder
     * @param placeholder String
     */
    public IntegerHeaderFilter(String placeholder) {
        super(placeholder);
    }

    /**
     * create a new instance
     */
    public static <T> IntegerHeaderFilter<T> create() {
        return new IntegerHeaderFilter<>();
    }

    /**
     * creates a new instance with custom placeholder
     * @param placeholder String
     * @param <T> type of the data table records
     * @return new instance
     */
    public static <T> IntegerHeaderFilter<T> create(String placeholder) {
        return new IntegerHeaderFilter<>(placeholder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement getInputElement() {
        return integerBox.getInputElement().element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IntegerBox createValueBox() {
        this.integerBox = IntegerBox.create();
        return this.integerBox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEmpty() {
        return this.integerBox.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getValue() {
        return this.integerBox.getValue()+"";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FilterTypes getType() {
        return FilterTypes.INTEGER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        integerBox.pauseChangeHandlers();
        integerBox.clear();
        integerBox.getInputElement().element().value = "";
        integerBox.resumeChangeHandlers();
    }

    /**
     *
     * @return the {@link IntegerBox} wrapped in this component
     */
    public IntegerBox getIntegerBox() {
        return integerBox;
    }
}
