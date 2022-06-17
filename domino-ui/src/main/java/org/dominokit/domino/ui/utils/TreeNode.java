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

/**
 * An interface representing a tree node
 *
 * @param <T> the type of the child tree nodes
 */
public interface TreeNode<T extends TreeNode<T>> {
  /** @return The parent of this tree node */
  TreeNode<T> getParentNode();

  /** @return The children of this tree node */
  List<T> getChildNodes();

  /**
   * @param node The Node to test with.
   * @return a boolean value indicating whether a node is a descendant of a given node
   */
  default boolean contains(T node) {
    if (this == node) return true;

    for (T treeNode : getChildNodes()) {
      if (treeNode.contains(node)) return true;
    }

    return false;
  }

  /** @return The root of this tree node */
  default TreeNode<T> getRootNode() {
    TreeNode<T> parentNode = getParentNode();

    if (parentNode == null) return this;

    return parentNode.getParentNode();
  }

  /** @return A boolean value indicating of this tree node has child nodes or not */
  default boolean hasChildNodes() {
    return getChildNodes().size() > 0;
  }

  /**
   * @param node A child tree node to be removed from this tree node
   * @return The removed tree node
   */
  default T removeChild(T node) {
    getChildNodes().remove(node);

    return node;
  }
}
