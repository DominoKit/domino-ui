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

import elemental2.dom.EventListener;

public interface AcceptKeyEvents {

  /**
   * On ctrl + backspace buttons pressed
   *
   * @param backspaceHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onBackspace(EventListener backspaceHandler);

  /**
   * On ctrl + backspace buttons pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param backspaceHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onBackspace(KeyboardEventOptions options, EventListener backspaceHandler);

  // ---------------- handlers ----------------
  /**
   * On escape button pressed
   *
   * @param escapeHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onEscape(EventListener escapeHandler);

  /**
   * On escape button pressed with {@code options}
   *
   * @param options the {@link KeyboardEventOptions}
   * @param escapeHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onEscape(KeyboardEventOptions options, EventListener escapeHandler);

  /**
   * On arrow up or arrow down buttons pressed
   *
   * @param arrowDownHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowUpDown(EventListener arrowDownHandler);

  /**
   * On arrow up or arrow down buttons pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param arrowDownHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowUpDown(KeyboardEventOptions options, EventListener arrowDownHandler);

  /**
   * On arrow down button pressed
   *
   * @param arrowDownHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowDown(EventListener arrowDownHandler);

  /**
   * On arrow down button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param arrowDownHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowDown(KeyboardEventOptions options, EventListener arrowDownHandler);

  /**
   * On arrow up button pressed with options
   *
   * @param arrowUpHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowUp(EventListener arrowUpHandler);

  /**
   * On arrow up button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param arrowUpHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowUp(KeyboardEventOptions options, EventListener arrowUpHandler);

  /**
   * On arrow right button pressed with options
   *
   * @param arrowUpHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowRight(EventListener arrowUpHandler);

  /**
   * On arrow right button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param arrowUpHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowRight(KeyboardEventOptions options, EventListener arrowUpHandler);

  /**
   * On arrow right button pressed with options
   *
   * @param arrowUpHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowLeft(EventListener arrowUpHandler);

  /**
   * On arrow right button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param arrowUpHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onArrowLeft(KeyboardEventOptions options, EventListener arrowUpHandler);

  /**
   * On enter button pressed
   *
   * @param enterHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onEnter(EventListener enterHandler);

  /**
   * On enter button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param enterHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onEnter(KeyboardEventOptions options, EventListener enterHandler);

  /**
   * On delete button pressed
   *
   * @param deleteHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onDelete(EventListener deleteHandler);

  /**
   * On delete button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param deleteHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onDelete(KeyboardEventOptions options, EventListener deleteHandler);

  /**
   * On space button pressed
   *
   * @param spaceHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onSpace(EventListener spaceHandler);

  /**
   * On space button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param spaceHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onSpace(KeyboardEventOptions options, EventListener spaceHandler);

  /**
   * On tab button pressed
   *
   * @param tabHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onTab(EventListener tabHandler);

  /**
   * On tab button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param tabHandler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents onTab(KeyboardEventOptions options, EventListener tabHandler);

  /**
   * On key button pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param handler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents on(String key, KeyboardEventOptions options, EventListener handler);

  /**
   * On key button pressed
   *
   * @param handler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents on(String key, EventListener handler);
  /**
   * On key pressed with options
   *
   * @param options the {@link KeyboardEventOptions}
   * @param handler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents any(KeyboardEventOptions options, EventListener handler);

  /**
   * On key pressed
   *
   * @param handler the {@link EventListener} to call
   * @return same instance
   */
  AcceptKeyEvents any(EventListener handler);

  AcceptKeyEvents clearAll();

  AcceptKeyEvents clear(String key);
}
