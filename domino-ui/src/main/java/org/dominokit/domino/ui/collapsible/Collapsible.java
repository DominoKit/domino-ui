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
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.IsCollapsible;

/**
 * A component to show and hide element
 *
 * <p>Collapsible component can wrap any element to provide functionality to show and hide the
 * wrapped element also it allows attaching callbacks when the element is shown/hidden
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Collapsible implements IsElement<Element>, IsCollapsible<Collapsible> {

  /** Constant <code>DUI_SCROLL_HEIGHT="dui-scroll-height"</code> */
  public static final String DUI_SCROLL_HEIGHT = "dui-scroll-height";
  /** Constant <code>DUI_COLLAPSE_HEIGHT="dom-ui-collapse-height"</code> */
  public static final String DUI_COLLAPSE_HEIGHT = "dom-ui-collapse-height";
  /** Constant <code>DUI_COLLAPSED="dui-collapsed"</code> */
  public static final String DUI_COLLAPSED = "dui-collapsed";

  private final Element element;
  private final CollapsibleHandlers handlers;

  private boolean collapsed = false;
  private boolean forceHidden = false;

  private List<CollapseHandler> collapseHandlers = new ArrayList<>();
  private List<CollapseHandler> beforeCollapseHandlers = new ArrayList<>();
  private List<ExpandHandler> expandHandlers = new ArrayList<>();
  private List<ExpandHandler> beforeExpandHandlers = new ArrayList<>();
  private CollapseStrategy strategy = new DisplayCollapseStrategy();

  /**
   * Creates a collapsible wrapping the element
   *
   * @param element {@link elemental2.dom.HTMLElement} to be wrapped in a collapsible
   */
  public Collapsible(Element element) {
    this.element = element;
    handlers =
        new CollapsibleHandlers() {
          @Override
          public Runnable onBeforeExpand() {
            return Collapsible.this::onBeforeExpand;
          }

          @Override
          public Runnable onExpandCompleted() {
            return Collapsible.this::onExpandCompleted;
          }

          @Override
          public Runnable onBeforeCollapse() {
            return Collapsible.this::onBeforeCollapse;
          }

          @Override
          public Runnable onCollapseCompleted() {
            return Collapsible.this::onCollapseCompleted;
          }
        };
    strategy.init(element, handlers);
  }

  /**
   * A factory to create a collapsible wrapping the element
   *
   * @param element {@link elemental2.dom.HTMLElement} to be wrapped in a collapsible
   * @return a {@link org.dominokit.domino.ui.collapsible.Collapsible} object
   */
  public static Collapsible create(Element element) {
    return new Collapsible(element);
  }

  /**
   * A factory to create a collapsible wrapping the element
   *
   * @param isElement {@link org.dominokit.domino.ui.IsElement} to be wrapped in a collapsible
   * @return a {@link org.dominokit.domino.ui.collapsible.Collapsible} object
   */
  public static Collapsible create(IsElement<?> isElement) {
    return create(isElement.element());
  }

  /**
   * isForceCollapsed.
   *
   * @return boolean, if true the element is hidden and will not be shown even if we call {@link
   *     #expand()}
   */
  public boolean isForceCollapsed() {
    return forceHidden;
  }

  /**
   * Disable/Enable force hidden
   *
   * @param forceHidden boolean, if true it will hide the element if it is visible and will not
   *     allow the element to be shown unless it is turned off, when turned off the element will
   *     remain hidden until we call {@link #expand()}
   * @return same instance
   */
  public Collapsible setForceCollapsed(boolean forceHidden) {
    if (!isCollapsed()) {
      collapse();
    }
    this.forceHidden = forceHidden;
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Make the element visible and call any attached show handlers
   */
  @Override
  public Collapsible expand() {
    if (!forceHidden && isCollapsed()) {
      strategy.expand(element);
      element.setAttribute("aria-expanded", "true");
      this.collapsed = false;
    }
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Make the element hidden and call any attached hide handlers
   */
  @Override
  public Collapsible collapse() {
    if (!forceHidden && !isCollapsed()) {
      strategy.collapse(element);
      element.setAttribute("aria-expanded", "false");
      this.collapsed = true;
    }
    return this;
  }

  private void onCollapseCompleted() {
    if (nonNull(collapseHandlers)) {
      collapseHandlers.forEach(CollapseHandler::apply);
    }
  }

  private void onBeforeCollapse() {
    if (nonNull(beforeCollapseHandlers)) {
      beforeCollapseHandlers.forEach(CollapseHandler::apply);
    }
  }

  private void onExpandCompleted() {
    if (nonNull(expandHandlers)) {
      expandHandlers.forEach(ExpandHandler::apply);
    }
  }

  private void onBeforeExpand() {
    if (nonNull(beforeExpandHandlers)) {
      beforeExpandHandlers.forEach(ExpandHandler::apply);
    }
  }

  /**
   * {@inheritDoc}
   *
   * <p>checks if the wrapped element is collapsed
   */
  @Override
  public boolean isCollapsed() {
    return this.collapsed || elements.elementOf(element).hasAttribute(DUI_COLLAPSED);
  }

  /**
   * {@inheritDoc}
   *
   * <p>toggle the element visibility, if its visible it hides it, otherwise it make it visible
   */
  @Override
  public Collapsible toggleCollapse() {
    if (isCollapsed()) {
      expand();
    } else {
      collapse();
    }
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>toggle the element visibility based on the flag.
   */
  @Override
  public Collapsible toggleCollapse(boolean state) {
    if (state) {
      expand();
    } else {
      collapse();
    }
    return this;
  }

  /**
   * Add handler to be called when ever the element changed state to hidden
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   * @return same Collapsible instance
   */
  public Collapsible addCollapseHandler(CollapseHandler handler) {
    if (isNull(collapseHandlers)) {
      collapseHandlers = new ArrayList<>();
    }
    collapseHandlers.add(handler);
    return this;
  }

  /**
   * Add handler to be called when ever the element changed state to hidden before the hide
   * operation started
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   * @return same Collapsible instance
   */
  public Collapsible addBeforeCollapseHandler(CollapseHandler handler) {
    if (isNull(beforeCollapseHandlers)) {
      beforeCollapseHandlers = new ArrayList<>();
    }
    beforeCollapseHandlers.add(handler);
    return this;
  }

  /**
   * removes the hide handler
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   */
  public void removeCollapseHandler(CollapseHandler handler) {
    if (nonNull(collapseHandlers)) {
      collapseHandlers.remove(handler);
    }
  }
  /**
   * removes the before hide handler
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.CollapseHandler}
   */
  public void removeBeforeCollapseHandler(CollapseHandler handler) {
    if (nonNull(beforeCollapseHandlers)) {
      beforeCollapseHandlers.remove(handler);
    }
  }

  /**
   * Add handler to be called when ever the element changed state to visible
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   * @return same Collapsible instance
   */
  public Collapsible addExpandHandler(ExpandHandler handler) {
    if (isNull(expandHandlers)) {
      expandHandlers = new ArrayList<>();
    }
    expandHandlers.add(handler);
    return this;
  }

  /**
   * Add handler to be called when ever the element changed state to visible, before the show
   * operation is completed
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   * @return same Collapsible instance
   */
  public Collapsible addBeforeExpandHandler(ExpandHandler handler) {
    if (isNull(beforeExpandHandlers)) {
      beforeExpandHandlers = new ArrayList<>();
    }
    beforeExpandHandlers.add(handler);
    return this;
  }

  /**
   * removes the show handler
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   */
  public void removeExpandHandler(ExpandHandler handler) {
    if (nonNull(expandHandlers)) {
      expandHandlers.remove(handler);
    }
  }

  /**
   * removes the before show handler
   *
   * @param handler {@link org.dominokit.domino.ui.collapsible.Collapsible.ExpandHandler}
   */
  public void removeBeforeExpandHandler(ExpandHandler handler) {
    if (nonNull(beforeExpandHandlers)) {
      beforeExpandHandlers.remove(handler);
    }
  }

  /** @return the current {@link CollapseStrategy} used by this Collapsible */
  /**
   * Getter for the field <code>strategy</code>.
   *
   * @return a {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} object
   */
  public CollapseStrategy getStrategy() {
    return strategy;
  }

  /**
   * Setter for the field <code>strategy</code>.
   *
   * @param strategy {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} to be used with
   *     this collapsible
   * @return same Collapsible instance
   */
  public Collapsible setStrategy(CollapseStrategy strategy) {
    if (nonNull(this.strategy)) {
      this.strategy.cleanup(element);
    }
    this.strategy = strategy;
    this.strategy.init(element, handlers);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Element element() {
    return element;
  }

  /** A callback interface to attach some listener when finish hiding the element */
  @FunctionalInterface
  public interface CollapseHandler {
    void apply();
  }

  /** A callback interface to attach some listener when showing an element. */
  @FunctionalInterface
  public interface ExpandHandler {
    void apply();
  }
}
