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

/** WavesStyles interface. */
public interface WavesStyles {
  /** Constant <code>dui_waves_float</code> */
  CssClass dui_waves_float = () -> "dui-waves-float";
  /** Constant <code>dui_waves_circle</code> */
  CssClass dui_waves_circle = () -> "dui-waves-circle";
  /** Constant <code>dui_waves_ripple</code> */
  CssClass dui_waves_ripple = () -> "dui-waves-ripple";
  /** Constant <code>dui_waves_block</code> */
  CssClass dui_waves_block = () -> "dui-waves-block";

  CssClass dui_waves_primary =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-info",
                  () -> "dui-waves-warning",
                  () -> "dui-waves-error",
                  () -> "dui-waves-accent",
                  () -> "dui-waves-dominant",
                  () -> "dui-waves-secondary",
                  () -> "dui-waves-success"))
          /** Constant <code>dui_waves_primary</code> */
          .replaceWith(() -> "dui-waves-primary");
  CssClass dui_waves_secondary =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-info",
                  () -> "dui-waves-warning",
                  () -> "dui-waves-error",
                  () -> "dui-waves-accent",
                  () -> "dui-waves-dominant",
                  () -> "dui-waves-primary",
                  () -> "dui-waves-success"))
          /** Constant <code>dui_waves_secondary</code> */
          .replaceWith(() -> "dui-waves-secondary");
  CssClass dui_waves_dominant =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-info",
                  () -> "dui-waves-warning",
                  () -> "dui-waves-error",
                  () -> "dui-waves-accent",
                  () -> "dui-waves-secondary",
                  () -> "dui-waves-primary",
                  () -> "dui-waves-success"))
          /** Constant <code>dui_waves_dominant</code> */
          .replaceWith(() -> "dui-waves-dominant");
  CssClass dui_waves_accent =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-info",
                  () -> "dui-waves-warning",
                  () -> "dui-waves-error",
                  () -> "dui-waves-dominant",
                  () -> "dui-waves-secondary",
                  () -> "dui-waves-primary",
                  () -> "dui-waves-success"))
          /** Constant <code>dui_waves_accent</code> */
          .replaceWith(() -> "dui-waves-accent");
  CssClass dui_waves_success =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-info",
                  () -> "dui-waves-warning",
                  () -> "dui-waves-error",
                  () -> "dui-waves-accent",
                  () -> "dui-waves-dominant",
                  () -> "dui-waves-secondary",
                  () -> "dui-waves-primary"))
          /** Constant <code>dui_waves_success</code> */
          .replaceWith(() -> "dui-waves-success");
  CssClass dui_waves_info =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-success",
                  () -> "dui-waves-warning",
                  () -> "dui-waves-error",
                  () -> "dui-waves-accent",
                  () -> "dui-waves-dominant",
                  () -> "dui-waves-secondary",
                  () -> "dui-waves-primary"))
          /** Constant <code>dui_waves_info</code> */
          .replaceWith(() -> "dui-waves-info");
  CssClass dui_waves_warning =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-success",
                  () -> "dui-waves-info",
                  () -> "dui-waves-error",
                  () -> "dui-waves-accent",
                  () -> "dui-waves-dominant",
                  () -> "dui-waves-secondary",
                  () -> "dui-waves-primary"))
          /** Constant <code>dui_waves_warning</code> */
          .replaceWith(() -> "dui-waves-warning");
  CssClass dui_waves_error =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-waves-success",
                  () -> "dui-waves-info",
                  () -> "dui-waves-warning",
                  () -> "dui-waves-accent",
                  () -> "dui-waves-dominant",
                  () -> "dui-waves-secondary",
                  () -> "dui-waves-primary"))
          /** Constant <code>dui_waves_error</code> */
          .replaceWith(() -> "dui-waves-error");

  /** Constant <code>dui_waves_red</code> */
  CssClass dui_waves_red = () -> "dui-waves-red";
  /** Constant <code>dui_waves_pink</code> */
  CssClass dui_waves_pink = () -> "dui-waves-pink";
  /** Constant <code>dui_waves_purple</code> */
  CssClass dui_waves_purple = () -> "dui-waves-purple";
  /** Constant <code>dui_waves_deep_purple</code> */
  CssClass dui_waves_deep_purple = () -> "dui-waves-deep-purple";
  /** Constant <code>dui_waves_indigo</code> */
  CssClass dui_waves_indigo = () -> "dui-waves-indigo";
  /** Constant <code>dui_waves_blue</code> */
  CssClass dui_waves_blue = () -> "dui-waves-blue";
  /** Constant <code>dui_waves_light_blue</code> */
  CssClass dui_waves_light_blue = () -> "dui-waves-light-blue";
  /** Constant <code>dui_waves_cyan</code> */
  CssClass dui_waves_cyan = () -> "dui-waves-cyan";
  /** Constant <code>dui_waves_teal</code> */
  CssClass dui_waves_teal = () -> "dui-waves-teal";
  /** Constant <code>dui_waves_green</code> */
  CssClass dui_waves_green = () -> "dui-waves-green";
  /** Constant <code>dui_waves_light_green</code> */
  CssClass dui_waves_light_green = () -> "dui-waves-light-green";
  /** Constant <code>dui_waves_lime</code> */
  CssClass dui_waves_lime = () -> "dui-waves-lime";
  /** Constant <code>dui_waves_yellow</code> */
  CssClass dui_waves_yellow = () -> "dui-waves-yellow";
  /** Constant <code>dui_waves_amber</code> */
  CssClass dui_waves_amber = () -> "dui-waves-amber";
  /** Constant <code>dui_waves_orange</code> */
  CssClass dui_waves_orange = () -> "dui-waves-orange";
  /** Constant <code>dui_waves_deep_orange</code> */
  CssClass dui_waves_deep_orange = () -> "dui-waves-deep-orange";
  /** Constant <code>dui_waves_brown</code> */
  CssClass dui_waves_brown = () -> "dui-waves-brown";
  /** Constant <code>dui_waves_grey</code> */
  CssClass dui_waves_grey = () -> "dui-waves-grey";
  /** Constant <code>dui_waves_blue_grey</code> */
  CssClass dui_waves_blue_grey = () -> "dui-waves-blue-grey";
  /** Constant <code>dui_waves_white</code> */
  CssClass dui_waves_white = () -> "dui-waves-white";
  /** Constant <code>dui_waves_black</code> */
  CssClass dui_waves_black = () -> "dui-waves-black";
}
