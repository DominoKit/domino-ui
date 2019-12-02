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

import java.util.Arrays;

public class EnumHeaderFilter<T, E extends Enum> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

    private final Select<String> select;

    public static <T, E extends Enum> EnumHeaderFilter<T, E> create(E[] values) {
        return new EnumHeaderFilter<>(values, "ALL");
    }

    public static <T, E extends Enum> EnumHeaderFilter<T, E> create(E[] values, String allLabel) {
        return new EnumHeaderFilter<>(values, allLabel);
    }

    public EnumHeaderFilter(E[] values, String allLabel) {
        select = Select.<String>create()
                .appendChild(SelectOption.create("", allLabel))
                .apply(element -> Arrays.stream(values)
                        .forEach(value -> element.appendChild(SelectOption.create(value.toString(), value.toString()))))
                .selectAt(0);
        select.styler(style -> style.setMarginBottom("0px"));
    }

    @Override
    public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
        searchContext.addBeforeSearchHandler(context -> {
            if (select.getSelectedIndex() > 0) {
                searchContext.add(Filter.create(columnConfig.getName(), select.getValue(), Category.HEADER_FILTER, FilterTypes.ENUM));
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
