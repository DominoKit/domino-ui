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
 * Represents an option for tagging in a tagging component.
 *
 * @param <V> The type of the tagging value.
 */
public class TagOption<V> extends Option<V, Chip, TagOption<V>> {

  /** The attribute key used to store the option key in the DOM element. */
  public static final String DUI_OPTION_KEY = "dui_option_key";

  /**
   * Creates a new {@code TagOption} with the provided key, value, and text.
   *
   * @param key The unique key for the tag option.
   * @param value The value associated with the tag option.
   * @param text The text to display for the tag option.
   * @return A new {@code TagOption} instance.
   */
  public static <V> TagOption<V> create(String key, V value, String text) {
    return new TagOption<>(key, value, text);
  }

  /**
   * Creates a new {@code TagOption} with the provided value, using its string representation as the
   * key and text.
   *
   * @param value The value associated with the tag option.
   * @return A new {@code TagOption} instance.
   */
  public static <V> TagOption<V> create(V value) {
    return new TagOption<>(String.valueOf(value), value, String.valueOf(value));
  }

  /**
   * Creates a new {@code TagOption} with the provided key, value, text, and description.
   *
   * @param key The unique key for the tag option.
   * @param value The value associated with the tag option.
   * @param text The text to display for the tag option.
   * @param description The description of the tag option.
   * @return A new {@code TagOption} instance.
   */
  public static <V> TagOption<V> create(String key, V value, String text, String description) {
    return new TagOption<>(key, value, text, description);
  }

  /**
   * Creates a new {@code TagOption} with the provided key, value, component supplier, and menu item
   * supplier.
   *
   * @param value The value associated with the tag option.
   * @param key The unique key for the tag option.
   * @param componentSupplier A supplier for the tag option's component element.
   * @param menuItemSupplier A supplier for the tag option's menu item.
   * @return A new {@code TagOption} instance.
   */
  public static <V> TagOption<V> create(
      V value,
      String key,
      OptionSupplier<Chip, V> componentSupplier,
      OptionSupplier<AbstractMenuItem<V>, V> menuItemSupplier) {
    return new TagOption<>(key, value, componentSupplier, menuItemSupplier);
  }

  /**
   * Constructs a {@code TagOption} with the provided key, value, text, and description.
   *
   * @param key The unique key for the tag option.
   * @param value The value associated with the tag option.
   * @param text The text to display for the tag option.
   * @param description The description of the tag option.
   */
  public TagOption(String key, V value, String text, String description) {
    this(key, value, (k, v) -> Chip.create(text), (k, v) -> MenuItem.create(text, description));
  }

  /**
   * Constructs a {@code TagOption} with the provided key, value, and text.
   *
   * @param key The unique key for the tag option.
   * @param value The value associated with the tag option.
   * @param text The text to display for the tag option.
   */
  public TagOption(String key, V value, String text) {
    super(key, value, Chip.create(text), MenuItem.create(text));
    withComponent(
        (parent, chip) ->
            chip.addOnRemoveListener(c -> onChipRemoved())
                .applyMeta(ValueMeta.of(value), AttributeMeta.of(DUI_OPTION_KEY, key)));
  }

  /**
   * Constructs a {@code TagOption} with the provided key, value, component supplier, and menu item
   * supplier.
   *
   * @param key The unique key for the tag option.
   * @param value The value associated with the tag option.
   * @param componentSupplier A supplier for the tag option's component element.
   * @param menuItemSupplier A supplier for the tag option's menu item.
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
   * Sets whether the tag option is removable.
   *
   * @param removable {@code true} if the tag option is removable, {@code false} otherwise.
   * @return This {@code TagOption} instance.
   */
  public TagOption<V> setRemovable(boolean removable) {
    this.getComponent().setRemovable(removable);
    return this;
  }

  /**
   * Checks if the tag option is removable.
   *
   * @return {@code true} if the tag option is removable, {@code false} otherwise.
   */
  public boolean isRemovable() {
    return this.getComponent().isRemovable();
  }
}
