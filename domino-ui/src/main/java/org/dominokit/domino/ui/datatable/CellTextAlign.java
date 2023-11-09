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
package org.dominokit.domino.ui.datatable;

import static org.dominokit.domino.ui.style.SpacingCss.*;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;

/**
 * Enum representing possible text alignment options for cells within the data table. This provides
 * alignment styling based on the defined CSS classes.
 */
public enum CellTextAlign implements HasCssClass {

  /** Aligns the text to the left. */
  LEFT(dui_text_left),

  /** Aligns the text to the right. */
  RIGHT(dui_text_right),

  /** Centers the text. */
  CENTER(dui_text_center),

  /** Justifies the text. */
  JUSTIFY(dui_text_justify),

  /** Inherit the alignment from the parent element. */
  INHERIT(dui_text_inherit),

  /** Use the current alignment setting. */
  CURRENT(dui_text_current);

  private final CssClass cssClass;

  /**
   * Constructs a CellTextAlign enum item.
   *
   * @param alignCss the associated CSS class defining the alignment style.
   */
  CellTextAlign(CssClass alignCss) {
    this.cssClass = alignCss;
  }

  /**
   * Retrieves the CSS class associated with this alignment setting.
   *
   * @return the alignment's CSS class.
   */
  @Override
  public CssClass getCssClass() {
    return cssClass;
  }
}
