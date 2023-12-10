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
import org.dominokit.domino.ui.icons.ElementIcon;
import org.dominokit.domino.ui.pickers.ColorValue;

/**
 * A specialized {@link ColorPickerButton} for selecting background colors.
 *
 * <p>Provides a UI component to select a color, primarily for setting the background color of an
 * element within the rich text editor.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>{@code
 * BackgroundColorPicker picker = BackgroundColorPicker.create();
 * picker.addSelectionHandler(color -> {
 *     // do something with the selected color
 * });
 * }</pre>
 */
public class BackgroundColorPicker extends ColorPickerButton {

  private ElementIcon colorIndicator;

  /**
   * Creates a new instance of the {@link BackgroundColorPicker}.
   *
   * @return A newly created instance.
   */
  public static BackgroundColorPicker create() {
    return new BackgroundColorPicker();
  }

  /**
   * Invoked when a color is selected from the picker.
   *
   * @param newValue The newly selected color.
   */
  @Override
  protected void onColorSelected(ColorValue newValue) {
    colorIndicator.setBackgroundColor(newValue.getHex());
  }

  /**
   * Creates the button with a color indicator for the selected color.
   *
   * @return The created button with color indicator.
   */
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

  /**
   * Provides the default color for the color picker.
   *
   * @return The default color in hex format.
   */
  @Override
  protected String getDefaultColor() {
    return "#FFFFFF";
  }
}
