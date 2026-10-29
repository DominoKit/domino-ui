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
package org.dominokit.domino.ui.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Strategy interface for filtering collections using one or more {@link DataFilter} instances.
 *
 * <p>Implementations provided here are:
 *
 * <ul>
 *   <li>{@link #denial()} — keep items that pass <em>all</em> filters (logical AND).
 *   <li>{@link #acceptance()} — keep items that pass <em>any</em> filter (logical OR).
 *   <li>{@link #acceptAll()} — ignore filters and keep all items.
 *   <li>{@link #denyAll()} — ignore filters and keep no items.
 * </ul>
 *
 * <p><strong>Null-handling:</strong> For convenience and safety, all built-in modes treat {@code
 * data == null} as empty and {@code filters == null} or empty as "no filters", which accepts all
 * items (except for {@link #denyAll()}).
 *
 * <p><em>Note:</em> This interface uses private static helper methods (requires Java 9+).
 *
 * @param <T> the element type
 */
@FunctionalInterface
public interface FilterMode<T> {

  /**
   * Applies this filter mode to the provided data using the provided filters.
   *
   * @param data the input elements; may be {@code null} (treated as empty)
   * @param filters the filters to evaluate; may be {@code null} or empty
   * @return a new {@link List} containing the elements that satisfy this mode
   * @implNote Implementations should avoid mutating the input collections and should generally
   *     preserve input iteration order.
   */
  List<T> apply(Collection<T> data, Collection<? extends DataFilter<? super T>> filters);

  /**
   * A mode that keeps only items which pass <em>all</em> filters (logical AND).
   *
   * <p>Behavior:
   *
   * <ul>
   *   <li>If {@code data} is {@code null} or empty → returns an empty list.
   *   <li>If {@code filters} is {@code null} or empty → returns a copy of {@code data}.
   *   <li>Otherwise → includes an item only if every filter returns {@code true} for it.
   * </ul>
   *
   * @param <T> the element type
   * @return a {@link FilterMode} implementing AND semantics
   */
  static <T> FilterMode<T> denial() {
    return (data, filters) -> {
      if (data == null || data.isEmpty()) return new ArrayList<>();
      if (filters == null || filters.isEmpty()) return new ArrayList<>(data);

      List<T> out = new ArrayList<>(data.size());
      for (T item : data) {
        if (passesAll(item, filters)) {
          out.add(item);
        }
      }
      return out;
    };
  }

  /**
   * A mode that keeps items which pass <em>any</em> filter (logical OR).
   *
   * <p>Behavior:
   *
   * <ul>
   *   <li>If {@code data} is {@code null} or empty → returns an empty list.
   *   <li>If {@code filters} is {@code null} or empty → returns a copy of {@code data}.
   *   <li>Otherwise → includes an item if at least one filter returns {@code true} for it.
   * </ul>
   *
   * @param <T> the element type
   * @return a {@link FilterMode} implementing OR semantics
   */
  static <T> FilterMode<T> acceptance() {
    return (data, filters) -> {
      if (data == null || data.isEmpty()) return new ArrayList<>();
      if (filters == null || filters.isEmpty()) return new ArrayList<>(data);

      List<T> out = new ArrayList<>();
      for (T item : data) {
        if (passesAny(item, filters)) {
          out.add(item);
        }
      }
      return out;
    };
  }

  /**
   * A mode that ignores filters and accepts all items.
   *
   * <p>Behavior:
   *
   * <ul>
   *   <li>If {@code data} is {@code null} → returns an empty list.
   *   <li>Otherwise → returns a copy of {@code data}.
   * </ul>
   *
   * @param <T> the element type
   * @return a {@link FilterMode} that accepts everything
   */
  static <T> FilterMode<T> acceptAll() {
    return (data, filters) -> data == null ? new ArrayList<>() : new ArrayList<>(data);
  }

  /**
   * A mode that ignores filters and denies all items.
   *
   * @param <T> the element type
   * @return a {@link FilterMode} that accepts nothing
   */
  static <T> FilterMode<T> denyAll() {
    return (data, filters) -> new ArrayList<>();
  }

  /**
   * Returns {@code true} if the given {@code item} passes <em>all</em> {@code filters}.
   *
   * @param item the item to test
   * @param filters the filters to evaluate (assumed non-null/non-empty by callers)
   * @param <T> the element type
   * @return {@code true} if every filter returns {@code true} for {@code item}
   */
  private static <T> boolean passesAll(
      T item, Collection<? extends DataFilter<? super T>> filters) {
    for (DataFilter<? super T> f : filters) {
      if (!f.filter(item)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns {@code true} if the given {@code item} passes <em>any</em> of the {@code filters}.
   *
   * @param item the item to test
   * @param filters the filters to evaluate (assumed non-null/non-empty by callers)
   * @param <T> the element type
   * @return {@code true} if at least one filter returns {@code true} for {@code item}
   */
  private static <T> boolean passesAny(
      T item, Collection<? extends DataFilter<? super T>> filters) {
    for (DataFilter<? super T> f : filters) {
      if (f.filter(item)) {
        return true;
      }
    }
    return false;
  }
}
