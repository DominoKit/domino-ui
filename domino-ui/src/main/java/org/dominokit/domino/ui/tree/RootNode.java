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
 * Represents the root of a tree structure, providing common behaviors and configurations for all
 * nodes within the tree.
 *
 * <p>Notable capabilities include:
 *
 * <ul>
 *   <li>Tracking and managing an active node (see {@link HasActiveNode})
 *   <li>Controlling whether nodes automatically collapse or expand under certain conditions
 *   <li>Supplying icons for nodes via a {@link NodeIconSupplier}
 *   <li>Receiving notifications when a node's active state or selection changes
 * </ul>
 *
 * @param <V> the type of data value associated with each node
 * @param <N> the node (tree item) type
 * @param <S> the type representing the selection (often the node type or a list of nodes)
 */
public interface RootNode<V, N extends TreeNode<V, N, S>, S> extends HasActiveNode<V, N, S> {

  /**
   * Indicates whether parent nodes should automatically collapse when a new node is activated or
   * expanded.
   *
   * @return true if automatic collapse is enabled, false otherwise
   */
  boolean isAutoCollapse();

  /**
   * Indicates whether nodes should automatically expand when they match a search or filtering
   * criterion (e.g., "found" nodes in a search).
   *
   * @return true if automatic expansion of found nodes is enabled, false otherwise
   */
  boolean isAutoExpandFound();

  /**
   * Retrieves the {@link NodeIconSupplier} responsible for providing icons to each node within the
   * tree.
   *
   * @return a {@link NodeIconSupplier} instance
   */
  NodeIconSupplier<V, N, S> getIconSupplier();

  /**
   * Called when the active node changes within this tree (e.g., a node is activated or
   * re-activated).
   *
   * @param node the node that is now active
   * @param selection the current selection in the tree
   * @param silent true if the change should not trigger user-facing events, false otherwise
   */
  default void onActiveNodeChanged(N node, S selection, boolean silent) {}

  /**
   * Called when a node is deselected (or changes its selection state) in this tree.
   *
   * @param source the node that triggered the deselection event
   * @param selection the current selection in the tree after deselection
   */
  void onDeselectionChanged(N source, S selection);
}
