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
  CssClass dui_primary = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-info",
          ()->"dui-warning",
          ()->"dui-error",
          ()->"dui-accent",
          ()->"dui-dominant",
          ()->"dui-secondary",
          ()->"dui-success"
  )).replaceWith(()->"dui-primary");
  CssClass dui_secondary = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-info",
          ()->"dui-warning",
          ()->"dui-error",
          ()->"dui-accent",
          ()->"dui-dominant",
          ()->"dui-primary",
          ()->"dui-success"
  )).replaceWith(()->"dui-secondary");
  CssClass dui_dominant = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-info",
          ()->"dui-warning",
          ()->"dui-error",
          ()->"dui-accent",
          ()->"dui-secondary",
          ()->"dui-primary",
          ()->"dui-success"
  )).replaceWith(()->"dui-dominant");
  CssClass dui_accent = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-info",
          ()->"dui-warning",
          ()->"dui-error",
          ()->"dui-dominant",
          ()->"dui-secondary",
          ()->"dui-primary",
          ()->"dui-success"
  )).replaceWith(()->"dui-accent");
  CssClass dui_success = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-info",
          ()->"dui-warning",
          ()->"dui-error",
          ()->"dui-accent",
          ()->"dui-dominant",
          ()->"dui-secondary",
          ()->"dui-primary"
  )).replaceWith(()->"dui-success");
  CssClass dui_info = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-success",
          ()->"dui-warning",
          ()->"dui-error",
          ()->"dui-accent",
          ()->"dui-dominant",
          ()->"dui-secondary",
          ()->"dui-primary"
  )).replaceWith(()->"dui-info");
  CssClass dui_warning = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-success",
          ()->"dui-info",
          ()->"dui-error",
          ()->"dui-accent",
          ()->"dui-dominant",
          ()->"dui-secondary",
          ()->"dui-primary"
  )).replaceWith(()->"dui-warning");
  CssClass dui_error = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-success",
          ()->"dui-info",
          ()->"dui-warning",
          ()->"dui-accent",
          ()->"dui-dominant",
          ()->"dui-secondary",
          ()->"dui-primary"
  )).replaceWith(()->"dui-error");
  CssClass dui_clickable = () -> "dui-clickable";
  CssClass dui_disabled = ()-> "dui-disabled";
  CssClass dui_active = () -> "dui-active";
  CssClass dui_transition_none = () -> "dui-transition-none";
  CssClass dui_horizontal = () -> "dui-horizontal";
  CssClass dui_vertical = () -> "dui-vertical";
  CssClass dui_postfix = () -> "dui-postfix-addon";
  CssClass dui_prefix = () -> "dui-prefix-addon";
  /** The css to add the stripes effect */
  CssClass dui_separator = () -> "dui-separator";
  CssClass dui_striped = ()->"dui-striped";
  CssClass dui_xlarge = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-lg",
          ()->"dui-md",
          ()->"dui-sm",
          ()->"dui-xs"
  )).replaceWith(()->"dui-xl");
  CssClass dui_large = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-xl",
          ()->"dui-md",
          ()->"dui-sm",
          ()->"dui-xs"
  )).replaceWith(()->"dui-lg");
  CssClass dui_medium = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-xl",
          ()->"dui-lg",
          ()->"dui-sm",
          ()->"dui-xs"
  )).replaceWith(()->"dui-md");
  CssClass dui_small = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-xl",
          ()->"dui-lg",
          ()->"dui-md",
          ()->"dui-xs"
  )).replaceWith(()->"dui-sm");
  CssClass dui_xsmall = new ReplaceCssClass(CompositeCssClass.of(
          ()->"dui-xl",
          ()->"dui-lg",
          ()->"dui-md",
          ()->"dui-sm"
  )).replaceWith(()->"dui-xs");

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

  CssClass dui_close = () -> "dui-close";

  CssClass dui_selected = () -> "dui-selected";

  CssClass dui_disable_text_select = ()->"dui-disable-text-select";
}
