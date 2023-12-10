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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Node;

/** A functional interface for supplying header elements in a data table. */
@FunctionalInterface
public interface HeaderElementSupplier {

  /**
   * Provides a header element based on the given column title.
   *
   * @param columnTitle The title of the column.
   * @return The header element.
   */
  Node asElement(String columnTitle);
}
