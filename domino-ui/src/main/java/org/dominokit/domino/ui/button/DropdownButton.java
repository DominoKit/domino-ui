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
package org.dominokit.domino.ui.button;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * A Button with dropdown menu component
 *
 * <p>By default this Button component will open a dropdown menu when clicked
 *
 * @see BaseDominoElement
 */
public class DropdownButton<T extends BaseButton<?, T>, V>
    extends BaseDominoElement<HTMLElement, DropdownButton<T, V>> implements IsButton<T> {

  private T button;
  private Menu<V> menu;

  /**
   * Factory method to create a DropdownButton button from the provided button and menu
   *
   * @param button The button to be used as dropdown menu target
   * @param menu The {@link org.dominokit.domino.ui.menu.Menu} to be used as a dropdown menu
   * @param <T> a T class
   * @param <V> a V class
   * @return new {@link org.dominokit.domino.ui.button.DropdownButton} instance
   */
  public static <T extends BaseButton<?, T>, V> DropdownButton<T, V> create(
      T button, Menu<V> menu) {
    return new DropdownButton<>(button, menu);
  }

  /**
   * Creates a DropdownButton from a button and a menu
   *
   * @param button The button to be used as dropdown menu target
   * @param menu The {@link org.dominokit.domino.ui.menu.Menu} to be used as a dropdown menu
   */
  public DropdownButton(T button, Menu<V> menu) {
    this.button = button;
    this.menu = menu;
    this.button
        .setAttribute("data-toggle", "dropdown")
        .setAttribute("aria-haspopup", true)
        .setAttribute("aria-expanded", true)
        .setAttribute("type", "button");
    this.button.setDropMenu(this.menu);
    init(this);
  }

  /** @return The button component of this DropdownButton instance. */
  public T getButton() {
    return button;
  }

  /** @return The menu component of this DropdownButton instance */
  public Menu<V> getMenu() {
    return menu;
  }

  /**
   * Use to apply customization to the button component of this DropdownButton instance without
   * breaking the fluent API chain. {@link ChildHandler}
   *
   * @param handler a {@link ChildHandler} that applies the customization.
   * @return same DropdownButton instance
   */
  public DropdownButton<T, V> withButton(ChildHandler<DropdownButton<T, V>, T> handler) {
    handler.apply(this, button);
    return this;
  }

  /**
   * Use to apply customization to the menu component of this DropdownButton instance without
   * breaking the fluent API chain. {@link ChildHandler}
   *
   * @param handler a {@link ChildHandler} that applies the customization.
   * @return same DropdownButton instance
   */
  public DropdownButton<T, V> withMenu(ChildHandler<DropdownButton<T, V>, Menu<V>> handler) {
    handler.apply(this, menu);
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public T asButton() {
    return button;
  }
}
