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

import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.elemento.IsElement;

/**
 * A component to show and hide element
 *
 * <p>Collapsible component can wrap any element to provide functionality to show and hide the
 * wrapped element also it allows attaching callbacks when the element is shown/hidden
 *
 * <pre>
 *         Collapsible.create(DominoElement.div().setTextContent("Hello world"))
 *         .addShowHandler(() -> DomGlobal.console.info("Div visible"))
 *         .addHideHandler(() -> DomGlobal.console.info("Div visible"));
 *     </pre>
 */
public class Collapsible implements IsElement<HTMLElement>, IsCollapsible<Collapsible> {

  private final HTMLElement element;
  private final Style<HTMLElement, IsElement<HTMLElement>> style;

  private boolean collapsed = false;
  private boolean forceHidden = false;

  private List<HideCompletedHandler> hideHandlers;
  private List<ShowCompletedHandler> showHandlers = new ArrayList<>();

  /**
   * Creates a collapsible wrapping the element
   *
   * @param element {@link HTMLElement} to be wrapped in a collapsible
   */
  public Collapsible(HTMLElement element) {
    this.element = element;
    style = Style.of(element);
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
    if (!isHidden()) {
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
      onShowCompleted();
      style.removeProperty("display");
      DominoElement.of(element).removeAttribute("d-collapsed");
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
      style.setDisplay("none");
      DominoElement.of(element).setAttribute("d-collapsed", "true");
      onHideCompleted();
      this.collapsed = true;
    }
    return this;
  }

  private void onHideCompleted() {
    if (nonNull(hideHandlers)) {
      hideHandlers.forEach(HideCompletedHandler::onHidden);
    }
  }

  private void onShowCompleted() {
    if (nonNull(showHandlers)) {
      showHandlers.forEach(ShowCompletedHandler::onShown);
    }
  }

  /**
   * checks if the wrapped element is hidden
   *
   * @return boolean, true if the element is hidden.
   */
  @Override
  public boolean isHidden() {
    return this.collapsed || DominoElement.of(element).hasAttribute("d-collapsed");
  }

  /**
   * toggle the element visibility, if its visible it hides it, otherwise it make it visible
   *
   * @return same collapsible instance
   */
  @Override
  public Collapsible toggleDisplay() {
    if (isHidden()) show();
    else hide();
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
   * @param handler {@link HideCompletedHandler}
   * @return same Collapsible instance
   */
  public Collapsible addHideHandler(HideCompletedHandler handler) {
    if (isNull(hideHandlers)) {
      hideHandlers = new ArrayList<>();
    }
    hideHandlers.add(handler);
    return this;
  }

  /**
   * removes the hide handler
   *
   * @param handler {@link HideCompletedHandler}
   * @return same Collapsible instance
   */
  public void removeHideHandler(HideCompletedHandler handler) {
    if (nonNull(hideHandlers)) {
      hideHandlers.remove(handler);
    }
  }

  /**
   * Add handler to be called when ever the element changed state to visible
   *
   * @param handler {@link ShowCompletedHandler}
   * @return same Collapsible instance
   */
  public Collapsible addShowHandler(ShowCompletedHandler handler) {
    if (isNull(showHandlers)) {
      showHandlers = new ArrayList<>();
    }
    showHandlers.add(handler);
    return this;
  }

  /**
   * removes the show handler
   *
   * @param handler {@link ShowCompletedHandler}
   * @return same Collapsible instance
   */
  public void removeShowHandler(ShowCompletedHandler handler) {
    if (nonNull(showHandlers)) {
      showHandlers.remove(handler);
    }
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element;
  }

  /** A callback interface to attach some listener when finish hiding the element */
  @FunctionalInterface
  public interface HideCompletedHandler {
    void onHidden();
  }

  /** A callback interface to attach some listener when showing an element. */
  @FunctionalInterface
  public interface ShowCompletedHandler {
    void onShown();
  }
}
