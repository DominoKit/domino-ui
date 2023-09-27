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
package org.dominokit.domino.ui.grid.flex;

import static org.dominokit.domino.ui.style.SpacingCss.*;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;

/** An enum representing how content is distributed inside the layout */
public enum FlexJustifyContent implements HasCssClass {
  /** At the start of the layout */
  START(dui_justify_start),
  /** At the end of the layout */
  END(dui_justify_end),
  /** At the center of the layout */
  CENTER(dui_justify_center),
  /**
   * Evenly distributed over all the content; first item at the start and last item at the end of
   * the layout
   */
  SPACE_BETWEEN(dui_justify_between),
  /** Evenly distributed over all the content */
  SPACE_AROUND(dui_justify_around),
  /** Evenly distributed over all the content with the same spacing between all items */
  SPACE_EVENLY(dui_justify_evenly);

  private final CssClass style;

  FlexJustifyContent(CssClass style) {
    this.style = style;
  }

  @Override
  public CssClass getCssClass() {
    return style;
  }
}
