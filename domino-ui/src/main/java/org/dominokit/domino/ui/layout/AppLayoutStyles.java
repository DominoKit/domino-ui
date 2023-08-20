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

/** AppLayoutStyles interface. */
public interface AppLayoutStyles {

  /** Constant <code>dui_layout</code> */
  CssClass dui_layout = () -> "dui-layout";
  /** Constant <code>dui_body</code> */
  CssClass dui_body = () -> "dui-layout-body";
  /** Constant <code>dui_header</code> */
  CssClass dui_header = () -> "dui-layout-header";
  /** Constant <code>dui_footer</code> */
  CssClass dui_footer = () -> "dui-layout-footer";
  /** Constant <code>dui_content</code> */
  CssClass dui_content = () -> "dui-layout-content";
  /** Constant <code>dui_left_drawer</code> */
  CssClass dui_left_drawer = () -> "dui-left-drawer";
  /** Constant <code>dui_right_drawer</code> */
  CssClass dui_right_drawer = () -> "dui-right-drawer";
  /** Constant <code>dui_has_header</code> */
  CssClass dui_has_header = () -> "dui-layout-has-header";
  /** Constant <code>dui_has_footer</code> */
  CssClass dui_has_footer = () -> "dui-layout-has-footer";
  /** Constant <code>dui_footer_fixed</code> */
  CssClass dui_footer_fixed = () -> "dui-layout-footer-fixed";

  /** Constant <code>dui_left_open</code> */
  CssClass dui_left_open = () -> "dui-left-open";
  /** Constant <code>dui_layout_menu</code> */
  CssClass dui_layout_menu = () -> "dui-layout-menu";

  /** Constant <code>dui_left_xsmall</code> */
  CssClass dui_left_xsmall = () -> "dui-layout-left-drawer-xsm";
  /** Constant <code>dui_left_small</code> */
  CssClass dui_left_small = () -> "dui-layout-left-drawer-sm";
  /** Constant <code>dui_left_medium</code> */
  CssClass dui_left_medium = () -> "dui-layout-left-drawer-md";
  /** Constant <code>dui_left_large</code> */
  CssClass dui_left_large = () -> "dui-layout-left-drawer-lg";
  /** Constant <code>dui_left_xlarge</code> */
  CssClass dui_left_xlarge = () -> "dui-layout-left-drawer-xlg";

  /** Constant <code>dui_right_open</code> */
  CssClass dui_right_open = () -> "dui-right-open";

  /** Constant <code>dui_right_xsmall</code> */
  CssClass dui_right_xsmall = () -> "dui-layout-right-drawer-xsm";
  /** Constant <code>dui_right_small</code> */
  CssClass dui_right_small = () -> "dui-layout-right-drawer-sm";
  /** Constant <code>dui_right_medium</code> */
  CssClass dui_right_medium = () -> "dui-layout-right-drawer-md";
  /** Constant <code>dui_right_large</code> */
  CssClass dui_right_large = () -> "dui-layout-right-drawer-lg";
  /** Constant <code>dui_right_xlarge</code> */
  CssClass dui_right_xlarge = () -> "dui-layout-right-drawer-xlg";
  /** Constant <code>dui_shrink_content</code> */
  CssClass dui_shrink_content = () -> "dui-shrink-content";
  /** Constant <code>dui_left_span_up</code> */
  CssClass dui_left_span_up = () -> "dui-left-drawer-span-up";
  /** Constant <code>dui_left_span_down</code> */
  CssClass dui_left_span_down = () -> "dui-left-drawer-span-down";

  /** Constant <code>dui_left_overlay</code> */
  CssClass dui_left_overlay = () -> "dui-left-overlay";
  /** Constant <code>dui_right_overlay</code> */
  CssClass dui_right_overlay = () -> "dui-right-overlay";
}
