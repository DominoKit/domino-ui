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

package org.dominokit.domino.ui.datatable.plugins.pagination;

/**
 * The {@code SortDirection} enum represents the sorting directions used in sorting operations. It
 * provides three possible sorting directions: - {@link SortDirection#ASC ASC} for ascending sorting
 * order. - {@link SortDirection#DESC DESC} for descending sorting order. - {@link
 * SortDirection#NONE NONE} when no sorting is applied.
 *
 * <p>This enum is typically used in conjunction with sorting operations in a {@link
 * org.dominokit.domino.ui.datatable.DataTable} to indicate the desired sorting direction for
 * columns or data.
 *
 * @see org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin
 */
public enum SortDirection {
  /**
   * Represents ascending sorting order.
   *
   * @see org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin
   */
  ASC,

  /**
   * Represents descending sorting order.
   *
   * @see org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin
   */
  DESC,

  /**
   * Represents no sorting.
   *
   * @see org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin
   */
  NONE;

  public SortDirection next(boolean triState) {
    if (this == NONE) return ASC;
    if (this == ASC) return DESC;
    if (this == DESC) return triState ? NONE : ASC;
    return NONE;
  }

  public SortDirection previous(boolean triState) {
    if (this == NONE) return DESC;
    if (this == DESC) return ASC;
    if (this == ASC) return triState ? NONE : DESC;
    return NONE;
  }
}
