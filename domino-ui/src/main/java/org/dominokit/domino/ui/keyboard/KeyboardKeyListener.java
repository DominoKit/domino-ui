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

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.KeyboardEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import jsinterop.base.Js;
import org.dominokit.domino.ui.events.HasDefaultEventOptions;

/**
 * The {@code KeyboardKeyListener} class is an event listener for keyboard events that implements
 * the {@link EventListener} and {@link AcceptKeyEvents} interfaces. It allows you to define event
 * handlers for specific key events such as keydown, keyup, and keypress, including common keyboard
 * keys like escape, arrow keys, enter, delete, space, tab, and backspace.
 *
 * <p>You can register and manage event handlers for specific keys and globally for all keyboard
 * events. Additionally, it supports default event options provided by the {@link
 * HasDefaultEventOptions} interface.
 *
 * @see AcceptKeyEvents
 * @see HasDefaultEventOptions
 */
public class KeyboardKeyListener implements EventListener, AcceptKeyEvents {

  /** The constant representing the "escape" key. */
  public static final String ESCAPE = "escape";

  /** The constant representing the "arrowdown" key. */
  public static final String ARROWDOWN = "arrowdown";

  /** The constant representing the "arrowup" key. */
  public static final String ARROWUP = "arrowup";

  /** The constant representing the "arrowright" key. */
  public static final String ARROWRIGHT = "arrowright";

  /** The constant representing the "arrowleft" key. */
  public static final String ARROWLEFT = "arrowleft";

  /** The constant representing the "enter" key. */
  public static final String ENTER = "enter";

  /** The constant representing the "delete" key. */
  public static final String DELETE = "delete";

  /** The constant representing the "space" key. */
  public static final String SPACE = "space";

  /** The constant representing the "tab" key. */
  public static final String TAB = "tab";

  /** The constant representing the "backspace" key. */
  public static final String BACKSPACE = "backspace";

  private final Map<String, List<KeyEventHandlerContext>> handlers = new HashMap<>();
  private final List<KeyEventHandlerContext> globalHandlers = new ArrayList<>();
  private HasDefaultEventOptions<KeyboardEventOptions> hasDefaultEventOptions;

  /**
   * Constructs a new {@code KeyboardKeyListener} instance with the provided default event options.
   *
   * @param hasDefaultEventOptions The {@link HasDefaultEventOptions} object that provides default
   *     event options.
   */
  public KeyboardKeyListener(HasDefaultEventOptions<KeyboardEventOptions> hasDefaultEventOptions) {
    this.hasDefaultEventOptions = hasDefaultEventOptions;
  }

  /** {@inheritDoc} */
  @Override
  public void handleEvent(Event evt) {
    KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
    // ignore events without keycode (browser bug?)
    // example: picking value by keyboard from Chrome auto-suggest
    if (keyboardEvent.key == null) return;
    String key = keyboardEvent.key.toLowerCase();
    if (handlers.containsKey(key)) {
      callHandlers(handlers.get(key), evt);
    }
    callHandlers(globalHandlers, evt);
  }

  private void callHandlers(List<KeyEventHandlerContext> keyEventHandlerContexts, Event evt) {
    KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
    keyEventHandlerContexts.stream()
        .filter(
            context ->
                context.options.get().withCtrlKey == keyboardEvent.ctrlKey
                    && context.options.get().withAltKey == keyboardEvent.altKey
                    && context.options.get().withShiftKey == keyboardEvent.shiftKey
                    && context.options.get().withMetaKey == keyboardEvent.metaKey
                    && context.options.get().repeating == keyboardEvent.repeat)
        .forEach(
            context -> {
              context.handler.handleEvent(keyboardEvent);
              if (context.options.get().preventDefault) {
                evt.preventDefault();
              }
              if (context.options.get().stopPropagation) {
                evt.stopPropagation();
              }
            });
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onBackspace(EventListener handler) {
    return addHandler(BACKSPACE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onBackspace(KeyboardEventOptions options, EventListener handler) {
    return addHandler(BACKSPACE, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onEscape(EventListener handler) {
    return addHandler(ESCAPE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onEscape(KeyboardEventOptions options, EventListener handler) {
    return addHandler(ESCAPE, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowUpDown(EventListener handler) {
    return onArrowUp(handler).onArrowDown(handler);
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowUpDown(KeyboardEventOptions options, EventListener handler) {
    return onArrowUp(options, handler).onArrowDown(options, handler);
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowDown(EventListener handler) {
    return addHandler(ARROWDOWN, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowDown(KeyboardEventOptions options, EventListener handler) {
    return addHandler(ARROWDOWN, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowUp(EventListener handler) {
    return addHandler(ARROWUP, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowUp(KeyboardEventOptions options, EventListener handler) {
    return addHandler(ARROWUP, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowRight(EventListener handler) {
    return addHandler(ARROWRIGHT, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowRight(KeyboardEventOptions options, EventListener handler) {
    return addHandler(ARROWRIGHT, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowLeft(EventListener handler) {
    return addHandler(ARROWLEFT, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onArrowLeft(KeyboardEventOptions options, EventListener handler) {
    return addHandler(ARROWLEFT, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onEnter(EventListener handler) {
    return addHandler(ENTER, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onEnter(KeyboardEventOptions options, EventListener handler) {
    return addHandler(ENTER, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onDelete(EventListener handler) {
    return addHandler(DELETE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onDelete(KeyboardEventOptions options, EventListener handler) {
    return addHandler(DELETE, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onSpace(EventListener handler) {
    return addHandler(SPACE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onSpace(KeyboardEventOptions options, EventListener handler) {
    return addHandler(SPACE, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onTab(EventListener handler) {
    return addHandler(TAB, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents onTab(KeyboardEventOptions options, EventListener handler) {
    return addHandler(TAB, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents on(String key, EventListener handler) {
    return addHandler(key, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents on(String key, KeyboardEventOptions options, EventListener handler) {
    return addHandler(key, contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents any(KeyboardEventOptions options, EventListener handler) {
    return addGlobalHandler(contextOf(handler, () -> options));
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents any(EventListener handler) {
    return addGlobalHandler(contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
  }

  private AcceptKeyEvents addHandler(String key, KeyEventHandlerContext keyEventHandlerContext) {
    if (!handlers.containsKey(key)) {
      handlers.put(key, new ArrayList<>());
    }
    handlers.get(key).add(keyEventHandlerContext);
    return this;
  }

  private AcceptKeyEvents addGlobalHandler(KeyEventHandlerContext keyEventHandlerContext) {
    globalHandlers.add(keyEventHandlerContext);
    return this;
  }

  private KeyEventHandlerContext contextOf(
      EventListener handler, Supplier<KeyboardEventOptions> options) {
    return new KeyEventHandlerContext(handler, options);
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents clearAll() {
    handlers.clear();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public AcceptKeyEvents clear(String key) {
    if (handlers.containsKey(key)) {
      handlers.get(key).clear();
    }
    return this;
  }
}
