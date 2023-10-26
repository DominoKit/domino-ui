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

import java.util.Comparator;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection;

/**
 * The {@code RecordsSorter} functional interface defines a contract for providing a comparator for
 * sorting records in a data table.
 *
 * @param <T> The type of data representing the records in the data table.
 */
@FunctionalInterface
public interface RecordsSorter<T> {

  /**
   * Provides a comparator for sorting records based on the specified sorting criteria.
   *
   * @param sortBy The name of the field by which the records should be sorted.
   * @param sortDirection The sorting direction (ascending or descending).
   * @return A comparator for sorting records.
   */
  Comparator<T> onSortChange(String sortBy, SortDirection sortDirection);
}
