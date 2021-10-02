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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonStyles;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.Sizable;

/** to be removed */
@Deprecated
public class JustifiedGroup extends BaseDominoElement<HTMLElement, JustifiedGroup>
    implements IsGroup<JustifiedGroup>, Sizable<JustifiedGroup> {

  private ButtonsGroup group = ButtonsGroup.create();

  public static JustifiedGroup create() {
    return new JustifiedGroup();
  }

  private JustifiedGroup() {
    group.addCss(ButtonStyles.JUSTIFIED);
    init(this);
  }

  @Override
  public JustifiedGroup appendChild(Button button) {
    group.appendChild(button);
    return this;
  }

  @Override
  public JustifiedGroup appendChild(DropdownButton dropDown) {
    group.appendChild(dropDown);
    return this;
  }

  @Override
  public JustifiedGroup verticalAlign() {
    group.verticalAlign();
    return this;
  }

  @Override
  public JustifiedGroup horizontalAlign() {
    group.horizontalAlign();
    return this;
  }

  @Override
  public HTMLElement element() {
    return group.element();
  }

  @Override
  public JustifiedGroup large() {
    group.large();
    return this;
  }

  @Override
  public JustifiedGroup medium() {
    group.medium();
    return this;
  }

  @Override
  public JustifiedGroup small() {
    group.small();
    return this;
  }

  @Override
  public JustifiedGroup xSmall() {
    group.xSmall();
    return this;
  }
}
