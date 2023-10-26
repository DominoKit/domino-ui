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

/**
 * The {@code Category} enum represents different categories or types of filters that can be applied
 * in a DataTable.
 *
 * <p>Filters in a DataTable can be categorized into two main categories:
 *
 * <ul>
 *   <li>SEARCH: This category is used for filters that are applied to the DataTable's search
 *       functionality. Filters in this category are typically used to search for specific data
 *       within the DataTable.
 *   <li>HEADER_FILTER: This category is used for filters that are applied to the DataTable's header
 *       columns. Filters in this category are typically used to filter data based on
 *       column-specific criteria, such as filtering by date, number, or text within a specific
 *       column.
 * </ul>
 *
 * <p>You can use these categories to classify and organize filters within your DataTable, making it
 * easier to manage and apply different types of filters to your data.
 *
 * @see org.dominokit.domino.ui.datatable.model.Filter
 */
public enum Category {
  /** The {@code SEARCH} category for filters applied to the DataTable's search functionality. */
  SEARCH,

  /** The {@code HEADER_FILTER} category for filters applied to the DataTable's header columns. */
  HEADER_FILTER
}
