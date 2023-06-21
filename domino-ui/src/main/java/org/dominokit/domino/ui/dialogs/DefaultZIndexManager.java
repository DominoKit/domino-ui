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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.utils.IsPopup;

/**
 * DefaultZIndexManager class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class DefaultZIndexManager implements ZIndexManager, HasComponentConfig<ZIndexConfig> {

  /** Constant <code>INSTANCE</code> */
  public static final ZIndexManager INSTANCE = new DefaultZIndexManager();

  private Integer currentZIndex;
  private static Deque<IsPopup<?>> modals = new LinkedList<>();

  private final List<ZIndexListener> listeners = new ArrayList<>();

  /** {@inheritDoc} */
  @Override
  public Integer getNextZIndex() {
    if (isNull(currentZIndex)) {
      this.currentZIndex = getConfig().getInitialZIndex();
    }
    currentZIndex += getConfig().getzIndexIncrement();
    return currentZIndex;
  }

  /** {@inheritDoc} Also attach the modal backdrop if not attached */
  @Override
  public void onPopupOpen(IsPopup<?> popup) {
    if (popup.isModal()) {
      Integer nextZIndex = getNextZIndex();
      ModalBackDrop.INSTANCE.setZIndex(nextZIndex);
      if (!ModalBackDrop.INSTANCE.isAttached()) {
        elements.body().appendChild(ModalBackDrop.INSTANCE);
      }
      modals.push(popup);
    }

    Integer next = getNextZIndex();
    popup.setZIndex(next);
    listeners.forEach(
        listener -> listener.onZIndexChange(new ZIndexListener.ZIndexInfo(popup, modals)));
  }

  /** {@inheritDoc} Also remove the modal backdrop when modal remain open */
  @Override
  public void onPopupClose(IsPopup<?> popup) {
    if (popup.isModal()) {
      modals.remove(popup);
      if (!modals.isEmpty()) {
        Integer backdropZIndex = getNextZIndex();
        ModalBackDrop.INSTANCE.setZIndex(backdropZIndex);
        Integer modalZIndex = getNextZIndex();
        modals.peek().setZIndex(modalZIndex);
        listeners.forEach(
            listener ->
                listener.onZIndexChange(new ZIndexListener.ZIndexInfo(modals.peek(), modals)));
      } else {
        ModalBackDrop.INSTANCE.remove();
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  public Optional<IsPopup<?>> getTopLevelModal() {
    return Optional.ofNullable(modals.peek());
  }

  /** {@inheritDoc} */
  @Override
  public void addZIndexListener(ZIndexListener listener) {
    if (nonNull(listener)) {
      listeners.add(listener);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void removeZIndexListener(ZIndexListener listener) {
    if (nonNull(listener)) {
      listeners.remove(listener);
    }
  }
}
