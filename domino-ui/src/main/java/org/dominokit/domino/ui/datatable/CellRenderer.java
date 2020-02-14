package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

@FunctionalInterface
public interface CellRenderer<T> {
    Node asElement(CellInfo<T> cellInfo);

    class CellInfo<T>{
        private final TableRow<T> tableRow;
        private final HTMLTableCellElement element;
        private DirtyRecordHandler<T> dirtyRecordHandler = dirty -> {};
        private CellValidator cellValidator = ValidationResult::valid;

        public CellInfo(TableRow<T> tableRow, HTMLTableCellElement element) {
            this.tableRow = tableRow;
            this.element = element;
        }

        public TableRow<T> getTableRow() {
            return tableRow;
        }

        public HTMLTableCellElement getElement() {
            return element;
        }

        public T getRecord(){
            return tableRow.getRecord();
        }

        public void updateDirtyRecord(T dirtyRecord){
            if(nonNull(dirtyRecordHandler)){
                this.dirtyRecordHandler.onUpdateDirtyRecord(dirtyRecord);
            }
        }

        public ValidationResult validate(){
            if(nonNull(cellValidator)){
                return cellValidator.onValidate();
            }
            return ValidationResult.valid();
        }

        public void setDirtyRecordHandler(DirtyRecordHandler<T> dirtyRecordHandler) {
            this.dirtyRecordHandler = dirtyRecordHandler;
        }

        public void setCellValidator(CellValidator cellValidator) {
            this.cellValidator = cellValidator;
        }
    }
}
