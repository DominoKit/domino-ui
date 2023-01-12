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
package org.dominokit.domino.ui.modals;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.DominoElement.body;

import java.util.*;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.IsPopup;

public class DefaultZIndexManager implements ZIndexManager {

  private Integer currentZIndex;
  private static Deque<IsPopup<?>> modals = new LinkedList<>();

  private final List<ZIndexListener> listeners = new ArrayList<>();

  /**
   * {@inheritDoc}
   *
   * @return The next z-index starting from {@link DominoUIConfig#getInitialZIndex()} and
   *     incremented by {@link DominoUIConfig#getzIndexIncrement()} with every call
   */
  @Override
  public Integer getNextZIndex() {
    if (isNull(currentZIndex)) {
      this.currentZIndex = DominoUIConfig.INSTANCE.getInitialZIndex();
    }
    currentZIndex += DominoUIConfig.INSTANCE.getzIndexIncrement();
    return currentZIndex;
  }

  /**
   * {@inheritDoc} Also attach the modal backdrop if not attached
   *
   * @param popup the popup to be shown next
   */
  @Override
  public void onPopupOpen(IsPopup<?> popup) {
    List<Integer> assignedValues = new ArrayList<>();
    if (popup.isModal()) {
      Integer nextZIndex = getNextZIndex();
      assignedValues.add(nextZIndex);
      ModalBackDrop.INSTANCE.setZIndex(nextZIndex);
      if (!ModalBackDrop.INSTANCE.isAttached()) {
        body().appendChild(ModalBackDrop.INSTANCE);
      }
      modals.push(popup);
    }
    Integer nextZIndex = getNextZIndex();
    popup.setZIndex(nextZIndex);
    assignedValues.add(nextZIndex);
    listeners.forEach(
        listener -> listener.onZIndexChange(assignedValues, ModalBackDrop.INSTANCE.isAttached()));
  }

  /**
   * {@inheritDoc} Also remove the modal backdrop when modal remain open
   *
   * @param popup the popup to be closed
   */
  @Override
  public void onPopupClose(IsPopup<?> popup) {
    List<Integer> assignedValues = new ArrayList<>();
    if (popup.isModal()) {
      modals.remove(popup);
      if (!modals.isEmpty()) {
        Integer backdropZIndex = getNextZIndex();
        assignedValues.add(backdropZIndex);
        ModalBackDrop.INSTANCE.setZIndex(backdropZIndex);
        Integer modalZIndex = getNextZIndex();
        modals.peek().setZIndex(modalZIndex);
        assignedValues.add(modalZIndex);
        listeners.forEach(
            listener ->
                listener.onZIndexChange(assignedValues, ModalBackDrop.INSTANCE.isAttached()));
      } else {
        ModalBackDrop.INSTANCE.remove();
      }
    }
  }

  @Override
  public Optional<IsPopup<?>> getTopLevelModal() {
    return Optional.ofNullable(modals.peek());
  }

  @Override
  public void addZIndexListener(ZIndexListener listener) {
    if (nonNull(listener)) {
      listeners.add(listener);
    }
  }

  @Override
  public void removeZIndexListener(ZIndexListener listener) {
    if (nonNull(listener)) {
      listeners.remove(listener);
    }
  }
}
