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
package org.dominokit.domino.ui.tag.store;

import static java.util.Map.Entry;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.TreeMap;

/**
 * A store implementation that accepts a list of items ordered by key
 *
 * @param <V> the type of the value
 */
@Deprecated
public class OrderedLocalTagsStore<V> implements TagsStore<V> {

  private final Map<String, V> items = new TreeMap<>();

  /**
   * @param <V> the type of the object
   * @return new instance
   */
  public static <V> OrderedLocalTagsStore<V> create() {
    return new OrderedLocalTagsStore<>();
  }

  /** {@inheritDoc} */
  @Override
  public OrderedLocalTagsStore<V> addItem(String displayValue, V item) {
    items.put(displayValue, item);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public OrderedLocalTagsStore<V> removeItem(V item) {
    items.values().remove(item);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public OrderedLocalTagsStore<V> clear() {
    items.clear();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public OrderedLocalTagsStore<V> addItems(Map<String, V> items) {
    this.items.putAll(items);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Map<String, V> getItems() {
    return items;
  }

  /** {@inheritDoc} */
  @Override
  public V getItemByDisplayValue(String displayValue) {
    return items.get(displayValue);
  }

  /** {@inheritDoc} */
  @Override
  public Map<String, V> filter(String searchValue) {
    return items.entrySet().stream()
        .filter(entry -> entry.getKey().contains(searchValue))
        .collect(toMap(Entry::getKey, Entry::getValue));
  }

  /** {@inheritDoc} */
  @Override
  public String getDisplayValue(V value) {
    return items.entrySet().stream()
        .filter(entry -> entry.getValue().equals(value))
        .map(Entry::getKey)
        .findFirst()
        .orElse(null);
  }
}
