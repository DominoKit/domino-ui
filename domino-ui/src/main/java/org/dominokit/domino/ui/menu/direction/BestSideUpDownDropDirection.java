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

import elemental2.dom.DOMRect;
import elemental2.dom.Element;

/**
 * BestSideUpDownDropDirection class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class BestSideUpDownDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public void position(Element source, Element target) {
    dui_flex_col_reverse.remove(source);
    cleanup(source);
    DOMRect targetRect = target.getBoundingClientRect();
    DOMRect sourceRect = source.getBoundingClientRect();
    int innerWidth = window.innerWidth;
    int innerHeight = window.innerHeight;

    double sourceHeight = sourceRect.height;
    double downSpace = innerHeight - targetRect.height;
    double sourceWidth = sourceRect.width;
    double rightSpace = innerWidth - targetRect.right - window.pageXOffset;

    DropDirection currentPosition;

    if (hasSpaceOnRightSide(sourceWidth, rightSpace)) {
      if (hasSpaceBelow(sourceHeight, downSpace)) {
        currentPosition = DropDirection.BOTTOM_RIGHT;
      } else {
        currentPosition = DropDirection.TOP_RIGHT;
      }
    } else {
      if (hasSpaceBelow(sourceHeight, downSpace)) {
        currentPosition = DropDirection.BOTTOM_LEFT;
      } else {
        currentPosition = DropDirection.TOP_LEFT;
      }
    }

    currentPosition.position(source, target);
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    DropDirection.BOTTOM_RIGHT.cleanup(source);
    DropDirection.TOP_RIGHT.cleanup(source);
    DropDirection.BOTTOM_LEFT.cleanup(source);
    DropDirection.TOP_LEFT.cleanup(source);
  }

  private boolean hasSpaceBelow(double sourceHeight, double downSpace) {
    return downSpace > sourceHeight;
  }

  private boolean hasSpaceOnRightSide(double sourceWidth, double rightSpace) {
    return rightSpace > sourceWidth;
  }
}
