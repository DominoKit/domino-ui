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

import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_COLLAPSED;
import static org.dominokit.domino.ui.style.GenericCss.dui_transition_none;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.AddEventListenerOptions;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.EventListener;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.DominoId;
import org.dominokit.domino.ui.utils.IsCollapsible;

/**
 * An implementation of {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} that uses the
 * height to hide/show the collapsible element
 */
public class HeightCollapseStrategy implements CollapseStrategy, CollapsibleStyles {

  private static final String EXPAND_COLLAPSE_HEIGHT_VAR = "--dui-element-expand-collapse-height-";
  private static final String DUI_EXPANDED_HEIGHT = "dui-expanded-height";
  private static final String DUI_EXPAND_COLLAPSE_VAR = "dui-expand-collapse-var";

  private final CollapsibleDuration transition;
  private final String heightVar;
  private CollapsibleHandlers handlers;
  private DominoElement<Element> target;

  /** Create a HeightCollapseStrategy with a default duration of 300ms */
  public HeightCollapseStrategy() {
    this(CollapsibleDuration._300ms);
  }

  /**
   * Create a HeightCollapseStrategy with the provided duration
   *
   * @param transition The height animation {@link CollapsibleDuration}
   */
  public HeightCollapseStrategy(CollapsibleDuration transition) {
    this.transition = transition;
    this.heightVar = DominoId.unique(EXPAND_COLLAPSE_HEIGHT_VAR);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void init(Element element, CollapsibleHandlers handlers) {
    this.target = elements.elementOf(element);
    this.target.setAttribute(DUI_EXPAND_COLLAPSE_VAR, this.heightVar);
    this.target.setCssProperty("height", "var(" + this.heightVar + ", auto)");
    this.handlers = handlers;
    this.target.addCss(dui_height_collapsed_overflow).addCss(transition.getStyle());
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void cleanup(Element element) {
    elements.elementOf(element).addCss(dui_height_collapsed_overflow).addCss(transition.getStyle());
    element.removeAttribute("dom-ui-collapse-height");
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void expand(Element element) {
    this.target.nowOrWhenAttached(
        () -> {
          this.handlers.onBeforeExpand().run();
          expandElement(element);
        });
  }

  private double getActualHeight() {
    double contentHeight =
        this.target.childElements().stream()
            .filter(IsCollapsible::isExpanded)
            .mapToDouble(e -> e.getBoundingClientRect().height)
            .sum();

    double elementHeight = this.target.getBoundingClientRect().height;
    return Math.max(elementHeight, contentHeight);
  }

  private void expandElement(Element element) {
    if (dui_transition_none.isAppliedTo(this.target)) {
      this.target.setCssProperty(this.heightVar, "auto");
      this.target.removeAttribute(DUI_COLLAPSED);
      handlers.onExpandCompleted().run();
    } else {
      EventListener stopListener =
          evt -> {
            handlers.onExpandCompleted().run();
            double actualHeight = getActualHeight();
            this.target.setCssProperty(this.heightVar, "auto");
            this.target.setAttribute(DUI_EXPANDED_HEIGHT, actualHeight);
          };

      AddEventListenerOptions addEventListenerOptions = AddEventListenerOptions.create();
      addEventListenerOptions.setOnce(true);
      this.target
          .element()
          .addEventListener("webkitTransitionEnd", stopListener, addEventListenerOptions);
      this.target
          .element()
          .addEventListener("MSTransitionEnd", stopListener, addEventListenerOptions);
      this.target
          .element()
          .addEventListener("mozTransitionEnd", stopListener, addEventListenerOptions);
      this.target
          .element()
          .addEventListener("oanimationend", stopListener, addEventListenerOptions);
      this.target.element().addEventListener("animationend", stopListener, addEventListenerOptions);

      this.target.removeCss(dui_height_collapsed);
      String expandedHeight = this.target.getAttribute(DUI_EXPANDED_HEIGHT);

      if ("auto".equals(expandedHeight)) {
        double actualHeight = getActualHeight();
        this.target.setCssProperty(this.heightVar, actualHeight + "px");
        this.target.removeAttribute(DUI_COLLAPSED);
      } else {
        this.target.setCssProperty(this.heightVar, expandedHeight + "px");
        this.target.removeAttribute(DUI_COLLAPSED);
      }
    }
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void collapse(Element element) {
    boolean disableAnimation = dui_transition_none.isAppliedTo(this.target);
    this.target.apply(
        self -> {
          if (self.isAttached()) {
            double actualHeight = getActualHeight();
            this.target.setAttribute(DUI_EXPANDED_HEIGHT, actualHeight);
            this.target.setCssProperty(this.heightVar, actualHeight + "px");

            this.handlers.onBeforeCollapse().run();
            collapseElement(element);
            handlers.onCollapseCompleted().run();
          } else {
            self.onAttached(
                mutationRecord -> {
                  this.target.setAttribute(DUI_EXPANDED_HEIGHT, "auto");
                  this.target.setCssProperty(this.heightVar, "auto");
                  this.handlers.onBeforeCollapse().run();
                  this.target.addCss(dui_transition_none);
                  collapseElement(element);
                  if (!disableAnimation) {
                    dui_transition_none.remove(this.target);
                  }
                  handlers.onCollapseCompleted().run();
                });
          }
        });
  }

  private void collapseElement(Element element) {
    if (dui_transition_none.isAppliedTo(this.target)) {
      this.target.setAttribute(DUI_COLLAPSED, "true");
      this.target.setCssProperty(this.heightVar, "0px");
      this.target.addCss(dui_height_collapsed);
    } else {
      DomGlobal.requestAnimationFrame(
          timestamp -> {
            this.target.setAttribute(DUI_COLLAPSED, "true");
            this.target.setCssProperty(this.heightVar, "0px");
            this.target.addCss(dui_height_collapsed);
          });
    }
  }
}
