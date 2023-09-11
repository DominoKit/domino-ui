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

/** ResizeColumnMeta class. */
public class ResizeColumnMeta implements ComponentMeta {

  /** Constant <code>RESIZE_COLUMN_META="resize-column-meta"</code> */
  public static final String RESIZE_COLUMN_META = "resize-column-meta";

  private double initialWidth;
  private double startPosition;
  private boolean resizable = true;

  private String originalWidth;
  private String originalMinWidth;
  private String originalMaxWidth;

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta} object
   */
  public static ResizeColumnMeta create() {
    return new ResizeColumnMeta(true);
  }

  /**
   * create.
   *
   * @param resizable a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta} object
   */
  public static ResizeColumnMeta create(boolean resizable) {
    return new ResizeColumnMeta(resizable);
  }

  /**
   * Constructor for ResizeColumnMeta.
   *
   * @param resizable a boolean
   */
  public ResizeColumnMeta(boolean resizable) {
    this.resizable = resizable;
  }

  /**
   * Getter for the field <code>initialWidth</code>.
   *
   * @return a double
   */
  public double getInitialWidth() {
    return initialWidth;
  }

  /**
   * Setter for the field <code>initialWidth</code>.
   *
   * @param initialWidth a double
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta} object
   */
  public ResizeColumnMeta setInitialWidth(double initialWidth) {
    this.initialWidth = initialWidth;
    return this;
  }

  /**
   * Getter for the field <code>startPosition</code>.
   *
   * @return a double
   */
  public double getStartPosition() {
    return startPosition;
  }

  /**
   * Setter for the field <code>startPosition</code>.
   *
   * @param startPosition a double
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta} object
   */
  public ResizeColumnMeta setStartPosition(double startPosition) {
    this.startPosition = startPosition;
    return this;
  }

  /**
   * isResizable.
   *
   * @return a boolean
   */
  public boolean isResizable() {
    return resizable;
  }

  /**
   * Setter for the field <code>resizable</code>.
   *
   * @param resizable a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta} object
   */
  public ResizeColumnMeta setResizable(boolean resizable) {
    this.resizable = resizable;
    return this;
  }

  /**
   * Getter for the field <code>originalWidth</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getOriginalWidth() {
    return originalWidth;
  }

  /**
   * Setter for the field <code>originalWidth</code>.
   *
   * @param originalWidth a {@link java.lang.String} object
   */
  public void setOriginalWidth(String originalWidth) {
    this.originalWidth = originalWidth;
  }

  /**
   * Getter for the field <code>originalMinWidth</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getOriginalMinWidth() {
    return originalMinWidth;
  }

  /**
   * Setter for the field <code>originalMinWidth</code>.
   *
   * @param originalMinWidth a {@link java.lang.String} object
   */
  public void setOriginalMinWidth(String originalMinWidth) {
    this.originalMinWidth = originalMinWidth;
  }

  /**
   * Getter for the field <code>originalMaxWidth</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getOriginalMaxWidth() {
    return originalMaxWidth;
  }

  /**
   * Setter for the field <code>originalMaxWidth</code>.
   *
   * @param originalMaxWidth a {@link java.lang.String} object
   */
  public void setOriginalMaxWidth(String originalMaxWidth) {
    this.originalMaxWidth = originalMaxWidth;
  }

  /**
   * suppliedMaxWidthOrOriginal.
   *
   * @param maxWidth a {@link java.lang.String} object
   * @return a {@link java.lang.String} object
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
   * suppliedMinWidthOrOriginal.
   *
   * @param minWidth a {@link java.lang.String} object
   * @return a {@link java.lang.String} object
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

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return RESIZE_COLUMN_META;
  }

  /**
   * get.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @return a {@link java.util.Optional} object
   */
  public static Optional<ResizeColumnMeta> get(ColumnConfig<?> column) {
    return column.getMeta(RESIZE_COLUMN_META);
  }
}
