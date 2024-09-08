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

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

/**
 * Position the popover on the better position based on the target element location in the screen.
 *
 * <p>I.e. if the popover will exceed the window from the bottom, then it will be better to show it
 * on the top
 */
@Deprecated
public class PopupPositionBestFit implements PopupPosition {

  private String positionClass;

  /** {@inheritDoc} */
  @Override
  public void position(HTMLElement popup, HTMLElement target) {
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

  protected void position(HTMLElement popup, HTMLElement target, PopupPosition popupPosition) {
    popupPosition.position(popup, target);
    this.positionClass = popupPosition.getDirectionClass();
  }

  /** {@inheritDoc} */
  @Override
  public String getDirectionClass() {
    return positionClass;
  }
}
