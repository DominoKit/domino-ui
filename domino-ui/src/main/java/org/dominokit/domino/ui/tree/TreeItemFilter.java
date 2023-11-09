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
 * A functional interface for filtering tree items based on a search token.
 *
 * @param <T> The type of tree item to filter.
 */
@FunctionalInterface
public interface TreeItemFilter<T> {

  /**
   * Tests whether a given tree item should be included in the filtered results based on a search
   * token.
   *
   * @param treeItem The tree item to be tested.
   * @param searchToken The search token used for filtering.
   * @return {@code true} if the tree item should be included in the filtered results, {@code false}
   *     otherwise.
   */
  boolean filter(T treeItem, String searchToken);
}
