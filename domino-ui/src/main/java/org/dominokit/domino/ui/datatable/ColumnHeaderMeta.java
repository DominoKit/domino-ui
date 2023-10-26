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
package org.dominokit.domino.ui.datatable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * Meta information for column headers in a data table. This class allows adding and retrieving
 * additional column headers to be displayed in the table header.
 */
public class ColumnHeaderMeta implements ComponentMeta {

  /** The key used for identifying the column header meta information. */
  public static final String DOMINO_COLUMN_HEADER_META = "domino-column-header-meta";

  private List<ColumnHeader> extraHeadElements = new ArrayList<>();

  /**
   * Creates a new {@link ColumnHeaderMeta} instance.
   *
   * @return The created {@link ColumnHeaderMeta} instance.
   */
  public static ColumnHeaderMeta create() {
    return new ColumnHeaderMeta();
  }

  /**
   * Retrieves the key used for identifying this component's meta information.
   *
   * @return The meta information key.
   */
  @Override
  public String getKey() {
    return DOMINO_COLUMN_HEADER_META;
  }

  /**
   * Retrieves the column header meta information associated with a specific column.
   *
   * @param column The column for which to retrieve the header meta information.
   * @return An optional {@link ColumnHeaderMeta} instance if available, otherwise an empty
   *     optional.
   */
  public static Optional<ColumnHeaderMeta> get(ColumnConfig<?> column) {
    return column.getMeta(DOMINO_COLUMN_HEADER_META);
  }

  /**
   * Retrieves a list of additional column header elements.
   *
   * @return A list of {@link ColumnHeader} instances representing additional column headers.
   */
  public List<ColumnHeader> getExtraHeadElements() {
    return extraHeadElements;
  }

  /**
   * Adds an additional column header element to the meta information.
   *
   * @param extraHeadElement The {@link ColumnHeader} to add.
   * @return The current {@link ColumnHeaderMeta} instance.
   */
  public ColumnHeaderMeta addExtraHeadElement(ColumnHeader extraHeadElement) {
    this.extraHeadElements.add(extraHeadElement);
    return this;
  }
}
