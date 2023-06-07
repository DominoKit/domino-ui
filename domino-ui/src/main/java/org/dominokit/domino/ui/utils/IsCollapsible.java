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
 * A component that can be shown/hidden should implement this interface
 *
 * @see org.dominokit.domino.ui.collapsible.Collapsible
 * @param <T> the type of the component implementing this interface
 */
public interface IsCollapsible<T> {

  /**
   * Show the component
   *
   * @return same component instance
   */
  T expand();

  /**
   * Hides the component
   *
   * @return same component instance
   */
  T collapse();

  /**
   * if the component is visible then hide it, otherwise show it
   *
   * @return same component instance
   */
  T toggleCollapse();

  /**
   * Show/hides the component based on the provided flag
   *
   * @param state boolean, if true show the component, if false hide it
   * @return same component instance
   */
  T toggleCollapse(boolean state);

  /** @return boolean, true if the component is collapsed */
  boolean isCollapsed();

  /** @return boolean, true if the component is expanded */
  default boolean isExpanded() {
    return !isCollapsed();
  }
}
