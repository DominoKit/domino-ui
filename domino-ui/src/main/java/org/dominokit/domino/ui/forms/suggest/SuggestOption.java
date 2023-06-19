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

public class SuggestOption<V> extends Option<V, SpanElement, SuggestOption<V>> {
  public static final String DUI_OPTION_KEY = "dui_option_key";

  public static <V> SuggestOption<V> create(String key, V value, String text) {
    return new SuggestOption<>(key, value, text);
  }

  public static <V> SuggestOption<V> create(V value) {
    return new SuggestOption<>(String.valueOf(value), value, String.valueOf(value));
  }

  public static <V> SuggestOption<V> create(String key, V value, String text, String description) {
    return new SuggestOption<>(key, value, text, description);
  }

  public static <V> SuggestOption<V> create(
      V value,
      String key,
      OptionSupplier<SpanElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    return new SuggestOption<>(key, value, componentSupplier, menuItemSupplier);
  }

  public SuggestOption(String key, V value, String text, String description) {
    this(
        key,
        value,
        (k, v) -> elements.span().textContent(text),
        (k, v) -> MenuItem.create(text, description));
  }

  public SuggestOption(String key, V value, String text) {
    super(key, value, elements.span().textContent(text), MenuItem.create(text));
    withComponent(
        (parent, span) ->
            span.applyMeta(ValueMeta.of(value), AttributeMeta.of(DUI_OPTION_KEY, key)));
  }

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
