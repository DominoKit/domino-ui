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
package org.dominokit.domino.ui.dropdown;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementUtil.isArrowDown;
import static org.dominokit.domino.ui.utils.ElementUtil.isArrowUp;
import static org.dominokit.domino.ui.utils.ElementUtil.isEnterKey;
import static org.dominokit.domino.ui.utils.ElementUtil.isEscapeKey;
import static org.dominokit.domino.ui.utils.ElementUtil.isSpaceKey;
import static org.dominokit.domino.ui.utils.ElementUtil.isTabKey;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jsinterop.base.Js;
import org.jboss.elemento.IsElement;

/**
 * A helper class to ease the keyboard navigation of a menu
 *
 * @param <V> The element type
 * @see IsElement
 * @see EventListener
 */
public class MenuNavigation<V extends IsElement<?>> implements EventListener {

  private final List<V> items;
  private FocusHandler<V> focusHandler;
  private ItemNavigationHandler<V> selectHandler = (event, item) -> {};
  private ItemNavigationHandler<V> enterHandler;
  private ItemNavigationHandler<V> tabHandler;
  private ItemNavigationHandler<V> spaceHandler;
  private final Map<String, List<ItemNavigationHandler<V>>> navigationHandlers = new HashMap<>();
  private FocusCondition<V> focusCondition;
  private EscapeHandler escapeHandler;
  private EventOptions globalOptions = new EventOptions(true, true);
  private EventOptions enterOptions = new EventOptions(true, true);
  private EventOptions tabOptions = new EventOptions(true, true);
  private EventOptions spaceOptions = new EventOptions(true, true);

  public MenuNavigation(List<V> items) {
    this.items = items;
  }

  /**
   * Creates new navigation for a menu contains a list of items
   *
   * @param items the items of the menu
   * @param <V> the element type
   * @return new instance
   */
  public static <V extends IsElement<?>> MenuNavigation<V> create(List<V> items) {
    return new MenuNavigation<>(items);
  }

  /**
   * Sets a handler which will be called when an item gets focused
   *
   * @param focusHandler A {@link FocusHandler}
   * @return same instance
   */
  public MenuNavigation<V> onFocus(FocusHandler<V> focusHandler) {
    this.focusHandler = focusHandler;
    return this;
  }

  /**
   * Sets a handler which will be called when an item gets selected
   *
   * @param selectHandler A {@link ItemNavigationHandler}
   * @return same instance
   */
  public MenuNavigation<V> onSelect(ItemNavigationHandler<V> selectHandler) {
    this.selectHandler = selectHandler;
    return this;
  }

  /**
   * Sets a handler which will be called when escape key is pressed
   *
   * @param escapeHandler A {@link EscapeHandler}
   * @return same instance
   */
  public MenuNavigation<V> onEscape(EscapeHandler escapeHandler) {
    this.escapeHandler = escapeHandler;
    return this;
  }

  /**
   * Adds a condition which evaluates if an item should be focused or not
   *
   * @param focusCondition a condition returns true if an item should be focused, false otherwise
   * @return same instance
   */
  public MenuNavigation<V> focusCondition(FocusCondition<V> focusCondition) {
    this.focusCondition = focusCondition;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void handleEvent(Event evt) {
    KeyboardEvent keyboardEvent = (KeyboardEvent) evt;

    HTMLElement element = Js.uncheckedCast(keyboardEvent.target);
    for (V item : items) {
      if (item.element().contains(element)) {
        if (isArrowUp(keyboardEvent)) {
          doEvent(evt, globalOptions, () -> focusPrevious(item));
        } else if (isArrowDown(keyboardEvent)) {
          doEvent(evt, globalOptions, () -> focusNext(item));
        } else if (isEscapeKey(keyboardEvent)) {
          doEvent(evt, globalOptions, () -> escapeHandler.onEscape());
        }

        if (isEnterKey(keyboardEvent)) {
          doEvent(keyboardEvent, enterOptions, () -> onEnter(keyboardEvent, item));
        }

        if (isSpaceKey(keyboardEvent)) {
          doEvent(keyboardEvent, spaceOptions, () -> onSpace(keyboardEvent, item));
        }

        if (isTabKey(keyboardEvent)) {
          doEvent(keyboardEvent, tabOptions, () -> onTab(keyboardEvent, item));
        }

        onCustomHandler(keyboardEvent, item);
      }
    }
  }

  private void onCustomHandler(KeyboardEvent event, V item) {
    if (navigationHandlers.containsKey(event.key.toLowerCase())) {
      navigationHandlers
          .get(event.key.toLowerCase())
          .forEach(handler -> handler.onItemNavigation(event, item));
    }
  }

  private void onEnter(KeyboardEvent event, V item) {
    (nonNull(enterHandler) ? enterHandler : selectHandler).onItemNavigation(event, item);
  }

  private void onSpace(KeyboardEvent event, V item) {
    (nonNull(spaceHandler) ? spaceHandler : selectHandler).onItemNavigation(event, item);
  }

  private void onTab(KeyboardEvent event, V item) {
    (nonNull(tabHandler) ? tabHandler : selectHandler).onItemNavigation(event, item);
  }

  public MenuNavigation<V> setEnterHandler(ItemNavigationHandler<V> enterHandler) {
    this.enterHandler = enterHandler;
    return this;
  }

  public MenuNavigation<V> setTabHandler(ItemNavigationHandler<V> tabHandler) {
    this.tabHandler = tabHandler;
    return this;
  }

  public MenuNavigation<V> setSpaceHandler(ItemNavigationHandler<V> spaceHandler) {
    this.spaceHandler = spaceHandler;
    return this;
  }

  public MenuNavigation<V> setGlobalOptions(EventOptions globalOptions) {
    this.globalOptions = globalOptions;
    return this;
  }

  public MenuNavigation<V> setEnterOptions(EventOptions enterOptions) {
    this.enterOptions = enterOptions;
    return this;
  }

  public MenuNavigation<V> setTabOptions(EventOptions tabOptions) {
    this.tabOptions = tabOptions;
    return this;
  }

  public MenuNavigation<V> setSpaceOptions(EventOptions spaceOptions) {
    this.spaceOptions = spaceOptions;
    return this;
  }

  public void focusNext(V item) {
    int nextIndex = items.indexOf(item) + 1;
    int size = items.size();
    if (nextIndex >= size) {
      focusTopFocusableItem();
    } else {
      for (int i = nextIndex; i < size; i++) {
        V itemToFocus = items.get(i);
        if (shouldFocus((V) itemToFocus)) {
          doFocus(itemToFocus);
          return;
        }
      }
      focusTopFocusableItem();
    }
  }

  public boolean isLastFocusableItem(V item) {
    int nextIndex = items.indexOf(item) + 1;
    int size = items.size();
    if (nextIndex >= size) {
      return true;
    } else {
      return !items.subList(nextIndex, size).stream().anyMatch(this::shouldFocus);
    }
  }

  private boolean shouldFocus(V itemToFocus) {
    return isNull(focusCondition) || focusCondition.shouldFocus(itemToFocus);
  }

  public void focusTopFocusableItem() {
    for (V item : items) {
      if (shouldFocus(item)) {
        doFocus(item);
        break;
      }
    }
  }

  private void focusBottomFocusableItem() {
    for (int i = items.size() - 1; i >= 0; i--) {
      V itemToFocus = items.get(i);
      if (shouldFocus(itemToFocus)) {
        doFocus(itemToFocus);
        break;
      }
    }
  }

  public void focusPrevious(V item) {
    int nextIndex = items.indexOf(item) - 1;
    if (nextIndex < 0) {
      focusBottomFocusableItem();
    } else {
      for (int i = nextIndex; i >= 0; i--) {
        V itemToFocus = items.get(i);
        if (shouldFocus(itemToFocus)) {
          doFocus(itemToFocus);
          return;
        }
      }
      focusBottomFocusableItem();
    }
  }

  private void doFocus(V item) {
    focusHandler.doFocus(item);
  }

  /**
   * Focuses an item at a specific {@code index}
   *
   * @param index the index of the item
   */
  public void focusAt(int index) {
    if (!items.isEmpty()) {
      V item = items.get(index);
      doFocus(item);
    }
  }

  private void doEvent(Event event, EventOptions options, EventExecutor executor) {
    if (options.stopPropagation) {
      event.stopPropagation();
    }
    executor.execute();
    if (options.preventDefault) {
      event.preventDefault();
    }
  }

  /**
   * @param keyCode String keyboard key code
   * @param navigationHandler the navigation handler to be registered
   * @return same instance
   */
  public MenuNavigation<V> registerNavigationHandler(
      String keyCode, ItemNavigationHandler<V> navigationHandler) {
    if (!navigationHandlers.containsKey(keyCode)) {
      navigationHandlers.put(keyCode.toLowerCase(), new ArrayList<>());
    }
    navigationHandlers.get(keyCode.toLowerCase()).add(navigationHandler);
    return this;
  }

  /**
   * @param keyCode String keyboard key code
   * @param navigationHandler the navigation handler to be removed
   * @return same instance
   */
  public MenuNavigation<V> removeNavigationHandler(
      String keyCode, ItemNavigationHandler<V> navigationHandler) {
    if (navigationHandlers.containsKey(keyCode.toLowerCase())) {
      navigationHandlers.get(keyCode.toLowerCase()).remove(navigationHandler);
    }
    return this;
  }

  /**
   * Focus handler to be called when an item gets focused
   *
   * @param <V> the item type
   */
  @FunctionalInterface
  public interface FocusHandler<V> {
    /**
     * Will be called when {@code item} gets focused
     *
     * @param item the focused item
     */
    void doFocus(V item);
  }

  /**
   * Selection handler to be called when an item gets selected
   *
   * @param <V> the item type
   */
  @FunctionalInterface
  public interface ItemNavigationHandler<V> {
    /**
     * Will be called when {@code item} gets selected
     *
     * @param item the selected item
     */
    void onItemNavigation(KeyboardEvent event, V item);
  }

  /** Escape handler to be called when escape key is pressed */
  @FunctionalInterface
  public interface EscapeHandler {
    /** Will be called when the escape key is pressed */
    void onEscape();
  }

  /**
   * A condition which evaluates if an item should be focused or not
   *
   * @param <V> the item type
   */
  @FunctionalInterface
  public interface FocusCondition<V> {
    /**
     * Returns true if the item should be focused, false otherwise
     *
     * @param item the item
     * @return true if the item should be focused, false otherwise
     */
    boolean shouldFocus(V item);
  }

  private interface EventExecutor {
    void execute();
  }

  public static final class EventOptions {
    private boolean preventDefault;
    private boolean stopPropagation;

    public EventOptions(boolean preventDefault, boolean stopPropagation) {
      this.preventDefault = preventDefault;
      this.stopPropagation = stopPropagation;
    }
  }
}
