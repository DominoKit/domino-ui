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
package org.dominokit.domino.ui.tree;

/**
 * An interface for tree structures or nodes that track a single "active" (e.g., focused) node.
 *
 * <p>Commonly, "active" refers to a highlighted node in the tree. Depending on the implementation,
 * activation may also trigger actions like expanding/collapsing or scrolling the node into view.
 *
 * @param <V> the data value type held by the node
 * @param <N> the node type (e.g., a subclass of {@link TreeNode})
 * @param <S> the type representing the overall selection or active state
 */
public interface HasActiveNode<V, N extends TreeNode<V, N, S>, S> {

  /**
   * Sets the specified node as the active node in this tree or subtree. Behaviors may include
   * highlighting the node, deactivating previously active nodes, or other custom responses.
   *
   * @param node the node to activate
   */
  void setActiveNode(N node);

  /**
   * Sets the specified node as the active node, optionally suppressing event notifications or other
   * side effects.
   *
   * @param node the node to activate
   * @param silent {@code true} to suppress event notifications, {@code false} to allow them
   */
  void setActiveNode(N node, boolean silent);

  /**
   * Retrieves the node currently marked as active, if any.
   *
   * @return the active node, or {@code null} if none is active
   */
  N getActiveNode();
}
