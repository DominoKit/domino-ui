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

import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.utils.meta.AttributeMeta;
import org.dominokit.domino.ui.utils.meta.ValueMeta;

/**
 * TagOption class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TagOption<V> extends Option<V, Chip, TagOption<V>> {
  /** Constant <code>DUI_OPTION_KEY="dui_option_key"</code> */
  public static final String DUI_OPTION_KEY = "dui_option_key";

  /**
   * create.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.TagOption} object
   */
  public static <V> TagOption<V> create(String key, V value, String text) {
    return new TagOption<>(key, value, text);
  }

  /**
   * create.
   *
   * @param value a V object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.TagOption} object
   */
  public static <V> TagOption<V> create(V value) {
    return new TagOption<>(String.valueOf(value), value, String.valueOf(value));
  }

  /**
   * create.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.TagOption} object
   */
  public static <V> TagOption<V> create(String key, V value, String text, String description) {
    return new TagOption<>(key, value, text, description);
  }

  /**
   * create.
   *
   * @param value a V object
   * @param key a {@link java.lang.String} object
   * @param componentSupplier a OptionSupplier object
   * @param menuItemSupplier a OptionSupplier object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.TagOption} object
   */
  public static <V> TagOption<V> create(
      V value,
      String key,
      OptionSupplier<Chip, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    return new TagOption<>(key, value, componentSupplier, menuItemSupplier);
  }

  /**
   * Constructor for TagOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   * @param description a {@link java.lang.String} object
   */
  public TagOption(String key, V value, String text, String description) {
    this(key, value, (k, v) -> Chip.create(text), (k, v) -> MenuItem.create(text, description));
  }

  /**
   * Constructor for TagOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param text a {@link java.lang.String} object
   */
  public TagOption(String key, V value, String text) {
    super(key, value, Chip.create(text), MenuItem.create(text));
    withComponent(
        (parent, chip) ->
            chip.addOnRemoveListener(c -> onChipRemoved())
                .applyMeta(ValueMeta.of(value), AttributeMeta.of(DUI_OPTION_KEY, key)));
  }

  /**
   * Constructor for TagOption.
   *
   * @param key a {@link java.lang.String} object
   * @param value a V object
   * @param componentSupplier a OptionSupplier object
   * @param menuItemSupplier a OptionSupplier object
   */
  public TagOption(
      String key,
      V value,
      OptionSupplier<Chip, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    super(key, value, componentSupplier, menuItemSupplier);
    withComponent(
        (parent, chip) -> {
          chip.addOnRemoveListener(c -> onChipRemoved())
              .applyMeta(ValueMeta.of(value), AttributeMeta.of(DUI_OPTION_KEY, key));
        });
  }

  private void onChipRemoved() {
    getTarget().onOptionDeselected(this);
  }

  /**
   * setRemovable.
   *
   * @param removable a boolean
   * @return a {@link org.dominokit.domino.ui.forms.suggest.TagOption} object
   */
  public TagOption<V> setRemovable(boolean removable) {
    this.getComponent().setRemovable(removable);
    return this;
  }

  /**
   * isRemovable.
   *
   * @return a boolean
   */
  public boolean isRemovable() {
    return this.getComponent().isRemovable();
  }
}
