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
package org.dominokit.domino.ui.layout;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.ToggleCssClass;

public class AppLayoutStyles {

  public static CssClass LAYOUT = () -> ("dui-layout");
  public static CssClass BODY = () -> ("dui-layout-body");
  public static CssClass HEADER = () -> ("dui-layout-header");
  public static CssClass FOOTER = () -> ("dui-layout-footer");
  public static CssClass CONTENT = () -> ("dui-layout-content");
  public static CssClass LEFT_DRAWER = () -> ("dui-left-drawer");
  public static CssClass RIGHT_DRAWER = () -> ("dui-right-drawer");
  public static CssClass HAS_HEADER = () -> ("dui-layout-has-header");
  public static CssClass HAS_FOOTER = () -> ("dui-layout-has-footer");
  public static ToggleCssClass FOOTER_FIXED = () -> ("dui-layout-footer-fixed");

  public static ToggleCssClass LEFT_OPEN = () -> ("dui-left-open");
  public static CssClass LAYOUT_MENU = () -> ("dui-layout-menu");

  public static CssClass LEFT_XSMALL = () -> ("dui-layout-left-drawer-xsm");
  public static CssClass LEFT_SMALL = () -> ("dui-layout-left-drawer-sm");
  public static CssClass LEFT_MEDIUM = () -> ("dui-layout-left-drawer-md");
  public static CssClass LEFT_LARGE = () -> ("dui-layout-left-drawer-lg");
  public static CssClass LEFT_XLARGE = () -> ("dui-layout-left-drawer-xlg");

  public static ToggleCssClass RIGHT_OPEN = () -> ("dui-right-open");

  public static CssClass RIGHT_XSMALL = () -> ("dui-layout-right-drawer-xsm");
  public static CssClass RIGHT_SMALL = () -> ("dui-layout-right-drawer-sm");
  public static CssClass RIGHT_MEDIUM = () -> ("dui-layout-right-drawer-md");
  public static CssClass RIGHT_LARGE = () -> ("dui-layout-right-drawer-lg");
  public static CssClass RIGHT_XLARGE = () -> ("dui-layout-right-drawer-xlg");

  public static ToggleCssClass SHRINK_CONENT = () -> ("dui-shrink-content");
  public static ToggleCssClass LEFT_SPAN_UP = () -> ("dui-left-drawer-span-up");
  public static ToggleCssClass LEFT_SPAN_DOWN = () -> ("dui-left-drawer-span-down");

  public static ToggleCssClass LEFT_OVERLAY = () -> "dui-left-overlay";
  public static ToggleCssClass RIGHT_OVERLAY = () -> "dui-right-overlay";
}
