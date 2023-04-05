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

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.chips.Chip;
import org.dominokit.domino.ui.elements.SmallElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.NullLazyChild;
import org.dominokit.domino.ui.IsElement;

public class TagOption<V> extends Option<V> {

  private SmallElement descriptionElement;
  private SpanElement textElement;

  private Chip chip;
  private LazyChild<Chip> lazyChip = NullLazyChild.of();

  public static <V> TagOption<V> create(V value, String key, String text) {
    return new TagOption<>(value, key, text);
  }

  public static <V> TagOption<V> create(V value) {
    return new TagOption<>(value, String.valueOf(value), String.valueOf(value));
  }

  public static <V> TagOption<V> create(V value, String key, String text, String description) {
    return new TagOption<>(value, key, text, description);
  }

  public TagOption(V value, String key, String text, String description) {
    this(value, key, text);
    if (nonNull(description) && !description.isEmpty()) {
      descriptionElement = small().addCss(menu_item_hint).setTextContent(text);
      textElement.appendChild(descriptionElement);
    }
  }

  public TagOption(V value, String key, String text) {
    setKey(key);
    setValue(value);
    chip = createChip(value, key, text);
    if (nonNull(text) && !text.isEmpty()) {
      textElement = span().addCss(menu_item_body).setTextContent(text);
      appendChild(textElement);
    }
  }

  protected Chip createChip(V value, String key, String text) {
    return Chip.create(text).addCss(dui_m_r_0_5);
  }

  public Chip getChip() {
    return chip;
  }

  public TagOption<V> withChip(ChildHandler<TagOption<V>, Chip> handler) {
    handler.apply(this, chip);
    return this;
  }

  public TagOption<V> setRemovable(boolean removable) {
    this.chip.setRemovable(removable);
    return this;
  }

  public boolean isRemovable() {
    return chip.isRemovable();
  }

  @Override
  protected void onSelected() {
    if (!lazyChip.isInitialized()) {
      lazyChip = LazyChild.of(chip, getValueTarget());
    }
    lazyChip.get();
  }

  @Override
  protected void onDeselected() {
    lazyChip.remove();
  }

  /** @return The description element */
  public SmallElement getDescriptionElement() {
    return descriptionElement;
  }

  /**
   * @return the main text element
   */
  public SpanElement getTextElement() {
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
      this.expand();
      return true;
    }
    if (containsToken(token, caseSensitive)) {
      if (this.isCollapsed()) {
        this.expand();
      }
      return true;
    }
    if (this.isExpanded()) {
      this.collapse();
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
  public TagOption<V> addLeftAddOn(IsElement<?> addOn) {
    if (nonNull(addOn)) {
      linkElement.appendChild(elementOf(addOn).addCss(menu_item_icon));
    }
    return this;
  }

  /**
   * Adds an element as an add-on to the right
   *
   * @param addOn {@link FlexItem}
   * @return same menu item instance
   */
  public TagOption<V> addRightAddOn(IsElement<?> addOn) {
    if (nonNull(addOn)) {
      linkElement.appendChild(elementOf(addOn).addCss(menu_item_utility));
    }
    return this;
  }
}
