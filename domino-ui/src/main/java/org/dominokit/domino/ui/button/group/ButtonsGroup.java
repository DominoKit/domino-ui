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
package org.dominokit.domino.ui.button.group;

import static org.dominokit.domino.ui.button.ButtonStyles.*;

import elemental2.dom.HTMLElement;
import java.util.Arrays;
import org.dominokit.domino.ui.button.IsButton;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * a component to group a set of buttons.
 *
 * <p>This component wraps a set of different Buttons into one group the grouped buttons can be
 * aligned horizontally or vertically and the group can apply some properties to all grouped button
 */
public class ButtonsGroup extends BaseDominoElement<HTMLElement, ButtonsGroup> {

  private DivElement groupElement;

  /** default constructor */
  public ButtonsGroup() {
    groupElement = div().addCss(dui_button_group).setAttribute("role", "group");
    init(this);
  }

  /**
   * default constructor
   *
   * @param buttons a {@link org.dominokit.domino.ui.button.IsButton} object
   */
  public ButtonsGroup(IsButton<?>... buttons) {
    this();
    appendChild(buttons);
  }

  /** @return a new ButtonsGroup instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.button.group.ButtonsGroup} object
   */
  public static ButtonsGroup create() {
    return new ButtonsGroup();
  }

  /** @return a new ButtonsGroup instance */
  /**
   * create.
   *
   * @param buttons a {@link org.dominokit.domino.ui.button.IsButton} object
   * @return a {@link org.dominokit.domino.ui.button.group.ButtonsGroup} object
   */
  public static ButtonsGroup create(IsButton<?>... buttons) {
    return new ButtonsGroup(buttons);
  }

  /**
   * appendChild.
   *
   * @param buttons a {@link org.dominokit.domino.ui.button.IsButton} object
   * @return a {@link org.dominokit.domino.ui.button.group.ButtonsGroup} object
   */
  public ButtonsGroup appendChild(IsButton<?>... buttons) {
    Arrays.stream(buttons).forEach(btn -> appendChild(btn.asButton()));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return groupElement.element();
  }

  /**
   * setVertical.
   *
   * @param vertical a boolean
   * @return a {@link org.dominokit.domino.ui.button.group.ButtonsGroup} object
   */
  public ButtonsGroup setVertical(boolean vertical) {
    addCss(BooleanCssClass.of(dui_vertical, vertical));
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * @return a {@link org.dominokit.domino.ui.button.group.ButtonsGroup} object
   */
  public ButtonsGroup vertical() {
    return addCss(dui_vertical);
  }

  /**
   * {@inheritDoc}
   *
   * @return a {@link org.dominokit.domino.ui.button.group.ButtonsGroup} object
   */
  public ButtonsGroup horizontal() {
    dui_vertical.remove(this.element());
    return this;
  }
}
