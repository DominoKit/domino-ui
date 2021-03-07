package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.FloatBox;

/**
 * Float number column header filter component that is rendered as a {@link FloatBox} component
 * @param <T> type of data table records
 */
public class FloatHeaderFilter<T> extends DelayedHeaderFilterInput<FloatBox, T> {

    private FloatBox floatBox;

    /**
     * Default constructor
     */
    public FloatHeaderFilter() {
    }

    /**
     * Create and instance with custom placeholder
     * @param placeholder String
     */
    public FloatHeaderFilter(String placeholder) {
        super(placeholder);
    }

    /**
     * create a new instance
     */
    public static <T> FloatHeaderFilter<T> create() {
        return new FloatHeaderFilter<>();
    }

    /**
     * creates a new instance with custom placeholder
     * @param placeholder String
     * @param <T> type of the data table records
     * @return new instance
     */
    public static <T> FloatHeaderFilter<T> create(String placeholder) {
        return new FloatHeaderFilter<>(placeholder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement getInputElement() {
        return floatBox.getInputElement().element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FloatBox createValueBox() {
        this.floatBox = FloatBox.create();
        return this.floatBox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEmpty() {
        return this.floatBox.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getValue() {
        return this.floatBox.getValue()+"";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FilterTypes getType() {
        return FilterTypes.FLOAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        floatBox.pauseChangeHandlers();
        floatBox.clear();
        floatBox.getInputElement().element().value = "";
        floatBox.resumeChangeHandlers();
    }

    /**
     *
     * @return the {@link FloatBox} wrapped in this component
     */
    public FloatBox getFloatBox() {
        return floatBox;
    }
}
