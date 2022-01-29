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
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.Elements;

/**
 * a component for a toolbar that has many buttons
 *
 * <p>This class is used to group buttons in a set of groups to form a toolbar
 *
 * <pre>
 *         ButtonsToolbar.create()
 *              .addGroup(
 *                  ButtonsGroup.create()
 *                      .appendChild(Button.createDefault("1"))
 *                      .appendChild(Button.createDefault("2"))
 *                      .appendChild(Button.createDefault("3")))
 *              .addGroup(
 *                  ButtonsGroup.create()
 *                      .appendChild(Button.createDefault("4"))
 *                      .appendChild(Button.createDefault("5"))
 *                      .appendChild(Button.createDefault("6")))
 *              .addGroup(
 *                  ButtonsGroup.create()
 *                      .appendChild(Button.createDefault("7"))
 *                    );
 *     </pre>
 */
public class ButtonsToolbar extends BaseDominoElement<HTMLElement, ButtonsToolbar> {

  private HTMLElement toolbarElement =
      DominoElement.of(Elements.div())
          .css(ButtonStyles.BUTTON_TOOLBAR)
          .attr("role", "toolbar")
          .element();

  /** default constructor */
  public ButtonsToolbar() {
    init(this);
  }

  /** @return a new ButtonsToolbar instance */
  public static ButtonsToolbar create() {
    return new ButtonsToolbar();
  }

  /**
   * Adds a a ButtonsGroup to the toolbar
   *
   * @param group {@link ButtonsGroup}
   * @return new ButtonsToolbar instance
   */
  public ButtonsToolbar addGroup(ButtonsGroup group) {
    toolbarElement.appendChild(group.element());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return toolbarElement;
  }
}
