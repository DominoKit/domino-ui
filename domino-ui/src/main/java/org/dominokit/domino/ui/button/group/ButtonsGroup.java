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
 * a component to group a set of buttons and align them horizontally or vertically, by default buttons will be aligned horizontally.
 */
public class ButtonsGroup extends BaseDominoElement<HTMLElement, ButtonsGroup> {

  private DivElement groupElement;

  /**
   * Creates an empty ButtonsGroup
   */
  public ButtonsGroup() {
    groupElement = div().addCss(dui_button_group).setAttribute("role", "group");
    init(this);
  }

  /**
   * Creates a ButtonsGroup that holds the provided buttons
   *
   * @param buttons The set of {@link org.dominokit.domino.ui.button.IsButton} components to be appended to the ButtonsGroup
   */
  public ButtonsGroup(IsButton<?>... buttons) {
    this();
    appendChild(buttons);
  }

  /**
   * Factory method to create an empty ButtonsGroup
   *
   * @return An empty {@link org.dominokit.domino.ui.button.group.ButtonsGroup}.
   */
  public static ButtonsGroup create() {
    return new ButtonsGroup();
  }

  /**
   * Factory method to create a ButtonsGroup that holds the provided buttons
   *
   * @param buttons The set of {@link org.dominokit.domino.ui.button.IsButton} components to be appended to the ButtonsGroup
   * @return A {@link org.dominokit.domino.ui.button.group.ButtonsGroup}
   */
  public static ButtonsGroup create(IsButton<?>... buttons) {
    return new ButtonsGroup(buttons);
  }

  /**
   * Appends the provided button to the ButtonsGroup
   *
   * @param buttons a {@link org.dominokit.domino.ui.button.IsButton} to be appended
   * @return same ButtonsGroup instance
   */
  public ButtonsGroup appendChild(IsButton<?>... buttons) {
    Arrays.stream(buttons).forEach(btn -> appendChild(btn.asButton()));
    return this;
  }

  /** @hidden {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return groupElement.element();
  }

  /**
   * Aligns the buttons within this ButtonsGroup instance vertically if the provided flag is true, otherwise revert to default alignment -Horizontally-.
   *
   * @param vertical a boolean, <b>true</b> to align the buttons vertically, <b>false</b> revert to horizontal default alignment
   * @return same ButtonsGroup instance
   */
  public ButtonsGroup setVertical(boolean vertical) {
    addCss(BooleanCssClass.of(dui_vertical, vertical));
    return this;
  }

  /**
   * Shortcut method for <b>setVertical(true)</b>
   *
   * @return same ButtonsGroup instance
   */
  public ButtonsGroup vertical() {
    return addCss(dui_vertical);
  }

  /**
   * Remove the vertical alignment and switch to the horizontal default alignment
   * this is same as calling <b>setVertical(false)</b>
   *
   * @return same ButtonsGroup instance
   */
  public ButtonsGroup horizontal() {
    dui_vertical.remove(this.element());
    return this;
  }
}
