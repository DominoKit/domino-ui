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

import static org.dominokit.domino.ui.style.SpacingCss.dui_flex_col_reverse;

import elemental2.dom.Element;

/** BestSideUpDownDropDirection class. */
public class BestSideUpDownDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public DropDirection position(Element source, Element target) {
    cleanup(source);
    dui_flex_col_reverse.remove(source);

    SpaceChecker spaceChecker = SpaceChecker.of(source, target);

    if (spaceChecker.hasSpaceOnRight()) {
      if (spaceChecker.hasSpaceBelow()) {
        return BOTTOM_RIGHT.position(source, target);
      } else if (spaceChecker.hasSpaceAbove()) {
        return TOP_RIGHT.position(source, target);
      }
    } else if (spaceChecker.hasSpaceOnLeft()) {
      if (spaceChecker.hasSpaceBelow()) {
        return BOTTOM_LEFT.position(source, target);
      } else if (spaceChecker.hasSpaceAbove()) {
        return TOP_LEFT.position(source, target);
      }
    }

    return MIDDLE_SCREEN.position(source, target);
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    DropDirection.BOTTOM_RIGHT.cleanSelf(source);
    DropDirection.TOP_RIGHT.cleanSelf(source);
    DropDirection.BOTTOM_LEFT.cleanSelf(source);
    DropDirection.TOP_LEFT.cleanSelf(source);
    DropDirection.MIDDLE_SCREEN.cleanSelf(source);
  }
}
