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

import org.dominokit.domino.ui.style.IsCss;

/** An enum representing how content is distributed inside the layout */
public enum FlexJustifyContent implements IsCss {
  /** At the start of the layout */
  START(FlexStyles.FLEX_JUST_START),
  /** At the end of the layout */
  END(FlexStyles.FLEX_JUST_END),
  /** At the center of the layout */
  CENTER(FlexStyles.FLEX_JUST_CENTER),
  /**
   * Evenly distributed over all the content; first item at the start and last item at the end of
   * the layout
   */
  SPACE_BETWEEN(FlexStyles.FLEX_JUST_SPACE_BETWEEN),
  /** Evenly distributed over all the content */
  SPACE_AROUND(FlexStyles.FLEX_JUST_SPACE_AROUND),
  /** Evenly distributed over all the content with the same spacing between all items */
  SPACE_EVENLY(FlexStyles.FLEX_JUST_SPACE_EVENLY);

  private final String style;

  FlexJustifyContent(String style) {
    this.style = style;
  }

  /** {@inheritDoc} */
  @Override
  public String getStyle() {
    return style;
  }
}
