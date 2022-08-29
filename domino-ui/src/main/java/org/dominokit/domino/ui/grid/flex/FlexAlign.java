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

/** Am enum representing the alignment of flex */
public enum FlexAlign implements IsCss {
  /** The alignment will be at the start of the layout */
  START(FlexStyles.FLEX_ALIGN_START, "flex-start"),
  /** The alignment will be at the end of the layout */
  END(FlexStyles.FLEX_ALIGN_END, "flex-end"),
  /** The alignment will be at the center of the layout */
  CENTER(FlexStyles.FLEX_ALIGN_CENTER, "center"),
  /** The alignment will cover all the layout */
  STRETCH(FlexStyles.FLEX_ALIGN_STRETCH, "stretch"),
  /** The alignment will be based on the original alignment */
  BASE_LINE(FlexStyles.FLEX_ALIGN_BASELINE, "baseline");

  private final String style;
  private final String value;

  FlexAlign(String style, String value) {
    this.style = style;
    this.value = value;
  }

  /** {@inheritDoc} */
  @Override
  public String getStyle() {
    return style;
  }

  /** @return The style */
  public String getValue() {
    return value;
  }
}
