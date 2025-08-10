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
package org.dominokit.domino.ui.datatable.plugins.header;

import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.SpacingCss.dui_gap_4;
import static org.dominokit.domino.ui.style.SpacingCss.dui_min_w_8;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.DefaultColumnShowHideListener;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * An implementation of the {@link HeaderActionElement} that provides the ability to show/hide
 * columns in a DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class ShowHideColumnsAction<T>
    extends BaseDominoElement<HTMLElement, ShowHideColumnsAction<T>> {

  private final Icon<?> columnsIcon;

  public static <T> ShowHideColumnsAction<T> create(DataTable<T> dataTable) {
    return new ShowHideColumnsAction<>(dataTable);
  }

  /**
   * Creates an element representing a button that allows users to show/hide columns. When clicked,
   * a dropdown menu appears, providing options to show or hide individual columns.
   *
   * @param dataTable The DataTable to which this action element belongs.
   */
  public ShowHideColumnsAction(DataTable<T> dataTable) {
    columnsIcon = Icons.view_column().clickable();

    Menu<String> dropDownMenu =
        Menu.<String>create()
            .setDropDirection(DropDirection.BEST_FIT_SIDE)
            .apply(
                columnsMenu ->
                    dataTable.getTableConfig().getColumns().stream()
                        .filter(this::notUtility)
                        .forEach(
                            columnConfig -> {
                              Icon<?> checkIcon =
                                  Icons.check().toggleDisplay(!columnConfig.isHidden());
                              columnConfig.addShowHideListener(
                                  DefaultColumnShowHideListener.of(checkIcon.element(), true));

                              columnsMenu.appendChild(
                                  new CustomMenuItem<String>()
                                      .appendChild(
                                          elements
                                              .div()
                                              .addCss(dui_flex, dui_gap_4)
                                              .appendChild(
                                                  elements
                                                      .div()
                                                      .addCss(dui_min_w_8)
                                                      .appendChild(checkIcon))
                                              .appendChild(
                                                  elements
                                                      .div()
                                                      .textContent(columnConfig.getTitle())))
                                      .addSelectionListener(
                                          (source, selection) -> {
                                            columnConfig.toggleDisplay(columnConfig.isHidden());
                                          }));
                            }));

    columnsIcon.addClickListener(
        evt -> {
          if (dropDownMenu.isOpened()) {
            dropDownMenu.close();
          } else {
            dropDownMenu.open();
          }
          evt.stopPropagation();
        });
    init(this);
  }

  private boolean notUtility(ColumnConfig<T> column) {
    return !column.isUtilityColumn();
  }

  @Override
  public HTMLElement element() {
    return columnsIcon.element();
  }
}
