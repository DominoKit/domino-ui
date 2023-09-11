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
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLTableCellElement;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * This class represent a single cell in a data table row, and it contains information about the
 * cell row and column which it is part of
 *
 * @param <T> the type of the data table records
 */
public class SummaryRowCell<T, S> {

  private final ColumnConfig<T> columnConfig;
  private final SummaryCellRenderer.SummaryCellInfo<T, S> cellInfo;
  private SummaryCellRenderer<T, S> defaultCellRenderer = cell -> elements.text();

  /**
   * Creates and initialize an instance with the cell info and column info
   *
   * @param cellInfo the {@link org.dominokit.domino.ui.datatable.CellRenderer.CellInfo} information
   *     about this cell
   * @param columnConfig the {@link org.dominokit.domino.ui.datatable.ColumnConfig} the column this
   *     cell is part of
   */
  public SummaryRowCell(
      SummaryCellRenderer.SummaryCellInfo<T, S> cellInfo, ColumnConfig<T> columnConfig) {
    this.columnConfig = columnConfig;
    this.cellInfo = cellInfo;
  }

  /** @return the {@link ColumnConfig} the column this cell is part of */
  /**
   * Getter for the field <code>columnConfig</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   */
  public ColumnConfig<T> getColumnConfig() {
    return columnConfig;
  }

  /**
   * This method will force update the cell which might result on clearing all it content and
   * rerender them again with any updated data this is useful when for example changing a field
   * value in the record instance, and we want to reflect the change to the cell that renders the
   * field.
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

  /** @return the {@link CellRenderer.CellInfo} information about this cell */
  /**
   * Getter for the field <code>cellInfo</code>.
   *
   * @return a {@link
   *     org.dominokit.domino.ui.datatable.plugins.summary.SummaryCellRenderer.SummaryCellInfo}
   *     object
   */
  public SummaryCellRenderer.SummaryCellInfo<T, S> getCellInfo() {
    return cellInfo;
  }
}
