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
 * An enum to list possible values for tabs align
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public enum TabsDirection implements HasCssClass {
  /** Tabs headers will be aligned to the left of the tab panel */
  HORIZONTAL(GenericCss.dui_horizontal),
  /** Tabs headers will be aligned to the center of the tab panel */
  VERTICAL(GenericCss.dui_vertical);

  private final CssClass direction;

  /** @param direction String css class name for the tab align */
  TabsDirection(CssClass direction) {
    this.direction = direction;
  }

  /** @return String css class name for the tab align */
  /**
   * getCssClass.
   *
   * @return a {@link org.dominokit.domino.ui.style.CssClass} object
   */
  public CssClass getCssClass() {
    return direction;
  }
}
