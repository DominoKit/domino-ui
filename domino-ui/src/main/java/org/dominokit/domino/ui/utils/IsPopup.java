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
 * An interface representing a popup component that can be opened and closed.
 *
 * @param <T> The type of the component that implements this interface.
 */
public interface IsPopup<T> {

  /**
   * Opens the popup.
   *
   * @return The component instance after opening.
   */
  T open();

  /**
   * Closes the popup.
   *
   * @return The component instance after closing.
   */
  T close();

  /**
   * Checks if the popup is modal.
   *
   * @return {@code true} if the popup is modal, {@code false} otherwise.
   */
  boolean isModal();

  /**
   * Checks if the popup is set to auto-close.
   *
   * @return {@code true} if auto-close is enabled, {@code false} otherwise.
   */
  boolean isAutoClose();

  /**
   * Checks if the popup is a dialog.
   *
   * @return {@code true} if the popup is a dialog, {@code false} otherwise.
   */
  default boolean isDialog() {
    return false;
  }

  /**
   * Sets the z-index of the popup.
   *
   * @param zIndex The z-index value to set.
   * @return The component instance after setting the z-index.
   */
  T setZIndex(int zIndex);

  /**
   * Gets the current z-index of the popup.
   *
   * @return The current z-index value.
   */
  int getZIndex();

  /**
   * Steals focus for the popup. This method is empty by default and can be overridden by
   * implementing classes.
   */
  default void stealFocus() {}
}
