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
package org.dominokit.domino.ui.datatable;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import java.util.Optional;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

/**
 * A functional interface representing the renderer responsible for rendering a cell within the data
 * table.
 *
 * @param <T> the type of data contained within the table row.
 */
@FunctionalInterface
public interface CellRenderer<T> {

  /**
   * Converts the given cell information into a displayable Node element.
   *
   * @param cellInfo information about the cell being rendered.
   * @return the Node representation of the cell content.
   */
  Node asElement(CellInfo<T> cellInfo);

  /**
   * Represents the detailed information of a specific cell in the data table.
   *
   * @param <T> the type of data contained within the table row.
   */
  class CellInfo<T> {
    private final TableRow<T> tableRow;
    private final HTMLTableCellElement element;
    private DirtyRecordHandler<T> dirtyRecordHandler = dirty -> {};
    private CellValidator cellValidator = ValidationResult::valid;
    private ColumnConfig<T> columnConfig;

    /**
     * Creates a new cell information instance.
     *
     * @param tableRow the table row containing the cell.
     * @param element the HTML element representation of the cell.
     */
    public CellInfo(TableRow<T> tableRow, HTMLTableCellElement element) {
      this.tableRow = tableRow;
      this.element = element;
      this.columnConfig = null;
    }

    /**
     * Creates a new cell information instance.
     *
     * @param tableRow the table row containing the cell.
     * @param element the HTML element representation of the cell.
     */
    public CellInfo(
        TableRow<T> tableRow, ColumnConfig<T> columnConfig, HTMLTableCellElement element) {
      this.tableRow = tableRow;
      this.element = element;
      this.columnConfig = columnConfig;
    }

    /**
     * Returns the table row containing the cell.
     *
     * @return the table row.
     */
    public TableRow<T> getTableRow() {
      return tableRow;
    }

    /**
     * Returns the HTML element representation of the cell.
     *
     * @return the cell element.
     */
    public HTMLTableCellElement getElement() {
      return element;
    }

    /**
     * Returns the data record associated with the table row containing the cell.
     *
     * @return the data record.
     */
    public T getRecord() {
      return tableRow.getRecord();
    }

    /** @return The column config the cell belongs to. */
    public Optional<ColumnConfig<T>> getColumnConfig() {
      return Optional.ofNullable(columnConfig);
    }

    /**
     * Invokes the handler for updating a dirty record.
     *
     * @param dirtyRecord the updated record.
     */
    public void updateDirtyRecord(T dirtyRecord) {
      if (nonNull(dirtyRecordHandler)) {
        this.dirtyRecordHandler.onUpdateDirtyRecord(dirtyRecord);
      }
    }

    /**
     * Validates the cell's content.
     *
     * @return the validation result.
     */
    public ValidationResult validate() {
      if (nonNull(cellValidator)) {
        return cellValidator.onValidate();
      }
      return ValidationResult.valid();
    }

    /**
     * Sets the handler responsible for updating dirty records.
     *
     * @param dirtyRecordHandler the handler to be set.
     */
    public void setDirtyRecordHandler(DirtyRecordHandler<T> dirtyRecordHandler) {
      this.dirtyRecordHandler = dirtyRecordHandler;
    }

    /**
     * Sets the validator for the cell's content.
     *
     * @param cellValidator the validator to be set.
     */
    public void setCellValidator(CellValidator cellValidator) {
      this.cellValidator = cellValidator;
    }
  }
}
