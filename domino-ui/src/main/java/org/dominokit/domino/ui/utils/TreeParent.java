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

import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.tree.TreeItemFilter;

/**
 * The {@code TreeParent} interface represents a parent node in a tree structure.
 *
 * @param <T> The type of data associated with tree items.
 */
public interface TreeParent<T> {

  /**
   * Gets the currently active tree item within this parent.
   *
   * @return The active tree item, or {@code null} if none is active.
   */
  TreeItem<T> getActiveItem();

  /**
   * Sets the active tree item within this parent.
   *
   * @param activeItem The tree item to set as active.
   */
  void setActiveItem(TreeItem<T> activeItem);

  /**
   * Sets the active tree item within this parent and optionally suppresses events.
   *
   * @param activeItem The tree item to set as active.
   * @param silent {@code true} to suppress events, {@code false} otherwise.
   */
  void setActiveItem(TreeItem<T> activeItem, boolean silent);

  /**
   * Gets the root of the tree structure to which this parent belongs.
   *
   * @return The root tree.
   */
  Tree<T> getTreeRoot();

  /**
   * Checks if auto-expand of found items is enabled.
   *
   * @return {@code true} if auto-expand is enabled, {@code false} otherwise.
   */
  boolean isAutoExpandFound();

  /**
   * Expands the current node.
   *
   * @return This tree parent after expansion.
   */
  TreeParent<T> expandNode();

  /**
   * Expands the current node and optionally expands its parent node.
   *
   * @param expandParent {@code true} to expand the parent, {@code false} otherwise.
   * @return This tree parent after expansion.
   */
  TreeParent<T> expandNode(boolean expandParent);

  /** Activates the current tree parent. */
  void activate();

  /**
   * Activates the current tree parent and optionally activates its parent node.
   *
   * @param activateParent {@code true} to activate the parent, {@code false} otherwise.
   */
  void activate(boolean activateParent);

  /**
   * Gets the parent tree parent, if one exists.
   *
   * @return An optional containing the parent tree parent, or an empty optional if none exists.
   */
  Optional<TreeParent<T>> getParent();

  /**
   * Removes the specified tree item from this tree parent.
   *
   * @param item The tree item to remove.
   */
  void removeItem(TreeItem<T> item);

  /**
   * Gets a list of sub-items contained within this tree parent.
   *
   * @return A list of sub-items.
   */
  List<TreeItem<T>> getSubItems();

  /**
   * Gets the filter used to filter tree items within this parent.
   *
   * @return The tree item filter.
   */
  TreeItemFilter<TreeItem<T>> getFilter();

  /**
   * Gets the underlying sub-tree element of this parent.
   *
   * @return The sub-tree element.
   */
  UListElement getSubTree();

  /**
   * Gets the value associated with this tree parent.
   *
   * @return The value.
   */
  T getValue();
}
