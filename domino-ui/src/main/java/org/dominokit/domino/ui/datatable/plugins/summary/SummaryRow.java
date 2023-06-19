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

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.elements.TDElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class SummaryRow<T, S> extends BaseDominoElement<HTMLTableRowElement, SummaryRow<T, S>>
    implements DataTableStyles {
  private S record;
  private final int index;
  private DataTable<T> dataTable;
  private final Map<String, SummaryRowCell<T, S>> rowCells = new HashMap<>();
  private TableRowElement element = tr().addCss(dui_datatable_row);
  private SummaryRowRenderer<T, S> rowRenderer = new DefaultSummaryRowRenderer<>();

  public SummaryRow(S record, int index, DataTable<T> dataTable) {
    this.record = record;
    this.index = index;
    this.dataTable = dataTable;
    init(this);
  }

  public void setRecord(S record) {
    this.record = record;
  }

  public S getRecord() {
    return record;
  }

  public DataTable<T> getDataTable() {
    return dataTable;
  }

  @Override
  public HTMLTableRowElement element() {
    return element.element();
  }

  public void addCell(SummaryRowCell<T, S> rowCell) {
    rowCells.put(rowCell.getColumnConfig().getName(), rowCell);
  }

  public SummaryRowCell<T, S> getCell(String name) {
    return rowCells.get(name);
  }

  public int getIndex() {
    return index;
  }

  public void updateRow() {
    updateRow(this.record);
  }

  public void updateRow(S record) {
    this.record = record;
    rowCells.values().forEach(SummaryRowCell::updateCell);
  }

  public Map<String, SummaryRowCell<T, S>> getRowCells() {
    return Collections.unmodifiableMap(rowCells);
  }

  public void render() {
    rowRenderer.render(dataTable, this);
  }

  /**
   * An interface to implement listeners for Table row changes
   *
   * @param <T> the type of the data table records
   */
  @FunctionalInterface
  public interface RowListener<T, S> {
    /** @param summaryRow the changed {@link SummaryRow} */
    void onChange(SummaryRow<T, S> summaryRow);
  }

  public void renderCell(ColumnConfig<T> columnConfig) {
    TDElement cellElement = td().addCss(dui_datatable_td);

    ColumnCssRuleMeta.get(columnConfig)
        .ifPresent(
            meta ->
                meta.cssRules()
                    .forEach(
                        columnCssRule ->
                            cellElement.addCss(() -> columnCssRule.getCssRule().getCssClass())));

    SummaryRowCell<T, S> rowCell =
        new SummaryRowCell<>(
            new SummaryCellRenderer.SummaryCellInfo<>(this, cellElement.element()), columnConfig);
    rowCell.updateCell();
    addCell(rowCell);

    columnConfig.applyScreenMedia(cellElement.element());

    if (columnConfig.isHidden()) {
      cellElement.hide();
    }
    element().appendChild(cellElement.element());
    columnConfig.addShowHideListener(DefaultColumnShowHideListener.of(cellElement.element()));
  }

  public interface SummaryRowRenderer<T, S> {
    void render(DataTable<T> dataTable, SummaryRow<T, S> summaryRow);
  }

  private static class DefaultSummaryRowRenderer<T, S> implements SummaryRowRenderer<T, S> {

    @Override
    public void render(DataTable<T> dataTable, SummaryRow<T, S> summaryRow) {

      List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
      for (int i = 0; i < columns.size(); i++) {
        summaryRow.renderCell(columns.get(i));
        SummaryRowCell<T, S> addedCell = summaryRow.rowCells.get(columns.get(i).getName());
        DominoElement<HTMLTableCellElement> cell =
            elements.elementOf(addedCell.getCellInfo().getElement());
        if (cell.hasAttribute("colspan")) {
          int colspan = Integer.parseInt(cell.getAttribute("colspan"));
          if (colspan > 1) {
            i += colspan - 1;
          }
        }
      }
    }
  }
}
