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
 * The HeaderBarPlugin class provides a customizable header bar for a DataTable with various actions
 * such as condensing, expanding, toggling stripes, borders, hover effect, clearing filters, and
 * showing/hiding columns.
 *
 * <p>Usage Example:
 *
 * <pre>
 * HeaderBarPlugin<MyData> headerBar = new HeaderBarPlugin<>("My Table", "Description");
 * headerBar.addActionElement(new HeaderBarPlugin.CondenseTableAction<>());
 * headerBar.addActionElement(new HeaderBarPlugin.StripesTableAction<>());
 * headerBar.addActionElement(new HeaderBarPlugin.BordersTableAction<>());
 * headerBar.addActionElement(new HeaderBarPlugin.HoverTableAction<>());
 * headerBar.addActionElement(new HeaderBarPlugin.ClearSearch<>());
 * headerBar.addActionElement(new HeaderBarPlugin.SearchTableAction<>());
 * headerBar.addActionElement(new HeaderBarPlugin.ShowHideColumnsAction<>());
 *
 * DataTable<MyData> dataTable = DataTable.create(data);
 * dataTable.addPlugin(headerBar);
 * </pre>
 *
 * @param <T> The data type of the DataTable
 */
public class HeaderBarPlugin<T> implements DataTablePlugin<T> {

  private final NavBar navBar;
  private final List<HeaderActionElement<T>> actionElements = new ArrayList<>();

  /**
   * Creates a HeaderBarPlugin with the specified title and an empty description.
   *
   * @param title The title to be displayed in the header bar.
   */
  public HeaderBarPlugin(String title) {
    this(title, "");
  }

  /**
   * Creates a HeaderBarPlugin with the specified title and description.
   *
   * @param title The title to be displayed in the header bar.
   * @param description The description to be displayed in the header bar.
   */
  public HeaderBarPlugin(String title, String description) {
    this.navBar = NavBar.create(title).addCss(dui_datatable_nav_bar);
    if (nonNull(description) && !description.isEmpty()) {
      this.navBar.setDescription(description);
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method is called before adding the DataTable to the DOM. It adds the header bar and
   * action elements to the DataTable.
   *
   * @param dataTable The DataTable to which the header bar and action elements will be added.
   */
  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    actionElements.forEach(
        actionElement -> navBar.appendChild(PostfixAddOn.of(actionElement.asElement(dataTable))));
    dataTable.appendChild(navBar);
  }

  /**
   * Adds an action element to the header bar.
   *
   * @param headerActionElement The HeaderActionElement to be added to the header bar.
   * @return This HeaderBarPlugin instance for method chaining.
   */
  public HeaderBarPlugin<T> addActionElement(HeaderActionElement<T> headerActionElement) {
    actionElements.add(headerActionElement);
    return this;
  }

  /**
   * An implementation of the {@link HeaderActionElement} that allows condensing and expanding the
   * DataTable.
   *
   * @param <T> The type of data in the DataTable.
   */
  public static class CondenseTableAction<T> implements HeaderActionElement<T> {
    private String condenseToolTip = "Condense";
    private String expandToolTip = "Expand";

    /**
     * {@inheritDoc}
     *
     * <p>Creates an element that represents a toggle button for condensing and expanding the
     * DataTable.
     *
     * @param dataTable The DataTable to apply the condense/expand action to.
     * @return The created HTML element representing the condense/expand button.
     */
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
     * Sets the tooltip text for the condense action button.
     *
     * @param condenseToolTip The tooltip text for the condense action.
     * @return This {@code CondenseTableAction} instance for method chaining.
     */
    public CondenseTableAction<T> setCondenseToolTip(String condenseToolTip) {
      this.condenseToolTip = condenseToolTip;
      return this;
    }

    /**
     * Sets the tooltip text for the expand action button.
     *
     * @param expandToolTip The tooltip text for the expand action.
     * @return This {@code CondenseTableAction} instance for method chaining.
     */
    public CondenseTableAction<T> setExpandToolTip(String expandToolTip) {
      this.expandToolTip = expandToolTip;
      return this;
    }
  }

  /**
   * An implementation of the {@link HeaderActionElement} that allows toggling table stripes.
   *
   * @param <T> The type of data in the DataTable.
   */
  public static class StripesTableAction<T> implements HeaderActionElement<T> {

    private String noStripsToolTip = "No stripes";
    private String stripsToolTip = "Stripes";

    /**
     * {@inheritDoc}
     *
     * <p>Creates an element that represents a toggle button for showing or hiding table stripes.
     *
     * @param dataTable The DataTable to apply the stripes action to.
     * @return The created HTML element representing the stripes toggle button.
     */
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
     * Sets the tooltip text for the "No Stripes" action button.
     *
     * @param noStripsToolTip The tooltip text for the "No Stripes" action.
     * @return This {@code StripesTableAction} instance for method chaining.
     */
    public StripesTableAction<T> setNoStripsToolTip(String noStripsToolTip) {
      this.noStripsToolTip = noStripsToolTip;
      return this;
    }

    /**
     * Sets the tooltip text for the "Stripes" action button.
     *
     * @param stripsToolTip The tooltip text for the "Stripes" action.
     * @return This {@code StripesTableAction} instance for method chaining.
     */
    public StripesTableAction<T> setStripsToolTip(String stripsToolTip) {
      this.stripsToolTip = stripsToolTip;
      return this;
    }
  }

  /**
   * An implementation of the {@link HeaderActionElement} that allows toggling table borders.
   *
   * @param <T> The type of data in the DataTable.
   */
  public static class BordersTableAction<T> implements HeaderActionElement<T> {

    private String borderedToolTip = "Bordered";
    private String noBordersToolTip = "No borders";

    /**
     * {@inheritDoc}
     *
     * <p>Creates an element that represents a toggle button for showing or hiding table borders.
     *
     * @param dataTable The DataTable to apply the borders action to.
     * @return The created HTML element representing the borders toggle button.
     */
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
     * Sets the tooltip text for the "Bordered" action button.
     *
     * @param borderedToolTip The tooltip text for the "Bordered" action.
     * @return This {@code BordersTableAction} instance for method chaining.
     */
    public BordersTableAction<T> setBorderedToolTip(String borderedToolTip) {
      this.borderedToolTip = borderedToolTip;
      return this;
    }

    /**
     * Sets the tooltip text for the "No Borders" action button.
     *
     * @param noBordersToolTip The tooltip text for the "No Borders" action.
     * @return This {@code BordersTableAction} instance for method chaining.
     */
    public BordersTableAction<T> setNoBordersToolTip(String noBordersToolTip) {
      this.noBordersToolTip = noBordersToolTip;
      return this;
    }
  }

  /**
   * An implementation of the {@link HeaderActionElement} that allows toggling table hover effect.
   *
   * @param <T> The type of data in the DataTable.
   */
  public static class HoverTableAction<T> implements HeaderActionElement<T> {

    private String hoverToolTip = "Hover";
    private String noHoverToolTip = "No Hover";

    /**
     * {@inheritDoc}
     *
     * <p>Creates an element that represents a toggle button for enabling or disabling table hover
     * effect.
     *
     * @param dataTable The DataTable to apply the hover action to.
     * @return The created HTML element representing the hover toggle button.
     */
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
     * Sets the tooltip text for the "Hover" action button.
     *
     * @param hoverToolTip The tooltip text for the "Hover" action.
     * @return This {@code HoverTableAction} instance for method chaining.
     */
    public HoverTableAction<T> setHoverToolTip(String hoverToolTip) {
      this.hoverToolTip = hoverToolTip;
      return this;
    }

    /**
     * Sets the tooltip text for the "No Hover" action button.
     *
     * @param noHoverToolTip The tooltip text for the "No Hover" action.
     * @return This {@code HoverTableAction} instance for method chaining.
     */
    public HoverTableAction<T> setNoHoverToolTip(String noHoverToolTip) {
      this.noHoverToolTip = noHoverToolTip;
      return this;
    }
  }

  /**
   * An implementation of the {@link HeaderActionElement} that allows clearing filters in a
   * DataTable.
   *
   * @param <T> The type of data in the DataTable.
   */
  public static class ClearSearch<T> implements HeaderActionElement<T> {

    private String clearFiltersToolTip = "Clear filters";

    /**
     * {@inheritDoc}
     *
     * <p>Creates an element that represents a button to clear filters in a DataTable.
     *
     * @param dataTable The DataTable from which to clear filters.
     * @return The created HTML element representing the clear filters button.
     */
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
     * Sets the tooltip text for the "Clear Filters" action button.
     *
     * @param clearFiltersToolTip The tooltip text for the "Clear Filters" action.
     * @return This {@code ClearSearch} instance for method chaining.
     */
    public ClearSearch<T> setClearFiltersToolTip(String clearFiltersToolTip) {
      this.clearFiltersToolTip = clearFiltersToolTip;
      return this;
    }
  }

  /**
   * An implementation of the {@link HeaderActionElement} that provides search functionality for a
   * DataTable.
   *
   * @param <T> The type of data in the DataTable.
   */
  public static class SearchTableAction<T> implements HeaderActionElement<T> {

    private DataTable<T> dataTable;
    private final SearchBox searchBox;

    /**
     * Creates a new instance of the {@code SearchTableAction}. Initializes a search box with
     * automatic search and adds a search listener to trigger searches.
     */
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

    /** Clears the search box. */
    public void clear() {
      searchBox.clearSearch();
    }

    /**
     * {@inheritDoc}
     *
     * <p>Handles events related to search, particularly clearing the search box when the search is
     * cleared.
     *
     * @param event The table event to handle.
     */
    @Override
    public void handleEvent(TableEvent event) {
      if (SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())) {
        searchBox.clearSearch(true);
      }
    }

    /**
     * {@inheritDoc}
     *
     * <p>Creates an element representing the search box and adds listeners to handle searching and
     * clearing.
     *
     * @param dataTable The DataTable to which this action element belongs.
     * @return The created HTML element representing the search box.
     */
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

    /**
     * {@inheritDoc}
     *
     * <p>Applies styles to the search box element.
     *
     * @param self The element representing the search box.
     */
    @Override
    public void applyStyles(Element self) {
      elements.elementOf(self).addCss(dui_grow_1);
    }

    /**
     * Configures the search box with a custom handler using method chaining.
     *
     * @param handler The custom handler to apply to the search box.
     * @return This {@code SearchTableAction} instance for method chaining.
     */
    public SearchTableAction<T> withSearchBox(
        ChildHandler<SearchTableAction<T>, SearchBox> handler) {
      handler.apply(this, searchBox);
      return this;
    }
  }

  /**
   * An implementation of the {@link HeaderActionElement} that provides the ability to show/hide
   * columns in a DataTable.
   *
   * @param <T> The type of data in the DataTable.
   */
  public static class ShowHideColumnsAction<T> implements HeaderActionElement<T> {

    /**
     * {@inheritDoc}
     *
     * <p>Creates an element representing a button that allows users to show/hide columns. When
     * clicked, a dropdown menu appears, providing options to show or hide individual columns.
     *
     * @param dataTable The DataTable to which this action element belongs.
     * @return The created HTML element representing the show/hide columns button.
     */
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
            if (dropDownMenu.isOpened()) {
              dropDownMenu.close();
            } else {
              dropDownMenu.open();
            }
            evt.stopPropagation();
          });
      return columnsIcon.element();
    }

    private boolean notUtility(ColumnConfig<T> column) {
      return !column.isUtilityColumn();
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method does not handle any specific events.
     *
     * @param event The table event to handle.
     */
    @Override
    public void handleEvent(TableEvent event) {}
  }
}
