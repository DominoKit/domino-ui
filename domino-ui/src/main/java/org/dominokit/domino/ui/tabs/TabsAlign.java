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
package org.dominokit.domino.ui.tabs;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.SpacingCss;

/**
 * Represents the alignment options available for tabs.
 *
 * <p>This enum provides alignment options for positioning the tabs. Each alignment option
 * corresponds to a specific CSS class that will be applied to align the tabs.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * TabsPanel tabsPanel = new TabsPanel();
 * tabsPanel.setAlignment(TabsAlign.CENTER);
 * </pre>
 *
 * @see TabsPanel
 * @see CssClass
 */
public enum TabsAlign {

  /** Represents tabs aligned to the start. */
  START(SpacingCss.dui_justify_start),

  /** Represents tabs aligned to the center. */
  CENTER(SpacingCss.dui_justify_center),

  /** Represents tabs aligned to the end. */
  END(SpacingCss.dui_justify_end);

  private final CssClass align;

  /**
   * Creates a {@link TabsAlign} enum instance with the specified alignment.
   *
   * @param align the CSS class representing the alignment
   */
  TabsAlign(CssClass align) {
    this.align = align;
  }

  /**
   * Returns the {@link CssClass} associated with this alignment option.
   *
   * @return the CSS class for the alignment
   */
  public CssClass getAlign() {
    return align;
  }
}
