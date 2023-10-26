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
package org.dominokit.domino.ui.pagination;

import org.dominokit.domino.ui.style.CssClass;

public interface PaginationStyles {
  CssClass dui_pager = () -> "dui-pager";
  CssClass dui_pager_list = () -> "dui-pager-list";
  CssClass dui_pager_item = () -> "dui-pager-item";
  CssClass dui_page_link = () -> "dui-page-link";
  CssClass dui_page_icon = () -> "dui-page-icon";
  CssClass dui_navigator_nav = () -> "dui-navigator-nav";
  CssClass dui_page_count = () -> "dui-page-count";
  CssClass dui_navigator = () -> "dui-navigator";
  CssClass dui_navigator_next = () -> "dui-navigator-next";
  CssClass dui_navigator_previous = () -> "dui-navigator-previous";
  CssClass dui_pagination_select = () -> "dui-pagination-select";
}
