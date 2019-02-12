package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.EventType;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class HeaderBarPlugin<T> implements DataTablePlugin<T> {

    private Column titleColumn = Column.span6();
    private Column actionsBarColumn = Column.span6();

    private HTMLHeadingElement title = Style.of(h(2))
            .setMarginBottom("0px").asElement();
    private FlexLayout actionsBar = FlexLayout.create()
            .setJustifyContent(FlexJustifyContent.END);

    private HTMLDivElement element = div()
            .add(Row.create()
                    .appendChild(titleColumn.appendChild(title))
                    .appendChild(actionsBarColumn.appendChild(actionsBar))
                    .asElement())
            .css(DataTableStyles.HEADER)
            .style("padding-bottom: 5px;")
            .asElement();

    private final List<HeaderActionElement<T>> actionElements = new ArrayList<>();

    public HeaderBarPlugin(String title) {
        this(title, "");
    }

    public HeaderBarPlugin(String title, String description) {
        this.title.appendChild(DomGlobal.document.createTextNode(title));
        if (nonNull(description) && !description.isEmpty()) {
            this.title.appendChild(small().textContent(description).asElement());
        }

        Style.of(titleColumn).setMarginBottom("0px");
        Style.of(actionsBarColumn).setMarginBottom("0px");
    }

    @Override
    public void onBeforeAddTable(DataTable<T> dataTable) {
        actionElements.forEach(actionElement -> actionsBar.appendChild(FlexItem.create()
                .styler(style -> style
                        .add(Styles.m_r_5)
                        .add(Styles.m_l_5))
                .appendChild(actionElement.asElement(dataTable)).asElement()));
        dataTable.asElement().appendChild(element);
    }

    public HeaderBarPlugin<T> addActionElement(HeaderActionElement<T> headerActionElement) {
        actionElements.add(headerActionElement);
        return this;
    }

    public static class CondenseTableAction<T> implements HeaderActionElement<T> {
        private String condenseToolTip = "Condense";
        private String expandToolTip = "Expand";

        @Override
        public Node asElement(DataTable<T> dataTable) {
            Icon condenseIcon= Icons.ALL.line_weight()
                    .clickable()
                    .setTooltip(condenseToolTip)
                    .setToggleIcon(Icons.ALL.format_line_spacing())
                    .toggleOnClick(true)
                    .apply(icon -> icon.addClickListener(evt -> {
                        if (dataTable.isCondensed()) {
                            dataTable.show();
                            icon.setTooltip(condenseToolTip);
                        } else {
                            dataTable.condense();
                            icon.setTooltip(expandToolTip);
                        }
                    }));


            return a().add(condenseIcon).asElement();
        }

        public CondenseTableAction<T> setCondenseToolTip(String condenseToolTip) {
            this.condenseToolTip = condenseToolTip;
            return this;
        }

        public CondenseTableAction<T> setExpandToolTip(String expandToolTip) {
            this.expandToolTip = expandToolTip;
            return this;
        }
    }

    public static class StripesTableAction<T> implements HeaderActionElement<T> {

        private String noStripsToolTip = "No stripes";
        private String stripsToolTip = "Stripes";

        @Override
        public Node asElement(DataTable<T> dataTable) {
            Icon stripesIcon= Icons.ALL.format_line_spacing()
                    .clickable()
                    .setToggleIcon(Icons.ALL.power_input())
                    .setTooltip(noStripsToolTip)
                    .toggleOnClick(true)
                    .apply(icon -> icon.addClickListener(evt -> {
                        if (dataTable.isStriped()) {
                            dataTable.noStripes();
                            icon.setTooltip(stripsToolTip);
                        } else {
                            dataTable.striped();
                            icon.setTooltip(noStripsToolTip);
                        }
                    }));

            return a().add(stripesIcon).asElement();
        }

        public StripesTableAction<T> setNoStripsToolTip(String noStripsToolTip) {
            this.noStripsToolTip = noStripsToolTip;
            return this;
        }

        public StripesTableAction<T> setStripsToolTip(String stripsToolTip) {
            this.stripsToolTip = stripsToolTip;
            return this;
        }
    }

    public static class BordersTableAction<T> implements HeaderActionElement<T> {

        private String borderedToolTip = "Bordered";
        private String noBprdersToolTip = "No borders";

        @Override
        public Node asElement(DataTable<T> dataTable) {

            Icon bordersIcon = Icons.ALL.border_vertical()
                    .clickable()
                    .setToggleIcon(Icons.ALL.border_clear())
                    .toggleOnClick(true)
                    .setTooltip(borderedToolTip)
                    .apply(icon -> icon.addClickListener(evt -> {
                        if (dataTable.isBordered()) {
                            dataTable.noBorder();
                            icon.setTooltip(borderedToolTip);
                        } else {
                            dataTable.bordered();
                            icon.setTooltip(noBprdersToolTip);
                        }
                    }));

            return a().add(bordersIcon).asElement();
        }

        public BordersTableAction<T> setBorderedToolTip(String borderedToolTip) {
            this.borderedToolTip = borderedToolTip;
            return this;
        }

        public BordersTableAction<T> setNoBprdersToolTip(String noBprdersToolTip) {
            this.noBprdersToolTip = noBprdersToolTip;
            return this;
        }
    }

    public static class HoverTableAction<T> implements HeaderActionElement<T> {

        private String hoverToolTip = "Hover";
        private String noHoverToolTip = "No Hover";

        @Override
        public Node asElement(DataTable<T> dataTable) {

            Icon hoverIcon = Icons.ALL.blur_off()
                    .clickable()
                    .setToggleIcon(Icons.ALL.blur_on())
                    .toggleOnClick(true)
                    .setTooltip(noHoverToolTip)
                    .apply(icon -> icon.addClickListener(evt -> {
                        if (dataTable.isHoverable()) {
                            dataTable.noHover();
                            icon.setTooltip(hoverToolTip);
                        } else {
                            dataTable.hovered();
                            icon.setTooltip(noHoverToolTip);
                        }
                    }));

            return a().add(hoverIcon).asElement();
        }

        public HoverTableAction<T> setHoverToolTip(String hoverToolTip) {
            this.hoverToolTip = hoverToolTip;
            return this;
        }

        public HoverTableAction<T> setNoHoverToolTip(String noHoverToolTip) {
            this.noHoverToolTip = noHoverToolTip;
            return this;
        }
    }

    public static class ClearSearch<T> implements HeaderActionElement<T> {

        private String clearFiltersToolTip = "Clear filters";

        @Override
        public Node asElement(DataTable<T> dataTable) {

            MdiIcon clearFiltersIcon = Icons.MDI_ICONS.filter_remove_mdi()
                    .setTooltip(clearFiltersToolTip)
                    .size18()
                    .clickable()
                    .addClickListener(evt -> dataTable.getSearchContext()
                            .clear()
                            .fireSearchEvent());

            return a()
                    .add(clearFiltersIcon).asElement();
        }

        public ClearSearch<T> setClearFiltersToolTip(String clearFiltersToolTip) {
            this.clearFiltersToolTip = clearFiltersToolTip;
            return this;
        }
    }

    public static class SearchTableAction<T> implements HeaderActionElement<T> {

        private String searchToolTip = "Search";
        private String clearSearchToolTip = "Clear search";

        private int autoSearchDelay = 200;
        private HTMLDivElement element = div().css("search-new").asElement();
        private DataTable<T> dataTable;
        private final TextBox textBox;
        private boolean autoSearch = true;
        private Timer autoSearchTimer;
        private EventListener autoSearchEventListener;
        private final Icon searchIcon;
        private final Icon clearIcon;

        public SearchTableAction() {

            searchIcon = Icons.ALL.search()
                    .addClickListener(evt -> {
                        autoSearchTimer.cancel();
                        doSearch();
                    })
                    .setTooltip(searchToolTip)
                    .style()
                    .setCursor("pointer")
                    .get();

            clearIcon = Icons.ALL.clear()
                    .setTooltip(clearSearchToolTip)
                    .style()
                    .setCursor("pointer")
                    .get();

            textBox = TextBox.create()
                    .setPlaceholder(searchToolTip)
                    .setLeftAddon(searchIcon)
                    .setRightAddon(clearIcon)
                    .styler(style -> style
                            .add("table-search-box")
                            .setMarginBottom("0px")
                            .setMaxWidth("300px")
                            .add(Styles.pull_right));

            clearIcon.addClickListener(evt -> {
                textBox.clear();
                autoSearchTimer.cancel();
                doSearch();
            });

            element.appendChild(textBox.asElement());

            autoSearchTimer = new Timer() {
                @Override
                public void run() {
                    doSearch();
                }
            };

            autoSearchEventListener = evt -> {
                autoSearchTimer.cancel();
                autoSearchTimer.schedule(autoSearchDelay);
            };

            setAutoSearch(true);
        }

        public boolean isAutoSearch() {
            return autoSearch;
        }

        public SearchTableAction<T> setAutoSearch(boolean autoSearch) {
            this.autoSearch = autoSearch;

            if (autoSearch) {
                textBox.addEventListener("input", autoSearchEventListener);
            } else {
                textBox.removeEventListener("input", autoSearchEventListener);
                autoSearchTimer.cancel();
            }

            textBox.addEventListener(EventType.keypress.getName(), evt -> {
                if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                    doSearch();
                }
            });

            return this;
        }

        public int getAutoSearchDelay() {
            return autoSearchDelay;
        }

        public void setAutoSearchDelay(int autoSearchDelayInMillies) {
            this.autoSearchDelay = autoSearchDelayInMillies;
        }

        private void doSearch() {
            SearchContext searchContext = dataTable.getSearchContext();
            Category search = Category.SEARCH;
            searchContext.removeByCategory(search);
            searchContext.add(Filter.create("*", textBox.getValue(), Category.SEARCH))
                    .fireSearchEvent();
        }

        @Override
        public void handleEvent(TableEvent event) {
            if(SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())){
                textBox.pauseChangeHandlers();
                textBox.clear();
                textBox.resumeChangeHandlers();
            }
        }

        @Override
        public Node asElement(DataTable<T> dataTable) {
            this.dataTable = dataTable;
            dataTable.addTableEventListner(SearchClearedEvent.SEARCH_EVENT_CLEARED, this);
            return element;
        }

        public SearchTableAction<T> setSearchToolTip(String searchToolTip) {
            this.searchToolTip = searchToolTip;
            searchIcon.setTooltip(searchToolTip);
            textBox.setPlaceholder(searchToolTip);
            return this;
        }

        public SearchTableAction<T> setClearSearchToolTip(String clearSearchToolTip) {
            this.clearSearchToolTip = clearSearchToolTip;
            clearIcon.setTooltip(clearSearchToolTip);
            return this;
        }
    }
}
