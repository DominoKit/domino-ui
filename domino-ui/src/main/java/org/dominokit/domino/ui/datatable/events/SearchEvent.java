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
 * This event is fired when ever the search filters of the data table are changed, it is fired from
 * the following locations :
 *
 * <p>{@link org.dominokit.domino.ui.datatable.store.LocalListDataStore}
 *
 * <p>{@link org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource}
 *
 * <p>{@link org.dominokit.domino.ui.datatable.store.SearchFilter}
 *
 * <p>{@link org.dominokit.domino.ui.datatable.model.SearchContext}
 */
public class SearchEvent implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String SEARCH_EVENT = "table-search";

  private final List<Filter> filters;

  /** @param filters the {@link List} of {@link Filter}s that are being applied */
  public SearchEvent(List<Filter> filters) {
    this.filters = filters;
  }

  /** @return the {@link List} of {@link Filter}s that are being applied */
  public List<Filter> getFilters() {
    return filters;
  }

  /**
   * @param category {@link Category}
   * @return a List of {@link Filter}s of the specified category
   */
  public List<Filter> getByCategory(Category category) {
    return filters.stream()
        .filter(f -> f.getCategory().equals(category))
        .collect(Collectors.toList());
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return SEARCH_EVENT;
  }
}
