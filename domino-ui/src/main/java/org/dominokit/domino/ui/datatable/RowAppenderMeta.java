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

package org.dominokit.domino.ui.datatable;

import java.util.Objects;
import java.util.Optional;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * A meta information class for storing a row appender in a data table row.
 *
 * @param <T> The type of data in the data table.
 */
public class RowAppenderMeta<T> implements ComponentMeta {

  public static final String TABLE_ROW_APPENDER_META = "table-row-appender-meta";

  private final TableConfig.RowAppender<T> rowAppender;

  /**
   * Creates a new instance of {@code RowAppenderMeta} with the provided row appender.
   *
   * @param <T> The type of data in the data table.
   * @param rowAppender The row appender to store.
   * @return A new {@code RowAppenderMeta<T>} instance with the provided row appender.
   */
  public static <T> RowAppenderMeta<T> of(TableConfig.RowAppender<T> rowAppender) {
    return new RowAppenderMeta<>(rowAppender);
  }

  /**
   * Creates a new instance of {@code RowAppenderMeta} with the provided row appender.
   *
   * @param rowAppender The row appender to store.
   */
  public RowAppenderMeta(TableConfig.RowAppender<T> rowAppender) {
    Objects.requireNonNull(rowAppender, "RowAppender cant be null.");
    this.rowAppender = rowAppender;
  }

  /**
   * Retrieves a {@code RowAppenderMeta} instance associated with a specific data table row.
   *
   * @param <T> The type of data in the data table.
   * @param row The data table row.
   * @return An optional containing the {@code RowAppenderMeta} instance if found, or an empty
   *     optional if not found.
   */
  public static <T> Optional<RowAppenderMeta<T>> get(TableRow<T> row) {
    return row.getMeta(TABLE_ROW_APPENDER_META);
  }

  /**
   * Gets the stored row appender.
   *
   * @return The row appender.
   */
  public TableConfig.RowAppender<T> getRowAppender() {
    return rowAppender;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the key that identifies the type of metadata associated with this class.
   *
   * @return The key for identifying metadata of this type.
   */
  @Override
  public String getKey() {
    return TABLE_ROW_APPENDER_META;
  }
}
