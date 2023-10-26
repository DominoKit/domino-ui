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
package org.dominokit.domino.ui.dnd;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of draggable elements providing functionality to add and remove them.
 *
 * <p>This class maintains a map of draggable elements and offers methods to dynamically manage
 * which elements are draggable at a given time. Example usage:
 *
 * <pre>
 * DragSource source = new DragSource();
 * Draggable&lt;MyElement&gt; draggable = Draggable.of(myElementInstance);
 * source.addDraggable(draggable);
 * source.removeDraggable(draggable.getId());
 * </pre>
 */
public class DragSource {

  /** Constant representing a CSS class used to denote an element is currently being dragged. */
  static final String DRAGGING = "dragging";

  /** Map of draggable elements indexed by their ID. */
  private final Map<String, Draggable> draggables = new HashMap<>();

  /**
   * Adds a new {@link Draggable} element to the manager.
   *
   * @param draggable the draggable element to be added
   */
  public void addDraggable(Draggable<?> draggable) {
    draggables.put(draggable.getId(), draggable);
  }

  /**
   * Removes a {@link Draggable} element from the manager using its ID.
   *
   * <p>If an element with the provided ID is found, it is first detached (made non-draggable) and
   * then removed from the manager.
   *
   * @param id the unique identifier of the draggable element to be removed
   */
  public void removeDraggable(String id) {
    if (draggables.containsKey(id)) {
      Draggable draggable = draggables.get(id);
      draggable.detach();
      draggables.remove(id);
    }
  }
}
