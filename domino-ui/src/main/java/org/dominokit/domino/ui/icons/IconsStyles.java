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

  public static final CssClass MDI = () -> "mdi";

  public static final CssClass LABELED_ICON = () -> "dui-labeled-icon";
  public static final CssClass REVERSED = () -> "dui-reversed";
  public static final CssClass ICON_TEXT = () -> "dui-mdi-text";

  public static final CssClass _18PX = () -> "mdi-18px";
  public static final CssClass _24PX = () -> "mdi-24px";
  public static final CssClass _36PX = () -> "mdi-36px";
  public static final CssClass _48PX = () -> "mdi-48px";

  public static final CssClass ROTATE_45 = () -> "mdi-rotate-45";
  public static final CssClass ROTATE_90 = () -> "mdi-rotate-90";
  public static final CssClass ROTATE_135 = () -> "mdi-rotate-135";
  public static final CssClass ROTATE_180 = () -> "mdi-rotate-180";
  public static final CssClass ROTATE_225 = () -> "mdi-rotate-225";
  public static final CssClass ROTATE_270 = () -> "mdi-rotate-270";
  public static final CssClass ROTATE_315 = () -> "mdi-rotate-315";

  public static final ToggleCssClass FLIP_V = () -> "mdi-flip-v";
  public static final ToggleCssClass FLIP_H = () -> "mdi-flip-h";

  public static final CssClass LIGHT = () -> "mdi-light";
  public static final CssClass DARK = () -> "mdi-dark";

  public static final CssClass SPIN = () -> "mdi-spin";
  public static final CssClass INACTIVE = () -> "mdi-inactive";
}
