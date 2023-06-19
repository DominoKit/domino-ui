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

/** An enum to list possible values for tabs align */
public enum TabsHeaderAlign implements HasCssClass {
  /** Tabs headers will be aligned to the left of the tab panel */
  LEFT(GenericCss.dui_left),
  /** Tabs headers will be aligned to the center of the tab panel */
  CENTER(GenericCss.dui_center),
  /** Tabs headers will be aligned to the right of the tab panel */
  RIGHT(GenericCss.dui_right);

  private final CssClass align;

  /** @param align String css class name for the tab align */
  TabsHeaderAlign(CssClass align) {
    this.align = align;
  }

  /** @return String css class name for the tab align */
  public CssClass getAlign() {
    return align;
  }

  @Override
  public CssClass getCssClass() {
    return align;
  }
}
