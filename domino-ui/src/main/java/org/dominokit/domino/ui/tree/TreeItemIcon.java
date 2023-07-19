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
 * TreeItemIcon class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TreeItemIcon {

  /** Constant <code>STATE_COLLAPSED="dui-tree-collapsed"</code> */
  public static final String STATE_COLLAPSED = "dui-tree-collapsed";
  /** Constant <code>STATE_EXPANDED="dui-tree-expanded"</code> */
  public static final String STATE_EXPANDED = "dui-tree-expanded";
  /** Constant <code>STATE_LEAF="dui-tree-leaf"</code> */
  public static final String STATE_LEAF = "dui-tree-leaf";
  /** Constant <code>STATE_ACTIVE="dui-tree-active"</code> */
  public static final String STATE_ACTIVE = "dui-tree-active";

  /**
   * of.
   *
   * @param collapsed a {@link org.dominokit.domino.ui.icons.MdiIcon} object
   * @param expanded a {@link org.dominokit.domino.ui.icons.MdiIcon} object
   * @param leaf a {@link org.dominokit.domino.ui.icons.MdiIcon} object
   * @param active a {@link org.dominokit.domino.ui.icons.MdiIcon} object
   * @return a {@link org.dominokit.domino.ui.icons.StateChangeMdiIcon} object
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
