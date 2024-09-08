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
package org.dominokit.domino.ui.shaded.datatable.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.shaded.datatable.DataTable;
import org.dominokit.domino.ui.shaded.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.shaded.datatable.events.SearchEvent;

/**
 * A class to represent the current search and filter state of the datatable
 *
 * @param <T> the type of data table records
 */
@Deprecated
public class SearchContext<T> {

  private final DataTable<T> dataTable;
  private final List<Filter> filters = new ArrayList<>();
  private final List<Consumer<SearchContext<T>>> beforeSearchHandlers = new ArrayList<>();

  /**
   * Initialize the context with a datatable
   *
   * @param dataTable the {@link DataTable} that is linked to this context
   */
  public SearchContext(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /**
   * Adds a new filter to the search context
   *
   * @param filter {@link Filter}
   * @return same SearchContext instance
   */
  public SearchContext add(Filter filter) {
    if (filters.contains(filter)) {
      this.filters.remove(filter);
    }

    this.filters.add(filter);
    return this;
  }

  /**
   * Removes a filter from the context
   *
   * @param filter {@link Filter}
   * @return same SearchContext instance
   */
  public SearchContext remove(Filter filter) {
    return remove(filter.getFieldName(), filter.getCategory());
  }

  /**
   * Removes all filters associated with the specified field name from the context
   *
   * @param fieldName String field name
   * @return same SearchContext instance
   */
  public SearchContext remove(String fieldName) {
    filters.removeAll(
        filters.stream()
            .filter(filter -> filter.getFieldName().equals(fieldName))
            .collect(Collectors.toList()));
    return this;
  }

  /**
   * Removes all filters associated with the specified field name and of the specified category from
   * the context
   *
   * @param fieldName String field name
   * @param category {@link Category}
   * @return same SearchContext instance
   */
  public SearchContext remove(String fieldName, Category category) {
    filters.removeAll(
        filters.stream()
            .filter(
                filter ->
                    filter.getFieldName().equals(fieldName)
                        && filter.getCategory().equals(category))
            .collect(Collectors.toList()));
    return this;
  }

  /**
   * Removes all filters of the specified category from the context
   *
   * @param category {@link Category}
   * @return same SearchContext instance
   */
  public SearchContext removeByCategory(Category category) {
    List<Filter> collect =
        filters.stream()
            .filter(filter -> filter.getCategory().equals(category))
            .collect(Collectors.toList());
    if (!collect.isEmpty()) {
      filters.removeAll(collect);
    }
    return this;
  }

  /**
   * Remove all filters and fires the {@link SearchClearedEvent}
   *
   * @return same SearchContext instance
   */
  public SearchContext clear() {
    filters.clear();
    dataTable.fireTableEvent(new SearchClearedEvent());
    return this;
  }

  /**
   * @param fieldName String field name
   * @return a List of all Filters associated with the specified field name
   */
  public List<Filter> get(String fieldName) {
    return filters.stream()
        .filter(filter -> filter.getFieldName().equals(fieldName))
        .collect(Collectors.toList());
  }

  /** @return a new List of all filters */
  public List<Filter> listAll() {
    return new ArrayList<>(filters);
  }

  /**
   * Checks if the context contains the specified filter
   *
   * @param filter {@link Filter}
   * @return boolean, true if the context contains the filter, otherwise false
   */
  public boolean contains(Filter filter) {
    return filters.stream().anyMatch(f -> f.equals(filter));
  }

  /** Call all the before search handlers and then fire the {@link SearchEvent} */
  public void fireSearchEvent() {
    beforeSearchHandlers.forEach(handler -> handler.accept(SearchContext.this));
    dataTable.fireTableEvent(new SearchEvent(listAll()));
  }

  /**
   * Adds a new BeforeSearch handler
   *
   * @param handler {@link Consumer} of {@link SearchContext}
   */
  public void addBeforeSearchHandler(Consumer<SearchContext<T>> handler) {
    this.beforeSearchHandlers.add(handler);
  }

  /**
   * removes a BeforeSearch handler
   *
   * @param handler {@link Consumer} of {@link SearchContext}
   */
  public void removeBeforeSearchHandler(Consumer<SearchContext<T>> handler) {
    this.beforeSearchHandlers.remove(handler);
  }
}
