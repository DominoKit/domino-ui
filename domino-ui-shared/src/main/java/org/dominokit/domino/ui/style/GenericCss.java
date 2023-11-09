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

public interface GenericCss {

  CssClass dui = () -> "dui";

  CssClass dui_ignore_bg = () -> "dui-ignore-bg";

  CssClass dui_ignore_fg = () -> "dui-ignore-fg";

  CssClass dui_odd = ReplaceCssClass.of(() -> "dui-even").replaceWith(() -> "dui-odd");

  CssClass dui_even = ReplaceCssClass.of(() -> "dui-odd").replaceWith(() -> "dui-even");

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

  CssClass dui_red = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-red");

  CssClass dui_pink = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-pink");

  CssClass dui_purple = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-purple");

  CssClass dui_deep_purple = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-deep-purple");

  CssClass dui_indigo = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-indigo");

  CssClass dui_blue = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-blue");

  CssClass dui_light_blue = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-light-blue");

  CssClass dui_cyan = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-cyan");

  CssClass dui_teal = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-teal");

  CssClass dui_green = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-green");

  CssClass dui_light_green = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-light-green");

  CssClass dui_lime = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-lime");

  CssClass dui_yellow = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-yellow");

  CssClass dui_amber = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-amber");

  CssClass dui_orange = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-orange");

  CssClass dui_deep_orange = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-deep-orange");

  CssClass dui_brown = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-brown");

  CssClass dui_grey = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-grey");

  CssClass dui_blue_grey = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-blue-grey");

  CssClass dui_white = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-white");

  CssClass dui_black = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-black");

  CssClass dui_transparent = CompositeCssClass.of(() -> "dui-ctx", () -> "dui-transparent");

  CssClass dui_bg = () -> "dui-bg";

  CssClass dui_bg_l_5 = () -> "dui-bg-l-5";

  CssClass dui_bg_l_4 = () -> "dui-bg-l-4";

  CssClass dui_bg_l_3 = () -> "dui-bg-l-3";

  CssClass dui_bg_l_2 = () -> "dui-bg-l-2";

  CssClass dui_bg_l_1 = () -> "dui-bg-l-1";

  CssClass dui_bg_d_1 = () -> "dui-bg-d-1";

  CssClass dui_bg_d_2 = () -> "dui-bg-d-2";

  CssClass dui_bg_d_3 = () -> "dui-bg-d-3";

  CssClass dui_bg_d_4 = () -> "dui-bg-d-4";

  CssClass dui_fg = () -> "dui-fg";

  CssClass dui_clickable = () -> "dui-clickable";

  CssClass dui_disabled = () -> "dui-disabled";

  CssClass dui_active = () -> "dui-active";

  CssClass dui_hide_empty = () -> "dui-hide-empty";

  CssClass dui_hover_disabled = () -> "dui-hover-disabled";

  CssClass dui_transition_none = () -> "dui-transition-none";

  CssClass dui_horizontal =
      ReplaceCssClass.of(() -> "dui-vertical").replaceWith(() -> "dui-horizontal");

  CssClass dui_vertical =
      ReplaceCssClass.of(() -> "dui-horizontal").replaceWith(() -> "dui-vertical");

  CssClass dui_postfix_addon = () -> "dui-postfix-addon";

  CssClass dui_subheader_addon = () -> "dui-subheader-addon";

  CssClass dui_primary_addon = () -> "dui-primary-addon";

  CssClass dui_prefix_addon = () -> "dui-prefix-addon";

  CssClass dui_separator = () -> "dui-separator";

  CssClass dui_striped = () -> "dui-striped";

  CssClass dui_xlarge =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-lg", () -> "dui-md", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-xl");

  CssClass dui_large =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-md", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-lg");

  CssClass dui_medium =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-sm", () -> "dui-xs"))
          .replaceWith(() -> "dui-md");

  CssClass dui_small =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-md", () -> "dui-xs"))
          .replaceWith(() -> "dui-sm");

  CssClass dui_xsmall =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-xl", () -> "dui-lg", () -> "dui-md", () -> "dui-sm"))
          .replaceWith(() -> "dui-xs");

  CssClass dui_w_xlarge = () -> "dui-w-xl";

  CssClass dui_w_large = () -> "dui-w-lg";

  CssClass dui_w_medium = () -> "dui-w-md";

  CssClass dui_w_small = () -> "dui-w-sm";

  CssClass dui_w_xsmall = () -> "dui-w-xs";

  CssClass dui_h_xlarge = () -> "dui-h-xl";

  CssClass dui_h_large = () -> "dui-h-lg";

  CssClass dui_h_medium = () -> "dui-h-md";

  CssClass dui_h_small = () -> "dui-h-sm";

  CssClass dui_h_xsmall = () -> "dui-h-xs";

  CssClass dui_overlay = () -> "dui-overlay";

  CssClass dui_clearable = () -> "dui-clearable";

  CssClass dui_vertical_center = () -> "dui-vertical-center";

  CssClass dui_horizontal_center = () -> "dui-horizontal-center";

  CssClass dui_left = () -> "dui-left";

  CssClass dui_right = () -> "dui-right";

  CssClass dui_center = () -> "dui-center";

  CssClass dui_close = () -> "dui-close";

  CssClass dui_close_char = () -> "dui-close-char";

  CssClass dui_selected = () -> "dui-selected";

  CssClass dui_disable_text_select = () -> "dui-disable-text-select";
}
