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
package org.dominokit.domino.ui.datatable.events;

import org.dominokit.domino.ui.datatable.ColumnConfig;

/**
 * This event will be fired when a column gets resized
 *
 * <p>Event type: <b>COLUMN_RESIZED -> 'column-resized'</b>
 */
public class ColumnResizedEvent implements TableEvent {
  /** Constant <code>COLUMN_RESIZED="column-resized"</code> */
  public static final String COLUMN_RESIZED = "column-resized";

  private final ColumnConfig<?> column;
  private final double sizeDiff;
  private final boolean completed;

  /**
   * Factory method to create a new Event instance
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   * @param sizeDiff a double
   * @return a {@link org.dominokit.domino.ui.datatable.events.ColumnResizedEvent}
   */
  public static ColumnResizedEvent of(ColumnConfig<?> column, double sizeDiff) {
    return new ColumnResizedEvent(column, sizeDiff);
  }

  /**
   * Factory method to create a new Event instance
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   * @param sizeDiff a double
   * @param completed a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.events.ColumnResizedEvent}
   */
  public static ColumnResizedEvent of(ColumnConfig<?> column, double sizeDiff, boolean completed) {
    return new ColumnResizedEvent(column, sizeDiff, completed);
  }

  /**
   * Creates a new Event instance
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   * @param sizeDiff a double
   */
  public ColumnResizedEvent(ColumnConfig<?> column, double sizeDiff) {
    this(column, sizeDiff, false);
  }

  /**
   * Creates a new Event instance
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   * @param sizeDiff a double
   * @param completed a boolean
   */
  public ColumnResizedEvent(ColumnConfig<?> column, double sizeDiff, boolean completed) {
    this.column = column;
    this.sizeDiff = sizeDiff;
    this.completed = completed;
  }

  /**
   * Getter for the field <code>column</code>.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnConfig}
   */
  public ColumnConfig<?> getColumn() {
    return column;
  }

  /**
   * Getter for the field <code>sizeDiff</code>.
   *
   * @return a double
   */
  public double getSizeDiff() {
    return sizeDiff;
  }

  /**
   * isCompleted.
   *
   * @return a boolean
   */
  public boolean isCompleted() {
    return completed;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return COLUMN_RESIZED;
  }
}
