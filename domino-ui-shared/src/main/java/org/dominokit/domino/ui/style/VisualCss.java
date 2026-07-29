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

/** CSS utilities for background, border, and outline helpers. */
public interface VisualCss {

  CssClass dui_content_none = () -> "dui-content-none";

  CssClass dui_bg_fixed = () -> "dui-bg-fixed";

  CssClass dui_bg_local = () -> "dui-bg-local";

  CssClass dui_bg_scroll = () -> "dui-bg-scroll";

  CssClass dui_bg_clip_border = () -> "dui-bg-clip-border";

  CssClass dui_bg_clip_padding = () -> "dui-bg-clip-padding";

  CssClass dui_bg_clip_content = () -> "dui-bg-clip-content";

  CssClass dui_bg_clip_text = () -> "dui-bg-clip-text";

  CssClass dui_bg_origin_border = () -> "dui-bg-origin-border";

  CssClass dui_bg_origin_padding = () -> "dui-bg-origin-padding";

  CssClass dui_bg_origin_content = () -> "dui-bg-origin-content";

  CssClass dui_bg_bottom = () -> "dui-bg-bottom";

  CssClass dui_bg_center = () -> "dui-bg-center";

  CssClass dui_bg_left = () -> "dui-bg-left";

  CssClass dui_bg_left_bottom = () -> "dui-bg-left-bottom";

  CssClass dui_bg_left_top = () -> "dui-bg-left-top";

  CssClass dui_bg_right = () -> "dui-bg-right";

  CssClass dui_bg_right_bottom = () -> "dui-bg-right-bottom";

  CssClass dui_bg_right_top = () -> "dui-bg-right-top";

  CssClass dui_bg_top = () -> "dui-bg-top";

  CssClass dui_bg_repeat = () -> "dui-bg-repeat";

  CssClass dui_bg_no_repeat = () -> "dui-bg-no-repeat";

  CssClass dui_bg_repeat_x = () -> "dui-bg-repeat-x";

  CssClass dui_bg_repeat_y = () -> "dui-bg-repeat-y";

  CssClass dui_bg_repeat_round = () -> "dui-bg-repeat-round";

  CssClass dui_bg_repeat_space = () -> "dui-bg-repeat-space";

  CssClass dui_bg_auto = () -> "dui-bg-auto";

  CssClass dui_bg_cover = () -> "dui-bg-cover";

  CssClass dui_bg_contain = () -> "dui-bg-contain";

  CssClass dui_rounded_none = () -> "dui-rounded-none";

  CssClass dui_rounded_inherit = () -> "dui-rounded-inherit";

  CssClass dui_rounded_t_inherit = () -> "dui-rounded-t-inherit";

  CssClass dui_rounded_b_inherit = () -> "dui-rounded-b-inherit";

  CssClass dui_rounded_l_inherit = () -> "dui-rounded-l-inherit";

  CssClass dui_rounded_r_inherit = () -> "dui-rounded-r-inherit";

  CssClass dui_rounded_tl_inherit = () -> "dui-rounded-tl-inherit";

  CssClass dui_rounded_tr_inherit = () -> "dui-rounded-tr-inherit";

  CssClass dui_rounded_br_inherit = () -> "dui-rounded-br-inherit";

  CssClass dui_rounded_bl_inherit = () -> "dui-rounded-bl-inherit";

  CssClass dui_rounded_sm = () -> "dui-rounded-sm";

  CssClass dui_rounded = () -> "dui-rounded";

  CssClass dui_rounded_md = () -> "dui-rounded-md";

  CssClass dui_rounded_lg = () -> "dui-rounded-lg";

  CssClass dui_rounded_xl = () -> "dui-rounded-xl";

  CssClass dui_rounded_2xl = () -> "dui-rounded-2xl";

  CssClass dui_rounded_3xl = () -> "dui-rounded-3xl";

  CssClass dui_rounded_full = () -> "dui-rounded-full";

  CssClass dui_rounded_circle = () -> "dui-rounded-circle";

  CssClass dui_rounded_t_none = () -> "dui-rounded-t-none";

  CssClass dui_rounded_t_sm = () -> "dui-rounded-t-sm";

  CssClass dui_rounded_t = () -> "dui-rounded-t";

  CssClass dui_rounded_t_md = () -> "dui-rounded-t-md";

  CssClass dui_rounded_t_lg = () -> "dui-rounded-t-lg";

  CssClass dui_rounded_t_xl = () -> "dui-rounded-t-xl";

  CssClass dui_rounded_t_2xl = () -> "dui-rounded-t-2xl";

  CssClass dui_rounded_t_3xl = () -> "dui-rounded-t-3xl";

  CssClass dui_rounded_t_full = () -> "dui-rounded-t-full";

  CssClass dui_rounded_r_none = () -> "dui-rounded-r-none";

  CssClass dui_rounded_r_sm = () -> "dui-rounded-r-sm";

  CssClass dui_rounded_r = () -> "dui-rounded-r";

  CssClass dui_rounded_r_md = () -> "dui-rounded-r-md";

  CssClass dui_rounded_r_lg = () -> "dui-rounded-r-lg";

  CssClass dui_rounded_r_xl = () -> "dui-rounded-r-xl";

  CssClass dui_rounded_r_2xl = () -> "dui-rounded-r-2xl";

  CssClass dui_rounded_r_3xl = () -> "dui-rounded-r-3xl";

  CssClass dui_rounded_r_full = () -> "dui-rounded-r-full";

  CssClass dui_rounded_b_none = () -> "dui-rounded-b-none";

  CssClass dui_rounded_b_sm = () -> "dui-rounded-b-sm";

  CssClass dui_rounded_b = () -> "dui-rounded-b";

  CssClass dui_rounded_b_md = () -> "dui-rounded-b-md";

  CssClass dui_rounded_b_lg = () -> "dui-rounded-b-lg";

  CssClass dui_rounded_b_xl = () -> "dui-rounded-b-xl";

  CssClass dui_rounded_b_2xl = () -> "dui-rounded-b-2xl";

  CssClass dui_rounded_b_3xl = () -> "dui-rounded-b-3xl";

  CssClass dui_rounded_b_full = () -> "dui-rounded-b-full";

  CssClass dui_rounded_l_none = () -> "dui-rounded-l-none";

  CssClass dui_rounded_l_sm = () -> "dui-rounded-l-sm";

  CssClass dui_rounded_l = () -> "dui-rounded-l";

  CssClass dui_rounded_l_md = () -> "dui-rounded-l-md";

  CssClass dui_rounded_l_lg = () -> "dui-rounded-l-lg";

  CssClass dui_rounded_l_xl = () -> "dui-rounded-l-xl";

  CssClass dui_rounded_l_2xl = () -> "dui-rounded-l-2xl";

  CssClass dui_rounded_l_3xl = () -> "dui-rounded-l-3xl";

  CssClass dui_rounded_l_full = () -> "dui-rounded-l-full";

  CssClass dui_rounded_tl_none = () -> "dui-rounded-tl-none";

  CssClass dui_rounded_tl_sm = () -> "dui-rounded-tl-sm";

  CssClass dui_rounded_tl = () -> "dui-rounded-tl";

  CssClass dui_rounded_tl_md = () -> "dui-rounded-tl-md";

  CssClass dui_rounded_tl_lg = () -> "dui-rounded-tl-lg";

  CssClass dui_rounded_tl_xl = () -> "dui-rounded-tl-xl";

  CssClass dui_rounded_tl_2xl = () -> "dui-rounded-tl-2xl";

  CssClass dui_rounded_tl_3xl = () -> "dui-rounded-tl-3xl";

  CssClass dui_rounded_tl_full = () -> "dui-rounded-tl-full";

  CssClass dui_rounded_tr_none = () -> "dui-rounded-tr-none";

  CssClass dui_rounded_tr_sm = () -> "dui-rounded-tr-sm";

  CssClass dui_rounded_tr = () -> "dui-rounded-tr";

  CssClass dui_rounded_tr_md = () -> "dui-rounded-tr-md";

  CssClass dui_rounded_tr_lg = () -> "dui-rounded-tr-lg";

  CssClass dui_rounded_tr_xl = () -> "dui-rounded-tr-xl";

  CssClass dui_rounded_tr_2xl = () -> "dui-rounded-tr-2xl";

  CssClass dui_rounded_tr_3xl = () -> "dui-rounded-tr-3xl";

  CssClass dui_rounded_tr_full = () -> "dui-rounded-tr-full";

  CssClass dui_rounded_br_none = () -> "dui-rounded-br-none";

  CssClass dui_rounded_br_sm = () -> "dui-rounded-br-sm";

  CssClass dui_rounded_br = () -> "dui-rounded-br";

  CssClass dui_rounded_br_md = () -> "dui-rounded-br-md";

  CssClass dui_rounded_br_lg = () -> "dui-rounded-br-lg";

  CssClass dui_rounded_br_xl = () -> "dui-rounded-br-xl";

  CssClass dui_rounded_br_2xl = () -> "dui-rounded-br-2xl";

  CssClass dui_rounded_br_3xl = () -> "dui-rounded-br-3xl";

  CssClass dui_rounded_br_full = () -> "dui-rounded-br-full";

  CssClass dui_rounded_bl_none = () -> "dui-rounded-bl-none";

  CssClass dui_rounded_bl_sm = () -> "dui-rounded-bl-sm";

  CssClass dui_rounded_bl = () -> "dui-rounded-bl";

  CssClass dui_rounded_bl_md = () -> "dui-rounded-bl-md";

  CssClass dui_rounded_bl_lg = () -> "dui-rounded-bl-lg";

  CssClass dui_rounded_bl_xl = () -> "dui-rounded-bl-xl";

  CssClass dui_rounded_bl_2xl = () -> "dui-rounded-bl-2xl";

  CssClass dui_rounded_bl_3xl = () -> "dui-rounded-bl-3xl";

  CssClass dui_rounded_bl_full = () -> "dui-rounded-bl-full";

  CssClass dui_border_0 = () -> "dui-border-0";

  CssClass dui_border = () -> "dui-border";

  CssClass dui_border_2px = () -> "dui-border-2px";

  CssClass dui_border_4px = () -> "dui-border-4px";

  CssClass dui_border_8px = () -> "dui-border-8px";

  CssClass dui_border_9999px = () -> "dui-border-9999px";

  CssClass dui_border_0_5 = () -> "dui-border-0_5";

  CssClass dui_border_1 = () -> "dui-border-1";

  CssClass dui_border_1_5 = () -> "dui-border-1_5";

  CssClass dui_border_2 = () -> "dui-border-2";

  CssClass dui_border_2_5 = () -> "dui-border-2_5";

  CssClass dui_border_3 = () -> "dui-border-3";

  CssClass dui_border_3_5 = () -> "dui-border-3_5";

  CssClass dui_border_4 = () -> "dui-border-4";

  CssClass dui_border_5 = () -> "dui-border-5";

  CssClass dui_border_6 = () -> "dui-border-6";

  CssClass dui_border_7 = () -> "dui-border-7";

  CssClass dui_border_8 = () -> "dui-border-8";

  CssClass dui_border_9 = () -> "dui-border-9";

  CssClass dui_border_10 = () -> "dui-border-10";

  CssClass dui_border_11 = () -> "dui-border-11";

  CssClass dui_border_12 = () -> "dui-border-12";

  CssClass dui_border_14 = () -> "dui-border-14";

  CssClass dui_border_16 = () -> "dui-border-16";

  CssClass dui_border_20 = () -> "dui-border-20";

  CssClass dui_border_24 = () -> "dui-border-24";

  CssClass dui_border_28 = () -> "dui-border-28";

  CssClass dui_border_32 = () -> "dui-border-32";

  CssClass dui_border_36 = () -> "dui-border-36";

  CssClass dui_border_40 = () -> "dui-border-40";

  CssClass dui_border_44 = () -> "dui-border-44";

  CssClass dui_border_48 = () -> "dui-border-48";

  CssClass dui_border_52 = () -> "dui-border-52";

  CssClass dui_border_56 = () -> "dui-border-56";

  CssClass dui_border_60 = () -> "dui-border-60";

  CssClass dui_border_64 = () -> "dui-border-64";

  CssClass dui_border_72 = () -> "dui-border-72";

  CssClass dui_border_80 = () -> "dui-border-80";

  CssClass dui_border_96 = () -> "dui-border-96";

  CssClass dui_border_x_0 = () -> "dui-border-x-0";

  CssClass dui_border_x = () -> "dui-border-x";

  CssClass dui_border_x_2px = () -> "dui-border-x-2px";

  CssClass dui_border_x_4px = () -> "dui-border-x-4px";

  CssClass dui_border_x_8px = () -> "dui-border-x-8px";

  CssClass dui_border_x_9999px = () -> "dui-border-x-9999px";

  CssClass dui_border_x_0_5 = () -> "dui-border-x-0_5";

  CssClass dui_border_x_1 = () -> "dui-border-x-1";

  CssClass dui_border_x_1_5 = () -> "dui-border-x-1_5";

  CssClass dui_border_x_2 = () -> "dui-border-x-2";

  CssClass dui_border_x_2_5 = () -> "dui-border-x-2_5";

  CssClass dui_border_x_3 = () -> "dui-border-x-3";

  CssClass dui_border_x_3_5 = () -> "dui-border-x-3_5";

  CssClass dui_border_x_4 = () -> "dui-border-x-4";

  CssClass dui_border_x_5 = () -> "dui-border-x-5";

  CssClass dui_border_x_6 = () -> "dui-border-x-6";

  CssClass dui_border_x_7 = () -> "dui-border-x-7";

  CssClass dui_border_x_8 = () -> "dui-border-x-8";

  CssClass dui_border_x_9 = () -> "dui-border-x-9";

  CssClass dui_border_x_10 = () -> "dui-border-x-10";

  CssClass dui_border_x_11 = () -> "dui-border-x-11";

  CssClass dui_border_x_12 = () -> "dui-border-x-12";

  CssClass dui_border_x_14 = () -> "dui-border-x-14";

  CssClass dui_border_x_16 = () -> "dui-border-x-16";

  CssClass dui_border_x_20 = () -> "dui-border-x-20";

  CssClass dui_border_x_24 = () -> "dui-border-x-24";

  CssClass dui_border_x_28 = () -> "dui-border-x-28";

  CssClass dui_border_x_32 = () -> "dui-border-x-32";

  CssClass dui_border_x_36 = () -> "dui-border-x-36";

  CssClass dui_border_x_40 = () -> "dui-border-x-40";

  CssClass dui_border_x_44 = () -> "dui-border-x-44";

  CssClass dui_border_x_48 = () -> "dui-border-x-48";

  CssClass dui_border_x_52 = () -> "dui-border-x-52";

  CssClass dui_border_x_56 = () -> "dui-border-x-56";

  CssClass dui_border_x_60 = () -> "dui-border-x-60";

  CssClass dui_border_x_64 = () -> "dui-border-x-64";

  CssClass dui_border_x_72 = () -> "dui-border-x-72";

  CssClass dui_border_x_80 = () -> "dui-border-x-80";

  CssClass dui_border_x_96 = () -> "dui-border-x-96";

  CssClass dui_border_y_0 = () -> "dui-border-y-0";

  CssClass dui_border_y = () -> "dui-border-y";

  CssClass dui_border_y_2px = () -> "dui-border-y-2px";

  CssClass dui_border_y_4px = () -> "dui-border-y-4px";

  CssClass dui_border_y_8px = () -> "dui-border-y-8px";

  CssClass dui_border_y_9999px = () -> "dui-border-y-9999px";

  CssClass dui_border_y_0_5 = () -> "dui-border-y-0_5";

  CssClass dui_border_y_1 = () -> "dui-border-y-1";

  CssClass dui_border_y_1_5 = () -> "dui-border-y-1_5";

  CssClass dui_border_y_2 = () -> "dui-border-y-2";

  CssClass dui_border_y_2_5 = () -> "dui-border-y-2_5";

  CssClass dui_border_y_3 = () -> "dui-border-y-3";

  CssClass dui_border_y_3_5 = () -> "dui-border-y-3_5";

  CssClass dui_border_y_4 = () -> "dui-border-y-4";

  CssClass dui_border_y_5 = () -> "dui-border-y-5";

  CssClass dui_border_y_6 = () -> "dui-border-y-6";

  CssClass dui_border_y_7 = () -> "dui-border-y-7";

  CssClass dui_border_y_8 = () -> "dui-border-y-8";

  CssClass dui_border_y_9 = () -> "dui-border-y-9";

  CssClass dui_border_y_10 = () -> "dui-border-y-10";

  CssClass dui_border_y_11 = () -> "dui-border-y-11";

  CssClass dui_border_y_12 = () -> "dui-border-y-12";

  CssClass dui_border_y_14 = () -> "dui-border-y-14";

  CssClass dui_border_y_16 = () -> "dui-border-y-16";

  CssClass dui_border_y_20 = () -> "dui-border-y-20";

  CssClass dui_border_y_24 = () -> "dui-border-y-24";

  CssClass dui_border_y_28 = () -> "dui-border-y-28";

  CssClass dui_border_y_32 = () -> "dui-border-y-32";

  CssClass dui_border_y_36 = () -> "dui-border-y-36";

  CssClass dui_border_y_40 = () -> "dui-border-y-40";

  CssClass dui_border_y_44 = () -> "dui-border-y-44";

  CssClass dui_border_y_48 = () -> "dui-border-y-48";

  CssClass dui_border_y_52 = () -> "dui-border-y-52";

  CssClass dui_border_y_56 = () -> "dui-border-y-56";

  CssClass dui_border_y_60 = () -> "dui-border-y-60";

  CssClass dui_border_y_64 = () -> "dui-border-y-64";

  CssClass dui_border_y_72 = () -> "dui-border-y-72";

  CssClass dui_border_y_80 = () -> "dui-border-y-80";

  CssClass dui_border_y_96 = () -> "dui-border-y-96";

  CssClass dui_border_t_0 = () -> "dui-border-t-0";

  CssClass dui_border_t = () -> "dui-border-t";

  CssClass dui_border_t_2px = () -> "dui-border-t-2px";

  CssClass dui_border_t_4px = () -> "dui-border-t-4px";

  CssClass dui_border_t_8px = () -> "dui-border-t-8px";

  CssClass dui_border_t_9999px = () -> "dui-border-t-9999px";

  CssClass dui_border_t_0_5 = () -> "dui-border-t-0_5";

  CssClass dui_border_t_1 = () -> "dui-border-t-1";

  CssClass dui_border_t_1_5 = () -> "dui-border-t-1_5";

  CssClass dui_border_t_2 = () -> "dui-border-t-2";

  CssClass dui_border_t_2_5 = () -> "dui-border-t-2_5";

  CssClass dui_border_t_3 = () -> "dui-border-t-3";

  CssClass dui_border_t_3_5 = () -> "dui-border-t-3_5";

  CssClass dui_border_t_4 = () -> "dui-border-t-4";

  CssClass dui_border_t_5 = () -> "dui-border-t-5";

  CssClass dui_border_t_6 = () -> "dui-border-t-6";

  CssClass dui_border_t_7 = () -> "dui-border-t-7";

  CssClass dui_border_t_8 = () -> "dui-border-t-8";

  CssClass dui_border_t_9 = () -> "dui-border-t-9";

  CssClass dui_border_t_10 = () -> "dui-border-t-10";

  CssClass dui_border_t_11 = () -> "dui-border-t-11";

  CssClass dui_border_t_12 = () -> "dui-border-t-12";

  CssClass dui_border_t_14 = () -> "dui-border-t-14";

  CssClass dui_border_t_16 = () -> "dui-border-t-16";

  CssClass dui_border_t_20 = () -> "dui-border-t-20";

  CssClass dui_border_t_24 = () -> "dui-border-t-24";

  CssClass dui_border_t_28 = () -> "dui-border-t-28";

  CssClass dui_border_t_32 = () -> "dui-border-t-32";

  CssClass dui_border_t_36 = () -> "dui-border-t-36";

  CssClass dui_border_t_40 = () -> "dui-border-t-40";

  CssClass dui_border_t_44 = () -> "dui-border-t-44";

  CssClass dui_border_t_48 = () -> "dui-border-t-48";

  CssClass dui_border_t_52 = () -> "dui-border-t-52";

  CssClass dui_border_t_56 = () -> "dui-border-t-56";

  CssClass dui_border_t_60 = () -> "dui-border-t-60";

  CssClass dui_border_t_64 = () -> "dui-border-t-64";

  CssClass dui_border_t_72 = () -> "dui-border-t-72";

  CssClass dui_border_t_80 = () -> "dui-border-t-80";

  CssClass dui_border_t_96 = () -> "dui-border-t-96";

  CssClass dui_border_r_0 = () -> "dui-border-r-0";

  CssClass dui_border_r = () -> "dui-border-r";

  CssClass dui_border_r_2px = () -> "dui-border-r-2px";

  CssClass dui_border_r_4px = () -> "dui-border-r-4px";

  CssClass dui_border_r_8px = () -> "dui-border-r-8px";

  CssClass dui_border_r_9999px = () -> "dui-border-r-9999px";

  CssClass dui_border_r_0_5 = () -> "dui-border-r-0_5";

  CssClass dui_border_r_1 = () -> "dui-border-r-1";

  CssClass dui_border_r_1_5 = () -> "dui-border-r-1_5";

  CssClass dui_border_r_2 = () -> "dui-border-r-2";

  CssClass dui_border_r_2_5 = () -> "dui-border-r-2_5";

  CssClass dui_border_r_3 = () -> "dui-border-r-3";

  CssClass dui_border_r_3_5 = () -> "dui-border-r-3_5";

  CssClass dui_border_r_4 = () -> "dui-border-r-4";

  CssClass dui_border_r_5 = () -> "dui-border-r-5";

  CssClass dui_border_r_6 = () -> "dui-border-r-6";

  CssClass dui_border_r_7 = () -> "dui-border-r-7";

  CssClass dui_border_r_8 = () -> "dui-border-r-8";

  CssClass dui_border_r_9 = () -> "dui-border-r-9";

  CssClass dui_border_r_10 = () -> "dui-border-r-10";

  CssClass dui_border_r_11 = () -> "dui-border-r-11";

  CssClass dui_border_r_12 = () -> "dui-border-r-12";

  CssClass dui_border_r_14 = () -> "dui-border-r-14";

  CssClass dui_border_r_16 = () -> "dui-border-r-16";

  CssClass dui_border_r_20 = () -> "dui-border-r-20";

  CssClass dui_border_r_24 = () -> "dui-border-r-24";

  CssClass dui_border_r_28 = () -> "dui-border-r-28";

  CssClass dui_border_r_32 = () -> "dui-border-r-32";

  CssClass dui_border_r_36 = () -> "dui-border-r-36";

  CssClass dui_border_r_40 = () -> "dui-border-r-40";

  CssClass dui_border_r_44 = () -> "dui-border-r-44";

  CssClass dui_border_r_48 = () -> "dui-border-r-48";

  CssClass dui_border_r_52 = () -> "dui-border-r-52";

  CssClass dui_border_r_56 = () -> "dui-border-r-56";

  CssClass dui_border_r_60 = () -> "dui-border-r-60";

  CssClass dui_border_r_64 = () -> "dui-border-r-64";

  CssClass dui_border_r_72 = () -> "dui-border-r-72";

  CssClass dui_border_r_80 = () -> "dui-border-r-80";

  CssClass dui_border_r_96 = () -> "dui-border-r-96";

  CssClass dui_border_b_0 = () -> "dui-border-b-0";

  CssClass dui_border_b = () -> "dui-border-b";

  CssClass dui_border_b_2px = () -> "dui-border-b-2px";

  CssClass dui_border_b_4px = () -> "dui-border-b-4px";

  CssClass dui_border_b_8px = () -> "dui-border-b-8px";

  CssClass dui_border_b_9999px = () -> "dui-border-b-9999px";

  CssClass dui_border_b_0_5 = () -> "dui-border-b-0_5";

  CssClass dui_border_b_1 = () -> "dui-border-b-1";

  CssClass dui_border_b_1_5 = () -> "dui-border-b-1_5";

  CssClass dui_border_b_2 = () -> "dui-border-b-2";

  CssClass dui_border_b_2_5 = () -> "dui-border-b-2_5";

  CssClass dui_border_b_3 = () -> "dui-border-b-3";

  CssClass dui_border_b_3_5 = () -> "dui-border-b-3_5";

  CssClass dui_border_b_4 = () -> "dui-border-b-4";

  CssClass dui_border_b_5 = () -> "dui-border-b-5";

  CssClass dui_border_b_6 = () -> "dui-border-b-6";

  CssClass dui_border_b_7 = () -> "dui-border-b-7";

  CssClass dui_border_b_8 = () -> "dui-border-b-8";

  CssClass dui_border_b_9 = () -> "dui-border-b-9";

  CssClass dui_border_b_10 = () -> "dui-border-b-10";

  CssClass dui_border_b_11 = () -> "dui-border-b-11";

  CssClass dui_border_b_12 = () -> "dui-border-b-12";

  CssClass dui_border_b_14 = () -> "dui-border-b-14";

  CssClass dui_border_b_16 = () -> "dui-border-b-16";

  CssClass dui_border_b_20 = () -> "dui-border-b-20";

  CssClass dui_border_b_24 = () -> "dui-border-b-24";

  CssClass dui_border_b_28 = () -> "dui-border-b-28";

  CssClass dui_border_b_32 = () -> "dui-border-b-32";

  CssClass dui_border_b_36 = () -> "dui-border-b-36";

  CssClass dui_border_b_40 = () -> "dui-border-b-40";

  CssClass dui_border_b_44 = () -> "dui-border-b-44";

  CssClass dui_border_b_48 = () -> "dui-border-b-48";

  CssClass dui_border_b_52 = () -> "dui-border-b-52";

  CssClass dui_border_b_56 = () -> "dui-border-b-56";

  CssClass dui_border_b_60 = () -> "dui-border-b-60";

  CssClass dui_border_b_64 = () -> "dui-border-b-64";

  CssClass dui_border_b_72 = () -> "dui-border-b-72";

  CssClass dui_border_b_80 = () -> "dui-border-b-80";

  CssClass dui_border_b_96 = () -> "dui-border-b-96";

  CssClass dui_border_l_0 = () -> "dui-border-l-0";

  CssClass dui_border_l = () -> "dui-border-l";

  CssClass dui_border_l_2px = () -> "dui-border-l-2px";

  CssClass dui_border_l_4px = () -> "dui-border-l-4px";

  CssClass dui_border_l_8px = () -> "dui-border-l-8px";

  CssClass dui_border_l_9999px = () -> "dui-border-l-9999px";

  CssClass dui_border_l_0_5 = () -> "dui-border-l-0_5";

  CssClass dui_border_l_1 = () -> "dui-border-l-1";

  CssClass dui_border_l_1_5 = () -> "dui-border-l-1_5";

  CssClass dui_border_l_2 = () -> "dui-border-l-2";

  CssClass dui_border_l_2_5 = () -> "dui-border-l-2_5";

  CssClass dui_border_l_3 = () -> "dui-border-l-3";

  CssClass dui_border_l_3_5 = () -> "dui-border-l-3_5";

  CssClass dui_border_l_4 = () -> "dui-border-l-4";

  CssClass dui_border_l_5 = () -> "dui-border-l-5";

  CssClass dui_border_l_6 = () -> "dui-border-l-6";

  CssClass dui_border_l_7 = () -> "dui-border-l-7";

  CssClass dui_border_l_8 = () -> "dui-border-l-8";

  CssClass dui_border_l_9 = () -> "dui-border-l-9";

  CssClass dui_border_l_10 = () -> "dui-border-l-10";

  CssClass dui_border_l_11 = () -> "dui-border-l-11";

  CssClass dui_border_l_12 = () -> "dui-border-l-12";

  CssClass dui_border_l_14 = () -> "dui-border-l-14";

  CssClass dui_border_l_16 = () -> "dui-border-l-16";

  CssClass dui_border_l_20 = () -> "dui-border-l-20";

  CssClass dui_border_l_24 = () -> "dui-border-l-24";

  CssClass dui_border_l_28 = () -> "dui-border-l-28";

  CssClass dui_border_l_32 = () -> "dui-border-l-32";

  CssClass dui_border_l_36 = () -> "dui-border-l-36";

  CssClass dui_border_l_40 = () -> "dui-border-l-40";

  CssClass dui_border_l_44 = () -> "dui-border-l-44";

  CssClass dui_border_l_48 = () -> "dui-border-l-48";

  CssClass dui_border_l_52 = () -> "dui-border-l-52";

  CssClass dui_border_l_56 = () -> "dui-border-l-56";

  CssClass dui_border_l_60 = () -> "dui-border-l-60";

  CssClass dui_border_l_64 = () -> "dui-border-l-64";

  CssClass dui_border_l_72 = () -> "dui-border-l-72";

  CssClass dui_border_l_80 = () -> "dui-border-l-80";

  CssClass dui_border_l_96 = () -> "dui-border-l-96";

  CssClass dui_divide_x_0 = () -> "dui-divide-x-0";

  CssClass dui_divide_x_2 = () -> "dui-divide-x-2";

  CssClass dui_divide_x_4 = () -> "dui-divide-x-4";

  CssClass dui_divide_x_8 = () -> "dui-divide-x-8";

  CssClass dui_divide_x = () -> "dui-divide-x";

  CssClass dui_divide_y_0 = () -> "dui-divide-y-0";

  CssClass dui_divide_y_2 = () -> "dui-divide-y-2";

  CssClass dui_divide_y_4 = () -> "dui-divide-y-4";

  CssClass dui_divide_y_8 = () -> "dui-divide-y-8";

  CssClass dui_divide_y = () -> "dui-divide-y";

  CssClass dui_outline_0 = () -> "dui-outline-0";

  CssClass dui_outline_1 = () -> "dui-outline-1";

  CssClass dui_outline_2 = () -> "dui-outline-2";

  CssClass dui_outline_4 = () -> "dui-outline-4";

  CssClass dui_outline_8 = () -> "dui-outline-8";

  CssClass dui_outline_offset_0 = () -> "dui-outline-offset-0";

  CssClass dui_outline_offset_1 = () -> "dui-outline-offset-1";

  CssClass dui_outline_offset_2 = () -> "dui-outline-offset-2";

  CssClass dui_outline_offset_4 = () -> "dui-outline-offset-4";

  CssClass dui_outline_offset_8 = () -> "dui-outline-offset-8";
}
