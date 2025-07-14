/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dominokit.domino.ui.datatable.plugins.marker;

import static java.util.Objects.nonNull;

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.DominoEvent;

/**
 * A DataTable plugin that adds row markers based on the provided {@link MarkerColor} function.
 *
 * @param <T> The type of data in the DataTable.
 */
public class RowMarkerPlugin<T> implements DataTablePlugin<T>, DataTableStyles {

  private final MarkerColor<T> markerColor;

  /**
   * Creates a new {@link RowMarkerPlugin} with the specified marker color function.
   *
   * @param markerColor The function that determines the marker color for each row.
   */
  public RowMarkerPlugin(MarkerColor<T> markerColor) {
    this.markerColor = markerColor;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Adds the CSS class for row markers to the DataTable before adding it.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   */
  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    dataTable.addCss(dui_datatable_row_marker);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Sets the marker style for the newly added row.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param tableRow The newly added TableRow.
   */
  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    setStyle(tableRow);
  }

  /**
   * Sets the CSS style for the specified table row based on the marker color function.
   *
   * @param tableRow The TableRow for which to set the style.
   */
  private void setStyle(TableRow<T> tableRow) {
    CssClass color = markerColor.getColor(tableRow);
    RowMarkerMeta.get(tableRow).ifPresent(meta -> meta.getMarkerCssClass().remove(tableRow));

    if (nonNull(color)) {
      tableRow.addCss(color);
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>Handles row record updated events by updating the row marker style.
   *
   * @param event The table event to handle.
   */
  @Override
  public void handleEvent(DominoEvent event) {
    if (RowRecordUpdatedEvent.RECORD_UPDATED.equals(event.getType())) {
      setStyle(((RowRecordUpdatedEvent<T>) event).getTableRow());
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>Specifies the order in which this plugin should be executed. It has the highest order value
   * to ensure that it runs last.
   *
   * @return The order value, set to {@link Integer#MAX_VALUE}.
   */
  @Override
  public int order() {
    return Integer.MAX_VALUE;
  }

  /**
   * Functional interface for determining the marker color for a row.
   *
   * @param <T> The type of data in the DataTable.
   */
  @FunctionalInterface
  public interface MarkerColor<T> {

    /**
     * Returns the marker color CSS class for the specified table row.
     *
     * @param tableRow The TableRow for which to determine the marker color.
     * @return The CSS class representing the marker color for the row.
     */
    CssClass getColor(TableRow<T> tableRow);
  }
}
