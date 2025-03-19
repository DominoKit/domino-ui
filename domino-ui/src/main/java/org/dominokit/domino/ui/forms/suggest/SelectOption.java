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
package org.dominokit.domino.ui.forms.suggest;

import static org.dominokit.domino.ui.utils.Domino.*;

import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.MenuItem;

/**
 * Represents a selectable option within a dropdown menu or suggestion list.
 *
 * <p>This class extends the {@link Option} class and is designed for use with a {@link SuggestBox}
 * and {@link Select} or similar components to represent selectable options.
 *
 * <p>Usage Example:
 *
 * <pre>{@code
 * SelectOption<String> option = SelectOption.create("1", "Option 1", "This is the first option");
 * }</pre>
 *
 * @param <V> The type of the option's value.
 */
public class SelectOption<V> extends Option<V, DivElement, SelectOption<V>> {

  /**
   * Creates a new SelectOption with the provided key, value, and text.
   *
   * @param <V> The type of the option's value.
   * @param key The unique key for the option.
   * @param value The value associated with the option.
   * @param text The text to display for the option.
   * @return A new SelectOption instance.
   */
  public static <V> SelectOption<V> create(String key, V value, String text) {
    return new SelectOption<>(key, value, text);
  }

  /**
   * Creates a new SelectOption with the provided value, using the value itself as the key and text.
   *
   * @param <V> The type of the option's value.
   * @param value The value associated with the option.
   * @return A new SelectOption instance.
   */
  public static <V> SelectOption<V> create(V value) {
    return new SelectOption<>(String.valueOf(value), value, String.valueOf(value));
  }

  /**
   * Creates a new SelectOption with the provided value, key, and text.
   *
   * @param <V> The type of the option's value.
   * @param value The value associated with the option.
   * @param text The text to display for the option.
   * @return A new SelectOption instance.
   */
  public static <V> SelectOption<V> create(V value, String text) {
    return new SelectOption<>(String.valueOf(value), value, text);
  }

  /**
   * Creates a new SelectOption with the provided key, value, text, and description.
   *
   * @param <V> The type of the option's value.
   * @param key The unique key for the option.
   * @param value The value associated with the option.
   * @param text The text to display for the option.
   * @param description The description for the option.
   * @return A new SelectOption instance.
   */
  public static <V> SelectOption<V> create(String key, V value, String text, String description) {
    return new SelectOption<>(key, value, text, description);
  }

  /**
   * Creates a new SelectOption with the provided key, value, and custom component and menu item
   * suppliers.
   *
   * @param <V> The type of the option's value.
   * @param key The unique key for the option.
   * @param value The value associated with the option.
   * @param componentSupplier A custom supplier for creating the component (DivElement) for the
   *     option.
   * @param menuItemSupplier A custom supplier for creating the menu item (AbstractMenuItem) for the
   *     option.
   * @return A new SelectOption instance with custom component and menu item.
   */
  public static <V> SelectOption<V> create(
      String key,
      V value,
      OptionSupplier<DivElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    return new SelectOption<>(key, value, componentSupplier, menuItemSupplier);
  }

  /**
   * Creates a new SelectOption with the provided key, value, text, and description.
   *
   * @param key The unique key for the option.
   * @param value The value associated with the option.
   * @param text The text to display for the option.
   * @param description The description for the option.
   */
  public SelectOption(String key, V value, String text, String description) {
    super(
        key, value, div().textContent(text).addCss(dui_m_r_1), MenuItem.create(text, description));
  }

  /**
   * Creates a new SelectOption with the provided key, value, and text.
   *
   * @param key The unique key for the option.
   * @param value The value associated with the option.
   * @param text The text to display for the option.
   */
  public SelectOption(String key, V value, String text) {
    super(key, value, div().textContent(text).addCss(dui_m_r_1), MenuItem.create(text));
  }

  /**
   * Creates a new SelectOption with the provided key, value, component supplier, and menu item
   * supplier.
   *
   * @param key The unique key for the option.
   * @param value The value associated with the option.
   * @param componentSupplier The supplier for the option's component.
   * @param menuItemSupplier The supplier for the option's menu item.
   */
  public SelectOption(
      String key,
      V value,
      OptionSupplier<DivElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    super(key, value, componentSupplier, menuItemSupplier);
  }
}
