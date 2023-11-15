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

package org.dominokit.domino.ui.datatable.plugins.summary;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLTableCellElement;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Represents a cell within a summary row of a DataTable, containing a specific column's summary
 * data.
 *
 * @param <T> The type of data displayed in the DataTable.
 * @param <S> The type of data used for summary calculations.
 */
public class SummaryRowCell<T, S> {

  private final ColumnConfig<T> columnConfig;
  private final SummaryCellRenderer.SummaryCellInfo<T, S> cellInfo;
  private SummaryCellRenderer<T, S> defaultCellRenderer = cell -> elements.text();

  /**
   * Constructs a new {@code SummaryRowCell} for the given column configuration and summary cell
   * info.
   *
   * @param cellInfo The summary cell information associated with this cell.
   * @param columnConfig The column configuration associated with this cell.
   */
  public SummaryRowCell(
      SummaryCellRenderer.SummaryCellInfo<T, S> cellInfo, ColumnConfig<T> columnConfig) {
    this.columnConfig = columnConfig;
    this.cellInfo = cellInfo;
  }

  /**
   * Gets the column configuration associated with this summary cell.
   *
   * @return The {@link ColumnConfig} associated with this summary cell.
   */
  public ColumnConfig<T> getColumnConfig() {
    return columnConfig;
  }

  /**
   * Updates the content of this summary cell based on its associated column configuration and
   * summary data.
   */
  public void updateCell() {
    DominoElement<HTMLTableCellElement> cellElement = elements.elementOf(cellInfo.getElement());
    cellElement.clearElement();

    if (nonNull(columnConfig.getMinWidth())) {
      columnConfig.getHeadElement().style().setMinWidth(columnConfig.getMinWidth());
    }

    if (nonNull(columnConfig.getMaxWidth())) {
      columnConfig.getHeadElement().style().setMaxWidth(columnConfig.getMaxWidth());
    }

    if (nonNull(columnConfig.getTextAlign())) {
      cellElement.addCss(columnConfig.getTextAlign());
    }

    if (nonNull(columnConfig.getHeaderTextAlign())) {
      columnConfig.getHeadElement().addCss(columnConfig.getHeaderTextAlign());
    }

    Optional<SummaryMeta<T, S>> summaryMeta = SummaryMeta.get(columnConfig);
    if (summaryMeta.isPresent()) {
      cellElement.appendChild(summaryMeta.get().getCellRenderer().asElement(cellInfo));
    } else {
      cellElement.appendChild(defaultCellRenderer.asElement(cellInfo));
    }
  }

  /**
   * Gets the summary cell information associated with this cell.
   *
   * @return The {@link SummaryCellRenderer.SummaryCellInfo} associated with this cell.
   */
  public SummaryCellRenderer.SummaryCellInfo<T, S> getCellInfo() {
    return cellInfo;
  }
}
