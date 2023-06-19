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

/** Default CSS classes for {@link Tree} */
public interface TreeStyles {
  CssClass dui_tree = () -> "dui-tree";
  CssClass dui_tree_body = () -> "dui-tree-body";
  CssClass dui_tree_nav = () -> "dui-tree-nav";
  CssClass dui_tree_header = () -> "dui-tree-header";
  CssClass dui_tree_header_item = () -> "dui-tree-header-item";
  CssClass dui_tree_item_close = () -> "dui-tree-item-close";
  CssClass dui_tree_item_icon = () -> "dui-tree-item-icon";
  CssClass dui_tree_item_text = () -> "dui-tree-item-text";
  CssClass dui_tree_item_filler = () -> "dui-tree-item-filler";
  CssClass dui_tree_content_item = () -> "dui-tree-content-item";
  CssClass dui_tree_item_content = () -> "dui-tree-item-content";
  CssClass dui_tree_anchor = () -> "dui-tree-anchor";
  CssClass dui_tree_item = () -> "dui-tree-item";
}
