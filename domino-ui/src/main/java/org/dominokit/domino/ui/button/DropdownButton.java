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
package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.dropdown.DropDownPosition;
import org.dominokit.domino.ui.dropdown.DropdownAction;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.style.Styles;

/**
 * A Button with dropdown menu component
 *
 * <p>This Button component will open a dropdown menu when clicked by default
 *
 * <pre>
 *         DropdownButton.createDefault("TOP")
 *                     .appendChild(DropdownAction.create("Action"))
 *                     .appendChild(DropdownAction.create("Another action"))
 *                     .setPosition(DropDownPosition.TOP)
 *     </pre>
 */
public class DropdownButton extends BaseButton<DropdownButton> {

  private Icon caretIcon = Icons.ALL.keyboard_arrow_down();
  private ButtonsGroup groupElement = ButtonsGroup.create();
  private DropDownMenu dropDownMenu;

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType}
   *
   * @param text String, the button text
   * @param type {@link StyleType}
   */
  public DropdownButton(String text, StyleType type) {
    super(text, type);
    initDropDown();
  }

  /**
   * Creates a Dropdown button with a text and a custom background color
   *
   * @param text String, the button text
   * @param background {@link Color}
   */
  public DropdownButton(String text, Color background) {
    super(text, background);
    initDropDown();
  }

  /**
   * Creates a Dropdown button with a text
   *
   * @param text String, the button text
   */
  public DropdownButton(String text) {
    super(text);
    initDropDown();
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @param type {@link StyleType}
   */
  public DropdownButton(BaseIcon<?> icon, StyleType type) {
    super(icon, type);
    initDropDown();
  }

  /**
   * Creates a Dropdown button with an icon
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public DropdownButton(BaseIcon<?> icon) {
    super(icon);
    initDropDown();
  }

  /**
   * Creates a Dropdown button with a text
   *
   * @param text String, the button text
   */
  public static DropdownButton create(String text) {
    return new DropdownButton(text);
  }

  /**
   * Creates a Dropdown button with a text and a custom background color
   *
   * @param text String, the button text
   * @param background {@link Color}
   */
  public static DropdownButton create(String text, Color background) {
    return new DropdownButton(text, background);
  }

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType}
   *
   * @param text String, the button text
   * @param type {@link StyleType}
   */
  public static DropdownButton create(String text, StyleType type) {
    return new DropdownButton(text, type);
  }

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType#DEFAULT}
   *
   * @param text String, the button text
   */
  public static DropdownButton createDefault(String text) {
    return create(text, StyleType.DEFAULT);
  }

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType#PRIMARY}
   *
   * @param text String, the button text
   */
  public static DropdownButton createPrimary(String text) {
    return create(text, StyleType.PRIMARY);
  }

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType#SUCCESS}
   *
   * @param text String, the button text
   */
  public static DropdownButton createSuccess(String text) {
    return create(text, StyleType.SUCCESS);
  }

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType#INFO}
   *
   * @param text String, the button text
   */
  public static DropdownButton createInfo(String text) {
    return create(text, StyleType.INFO);
  }

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType#WARNING}
   *
   * @param text String, the button text
   */
  public static DropdownButton createWarning(String text) {
    return create(text, StyleType.WARNING);
  }

  /**
   * Creates a Dropdown button with a text and apply a {@link StyleType#DANGER}
   *
   * @param text String, the button text
   */
  public static DropdownButton createDanger(String text) {
    return create(text, StyleType.DANGER);
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType}
   *
   * @param icon {@link BaseIcon}, the button icon
   * @param type {@link StyleType}
   */
  public static DropdownButton create(BaseIcon<?> icon, StyleType type) {
    return new DropdownButton(icon, type);
  }

  /**
   * Creates a Dropdown button with an icon
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public static DropdownButton create(BaseIcon<?> icon) {
    return new DropdownButton(icon);
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType#DEFAULT}
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public static DropdownButton createDefault(BaseIcon<?> icon) {
    return create(icon, StyleType.DEFAULT);
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType#PRIMARY}
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public static DropdownButton createPrimary(BaseIcon<?> icon) {
    return create(icon, StyleType.PRIMARY);
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType#SUCCESS}
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public static DropdownButton createSuccess(BaseIcon<?> icon) {
    return create(icon, StyleType.SUCCESS);
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType#INFO}
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public static DropdownButton createInfo(BaseIcon<?> icon) {
    return create(icon, StyleType.INFO);
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType#WARNING}
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public static DropdownButton createWarning(BaseIcon<?> icon) {
    return create(icon, StyleType.WARNING);
  }

  /**
   * Creates a Dropdown button with an icon and apply a {@link StyleType#DANGER}
   *
   * @param icon {@link BaseIcon}, the button icon
   */
  public static DropdownButton createDanger(BaseIcon<?> icon) {
    return create(icon, StyleType.DANGER);
  }

  private void initDropDown() {
    buttonElement.style().add(ButtonStyles.BUTTON_DROPDOWN);
    dropDownMenu = DropDownMenu.create(groupElement);
    groupElement.appendChild(asDropDown());
    caretIcon.addCss(Styles.pull_right);
    buttonElement.appendChild(caretIcon);
    init(this);
    elevate(Elevation.LEVEL_1);
  }

  private HTMLElement asDropDown() {
    buttonElement.style().add(ButtonStyles.DROPDOWN_TOGGLE);
    buttonElement.setAttribute("data-toggle", "dropdown");
    buttonElement.setAttribute("aria-haspopup", true);
    buttonElement.setAttribute("aria-expanded", true);
    buttonElement.setAttribute("type", "button");
    addClickListener(
        evt -> {
          DropDownMenu.closeAllMenus();
          open();
          evt.stopPropagation();
        });
    return buttonElement.element();
  }

  private void open() {
    dropDownMenu.open();
  }

  /**
   * Add a DropdownAction to the dropdown button menu
   *
   * @param action {@link DropdownAction}
   * @return same dropdown instance
   */
  public DropdownButton appendChild(DropdownAction<?> action) {
    dropDownMenu.addAction(action);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return groupElement.element();
  }

  /**
   * Adds a separator item to the dropdown menu
   *
   * @return same dropdown instance
   */
  public DropdownButton separator() {
    dropDownMenu.separator();
    return this;
  }

  /**
   * hides the dropdown caret arrow
   *
   * @return same dropdown instance
   */
  public DropdownButton hideCaret() {
    caretIcon.hide();
    return this;
  }

  /**
   * show the dropdown caret arrow
   *
   * @return same dropdown instance
   */
  public DropdownButton showCaret() {
    caretIcon.show();
    return this;
  }

  /**
   * changes the dropdown to look like a link
   *
   * @return same dropdown instance
   */
  public DropdownButton linkify() {
    groupElement.style().add(ButtonStyles.LINK);
    super.linkify();
    return this;
  }

  /**
   * revert the linkify effect
   *
   * @return same dropdown instance
   */
  public DropdownButton delinkify() {
    groupElement.style().remove(ButtonStyles.LINK);
    super.deLinkify();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DropdownButton bordered() {
    groupElement.addCss(ButtonStyles.BTN_GROUP_BORDERED);
    return super.bordered();
  }

  /** {@inheritDoc} */
  @Override
  public DropdownButton nonBordered() {
    groupElement.removeCss(ButtonStyles.BTN_GROUP_BORDERED);
    return super.nonBordered();
  }

  /**
   * set the direction and the position of the dropdown button menu when it is open
   *
   * @param position {@link DropDownPosition}
   * @return same as dropdown instance
   */
  public DropdownButton setPosition(DropDownPosition position) {
    dropDownMenu.setPosition(position);
    return this;
  }

  /** @return the caret {@link Icon} */
  public Icon getCaretIcon() {
    return caretIcon;
  }

  /** @return the DropdownButton {@link DropDownMenu} */
  public DropDownMenu getDropDownMenu() {
    return dropDownMenu;
  }
}
