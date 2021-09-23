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
package org.dominokit.domino.ui.keyboard;

import static java.util.Objects.nonNull;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import elemental2.dom.Node;
import java.util.HashMap;
import java.util.Map;
import jsinterop.base.Js;
import org.jboss.elemento.IsElement;

/**
 * A helper class allowing listening to keyboard events on an element
 *
 * @param <T> the element type
 */
public class KeyboardEvents<T extends Node> {

  public static final String ESCAPE = "escape";
  public static final String KEYDOWN = "keydown";
  public static final String KEYUP = "keyup";
  public static final String KEYPRESS = "keypress";
  public static final String ARROWDOWN = "arrowdown";
  public static final String ARROWUP = "arrowup";
  public static final String ENTER = "enter";
  public static final String DELETE = "delete";
  public static final String SPACE = "space";
  public static final String TAB = "tab";
  public static final String BACKSPACE = "backspace";

  private final Map<String, HandlerContext> handlers = new HashMap<>();
  private final Map<String, HandlerContext> ctrlHandlers = new HashMap<>();
  private KeyboardEventOptions defaultOptions = KeyboardEventOptions.create();

  /**
   * @param eventType The eventType that will trigger the handlers
   * @param element the target element
   */
  public KeyboardEvents(String eventType, T element) {
    element.addEventListener(
        eventType,
        evt -> {
          KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
          // ignore events without keycode (browser bug?)
          // example: picking value by keyboard from Chrome auto-suggest
          if (keyboardEvent.key == null) return;
          String key = keyboardEvent.key.toLowerCase();
          HandlerContext handlerContext = null;
          if (keyboardEvent.ctrlKey && ctrlHandlers.containsKey(key)) {
            handlerContext = ctrlHandlers.get(key);
          } else if (handlers.containsKey(key)) {
            handlerContext = handlers.get(key);
          }

          if (nonNull(handlerContext)) {
            handlerContext.handler.handleEvent(evt);
            if (handlerContext.options.preventDefault) {
              evt.preventDefault();
            }
            if (handlerContext.options.stopPropagation) {
              evt.stopPropagation();
            }
          }
        });
  }

  /** @param element the target element */
  public KeyboardEvents(T element) {
    this(KEYDOWN, element);
  }

  /**
   * Static factory for creation keyboard event listener
   *
   * @param element the target element
   * @param <T> the type of the element
   * @return new instance
   * @deprecated use {@link #listenOnKeyDown(Node)}, {@link #listenOnKeyUp(Node)}, {@link
   *     #listenOnKeyPress(Node)}
   */
  @Deprecated
  public static <T extends Node> KeyboardEvents<T> listenOn(T element) {
    return new KeyboardEvents<>(element);
  }

  /**
   * Same as {@link KeyboardEvents#listenOn(Node)} but with wrapper {@link IsElement}
   *
   * @param element the target {@link IsElement}
   * @param <T> the type of the element
   * @return new instance
   * @deprecated use {@link #listenOnKeyDown(IsElement)}, {@link #listenOnKeyUp(IsElement)}, {@link
   *     #listenOnKeyPress(IsElement)}
   */
  @Deprecated
  public static <T extends HTMLElement> KeyboardEvents<T> listenOn(IsElement<T> element) {
    return new KeyboardEvents<>(element.element());
  }

  /**
   * Static factory for creation keyboard keydown event listener
   *
   * @param element the target element
   * @param <T> the type of the element
   * @return new instance
   */
  public static <T extends Node> KeyboardEvents<T> listenOnKeyDown(T element) {
    return new KeyboardEvents<>(KEYDOWN, element);
  }

  /**
   * Same as {@link KeyboardEvents#listenOnKeyDown(Node)} but with wrapper {@link IsElement}
   *
   * @param element the target {@link IsElement}
   * @param <T> the type of the element
   * @return new instance
   */
  public static <T extends HTMLElement> KeyboardEvents<T> listenOnKeyDown(IsElement<T> element) {
    return new KeyboardEvents<>(KEYDOWN, element.element());
  }

  /**
   * Static factory for creation keyboard keyUp event listener
   *
   * @param element the target element
   * @param <T> the type of the element
   * @return new instance
   */
  public static <T extends Node> KeyboardEvents<T> listenOnKeyUp(T element) {
    return new KeyboardEvents<>(KEYUP, element);
  }

  /**
   * Same as {@link KeyboardEvents#listenOnKeyUp(Node)} but with wrapper {@link IsElement}
   *
   * @param element the target {@link IsElement}
   * @param <T> the type of the element
   * @return new instance
   */
  public static <T extends HTMLElement> KeyboardEvents<T> listenOnKeyUp(IsElement<T> element) {
    return new KeyboardEvents<>(KEYUP, element.element());
  }

  /**
   * Static factory for creation keyboard keyPress event listener
   *
   * @param element the target element
   * @param <T> the type of the element
   * @return new instance
   */
  public static <T extends Node> KeyboardEvents<T> listenOnKeyPress(T element) {
    return new KeyboardEvents<>(KEYPRESS, element);
  }

  /**
   * Same as {@link KeyboardEvents#listenOnKeyPress(Node)} but with wrapper {@link IsElement}
   *
   * @param element the target {@link IsElement}
   * @param <T> the type of the element
   * @return new instance
   */
  public static <T extends HTMLElement> KeyboardEvents<T> listenOnKeyPress(IsElement<T> element) {
    return new KeyboardEvents<>(KEYPRESS, element.element());
  }

  /**
   * On escape button pressed
   *
   * @param escapeHandler the {@link EventListener} to call
   * @return same instance
   */
  // ---------------- handlers ----------------
  public KeyboardEvents<T> onEscape(EventListener escapeHandler) {
    return onEscape(escapeHandler, defaultOptions());
  }

  /**
   * On escape button pressed with {@code options}
   *
   * @param escapeHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onEscape(EventListener escapeHandler, KeyboardEventOptions options) {
    return addHandler(ESCAPE, contextOf(escapeHandler, options));
  }

  /**
   * On arrow up or arrow down buttons pressed
   *
   * @param arrowDownHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onArrowUpDown(EventListener arrowDownHandler) {
    return onArrowUp(arrowDownHandler).onArrowDown(arrowDownHandler);
  }

  /**
   * On arrow up or arrow down buttons pressed with options
   *
   * @param arrowDownHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onArrowUpDown(
      EventListener arrowDownHandler, KeyboardEventOptions options) {
    return onArrowUp(arrowDownHandler, options).onArrowDown(arrowDownHandler, options);
  }

  /**
   * On arrow down button pressed
   *
   * @param arrowDownHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onArrowDown(EventListener arrowDownHandler) {
    return onArrowDown(arrowDownHandler, defaultOptions());
  }

  /**
   * On arrow down button pressed with options
   *
   * @param arrowDownHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onArrowDown(
      EventListener arrowDownHandler, KeyboardEventOptions options) {
    return addHandler(ARROWDOWN, contextOf(arrowDownHandler, options));
  }

  /**
   * On arrow up button pressed with options
   *
   * @param arrowUpHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onArrowUp(EventListener arrowUpHandler) {
    return onArrowUp(arrowUpHandler, defaultOptions());
  }

  /**
   * On arrow up button pressed with options
   *
   * @param arrowUpHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onArrowUp(EventListener arrowUpHandler, KeyboardEventOptions options) {
    return addHandler(ARROWUP, contextOf(arrowUpHandler, options));
  }

  /**
   * On enter button pressed
   *
   * @param enterHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onEnter(EventListener enterHandler) {
    return onEnter(enterHandler, defaultOptions());
  }

  /**
   * On enter button pressed with options
   *
   * @param enterHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onEnter(EventListener enterHandler, KeyboardEventOptions options) {
    return addHandler(ENTER, contextOf(enterHandler, options));
  }

  /**
   * On delete button pressed
   *
   * @param deleteHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onDelete(EventListener deleteHandler) {
    return onDelete(deleteHandler, defaultOptions());
  }

  /**
   * On delete button pressed with options
   *
   * @param deleteHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onDelete(EventListener deleteHandler, KeyboardEventOptions options) {
    return addHandler(DELETE, contextOf(deleteHandler, options));
  }

  /**
   * On space button pressed
   *
   * @param spaceHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onSpace(EventListener spaceHandler) {
    return onSpace(spaceHandler, defaultOptions());
  }

  /**
   * On space button pressed with options
   *
   * @param spaceHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onSpace(EventListener spaceHandler, KeyboardEventOptions options) {
    return addHandler(SPACE, contextOf(spaceHandler, options));
  }

  /**
   * On tab button pressed
   *
   * @param tabHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onTab(EventListener tabHandler) {
    return onTab(tabHandler, defaultOptions());
  }

  /**
   * On tab button pressed with options
   *
   * @param tabHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onTab(EventListener tabHandler, KeyboardEventOptions options) {
    return addHandler(TAB, contextOf(tabHandler, options));
  }

  /**
   * On key button pressed with options
   *
   * @param handler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> on(String key, EventListener handler, KeyboardEventOptions options) {
    return addHandler(key, contextOf(handler, options));
  }

  /**
   * On key button pressed
   *
   * @param handler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> on(String key, EventListener handler) {
    return on(key, handler, defaultOptions());
  }

  private KeyboardEvents<T> addHandler(String type, HandlerContext handlerContext) {
    handlers.put(type, handlerContext);
    return this;
  }

  // ---------------- ctrl handlers ----------------

  /**
   * On ctrl + backspace buttons pressed
   *
   * @param ctrlBackspaceHandler the {@link EventListener} to call
   * @return same instance
   */
  public KeyboardEvents<T> onCtrlBackspace(EventListener ctrlBackspaceHandler) {
    return onCtrlBackspace(ctrlBackspaceHandler, defaultOptions());
  }

  /**
   * On ctrl + backspace buttons pressed with options
   *
   * @param ctrlBackspaceHandler the {@link EventListener} to call
   * @param options the {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> onCtrlBackspace(
      EventListener ctrlBackspaceHandler, KeyboardEventOptions options) {
    return addCtrlHandler(BACKSPACE, contextOf(ctrlBackspaceHandler, options));
  }

  /**
   * Sets the default {@link KeyboardEventOptions}
   *
   * @param defaultOptions the default {@link KeyboardEventOptions}
   * @return same instance
   */
  public KeyboardEvents<T> setDefaultOptions(KeyboardEventOptions defaultOptions) {
    this.defaultOptions = defaultOptions;
    return this;
  }

  private KeyboardEvents<T> addCtrlHandler(String type, HandlerContext handlerContext) {
    ctrlHandlers.put(type, handlerContext);
    return this;
  }

  private HandlerContext contextOf(EventListener handler, KeyboardEventOptions options) {
    return new HandlerContext(handler, options);
  }

  private KeyboardEventOptions defaultOptions() {
    return defaultOptions;
  }

  /** Context to hold keyboard event options */
  public static class KeyboardEventOptions {
    private boolean preventDefault = false;
    private boolean stopPropagation = false;

    /** @return new instance */
    public static KeyboardEventOptions create() {
      return new KeyboardEventOptions();
    }

    /**
     * Sets if prevent default behaviour is enabled or not
     *
     * @param preventDefault true to prevent default, false otherwise
     * @return same instance
     */
    public KeyboardEventOptions setPreventDefault(boolean preventDefault) {
      this.preventDefault = preventDefault;
      return this;
    }

    /**
     * Sets if stop event propagation is enabled or not
     *
     * @param stopPropagation true to stop propagation, false otherwise
     * @return same instance
     */
    public KeyboardEventOptions setStopPropagation(boolean stopPropagation) {
      this.stopPropagation = stopPropagation;
      return this;
    }
  }

  private static class HandlerContext {
    private final EventListener handler;
    private final KeyboardEventOptions options;

    public HandlerContext(EventListener handler, KeyboardEventOptions options) {
      this.handler = handler;
      this.options = options;
    }
  }
}
