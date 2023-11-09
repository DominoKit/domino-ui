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
import org.dominokit.domino.ui.style.HasCssClass;

/**
 * Enum to represent direction options available for tab headers.
 *
 * <p>This enum defines direction options for positioning the tab headers. Each direction option
 * corresponds to a specific CSS class that will be applied to style the headers according to the
 * desired direction.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * TabsPanel tabsPanel = new TabsPanel();
 * tabsPanel.setHeaderDirection(HeaderDirection.VERTICAL);
 * </pre>
 *
 * @see TabsPanel
 * @see CssClass
 * @see HasCssClass
 */
public enum HeaderDirection implements HasCssClass {

  /** Represents the default direction for tab headers. */
  DEFAULT(CssClass.NONE),

  /** Represents vertical direction for tab headers. */
  VERTICAL(TabStyles.dui_vertical_header),

  /** Represents reversed vertical direction for tab headers. */
  VERTICAL_REVERSED(TabStyles.dui_vertical_header_reversed);

  private final CssClass direction;

  /**
   * Creates a {@link HeaderDirection} enum instance with the specified direction.
   *
   * @param direction the CSS class representing the direction
   */
  HeaderDirection(CssClass direction) {
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
