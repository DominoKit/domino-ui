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

/** Am enum representing the alignment of flex */
public enum FlexAlignSelf implements HasCssClass {
  AUTO(dui_self_auto),
  START(dui_self_start),
  /** The alignment will be at the end of the layout */
  END(dui_self_end),
  /** The alignment will be at the center of the layout */
  CENTER(dui_self_center),
  /** The alignment will cover all the layout */
  STRETCH(dui_self_stretch),
  /** The alignment will be based on the original alignment */
  BASE_LINE(dui_self_baseline);

  private final CssClass style;

  FlexAlignSelf(CssClass style) {
    this.style = style;
  }

  @Override
  public CssClass getCssClass() {
    return style;
  }
}
