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
import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_COLLAPSE_HEIGHT;
import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_SCROLL_HEIGHT;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementsFactory;

/**
 * An implementation of {@link CollapseStrategy} that uses the css display property to hide/show the
 * collapsible element
 */
public class HeightCollapseStrategy implements CollapseStrategy, CollapsibleStyles {

  private final CollapseDuration transition;
  private CollapsibleHandlers handlers;

  public HeightCollapseStrategy() {
    this.transition = CollapseDuration._200ms;
  }

  public HeightCollapseStrategy(CollapseDuration transition) {
    this.transition = transition;
  }

  @Override
  public void init(HTMLElement element, CollapsibleHandlers handlers) {
      this.handlers = handlers;
    elements.elementOf(element)
        .addCss(dui_height_collapsed_overflow)
        .addCss(transition.getStyle())
        .removeAttribute(DUI_COLLAPSE_HEIGHT);
  }

  @Override
  public void cleanup(HTMLElement element) {
      elements.elementOf(element)
        .removeCss(dui_height_collapsed_overflow)
        .removeCss(transition.getStyle());
  }

  /** {@inheritDoc} */
  @Override
  public void show(HTMLElement element) {
      elements.elementOf(element)
        .apply(
            self -> {
                self.nowOrWhenAttached(
                        () -> {
                            this.handlers.onBeforeShow().run();
                            expandElement(element);
                        });
            });
  }

  private void expandElement(HTMLElement element) {

    DominoElement<HTMLElement> theElement = elements.elementOf(element);
    if (!dui_height_collapsed.isAppliedTo(element)) {
      theElement.addCss(dui_height_collapsed);
    }

    EventListener stopListener =
        evt -> {
          String collapseHeight = element.getAttribute(DUI_COLLAPSE_HEIGHT);
          theElement.removeAttribute(DUI_COLLAPSE_HEIGHT);
          element.style.height = CSSProperties.HeightUnionType.of(collapseHeight);
            this.handlers.onShowCompleted().run();
        };
    String scrollHeight = element.getAttribute(DUI_SCROLL_HEIGHT);
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
    dui_height_collapsed.remove(element);
    theElement.removeAttribute(Collapsible.DUI_COLLAPSED).removeAttribute(DUI_SCROLL_HEIGHT);
  }

  /** {@inheritDoc} */
  @Override
  public void hide(HTMLElement element) {
      elements.elementOf(element)
        .apply(
            self -> {
                if (self.isAttached()) {
                    this.handlers.onBeforeHide().run();
                    collapseElement(element, true);
                    this.handlers.onHideCompleted().run();
                } else {
                    self.onAttached(
                            mutationRecord -> {
                                this.handlers.onBeforeHide().run();
                                transition.getStyle().remove(element);
                                collapseElement(element, false);
                                transition.getStyle().apply(element);
                                this.handlers.onHideCompleted().run();
                            });
                }
            });
  }

  private void collapseElement(HTMLElement element, boolean useAnimationFrame) {
    DominoElement<HTMLElement> elementToCollapse = elements.elementOf(element);
    int scrollHeight = element.scrollHeight;
    dui_height_collapsed_overflow.remove(element);

    CSSProperties.HeightUnionType originalHeight = element.style.height;
    element.style.height = CSSProperties.HeightUnionType.of(scrollHeight + "px");
    if (useAnimationFrame) {
      DomGlobal.requestAnimationFrame(
          timestamp -> {
            elementToCollapse
                .addCss(dui_height_collapsed_overflow)
                .addCss(dui_height_collapsed)
                .setAttribute(DUI_COLLAPSE_HEIGHT, originalHeight.asString())
                .setAttribute(Collapsible.DUI_COLLAPSED, "true")
                .setAttribute(DUI_SCROLL_HEIGHT, scrollHeight);
          });
    } else {
      elementToCollapse
          .addCss(dui_height_collapsed_overflow)
          .addCss(CollapsibleStyles.dui_height_collapsed)
          .setAttribute(DUI_COLLAPSE_HEIGHT, originalHeight.asString())
          .setAttribute(Collapsible.DUI_COLLAPSED, "true")
          .setAttribute(DUI_SCROLL_HEIGHT, scrollHeight);
    }
  }
}
