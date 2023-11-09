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
 * The {@code TableBorderedEvent} class represents an event that occurs when toggling the border of
 * a DataTable.
 */
public class TableBorderedEvent implements TableEvent {

  /** The event type for the table bordered event. */
  public static final String TABLE_BORDERED_EVENT = "table-bordered-event";

  /** A flag indicating whether the table is bordered or not. */
  private final boolean bordered;

  /**
   * Constructs a new {@code TableBorderedEvent} with the specified bordered flag.
   *
   * @param bordered {@code true} if the table should have borders, {@code false} otherwise
   */
  public TableBorderedEvent(boolean bordered) {
    this.bordered = bordered;
  }

  /**
   * Checks if the table is bordered.
   *
   * @return {@code true} if the table is bordered, {@code false} otherwise
   */
  public boolean isBordered() {
    return bordered;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return TABLE_BORDERED_EVENT;
  }
}
