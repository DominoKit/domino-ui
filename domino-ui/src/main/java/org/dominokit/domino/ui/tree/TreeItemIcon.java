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

import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.StateChangeMdiIcon;

/**
 * The `TreeItemIcon` class provides a utility for creating a state-changing icon for tree items.
 * This icon can change its appearance based on the state of the tree item (collapsed, expanded,
 * leaf, or active).
 */
public class TreeItemIcon {

  /** The CSS class name for the collapsed state. */
  public static final String STATE_COLLAPSED = "dui-tree-collapsed";

  /** The CSS class name for the expanded state. */
  public static final String STATE_EXPANDED = "dui-tree-expanded";

  /** The CSS class name for the leaf state. */
  public static final String STATE_LEAF = "dui-tree-leaf";

  /** The CSS class name for the active state. */
  public static final String STATE_ACTIVE = "dui-tree-active";

  /**
   * Creates a state-changing Material Design Icon (MdiIcon) for a tree item.
   *
   * @param collapsed The icon to be displayed when the tree item is in a collapsed state.
   * @param expanded The icon to be displayed when the tree item is in an expanded state.
   * @param leaf The icon to be displayed when the tree item is a leaf node.
   * @param active The icon to be displayed when the tree item is active/selected.
   * @return A state-changing MdiIcon that can display different icons based on the tree item's
   *     state.
   */
  public static StateChangeMdiIcon of(
      MdiIcon collapsed, MdiIcon expanded, MdiIcon leaf, MdiIcon active) {
    StateChangeMdiIcon stateChangeMdiIcon = new StateChangeMdiIcon(MdiIcon.create(leaf.getName()));
    stateChangeMdiIcon
        .withState(STATE_COLLAPSED, collapsed)
        .withState(STATE_EXPANDED, expanded)
        .withState(STATE_LEAF, leaf)
        .withState(STATE_ACTIVE, active);
    return stateChangeMdiIcon;
  }
}
