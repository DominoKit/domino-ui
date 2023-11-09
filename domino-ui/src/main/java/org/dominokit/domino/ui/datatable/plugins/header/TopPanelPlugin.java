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

package org.dominokit.domino.ui.datatable.plugins.header;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;

/**
 * An abstract class that provides a plugin mechanism for adding a top panel element to a DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public abstract class TopPanelPlugin<T> implements DataTablePlugin<T>, IsElement<HTMLElement> {

  /**
   * {@inheritDoc}
   *
   * <p>This method is called before adding the DataTable to the DOM. It appends the top panel
   * element, if not null, to the DataTable's element.
   *
   * @param dataTable The DataTable to which this top panel belongs.
   */
  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    if (nonNull(element())) {
      dataTable.element().appendChild(element());
    }
  }
}
