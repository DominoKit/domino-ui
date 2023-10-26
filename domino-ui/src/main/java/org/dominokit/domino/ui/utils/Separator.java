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

package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.elements.LIElement;

/**
 * The {@code Separator} class represents a separator element that can be used to visually separate
 * items in a list or menu. It extends the {@link BaseDominoElement} class and provides methods for
 * creating and manipulating separator elements.
 *
 * <p>Separators are commonly used to enhance the visual organization of lists or menus by adding
 * visible lines or other decorative elements between items.
 *
 * @see BaseDominoElement
 * @see HTMLLIElement
 * @see LIElement
 */
public class Separator extends BaseDominoElement<HTMLLIElement, Separator> {

  private LIElement element;

  /**
   * Creates a new {@code Separator} instance.
   *
   * @return A new {@code Separator} instance.
   */
  public static Separator create() {
    return new Separator();
  }

  /**
   * Creates a new {@code Separator} instance.
   *
   * <p>This constructor initializes the separator element and adds the necessary CSS class to style
   * it.
   */
  public Separator() {
    element = li().addCss(dui_separator);
    init(this);
  }

  /**
   * Retrieves the underlying HTML list item (LI) element associated with this separator.
   *
   * @return The HTML list item (LI) element.
   */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }
}
