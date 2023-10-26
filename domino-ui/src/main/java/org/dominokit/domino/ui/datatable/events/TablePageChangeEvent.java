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

import org.dominokit.domino.ui.pagination.HasPagination;

/**
 * The {@code TablePageChangeEvent} class represents an event that occurs when the page in a
 * DataTable changes.
 */
public class TablePageChangeEvent implements TableEvent {

  /** The event type for the table page change event. */
  public static final String PAGINATION_EVENT = "table-page-change";

  /** The new page number. */
  private final int page;

  /** The pagination component associated with the DataTable. */
  private final HasPagination pagination;

  /**
   * Constructs a new {@code TablePageChangeEvent} with the specified page number and pagination
   * component.
   *
   * @param page the new page number
   * @param pagination the pagination component associated with the DataTable
   */
  public TablePageChangeEvent(int page, HasPagination pagination) {
    this.page = page;
    this.pagination = pagination;
  }

  /**
   * Gets the new page number.
   *
   * @return the new page number
   */
  public int getPage() {
    return page;
  }

  /**
   * Gets the pagination component associated with the DataTable.
   *
   * @return the pagination component
   */
  public HasPagination getPagination() {
    return pagination;
  }

  /**
   * Retrieves the type of this event.
   *
   * @return the event type
   */
  @Override
  public String getType() {
    return PAGINATION_EVENT;
  }
}
