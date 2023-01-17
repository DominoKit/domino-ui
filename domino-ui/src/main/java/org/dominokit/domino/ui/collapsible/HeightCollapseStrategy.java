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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.collapsible.Collapsible.DOM_UI_SCROLL_HEIGHT;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
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
  private CollapsibleHandlers handlers;

  public HeightCollapseStrategy() {
    this.transition = CollapseDuration._200ms;
  }

  public HeightCollapseStrategy(CollapseDuration transition) {
    this.transition = transition;
  }

  @Override
  public void init(
      HTMLElement element,
      Style<HTMLElement, IsElement<HTMLElement>> style,
      CollapsibleHandlers handlers) {
    this.handlers = handlers;
    style.addCss(CollapsibleStyles.HEIGHT_COLLAPSED_OVERFLOW);
    style.addCss(transition.getStyle());
    element.removeAttribute("dom-ui-collapse-height");
  }

  @Override
  public void cleanup(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    style.removeCss(CollapsibleStyles.HEIGHT_COLLAPSED_OVERFLOW);
    style.removeCss(transition.getStyle());
  }

  /** {@inheritDoc} */
  @Override
  public void show(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    DominoElement.of(element)
        .apply(
            self -> {
              self.nowOrWhenAttached(
                  () -> {
                    this.handlers.onBeforeShow().run();
                    expandElement(element, style);
                  });
            });
  }

  private void expandElement(
      HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {

    DominoElement<HTMLElement> theElement = DominoElement.of(element);
    if (!theElement.containsCss(CollapsibleStyles.HEIGHT_COLLAPSED)) {
      theElement.css(CollapsibleStyles.HEIGHT_COLLAPSED);
    }

    EventListener stopListener =
        evt -> {
          String collapseHeight = element.getAttribute("dom-ui-collapse-height");
          theElement.removeAttribute("dom-ui-collapse-height");
          element.style.height = CSSProperties.HeightUnionType.of(collapseHeight);
          this.handlers.onShowCompleted().run();
        };
    String scrollHeight = element.getAttribute(DOM_UI_SCROLL_HEIGHT);
    AddEventListenerOptions addEventListenerOptions = AddEventListenerOptions.create();
    addEventListenerOptions.setOnce(true);
    element.addEventListener("webkitTransitionEnd", stopListener, addEventListenerOptions);
    element.addEventListener("MSTransitionEnd", stopListener, addEventListenerOptions);
    element.addEventListener("mozTransitionEnd", stopListener, addEventListenerOptions);
    element.addEventListener("oanimationend", stopListener, addEventListenerOptions);
    element.addEventListener("animationend", stopListener, addEventListenerOptions);
    int desiredHeight =
        isNull(scrollHeight)
            ? element.scrollHeight
            : Math.max(Integer.parseInt(scrollHeight), element.scrollHeight);
    element.style.height = CSSProperties.HeightUnionType.of(desiredHeight + "px");
    style.removeCss(CollapsibleStyles.HEIGHT_COLLAPSED);
    theElement.removeAttribute(D_COLLAPSED).removeAttribute(DOM_UI_SCROLL_HEIGHT);
  }

  /** {@inheritDoc} */
  @Override
  public void hide(HTMLElement element, Style<HTMLElement, IsElement<HTMLElement>> style) {
    DominoElement.of(element)
        .apply(
            self -> {
              if (self.isAttached()) {
                this.handlers.onBeforeHide().run();
                collapseElement(element, style, true);
                this.handlers.onHideCompleted().run();
              } else {
                self.onAttached(
                    mutationRecord -> {
                      this.handlers.onBeforeHide().run();
                      style.removeCss(transition.getStyle());
                      collapseElement(element, style, false);
                      style.addCss(transition.getStyle());
                      this.handlers.onHideCompleted().run();
                    });
              }
            });
  }

  private void collapseElement(
      HTMLElement element,
      Style<HTMLElement, IsElement<HTMLElement>> style,
      boolean useAnimationFrame) {
    DominoElement<HTMLElement> elementToCollapse = DominoElement.of(element);
    int scrollHeight = element.scrollHeight;
    style.removeCss(CollapsibleStyles.HEIGHT_COLLAPSED_OVERFLOW);

    CSSProperties.HeightUnionType originalHeight = element.style.height;
    element.style.height = CSSProperties.HeightUnionType.of(scrollHeight + "px");
    if (useAnimationFrame) {
      DomGlobal.requestAnimationFrame(
          timestamp -> {
            style.addCss(CollapsibleStyles.HEIGHT_COLLAPSED_OVERFLOW);

            style.addCss(CollapsibleStyles.HEIGHT_COLLAPSED);
            elementToCollapse
                .setAttribute("dom-ui-collapse-height", originalHeight.asString())
                .setAttribute(D_COLLAPSED, "true")
                .setAttribute(DOM_UI_SCROLL_HEIGHT, scrollHeight);
          });
    } else {
      style.addCss(CollapsibleStyles.HEIGHT_COLLAPSED_OVERFLOW);

      style.addCss(CollapsibleStyles.HEIGHT_COLLAPSED);
      elementToCollapse
          .setAttribute("dom-ui-collapse-height", originalHeight.asString())
          .setAttribute(D_COLLAPSED, "true")
          .setAttribute(DOM_UI_SCROLL_HEIGHT, scrollHeight);
    }
  }
}
