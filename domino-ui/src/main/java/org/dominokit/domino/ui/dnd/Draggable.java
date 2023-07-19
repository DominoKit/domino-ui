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

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.*;
import java.util.function.Consumer;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class Draggable<E extends IsElement<? extends HTMLElement>> {

  private final String id;
  private final E element;
  private final EventListener eventListener;
  private final Consumer<E> dragStartListener;

  public static <E extends IsElement<? extends HTMLElement>> Draggable<E> of(E element) {
    return new Draggable<>(element);
  }

  public static <E extends IsElement<? extends HTMLElement>> Draggable<E> of(
      E element, Consumer<E> dragStartListener) {
    return new Draggable<>(element, dragStartListener);
  }

  public static <E extends IsElement<? extends HTMLElement>> Draggable<E> of(String id, E element) {
    return new Draggable<>(id, element);
  }

  public static <E extends IsElement<? extends HTMLElement>> Draggable<E> of(
      String id, E element, Consumer<E> dragStartListener) {
    return new Draggable<>(id, element, dragStartListener);
  }

  Draggable(E element) {
    this(elements.elementOf(element.element()).getDominoId(), element, e -> {});
  }

  Draggable(E element, Consumer<E> dragStartListener) {
    this(elements.elementOf(element.element()).getDominoId(), element, dragStartListener);
  }

  Draggable(String id, E element) {
    this(id, element, e -> {});
  }

  Draggable(String id, E element, Consumer<E> dragStartListener) {
    this.id = id;
    this.element = element;
    this.dragStartListener = dragStartListener;
    DominoElement<? extends Element> dominoElement = elements.elementOf(element.element());
    element.element().draggable = true;
    eventListener = evt -> onDragStart(evt, element, id);
    dominoElement.addEventListener("dragstart", eventListener);
  }

  private void onDragStart(Event evt, E draggable, String id) {
    DragEvent e = (DragEvent) evt;
    e.dataTransfer.setData("draggable_id", id);
    e.dataTransfer.dropEffect = "move";
    draggable.element().classList.add(DragSource.DRAGGING);
    dragStartListener.accept(draggable);
  }

  public void detach() {
    element.element().draggable = false;
    element.element().removeEventListener("dragstart", eventListener);
  }

  public String getId() {
    return id;
  }
}
