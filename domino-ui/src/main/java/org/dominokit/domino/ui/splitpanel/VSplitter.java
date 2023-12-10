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
 * Represents a vertical splitter used to resize adjacent panels in a vertical split layout.
 *
 * <p>The VSplitter is positioned between two vertical panels and allows users to drag and adjust
 * the height of the panels.
 */
class VSplitter extends BaseSplitter<VSplitter> {

  /**
   * Creates a new vertical splitter.
   *
   * @param top the top panel in the split layout
   * @param bottom the bottom panel in the split layout
   * @param vSplitPanel the vertical split panel that holds the two sub-panels
   */
  VSplitter(SplitPanel top, SplitPanel bottom, HasSplitPanels vSplitPanel) {
    super(top, bottom, vSplitPanel);
    init(this);
    handleElement.addCss(dui_vertical);
  }

  /**
   * Factory method to create a new instance of {@link VSplitter}.
   *
   * @param top the top panel to be associated with the splitter
   * @param bottom the bottom panel to be associated with the splitter
   * @param vSplitPanel the vertical split panel
   * @return a new instance of VSplitter
   */
  static VSplitter create(SplitPanel top, SplitPanel bottom, HasSplitPanels vSplitPanel) {
    return new VSplitter(top, bottom, vSplitPanel);
  }

  /**
   * Returns the y-coordinate of the mouse event.
   *
   * @param event the mouse event
   * @return the y-coordinate of the mouse cursor
   */
  public double mousePosition(MouseEvent event) {
    return event.clientY;
  }

  /**
   * Returns the y-coordinate of the touch event.
   *
   * @param event the touch event
   * @return the y-coordinate of the touch point
   */
  @Override
  protected double touchPosition(TouchEvent event) {
    return event.touches.getAt(0).clientY;
  }

  /**
   * Gets the height of the splitter.
   *
   * @return the height of the splitter
   */
  @Override
  public double getSize() {
    return element.getBoundingClientRect().height;
  }
}
