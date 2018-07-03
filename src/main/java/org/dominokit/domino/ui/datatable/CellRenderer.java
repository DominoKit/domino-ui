package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;

@FunctionalInterface
public interface CellRenderer<T> {
    Node asElement(CellInfo<T> cellInfo);

    class CellInfo<T>{
        private final TableRow<T> tableRow;
        private final HTMLTableCellElement element;

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
    }
}
