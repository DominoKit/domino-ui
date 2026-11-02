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
package org.dominokit.domino.ui.icons;

import org.dominokit.domino.ui.style.CssClass;

/** Shared CSS hooks used by all Domino UI icon packs. */
public final class IconCss {

  /** Shared marker applied to all pack icon roots. */
  public static final CssClass dui_icons = () -> "dui-icons";

  /** Legacy common icon marker retained for existing icon styling and APIs. */
  public static final CssClass dui_icon = () -> "dui-icon";

  /** Default outline SVG icon treatment. */
  public static final CssClass dui_icon_outline = () -> "dui-icon-outline";

  /** Filled SVG icon treatment. */
  public static final CssClass dui_icon_filled = () -> "dui-icon-filled";

  /** One-pixel SVG stroke width preset. */
  public static final CssClass dui_stroke_width_1 = () -> "dui-stroke-width-1";

  /** One-and-a-half-pixel SVG stroke width preset. */
  public static final CssClass dui_stroke_width_1_5 = () -> "dui-stroke-width-1_5";

  /** Two-pixel SVG stroke width preset. */
  public static final CssClass dui_stroke_width_2 = () -> "dui-stroke-width-2";

  /** Two-and-a-half-pixel SVG stroke width preset. */
  public static final CssClass dui_stroke_width_2_5 = () -> "dui-stroke-width-2_5";

  /** Three-pixel SVG stroke width preset. */
  public static final CssClass dui_stroke_width_3 = () -> "dui-stroke-width-3";

  /** Shared square icon treatment. */
  public static final CssClass dui_icon_square = () -> "dui-icon-square";

  /** Shared bordered icon treatment. */
  public static final CssClass dui_icon_bordered = () -> "dui-icon-bordered";

  /** Shared surface icon treatment. */
  public static final CssClass dui_icon_surface = () -> "dui-icon-surface";

  private IconCss() {}
}
