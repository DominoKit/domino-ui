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

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

/** Position the popover on the right */
public class PopupPositionRight implements PopupPosition {
  /** {@inheritDoc} */
  @Override
  public void position(HTMLElement tooltip, HTMLElement target) {
    DOMRect targetRect = target.getBoundingClientRect();
    DOMRect tooltipRect = tooltip.getBoundingClientRect();
    tooltip.style.setProperty(
        "top",
        (targetRect.top + DomGlobal.window.pageYOffset)
            + ((targetRect.height - tooltipRect.height) / 2)
            + "px");
    tooltip.style.setProperty(
        "left", targetRect.left + DomGlobal.window.pageXOffset + targetRect.width + "px");
  }

  /** {@inheritDoc} */
  @Override
  public String getDirectionClass() {
    return "right";
  }
}
