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
package org.dominokit.domino.ui.popover;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.CssClass;

/** An interface for the required API to implement new position classes for popover */
public interface PopupPosition {
  /**
   * Positions the popover based on the target element
   *
   * @param tooltip the popover element
   * @param target the target element
   */
  void position(Element tooltip, Element target);

  /** @return the CSS class for the position */
  CssClass getDirectionClass();

  PopupPosition RIGHT = new PopupPositionRight();
  PopupPosition TOP = new PopupPositionTop();
  PopupPosition LEFT = new PopupPositionLeft();
  PopupPosition BOTTOM = new PopupPositionBottom();

  PopupPosition BEST_FIT = new PopupPositionBestFit();
  PopupPosition LEFT_RIGHT = new PopupPositionLeftRight();
}
