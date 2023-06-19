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
package org.dominokit.domino.ui.menu;

import org.dominokit.domino.ui.style.CssClass;

public interface MenuStyles {

  CssClass dui_menu = () -> "dui-menu";
  CssClass dui_menu_header_bar = () -> "dui-menu-header-bar";
  CssClass dui_menu_back_icon = () -> "dui-menu-back";
  CssClass dui_menu_icon = () -> "dui-menu-icon";
  CssClass dui_menu_title = () -> "dui-menu-title";
  CssClass dui_menu_utility = () -> "dui-menu-utility";
  CssClass dui_menu_search = () -> "dui-menu-search";
  CssClass dui_menu_search_box = () -> "dui-menu-search-box";
  CssClass dui_menu_sub_header = () -> "dui-menu-subheader";
  CssClass dui_menu_body = () -> "dui-menu-body";
  CssClass dui_menu_items_list = () -> "dui-menu-items-list";
  CssClass dui_menu_item = () -> "dui-menu-item";
  CssClass dui_menu_item_anchor = () -> "dui-menu-item-anchor";
  CssClass dui_menu_item_icon = () -> "dui-menu-item-icon";
  CssClass dui_menu_item_body = () -> "dui-menu-item-body";
  CssClass dui_menu_item_utility = () -> "dui-menu-item-utility";
  CssClass dui_menu_item_indicator = () -> "dui-menu-item-indicator";
  CssClass dui_menu_separator = () -> "dui-menu-separator";
  CssClass dui_menu_create_missing = () -> "dui-menu-create-missing";
  CssClass dui_menu_no_results = () -> "dui-menu-no-results";
  CssClass dui_menu_item_selected = () -> "dui-menu-item-selected";
  CssClass dui_menu_item_hint = () -> "dui-menu-item-hint";
  CssClass dui_menu_group = () -> "dui-menu-group";
  CssClass dui_menu_group_header = () -> "dui-menu-group-header";
  CssClass dui_menu_drop = () -> "dui-menu-drop";

  CssClass dui_menu_item_prefix = () -> "dui-menu-item-prefix";
  CssClass dui_menu_item_postfix = () -> "dui-menu-item-postfix";
  CssClass dui_menu_item_nested_indicator = () -> "dui-menu-item-nested-indicator";
  CssClass dui_menu_item_content = () -> "dui-menu-item-content";
  CssClass dui_menu_item_bottom = () -> "dui-menu-item-bottom";
  CssClass dui_context_menu = () -> "dui-context-menu";
}
