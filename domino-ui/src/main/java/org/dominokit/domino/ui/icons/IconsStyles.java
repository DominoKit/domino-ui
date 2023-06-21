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

/**
 * IconsStyles class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class IconsStyles {
  /** Constant <code>dui_mdi</code> */
  public static final CssClass dui_mdi = () -> "mdi";
  /** Constant <code>dui_labeled_icon</code> */
  public static final CssClass dui_labeled_icon = () -> "dui-labeled-icon";
  /** Constant <code>dui_icon_text</code> */
  public static final CssClass dui_icon_text = () -> "dui-mdi-text";

  /** Constant <code>mdi_rotate_45</code> */
  public static final CssClass mdi_rotate_45 = () -> "mdi-rotate-45";
  /** Constant <code>mdi_rotate_90</code> */
  public static final CssClass mdi_rotate_90 = () -> "mdi-rotate-90";
  /** Constant <code>mdi_rotate_135</code> */
  public static final CssClass mdi_rotate_135 = () -> "mdi-rotate-135";
  /** Constant <code>mdi_rotate_180</code> */
  public static final CssClass mdi_rotate_180 = () -> "mdi-rotate-180";
  /** Constant <code>mdi_rotate_225</code> */
  public static final CssClass mdi_rotate_225 = () -> "mdi-rotate-225";
  /** Constant <code>mdi_rotate_270</code> */
  public static final CssClass mdi_rotate_270 = () -> "mdi-rotate-270";
  /** Constant <code>mdi_rotate_315</code> */
  public static final CssClass mdi_rotate_315 = () -> "mdi-rotate-315";

  /** Constant <code>mdi_flip_v</code> */
  public static final ToggleCssClass mdi_flip_v = ToggleCssClass.of(() -> "mdi-flip-v");
  /** Constant <code>mdi_flip_h</code> */
  public static final ToggleCssClass mdi_flip_h = ToggleCssClass.of(() -> "mdi-flip-h");

  /** Constant <code>mdi_light</code> */
  public static final CssClass mdi_light = () -> "mdi-light";
  /** Constant <code>mdi_dark</code> */
  public static final CssClass mdi_dark = () -> "mdi-dark";

  /** Constant <code>mdi_spin</code> */
  public static final CssClass mdi_spin = () -> "mdi-spin";
  /** Constant <code>mdi_inactive</code> */
  public static final CssClass mdi_inactive = () -> "mdi-inactive";
}
