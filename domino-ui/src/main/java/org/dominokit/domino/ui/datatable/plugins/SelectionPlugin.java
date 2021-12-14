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
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.Node;
import java.util.function.Supplier;
import jsinterop.base.Js;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.Selectable;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.IsElement;

/**
 * This plugin allow selecting/deselecting single or multiple rows based on the {@link
 * TableConfig#isMultiSelect()} and fires table selection change events when the user changes the
 * selection.
 *
 * @param <T> the type of the data table records
 */
public class SelectionPlugin<T> implements DataTablePlugin<T> {

  private ColorScheme colorScheme;
  private Selectable<T> selectedRow;
  private HTMLElement singleSelectIndicator = Icons.ALL.check().element();
  private SelectionCondition<T> selectionCondition = (table, row) -> true;
  private TableRow<T> lastSelected;
  private Supplier<CheckBox> checkBoxCreator = CheckBox::create;

  /** creates an instance with default configurations */
  public SelectionPlugin() {}

  /**
   * create an instance that changes the selected row background color
   *
   * @param colorScheme {@link ColorScheme} the selected row background color
   */
  public SelectionPlugin(ColorScheme colorScheme) {
    this.colorScheme = colorScheme;
  }

  /**
   * create an instance that changes the selected row background color and use a custom selection
   * indicator icon
   *
   * @param colorScheme {@link ColorScheme} the selected row background color
   * @param singleSelectIndicator {@link HTMLElement} to use a selection indicator
   */
  public SelectionPlugin(ColorScheme colorScheme, HTMLElement singleSelectIndicator) {
    this(colorScheme);
    this.singleSelectIndicator = singleSelectIndicator;
  }

  /**
   * create an instance that changes the selected row background color and use a custom selection
   * indicator icon
   *
   * @param colorScheme {@link ColorScheme} the selected row background color
   * @param singleSelectIndicator {@link IsElement} to use a selection indicator
   */
  public SelectionPlugin(ColorScheme colorScheme, IsElement<?> singleSelectIndicator) {
    this(colorScheme, singleSelectIndicator.element());
  }

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddHeaders(DataTable<T> dataTable) {
    dataTable
        .getTableConfig()
        .insertColumnFirst(
            ColumnConfig.<T>create("data-table-select-cm")
                .setSortable(false)
                .setPluginColumn(true)
                .setWidth(dataTable.getTableConfig().isMultiSelect() ? "35px" : "40px")
                .styleCell(
                    element ->
                        Style.of(element)
                            .setMaxWidth(
                                dataTable.getTableConfig().isMultiSelect() ? "35px" : "40px")
                            .setWidth(dataTable.getTableConfig().isMultiSelect() ? "35px" : "40px"))
                .setTooltipNode(DomGlobal.document.createTextNode("Select"))
                .setHeaderElement(
                    columnTitle -> {
                      if (dataTable.getTableConfig().isMultiSelect()) {
                        return createMultiSelectHeader(dataTable);
                      } else {
                        return createSingleSelectHeader();
                      }
                    })
                .setCellRenderer(
                    cell -> {
                      if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                        if (dataTable.getTableConfig().isMultiSelect()) {
                          return createMultiSelectCell(dataTable, cell);
                        } else {
                          return createSingleSelectCell(dataTable, cell);
                        }
                      } else {
                        return TextNode.empty();
                      }
                    }));
  }

  private Node createSingleSelectHeader() {
    return singleSelectIndicator.cloneNode(true);
  }

  private Node createSingleSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
    HTMLElement clonedIndicator = Js.uncheckedCast(singleSelectIndicator.cloneNode(true));
    cell.getTableRow()
        .element()
        .addEventListener(
            "click",
            evt -> {
              if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                if (cell.getTableRow().isSelected()) {
                  cell.getTableRow().deselect();
                } else {
                  cell.getTableRow().select();
                }
                dataTable.onSelectionChange(cell.getTableRow());
              }
            });
    cell.getTableRow()
        .addSelectionHandler(
            selectable -> {
              if (selectionCondition.isAllowSelection(dataTable, cell.getTableRow())) {
                if (selectable.isSelected()) {
                  if (nonNull(selectedRow)) {
                    selectedRow.deselect();
                  }
                  Style.of(clonedIndicator).setDisplay("inline-block");
                  if (nonNull(colorScheme)) {
                    Style.of(((TableRow<T>) selectable).element())
                        .addCss(colorScheme.lighten_5().getBackground());
                  }
                  selectedRow = selectable;
                } else {
                  Style.of(clonedIndicator).setDisplay("none");
                  if (nonNull(colorScheme)) {
                    ((TableRow<T>) selectable).removeCss(colorScheme.lighten_5().getBackground());
                  }
                  selectedRow = null;
                }
              }
            });
    Style.of(clonedIndicator).setDisplay("none");
    return clonedIndicator;
  }

  private Node createMultiSelectCell(DataTable<T> dataTable, CellRenderer.CellInfo<T> cell) {
    CheckBox checkBox = createCheckBox();

    TableRow<T> tableRow = cell.getTableRow();
    tableRow.addSelectionHandler(
        selectable -> {
          if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
            if (selectable.isSelected()) {
              checkBox.check(true);
              if (nonNull(colorScheme)) {
                Style.of(((TableRow<T>) selectable).element())
                    .addCss(colorScheme.lighten_5().getBackground());
              }
            } else {
              checkBox.uncheck(true);
              if (nonNull(colorScheme)) {
                ((TableRow<T>) selectable).removeCss(colorScheme.lighten_5().getBackground());
              }
            }
          }
        });

    checkBox.addClickListener(
        evt -> {
          MouseEvent mouseEvent = Js.cast(evt);
          if (mouseEvent.shiftKey) {
            int startIndex = getStartSelectionIndex(dataTable);
            int endIndex = tableRow.getIndex();
            int increment = startIndex < endIndex ? 1 : -1;
            for (int i = startIndex;
                startIndex < endIndex ? i <= endIndex : i >= endIndex;
                i += increment) {
              TableRow<T> row = dataTable.getItems().get(i);
              selectRow(dataTable, row);
            }
          } else {
            this.lastSelected = tableRow;
          }
        });
    checkBox.addChangeHandler(
        checked -> {
          if (selectionCondition.isAllowSelection(dataTable, tableRow)) {
            if (checked) {
              selectRow(dataTable, tableRow);
            } else {
              tableRow.deselect();
              if (nonNull(colorScheme)) {
                tableRow.removeCss(colorScheme.lighten_5().getBackground());
              }
              dataTable.onSelectionChange(tableRow);
            }
          }
        });
    return checkBox.element();
  }

  private int getStartSelectionIndex(DataTable<T> dataTable) {
    if (nonNull(lastSelected)) {
      return lastSelected.getIndex();
    } else {
      if (dataTable.getSelectedItems().isEmpty()) {
        return 0;
      } else {
        return dataTable.getSelectedItems().get(0).getIndex();
      }
    }
  }

  private void selectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.select();
    if (nonNull(colorScheme)) {
      Style.of(tableRow.element()).addCss(colorScheme.lighten_5().getBackground());
    }
    dataTable.onSelectionChange(tableRow);
  }

  private void deselectRow(DataTable<T> dataTable, TableRow<T> tableRow) {
    tableRow.deselect();
    if (nonNull(colorScheme)) {
      Style.of(tableRow.element()).removeCss(colorScheme.lighten_5().getBackground());
    }
    dataTable.onSelectionChange(tableRow);
  }

  private Node createMultiSelectHeader(DataTable<T> dataTable) {
    CheckBox checkBox = createCheckBox();
    checkBox.addChangeHandler(
        checked -> {
          if (checked) {
            dataTable.selectAll(selectionCondition);
          } else {
            dataTable.deselectAll(selectionCondition);
          }
        });

    dataTable.addSelectionListener(
        (selectedRows, selectedRecords) -> {
          if (selectedRows.size()
              != dataTable.getItems().stream()
                  .filter(tableRow -> selectionCondition.isAllowSelection(dataTable, tableRow))
                  .count()) {
            checkBox.uncheck(true);
          } else {
            checkBox.check(true);
          }
        });
    return checkBox.element();
  }

  /**
   * Change the single selection indicator icon
   *
   * @param singleSelectIcon {@link BaseIcon}
   * @return same plugin instance
   */
  public SelectionPlugin<T> setSingleSelectIcon(BaseIcon<?> singleSelectIcon) {
    return this;
  }

  private CheckBox createCheckBox() {
    CheckBox checkBox = checkBoxCreator.get();
    if (nonNull(colorScheme)) {
      checkBox.setColor(colorScheme.color());
    }
    checkBox.addCss(DataTableStyles.SELECT_CHECKBOX);
    return checkBox;
  }

  /**
   * Set a condition to use to determine if a row should be selectable or not
   *
   * @param selectionCondition {@link SelectionCondition}
   * @return Same plugin instance
   */
  public SelectionPlugin<T> setSelectionCondition(SelectionCondition<T> selectionCondition) {
    if (nonNull(selectionCondition)) {
      this.selectionCondition = selectionCondition;
    }
    return this;
  }

  /**
   * A setter to to give the user the ability to customize the selection checkbox
   *
   * @param checkBoxCreator {@link Supplier} of {@link CheckBox}
   * @return same plugin instance
   */
  public SelectionPlugin<T> setCheckBoxCreator(Supplier<CheckBox> checkBoxCreator) {
    if (nonNull(checkBoxCreator)) {
      this.checkBoxCreator = checkBoxCreator;
    }
    return this;
  }
}
