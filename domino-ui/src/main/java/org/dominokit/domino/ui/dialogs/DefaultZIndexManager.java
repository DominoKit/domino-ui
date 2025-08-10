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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.utils.HasZIndexLayer;
import org.dominokit.domino.ui.utils.IsPopup;

/**
 * Default implementation of the {@link ZIndexManager} for managing z-index values of popups and
 * modals. It provides utilities for handling stacking order to ensure the correct display of
 * overlay components.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * DefaultZIndexManager.INSTANCE.onPopupOpen(somePopup);
 * </pre>
 */
public class DefaultZIndexManager implements ZIndexManager, HasComponentConfig<ZIndexConfig> {

  /** A singleton instance of {@link DefaultZIndexManager}. */
  public static final ZIndexManager INSTANCE = new DefaultZIndexManager();

  private Integer currentZIndex;
  private static Deque<IsPopup<?>> modals = new LinkedList<>();

  private final List<ZIndexListener> listeners = new ArrayList<>();
  private Map<HasZIndexLayer.ZIndexLayer, Integer> counters = new HashMap<>();

  @Override
  public Integer nextIndex(HasZIndexLayer.ZIndexLayer layer) {
    return getZIndex(layer);
  }

  /**
   * Calculates and returns the next z-index value.
   *
   * @return the next z-index value
   */
  @Override
  public Integer getNextZIndex(HasZIndexLayer<?> element) {
    HasZIndexLayer.ZIndexLayer layer = element.getZIndexLayer();
    int nextZIndex = getZIndex(layer);
    if (element.incrementsZIndex()) {
      ZIndexConfig config = getConfig();
      nextZIndex = counters.get(layer) + config.getzIndexIncrement();
      counters.put(layer, nextZIndex);
    }
    return nextZIndex;
  }

  private Integer getZIndex(HasZIndexLayer.ZIndexLayer layer) {
    if (isNull(layer)) {
      layer = HasZIndexLayer.ZIndexLayer.Z_LAYER_1;
    }
    if (!counters.containsKey(layer)) {
      counters.put(layer, layer.getzIndexOffset() + getConfig().getInitialZIndex());
    }
    return counters.get(layer);
  }

  /**
   * Handler for when a popup is opened. Adjusts z-index values and ensures modals are correctly
   * stacked.
   *
   * @param popup the popup that was opened
   */
  @Override
  public void onPopupOpen(IsPopup<?> popup) {
    if (popup.isModal()) {
      Integer nextZIndex = getNextZIndex(popup);
      ModalBackDrop.INSTANCE.setZIndex(nextZIndex);
      if (!ModalBackDrop.INSTANCE.isAttached()) {
        elements.body().appendChild(ModalBackDrop.INSTANCE);
      }
      modals.push(popup);
    }

    Integer next = getNextZIndex(popup);
    popup.setZIndex(next);
    popup.setZIndexLayer(popup.getZIndexLayer());
    listeners.forEach(
        listener -> listener.onZIndexChange(new ZIndexListener.ZIndexInfo(popup, modals)));
  }

  /**
   * Handler for when a popup is closed. Adjusts z-index values and updates modal stacking.
   *
   * @param popup the popup that was closed
   */
  @Override
  public void onPopupClose(IsPopup<?> popup) {
    if (popup.isModal()) {
      modals.remove(popup);
      if (!modals.isEmpty()) {
        Integer backdropZIndex = getNextZIndex(popup);
        ModalBackDrop.INSTANCE.setZIndex(backdropZIndex);
        Integer modalZIndex = getNextZIndex(popup);
        modals.peek().setZIndex(modalZIndex);
        listeners.forEach(
            listener ->
                listener.onZIndexChange(new ZIndexListener.ZIndexInfo(modals.peek(), modals)));
      } else {
        ModalBackDrop.INSTANCE.remove();
      }
    } else {
      popup.resetZIndexLayer();
    }
  }

  /**
   * Returns the top level modal if any.
   *
   * @return an {@link Optional} containing the top level modal, or empty if none exists
   */
  @Override
  public Optional<IsPopup<?>> getTopLevelModal() {
    return Optional.ofNullable(modals.peek());
  }

  /**
   * Adds a listener to be notified of z-index changes.
   *
   * @param listener the {@link ZIndexListener} to add
   */
  @Override
  public void addZIndexListener(ZIndexListener listener) {
    if (nonNull(listener)) {
      listeners.add(listener);
    }
  }

  /**
   * Removes a z-index change listener.
   *
   * @param listener the {@link ZIndexListener} to remove
   */
  @Override
  public void removeZIndexListener(ZIndexListener listener) {
    if (nonNull(listener)) {
      listeners.remove(listener);
    }
  }
}
