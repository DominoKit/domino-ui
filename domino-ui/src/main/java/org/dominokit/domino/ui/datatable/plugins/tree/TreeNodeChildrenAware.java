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

package org.dominokit.domino.ui.datatable.plugins.tree;

/**
 * An interface to indicate whether a specific item in a tree structure has children.
 *
 * @param <T> The type of items in the tree.
 */
public interface TreeNodeChildrenAware<T> {

  /**
   * Checks if the specified item has children.
   *
   * @param record The item to check for children.
   * @return {@code true} if the item has children, {@code false} otherwise.
   */
  boolean hasChildren(T record);
}
