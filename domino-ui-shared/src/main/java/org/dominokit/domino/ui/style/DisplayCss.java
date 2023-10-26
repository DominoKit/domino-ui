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

/** @hidden DisplayCss interface. */
public interface DisplayCss {
  /** @hidden Constant <code>dui_image_responsive</code> */
  CssClass dui_image_responsive = () -> "dui-image-responsive";
  /** @hidden Constant <code>dui_reversed</code> */
  CssClass dui_reversed = () -> "dui-reversed";
  /** @hidden Constant <code>dui_undimmed</code> */
  CssClass dui_undimmed = () -> "dui-undimmed";
  /** @hidden Constant <code>dui_opacity_0</code> */
  CssClass dui_opacity_0 = () -> "dui-opacity-0";
  /** @hidden Constant <code>dui_opacity_5</code> */
  CssClass dui_opacity_5 = () -> "dui-opacity-5";
  /** @hidden Constant <code>dui_opacity_10</code> */
  CssClass dui_opacity_10 = () -> "dui-opacity-10";
  /** @hidden Constant <code>dui_opacity_20</code> */
  CssClass dui_opacity_20 = () -> "dui-opacity-20";
  /** @hidden Constant <code>dui_opacity_25</code> */
  CssClass dui_opacity_25 = () -> "dui-opacity-25";
  /** @hidden Constant <code>dui_opacity_30</code> */
  CssClass dui_opacity_30 = () -> "dui-opacity-30";
  /** @hidden Constant <code>dui_opacity_40</code> */
  CssClass dui_opacity_40 = () -> "dui-opacity-40";
  /** @hidden Constant <code>dui_opacity_50</code> */
  CssClass dui_opacity_50 = () -> "dui-opacity-50";
  /** @hidden Constant <code>dui_opacity_60</code> */
  CssClass dui_opacity_60 = () -> "dui-opacity-60";
  /** @hidden Constant <code>dui_opacity_70</code> */
  CssClass dui_opacity_70 = () -> "dui-opacity-70";
  /** @hidden Constant <code>dui_opacity_75</code> */
  CssClass dui_opacity_75 = () -> "dui-opacity-75";
  /** @hidden Constant <code>dui_opacity_80</code> */
  CssClass dui_opacity_80 = () -> "dui-opacity-80";
  /** @hidden Constant <code>dui_opacity_90</code> */
  CssClass dui_opacity_90 = () -> "dui-opacity-90";
  /** @hidden Constant <code>dui_opacity_95</code> */
  CssClass dui_opacity_95 = () -> "dui-opacity-95";
  /** @hidden Constant <code>dui_opacity_100</code> */
  CssClass dui_opacity_100 = () -> "dui-opacity-100";

  /** @hidden Constant <code>dui_block</code> */
  CssClass dui_block = ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-block");
  /** @hidden Constant <code>dui_block_full</code> */
  CssClass dui_block_full =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-block-full");
  /** @hidden Constant <code>dui_inline_block</code> */
  CssClass dui_inline_block =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-inline-block");
  /** @hidden Constant <code>dui_inline</code> */
  CssClass dui_inline =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-inline");
  /** @hidden Constant <code>dui_flex</code> */
  CssClass dui_flex = ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-flex");
  /** @hidden Constant <code>dui_inline_flex</code> */
  CssClass dui_inline_flex =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-inline-flex");

  /** @hidden Constant <code>dui_table</code> */
  CssClass dui_table = ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table");
  /** @hidden Constant <code>dui_inline_table</code> */
  CssClass dui_inline_table =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-inline-table");
  /** @hidden Constant <code>dui_table_caption</code> */
  CssClass dui_table_caption =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-caption");
  /** @hidden Constant <code>dui_table_cell</code> */
  CssClass dui_table_cell =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-cell");
  /** @hidden Constant <code>dui_table_column</code> */
  CssClass dui_table_column =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-column");
  /** @hidden Constant <code>dui_table_column_group</code> */
  CssClass dui_table_column_group =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-column-group");
  /** @hidden Constant <code>dui_table_footer_group</code> */
  CssClass dui_table_footer_group =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-footer-group");
  /** @hidden Constant <code>dui_table_header_group</code> */
  CssClass dui_table_header_group =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-header-group");
  /** @hidden Constant <code>dui_table_row_group</code> */
  CssClass dui_table_row_group =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-row-group");
  /** @hidden Constant <code>dui_table_row</code> */
  CssClass dui_table_row =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-table-row");
  /** @hidden Constant <code>dui_flow_root</code> */
  CssClass dui_flow_root =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-flow-root");
  /** @hidden Constant <code>dui_grid</code> */
  CssClass dui_grid = ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-grid");
  /** @hidden Constant <code>dui_inline_grid</code> */
  CssClass dui_inline_grid =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-inline-grid");
  /** @hidden Constant <code>dui_contents</code> */
  CssClass dui_contents =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-contents");
  /** @hidden Constant <code>dui_list_item</code> */
  CssClass dui_list_item =
      ReplaceCssClass.of(AggregatedCss.dui_display).replaceWith(() -> "dui-list-item");

  /** @hidden Constant <code>dui_flex_responsive</code> */
  CssClass dui_flex_responsive = () -> "dui-flex-responsive";
  /** @hidden Constant <code>dui_flex_responsive_reverse</code> */
  CssClass dui_flex_responsive_reverse = () -> "dui-flex-responsive-reverse";
  /** @hidden Constant <code>dui_hidden</code> */
  CssClass dui_hidden = () -> "dui-hidden";
  /** @hidden Constant <code>dui_float_right</code> */
  CssClass dui_float_right = () -> "dui-float-right";
  /** @hidden Constant <code>dui_float_left</code> */
  CssClass dui_float_left = () -> "dui-float-left";
  /** @hidden Constant <code>dui_float_none</code> */
  CssClass dui_float_none = () -> "dui-float-none";
  /** @hidden Constant <code>dui_clear_left</code> */
  CssClass dui_clear_left = () -> "dui-clear-left";
  /** @hidden Constant <code>dui_clear_right</code> */
  CssClass dui_clear_right = () -> "dui-clear-right";
  /** @hidden Constant <code>dui_clear_both</code> */
  CssClass dui_clear_both = () -> "dui-clear-both";
  /** @hidden Constant <code>dui_clear_none</code> */
  CssClass dui_clear_none = () -> "dui-clear-none";
  /** @hidden Constant <code>dui_isolate</code> */
  CssClass dui_isolate = () -> "dui-isolate";
  /** @hidden Constant <code>dui_isolation_auto</code> */
  CssClass dui_isolation_auto = () -> "dui-isolation-auto";
  /** @hidden Constant <code>dui_object_contain</code> */
  CssClass dui_object_contain = () -> "dui-object-contain";
  /** @hidden Constant <code>dui_object_cover</code> */
  CssClass dui_object_cover = () -> "dui-object-cover";
  /** @hidden Constant <code>dui_object_fill</code> */
  CssClass dui_object_fill = () -> "dui-object-fill";
  /** @hidden Constant <code>dui_object_none</code> */
  CssClass dui_object_none = () -> "dui-object-none";
  /** @hidden Constant <code>dui_object_scale_down</code> */
  CssClass dui_object_scale_down = () -> "dui-object-scale-down";
  /** @hidden Constant <code>dui_object_bottom</code> */
  CssClass dui_object_bottom = () -> "dui-object-bottom";
  /** @hidden Constant <code>dui_object_center</code> */
  CssClass dui_object_center = () -> "dui-object-center";
  /** @hidden Constant <code>dui_object_left</code> */
  CssClass dui_object_left = () -> "dui-object-left";
  /** @hidden Constant <code>dui_object_left_bottom</code> */
  CssClass dui_object_left_bottom = () -> "dui-object-left-bottom";
  /** @hidden Constant <code>dui_object_left_top</code> */
  CssClass dui_object_left_top = () -> "dui-object-left-top";
  /** @hidden Constant <code>dui_object_right</code> */
  CssClass dui_object_right = () -> "dui-object-right";
  /** @hidden Constant <code>dui_object_right_bottom</code> */
  CssClass dui_object_right_bottom = () -> "dui-object-right-bottom";
  /** @hidden Constant <code>dui_object_right_top</code> */
  CssClass dui_object_right_top = () -> "dui-object-right-top";
  /** @hidden Constant <code>dui_object_top</code> */
  CssClass dui_object_top = () -> "dui-object-top";
  /** @hidden Constant <code>dui_overflow_auto</code> */
  CssClass dui_overflow_auto = () -> "dui-overflow-auto";
  /** @hidden Constant <code>dui_overflow_hidden</code> */
  CssClass dui_overflow_hidden = () -> "dui-overflow-hidden";
  /** @hidden Constant <code>dui_overflow_clip</code> */
  CssClass dui_overflow_clip = () -> "dui-overflow-clip";
  /** @hidden Constant <code>dui_overflow_visible</code> */
  CssClass dui_overflow_visible = () -> "dui-overflow-visible";
  /** @hidden Constant <code>dui_overflow_scroll</code> */
  CssClass dui_overflow_scroll = () -> "dui-overflow-scroll";
  /** @hidden Constant <code>dui_overflow_x_auto</code> */
  CssClass dui_overflow_x_auto = () -> "dui-overflow-x-auto";
  /** @hidden Constant <code>dui_overflow_y_auto</code> */
  CssClass dui_overflow_y_auto = () -> "dui-overflow-y-auto";
  /** @hidden Constant <code>dui_overflow_x_hidden</code> */
  CssClass dui_overflow_x_hidden = () -> "dui-overflow-x-hidden";
  /** @hidden Constant <code>dui_overflow_y_hidden</code> */
  CssClass dui_overflow_y_hidden = () -> "dui-overflow-y-hidden";
  /** @hidden Constant <code>dui_overflow_x_clip</code> */
  CssClass dui_overflow_x_clip = () -> "dui-overflow-x-clip";
  /** @hidden Constant <code>dui_overflow_y_clip</code> */
  CssClass dui_overflow_y_clip = () -> "dui-overflow-y-clip";
  /** @hidden Constant <code>dui_overflow_x_visible</code> */
  CssClass dui_overflow_x_visible = () -> "dui-overflow-x-visible";
  /** @hidden Constant <code>dui_overflow_y_visible</code> */
  CssClass dui_overflow_y_visible = () -> "dui-overflow-y-visible";
  /** @hidden Constant <code>dui_overflow_x_scroll</code> */
  CssClass dui_overflow_x_scroll = () -> "dui-overflow-x-scroll";
  /** @hidden Constant <code>dui_overflow_y_scroll</code> */
  CssClass dui_overflow_y_scroll = () -> "dui-overflow-y-scroll";
  /** @hidden Constant <code>dui_overscroll_auto</code> */
  CssClass dui_overscroll_auto = () -> "dui-overscroll-auto";
  /** @hidden Constant <code>dui_overscroll_contain</code> */
  CssClass dui_overscroll_contain = () -> "dui-overscroll-contain";
  /** @hidden Constant <code>dui_overscroll_none</code> */
  CssClass dui_overscroll_none = () -> "dui-overscroll-none";
  /** @hidden Constant <code>dui_overscroll_y_auto</code> */
  CssClass dui_overscroll_y_auto = () -> "dui-overscroll-y-auto";
  /** @hidden Constant <code>dui_overscroll_y_contain</code> */
  CssClass dui_overscroll_y_contain = () -> "dui-overscroll-y-contain";
  /** @hidden Constant <code>dui_overscroll_y_none</code> */
  CssClass dui_overscroll_y_none = () -> "dui-overscroll-y-none";
  /** @hidden Constant <code>dui_overscroll_x_auto</code> */
  CssClass dui_overscroll_x_auto = () -> "dui-overscroll-x-auto";
  /** @hidden Constant <code>dui_overscroll_x_contain</code> */
  CssClass dui_overscroll_x_contain = () -> "dui-overscroll-x-contain";
  /** @hidden Constant <code>dui_overscroll_x_none</code> */
  CssClass dui_overscroll_x_none = () -> "dui-overscroll-x-none";
  /** @hidden Constant <code>dui_static_</code> */
  CssClass dui_static_ = () -> "dui-static";
  /** @hidden Constant <code>dui_fixed</code> */
  CssClass dui_fixed = () -> "dui-fixed";
  /** @hidden Constant <code>dui_absolute</code> */
  CssClass dui_absolute = () -> "dui-absolute";
  /** @hidden Constant <code>dui_relative</code> */
  CssClass dui_relative = () -> "dui-relative";
  /** @hidden Constant <code>dui_sticky</code> */
  CssClass dui_sticky = () -> "dui-sticky";

  /** @hidden Constant <code>dui_inset_1</code> */
  CssClass dui_inset_1 = () -> "dui-inset-1";
  /** @hidden Constant <code>dui_inset_x_1</code> */
  CssClass dui_inset_x_1 = () -> "dui-inset-x-1";
  /** @hidden Constant <code>dui_inset_y_1</code> */
  CssClass dui_inset_y_1 = () -> "dui-inset-y-1";
  /** @hidden Constant <code>dui_bottom_1</code> */
  CssClass dui_bottom_1 = () -> "dui-bottom-1";
  /** @hidden Constant <code>dui_inset_1_5</code> */
  CssClass dui_inset_1_5 = () -> "dui-inset-1.5";
  /** @hidden Constant <code>dui_inset_x_1_5</code> */
  CssClass dui_inset_x_1_5 = () -> "dui-inset-x-1.5";
  /** @hidden Constant <code>dui_inset_y_1_5</code> */
  CssClass dui_inset_y_1_5 = () -> "dui-inset-y-1.5";
  /** @hidden Constant <code>dui_bottom_1_5</code> */
  CssClass dui_bottom_1_5 = () -> "dui-bottom-1.5";
  /** @hidden Constant <code>dui_inset_2</code> */
  CssClass dui_inset_2 = () -> "dui-inset-2";
  /** @hidden Constant <code>dui_inset_x_2</code> */
  CssClass dui_inset_x_2 = () -> "dui-inset-x-2";
  /** @hidden Constant <code>dui_inset_y_2</code> */
  CssClass dui_inset_y_2 = () -> "dui-inset-y-2";
  /** @hidden Constant <code>dui_bottom_2</code> */
  CssClass dui_bottom_2 = () -> "dui-bottom-2";
  /** @hidden Constant <code>dui_inset_2_5</code> */
  CssClass dui_inset_2_5 = () -> "dui-inset-2.5";
  /** @hidden Constant <code>dui_inset_x_2_5</code> */
  CssClass dui_inset_x_2_5 = () -> "dui-inset-x-2.5";
  /** @hidden Constant <code>dui_inset_y_2_5</code> */
  CssClass dui_inset_y_2_5 = () -> "dui-inset-y-2.5";
  /** @hidden Constant <code>dui_bottom_2_5</code> */
  CssClass dui_bottom_2_5 = () -> "dui-bottom-2.5";
  /** @hidden Constant <code>dui_inset_3</code> */
  CssClass dui_inset_3 = () -> "dui-inset-3";
  /** @hidden Constant <code>dui_inset_x_3</code> */
  CssClass dui_inset_x_3 = () -> "dui-inset-x-3";
  /** @hidden Constant <code>dui_inset_y_3</code> */
  CssClass dui_inset_y_3 = () -> "dui-inset-y-3";
  /** @hidden Constant <code>dui_bottom_3</code> */
  CssClass dui_bottom_3 = () -> "dui-bottom-3";
  /** @hidden Constant <code>dui_inset_3_5</code> */
  CssClass dui_inset_3_5 = () -> "dui-inset-3.5";
  /** @hidden Constant <code>dui_inset_x_3_5</code> */
  CssClass dui_inset_x_3_5 = () -> "dui-inset-x-3.5";
  /** @hidden Constant <code>dui_inset_y_3_5</code> */
  CssClass dui_inset_y_3_5 = () -> "dui-inset-y-3.5";
  /** @hidden Constant <code>dui_bottom_3_5</code> */
  CssClass dui_bottom_3_5 = () -> "dui-bottom-3.5";
  /** @hidden Constant <code>dui_inset_4</code> */
  CssClass dui_inset_4 = () -> "dui-inset-4";
  /** @hidden Constant <code>dui_inset_x_4</code> */
  CssClass dui_inset_x_4 = () -> "dui-inset-x-4";
  /** @hidden Constant <code>dui_inset_y_4</code> */
  CssClass dui_inset_y_4 = () -> "dui-inset-y-4";
  /** @hidden Constant <code>dui_bottom_4</code> */
  CssClass dui_bottom_4 = () -> "dui-bottom-4";
  /** @hidden Constant <code>dui_inset_5</code> */
  CssClass dui_inset_5 = () -> "dui-inset-5";
  /** @hidden Constant <code>dui_inset_x_5</code> */
  CssClass dui_inset_x_5 = () -> "dui-inset-x-5";
  /** @hidden Constant <code>dui_inset_y_5</code> */
  CssClass dui_inset_y_5 = () -> "dui-inset-y-5";
  /** @hidden Constant <code>dui_bottom_5</code> */
  CssClass dui_bottom_5 = () -> "dui-bottom-5";
  /** @hidden Constant <code>dui_inset_6</code> */
  CssClass dui_inset_6 = () -> "dui-inset-6";
  /** @hidden Constant <code>dui_inset_x_6</code> */
  CssClass dui_inset_x_6 = () -> "dui-inset-x-6";
  /** @hidden Constant <code>dui_inset_y_6</code> */
  CssClass dui_inset_y_6 = () -> "dui-inset-y-6";
  /** @hidden Constant <code>dui_bottom_6</code> */
  CssClass dui_bottom_6 = () -> "dui-bottom-6";
  /** @hidden Constant <code>dui_inset_7</code> */
  CssClass dui_inset_7 = () -> "dui-inset-7";
  /** @hidden Constant <code>dui_inset_x_7</code> */
  CssClass dui_inset_x_7 = () -> "dui-inset-x-7";
  /** @hidden Constant <code>dui_inset_y_7</code> */
  CssClass dui_inset_y_7 = () -> "dui-inset-y-7";
  /** @hidden Constant <code>dui_bottom_7</code> */
  CssClass dui_bottom_7 = () -> "dui-bottom-7";
  /** @hidden Constant <code>dui_inset_8</code> */
  CssClass dui_inset_8 = () -> "dui-inset-8";
  /** @hidden Constant <code>dui_inset_x_8</code> */
  CssClass dui_inset_x_8 = () -> "dui-inset-x-8";
  /** @hidden Constant <code>dui_inset_y_8</code> */
  CssClass dui_inset_y_8 = () -> "dui-inset-y-8";
  /** @hidden Constant <code>dui_bottom_8</code> */
  CssClass dui_bottom_8 = () -> "dui-bottom-8";
  /** @hidden Constant <code>dui_inset_9</code> */
  CssClass dui_inset_9 = () -> "dui-inset-9";
  /** @hidden Constant <code>dui_inset_x_9</code> */
  CssClass dui_inset_x_9 = () -> "dui-inset-x-9";
  /** @hidden Constant <code>dui_inset_y_9</code> */
  CssClass dui_inset_y_9 = () -> "dui-inset-y-9";
  /** @hidden Constant <code>dui_bottom_9</code> */
  CssClass dui_bottom_9 = () -> "dui-bottom-9";
  /** @hidden Constant <code>dui_inset_10</code> */
  CssClass dui_inset_10 = () -> "dui-inset-10";
  /** @hidden Constant <code>dui_inset_x_10</code> */
  CssClass dui_inset_x_10 = () -> "dui-inset-x-10";
  /** @hidden Constant <code>dui_inset_y_10</code> */
  CssClass dui_inset_y_10 = () -> "dui-inset-y-10";
  /** @hidden Constant <code>dui_bottom_10</code> */
  CssClass dui_bottom_10 = () -> "dui-bottom-10";
  /** @hidden Constant <code>dui_inset_11</code> */
  CssClass dui_inset_11 = () -> "dui-inset-11";
  /** @hidden Constant <code>dui_inset_x_11</code> */
  CssClass dui_inset_x_11 = () -> "dui-inset-x-11";
  /** @hidden Constant <code>dui_inset_y_11</code> */
  CssClass dui_inset_y_11 = () -> "dui-inset-y-11";
  /** @hidden Constant <code>dui_bottom_11</code> */
  CssClass dui_bottom_11 = () -> "dui-bottom-11";
  /** @hidden Constant <code>dui_inset_12</code> */
  CssClass dui_inset_12 = () -> "dui-inset-12";
  /** @hidden Constant <code>dui_inset_x_12</code> */
  CssClass dui_inset_x_12 = () -> "dui-inset-x-12";
  /** @hidden Constant <code>dui_inset_y_12</code> */
  CssClass dui_inset_y_12 = () -> "dui-inset-y-12";
  /** @hidden Constant <code>dui_bottom_12</code> */
  CssClass dui_bottom_12 = () -> "dui-bottom-12";
  /** @hidden Constant <code>dui_inset_14</code> */
  CssClass dui_inset_14 = () -> "dui-inset-14";
  /** @hidden Constant <code>dui_inset_x_14</code> */
  CssClass dui_inset_x_14 = () -> "dui-inset-x-14";
  /** @hidden Constant <code>dui_inset_y_14</code> */
  CssClass dui_inset_y_14 = () -> "dui-inset-y-14";
  /** @hidden Constant <code>dui_bottom_14</code> */
  CssClass dui_bottom_14 = () -> "dui-bottom-14";
  /** @hidden Constant <code>dui_inset_16</code> */
  CssClass dui_inset_16 = () -> "dui-inset-16";
  /** @hidden Constant <code>dui_inset_x_16</code> */
  CssClass dui_inset_x_16 = () -> "dui-inset-x-16";
  /** @hidden Constant <code>dui_inset_y_16</code> */
  CssClass dui_inset_y_16 = () -> "dui-inset-y-16";
  /** @hidden Constant <code>dui_bottom_16</code> */
  CssClass dui_bottom_16 = () -> "dui-bottom-16";
  /** @hidden Constant <code>dui_inset_20</code> */
  CssClass dui_inset_20 = () -> "dui-inset-20";
  /** @hidden Constant <code>dui_inset_x_20</code> */
  CssClass dui_inset_x_20 = () -> "dui-inset-x-20";
  /** @hidden Constant <code>dui_inset_y_20</code> */
  CssClass dui_inset_y_20 = () -> "dui-inset-y-20";
  /** @hidden Constant <code>dui_bottom_20</code> */
  CssClass dui_bottom_20 = () -> "dui-bottom-20";
  /** @hidden Constant <code>dui_inset_24</code> */
  CssClass dui_inset_24 = () -> "dui-inset-24";
  /** @hidden Constant <code>dui_inset_x_24</code> */
  CssClass dui_inset_x_24 = () -> "dui-inset-x-24";
  /** @hidden Constant <code>dui_inset_y_24</code> */
  CssClass dui_inset_y_24 = () -> "dui-inset-y-24";
  /** @hidden Constant <code>dui_bottom_24</code> */
  CssClass dui_bottom_24 = () -> "dui-bottom-24";
  /** @hidden Constant <code>dui_inset_28</code> */
  CssClass dui_inset_28 = () -> "dui-inset-28";
  /** @hidden Constant <code>dui_inset_x_28</code> */
  CssClass dui_inset_x_28 = () -> "dui-inset-x-28";
  /** @hidden Constant <code>dui_inset_y_28</code> */
  CssClass dui_inset_y_28 = () -> "dui-inset-y-28";
  /** @hidden Constant <code>dui_bottom_28</code> */
  CssClass dui_bottom_28 = () -> "dui-bottom-28";
  /** @hidden Constant <code>dui_inset_32</code> */
  CssClass dui_inset_32 = () -> "dui-inset-32";
  /** @hidden Constant <code>dui_inset_x_32</code> */
  CssClass dui_inset_x_32 = () -> "dui-inset-x-32";
  /** @hidden Constant <code>dui_inset_y_32</code> */
  CssClass dui_inset_y_32 = () -> "dui-inset-y-32";
  /** @hidden Constant <code>dui_bottom_32</code> */
  CssClass dui_bottom_32 = () -> "dui-bottom-32";
  /** @hidden Constant <code>dui_inset_36</code> */
  CssClass dui_inset_36 = () -> "dui-inset-36";
  /** @hidden Constant <code>dui_inset_x_36</code> */
  CssClass dui_inset_x_36 = () -> "dui-inset-x-36";
  /** @hidden Constant <code>dui_inset_y_36</code> */
  CssClass dui_inset_y_36 = () -> "dui-inset-y-36";
  /** @hidden Constant <code>dui_bottom_36</code> */
  CssClass dui_bottom_36 = () -> "dui-bottom-36";
  /** @hidden Constant <code>dui_inset_40</code> */
  CssClass dui_inset_40 = () -> "dui-inset-40";
  /** @hidden Constant <code>dui_inset_x_40</code> */
  CssClass dui_inset_x_40 = () -> "dui-inset-x-40";
  /** @hidden Constant <code>dui_inset_y_40</code> */
  CssClass dui_inset_y_40 = () -> "dui-inset-y-40";
  /** @hidden Constant <code>dui_bottom_40</code> */
  CssClass dui_bottom_40 = () -> "dui-bottom-40";
  /** @hidden Constant <code>dui_inset_44</code> */
  CssClass dui_inset_44 = () -> "dui-inset-44";
  /** @hidden Constant <code>dui_inset_x_44</code> */
  CssClass dui_inset_x_44 = () -> "dui-inset-x-44";
  /** @hidden Constant <code>dui_inset_y_44</code> */
  CssClass dui_inset_y_44 = () -> "dui-inset-y-44";
  /** @hidden Constant <code>dui_bottom_44</code> */
  CssClass dui_bottom_44 = () -> "dui-bottom-44";
  /** @hidden Constant <code>dui_inset_48</code> */
  CssClass dui_inset_48 = () -> "dui-inset-48";
  /** @hidden Constant <code>dui_inset_x_48</code> */
  CssClass dui_inset_x_48 = () -> "dui-inset-x-48";
  /** @hidden Constant <code>dui_inset_y_48</code> */
  CssClass dui_inset_y_48 = () -> "dui-inset-y-48";
  /** @hidden Constant <code>dui_bottom_48</code> */
  CssClass dui_bottom_48 = () -> "dui-bottom-48";
  /** @hidden Constant <code>dui_inset_52</code> */
  CssClass dui_inset_52 = () -> "dui-inset-52";
  /** @hidden Constant <code>dui_inset_x_52</code> */
  CssClass dui_inset_x_52 = () -> "dui-inset-x-52";
  /** @hidden Constant <code>dui_inset_y_52</code> */
  CssClass dui_inset_y_52 = () -> "dui-inset-y-52";
  /** @hidden Constant <code>dui_bottom_52</code> */
  CssClass dui_bottom_52 = () -> "dui-bottom-52";
  /** @hidden Constant <code>dui_inset_56</code> */
  CssClass dui_inset_56 = () -> "dui-inset-56";
  /** @hidden Constant <code>dui_inset_x_56</code> */
  CssClass dui_inset_x_56 = () -> "dui-inset-x-56";
  /** @hidden Constant <code>dui_inset_y_56</code> */
  CssClass dui_inset_y_56 = () -> "dui-inset-y-56";
  /** @hidden Constant <code>dui_bottom_56</code> */
  CssClass dui_bottom_56 = () -> "dui-bottom-56";
  /** @hidden Constant <code>dui_inset_60</code> */
  CssClass dui_inset_60 = () -> "dui-inset-60";
  /** @hidden Constant <code>dui_inset_x_60</code> */
  CssClass dui_inset_x_60 = () -> "dui-inset-x-60";
  /** @hidden Constant <code>dui_inset_y_60</code> */
  CssClass dui_inset_y_60 = () -> "dui-inset-y-60";
  /** @hidden Constant <code>dui_bottom_60</code> */
  CssClass dui_bottom_60 = () -> "dui-bottom-60";
  /** @hidden Constant <code>dui_inset_64</code> */
  CssClass dui_inset_64 = () -> "dui-inset-64";
  /** @hidden Constant <code>dui_inset_x_64</code> */
  CssClass dui_inset_x_64 = () -> "dui-inset-x-64";
  /** @hidden Constant <code>dui_inset_y_64</code> */
  CssClass dui_inset_y_64 = () -> "dui-inset-y-64";
  /** @hidden Constant <code>dui_bottom_64</code> */
  CssClass dui_bottom_64 = () -> "dui-bottom-64";
  /** @hidden Constant <code>dui_inset_72</code> */
  CssClass dui_inset_72 = () -> "dui-inset-72";
  /** @hidden Constant <code>dui_inset_x_72</code> */
  CssClass dui_inset_x_72 = () -> "dui-inset-x-72";
  /** @hidden Constant <code>dui_inset_y_72</code> */
  CssClass dui_inset_y_72 = () -> "dui-inset-y-72";
  /** @hidden Constant <code>dui_bottom_72</code> */
  CssClass dui_bottom_72 = () -> "dui-bottom-72";
  /** @hidden Constant <code>dui_inset_80</code> */
  CssClass dui_inset_80 = () -> "dui-inset-80";
  /** @hidden Constant <code>dui_inset_x_80</code> */
  CssClass dui_inset_x_80 = () -> "dui-inset-x-80";
  /** @hidden Constant <code>dui_inset_y_80</code> */
  CssClass dui_inset_y_80 = () -> "dui-inset-y-80";
  /** @hidden Constant <code>dui_bottom_80</code> */
  CssClass dui_bottom_80 = () -> "dui-bottom-80";
  /** @hidden Constant <code>dui_inset_96</code> */
  CssClass dui_inset_96 = () -> "dui-inset-96";
  /** @hidden Constant <code>dui_inset_x_96</code> */
  CssClass dui_inset_x_96 = () -> "dui-inset-x-96";
  /** @hidden Constant <code>dui_inset_y_96</code> */
  CssClass dui_inset_y_96 = () -> "dui-inset-y-96";
  /** @hidden Constant <code>dui_bottom_96</code> */
  CssClass dui_bottom_96 = () -> "dui-bottom-96";
  /** @hidden Constant <code>dui_inset_auto</code> */
  CssClass dui_inset_auto = () -> "dui-inset-auto";
  /** @hidden Constant <code>dui_inset_1_2</code> */
  CssClass dui_inset_1_2 = () -> "dui-inset-1_2";
  /** @hidden Constant <code>dui_inset_1_3</code> */
  CssClass dui_inset_1_3 = () -> "dui-inset-1_3";
  /** @hidden Constant <code>dui_inset_2_3</code> */
  CssClass dui_inset_2_3 = () -> "dui-inset-2_3";
  /** @hidden Constant <code>dui_inset_1_4</code> */
  CssClass dui_inset_1_4 = () -> "dui-inset-1_4";
  /** @hidden Constant <code>dui_inset_2_4</code> */
  CssClass dui_inset_2_4 = () -> "dui-inset-2_4";
  /** @hidden Constant <code>dui_inset_3_4</code> */
  CssClass dui_inset_3_4 = () -> "dui-inset-3_4";
  /** @hidden Constant <code>dui_inset_full</code> */
  CssClass dui_inset_full = () -> "dui-inset-full";
  /** @hidden Constant <code>dui_inset_x_auto</code> */
  CssClass dui_inset_x_auto = () -> "dui-inset-x-auto";
  /** @hidden Constant <code>dui_inset_x_1_2</code> */
  CssClass dui_inset_x_1_2 = () -> "dui-inset-x-1_2";
  /** @hidden Constant <code>dui_inset_x_1_3</code> */
  CssClass dui_inset_x_1_3 = () -> "dui-inset-x-1_3";
  /** @hidden Constant <code>dui_inset_x_2_3</code> */
  CssClass dui_inset_x_2_3 = () -> "dui-inset-x-2_3";
  /** @hidden Constant <code>dui_inset_x_1_4</code> */
  CssClass dui_inset_x_1_4 = () -> "dui-inset-x-1_4";
  /** @hidden Constant <code>dui_inset_x_2_4</code> */
  CssClass dui_inset_x_2_4 = () -> "dui-inset-x-2_4";
  /** @hidden Constant <code>dui_inset_x_3_4</code> */
  CssClass dui_inset_x_3_4 = () -> "dui-inset-x-3_4";
  /** @hidden Constant <code>dui_inset_x_full</code> */
  CssClass dui_inset_x_full = () -> "dui-inset-x-full";
  /** @hidden Constant <code>dui_inset_y_auto</code> */
  CssClass dui_inset_y_auto = () -> "dui-inset-y-auto";
  /** @hidden Constant <code>dui_inset_y_1_2</code> */
  CssClass dui_inset_y_1_2 = () -> "dui-inset-y-1_2";
  /** @hidden Constant <code>dui_inset_y_1_3</code> */
  CssClass dui_inset_y_1_3 = () -> "dui-inset-y-1_3";
  /** @hidden Constant <code>dui_inset_y_2_3</code> */
  CssClass dui_inset_y_2_3 = () -> "dui-inset-y-2_3";
  /** @hidden Constant <code>dui_inset_y_1_4</code> */
  CssClass dui_inset_y_1_4 = () -> "dui-inset-y-1_4";
  /** @hidden Constant <code>dui_inset_y_2_4</code> */
  CssClass dui_inset_y_2_4 = () -> "dui-inset-y-2_4";
  /** @hidden Constant <code>dui_inset_y_3_4</code> */
  CssClass dui_inset_y_3_4 = () -> "dui-inset-y-3_4";
  /** @hidden Constant <code>dui_inset_y_full</code> */
  CssClass dui_inset_y_full = () -> "dui-inset-y-full";
  /** @hidden Constant <code>dui_bottom_0</code> */
  CssClass dui_bottom_0 = () -> "dui-bottom-0";
  /** @hidden Constant <code>dui_inset_y_0_5</code> */
  CssClass dui_inset_y_0_5 = () -> "dui-inset-y-0.5";
  /** @hidden Constant <code>dui_bottom_0_5</code> */
  CssClass dui_bottom_0_5 = () -> "dui-bottom-0.5";
  /** @hidden Constant <code>dui_inset_0</code> */
  CssClass dui_inset_0 = () -> "dui-inset-0";
  /** @hidden Constant <code>dui_inset_x_0</code> */
  CssClass dui_inset_x_0 = () -> "dui-inset-x-0";
  /** @hidden Constant <code>dui_inset_y_0</code> */
  CssClass dui_inset_y_0 = () -> "dui-inset-y-0";
  /** @hidden Constant <code>dui_inset_px</code> */
  CssClass dui_inset_px = () -> "dui-inset-px";
  /** @hidden Constant <code>dui_inset_x_px</code> */
  CssClass dui_inset_x_px = () -> "dui-inset-x-px";
  /** @hidden Constant <code>dui_inset_y_px</code> */
  CssClass dui_inset_y_px = () -> "dui-inset-y-px";
  /** @hidden Constant <code>dui_bottom_px</code> */
  CssClass dui_bottom_px = () -> "dui-bottom-px";
  /** @hidden Constant <code>dui_inset_0_5</code> */
  CssClass dui_inset_0_5 = () -> "dui-inset-0.5";
  /** @hidden Constant <code>dui_inset_x_0_5</code> */
  CssClass dui_inset_x_0_5 = () -> "dui-inset-x-0.5";

  CssClass dui_bottom_auto = () -> "dui-bottom-auto";
  /** @hidden Constant <code>dui_bottom_1_2</code> */
  CssClass dui_bottom_1_2 = () -> "dui-bottom-1_2";
  /** @hidden Constant <code>dui_bottom_1_3</code> */
  CssClass dui_bottom_1_3 = () -> "dui-bottom-1_3";
  /** @hidden Constant <code>dui_bottom_2_3</code> */
  CssClass dui_bottom_2_3 = () -> "dui-bottom-2_3";
  /** @hidden Constant <code>dui_bottom_1_4</code> */
  CssClass dui_bottom_1_4 = () -> "dui-bottom-1_4";
  /** @hidden Constant <code>dui_bottom_2_4</code> */
  CssClass dui_bottom_2_4 = () -> "dui-bottom-2_4";
  /** @hidden Constant <code>dui_bottom_3_4</code> */
  CssClass dui_bottom_3_4 = () -> "dui-bottom-3_4";
  /** @hidden Constant <code>dui_bottom_full</code> */
  CssClass dui_bottom_full = () -> "dui-bottom-full";

  CssClass dui_visible = () -> "dui-visible";
  /** @hidden Constant <code>dui_invisible</code> */
  CssClass dui_invisible = () -> "dui-invisible";
  /** @hidden Constant <code>dui_border_solid</code> */
  CssClass dui_border_solid = () -> "dui-border-solid";
  /** @hidden Constant <code>dui_border_dashed</code> */
  CssClass dui_border_dashed = () -> "dui-border-dashed";
  /** @hidden Constant <code>dui_border_dotted</code> */
  CssClass dui_border_dotted = () -> "dui-border-dotted";
  /** @hidden Constant <code>dui_border_double</code> */
  CssClass dui_border_double = () -> "dui-border-double";
  /** @hidden Constant <code>dui_border_hidden</code> */
  CssClass dui_border_hidden = () -> "dui-border-hidden";
  /** @hidden Constant <code>dui_border_none</code> */
  CssClass dui_border_none = () -> "dui-border-none";
  /** @hidden Constant <code>dui_divide_solid</code> */
  CssClass dui_divide_solid = () -> "dui-divide-solid";
  /** @hidden Constant <code>dui_divide_dashed</code> */
  CssClass dui_divide_dashed = () -> "dui-divide-dashed";
  /** @hidden Constant <code>dui_divide_dotted</code> */
  CssClass dui_divide_dotted = () -> "dui-divide-dotted";
  /** @hidden Constant <code>dui_divide_double</code> */
  CssClass dui_divide_double = () -> "dui-divide-double";
  /** @hidden Constant <code>dui_divide_none</code> */
  CssClass dui_divide_none = () -> "dui-divide-none";
  /** @hidden Constant <code>dui_outline_none</code> */
  CssClass dui_outline_none = () -> "dui-outline-none";
  /** @hidden Constant <code>dui_outline</code> */
  CssClass dui_outline = () -> "dui-outline";
  /** @hidden Constant <code>dui_outline_dashed</code> */
  CssClass dui_outline_dashed = () -> "dui-outline-dashed";
  /** @hidden Constant <code>dui_outline_dotted</code> */
  CssClass dui_outline_dotted = () -> "dui-outline-dotted";
  /** @hidden Constant <code>dui_outline_double</code> */
  CssClass dui_outline_double = () -> "dui-outline-double";
  /** @hidden Constant <code>dui_outline_hidden</code> */
  CssClass dui_outline_hidden = () -> "dui-outline-hidden";
  /** @hidden Constant <code>dui_elevation_none</code> */
  CssClass dui_elevation_none = () -> "dui-elevation-none";
  /** @hidden Constant <code>dui_elevation_sm</code> */
  CssClass dui_elevation_sm = () -> "dui-elevation-sm";
  /** @hidden Constant <code>dui_elevation</code> */
  CssClass dui_elevation = () -> "dui-elevation";
  /** @hidden Constant <code>dui_elevation_md</code> */
  CssClass dui_elevation_md = () -> "dui-elevation-md";
  /** @hidden Constant <code>dui_elevation_lg</code> */
  CssClass dui_elevation_lg = () -> "dui-elevation-lg";
  /** @hidden Constant <code>dui_elevation_xl</code> */
  CssClass dui_elevation_xl = () -> "dui-elevation-xl";
  /** @hidden Constant <code>dui_elevation_2xl</code> */
  CssClass dui_elevation_2xl = () -> "dui-elevation-2xl";
  /** @hidden Constant <code>dui_elevation_inner</code> */
  CssClass dui_elevation_inner = () -> "dui-elevation-inner";
  /** @hidden Constant <code>dui_elevation_0</code> */
  CssClass dui_elevation_0 = () -> "dui-elevation-0";
  /** @hidden Constant <code>dui_elevation_1</code> */
  CssClass dui_elevation_1 = () -> "dui-elevation-1";
  /** @hidden Constant <code>dui_elevation_2</code> */
  CssClass dui_elevation_2 = () -> "dui-elevation-2";
  /** @hidden Constant <code>dui_elevation_3</code> */
  CssClass dui_elevation_3 = () -> "dui-elevation-3";
  /** @hidden Constant <code>dui_elevation_4</code> */
  CssClass dui_elevation_4 = () -> "dui-elevation-4";
  /** @hidden Constant <code>dui_elevation_5</code> */
  CssClass dui_elevation_5 = () -> "dui-elevation-5";
  /** @hidden Constant <code>dui_elevation_6</code> */
  CssClass dui_elevation_6 = () -> "dui-elevation-6";
  /** @hidden Constant <code>dui_elevation_7</code> */
  CssClass dui_elevation_7 = () -> "dui-elevation-7";
  /** @hidden Constant <code>dui_elevation_8</code> */
  CssClass dui_elevation_8 = () -> "dui-elevation-8";
  /** @hidden Constant <code>dui_elevation_9</code> */
  CssClass dui_elevation_9 = () -> "dui-elevation-9";
  /** @hidden Constant <code>dui_elevation_10</code> */
  CssClass dui_elevation_10 = () -> "dui-elevation-10";
  /** @hidden Constant <code>dui_elevation_11</code> */
  CssClass dui_elevation_11 = () -> "dui-elevation-11";
  /** @hidden Constant <code>dui_elevation_12</code> */
  CssClass dui_elevation_12 = () -> "dui-elevation-12";
  /** @hidden Constant <code>dui_elevation_13</code> */
  CssClass dui_elevation_13 = () -> "dui-elevation-13";
  /** @hidden Constant <code>dui_elevation_14</code> */
  CssClass dui_elevation_14 = () -> "dui-elevation-14";
  /** @hidden Constant <code>dui_elevation_15</code> */
  CssClass dui_elevation_15 = () -> "dui-elevation-15";
  /** @hidden Constant <code>dui_elevation_16</code> */
  CssClass dui_elevation_16 = () -> "dui-elevation-16";
  /** @hidden Constant <code>dui_elevation_17</code> */
  CssClass dui_elevation_17 = () -> "dui-elevation-17";
  /** @hidden Constant <code>dui_elevation_18</code> */
  CssClass dui_elevation_18 = () -> "dui-elevation-18";
  /** @hidden Constant <code>dui_elevation_19</code> */
  CssClass dui_elevation_19 = () -> "dui-elevation-19";
  /** @hidden Constant <code>dui_elevation_20</code> */
  CssClass dui_elevation_20 = () -> "dui-elevation-20";
  /** @hidden Constant <code>dui_elevation_21</code> */
  CssClass dui_elevation_21 = () -> "dui-elevation-21";
  /** @hidden Constant <code>dui_elevation_22</code> */
  CssClass dui_elevation_22 = () -> "dui-elevation-22";
  /** @hidden Constant <code>dui_elevation_23</code> */
  CssClass dui_elevation_23 = () -> "dui-elevation-23";
  /** @hidden Constant <code>dui_elevation_24</code> */
  CssClass dui_elevation_24 = () -> "dui-elevation-24";
  /** @hidden Constant <code>dui_cursor_auto</code> */
  CssClass dui_cursor_auto = () -> "dui-cursor-auto";
  /** @hidden Constant <code>dui_cursor_default</code> */
  CssClass dui_cursor_default = () -> "dui-cursor-default";
  /** @hidden Constant <code>dui_cursor_pointer</code> */
  CssClass dui_cursor_pointer = () -> "dui-cursor-pointer";
  /** @hidden Constant <code>dui_cursor_wait</code> */
  CssClass dui_cursor_wait = () -> "dui-cursor-wait";
  /** @hidden Constant <code>dui_cursor_text</code> */
  CssClass dui_cursor_text = () -> "dui-cursor-text";
  /** @hidden Constant <code>dui_cursor_move</code> */
  CssClass dui_cursor_move = () -> "dui-cursor-move";
  /** @hidden Constant <code>dui_cursor_help</code> */
  CssClass dui_cursor_help = () -> "dui-cursor-help";
  /** @hidden Constant <code>dui_cursor_not_allowed</code> */
  CssClass dui_cursor_not_allowed = () -> "dui-cursor-not-allowed";
  /** @hidden Constant <code>dui_cursor_none</code> */
  CssClass dui_cursor_none = () -> "dui-cursor-none";
  /** @hidden Constant <code>dui_cursor_context_menu</code> */
  CssClass dui_cursor_context_menu = () -> "dui-cursor-context-menu";
  /** @hidden Constant <code>dui_cursor_progress</code> */
  CssClass dui_cursor_progress = () -> "dui-cursor-progress";
  /** @hidden Constant <code>dui_cursor_cell</code> */
  CssClass dui_cursor_cell = () -> "dui-cursor-cell";
  /** @hidden Constant <code>dui_cursor_crosshair</code> */
  CssClass dui_cursor_crosshair = () -> "dui-cursor-crosshair";
  /** @hidden Constant <code>dui_cursor_vertical_text</code> */
  CssClass dui_cursor_vertical_text = () -> "dui-cursor-vertical-text";
  /** @hidden Constant <code>dui_cursor_alias</code> */
  CssClass dui_cursor_alias = () -> "dui-cursor-alias";
  /** @hidden Constant <code>dui_cursor_copy</code> */
  CssClass dui_cursor_copy = () -> "dui-cursor-copy";
  /** @hidden Constant <code>dui_cursor_no_drop</code> */
  CssClass dui_cursor_no_drop = () -> "dui-cursor-no-drop";
  /** @hidden Constant <code>dui_cursor_grab</code> */
  CssClass dui_cursor_grab = () -> "dui-cursor-grab";
  /** @hidden Constant <code>dui_cursor_grabbing</code> */
  CssClass dui_cursor_grabbing = () -> "dui-cursor-grabbing";
  /** @hidden Constant <code>dui_cursor_all_scroll</code> */
  CssClass dui_cursor_all_scroll = () -> "dui-cursor-all-scroll";
  /** @hidden Constant <code>dui_cursor_col_resize</code> */
  CssClass dui_cursor_col_resize = () -> "dui-cursor-col-resize";
  /** @hidden Constant <code>dui_cursor_row_resize</code> */
  CssClass dui_cursor_row_resize = () -> "dui-cursor-row-resize";
  /** @hidden Constant <code>dui_cursor_n_resize</code> */
  CssClass dui_cursor_n_resize = () -> "dui-cursor-n-resize";
  /** @hidden Constant <code>dui_cursor_e_resize</code> */
  CssClass dui_cursor_e_resize = () -> "dui-cursor-e-resize";
  /** @hidden Constant <code>dui_cursor_s_resize</code> */
  CssClass dui_cursor_s_resize = () -> "dui-cursor-s-resize";
  /** @hidden Constant <code>dui_cursor_w_resize</code> */
  CssClass dui_cursor_w_resize = () -> "dui-cursor-w-resize";
  /** @hidden Constant <code>dui_cursor_ne_resize</code> */
  CssClass dui_cursor_ne_resize = () -> "dui-cursor-ne-resize";
  /** @hidden Constant <code>dui_cursor_nw_resize</code> */
  CssClass dui_cursor_nw_resize = () -> "dui-cursor-nw-resize";
  /** @hidden Constant <code>dui_cursor_se_resize</code> */
  CssClass dui_cursor_se_resize = () -> "dui-cursor-se-resize";
  /** @hidden Constant <code>dui_cursor_sw_resize</code> */
  CssClass dui_cursor_sw_resize = () -> "dui-cursor-sw-resize";
  /** @hidden Constant <code>dui_cursor_ew_resize</code> */
  CssClass dui_cursor_ew_resize = () -> "dui-cursor-ew-resize";
  /** @hidden Constant <code>dui_cursor_ns_resize</code> */
  CssClass dui_cursor_ns_resize = () -> "dui-cursor-ns-resize";
  /** @hidden Constant <code>dui_cursor_nesw_resize</code> */
  CssClass dui_cursor_nesw_resize = () -> "dui-cursor-nesw-resize";
  /** @hidden Constant <code>dui_cursor_nwse_resize</code> */
  CssClass dui_cursor_nwse_resize = () -> "dui-cursor-nwse-resize";
  /** @hidden Constant <code>dui_cursor_zoom_in</code> */
  CssClass dui_cursor_zoom_in = () -> "dui-cursor-zoom-in";
  /** @hidden Constant <code>dui_cursor_zoom_out</code> */
  CssClass dui_cursor_zoom_out = () -> "dui-cursor-zoom-out";
}
