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

public class CondenseTableAction<T> extends BaseDominoElement<HTMLElement, CondenseTableAction<T>> {

  private final ToggleIcon<?, ?> condenseIcon;
  private String condenseToolTip = "Condense";
  private String expandToolTip = "Expand";

  public static <T> CondenseTableAction<T> create(DataTable<T> dataTable) {
    return new CondenseTableAction<>(dataTable);
  }

  public CondenseTableAction(DataTable<T> dataTable) {
    condenseIcon =
        ToggleMdiIcon.create(Icons.arrow_collapse_vertical(), Icons.arrow_expand_vertical())
            .clickable()
            .setTooltip(condenseToolTip)
            .toggleOnClick(true)
            .onToggle(
                toggleMdiIcon -> {
                  dataTable.setCondensed(!dataTable.isCondensed());
                  toggleMdiIcon.setTooltip(
                      dataTable.isCondensed() ? condenseToolTip : expandToolTip);
                });
    init(this);
  }

  /**
   * Sets the tooltip text for the condense action button.
   *
   * @param condenseToolTip The tooltip text for the condense action.
   * @return This {@code CondenseTableAction} instance for method chaining.
   */
  public CondenseTableAction<T> setCondenseToolTip(String condenseToolTip) {
    this.condenseToolTip = condenseToolTip;
    return this;
  }

  /**
   * Sets the tooltip text for the expand action button.
   *
   * @param expandToolTip The tooltip text for the expand action.
   * @return This {@code CondenseTableAction} instance for method chaining.
   */
  public CondenseTableAction<T> setExpandToolTip(String expandToolTip) {
    this.expandToolTip = expandToolTip;
    return this;
  }

  @Override
  public HTMLElement element() {
    return condenseIcon.element();
  }
}
