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
 * Represents an auto-scrollable panel component.
 *
 * <p>The {@code AutoScrollPanel} class provides a way to create a scrollable panel that
 * automatically adds scrollbars when needed based on the content's dimensions. It extends {@link
 * BaseDominoElement} and encapsulates a root {@link DivElement} with CSS styles applied to enable
 * automatic scrolling.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * AutoScrollPanel autoScrollPanel = AutoScrollPanel.create();
 * // Add content to the auto-scrollable panel
 * autoScrollPanel.appendChild(someContentElement);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class AutoScrollPanel extends BaseDominoElement<HTMLDivElement, AutoScrollPanel> {

  private DivElement root;

  /**
   * Factory method to create a new instance of AutoScrollPanel.
   *
   * @return A new instance of AutoScrollPanel.
   */
  public static AutoScrollPanel create() {
    return new AutoScrollPanel();
  }

  /** Constructs a new AutoScrollPanel instance. */
  public AutoScrollPanel() {
    root = div().addCss(dui_overflow_auto);
    init(this);
  }

  /**
   * Returns the main HTMLElement of this auto-scroll panel, which is the root div element.
   *
   * @return The HTMLElement of the root div element.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
