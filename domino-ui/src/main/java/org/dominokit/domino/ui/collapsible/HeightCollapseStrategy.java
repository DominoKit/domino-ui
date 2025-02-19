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

/**
 * An implementation of {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} that uses the
 * height to hide/show the collapsible element
 */
public class HeightCollapseStrategy implements CollapseStrategy, CollapsibleStyles {

  private static final String EXPAND_COLLAPSE_HEIGHT_VAR = "--dui-element-expand-collapse-height-";

  private final CollapsibleDuration transition;
  private final String heightVar;
  private final String initialHeight;
  private CollapsibleHandlers handlers;
  private DominoElement<Element> target;

  /** Create a HeightCollapseStrategy with a default duration of 300ms */
  public HeightCollapseStrategy() {
    this(CollapsibleDuration._300ms);
  }

  /** Create a HeightCollapseStrategy with a default duration of 300ms */
  public HeightCollapseStrategy(String initialHeight) {
    this(initialHeight, CollapsibleDuration._300ms);
  }

  /**
   * Create a HeightCollapseStrategy with the provided duration
   *
   * @param transition The height animation {@link CollapsibleDuration}
   */
  public HeightCollapseStrategy(CollapsibleDuration transition) {
    this("auto", transition);
  }

  /**
   * Create a HeightCollapseStrategy with the provided duration
   *
   * @param transition The height animation {@link CollapsibleDuration}
   */
  public HeightCollapseStrategy(String initialHeight, CollapsibleDuration transition) {
    this.transition = transition;
    this.heightVar = DominoId.unique(EXPAND_COLLAPSE_HEIGHT_VAR);
    this.initialHeight = initialHeight;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void init(Element element, CollapsibleHandlers handlers) {
    this.target = elements.elementOf(element);
    this.target.setCssProperty("height", "var(" + this.heightVar + "," + this.initialHeight + ")");
    this.handlers = handlers;
    this.target
        .addCss(dui_height_collapsed_overflow, dui_height_collapsed)
        .addCss(transition.getStyle());
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void cleanup(Element element) {
    elements
        .elementOf(element)
        .removeCss(dui_height_collapsed_overflow)
        .removeCss(dui_height_collapsed)
        .removeCss(transition.getStyle());
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void expand(Element element) {
    this.target.nowOrWhenAttached(
        () -> {
          boolean noTransition = dui_transition_none.isAppliedTo(this.target);
          this.target.addCss(dui_transition_none);
          this.target.setCssProperty(this.heightVar, "auto");
          this.target.setAttribute("dui-default-height", this.target.element().scrollHeight);
          this.target.setCssProperty(this.heightVar, "0px");
          if (!noTransition) {
            this.target.removeCss(dui_transition_none);
          }
          this.handlers.onBeforeExpand().run();
          expandElement(element);
        });
  }

  private void expandElement(Element element) {
    if (dui_transition_none.isAppliedTo(this.target)) {
      this.target.removeAttribute(DUI_COLLAPSED);
      handlers.onExpandCompleted().run();
    } else {
      EventListener stopListener =
          evt -> {
            this.target.setCssProperty(this.heightVar, "auto");
            handlers.onExpandCompleted().run();
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
    }

    this.target.removeAttribute(DUI_COLLAPSED);
    this.target.setCssProperty(this.heightVar, getActualHeight() + "px");
  }

  private double getActualHeight() {
    if (this.target.hasAttribute("dui-default-height")) {
      return Math.max(
          Double.parseDouble(this.target.getAttribute("dui-default-height")),
          this.target.element().scrollHeight);
    }
    return this.target.element().scrollHeight;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public void collapse(Element element) {
    boolean disableAnimation = dui_transition_none.isAppliedTo(this.target);
    this.target.apply(
        self -> {
          if (self.isAttached()) {
            this.target.setCssProperty(this.heightVar, getActualHeight() + "px");

            this.handlers.onBeforeCollapse().run();
            collapseElement(element);
            handlers.onCollapseCompleted().run();
          } else {
            self.onAttached(
                (e, mutationRecord) -> {

                  //                  this.target.setAttribute(DUI_EXPANDED_HEIGHT, "auto");
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
    } else {
      DomGlobal.requestAnimationFrame(
          timestamp -> {
            this.target.setAttribute(DUI_COLLAPSED, "true");
            this.target.setCssProperty(this.heightVar, "0px");
          });
    }
  }
}
