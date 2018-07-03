package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.EventType;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.span;

public class DataTableSortPlugin<T> implements DataTablePlugin<T> {

    private SortContainer currentContainer;

    @Override
    public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
        if (column.isSortable()) {
            SortContainer sortContainer = new SortContainer(column.getName());

            Style.of(column.getHeadElement()).css(Styles.cursor_pointer, Styles.disable_selection);
//            Style.of(sortContainer.sortElement)
//                    .setProperty("position", "absolute");
            column.contextMenu.appendChild(sortContainer.sortElement);
            column.getHeadElement().addEventListener(EventType.click.getName(), evt -> {
                Style.of(sortContainer.sortElement)
//                        .setProperty("position", "absolute")
                        .setProperty("right", "15px")
                        .setProperty("list-style", "none");
                sortContainer.clear();
                if (isNull(currentContainer)) {
                    sortContainer.update(false);
                } else {
                    currentContainer.clear();
                    sortContainer.update(currentContainer.columnName.equals(sortContainer.columnName));
                }
                currentContainer = sortContainer;
                dataTable.fireTableEvent(new SortEvent<>(currentContainer.sortDirection, column));
            });
        }
    }

    private class SortContainer {
        private final String columnName;
        private SortDirection sortDirection = SortDirection.DESC;
        private HTMLElement directionElement = Style.of(ElementUtil.builderFor(Icons.ALL.arrow_upward().asElement()).textContent(" ")).css(Styles.font_15).asElement();
        private HTMLElement sortElement = span().css(Styles.pull_right).add(directionElement)
                .style("min-width: 15px;")
                .asElement();

        public SortContainer(String columnName) {
            this.columnName = columnName;
        }

        public void clear() {
            directionElement.textContent = " ";
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
