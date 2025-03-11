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
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;
import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.Style;

/** LeftDownDropDirection class. */
public class LeftDownDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public DropDirection position(DropDirectionContext context) {
    Element source = context.getSource();
    Element target = context.getTarget();
    cleanup(source);
    SpaceChecker spaceChecker = context.getSpaceChecker();

    if (spaceChecker.hasSpaceOnLeft()) {
      if (spaceChecker.hasSpaceBelow()) {
        double delta = 0;
        double availableSpace = spaceChecker.getAvailableSpaceOnTop();
        if (availableSpace < spaceChecker.getSourceHeight()) {
          delta = spaceChecker.getSourceHeight() - availableSpace;
        }

        Style.of(source)
            .style
            .setProperty("top", px.of((spaceChecker.getTargetTop() + window.pageYOffset - delta)));

        Style.of(source).style.setProperty("left", px.of(0));

        dui_dd_left_down.apply(source);
        elements
            .elementOf(source)
            .setCssProperty(
                "--dui-dd-position-delta",
                ((target.getBoundingClientRect().top - source.getBoundingClientRect().top)) + "px");
        elements
            .elementOf(source)
            .setCssProperty("--dui-menu-drop-min-width", spaceChecker.getTargetWidth() + "px");

        spaceChecker = context.newSpaceChecker();
        double left =
            spaceChecker.getTargetLeft() - spaceChecker.getSourceWidth() + window.pageXOffset;

        Style.of(source).style.setProperty("left", px.of(Math.max(left, 0)));
        return this;
      } else if (spaceChecker.hasSpaceAbove()) {
        return LEFT_UP.position(context);
      } else {
        return MIDDLE_SCREEN.position(context);
      }
    } else if (spaceChecker.hasSpaceOnRight()) {
      return RIGHT_DOWN.position(context);
    } else if (spaceChecker.hasSpaceBelow()) {
      return BOTTOM_MIDDLE.position(context);
    } else if (spaceChecker.hasSpaceAbove()) {
      return TOP_MIDDLE.position(context);
    }

    return MIDDLE_SCREEN.position(context);
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    cleanSelf(source);
    RIGHT_DOWN.cleanSelf(source);
    MIDDLE_SCREEN.cleanSelf(source);
    RIGHT_DOWN.cleanSelf(source);
    BOTTOM_MIDDLE.cleanSelf(source);
    TOP_MIDDLE.cleanSelf(source);
  }

  @Override
  public void cleanSelf(Element source) {
    dui_dd_left_down.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-dd-position-delta");
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
