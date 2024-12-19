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

public interface RootNode<V, N extends TreeNode<V, N, S>, S> extends HasActiveNode<V, N, S> {
  boolean isAutoCollapse();

  boolean isAutoExpandFound();

  NodeIconSupplier<V, N, S> getIconSupplier();

  default void onActiveNodeChanged(N node, S selection, boolean silent) {}

  void onDeselectionChanged(N source, S selection);
}
