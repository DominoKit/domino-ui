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

/** GenericCss interface. */
public interface GenericCss {
  /** Constant <code>dui</code> */
  CssClass dui = () -> "dui";

  /** Constant <code>dui_ignore_bg</code> */
  CssClass dui_ignore_bg = () -> "dui-ignore-bg";
  /** Constant <code>dui_ignore_fg</code> */
  CssClass dui_ignore_fg = () -> "dui-ignore-fg";

  /** Constant <code>dui_odd</code> */
  CssClass dui_odd = ReplaceCssClass.of(() -> "dui-even").replaceWith(() -> "dui-odd");
  /** Constant <code>dui_even</code> */
  CssClass dui_even = ReplaceCssClass.of(() -> "dui-odd").replaceWith(() -> "dui-even");
  /** Constant <code>dui_primary</code> */
  CssClass dui_primary =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-success"))
          .replaceWith(() -> "dui-primary");
  /** Constant <code>dui_secondary</code> */
  CssClass dui_secondary =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-primary",
                  () -> "dui-success"))
          .replaceWith(() -> "dui-secondary");
  /** Constant <code>dui_dominant</code> */
  CssClass dui_dominant =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-secondary",
                  () -> "dui-primary",
                  () -> "dui-success"))
          .replaceWith(() -> "dui-dominant");
  /** Constant <code>dui_accent</code> */
  CssClass dui_accent =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary",
                  () -> "dui-success"))
          .replaceWith(() -> "dui-accent");
  /** Constant <code>dui_success</code> */
  CssClass dui_success =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(() -> "dui-success");
  /** Constant <code>dui_info</code> */
  CssClass dui_info =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-success",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(() -> "dui-info");
  /** Constant <code>dui_warning</code> */
  CssClass dui_warning =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-success",
                  () -> "dui-info",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(() -> "dui-warning");
  /** Constant <code>dui_error</code> */
  CssClass dui_error =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-success",
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(() -> "dui-error");

  /** Constant <code>dui_red</code> */
  CssClass dui_red = () -> "dui-red";
  /** Constant <code>dui_pink</code> */
  CssClass dui_pink = () -> "dui-pink";
  /** Constant <code>dui_purple</code> */
  CssClass dui_purple = () -> "dui-purple";
  /** Constant <code>dui_deep_purple</code> */
  CssClass dui_deep_purple = () -> "dui-deep-purple";
  /** Constant <code>dui_indigo</code> */
  CssClass dui_indigo = () -> "dui-indigo";
  /** Constant <code>dui_blue</code> */
  CssClass dui_blue = () -> "dui-blue";
  /** Constant <code>dui_light_blue</code> */
  CssClass dui_light_blue = () -> "dui-light-blue";
  /** Constant <code>dui_cyan</code> */
  CssClass dui_cyan = () -> "dui-cyan";
  /** Constant <code>dui_teal</code> */
  CssClass dui_teal = () -> "dui-teal";
  /** Constant <code>dui_green</code> */
  CssClass dui_green = () -> "dui-green";
  /** Constant <code>dui_light_green</code> */
  CssClass dui_light_green = () -> "dui-light-green";
  /** Constant <code>dui_lime</code> */
  CssClass dui_lime = () -> "dui-lime";
  /** Constant <code>dui_yellow</code> */
  CssClass dui_yellow = () -> "dui-yellow";
  /** Constant <code>dui_amber</code> */
  CssClass dui_amber = () -> "dui-amber";
  /** Constant <code>dui_orange</code> */
  CssClass dui_orange = () -> "dui-orange";
  /** Constant <code>dui_deep_orange</code> */
  CssClass dui_deep_orange = () -> "dui-deep-orange";
  /** Constant <code>dui_brown</code> */
  CssClass dui_brown = () -> "dui-brown";
  /** Constant <code>dui_grey</code> */
  CssClass dui_grey = () -> "dui-grey";
  /** Constant <code>dui_blue_grey</code> */
  CssClass dui_blue_grey = () -> "dui-blue-grey";
  /** Constant <code>dui_white</code> */
  CssClass dui_white = () -> "dui-white";
  /** Constant <code>dui_black</code> */
  CssClass dui_black = () -> "dui-black";
  /** Constant <code>dui_transparent</code> */
  CssClass dui_transparent = () -> "dui-transparent";

  /** Constant <code>dui_bg</code> */
  CssClass dui_bg = () -> "dui-bg";
  /** Constant <code>dui_bg_l_5</code> */
  CssClass dui_bg_l_5 = () -> "dui-bg-l-5";
  /** Constant <code>dui_bg_l_4</code> */
  CssClass dui_bg_l_4 = () -> "dui-bg-l-4";
  /** Constant <code>dui_bg_l_3</code> */
  CssClass dui_bg_l_3 = () -> "dui-bg-l-3";
  /** Constant <code>dui_bg_l_2</code> */
  CssClass dui_bg_l_2 = () -> "dui-bg-l-2";
  /** Constant <code>dui_bg_l_1</code> */
  CssClass dui_bg_l_1 = () -> "dui-bg-l-1";
  /** Constant <code>dui_bg_d_1</code> */
  CssClass dui_bg_d_1 = () -> "dui-bg-d-1";
  /** Constant <code>dui_bg_d_2</code> */
  CssClass dui_bg_d_2 = () -> "dui-bg-d-2";
  /** Constant <code>dui_bg_d_3</code> */
  CssClass dui_bg_d_3 = () -> "dui-bg-d-3";
  /** Constant <code>dui_bg_d_4</code> */
  CssClass dui_bg_d_4 = () -> "dui-bg-d-4";
  /** Constant <code>dui_fg</code> */
  CssClass dui_fg = () -> "dui-fg";
  /** Constant <code>dui_clickable</code> */
  CssClass dui_clickable = () -> "dui-clickable";
  /** Constant <code>dui_disabled</code> */
  CssClass dui_disabled = () -> "dui-disabled";
  /** Constant <code>dui_active</code> */
  CssClass dui_active = () -> "dui-active";
  /** Constant <code>dui_hide_empty</code> */
  CssClass dui_hide_empty = () -> "dui-hide-empty";
  /** Constant <code>dui_hover_disabled</code> */
  CssClass dui_hover_disabled = () -> "dui-hover-disabled";
  /** Constant <code>dui_transition_none</code> */
  CssClass dui_transition_none = () -> "dui-transition-none";
  /** Constant <code>dui_horizontal</code> */
  CssClass dui_horizontal =
      ReplaceCssClass.of(() -> "dui-vertical").replaceWith(() -> "dui-horizontal");
  /** Constant <code>dui_vertical</code> */
  CssClass dui_vertical =
      ReplaceCssClass.of(() -> "dui-horizontal").replaceWith(() -> "dui-vertical");
  /** Constant <code>dui_postfix_addon</code> */
  CssClass dui_postfix_addon = () -> "dui-postfix-addon";
  /** Constant <code>dui_subheader_addon</code> */
  CssClass dui_subheader_addon = () -> "dui-subheader-addon";
  /** Constant <code>dui_primary_addon</code> */
  CssClass dui_primary_addon = () -> "dui-primary-addon";
  /** Constant <code>dui_prefix_addon</code> */
  CssClass dui_prefix_addon = () -> "dui-prefix-addon";
  /** The css to add the stripes effect */
  CssClass dui_separator = () -> "dui-separator";

  /** Constant <code>dui_striped</code> */
  CssClass dui_striped = () -> "dui-striped";
  /** Constant <code>dui_xlarge</code> */
  CssClass dui_xlarge =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-lg", () -> "dui-md", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-xl");
  /** Constant <code>dui_large</code> */
  CssClass dui_large =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-md", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-lg");
  /** Constant <code>dui_medium</code> */
  CssClass dui_medium =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-md");
  /** Constant <code>dui_small</code> */
  CssClass dui_small =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-md", () -> "dui-xs"))
          .replaceWith(() -> "dui-sm");
  /** Constant <code>dui_xsmall</code> */
  CssClass dui_xsmall =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-md", () -> "dui-sm"))
          .replaceWith(() -> "dui-xs");

  /** Constant <code>dui_w_xlarge</code> */
  CssClass dui_w_xlarge = () -> "dui-w-xl";
  /** Constant <code>dui_w_large</code> */
  CssClass dui_w_large = () -> "dui-w-lg";
  /** Constant <code>dui_w_medium</code> */
  CssClass dui_w_medium = () -> "dui-w-md";
  /** Constant <code>dui_w_small</code> */
  CssClass dui_w_small = () -> "dui-w-sm";
  /** Constant <code>dui_w_xsmall</code> */
  CssClass dui_w_xsmall = () -> "dui-w-xs";

  /** Constant <code>dui_h_xlarge</code> */
  CssClass dui_h_xlarge = () -> "dui-h-xl";
  /** Constant <code>dui_h_large</code> */
  CssClass dui_h_large = () -> "dui-h-lg";
  /** Constant <code>dui_h_medium</code> */
  CssClass dui_h_medium = () -> "dui-h-md";
  /** Constant <code>dui_h_small</code> */
  CssClass dui_h_small = () -> "dui-h-sm";
  /** Constant <code>dui_h_xsmall</code> */
  CssClass dui_h_xsmall = () -> "dui-h-xs";

  /** Constant <code>dui_overlay</code> */
  CssClass dui_overlay = () -> "dui-overlay";
  /** Constant <code>dui_clearable</code> */
  CssClass dui_clearable = () -> "dui-clearable";
  /** Constant <code>dui_vertical_center</code> */
  CssClass dui_vertical_center = () -> "dui-vertical-center";
  /** Constant <code>dui_horizontal_center</code> */
  CssClass dui_horizontal_center = () -> "dui-horizontal-center";

  /** Constant <code>dui_left</code> */
  CssClass dui_left = () -> "dui-left";
  /** Constant <code>dui_right</code> */
  CssClass dui_right = () -> "dui-right";
  /** Constant <code>dui_center</code> */
  CssClass dui_center = () -> "dui-center";

  /** Constant <code>dui_close</code> */
  CssClass dui_close = () -> "dui-close";
  /** Constant <code>dui_close_char</code> */
  CssClass dui_close_char = () -> "dui-close-char";

  /** Constant <code>dui_selected</code> */
  CssClass dui_selected = () -> "dui-selected";

  /** Constant <code>dui_disable_text_select</code> */
  CssClass dui_disable_text_select = () -> "dui-disable-text-select";
}
