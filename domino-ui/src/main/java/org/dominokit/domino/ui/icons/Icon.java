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
package org.dominokit.domino.ui.icons;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.i;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** Google material design icons implementation */
public class Icon extends BaseIcon<Icon> {

  private Icon(HTMLElement icon) {
    this.icon = DominoElement.of(icon);
    init(this);
  }

  /**
   * Creates a new Icon
   *
   * @param icon the name of the icon
   * @return new instance
   */
  public static Icon create(String icon) {
    Icon iconElement = new Icon(i().css(IconsStyles.MATERIAL_ICONS).textContent(icon).element());
    iconElement.name = icon;
    return iconElement;
  }

  /** {@inheritDoc} */
  @Override
  public Icon copy() {
    return Icon.create(this.getName()).setColor(this.color);
  }

  /** {@inheritDoc} */
  @Override
  protected Icon doToggle() {
    if (nonNull(toggleName)) {
      if (this.getTextContent().equals(originalName)) {
        this.setTextContent(toggleName);
      } else {
        this.setTextContent(originalName);
      }
    }

    return this;
  }

  /**
   * Sets the size to small
   *
   * @return same instance
   */
  public Icon small() {
    style.add(IconsStyles.SMALL_ICON);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Icon changeTo(BaseIcon<Icon> icon) {
    element().textContent = icon.getName();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return icon.element();
  }
}
