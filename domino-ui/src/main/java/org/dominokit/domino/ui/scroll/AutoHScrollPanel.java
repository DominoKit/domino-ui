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
 * Represents a horizontal auto-scrollable panel component.
 *
 * <p>The {@code AutoHScrollPanel} class provides a way to create a horizontal scrollable panel that
 * automatically adds a horizontal scrollbar when needed based on the content's dimensions. It
 * extends {@link BaseDominoElement} and encapsulates a root {@link DivElement} with CSS styles
 * applied to enable automatic horizontal scrolling.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * AutoHScrollPanel autoHScrollPanel = AutoHScrollPanel.create();
 * // Add content to the horizontal auto-scrollable panel
 * autoHScrollPanel.appendChild(someHorizontalContentElement);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class AutoHScrollPanel extends BaseDominoElement<HTMLDivElement, AutoHScrollPanel> {

  private DivElement root;

  /**
   * Factory method to create a new instance of AutoHScrollPanel.
   *
   * @return A new instance of AutoHScrollPanel.
   */
  public static AutoHScrollPanel create() {
    return new AutoHScrollPanel();
  }

  /** Constructs a new AutoHScrollPanel instance. */
  public AutoHScrollPanel() {
    root = div().addCss(dui_overflow_x_auto);
    init(this);
  }

  /**
   * Returns the main HTMLElement of this horizontal auto-scroll panel, which is the root div
   * element.
   *
   * @return The HTMLElement of the root div element.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
