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

package org.dominokit.domino.ui.datatable.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.SearchClearedEvent;
import org.dominokit.domino.ui.datatable.events.SearchEvent;

/**
 * The {@code SearchContext} class provides a context for managing and performing searches within a
 * DataTable. It allows you to add, remove, and clear filters for searching data, and fire search
 * events to trigger data filtering.
 *
 * @param <T> the type of data in the DataTable
 * @see org.dominokit.domino.ui.datatable.DataTable
 * @see org.dominokit.domino.ui.datatable.model.Filter
 * @see org.dominokit.domino.ui.datatable.events.SearchEvent
 * @see org.dominokit.domino.ui.datatable.events.SearchClearedEvent
 */
public class SearchContext<T> {

  private final DataTable<T> dataTable;
  private final List<Filter> filters = new ArrayList<>();
  private final List<Consumer<SearchContext<T>>> beforeSearchHandlers = new ArrayList<>();

  /**
   * Creates a new {@code SearchContext} associated with the specified DataTable.
   *
   * @param dataTable the DataTable to which this context is associated
   */
  public SearchContext(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /**
   * Adds a filter to the search context. If a filter with the same field name and category already
   * exists, it will be replaced.
   *
   * @param filter the filter to add
   * @return this SearchContext for method chaining
   */
  public SearchContext add(Filter filter) {
    if (filters.contains(filter)) {
      this.filters.remove(filter);
    }

    this.filters.add(filter);
    return this;
  }

  /**
   * Removes a filter from the search context.
   *
   * @param filter the filter to remove
   * @return this SearchContext for method chaining
   */
  public SearchContext remove(Filter filter) {
    return remove(filter.getFieldName(), filter.getCategory());
  }

  /**
   * Removes all filters with the specified field name from the search context.
   *
   * @param fieldName the name of the field associated with the filters to remove
   * @return this SearchContext for method chaining
   */
  public SearchContext remove(String fieldName) {
    filters.removeAll(
        filters.stream()
            .filter(filter -> filter.getFieldName().equals(fieldName))
            .collect(Collectors.toList()));
    return this;
  }

  /**
   * Removes all filters with the specified field name and category from the search context.
   *
   * @param fieldName the name of the field associated with the filters to remove
   * @param category the category of the filters to remove
   * @return this SearchContext for method chaining
   */
  public SearchContext remove(String fieldName, IsFilterCategory category) {
    filters.removeAll(
        filters.stream()
            .filter(
                filter ->
                    filter.getFieldName().equals(fieldName)
                        && filter.getCategory().isSameCategory(category))
            .collect(Collectors.toList()));
    return this;
  }

  /**
   * Removes all filters with the specified category from the search context.
   *
   * @param category the category of the filters to remove
   * @return this SearchContext for method chaining
   */
  public SearchContext removeByCategory(IsFilterCategory category) {
    List<Filter> collect =
        filters.stream()
            .filter(filter -> filter.getCategory().isSameCategory(category))
            .collect(Collectors.toList());
    if (!collect.isEmpty()) {
      filters.removeAll(collect);
    }
    return this;
  }

  /**
   * Clears all filters from the search context.
   *
   * @return this SearchContext for method chaining
   */
  public SearchContext clear() {
    filters.clear();
    dataTable.fireTableEvent(new SearchClearedEvent());
    return this;
  }

  /**
   * Retrieves all filters with the specified field name.
   *
   * @param fieldName the name of the field associated with the filters to retrieve
   * @return a list of filters with the specified field name
   */
  public List<Filter> get(String fieldName) {
    return filters.stream()
        .filter(filter -> filter.getFieldName().equals(fieldName))
        .collect(Collectors.toList());
  }

  /**
   * Retrieves all filters in the search context.
   *
   * @return a list of all filters in the search context
   */
  public List<Filter> listAll() {
    return new ArrayList<>(filters);
  }

  /**
   * Checks if the search context contains the specified filter.
   *
   * @param filter the filter to check for
   * @return {@code true} if the filter exists in the search context, {@code false} otherwise
   */
  public boolean contains(Filter filter) {
    return filters.stream().anyMatch(f -> f.equals(filter));
  }

  /**
   * Fires a search event, triggering data filtering based on the current filters in the search
   * context.
   */
  public void fireSearchEvent() {
    beforeSearchHandlers.forEach(handler -> handler.accept(SearchContext.this));
    dataTable.fireTableEvent(new SearchEvent(listAll()));
  }

  /**
   * Adds a handler to be executed before a search event is fired.
   *
   * @param handler the handler to add
   */
  public void addBeforeSearchHandler(Consumer<SearchContext<T>> handler) {
    this.beforeSearchHandlers.add(handler);
  }

  /**
   * Removes a handler from the list of handlers to be executed before a search event is fired.
   *
   * @param handler the handler to remove
   */
  public void removeBeforeSearchHandler(Consumer<SearchContext<T>> handler) {
    this.beforeSearchHandlers.remove(handler);
  }
}
