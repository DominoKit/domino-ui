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
package org.dominokit.domino.ui.shaded.grid.flex;

import org.dominokit.domino.ui.shaded.style.IsCssClass;

/** An enum representing the direction of the items inside the flex layout */
public enum FlexDirection implements IsCssClass {
  LEFT_TO_RIGHT(FlexStyles.FLEX_DIR_ROW),
  RIGHT_TO_LEFT(FlexStyles.FLEX_DIR_ROW_REVERSE),
  TOP_TO_BOTTOM(FlexStyles.FLEX_DIR_COLUMN),
  BOTTOM_TO_TOP(FlexStyles.FLEX_DIR_COLUMN_REVERSE);

  private final String style;

  FlexDirection(String style) {
    this.style = style;
  }

  /** {@inheritDoc} */
  @Override
  public String getStyle() {
    return style;
  }
}
