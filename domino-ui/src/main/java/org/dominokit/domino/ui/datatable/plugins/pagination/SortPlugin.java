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

package org.dominokit.domino.ui.datatable.plugins.pagination;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.plugins.PluginsConstants.DUI_DT_COL_RESIZING;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.DataSortEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.IconWrapper;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DominoEvent;
import org.dominokit.domino.ui.utils.PrefixAddOn;

/**
 * A plugin for adding sorting functionality to a DataTable. This plugin allows users to click on
 * the table headers to sort the data in ascending or descending order.
 *
 * @param <T> The type of data in the DataTable.
 */
public class SortPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, SortPlugin<T>, SortPluginConfig> {

  private SortContext currentSortContext;
  private Map<String, SortContext> sortContainers = new HashMap<>();
  private DataTable<T> dataTable;
  private SortPluginConfig config = new SortPluginConfig();

  /**
   * Initializes the plugin with the DataTable instance.
   *
   * @param dataTable The DataTable instance to which this plugin is applied.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /**
   * Adds sorting functionality to the table header columns that are marked as sortable.
   *
   * @param dataTable The DataTable instance to which this plugin is applied.
   * @param column The column configuration to which sorting functionality is added.
   */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isSortable()) {
      SortContext sortContext = new SortContext(column.getSortKey(), config);
      sortContainers.put(column.getSortKey(), sortContext);
      column.appendChild(div().addCss(dui_order_100).appendChild(sortContext.sortElement));
      column.getHeadElement().addCss(dui_cursor_pointer, dui_disable_text_select);
      column
          .getHeadElement()
          .addEventListener(
              EventType.click.getName(),
              evt -> {
                applySort(column, sortContext, currentSortContext.sortDirection);
              });
      if (config.isShowSortOptionsInColumnMenu()) {
        column
            .getMenu()
            .appendChild(
                MenuItem.<String>create(config.getSortAscendingLabel())
                    .appendChild(PrefixAddOn.of(config.getAscendingIcon().get()))
                    .addSelectionListener(
                        (source, selection) -> applySort(column, sortContext, SortDirection.ASC)))
            .appendChild(
                MenuItem.<String>create(config.getSortDescendingLabel())
                    .appendChild(PrefixAddOn.of(config.getDescendingIcon().get()))
                    .addSelectionListener(
                        (source, selection) -> applySort(column, sortContext, SortDirection.DESC)));

        if (config.isTriStateSort()) {
          column
              .getMenu()
              .appendChild(
                  MenuItem.<String>create(config.getNoSortLabel())
                      .appendChild(PrefixAddOn.of(config.getUnsortedIcon().get()))
                      .addSelectionListener(
                          (source, selection) ->
                              applySort(column, sortContext, SortDirection.NONE)));
        }
      }
    }
  }

  private void applySort(
      ColumnConfig<T> column, SortContext sortContext, SortDirection sortDirection) {
    if (this.dataTable.getMeta(DUI_DT_COL_RESIZING).isEmpty()) {
      if (config.isShowIconOnSortedColumnOnly() && nonNull(currentSortContext)) {
        currentSortContext.sortElement.clearElement();
      }
      sortContext.sortElement.appendChild(sortContext.sortIcon);
      updateSort(sortContext);
      fireSortEvent(sortDirection, column);
    }
  }

  private void updateSort(SortContext sortContext) {
    if (nonNull(currentSortContext)
        && !currentSortContext.columnName.equals(sortContext.columnName)) {
      currentSortContext.clear();
    }
    sortContext.update(true);
    currentSortContext = sortContext;
  }

  /**
   * Sorts the table data in the specified direction for the given column.
   *
   * @param direction The sorting direction (ascending or descending).
   * @param column The column to be sorted.
   */
  public void sort(SortDirection direction, ColumnConfig<T> column) {
    SortContext sortContext = sortContainers.get(column.getSortKey());
    sortContext.sortDirection = direction;
    updateSort(sortContext);
    fireSortEvent(direction, column);
  }

  /**
   * Fires a SortEvent to notify listeners of a sorting operation.
   *
   * @param direction The sorting direction.
   * @param column The column being sorted.
   */
  private void fireSortEvent(SortDirection direction, ColumnConfig<T> column) {
    dataTable.fireTableEvent(new SortEvent<>(direction, column));
  }

  /**
   * Handles sorting-related events, such as DataSortEvent.
   *
   * @param event The event to handle.
   */
  @Override
  public void handleEvent(DominoEvent event) {
    if (DataSortEvent.EVENT.equalsIgnoreCase(event.getType())) {
      DataSortEvent dataSortEvent = (DataSortEvent) event;
      if (sortContainers.containsKey(dataSortEvent.getSortColumn())) {
        SortContext sortContext = sortContainers.get(dataSortEvent.getSortColumn());
        sortContext.sortDirection = dataSortEvent.getSortDirection();
        sortContext.update(false);
        currentSortContext = sortContext;
      }
    }
  }

  /**
   * Sets the configuration for this plugin.
   *
   * @param config The SortPluginConfig to set.
   * @return This SortPlugin instance for method chaining.
   */
  @Override
  public SortPlugin<T> setConfig(SortPluginConfig config) {
    this.config = config;
    return this;
  }

  /**
   * Gets the current configuration for this plugin.
   *
   * @return The SortPluginConfig.
   */
  @Override
  public SortPluginConfig getConfig() {
    return config;
  }

  /**
   * Configures the SortPlugin using a consumer that modifies the configuration settings.
   *
   * @param handler The consumer to apply configuration changes.
   * @return This SortPlugin instance for method chaining.
   */
  public SortPlugin<T> configure(Consumer<SortPluginConfig> handler) {
    handler.accept(config);
    return this;
  }

  /** A helper class for managing the sorting state of a column. */
  private static class SortContext {
    private final String columnName;
    private SortPluginConfig config;
    private SortDirection sortDirection = SortDirection.DESC;
    private DominoElement<HTMLElement> sortElement;
    private StateIcon sortIcon;

    public SortContext(String columnName, SortPluginConfig config) {
      this.columnName = columnName;
      this.config = config;
      sortIcon =
          StateIcon.create(config.getUnsortedIcon().get())
              .withState(SortDirection.NONE.name(), new IconWrapper(config.getUnsortedIcon().get()))
              .withState(SortDirection.ASC.name(), new IconWrapper(config.getAscendingIcon().get()))
              .withState(
                  SortDirection.DESC.name(), new IconWrapper(config.getDescendingIcon().get()));
      sortElement = elements.elementOf(elements.span());
      if (!config.isShowIconOnSortedColumnOnly()) {
        sortElement.appendChild(sortIcon);
      }
    }

    /** Clears the sorting state of the column. */
    public void clear() {
      sortDirection = SortDirection.NONE;
      sortIcon.setState(sortDirection.name());
    }

    /**
     * Updates the sorting state of the column, optionally flipping the sort direction.
     *
     * @param flip Whether to flip the sort direction.
     */
    public void update(boolean flip) {
      if (flip) {
        if (sortDirection.NONE.equals(sortDirection)) {
          sortDirection = SortDirection.ASC;
        } else if (SortDirection.ASC.equals(sortDirection)) {
          sortDirection = SortDirection.DESC;
        } else if (SortDirection.DESC.equals(sortDirection)) {
          if (config.isTriStateSort()) {
            sortDirection = SortDirection.NONE;
          } else {
            sortDirection = SortDirection.ASC;
          }
        }
      }
      sortIcon.setState(sortDirection.name());
    }
  }
}
