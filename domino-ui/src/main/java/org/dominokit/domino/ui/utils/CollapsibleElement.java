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

/** CollapsibleElement interface. */
public interface CollapsibleElement<T> {

  /**
   * setCollapsible.
   *
   * @param collapsible a boolean
   * @return a T object
   */
  T setCollapsible(boolean collapsible);

  /**
   * toggleCollapse.
   *
   * @return a T object
   */
  T toggleCollapse();

  /**
   * toggleCollapse.
   *
   * @param collapse a boolean
   * @return a T object
   */
  T toggleCollapse(boolean collapse);

  /**
   * expand.
   *
   * @return a T object
   */
  T expand();

  /**
   * collapse.
   *
   * @return a T object
   */
  T collapse();

  /**
   * isCollapsed.
   *
   * @return a boolean
   */
  boolean isCollapsed();

  /**
   * getCollapseHandlers.
   *
   * @return a {@link java.util.Set} object
   */
  Set<CollapseHandler<T>> getCollapseHandlers();

  /**
   * getExpandHandlers.
   *
   * @return a {@link java.util.Set} object
   */
  Set<ExpandHandler<T>> getExpandHandlers();

  /**
   * addCollapseHandler.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.CollapsibleElement.CollapseHandler}
   *     object
   * @return a T object
   */
  default T addCollapseHandler(CollapseHandler<T> handler) {
    getCollapseHandlers().add(handler);
    return (T) this;
  }

  /**
   * addExpandHandler.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.CollapsibleElement.ExpandHandler} object
   * @return a T object
   */
  default T addExpandHandler(ExpandHandler<T> handler) {
    getExpandHandlers().add(handler);
    return (T) this;
  }

  /**
   * removeCollapseHandler.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.CollapsibleElement.CollapseHandler}
   *     object
   * @return a T object
   */
  default T removeCollapseHandler(CollapseHandler<T> handler) {
    getCollapseHandlers().remove(handler);
    return (T) this;
  }

  /**
   * removeExpandHandler.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.CollapsibleElement.ExpandHandler} object
   * @return a T object
   */
  default T removeExpandHandler(ExpandHandler<T> handler) {
    getExpandHandlers().remove(handler);
    return (T) this;
  }

  @FunctionalInterface
  interface CollapseHandler<T> {
    void onCollapsed(T element);
  }

  /** A callback interface to attach some listener when showing an element. */
  @FunctionalInterface
  interface ExpandHandler<T> {
    void onExpanded(T element);
  }
}
