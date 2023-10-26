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

import static java.util.Objects.isNull;

import elemental2.core.JsNumber;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * Meta information class used to store additional metadata related to column resizing in a
 * DataTable.
 */
public class ResizeColumnMeta implements ComponentMeta {

  /** The key used to retrieve the ResizeColumnMeta instance from a column's metadata. */
  public static final String RESIZE_COLUMN_META = "resize-column-meta";

  private double initialWidth;
  private double startPosition;
  private boolean resizable = true;

  private String originalWidth;
  private String originalMinWidth;
  private String originalMaxWidth;

  /**
   * Creates a new ResizeColumnMeta instance with the default setting of resizable.
   *
   * @return A new ResizeColumnMeta instance with resizable set to true.
   */
  public static ResizeColumnMeta create() {
    return new ResizeColumnMeta(true);
  }

  /**
   * Creates a new ResizeColumnMeta instance with the specified resizable setting.
   *
   * @param resizable {@code true} if the column is resizable, {@code false} otherwise.
   * @return A new ResizeColumnMeta instance with the specified resizable setting.
   */
  public static ResizeColumnMeta create(boolean resizable) {
    return new ResizeColumnMeta(resizable);
  }

  /**
   * Constructs a ResizeColumnMeta instance with the specified resizable setting.
   *
   * @param resizable {@code true} if the column is resizable, {@code false} otherwise.
   */
  public ResizeColumnMeta(boolean resizable) {
    this.resizable = resizable;
  }

  /**
   * Gets the initial width of the column during resizing.
   *
   * @return The initial width of the column during resizing.
   */
  public double getInitialWidth() {
    return initialWidth;
  }

  /**
   * Sets the initial width of the column during resizing.
   *
   * @param initialWidth The initial width of the column during resizing.
   * @return The ResizeColumnMeta instance with the updated initial width.
   */
  public ResizeColumnMeta setInitialWidth(double initialWidth) {
    this.initialWidth = initialWidth;
    return this;
  }

  /**
   * Gets the starting position of the column during resizing.
   *
   * @return The starting position of the column during resizing.
   */
  public double getStartPosition() {
    return startPosition;
  }

  /**
   * Sets the starting position of the column during resizing.
   *
   * @param startPosition The starting position of the column during resizing.
   * @return The ResizeColumnMeta instance with the updated starting position.
   */
  public ResizeColumnMeta setStartPosition(double startPosition) {
    this.startPosition = startPosition;
    return this;
  }

  /**
   * Checks if the column is resizable.
   *
   * @return {@code true} if the column is resizable, {@code false} otherwise.
   */
  public boolean isResizable() {
    return resizable;
  }

  /**
   * Sets whether the column is resizable.
   *
   * @param resizable {@code true} to make the column resizable, {@code false} to make it
   *     non-resizable.
   * @return The ResizeColumnMeta instance with the updated resizable setting.
   */
  public ResizeColumnMeta setResizable(boolean resizable) {
    this.resizable = resizable;
    return this;
  }

  /**
   * Gets the original width of the column.
   *
   * @return The original width of the column.
   */
  public String getOriginalWidth() {
    return originalWidth;
  }

  /**
   * Sets the original width of the column.
   *
   * @param originalWidth The original width of the column.
   */
  public void setOriginalWidth(String originalWidth) {
    this.originalWidth = originalWidth;
  }

  /**
   * Gets the original minimum width of the column.
   *
   * @return The original minimum width of the column.
   */
  public String getOriginalMinWidth() {
    return originalMinWidth;
  }

  /**
   * Sets the original minimum width of the column.
   *
   * @param originalMinWidth The original minimum width of the column.
   */
  public void setOriginalMinWidth(String originalMinWidth) {
    this.originalMinWidth = originalMinWidth;
  }

  /**
   * Gets the original maximum width of the column.
   *
   * @return The original maximum width of the column.
   */
  public String getOriginalMaxWidth() {
    return originalMaxWidth;
  }

  /**
   * Sets the original maximum width of the column.
   *
   * @param originalMaxWidth The original maximum width of the column.
   */
  public void setOriginalMaxWidth(String originalMaxWidth) {
    this.originalMaxWidth = originalMaxWidth;
  }

  /**
   * Returns the original maximum width or the supplied width if the original is not set or invalid.
   *
   * @param maxWidth The supplied maximum width.
   * @return The original maximum width or the supplied width if valid.
   */
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

  /**
   * Returns the original minimum width or the supplied width if the original is not set or invalid.
   *
   * @param minWidth The supplied minimum width.
   * @return The original minimum width or the supplied width if valid.
   */
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

  /**
   * Gets the key used to identify the metadata associated with column resizing.
   *
   * @return The key used to identify the column resizing metadata.
   */
  @Override
  public String getKey() {
    return RESIZE_COLUMN_META;
  }

  /**
   * Retrieves the ResizeColumnMeta instance associated with the given column.
   *
   * @param column The ColumnConfig to retrieve the ResizeColumnMeta from.
   * @return An Optional containing the ResizeColumnMeta if it exists, or an empty Optional if not.
   */
  public static Optional<ResizeColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(RESIZE_COLUMN_META);
  }
}
