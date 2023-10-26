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
package org.dominokit.domino.ui.datatable.plugins.column;

import elemental2.dom.HTMLTableCellElement;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Represents metadata associated with a column filter in a DataTable's header.
 *
 * @param <T> The type of data in the column.
 */
public class ColumnFilterMeta<T> implements ComponentMeta {

  /** The key used to identify this metadata. */
  public static final String DOMINO_COLUMN_HEADER_FILTER_META = "domino-column-header-filter-meta";

  private ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter;
  private DominoElement<HTMLTableCellElement> headerElement;

  /**
   * Creates a new ColumnFilterMeta instance with the given header filter.
   *
   * @param headerFilter The header filter associated with the column.
   */
  public ColumnFilterMeta(ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter) {
    this.headerFilter = headerFilter;
  }

  /**
   * Creates a new ColumnFilterMeta instance with the given header filter.
   *
   * @param <T> The type of data in the column.
   * @param headerFilter The header filter associated with the column.
   * @return A new ColumnFilterMeta instance.
   */
  public static <T> ColumnFilterMeta<T> of(ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter) {
    return new ColumnFilterMeta<>(headerFilter);
  }

  /**
   * {@inheritDoc} Returns the key used to identify this metadata, which is {@value
   * DOMINO_COLUMN_HEADER_FILTER_META}.
   *
   * @return The metadata key.
   */
  @Override
  public String getKey() {
    return DOMINO_COLUMN_HEADER_FILTER_META;
  }

  /**
   * Retrieves the ColumnFilterMeta associated with the specified column configuration.
   *
   * @param <T> The type of data in the column.
   * @param column The column configuration to retrieve the metadata from.
   * @return An optional ColumnFilterMeta instance if found; otherwise, an empty optional.
   */
  public static <T> Optional<ColumnFilterMeta<T>> get(ColumnConfig<T> column) {
    return column.getMeta(DOMINO_COLUMN_HEADER_FILTER_META);
  }

  /**
   * Retrieves the header filter associated with this ColumnFilterMeta.
   *
   * @return The header filter.
   */
  public ColumnHeaderFilterPlugin.HeaderFilter<T> getHeaderFilter() {
    return headerFilter;
  }
}
