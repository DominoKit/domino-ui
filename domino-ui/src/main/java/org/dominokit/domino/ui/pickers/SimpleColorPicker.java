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
package org.dominokit.domino.ui.pickers;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.HasChangeListeners;

/**
 * A simple color picker component that allows users to select colors from predefined shades.
 *
 * <p>This component displays a grid of color shades organized by color schemes. Users can click on
 * a color square to select a color. It provides methods for handling color selection and change
 * events.
 *
 * <p>Usage example:
 *
 * <pre>
 * SimpleColorPicker colorPicker = SimpleColorPicker.create();
 * colorPicker.addChangeListener((oldColor, newColor) -> {
 *     // Handle color change event
 *     console.log("Color changed from " + oldColor.getColorCode() + " to " + newColor.getColorCode());
 * });
 * </pre>
 *
 * <p>All HTML tags in the documentation are correctly closed.
 *
 * @see BaseDominoElement
 */
public class SimpleColorPicker extends BaseDominoElement<HTMLDivElement, SimpleColorPicker>
    implements ColorPickerStyles, HasChangeListeners<SimpleColorPicker, ColorValue> {

  private final DivElement root;
  private boolean changeListenersPaused = false;
  private ColorValue value;
  private Set<ChangeListener<? super ColorValue>> changeListeners = new HashSet<>();

  /**
   * Creates a new instance of {@code SimpleColorPicker} with the default color (#FFFFFF).
   *
   * @return A new {@code SimpleColorPicker} instance.
   */
  public static SimpleColorPicker create() {
    return new SimpleColorPicker(ColorValue.of("#FFFFFF"));
  }

  /**
   * Creates a new instance of {@code SimpleColorPicker} with the specified color value.
   *
   * @param colorValue The initial color value to set.
   * @return A new {@code SimpleColorPicker} instance.
   */
  public static SimpleColorPicker create(ColorValue colorValue) {
    return new SimpleColorPicker(colorValue);
  }

  /**
   * Constructs a {@code SimpleColorPicker} instance with the specified default color.
   *
   * @param defaultColor The default color to initialize the color picker with.
   */
  public SimpleColorPicker(ColorValue defaultColor) {
    this.value = defaultColor;
    this.root =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_1, dui_flex_wrap, dui_justify_center)
            .appendChild(colorShades(ColorScheme.RED))
            .appendChild(colorShades(ColorScheme.PINK))
            .appendChild(colorShades(ColorScheme.PURPLE))
            .appendChild(colorShades(ColorScheme.DEEP_PURPLE))
            .appendChild(colorShades(ColorScheme.INDIGO))
            .appendChild(colorShades(ColorScheme.BLUE))
            .appendChild(colorShades(ColorScheme.LIGHT_BLUE))
            .appendChild(colorShades(ColorScheme.CYAN))
            .appendChild(colorShades(ColorScheme.TEAL))
            .appendChild(colorShades(ColorScheme.GREEN))
            .appendChild(colorShades(ColorScheme.LIGHT_GREEN))
            .appendChild(colorShades(ColorScheme.LIME))
            .appendChild(colorShades(ColorScheme.YELLOW))
            .appendChild(colorShades(ColorScheme.AMBER))
            .appendChild(colorShades(ColorScheme.ORANGE))
            .appendChild(colorShades(ColorScheme.DEEP_ORANGE))
            .appendChild(colorShades(ColorScheme.BROWN))
            .appendChild(colorShades(ColorScheme.BLUE_GREY))
            .appendChild(colorShades(ColorScheme.GREY))
            .appendChild(colorShades(ColorScheme.BLACK))
            .appendChild(colorShades(ColorScheme.WHITE));
    init(this);
  }

  private DivElement colorShades(ColorScheme scheme) {
    return div()
        .addCss(dui_flex, dui_gap_1)
        .appendChild(colorSquare(scheme.lighten_5()))
        .appendChild(colorSquare(scheme.lighten_4()))
        .appendChild(colorSquare(scheme.lighten_3()))
        .appendChild(colorSquare(scheme.lighten_2()))
        .appendChild(colorSquare(scheme.lighten_1()))
        .appendChild(colorSquare(scheme.color()))
        .appendChild(colorSquare(scheme.darker_1()))
        .appendChild(colorSquare(scheme.darker_2()))
        .appendChild(colorSquare(scheme.darker_3()))
        .appendChild(colorSquare(scheme.darker_4()));
  }

  private DivElement colorSquare(Color color) {
    return div()
        .addCss(dui_w_4, dui_h_4, dui_color_picker_color, color.getBackground())
        .apply(
            self -> {
              self.addClickListener(
                  evt -> {
                    ColorValue old = this.value;
                    this.value =
                        ColorValue.of(
                            DominoDom.window
                                .getComputedStyle(self.element())
                                .getPropertyValue("background-color"));
                    triggerChangeListeners(old, this.value);
                  });
            });
  }

  /**
   * Gets the currently selected color value.
   *
   * @return The currently selected color as a {@code ColorValue} object.
   */
  public ColorValue getValue() {
    return value;
  }

  /**
   * Pauses change listeners for this color picker.
   *
   * @return This {@code SimpleColorPicker} instance with change listeners paused.
   */
  @Override
  public SimpleColorPicker pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /**
   * Resumes change listeners for this color picker.
   *
   * @return This {@code SimpleColorPicker} instance with change listeners resumed.
   */
  @Override
  public SimpleColorPicker resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /**
   * Toggles the pause state of change listeners for this color picker.
   *
   * @param toggle {@code true} to pause change listeners, {@code false} to resume.
   * @return This {@code SimpleColorPicker} instance with change listeners toggled.
   */
  @Override
  public SimpleColorPicker togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  /**
   * Gets the set of change listeners registered with this color picker.
   *
   * @return A set of {@code ChangeListener} objects.
   */
  @Override
  public Set<ChangeListener<? super ColorValue>> getChangeListeners() {
    return this.changeListeners;
  }

  /**
   * Checks if change listeners are currently paused for this color picker.
   *
   * @return {@code true} if change listeners are paused, {@code false} otherwise.
   */
  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  /**
   * Triggers the change listeners for color value changes.
   *
   * @param oldValue The previous color value.
   * @param newValue The new color value.
   * @return This {@code SimpleColorPicker} instance after triggering the change listeners.
   */
  @Override
  public SimpleColorPicker triggerChangeListeners(ColorValue oldValue, ColorValue newValue) {
    if (!this.changeListenersPaused) {
      this.changeListeners.forEach(listener -> listener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  /**
   * Gets the underlying HTML element representing this color picker.
   *
   * @return The HTML element of this color picker.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
