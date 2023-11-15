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
 * Represents a scrollable panel component.
 *
 * <p>The {@code ScrollPanel} class provides a simple way to create a scrollable panel. It extends
 * {@link BaseDominoElement} and encapsulates a root {@link DivElement} with CSS styles applied to
 * enable scrolling.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * ScrollPanel scrollPanel = ScrollPanel.create();
 * // Add content to the scroll panel
 * scrollPanel.appendChild(someContentElement);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class ScrollPanel extends BaseDominoElement<HTMLDivElement, ScrollPanel> {

  private DivElement root;

  /**
   * Factory method to create a new instance of ScrollPanel.
   *
   * @return A new instance of ScrollPanel.
   */
  public static ScrollPanel create() {
    return new ScrollPanel();
  }

  /** Constructs a new ScrollPanel instance. */
  public ScrollPanel() {
    root = div().addCss(dui_overflow_scroll);
    init(this);
  }

  /**
   * Returns the main HTMLElement of this scroll panel, which is the root div element.
   *
   * @return The HTMLElement of the root div element.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
