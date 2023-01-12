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

public class RowRendererMeta<T> implements RowMeta {

  public static final String TABLE_ROW_RENDERER_META = "table-row-renderer-meta";

  private final TableRow.RowRenderer<T> rowRenderer;

  public static <T> RowRendererMeta<T> of(TableRow.RowRenderer<T> rowRenderer) {
    return new RowRendererMeta<>(rowRenderer);
  }

  public RowRendererMeta(TableRow.RowRenderer<T> rowRenderer) {
    Objects.requireNonNull(rowRenderer, "RowRenderer cant be null.");
    this.rowRenderer = rowRenderer;
  }

  public static <T> Optional<RowRendererMeta<T>> get(TableRow<T> row) {
    return row.getMeta(TABLE_ROW_RENDERER_META);
  }

  public TableRow.RowRenderer<T> getRowRenderer() {
    return rowRenderer;
  }

  @Override
  public String getKey() {
    return TABLE_ROW_RENDERER_META;
  }
}
