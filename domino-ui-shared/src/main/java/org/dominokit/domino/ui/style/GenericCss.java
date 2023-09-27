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

/** @hidden GenericCss interface. */
public interface GenericCss {
  /** @hidden Constant <code>dui</code> */
  CssClass dui = () -> "dui";

  /** @hidden Constant <code>dui_ignore_bg</code> */
  CssClass dui_ignore_bg = () -> "dui-ignore-bg";
  /** @hidden Constant <code>dui_ignore_fg</code> */
  CssClass dui_ignore_fg = () -> "dui-ignore-fg";

  /** @hidden Constant <code>dui_odd</code> */
  CssClass dui_odd = ReplaceCssClass.of(() -> "dui-even").replaceWith(() -> "dui-odd");
  /** @hidden Constant <code>dui_even</code> */
  CssClass dui_even = ReplaceCssClass.of(() -> "dui-odd").replaceWith(() -> "dui-even");
  /** @hidden Constant <code>dui_primary</code> */
  CssClass dui_primary =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-success"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-primary"));
  /** @hidden Constant <code>dui_secondary</code> */
  CssClass dui_secondary =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-primary",
                  () -> "dui-success"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-secondary"));
  /** @hidden Constant <code>dui_dominant</code> */
  CssClass dui_dominant =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-secondary",
                  () -> "dui-primary",
                  () -> "dui-success"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-dominant"));
  /** @hidden Constant <code>dui_accent</code> */
  CssClass dui_accent =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary",
                  () -> "dui-success"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-accent"));
  /** @hidden Constant <code>dui_success</code> */
  CssClass dui_success =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-success"));
  /** @hidden Constant <code>dui_info</code> */
  CssClass dui_info =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-success",
                  () -> "dui-warning",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-info"));
  /** @hidden Constant <code>dui_warning</code> */
  CssClass dui_warning =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-success",
                  () -> "dui-info",
                  () -> "dui-error",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-warning"));
  /** @hidden Constant <code>dui_error</code> */
  CssClass dui_error =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-ctx",
                  () -> "dui-success",
                  () -> "dui-info",
                  () -> "dui-warning",
                  () -> "dui-accent",
                  () -> "dui-dominant",
                  () -> "dui-secondary",
                  () -> "dui-primary"))
          .replaceWith(CompositeCssClass.of(() -> "dui-ctx", () -> "dui-error"));

  /** @hidden Constant <code>dui_red</code> */
  CssClass dui_red = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-red");
  /** @hidden Constant <code>dui_pink</code> */
  CssClass dui_pink = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-pink");
  /** @hidden Constant <code>dui_purple</code> */
  CssClass dui_purple = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-purple");
  /** @hidden Constant <code>dui_deep_purple</code> */
  CssClass dui_deep_purple = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-deep-purple");
  /** @hidden Constant <code>dui_indigo</code> */
  CssClass dui_indigo = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-indigo");
  /** @hidden Constant <code>dui_blue</code> */
  CssClass dui_blue = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-blue");
  /** @hidden Constant <code>dui_light_blue</code> */
  CssClass dui_light_blue = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-light-blue");
  /** @hidden Constant <code>dui_cyan</code> */
  CssClass dui_cyan = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-cyan");
  /** @hidden Constant <code>dui_teal</code> */
  CssClass dui_teal = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-teal");
  /** @hidden Constant <code>dui_green</code> */
  CssClass dui_green = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-green");
  /** @hidden Constant <code>dui_light_green</code> */
  CssClass dui_light_green = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-light-green");
  /** @hidden Constant <code>dui_lime</code> */
  CssClass dui_lime = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-lime");
  /** @hidden Constant <code>dui_yellow</code> */
  CssClass dui_yellow = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-yellow");
  /** @hidden Constant <code>dui_amber</code> */
  CssClass dui_amber = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-amber");
  /** @hidden Constant <code>dui_orange</code> */
  CssClass dui_orange = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-orange");
  /** @hidden Constant <code>dui_deep_orange</code> */
  CssClass dui_deep_orange = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-deep-orange");
  /** @hidden Constant <code>dui_brown</code> */
  CssClass dui_brown = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-brown");
  /** @hidden Constant <code>dui_grey</code> */
  CssClass dui_grey = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-grey");
  /** @hidden Constant <code>dui_blue_grey</code> */
  CssClass dui_blue_grey = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-blue-grey");
  /** @hidden Constant <code>dui_white</code> */
  CssClass dui_white = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-white");
  /** @hidden Constant <code>dui_black</code> */
  CssClass dui_black = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-black");
  /** @hidden Constant <code>dui_transparent</code> */
  CssClass dui_transparent = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-transparent");

  /** @hidden Constant <code>dui_bg</code> */
  CssClass dui_bg = () -> "dui-bg";
  /** @hidden Constant <code>dui_bg_l_5</code> */
  CssClass dui_bg_l_5 = () -> "dui-bg-l-5";
  /** @hidden Constant <code>dui_bg_l_4</code> */
  CssClass dui_bg_l_4 = () -> "dui-bg-l-4";
  /** @hidden Constant <code>dui_bg_l_3</code> */
  CssClass dui_bg_l_3 = () -> "dui-bg-l-3";
  /** @hidden Constant <code>dui_bg_l_2</code> */
  CssClass dui_bg_l_2 = () -> "dui-bg-l-2";
  /** @hidden Constant <code>dui_bg_l_1</code> */
  CssClass dui_bg_l_1 = () -> "dui-bg-l-1";
  /** @hidden Constant <code>dui_bg_d_1</code> */
  CssClass dui_bg_d_1 = () -> "dui-bg-d-1";
  /** @hidden Constant <code>dui_bg_d_2</code> */
  CssClass dui_bg_d_2 = () -> "dui-bg-d-2";
  /** @hidden Constant <code>dui_bg_d_3</code> */
  CssClass dui_bg_d_3 = () -> "dui-bg-d-3";
  /** @hidden Constant <code>dui_bg_d_4</code> */
  CssClass dui_bg_d_4 = () -> "dui-bg-d-4";
  /** @hidden Constant <code>dui_fg</code> */
  CssClass dui_fg = () -> "dui-fg";
  /** @hidden Constant <code>dui_clickable</code> */
  CssClass dui_clickable = () -> "dui-clickable";
  /** @hidden Constant <code>dui_disabled</code> */
  CssClass dui_disabled = () -> "dui-disabled";
  /** @hidden Constant <code>dui_active</code> */
  CssClass dui_active = () -> "dui-active";
  /** @hidden Constant <code>dui_hide_empty</code> */
  CssClass dui_hide_empty = () -> "dui-hide-empty";
  /** @hidden Constant <code>dui_hover_disabled</code> */
  CssClass dui_hover_disabled = () -> "dui-hover-disabled";
  /** @hidden Constant <code>dui_transition_none</code> */
  CssClass dui_transition_none = () -> "dui-transition-none";
  /** @hidden Constant <code>dui_horizontal</code> */
  CssClass dui_horizontal =
      ReplaceCssClass.of(() -> "dui-vertical").replaceWith(() -> "dui-horizontal");
  /** @hidden Constant <code>dui_vertical</code> */
  CssClass dui_vertical =
      ReplaceCssClass.of(() -> "dui-horizontal").replaceWith(() -> "dui-vertical");
  /** @hidden Constant <code>dui_postfix_addon</code> */
  CssClass dui_postfix_addon = () -> "dui-postfix-addon";
  /** @hidden Constant <code>dui_subheader_addon</code> */
  CssClass dui_subheader_addon = () -> "dui-subheader-addon";
  /** @hidden Constant <code>dui_primary_addon</code> */
  CssClass dui_primary_addon = () -> "dui-primary-addon";
  /** @hidden Constant <code>dui_prefix_addon</code> */
  CssClass dui_prefix_addon = () -> "dui-prefix-addon";
  /** @hidden The css to add the stripes effect */
  CssClass dui_separator = () -> "dui-separator";

  /** @hidden Constant <code>dui_striped</code> */
  CssClass dui_striped = () -> "dui-striped";
  /** @hidden Constant <code>dui_xlarge</code> */
  CssClass dui_xlarge =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-lg", () -> "dui-md", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-xl");
  /** @hidden Constant <code>dui_large</code> */
  CssClass dui_large =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-md", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-lg");
  /** @hidden Constant <code>dui_medium</code> */
  CssClass dui_medium =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-md");
  /** @hidden Constant <code>dui_small</code> */
  CssClass dui_small =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-md", () -> "dui-xs"))
          .replaceWith(() -> "dui-sm");
  /** @hidden Constant <code>dui_xsmall</code> */
  CssClass dui_xsmall =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-md", () -> "dui-sm"))
          .replaceWith(() -> "dui-xs");

  /** @hidden Constant <code>dui_w_xlarge</code> */
  CssClass dui_w_xlarge = () -> "dui-w-xl";
  /** @hidden Constant <code>dui_w_large</code> */
  CssClass dui_w_large = () -> "dui-w-lg";
  /** @hidden Constant <code>dui_w_medium</code> */
  CssClass dui_w_medium = () -> "dui-w-md";
  /** @hidden Constant <code>dui_w_small</code> */
  CssClass dui_w_small = () -> "dui-w-sm";
  /** @hidden Constant <code>dui_w_xsmall</code> */
  CssClass dui_w_xsmall = () -> "dui-w-xs";

  /** @hidden Constant <code>dui_h_xlarge</code> */
  CssClass dui_h_xlarge = () -> "dui-h-xl";
  /** @hidden Constant <code>dui_h_large</code> */
  CssClass dui_h_large = () -> "dui-h-lg";
  /** @hidden Constant <code>dui_h_medium</code> */
  CssClass dui_h_medium = () -> "dui-h-md";
  /** @hidden Constant <code>dui_h_small</code> */
  CssClass dui_h_small = () -> "dui-h-sm";
  /** @hidden Constant <code>dui_h_xsmall</code> */
  CssClass dui_h_xsmall = () -> "dui-h-xs";

  /** @hidden Constant <code>dui_overlay</code> */
  CssClass dui_overlay = () -> "dui-overlay";
  /** @hidden Constant <code>dui_clearable</code> */
  CssClass dui_clearable = () -> "dui-clearable";
  /** @hidden Constant <code>dui_vertical_center</code> */
  CssClass dui_vertical_center = () -> "dui-vertical-center";
  /** @hidden Constant <code>dui_horizontal_center</code> */
  CssClass dui_horizontal_center = () -> "dui-horizontal-center";

  /** @hidden Constant <code>dui_left</code> */
  CssClass dui_left = () -> "dui-left";
  /** @hidden Constant <code>dui_right</code> */
  CssClass dui_right = () -> "dui-right";
  /** @hidden Constant <code>dui_center</code> */
  CssClass dui_center = () -> "dui-center";

  /** @hidden Constant <code>dui_close</code> */
  CssClass dui_close = () -> "dui-close";
  /** @hidden Constant <code>dui_close_char</code> */
  CssClass dui_close_char = () -> "dui-close-char";

  /** @hidden Constant <code>dui_selected</code> */
  CssClass dui_selected = () -> "dui-selected";

  /** @hidden Constant <code>dui_disable_text_select</code> */
  CssClass dui_disable_text_select = () -> "dui-disable-text-select";
}
