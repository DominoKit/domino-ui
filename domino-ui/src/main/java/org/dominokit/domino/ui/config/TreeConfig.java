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
package org.dominokit.domino.ui.config;

import java.util.function.Supplier;
import org.dominokit.domino.ui.collapsible.*;
import org.dominokit.domino.ui.tree.TreeNode;

/**
 * Implementations of this interface can be used to configure defaults for {@link
 * org.dominokit.domino.ui.tree.Tree} component
 */
public interface TreeConfig extends ComponentConfig {

  /**
   * Use this method to define the default CollapseStrategy for a tree component items
   *
   * <p>Defaults to : {@code TreeHeightCollapseStrategy}
   *
   * @param node The TreeItem we are creating the strategy for.
   * @return a {@code Supplier<CollapseStrategy>}
   */
  default Supplier<CollapseStrategy> getTreeDefaultCollapseStrategy(TreeNode<?, ?, ?> node) {
    return () -> new HeightCollapseStrategy("0");
  }
}
