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

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_priority_cell;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_priority_details;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_secondary_cell;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_stacked;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_utility_cell;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.MediaQueryList;
import elemental2.dom.MediaQueryListListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;

/**
 * Enables an opt-in responsive presentation for a data table below a viewport breakpoint.
 *
 * <p>The default {@link Mode#STACKED} mode presents each cell as a labeled row. The opt-in {@link
 * Mode#PRIORITY_DETAILS} mode keeps named priority columns visible and delegates the remaining
 * record content to a {@link RecordDetailsPlugin}. Both modes preserve the table's native rows,
 * cells, and content; the corresponding responsive CSS is provided by Domino UI.
 *
 * <pre>
 * ResponsiveDataTablePlugin&lt;Employee&gt; responsive =
 *     ResponsiveDataTablePlugin.&lt;Employee&gt;create().setBreakpoint("768px");
 * TableConfig&lt;Employee&gt; config = new TableConfig&lt;Employee&gt;().addPlugin(responsive);
 *
 * ResponsiveDataTablePlugin&lt;Employee&gt; priorityDetails =
 *     ResponsiveDataTablePlugin.&lt;Employee&gt;create()
 *         .setMode(ResponsiveDataTablePlugin.Mode.PRIORITY_DETAILS)
 *         .setPriorityColumns("name", "status");
 * </pre>
 *
 * @param <T> the type of data displayed by the table
 */
public class ResponsiveDataTablePlugin<T> implements DataTablePlugin<T>, DataTableStyles {

  public static final String DEFAULT_BREAKPOINT = "768px";

  /** Responsive presentation used by this plugin. */
  public enum Mode {
    /** Displays each cell as a stacked, labeled row below the breakpoint. */
    STACKED,
    /** Keeps configured priority columns and delegates secondary details to RecordDetailsPlugin. */
    PRIORITY_DETAILS
  }

  private final ResponsiveBreakpointObserver breakpointObserver;
  private String breakpoint = DEFAULT_BREAKPOINT;
  private Mode mode = Mode.STACKED;
  private String[] priorityColumns = new String[0];

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

  /** Returns the responsive presentation mode. */
  public Mode getMode() {
    return mode;
  }

  /** Sets the responsive presentation mode. */
  public ResponsiveDataTablePlugin<T> setMode(Mode mode) {
    this.mode = Objects.requireNonNull(mode, "mode");
    return this;
  }

  /**
   * Sets the names of visible leaf columns to retain in priority/details mode.
   *
   * <p>The names are validated when the plugin is initialized with its DataTable, allowing columns
   * and plugins to be configured in either order before the table is constructed.
   */
  public ResponsiveDataTablePlugin<T> setPriorityColumns(String... columnNames) {
    this.priorityColumns =
        columnNames == null ? null : Arrays.copyOf(columnNames, columnNames.length);
    return this;
  }

  @Override
  public void init(DataTable<T> dataTable) {
    if (mode == Mode.PRIORITY_DETAILS) {
      validatePriorityConfiguration(dataTable);
    }
  }

  private void validatePriorityConfiguration(DataTable<T> dataTable) {
    if (priorityColumns == null || priorityColumns.length == 0) {
      throw new IllegalArgumentException(
          "PRIORITY_DETAILS mode requires at least one priority column name.");
    }

    boolean hasRecordDetailsPlugin =
        dataTable.getTableConfig().getPlugins().stream()
            .anyMatch(plugin -> plugin instanceof RecordDetailsPlugin);
    if (!hasRecordDetailsPlugin) {
      throw new IllegalArgumentException("PRIORITY_DETAILS mode requires a RecordDetailsPlugin.");
    }

    Set<String> configuredNames = new HashSet<>();
    List<ColumnConfig<T>> allColumns = dataTable.getTableConfig().getFlattenColumns();
    List<ColumnConfig<T>> leafColumns = dataTable.getTableConfig().getLeafColumns();
    for (String columnName : priorityColumns) {
      if (columnName == null || columnName.trim().isEmpty()) {
        throw new IllegalArgumentException(
            "PRIORITY_DETAILS mode contains a null or blank priority column name.");
      }
      if (!configuredNames.add(columnName)) {
        throw new IllegalArgumentException(
            "PRIORITY_DETAILS mode contains duplicate priority column name '" + columnName + "'.");
      }

      ColumnConfig<T> column =
          allColumns.stream()
              .filter(candidate -> columnName.equals(candidate.getName()))
              .findFirst()
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "Unknown priority column name '" + columnName + "'."));

      if (column.isColumnGroup()) {
        throw new IllegalArgumentException(
            "Priority column '" + columnName + "' is a group; configure its leaf columns.");
      }
      if (column.isUtilityColumn() || column.isPluginColumn()) {
        throw new IllegalArgumentException(
            "Priority column '" + columnName + "' is a utility/plugin column.");
      }
      if (!leafColumns.contains(column) || isHidden(column)) {
        throw new IllegalArgumentException(
            "Priority column '" + columnName + "' must be a visible leaf column.");
      }
    }
  }

  private boolean isHidden(ColumnConfig<T> column) {
    ColumnConfig<T> current = column;
    while (current != null) {
      if (current.isHidden()) {
        return true;
      }
      current = current.getParent();
    }
    return false;
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
                updateResponsiveState(dataTable, matches);
              }
            });
    dataTable.addOnBeforeRemoveListener(
        ignored -> {
          if (!removed[0]) {
            removed[0] = true;
            registration.remove();
            dataTable.element().classList.remove(dui_datatable_responsive_stacked.getCssClass());
            dataTable
                .element()
                .classList
                .remove(dui_datatable_responsive_priority_details.getCssClass());
          }
        });
  }

  private void updateResponsiveState(DataTable<T> dataTable, boolean matches) {
    String activeClass =
        mode == Mode.PRIORITY_DETAILS
            ? dui_datatable_responsive_priority_details.getCssClass()
            : dui_datatable_responsive_stacked.getCssClass();
    String inactiveClass =
        mode == Mode.PRIORITY_DETAILS
            ? dui_datatable_responsive_stacked.getCssClass()
            : dui_datatable_responsive_priority_details.getCssClass();

    if (matches) {
      if (mode == Mode.PRIORITY_DETAILS) {
        moveFocusFromSecondaryCell(dataTable);
      }
      dataTable.element().classList.remove(inactiveClass);
      dataTable.element().classList.add(activeClass);
    } else {
      dataTable.element().classList.remove(activeClass);
    }
  }

  private void moveFocusFromSecondaryCell(DataTable<T> dataTable) {
    Element activeElement = document.activeElement;
    if (activeElement == null) {
      return;
    }

    if (!dataTable.element().contains(activeElement)) {
      return;
    }

    Element secondaryCell = activeElement;
    while (secondaryCell != null
        && !secondaryCell.classList.contains(
            dui_datatable_responsive_secondary_cell.getCssClass())) {
      secondaryCell = secondaryCell.parentElement;
    }
    if (secondaryCell == null) {
      return;
    }

    Element row = secondaryCell;
    while (row != null && !"TR".equalsIgnoreCase(row.tagName)) {
      row = row.parentElement;
    }
    if (row == null) {
      return;
    }
    HTMLElement detailsControl =
        (HTMLElement)
            row.querySelector(
                "." + dui_datatable_responsive_utility_cell.getCssClass() + " [role='button']");
    if (detailsControl != null) {
      detailsControl.focus();
    }
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
              if (mode == Mode.PRIORITY_DETAILS) {
                if (column.isUtilityColumn() || column.isPluginColumn()) {
                  rowCell.addCss(dui_datatable_responsive_utility_cell);
                } else if (Arrays.asList(priorityColumns).contains(column.getName())) {
                  rowCell.addCss(dui_datatable_responsive_priority_cell);
                } else {
                  rowCell.addCss(dui_datatable_responsive_secondary_cell);
                }
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
