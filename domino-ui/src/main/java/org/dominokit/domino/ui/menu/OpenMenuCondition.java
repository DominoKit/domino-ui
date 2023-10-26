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
 * Functional interface for defining a condition under which a menu should be opened.
 *
 * <p>This interface allows for custom logic to decide whether a menu should be opened or not. For
 * example, you can conditionally prevent a menu from opening based on certain criteria. Usage:
 *
 * <pre>{@code
 * menu.setOpenCondition(menuInstance -> {
 *   // Open menu only if a certain condition is met
 *   return someConditionCheck();
 * });
 * }</pre>
 *
 * @param <V> The type of the item's value in the menu
 */
public interface OpenMenuCondition<V> {

  /**
   * This method is invoked to check whether the menu should be opened.
   *
   * @param menu The menu for which the condition is being checked
   * @return {@code true} if the menu should be opened, {@code false} otherwise
   */
  boolean check(Menu<V> menu);
}
