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
 * Enum to represent alignment options available for tab headers.
 *
 * <p>This enum defines alignment options for positioning the tab headers. Each alignment option
 * corresponds to a specific CSS class that will be applied to align the headers accordingly.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * TabsPanel tabsPanel = new TabsPanel();
 * tabsPanel.setHeaderAlign(TabsHeaderAlign.CENTER);
 * </pre>
 *
 * @see TabsPanel
 * @see CssClass
 * @see HasCssClass
 */
public enum TabsHeaderAlign implements HasCssClass {

  /** Represents left alignment for tab headers. */
  LEFT(GenericCss.dui_left),

  /** Represents center alignment for tab headers. */
  CENTER(GenericCss.dui_center),

  /** Represents right alignment for tab headers. */
  RIGHT(GenericCss.dui_right);

  private final CssClass align;

  /**
   * Creates a {@link TabsHeaderAlign} enum instance with the specified alignment.
   *
   * @param align the CSS class representing the alignment
   */
  TabsHeaderAlign(CssClass align) {
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

  /**
   * Returns the {@link CssClass} associated with this alignment option.
   *
   * @return the CSS class for the alignment
   */
  @Override
  public CssClass getCssClass() {
    return align;
  }
}
