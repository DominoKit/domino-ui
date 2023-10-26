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

package org.dominokit.domino.ui.utils;

/**
 * An interface representing a collapsible component that can be expanded or collapsed.
 *
 * @param <T> The type of the component that implements this interface.
 */
public interface IsCollapsible<T> {

  /**
   * Expands the collapsible component, making its content visible.
   *
   * @return The component instance after expansion.
   */
  T expand();

  /**
   * Collapses the collapsible component, hiding its content.
   *
   * @return The component instance after collapse.
   */
  T collapse();

  /**
   * Toggles the collapse/expand state of the component.
   *
   * @return The component instance after toggling.
   */
  T toggleCollapse();

  /**
   * Sets the collapse/expand state of the component based on the provided state.
   *
   * @param state {@code true} to collapse, {@code false} to expand.
   * @return The component instance after setting the state.
   */
  T toggleCollapse(boolean state);

  /**
   * Checks if the component is currently in a collapsed state.
   *
   * @return {@code true} if collapsed, {@code false} if expanded.
   */
  boolean isCollapsed();

  /**
   * Checks if the component is currently in an expanded state.
   *
   * @return {@code true} if expanded, {@code false} if collapsed.
   */
  default boolean isExpanded() {
    return !isCollapsed();
  }
}
