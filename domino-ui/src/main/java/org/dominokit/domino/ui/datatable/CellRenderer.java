package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * An implementation of this interface will determine in how a table cell content will be displayed and rendered in the table
 * @param <T> the type of the data table records
 */
@FunctionalInterface
public interface CellRenderer<T> {
    /**
     * Takes a cell info to determine what content to append to the cell element
     * @param cellInfo {@link CellInfo}
     * @return the {@link Node} to be appended to the table cell element
     */
    Node asElement(CellInfo<T> cellInfo);

    /**
     * A class containing all information required about a cell in a data table
     * @param <T> the type of the data table records
     */
    class CellInfo<T>{
        private final TableRow<T> tableRow;
        private final HTMLTableCellElement element;
        private DirtyRecordHandler<T> dirtyRecordHandler = dirty -> {};
        private CellValidator cellValidator = ValidationResult::valid;

        /**
         * Creates an instance with the row that the belongs to and the cell html element
         * @param tableRow {@link TableRow}
         * @param element {@link HTMLTableCellElement} the td element
         */
        public CellInfo(TableRow<T> tableRow, HTMLTableCellElement element) {
            this.tableRow = tableRow;
            this.element = element;
        }

        /**
         *
         * @return the {@link TableRow} the cell belongs to
         */
        public TableRow<T> getTableRow() {
            return tableRow;
        }

        /**
         *
         * @return the {@link HTMLTableCellElement}, the td element
         */
        public HTMLTableCellElement getElement() {
            return element;
        }

        /**
         *
         * @return T the record instance being rendered on the row this belong to.
         */
        public T getRecord(){
            return tableRow.getRecord();
        }

        /**
         * For editable data table this will update the dirty record instance with the new fields values in the row being edited
         * @param dirtyRecord T, the current dirty record instance in the table row
         */
        public void updateDirtyRecord(T dirtyRecord){
            if(nonNull(dirtyRecordHandler)){
                this.dirtyRecordHandler.onUpdateDirtyRecord(dirtyRecord);
            }
        }

        /**
         * for editable cell this will validate the cell field
         * @return the {@link ValidationResult}
         */
        public ValidationResult validate(){
            if(nonNull(cellValidator)){
                return cellValidator.onValidate();
            }
            return ValidationResult.valid();
        }

        /**
         * set the handler to update the dirty record
         * @param dirtyRecordHandler {@link DirtyRecordHandler}
         */
        public void setDirtyRecordHandler(DirtyRecordHandler<T> dirtyRecordHandler) {
            this.dirtyRecordHandler = dirtyRecordHandler;
        }

        /**
         * for editable cells set the validator to validate the cell value when edited
         * @param cellValidator {@link CellValidator}
         */
        public void setCellValidator(CellValidator cellValidator) {
            this.cellValidator = cellValidator;
        }
    }
}
