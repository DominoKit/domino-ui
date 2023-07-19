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

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.SpinConfig;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasChangeListeners;

/**
 * Abstract implementation for spin
 *
 * @param <T> the type of the object inside the spin
 * @param <S> the type of the spin
 */
abstract class SpinSelect<T, S extends SpinSelect<T, S>>
    extends BaseDominoElement<HTMLDivElement, S>
    implements SpinStyles, HasChangeListeners<S, T>, HasComponentConfig<SpinConfig> {

  private final Icon<?> backIcon;
  private final Icon<?> forwardIcon;

  protected DivElement root;
  private final AnchorElement prevAnchor;
  private final AnchorElement nextAnchor;
  protected DivElement contentPanel;
  protected List<SpinItem<T>> items = new ArrayList<>();
  private SpinItem<T> activeItem;
  private T oldValue;
  private boolean changeListenersPaused;
  private final Set<ChangeListener<? super T>> changeListeners = new HashSet<>();
  private SwapCssClass exitCss = SwapCssClass.of();
  private EventListener clearAnimation;

  SpinSelect(Icon<?> backIcon, Icon<?> forwardIcon) {
    this.backIcon = backIcon;
    this.forwardIcon = forwardIcon;
    root =
        div()
            .addCss(dui_spin)
            .appendChild(
                prevAnchor =
                    a().addCss(dui_spin_prev, dui_disabled)
                        .appendChild(
                            backIcon.addCss(dui_clickable).addClickListener(evt -> moveBack())))
            .appendChild(contentPanel = div().addCss(dui_spin_content))
            .appendChild(
                nextAnchor =
                    a().addCss(dui_spin_next)
                        .appendChild(
                            forwardIcon
                                .addCss(dui_clickable)
                                .addClickListener(evt -> moveForward())));

    init((S) this);
    addCss(() -> "dui-spin-exit-right");
    clearAnimation =
        evt -> {
          removeCss("dui-spin-animate");
        };
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
    this.oldValue = getValue();
    if (targetIndex < items.size() && targetIndex >= 0) {
      int activeIndex = items.indexOf(activeItem);
      if (targetIndex != activeIndex) {
        SpinItem<T> next = items.get(targetIndex);
        if (items.indexOf(next) > indexOf(this.activeItem)) {
          addCss(exitCss.replaceWith(dui_spin_exit_forward));
        } else {
          addCss(exitCss.replaceWith(dui_spin_exit_backward));
        }
        this.activeItem.addCss(spinExiting);
        next.addCss(spinActivating);
        DomGlobal.setTimeout(
            p0 -> {
              addCss(dui_spin_animate);
              this.activeItem.removeCss(dui_active);
              next.addCss(dui_active);
              this.activeItem = next;
              updateArrowsVisibility();
              triggerChangeListeners(oldValue, getValue());
            },
            0);
      }
    }
    return (S) this;
  }

  /**
   * Move to a specific item
   *
   * @param item the {@link org.dominokit.domino.ui.spin.SpinItem}
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
      nextAnchor.addCss(dui_disabled);
      nextAnchor.disable();
    } else {
      nextAnchor.removeCss(dui_disabled);
      nextAnchor.enable();
    }

    if (items.indexOf(this.activeItem) < 1) {
      prevAnchor.addCss(dui_disabled);
      prevAnchor.disable();
    } else {
      prevAnchor.removeCss(dui_disabled);
      prevAnchor.enable();
    }
  }

  /** {@inheritDoc} */
  @Override
  public S pauseChangeListeners() {
    this.changeListenersPaused = true;
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public S resumeChangeListeners() {
    this.changeListenersPaused = false;
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public S togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return (S) this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<ChangeListener<? super T>> getChangeListeners() {
    return this.changeListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public S triggerChangeListeners(T oldValue, T newValue) {
    if (!isChangeListenersPaused()) {
      changeListeners.forEach(
          changeListener ->
              changeListener.onValueChanged(
                  oldValue,
                  Optional.ofNullable(getActiveItem()).map(SpinItem::getValue).orElse(null)));
    }
    return (S) this;
  }

  /**
   * Adds a new item
   *
   * @param spinItem A {@link org.dominokit.domino.ui.spin.SpinItem} to add
   * @return same instance
   */
  public S appendChild(SpinItem<T> spinItem) {
    if (nonNull(spinItem)) {
      if (items.isEmpty()) {
        this.activeItem = spinItem;
        this.activeItem.addCss(dui_active);
      }
      items.add(spinItem);
      spinItem.addEventListener("transitionend", clearAnimation);
      contentPanel.appendChild(spinItem);
      updateArrowsVisibility();
    }
    return (S) this;
  }

  /**
   * Adds a new item
   *
   * @param spinItem A {@link org.dominokit.domino.ui.spin.SpinItem} to add
   * @return same instance
   */
  public S prependChild(SpinItem<T> spinItem) {
    if (nonNull(spinItem)) {
      if (items.isEmpty()) {
        this.activeItem = spinItem;
        this.activeItem.addCss(dui_active);
      }
      items.add(0, spinItem);
      spinItem.addEventListener("transitionend", clearAnimation);
      contentPanel.insertFirst(spinItem);
      updateArrowsVisibility();
    }
    return (S) this;
  }

  /**
   * reset.
   *
   * @return a S object
   */
  public S reset() {
    getItems().forEach(BaseDominoElement::remove);
    this.getItems().clear();
    this.activeItem = null;
    this.oldValue = null;
    return (S) this;
  }

  /** @return the current active item */
  /**
   * Getter for the field <code>activeItem</code>.
   *
   * @return a {@link org.dominokit.domino.ui.spin.SpinItem} object
   */
  public SpinItem<T> getActiveItem() {
    return activeItem;
  }

  /** @return All the items */
  /**
   * Getter for the field <code>items</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<SpinItem<T>> getItems() {
    return items;
  }

  /**
   * indexOf.
   *
   * @param item the {@link org.dominokit.domino.ui.spin.SpinItem}
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
  /**
   * itemsCount.
   *
   * @return a int
   */
  public int itemsCount() {
    return items.size();
  }

  /**
   * isLastItem.
   *
   * @param item the {@link org.dominokit.domino.ui.spin.SpinItem}
   * @return true if the item is the last item, false otherwise
   */
  public boolean isLastItem(SpinItem<T> item) {
    return items.contains(item) && indexOf(item) == (itemsCount() - 1);
  }

  /**
   * isFirstItem.
   *
   * @param item the {@link org.dominokit.domino.ui.spin.SpinItem}
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

  /** @return the previous element */
  /**
   * Getter for the field <code>prevAnchor</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AnchorElement} object
   */
  public AnchorElement getPrevAnchor() {
    return prevAnchor;
  }

  /** @return the next element */
  /**
   * Getter for the field <code>nextAnchor</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AnchorElement} object
   */
  public AnchorElement getNextAnchor() {
    return nextAnchor;
  }

  /** @return the content panel */
  /**
   * Getter for the field <code>contentPanel</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getContentPanel() {
    return contentPanel;
  }

  /**
   * getValue.
   *
   * @return a T object
   */
  public T getValue() {
    return Optional.ofNullable(activeItem).map(SpinItem::getValue).orElse(null);
  }

  /**
   * withBackAnchor.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a S object
   */
  public S withBackAnchor(ChildHandler<S, AnchorElement> handler) {
    handler.apply((S) this, prevAnchor);
    return (S) this;
  }

  /**
   * withForwardAnchor.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a S object
   */
  public S withForwardAnchor(ChildHandler<S, AnchorElement> handler) {
    handler.apply((S) this, nextAnchor);
    return (S) this;
  }

  /**
   * withBackIcon.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a S object
   */
  public S withBackIcon(ChildHandler<S, Icon<?>> handler) {
    handler.apply((S) this, backIcon);
    return (S) this;
  }

  /**
   * withForwardIcon.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a S object
   */
  public S withForwardIcon(ChildHandler<S, Icon<?>> handler) {
    handler.apply((S) this, forwardIcon);
    return (S) this;
  }

  /**
   * withContentContainer.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a S object
   */
  public S withContentContainer(ChildHandler<S, DivElement> handler) {
    handler.apply((S) this, contentPanel);
    return (S) this;
  }

  /** fixElementsWidth. */
  protected abstract void fixElementsWidth();

  /**
   * setTransformProperty.
   *
   * @param offset a double
   */
  protected abstract void setTransformProperty(double offset);

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
