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
package org.dominokit.domino.ui.dialogs;

import static org.dominokit.domino.ui.style.GenericCss.*;

import org.dominokit.domino.ui.style.CssClass;

/**
 * Enumerates different sizes for dialogs, providing both width and height styles for each size.
 *
 * <p>This allows for a consistent sizing mechanism across different dialogs.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * DialogSize size = DialogSize.SMALL;
 * CssClass width = size.getWidthStyle();
 * CssClass height = size.getHeightStyle();
 * </pre>
 *
 * @see CssClass
 */
public enum DialogSize implements IsDialogSize {

  /** Very small dialog size. */
  VERY_SMALL(dui_w_xsmall, dui_h_xsmall),

  /** Small dialog size. */
  SMALL(dui_w_small, dui_h_small),

  /** Medium dialog size. */
  MEDIUM(dui_w_medium, dui_h_medium),

  /** Large dialog size. */
  LARGE(dui_w_large, dui_h_large),

  /** Very large dialog size. */
  VERY_LARGE(dui_w_xlarge, dui_h_xlarge);

  private CssClass widthStyle;
  private CssClass heightStyle;

  /**
   * Constructs a {@link DialogSize} enum value with specific width and height styles.
   *
   * @param widthStyle the {@link CssClass} representing the width style
   * @param heightStyle the {@link CssClass} representing the height style
   */
  DialogSize(CssClass widthStyle, CssClass heightStyle) {
    this.widthStyle = widthStyle;
    this.heightStyle = heightStyle;
  }

  /**
   * Retrieves the width style as a {@link CssClass}.
   *
   * @return the {@link CssClass} representing the width style
   */
  public CssClass getWidthStyle() {
    return widthStyle;
  }

  /**
   * Retrieves the height style as a {@link CssClass}.
   *
   * @return the {@link CssClass} representing the height style
   */
  public CssClass getHeightStyle() {
    return heightStyle;
  }
}
