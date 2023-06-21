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
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.StateIcon;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.TDElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.IconWrapper;
import org.dominokit.domino.ui.icons.lib.*;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * This plugin add the capability to expand a row in the table to display more information about its
 * record beneath the row itself
 *
 * @param <T> the type of the data table records
 * @author vegegoku
 * @version $Id: $Id
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
   * Creates an instance with custom renderer and default expand/collapse icons
   *
   * @param cellRenderer the {@link org.dominokit.domino.ui.datatable.CellRenderer}
   */
  public RecordDetailsPlugin(CellRenderer<T> cellRenderer) {
    this(
        cellRenderer,
        () -> Icons.fullscreen().clickable(),
        () -> Icons.fullscreen_exit().clickable());
  }

  /**
   * Creates an instance with custom renderer and expand/collapse icons
   *
   * @param cellRenderer the {@link org.dominokit.domino.ui.datatable.CellRenderer}
   * @param expandIcon {@link Supplier<Icon>}
   * @param collapseIcon {@link Supplier<Icon>}
   */
  public RecordDetailsPlugin(
      CellRenderer<T> cellRenderer, Supplier<Icon<?>> expandIcon, Supplier<Icon<?>> collapseIcon) {
    this.cellRenderer = cellRenderer;
    this.expandIcon = expandIcon;
    this.collapseIcon = collapseIcon;
  }

  /** {@inheritDoc} */
  @Override
  public boolean requiresUtilityColumn() {
    return true;
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
    if (column.isUtilityColumn()) {
      column.appendChild(div().addCss(dui_order_30).appendChild(expandIcon.get()));
    }
  }

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddHeaders(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /** {@inheritDoc} */
  @Override
  public void handleEvent(TableEvent event) {
    if (ExpandRecordEvent.EXPAND_RECORD.equals(event.getType())) {
      expandRow((ExpandRecordEvent<T>) event);
    }
  }

  private void expandRow(ExpandRecordEvent<T> event) {
    Optional<DetailsButtonElement<T>> detailsButtonElement =
        DetailsButtonElement.get(event.getTableRow());
    setExpanded(detailsButtonElement.get());
  }

  /** @return the root {@link HTMLDivElement} of this component */
  /**
   * Getter for the field <code>element</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getElement() {
    return element;
  }

  /** @return the {@link HTMLTableCellElement} that contains the records details */
  /**
   * Getter for the field <code>td</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TDElement} object
   */
  public TDElement getTd() {
    return td;
  }

  /** @return the {@link HTMLTableRowElement} that contains the records details */
  /**
   * Getter for the field <code>tr</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.TableRowElement} object
   */
  public TableRowElement getTr() {
    return tr;
  }

  /**
   * applyStyles.
   *
   * @param cellInfo a {@link org.dominokit.domino.ui.datatable.CellRenderer.CellInfo} object
   */
  public void applyStyles(CellRenderer.CellInfo<T> cellInfo) {}

  /**
   * A hook method to customize the column of the expand/collapse icons
   *
   * @param column {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   */
  public void setupColumn(ColumnConfig<T> column) {}

  private void clear() {
    tr.remove();
    element.clearElement();
  }

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

  private static class DetailsButtonElement<T> implements IsElement<HTMLElement>, ComponentMeta {
    public static final String RECORD_DETAILS_BUTTON = "record-details-button";
    private final DivElement element;
    private final CellRenderer.CellInfo<T> cellInfo;
    private StateIcon stateIcon;
    private RecordDetailsPlugin<T> recordDetailsPlugin;

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

    public CellRenderer.CellInfo<T> getCellInfo() {
      return cellInfo;
    }

    public void expand() {
      recordDetailsPlugin.setExpanded(this);
      this.stateIcon.setState("expanded");
    }

    public void collapse() {
      recordDetailsPlugin.clear();
      this.stateIcon.setState("collapsed");
    }

    @Override
    public HTMLElement element() {
      return element.element();
    }

    @Override
    public String getKey() {
      return RECORD_DETAILS_BUTTON;
    }

    public static <T> Optional<DetailsButtonElement<T>> get(TableRow<T> tableRow) {
      return tableRow.getMeta(RECORD_DETAILS_BUTTON);
    }
  }
}
