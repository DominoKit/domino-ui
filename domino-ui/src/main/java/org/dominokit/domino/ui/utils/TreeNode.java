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
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/** An interface representing a tree node */
public interface TreeNode {
  /** @return the parent of this tree node */
  TreeNode getParentNode();

  /** @return the children of this tree node */
  <T extends TreeNode> List<T> getChildNodes();

  /**
   * Returns an {@link Optional} tree node if it matches the given predicate
   *
   * @param predicate a predicate to test with
   * @return an {@code Optional} tree node matching the given predicate
   */
  default <T extends TreeNode> Optional<T> findAny(Predicate<TreeNode> predicate) {
    if (predicate.test(this)) return Optional.of((T) this);

    for (TreeNode childNode : getChildNodes()) {
      Optional<T> found = childNode.findAny(predicate);

      if (found.isPresent()) return found;
    }

    return Optional.empty();
  }

  /**
   * @param node a node to test with
   * @return a boolean value indicating whether a node is a descendant of a given node
   */
  default boolean contains(TreeNode node) {
    return findAny(n -> n == node).isPresent();
  }

  /**
   * Search this three node and all its descendant tree nodes. A {@link BiPredicate} is used, which
   * also holds an indicator if there is any match in its descendant tree nodes.
   *
   * @param predicate a predicate to test with
   * @return a boolean value indication whether there is any match of this tree node and its
   *     descendant tree nodes against the given predicate
   */
  default boolean search(BiPredicate<TreeNode, Boolean> predicate) {
    boolean found = false;

    for (TreeNode childNode : getChildNodes()) {
      found |= childNode.search(predicate);
    }

    return predicate.test(this, found);
  }

  /** @return the root of this tree node */
  default TreeNode getRootNode() {
    TreeNode parentNode = getParentNode();

    if (parentNode == null) return this;

    return parentNode.getParentNode();
  }

  /** @return a boolean value indicating of this tree node has child nodes or not */
  default boolean hasChildNodes() {
    return getChildNodes().size() > 0;
  }

  /**
   * @param node a child tree node to be removed from this tree node
   * @return the removed tree node
   */
  default TreeNode removeChild(TreeNode node) {
    getChildNodes().remove(node);

    return node;
  }
}
