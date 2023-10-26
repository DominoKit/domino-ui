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

package org.dominokit.domino.ui.datatable.plugins.column;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_column_filter;

import elemental2.dom.HTMLElement;
import java.util.List;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.ColumnHeader;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.elements.THeadElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.style.Style;

/**
 * A DataTable plugin that adds header filters to the DataTable. Header filters are used to filter
 * data in the DataTable based on the values in the column headers.
 *
 * @param <T> The type of data in the DataTable.
 */
public class ColumnHeaderFilterPlugin<T> implements DataTablePlugin<T> {

  /** The HTML element that contains the header filters. */
  private TableRowElement filtersRowElement = elements.tr();

  /** The DataTable instance to which this plugin is attached. */
  private DataTable<T> datatable;

  /**
   * Initializes the ColumnHeaderFilterPlugin for a specific DataTable instance.
   *
   * @param dataTable The DataTable to which this plugin is attached.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    this.datatable = dataTable;
  }

  /**
   * Creates a new instance of the ColumnHeaderFilterPlugin.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new ColumnHeaderFilterPlugin instance.
   */
  public static <T> ColumnHeaderFilterPlugin<T> create() {
    return new ColumnHeaderFilterPlugin<>();
  }

  /**
   * Adds header filters to the DataTable after the headers have been added.
   *
   * @param dataTable The DataTable to which the header filters are added.
   */
  @Override
  public void onAfterAddHeaders(DataTable<T> dataTable) {
    TableConfig<T> tableConfig = dataTable.getTableConfig();
    List<ColumnConfig<T>> columns = tableConfig.getColumns();
    THeadElement thead = dataTable.headerElement();
    thead.appendChild(filtersRowElement);

    columns.forEach(
        columnConfig -> {
          ColumnHeader th = ColumnHeader.create().addCss(dui_datatable_column_filter);
          columnConfig.getHeaderStyler().styleCell(th.element());

          columnConfig.applyScreenMedia(th.element());

          ColumnCssRuleMeta.get(columnConfig)
              .ifPresent(
                  meta ->
                      meta.cssRules()
                          .forEach(
                              columnCssRule ->
                                  th.addCss(columnCssRule.getCssRule().getCssClass())));

          filtersRowElement.appendChild(th);

          if (columnConfig.isFixed()) {
            fixElementWidth(columnConfig, th.element());
          }

          ColumnFilterMeta.get(columnConfig)
              .ifPresent(
                  meta -> {
                    meta.getHeaderFilter().init(dataTable.getSearchContext(), columnConfig);
                    th.appendChild(meta.getHeaderFilter());
                  });
          ColumnHeaderMeta.get(columnConfig)
              .ifPresent(columnHeaderMeta -> columnHeaderMeta.addExtraHeadElement(th));

          columnConfig.addShowHideListener(DefaultColumnShowHideListener.of(th.element(), true));
          th.toggleDisplay(!columnConfig.isHidden());
        });

    dataTable.tableElement().appendChild(thead);
  }

  private void fixElementWidth(ColumnConfig<T> column, HTMLElement element) {
    String fixedWidth = bestFitWidth(column);
    Style.of(element).setWidth(fixedWidth).addCss(DataTableStyles.fixed_width);
  }

  private String bestFitWidth(ColumnConfig<T> columnConfig) {
    if (nonNull(columnConfig.getWidth()) && !columnConfig.getWidth().isEmpty()) {
      return columnConfig.getWidth();
    } else if (nonNull(columnConfig.getMinWidth()) && !columnConfig.getMinWidth().isEmpty()) {
      return columnConfig.getMinWidth();
    } else if (nonNull(columnConfig.getMaxWidth()) && !columnConfig.getMaxWidth().isEmpty()) {
      return columnConfig.getMaxWidth();
    } else {
      return "100px";
    }
  }

  /**
   * Handles table events, such as clearing the filters when a search is cleared.
   *
   * @param event The table event to handle.
   */
  @Override
  public void handleEvent(TableEvent event) {
    if (SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())) {
      this.datatable
          .getTableConfig()
          .getFlattenColumns()
          .forEach(
              col -> {
                ColumnFilterMeta.get(col)
                    .ifPresent(
                        meta -> {
                          meta.getHeaderFilter().clear();
                        });
              });
    }
  }

  /**
   * Gets the HTML element that contains the header filters.
   *
   * @return The TableRowElement containing the header filters.
   */
  public TableRowElement getFiltersRowElement() {
    return filtersRowElement;
  }

  /**
   * Specifies the order in which this plugin should be executed. Plugins with lower order values
   * are executed first.
   *
   * @return The order value for this plugin.
   */
  @Override
  public int order() {
    return 110;
  }

  /**
   * An interface for defining header filters that can be used with the ColumnHeaderFilterPlugin.
   *
   * @param <T> The type of data in the DataTable.
   */
  public interface HeaderFilter<T> extends IsElement<HTMLElement> {

    /**
     * Initializes the header filter with the search context and column configuration.
     *
     * @param searchContext The search context for the DataTable.
     * @param columnConfig The configuration of the column to which the filter is attached.
     */
    void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig);

    /** Clears the header filter, resetting it to its initial state. */
    void clear();
  }
}
