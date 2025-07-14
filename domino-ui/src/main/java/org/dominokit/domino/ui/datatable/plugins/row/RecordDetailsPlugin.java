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

package org.dominokit.domino.ui.datatable.plugins.row;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_details_td;
import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_details_tr;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.events.ExpandRecordEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.StateIcon;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.TDElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.IconWrapper;
import org.dominokit.domino.ui.icons.lib.*;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoEvent;

/**
 * The {@code RecordDetailsPlugin} class is a DataTable plugin that allows expanding and collapsing
 * rows to display additional details within the DataTable. It provides functionality to add
 * expand/collapse buttons to utility columns and handle expand/collapse events.
 *
 * @param <T> The type of data in the DataTable rows.
 * @see DataTablePlugin
 * @see CellRenderer
 */
public class RecordDetailsPlugin<T> implements DataTablePlugin<T> {

  private DivElement element = div();
  private TDElement td = td().addCss(dui_datatable_details_td).appendChild(element);
  private TableRowElement tr = tr().addCss(dui_datatable_details_tr).appendChild(td);

  private final CellRenderer<T> cellRenderer;
  private Supplier<Icon<?>> expandIcon;
  private Supplier<Icon<?>> collapseIcon;
  private DataTable<T> dataTable;
  private DetailsButtonElement<T> expandedRow;

  /**
   * Creates a new {@code RecordDetailsPlugin} with the provided cell renderer.
   *
   * @param cellRenderer The cell renderer used to render details content.
   */
  public RecordDetailsPlugin(CellRenderer<T> cellRenderer) {
    this(
        cellRenderer,
        () -> Icons.fullscreen().clickable(),
        () -> Icons.fullscreen_exit().clickable());
  }

  /**
   * Creates a new {@code RecordDetailsPlugin} with the provided cell renderer and custom expand and
   * collapse icons.
   *
   * @param cellRenderer The cell renderer used to render details content.
   * @param expandIcon A supplier of the expand icon.
   * @param collapseIcon A supplier of the collapse icon.
   */
  public RecordDetailsPlugin(
      CellRenderer<T> cellRenderer, Supplier<Icon<?>> expandIcon, Supplier<Icon<?>> collapseIcon) {
    this.cellRenderer = cellRenderer;
    this.expandIcon = expandIcon;
    this.collapseIcon = collapseIcon;
  }

  /**
   * Indicates whether this plugin requires a utility column in the DataTable. It returns {@code
   * true} since it adds expand/collapse buttons to utility columns.
   *
   * @return {@code true} since this plugin requires a utility column.
   */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /**
   * Returns a list of utility elements to be added to utility columns for a specific cell.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param cell The cell information containing the cell content and metadata.
   * @return An optional list of utility elements, empty if none.
   */
  @Override
  public Optional<List<HTMLElement>> getUtilityElements(
      DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
    applyStyles(cell);
    DetailsButtonElement<T> detailsButtonElement =
        new DetailsButtonElement<>(
            expandIcon.get(), collapseIcon.get(), RecordDetailsPlugin.this, cell);
    cell.getTableRow().applyMeta(detailsButtonElement);
    cell.getTableRow()
        .addCollapseListener(
            () -> {
              if (nonNull(expandedRow)
                  && cell.getTableRow().equals(expandedRow.getCellInfo().getTableRow())) {
                expandedRow.collapse();
              }
            });
    applyStyles(cell);
    detailsButtonElement.element.setAttribute("order", "30");
    return Optional.of(Collections.singletonList(detailsButtonElement.element()));
  }

  /**
   * Handles the addition of headers to the DataTable. In this case, it adds the expand icon to the
   * utility column header.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   * @param column The column configuration to which the header is added.
   */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      column.appendChild(div().addCss(dui_order_30).appendChild(expandIcon.get()));
    }
  }

  /**
   * Called before adding headers to the DataTable. It initializes the DataTable instance.
   *
   * @param dataTable The DataTable to which this plugin is applied.
   */
  @Override
  public void onBeforeAddHeaders(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /**
   * Handles table events, specifically handling the expand/collapse events.
   *
   * @param event The table event to be handled.
   */
  @Override
  public void handleEvent(DominoEvent event) {
    if (ExpandRecordEvent.EXPAND_RECORD.equals(event.getType())) {
      expandRow((ExpandRecordEvent<T>) event);
    }
  }

  /**
   * Expands a row when receiving an expand record event.
   *
   * @param event The expand record event.
   */
  private void expandRow(ExpandRecordEvent<T> event) {
    Optional<DetailsButtonElement<T>> detailsButtonElement =
        DetailsButtonElement.get(event.getTableRow());
    setExpanded(detailsButtonElement.get());
  }

  /**
   * Gets the details element.
   *
   * @return The details element.
   */
  public DivElement getElement() {
    return element;
  }

  /**
   * Gets the TD element.
   *
   * @return The TD element.
   */
  public TDElement getTd() {
    return td;
  }

  /**
   * Gets the TR element.
   *
   * @return The TR element.
   */
  public TableRowElement getTr() {
    return tr;
  }

  /**
   * Applies styles to a cell based on the cell information.
   *
   * @param cellInfo The cell information containing the cell content and metadata.
   */
  public void applyStyles(CellRenderer.CellInfo<T> cellInfo) {}

  /**
   * Sets up a column with the specified configuration.
   *
   * @param column The column configuration to set up.
   */
  public void setupColumn(ColumnConfig<T> column) {}

  /** Clears the current details content. */
  private void clear() {
    tr.remove();
    element.clearElement();
  }

  /**
   * Sets the specified element as expanded and displays the details content.
   *
   * @param expandElement The element to expand.
   */
  private void setExpanded(DetailsButtonElement<T> expandElement) {
    if (nonNull(this.expandedRow)) {
      this.expandedRow.collapse();
    }
    this.expandedRow = expandElement;
    td.setAttribute("colspan", dataTable.getTableConfig().getColumns().size() + "");
    element.appendChild(cellRenderer.asElement(expandElement.getCellInfo()));
    dataTable
        .bodyElement()
        .insertBefore(tr, expandElement.getCellInfo().getTableRow().element().nextSibling);
  }

  /**
   * The {@code DetailsButtonElement} class represents an element for handling row expand/collapse
   * events.
   *
   * @param <T> The type of data in the DataTable rows.
   * @see IsElement
   * @see ComponentMeta
   */
  private static class DetailsButtonElement<T> implements IsElement<HTMLElement>, ComponentMeta {
    public static final String RECORD_DETAILS_BUTTON = "record-details-button";
    private final DivElement element;
    private final CellRenderer.CellInfo<T> cellInfo;
    private StateIcon stateIcon;
    private RecordDetailsPlugin<T> recordDetailsPlugin;

    /**
     * Creates a new {@code DetailsButtonElement} with the provided expand and collapse icons.
     *
     * @param expandIcon The icon for expanding rows.
     * @param collapseIcon The icon for collapsing rows.
     * @param recordDetailsPlugin The RecordDetailsPlugin instance associated with this element.
     * @param cellInfo The cell information containing the cell content and metadata.
     */
    public DetailsButtonElement(
        Icon<?> expandIcon,
        Icon<?> collapseIcon,
        RecordDetailsPlugin<T> recordDetailsPlugin,
        CellRenderer.CellInfo<T> cellInfo) {
      this.stateIcon =
          StateIcon.create(expandIcon.copy())
              .withState("collapsed", IconWrapper.of(expandIcon))
              .withState("expanded", IconWrapper.of(collapseIcon));
      this.recordDetailsPlugin = recordDetailsPlugin;
      this.cellInfo = cellInfo;
      this.element = elements.div();
      this.element.appendChild(
          this.stateIcon.apply(
              self -> {
                self.addClickListener(
                    evt -> {
                      if ("collapsed".equals(self.getState())
                          || "default".equals(self.getState())) {
                        expand();
                      } else {
                        collapse();
                      }
                    });
              }));
    }

    /**
     * Gets the cell information associated with this element.
     *
     * @return The cell information.
     */
    public CellRenderer.CellInfo<T> getCellInfo() {
      return cellInfo;
    }

    /** Expands the associated row and sets the icon to the expanded state. */
    public void expand() {
      recordDetailsPlugin.setExpanded(this);
      this.stateIcon.setState("expanded");
    }

    /** Collapses the associated row and sets the icon to the collapsed state. */
    public void collapse() {
      recordDetailsPlugin.clear();
      this.stateIcon.setState("collapsed");
    }

    /**
     * Gets the HTML element representing this DetailsButtonElement.
     *
     * @return The HTML element.
     */
    @Override
    public HTMLElement element() {
      return element.element();
    }

    /**
     * Gets the key associated with this component meta.
     *
     * @return The key.
     */
    @Override
    public String getKey() {
      return RECORD_DETAILS_BUTTON;
    }

    /**
     * Retrieves a DetailsButtonElement associated with a specific table row.
     *
     * @param <T> The type of data in the DataTable rows.
     * @param tableRow The table row to retrieve the DetailsButtonElement for.
     * @return An optional DetailsButtonElement, empty if not found.
     */
    public static <T> Optional<DetailsButtonElement<T>> get(TableRow<T> tableRow) {
      return tableRow.getMeta(RECORD_DETAILS_BUTTON);
    }
  }
}
