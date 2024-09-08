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
package org.dominokit.domino.ui.shaded.dropdown;

import elemental2.dom.HTMLElement;

/**
 * The dropdown position
 *
 * <p>An interface to position the dropdown relative to its target element
 */
@Deprecated
public interface DropDownPosition {

  /** Positions the menu on the top of its target element */
  DropDownPosition TOP = new DropDownPositionTop();
  /** Positions the menu on the top right of its target element */
  DropDownPosition TOP_RIGHT = new DropDownPositionTopRight();
  /** Positions the menu on the top left of its target element */
  DropDownPosition TOP_LEFT = new DropDownPositionTopLeft();
  /** Positions the menu on the bottom of its target element */
  DropDownPosition BOTTOM = new DropDownPositionBottom();
  /** Positions the menu on the bottom left of its target element */
  DropDownPosition BOTTOM_LEFT = new DropDownPositionBottomLeft();
  /** Positions the menu on the bottom right of its target element */
  DropDownPosition BOTTOM_RIGHT = new DropDownPositionBottomRight();

  /**
   * Positions the menu based on its target
   *
   * @param actionsMenu the menu
   * @param target the target element
   */
  void position(HTMLElement actionsMenu, HTMLElement target);
}
