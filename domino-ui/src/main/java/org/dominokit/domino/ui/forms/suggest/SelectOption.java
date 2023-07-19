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

import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.MenuItem;

/**
 * SelectOption class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class SelectOption<V> extends Option<V, DivElement, SelectOption<V>> {

  /**
   * create.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SelectOption} object
   */
  public static <V> SelectOption<V> create(String key, V value, String text) {
    return new SelectOption<>(key, value, text);
  }

  /**
   * create.
   *
   * @param value a V object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SelectOption} object
   */
  public static <V> SelectOption<V> create(V value) {
    return new SelectOption<>(String.valueOf(value), value, String.valueOf(value));
  }

  /**
   * create.
   *
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SelectOption} object
   */
  public static <V> SelectOption<V> create(V value, String text) {
    return new SelectOption<>(String.valueOf(value), value, text);
  }

  /**
   * create.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SelectOption} object
   */
  public static <V> SelectOption<V> create(String key, V value, String text, String description) {
    return new SelectOption<>(key, value, text, description);
  }

  /**
   * create.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param componentSupplier a OptionSupplier object
   * @param menuItemSupplier a OptionSupplier object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.SelectOption} object
   */
  public static <V> SelectOption<V> create(
      String key,
      V value,
      OptionSupplier<DivElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    return new SelectOption<>(key, value, componentSupplier, menuItemSupplier);
  }

  /**
   * Constructor for SelectOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   */
  public SelectOption(String key, V value, String text, String description) {
    super(
        key,
        value,
        elements.div().textContent(text).addCss(dui_m_r_1),
        MenuItem.create(text, description));
  }

  /**
   * Constructor for SelectOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   */
  public SelectOption(String key, V value, String text) {
    super(key, value, elements.div().textContent(text).addCss(dui_m_r_1), MenuItem.create(text));
  }

  /**
   * Constructor for SelectOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param componentSupplier a OptionSupplier object
   * @param menuItemSupplier a OptionSupplier object
   */
  public SelectOption(
      String key,
      V value,
      OptionSupplier<DivElement, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    super(key, value, componentSupplier, menuItemSupplier);
  }
}
