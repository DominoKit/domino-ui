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

public class BooleanHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

    private final Select<String> select;

    public static <T> BooleanHeaderFilter<T> create() {
        return new BooleanHeaderFilter<>();
    }

    public static <T> BooleanHeaderFilter<T> create(String trueLabel, String falseLabel, String bothLabel) {
        return new BooleanHeaderFilter<>(trueLabel, falseLabel, bothLabel);
    }

    public BooleanHeaderFilter() {
        this("Yes", "No", "ALL");
    }

    public BooleanHeaderFilter(String trueLabel, String falseLabel, String bothLabel) {
        select = Select.<String>create()
                .appendChild(SelectOption.create("", bothLabel))
                .appendChild(SelectOption.create(Boolean.TRUE.toString(), trueLabel))
                .appendChild(SelectOption.create(Boolean.FALSE.toString(), falseLabel))
                .setSearchable(false)
                .selectAt(0);

        select.styler(style -> style.setMarginBottom("0px"));
    }

    @Override
    public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
        select.addSelectionHandler(option -> {
            if (select.getSelectedIndex() > 0) {
                searchContext.add(Filter.create(columnConfig.getName(), option.getValue(), Category.HEADER_FILTER, FilterTypes.BOOLEAN));
                searchContext.fireSearchEvent();
            } else {
                searchContext.remove(columnConfig.getName(), Category.HEADER_FILTER);
                searchContext.fireSearchEvent();
            }
        });
    }

    @Override
    public void clear() {
        select.selectAt(0, true);
    }

    @Override
    public HTMLElement asElement() {
        return select.asElement();
    }
}
