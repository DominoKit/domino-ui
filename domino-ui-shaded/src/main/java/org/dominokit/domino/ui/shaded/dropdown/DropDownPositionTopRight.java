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

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.shaded.style.Unit.px;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;

/** Positions the menu on the top right of its target element */
@Deprecated
public class DropDownPositionTopRight implements DropDownPosition {
  /** {@inheritDoc} */
  @Override
  public void position(HTMLElement actionsMenu, HTMLElement target) {
    DOMRect targetRect = target.getBoundingClientRect();
    DOMRect actionsRect = actionsMenu.getBoundingClientRect();
    actionsMenu.style.setProperty(
        "top", px.of((targetRect.top + window.pageYOffset) - actionsRect.height));
    actionsMenu.style.setProperty(
        "left", px.of(targetRect.left + window.pageXOffset + targetRect.width));
  }
}
