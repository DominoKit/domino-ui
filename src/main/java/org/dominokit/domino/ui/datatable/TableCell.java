package org.dominokit.domino.ui.datatable;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;

@FunctionalInterface
public interface TableCell<T> {
    Node asElement(Cell<T> cell);

    class Cell<T>{
        private final TableRow<T> tableRow;
        private final HTMLTableCellElement element;

        public Cell(TableRow<T> tableRow, HTMLTableCellElement element) {
            this.tableRow = tableRow;
            this.element = element;
        }

        public TableRow<T> getTableRow() {
            return tableRow;
        }

        public HTMLTableCellElement getElement() {
            return element;
        }
    }
}
