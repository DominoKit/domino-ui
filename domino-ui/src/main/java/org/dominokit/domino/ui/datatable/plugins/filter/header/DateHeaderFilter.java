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

/**
 * Date column header filter component that is rendered as a {@link DateBox} component
 * @param <T> type of data table records
 */
public class DateHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

    private DateBox dateBox;

    /**
     * Static factory to create a new instance
     * @param <T> the type of the data table records
     * @return new instance
     */
    public static <T> DateHeaderFilter<T> create() {
        return new DateHeaderFilter<>();
    }

    /**
     * @see DateHeaderFilter#create()
     */
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

    /**
     *
     * @return the {@link DateBox} wrapped in this filter component
     */
    public DateBox getDateBox() {
        return dateBox;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        dateBox.pauseChangeHandlers();
        dateBox.clear();
        dateBox.resumeChangeHandlers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return dateBox.element();
    }
}
