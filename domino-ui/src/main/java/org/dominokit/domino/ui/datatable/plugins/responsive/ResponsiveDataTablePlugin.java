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
import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import elemental2.dom.MediaQueryList;
import elemental2.dom.MediaQueryListListener;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsCell;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsCellInfo;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.utils.DominoEventListener;
import org.dominokit.domino.ui.utils.ResizeObserver;

/**
 * Enables an opt-in responsive presentation for a data table below a viewport breakpoint.
 *
 * <p>The default {@link Mode#STACKED} mode presents each cell as a labeled row. The opt-in {@link
 * Mode#PRIORITY_DETAILS} mode keeps named priority columns visible and progressively moves other
 * columns into responsive details as the table narrows. A {@link RecordDetailsPlugin}, when
 * configured, takes over details rendering; otherwise the plugin renders a built-in key/value view.
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
  private final ResponsiveWidthObserver widthObserver;
  private String breakpoint = DEFAULT_BREAKPOINT;
  private Mode mode = Mode.STACKED;
  private String[] priorityColumns = new String[0];
  private boolean builtInDetailsEnabled = true;
  private RecordDetailsRenderer<T> detailsRenderer;
  private boolean hasRecordDetailsPlugin;
  private boolean breakpointMatches;
  private double availableWidth;
  private final Map<String, Double> measuredColumnWidths = new LinkedHashMap<>();
  private final Set<String> collapsedColumns = new LinkedHashSet<>();
  private final Map<TableRow<T>, BuiltInDetails> builtInDetails = new IdentityHashMap<>();

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
    if (priorityColumns == null || priorityColumns.length == 0) {
      throw new IllegalArgumentException(
          "PRIORITY_DETAILS mode requires at least one priority column name.");
    }

    hasRecordDetailsPlugin =
        dataTable.getTableConfig().getPlugins().stream()
            .anyMatch(plugin -> plugin instanceof RecordDetailsPlugin);

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
            dataTable.element().classList.remove(dui_datatable_responsive_stacked.getCssClass());
            dataTable
                .element()
                .classList
                .remove(dui_datatable_responsive_priority_details.getCssClass());
            clearBuiltInDetails();
            dataTable
                .element()
                .classList
                .remove(dui_datatable_responsive_priority_no_details.getCssClass());
          }
        });
  }

  private void updateResponsiveState(DataTable<T> dataTable, boolean matches) {
    if (mode == Mode.PRIORITY_DETAILS) {
      dataTable.element().classList.remove(dui_datatable_responsive_stacked.getCssClass());
      if (matches) {
        dataTable.element().classList.add(dui_datatable_responsive_priority_details.getCssClass());
      }
      measureColumnWidths(dataTable);
      updatePriorityLayout(dataTable);
      return;
    }

    String activeClass = dui_datatable_responsive_stacked.getCssClass();

    if (matches) {
      dataTable.element().classList.add(activeClass);
    } else {
      dataTable.element().classList.remove(activeClass);
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
        BuiltInDetails details = createBuiltInDetails(dataTable, row);
        builtInDetails.put(row, details);
      }
      syncBuiltInDetails(row, builtInDetails.get(row));
    }
  }

  private BuiltInDetails createBuiltInDetails(DataTable<T> dataTable, TableRow<T> sourceRow) {
    HTMLTableRowElement detailsRow = (HTMLTableRowElement) document.createElement("tr");
    detailsRow.classList.add(dui_datatable_responsive_details_tr.getCssClass());
    detailsRow.classList.add(dui_datatable_row.getCssClass());
    detailsRow.classList.add(dui_datatable_details_tr.getCssClass());
    if (sourceRow.element().classList.contains("dui-even")) {
      detailsRow.classList.add("dui-even");
    } else if (sourceRow.element().classList.contains("dui-odd")) {
      detailsRow.classList.add("dui-odd");
    }
    HTMLTableCellElement detailsCell = (HTMLTableCellElement) document.createElement("td");
    detailsCell.classList.add(dui_datatable_responsive_details_td.getCssClass());
    detailsCell.setAttribute(
        "colspan", String.valueOf(dataTable.getTableConfig().getLeafColumns().size()));
    HTMLElement content = (HTMLElement) document.createElement("div");
    content.classList.add(dui_datatable_responsive_details_content.getCssClass());
    detailsCell.appendChild(content);
    detailsRow.appendChild(detailsCell);

    if (detailsRenderer != null) {
      TableRow<T> detailsTableRow =
          new TableRow<>(
              TableRowElement.of(detailsRow),
              sourceRow.getRecord(),
              sourceRow.getIndex(),
              dataTable);
      RecordDetailsCell<T> detailsCellComponent =
          new RecordDetailsCell<>(
              new RecordDetailsCellInfo<>(
                  detailsTableRow,
                  sourceRow,
                  detailsCell,
                  DivElement.of((elemental2.dom.HTMLDivElement) content)));
      detailsRenderer.render(detailsCellComponent);
      return new BuiltInDetails(detailsRow, new ArrayList<>(), null, true);
    }

    HTMLElement definitionList = (HTMLElement) document.createElement("dl");
    definitionList.classList.add(dui_datatable_responsive_details_list.getCssClass());
    content.appendChild(definitionList);
    List<MovedCellContent> movedContent = new ArrayList<>();
    for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
      if (!isSecondaryColumn(column)) {
        continue;
      }
      RowCell<T> sourceCell = sourceRow.getCell(column.getName());
      if (sourceCell == null) {
        continue;
      }

      HTMLElement item = (HTMLElement) document.createElement("div");
      item.classList.add(dui_datatable_responsive_details_item.getCssClass());
      HTMLElement label = (HTMLElement) document.createElement("dt");
      label.classList.add(dui_datatable_responsive_details_label.getCssClass());
      label.textContent = getColumnLabel(column);
      HTMLElement value = (HTMLElement) document.createElement("dd");
      value.classList.add(dui_datatable_responsive_details_value.getCssClass());
      item.appendChild(label);
      item.appendChild(value);
      movedContent.add(new MovedCellContent(column.getName(), sourceCell.element(), item, value));
    }
    return new BuiltInDetails(detailsRow, movedContent, definitionList, false);
  }

  private void syncBuiltInDetails(TableRow<T> sourceRow, BuiltInDetails details) {
    if (details == null) {
      return;
    }

    if (!details.customRenderer) {
      for (MovedCellContent moved : details.movedContent) {
        boolean shouldMove = collapsedColumns.contains(moved.columnName);
        if (shouldMove && !moved.attached) {
          moved.nodes.addAll(takeChildren(moved.originalCell));
          moved.nodes.forEach(moved.value::appendChild);
          details.definitionList.appendChild(moved.item);
          moved.attached = true;
        } else if (!shouldMove && moved.attached) {
          moved.nodes.forEach(moved.originalCell::appendChild);
          moved.nodes.clear();
          moved.item.parentNode.removeChild(moved.item);
          moved.attached = false;
        }
      }
    }

    boolean hasDetails = !collapsedColumns.isEmpty();
    if (hasDetails) {
      sourceRow.element().classList.add(dui_datatable_responsive_row_with_details.getCssClass());
      if (details.row.parentNode == null) {
        sourceRow.element().parentNode.insertBefore(details.row, sourceRow.element().nextSibling);
      }
    } else {
      sourceRow.element().classList.remove(dui_datatable_responsive_row_with_details.getCssClass());
      if (details.row.parentNode != null) {
        details.row.parentNode.removeChild(details.row);
      }
    }
  }

  private void updatePriorityLayout(DataTable<T> dataTable) {
    List<String> secondaryColumns = new ArrayList<>();
    double fixedColumnsWidth = 0;
    for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
      if (isHidden(column)) {
        continue;
      }
      double width = measuredColumnWidths.getOrDefault(column.getName(), 132.0);
      if (isSecondaryColumn(column)) {
        secondaryColumns.add(column.getName());
      } else {
        fixedColumnsWidth += width;
      }
    }
    double allColumnsWidth = fixedColumnsWidth;
    for (String columnName : secondaryColumns) {
      allColumnsWidth += measuredColumnWidths.getOrDefault(columnName, 132.0);
    }
    boolean responsiveLayoutActive =
        breakpointMatches || (availableWidth > 0 && allColumnsWidth > availableWidth);

    if (!responsiveLayoutActive) {
      dataTable.element().classList.remove(dui_datatable_responsive_priority_details.getCssClass());
      collapsedColumns.clear();
      clearBuiltInDetails();
      for (TableRow<T> row : dataTable.getRows()) {
        for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
          RowCell<T> cell = row.getCell(column.getName());
          if (cell != null) {
            cell.element()
                .classList
                .remove(dui_datatable_responsive_secondary_visible.getCssClass());
          }
        }
      }
      dataTable
          .element()
          .classList
          .remove(dui_datatable_responsive_priority_no_details.getCssClass());
      return;
    }

    dataTable.element().classList.add(dui_datatable_responsive_priority_details.getCssClass());
    collapsedColumns.clear();
    if (!shouldShowSecondaryCells()) {
      collapsedColumns.addAll(
          ResponsiveColumnCollapse.determine(
              secondaryColumns, measuredColumnWidths, fixedColumnsWidth, availableWidth));
    }

    if (!collapsedColumns.isEmpty()) {
      moveFocusFromSecondaryCell(dataTable);
    }

    for (TableRow<T> row : dataTable.getRows()) {
      for (String columnName : secondaryColumns) {
        RowCell<T> cell = row.getCell(columnName);
        if (cell != null) {
          if (collapsedColumns.contains(columnName)) {
            cell.element()
                .classList
                .remove(dui_datatable_responsive_secondary_visible.getCssClass());
          } else {
            cell.element().classList.add(dui_datatable_responsive_secondary_visible.getCssClass());
          }
        }
      }
    }

    if (shouldShowSecondaryCells()) {
      dataTable.element().classList.add(dui_datatable_responsive_priority_no_details.getCssClass());
    } else {
      dataTable
          .element()
          .classList
          .remove(dui_datatable_responsive_priority_no_details.getCssClass());
    }

    if (hasRecordDetailsPlugin || !builtInDetailsEnabled) {
      if (hasRecordDetailsPlugin) {
        dataTable
            .element()
            .classList
            .remove(dui_datatable_responsive_priority_no_details.getCssClass());
      }
    } else {
      renderBuiltInDetails(dataTable);
    }
  }

  private void measureColumnWidths(DataTable<T> dataTable) {
    boolean responsiveClassApplied =
        dataTable
            .element()
            .classList
            .contains(dui_datatable_responsive_priority_details.getCssClass());
    if (responsiveClassApplied) {
      dataTable.element().classList.remove(dui_datatable_responsive_priority_details.getCssClass());
    }
    for (ColumnConfig<T> column : dataTable.getTableConfig().getLeafColumns()) {
      if (isHidden(column)) {
        continue;
      }
      double width =
          column.getHeadElement() == null ? 0 : column.getHeadElement().element().scrollWidth;
      for (TableRow<T> row : dataTable.getRows()) {
        RowCell<T> cell = row.getCell(column.getName());
        if (cell != null) {
          width = Math.max(width, cell.element().scrollWidth);
          width = Math.max(width, cell.element().getBoundingClientRect().width);
        }
      }
      if (width > 0) {
        measuredColumnWidths.put(column.getName(), Math.max(width + 12, 132));
      }
    }
    if (responsiveClassApplied) {
      dataTable.element().classList.add(dui_datatable_responsive_priority_details.getCssClass());
    }
  }

  private boolean isSecondaryColumn(ColumnConfig<T> column) {
    return !column.isUtilityColumn()
        && !column.isPluginColumn()
        && !isHidden(column)
        && !Arrays.asList(priorityColumns).contains(column.getName());
  }

  private List<Node> takeChildren(Element element) {
    List<Node> nodes = new ArrayList<>();
    while (element.firstChild != null) {
      Node node = element.firstChild;
      nodes.add(node);
      element.removeChild(node);
    }
    return nodes;
  }

  private void clearBuiltInDetails() {
    for (Map.Entry<TableRow<T>, BuiltInDetails> entry : builtInDetails.entrySet()) {
      BuiltInDetails details = entry.getValue();
      details.movedContent.forEach(
          moved -> {
            if (moved.attached) {
              moved.nodes.forEach(moved.originalCell::appendChild);
            }
          });
      entry
          .getKey()
          .element()
          .classList
          .remove(dui_datatable_responsive_row_with_details.getCssClass());
      if (details.row.parentNode != null) {
        details.row.parentNode.removeChild(details.row);
      }
    }
    builtInDetails.clear();
  }

  private static class BuiltInDetails {
    private final HTMLTableRowElement row;
    private final List<MovedCellContent> movedContent;
    private final HTMLElement definitionList;
    private final boolean customRenderer;

    private BuiltInDetails(
        HTMLTableRowElement row,
        List<MovedCellContent> movedContent,
        HTMLElement definitionList,
        boolean customRenderer) {
      this.row = row;
      this.movedContent = movedContent;
      this.definitionList = definitionList;
      this.customRenderer = customRenderer;
    }
  }

  private static class MovedCellContent {
    private final String columnName;
    private final Element originalCell;
    private final HTMLElement item;
    private final HTMLElement value;
    private final List<Node> nodes = new ArrayList<>();
    private boolean attached;

    private MovedCellContent(
        String columnName, Element originalCell, HTMLElement item, HTMLElement value) {
      this.columnName = columnName;
      this.originalCell = originalCell;
      this.item = item;
      this.value = value;
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

  private static class BrowserResponsiveWidthObserver implements ResponsiveWidthObserver {

    @Override
    public Registration observe(Element element, Consumer<Double> onResize) {
      ResizeObserver observer =
          new ResizeObserver(
              entries -> {
                if (entries.length > 0) {
                  onResize.accept(entries.getAt(0).contentRect.width);
                }
              });
      observer.observe(element);
      return observer::disconnect;
    }
  }
}
