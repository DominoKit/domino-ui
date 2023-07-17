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

import elemental2.dom.HTMLDivElement;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.HasChangeListeners;

public class SimpleColorPicker extends BaseDominoElement<HTMLDivElement, SimpleColorPicker>
    implements ColorPickerStyles, HasChangeListeners<SimpleColorPicker, ColorValue> {

  private final DivElement root;
  private boolean changeListenersPaused = false;
  private ColorValue value;
  private Set<ChangeListener<? super ColorValue>> changeListeners = new HashSet<>();

  public static SimpleColorPicker create() {
    return new SimpleColorPicker(ColorValue.of("#FFFFFF"));
  }

  public static SimpleColorPicker create(ColorValue colorValue) {
    return new SimpleColorPicker(colorValue);
  }

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

  public ColorValue getValue() {
    return value;
  }

  @Override
  public SimpleColorPicker pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  @Override
  public SimpleColorPicker resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  @Override
  public SimpleColorPicker togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  @Override
  public Set<ChangeListener<? super ColorValue>> getChangeListeners() {
    return this.changeListeners;
  }

  @Override
  public boolean isChangeListenersPaused() {
    return this.changeListenersPaused;
  }

  @Override
  public SimpleColorPicker triggerChangeListeners(ColorValue oldValue, ColorValue newValue) {
    if (!this.changeListenersPaused) {
      this.changeListeners.forEach(listener -> listener.onValueChanged(oldValue, newValue));
    }
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
