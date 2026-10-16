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
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_priority_title_omitted;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_secondary_cell;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_stacked;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_responsive_utility_cell;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.MediaQueryList;
import elemental2.dom.MediaQueryListListener;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.RowRecordUpdatedEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer;
import org.dominokit.domino.ui.utils.DominoEventListener;
import org.dominokit.domino.ui.utils.ResizeObserver;

/**
 * Enables a responsive presentation for a data table below a viewport breakpoint.
 *
 * <p>The default {@link Mode#PRIORITY_DETAILS} mode keeps explicitly prioritized columns visible
 * and progressively moves other columns into responsive details as the table narrows. The {@link
 * Mode#STACKED} mode presents each cell as a labeled row. A {@link RecordDetailsPlugin}, when
 * configured, takes over details rendering; otherwise the plugin renders a built-in key/value view.
 *
 * <pre>
 * ColumnConfig&lt;Employee&gt; name = ColumnConfig.&lt;Employee&gt;create("name", "Name")
 *     .setResponsivePriority(true);
 * ResponsiveDataTablePlugin&lt;Employee&gt; responsive =
 *     ResponsiveDataTablePlugin.&lt;Employee&gt;create().setBreakpoint("768px");
 * TableConfig&lt;Employee&gt; config = new TableConfig&lt;Employee&gt;()
 *     .addColumn(name)
 *     .addPlugin(responsive);
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
  private final ResponsiveWidthObserver widthObserver;
  private String breakpoint = DEFAULT_BREAKPOINT;
  private double minimumColumnWidth = ResponsiveColumnCollapse.DEFAULT_COLUMN_MIN_WIDTH;
  private Mode mode = Mode.PRIORITY_DETAILS;
  private boolean builtInDetailsEnabled = true;
  private RecordDetailsRenderer<T> detailsRenderer;
  private boolean hasRecordDetailsPlugin;
  private boolean breakpointMatches;
  private double availableWidth;
  private final Map<String, Double> measuredColumnWidths = new LinkedHashMap<>();
  private final Set<String> collapsedColumns = new LinkedHashSet<>();
  private final Map<TableRow<T>, ResponsiveDetailsRow<T>> builtInDetails = new IdentityHashMap<>();

  /** Creates a responsive data table plugin using the browser's media-query API. */
  public static <T> ResponsiveDataTablePlugin<T> create() {
    return new ResponsiveDataTablePlugin<>(
        new BrowserResponsiveBreakpointObserver(), new BrowserResponsiveWidthObserver());
  }

  ResponsiveDataTablePlugin(ResponsiveBreakpointObserver breakpointObserver) {
    this(breakpointObserver, (element, onResize) -> () -> {});
  }

  ResponsiveDataTablePlugin(
      ResponsiveBreakpointObserver breakpointObserver, ResponsiveWidthObserver widthObserver) {
    this.breakpointObserver = Objects.requireNonNull(breakpointObserver);
    this.widthObserver = Objects.requireNonNull(widthObserver);
  }

  /** Sets the maximum viewport width at which the responsive presentation is enabled. */
  public ResponsiveDataTablePlugin<T> setBreakpoint(String breakpoint) {
    this.breakpoint = breakpoint;
    return this;
  }

  /** Returns the minimum width used when measuring columns for priority-details collapse. */
  public double getMinimumColumnWidth() {
    return minimumColumnWidth;
  }

  /**
   * Sets the minimum width used when measuring columns for priority-details collapse.
   *
   * <p>The default is 132 pixels.
   */
  public ResponsiveDataTablePlugin<T> setMinimumColumnWidth(double minimumColumnWidth) {
    if (minimumColumnWidth <= 0) {
      throw new IllegalArgumentException("minimumColumnWidth must be greater than zero.");
    }
    this.minimumColumnWidth = minimumColumnWidth;
    return this;
  }

  /** Returns the responsive presentation mode. */
  public Mode getMode() {
    return mode;
  }

  /** Sets the responsive presentation mode. */
  public ResponsiveDataTablePlugin<T> setMode(Mode mode) {
    this.mode = Objects.requireNonNull(mode, "Responsive Mode cannot be null.");
    return this;
  }

  /**
   * Enables or disables the built-in priority-details presentation.
   *
   * <p>A configured {@link RecordDetailsPlugin} takes over details rendering automatically.
   */
  public ResponsiveDataTablePlugin<T> setBuiltInDetailsEnabled(boolean enabled) {
    this.builtInDetailsEnabled = enabled;
    return this;
  }

  /**
   * Sets a custom renderer for each built-in priority-details row.
   *
   * <p>When unset, secondary columns are displayed as key/value pairs using their existing rendered
   * cell content.
   */
  public ResponsiveDataTablePlugin<T> setDetailsRenderer(RecordDetailsRenderer<T> renderer) {
    this.detailsRenderer = renderer;
    return this;
  }

  @Override
  public void init(DataTable<T> dataTable) {
    if (mode == Mode.PRIORITY_DETAILS) {
      validatePriorityConfiguration(dataTable);
    }
  }

  private void validatePriorityConfiguration(DataTable<T> dataTable) {
    hasRecordDetailsPlugin =
        dataTable.getTableConfig().getPlugins().stream()
            .anyMatch(plugin -> plugin instanceof RecordDetailsPlugin);
    List<ColumnConfig<T>> leafColumns = dataTable.getTableConfig().getLeafColumns();
    for (ColumnConfig<T> column : leafColumns) {
      if (!column.isResponsivePriority()) {
        continue;
      }
      if (column.isUtilityColumn() || column.isPluginColumn()) {
        throw new IllegalArgumentException(
            "A utility/plugin column cannot be marked as responsive priority.");
      }
      if (isHidden(column)) {
        throw new IllegalArgumentException(
            "A hidden column cannot be marked as responsive priority: " + column.getName());
      }
    }
    for (ColumnConfig<T> column : dataTable.getTableConfig().getFlattenColumns()) {
      if (column.isResponsivePriority() && column.isColumnGroup()) {
        throw new IllegalArgumentException(
            "A column group cannot be marked responsive priority; mark its leaf columns instead.");
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
    ResponsiveWidthObserver.Registration widthRegistration =
        mode == Mode.PRIORITY_DETAILS
            ? widthObserver.observe(
                dataTable.element(),
                width -> {
                  availableWidth = width;
                  if (!removed[0]) {
                    measureColumnWidths(dataTable);
                    updatePriorityLayout(dataTable);
                  }
                })
            : () -> {};
    ResponsiveBreakpointObserver.Registration registration =
        breakpointObserver.observe(
            query,
            matches -> {
              if (!removed[0]) {
                breakpointMatches = matches;
                updateResponsiveState(dataTable, matches);
              }
            });
    DominoEventListener recordUpdateListener =
        event -> {
          if (!removed[0] && mode == Mode.PRIORITY_DETAILS) {
            measureColumnWidths(dataTable);
            updatePriorityLayout(dataTable);
          }
        };
    dataTable.addTableEventListener(RowRecordUpdatedEvent.RECORD_UPDATED, recordUpdateListener);
    dataTable.addOnBeforeRemoveListener(
        ignored -> {
          if (!removed[0]) {
            removed[0] = true;
            registration.remove();
            widthRegistration.remove();
            dataTable.removeTableListener(
                RowRecordUpdatedEvent.RECORD_UPDATED, recordUpdateListener);
            dataTable.removeCss(dui_datatable_responsive_stacked);
            dataTable.removeCss(dui_datatable_responsive_priority_details);
            clearBuiltInDetails();
            dataTable.removeCss(dui_datatable_responsive_priority_no_details);
          }
        });
  }

  private void updateResponsiveState(DataTable<T> dataTable, boolean matches) {
    if (mode == Mode.PRIORITY_DETAILS) {
      dataTable.removeCss(dui_datatable_responsive_stacked);
      if (matches) {
        dataTable.addCss(dui_datatable_responsive_priority_details);
      }
      measureColumnWidths(dataTable);
      updatePriorityLayout(dataTable);
      return;
    }

    if (matches) {
      dataTable.addCss(dui_datatable_responsive_stacked);
    } else {
      dataTable.removeCss(dui_datatable_responsive_stacked);
    }
  }

  private boolean shouldShowSecondaryCells() {
    return !hasRecordDetailsPlugin && !builtInDetailsEnabled;
  }

  @Override
  public void onAllRowsAdded(DataTable<T> dataTable) {
    if (mode == Mode.PRIORITY_DETAILS) {
      measureColumnWidths(dataTable);
      updatePriorityLayout(dataTable);
    }
  }

  @Override
  public void onBeforeDataChange(DataTable<T> dataTable, boolean append) {
    if (mode == Mode.PRIORITY_DETAILS && !append) {
      clearBuiltInDetails();
    }
  }

  private void renderBuiltInDetails(DataTable<T> dataTable) {
    if (hasRecordDetailsPlugin || !builtInDetailsEnabled) {
      return;
    }
    if (collapsedColumns.isEmpty()) {
      clearBuiltInDetails();
      return;
    }

    for (TableRow<T> row : dataTable.getRows()) {
      if (!builtInDetails.containsKey(row)) {
        List<ColumnConfig<T>> detailColumns = new ArrayList<>();
        for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
          if (isSecondaryColumn(column)) {
            detailColumns.add(column);
          }
        }
        builtInDetails.put(
            row,
            ResponsiveDetailsRow.create(
                dataTable, row, detailColumns, detailsRenderer, this::getColumnLabel));
      }
      ResponsiveDetailsRow<T> detailsRow = builtInDetails.get(row);
      detailsRow.sync(collapsedColumns);
      detailsRow.attachAfter(dataTable);
    }
  }

  private void updatePriorityLayout(DataTable<T> dataTable) {
    List<String> secondaryColumns = new ArrayList<>();
    double fixedColumnsWidth = 0;
    for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
      if (isHidden(column)) {
        continue;
      }
      double width = measuredColumnWidths.getOrDefault(column.getName(), minimumColumnWidth);
      if (isSecondaryColumn(column)) {
        secondaryColumns.add(column.getName());
      } else {
        fixedColumnsWidth += width;
      }
    }
    // The configured viewport breakpoint is the gate for changing presentation. The observed
    // container width only decides how many secondary columns collapse after the mode is active.
    boolean responsiveLayoutActive = breakpointMatches;

    if (!responsiveLayoutActive) {
      dataTable.removeCss(dui_datatable_responsive_priority_details);
      collapsedColumns.clear();
      clearBuiltInDetails();
      for (TableRow<T> row : dataTable.getRows()) {
        for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
          RowCell<T> cell = row.getCell(column.getName());
          if (cell != null) {
            cell.removeCss(dui_datatable_responsive_secondary_visible);
          }
        }
      }
      dataTable.removeCss(dui_datatable_responsive_priority_no_details);
      return;
    }

    dataTable.addCss(dui_datatable_responsive_priority_details);
    collapsedColumns.clear();
    if (!shouldShowSecondaryCells()) {
      collapsedColumns.addAll(
          ResponsiveColumnCollapse.determine(
              secondaryColumns,
              measuredColumnWidths,
              fixedColumnsWidth,
              availableWidth,
              minimumColumnWidth));
    }

    if (!collapsedColumns.isEmpty()) {
      moveFocusFromSecondaryCell(dataTable);
    }

    for (TableRow<T> row : dataTable.getRows()) {
      for (String columnName : secondaryColumns) {
        RowCell<T> cell = row.getCell(columnName);
        if (cell != null) {
          if (collapsedColumns.contains(columnName)) {
            cell.removeCss(dui_datatable_responsive_secondary_visible);
          } else {
            cell.addCss(dui_datatable_responsive_secondary_visible);
          }
        }
      }
    }

    if (shouldShowSecondaryCells()) {
      dataTable.addCss(dui_datatable_responsive_priority_no_details);
    } else {
      dataTable.removeCss(dui_datatable_responsive_priority_no_details);
    }

    if (hasRecordDetailsPlugin || !builtInDetailsEnabled) {
      if (hasRecordDetailsPlugin) {
        dataTable.removeCss(dui_datatable_responsive_priority_no_details);
      }
    } else {
      renderBuiltInDetails(dataTable);
    }
  }

  private void measureColumnWidths(DataTable<T> dataTable) {
    boolean responsiveClassApplied =
        dataTable.containsCss(dui_datatable_responsive_priority_details.getCssClass());
    if (responsiveClassApplied) {
      dataTable.removeCss(dui_datatable_responsive_priority_details);
    }
    for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
      if (isHidden(column)) {
        continue;
      }
      double width =
          column.getHeadElement() == null
              ? 0
              : ResponsiveColumnCollapse.measuredContentWidth(
                  column.getHeadElement().element().scrollWidth,
                  column.getHeadElement().element().getBoundingClientRect().width);
      for (TableRow<T> row : dataTable.getRows()) {
        RowCell<T> cell = row.getCell(column.getName());
        if (cell != null) {
          width =
              Math.max(
                  width,
                  ResponsiveColumnCollapse.measuredContentWidth(
                      cell.element().scrollWidth, cell.element().getBoundingClientRect().width));
        }
      }
      if (width > 0) {
        // scrollWidth already includes cell padding and the rendered width includes the table's
        // allocated column width. Adding a per-column buffer here double-counts layout spacing,
        // making a table appear too wide even when it fits and activating the flex layout early.
        measuredColumnWidths.put(column.getName(), Math.max(width, minimumColumnWidth));
      }
    }
    if (responsiveClassApplied) {
      dataTable.addCss(dui_datatable_responsive_priority_details);
    }
  }

  private boolean isSecondaryColumn(ColumnConfig<T> column) {
    return !column.isUtilityColumn()
        && !column.isPluginColumn()
        && !isHidden(column)
        && !column.isResponsivePriority();
  }

  private void clearBuiltInDetails() {
    builtInDetails.values().forEach(ResponsiveDetailsRow::dispose);
    builtInDetails.clear();
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
    if (!collapsedColumns.contains(secondaryCell.getAttribute("data-column"))) {
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
                rowCell.setAttribute("data-column", column.getName());
                if (column.isUtilityColumn() || column.isPluginColumn()) {
                  rowCell.addCss(dui_datatable_responsive_utility_cell);
                } else if (column.isResponsivePriority()) {
                  rowCell.addCss(dui_datatable_responsive_priority_cell);
                  if (ResponsiveColumnMeta.get(column)
                      .map(ResponsiveColumnMeta::isOmitPriorityTitle)
                      .orElse(false)) {
                    rowCell.addCss(dui_datatable_responsive_priority_title_omitted);
                  }
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

  private static class BrowserResponsiveWidthObserver implements ResponsiveWidthObserver {

    @Override
    public Registration observe(Element element, Consumer<Double> onResize) {
      ResizeObserver observer =
          new ResizeObserver(
              entries -> {
                if (entries.length > 0) {
                  onResize.accept(ResponsiveWidthObserver.contentWidth(entries));
                }
              });
      observer.observe(element);
      return observer::disconnect;
    }
  }
}
