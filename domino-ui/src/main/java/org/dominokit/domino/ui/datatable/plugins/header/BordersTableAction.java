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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * An implementation of the {@link HeaderActionElement} that allows toggling table borders.
 *
 * @param <T> The type of data in the DataTable.
 */
public class BordersTableAction<T> extends BaseDominoElement<HTMLElement, BordersTableAction<T>> {

  private final ToggleIcon<?, ?> bordersIcon;
  private String borderedToolTip = "Bordered";
  private String noBordersToolTip = "No borders";

  public static <T> BordersTableAction<T> create(DataTable<T> dataTable) {
    return new BordersTableAction<>(dataTable);
  }

  /**
   * Creates an element that represents a toggle button for showing or hiding table borders.
   *
   * @param dataTable The DataTable to apply the borders action to.
   */
  public BordersTableAction(DataTable<T> dataTable) {
    bordersIcon =
        ToggleMdiIcon.create(Icons.border_vertical(), Icons.border_none())
            .clickable()
            .toggleOnClick(true)
            .setTooltip(borderedToolTip)
            .onToggle(
                toggleMdiIcon -> {
                  dataTable.setBordered(!dataTable.isBordered());
                  toggleMdiIcon.setTooltip(
                      dataTable.isBordered() ? noBordersToolTip : borderedToolTip);
                });

    init(this);
  }

  @Override
  public HTMLElement element() {
    return bordersIcon.element();
  }

  /**
   * Sets the tooltip text for the "Bordered" action button.
   *
   * @param borderedToolTip The tooltip text for the "Bordered" action.
   * @return This {@code BordersTableAction} instance for method chaining.
   */
  public BordersTableAction<T> setBorderedToolTip(String borderedToolTip) {
    this.borderedToolTip = borderedToolTip;
    return this;
  }

  /**
   * Sets the tooltip text for the "No Borders" action button.
   *
   * @param noBordersToolTip The tooltip text for the "No Borders" action.
   * @return This {@code BordersTableAction} instance for method chaining.
   */
  public BordersTableAction<T> setNoBordersToolTip(String noBordersToolTip) {
    this.noBordersToolTip = noBordersToolTip;
    return this;
  }
}
