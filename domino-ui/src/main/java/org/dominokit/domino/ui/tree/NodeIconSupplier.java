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

import org.dominokit.domino.ui.icons.Icon;

/**
 * An interface to provide custom icons for tree items.
 *
 * @param <N> The type of data associated with each tree item.
 */
public interface NodeIconSupplier<V, N extends TreeNode<V, N, S>, S> {
  /**
   * Creates an icon for the given tree item.
   *
   * @param item The tree item for which to create the icon.
   * @return The created icon.
   */
  Icon<?> createIcon(N item);
}
