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
 * An interface to implement the sort mechanism for a {@link
 * org.dominokit.domino.ui.datatable.store.LocalListDataStore}
 *
 * @param <T> the type of the data table records
 * @author vegegoku
 * @version $Id: $Id
 */
@FunctionalInterface
public interface RecordsSorter<T> {
  /**
   * onSortChange.
   *
   * @param sortBy String sort column name
   * @param sortDirection {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortDirection}
   * @return a {@link java.util.Comparator} to sort the records
   */
  Comparator<T> onSortChange(String sortBy, SortDirection sortDirection);
}
