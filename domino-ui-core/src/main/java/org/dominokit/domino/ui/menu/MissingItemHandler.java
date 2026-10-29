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
 * Functional interface for handling cases when a specific item is not found in a menu.
 *
 * <p>For example, you might use this to provide custom actions when a search in a menu doesn't
 * yield results. Usage:
 *
 * <pre>
 * menu.setMissingItemHandler((token, menu) -> {
 *   // Handle missing item, e.g., show a message or an option to create a new entry
 * });
 * </pre>
 *
 * @param <T> The type of the item's value in the menu
 */
@FunctionalInterface
public interface MissingItemHandler<T, C> {

  /**
   * This method is invoked when an item is not found in the menu.
   *
   * @param token The search token or identifier for the missing item
   * @param menu The menu where the search was conducted
   */
  void onMissingItem(String token, C menu);
}
