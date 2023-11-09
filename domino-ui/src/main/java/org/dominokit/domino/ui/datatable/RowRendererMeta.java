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
 * The {@code RowRendererMeta} class associates a row renderer with a table row, allowing
 * customization of the rendering logic for individual rows in a data table.
 *
 * @param <T> The type of data contained in the row.
 */
public class RowRendererMeta<T> implements ComponentMeta {

  /** The meta key used to associate row renderers with table rows. */
  public static final String TABLE_ROW_RENDERER_META = "table-row-renderer-meta";

  /** The row renderer associated with this meta information. */
  private final TableRow.RowRenderer<T> rowRenderer;

  /**
   * Creates a new {@code RowRendererMeta} instance with the specified row renderer.
   *
   * @param <T> The type of data contained in the row.
   * @param rowRenderer The row renderer to associate with the meta information.
   * @return A new {@code RowRendererMeta} instance with the specified row renderer.
   */
  public static <T> RowRendererMeta<T> of(TableRow.RowRenderer<T> rowRenderer) {
    return new RowRendererMeta<>(rowRenderer);
  }

  /**
   * Constructs a new {@code RowRendererMeta} with the given row renderer.
   *
   * @param rowRenderer The row renderer to associate with this meta information.
   */
  public RowRendererMeta(TableRow.RowRenderer<T> rowRenderer) {
    Objects.requireNonNull(rowRenderer, "RowRenderer cant be null.");
    this.rowRenderer = rowRenderer;
  }

  /**
   * Gets the meta information associated with a given table row, if available.
   *
   * @param <T> The type of data contained in the row.
   * @param row The table row for which to retrieve the meta information.
   * @return An optional containing the meta information if available, or an empty optional if not.
   */
  public static <T> Optional<RowRendererMeta<T>> get(TableRow<T> row) {
    return row.getMeta(TABLE_ROW_RENDERER_META);
  }

  /**
   * Retrieves the row renderer associated with this meta information.
   *
   * @return The row renderer associated with this meta information.
   */
  public TableRow.RowRenderer<T> getRowRenderer() {
    return rowRenderer;
  }

  /**
   * Retrieves the meta key used to associate row renderers with table rows.
   *
   * @return The meta key for row renderer association.
   */
  @Override
  public String getKey() {
    return TABLE_ROW_RENDERER_META;
  }
}
