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
import org.dominokit.domino.ui.IsElement;

/**
 * The `KeyboardNavigation` class provides a convenient way to handle keyboard navigation within a
 * list of elements.
 *
 * @param <V> The type of elements to navigate.
 */
public class KeyboardNavigation<V extends IsElement<?>> implements EventListener {

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

  /**
   * Creates a new `KeyboardNavigation` instance for the given list of items.
   *
   * @param items The list of items to navigate.
   */
  public KeyboardNavigation(List<V> items) {
    this.items = items;
  }

  /**
   * Creates a new `KeyboardNavigation` instance for the given list of items.
   *
   * @param items The list of items to navigate.
   * @param <V> The type of elements to navigate.
   * @return A new `KeyboardNavigation` instance.
   */
  public static <V extends IsElement<?>> KeyboardNavigation<V> create(List<V> items) {
    return new KeyboardNavigation<>(items);
  }

  /**
   * Sets the focus handler for the keyboard navigation.
   *
   * @param focusHandler The focus handler to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> onFocus(FocusHandler<V> focusHandler) {
    this.focusHandler = focusHandler;
    return this;
  }

  /**
   * Sets the select handler for the keyboard navigation.
   *
   * @param selectHandler The select handler to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> onSelect(ItemNavigationHandler<V> selectHandler) {
    this.selectHandler = selectHandler;
    return this;
  }

  /**
   * Sets the escape handler for the keyboard navigation.
   *
   * @param escapeHandler The escape handler to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> onEscape(EscapeHandler escapeHandler) {
    this.escapeHandler = escapeHandler;
    return this;
  }

  /**
   * Sets the focus condition for determining whether an element should receive focus.
   *
   * @param focusCondition The focus condition to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> focusCondition(FocusCondition<V> focusCondition) {
    this.focusCondition = focusCondition;
    return this;
  }

  /**
   * Handles keyboard events and navigates through the list of items accordingly.
   *
   * @param evt The keyboard event.
   */
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

  /**
   * Sets the enter handler for handling Enter key presses.
   *
   * @param enterHandler The enter handler to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> setEnterHandler(ItemNavigationHandler<V> enterHandler) {
    this.enterHandler = enterHandler;
    return this;
  }

  /**
   * Sets the tab handler for handling Tab key presses.
   *
   * @param tabHandler The tab handler to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> setTabHandler(ItemNavigationHandler<V> tabHandler) {
    this.tabHandler = tabHandler;
    return this;
  }

  /**
   * Sets the space handler for handling Space key presses.
   *
   * @param spaceHandler The space handler to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> setSpaceHandler(ItemNavigationHandler<V> spaceHandler) {
    this.spaceHandler = spaceHandler;
    return this;
  }

  /**
   * Sets the global options for event handling.
   *
   * @param globalOptions The global event options to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> setGlobalOptions(EventOptions globalOptions) {
    this.globalOptions = globalOptions;
    return this;
  }

  /**
   * Sets the enter options for handling Enter key presses.
   *
   * @param enterOptions The enter event options to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> setEnterOptions(EventOptions enterOptions) {
    this.enterOptions = enterOptions;
    return this;
  }

  /**
   * Sets the tab options for handling Tab key presses.
   *
   * @param tabOptions The tab event options to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> setTabOptions(EventOptions tabOptions) {
    this.tabOptions = tabOptions;
    return this;
  }

  /**
   * Sets the space options for handling Space key presses.
   *
   * @param spaceOptions The space event options to set.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> setSpaceOptions(EventOptions spaceOptions) {
    this.spaceOptions = spaceOptions;
    return this;
  }

  /**
   * Focuses on the next item in the list.
   *
   * @param item The current item.
   */
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

  /**
   * Checks if the given item is the last focusable item in the list.
   *
   * @param item The item to check.
   * @return `true` if the item is the last focusable item, `false` otherwise.
   */
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
    return isNull(focusCondition)
        || focusCondition.shouldFocus(itemToFocus)
            && !ElementsFactory.elements.elementOf(itemToFocus.element()).isHidden();
  }

  /** Focuses on the first focusable item in the list. */
  public void focusTopFocusableItem() {
    for (V item : items) {
      if (shouldFocus(item)) {
        doFocus(item);
        break;
      }
    }
  }

  /** Focuses on the last focusable item in the list. */
  private void focusBottomFocusableItem() {
    for (int i = items.size() - 1; i >= 0; i--) {
      V itemToFocus = items.get(i);
      if (shouldFocus(itemToFocus)) {
        doFocus(itemToFocus);
        break;
      }
    }
  }

  /**
   * Focuses on the previous item in the list.
   *
   * @param item The current item.
   */
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
   * Focuses on the item at the specified index in the list.
   *
   * @param index The index of the item to focus.
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
   * Registers a custom navigation handler for a specific key code.
   *
   * @param keyCode The key code for which to register the handler.
   * @param navigationHandler The navigation handler to register.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> registerNavigationHandler(
      String keyCode, ItemNavigationHandler<V> navigationHandler) {
    if (!navigationHandlers.containsKey(keyCode)) {
      navigationHandlers.put(keyCode.toLowerCase(), new ArrayList<>());
    }
    navigationHandlers.get(keyCode.toLowerCase()).add(navigationHandler);
    return this;
  }

  /**
   * Removes a custom navigation handler for a specific key code.
   *
   * @param keyCode The key code for which to remove the handler.
   * @param navigationHandler The navigation handler to remove.
   * @return This `KeyboardNavigation` instance.
   */
  public KeyboardNavigation<V> removeNavigationHandler(
      String keyCode, ItemNavigationHandler<V> navigationHandler) {
    if (navigationHandlers.containsKey(keyCode.toLowerCase())) {
      navigationHandlers.get(keyCode.toLowerCase()).remove(navigationHandler);
    }
    return this;
  }

  /**
   * A functional interface for handling focus on items.
   *
   * @param <V> The type of elements to focus.
   */
  @FunctionalInterface
  public interface FocusHandler<V> {
    /**
     * Handles focusing on the given item.
     *
     * @param item The item to focus.
     */
    void doFocus(V item);
  }

  /**
   * A functional interface for handling item navigation.
   *
   * @param <V> The type of elements to navigate.
   */
  @FunctionalInterface
  public interface ItemNavigationHandler<V> {
    /**
     * Handles item navigation based on a keyboard event.
     *
     * @param event The keyboard event.
     * @param item The item to navigate.
     */
    void onItemNavigation(KeyboardEvent event, V item);
  }

  /** A functional interface for handling Escape key presses. */
  @FunctionalInterface
  public interface EscapeHandler {
    /** Handles Escape key presses. */
    void onEscape();
  }

  /**
   * A functional interface for defining a focus condition for items.
   *
   * @param <V> The type of elements to focus.
   */
  @FunctionalInterface
  public interface FocusCondition<V> {
    /**
     * Checks if the given item should receive focus.
     *
     * @param item The item to check.
     * @return `true` if the item should receive focus, `false` otherwise.
     */
    boolean shouldFocus(V item);
  }

  /** Represents event options for handling keyboard events. */
  private interface EventExecutor {
    void execute();
  }

  /** Represents event options for handling keyboard events. */
  public static final class EventOptions {
    private boolean preventDefault;
    private boolean stopPropagation;

    /**
     * Creates a new `EventOptions` instance with the specified options.
     *
     * @param preventDefault Indicates whether to prevent the default behavior of the event.
     * @param stopPropagation Indicates whether to stop the propagation of the event.
     */
    public EventOptions(boolean preventDefault, boolean stopPropagation) {
      this.preventDefault = preventDefault;
      this.stopPropagation = stopPropagation;
    }
  }
}
