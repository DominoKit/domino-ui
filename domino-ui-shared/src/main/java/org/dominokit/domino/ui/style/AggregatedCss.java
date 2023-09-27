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
package org.dominokit.domino.ui.style;

class AggregatedCss {

  static CssClass dui_block = () -> "dui-block";
  static CssClass dui_block_full = () -> "dui-block-full";
  static CssClass dui_inline_block = () -> "dui-inline-block";
  static CssClass dui_inline = () -> "dui-inline";
  static CssClass dui_flex = () -> "dui-flex";
  static CssClass dui_inline_flex = () -> "dui-inline-flex";
  static CssClass dui_table = () -> "dui-table";
  static CssClass dui_inline_table = () -> "dui-inline-table";
  static CssClass dui_table_caption = () -> "dui-table-caption";
  static CssClass dui_table_cell = () -> "dui-table-cell";
  static CssClass dui_table_column = () -> "dui-table-column";
  static CssClass dui_table_column_group = () -> "dui-table-column-group";
  static CssClass dui_table_footer_group = () -> "dui-table-footer-group";
  static CssClass dui_table_header_group = () -> "dui-table-header-group";
  static CssClass dui_table_row_group = () -> "dui-table-row-group";
  static CssClass dui_table_row = () -> "dui-table-row";
  static CssClass dui_flow_root = () -> "dui-flow-root";
  static CssClass dui_grid = () -> "dui-grid";
  static CssClass dui_inline_grid = () -> "dui-inline-grid";
  static CssClass dui_contents = () -> "dui-contents";
  static CssClass dui_list_item = () -> "dui-list-item";
  static CompositeCssClass dui_display =
      CompositeCssClass.of(
          dui_block,
          dui_block_full,
          dui_inline_block,
          dui_inline,
          dui_flex,
          dui_inline_flex,
          dui_table,
          dui_inline_table,
          dui_table_caption,
          dui_table_cell,
          dui_table_column,
          dui_table_column_group,
          dui_table_footer_group,
          dui_table_header_group,
          dui_table_row_group,
          dui_table_row,
          dui_flow_root,
          dui_grid,
          dui_inline_grid,
          dui_contents,
          dui_list_item);
}
