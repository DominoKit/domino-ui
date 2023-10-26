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

import java.util.Set;

/**
 * The {@code CollapsibleElement} interface represents an element that can be collapsed or expanded.
 * Implementations of this interface can be toggled between a collapsed and expanded state, and
 * listeners can be added to handle events when the element is collapsed or expanded.
 *
 * @param <T> The type of the implementing class.
 * @see CollapseHandler
 * @see ExpandHandler
 */
public interface CollapsibleElement<T> {

  /**
   * Sets whether the element is collapsible or not.
   *
   * @param collapsible {@code true} if the element should be collapsible, {@code false} otherwise.
   * @return The instance of the implementing class.
   */
  T setCollapsible(boolean collapsible);

  /**
   * Toggles the collapse/expand state of the element.
   *
   * @return The instance of the implementing class.
   */
  T toggleCollapse();

  /**
   * Toggles the collapse/expand state of the element.
   *
   * @param collapse {@code true} to collapse the element, {@code false} to expand it.
   * @return The instance of the implementing class.
   */
  T toggleCollapse(boolean collapse);

  /**
   * Expands the element.
   *
   * @return The instance of the implementing class.
   */
  T expand();

  /**
   * Collapses the element.
   *
   * @return The instance of the implementing class.
   */
  T collapse();

  /**
   * Checks if the element is currently in a collapsed state.
   *
   * @return {@code true} if the element is collapsed, {@code false} otherwise.
   */
  boolean isCollapsed();

  /**
   * Retrieves the set of {@link CollapseHandler} instances attached to this element.
   *
   * @return A set of {@link CollapseHandler} instances.
   */
  Set<CollapseHandler<T>> getCollapseHandlers();

  /**
   * Retrieves the set of {@link ExpandHandler} instances attached to this element.
   *
   * @return A set of {@link ExpandHandler} instances.
   */
  Set<ExpandHandler<T>> getExpandHandlers();

  /**
   * Adds a {@link CollapseHandler} to listen for collapse events on this element.
   *
   * @param handler The {@link CollapseHandler} to add.
   * @return The instance of the implementing class.
   */
  default T addCollapseHandler(CollapseHandler<T> handler) {
    getCollapseHandlers().add(handler);
    return (T) this;
  }

  /**
   * Adds an {@link ExpandHandler} to listen for expand events on this element.
   *
   * @param handler The {@link ExpandHandler} to add.
   * @return The instance of the implementing class.
   */
  default T addExpandHandler(ExpandHandler<T> handler) {
    getExpandHandlers().add(handler);
    return (T) this;
  }

  /**
   * Removes a {@link CollapseHandler} from listening for collapse events on this element.
   *
   * @param handler The {@link CollapseHandler} to remove.
   * @return The instance of the implementing class.
   */
  default T removeCollapseHandler(CollapseHandler<T> handler) {
    getCollapseHandlers().remove(handler);
    return (T) this;
  }

  /**
   * Removes an {@link ExpandHandler} from listening for expand events on this element.
   *
   * @param handler The {@link ExpandHandler} to remove.
   * @return The instance of the implementing class.
   */
  default T removeExpandHandler(ExpandHandler<T> handler) {
    getExpandHandlers().remove(handler);
    return (T) this;
  }

  /**
   * A functional interface for handling collapse events on a {@code CollapsibleElement}.
   *
   * @param <T> The type of the implementing class.
   */
  @FunctionalInterface
  interface CollapseHandler<T> {
    /**
     * Called when the element is collapsed.
     *
     * @param element The instance of the implementing class.
     */
    void onCollapsed(T element);
  }

  /**
   * A functional interface for handling expand events on a {@code CollapsibleElement}.
   *
   * @param <T> The type of the implementing class.
   */
  @FunctionalInterface
  interface ExpandHandler<T> {
    /**
     * Called when the element is expanded.
     *
     * @param element The instance of the implementing class.
     */
    void onExpanded(T element);
  }
}
