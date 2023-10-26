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
package org.dominokit.domino.ui.menu;

/**
 * An interface to define search filter logic for menu items in a {@link Menu}.
 *
 * <p><strong>Usage example:</strong>
 *
 * <pre>{@code
 * CustomMenuItem<String> menuItem = CustomMenuItem.create();
 * menuItem.setSearchFilter((token, caseSensitive) -> {
 *     // Your search logic here.
 *     return token.equalsIgnoreCase("example");
 * });
 * }</pre>
 */
public interface MenuSearchFilter {

  /**
   * Evaluates the provided search token against menu items or related content.
   *
   * @param token the search token
   * @param caseSensitive indicates if the search should be case sensitive or not
   * @return true if the search condition is met; false otherwise
   */
  boolean onSearch(String token, boolean caseSensitive);
}
