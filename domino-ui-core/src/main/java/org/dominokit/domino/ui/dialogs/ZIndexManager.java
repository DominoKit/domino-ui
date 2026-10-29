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
package org.dominokit.domino.ui.dialogs;

import java.util.Deque;
import java.util.Optional;
import org.dominokit.domino.ui.utils.HasZIndexLayer;
import org.dominokit.domino.ui.utils.IsPopup;

/**
 * Manages z-index values and the order of popups within an application.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * ZIndexManager manager = ...; // Obtain an implementation
 * manager.onPopupOpen(myPopup);
 * Integer zIndex = manager.getNextZIndex();
 * }</pre>
 */
public interface ZIndexManager {

  Integer nextIndex(HasZIndexLayer.ZIndexLayer layer);

  /**
   * Returns the next available z-index value.
   *
   * @return the next z-index
   */
  Integer getNextZIndex(HasZIndexLayer<?> element);

  /**
   * Notifies the manager that a popup has been opened.
   *
   * @param popup the opened popup
   */
  void onPopupOpen(IsPopup<?> popup);

  /**
   * Notifies the manager that a popup has been closed.
   *
   * @param popup the closed popup
   */
  void onPopupClose(IsPopup<?> popup);

  /**
   * Retrieves the top-level modal currently managed.
   *
   * @return an optional top-level modal
   */
  Optional<IsPopup<?>> getTopLevelModal();

  /**
   * Adds a listener to observe z-index changes.
   *
   * @param listener the listener to add
   */
  void addZIndexListener(ZIndexListener listener);

  /**
   * Removes a z-index change listener.
   *
   * @param listener the listener to remove
   */
  void removeZIndexListener(ZIndexListener listener);

  /** Functional interface for listening to changes in z-index values. */
  @FunctionalInterface
  interface ZIndexListener {

    /**
     * Callback method for when the z-index changes.
     *
     * @param zIndexInfo the information regarding the z-index change
     */
    void onZIndexChange(ZIndexInfo zIndexInfo);

    /** Class to provide information about a z-index change event. */
    class ZIndexInfo {
      private final IsPopup<?> popup;
      private final Deque<IsPopup<?>> modals;

      /**
       * Constructs a ZIndexInfo instance.
       *
       * @param popup the popup related to the event
       * @param modals the modals currently being managed
       */
      public ZIndexInfo(IsPopup<?> popup, Deque<IsPopup<?>> modals) {
        this.popup = popup;
        this.modals = modals;
      }

      /**
       * Returns the popup related to the z-index change event.
       *
       * @return the popup
       */
      public IsPopup<?> getPopup() {
        return popup;
      }

      /**
       * Returns the list of modals currently being managed.
       *
       * @return the modals
       */
      public Deque<IsPopup<?>> getModals() {
        return modals;
      }
    }
  }
}
