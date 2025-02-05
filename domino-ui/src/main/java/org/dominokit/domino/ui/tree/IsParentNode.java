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

import java.util.Optional;

/**
 * An interface representing a parent node in a tree-like structure. Defines the minimal contract
 * for a node that can hold children, expand to show them, and integrate into a root tree hierarchy.
 *
 * <p>Methods:
 *
 * <ul>
 *   <li>{@link #getRootNode()} - obtains the {@link RootNode} that this node ultimately belongs to
 *   <li>{@link #expandNode()} / {@link #expandNode(boolean)} - expands this node (and optionally
 *       parent nodes)
 *   <li>{@link #getFilter()} - retrieves the filter logic used to determine visibility/matching
 *       (e.g., for search)
 *   <li>{@link #getParent()} - returns the parent node, if any
 *   <li>{@link #removeNode(TreeNode)} - removes a child node
 *   <li>{@link #getValue()} / {@link #setValue(Object)} - manages the data value associated with
 *       this node
 * </ul>
 *
 * <p>This interface also extends {@link HasActiveNode} to provide for activation (focus/selection)
 * logic at the parent level.
 *
 * @param <V> the type of data value or model object stored in nodes
 * @param <N> the node type (e.g., a concrete subclass of {@link TreeNode})
 * @param <S> the selection type, often the same as the node type or a collection of nodes
 */
public interface IsParentNode<V, N extends TreeNode<V, N, S>, S> extends HasActiveNode<V, N, S> {

  /**
   * Returns the root of the tree that this node is ultimately part of. The root node typically
   * manages high-level tree behaviors (e.g., auto-collapse, icon suppliers).
   *
   * @return the root node of this tree hierarchy
   */
  RootNode<V, N, S> getRootNode();

  /**
   * Expands this node to show its children (if any). Behavior may vary depending on the tree
   * configuration (e.g., auto-collapse of siblings, etc.).
   *
   * @return this node (for method chaining)
   */
  IsParentNode<V, N, S> expandNode();

  /**
   * Expands this node, optionally also expanding all parent nodes up the hierarchy. Useful for
   * ensuring a path is fully visible from the root down to this node.
   *
   * @param expandParent if true, also expands parent nodes
   * @return this node (for method chaining)
   */
  IsParentNode<V, N, S> expandNode(boolean expandParent);

  /**
   * Retrieves the filter logic that determines if this node (and its subtree) match certain
   * criteria (e.g., a search token). Often implemented at the root node, then inherited by
   * children.
   *
   * @return the current filter logic for this node
   */
  TreeItemFilter<N> getFilter();

  /**
   * Returns an optional reference to this node's parent, if it exists. If the node is at the root
   * level, the result is typically empty (no parent).
   *
   * @return an {@link Optional} containing the parent node
   */
  Optional<IsParentNode<V, N, S>> getParent();

  /**
   * Removes a child node from this node's subtree. If the node is not a direct child,
   * implementations may ignore or handle it differently.
   *
   * @param node the node to remove
   */
  void removeNode(N node);

  /**
   * Retrieves the data value associated with this node, if any. This is typically the model object
   * or identifier linked to the node's display.
   *
   * @return the data value for this node
   */
  V getValue();

  /**
   * Sets the data value associated with this node. Useful for changing the underlying model object
   * without recreating the node.
   *
   * @param value the new data value
   */
  void setValue(V value);
}
