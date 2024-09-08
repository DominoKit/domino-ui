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
package org.dominokit.domino.ui.shaded.datatable.plugins;

import static java.util.Objects.isNull;

import elemental2.core.JsNumber;
import java.util.Optional;
import org.dominokit.domino.ui.shaded.datatable.ColumnConfig;
import org.dominokit.domino.ui.shaded.utils.ComponentMeta;

@Deprecated
public class ResizeColumnMeta implements ComponentMeta {

  public static final String RESIZE_COLUMN_META = "resize-column-meta";

  private double initialWidth;
  private double startPosition;
  private boolean resizable = true;

  private String originalWidth;
  private String originalMinWidth;
  private String originalMaxWidth;

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

  public String getOriginalWidth() {
    return originalWidth;
  }

  public void setOriginalWidth(String originalWidth) {
    this.originalWidth = originalWidth;
  }

  public String getOriginalMinWidth() {
    return originalMinWidth;
  }

  public void setOriginalMinWidth(String originalMinWidth) {
    this.originalMinWidth = originalMinWidth;
  }

  public String getOriginalMaxWidth() {
    return originalMaxWidth;
  }

  public void setOriginalMaxWidth(String originalMaxWidth) {
    this.originalMaxWidth = originalMaxWidth;
  }

  public String suppliedMaxWidthOrOriginal(String maxWidth) {
    if (isNull(originalMaxWidth) || !originalMaxWidth.contains("px")) {
      return maxWidth;
    }

    try {
      int original = JsNumber.parseInt(originalMaxWidth, 10);
      int supplied = JsNumber.parseInt(maxWidth, 10);

      if (supplied > original) {
        return originalMaxWidth;
      } else {
        return maxWidth;
      }
    } catch (Exception e) {
      return maxWidth;
    }
  }

  public String suppliedMinWidthOrOriginal(String minWidth) {
    if (isNull(originalMinWidth) || !originalMinWidth.contains("px")) {
      return minWidth;
    }
    try {
      int originalMax = JsNumber.parseInt(originalMaxWidth, 10);
      int supplied = JsNumber.parseInt(minWidth, 10);
      int original = JsNumber.parseInt(originalMinWidth, 10);

      if (supplied < original) {
        if (!"NaN".equals(originalMax + "")) {
          return Math.min(original, originalMax) + "px";
        } else {
          return originalMinWidth;
        }
      } else {
        if (!"NaN".equals(originalMax + "")) {
          return Math.min(supplied, originalMax) + "px";
        } else {
          return minWidth;
        }
      }
    } catch (Exception e) {
      return minWidth;
    }
  }

  @Override
  public String getKey() {
    return RESIZE_COLUMN_META;
  }

  public static Optional<ResizeColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(RESIZE_COLUMN_META);
  }
}
