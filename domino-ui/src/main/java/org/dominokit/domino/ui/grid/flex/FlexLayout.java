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
package org.dominokit.domino.ui.grid.flex;

import static java.util.Objects.isNull;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * The {@code FlexLayout} class represents a flexible layout container that uses CSS Flexbox.
 *
 * <p>It allows you to create complex layouts by distributing space and aligning items in a more
 * efficient way. This class provides methods to control the flex direction, wrapping, alignment,
 * and gap between items.
 *
 * <p>Usage Example:
 *
 * <pre>
 * FlexLayout flexLayout = FlexLayout.create()
 *     .setDirection(FlexDirection.ROW)
 *     .setWrap(FlexWrap.WRAP)
 *     .setJustifyContent(FlexJustifyContent.CENTER)
 *     .setAlignItems(FlexAlign.CENTER);
 *
 * FlexItem<?> flexItem1 = // Create and configure a FlexItem
 * FlexItem<?> flexItem2 = // Create and configure another FlexItem
 *
 * flexLayout.appendChild(flexItem1);
 * flexLayout.appendChild(flexItem2);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class FlexLayout extends BaseDominoElement<HTMLDivElement, FlexLayout> {

  private final DivElement element;
  private final List<FlexItem<?>> flexItems = new ArrayList<>();
  private SwapCssClass flexDirection = SwapCssClass.of();
  private SwapCssClass flexWrap = SwapCssClass.of();
  private SwapCssClass flexJustifyContent = SwapCssClass.of();
  private SwapCssClass flexAlign = SwapCssClass.of();

  /** Constructs a new {@code FlexLayout} instance. */
  public FlexLayout() {
    this.element = div().addCss(dui_flex);
    init(this);
  }

  /**
   * Creates a new instance of the {@code FlexLayout} class.
   *
   * @return A new {@code FlexLayout} instance.
   */
  public static FlexLayout create() {
    return new FlexLayout();
  }

  /**
   * Sets the flex direction of the layout.
   *
   * @param direction The flex direction to set.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout setDirection(FlexDirection direction) {
    this.flexDirection.replaceWith(direction).apply(this);
    return this;
  }

  /**
   * Sets the flex wrapping behavior of the layout.
   *
   * @param wrap The flex wrap behavior to set.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout setWrap(FlexWrap wrap) {
    this.flexWrap.replaceWith(wrap).apply(this);
    return this;
  }

  /**
   * Sets both the flex direction and flex wrapping behavior of the layout.
   *
   * @param direction The flex direction to set.
   * @param wrap The flex wrap behavior to set.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout setFlow(FlexDirection direction, FlexWrap wrap) {
    setDirection(direction);
    setWrap(wrap);
    return this;
  }

  /**
   * Sets the alignment of items along the main axis of the layout.
   *
   * @param justifyContent The alignment value to set.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout setJustifyContent(FlexJustifyContent justifyContent) {
    this.flexJustifyContent.replaceWith(justifyContent).apply(this);
    return this;
  }

  /**
   * Sets the alignment of items along the cross axis of the layout.
   *
   * @param alignItems The alignment value to set.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout setAlignItems(FlexAlign alignItems) {
    this.flexAlign.replaceWith(alignItems).apply(this);
    return this;
  }

  /**
   * Appends a {@code FlexItem} to the layout.
   *
   * @param flexItem The {@code FlexItem} to append.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout appendChild(FlexItem<?> flexItem) {
    flexItems.add(flexItem);
    appendChild(flexItem.element());
    return this;
  }

  /**
   * Inserts a {@code FlexItem} at the beginning of the layout.
   *
   * @param flexItem The {@code FlexItem} to insert.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout insertFirst(FlexItem<?> flexItem) {
    if (!flexItems.isEmpty()) {
      return appendChildBefore(flexItem, flexItems.get(0));
    }
    return appendChild(flexItem);
  }

  /**
   * Inserts a {@code FlexItem} before an existing item in the layout.
   *
   * @param flexItem The {@code FlexItem} to insert.
   * @param existingItem The existing {@code FlexItem} before which the new item should be inserted.
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout appendChildBefore(FlexItem<?> flexItem, FlexItem<?> existingItem) {
    if (flexItems.contains(existingItem)) {
      flexItems.add(flexItem);
      insertBefore(flexItem, existingItem);
    }
    return this;
  }

  /**
   * Sets the gap between items in the layout.
   *
   * @param gap The gap size as a CSS value (e.g., "20px").
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout setGap(String gap) {
    if (isNull(gap) || gap.isEmpty()) {
      return removeGap();
    }
    setCssProperty("gap", gap);
    return this;
  }

  /**
   * Removes the gap between items in the layout.
   *
   * @return This {@code FlexLayout} instance for method chaining.
   */
  public FlexLayout removeGap() {
    removeCssProperty("gap");
    return this;
  }

  /**
   * Retrieves a list of {@code FlexItem}s added to the layout.
   *
   * @return A list of {@code FlexItem}s.
   */
  public List<FlexItem<?>> getFlexItems() {
    return flexItems;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
