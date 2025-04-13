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

/** BottomLeftDropDirection class. */
public class BottomLeftDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public DropDirection position(DropDirectionContext context) {
    Element source = context.getSource();
    cleanup(source);
    dui_flex_col_reverse.remove(source);

    SpaceChecker spaceChecker = context.getSpaceChecker();

    Style.of(source)
        .style
        .setProperty(
            "top",
            px.of(
                (spaceChecker.getTargetTop() + window.pageYOffset)
                    + spaceChecker.getTargetHeight()
                    + 1));
    Style.of(source).style.setProperty("left", px.of(0));
    dui_dd_bottom_left.apply(source);
    elements
        .elementOf(source)
        .setCssProperty("--dui-menu-drop-min-width", spaceChecker.getTargetWidth() + "px");

    spaceChecker = context.newSpaceChecker();
    double left = 0;
    double delta = 0;
    if (spaceChecker.hasSpaceOnLeft()) {
      if (spaceChecker.hasSpaceBelow()) {
        left =
            spaceChecker.getTargetLeft()
                - (spaceChecker.getSourceWidth() - spaceChecker.getTargetWidth());
        if (spaceChecker.getAvailableSpaceOnRight() < 0) {
          delta =
              Math.min(
                  spaceChecker.getTargetWidth(), Math.abs(spaceChecker.getAvailableSpaceOnRight()));
        }
        left = left - delta;
        Style.of(source).style.setProperty("left", px.of(Math.max(left, 0)));
        return this;
      } else if (spaceChecker.hasSpaceAbove()) {
        return TOP_LEFT.position(context);
      } else {
        return MIDDLE_SCREEN.position(context);
      }
    } else if (spaceChecker.hasSpaceOnRight()) {
      return BOTTOM_RIGHT.position(context);
    } else if (spaceChecker.hasSpaceBelow()) {
      return BOTTOM_MIDDLE.position(context);
    } else if (spaceChecker.hasSpaceAbove()) {
      return TOP_MIDDLE.position(context);
    } else {
      return fallBackPosition(context, spaceChecker);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    cleanSelf(source);
    TOP_LEFT.cleanSelf(source);
    MIDDLE_SCREEN.cleanSelf(source);
    BOTTOM_RIGHT.cleanSelf(source);
    BOTTOM_MIDDLE.cleanSelf(source);
    TOP_MIDDLE.cleanSelf(source);
  }

  @Override
  public void cleanSelf(Element source) {
    dui_dd_bottom_left.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
