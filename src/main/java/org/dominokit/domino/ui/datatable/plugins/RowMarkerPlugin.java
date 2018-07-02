package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.Text;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableCell;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

import static java.util.Objects.nonNull;

public class RowMarkerPlugin<T> implements DataTablePlugin<T> {

    private final MarkerColor<T> markerColor;

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable.getTableConfig().insertColumnFirst(ColumnConfig.<T>create("data-table-marker-cm")
                .setSortable(false)
                .setSortable(false)
                .maxWidth("3px")
                .styleHeader(element -> Style.of(element).setPadding("0px", true)
                        .setWidth("3px", true))
                .styleCell(element -> Style.of(element).setPadding("0px", true)
                        .setWidth("3px", true))

                .setTableCell(cell -> {
                    ColorScheme colorScheme = markerColor.getColorScheme(cell);
                    if (nonNull(colorScheme)) {
                        Style.of(cell.getElement()).css(markerColor.getColorScheme(cell).color().getBackground());
                    }
                    return new Text("");
                }));
    }

    public RowMarkerPlugin(MarkerColor<T> markerColor) {
        this.markerColor = markerColor;
    }

    @FunctionalInterface
    public interface MarkerColor<T> {
        ColorScheme getColorScheme(TableCell.Cell<T> tableCell);
    }
}
