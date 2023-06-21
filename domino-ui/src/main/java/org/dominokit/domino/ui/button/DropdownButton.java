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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * A Button with dropdown menu component
 *
 * <p>This Button component will open a dropdown menu when clicked by default
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class DropdownButton<T extends BaseButton<?, T>, V>
    extends BaseDominoElement<HTMLElement, DropdownButton<T, V>> implements IsButton<T> {

  private T button;
  private Menu<V> menu;

  /**
   * create.
   *
   * @param button a T object
   * @param menu a {@link org.dominokit.domino.ui.menu.Menu} object
   * @param <T> a T class
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.button.DropdownButton} object
   */
  public static <T extends BaseButton<?, T>, V> DropdownButton<T, V> create(
      T button, Menu<V> menu) {
    return new DropdownButton<>(button, menu);
  }

  /**
   * Creates a Dropdown button from a button and a menu
   *
   * @param button a T object
   * @param menu a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public DropdownButton(T button, Menu<V> menu) {
    this.button = button;
    this.menu = menu;
    this.button
        .setAttribute("data-toggle", "dropdown")
        .setAttribute("aria-haspopup", true)
        .setAttribute("aria-expanded", true)
        .setAttribute("type", "button");
    //    this.menu.setTargetElement(button).setMenuAppendTarget(body().element());
    this.button.addClickListener(evt -> this.menu.open());
    this.button.setDropMenu(this.menu);
    init(this);
  }

  /**
   * Getter for the field <code>button</code>.
   *
   * @return a T object
   */
  public T getButton() {
    return button;
  }

  /**
   * Getter for the field <code>menu</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> getMenu() {
    return menu;
  }

  /**
   * withButton.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.button.DropdownButton} object
   */
  public DropdownButton<T, V> withButton(ChildHandler<DropdownButton<T, V>, T> handler) {
    handler.apply(this, button);
    return this;
  }

  /**
   * withMenu.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.button.DropdownButton} object
   */
  public DropdownButton<T, V> withMenu(ChildHandler<DropdownButton<T, V>, Menu<V>> handler) {
    handler.apply(this, menu);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return button.element();
  }

  /** {@inheritDoc} */
  @Override
  public T asButton() {
    return button;
  }
}
