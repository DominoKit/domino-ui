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
import static org.dominokit.domino.ui.utils.Domino.body;
import static org.dominokit.domino.ui.utils.Domino.span;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.icons.ElementIcon;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.pickers.ColorPickerStyles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoDom;

/**
 * A UI component that allows users to pick a font from a dropdown list.
 *
 * <p>The FontPicker provides a button displaying the current font, and a dropdown menu with a list
 * of available fonts. When a font is selected, it is reflected on the button.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * FontPicker fontPicker = FontPicker.create();
 * fontPicker.addChangeListener(font -> {
 *     // handle font change logic
 * });
 * </pre>
 *
 * @see BaseDominoElement
 */
public class FontPicker extends BaseDominoElement<HTMLElement, FontPicker>
    implements ColorPickerStyles {

  private final ButtonsGroup root;
  private final Button mainButton;
  private Icon<?> fontIndicator;
  private String fontName;
  private Menu<String> fontsMenu;

  /**
   * Factory method to create a new instance of FontPicker.
   *
   * @return A new instance of FontPicker.
   */
  public static FontPicker create() {
    return new FontPicker();
  }

  /** Initializes the FontPicker with its UI components. */
  public FontPicker() {
    this.root =
        ButtonsGroup.create(
            mainButton =
                Button.create(
                    fontIndicator =
                        ElementIcon.create(
                            span()
                                .textContent(
                                    DominoDom.window
                                        .getComputedStyle(body().element())
                                        .getPropertyValue("font-family")),
                            "fore-color")),
            DropdownButton.create(
                Button.create(Icons.chevron_down()),
                fontsMenu =
                    Menu.<String>create()
                        .appendChild(
                            MenuItem.<String>create("Inter")
                                .withValue("Inter")
                                .setCssProperty("font-family", "Inter"))
                        .appendChild(
                            MenuItem.<String>create("Roboto")
                                .withValue("Roboto")
                                .setCssProperty("font-family", "Roboto"))
                        .appendChild(
                            MenuItem.<String>create("Open sans")
                                .withValue("Open sans")
                                .setCssProperty("font-family", "Open sans"))
                        .addSelectionListener(
                            (source, selection) -> {
                              fontIndicator.textContent(selection.get(0).getValue());
                              this.fontName = selection.get(0).getValue();
                            })
                        .setDropDirection(DropDirection.BOTTOM_LEFT)));
    init(this);
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
   * Allows further customization of the internal {@link Menu} instance.
   *
   * @param handler A handler to apply customizations to the internal menu.
   * @return The current {@link FontPicker} instance.
   */
  public FontPicker withMenu(ChildHandler<FontPicker, Menu<String>> handler) {
    handler.apply(this, fontsMenu);
    return this;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Returns the root element of the FontPicker.
   * @return The root {@link HTMLElement} of the FontPicker.
   */
  @Override
  public HTMLElement element() {
    return root.element();
  }
}
