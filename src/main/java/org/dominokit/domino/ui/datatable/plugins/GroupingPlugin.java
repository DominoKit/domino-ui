package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.OnBeforeDataChangeEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.gwt.elemento.core.Elements.td;
import static org.jboss.gwt.elemento.core.Elements.tr;

public class GroupingPlugin<T> implements DataTablePlugin<T>, TableConfig.RowAppender<T> {

    private Map<String, DataGroup<T>> dataGroups = new HashMap<>();
    private final GroupSupplier<T> groupSupplier;
    private CellRenderer<T> groupRenderer;

    public GroupingPlugin(GroupSupplier<T> groupSupplier, CellRenderer<T> groupRenderer) {
        this.groupSupplier = groupSupplier;
        this.groupRenderer = groupRenderer;
    }

    @Override
    public void init(DataTable<T> dataTable) {
        dataTable.getTableConfig()
                .setRowAppender(this);
    }

    @Override
    public void appendRow(DataTable<T> dataTable, TableRow<T> tableRow) {
        String groupId = groupSupplier.getRecordGroupId(tableRow);
        if (!dataGroups.containsKey(groupId)) {
            DataGroup<T> dataGroup = new DataGroup<>(tableRow);
            HTMLTableCellElement cellElement = td()
                    .attr("colspan", dataTable.getTableConfig().getColumns().size() + "")
                    .asElement();
            CellRenderer.CellInfo<T> cellInfo = new CellRenderer.CellInfo<>(tableRow, cellElement);

            cellElement.appendChild(FlexLayout.create()
                    .appendChild(FlexItem.create()
                            .appendChild(Icons.ALL.minus_mdi()
                                    .clickable()
                                    .setToggleIcon(Icons.ALL.plus_mdi())
                                    .toggleOnClick(true)
                                    .addClickListener(evt -> dataGroup.toggleGroup())))
                    .appendChild(FlexItem.create()
                            .styler(style -> style.setLineHeight(px.of(35))
                                    .setPaddingLeft(px.of(10)))
                            .setFlexGrow(1)
                            .appendChild(groupRenderer.asElement(cellInfo)))
                    .asElement());

            dataTable.bodyElement().appendChild(tr().add(cellElement));
            dataTable.bodyElement().appendChild(tableRow.asElement());
            dataGroups.put(groupId, dataGroup);
        } else {
            DataGroup<T> dataGroup = dataGroups.get(groupId);
            Node nextSibling = dataGroup.lastRow.asElement().nextSibling;
            if (nonNull(nextSibling)) {
                DominoElement.of(dataTable.bodyElement()).insertBefore(tableRow.asElement(), nextSibling);
            } else {
                dataTable.bodyElement().appendChild(tableRow.asElement());
            }

            dataGroup.lastRow = tableRow;
            dataGroup.addRow(tableRow);

        }
    }

    @Override
    public void handleEvent(TableEvent event) {
        if (event.getType().equalsIgnoreCase(OnBeforeDataChangeEvent.ON_BEFORE_DATA_CHANGE)) {
            dataGroups.clear();
        }
    }

    private class DataGroup<T> {

        private List<TableRow<T>> groupRows = new ArrayList<>();
        private TableRow<T> lastRow;
        private boolean expanded = true;

        public DataGroup(TableRow<T> lastRow) {
            this.lastRow = lastRow;
            groupRows.add(lastRow);
        }

        public void toggleGroup() {
            expanded = !expanded;
            groupRows.forEach(tableRow -> DominoElement.of(tableRow.asElement())
                    .toggleDisplay(expanded));

        }

        public void addRow(TableRow<T> tableRow) {
            groupRows.add(tableRow);
        }

    }

    @FunctionalInterface
    public interface GroupSupplier<T> {
        String getRecordGroupId(TableRow<T> tableRow);
    }

}
