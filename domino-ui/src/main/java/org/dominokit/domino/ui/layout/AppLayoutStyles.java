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

/**
 * The {@code AppLayoutStyles} interface provides CSS classes for styling the elements of an
 * application layout.
 */
public interface AppLayoutStyles {

  /** Represents the main layout CSS class. */
  CssClass dui_layout = () -> "dui-layout";

  /** Represents the CSS class for the main layout body. */
  CssClass dui_body = () -> "dui-layout-body";

  /** Represents the CSS class for the layout header. */
  CssClass dui_header = () -> "dui-layout-header";

  /** Represents the CSS class for the layout footer. */
  CssClass dui_footer = () -> "dui-layout-footer";

  /** Represents the CSS class for the layout content. */
  CssClass dui_content = () -> "dui-layout-content";

  /** Represents the CSS class for the left drawer. */
  CssClass dui_left_drawer = () -> "dui-left-drawer";

  /** Represents the CSS class for the right drawer. */
  CssClass dui_right_drawer = () -> "dui-right-drawer";

  /** Represents the CSS class for layouts with a header. */
  CssClass dui_has_header = () -> "dui-layout-has-header";

  /** Represents the CSS class for layouts with a footer. */
  CssClass dui_has_footer = () -> "dui-layout-has-footer";

  /** Represents the CSS class for a fixed footer in the layout. */
  CssClass dui_footer_fixed = () -> "dui-layout-footer-fixed";

  /** Represents the CSS class for an open left drawer. */
  CssClass dui_left_open = () -> "dui-left-open";

  /** Represents the CSS class for the layout menu. */
  CssClass dui_layout_menu = () -> "dui-layout-menu";

  /** Represents the CSS class for an extra-small left drawer. */
  CssClass dui_left_xsmall = () -> "dui-layout-left-drawer-xsm";

  /** Represents the CSS class for a small left drawer. */
  CssClass dui_left_small = () -> "dui-layout-left-drawer-sm";

  /** Represents the CSS class for a medium-sized left drawer. */
  CssClass dui_left_medium = () -> "dui-layout-left-drawer-md";

  /** Represents the CSS class for a large left drawer. */
  CssClass dui_left_large = () -> "dui-layout-left-drawer-lg";

  /** Represents the CSS class for an extra-large left drawer. */
  CssClass dui_left_xlarge = () -> "dui-layout-left-drawer-xlg";

  /** Represents the CSS class for an open right drawer. */
  CssClass dui_right_open = () -> "dui-right-open";

  /** Represents the CSS class for an extra-small right drawer. */
  CssClass dui_right_xsmall = () -> "dui-layout-right-drawer-xsm";

  /** Represents the CSS class for a small right drawer. */
  CssClass dui_right_small = () -> "dui-layout-right-drawer-sm";

  /** Represents the CSS class for a medium-sized right drawer. */
  CssClass dui_right_medium = () -> "dui-layout-right-drawer-md";

  /** Represents the CSS class for a large right drawer. */
  CssClass dui_right_large = () -> "dui-layout-right-drawer-lg";

  /** Represents the CSS class for an extra-large right drawer. */
  CssClass dui_right_xlarge = () -> "dui-layout-right-drawer-xlg";

  /** Represents the CSS class for shrinking content. */
  CssClass dui_shrink_content = () -> "dui-shrink-content";

  /** Represents the CSS class for spanning up the left drawer. */
  CssClass dui_left_span_up = () -> "dui-left-drawer-span-up";

  /** Represents the CSS class for spanning down the left drawer. */
  CssClass dui_left_span_down = () -> "dui-left-drawer-span-down";

  /** Represents the CSS class for overlaying the left drawer. */
  CssClass dui_left_overlay = () -> "dui-left-overlay";

  /** Represents the CSS class for overlaying the right drawer. */
  CssClass dui_right_overlay = () -> "dui-right-overlay";
}
