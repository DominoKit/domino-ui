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
 * ColumnFilterMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ColumnFilterMeta<T> implements ComponentMeta {

  /** Constant <code>DOMINO_COLUMN_HEADER_FILTER_META="domino-column-header-filter-meta"</code> */
  public static final String DOMINO_COLUMN_HEADER_FILTER_META = "domino-column-header-filter-meta";

  private ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter;
  private DominoElement<HTMLTableCellElement> headerElement;

  /**
   * Constructor for ColumnFilterMeta.
   *
   * @param headerFilter a {@link
   *     org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin.HeaderFilter}
   *     object
   */
  public ColumnFilterMeta(ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter) {
    this.headerFilter = headerFilter;
  }

  /**
   * of.
   *
   * @param headerFilter a {@link
   *     org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin.HeaderFilter}
   *     object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta} object
   */
  public static <T> ColumnFilterMeta<T> of(ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter) {
    return new ColumnFilterMeta<>(headerFilter);
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return DOMINO_COLUMN_HEADER_FILTER_META;
  }

  /**
   * get.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @param <T> a T class
   * @return a {@link java.util.Optional} object
   */
  public static <T> Optional<ColumnFilterMeta<T>> get(ColumnConfig<T> column) {
    return column.getMeta(DOMINO_COLUMN_HEADER_FILTER_META);
  }

  /**
   * Getter for the field <code>headerFilter</code>.
   *
   * @return a {@link
   *     org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin.HeaderFilter}
   *     object
   */
  public ColumnHeaderFilterPlugin.HeaderFilter<T> getHeaderFilter() {
    return headerFilter;
  }
}
