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
package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.ColumnHeaderMeta;
import org.dominokit.domino.ui.datatable.ColumnMeta;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.DefaultColumnShowHideListener;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.elements.THElement;
import org.dominokit.domino.ui.elements.THeadElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.style.Style;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

/**
 * This plugin adds header filters to table columns headers
 *
 * <pre>
 * tableConfig
 *         .addPlugin(ColumnHeaderFilterPlugin.<Person&gt;create()
 *                 .addHeaderFilter("id", IntegerHeaderFilter.create())
 *                 .addHeaderFilter("name", TextHeaderFilter.create()));
 * </pre>
 *
 * @param <T> the type of the data table records
 */
public class ColumnHeaderFilterPlugin<T> implements DataTablePlugin<T> {

  private final Map<String, HeaderFilter> headerFilters = new HashMap<>();
  private TableRowElement filtersRowElement = elements.tr();

  /**
   * Create a new instance
   *
   * @param <T> the type of the data table records
   * @return new instance
   */
  public static <T> ColumnHeaderFilterPlugin<T> create() {
    return new ColumnHeaderFilterPlugin<>();
  }

  /** {@inheritDoc} */
  @Override
  public void onAfterAddHeaders(DataTable<T> dataTable) {
    TableConfig<T> tableConfig = dataTable.getTableConfig();
    List<ColumnConfig<T>> columns = tableConfig.getColumns();
    THeadElement thead = dataTable.headerElement();
    thead.appendChild(filtersRowElement);

    columns.forEach(
        columnConfig -> {
          THElement th =
              elements.th().css(DataTableStyles.TABLE_CM_FILTER);
          columnConfig.getHeaderStyler().styleCell(th.element());

          columnConfig.applyScreenMedia(th.element());

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
          if (headerFilters.containsKey(columnConfig.getName())) {
            headerFilters
                .get(columnConfig.getName())
                .init(dataTable.getSearchContext(), columnConfig);
            th.appendChild(headerFilters.get(columnConfig.getName()));
          }
          ColumnHeaderMeta.get(columnConfig)
              .ifPresent(columnHeaderMeta -> columnHeaderMeta.addExtraHeadElement(th));

          columnConfig.addShowHideListener(DefaultColumnShowHideListener.of(th.element(), true));
          th.toggleDisplay(!columnConfig.isHidden());
        });

    dataTable.tableElement().appendChild(thead);
  }

  private void fixElementWidth(ColumnConfig<T> column, HTMLElement element) {
    String fixedWidth = bestFitWidth(column);
    Style.of(element).setWidth(fixedWidth).addCss(DataTableStyles.FIXED_WIDTH);
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
   * Adds a new header filter to the plugin
   *
   * @param columnName String, the name of the column we are adding the header filter to.
   * @param headerFilter the {@link HeaderFilter}
   * @return same instance
   * @deprecated use {@link ColumnConfig#applyMeta(ColumnMeta)} and pass {@link ColumnFilterMeta}
   */
  @Deprecated
  public ColumnHeaderFilterPlugin<T> addHeaderFilter(String columnName, HeaderFilter headerFilter) {
    headerFilters.put(columnName, headerFilter);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void handleEvent(TableEvent event) {
    if (SearchClearedEvent.SEARCH_EVENT_CLEARED.equals(event.getType())) {
      headerFilters.values().forEach(HeaderFilter::clear);
    }
  }

  /** @return The table row element that contains the header filters components */
  public TableRowElement getFiltersRowElement() {
    return filtersRowElement;
  }

  @Override
  public int order() {
    return 110;
  }

  /**
   * An interface for implementing HeaderFilters
   *
   * @param <T> the type of data table records
   */
  public interface HeaderFilter<T> extends IsElement<HTMLElement> {
    /**
     * Initializes the header filter with the data table search context and the column config to
     * which the filter is being added
     *
     * <p>this will be called by the {@link ColumnHeaderFilterPlugin}
     *
     * @param searchContext {@link SearchContext}
     * @param columnConfig {@link ColumnConfig}
     */
    void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig);

    /**
     * Clears the header filter component value
     *
     * <p>
     *
     * <p>this will be called by the {@link ColumnHeaderFilterPlugin}
     */
    void clear();
  }
}
