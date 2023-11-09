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

/**
 * The {@code ElementIcon} class represents an icon that wraps an existing {@link IsElement}
 * instance.
 */
public class ElementIcon extends Icon<ElementIcon> implements CanChangeIcon<ElementIcon> {

  private final IsElement<? extends HTMLElement> element;

  /**
   * Creates a new {@code ElementIcon} instance with the provided {@link IsElement} and icon name.
   *
   * @param element The {@link IsElement} to wrap as an icon.
   * @param name The CSS class name representing the icon.
   */
  private ElementIcon(IsElement<? extends HTMLElement> element, String name) {
    this(element, () -> name);
  }

  /**
   * Creates a new {@code ElementIcon} instance with the provided {@link IsElement} and icon CSS
   * class.
   *
   * @param element The {@link IsElement} to wrap as an icon.
   * @param name The {@link CssClass} representing the icon.
   */
  private ElementIcon(IsElement<? extends HTMLElement> element, CssClass name) {
    this.element = element;
    this.name = SwapCssClass.of(name);
    this.icon = elementOf(element.element());
    init(this);
  }

  /**
   * Creates a new {@code ElementIcon} instance with the provided {@link IsElement} and icon name.
   *
   * @param element The {@link IsElement} to wrap as an icon.
   * @param name The CSS class name representing the icon.
   * @return A new {@code ElementIcon} instance.
   */
  public static ElementIcon create(IsElement<? extends HTMLElement> element, String name) {
    return new ElementIcon(element, name);
  }

  /**
   * Creates a new {@code ElementIcon} instance that is a copy of this icon.
   *
   * @return A new {@code ElementIcon} instance with the same {@link IsElement} and icon
   *     representation.
   */
  @Override
  public ElementIcon copy() {
    return new ElementIcon(element, name);
  }

  /**
   * Changes the icon representation to the provided {@code icon}.
   *
   * @param icon The {@code ElementIcon} to change to.
   * @return This {@code ElementIcon} instance after changing the icon representation.
   */
  @Override
  public ElementIcon changeTo(ElementIcon icon) {
    removeCss(getName());
    addCss(icon.getName());
    return null;
  }
}
