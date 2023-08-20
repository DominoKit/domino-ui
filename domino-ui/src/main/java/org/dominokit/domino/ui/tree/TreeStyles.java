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

import org.dominokit.domino.ui.style.CssClass;

/** Default CSS classes for {@link org.dominokit.domino.ui.tree.Tree} */
public interface TreeStyles {
  /** Constant <code>dui_tree</code> */
  CssClass dui_tree = () -> "dui-tree";
  /** Constant <code>dui_tree_body</code> */
  CssClass dui_tree_body = () -> "dui-tree-body";
  /** Constant <code>dui_tree_nav</code> */
  CssClass dui_tree_nav = () -> "dui-tree-nav";
  /** Constant <code>dui_tree_header</code> */
  CssClass dui_tree_header = () -> "dui-tree-header";
  /** Constant <code>dui_tree_header_item</code> */
  CssClass dui_tree_header_item = () -> "dui-tree-header-item";
  /** Constant <code>dui_tree_item_close</code> */
  CssClass dui_tree_item_close = () -> "dui-tree-item-close";
  /** Constant <code>dui_tree_item_icon</code> */
  CssClass dui_tree_item_icon = () -> "dui-tree-item-icon";
  /** Constant <code>dui_tree_item_text</code> */
  CssClass dui_tree_item_text = () -> "dui-tree-item-text";
  /** Constant <code>dui_tree_item_filler</code> */
  CssClass dui_tree_item_filler = () -> "dui-tree-item-filler";
  /** Constant <code>dui_tree_content_item</code> */
  CssClass dui_tree_content_item = () -> "dui-tree-content-item";
  /** Constant <code>dui_tree_item_content</code> */
  CssClass dui_tree_item_content = () -> "dui-tree-item-content";
  /** Constant <code>dui_tree_anchor</code> */
  CssClass dui_tree_anchor = () -> "dui-tree-anchor";
  /** Constant <code>dui_tree_item</code> */
  CssClass dui_tree_item = () -> "dui-tree-item";
}
