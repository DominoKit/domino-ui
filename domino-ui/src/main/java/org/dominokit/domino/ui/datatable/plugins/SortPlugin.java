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

import static java.util.Objects.isNull;

import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.DataSortEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.events.EventType;

/**
 * This plugin adds sort capability to column headers on click
 *
 * @param <T> the type of the data table records
 */
public class SortPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, SortPlugin<T>, SortPluginConfig> {

  private SortContainer currentContainer;
  private Map<String, SortContainer> sortContainers = new HashMap<>();
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
    if (column.isSortable() && !column.isUtilityColumn()) {
      SortContainer sortContainer = new SortContainer(column.getSortKey(), config);
      sortContainers.put(column.getSortKey(), sortContainer);

      column
          .getHeaderLayout()
          .appendChild(FlexItem.create().setOrder(100).appendChild(sortContainer.sortElement));
      column.getHeadElement().addCss(dui_cursor_pointer, GenericCss.dui_disable_text_select);
      column
          .getHeadElement()
          .addEventListener(
              EventType.click.getName(),
              evt -> {
                updateStyles(sortContainer);
                fireSortEvent(currentContainer.sortDirection, column);
              });
    }
  }

  private void updateStyles(SortContainer sortContainer) {
    elements.elementOf(sortContainer.sortElement)
        .setCssProperty("right", "15px")
        .setCssProperty("list-style", "none");
    sortContainer.clear();
    if (isNull(currentContainer)) {
      sortContainer.update(false);
    } else {
      currentContainer.clear();
      sortContainer.update(currentContainer.columnName.equals(sortContainer.columnName));
    }
    currentContainer = sortContainer;
  }

  /**
   * manually sort the table by the specified column and fires the {@link SortEvent}
   *
   * @param direction the {@link SortDirection}
   * @param column the sort {@link ColumnConfig}
   */
  public void sort(SortDirection direction, ColumnConfig<T> column) {
    SortContainer sortContainer = sortContainers.get(column.getSortKey());
    updateStyles(sortContainer);
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
        SortContainer sortContainer = sortContainers.get(dataSortEvent.getSortColumn());
        sortContainer.sortDirection = dataSortEvent.getSortDirection();
        sortContainer.update(false);
        currentContainer = sortContainer;
      }
    }
  }

  @Override
  public SortPlugin<T> setConfig(SortPluginConfig config) {
    this.config = config;
    return this;
  }

  @Override
  public SortPluginConfig getConfig() {
    return config;
  }

  /**
   * Use to update the configuration in the current plugin configuration
   *
   * @param handler {@link Consumer} of {@link SortPluginConfig}
   * @return same plugin instance.
   */
  public SortPlugin<T> configure(Consumer<SortPluginConfig> handler) {
    handler.accept(config);
    return this;
  }

  private static class SortContainer {
    private final String columnName;
    private SortPluginConfig config;
    private SortDirection sortDirection = SortDirection.DESC;
    private DominoElement<HTMLElement> sortElement =
        elements.elementOf(elements.span()).appendChild(Icons.sort()).setMinWidth("15px");

    public SortContainer(String columnName, SortPluginConfig config) {
      this.columnName = columnName;
      this.config = config;
    }

    public void clear() {
      sortElement.clearElement().appendChild(Icons.sort());
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
      clear();
      sortElement.clearElement().appendChild(getSortArrow());
    }

    public Icon<?> getSortArrow() {
      if (SortDirection.ASC.equals(sortDirection)) {
        return Icons.sort_ascending();
      } else if (SortDirection.DESC.equals(sortDirection)) {
        return Icons.sort_descending();
      } else {
        return Icons.sort();
      }
    }
  }
}
