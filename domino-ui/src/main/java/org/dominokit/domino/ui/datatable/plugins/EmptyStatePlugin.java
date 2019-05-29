package org.dominokit.domino.ui.datatable.plugins;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.layout.EmptyState;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;

public class EmptyStatePlugin<T> implements DataTablePlugin<T> {

    private EmptyState emptyState;

    public EmptyStatePlugin(BaseIcon<?> emptyStateIcon, String title) {
        emptyState = EmptyState.create(emptyStateIcon)
                .setTitle(title)
                .setIconColor(Color.GREY)
                .setTitleColor(Color.GREY)
                .styler(style -> style.remove(Styles.vertical_center));
    }

    @Override
    public void onAfterAddTable(DataTable dataTable) {
        dataTable.addTableEventListner(TableDataUpdatedEvent.DATA_UPDATED, event -> {
            TableDataUpdatedEvent tableDataUpdatedEvent = (TableDataUpdatedEvent) event;
            if (tableDataUpdatedEvent.getTotalCount() == 0) {
                emptyState.show();
            } else {
                emptyState.hide();
            }
        });
        dataTable.asElement().appendChild(emptyState.asElement());
    }

    public EmptyState getEmptyState() {
        return emptyState;
    }
}
