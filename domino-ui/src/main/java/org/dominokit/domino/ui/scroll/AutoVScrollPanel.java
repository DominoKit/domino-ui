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

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a vertical auto-scrollable panel component.
 *
 * <p>The {@code AutoVScrollPanel} class provides a way to create a vertical scrollable panel that
 * automatically adds a vertical scrollbar when needed based on the content's dimensions. It extends
 * {@link BaseDominoElement} and encapsulates a root {@link DivElement} with CSS styles applied to
 * enable automatic vertical scrolling.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * AutoVScrollPanel autoVScrollPanel = AutoVScrollPanel.create();
 * // Add content to the vertical auto-scrollable panel
 * autoVScrollPanel.appendChild(someVerticalContentElement);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class AutoVScrollPanel extends BaseDominoElement<HTMLDivElement, AutoVScrollPanel> {

  private DivElement root;

  /**
   * Factory method to create a new instance of AutoVScrollPanel.
   *
   * @return A new instance of AutoVScrollPanel.
   */
  public static AutoVScrollPanel create() {
    return new AutoVScrollPanel();
  }

  /** Constructs a new AutoVScrollPanel instance. */
  public AutoVScrollPanel() {
    root = div().addCss(dui_overflow_y_auto);
    init(this);
  }

  /**
   * Returns the main HTMLElement of this vertical auto-scroll panel, which is the root div element.
   *
   * @return The HTMLElement of the root div element.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
