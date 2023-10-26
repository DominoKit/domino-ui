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
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.pickers.ColorValue;

/**
 * A UI component for selecting foreground (text) color.
 *
 * <p>The ForegroundColorPicker extends {@link ColorPickerButton} to provide a button with a text
 * color indicator. When clicked, a color picker is presented, and upon selection, the text color of
 * the indicator is updated.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * ForegroundColorPicker colorPicker = ForegroundColorPicker.create();
 * colorPicker.addChangeListener(color -> {
 *     // handle color change logic
 * });
 * }</pre>
 */
public class ForegroundColorPicker extends ColorPickerButton {

  private Icon<?> colorIndicator;

  /**
   * Factory method to create a new instance of ForegroundColorPicker.
   *
   * @return A new instance of ForegroundColorPicker.
   */
  public static ForegroundColorPicker create() {
    return new ForegroundColorPicker();
  }

  /**
   * Updates the color of the indicator icon with the newly selected color.
   *
   * @param newValue The new color value selected.
   */
  @Override
  protected void onColorSelected(ColorValue newValue) {
    colorIndicator.setColor(newValue.getHex());
  }

  /**
   * Creates and returns the button used as an indicator for the selected color.
   *
   * @return The button with an icon indicating the selected color.
   */
  @Override
  public Button makeIndicatorButton() {
    return Button.create(
        colorIndicator =
            Icons.format_color_text()
                .addCss(dui_font_size_4)
                .setColor(getDefaultColor())
                .addCss(dui_bg_white, dui_border, dui_border_solid, dui_border_black));
  }

  /**
   * Provides the default color which is set when the picker is initialized.
   *
   * @return The default color in hex format.
   */
  @Override
  protected String getDefaultColor() {
    return "#000000";
  }
}
