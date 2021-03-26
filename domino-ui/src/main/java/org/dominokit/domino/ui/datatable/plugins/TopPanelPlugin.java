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
package org.dominokit.domino.ui.datatable.plugins;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.jboss.elemento.IsElement;

/**
 * This abstract plugin attach custom content to the data table top panel
 *
 * @param <T> the type of the data table records
 */
public abstract class TopPanelPlugin<T> implements DataTablePlugin<T>, IsElement<HTMLElement> {

  /** {@inheritDoc} */
  @Override
  public void onBeforeAddTable(DataTable<T> dataTable) {
    if (nonNull(element())) {
      dataTable.element().appendChild(element());
    }
  }
}
