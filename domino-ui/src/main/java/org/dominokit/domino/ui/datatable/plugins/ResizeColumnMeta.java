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

import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.ColumnMeta;

public class ResizeColumnMeta implements ColumnMeta {

  public static final String RESIZE_COLUMN_META = "resize-column-meta";

  private double initialWidth;
  private double startPosition;
  private boolean resizable = true;

  public static ResizeColumnMeta create() {
    return new ResizeColumnMeta(true);
  }

  public static ResizeColumnMeta create(boolean resizable) {
    return new ResizeColumnMeta(resizable);
  }

  public ResizeColumnMeta(boolean resizable) {
    this.resizable = resizable;
  }

  public double getInitialWidth() {
    return initialWidth;
  }

  public ResizeColumnMeta setInitialWidth(double initialWidth) {
    this.initialWidth = initialWidth;
    return this;
  }

  public double getStartPosition() {
    return startPosition;
  }

  public ResizeColumnMeta setStartPosition(double startPosition) {
    this.startPosition = startPosition;
    return this;
  }

  public boolean isResizable() {
    return resizable;
  }

  public ResizeColumnMeta setResizable(boolean resizable) {
    this.resizable = resizable;
    return this;
  }

  @Override
  public String getKey() {
    return RESIZE_COLUMN_META;
  }

  public static Optional<ResizeColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(RESIZE_COLUMN_META);
  }
}
