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

/** A utility class that provides CSS classes for customizing icons in Domino UI. */
public class IconsStyles {

  /** Represents the Material Design Icons (MDI) CSS class. */
  public static final CssClass dui_mdi = () -> "mdi";

  /** Represents the CSS class for labeled icons. */
  public static final CssClass dui_labeled_icon = () -> "dui-labeled-icon";

  /** Represents the CSS class for MDI icons with text. */
  public static final CssClass dui_icon_text = () -> "dui-mdi-text";

  /** Represents the CSS class for rotating an MDI icon by 45 degrees. */
  public static final CssClass mdi_rotate_45 = () -> "mdi-rotate-45";

  /** Represents the CSS class for rotating an MDI icon by 90 degrees. */
  public static final CssClass mdi_rotate_90 = () -> "mdi-rotate-90";

  /** Represents the CSS class for rotating an MDI icon by 135 degrees. */
  public static final CssClass mdi_rotate_135 = () -> "mdi-rotate-135";

  /** Represents the CSS class for rotating an MDI icon by 180 degrees. */
  public static final CssClass mdi_rotate_180 = () -> "mdi-rotate-180";

  /** Represents the CSS class for rotating an MDI icon by 225 degrees. */
  public static final CssClass mdi_rotate_225 = () -> "mdi-rotate-225";

  /** Represents the CSS class for rotating an MDI icon by 270 degrees. */
  public static final CssClass mdi_rotate_270 = () -> "mdi-rotate-270";

  /** Represents the CSS class for rotating an MDI icon by 315 degrees. */
  public static final CssClass mdi_rotate_315 = () -> "mdi-rotate-315";

  /** Represents the CSS class for flipping an MDI icon vertically. */
  public static final ToggleCssClass mdi_flip_v = ToggleCssClass.of(() -> "mdi-flip-v");

  /** Represents the CSS class for flipping an MDI icon horizontally. */
  public static final ToggleCssClass mdi_flip_h = ToggleCssClass.of(() -> "mdi-flip-h");

  /** Represents the CSS class for a light-colored MDI icon. */
  public static final CssClass mdi_light = () -> "mdi-light";

  /** Represents the CSS class for a dark-colored MDI icon. */
  public static final CssClass mdi_dark = () -> "mdi-dark";

  /** Represents the CSS class for spinning an MDI icon. */
  public static final CssClass mdi_spin = () -> "mdi-spin";

  /** Represents the CSS class for an inactive MDI icon. */
  public static final CssClass mdi_inactive = () -> "mdi-inactive";
}
