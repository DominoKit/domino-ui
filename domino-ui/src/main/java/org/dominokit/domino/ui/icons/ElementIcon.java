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

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.SwapCssClass;

/** Url icon implementation */
public class ElementIcon extends Icon<ElementIcon> implements CanChangeIcon<ElementIcon> {

  private final IsElement<? extends HTMLElement> element;

  private ElementIcon(IsElement<? extends HTMLElement> element, String name) {
    this(element, () -> name);
  }

  private ElementIcon(IsElement<? extends HTMLElement> element, CssClass name) {
    this.element = element;
    this.name = SwapCssClass.of(name);
    this.icon = elementOf(element.element());
    init(this);
  }

  /**
   * Creates an icon with a specific {@code url} and a name
   *
   * @param element the element to use as an icon
   * @param name the name of the icon
   * @return new instance
   */
  public static ElementIcon create(IsElement<? extends HTMLElement> element, String name) {
    return new ElementIcon(element, name);
  }

  /** {@inheritDoc} */
  @Override
  public ElementIcon copy() {
    return new ElementIcon(element, name);
  }

  /** {@inheritDoc} */
  @Override
  public ElementIcon changeTo(ElementIcon icon) {
    removeCss(getName());
    addCss(icon.getName());
    return null;
  }
}
