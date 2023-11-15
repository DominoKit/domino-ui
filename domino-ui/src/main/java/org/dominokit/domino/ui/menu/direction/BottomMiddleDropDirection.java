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

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Style;

/** BottomMiddleDropDirection class. */
public class BottomMiddleDropDirection implements DropDirection {
  /** {@inheritDoc} */
  @Override
  public void position(Element source, Element target) {
    dui_flex_col_reverse.remove(source);
    DOMRect targetRect = target.getBoundingClientRect();

    elements.elementOf(source).setCssProperty("--dui-menu-drop-min-width", targetRect.width + "px");
    targetRect = target.getBoundingClientRect();

    Style.of(source)
        .style
        .setProperty("top", px.of((targetRect.top + window.pageYOffset) + targetRect.height + 1));

    Style.of(source).style.setProperty("left", "0");
    dui_dd_bottom_middle.apply(source);
    DomGlobal.console.info(
        "source.offsetLeft : " + Js.<HTMLElement>uncheckedCast(source).offsetLeft);

    DomGlobal.setTimeout(
        p0 -> {
          DOMRect newRect = source.getBoundingClientRect();
          DOMRect newTargetRect = target.getBoundingClientRect();

          int innerWidth = window.innerWidth;

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

          newRect = source.getBoundingClientRect();
          newTargetRect = target.getBoundingClientRect();
        },
        0);
  }

  /** {@inheritDoc} */
  @Override
  public void cleanup(Element source) {
    dui_dd_bottom_middle.remove(source);
    elements.elementOf(source).removeCssProperty("--dui-menu-drop-min-width");
  }
}
