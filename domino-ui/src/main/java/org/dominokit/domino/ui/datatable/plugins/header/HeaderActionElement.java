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

import elemental2.dom.Element;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;

/**
 * An interface to implement header action elements for the {@link
 * org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin}
 *
 * @param <T> the type of the data table records
 */
public interface HeaderActionElement<T> extends TableEventListener {
  /**
   * initialize the element for this action
   *
   * @param dataTable the {@link org.dominokit.domino.ui.datatable.DataTable} we are attaching the
   *     plugin to
   * @return the {@link elemental2.dom.Node} representing this action element
   */
  Element asElement(DataTable<T> dataTable);

  /** {@inheritDoc} */
  @Override
  default void handleEvent(TableEvent event) {}

  /**
   * Customize the styles for this action container
   *
   * @param container the flex item parent container of this action
   */
  default void applyStyles(Element container) {}
}
