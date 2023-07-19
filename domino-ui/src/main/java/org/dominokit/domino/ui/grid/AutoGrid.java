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
package org.dominokit.domino.ui.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Creates a responsive grid layout without <i>any</i> media queries at all.
 *
 * <p>Original blog <a
 * href="https://css-tricks.com/a-responsive-grid-layout-with-no-media-queries/">source</a>.
 */
public class AutoGrid extends BaseDominoElement<HTMLDivElement, AutoGrid> implements GridStyles {
  private static final String VARIABLE_GRID_MIN_SIZE = "--auto-grid-min-size";
  private static final String DEFAULT_MIN_SIZE = "24rem";
  private static final String DEFAULT_GAP = "20px";
  private final DivElement element =
      div()
          .addCss(dui_p_4, dui_auto_grid, dui_grid)
          .setCssProperty(VARIABLE_GRID_MIN_SIZE, DEFAULT_MIN_SIZE)
          .setCssProperty("flex", "1")
          .setCssProperty("gap", DEFAULT_GAP)
          .setCssProperty("grid-auto-rows", "max-content")
          .setCssProperty(
              "grid-template-columns", "repeat(auto-fill, minmax(var(--auto-grid-min-size), 1fr))");

  public static AutoGrid create() {
    return new AutoGrid();
  }

  public AutoGrid() {
    init(this);
  }

  public AutoGrid setGap(String gap) {
    element.setCssProperty("gap", gap);
    return this;
  }

  public AutoGrid setGridMinSize(String size) {
    element.setCssProperty(VARIABLE_GRID_MIN_SIZE, size);
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
