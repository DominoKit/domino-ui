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

/** This event will be fired when the page of the data table is changed */
public class TablePageChangeEvent implements TableEvent {

  /** A constant string to define a unique type for this event */
  public static final String PAGINATION_EVENT = "table-page-change";

  private final int page;
  private final HasPagination pagination;

  /**
   * @param page int, the new page
   * @param pagination the {@link HasPagination} which is the component that changed the page.
   */
  public TablePageChangeEvent(int page, HasPagination pagination) {
    this.page = page;
    this.pagination = pagination;
  }

  /** @return int, the new page */
  public int getPage() {
    return page;
  }

  /** @return the {@link HasPagination} which is the component that changed the page. */
  public HasPagination getPagination() {
    return pagination;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return PAGINATION_EVENT;
  }
}
