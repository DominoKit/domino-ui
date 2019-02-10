package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.utils.DelayedTextInput;

import static java.util.Objects.nonNull;

public abstract class DelayedHeaderFilterInput<B extends ValueBox, T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {
    private B input;
    private DelayedTextInput delayedTextInput;

    public DelayedHeaderFilterInput() {
        this("Search");
    }

    public DelayedHeaderFilterInput(String placeHolder) {
        input = createValueBox();

        input.styler(style -> style.setMarginBottom("0px"));
        input.setPlaceholder(placeHolder);
        input.getLeftAddonContainer().hide();
        input.getRightAddonContainer().hide();

        delayedTextInput = DelayedTextInput.create(getInputElement(), 200);
    }

    @Override
    public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
        delayedTextInput.setDelayedAction(() -> {
            if (nonNull(searchContext) && nonNull(columnConfig)) {
                if (isEmpty()) {
                    searchContext.remove(columnConfig.getName(), Category.HEADER_FILTER);
                    searchContext.fireSearchEvent();
                } else {
                    searchContext.add(Filter.create(columnConfig.getName(), getValue(), Category.HEADER_FILTER, getType()));
                    searchContext.fireSearchEvent();
                }
            }
        });
    }

    protected abstract HTMLInputElement getInputElement();
    protected abstract B createValueBox();
    protected abstract boolean isEmpty();
    protected abstract String getValue();
    protected abstract FilterTypes getType();
    public B getField(){
        return input;
    }

    @Override
    public HTMLElement asElement() {
        return input.asElement();
    }
}
