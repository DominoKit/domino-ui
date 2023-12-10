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

import static org.dominokit.domino.ui.utils.Domino.*;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.pickers.ColorValue;

/**
 * A UI component for selecting highlight color.
 *
 * <p>The HiliteColorPicker extends {@link ColorPickerButton} to provide a button with a highlight
 * color indicator. When clicked, a color picker is presented, and upon selection, the highlight
 * color of the indicator is updated.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * HiliteColorPicker hilitePicker = HiliteColorPicker.create();
 * hilitePicker.addChangeListener(color -> {
 *     // handle color change logic
 * });
 * }</pre>
 */
public class HiliteColorPicker extends ColorPickerButton {

  private Icon<?> colorIndicator;

  /**
   * Factory method to create a new instance of HiliteColorPicker.
   *
   * @return A new instance of HiliteColorPicker.
   */
  public static HiliteColorPicker create() {
    return new HiliteColorPicker();
  }

  /**
   * Updates the color of the highlight indicator icon with the newly selected color.
   *
   * @param newValue The new color value selected.
   */
  @Override
  protected void onColorSelected(ColorValue newValue) {
    colorIndicator.setColor(newValue.getHex());
  }

  /**
   * Creates and returns the button used as an indicator for the selected highlight color.
   *
   * @return The button with an icon indicating the selected highlight color.
   */
  @Override
  public Button makeIndicatorButton() {
    return Button.create(
        colorIndicator =
            Icons.format_color_highlight()
                .addCss(dui_font_size_4)
                .setColor(getDefaultColor())
                .addCss(dui_bg_white, dui_border, dui_border_solid, dui_border_black));
  }

  /**
   * Provides the default highlight color which is set when the picker is initialized.
   *
   * @return The default highlight color in hex format.
   */
  @Override
  protected String getDefaultColor() {
    return "#FF9800";
  }
}
