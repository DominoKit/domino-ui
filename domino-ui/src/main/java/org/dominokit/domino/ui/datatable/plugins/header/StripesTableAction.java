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

public class StripesTableAction<T> extends BaseDominoElement<HTMLElement, StripesTableAction<T>> {

  private final ToggleIcon<?, ?> stripesIcon;
  private String noStripsToolTip = "No stripes";
  private String stripsToolTip = "Stripes";

  public static <T> StripesTableAction<T> create(DataTable<T> dataTable) {
    return new StripesTableAction<>(dataTable);
  }

  /**
   * Creates an element that represents a toggle button for showing or hiding table stripes.
   *
   * @param dataTable The DataTable to apply the stripes action to.
   */
  public StripesTableAction(DataTable<T> dataTable) {
    stripesIcon =
        ToggleMdiIcon.create(Icons.view_day_outline(), Icons.view_day())
            .clickable()
            .setTooltip(noStripsToolTip)
            .toggleOnClick(true)
            .onToggle(
                toggleMdiIcon -> {
                  dataTable.setStriped(!dataTable.isStriped());
                  toggleMdiIcon.setTooltip(dataTable.isStriped() ? stripsToolTip : noStripsToolTip);
                });

    init(this);
  }

  @Override
  public HTMLElement element() {
    return stripesIcon.element();
  }

  /**
   * Sets the tooltip text for the "No Stripes" action button.
   *
   * @param noStripsToolTip The tooltip text for the "No Stripes" action.
   * @return This {@code StripesTableAction} instance for method chaining.
   */
  public StripesTableAction<T> setNoStripsToolTip(String noStripsToolTip) {
    this.noStripsToolTip = noStripsToolTip;
    return this;
  }

  /**
   * Sets the tooltip text for the "Stripes" action button.
   *
   * @param stripsToolTip The tooltip text for the "Stripes" action.
   * @return This {@code StripesTableAction} instance for method chaining.
   */
  public StripesTableAction<T> setStripsToolTip(String stripsToolTip) {
    this.stripsToolTip = stripsToolTip;
    return this;
  }
}
