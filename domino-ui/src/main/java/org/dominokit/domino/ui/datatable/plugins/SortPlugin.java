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
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.DataSortEvent;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.elemento.EventType;

/**
 * This plugin adds sort capability to column headers on click
 *
 * @param <T> the type of the data table records
 */
public class SortPlugin<T> implements DataTablePlugin<T> {

  private SortContainer currentContainer;
  private Map<String, SortContainer> sortContainers = new HashMap<>();
  private DataTable<T> dataTable;

  /** {@inheritDoc} */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /** {@inheritDoc} */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isSortable()) {
      SortContainer sortContainer = new SortContainer(column.getSortKey());
      sortContainers.put(column.getSortKey(), sortContainer);

      column.getHeadElement().addCss(Styles.cursor_pointer, Styles.disable_selection);
      column.contextMenu.appendChild(sortContainer.sortElement);
      Style.of(column.contextMenu).setDisplay("block");
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
    DominoElement.of(sortContainer.sortElement)
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

  private class SortContainer {
    private final String columnName;
    private SortDirection sortDirection = SortDirection.DESC;
    private HTMLElement directionElement =
        Style.of(
                ElementUtil.contentBuilder(Icons.ALL.arrow_upward().element())
                    .textContent("import_export"))
            .addCss(Styles.font_15)
            .element();
    private HTMLElement sortElement =
        span().css(Styles.pull_right).add(directionElement).style("min-width: 15px;").element();

    public SortContainer(String columnName) {
      this.columnName = columnName;
    }

    public void clear() {
      directionElement.textContent = "import_export";
    }

    public void update(boolean flip) {
      if (flip) {
        if (SortDirection.ASC.equals(sortDirection)) {
          sortDirection = SortDirection.DESC;
        } else {
          sortDirection = SortDirection.ASC;
        }
      }
      clear();
      directionElement.textContent = getSortArrow();
    }

    public String getSortArrow() {
      if (SortDirection.ASC.equals(sortDirection)) {
        return Icons.ALL.arrow_upward().getName();
      } else {
        return Icons.ALL.arrow_downward().getName();
      }
    }
  }
}
