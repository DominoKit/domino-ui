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

/** DisplayCss interface. */
public interface DisplayCss {
  /** Constant <code>dui_image_responsive</code> */
  CssClass dui_image_responsive = () -> "dui-image-responsive";
  /** Constant <code>dui_reversed</code> */
  CssClass dui_reversed = () -> "dui-reversed";
  /** Constant <code>dui_undimmed</code> */
  CssClass dui_undimmed = () -> "dui-undimmed";
  /** Constant <code>dui_opacity_0</code> */
  CssClass dui_opacity_0 = () -> "dui-opacity-0";
  /** Constant <code>dui_opacity_5</code> */
  CssClass dui_opacity_5 = () -> "dui-opacity-5";
  /** Constant <code>dui_opacity_10</code> */
  CssClass dui_opacity_10 = () -> "dui-opacity-10";
  /** Constant <code>dui_opacity_20</code> */
  CssClass dui_opacity_20 = () -> "dui-opacity-20";
  /** Constant <code>dui_opacity_25</code> */
  CssClass dui_opacity_25 = () -> "dui-opacity-25";
  /** Constant <code>dui_opacity_30</code> */
  CssClass dui_opacity_30 = () -> "dui-opacity-30";
  /** Constant <code>dui_opacity_40</code> */
  CssClass dui_opacity_40 = () -> "dui-opacity-40";
  /** Constant <code>dui_opacity_50</code> */
  CssClass dui_opacity_50 = () -> "dui-opacity-50";
  /** Constant <code>dui_opacity_60</code> */
  CssClass dui_opacity_60 = () -> "dui-opacity-60";
  /** Constant <code>dui_opacity_70</code> */
  CssClass dui_opacity_70 = () -> "dui-opacity-70";
  /** Constant <code>dui_opacity_75</code> */
  CssClass dui_opacity_75 = () -> "dui-opacity-75";
  /** Constant <code>dui_opacity_80</code> */
  CssClass dui_opacity_80 = () -> "dui-opacity-80";
  /** Constant <code>dui_opacity_90</code> */
  CssClass dui_opacity_90 = () -> "dui-opacity-90";
  /** Constant <code>dui_opacity_95</code> */
  CssClass dui_opacity_95 = () -> "dui-opacity-95";
  /** Constant <code>dui_opacity_100</code> */
  CssClass dui_opacity_100 = () -> "dui-opacity-100";
  /** Constant <code>dui_block</code> */
  CssClass dui_block = () -> "dui-block";
  /** Constant <code>dui_block_full</code> */
  CssClass dui_block_full = () -> "dui-block-full";
  /** Constant <code>dui_inline_block</code> */
  CssClass dui_inline_block = () -> "dui-inline-block";
  /** Constant <code>dui_inline</code> */
  CssClass dui_inline = () -> "dui-inline";
  /** Constant <code>dui_flex</code> */
  CssClass dui_flex = () -> "dui-flex";
  /** Constant <code>dui_inline_flex</code> */
  CssClass dui_inline_flex = () -> "dui-inline-flex";
  /** Constant <code>dui_flex_responsive</code> */
  CssClass dui_flex_responsive = () -> "dui-flex-responsive";
  /** Constant <code>dui_flex_responsive_reverse</code> */
  CssClass dui_flex_responsive_reverse = () -> "dui-flex-responsive-reverse";

  /** Constant <code>dui_table</code> */
  CssClass dui_table = () -> "dui-table";
  /** Constant <code>dui_inline_table</code> */
  CssClass dui_inline_table = () -> "dui-inline-table";
  /** Constant <code>dui_table_caption</code> */
  CssClass dui_table_caption = () -> "dui-table-caption";
  /** Constant <code>dui_table_cell</code> */
  CssClass dui_table_cell = () -> "dui-table-cell";
  /** Constant <code>dui_table_column</code> */
  CssClass dui_table_column = () -> "dui-table-column";
  /** Constant <code>dui_table_column_group</code> */
  CssClass dui_table_column_group = () -> "dui-table-column-group";
  /** Constant <code>dui_table_footer_group</code> */
  CssClass dui_table_footer_group = () -> "dui-table-footer-group";
  /** Constant <code>dui_table_header_group</code> */
  CssClass dui_table_header_group = () -> "dui-table-header-group";
  /** Constant <code>dui_table_row_group</code> */
  CssClass dui_table_row_group = () -> "dui-table-row-group";
  /** Constant <code>dui_table_row</code> */
  CssClass dui_table_row = () -> "dui-table-row";
  /** Constant <code>dui_flow_root</code> */
  CssClass dui_flow_root = () -> "dui-flow-root";
  /** Constant <code>dui_grid</code> */
  CssClass dui_grid = () -> "dui-grid";
  /** Constant <code>dui_inline_grid</code> */
  CssClass dui_inline_grid = () -> "dui-inline-grid";
  /** Constant <code>dui_contents</code> */
  CssClass dui_contents = () -> "dui-contents";
  /** Constant <code>dui_list_item</code> */
  CssClass dui_list_item = () -> "dui-list-item";
  /** Constant <code>dui_hidden</code> */
  CssClass dui_hidden = () -> "dui-hidden";
  /** Constant <code>dui_float_right</code> */
  CssClass dui_float_right = () -> "dui-float-right";
  /** Constant <code>dui_float_left</code> */
  CssClass dui_float_left = () -> "dui-float-left";
  /** Constant <code>dui_float_none</code> */
  CssClass dui_float_none = () -> "dui-float-none";
  /** Constant <code>dui_clear_left</code> */
  CssClass dui_clear_left = () -> "dui-clear-left";
  /** Constant <code>dui_clear_right</code> */
  CssClass dui_clear_right = () -> "dui-clear-right";
  /** Constant <code>dui_clear_both</code> */
  CssClass dui_clear_both = () -> "dui-clear-both";
  /** Constant <code>dui_clear_none</code> */
  CssClass dui_clear_none = () -> "dui-clear-none";
  /** Constant <code>dui_isolate</code> */
  CssClass dui_isolate = () -> "dui-isolate";
  /** Constant <code>dui_isolation_auto</code> */
  CssClass dui_isolation_auto = () -> "dui-isolation-auto";
  /** Constant <code>dui_object_contain</code> */
  CssClass dui_object_contain = () -> "dui-object-contain";
  /** Constant <code>dui_object_cover</code> */
  CssClass dui_object_cover = () -> "dui-object-cover";
  /** Constant <code>dui_object_fill</code> */
  CssClass dui_object_fill = () -> "dui-object-fill";
  /** Constant <code>dui_object_none</code> */
  CssClass dui_object_none = () -> "dui-object-none";
  /** Constant <code>dui_object_scale_down</code> */
  CssClass dui_object_scale_down = () -> "dui-object-scale-down";
  /** Constant <code>dui_object_bottom</code> */
  CssClass dui_object_bottom = () -> "dui-object-bottom";
  /** Constant <code>dui_object_center</code> */
  CssClass dui_object_center = () -> "dui-object-center";
  /** Constant <code>dui_object_left</code> */
  CssClass dui_object_left = () -> "dui-object-left";
  /** Constant <code>dui_object_left_bottom</code> */
  CssClass dui_object_left_bottom = () -> "dui-object-left-bottom";
  /** Constant <code>dui_object_left_top</code> */
  CssClass dui_object_left_top = () -> "dui-object-left-top";
  /** Constant <code>dui_object_right</code> */
  CssClass dui_object_right = () -> "dui-object-right";
  /** Constant <code>dui_object_right_bottom</code> */
  CssClass dui_object_right_bottom = () -> "dui-object-right-bottom";
  /** Constant <code>dui_object_right_top</code> */
  CssClass dui_object_right_top = () -> "dui-object-right-top";
  /** Constant <code>dui_object_top</code> */
  CssClass dui_object_top = () -> "dui-object-top";
  /** Constant <code>dui_overflow_auto</code> */
  CssClass dui_overflow_auto = () -> "dui-overflow-auto";
  /** Constant <code>dui_overflow_hidden</code> */
  CssClass dui_overflow_hidden = () -> "dui-overflow-hidden";
  /** Constant <code>dui_overflow_clip</code> */
  CssClass dui_overflow_clip = () -> "dui-overflow-clip";
  /** Constant <code>dui_overflow_visible</code> */
  CssClass dui_overflow_visible = () -> "dui-overflow-visible";
  /** Constant <code>dui_overflow_scroll</code> */
  CssClass dui_overflow_scroll = () -> "dui-overflow-scroll";
  /** Constant <code>dui_overflow_x_auto</code> */
  CssClass dui_overflow_x_auto = () -> "dui-overflow-x-auto";
  /** Constant <code>dui_overflow_y_auto</code> */
  CssClass dui_overflow_y_auto = () -> "dui-overflow-y-auto";
  /** Constant <code>dui_overflow_x_hidden</code> */
  CssClass dui_overflow_x_hidden = () -> "dui-overflow-x-hidden";
  /** Constant <code>dui_overflow_y_hidden</code> */
  CssClass dui_overflow_y_hidden = () -> "dui-overflow-y-hidden";
  /** Constant <code>dui_overflow_x_clip</code> */
  CssClass dui_overflow_x_clip = () -> "dui-overflow-x-clip";
  /** Constant <code>dui_overflow_y_clip</code> */
  CssClass dui_overflow_y_clip = () -> "dui-overflow-y-clip";
  /** Constant <code>dui_overflow_x_visible</code> */
  CssClass dui_overflow_x_visible = () -> "dui-overflow-x-visible";
  /** Constant <code>dui_overflow_y_visible</code> */
  CssClass dui_overflow_y_visible = () -> "dui-overflow-y-visible";
  /** Constant <code>dui_overflow_x_scroll</code> */
  CssClass dui_overflow_x_scroll = () -> "dui-overflow-x-scroll";
  /** Constant <code>dui_overflow_y_scroll</code> */
  CssClass dui_overflow_y_scroll = () -> "dui-overflow-y-scroll";
  /** Constant <code>dui_overscroll_auto</code> */
  CssClass dui_overscroll_auto = () -> "dui-overscroll-auto";
  /** Constant <code>dui_overscroll_contain</code> */
  CssClass dui_overscroll_contain = () -> "dui-overscroll-contain";
  /** Constant <code>dui_overscroll_none</code> */
  CssClass dui_overscroll_none = () -> "dui-overscroll-none";
  /** Constant <code>dui_overscroll_y_auto</code> */
  CssClass dui_overscroll_y_auto = () -> "dui-overscroll-y-auto";
  /** Constant <code>dui_overscroll_y_contain</code> */
  CssClass dui_overscroll_y_contain = () -> "dui-overscroll-y-contain";
  /** Constant <code>dui_overscroll_y_none</code> */
  CssClass dui_overscroll_y_none = () -> "dui-overscroll-y-none";
  /** Constant <code>dui_overscroll_x_auto</code> */
  CssClass dui_overscroll_x_auto = () -> "dui-overscroll-x-auto";
  /** Constant <code>dui_overscroll_x_contain</code> */
  CssClass dui_overscroll_x_contain = () -> "dui-overscroll-x-contain";
  /** Constant <code>dui_overscroll_x_none</code> */
  CssClass dui_overscroll_x_none = () -> "dui-overscroll-x-none";
  /** Constant <code>dui_static_</code> */
  CssClass dui_static_ = () -> "dui-static";
  /** Constant <code>dui_fixed</code> */
  CssClass dui_fixed = () -> "dui-fixed";
  /** Constant <code>dui_absolute</code> */
  CssClass dui_absolute = () -> "dui-absolute";
  /** Constant <code>dui_relative</code> */
  CssClass dui_relative = () -> "dui-relative";
  /** Constant <code>dui_sticky</code> */
  CssClass dui_sticky = () -> "dui-sticky";

  /** Constant <code>dui_inset_1</code> */
  CssClass dui_inset_1 = () -> "dui-inset-1";
  /** Constant <code>dui_inset_x_1</code> */
  CssClass dui_inset_x_1 = () -> "dui-inset-x-1";
  /** Constant <code>dui_inset_y_1</code> */
  CssClass dui_inset_y_1 = () -> "dui-inset-y-1";
  /** Constant <code>dui_bottom_1</code> */
  CssClass dui_bottom_1 = () -> "dui-bottom-1";
  /** Constant <code>dui_inset_1_5</code> */
  CssClass dui_inset_1_5 = () -> "dui-inset-1.5";
  /** Constant <code>dui_inset_x_1_5</code> */
  CssClass dui_inset_x_1_5 = () -> "dui-inset-x-1.5";
  /** Constant <code>dui_inset_y_1_5</code> */
  CssClass dui_inset_y_1_5 = () -> "dui-inset-y-1.5";
  /** Constant <code>dui_bottom_1_5</code> */
  CssClass dui_bottom_1_5 = () -> "dui-bottom-1.5";
  /** Constant <code>dui_inset_2</code> */
  CssClass dui_inset_2 = () -> "dui-inset-2";
  /** Constant <code>dui_inset_x_2</code> */
  CssClass dui_inset_x_2 = () -> "dui-inset-x-2";
  /** Constant <code>dui_inset_y_2</code> */
  CssClass dui_inset_y_2 = () -> "dui-inset-y-2";
  /** Constant <code>dui_bottom_2</code> */
  CssClass dui_bottom_2 = () -> "dui-bottom-2";
  /** Constant <code>dui_inset_2_5</code> */
  CssClass dui_inset_2_5 = () -> "dui-inset-2.5";
  /** Constant <code>dui_inset_x_2_5</code> */
  CssClass dui_inset_x_2_5 = () -> "dui-inset-x-2.5";
  /** Constant <code>dui_inset_y_2_5</code> */
  CssClass dui_inset_y_2_5 = () -> "dui-inset-y-2.5";
  /** Constant <code>dui_bottom_2_5</code> */
  CssClass dui_bottom_2_5 = () -> "dui-bottom-2.5";
  /** Constant <code>dui_inset_3</code> */
  CssClass dui_inset_3 = () -> "dui-inset-3";
  /** Constant <code>dui_inset_x_3</code> */
  CssClass dui_inset_x_3 = () -> "dui-inset-x-3";
  /** Constant <code>dui_inset_y_3</code> */
  CssClass dui_inset_y_3 = () -> "dui-inset-y-3";
  /** Constant <code>dui_bottom_3</code> */
  CssClass dui_bottom_3 = () -> "dui-bottom-3";
  /** Constant <code>dui_inset_3_5</code> */
  CssClass dui_inset_3_5 = () -> "dui-inset-3.5";
  /** Constant <code>dui_inset_x_3_5</code> */
  CssClass dui_inset_x_3_5 = () -> "dui-inset-x-3.5";
  /** Constant <code>dui_inset_y_3_5</code> */
  CssClass dui_inset_y_3_5 = () -> "dui-inset-y-3.5";
  /** Constant <code>dui_bottom_3_5</code> */
  CssClass dui_bottom_3_5 = () -> "dui-bottom-3.5";
  /** Constant <code>dui_inset_4</code> */
  CssClass dui_inset_4 = () -> "dui-inset-4";
  /** Constant <code>dui_inset_x_4</code> */
  CssClass dui_inset_x_4 = () -> "dui-inset-x-4";
  /** Constant <code>dui_inset_y_4</code> */
  CssClass dui_inset_y_4 = () -> "dui-inset-y-4";
  /** Constant <code>dui_bottom_4</code> */
  CssClass dui_bottom_4 = () -> "dui-bottom-4";
  /** Constant <code>dui_inset_5</code> */
  CssClass dui_inset_5 = () -> "dui-inset-5";
  /** Constant <code>dui_inset_x_5</code> */
  CssClass dui_inset_x_5 = () -> "dui-inset-x-5";
  /** Constant <code>dui_inset_y_5</code> */
  CssClass dui_inset_y_5 = () -> "dui-inset-y-5";
  /** Constant <code>dui_bottom_5</code> */
  CssClass dui_bottom_5 = () -> "dui-bottom-5";
  /** Constant <code>dui_inset_6</code> */
  CssClass dui_inset_6 = () -> "dui-inset-6";
  /** Constant <code>dui_inset_x_6</code> */
  CssClass dui_inset_x_6 = () -> "dui-inset-x-6";
  /** Constant <code>dui_inset_y_6</code> */
  CssClass dui_inset_y_6 = () -> "dui-inset-y-6";
  /** Constant <code>dui_bottom_6</code> */
  CssClass dui_bottom_6 = () -> "dui-bottom-6";
  /** Constant <code>dui_inset_7</code> */
  CssClass dui_inset_7 = () -> "dui-inset-7";
  /** Constant <code>dui_inset_x_7</code> */
  CssClass dui_inset_x_7 = () -> "dui-inset-x-7";
  /** Constant <code>dui_inset_y_7</code> */
  CssClass dui_inset_y_7 = () -> "dui-inset-y-7";
  /** Constant <code>dui_bottom_7</code> */
  CssClass dui_bottom_7 = () -> "dui-bottom-7";
  /** Constant <code>dui_inset_8</code> */
  CssClass dui_inset_8 = () -> "dui-inset-8";
  /** Constant <code>dui_inset_x_8</code> */
  CssClass dui_inset_x_8 = () -> "dui-inset-x-8";
  /** Constant <code>dui_inset_y_8</code> */
  CssClass dui_inset_y_8 = () -> "dui-inset-y-8";
  /** Constant <code>dui_bottom_8</code> */
  CssClass dui_bottom_8 = () -> "dui-bottom-8";
  /** Constant <code>dui_inset_9</code> */
  CssClass dui_inset_9 = () -> "dui-inset-9";
  /** Constant <code>dui_inset_x_9</code> */
  CssClass dui_inset_x_9 = () -> "dui-inset-x-9";
  /** Constant <code>dui_inset_y_9</code> */
  CssClass dui_inset_y_9 = () -> "dui-inset-y-9";
  /** Constant <code>dui_bottom_9</code> */
  CssClass dui_bottom_9 = () -> "dui-bottom-9";
  /** Constant <code>dui_inset_10</code> */
  CssClass dui_inset_10 = () -> "dui-inset-10";
  /** Constant <code>dui_inset_x_10</code> */
  CssClass dui_inset_x_10 = () -> "dui-inset-x-10";
  /** Constant <code>dui_inset_y_10</code> */
  CssClass dui_inset_y_10 = () -> "dui-inset-y-10";
  /** Constant <code>dui_bottom_10</code> */
  CssClass dui_bottom_10 = () -> "dui-bottom-10";
  /** Constant <code>dui_inset_11</code> */
  CssClass dui_inset_11 = () -> "dui-inset-11";
  /** Constant <code>dui_inset_x_11</code> */
  CssClass dui_inset_x_11 = () -> "dui-inset-x-11";
  /** Constant <code>dui_inset_y_11</code> */
  CssClass dui_inset_y_11 = () -> "dui-inset-y-11";
  /** Constant <code>dui_bottom_11</code> */
  CssClass dui_bottom_11 = () -> "dui-bottom-11";
  /** Constant <code>dui_inset_12</code> */
  CssClass dui_inset_12 = () -> "dui-inset-12";
  /** Constant <code>dui_inset_x_12</code> */
  CssClass dui_inset_x_12 = () -> "dui-inset-x-12";
  /** Constant <code>dui_inset_y_12</code> */
  CssClass dui_inset_y_12 = () -> "dui-inset-y-12";
  /** Constant <code>dui_bottom_12</code> */
  CssClass dui_bottom_12 = () -> "dui-bottom-12";
  /** Constant <code>dui_inset_14</code> */
  CssClass dui_inset_14 = () -> "dui-inset-14";
  /** Constant <code>dui_inset_x_14</code> */
  CssClass dui_inset_x_14 = () -> "dui-inset-x-14";
  /** Constant <code>dui_inset_y_14</code> */
  CssClass dui_inset_y_14 = () -> "dui-inset-y-14";
  /** Constant <code>dui_bottom_14</code> */
  CssClass dui_bottom_14 = () -> "dui-bottom-14";
  /** Constant <code>dui_inset_16</code> */
  CssClass dui_inset_16 = () -> "dui-inset-16";
  /** Constant <code>dui_inset_x_16</code> */
  CssClass dui_inset_x_16 = () -> "dui-inset-x-16";
  /** Constant <code>dui_inset_y_16</code> */
  CssClass dui_inset_y_16 = () -> "dui-inset-y-16";
  /** Constant <code>dui_bottom_16</code> */
  CssClass dui_bottom_16 = () -> "dui-bottom-16";
  /** Constant <code>dui_inset_20</code> */
  CssClass dui_inset_20 = () -> "dui-inset-20";
  /** Constant <code>dui_inset_x_20</code> */
  CssClass dui_inset_x_20 = () -> "dui-inset-x-20";
  /** Constant <code>dui_inset_y_20</code> */
  CssClass dui_inset_y_20 = () -> "dui-inset-y-20";
  /** Constant <code>dui_bottom_20</code> */
  CssClass dui_bottom_20 = () -> "dui-bottom-20";
  /** Constant <code>dui_inset_24</code> */
  CssClass dui_inset_24 = () -> "dui-inset-24";
  /** Constant <code>dui_inset_x_24</code> */
  CssClass dui_inset_x_24 = () -> "dui-inset-x-24";
  /** Constant <code>dui_inset_y_24</code> */
  CssClass dui_inset_y_24 = () -> "dui-inset-y-24";
  /** Constant <code>dui_bottom_24</code> */
  CssClass dui_bottom_24 = () -> "dui-bottom-24";
  /** Constant <code>dui_inset_28</code> */
  CssClass dui_inset_28 = () -> "dui-inset-28";
  /** Constant <code>dui_inset_x_28</code> */
  CssClass dui_inset_x_28 = () -> "dui-inset-x-28";
  /** Constant <code>dui_inset_y_28</code> */
  CssClass dui_inset_y_28 = () -> "dui-inset-y-28";
  /** Constant <code>dui_bottom_28</code> */
  CssClass dui_bottom_28 = () -> "dui-bottom-28";
  /** Constant <code>dui_inset_32</code> */
  CssClass dui_inset_32 = () -> "dui-inset-32";
  /** Constant <code>dui_inset_x_32</code> */
  CssClass dui_inset_x_32 = () -> "dui-inset-x-32";
  /** Constant <code>dui_inset_y_32</code> */
  CssClass dui_inset_y_32 = () -> "dui-inset-y-32";
  /** Constant <code>dui_bottom_32</code> */
  CssClass dui_bottom_32 = () -> "dui-bottom-32";
  /** Constant <code>dui_inset_36</code> */
  CssClass dui_inset_36 = () -> "dui-inset-36";
  /** Constant <code>dui_inset_x_36</code> */
  CssClass dui_inset_x_36 = () -> "dui-inset-x-36";
  /** Constant <code>dui_inset_y_36</code> */
  CssClass dui_inset_y_36 = () -> "dui-inset-y-36";
  /** Constant <code>dui_bottom_36</code> */
  CssClass dui_bottom_36 = () -> "dui-bottom-36";
  /** Constant <code>dui_inset_40</code> */
  CssClass dui_inset_40 = () -> "dui-inset-40";
  /** Constant <code>dui_inset_x_40</code> */
  CssClass dui_inset_x_40 = () -> "dui-inset-x-40";
  /** Constant <code>dui_inset_y_40</code> */
  CssClass dui_inset_y_40 = () -> "dui-inset-y-40";
  /** Constant <code>dui_bottom_40</code> */
  CssClass dui_bottom_40 = () -> "dui-bottom-40";
  /** Constant <code>dui_inset_44</code> */
  CssClass dui_inset_44 = () -> "dui-inset-44";
  /** Constant <code>dui_inset_x_44</code> */
  CssClass dui_inset_x_44 = () -> "dui-inset-x-44";
  /** Constant <code>dui_inset_y_44</code> */
  CssClass dui_inset_y_44 = () -> "dui-inset-y-44";
  /** Constant <code>dui_bottom_44</code> */
  CssClass dui_bottom_44 = () -> "dui-bottom-44";
  /** Constant <code>dui_inset_48</code> */
  CssClass dui_inset_48 = () -> "dui-inset-48";
  /** Constant <code>dui_inset_x_48</code> */
  CssClass dui_inset_x_48 = () -> "dui-inset-x-48";
  /** Constant <code>dui_inset_y_48</code> */
  CssClass dui_inset_y_48 = () -> "dui-inset-y-48";
  /** Constant <code>dui_bottom_48</code> */
  CssClass dui_bottom_48 = () -> "dui-bottom-48";
  /** Constant <code>dui_inset_52</code> */
  CssClass dui_inset_52 = () -> "dui-inset-52";
  /** Constant <code>dui_inset_x_52</code> */
  CssClass dui_inset_x_52 = () -> "dui-inset-x-52";
  /** Constant <code>dui_inset_y_52</code> */
  CssClass dui_inset_y_52 = () -> "dui-inset-y-52";
  /** Constant <code>dui_bottom_52</code> */
  CssClass dui_bottom_52 = () -> "dui-bottom-52";
  /** Constant <code>dui_inset_56</code> */
  CssClass dui_inset_56 = () -> "dui-inset-56";
  /** Constant <code>dui_inset_x_56</code> */
  CssClass dui_inset_x_56 = () -> "dui-inset-x-56";
  /** Constant <code>dui_inset_y_56</code> */
  CssClass dui_inset_y_56 = () -> "dui-inset-y-56";
  /** Constant <code>dui_bottom_56</code> */
  CssClass dui_bottom_56 = () -> "dui-bottom-56";
  /** Constant <code>dui_inset_60</code> */
  CssClass dui_inset_60 = () -> "dui-inset-60";
  /** Constant <code>dui_inset_x_60</code> */
  CssClass dui_inset_x_60 = () -> "dui-inset-x-60";
  /** Constant <code>dui_inset_y_60</code> */
  CssClass dui_inset_y_60 = () -> "dui-inset-y-60";
  /** Constant <code>dui_bottom_60</code> */
  CssClass dui_bottom_60 = () -> "dui-bottom-60";
  /** Constant <code>dui_inset_64</code> */
  CssClass dui_inset_64 = () -> "dui-inset-64";
  /** Constant <code>dui_inset_x_64</code> */
  CssClass dui_inset_x_64 = () -> "dui-inset-x-64";
  /** Constant <code>dui_inset_y_64</code> */
  CssClass dui_inset_y_64 = () -> "dui-inset-y-64";
  /** Constant <code>dui_bottom_64</code> */
  CssClass dui_bottom_64 = () -> "dui-bottom-64";
  /** Constant <code>dui_inset_72</code> */
  CssClass dui_inset_72 = () -> "dui-inset-72";
  /** Constant <code>dui_inset_x_72</code> */
  CssClass dui_inset_x_72 = () -> "dui-inset-x-72";
  /** Constant <code>dui_inset_y_72</code> */
  CssClass dui_inset_y_72 = () -> "dui-inset-y-72";
  /** Constant <code>dui_bottom_72</code> */
  CssClass dui_bottom_72 = () -> "dui-bottom-72";
  /** Constant <code>dui_inset_80</code> */
  CssClass dui_inset_80 = () -> "dui-inset-80";
  /** Constant <code>dui_inset_x_80</code> */
  CssClass dui_inset_x_80 = () -> "dui-inset-x-80";
  /** Constant <code>dui_inset_y_80</code> */
  CssClass dui_inset_y_80 = () -> "dui-inset-y-80";
  /** Constant <code>dui_bottom_80</code> */
  CssClass dui_bottom_80 = () -> "dui-bottom-80";
  /** Constant <code>dui_inset_96</code> */
  CssClass dui_inset_96 = () -> "dui-inset-96";
  /** Constant <code>dui_inset_x_96</code> */
  CssClass dui_inset_x_96 = () -> "dui-inset-x-96";
  /** Constant <code>dui_inset_y_96</code> */
  CssClass dui_inset_y_96 = () -> "dui-inset-y-96";
  /** Constant <code>dui_bottom_96</code> */
  CssClass dui_bottom_96 = () -> "dui-bottom-96";
  /** Constant <code>dui_inset_auto</code> */
  CssClass dui_inset_auto = () -> "dui-inset-auto";
  /** Constant <code>dui_inset_1_2</code> */
  CssClass dui_inset_1_2 = () -> "dui-inset-1_2";
  /** Constant <code>dui_inset_1_3</code> */
  CssClass dui_inset_1_3 = () -> "dui-inset-1_3";
  /** Constant <code>dui_inset_2_3</code> */
  CssClass dui_inset_2_3 = () -> "dui-inset-2_3";
  /** Constant <code>dui_inset_1_4</code> */
  CssClass dui_inset_1_4 = () -> "dui-inset-1_4";
  /** Constant <code>dui_inset_2_4</code> */
  CssClass dui_inset_2_4 = () -> "dui-inset-2_4";
  /** Constant <code>dui_inset_3_4</code> */
  CssClass dui_inset_3_4 = () -> "dui-inset-3_4";
  /** Constant <code>dui_inset_full</code> */
  CssClass dui_inset_full = () -> "dui-inset-full";
  /** Constant <code>dui_inset_x_auto</code> */
  CssClass dui_inset_x_auto = () -> "dui-inset-x-auto";
  /** Constant <code>dui_inset_x_1_2</code> */
  CssClass dui_inset_x_1_2 = () -> "dui-inset-x-1_2";
  /** Constant <code>dui_inset_x_1_3</code> */
  CssClass dui_inset_x_1_3 = () -> "dui-inset-x-1_3";
  /** Constant <code>dui_inset_x_2_3</code> */
  CssClass dui_inset_x_2_3 = () -> "dui-inset-x-2_3";
  /** Constant <code>dui_inset_x_1_4</code> */
  CssClass dui_inset_x_1_4 = () -> "dui-inset-x-1_4";
  /** Constant <code>dui_inset_x_2_4</code> */
  CssClass dui_inset_x_2_4 = () -> "dui-inset-x-2_4";
  /** Constant <code>dui_inset_x_3_4</code> */
  CssClass dui_inset_x_3_4 = () -> "dui-inset-x-3_4";
  /** Constant <code>dui_inset_x_full</code> */
  CssClass dui_inset_x_full = () -> "dui-inset-x-full";
  /** Constant <code>dui_inset_y_auto</code> */
  CssClass dui_inset_y_auto = () -> "dui-inset-y-auto";
  /** Constant <code>dui_inset_y_1_2</code> */
  CssClass dui_inset_y_1_2 = () -> "dui-inset-y-1_2";
  /** Constant <code>dui_inset_y_1_3</code> */
  CssClass dui_inset_y_1_3 = () -> "dui-inset-y-1_3";
  /** Constant <code>dui_inset_y_2_3</code> */
  CssClass dui_inset_y_2_3 = () -> "dui-inset-y-2_3";
  /** Constant <code>dui_inset_y_1_4</code> */
  CssClass dui_inset_y_1_4 = () -> "dui-inset-y-1_4";
  /** Constant <code>dui_inset_y_2_4</code> */
  CssClass dui_inset_y_2_4 = () -> "dui-inset-y-2_4";
  /** Constant <code>dui_inset_y_3_4</code> */
  CssClass dui_inset_y_3_4 = () -> "dui-inset-y-3_4";
  /** Constant <code>dui_inset_y_full</code> */
  CssClass dui_inset_y_full = () -> "dui-inset-y-full";
  /** Constant <code>dui_bottom_0</code> */
  CssClass dui_bottom_0 = () -> "dui-bottom-0";
  /** Constant <code>dui_inset_y_0_5</code> */
  CssClass dui_inset_y_0_5 = () -> "dui-inset-y-0.5";
  /** Constant <code>dui_bottom_0_5</code> */
  CssClass dui_bottom_0_5 = () -> "dui-bottom-0.5";
  /** Constant <code>dui_inset_0</code> */
  CssClass dui_inset_0 = () -> "dui-inset-0";
  /** Constant <code>dui_inset_x_0</code> */
  CssClass dui_inset_x_0 = () -> "dui-inset-x-0";
  /** Constant <code>dui_inset_y_0</code> */
  CssClass dui_inset_y_0 = () -> "dui-inset-y-0";
  /** Constant <code>dui_inset_px</code> */
  CssClass dui_inset_px = () -> "dui-inset-px";
  /** Constant <code>dui_inset_x_px</code> */
  CssClass dui_inset_x_px = () -> "dui-inset-x-px";
  /** Constant <code>dui_inset_y_px</code> */
  CssClass dui_inset_y_px = () -> "dui-inset-y-px";
  /** Constant <code>dui_bottom_px</code> */
  CssClass dui_bottom_px = () -> "dui-bottom-px";
  /** Constant <code>dui_inset_0_5</code> */
  CssClass dui_inset_0_5 = () -> "dui-inset-0.5";
  /** Constant <code>dui_inset_x_0_5</code> */
  CssClass dui_inset_x_0_5 = () -> "dui-inset-x-0.5";

  CssClass dui_bottom_auto = () -> "dui-bottom-auto";
  /** Constant <code>dui_bottom_1_2</code> */
  CssClass dui_bottom_1_2 = () -> "dui-bottom-1_2";
  /** Constant <code>dui_bottom_1_3</code> */
  CssClass dui_bottom_1_3 = () -> "dui-bottom-1_3";
  /** Constant <code>dui_bottom_2_3</code> */
  CssClass dui_bottom_2_3 = () -> "dui-bottom-2_3";
  /** Constant <code>dui_bottom_1_4</code> */
  CssClass dui_bottom_1_4 = () -> "dui-bottom-1_4";
  /** Constant <code>dui_bottom_2_4</code> */
  CssClass dui_bottom_2_4 = () -> "dui-bottom-2_4";
  /** Constant <code>dui_bottom_3_4</code> */
  CssClass dui_bottom_3_4 = () -> "dui-bottom-3_4";
  /** Constant <code>dui_bottom_full</code> */
  CssClass dui_bottom_full = () -> "dui-bottom-full";

  CssClass dui_visible = () -> "dui-visible";
  /** Constant <code>dui_invisible</code> */
  CssClass dui_invisible = () -> "dui-invisible";
  /** Constant <code>dui_border_solid</code> */
  CssClass dui_border_solid = () -> "dui-border-solid";
  /** Constant <code>dui_border_dashed</code> */
  CssClass dui_border_dashed = () -> "dui-border-dashed";
  /** Constant <code>dui_border_dotted</code> */
  CssClass dui_border_dotted = () -> "dui-border-dotted";
  /** Constant <code>dui_border_double</code> */
  CssClass dui_border_double = () -> "dui-border-double";
  /** Constant <code>dui_border_hidden</code> */
  CssClass dui_border_hidden = () -> "dui-border-hidden";
  /** Constant <code>dui_border_none</code> */
  CssClass dui_border_none = () -> "dui-border-none";
  /** Constant <code>dui_divide_solid</code> */
  CssClass dui_divide_solid = () -> "dui-divide-solid";
  /** Constant <code>dui_divide_dashed</code> */
  CssClass dui_divide_dashed = () -> "dui-divide-dashed";
  /** Constant <code>dui_divide_dotted</code> */
  CssClass dui_divide_dotted = () -> "dui-divide-dotted";
  /** Constant <code>dui_divide_double</code> */
  CssClass dui_divide_double = () -> "dui-divide-double";
  /** Constant <code>dui_divide_none</code> */
  CssClass dui_divide_none = () -> "dui-divide-none";
  /** Constant <code>dui_outline_none</code> */
  CssClass dui_outline_none = () -> "dui-outline-none";
  /** Constant <code>dui_outline</code> */
  CssClass dui_outline = () -> "dui-outline";
  /** Constant <code>dui_outline_dashed</code> */
  CssClass dui_outline_dashed = () -> "dui-outline-dashed";
  /** Constant <code>dui_outline_dotted</code> */
  CssClass dui_outline_dotted = () -> "dui-outline-dotted";
  /** Constant <code>dui_outline_double</code> */
  CssClass dui_outline_double = () -> "dui-outline-double";
  /** Constant <code>dui_outline_hidden</code> */
  CssClass dui_outline_hidden = () -> "dui-outline-hidden";
  /** Constant <code>dui_elevation_none</code> */
  CssClass dui_elevation_none = () -> "dui-elevation-none";
  /** Constant <code>dui_elevation_sm</code> */
  CssClass dui_elevation_sm = () -> "dui-elevation-sm";
  /** Constant <code>dui_elevation</code> */
  CssClass dui_elevation = () -> "dui-elevation";
  /** Constant <code>dui_elevation_md</code> */
  CssClass dui_elevation_md = () -> "dui-elevation-md";
  /** Constant <code>dui_elevation_lg</code> */
  CssClass dui_elevation_lg = () -> "dui-elevation-lg";
  /** Constant <code>dui_elevation_xl</code> */
  CssClass dui_elevation_xl = () -> "dui-elevation-xl";
  /** Constant <code>dui_elevation_2xl</code> */
  CssClass dui_elevation_2xl = () -> "dui-elevation-2xl";
  /** Constant <code>dui_elevation_inner</code> */
  CssClass dui_elevation_inner = () -> "dui-elevation-inner";
  /** Constant <code>dui_elevation_0</code> */
  CssClass dui_elevation_0 = () -> "dui-elevation-0";
  /** Constant <code>dui_elevation_1</code> */
  CssClass dui_elevation_1 = () -> "dui-elevation-1";
  /** Constant <code>dui_elevation_2</code> */
  CssClass dui_elevation_2 = () -> "dui-elevation-2";
  /** Constant <code>dui_elevation_3</code> */
  CssClass dui_elevation_3 = () -> "dui-elevation-3";
  /** Constant <code>dui_elevation_4</code> */
  CssClass dui_elevation_4 = () -> "dui-elevation-4";
  /** Constant <code>dui_elevation_5</code> */
  CssClass dui_elevation_5 = () -> "dui-elevation-5";
  /** Constant <code>dui_elevation_6</code> */
  CssClass dui_elevation_6 = () -> "dui-elevation-6";
  /** Constant <code>dui_elevation_7</code> */
  CssClass dui_elevation_7 = () -> "dui-elevation-7";
  /** Constant <code>dui_elevation_8</code> */
  CssClass dui_elevation_8 = () -> "dui-elevation-8";
  /** Constant <code>dui_elevation_9</code> */
  CssClass dui_elevation_9 = () -> "dui-elevation-9";
  /** Constant <code>dui_elevation_10</code> */
  CssClass dui_elevation_10 = () -> "dui-elevation-10";
  /** Constant <code>dui_elevation_11</code> */
  CssClass dui_elevation_11 = () -> "dui-elevation-11";
  /** Constant <code>dui_elevation_12</code> */
  CssClass dui_elevation_12 = () -> "dui-elevation-12";
  /** Constant <code>dui_elevation_13</code> */
  CssClass dui_elevation_13 = () -> "dui-elevation-13";
  /** Constant <code>dui_elevation_14</code> */
  CssClass dui_elevation_14 = () -> "dui-elevation-14";
  /** Constant <code>dui_elevation_15</code> */
  CssClass dui_elevation_15 = () -> "dui-elevation-15";
  /** Constant <code>dui_elevation_16</code> */
  CssClass dui_elevation_16 = () -> "dui-elevation-16";
  /** Constant <code>dui_elevation_17</code> */
  CssClass dui_elevation_17 = () -> "dui-elevation-17";
  /** Constant <code>dui_elevation_18</code> */
  CssClass dui_elevation_18 = () -> "dui-elevation-18";
  /** Constant <code>dui_elevation_19</code> */
  CssClass dui_elevation_19 = () -> "dui-elevation-19";
  /** Constant <code>dui_elevation_20</code> */
  CssClass dui_elevation_20 = () -> "dui-elevation-20";
  /** Constant <code>dui_elevation_21</code> */
  CssClass dui_elevation_21 = () -> "dui-elevation-21";
  /** Constant <code>dui_elevation_22</code> */
  CssClass dui_elevation_22 = () -> "dui-elevation-22";
  /** Constant <code>dui_elevation_23</code> */
  CssClass dui_elevation_23 = () -> "dui-elevation-23";
  /** Constant <code>dui_elevation_24</code> */
  CssClass dui_elevation_24 = () -> "dui-elevation-24";
  /** Constant <code>dui_cursor_auto</code> */
  CssClass dui_cursor_auto = () -> "dui-cursor-auto";
  /** Constant <code>dui_cursor_default</code> */
  CssClass dui_cursor_default = () -> "dui-cursor-default";
  /** Constant <code>dui_cursor_pointer</code> */
  CssClass dui_cursor_pointer = () -> "dui-cursor-pointer";
  /** Constant <code>dui_cursor_wait</code> */
  CssClass dui_cursor_wait = () -> "dui-cursor-wait";
  /** Constant <code>dui_cursor_text</code> */
  CssClass dui_cursor_text = () -> "dui-cursor-text";
  /** Constant <code>dui_cursor_move</code> */
  CssClass dui_cursor_move = () -> "dui-cursor-move";
  /** Constant <code>dui_cursor_help</code> */
  CssClass dui_cursor_help = () -> "dui-cursor-help";
  /** Constant <code>dui_cursor_not_allowed</code> */
  CssClass dui_cursor_not_allowed = () -> "dui-cursor-not-allowed";
  /** Constant <code>dui_cursor_none</code> */
  CssClass dui_cursor_none = () -> "dui-cursor-none";
  /** Constant <code>dui_cursor_context_menu</code> */
  CssClass dui_cursor_context_menu = () -> "dui-cursor-context-menu";
  /** Constant <code>dui_cursor_progress</code> */
  CssClass dui_cursor_progress = () -> "dui-cursor-progress";
  /** Constant <code>dui_cursor_cell</code> */
  CssClass dui_cursor_cell = () -> "dui-cursor-cell";
  /** Constant <code>dui_cursor_crosshair</code> */
  CssClass dui_cursor_crosshair = () -> "dui-cursor-crosshair";
  /** Constant <code>dui_cursor_vertical_text</code> */
  CssClass dui_cursor_vertical_text = () -> "dui-cursor-vertical-text";
  /** Constant <code>dui_cursor_alias</code> */
  CssClass dui_cursor_alias = () -> "dui-cursor-alias";
  /** Constant <code>dui_cursor_copy</code> */
  CssClass dui_cursor_copy = () -> "dui-cursor-copy";
  /** Constant <code>dui_cursor_no_drop</code> */
  CssClass dui_cursor_no_drop = () -> "dui-cursor-no-drop";
  /** Constant <code>dui_cursor_grab</code> */
  CssClass dui_cursor_grab = () -> "dui-cursor-grab";
  /** Constant <code>dui_cursor_grabbing</code> */
  CssClass dui_cursor_grabbing = () -> "dui-cursor-grabbing";
  /** Constant <code>dui_cursor_all_scroll</code> */
  CssClass dui_cursor_all_scroll = () -> "dui-cursor-all-scroll";
  /** Constant <code>dui_cursor_col_resize</code> */
  CssClass dui_cursor_col_resize = () -> "dui-cursor-col-resize";
  /** Constant <code>dui_cursor_row_resize</code> */
  CssClass dui_cursor_row_resize = () -> "dui-cursor-row-resize";
  /** Constant <code>dui_cursor_n_resize</code> */
  CssClass dui_cursor_n_resize = () -> "dui-cursor-n-resize";
  /** Constant <code>dui_cursor_e_resize</code> */
  CssClass dui_cursor_e_resize = () -> "dui-cursor-e-resize";
  /** Constant <code>dui_cursor_s_resize</code> */
  CssClass dui_cursor_s_resize = () -> "dui-cursor-s-resize";
  /** Constant <code>dui_cursor_w_resize</code> */
  CssClass dui_cursor_w_resize = () -> "dui-cursor-w-resize";
  /** Constant <code>dui_cursor_ne_resize</code> */
  CssClass dui_cursor_ne_resize = () -> "dui-cursor-ne-resize";
  /** Constant <code>dui_cursor_nw_resize</code> */
  CssClass dui_cursor_nw_resize = () -> "dui-cursor-nw-resize";
  /** Constant <code>dui_cursor_se_resize</code> */
  CssClass dui_cursor_se_resize = () -> "dui-cursor-se-resize";
  /** Constant <code>dui_cursor_sw_resize</code> */
  CssClass dui_cursor_sw_resize = () -> "dui-cursor-sw-resize";
  /** Constant <code>dui_cursor_ew_resize</code> */
  CssClass dui_cursor_ew_resize = () -> "dui-cursor-ew-resize";
  /** Constant <code>dui_cursor_ns_resize</code> */
  CssClass dui_cursor_ns_resize = () -> "dui-cursor-ns-resize";
  /** Constant <code>dui_cursor_nesw_resize</code> */
  CssClass dui_cursor_nesw_resize = () -> "dui-cursor-nesw-resize";
  /** Constant <code>dui_cursor_nwse_resize</code> */
  CssClass dui_cursor_nwse_resize = () -> "dui-cursor-nwse-resize";
  /** Constant <code>dui_cursor_zoom_in</code> */
  CssClass dui_cursor_zoom_in = () -> "dui-cursor-zoom-in";
  /** Constant <code>dui_cursor_zoom_out</code> */
  CssClass dui_cursor_zoom_out = () -> "dui-cursor-zoom-out";
}
