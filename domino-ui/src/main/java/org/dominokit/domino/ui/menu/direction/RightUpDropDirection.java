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

/** RightUpDropDirection class. */
public class RightUpDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public DropDirection position(DropDirectionContext context) {
    Element source = context.getSource();
    cleanup(source);
    dui_flex_col_reverse.apply(source);

    SpaceChecker spaceChecker = context.getSpaceChecker();

    if (spaceChecker.hasSpaceAbove()) {
      if (spaceChecker.hasSpaceOnRight()) {
        return showRightUp(context);
      } else if (spaceChecker.hasSpaceOnLeft()) {
        return LEFT_UP.position(context);
      } else {
        return TOP_MIDDLE.position(context);
      }
    } else if (spaceChecker.hasSpaceBelow()) {
      if (spaceChecker.hasSpaceOnRight()) {
        return RIGHT_DOWN.position(context);
      } else if (spaceChecker.hasSpaceOnLeft()) {
        return LEFT_DOWN.position(context);
      } else {
        return BOTTOM_MIDDLE.position(context);
      }
    } else {
      return MIDDLE_SCREEN.position(context);
    }
  }

  private DropDirection showRightUp(DropDirectionContext context) {
    Element source = context.getSource();
    SpaceChecker spaceChecker = context.getSpaceChecker();
    Style.of(source)
        .style
        .setProperty(
            "top",
            px.of(
                (spaceChecker.getTargetTop() + window.pageYOffset)
                    - (spaceChecker.getSourceHeight() - spaceChecker.getTargetHeight())));

    Style.of(source).style.setProperty("left", px.of(0));
    spaceChecker = context.newSpaceChecker();
    dui_dd_right_up.apply(source);
    elements
        .elementOf(source)
        .setCssProperty(
            "--dui-dd-position-delta",
            ((spaceChecker.getTargetTop() - spaceChecker.getSourceTop())) + "px");
    elements
        .elementOf(source)
        .setCssProperty("--dui-menu-drop-min-width", spaceChecker.getTargetWidth() + "px");

    double left = spaceChecker.getTargetLeft() + spaceChecker.getTargetWidth() + window.pageXOffset;
    Style.of(source).style.setProperty("left", px.of(Math.max(left, 0)));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    cleanSelf(source);
    LEFT_DOWN.cleanSelf(source);
    LEFT_UP.cleanSelf(source);
    RIGHT_DOWN.cleanSelf(source);
    MIDDLE_SCREEN.cleanSelf(source);
    TOP_MIDDLE.cleanSelf(source);
    BOTTOM_MIDDLE.cleanSelf(source);
  }

  @Override
  public void cleanSelf(Element source) {
    dui_dd_right_up.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-dd-position-delta");
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
