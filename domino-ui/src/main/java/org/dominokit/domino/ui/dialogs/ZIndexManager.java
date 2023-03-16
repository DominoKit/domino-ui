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

import org.dominokit.domino.ui.utils.IsPopup;

import java.util.Deque;
import java.util.Optional;

public interface ZIndexManager {

  /** @return return the next z-index value */
  Integer getNextZIndex();

  /**
   * Whenever a pop is opened this need to be called, the implementation for this should adjust the
   * opened modals and backdrop elements z-index.
   *
   * @param popup the popup to be shown next
   */
  void onPopupOpen(IsPopup<?> popup);

  /**
   * Whenever a pop is closed this need to be called, the implementation for this should adjust the
   * opened modals and backdrop elements z-index.
   *
   * @param popup the popup to be closed
   */
  void onPopupClose(IsPopup<?> popup);

  /** @return The last opened modal popup. */
  Optional<IsPopup<?>> getTopLevelModal();

  /**
   * Adds a new {@link ZIndexListener}
   *
   * @param listener {@link ZIndexListener}
   */
  void addZIndexListener(ZIndexListener listener);

  /**
   * Removes a {@link ZIndexListener}
   *
   * @param listener {@link ZIndexListener}
   */
  void removeZIndexListener(ZIndexListener listener);

  /**
   * A listener to be called when the zIndexManager assign z-index values to different elements, if
   * the {@link #getNextZIndex()} is called more than once from the same context it should return
   * all the assigned z-index values.
   */
  @FunctionalInterface
  interface ZIndexListener {
    void onZIndexChange(ZIndexInfo zIndexInfo);

    class ZIndexInfo {
      private final IsPopup<?> popup;
      private final Deque<IsPopup<?>> modals;

      public ZIndexInfo(IsPopup<?> popup, Deque<IsPopup<?>> modals) {
        this.popup = popup;
        this.modals = modals;
      }

      public IsPopup<?> getPopup() {
        return popup;
      }

      public Deque<IsPopup<?>> getModals() {
        return modals;
      }
    }
  }
}
