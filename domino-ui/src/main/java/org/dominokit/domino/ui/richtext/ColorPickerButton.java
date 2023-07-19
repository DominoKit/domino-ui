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

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.pickers.ColorPickerStyles;
import org.dominokit.domino.ui.pickers.ColorValue;
import org.dominokit.domino.ui.pickers.SimpleColorPicker;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

public abstract class ColorPickerButton extends BaseDominoElement<HTMLElement, ColorPickerButton>
    implements ColorPickerStyles {

  private final ButtonsGroup root;
  private final SimpleColorPicker colorPicker;
  private Button mainButton;

  public ColorPickerButton() {
    this.root =
        ButtonsGroup.create(
            mainButton = makeIndicatorButton(),
            DropdownButton.create(
                Button.create(Icons.chevron_down()),
                Menu.<String>create()
                    .addCss(dui_color_picker)
                    .appendChild(
                        CustomMenuItem.<String>create()
                            .appendChild(
                                colorPicker =
                                    SimpleColorPicker.create(ColorValue.of(getDefaultColor()))
                                        .addChangeListener(
                                            (oldValue, newValue) -> {
                                              onColorSelected(newValue);
                                            })))
                    .setDropDirection(DropDirection.BOTTOM_LEFT)));
    init(this);
  }

  protected abstract void onColorSelected(ColorValue newValue);

  public abstract Button makeIndicatorButton();

  protected abstract String getDefaultColor();

  public ColorPickerButton withColorPicker(
      ChildHandler<ColorPickerButton, SimpleColorPicker> handler) {
    handler.apply(this, colorPicker);
    return this;
  }

  @Override
  public Element getClickableElement() {
    return mainButton.element();
  }

  public SimpleColorPicker getColorPicker() {
    return colorPicker;
  }

  @Override
  public HTMLElement element() {
    return root.element();
  }
}
