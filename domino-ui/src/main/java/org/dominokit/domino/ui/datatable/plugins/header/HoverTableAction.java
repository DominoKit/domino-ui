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
 * An implementation of the {@link HeaderActionElement} that allows toggling table hover effect.
 *
 * @param <T> The type of data in the DataTable.
 */
public class HoverTableAction<T> extends BaseDominoElement<HTMLElement, HoverTableAction<T>> {

  private final ToggleIcon<?, ?> hoverIcon;
  private String hoverToolTip = "Hover";
  private String noHoverToolTip = "No Hover";

  public static <T> HoverTableAction<T> create(DataTable<T> dataTable) {
    return new HoverTableAction<>(dataTable);
  }

  /**
   * Creates an element that represents a toggle button for enabling or disabling table hover
   * effect.
   *
   * @param dataTable The DataTable to apply the hover action to.
   */
  public HoverTableAction(DataTable<T> dataTable) {
    hoverIcon =
        ToggleMdiIcon.create(Icons.blur_off(), Icons.blur())
            .clickable()
            .toggleOnClick(true)
            .setTooltip(noHoverToolTip)
            .onToggle(
                toggleMdiIcon -> {
                  dataTable.setHover(!dataTable.isHover());
                  toggleMdiIcon.setTooltip(dataTable.isHover() ? noHoverToolTip : hoverToolTip);
                });
    init(this);
  }

  @Override
  public HTMLElement element() {
    return hoverIcon.element();
  }

  /**
   * Sets the tooltip text for the "Hover" action button.
   *
   * @param hoverToolTip The tooltip text for the "Hover" action.
   * @return This {@code HoverTableAction} instance for method chaining.
   */
  public HoverTableAction<T> setHoverToolTip(String hoverToolTip) {
    this.hoverToolTip = hoverToolTip;
    return this;
  }

  /**
   * Sets the tooltip text for the "No Hover" action button.
   *
   * @param noHoverToolTip The tooltip text for the "No Hover" action.
   * @return This {@code HoverTableAction} instance for method chaining.
   */
  public HoverTableAction<T> setNoHoverToolTip(String noHoverToolTip) {
    this.noHoverToolTip = noHoverToolTip;
    return this;
  }
}
