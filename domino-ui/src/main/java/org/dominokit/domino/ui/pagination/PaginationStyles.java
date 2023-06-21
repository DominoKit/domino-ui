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

/**
 * PaginationStyles interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface PaginationStyles {
  /** Constant <code>dui_pager</code> */
  CssClass dui_pager = () -> "dui-pager";
  /** Constant <code>dui_pager_list</code> */
  CssClass dui_pager_list = () -> "dui-pager-list";
  /** Constant <code>dui_pager_item</code> */
  CssClass dui_pager_item = () -> "dui-pager-item";
  /** Constant <code>dui_page_link</code> */
  CssClass dui_page_link = () -> "dui-page-link";
  /** Constant <code>dui_page_icon</code> */
  CssClass dui_page_icon = () -> "dui-page-icon";
  /** Constant <code>dui_navigator_nav</code> */
  CssClass dui_navigator_nav = () -> "dui-navigator-nav";
  /** Constant <code>dui_page_count</code> */
  CssClass dui_page_count = () -> "dui-page-count";
  /** Constant <code>dui_navigator</code> */
  CssClass dui_navigator = () -> "dui-navigator";
  /** Constant <code>dui_navigator_next</code> */
  CssClass dui_navigator_next = () -> "dui-navigator-next";
  /** Constant <code>dui_navigator_previous</code> */
  CssClass dui_navigator_previous = () -> "dui-navigator-previous";
  /** Constant <code>dui_pagination_select</code> */
  CssClass dui_pagination_select = () -> "dui-pagination-select";
}
