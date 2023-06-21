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

/**
 * This event will be fired when the date table bordered is changed
 *
 * <p>{@link org.dominokit.domino.ui.datatable.DataTable#bordered()}
 *
 * <p>{@link org.dominokit.domino.ui.datatable.DataTable#noBorder()}
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TableBorderedEvent implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String TABLE_BORDERED_EVENT = "table-bordered-event";

  private final boolean bordered;

  /**
   * Constructor for TableBorderedEvent.
   *
   * @param bordered a boolean
   */
  public TableBorderedEvent(boolean bordered) {
    this.bordered = bordered;
  }

  /**
   * isBordered.
   *
   * @return a boolean
   */
  public boolean isBordered() {
    return bordered;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return TABLE_BORDERED_EVENT;
  }
}
