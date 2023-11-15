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

/** TopMiddleDropDirection class. */
public class TopMiddleDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public void position(Element source, Element target) {
    dui_flex_col_reverse.apply(source);
    DOMRect targetRect = target.getBoundingClientRect();
    DOMRect sourceRect = source.getBoundingClientRect();

    elements.elementOf(source).setCssProperty("--dui-menu-drop-min-width", targetRect.width + "px");
    targetRect = target.getBoundingClientRect();

    Style.of(source)
        .style
        .setProperty("top", px.of((targetRect.top + window.pageYOffset) - sourceRect.height - 1));

    Style.of(source).style.setProperty("left", px.of(targetRect.left));
    dui_dd_top_middle.apply(source);

    int innerWidth = window.innerWidth;
    DOMRect newRect = source.getBoundingClientRect();
    DOMRect newTargetRect = target.getBoundingClientRect();

    double delta = 0;
    double availableSpace = innerWidth - newTargetRect.right - window.pageXOffset;
    if (availableSpace < (newRect.width / 2)) {
      delta = (newRect.width / 2) - availableSpace;
    }
    elements.elementOf(source).setCssProperty("--dui-menu-drop-pin-offset", delta + "px");

    Style.of(source)
        .style
        .setProperty(
            "left",
            px.of(
                newTargetRect.left
                    - (newRect.width / 2)
                    + (newTargetRect.width / 2)
                    + window.pageXOffset
                    - delta
                    - elements.body().element().getBoundingClientRect().left));
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    dui_dd_top_middle.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
