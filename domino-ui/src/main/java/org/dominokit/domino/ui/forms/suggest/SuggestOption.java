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

import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.meta.AttributeMeta;
import org.dominokit.domino.ui.utils.meta.ValueMeta;

/** SuggestOption class. */
public class SuggestOption<V> extends Option<V, SpanElement, SuggestOption<V>> {
  /** Constant <code>DUI_OPTION_KEY="dui_option_key"</code> */
  public static final String DUI_OPTION_KEY = "dui_option_key";

  /**
   * create.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SuggestOption} object
   */
  public static <V> SuggestOption<V> create(String key, V value, String text) {
    return new SuggestOption<>(key, value, text);
  }

  /**
   * create.
   *
   * @param value a V object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SuggestOption} object
   */
  public static <V> SuggestOption<V> create(V value) {
    return new SuggestOption<>(String.valueOf(value), value, String.valueOf(value));
  }

  /**
   * create.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SuggestOption} object
   */
  public static <V> SuggestOption<V> create(String key, V value, String text, String description) {
    return new SuggestOption<>(key, value, text, description);
  }

  /**
   * create.
   *
   * @param value a V object
   * @param key a {@link java.lang.String} object
   * @param componentSupplier a OptionSupplier object
   * @param menuItemSupplier a OptionSupplier object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SuggestOption} object
   */
  public static <V> SuggestOption<V> create(
      V value,
      String key,
      OptionSupplier<SpanElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    return new SuggestOption<>(key, value, componentSupplier, menuItemSupplier);
  }

  /**
   * Constructor for SuggestOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   */
  public SuggestOption(String key, V value, String text, String description) {
    this(
        key,
        value,
        (k, v) -> elements.span().textContent(text),
        (k, v) -> MenuItem.create(text, description));
  }

  /**
   * Constructor for SuggestOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   */
  public SuggestOption(String key, V value, String text) {
    super(key, value, elements.span().textContent(text), MenuItem.create(text));
    withComponent(
        (parent, span) ->
            span.applyMeta(ValueMeta.of(value), AttributeMeta.of(DUI_OPTION_KEY, key)));
  }

  /**
   * Constructor for SuggestOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param componentSupplier a OptionSupplier object
   * @param menuItemSupplier a OptionSupplier object
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
