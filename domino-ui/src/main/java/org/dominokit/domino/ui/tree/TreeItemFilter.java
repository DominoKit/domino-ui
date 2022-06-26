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

import java.util.function.BiPredicate;

/**
 * An interface for filtering the tree item based on a search token
 *
 * @param <T> the type of the value
 * @deprecated use {@link BiPredicate} instead
 */
@FunctionalInterface
@Deprecated
public interface TreeItemFilter<T> {
  /**
   * @param treeItem the tree item to filter
   * @param searchToken the search token
   * @return true if the item should be shown, false otherwise
   */
  boolean filter(T treeItem, String searchToken);
}
