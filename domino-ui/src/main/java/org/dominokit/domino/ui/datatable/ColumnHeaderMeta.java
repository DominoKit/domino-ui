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
 * ColumnHeaderMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ColumnHeaderMeta implements ComponentMeta {

  /** Constant <code>DOMINO_COLUMN_HEADER_META="domino-column-header-meta"</code> */
  public static final String DOMINO_COLUMN_HEADER_META = "domino-column-header-meta";

  private List<ColumnHeader> extraHeadElements = new ArrayList<>();

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeaderMeta} object
   */
  public static ColumnHeaderMeta create() {
    return new ColumnHeaderMeta();
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return DOMINO_COLUMN_HEADER_META;
  }

  /**
   * get.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @return a {@link java.util.Optional} object
   */
  public static Optional<ColumnHeaderMeta> get(ColumnConfig<?> column) {
    return column.getMeta(DOMINO_COLUMN_HEADER_META);
  }

  /**
   * Getter for the field <code>extraHeadElements</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<ColumnHeader> getExtraHeadElements() {
    return extraHeadElements;
  }

  /**
   * addExtraHeadElement.
   *
   * @param extraHeadElement a {@link org.dominokit.domino.ui.datatable.ColumnHeader} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnHeaderMeta} object
   */
  public ColumnHeaderMeta addExtraHeadElement(ColumnHeader extraHeadElement) {
    this.extraHeadElements.add(extraHeadElement);
    return this;
  }
}
