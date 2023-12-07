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
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;
import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import org.dominokit.domino.ui.style.Style;

/** LeftUpDropDirection class. */
public class LeftUpDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public void position(Element source, Element target) {
    dui_flex_col_reverse.apply(source);
    DOMRect targetRect = target.getBoundingClientRect();
    DOMRect sourceRect = source.getBoundingClientRect();

    Style.of(source)
        .style
        .setProperty(
            "top",
            px.of((targetRect.top + window.pageYOffset) - (sourceRect.height - targetRect.height)));

    Style.of(source).style.setProperty("left", px.of(targetRect.left));

    dui_dd_left_down.apply(source);
    elements
        .elementOf(source)
        .setCssProperty(
            "--dui-dd-position-delta",
            ((target.getBoundingClientRect().top - source.getBoundingClientRect().top)) + "px");
    elements.elementOf(source).setCssProperty("--dui-menu-drop-min-width", targetRect.width + "px");

    DOMRect newRect = source.getBoundingClientRect();
    double left =
        targetRect.left
            - (newRect.left - targetRect.left)
            + window.pageXOffset
            - sourceRect.width
            - (source.hasAttribute("dui-position-x-offset")
                ? Double.parseDouble(source.getAttribute("dui-position-x-offset"))
                : 0);
    Style.of(source).style.setProperty("left", px.of(Math.max(left, 0)));
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    dui_dd_left_up.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-dd-position-delta");
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
