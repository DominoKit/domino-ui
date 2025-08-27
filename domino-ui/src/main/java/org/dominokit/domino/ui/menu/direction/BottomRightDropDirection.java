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

/** BottomRightDropDirection class. */
public class BottomRightDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public DropDirection position(DropDirectionContext context) {
    Element source = context.getSource();
    cleanup(source);
    dui_flex_col_reverse.remove(source);

    SpaceChecker spaceChecker = context.getSpaceChecker();

    if (spaceChecker.hasSpaceOnRight()) {
      return showOnbottomRight(context, spaceChecker, source);
    } else if (spaceChecker.hasSpaceOnLeft()) {
      return BOTTOM_LEFT.position(context);
    } else if (spaceChecker.hasSpaceBelow()) {
      return BOTTOM_MIDDLE.position(context);
    } else if (spaceChecker.hasSpaceAbove()) {
      return TOP_MIDDLE.position(context);
    } else {
      if (context.isAllowFallBack()) {
        return fallBackPosition(context, spaceChecker);
      } else {
        return showOnbottomRight(context, spaceChecker, source);
      }
    }
  }

  private DropDirection showOnbottomRight(
      DropDirectionContext context, SpaceChecker spaceChecker, Element source) {
    if (spaceChecker.hasSpaceBelow()) {
      double delta = 0;
      double availableSpace = spaceChecker.getAvailableSpaceOnRight();
      if (availableSpace < spaceChecker.getSourceWidth()) {
        delta = spaceChecker.getSourceWidth() - availableSpace;
      }

      Style.of(source)
          .style
          .setProperty(
              "top",
              px.of(
                  (spaceChecker.getTargetTop() + window.pageYOffset)
                      + spaceChecker.getTargetHeight()
                      + 1));
      Style.of(source).style.setProperty("left", px.of(spaceChecker.getTargetLeft()));
      dui_dd_bottom_right.apply(source);
      elements
          .elementOf(source)
          .setCssProperty("--dui-menu-drop-min-width", spaceChecker.getTargetWidth() + "px");
      spaceChecker = context.newSpaceChecker();
      double left =
          (spaceChecker.getTargetLeft()
                  - (spaceChecker.getSourceLeft() - spaceChecker.getTargetLeft()))
              + window.pageXOffset
              - delta;
      Style.of(source).style.setProperty("left", px.of(Math.max(left, 0)));
      return this;
    } else if (spaceChecker.hasSpaceAbove()) {
      return DropDirection.TOP_RIGHT.position(context);
    } else {
      return DropDirection.MIDDLE_SCREEN.position(context);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    cleanSelf(source);
    MIDDLE_SCREEN.cleanSelf(source);
    BOTTOM_LEFT.cleanSelf(source);
    BOTTOM_MIDDLE.cleanSelf(source);
    TOP_MIDDLE.cleanSelf(source);
    TOP_RIGHT.cleanSelf(source);
  }

  @Override
  public void cleanSelf(Element source) {
    dui_dd_bottom_right.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
