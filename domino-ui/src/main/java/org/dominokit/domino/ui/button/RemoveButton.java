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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLButtonElement;
import org.dominokit.domino.ui.elements.ButtonElement;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A special button class that used to create a button with a remove button style same the remove
 * buttons use in {@link org.dominokit.domino.ui.badges.Badge} and {@link
 * org.dominokit.domino.ui.chips.Chip}
 *
 * @see BaseDominoElement
 */
public class RemoveButton extends BaseDominoElement<HTMLButtonElement, RemoveButton> {

  private ButtonElement button;

  /**
   * Creates a RemoveButton with the required css classes.
   *
   * @return a {@link org.dominokit.domino.ui.button.RemoveButton} object
   */
  public static RemoveButton create() {
    return new RemoveButton();
  }

  /** Constructor for RemoveButton. */
  public RemoveButton() {
    button =
        button()
            .addCss(GenericCss.dui_close)
            .appendChild(span().addCss(dui_close_char).textContent("×"));
    init(this);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLButtonElement element() {
    return button.element();
  }
}
