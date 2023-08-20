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
 * An interface representing a parent tree item
 *
 * @param <T> the type of the object
 */
public interface TreeParent<T> {
  /** @return The current active value */
  /**
   * getActiveItem.
   *
   * @return a {@link org.dominokit.domino.ui.tree.TreeItem} object
   */
  TreeItem<T> getActiveItem();

  /**
   * Activates the item representing the value
   *
   * @param activeItem the value of the item to activate
   */
  void setActiveItem(TreeItem<T> activeItem);

  /**
   * Activates the item representing the value
   *
   * @param activeItem the value of the item to activate
   * @param silent true to not notify listeners
   */
  void setActiveItem(TreeItem<T> activeItem, boolean silent);

  /** @return The {@link Tree} */
  /**
   * getTreeRoot.
   *
   * @return a {@link org.dominokit.domino.ui.tree.Tree} object
   */
  Tree<T> getTreeRoot();

  /** @return true if automatic expanding is enabled when finding items in search */
  /**
   * isAutoExpandFound.
   *
   * @return a boolean
   */
  boolean isAutoExpandFound();

  /**
   * Expands the tree item
   *
   * @return same instance
   */
  TreeParent<T> expandNode();

  /**
   * Expands the tree item
   *
   * @param expandParent true to expand the parent of the item
   * @return same instance
   */
  TreeParent<T> expandNode(boolean expandParent);

  /** Activates the item */
  void activate();

  /**
   * Activates the item
   *
   * @param activateParent true to activate parent
   */
  void activate(boolean activateParent);

  /** @return the parent item */
  /**
   * getParent.
   *
   * @return a {@link java.util.Optional} object
   */
  Optional<TreeParent<T>> getParent();

  /**
   * Removes item
   *
   * @param item the item value
   */
  void removeItem(TreeItem<T> item);

  /** @return the children of this item */
  /**
   * getSubItems.
   *
   * @return a {@link java.util.List} object
   */
  List<TreeItem<T>> getSubItems();

  /** @return the {@link TreeItemFilter} */
  /**
   * getFilter.
   *
   * @return a {@link org.dominokit.domino.ui.tree.TreeItemFilter} object
   */
  TreeItemFilter<TreeItem<T>> getFilter();

  /**
   * getSubTree.
   *
   * @return a {@link org.dominokit.domino.ui.elements.UListElement} object
   */
  UListElement getSubTree();

  /**
   * getValue.
   *
   * @return a T object
   */
  T getValue();
}
