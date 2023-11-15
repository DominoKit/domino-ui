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

import static org.dominokit.domino.ui.utils.Domino.*;

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

/**
 * The {@code SummaryRow} class represents a summary row in a {@link DataTable}. Summary rows
 * provide aggregate information about the data in the table.
 *
 * @param <T> The type of data in the DataTable.
 * @param <S> The type of data in the summary row.
 * @see BaseDominoElement
 */
public class SummaryRow<T, S> extends BaseDominoElement<HTMLTableRowElement, SummaryRow<T, S>>
    implements DataTableStyles {
  private S record;
  private final int index;
  private DataTable<T> dataTable;
  private final Map<String, SummaryRowCell<T, S>> rowCells = new HashMap<>();
  private TableRowElement element = tr().addCss(dui_datatable_row);
  private SummaryRowRenderer<T, S> rowRenderer = new DefaultSummaryRowRenderer<>();

  /**
   * Constructs a new SummaryRow instance.
   *
   * @param record The summary record to be displayed in the row.
   * @param index The index of the summary row.
   * @param dataTable The DataTable to which this summary row belongs.
   */
  public SummaryRow(S record, int index, DataTable<T> dataTable) {
    this.record = record;
    this.index = index;
    this.dataTable = dataTable;
    init(this);
  }

  /**
   * Sets the summary record to be displayed in the summary row.
   *
   * @param record The summary record.
   */
  public void setRecord(S record) {
    this.record = record;
  }

  /**
   * Gets the summary record displayed in the summary row.
   *
   * @return The summary record.
   */
  public S getRecord() {
    return record;
  }

  /**
   * Gets the DataTable to which this summary row belongs.
   *
   * @return The DataTable instance.
   */
  public DataTable<T> getDataTable() {
    return dataTable;
  }

  /**
   * Gets the HTML representation of the summary row.
   *
   * @return The HTMLTableRowElement of the summary row.
   */
  @Override
  public HTMLTableRowElement element() {
    return element.element();
  }

  /**
   * Adds a summary cell to the summary row.
   *
   * @param rowCell The summary cell to add.
   */
  public void addCell(SummaryRowCell<T, S> rowCell) {
    rowCells.put(rowCell.getColumnConfig().getName(), rowCell);
  }

  /**
   * Gets a summary cell by its column name.
   *
   * @param name The name of the column associated with the summary cell.
   * @return The SummaryRowCell instance.
   */
  public SummaryRowCell<T, S> getCell(String name) {
    return rowCells.get(name);
  }

  /**
   * Gets the index of the summary row.
   *
   * @return The index of the summary row.
   */
  public int getIndex() {
    return index;
  }

  /** Updates the summary row with the current summary record. */
  public void updateRow() {
    updateRow(this.record);
  }

  /**
   * Updates the summary row with the specified summary record.
   *
   * @param record The summary record to update the row with.
   */
  public void updateRow(S record) {
    this.record = record;
    rowCells.values().forEach(SummaryRowCell::updateCell);
  }

  /**
   * Gets an unmodifiable map of summary cells in the summary row.
   *
   * @return An unmodifiable map of summary cells.
   */
  public Map<String, SummaryRowCell<T, S>> getRowCells() {
    return Collections.unmodifiableMap(rowCells);
  }

  /** Renders the summary row based on the DataTable's column configuration. */
  public void render() {
    rowRenderer.render(dataTable, this);
  }

  /**
   * The {@code RowListener} interface represents a listener for changes to a {@code SummaryRow}.
   *
   * @param <T> The type of data in the DataTable.
   * @param <S> The type of data in the summary row.
   */
  @FunctionalInterface
  public interface RowListener<T, S> {

    /**
     * Called when a change occurs in a SummaryRow.
     *
     * @param summaryRow The SummaryRow instance that has changed.
     */
    void onChange(SummaryRow<T, S> summaryRow);
  }

  /**
   * Renders a summary cell for a specific column configuration and adds it to the summary row.
   *
   * @param columnConfig The {@link ColumnConfig} associated with the summary cell to be rendered.
   */
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

  /**
   * Renders a summary row based on the DataTable's column configuration.
   *
   * @param <T> The type of data in the DataTable.
   * @param <S> The type of data in the summary row.
   */
  public interface SummaryRowRenderer<T, S> {
    /**
     * Renders the summary row.
     *
     * @param dataTable The DataTable to which the summary row belongs.
     * @param summaryRow The SummaryRow to render.
     */
    void render(DataTable<T> dataTable, SummaryRow<T, S> summaryRow);
  }

  private static class DefaultSummaryRowRenderer<T, S> implements SummaryRowRenderer<T, S> {

    @Override
    public void render(DataTable<T> dataTable, SummaryRow<T, S> summaryRow) {

      List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
      for (int i = 0; i < columns.size(); i++) {
        summaryRow.renderCell(columns.get(i));
        SummaryRowCell<T, S> addedCell = summaryRow.rowCells.get(columns.get(i).getName());
        DominoElement<HTMLTableCellElement> cell = elementOf(addedCell.getCellInfo().getElement());
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
