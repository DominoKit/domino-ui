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
package org.dominokit.domino.ui.datatable.plugins.responsive;

import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.ComponentMeta;

/** Responsive presentation metadata for a data-table column. */
public class ResponsiveColumnMeta implements ComponentMeta {

  /** The key used to identify responsive column metadata. */
  public static final String RESPONSIVE_COLUMN_META = "domino-responsive-column-meta";

  private boolean omitPriorityTitle;

  /** Creates responsive metadata with the default column-title behavior. */
  public static ResponsiveColumnMeta create() {
    return new ResponsiveColumnMeta();
  }

  /** Creates metadata that omits this priority column's generated responsive label. */
  public static ResponsiveColumnMeta omitPriorityTitle() {
    return create().setOmitPriorityTitle(true);
  }

  /** Retrieves responsive metadata associated with a column, if present. */
  public static Optional<ResponsiveColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(RESPONSIVE_COLUMN_META);
  }

  @Override
  public String getKey() {
    return RESPONSIVE_COLUMN_META;
  }

  /** Returns whether the generated title before a priority cell should be omitted. */
  public boolean isOmitPriorityTitle() {
    return omitPriorityTitle;
  }

  /** Configures whether the generated title before a priority cell should be omitted. */
  public ResponsiveColumnMeta setOmitPriorityTitle(boolean omitPriorityTitle) {
    this.omitPriorityTitle = omitPriorityTitle;
    return this;
  }
}
