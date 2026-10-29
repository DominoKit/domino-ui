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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DominoEvents {
  public static final String ANY = "*";
  private Map<String, List<DominoEventListener>> events = new HashMap<>();

  public DominoEvents() {
    this.events.put(ANY, new ArrayList<>());
  }

  /**
   * Registers the same event listener for multiple event types.
   *
   * @param listener the listener to be added
   * @param types the events types
   * @return the current DominoEvents instance
   */
  public DominoEvents addEventListener(DominoEventListener listener, String... types) {
    Arrays.asList(types).forEach(type -> addEventListener(type, listener));
    return this;
  }

  /**
   * Registers an event listener for the specified event type.
   *
   * @param type the event type
   * @param listener the listener to be added
   * @return the current DominoEvents instance
   */
  public DominoEvents addEventListener(String type, DominoEventListener listener) {
    if (!events.containsKey(type)) {
      events.put(type, new ArrayList<>());
    }
    events.get(type).add(listener);
    return this;
  }

  /**
   * Registers the same event listener for multiple event types.
   *
   * @param listener the listener to be added
   * @param types the events types
   * @return the current DominoEvents instance
   */
  public Register registerEventListener(DominoEventListener listener, String... types) {
    Arrays.asList(types).forEach(type -> addEventListener(type, listener));
    return () -> removeListener(listener, types);
  }

  /**
   * Registers an event listener for the specified event type.
   *
   * @param type the event type
   * @param listener the listener to be added
   * @return the current DominoEvents instance
   */
  public Register registerEventListener(String type, DominoEventListener listener) {
    if (!events.containsKey(type)) {
      events.put(type, new ArrayList<>());
    }
    events.get(type).add(listener);
    return () -> removeListener(type, listener);
  }

  /**
   * Removes a registered event listener for multiple event types.
   *
   * @param listener the listener to be removed
   * @param types the events types
   * @return the current DominoEvents instance
   */
  public DominoEvents removeListener(DominoEventListener listener, String... types) {
    Arrays.asList(types).forEach(type -> removeListener(type, listener));
    return this;
  }

  /**
   * Removes a registered event listener for the specified event type.
   *
   * @param type the event type
   * @param listener the listener to be removed
   * @return the current DominoEvents instance
   */
  public DominoEvents removeListener(String type, DominoEventListener listener) {
    if (events.containsKey(type)) {
      events.get(type).remove(listener);
    }
    return this;
  }

  /**
   * Fires a specified event.
   *
   * @param event the event to fire
   * @return the current DominoEvents instance
   */
  public DominoEvents fireEvent(DominoEvent event) {
    if (events.containsKey(event.getType())) {
      events.get(event.getType()).forEach(listener -> listener.handleEvent(event));
    }

    events.get(ANY).forEach(listener -> listener.handleEvent(event));
    return this;
  }
}
