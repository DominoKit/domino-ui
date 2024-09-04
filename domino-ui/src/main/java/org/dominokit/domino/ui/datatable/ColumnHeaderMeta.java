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

import elemental2.dom.HTMLTableCellElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoElement;

public class ColumnHeaderMeta implements ComponentMeta {

  public static final String DOMINO_COLUMN_HEADER_META = "domino-column-header-meta";

  private List<DominoElement<HTMLTableCellElement>> extraHeadElements = new ArrayList<>();

  public static ColumnHeaderMeta create() {
    return new ColumnHeaderMeta();
  }

  @Override
  public String getKey() {
    return DOMINO_COLUMN_HEADER_META;
  }

  public static Optional<ColumnHeaderMeta> get(ColumnConfig<?> column) {
    return column.getMeta(DOMINO_COLUMN_HEADER_META);
  }

  public List<DominoElement<HTMLTableCellElement>> getExtraHeadElements() {
    return extraHeadElements;
  }

  public ColumnHeaderMeta addExtraHeadElement(
      DominoElement<HTMLTableCellElement> extraHeadElement) {
    this.extraHeadElements.add(extraHeadElement);
    return this;
  }
}
