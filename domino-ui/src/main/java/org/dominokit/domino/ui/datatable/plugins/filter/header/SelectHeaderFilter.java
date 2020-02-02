package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;

public class SelectHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

    private final Select<String> select;

    public static <T> SelectHeaderFilter<T> create() {
        return new SelectHeaderFilter<>("ALL");
    }

    public static <T> SelectHeaderFilter<T> create(String allLabel) {
        return new SelectHeaderFilter<>(allLabel);
    }

    public SelectHeaderFilter(String allLabel) {
        select = Select.<String>create()
                .appendChild(SelectOption.create("", allLabel))
                .selectAt(0);
        select.styler(style -> style.setMarginBottom("0px"));
    }

    public SelectHeaderFilter appendChild(SelectOption<String> selectOption) {
        select.appendChild(selectOption);
        return this;
    }

    @Override
    public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
        searchContext.addBeforeSearchHandler(context -> {
            if (select.getSelectedIndex() > 0) {
                searchContext.add(Filter.create(columnConfig.getName(), select.getValue(), Category.HEADER_FILTER, FilterTypes.STRING));
            } else {
                searchContext.remove(columnConfig.getName(), Category.HEADER_FILTER);
            }
        });
        select.addSelectionHandler(option -> searchContext.fireSearchEvent());
    }

    @Override
    public void clear() {
        select.selectAt(0, true);
    }

    @Override
    public HTMLElement element() {
        return select.element();
    }
}
