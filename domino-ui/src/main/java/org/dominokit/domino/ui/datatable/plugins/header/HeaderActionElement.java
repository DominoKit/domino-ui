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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Element;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.events.TableEventListener;

/**
 * An interface for defining elements that can be used as actions in the header of a DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public interface HeaderActionElement<T> extends TableEventListener {

  /**
   * Converts the header action element into an HTML element.
   *
   * @param dataTable The DataTable to which this header action belongs.
   * @return The HTML element representing the header action.
   */
  Element asElement(DataTable<T> dataTable);

  /**
   * {@inheritDoc}
   *
   * <p>This default implementation does nothing when handling table events.
   *
   * @param event The table event to handle.
   */
  @Override
  default void handleEvent(TableEvent event) {}

  /**
   * Apply additional styles to the container element if needed.
   *
   * @param container The container element to which styles can be applied.
   */
  default void applyStyles(Element container) {}
}
