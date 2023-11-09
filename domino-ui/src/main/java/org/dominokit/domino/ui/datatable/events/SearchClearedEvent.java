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
 * The {@code SearchClearedEvent} class represents an event that is fired when a search is cleared
 * in a DataTable.
 *
 * @see org.dominokit.domino.ui.datatable.events.TableEvent
 */
public class SearchClearedEvent implements TableEvent {

  /** The event type for the search-cleared event. */
  public static final String SEARCH_EVENT_CLEARED = "table-search-cleared";

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return SEARCH_EVENT_CLEARED;
  }
}
