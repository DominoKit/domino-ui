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
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * Define a drop zone.
 *
 * <p>Each drop zone has a list of drop targets that accept drop event. Each drop target has a
 * listener that will be called when a drop event happens passing the id of the element
 */
public class DropZone {

  /**
   * Adds {@code element} as a valid drop target
   *
   * @param element the valid drop target
   * @param dropListener listener to be called when a drop happens
   */
  public void addDropTarget(HTMLElement element, DropListener dropListener) {
    new DropTarget(element, dropListener);
  }

  /**
   * Adds {@code element} as a valid drop target
   *
   * @param element the valid drop target
   * @param dropListener listener to be called when a drop happens
   */
  public void addDropTarget(IsElement<? extends HTMLElement> element, DropListener dropListener) {
    addDropTarget(element.element(), dropListener);
  }

  /** Listener to be called when a drop event gets fired */
  @FunctionalInterface
  public interface DropListener {
    /** @param draggableId the draggable element id */
    void onDrop(String draggableId);
  }

  private static class DropTarget {

    private static final String DRAG_OVER = "drag-over";
    private final DominoElement<? extends HTMLElement> element;
    private final DropListener dropListener;

    public DropTarget(HTMLElement element, DropListener dropListener) {
      this.element = DominoElement.of(element);
      this.dropListener = dropListener;
      element.addEventListener("dragover", this::onDragOver);
      element.addEventListener("dragleave", this::onDragLeave);
      element.addEventListener("drop", this::onDrop);
    }

    private void onDrop(Event evt) {
      evt.preventDefault();
      element.removeCss(DRAG_OVER);
      DragEvent e = (DragEvent) evt;
      String draggableId = e.dataTransfer.getData("draggable_id");
      dropListener.onDrop(draggableId);
    }

    private void onDragLeave(Event evt) {
      evt.preventDefault();
      element.removeCss(DRAG_OVER);
    }

    private void onDragOver(Event evt) {
      evt.preventDefault();
      element.addCss(DRAG_OVER);
    }
  }
}
