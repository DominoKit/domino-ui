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
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.CssClass;

/**
 * Position the popover on the better position based on the target element location in the screen.
 *
 * <p>I.e. if the popover will exceed the window from the bottom, then it will be better to show it
 * on the top
 */
public class PopupPositionBestFit implements PopupPosition {

  private CssClass positionClass = PopupPosition.TOP.getDirectionClass();

  /** {@inheritDoc} */
  @Override
  public void position(Element popup, Element target) {
    DOMRect targetRect = target.getBoundingClientRect();
    double bottom = targetRect.bottom + popup.getBoundingClientRect().height;
    double right = targetRect.right + popup.getBoundingClientRect().height;

    int innerHeight = DomGlobal.window.innerHeight;

    if (bottom < innerHeight) {
      position(popup, target, BOTTOM);
    } else if (popup.getBoundingClientRect().height < targetRect.top) {
      position(popup, target, TOP);
    } else if (popup.getBoundingClientRect().width < targetRect.left) {
      position(popup, target, LEFT);
    } else if (right < DomGlobal.window.innerWidth) {
      position(popup, target, RIGHT);
    } else {
      position(popup, target, BOTTOM);
    }
  }

  protected void position(Element popup, Element target, PopupPosition popupPosition) {
    popupPosition.position(popup, target);
    this.positionClass = popupPosition.getDirectionClass();
  }

  /** {@inheritDoc} */
  @Override
  public CssClass getDirectionClass() {
    return positionClass;
  }
}
