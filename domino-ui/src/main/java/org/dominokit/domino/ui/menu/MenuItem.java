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
package org.dominokit.domino.ui.menu;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.elements.SpanElement;

/**
 * Represents a menu item that can be added to a menu. Each menu item can have a text and an
 * optional description.
 *
 * @param <V> the type of value associated with this menu item
 */
public class MenuItem<V> extends AbstractMenuItem<V> {

  private SmallElement descriptionElement;
  private SpanElement textElement;

  /**
   * Creates a menu item with the specified text.
   *
   * @param text the text for the menu item
   * @return the created menu item
   */
  public static <V> MenuItem<V> create(String text) {
    return new MenuItem<>(text);
  }

  /**
   * Creates a menu item with the specified text and description.
   *
   * @param text the text for the menu item
   * @param description the description for the menu item
   * @return the created menu item
   */
  public static <V> MenuItem<V> create(String text, String description) {
    return new MenuItem<>(text, description);
  }

  /**
   * Constructs a menu item with the specified text.
   *
   * @param text the text for the menu item
   */
  public MenuItem(String text) {
    if (nonNull(text) && !text.isEmpty()) {
      textElement = span().addCss(dui_menu_item_content).setTextContent(text);
      appendChild(textElement);
    }
  }

  /**
   * Constructs a menu item with the specified text and description.
   *
   * @param text the text for the menu item
   * @param description the description for the menu item
   */
  public MenuItem(String text, String description) {
    this(text);

    if (nonNull(description) && !description.isEmpty()) {
      descriptionElement = small().addCss(dui_menu_item_hint).setTextContent(text);
      appendChild(descriptionElement);
    }
  }

  /**
   * Retrieves the description element of the menu item.
   *
   * @return the description element
   */
  public SmallElement getDescriptionElement() {
    return descriptionElement;
  }

  /**
   * Retrieves the text element of the menu item.
   *
   * @return the text element
   */
  public SpanElement getTextElement() {
    return textElement;
  }

  /**
   * Searches for a given token in the text and description of the menu item.
   *
   * @param token the search token
   * @param caseSensitive indicates if the search should be case-sensitive
   * @return true if the menu item contains the token, false otherwise
   */
  @Override
  public boolean onSearch(String token, boolean caseSensitive) {
    if (isNull(token) || token.isEmpty()) {
      this.show();
      return true;
    }
    if (searchable && containsToken(token, caseSensitive)) {
      if (this.isHidden()) {
        this.show();
      }
      return true;
    }
    if (!this.isHidden()) {
      this.hide();
    }
    return false;
  }

  /**
   * Determines if the menu item's text or description contains the specified token.
   *
   * @param token the search token
   * @param caseSensitive indicates if the search should be case-sensitive
   * @return true if the menu item contains the token, false otherwise
   */
  private boolean containsToken(String token, boolean caseSensitive) {
    String textContent =
        Arrays.asList(Optional.ofNullable(textElement), Optional.ofNullable(descriptionElement))
            .stream()
            .filter(Optional::isPresent)
            .map(element -> element.get().getTextContent())
            .collect(Collectors.joining(" "));
    if (isNull(textContent) || textContent.isEmpty()) {
      return false;
    }
    if (caseSensitive) {
      return textContent.contains(token);
    }
    return textContent.toLowerCase().contains(token.toLowerCase());
  }
}
