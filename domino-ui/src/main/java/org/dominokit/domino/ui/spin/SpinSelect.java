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
package org.dominokit.domino.ui.spin;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.spin.SpinStyles.*;
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.SwipeUtil;

/**
 * Abstract implementation for spin
 *
 * @param <T> the type of the object inside the spin
 * @param <S> the type of the spin
 */
abstract class SpinSelect<T, S extends SpinSelect<T, ?>>
    extends BaseDominoElement<HTMLDivElement, S> implements HasSelectionHandler<S, SpinItem<T>> {

  protected DominoElement<HTMLDivElement> element = DominoElement.of(div().css(getStyle()));
  private final DominoElement<HTMLAnchorElement> prevAnchor =
      DominoElement.of(a().css(PREV).css(DISABLED));
  private final DominoElement<HTMLAnchorElement> nextAnchor = DominoElement.of(a().css(NEXT));
  protected DominoElement<HTMLDivElement> contentPanel = DominoElement.of(div().css(SPIN_CONTENT));
  protected DominoElement<HTMLDivElement> main =
      DominoElement.of(div().add(contentPanel).css(SPIN_CONTAINER));
  protected List<SpinItem<T>> items = new ArrayList<>();
  private SpinItem<T> activeItem;
  private final List<HasSelectionHandler.SelectionHandler<SpinItem<T>>> selectionHandlers =
      new ArrayList<>();
  private NavigationHandler navigationHandler = direction -> {};

  SpinSelect(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
    element
        .appendChild(
            prevAnchor.appendChild(
                backIcon
                    .clickable()
                    .addClickListener(
                        evt -> {
                          moveBack();
                          navigationHandler.onNavigate(Direction.BACKWARD);
                        })))
        .appendChild(main)
        .appendChild(
            nextAnchor.appendChild(
                forwardIcon
                    .clickable()
                    .addClickListener(
                        evt -> {
                          moveForward();
                          navigationHandler.onNavigate(Direction.FORWARD);
                        })));
    init((S) this);
    onAttached(mutationRecord -> fixElementsWidth());
    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.RIGHT, main.element(), evt -> moveBack());
    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.LEFT, main.element(), evt -> moveForward());
  }

  /**
   * Move to the next item
   *
   * @return same instance
   */
  public S moveForward() {
    moveToIndex(items.indexOf(this.activeItem) + 1);
    return (S) this;
  }

  /**
   * Move back to the previous item
   *
   * @return same instance
   */
  public S moveBack() {
    moveToIndex(items.indexOf(this.activeItem) - 1);
    return (S) this;
  }

  /**
   * Move to item at a specific index
   *
   * @param targetIndex the index of the item
   * @return same instance
   */
  public S moveToIndex(int targetIndex) {
    if (targetIndex < items.size() && targetIndex >= 0) {
      int activeIndex = items.indexOf(activeItem);
      if (targetIndex != activeIndex) {
        this.activeItem = items.get(targetIndex);
        double offset = (100d / items.size()) * (targetIndex);
        setTransformProperty(offset);
        informSelectionHandlers();
      }
    }

    updateArrowsVisibility();
    return (S) this;
  }

  /**
   * Move to a specific item
   *
   * @param item the {@link SpinItem}
   * @return same instance
   */
  public S moveToItem(SpinItem<T> item) {
    if (items.contains(item)) {
      return moveToIndex(items.indexOf(item));
    }
    return (S) this;
  }

  private void updateArrowsVisibility() {
    if (items.indexOf(this.activeItem) == items.size() - 1) {
      nextAnchor.addCss(DISABLED);
    } else {
      nextAnchor.removeCss(DISABLED);
    }

    if (items.indexOf(this.activeItem) < 1) {
      prevAnchor.addCss(DISABLED);
    } else {
      prevAnchor.removeCss(DISABLED);
    }
  }

  /**
   * Adds a new item
   *
   * @param spinItem A {@link SpinItem} to add
   * @return same instance
   */
  public S appendChild(SpinItem<T> spinItem) {
    if (items.isEmpty()) {
      this.activeItem = spinItem;
    }
    items.add(spinItem);
    contentPanel.appendChild(spinItem);
    return (S) this;
  }

  /** @return the current active item */
  public SpinItem<T> getActiveItem() {
    return activeItem;
  }

  private void informSelectionHandlers() {
    selectionHandlers.forEach(
        spinItemSelectionHandler -> spinItemSelectionHandler.onSelection(this.activeItem));
  }

  /** {@inheritDoc} */
  @Override
  public S addSelectionHandler(SelectionHandler<SpinItem<T>> selectionHandler) {
    selectionHandlers.add(selectionHandler);
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public S removeSelectionHandler(SelectionHandler<SpinItem<T>> selectionHandler) {
    selectionHandlers.remove(selectionHandler);
    return (S) this;
  }

  /** @return All the items */
  public List<SpinItem<T>> getItems() {
    return items;
  }

  /**
   * @param item the {@link SpinItem}
   * @return the index of the item inside the spin
   */
  public int indexOf(SpinItem<T> item) {
    if (items.contains(item)) {
      return items.indexOf(item);
    } else {
      return -1;
    }
  }

  /** @return the total number of items inside the spin */
  public int itemsCount() {
    return items.size();
  }

  /**
   * @param item the {@link SpinItem}
   * @return true if the item is the last item, false otherwise
   */
  public boolean isLastItem(SpinItem<T> item) {
    return items.contains(item) && indexOf(item) == (itemsCount() - 1);
  }

  /**
   * @param item the {@link SpinItem}
   * @return true if the item is the first item, false otherwise
   */
  public boolean isFirstItem(SpinItem<T> item) {
    return items.contains(item) && indexOf(item) == 0;
  }

  /**
   * Move to the first item
   *
   * @return same instance
   */
  public S gotoFirst() {
    moveToIndex(0);
    return (S) this;
  }

  /**
   * Move to the last item
   *
   * @return same instance
   */
  public S gotoLast() {
    moveToIndex(itemsCount() - 1);
    return (S) this;
  }

  /**
   * Adds a handler which will be called when navigating between items
   *
   * @param navigationHandler A {@link NavigationHandler} to add
   * @return same instance
   */
  public S onNavigate(NavigationHandler navigationHandler) {
    if (nonNull(navigationHandler)) {
      this.navigationHandler = navigationHandler;
    }
    return (S) this;
  }

  /** @return the previous element */
  public DominoElement<HTMLAnchorElement> getPrevAnchor() {
    return prevAnchor;
  }

  /** @return the next element */
  public DominoElement<HTMLAnchorElement> getNextAnchor() {
    return nextAnchor;
  }

  /** @return the content panel */
  public DominoElement<HTMLDivElement> getContentPanel() {
    return contentPanel;
  }

  protected abstract void fixElementsWidth();

  protected abstract void setTransformProperty(double offset);

  protected abstract String getStyle();
}
