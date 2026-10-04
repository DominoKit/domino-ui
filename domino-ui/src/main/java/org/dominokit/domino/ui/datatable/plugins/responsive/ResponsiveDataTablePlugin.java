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
package org.dominokit.domino.ui.datatable.plugins.responsive;

import static elemental2.dom.DomGlobal.window;

import elemental2.dom.MediaQueryList;
import elemental2.dom.MediaQueryListListener;
import java.util.Objects;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;

/**
 * Enables an opt-in, CSS-stacked presentation for a data table below a viewport breakpoint.
 *
 * <p>The plugin preserves the table's native rows, cells, and content. It supplies cell labels and
 * header associations for the responsive presentation; the corresponding CSS is provided by Domino
 * UI.
 *
 * <pre>
 * ResponsiveDataTablePlugin&lt;Employee&gt; responsive =
 *     ResponsiveDataTablePlugin.&lt;Employee&gt;create().setBreakpoint("768px");
 * TableConfig&lt;Employee&gt; config = new TableConfig&lt;Employee&gt;().addPlugin(responsive);
 * </pre>
 *
 * @param <T> the type of data displayed by the table
 */
public class ResponsiveDataTablePlugin<T> implements DataTablePlugin<T>, DataTableStyles {

  public static final String DEFAULT_BREAKPOINT = "768px";

  private final ResponsiveBreakpointObserver breakpointObserver;
  private String breakpoint = DEFAULT_BREAKPOINT;

  /** Creates a responsive data table plugin using the browser's media-query API. */
  public static <T> ResponsiveDataTablePlugin<T> create() {
    return new ResponsiveDataTablePlugin<>(new BrowserResponsiveBreakpointObserver());
  }

  ResponsiveDataTablePlugin(ResponsiveBreakpointObserver breakpointObserver) {
    this.breakpointObserver = Objects.requireNonNull(breakpointObserver);
  }

  /** Sets the maximum viewport width at which the stacked presentation is enabled. */
  public ResponsiveDataTablePlugin<T> setBreakpoint(String breakpoint) {
    this.breakpoint = breakpoint;
    return this;
  }

  @Override
  public void onAfterAddTable(DataTable<T> dataTable) {
    String query = "(max-width: " + breakpoint + ")";
    boolean[] removed = {false};
    ResponsiveBreakpointObserver.Registration registration =
        breakpointObserver.observe(
            query,
            matches -> {
              if (!removed[0]) {
                if (matches) {
                  dataTable.element().classList.add(dui_datatable_responsive_stacked.getCssClass());
                } else {
                  dataTable
                      .element()
                      .classList
                      .remove(dui_datatable_responsive_stacked.getCssClass());
                }
              }
            });
    dataTable.addOnBeforeRemoveListener(
        ignored -> {
          if (!removed[0]) {
            removed[0] = true;
            registration.remove();
            dataTable.element().classList.remove(dui_datatable_responsive_stacked.getCssClass());
          }
        });
  }

  @Override
  public void onAfterAddCell(DataTable<T> dataTable, TableRow<T> tableRow, RowCell<T> rowCell) {
    rowCell
        .getColumnConfig()
        .ifPresent(
            column -> {
              rowCell.setAttribute("data-label", getColumnLabel(column));
              String headerId = ensureHeaderId(column);
              if (headerId != null) {
                rowCell.setAttribute("headers", headerId);
              }
            });
  }

  private String getColumnLabel(ColumnConfig<T> column) {
    String title = column.getTitle();
    return title == null || title.trim().isEmpty() ? column.getName() : title;
  }

  private String ensureHeaderId(ColumnConfig<T> column) {
    if (column.getHeadElement() == null) {
      return null;
    }
    String id = column.getHeadElement().getAttribute("id");
    if (id == null || id.isEmpty()) {
      id = column.getHeadElement().getDominoId();
      column.getHeadElement().setAttribute("id", id);
    }
    return id;
  }

  private static class BrowserResponsiveBreakpointObserver implements ResponsiveBreakpointObserver {

    @Override
    public Registration observe(String query, Consumer<Boolean> onChange) {
      MediaQueryList mediaQuery = window.matchMedia(query);
      MediaQueryListListener listener = list -> onChange.accept(list.matches);
      mediaQuery.addListener(listener);
      onChange.accept(mediaQuery.matches);
      return () -> mediaQuery.removeListener(listener);
    }
  }
}
