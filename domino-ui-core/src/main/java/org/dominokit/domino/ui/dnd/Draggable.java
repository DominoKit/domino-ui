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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.*;
import java.util.Objects;
import java.util.function.Consumer;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Represents an element that can be dragged by users.
 *
 * <p>This utility makes any given element draggable and provides an interface for interacting with
 * the drag-and-drop process.
 *
 * <p>Example usage:
 *
 * <pre>
 * Draggable&lt;MyElement&gt; draggable = Draggable.of(myElementInstance);
 * draggable.detach(); // To stop the element from being draggable
 * </pre>
 *
 * @param <E> the type of the draggable element which should implement {@link IsElement}
 */
public class Draggable<E extends IsElement<? extends HTMLElement>> {

  private final String id;
  private final E element;
  private final EventListener eventListener;
  private final Consumer<E> dragStartListener;
  private DraggableConfig config = () -> true;

  /**
   * Creates a draggable instance for the specified element.
   *
   * @param element the element to be made draggable
   * @param <E> the type of the element
   * @return a new Draggable instance
   */
  public static <E extends IsElement<? extends HTMLElement>> Draggable<E> of(E element) {
    return new Draggable<>(element);
  }

  /**
   * Creates a draggable instance for the specified element with a drag start listener.
   *
   * @param element the element to be made draggable
   * @param dragStartListener listener for the drag start event
   * @param <E> the type of the element
   * @return a new Draggable instance
   */
  public static <E extends IsElement<? extends HTMLElement>> Draggable<E> of(
      E element, Consumer<E> dragStartListener) {
    return new Draggable<>(element, dragStartListener);
  }

  /**
   * Creates a draggable instance for the specified element with a unique identifier.
   *
   * @param id unique identifier for the draggable element
   * @param element the element to be made draggable
   * @param <E> the type of the element
   * @return a new Draggable instance
   */
  public static <E extends IsElement<? extends HTMLElement>> Draggable<E> of(String id, E element) {
    return new Draggable<>(id, element);
  }

  /**
   * Creates a draggable instance for the specified element with a unique identifier and drag start
   * listener.
   *
   * @param id unique identifier for the draggable element
   * @param element the element to be made draggable
   * @param dragStartListener listener for the drag start event
   * @param <E> the type of the element
   * @return a new Draggable instance
   */
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
    if (config.isEnabled()) {
      DragEvent e = (DragEvent) evt;
      e.dataTransfer.setData("draggable_id", id);
      e.dataTransfer.dropEffect = "move";
      draggable.element().classList.add(DragSource.DRAGGING);
      dragStartListener.accept(draggable);
    } else {
      evt.preventDefault();
    }
  }

  /**
   * @return Draggble item DraggableConfig
   */
  public DraggableConfig getConfig() {
    return config;
  }

  /**
   * Sets the configuration for the draggble item, if null use a default config
   *
   * @param config DraggableConfig
   */
  public void setConfig(DraggableConfig config) {
    if (nonNull(config)) {
      this.config = config;
    } else {
      this.config = () -> true;
    }
  }

  /** Detaches the draggable feature from the element. */
  public void detach() {
    element.element().draggable = false;
    element.element().removeEventListener("dragstart", eventListener);
  }

  /**
   * Returns the unique identifier of the draggable element.
   *
   * @return the unique identifier
   */
  public String getId() {
    return id;
  }

  public interface DraggableConfig {
    boolean isEnabled();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Draggable)) {
      return false;
    }
    Draggable<?> draggable = (Draggable<?>) o;
    return Objects.equals(id, draggable.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
