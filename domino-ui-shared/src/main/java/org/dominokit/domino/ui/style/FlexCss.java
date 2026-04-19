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

/** CSS utilities for flex layout helpers. */
public interface FlexCss {

  CssClass dui_flex_basis_0 = () -> "dui-basis-0";

  CssClass dui_flex_basis_0_5 = () -> "dui-basis-0_5";

  CssClass dui_flex_basis_1 = () -> "dui-basis-1";

  CssClass dui_flex_basis_10 = () -> "dui-basis-10";

  CssClass dui_flex_basis_11 = () -> "dui-basis-11";

  CssClass dui_flex_basis_12 = () -> "dui-basis-12";

  CssClass dui_flex_basis_14 = () -> "dui-basis-14";

  CssClass dui_flex_basis_16 = () -> "dui-basis-16";

  CssClass dui_flex_basis_1_2p = () -> "dui-basis-1_2p";

  CssClass dui_flex_basis_1_3p = () -> "dui-basis-1_3p";

  CssClass dui_flex_basis_1_4p = () -> "dui-basis-1_4p";

  CssClass dui_flex_basis_1_5 = () -> "dui-basis-1_5";

  CssClass dui_flex_basis_2 = () -> "dui-basis-2";

  CssClass dui_flex_basis_20 = () -> "dui-basis-20";

  CssClass dui_flex_basis_24 = () -> "dui-basis-24";

  CssClass dui_flex_basis_28 = () -> "dui-basis-28";

  CssClass dui_flex_basis_2_3p = () -> "dui-basis-2_3p";

  CssClass dui_flex_basis_2_5 = () -> "dui-basis-2_5";

  CssClass dui_flex_basis_2px = () -> "dui-basis-2px";

  CssClass dui_flex_basis_3 = () -> "dui-basis-3";

  CssClass dui_flex_basis_32 = () -> "dui-basis-32";

  CssClass dui_flex_basis_36 = () -> "dui-basis-36";

  CssClass dui_flex_basis_3_4p = () -> "dui-basis-3_4p";

  CssClass dui_flex_basis_3_5 = () -> "dui-basis-3_5";

  CssClass dui_flex_basis_4 = () -> "dui-basis-4";

  CssClass dui_flex_basis_40 = () -> "dui-basis-40";

  CssClass dui_flex_basis_44 = () -> "dui-basis-44";

  CssClass dui_flex_basis_48 = () -> "dui-basis-48";

  CssClass dui_flex_basis_4px = () -> "dui-basis-4px";

  CssClass dui_flex_basis_5 = () -> "dui-basis-5";

  CssClass dui_flex_basis_52 = () -> "dui-basis-52";

  CssClass dui_flex_basis_56 = () -> "dui-basis-56";

  CssClass dui_flex_basis_6 = () -> "dui-basis-6";

  CssClass dui_flex_basis_60 = () -> "dui-basis-60";

  CssClass dui_flex_basis_64 = () -> "dui-basis-64";

  CssClass dui_flex_basis_7 = () -> "dui-basis-7";

  CssClass dui_flex_basis_72 = () -> "dui-basis-72";

  CssClass dui_flex_basis_8 = () -> "dui-basis-8";

  CssClass dui_flex_basis_80 = () -> "dui-basis-80";

  CssClass dui_flex_basis_8px = () -> "dui-basis-8px";

  CssClass dui_flex_basis_9 = () -> "dui-basis-9";

  CssClass dui_flex_basis_96 = () -> "dui-basis-96";

  CssClass dui_flex_basis_full = () -> "dui-basis-full";

  CssClass dui_flex_basis_px = () -> "dui-basis-px";

  CssClass dui_flex_row =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-flex-row-reverse", () -> "dui-flex-col", () -> "dui-flex-col-reverse"))
          .replaceWith(() -> "dui-flex-row");

  CssClass dui_flex_row_reverse =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-flex-row", () -> "dui-flex-col", () -> "dui-flex-col-reverse"))
          .replaceWith(() -> "dui-flex-row-reverse");

  CssClass dui_flex_col =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-flex-row", () -> "dui-flex-row-reverse", () -> "dui-flex-col-reverse"))
          .replaceWith(() -> "dui-flex-col");

  CssClass dui_flex_col_reverse =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  () -> "dui-flex-row", () -> "dui-flex-row-reverse", () -> "dui-flex-col"))
          .replaceWith(() -> "dui-flex-col-reverse");

  CssClass dui_flex_wrap =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-flex-wrap-reverse", () -> "dui-flex-nowrap"))
          .replaceWith(() -> "dui-flex-wrap");

  CssClass dui_flex_wrap_reverse =
      new ReplaceCssClass(CompositeCssClass.of(() -> "dui-flex-wrap", () -> "dui-flex-nowrap"))
          .replaceWith(() -> "dui-flex-wrap-reverse");

  CssClass dui_flex_nowrap =
      new ReplaceCssClass(
              CompositeCssClass.of(() -> "dui-flex-wrap", () -> "dui-flex-wrap-reverse"))
          .replaceWith(() -> "dui-flex-nowrap");

  CssClass dui_flex_1 = () -> "dui-flex-1";

  CssClass dui_flex_auto = () -> "dui-flex-auto";

  CssClass dui_flex_initial = () -> "dui-flex-initial";

  CssClass dui_flex_none = () -> "dui-flex-none";

  CssClass dui_grow_0 = () -> "dui-grow-0";

  CssClass dui_grow_1 = () -> "dui-grow-1";

  CssClass dui_grow_2 = () -> "dui-grow-2";

  CssClass dui_grow_3 = () -> "dui-grow-3";

  CssClass dui_grow_4 = () -> "dui-grow-4";

  CssClass dui_grow_5 = () -> "dui-grow-5";

  CssClass dui_grow_6 = () -> "dui-grow-6";

  CssClass dui_grow_7 = () -> "dui-grow-7";

  CssClass dui_grow_8 = () -> "dui-grow-8";

  CssClass dui_grow_9 = () -> "dui-grow-9";

  CssClass dui_grow_10 = () -> "dui-grow-10";

  CssClass dui_grow_11 = () -> "dui-grow-11";

  CssClass dui_grow_12 = () -> "dui-grow-12";

  CssClass dui_shrink_0 = () -> "dui-shrink-0";

  CssClass dui_shrink_1 = () -> "dui-shrink-1";

  CssClass dui_shrink_2 = () -> "dui-shrink-2";

  CssClass dui_shrink_3 = () -> "dui-shrink-3";

  CssClass dui_shrink_4 = () -> "dui-shrink-4";

  CssClass dui_shrink_5 = () -> "dui-shrink-5";

  CssClass dui_shrink_6 = () -> "dui-shrink-6";

  CssClass dui_shrink_7 = () -> "dui-shrink-7";

  CssClass dui_shrink_8 = () -> "dui-shrink-8";

  CssClass dui_shrink_9 = () -> "dui-shrink-9";

  CssClass dui_shrink_10 = () -> "dui-shrink-10";

  CssClass dui_shrink_11 = () -> "dui-shrink-11";

  CssClass dui_shrink_12 = () -> "dui-shrink-12";

  CssClass dui_order_1 = () -> "dui-order-1";

  CssClass dui_order_2 = () -> "dui-order-2";

  CssClass dui_order_3 = () -> "dui-order-3";

  CssClass dui_order_4 = () -> "dui-order-4";

  CssClass dui_order_5 = () -> "dui-order-5";

  CssClass dui_order_6 = () -> "dui-order-6";

  CssClass dui_order_7 = () -> "dui-order-7";

  CssClass dui_order_8 = () -> "dui-order-8";

  CssClass dui_order_9 = () -> "dui-order-9";

  CssClass dui_order_10 = () -> "dui-order-10";

  CssClass dui_order_20 = () -> "dui-order-20";

  CssClass dui_order_30 = () -> "dui-order-30";

  CssClass dui_order_40 = () -> "dui-order-40";

  CssClass dui_order_50 = () -> "dui-order-50";

  CssClass dui_order_60 = () -> "dui-order-60";

  CssClass dui_order_70 = () -> "dui-order-70";

  CssClass dui_order_80 = () -> "dui-order-80";

  CssClass dui_order_90 = () -> "dui-order-90";

  CssClass dui_order_100 = () -> "dui-order-100";

  CssClass dui_order_first = () -> "dui-order-first";

  CssClass dui_order_first_1 = () -> "dui-order-first-1";

  CssClass dui_order_first_2 = () -> "dui-order-first-2";

  CssClass dui_order_first_3 = () -> "dui-order-first-3";

  CssClass dui_order_first_4 = () -> "dui-order-first-4";

  CssClass dui_order_last = () -> "dui-order-last";

  CssClass dui_order_last_1 = () -> "dui-order-last-1";

  CssClass dui_order_last_2 = () -> "dui-order-last-2";

  CssClass dui_order_last_3 = () -> "dui-order-last-3";

  CssClass dui_order_last_4 = () -> "dui-order-last-4";

  CssClass dui_order_none = () -> "dui-order-none";

  CssClass dui_justify_start = () -> "dui-justify-start";

  CssClass dui_justify_end = () -> "dui-justify-end";

  CssClass dui_justify_center = () -> "dui-justify-center";

  CssClass dui_justify_between = () -> "dui-justify-between";

  CssClass dui_justify_around = () -> "dui-justify-around";

  CssClass dui_justify_evenly = () -> "dui-justify-evenly";

  CssClass dui_justify_items_start = () -> "dui-justify-items-start";

  CssClass dui_justify_items_end = () -> "dui-justify-items-end";

  CssClass dui_justify_items_center = () -> "dui-justify-items-center";

  CssClass dui_justify_items_stretch = () -> "dui-justify-items-stretch";

  CssClass dui_justify_self_auto = () -> "dui-justify-self-auto";

  CssClass dui_justify_self_start = () -> "dui-justify-self-start";

  CssClass dui_justify_self_end = () -> "dui-justify-self-end";

  CssClass dui_justify_self_center = () -> "dui-justify-self-center";

  CssClass dui_justify_self_stretch = () -> "dui-justify-self-stretch";

  CssClass dui_content_center = () -> "dui-content-center";

  CssClass dui_content_start = () -> "dui-content-start";

  CssClass dui_content_end = () -> "dui-content-end";

  CssClass dui_content_between = () -> "dui-content-between";

  CssClass dui_content_around = () -> "dui-content-around";

  CssClass dui_content_evenly = () -> "dui-content-evenly";

  CssClass dui_items_start = () -> "dui-items-start";

  CssClass dui_items_end = () -> "dui-items-end";

  CssClass dui_items_center = () -> "dui-items-center";

  CssClass dui_items_baseline = () -> "dui-items-baseline";

  CssClass dui_items_stretch = () -> "dui-items-stretch";

  CssClass dui_self_auto = () -> "dui-self-auto";

  CssClass dui_self_start = () -> "dui-self-start";

  CssClass dui_self_end = () -> "dui-self-end";

  CssClass dui_self_center = () -> "dui-self-center";

  CssClass dui_self_stretch = () -> "dui-self-stretch";

  CssClass dui_self_baseline = () -> "dui-self-baseline";

  CssClass dui_place_content_center = () -> "dui-place-content-center";

  CssClass dui_place_content_start = () -> "dui-place-content-start";

  CssClass dui_place_content_end = () -> "dui-place-content-end";

  CssClass dui_place_content_between = () -> "dui-place-content-between";

  CssClass dui_place_content_around = () -> "dui-place-content-around";

  CssClass dui_place_content_evenly = () -> "dui-place-content-evenly";

  CssClass dui_place_content_stretch = () -> "dui-place-content-stretch";

  CssClass dui_place_items_start = () -> "dui-place-items-start";

  CssClass dui_place_items_end = () -> "dui-place-items-end";

  CssClass dui_place_items_center = () -> "dui-place-items-center";

  CssClass dui_place_items_stretch = () -> "dui-place-items-stretch";

  CssClass dui_place_self_auto = () -> "dui-place-self-auto";

  CssClass dui_place_self_start = () -> "dui-place-self-start";

  CssClass dui_place_self_end = () -> "dui-place-self-end";

  CssClass dui_place_self_center = () -> "dui-place-self-center";

  CssClass dui_place_self_stretch = () -> "dui-place-self-stretch";
}
