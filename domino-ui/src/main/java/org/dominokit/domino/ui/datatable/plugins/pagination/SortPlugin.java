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

import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.DataSortEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.IconWrapper;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * This plugin adds sort capability to column headers on click
 *
 * @param <T> the type of the data table records
 */
public class SortPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, SortPlugin<T>, SortPluginConfig> {

  private SortContext currentSortContext;
  private Map<String, SortContext> sortContainers = new HashMap<>();
  private DataTable<T> dataTable;
  private SortPluginConfig config = new SortPluginConfig();

  /** {@inheritDoc} */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /** {@inheritDoc} */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isSortable()) {
      SortContext sortContext = new SortContext(column.getSortKey(), config);
      sortContainers.put(column.getSortKey(), sortContext);
      final boolean[] moving = new boolean[] {false};
      column.appendChild(div().addCss(dui_order_100).appendChild(sortContext.sortElement));
      column.getHeadElement().addCss(dui_cursor_pointer, dui_disable_text_select);
      column
          .getHeadElement()
          .addEventListener(
              EventType.mousemove.getName(),
              evt -> {
                moving[0] = true;
              })
          .addEventListener(
              EventType.mousedown.getName(),
              evt -> {
                moving[0] = false;
              });
      column
          .getHeadElement()
          .addEventListener(
              EventType.click.getName(),
              evt -> {
                if (!moving[0]) {
                  updateSort(sortContext);
                  fireSortEvent(currentSortContext.sortDirection, column);
                }
                moving[0] = false;
              });
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
   * manually sort the table by the specified column and fires the {@link
   * org.dominokit.domino.ui.datatable.events.SortEvent}
   *
   * @param direction the {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection}
   * @param column the sort {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   */
  public void sort(SortDirection direction, ColumnConfig<T> column) {
    SortContext sortContext = sortContainers.get(column.getSortKey());
    sortContext.sortDirection = direction;
    updateSort(sortContext);
    fireSortEvent(direction, column);
  }

  private void fireSortEvent(SortDirection direction, ColumnConfig<T> column) {
    dataTable.fireTableEvent(new SortEvent<>(direction, column));
  }

  /** {@inheritDoc} */
  @Override
  public void handleEvent(TableEvent event) {
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

  /** {@inheritDoc} */
  @Override
  public SortPlugin<T> setConfig(SortPluginConfig config) {
    this.config = config;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SortPluginConfig getConfig() {
    return config;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Use to update the configuration in the current plugin configuration
   */
  public SortPlugin<T> configure(Consumer<SortPluginConfig> handler) {
    handler.accept(config);
    return this;
  }

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

    public void clear() {
      sortDirection = SortDirection.NONE;
      sortIcon.setState(sortDirection.name());
    }

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
