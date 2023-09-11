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

/** Abstract StateChangeIcon class. */
public abstract class StateChangeIcon<I extends Icon<I>, T extends StateChangeIcon<I, T>>
    extends Icon<T> {
  protected final I defaultIcon;
  protected String currentState = "default";

  protected final Map<String, I> statesMap = new HashMap<>();
  private Consumer<T> onStateChanged = icon -> {};

  /**
   * Constructor for StateChangeIcon.
   *
   * @param defaultIcon a I object
   */
  public StateChangeIcon(I defaultIcon) {
    this.defaultIcon = defaultIcon;
    this.icon = elementOf(this.defaultIcon);
    init((T) this);
  }

  /**
   * withState.
   *
   * @param state a {@link java.lang.String} object
   * @param icon a I object
   * @return a T object
   */
  public T withState(String state, I icon) {
    if (nonNull(state) && !state.isEmpty() && nonNull(icon)) {
      statesMap.put(state, icon);
    }
    return (T) this;
  }

  /**
   * removeState.
   *
   * @param state a {@link java.lang.String} object
   * @return a T object
   */
  public T removeState(String state) {
    statesMap.remove(state);
    return (T) this;
  }

  /**
   * Sets a handler to be called when the icon state is changed
   *
   * @param stateConsumer the {@link java.util.function.Consumer} handler
   * @return same instance
   */
  public T onStateChanged(Consumer<T> stateConsumer) {
    this.onStateChanged = stateConsumer;
    return (T) this;
  }

  /**
   * setState.
   *
   * @param state a {@link java.lang.String} object
   * @return a T object
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

  /** {@inheritDoc} */
  @Override
  public T forEachChild(ElementHandler<Icon<?>> handler) {
    handler.handleElement(defaultIcon);
    statesMap.values().forEach(handler::handleElement);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLElement getStyleTarget() {
    return defaultIcon.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getClickableElement() {
    return defaultIcon.element();
  }

  /**
   * getState.
   *
   * @return a {@link java.lang.String} object
   */
  public String getState() {
    return this.currentState;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return defaultIcon.element();
  }
}
