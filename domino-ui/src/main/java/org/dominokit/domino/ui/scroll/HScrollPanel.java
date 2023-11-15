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
package org.dominokit.domino.ui.scroll;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a horizontal scrollable panel component.
 *
 * <p>The {@code HScrollPanel} class provides a simple way to create a horizontal scrollable panel.
 * It extends {@link BaseDominoElement} and encapsulates a root {@link DivElement} with CSS styles
 * applied to enable horizontal scrolling.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * HScrollPanel hScrollPanel = HScrollPanel.create();
 * // Add content to the horizontal scroll panel
 * hScrollPanel.appendChild(someContentElement);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class HScrollPanel extends BaseDominoElement<HTMLDivElement, HScrollPanel> {

  private DivElement root;

  /**
   * Factory method to create a new instance of HScrollPanel.
   *
   * @return A new instance of HScrollPanel.
   */
  public static HScrollPanel create() {
    return new HScrollPanel();
  }

  /** Constructs a new HScrollPanel instance. */
  public HScrollPanel() {
    root = div().addCss(dui_overflow_x_scroll);
    init(this);
  }

  /**
   * Returns the main HTMLElement of this horizontal scroll panel, which is the root div element.
   *
   * @return The HTMLElement of the root div element.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
