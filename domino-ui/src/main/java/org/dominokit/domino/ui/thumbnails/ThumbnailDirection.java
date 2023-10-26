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

/**
 * Represents the directions a thumbnail can be positioned in. The directions can be either
 * row-wise, column-wise or their reverse orientations.
 *
 * <p><b>Example Usage:</b>
 *
 * <pre>
 * Thumbnail thumbnail = Thumbnail.create();
 * thumbnail.setDirection(ThumbnailDirection.ROW);
 * </pre>
 *
 * @see Thumbnail
 * @see CssClass
 * @see HasCssClass
 * @see SpacingCss
 */
public enum ThumbnailDirection implements HasCssClass {

  /** Represents the row direction */
  ROW(SpacingCss.dui_flex_row),

  /** Represents the reverse row direction */
  ROW_REVERSE(SpacingCss.dui_flex_row_reverse),

  /** Represents the column direction */
  COLUMN(SpacingCss.dui_flex_col),

  /** Represents the reverse column direction */
  COLUMN_REVERSE(SpacingCss.dui_flex_col_reverse);

  private final CssClass cssClass;

  /**
   * Constructs a new {@link ThumbnailDirection} with the given css class.
   *
   * @param cssClass the {@link CssClass} associated with the direction
   */
  ThumbnailDirection(CssClass cssClass) {
    this.cssClass = cssClass;
  }

  /**
   * Retrieves the associated CSS class for this direction.
   *
   * @return the {@link CssClass} of the direction
   */
  @Override
  public CssClass getCssClass() {
    return cssClass;
  }
}
