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
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.CssClass;

import static elemental2.dom.DomGlobal.window;

/**
 * Position the popover on the right or the left based on the location of the target element in the
 * screen.
 *
 * <p>I.e. if showing the popover on the left will exceed the window, then it will be better to show
 * it on the right
 */
public class PopupPositionLeftRight implements PopupPosition {

  private CssClass positionClass = PopupPosition.RIGHT.getDirectionClass();

  /** {@inheritDoc} */
  @Override
  public void position(HTMLElement popup, HTMLElement target) {
    DOMRect targetRect = target.getBoundingClientRect();

    double distanceToCenter = (targetRect.left) - (targetRect.width / 2);
    double windowCenter = window.innerWidth >> 1;

    if (distanceToCenter >= windowCenter) {
      PopupPosition.LEFT.position(popup, target);
      this.positionClass = PopupPosition.LEFT.getDirectionClass();
    } else {
      PopupPosition.RIGHT.position(popup, target);
      this.positionClass = PopupPosition.RIGHT.getDirectionClass();
    }
  }

  /** {@inheritDoc} */
  @Override
  public CssClass getDirectionClass() {
    return positionClass;
  }
}
