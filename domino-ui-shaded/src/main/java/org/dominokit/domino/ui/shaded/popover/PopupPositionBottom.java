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
package org.dominokit.domino.ui.shaded.popover;

import static elemental2.dom.DomGlobal.window;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;

/** Position the popover on the bottom */
@Deprecated
public class PopupPositionBottom implements PopupPosition {
  /** {@inheritDoc} */
  @Override
  public void position(HTMLElement tooltip, HTMLElement target) {
    DOMRect targetRect = target.getBoundingClientRect();
    DOMRect tooltipRect = tooltip.getBoundingClientRect();
    tooltip.style.setProperty(
        "top", (targetRect.top + window.pageYOffset + targetRect.height) + "px");
    tooltip.style.setProperty(
        "left", targetRect.left + ((targetRect.width - tooltipRect.width) / 2) + "px");
  }

  /** {@inheritDoc} */
  @Override
  public String getDirectionClass() {
    return "bottom";
  }
}
