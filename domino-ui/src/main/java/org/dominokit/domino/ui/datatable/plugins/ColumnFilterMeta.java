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
package org.dominokit.domino.ui.datatable.plugins;

import elemental2.dom.HTMLTableCellElement;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;

@Deprecated
public class ColumnFilterMeta<T> implements ComponentMeta {

  public static final String DOMINO_COLUMN_HEADER_FILTER_META = "domino-column-header-filter-meta";

  private ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter;
  private DominoElement<HTMLTableCellElement> headerElement;

  public ColumnFilterMeta(ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter) {
    this.headerFilter = headerFilter;
  }

  public static <T> ColumnFilterMeta<T> of(ColumnHeaderFilterPlugin.HeaderFilter<T> headerFilter) {
    return new ColumnFilterMeta<>(headerFilter);
  }

  @Override
  public String getKey() {
    return DOMINO_COLUMN_HEADER_FILTER_META;
  }

  public static <T> Optional<ColumnFilterMeta<T>> get(ColumnConfig<T> column) {
    return column.getMeta(DOMINO_COLUMN_HEADER_FILTER_META);
  }

  public ColumnHeaderFilterPlugin.HeaderFilter<T> getHeaderFilter() {
    return headerFilter;
  }
}
