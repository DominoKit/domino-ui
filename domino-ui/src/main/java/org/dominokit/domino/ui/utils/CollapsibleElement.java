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

public interface CollapsibleElement<T> {

  T setCollapsible(boolean collapsible);

  T toggleCollapse();

  T toggleCollapse(boolean collapse);

  T expand();

  T collapse();

  boolean isCollapsed();

  Set<CollapseHandler<T>> getCollapseHandlers();

  Set<ExpandHandler<T>> getExpandHandlers();

  default T addCollapseHandler(CollapseHandler<T> handler) {
    getCollapseHandlers().add(handler);
    return (T) this;
  }

  default T addExpandHandler(ExpandHandler<T> handler) {
    getExpandHandlers().add(handler);
    return (T) this;
  }

  default T removeCollapseHandler(CollapseHandler<T> handler) {
    getCollapseHandlers().remove(handler);
    return (T) this;
  }

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
