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
package org.dominokit.domino.ui.shaded.datatable;

import java.util.Objects;
import java.util.Optional;
import org.dominokit.domino.ui.shaded.utils.ComponentMeta;

@Deprecated
public class RowAppenderMeta<T> implements ComponentMeta {

  public static final String TABLE_ROW_APPENDER_META = "table-row-appender-meta";
  private final TableConfig.RowAppender<T> rowAppender;

  public static <T> RowAppenderMeta<T> of(TableConfig.RowAppender<T> rowAppender) {
    return new RowAppenderMeta<>(rowAppender);
  }

  public RowAppenderMeta(TableConfig.RowAppender<T> rowAppender) {
    Objects.requireNonNull(rowAppender, "RowAppender cant be null.");
    this.rowAppender = rowAppender;
  }

  public static <T> Optional<RowAppenderMeta<T>> get(TableRow<T> row) {
    return row.getMeta(TABLE_ROW_APPENDER_META);
  }

  public TableConfig.RowAppender<T> getRowAppender() {
    return rowAppender;
  }

  @Override
  public String getKey() {
    return TABLE_ROW_APPENDER_META;
  }
}
