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

import elemental2.dom.DragEvent;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * Defines draggable elements.
 *
 * <p>Each drag source has a list of draggable elements (i.e. can be dragged and dropped)
 */
@Deprecated
public class DragSource {

  private static final String DRAGGING = "dragging";

  private final Map<String, Draggable> draggables = new HashMap<>();

  /**
   * Defines element as draggable
   *
   * @param draggable the element
   */
  public void addDraggable(HTMLElement draggable) {
    DominoElement<? extends HTMLElement> dominoElement = DominoElement.of(draggable);
    addDraggable(dominoElement.getDominoId(), draggable);
  }

  /**
   * Defines element as draggable
   *
   * @param draggable the element
   */
  public void addDraggable(IsElement<? extends HTMLElement> draggable) {
    addDraggable(draggable.element());
  }

  /**
   * Defines element as draggable
   *
   * @param draggable the element
   * @param id element id that will be passed to drop zone whenever this draggable has been dropped
   */
  public void addDraggable(String id, IsElement<? extends HTMLElement> draggable) {
    addDraggable(id, draggable.element());
  }

  /**
   * Defines element as draggable
   *
   * @param draggable the element
   * @param id element id that will be passed to drop zone whenever this draggable has been dropped
   */
  public void addDraggable(String id, HTMLElement draggable) {
    draggables.put(id, new Draggable(id, draggable));
  }

  public void removeDraggable(String id) {
    if (draggables.containsKey(id)) {
      Draggable draggable = draggables.get(id);
      draggable.detach();
      draggables.remove(id);
    }
  }

  private static class Draggable {

    private final HTMLElement element;
    private final EventListener eventListener;

    private Draggable(String id, HTMLElement element) {
      this.element = element;
      DominoElement<? extends HTMLElement> dominoElement = DominoElement.of(element);
      element.draggable = true;
      eventListener = evt -> onDragStart(evt, element, id);
      dominoElement.addEventListener("dragstart", eventListener);
    }

    private void onDragStart(Event evt, HTMLElement draggable, String id) {
      DragEvent e = (DragEvent) evt;
      e.dataTransfer.setData("draggable_id", id);
      e.dataTransfer.dropEffect = "move";
      draggable.classList.add(DRAGGING);
    }

    public void detach() {
      element.draggable = false;
      element.removeEventListener("dragstart", eventListener);
    }
  }
}
