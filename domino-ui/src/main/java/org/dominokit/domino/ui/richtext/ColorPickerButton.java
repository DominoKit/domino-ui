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

/**
 * An abstract button component designed to allow color selection using {@link SimpleColorPicker}.
 *
 * <p>This component provides a UI button with a dropdown color picker allowing users to select a
 * color. It can be extended to further customize the behavior and appearance of the color button.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * BackgroundColorPicker pickerButton = BackgroundColorPicker.create();
 * pickerButton.addChangeListener(color -> {
 *     // do something with the selected color
 * });
 * </pre>
 *
 * @see BaseDominoElement
 */
public abstract class ColorPickerButton extends BaseDominoElement<HTMLElement, ColorPickerButton>
    implements ColorPickerStyles {

  private final ButtonsGroup root;
  private final SimpleColorPicker colorPicker;
  private Button mainButton;

  /** Initializes the ColorPickerButton with its UI components. */
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

  /**
   * Invoked when a color is selected from the picker.
   *
   * @param newValue The newly selected color.
   */
  protected abstract void onColorSelected(ColorValue newValue);

  /**
   * Create the button that will display the currently selected color.
   *
   * @return The button with a visual representation of the current color.
   */
  public abstract Button makeIndicatorButton();

  /**
   * Provides the default color for the color picker.
   *
   * @return The default color in hex format.
   */
  protected abstract String getDefaultColor();

  /**
   * Allows further customization of the internal {@link SimpleColorPicker}.
   *
   * @param handler A handler to apply customizations to the internal color picker.
   * @return The current {@link ColorPickerButton} instance.
   */
  public ColorPickerButton withColorPicker(
      ChildHandler<ColorPickerButton, SimpleColorPicker> handler) {
    handler.apply(this, colorPicker);
    return this;
  }

  /**
   * Retrieves the clickable element of the button.
   *
   * @return The element that is clickable.
   */
  @Override
  public Element getClickableElement() {
    return mainButton.element();
  }

  /**
   * Retrieves the internal {@link SimpleColorPicker} instance.
   *
   * @return The current {@link SimpleColorPicker} instance.
   */
  public SimpleColorPicker getColorPicker() {
    return colorPicker;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the root element of the button.
   * @return The root {@link HTMLElement} of the button.
   */
  @Override
  public HTMLElement element() {
    return root.element();
  }
}
