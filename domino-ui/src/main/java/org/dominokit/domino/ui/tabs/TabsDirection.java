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
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.HasCssClass;

/**
 * Represents the direction options available for tabs.
 *
 * <p>This enum provides direction options for positioning the tabs. Each direction option
 * corresponds to a specific CSS class that will be applied to set the direction of the tabs.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * TabsPanel tabsPanel = new TabsPanel();
 * tabsPanel.setDirection(TabsDirection.VERTICAL);
 * </pre>
 *
 * @see TabsPanel
 * @see CssClass
 * @see HasCssClass
 */
public enum TabsDirection implements HasCssClass {

  /** Represents tabs laid out horizontally. */
  HORIZONTAL(GenericCss.dui_horizontal),

  /** Represents tabs laid out vertically. */
  VERTICAL(GenericCss.dui_vertical);

  private final CssClass direction;

  /**
   * Creates a {@link TabsDirection} enum instance with the specified direction.
   *
   * @param direction the CSS class representing the direction
   */
  TabsDirection(CssClass direction) {
    this.direction = direction;
  }

  /**
   * Returns the {@link CssClass} associated with this direction option.
   *
   * @return the CSS class for the direction
   */
  @Override
  public CssClass getCssClass() {
    return direction;
  }
}
