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
package org.dominokit.domino.ui.richtext;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.icons.ElementIcon;
import org.dominokit.domino.ui.pickers.ColorValue;

public class BackgroundColorPicker extends ColorPickerButton {

  private ElementIcon colorIndicator;

  public static BackgroundColorPicker create() {
    return new BackgroundColorPicker();
  }

  @Override
  protected void onColorSelected(ColorValue newValue) {
    colorIndicator.setBackgroundColor(newValue.getHex());
  }

  @Override
  public Button makeIndicatorButton() {
    return Button.create(
            colorIndicator =
                ElementIcon.create(
                    div()
                        .setBackgroundColor("#FFFFFF")
                        .addCss(dui_w_4, dui_h_4, dui_border, dui_border_black, dui_border_solid),
                    "color-picker"))
        .addCss(dui_border, dui_border_solid, dui_border_accent);
  }

  @Override
  protected String getDefaultColor() {
    return "#FFFFFF";
  }
}
