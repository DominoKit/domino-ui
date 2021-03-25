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

import elemental2.dom.ClientRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

/** Use {@link PopupPositionBestFit} */
@Deprecated
public class PopupPositionTopDown implements PopupPosition {

  private String positionClass;

  /** {@inheritDoc} */
  @Override
  public void position(HTMLElement popup, HTMLElement target) {
    ClientRect targetRect = target.getBoundingClientRect();

    double distanceToMiddle = ((targetRect.top) - (targetRect.height / 2));
    double windowMiddle = DomGlobal.window.innerHeight >> 1;

    if (distanceToMiddle >= windowMiddle) {
      PopupPosition.TOP.position(popup, target);
      this.positionClass = PopupPosition.TOP.getDirectionClass();
    } else {
      PopupPosition.BOTTOM.position(popup, target);
      this.positionClass = PopupPosition.BOTTOM.getDirectionClass();
    }
  }

  /** {@inheritDoc} */
  @Override
  public String getDirectionClass() {
    return positionClass;
  }
}
