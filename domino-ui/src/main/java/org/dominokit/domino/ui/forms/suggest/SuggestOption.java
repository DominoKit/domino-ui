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

import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.meta.AttributeMeta;
import org.dominokit.domino.ui.utils.meta.ValueMeta;

/**
 * Represents an option for suggestions in a suggest box or similar component.
 *
 * @param <V> The type of the suggestion value.
 */
public class SuggestOption<V> extends Option<V, SpanElement, SuggestOption<V>> {

  /** The attribute key used to store the option key in the DOM element. */
  public static final String DUI_OPTION_KEY = "dui_option_key";

  /**
   * Creates a new {@code SuggestOption} with the provided key, value, and text.
   *
   * @param key The unique key for the suggestion.
   * @param value The value associated with the suggestion.
   * @param text The text to display for the suggestion.
   * @return A new {@code SuggestOption} instance.
   */
  public static <V> SuggestOption<V> create(String key, V value, String text) {
    return new SuggestOption<>(key, value, text);
  }

  /**
   * Creates a new {@code SuggestOption} with the provided value, using its string representation as
   * the key and text.
   *
   * @param value The value associated with the suggestion.
   * @return A new {@code SuggestOption} instance.
   */
  public static <V> SuggestOption<V> create(V value) {
    return new SuggestOption<>(String.valueOf(value), value, String.valueOf(value));
  }

  /**
   * Creates a new {@code SuggestOption} with the provided key, value, text, and description.
   *
   * @param key The unique key for the suggestion.
   * @param value The value associated with the suggestion.
   * @param text The text to display for the suggestion.
   * @param description The description of the suggestion.
   * @return A new {@code SuggestOption} instance.
   */
  public static <V> SuggestOption<V> create(String key, V value, String text, String description) {
    return new SuggestOption<>(key, value, text, description);
  }

  /**
   * Creates a new {@code SuggestOption} with the provided key, value, component supplier, and menu
   * item supplier.
   *
   * @param value The value associated with the suggestion.
   * @param key The unique key for the suggestion.
   * @param componentSupplier A supplier for the suggestion's component element.
   * @param menuItemSupplier A supplier for the suggestion's menu item.
   * @return A new {@code SuggestOption} instance.
   */
  public static <V> SuggestOption<V> create(
      V value,
      String key,
      OptionSupplier<SpanElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    return new SuggestOption<>(key, value, componentSupplier, menuItemSupplier);
  }

  /**
   * Constructs a {@code SuggestOption} with the provided key, value, text, and description.
   *
   * @param key The unique key for the suggestion.
   * @param value The value associated with the suggestion.
   * @param text The text to display for the suggestion.
   * @param description The description of the suggestion.
   */
  public SuggestOption(String key, V value, String text, String description) {
    this(
        key,
        value,
        (k, v) -> span().textContent(text),
        (k, v) -> MenuItem.create(text, description));
  }

  /**
   * Constructs a {@code SuggestOption} with the provided key, value, and text.
   *
   * @param key The unique key for the suggestion.
   * @param value The value associated with the suggestion.
   * @param text The text to display for the suggestion.
   */
  public SuggestOption(String key, V value, String text) {
    super(key, value, span().textContent(text), MenuItem.create(text));
    withComponent(
        (parent, span) ->
            span.applyMeta(ValueMeta.of(value), AttributeMeta.of(DUI_OPTION_KEY, key)));
  }

  /**
   * Constructs a {@code SuggestOption} with the provided key, value, component supplier, and menu
   * item supplier.
   *
   * @param key The unique key for the suggestion.
   * @param value The value associated with the suggestion.
   * @param componentSupplier A supplier for the suggestion's component element.
   * @param menuItemSupplier A supplier for the suggestion's menu item.
   */
  public SuggestOption(
      String key,
      V value,
      OptionSupplier<SpanElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    super(key, value, componentSupplier, menuItemSupplier);
    withComponent(
        (parent, span) ->
            span.applyMeta(ValueMeta.of(value), AttributeMeta.of(DUI_OPTION_KEY, key)));
  }
}
