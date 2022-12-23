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
package org.dominokit.domino.ui.forms;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.MenuStyles.*;

import elemental2.dom.HTMLElement;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.NullLazyChild;
import org.jboss.elemento.IsElement;

public class SelectOption<V> extends Option<V> {

  private String text;
  private DominoElement<HTMLElement> descriptionElement;
  private DominoElement<HTMLElement> textElement;

  private DominoElement<HTMLElement> valueElement;
  private LazyChild<DominoElement<HTMLElement>> lazyValueElement = NullLazyChild.of();

  public static <V> SelectOption<V> create(V value, String key, String text) {
    return new SelectOption<>(value, key, text);
  }

  public static <V> SelectOption<V> create(V value) {
    return new SelectOption<>(value, String.valueOf(value), String.valueOf(value));
  }

  public static <V> SelectOption<V> create(V value, String key, String text, String description) {
    return new SelectOption<>(value, key, text, description);
  }

  public SelectOption(V value, String key, String text, String description) {
    this(value, key, text);
    if (nonNull(description) && !description.isEmpty()) {
      descriptionElement = DominoElement.small().addCss(menu_item_hint).setTextContent(text);
      textElement.appendChild(descriptionElement);
    }
  }

  public SelectOption(V value, String key, String text) {
    setKey(key);
    setValue(value);
    valueElement = createValueElement(value, key, text);
    if (nonNull(text) && !text.isEmpty()) {
      textElement = DominoElement.span().addCss(menu_item_body).setTextContent(text);
      appendChild(textElement);
    }
  }

  protected DominoElement<HTMLElement> createValueElement(V value, String key, String text) {
    return DominoElement.span().textContent(text).addCss(dui_m_r_1);
  }

  @Override
  protected void onSelected() {
    if (!lazyValueElement.isInitialized()) {
      lazyValueElement = LazyChild.of(valueElement, getValueTarget());
      lazyValueElement.get();
    }
  }

  @Override
  protected void onDeselected() {
    lazyValueElement.remove();
  }

  /** @return The description element */
  public DominoElement<HTMLElement> getDescriptionElement() {
    return descriptionElement;
  }

  /** @return the main text element */
  public DominoElement<HTMLElement> getTextElement() {
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

  /**
   * Adds an element as an add-on to the left
   *
   * @param addOn {@link FlexItem}
   * @return same menu item instance
   */
  public SelectOption<V> addLeftAddOn(IsElement<?> addOn) {
    if (nonNull(addOn)) {
      linkElement.appendChild(DominoElement.of(addOn).addCss(menu_item_icon));
    }
    return this;
  }

  /**
   * Adds an element as an add-on to the right
   *
   * @param addOn {@link FlexItem}
   * @return same menu item instance
   */
  public SelectOption<V> addRightAddOn(IsElement<?> addOn) {
    if (nonNull(addOn)) {
      linkElement.appendChild(DominoElement.of(addOn).addCss(menu_item_utility));
    }
    return this;
  }
}
