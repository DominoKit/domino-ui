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

import static org.dominokit.domino.ui.style.GenericCss.dui_even;
import static org.dominokit.domino.ui.style.GenericCss.dui_odd;
import static org.dominokit.domino.ui.utils.Domino.dd;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dl;
import static org.dominokit.domino.ui.utils.Domino.dt;
import static org.dominokit.domino.ui.utils.Domino.td;
import static org.dominokit.domino.ui.utils.Domino.tr;

import elemental2.dom.HTMLTableRowElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DataTableStyles;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsCell;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsCellInfo;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer;
import org.dominokit.domino.ui.elements.DDElement;
import org.dominokit.domino.ui.elements.DListElement;
import org.dominokit.domino.ui.elements.DTElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.TDElement;
import org.dominokit.domino.ui.elements.TableRowElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** A table row that renders the responsive details for one source data row. */
class ResponsiveDetailsRow<T>
    extends BaseDominoElement<HTMLTableRowElement, ResponsiveDetailsRow<T>>
    implements DataTableStyles {

  private final TableRowElement rowElement = tr();
  private final DListElement definitionList;
  private final List<MovedCellContent<T>> movedContent = new ArrayList<>();
  private final boolean customRenderer;
  private final TableRow<T> sourceRow;
  private boolean attached;

  private ResponsiveDetailsRow(
      DataTable<T> dataTable,
      TableRow<T> sourceRow,
      List<ColumnConfig<T>> detailColumns,
      RecordDetailsRenderer<T> detailsRenderer,
      Function<ColumnConfig<T>, String> labelProvider) {
    this.sourceRow = sourceRow;
    this.customRenderer = detailsRenderer != null;
    init(this);
    addCss(dui_datatable_responsive_details_tr, dui_datatable_row, dui_datatable_details_tr);
    if (dui_even.isAppliedTo(sourceRow)) {
      addCss(dui_even);
    } else if (dui_odd.isAppliedTo(sourceRow)) {
      addCss(dui_odd);
    }

    TDElement detailsCell = td().addCss(dui_datatable_responsive_details_td);
    detailsCell.setAttribute(
        "colspan", String.valueOf(dataTable.getTableConfig().getLeafColumns().size()));
    DivElement content = div().addCss(dui_datatable_responsive_details_content);
    detailsCell.appendChild(content);
    appendChild(detailsCell);

    if (customRenderer) {
      definitionList = null;
      TableRow<T> detailsTableRow =
          new TableRow<>(rowElement, sourceRow.getRecord(), sourceRow.getIndex(), dataTable);
      detailsRenderer.render(
          new RecordDetailsCell<>(
              new RecordDetailsCellInfo<>(
                  detailsTableRow, sourceRow, detailsCell.element(), content)));
      return;
    }

    definitionList = dl().addCss(dui_datatable_responsive_details_list);
    content.appendChild(definitionList);
    for (ColumnConfig<T> column : detailColumns) {
      RowCell<T> sourceCell = sourceRow.getCell(column.getName());
      if (sourceCell == null) {
        continue;
      }

      DivElement item = div().addCss(dui_datatable_responsive_details_item);
      DTElement label = dt().addCss(dui_datatable_responsive_details_label);
      label.setTextContent(labelProvider.apply(column));
      DDElement value = dd().addCss(dui_datatable_responsive_details_value);
      item.appendChild(label).appendChild(value);
      movedContent.add(new MovedCellContent<>(column.getName(), sourceCell, item, value));
    }
  }

  static <T> ResponsiveDetailsRow<T> create(
      DataTable<T> dataTable,
      TableRow<T> sourceRow,
      List<ColumnConfig<T>> detailColumns,
      RecordDetailsRenderer<T> detailsRenderer,
      Function<ColumnConfig<T>, String> labelProvider) {
    return new ResponsiveDetailsRow<>(
        dataTable, sourceRow, detailColumns, detailsRenderer, labelProvider);
  }

  void sync(Set<String> collapsedColumns) {
    if (!customRenderer) {
      for (MovedCellContent<T> moved : movedContent) {
        boolean shouldMove = collapsedColumns.contains(moved.columnName);
        if (shouldMove && !moved.attached) {
          moved.nodes.addAll(takeChildren(moved.originalCell));
          moved.nodes.forEach(moved.value::appendChild);
          definitionList.appendChild(moved.item);
          moved.attached = true;
        } else if (!shouldMove && moved.attached) {
          moved.nodes.forEach(moved.originalCell::appendChild);
          moved.nodes.clear();
          definitionList.removeChild(moved.item);
          moved.attached = false;
        }
      }
    }

    if (!collapsedColumns.isEmpty()) {
      sourceRow.addCss(dui_datatable_responsive_row_with_details);
    } else {
      sourceRow.removeCss(dui_datatable_responsive_row_with_details);
    }
  }

  void attachAfter(DataTable<T> dataTable) {
    if (!attached) {
      dataTable.bodyElement().insertAfter(this, sourceRow);
      attached = true;
    }
  }

  void detach() {
    if (attached) {
      remove();
      attached = false;
    }
  }

  void dispose() {
    movedContent.forEach(
        moved -> {
          if (moved.attached) {
            moved.nodes.forEach(moved.originalCell::appendChild);
            moved.nodes.clear();
            moved.attached = false;
          }
        });
    sourceRow.removeCss(dui_datatable_responsive_row_with_details);
    detach();
  }

  @Override
  public HTMLTableRowElement element() {
    return rowElement.element();
  }

  private List<Node> takeChildren(RowCell<T> cell) {
    List<Node> nodes = new ArrayList<>();
    while (cell.firstChild() != null) {
      Node node = cell.firstChild();
      nodes.add(node);
      cell.removeChild(node);
    }
    return nodes;
  }

  private static class MovedCellContent<T> {
    private final String columnName;
    private final RowCell<T> originalCell;
    private final DivElement item;
    private final DDElement value;
    private final List<Node> nodes = new ArrayList<>();
    private boolean attached;

    private MovedCellContent(
        String columnName, RowCell<T> originalCell, DivElement item, DDElement value) {
      this.columnName = columnName;
      this.originalCell = originalCell;
      this.item = item;
      this.value = value;
    }
  }
}
