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
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;
import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.Element;
import org.dominokit.domino.ui.style.Style;

/** LeftMiddleDropDirection class. */
public class LeftMiddleDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public DropDirection position(DropDirectionContext context) {
    Element source = context.getSource();
    cleanup(source);
    dui_flex_col_reverse.remove(source);

    SpaceChecker spaceChecker = context.getSpaceChecker();

    Style.of(source).style.setProperty("top", px.of(0));
    Style.of(source).style.setProperty("left", px.of(0));

    if (spaceChecker.hasSpaceOnLeft()) {
      spaceChecker = context.newSpaceChecker();
      double spaceNeeded = (spaceChecker.getSourceHeight() - spaceChecker.getTargetHeight()) / 2;
      double spaceDown = spaceChecker.getAvailableSpaceOnBottom();
      double spaceUp = spaceChecker.getAvailableSpaceOnTop();
      double delta = 0;
      if (spaceNeeded > spaceDown && spaceNeeded > spaceUp) {
        elementOf(context.getSource()).setCssProperty(spaceChecker.getMaximumSideSpaceProperty());
        elementOf(context.getSource())
            .setCssProperty(spaceChecker.getMaximumVerticalSpaceProperty());
        context.newSpaceChecker();

        return position(context);
      } else if (spaceNeeded > spaceUp) {
        delta = spaceNeeded - spaceUp;
      } else if (spaceNeeded > spaceDown) {
        delta = -1 * (spaceNeeded - spaceDown);
      }

      double arrowOffset = (delta + (spaceChecker.getTargetHeight() / 2));

      dui_dd_left_middle.apply(source);
      elements.elementOf(source).setCssProperty("--dui-dd-position-delta", arrowOffset + "px");
      elements
          .elementOf(source)
          .setCssProperty("--dui-menu-drop-min-width", spaceChecker.getTargetWidth() + "px");

      double pageYOffset = window.pageYOffset;
      double targetTop = spaceChecker.getTargetTop();
      double hh = (spaceChecker.getSourceHeight() - spaceChecker.getTargetHeight()) / 2;
      double top = targetTop + pageYOffset - hh + delta;
      Style.of(source).style.setProperty("top", px.of(top));
      double left =
          spaceChecker.getTargetLeft() - spaceChecker.getSourceWidth() + window.pageXOffset;
      Style.of(source).style.setProperty("left", px.of(left));

      return this;
    } else if (spaceChecker.hasSpaceOnRight()) {
      return RIGHT_MIDDLE.position(context);
    } else if (spaceChecker.hasSpaceAbove()) {
      return TOP_MIDDLE.position(context);
    } else if (spaceChecker.hasSpaceBelow()) {
      return BOTTOM_MIDDLE.position(context);
    } else {
      elementOf(context.getSource()).setCssProperty(spaceChecker.getMaximumSideSpaceProperty());
      elementOf(context.getSource()).setCssProperty(spaceChecker.getMaximumVerticalSpaceProperty());
      context.newSpaceChecker();

      return position(context);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    cleanSelf(source);
    RIGHT_MIDDLE.cleanSelf(source);
    TOP_MIDDLE.cleanSelf(source);
    BOTTOM_MIDDLE.cleanSelf(source);
    MIDDLE_SCREEN.cleanSelf(source);
  }

  @Override
  public void cleanSelf(Element source) {
    dui_dd_left_middle.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-dd-position-delta");
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
