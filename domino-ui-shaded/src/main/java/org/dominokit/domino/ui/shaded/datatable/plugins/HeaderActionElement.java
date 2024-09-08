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
package org.dominokit.domino.ui.shaded.datatable.plugins;

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.shaded.datatable.DataTable;
import org.dominokit.domino.ui.shaded.datatable.events.TableEvent;
import org.dominokit.domino.ui.shaded.datatable.events.TableEventListener;
import org.dominokit.domino.ui.shaded.grid.flex.FlexItem;

/**
 * An interface to implement header action elements for the {@link HeaderBarPlugin}
 *
 * @param <T> the type of the data table records
 */
@Deprecated
public interface HeaderActionElement<T> extends TableEventListener {
  /**
   * initialize the element for this action
   *
   * @param dataTable the {@link DataTable} we are attaching the plugin to
   * @return the {@link Node} representing this action element
   */
  Node asElement(DataTable<T> dataTable);

  /** {@inheritDoc} */
  @Override
  default void handleEvent(TableEvent event) {}

  /**
   * Customize the styles for this action container
   *
   * @param container the flex item parent container of this action
   */
  default void applyStyles(FlexItem<? extends HTMLElement> container) {}
}
