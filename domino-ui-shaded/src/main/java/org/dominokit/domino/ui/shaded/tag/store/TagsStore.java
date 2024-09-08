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
package org.dominokit.domino.ui.shaded.tag.store;

import java.util.Map;

/**
 * A store for saving, loading and filtering a list of items that will be used in {@link TagsStore}
 *
 * @param <V> the type of the value
 */
@Deprecated
public interface TagsStore<V> {
  /**
   * Adds a new item with its display value
   *
   * @param displayValue the display value that will be presented when selecting this item
   * @param item the item
   * @return same instance
   */
  TagsStore<V> addItem(String displayValue, V item);

  /**
   * Removes item from the store
   *
   * @param item the item
   * @return same instance
   */
  TagsStore<V> removeItem(V item);

  /**
   * Clears the store
   *
   * @return same instance
   */
  TagsStore<V> clear();

  /**
   * Adds a list of items with their display values
   *
   * @param items a map representing the display value and the item
   * @return same instance
   */
  TagsStore<V> addItems(Map<String, V> items);

  /** @return all the items in the store with their display values */
  Map<String, V> getItems();

  /**
   * @param displayValue the display value to search for
   * @return the item represented by the {@code displayValue}
   */
  V getItemByDisplayValue(String displayValue);

  /**
   * Filters the items based on the search query
   *
   * @param searchValue the query
   * @return the filtered items with their display values
   */
  Map<String, V> filter(String searchValue);

  /**
   * @param value the item to get the display value for
   * @return the display value of the item
   */
  String getDisplayValue(V value);
}
