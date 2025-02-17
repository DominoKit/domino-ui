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
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;
import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.Style;

/** TopMiddleDropDirection class. */
public class TopMiddleDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public DropDirection position(Element source, Element target) {
    cleanup(source);
    dui_flex_col_reverse.apply(source);

    Style.of(source).style.setProperty("left", px.of(0));
    SpaceChecker spaceChecker = SpaceChecker.of(source, target);
    elements
        .elementOf(source)
        .setCssProperty("--dui-menu-drop-min-width", spaceChecker.getTargetWidth() + "px");
    dui_dd_top_middle.apply(source);

    spaceChecker = SpaceChecker.of(source, target);
    if (spaceChecker.hasSpaceAbove() || spaceChecker.hasSpaceBelow()) {
      if (spaceChecker.hasSpaceAbove()) {
        return showUpMiddle(source, spaceChecker);
      } else if (spaceChecker.hasSpaceBelow()) {
        return DropDirection.BOTTOM_MIDDLE.position(source, target);
      }
    }
    return DropDirection.MIDDLE_SCREEN.position(source, target);
  }

  private DropDirection showUpMiddle(Element source, SpaceChecker spaceChecker) {
    Style.of(source)
        .style
        .setProperty(
            "top",
            px.of(
                (spaceChecker.getTargetTop() + window.pageYOffset)
                    - spaceChecker.getSourceHeight()
                    - 1));

    double delta = 0;
    double availableSpace = spaceChecker.getAvailableSpaceOnLeft();

    if (availableSpace
        < ((spaceChecker.getSourceWidth() / 2) - ((spaceChecker.getTargetWidth() / 2)))) {
      delta =
          Math.abs(
              availableSpace
                  - ((spaceChecker.getSourceWidth() / 2) - (spaceChecker.getTargetWidth() / 2)));
    }

    double rightSpace = spaceChecker.getAvailableSpaceOnRight();

    if (rightSpace < ((spaceChecker.getSourceWidth() / 2) - (spaceChecker.getTargetWidth() / 2))) {
      delta =
          -1
              * ((spaceChecker.getSourceWidth() / 2)
                  - (spaceChecker.getTargetWidth() / 2)
                  - rightSpace);
    }

    double offset = delta;

    if (delta > 0) {
      offset = Math.min(delta, (spaceChecker.getSourceWidth() / 2) - 12);
    } else if (delta < 0) {
      offset = Math.min(Math.abs(delta), (spaceChecker.getSourceWidth() / 2) - 12) * -1;
    }

    elements.elementOf(source).setCssProperty("--dui-menu-drop-pin-offset", offset + "px");
    double left =
        spaceChecker.getLeftSpace()
            - ((spaceChecker.getSourceWidth() / 2) - (spaceChecker.getTargetWidth() / 2))
            - window.pageXOffset
            + delta
            - elements.body().element().getBoundingClientRect().left;

    Style.of(source).style.setProperty("left", px.of(Math.max(left, 0)));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    cleanSelf(source);
    BOTTOM_MIDDLE.cleanSelf(source);
    MIDDLE_SCREEN.cleanSelf(source);
  }

  @Override
  public void cleanSelf(Element source) {
    dui_dd_top_middle.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
