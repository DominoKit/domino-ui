package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.forms.DoubleBox;
import org.dominokit.domino.ui.forms.LongBox;
/**
 * Long column header filter component that is rendered as a {@link LongBox} component
 * @param <T> type of data table records
 */
public class LongHeaderFilter<T> extends DelayedHeaderFilterInput<LongBox, T> {

    private LongBox longBox;

    /**
     * Default constructor
     */
    public LongHeaderFilter() {
    }

    /**
     * Create and instance with custom placeholder
     * @param placeholder String
     */
    public LongHeaderFilter(String placeholder) {
        super(placeholder);
    }

    /**
     * create a new instance
     */
    public static <T> LongHeaderFilter<T> create() {
        return new LongHeaderFilter<>();
    }

    /**
     * creates a new instance with custom placeholder
     * @param placeholder String
     * @param <T> type of the data table records
     * @return new instance
     */
    public static <T> LongHeaderFilter<T> create(String placeholder) {
        return new LongHeaderFilter<>(placeholder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HTMLInputElement getInputElement() {
        return longBox.getInputElement().element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected LongBox createValueBox() {
        this.longBox = LongBox.create();
        return this.longBox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isEmpty() {
        return this.longBox.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getValue() {
        return this.longBox.getValue()+"";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected FilterTypes getType() {
        return FilterTypes.LONG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        longBox.pauseChangeHandlers();
        longBox.clear();
        longBox.getInputElement().element().value = "";
        longBox.resumeChangeHandlers();
    }

    /**
     *
     * @return the {@link LongBox} wrapped in this component
     */
    public LongBox getLongBox() {
        return longBox;
    }
}
