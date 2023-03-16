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

import elemental2.dom.HTMLButtonElement;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

public class RemoveButton extends BaseDominoElement<HTMLButtonElement, RemoveButton> {

  private DominoElement<HTMLButtonElement> button;

  public static RemoveButton create() {
    return new RemoveButton();
  }

  public RemoveButton() {
    button =
        button()
            .addCss(GenericCss.dui_close)
            .appendChild(span().textContent("×"));
    init(this);
  }

  @Override
  public HTMLButtonElement element() {
    return button.element();
  }
}
