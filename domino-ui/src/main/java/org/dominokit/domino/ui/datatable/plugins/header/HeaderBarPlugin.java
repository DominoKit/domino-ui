/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.datatable.plugins.header;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_nav_bar;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_search_box;

import elemental2.dom.Element;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DefaultColumnShowHideListener;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.icons.*;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.PostfixAddOn;

/**
 * This plugin attach an action bar to the table and adds {@link
 * org.dominokit.domino.ui.datatable.plugins.header.HeaderActionElement}(s) to it
 *
 * @param <T> the type of the data table records
 * @author vegegoku
 * @version $Id: $Id
 */
public class HeaderBarPlugin<T> implements DataTablePlugin<T> {

  private final NavBar navBar;
  private final List<HeaderActionElement<T>> actionElements = new ArrayList<>();

  /**
   * creates an instance with a custom title
   *
   * @param title String title of the header bar
   */
  public HeaderBarPlugin(String title) {
    this(title, "");
  }

  /**
   * creates an instance with a custom and description
   *
   * @param title String title of the header bar
   * @param description String description of the header bar
   */
  public HeaderBarPlugin(String title, String description) {
    this.navBar = NavBar.create(title).addCss(dui_datatable_nav_bar);
    if (nonNull(description) && !description.isEmpty()) {
      this.navBar.setDescription(description);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    actionElements.forEach(
        actionElement -> navBar.appendChild(PostfixAddOn.of(actionElement.asElement(dataTable))));
    dataTable.appendChild(navBar);
  }

  /**
   * Adds a new header action to this header bar
   *
   * @param headerActionElement the {@link
   *     org.dominokit.domino.ui.datatable.plugins.header.HeaderActionElement}
   * @return same plugin instance
   */
  public HeaderBarPlugin<T> addActionElement(HeaderActionElement<T> headerActionElement) {
    actionElements.add(headerActionElement);
    return this;
  }

  /**
   * a Predefined {@link HeaderActionElement} that condense/expand the data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class CondenseTableAction<T> implements HeaderActionElement<T> {
    private String condenseToolTip = "Condense";
    private String expandToolTip = "Expand";

    /** {@inheritDoc} */
    @Override
    public Element asElement(DataTable<T> dataTable) {
      ToggleIcon<?, ?> condenseIcon =
          ToggleMdiIcon.create(Icons.arrow_collapse_vertical(), Icons.arrow_expand_vertical())
              .clickable()
              .setTooltip(condenseToolTip)
              .toggleOnClick(true)
              .onToggle(
                  toggleMdiIcon -> {
                    dataTable.setCondensed(!dataTable.isCondensed());
                    toggleMdiIcon.setTooltip(
                        dataTable.isCondensed() ? condenseToolTip : expandToolTip);
                  });

      return condenseIcon.element();
    }

    /**
     * Changes the condense icon tooltip
     *
     * @param condenseToolTip String
     * @return same acton instance
     */
    public CondenseTableAction<T> setCondenseToolTip(String condenseToolTip) {
      this.condenseToolTip = condenseToolTip;
      return this;
    }

    /**
     * Changes the expand icon tooltip
     *
     * @param expandToolTip String
     * @return same acton instance
     */
    public CondenseTableAction<T> setExpandToolTip(String expandToolTip) {
      this.expandToolTip = expandToolTip;
      return this;
    }
  }

  /**
   * A predefined action to toggle stripes on data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class StripesTableAction<T> implements HeaderActionElement<T> {

    private String noStripsToolTip = "No stripes";
    private String stripsToolTip = "Stripes";

    /** {@inheritDoc} */
    @Override
    public Element asElement(DataTable<T> dataTable) {
      ToggleIcon<?, ?> stripesIcon =
          ToggleMdiIcon.create(Icons.view_day_outline(), Icons.view_day())
              .clickable()
              .setTooltip(noStripsToolTip)
              .toggleOnClick(true)
              .onToggle(
                  toggleMdiIcon -> {
                    dataTable.setStriped(!dataTable.isStriped());
                    toggleMdiIcon.setTooltip(
                        dataTable.isStriped() ? stripsToolTip : noStripsToolTip);
                  });

      return stripesIcon.element();
    }

    /**
     * Changes the no strips icon tooltip
     *
     * @param noStripsToolTip String
     * @return same acton instance
     */
    public StripesTableAction<T> setNoStripsToolTip(String noStripsToolTip) {
      this.noStripsToolTip = noStripsToolTip;
      return this;
    }

    /**
     * Changes the strips icon tooltip
     *
     * @param stripsToolTip String
     * @return same acton instance
     */
    public StripesTableAction<T> setStripsToolTip(String stripsToolTip) {
      this.stripsToolTip = stripsToolTip;
      return this;
    }
  }

  /**
   * A predefined action to toggle borders on data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class BordersTableAction<T> implements HeaderActionElement<T> {

    private String borderedToolTip = "Bordered";
    private String noBordersToolTip = "No borders";

    /** {@inheritDoc} */
    @Override
    public Element asElement(DataTable<T> dataTable) {
      ToggleIcon<?, ?> bordersIcon =
          ToggleMdiIcon.create(Icons.border_vertical(), Icons.border_none())
              .clickable()
              .toggleOnClick(true)
              .setTooltip(borderedToolTip)
              .onToggle(
                  toggleMdiIcon -> {
                    dataTable.setBordered(!dataTable.isBordered());
                    toggleMdiIcon.setTooltip(
                        dataTable.isBordered() ? noBordersToolTip : borderedToolTip);
                  });

      return bordersIcon.element();
    }

    /**
     * Changes the borders icon tooltip
     *
     * @param borderedToolTip String
     * @return same acton instance
     */
    public BordersTableAction<T> setBorderedToolTip(String borderedToolTip) {
      this.borderedToolTip = borderedToolTip;
      return this;
    }

    /**
     * Changes the no borders icon tooltip
     *
     * @param noBordersToolTip String
     * @return same acton instance
     */
    public BordersTableAction<T> setNoBordersToolTip(String noBordersToolTip) {
      this.noBordersToolTip = noBordersToolTip;
      return this;
    }
  }

  /**
   * A predefined action to toggle hover on data table rows
   *
   * @param <T> the type of the data table records
   */
  public static class HoverTableAction<T> implements HeaderActionElement<T> {

    private String hoverToolTip = "Hover";
    private String noHoverToolTip = "No Hover";

    /** {@inheritDoc} */
    @Override
    public Element asElement(DataTable<T> dataTable) {

      ToggleIcon<?, ?> hoverIcon =
          ToggleMdiIcon.create(Icons.blur_off(), Icons.blur())
              .clickable()
              .toggleOnClick(true)
              .setTooltip(noHoverToolTip)
              .onToggle(
                  toggleMdiIcon -> {
                    dataTable.setHover(!dataTable.isHover());
                    toggleMdiIcon.setTooltip(dataTable.isHover() ? noHoverToolTip : hoverToolTip);
                  });

      return hoverIcon.element();
    }

    /**
     * Changes the hover icon tooltip
     *
     * @param hoverToolTip String
     * @return same acton instance
     */
    public HoverTableAction<T> setHoverToolTip(String hoverToolTip) {
      this.hoverToolTip = hoverToolTip;
      return this;
    }

    /**
     * Changes the no hover icon tooltip
     *
     * @param noHoverToolTip String
     * @return same acton instance
     */
    public HoverTableAction<T> setNoHoverToolTip(String noHoverToolTip) {
      this.noHoverToolTip = noHoverToolTip;
      return this;
    }
  }

  /**
   * A predefined action to clear data table search
   *
   * @param <T> the type of the data table records
   */
  public static class ClearSearch<T> implements HeaderActionElement<T> {

    private String clearFiltersToolTip = "Clear filters";

    /** {@inheritDoc} */
    @Override
    public Element asElement(DataTable<T> dataTable) {

      MdiIcon clearFiltersIcon =
          Icons.filter_off()
              .setTooltip(clearFiltersToolTip)
              .addCss(dui_font_size_4)
              .clickable()
              .addClickListener(evt -> dataTable.getSearchContext().clear().fireSearchEvent());

      return clearFiltersIcon.element();
    }

    /**
     * Changes the clear filters icon tooltip
     *
     * @param clearFiltersToolTip String
     * @return same acton instance
     */
    public ClearSearch<T> setClearFiltersToolTip(String clearFiltersToolTip) {
      this.clearFiltersToolTip = clearFiltersToolTip;
      return this;
    }
  }

  /**
   * A predefined action to add a search box the data table
   *
   * @param <T> the type of the data table records
   */
  public static class SearchTableAction<T> implements HeaderActionElement<T> {

    private DataTable<T> dataTable;
    private final SearchBox searchBox;

    /** creates a new instance */
    public SearchTableAction() {
      this.searchBox = SearchBox.create().addCss(dui_datatable_search_box);
      searchBox.setAutoSearch(true);
      searchBox.addSearchListener(
          token -> {
            search();
          });
    }

    private void search() {
      this.dataTable.getSearchContext().fireSearchEvent();
    }

    /** Clears the search */
    public void clear() {
      searchBox.clearSearch();
    }

    /** {@inheritDoc} */
    @Override
    public void handleEvent(TableEvent event) {
      if (SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())) {
        searchBox.clearSearch(true);
      }
    }

    /** {@inheritDoc} */
    @Override
    public Element asElement(DataTable<T> dataTable) {
      this.dataTable = dataTable;
      dataTable.addTableEventListener(SearchClearedEvent.SEARCH_EVENT_CLEARED, this);
      this.dataTable
          .getSearchContext()
          .addBeforeSearchHandler(
              context -> {
                context.removeByCategory(Category.SEARCH);
                context.add(Filter.create("*", searchBox.getTextBox().getValue(), Category.SEARCH));
              });
      return searchBox.element();
    }

    @Override
    public void applyStyles(Element self) {
      elements.elementOf(self).addCss(dui_grow_1);
    }

    /** @return the search box */
    public SearchTableAction<T> withSearchBox(
        ChildHandler<SearchTableAction<T>, SearchBox> handler) {
      handler.apply(this, searchBox);
      return this;
    }
  }

  /**
   * A predefined action to add a drop down to the data table that allow selecting which columns be
   * shown/hidden
   *
   * @param <T> the type of the data table records
   */
  public static class ShowHideColumnsAction<T> implements HeaderActionElement<T> {
    /** {@inheritDoc} */
    @Override
    public Element asElement(DataTable<T> dataTable) {
      Icon<?> columnsIcon = Icons.view_column().clickable();

      Menu<String> dropDownMenu =
          Menu.<String>create()
              .setDropDirection(DropDirection.BEST_FIT_SIDE)
              .apply(
                  columnsMenu ->
                      dataTable.getTableConfig().getColumns().stream()
                          .filter(this::notUtility)
                          .forEach(
                              columnConfig -> {
                                Icon<?> checkIcon =
                                    Icons.check().toggleDisplay(!columnConfig.isHidden());
                                columnConfig.addShowHideListener(
                                    DefaultColumnShowHideListener.of(checkIcon.element(), true));

                                columnsMenu.appendChild(
                                    new CustomMenuItem<String>()
                                        .appendChild(
                                            elements
                                                .div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(
                                                    elements
                                                        .div()
                                                        .addCss(dui_min_w_8)
                                                        .appendChild(checkIcon))
                                                .appendChild(
                                                    elements
                                                        .div()
                                                        .textContent(columnConfig.getTitle())))
                                        .addSelectionHandler(
                                            value ->
                                                columnConfig.toggleDisplay(
                                                    columnConfig.isHidden())));
                              }));

      columnsIcon.addClickListener(
          evt -> {
            dropDownMenu.open();
            evt.stopPropagation();
          });
      return columnsIcon.element();
    }

    private boolean notUtility(ColumnConfig<T> column) {
      return !column.isUtilityColumn();
    }

    /** {@inheritDoc} */
    @Override
    public void handleEvent(TableEvent event) {}
  }
}
