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
package org.dominokit.domino.ui.thumbnails;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;
import org.dominokit.domino.ui.style.SpacingCss;

public enum ThumbnailDirection implements HasCssClass {
  ROW(SpacingCss.dui_flex_row),
  ROW_REVERSE(SpacingCss.dui_flex_row_reverse),
  COLUMN(SpacingCss.dui_flex_col),
  COLUMN_REVERSE(SpacingCss.dui_flex_col_reverse);

  private final CssClass cssClass;

  ThumbnailDirection(CssClass cssClass) {
    this.cssClass = cssClass;
  }

  @Override
  public CssClass getCssClass() {
    return cssClass;
  }
}
