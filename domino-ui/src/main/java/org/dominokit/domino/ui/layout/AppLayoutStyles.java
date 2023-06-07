/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License";
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
package org.dominokit.domino.ui.layout;

import org.dominokit.domino.ui.style.CssClass;

public interface AppLayoutStyles {

  CssClass dui_layout = () -> "dui-layout";
  CssClass dui_body = () -> "dui-layout-body";
  CssClass dui_header = () -> "dui-layout-header";
  CssClass dui_footer = () -> "dui-layout-footer";
  CssClass dui_content = () -> "dui-layout-content";
  CssClass dui_left_drawer = () -> "dui-left-drawer";
  CssClass dui_right_drawer = () -> "dui-right-drawer";
  CssClass dui_has_header = () -> "dui-layout-has-header";
  CssClass dui_has_footer = () -> "dui-layout-has-footer";
  CssClass dui_footer_fixed = () -> "dui-layout-footer-fixed";

  CssClass dui_left_open = () -> "dui-left-open";
  CssClass dui_layout_menu = () -> "dui-layout-menu";

  CssClass dui_left_xsmall = () -> "dui-layout-left-drawer-xsm";
  CssClass dui_left_small = () -> "dui-layout-left-drawer-sm";
  CssClass dui_left_medium = () -> "dui-layout-left-drawer-md";
  CssClass dui_left_large = () -> "dui-layout-left-drawer-lg";
  CssClass dui_left_xlarge = () -> "dui-layout-left-drawer-xlg";

  CssClass dui_right_open = () -> "dui-right-open";

  CssClass dui_right_xsmall = () -> "dui-layout-right-drawer-xsm";
  CssClass dui_right_small = () -> "dui-layout-right-drawer-sm";
  CssClass dui_right_medium = () -> "dui-layout-right-drawer-md";
  CssClass dui_right_large = () -> "dui-layout-right-drawer-lg";
  CssClass dui_right_xlarge = () -> "dui-layout-right-drawer-xlg";
  CssClass dui_shrink_content = () -> "dui-shrink-content";
  CssClass dui_left_span_up = () -> "dui-left-drawer-span-up";
  CssClass dui_left_span_down = () -> "dui-left-drawer-span-down";

  CssClass dui_left_overlay = () -> "dui-left-overlay";
  CssClass dui_right_overlay = () -> "dui-right-overlay";
}
