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
package org.dominokit.domino.ui.menu.direction;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.SpacingCss.dui_flex_col_reverse;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DOMRect;
import elemental2.dom.Element;

/** BestFitSideDropDirection class. */
public class BestFitSideDropDirection implements DropDirection {

  /** {@inheritDoc} */
  @Override
  public void position(Element source, Element target) {
    cleanup(source);
    dui_flex_col_reverse.remove(source);
    DOMRect targetRect = target.getBoundingClientRect();
    DOMRect sourceRect = source.getBoundingClientRect();
    int innerWidth = window.innerWidth;
    int innerHeight = window.innerHeight;

    double sourceWidth = sourceRect.width;
    double sourceHeight = sourceRect.height;
    double rightSpace = innerWidth - targetRect.right - window.pageXOffset;
    double downSpace = innerHeight - targetRect.height;
    DropDirection currentPosition;

    if (hasSpaceOnRightSide(sourceWidth, rightSpace)) {
      if (hasSpaceBelow(sourceHeight, downSpace)) {
        currentPosition = DropDirection.RIGHT_DOWN;
      } else {
        currentPosition = DropDirection.RIGHT_UP;
      }
    } else {
      if (hasSpaceBelow(sourceHeight, downSpace)) {
        currentPosition = DropDirection.LEFT_DOWN;
      } else {
        currentPosition = DropDirection.LEFT_UP;
      }
    }
    currentPosition.position(source, target);
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    DropDirection.RIGHT_DOWN.cleanup(source);
    DropDirection.RIGHT_UP.cleanup(source);
    DropDirection.LEFT_DOWN.cleanup(source);
    DropDirection.LEFT_UP.cleanup(source);
  }

  private boolean hasSpaceBelow(double sourceHeight, double downSpace) {
    return downSpace > sourceHeight;
  }

  private boolean hasSpaceOnRightSide(double sourceWidth, double rightSpace) {
    return rightSpace > sourceWidth;
  }
}
