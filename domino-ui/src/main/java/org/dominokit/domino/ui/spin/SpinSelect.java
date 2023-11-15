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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import java.util.*;
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
 * Represents a UI component that provides spin select functionality. It allows the user to cycle
 * through a list of items, which can be navigated using next and previous icons.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * SpinSelect&lt;String&gt; spinSelect = new SpinSelectImplementation(backIcon, forwardIcon);
 * spinSelect.appendChild(new SpinItem("Item 1"));
 * spinSelect.appendChild(new SpinItem("Item 2"));
 * </pre>
 *
 * @param <T> The type of the value contained in each spin item.
 * @param <S> The specific type of the spin select.
 * @see BaseDominoElement
 */
public abstract class SpinSelect<T, S extends SpinSelect<T, S>>
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

  /**
   * Constructs a {@link SpinSelect} with specified back and forward icons.
   *
   * @param backIcon The icon to be used for the "move back" action.
   * @param forwardIcon The icon to be used for the "move forward" action.
   */
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
   * Moves the selection one step forward in the list.
   *
   * @return The current instance.
   */
  public S moveForward() {
    moveToIndex(items.indexOf(this.activeItem) + 1);
    return (S) this;
  }

  /**
   * Moves the active selection one step back in the spin list.
   *
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S moveBack() {
    moveToIndex(items.indexOf(this.activeItem) - 1);
    return (S) this;
  }

  /**
   * Moves the active selection to the specified index in the spin list. If the target index is out
   * of the bounds of the list, no action will be taken. This method will also handle the required
   * CSS animations and update the visibility of navigation arrows as needed.
   *
   * @param targetIndex The index to move the selection to.
   * @return The current instance of {@code SpinSelect} for chaining.
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
   * Moves the selection to the specified spin item.
   *
   * @param item The spin item to move the selection to.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S moveToItem(SpinItem<T> item) {
    if (items.contains(item)) {
      return moveToIndex(items.indexOf(item));
    }
    return (S) this;
  }

  /**
   * Updates the visibility or enabled/disabled status of the forward and backward navigation arrows
   * based on the current active item's position in the spin list.
   */
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

  /**
   * Pauses the change listeners to prevent them from getting triggered when changes occur. Useful
   * for making multiple changes without triggering listeners for each change.
   *
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  @Override
  public S pauseChangeListeners() {
    this.changeListenersPaused = true;
    return (S) this;
  }

  /**
   * Resumes the previously paused change listeners, allowing them to get triggered on subsequent
   * changes.
   *
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  @Override
  public S resumeChangeListeners() {
    this.changeListenersPaused = false;
    return (S) this;
  }

  /**
   * Toggles the paused status of the change listeners based on the provided boolean flag.
   *
   * @param toggle If {@code true}, change listeners will be paused. If {@code false}, they will be
   *     resumed.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  @Override
  public S togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return (S) this;
  }

  /**
   * Retrieves a set containing all the change listeners currently attached to the {@code
   * SpinSelect}.
   *
   * @return A set of change listeners.
   */
  @Override
  public Set<ChangeListener<? super T>> getChangeListeners() {
    return this.changeListeners;
  }

  /**
   * Checks whether the change listeners are currently paused or not.
   *
   * @return {@code true} if change listeners are paused, otherwise {@code false}.
   */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /**
   * Triggers the change listeners manually with the specified old and new values. Note: If change
   * listeners are paused, they will not be triggered.
   *
   * @param oldValue The previous value.
   * @param newValue The new value to notify listeners with.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
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
   * Appends a new item to the list of items in the spin select.
   *
   * @param spinItem The item to be appended.
   * @return The current instance.
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
   * Resets the spin select by removing all items.
   *
   * @return The current instance.
   */
  public S reset() {
    getItems().forEach(BaseDominoElement::remove);
    this.getItems().clear();
    this.activeItem = null;
    this.oldValue = null;
    return (S) this;
  }

  /**
   * Retrieves the currently active item from the spin list.
   *
   * @return The active {@code SpinItem}.
   */
  public SpinItem<T> getActiveItem() {
    return activeItem;
  }

  /**
   * Retrieves all items present in the spin list.
   *
   * @return A list of {@code SpinItem} objects.
   */
  public List<SpinItem<T>> getItems() {
    return items;
  }

  /**
   * Determines the index of the specified item in the spin list.
   *
   * @param item The {@code SpinItem} to find the index of.
   * @return The index of the item, or -1 if the item is not found.
   */
  public int indexOf(SpinItem<T> item) {
    if (items.contains(item)) {
      return items.indexOf(item);
    } else {
      return -1;
    }
  }

  /**
   * Determines the total number of items in the spin list.
   *
   * @return The count of {@code SpinItem} objects.
   */
  public int itemsCount() {
    return items.size();
  }

  /**
   * Checks if the specified item is the last item in the spin list.
   *
   * @param item The {@code SpinItem} to check.
   * @return {@code true} if it's the last item, {@code false} otherwise.
   */
  public boolean isLastItem(SpinItem<T> item) {
    return items.contains(item) && indexOf(item) == (itemsCount() - 1);
  }

  /**
   * Checks if the specified item is the first item in the spin list.
   *
   * @param item The {@code SpinItem} to check.
   * @return {@code true} if it's the first item, {@code false} otherwise.
   */
  public boolean isFirstItem(SpinItem<T> item) {
    return items.contains(item) && indexOf(item) == 0;
  }

  /**
   * Moves the active selection to the first item in the spin list.
   *
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S gotoFirst() {
    moveToIndex(0);
    return (S) this;
  }

  /**
   * Moves the active selection to the last item in the spin list.
   *
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S gotoLast() {
    moveToIndex(itemsCount() - 1);
    return (S) this;
  }

  /**
   * Retrieves the previous anchor element for navigation.
   *
   * @return The previous {@code AnchorElement}.
   */
  public AnchorElement getPrevAnchor() {
    return prevAnchor;
  }

  /**
   * Retrieves the next anchor element for navigation.
   *
   * @return The next {@code AnchorElement}.
   */
  public AnchorElement getNextAnchor() {
    return nextAnchor;
  }

  /**
   * Retrieves the content panel element that holds the spin items.
   *
   * @return The content {@code DivElement}.
   */
  public DivElement getContentPanel() {
    return contentPanel;
  }

  /**
   * Retrieves the value of the currently active item from the spin list.
   *
   * @return The value of the active {@code SpinItem}, or {@code null} if no active item is present.
   */
  public T getValue() {
    return Optional.ofNullable(activeItem).map(SpinItem::getValue).orElse(null);
  }

  /**
   * Applies a custom handler to the back anchor element and provides chaining support.
   *
   * @param handler The {@code ChildHandler} to apply custom operations to the back anchor.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S withBackAnchor(ChildHandler<S, AnchorElement> handler) {
    handler.apply((S) this, prevAnchor);
    return (S) this;
  }

  /**
   * Applies a custom handler to the forward anchor element and provides chaining support.
   *
   * @param handler The {@code ChildHandler} to apply custom operations to the forward anchor.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S withForwardAnchor(ChildHandler<S, AnchorElement> handler) {
    handler.apply((S) this, nextAnchor);
    return (S) this;
  }

  /**
   * Applies a custom handler to the back icon and provides chaining support.
   *
   * @param handler The {@code ChildHandler} to apply custom operations to the back icon.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S withBackIcon(ChildHandler<S, Icon<?>> handler) {
    handler.apply((S) this, backIcon);
    return (S) this;
  }

  /**
   * Applies a custom handler to the forward icon and provides chaining support.
   *
   * @param handler The {@code ChildHandler} to apply custom operations to the forward icon.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S withForwardIcon(ChildHandler<S, Icon<?>> handler) {
    handler.apply((S) this, forwardIcon);
    return (S) this;
  }

  /**
   * Applies a custom handler to the content container (panel) and provides chaining support.
   *
   * @param handler The {@code ChildHandler} to apply custom operations to the content panel.
   * @return The current instance of {@code SpinSelect} for chaining.
   */
  public S withContentContainer(ChildHandler<S, DivElement> handler) {
    handler.apply((S) this, contentPanel);
    return (S) this;
  }

  /** Adjusts the width of the elements inside the spin select for consistent display. */
  protected abstract void fixElementsWidth();

  /**
   * Sets the transform property of the spin select.
   *
   * @param offset The offset to be applied to the transform property.
   */
  protected abstract void setTransformProperty(double offset);

  /**
   * {@inheritDoc}
   *
   * <p>Retrieves the root element of the {@code SpinSelect} class.
   *
   * @return The root {@code HTMLDivElement} instance representing the main element of this
   *     component.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
