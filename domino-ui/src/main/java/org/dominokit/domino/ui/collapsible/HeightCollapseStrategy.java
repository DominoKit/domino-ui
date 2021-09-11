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
package org.dominokit.domino.ui.collapsible;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.collapsible.Collapsible.DOM_UI_SCROLL_HEIGHT;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.CSSProperties;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * An implementation of {@link CollapseStrategy} that uses the css display property to hide/show the
 * collapsible element
 */
public class HeightCollapseStrategy implements CollapseStrategy {

  public static final String D_COLLAPSED = "d-collapsed";
  private final CollapseDuration transition;

  public HeightCollapseStrategy() {
    this.transition = CollapseDuration._200ms;
  }

  public HeightCollapseStrategy(CollapseDuration transition) {
    this.transition = transition;
  }

  @Override
  public void init(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    style.add(CollapsibleStyles.HEIGHT_COLLAPSED_OVERFLOW);
    style.add(transition.getStyle());
  }

  /** {@inheritDoc} */
  @Override
  public void show(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    DominoElement.of(element)
        .apply(
            self -> {
              if (self.isAttached()) {
                expandElement(element, style);
              } else {
                self.onAttached(
                    mutationRecord -> {
                      expandElement(element, style);
                    });
              }
            });
  }

  private void expandElement(
      HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {

    EventListener stopListener;

    stopListener =
        evt -> {
          String collapseHeight = element.getAttribute("dom-ui-collapse-height");
          DominoElement.of(element).removeAttribute("dom-ui-collapse-height");
          element.style.height = CSSProperties.HeightUnionType.of(collapseHeight);
        };

    String scrollHeight = element.getAttribute(DOM_UI_SCROLL_HEIGHT);
    if (nonNull(scrollHeight)) {
      AddEventListenerOptions addEventListenerOptions = AddEventListenerOptions.create();
      addEventListenerOptions.setOnce(true);
      element.addEventListener("webkitAnimationEnd", stopListener, addEventListenerOptions);
      element.addEventListener("MSAnimationEnd", stopListener, addEventListenerOptions);
      element.addEventListener("mozAnimationEnd", stopListener, addEventListenerOptions);
      element.addEventListener("oanimationend", stopListener, addEventListenerOptions);
      element.addEventListener("animationend", stopListener, addEventListenerOptions);
      int desiredHeight = Math.max(Integer.parseInt(scrollHeight), element.scrollHeight);
      element.style.height = CSSProperties.HeightUnionType.of(desiredHeight + "px");
      style.remove(CollapsibleStyles.HEIGHT_COLLAPSED);
      DominoElement.of(element).removeAttribute(D_COLLAPSED).removeAttribute(DOM_UI_SCROLL_HEIGHT);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void hide(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    collapseElement(element, style);
  }

  private void collapseElement(
      HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    DominoElement<HTMLElement> elementToCollapse = DominoElement.of(element);
    int scrollHeight = element.scrollHeight;
    CSSProperties.HeightUnionType originalHeight = element.style.height;
    elementToCollapse
        .setAttribute("dom-ui-collapse-height", originalHeight.asString())
        .setAttribute(DOM_UI_SCROLL_HEIGHT, scrollHeight);
    element.style.height = CSSProperties.HeightUnionType.of(scrollHeight + "px");
    style.add(CollapsibleStyles.HEIGHT_COLLAPSED);
    elementToCollapse
        .setAttribute(D_COLLAPSED, "true")
        .setAttribute(DOM_UI_SCROLL_HEIGHT, scrollHeight);
  }
}
