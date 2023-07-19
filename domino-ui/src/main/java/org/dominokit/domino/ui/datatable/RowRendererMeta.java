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
 * RowRendererMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class RowRendererMeta<T> implements ComponentMeta {

  /** Constant <code>TABLE_ROW_RENDERER_META="table-row-renderer-meta"</code> */
  public static final String TABLE_ROW_RENDERER_META = "table-row-renderer-meta";

  private final TableRow.RowRenderer<T> rowRenderer;

  /**
   * of.
   *
   * @param rowRenderer a {@link org.dominokit.domino.ui.datatable.TableRow.RowRenderer} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.RowRendererMeta} object
   */
  public static <T> RowRendererMeta<T> of(TableRow.RowRenderer<T> rowRenderer) {
    return new RowRendererMeta<>(rowRenderer);
  }

  /**
   * Constructor for RowRendererMeta.
   *
   * @param rowRenderer a {@link org.dominokit.domino.ui.datatable.TableRow.RowRenderer} object
   */
  public RowRendererMeta(TableRow.RowRenderer<T> rowRenderer) {
    Objects.requireNonNull(rowRenderer, "RowRenderer cant be null.");
    this.rowRenderer = rowRenderer;
  }

  /**
   * get.
   *
   * @param row a {@link org.dominokit.domino.ui.datatable.TableRow} object
   * @param <T> a T class
   * @return a {@link java.util.Optional} object
   */
  public static <T> Optional<RowRendererMeta<T>> get(TableRow<T> row) {
    return row.getMeta(TABLE_ROW_RENDERER_META);
  }

  /**
   * Getter for the field <code>rowRenderer</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.TableRow.RowRenderer} object
   */
  public TableRow.RowRenderer<T> getRowRenderer() {
    return rowRenderer;
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return TABLE_ROW_RENDERER_META;
  }
}
