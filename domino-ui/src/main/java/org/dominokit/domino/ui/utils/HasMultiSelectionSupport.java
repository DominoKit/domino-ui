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
 * The {@code HasMultiSelectionSupport} interface defines methods for enabling or disabling
 * multi-selection support on a component.
 *
 * @param <T> The type of the component that can have multi-selection support.
 */
public interface HasMultiSelectionSupport<T extends HasMultiSelectionSupport<T>> {

  /**
   * Checks if multi-selection is enabled for the component.
   *
   * @return {@code true} if multi-selection is enabled, {@code false} otherwise.
   */
  boolean isMultiSelect();

  /**
   * Sets the multi-selection support for the component.
   *
   * @param multiSelect {@code true} to enable multi-selection, {@code false} to disable it.
   * @return The component with multi-selection support set.
   */
  T setMultiSelect(boolean multiSelect);
}
