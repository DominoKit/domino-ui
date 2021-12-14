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

import static java.util.Objects.nonNull;

import elemental2.dom.DomGlobal;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

/**
 * This plugin adds a thin colored border to the left of a row based on custom criteria
 *
 * @param <T> the type of the data table records
 */
public class RowMarkerPlugin<T> implements DataTablePlugin<T> {

  private final MarkerColor<T> markerColor;

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddHeaders(DataTable<T> dataTable) {
    dataTable
        .getTableConfig()
        .insertColumnFirst(
            ColumnConfig.<T>create("data-table-marker-cm")
                .setSortable(false)
                .setPluginColumn(true)
                .maxWidth("3px")
                .styleHeader(
                    element -> Style.of(element).setPadding("0px", true).setWidth("3px", true))
                .styleCell(
                    element -> Style.of(element).setPadding("0px", true).setWidth("3px", true))
                .setCellRenderer(
                    cell -> {
                      ColorScheme colorScheme = markerColor.getColorScheme(cell);
                      if (nonNull(colorScheme)) {
                        Optional<String> first =
                            cell.getElement().classList.asList().stream()
                                .filter(cssClass -> cssClass.startsWith("bg-"))
                                .findFirst();
                        first.ifPresent(
                            cssClass -> Style.of(cell.getElement()).removeCss(cssClass));
                        Style.of(cell.getElement())
                            .addCss(markerColor.getColorScheme(cell).color().getBackground());
                      }
                      return DomGlobal.document.createTextNode("");
                    }));
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
     * @param tableCellInfo {@link org.dominokit.domino.ui.datatable.CellRenderer.CellInfo}
     * @return the {@link ColorScheme}
     */
    ColorScheme getColorScheme(CellRenderer.CellInfo<T> tableCellInfo);
  }
}
