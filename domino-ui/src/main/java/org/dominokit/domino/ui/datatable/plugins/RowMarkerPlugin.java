package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.DomGlobal;
import elemental2.dom.Text;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

import static java.util.Objects.nonNull;

/**
 * This plugin adds a thin colored border to the left of a row based on custom criteria
 * @param <T> the type of the data table records
 */
public class RowMarkerPlugin<T> implements DataTablePlugin<T> {

    private final MarkerColor<T> markerColor;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable.getTableConfig().insertColumnFirst(ColumnConfig.<T>create("data-table-marker-cm")
                .setSortable(false)
                .maxWidth("3px")
                .styleHeader(element -> Style.of(element).setPadding("0px", true)
                        .setWidth("3px", true))
                .styleCell(element -> Style.of(element).setPadding("0px", true)
                        .setWidth("3px", true))

                .setCellRenderer(cell -> {
                    ColorScheme colorScheme = markerColor.getColorScheme(cell);
                    if (nonNull(colorScheme)) {
                        Style.of(cell.getElement()).add(markerColor.getColorScheme(cell).color().getBackground());
                    }
                    return DomGlobal.document.createTextNode("");
                }));
    }
    /**
     * creates an instance with a custom marker color
     * @param markerColor {@link MarkerColor}
     */
    public RowMarkerPlugin(MarkerColor<T> markerColor) {
        this.markerColor = markerColor;
    }

    /**
     * An interface to implement different color markers
     * @param <T> the type of the table row record
     */
    @FunctionalInterface
    public interface MarkerColor<T> {
        /**
         * determines the Color scheme from the cell info
         * @param tableCellInfo {@link org.dominokit.domino.ui.datatable.CellRenderer.CellInfo}
         * @return the {@link ColorScheme}
         */
        ColorScheme getColorScheme(CellRenderer.CellInfo<T> tableCellInfo);
    }
}
