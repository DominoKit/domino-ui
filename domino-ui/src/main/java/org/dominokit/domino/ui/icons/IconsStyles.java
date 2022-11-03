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
import org.dominokit.domino.ui.style.ToggleCssClass;

public class IconsStyles {

  public static final CssClass dui_mdi = () -> "mdi";

  public static final CssClass dui_labeled_icon = () -> "dui-labeled-icon";
  public static final CssClass dui_reversed = () -> "dui-reversed";
  public static final CssClass dui_icon_text = () -> "dui-mdi-text";

  public static final CssClass mdi_18px = () -> "mdi-18px";
  public static final CssClass mdi_24px = () -> "mdi-24px";
  public static final CssClass mdi_36px = () -> "mdi-36px";
  public static final CssClass mdi_48px = () -> "mdi-48px";

  public static final CssClass mdi_rotate_45 = () -> "mdi-rotate-45";
  public static final CssClass mdi_rotate_90 = () -> "mdi-rotate-90";
  public static final CssClass mdi_rotate_135 = () -> "mdi-rotate-135";
  public static final CssClass mdi_rotate_180 = () -> "mdi-rotate-180";
  public static final CssClass mdi_rotate_225 = () -> "mdi-rotate-225";
  public static final CssClass mdi_rotate_270 = () -> "mdi-rotate-270";
  public static final CssClass mdi_rotate_315 = () -> "mdi-rotate-315";

  public static final ToggleCssClass mdi_flip_v = () -> "mdi-flip-v";
  public static final ToggleCssClass mdi_flip_h = () -> "mdi-flip-h";

  public static final CssClass mdi_light = () -> "mdi-light";
  public static final CssClass mdi_dark = () -> "mdi-dark";

  public static final CssClass mdi_spin = () -> "mdi-spin";
  public static final CssClass mdi_inactive = () -> "mdi-inactive";
}
