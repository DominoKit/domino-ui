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

/**
 * A collection of predefined CSS classes to be used across the application.
 *
 * <p>This class provides a set of static {@link CssClass} definitions that encapsulate various
 * commonly used CSS styles. By using these definitions, you can ensure consistency and reduce the
 * chance of typos.
 *
 * @see CssClass
 */
class AggregatedCss {

  /** Represents the CSS class for block display. */
  static CssClass dui_block = () -> "dui-block";

  /** Represents the CSS class for full-width block display. */
  static CssClass dui_block_full = () -> "dui-block-full";

  /** Represents the CSS class for inline-block display. */
  static CssClass dui_inline_block = () -> "dui-inline-block";

  /** Represents the CSS class for inline display. */
  static CssClass dui_inline = () -> "dui-inline";

  /** Represents the CSS class for flexible box layout. */
  static CssClass dui_flex = () -> "dui-flex";

  /** Represents the CSS class for inline flexible box layout. */
  static CssClass dui_inline_flex = () -> "dui-inline-flex";

  /** Represents the CSS class for table display. */
  static CssClass dui_table = () -> "dui-table";

  /** Represents the CSS class for inline table display. */
  static CssClass dui_inline_table = () -> "dui-inline-table";

  /** Represents the CSS class for table caption elements. */
  static CssClass dui_table_caption = () -> "dui-table-caption";

  /** Represents the CSS class for table cell elements. */
  static CssClass dui_table_cell = () -> "dui-table-cell";

  /** Represents the CSS class for table column elements. */
  static CssClass dui_table_column = () -> "dui-table-column";

  /** Represents the CSS class for table column group elements. */
  static CssClass dui_table_column_group = () -> "dui-table-column-group";

  /** Represents the CSS class for table footer group elements. */
  static CssClass dui_table_footer_group = () -> "dui-table-footer-group";

  /** Represents the CSS class for table header group elements. */
  static CssClass dui_table_header_group = () -> "dui-table-header-group";

  /** Represents the CSS class for table row group elements. */
  static CssClass dui_table_row_group = () -> "dui-table-row-group";

  /** Represents the CSS class for table row elements. */
  static CssClass dui_table_row = () -> "dui-table-row";

  /** Represents the CSS class for block formatting context creation. */
  static CssClass dui_flow_root = () -> "dui-flow-root";

  /** Represents the CSS class for grid layout. */
  static CssClass dui_grid = () -> "dui-grid";

  /** Represents the CSS class for inline grid layout. */
  static CssClass dui_inline_grid = () -> "dui-inline-grid";

  /** Represents the CSS class for replacing element's children with their contents. */
  static CssClass dui_contents = () -> "dui-contents";

  /** Represents the CSS class for list item elements. */
  static CssClass dui_list_item = () -> "dui-list-item";

  /**
   * Aggregates multiple CSS classes into a composite class for display-related styles.
   *
   * @see CompositeCssClass
   */
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
