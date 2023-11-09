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

package org.dominokit.domino.ui.datatable.events;

import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;

/**
 * The {@code SearchEvent} class represents an event that is fired when a search is performed in a
 * DataTable.
 *
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 */
public class SearchEvent implements TableEvent {

  public static final String SEARCH_EVENT = "table-search";

  /** A list of filters associated with the search event. */
  private final List<Filter> filters;

  /**
   * Constructs a new {@code SearchEvent} with the specified list of filters.
   *
   * @param filters a list of filters
   */
  public SearchEvent(List<Filter> filters) {
    this.filters = filters;
  }

  /**
   * Retrieves the list of filters associated with this search event.
   *
   * @return the list of filters
   */
  public List<Filter> getFilters() {
    return filters;
  }

  /**
   * Retrieves a list of filters by their category.
   *
   * @param category the category to filter by
   * @return a list of filters that belong to the specified category
   */
  public List<Filter> getByCategory(Category category) {
    return filters.stream()
        .filter(f -> f.getCategory().equals(category))
        .collect(Collectors.toList());
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return SEARCH_EVENT;
  }
}
