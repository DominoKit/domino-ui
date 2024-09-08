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
package org.dominokit.domino.ui.shaded.collapsible;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.shaded.style.Style;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.dominokit.domino.ui.shaded.utils.IsCollapsible;
import org.jboss.elemento.IsElement;

/**
 * A component to show and hide element
 *
 * <p>Collapsible component can wrap any element to provide functionality to show and hide the
 * wrapped element also it allows attaching callbacks when the element is shown/hidden
 *
 * <pre>
 *         Collapsible.create(DominoElement.div().setTextContent("Hello world"))
 *         .addShowHandler(() -&gt; DomGlobal.console.info("Div visible"))
 *         .addHideHandler(() -&gt; DomGlobal.console.info("Div visible"));
 *     </pre>
 */
@Deprecated
public class Collapsible implements IsElement<HTMLElement>, IsCollapsible<Collapsible> {

  public static final String DOM_UI_SCROLL_HEIGHT = "dom-ui-scroll-height";
  private final HTMLElement element;
  private final Style<HTMLElement, IsElement<HTMLElement>> style;
  private final CollapsibleHandlers handlers;

  private boolean collapsed = false;
  private boolean forceHidden = false;

  private List<HideHandler> hideHandlers = new ArrayList<>();
  private List<HideHandler> beforeHideHandlers = new ArrayList<>();
  private List<ShowHandler> showHandlers = new ArrayList<>();
  private List<ShowHandler> beforeShowHandlers = new ArrayList<>();
  private CollapseStrategy strategy = new DisplayCollapseStrategy();

  /**
   * Creates a collapsible wrapping the element
   *
   * @param element {@link HTMLElement} to be wrapped in a collapsible
   */
  public Collapsible(HTMLElement element) {
    this.element = element;
    style = Style.of(element);
    handlers =
        new CollapsibleHandlers() {
          @Override
          public Runnable onBeforeShow() {
            return Collapsible.this::onBeforeShow;
          }

          @Override
          public Runnable onShowCompleted() {
            return Collapsible.this::onShowCompleted;
          }

          @Override
          public Runnable onBeforeHide() {
            return Collapsible.this::onBeforeHide;
          }

          @Override
          public Runnable onHideCompleted() {
            return Collapsible.this::onHideCompleted;
          }
        };
    strategy.init(element, Style.of(element), handlers);
  }

  /**
   * A factory to create a collapsible wrapping the element
   *
   * @param element {@link HTMLElement} to be wrapped in a collapsible
   */
  public static Collapsible create(HTMLElement element) {
    return new Collapsible(element);
  }

  /**
   * A factory to create a collapsible wrapping the element
   *
   * @param isElement {@link IsElement} to be wrapped in a collapsible
   */
  public static Collapsible create(IsElement<?> isElement) {
    return create(isElement.element());
  }

  /**
   * @return boolean, if true the element is hidden and wont be shown even if we call {@link
   *     #show()}
   */
  public boolean isForceHidden() {
    return forceHidden;
  }

  /**
   * Disable/Enable force hidden
   *
   * @param forceHidden boolean, if true it will hide the element if it is visible and wont allow
   *     the element to be shown unless it is turned off, when turned off the element will remain
   *     hidden until we call {@link #show()}
   * @return same instance
   */
  public Collapsible setForceHidden(boolean forceHidden) {
    if (!isCollapsed()) {
      hide();
    }
    this.forceHidden = forceHidden;
    return this;
  }

  /**
   * Make the element visible and call any attached show handlers
   *
   * @return same collapsible instance
   */
  @Override
  public Collapsible show() {
    if (!forceHidden) {
      strategy.show(element, style);
      element.setAttribute("aria-expanded", "true");
      this.collapsed = false;
    }
    return this;
  }

  /**
   * Make the element hidden and call any attached hide handlers
   *
   * @return same collapsible instance
   */
  @Override
  public Collapsible hide() {
    if (!forceHidden) {
      strategy.hide(element, style);
      element.setAttribute("aria-expanded", "false");
      this.collapsed = true;
    }
    return this;
  }

  private void onHideCompleted() {
    if (nonNull(hideHandlers)) {
      hideHandlers.forEach(HideHandler::apply);
    }
  }

  private void onBeforeHide() {
    if (nonNull(beforeHideHandlers)) {
      beforeHideHandlers.forEach(HideHandler::apply);
    }
  }

  private void onShowCompleted() {
    if (nonNull(showHandlers)) {
      showHandlers.forEach(ShowHandler::apply);
    }
  }

  private void onBeforeShow() {
    if (nonNull(beforeShowHandlers)) {
      beforeShowHandlers.forEach(ShowHandler::apply);
    }
  }

  /**
   * checks if the wrapped element is hidden
   *
   * @return boolean, true if the element is hidden.
   */
  @Override
  @Deprecated
  public boolean isHidden() {
    return isCollapsed();
  }

  /**
   * checks if the wrapped element is collapsed
   *
   * @return boolean, true if the element is collapsed.
   */
  @Override
  public boolean isCollapsed() {
    return this.collapsed || DominoElement.of(element).hasAttribute("d-collapsed");
  }

  /**
   * toggle the element visibility, if its visible it hides it, otherwise it make it visible
   *
   * @return same collapsible instance
   */
  @Override
  public Collapsible toggleDisplay() {
    if (isCollapsed()) {
      show();
    } else {
      hide();
    }
    return this;
  }

  /**
   * toggle the element visibility based on the flag.
   *
   * @param state boolean, if true make the element visible otherwise make it hidden
   * @return same collapsible instance
   */
  @Override
  public Collapsible toggleDisplay(boolean state) {
    if (state) {
      show();
    } else {
      hide();
    }
    return this;
  }

  /**
   * Add handler to be called when ever the element changed state to hidden
   *
   * @param handler {@link HideHandler}
   * @return same Collapsible instance
   */
  public Collapsible addHideHandler(HideHandler handler) {
    if (isNull(hideHandlers)) {
      hideHandlers = new ArrayList<>();
    }
    hideHandlers.add(handler);
    return this;
  }

  /**
   * Add handler to be called when ever the element changed state to hidden before the hide
   * operation started
   *
   * @param handler {@link HideHandler}
   * @return same Collapsible instance
   */
  public Collapsible addBeforeHideHandler(HideHandler handler) {
    if (isNull(beforeHideHandlers)) {
      beforeHideHandlers = new ArrayList<>();
    }
    beforeHideHandlers.add(handler);
    return this;
  }

  /**
   * removes the hide handler
   *
   * @param handler {@link HideHandler}
   * @return same Collapsible instance
   */
  public void removeHideHandler(HideHandler handler) {
    if (nonNull(hideHandlers)) {
      hideHandlers.remove(handler);
    }
  }
  /**
   * removes the before hide handler
   *
   * @param handler {@link HideHandler}
   * @return same Collapsible instance
   */
  public void removeBeforeHideHandler(HideHandler handler) {
    if (nonNull(beforeHideHandlers)) {
      beforeHideHandlers.remove(handler);
    }
  }

  /**
   * Add handler to be called when ever the element changed state to visible
   *
   * @param handler {@link ShowHandler}
   * @return same Collapsible instance
   */
  public Collapsible addShowHandler(ShowHandler handler) {
    if (isNull(showHandlers)) {
      showHandlers = new ArrayList<>();
    }
    showHandlers.add(handler);
    return this;
  }

  /**
   * Add handler to be called when ever the element changed state to visible, before the show
   * operation is completed
   *
   * @param handler {@link ShowHandler}
   * @return same Collapsible instance
   */
  public Collapsible addBeforeShowHandler(ShowHandler handler) {
    if (isNull(beforeShowHandlers)) {
      beforeShowHandlers = new ArrayList<>();
    }
    beforeShowHandlers.add(handler);
    return this;
  }

  /**
   * removes the show handler
   *
   * @param handler {@link ShowHandler}
   * @return same Collapsible instance
   */
  public void removeShowHandler(ShowHandler handler) {
    if (nonNull(showHandlers)) {
      showHandlers.remove(handler);
    }
  }

  /**
   * removes the before show handler
   *
   * @param handler {@link ShowHandler}
   * @return same Collapsible instance
   */
  public void removeBeforeShowHandler(ShowHandler handler) {
    if (nonNull(beforeShowHandlers)) {
      beforeShowHandlers.remove(handler);
    }
  }

  /** @return the current {@link CollapseStrategy} used by this Collapsible */
  public CollapseStrategy getStrategy() {
    return strategy;
  }

  /**
   * @param strategy {@link CollapseStrategy} to be used with this collapsible
   * @return same Collapsible instance
   */
  public Collapsible setStrategy(CollapseStrategy strategy) {
    if (nonNull(this.strategy)) {
      this.strategy.cleanup(element, style);
    }
    this.strategy = strategy;

    this.strategy.init(element, style, handlers);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element;
  }

  /** A callback interface to attach some listener when finish hiding the element */
  @FunctionalInterface
  @Deprecated
  public interface HideHandler {
    void apply();
  }

  /** A callback interface to attach some listener when showing an element. */
  @FunctionalInterface
  @Deprecated
  public interface ShowHandler {
    void apply();
  }
}
