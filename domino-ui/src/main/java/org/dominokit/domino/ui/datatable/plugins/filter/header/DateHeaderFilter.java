package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.popover.PopupPosition;

public class DateHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

    private DateBox dateBox;

    public static <T> DateHeaderFilter<T> create() {
        return new DateHeaderFilter<>();
    }

    public DateHeaderFilter() {
        this.dateBox = DateBox.create()
                .setPlaceholder("Search")
                .apply(element -> {
                    element.getDatePicker().hideHeaderPanel();
                    element.getDatePicker().addDateDayClickHandler((date, dateTimeFormatInfo) -> {
                        element.close();
                    });
                })
                .setPickerStyle(DateBox.PickerStyle.POPOVER)
                .setPopoverPosition(PopupPosition.BEST_FIT)
                .styler(style -> style.setMarginBottom("0px"));
    }

    public DateBox getDateBox() {
        return dateBox;
    }

    @Override
    public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
        searchContext.addBeforeSearchHandler(context -> {
            if (dateBox.isEmpty()) {
                searchContext.remove(columnConfig.getName(), Category.HEADER_FILTER);
            } else {
                searchContext.add(Filter.create(columnConfig.getName(), dateBox.getValue().getTime() + "", Category.HEADER_FILTER, FilterTypes.DATE));
            }
        });
        dateBox.addChangeHandler(value -> searchContext.fireSearchEvent());
    }

    @Override
    public void clear() {
        dateBox.pauseChangeHandlers();
        dateBox.clear();
        dateBox.resumeChangeHandlers();
    }

    @Override
    public HTMLElement element() {
        return dateBox.element();
    }
}
