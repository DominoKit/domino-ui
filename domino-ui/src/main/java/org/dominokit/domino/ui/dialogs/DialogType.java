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
package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.style.CssClass;

/** An enum to list modal types */
public enum DialogType implements DialogStyles {
  /** A modal that show up from the bottom of screen and spread to match the screen width */
  BOTTOM_SHEET(dui_dialog_bottom_sheet),
  /** A modal that show up from the top of screen and spread to match the screen width */
  TOP_SHEET(dui_dialog_top_sheet),
  /** A modal that show up from the left of screen and spread to match the screen height */
  LEFT_SHEET(dui_dialog_left_sheet),
  /** A modal that show up from the right of screen and spread to match the screen height */
  RIGHT_SHEET(dui_dialog_right_sheet),
  /** Set the modal type to default and show in the middle of the screen */
  DEFAULT(CssClass.NONE);

  CssClass style;

  /** @param style String css style name */
  DialogType(CssClass style) {
    this.style = style;
  }
}
