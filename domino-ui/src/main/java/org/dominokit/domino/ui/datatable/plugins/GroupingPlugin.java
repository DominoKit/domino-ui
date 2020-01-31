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
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.td;
import static org.jboss.elemento.Elements.tr;

public class GroupingPlugin<T> implements DataTablePlugin<T>, TableConfig.RowAppender<T> {

    private Map<String, DataGroup<T>> dataGroups = new HashMap<>();
    private final GroupSupplier<T> groupSupplier;
    private CellRenderer<T> groupRenderer;
    private Supplier<BaseIcon<?>> groupExpandedIconSupplier = Icons.ALL::minus_box_mdi;
    private Supplier<BaseIcon<?>> groupCollapsedIconSupplier = Icons.ALL::plus_box_mdi;

    public GroupingPlugin(GroupSupplier<T> groupSupplier, CellRenderer<T> groupRenderer) {
        this.groupSupplier = groupSupplier;
        this.groupRenderer = groupRenderer;
    }

    @Override
    public void init(DataTable<T> dataTable) {
        dataTable.getTableConfig()
                .setRowAppender(this);
    }

    public GroupingPlugin<T> setGroupExpandedIcon(Supplier<BaseIcon<?>> groupExpandedIconSupplier){
        this.groupExpandedIconSupplier = groupExpandedIconSupplier;
        return this;
    }

    public GroupingPlugin<T> setGroupCollapsedIcon(Supplier<BaseIcon<?>> groupCollapsedIconSupplier){
        this.groupCollapsedIconSupplier = groupCollapsedIconSupplier;
        return this;
    }

    @Override
    public void appendRow(DataTable<T> dataTable, TableRow<T> tableRow) {
        String groupId = groupSupplier.getRecordGroupId(tableRow);
        if (!dataGroups.containsKey(groupId)) {
            DataGroup<T> dataGroup = new DataGroup<>(tableRow);
            HTMLTableCellElement cellElement = td()
                    .attr("colspan", dataTable.getTableConfig().getColumns().size() + "")
                    .element();
            CellRenderer.CellInfo<T> cellInfo = new CellRenderer.CellInfo<>(tableRow, cellElement);

            cellElement.appendChild(FlexLayout.create()
                    .appendChild(FlexItem.create()
                            .appendChild(groupExpandedIconSupplier.get()
                                    .clickable()
                                    .setToggleIcon(groupCollapsedIconSupplier.get())
                                    .toggleOnClick(true)
                                    .addClickListener(evt -> dataGroup.toggleGroup())))
                    .appendChild(FlexItem.create()
                            .styler(style -> style.setLineHeight(px.of(35))
                                    .setPaddingLeft(px.of(10)))
                            .setFlexGrow(1)
                            .appendChild(groupRenderer.asElement(cellInfo)))
                    .element());

            dataTable.bodyElement().appendChild(tr().add(cellElement));
            dataTable.bodyElement().appendChild(tableRow.element());
            dataGroups.put(groupId, dataGroup);
        } else {
            DataGroup<T> dataGroup = dataGroups.get(groupId);
            Node nextSibling = dataGroup.lastRow.element().nextSibling;
            if (nonNull(nextSibling)) {
                DominoElement.of(dataTable.bodyElement()).insertBefore(tableRow.element(), nextSibling);
            } else {
                dataTable.bodyElement().appendChild(tableRow.element());
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
            groupRows.forEach(tableRow -> DominoElement.of(tableRow.element())
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
