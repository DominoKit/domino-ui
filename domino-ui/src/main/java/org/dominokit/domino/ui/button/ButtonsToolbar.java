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

import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * a component for a toolbar that has many buttons
 *
 * <p>This class is used to group buttons in a set of sub-groups to form a toolbar
 *
 * @see BaseDominoElement
 */
public class ButtonsToolbar extends BaseDominoElement<HTMLDivElement, ButtonsToolbar> {

  private DivElement toolbarElement;

  /** Creates and empty ButtonsToolbar */
  public ButtonsToolbar() {
    toolbarElement = div().addCss(ButtonStyles.dui_button_toolbar).setAttribute("role", "toolbar");
    init(this);
  }

  /**
   * Factory method to create an empty ButtonsToolbar.
   *
   * @return a new ButtonsToolbar instance
   */
  public static ButtonsToolbar create() {
    return new ButtonsToolbar();
  }

  /**
   * Adds a ButtonsGroup to the toolbar
   *
   * @param group {@link org.dominokit.domino.ui.button.group.ButtonsGroup}
   * @return same ButtonsToolbar instance
   */
  public ButtonsToolbar appendChild(ButtonsGroup group) {
    toolbarElement.appendChild(group.element());
    return this;
  }

  /**
   * Adds provided ButtonsGroups to the toolbar
   *
   * @param groups {@link org.dominokit.domino.ui.button.group.ButtonsGroup}
   * @return same ButtonsToolbar instance
   */
  public ButtonsToolbar appendChild(ButtonsGroup... groups) {
    Arrays.stream(groups).forEach(this::appendChild);
    return this;
  }
  /**
   * Adds provided buttons to the toolbar
   *
   * @param buttons {@link IsButton<?>}
   * @return same ButtonsToolbar instance
   */
  public ButtonsToolbar appendChild(IsButton<?>... buttons) {
    Arrays.stream(buttons).forEach(this::appendChild);
    return this;
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return toolbarElement.element();
  }
}
