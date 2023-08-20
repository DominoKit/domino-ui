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
 * Defines draggable elements.
 *
 * <p>Each drag source has a list of draggable elements (i.e. can be dragged and dropped)
 */
public class DragSource {

  static final String DRAGGING = "dragging";

  private final Map<String, Draggable> draggables = new HashMap<>();

  /**
   * Defines element as draggable
   *
   * @param draggable the element
   */
  public void addDraggable(Draggable<?> draggable) {
    draggables.put(draggable.getId(), draggable);
  }

  /**
   * removeDraggable.
   *
   * @param id a {@link java.lang.String} object
   */
  public void removeDraggable(String id) {
    if (draggables.containsKey(id)) {
      Draggable draggable = draggables.get(id);
      draggable.detach();
      draggables.remove(id);
    }
  }
}
