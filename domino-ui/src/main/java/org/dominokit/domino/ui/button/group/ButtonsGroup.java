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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.ButtonStyles;
import org.dominokit.domino.ui.button.IsButton;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.Arrays;

import static org.dominokit.domino.ui.button.ButtonStyles.*;

/**
 * a component to group a set of buttons.
 *
 * <p>This component wraps a set of different Buttons into one group the grouped buttons can be
 * aligned horizontally or vertically and the group can apply some properties to all grouped button
 *
 * <pre>
 *         ButtonsGroup.create()
 *            .appendChild(Button.createDefault("LEFT"))
 *            .appendChild(Button.createDefault("MIDDLE"))
 *            .appendChild(Button.createDefault("RIGHT"))
 *            .setSize(ButtonSize.LARGE);
 *     </pre>
 */
public class ButtonsGroup extends BaseDominoElement<HTMLElement, ButtonsGroup>
     {

  private DominoElement<HTMLDivElement> groupElement;

  /** default constructor */
  public ButtonsGroup() {
    groupElement  =
    DominoElement.div().addCss(dui_button_group).setAttribute("role", "group");
    init(this);
  }

  /** default constructor */
  public ButtonsGroup(IsButton<?>... buttons) {
    this();
    appendChild(buttons);
  }


  /** @return a new ButtonsGroup instance */
  public static ButtonsGroup create() {
    return new ButtonsGroup();
  }

  /** @return a new ButtonsGroup instance */
  public static ButtonsGroup create(IsButton<?>... buttons) {
    return new ButtonsGroup(buttons);
  }

  public ButtonsGroup appendChild(IsButton<?> button) {
    appendChild(button.asButton().element());
    return this;
  }
  public ButtonsGroup appendChild(IsButton<?>... buttons) {
    Arrays.stream(buttons).forEach(this::appendChild);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return groupElement.element();
  }

  public ButtonsGroup setVertical(boolean vertical){
    addCss(BooleanCssClass.of(dui_vertical, vertical));
    return this;
  }

  /** {@inheritDoc} */
  public ButtonsGroup vertical() {
    return addCss(dui_vertical);
  }

  /** {@inheritDoc} */
  public ButtonsGroup horizontal() {
    dui_vertical.remove(this.element());
    return this;
  }

}
