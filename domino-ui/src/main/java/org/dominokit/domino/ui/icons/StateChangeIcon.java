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
package org.dominokit.domino.ui.icons;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.ElementHandler;

/**
 * An abstract base class for icons that can change their state, displaying different icons based on
 * the current state.
 *
 * @param <I> The concrete icon type.
 * @param <T> The concrete StateChangeIcon type.
 */
public abstract class StateChangeIcon<I extends Icon<I>, T extends StateChangeIcon<I, T>>
    extends Icon<T> {
  protected final I defaultIcon;
  protected String currentState = "default";

  protected final Map<String, I> statesMap = new HashMap<>();
  private Consumer<T> onStateChanged = icon -> {};

  /**
   * Constructs a new StateChangeIcon with the default icon.
   *
   * @param defaultIcon The default icon to be displayed initially.
   */
  public StateChangeIcon(I defaultIcon) {
    this.defaultIcon = defaultIcon;
    this.icon = elementOf(this.defaultIcon);
    init((T) this);
  }

  /**
   * Adds a state icon mapping to this StateChangeIcon.
   *
   * @param state The state identifier.
   * @param icon The icon to be displayed when the specified state is set.
   * @return The StateChangeIcon instance for method chaining.
   */
  public T withState(String state, I icon) {
    if (nonNull(state) && !state.isEmpty() && nonNull(icon)) {
      statesMap.put(state, icon);
    }
    return (T) this;
  }

  /**
   * Removes a state icon mapping from this StateChangeIcon.
   *
   * @param state The state identifier to be removed.
   * @return The StateChangeIcon instance for method chaining.
   */
  public T removeState(String state) {
    statesMap.remove(state);
    return (T) this;
  }

  /**
   * Sets a callback function to be invoked when the state is changed.
   *
   * @param stateConsumer The callback function to handle the state change event.
   * @return The StateChangeIcon instance for method chaining.
   */
  public T onStateChanged(Consumer<T> stateConsumer) {
    this.onStateChanged = stateConsumer;
    return (T) this;
  }

  /**
   * Sets the current state of the icon and updates the displayed icon accordingly.
   *
   * @param state The state identifier to be set.
   * @return The StateChangeIcon instance for method chaining.
   */
  public T setState(String state) {
    if (statesMap.containsKey(state)) {
      this.defaultIcon.addCss(
          SwapCssClass.of(CompositeCssClass.of(this.defaultIcon))
              .replaceWith(CompositeCssClass.of(this.statesMap.get(state))));
      this.currentState = state;
      this.onStateChanged.accept((T) this);
      this.setAttribute("dui-icon-state", state);
    }
    return (T) this;
  }

  /**
   * Iterates through child icons and applies the given handler.
   *
   * @param handler The handler for child icons.
   * @return The StateChangeIcon instance for method chaining.
   */
  @Override
  public T forEachChild(ElementHandler<Icon<?>> handler) {
    handler.handleElement(defaultIcon);
    statesMap.values().forEach(handler::handleElement);
    return (T) this;
  }

  /**
   * Gets the target HTMLElement for applying styles.
   *
   * @return The HTMLElement of the default icon.
   */
  @Override
  protected HTMLElement getStyleTarget() {
    return defaultIcon.element();
  }

  /**
   * Gets the clickable HTMLElement for the icon.
   *
   * @return The HTMLElement of the default icon.
   */
  @Override
  public HTMLElement getClickableElement() {
    return defaultIcon.element();
  }

  /**
   * Gets the current state of the icon.
   *
   * @return The current state identifier.
   */
  public String getState() {
    return this.currentState;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc} Gets the HTMLElement representation of the icon.
   * @return The HTMLElement of the default icon.
   */
  @Override
  public HTMLElement element() {
    return defaultIcon.element();
  }
}
