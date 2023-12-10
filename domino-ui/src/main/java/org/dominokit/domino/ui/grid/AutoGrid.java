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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * The {@code AutoGrid} class creates a responsive grid layout without any media queries at all.
 *
 * <p>It allows you to create grid layouts that adapt to different screen sizes and devices
 * automatically. This class is based on the concept of a responsive grid layout without the need
 * for traditional media queries.
 *
 * <p>For more information, you can refer to the original blog post on this topic: <a
 * href="https://css-tricks.com/a-responsive-grid-layout-with-no-media-queries/">Responsive Grid
 * Layout with No Media Queries</a>.
 *
 * @see BaseDominoElement
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

  /** Creates a new instance of the {@code AutoGrid} class. */
  public static AutoGrid create() {
    return new AutoGrid();
  }

  /** Constructs a new {@code AutoGrid} instance. */
  public AutoGrid() {
    init(this);
  }

  /**
   * Sets the gap between grid items.
   *
   * @param gap The gap size as a CSS value (e.g., "20px").
   * @return This {@code AutoGrid} instance for method chaining.
   */
  public AutoGrid setGap(String gap) {
    element.setCssProperty("gap", gap);
    return this;
  }

  /**
   * Sets the minimum size for grid items.
   *
   * @param size The minimum size as a CSS value (e.g., "24rem").
   * @return This {@code AutoGrid} instance for method chaining.
   */
  public AutoGrid setGridMinSize(String size) {
    element.setCssProperty(VARIABLE_GRID_MIN_SIZE, size);
    return this;
  }

  /**
   * Retrieves the HTML {@code div} element representing this {@code AutoGrid} instance.
   *
   * @return The HTML {@code div} element.
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
