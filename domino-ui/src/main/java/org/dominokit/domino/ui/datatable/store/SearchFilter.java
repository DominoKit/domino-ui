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
package org.dominokit.domino.ui.datatable.store;

import org.dominokit.domino.ui.datatable.events.SearchEvent;

/**
 * An interface to write implementation for filtering {@link LocalListDataStore} records
 *
 * @param <T> the type of the datatable records
 */
@FunctionalInterface
public interface SearchFilter<T> {
  /**
   * Filters a record based on the search filters
   *
   * @param event {@link SearchEvent}
   * @param record T the record being checked
   * @return boolean, true if the record match the search criteria otherwise false.
   */
  boolean filterRecord(SearchEvent event, T record);
}
