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
package org.dominokit.domino.ui.datatable.plugins;

import java.util.Optional;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * This plugin adds a thin colored border to the left of a row based on custom criteria
 *
 * @param <T> the type of the data table records
 */
public class RowMarkerPlugin<T> implements DataTablePlugin<T> {

  private final MarkerColor<T> markerColor;

  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    dataTable.tableElement().styler(style -> style.addCss("dt-row-marker"));
  }

  @Override
  public void onAfterAddHeaders(DataTable<T> dataTable) {}

  @Override
  public void onBeforeAddRow(DataTable<T> dataTable, TableRow<T> tableRow) {}

  @Override
  public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
    setStyle(tableRow);
  }

  private void setStyle(TableRow<T> tableRow) {
    ColorScheme colorScheme = markerColor.getColorScheme(tableRow);
    String color =
        Optional.ofNullable(colorScheme)
            .map(scheme -> colorScheme.color().getHex())
            .orElse("transparent");
    DominoElement.of(tableRow.element()).setCssProperty("border-left-color", color);
  }

  @Override
  public void handleEvent(TableEvent event) {
    if (RowRecordUpdatedEvent.RECORD_UPDATED.equals(event.getType())) {
      setStyle(((RowRecordUpdatedEvent<T>) event).getTableRow());
    }
  }

  /**
   * creates an instance with a custom marker color
   *
   * @param markerColor {@link MarkerColor}
   */
  public RowMarkerPlugin(MarkerColor<T> markerColor) {
    this.markerColor = markerColor;
  }

  /**
   * An interface to implement different color markers
   *
   * @param <T> the type of the table row record
   */
  @FunctionalInterface
  public interface MarkerColor<T> {
    /**
     * determines the Color scheme from the cell info
     *
     * @param tableRow {@link org.dominokit.domino.ui.datatable.TableRow}
     * @return the {@link ColorScheme}
     */
    ColorScheme getColorScheme(TableRow<T> tableRow);
  }
}
