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

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.DragEvent;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A manager for drop targets in a Drag-and-Drop system.
 *
 * <p>The DropZone class allows the easy addition and removal of drop targets. It provides
 * functionality to manage the dropping of dragged elements on registered targets. Example usage:
 *
 * <pre>
 * DropZone zone = new DropZone();
 * zone.addDropTarget(myHtmlElement, draggableId -> DomGlobal.console.info("Dropped: " + draggableId));
 * </pre>
 */
public class DropZone {

  /** Map containing the drop targets. */
  private final Map<HTMLElement, DropTarget> dropTargets = new HashMap<>();

  /**
   * Registers an {@link HTMLElement} as a drop target with a specified {@link DropListener}.
   *
   * @param element the HTML element to register as a drop target
   * @param dropListener the listener that will be invoked upon a drop event
   */
  public void addDropTarget(HTMLElement element, DropListener dropListener) {
    if (!dropTargets.containsKey(element)) {
      dropTargets.put(element, new DropTarget(element, dropListener));
    }
  }

  /**
   * Registers an {@link IsElement} as a drop target with a specified {@link DropListener}.
   *
   * @param element the IsElement to register as a drop target
   * @param dropListener the listener that will be invoked upon a drop event
   */
  public void addDropTarget(IsElement<? extends HTMLElement> element, DropListener dropListener) {
    addDropTarget(element.element(), dropListener);
  }

  /**
   * Unregisters an {@link HTMLElement} from being a drop target.
   *
   * @param element the HTML element to unregister as a drop target
   */
  public void removeDropTarget(HTMLElement element) {
    if (dropTargets.containsKey(element)) {
      dropTargets.get(element).detach();
      dropTargets.remove(element);
    }
  }

  /**
   * Unregisters an {@link IsElement} from being a drop target.
   *
   * @param element the IsElement to unregister as a drop target
   */
  public void removeDropTarget(IsElement<? extends HTMLElement> element) {
    removeDropTarget(element.element());
  }

  /**
   * A functional interface representing a drop listener. This will be triggered when an item is
   * dropped onto a registered target.
   */
  @FunctionalInterface
  public interface DropListener {
    /**
     * Called when a draggable element is dropped.
     *
     * @param draggableId the ID of the dropped element
     */
    void onDrop(String draggableId);
  }

  /** Inner class representing a drop target. */
  private static class DropTarget {

    private static final String DRAG_OVER = "drag-over";
    private final DominoElement<? extends HTMLElement> element;
    private final DropListener dropListener;
    private final EventListener onDragOver;
    private final EventListener onDragLeave;
    private final EventListener onDrop;

    /**
     * Constructs a new {@link DropTarget} with the given element and drop listener.
     *
     * @param element the HTML element to be registered as a drop target
     * @param dropListener the listener to be invoked upon a drop event
     */
    public DropTarget(HTMLElement element, DropListener dropListener) {
      this.element = elements.elementOf(element);
      this.dropListener = dropListener;
      onDragOver = this::onDragOver;
      onDragLeave = this::onDragLeave;
      onDrop = this::onDrop;
      element.addEventListener("dragover", onDragOver);
      element.addEventListener("dragleave", onDragLeave);
      element.addEventListener("drop", onDrop);
    }

    /**
     * Handles the drop event, calling the drop listener and removing any styles applied during drag
     * over.
     *
     * @param evt the drag event
     */
    private void onDrop(Event evt) {
      evt.preventDefault();
      element.removeCss(DRAG_OVER);
      DragEvent e = (DragEvent) evt;
      String draggableId = e.dataTransfer.getData("draggable_id");
      dropListener.onDrop(draggableId);
    }

    /**
     * Handles the drag leave event, removing any styles applied during drag over.
     *
     * @param evt the drag event
     */
    private void onDragLeave(Event evt) {
      evt.preventDefault();
      element.removeCss(DRAG_OVER);
    }

    /**
     * Handles the drag over event, applying a style to indicate the drag over state.
     *
     * @param evt the drag event
     */
    private void onDragOver(Event evt) {
      evt.preventDefault();
      element.addCss(DRAG_OVER);
    }

    /** Detaches this drop target, ensuring no further events will be listened to. */
    public void detach() {
      element.removeEventListener("dragover", onDragOver);
      element.removeEventListener("dragleave", onDragLeave);
      element.removeEventListener("drop", onDrop);
    }
  }
}
