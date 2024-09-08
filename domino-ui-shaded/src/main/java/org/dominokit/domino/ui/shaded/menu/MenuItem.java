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
package org.dominokit.domino.ui.shaded.menu;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.small;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;

/**
 * An implementation og the {@link AbstractMenuItem} for a menu item that can have a main text and a
 * description {@inheritDoc}
 */
@Deprecated
public class MenuItem<V> extends AbstractMenuItem<V, MenuItem<V>> {

  private DominoElement<HTMLElement> descriptionElement = DominoElement.of(small());
  private DominoElement<HTMLHeadingElement> textElement = DominoElement.of(h(5));

  public static <V> MenuItem<V> create(String text) {
    return new MenuItem<>(text);
  }

  public static <V> MenuItem<V> create(String text, String description) {
    return new MenuItem<>(text, description);
  }

  public MenuItem(String text) {
    this(text, null);
  }

  public MenuItem(String text, String description) {
    css("simple-menu-item");
    if (nonNull(text)) {
      textElement.setTextContent(text);
    }

    if (nonNull(description)) {
      descriptionElement.setTextContent(description);
      textElement.appendChild(descriptionElement);
    }

    appendChild(textElement);
  }

  /** @return The description element */
  public DominoElement<HTMLElement> getDescriptionElement() {
    return descriptionElement;
  }

  /** @return the main text element */
  public DominoElement<HTMLHeadingElement> getTextElement() {
    return textElement;
  }

  /**
   * match the search token with both the text and description of the menu item
   *
   * @param token String search text
   * @param caseSensitive boolean, true if the search is case-sensitive
   * @return boolean, true if the item matches the search
   */
  @Override
  public boolean onSearch(String token, boolean caseSensitive) {
    if (isNull(token) || token.isEmpty()) {
      this.show();
      return true;
    }
    if (containsToken(token, caseSensitive)) {
      if (this.isCollapsed()) {
        this.show();
      }
      return true;
    }
    if (this.isExpanded()) {
      this.hide();
    }
    return false;
  }

  private boolean containsToken(String token, boolean caseSensitive) {
    String textContent = textElement.getTextContent();
    if (isNull(textContent) || textContent.isEmpty()) {
      return false;
    }
    if (caseSensitive) {
      return textContent.contains(token) || descriptionElement.getTextContent().contains(token);
    }
    return textContent.toLowerCase().contains(token.toLowerCase())
        || descriptionElement.getTextContent().toLowerCase().contains(token.toLowerCase());
  }
}
