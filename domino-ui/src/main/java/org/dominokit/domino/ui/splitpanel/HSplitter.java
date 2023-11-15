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
package org.dominokit.domino.ui.splitpanel;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;

/**
 * Represents a horizontal splitter used to resize adjacent panels in a horizontal split layout.
 *
 * <p>The HSplitter is positioned between two horizontal panels and allows users to drag and adjust
 * the width of the panels.
 */
class HSplitter extends BaseSplitter<HSplitter> {

  /**
   * Creates a new horizontal splitter.
   *
   * @param left the left panel in the split layout
   * @param right the right panel in the split layout
   * @param hSplitPanel the horizontal split panel that holds the two sub-panels
   */
  HSplitter(SplitPanel left, SplitPanel right, HasSplitPanels hSplitPanel) {
    super(left, right, hSplitPanel);
    init(this);
    addCss(dui_horizontal);
    handleElement.addCss(dui_horizontal);
  }

  /**
   * Factory method to create a new instance of {@link HSplitter}.
   *
   * @param left the left panel to be associated with the splitter
   * @param right the right panel to be associated with the splitter
   * @param hSplitPanel the horizontal split panel
   * @return a new instance of HSplitter
   */
  static HSplitter create(SplitPanel left, SplitPanel right, HSplitPanel hSplitPanel) {
    return new HSplitter(left, right, hSplitPanel);
  }

  /**
   * Returns the x-coordinate of the touch event.
   *
   * @param event the touch event
   * @return the x-coordinate of the touch point
   */
  @Override
  protected double touchPosition(TouchEvent event) {
    return event.touches.getAt(0).clientX;
  }

  /**
   * Returns the x-coordinate of the mouse event.
   *
   * @param event the mouse event
   * @return the x-coordinate of the mouse cursor
   */
  @Override
  protected double mousePosition(MouseEvent event) {
    return event.clientX;
  }

  /**
   * Gets the width of the splitter.
   *
   * @return the width of the splitter
   */
  @Override
  public double getSize() {
    return element.getBoundingClientRect().width;
  }
}
