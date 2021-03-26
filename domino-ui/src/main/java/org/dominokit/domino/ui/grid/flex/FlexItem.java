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

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component which provides an abstract level of the CSS flex item which will inherit the styles
 * for the CSS flex item by default
 *
 * <p>More information can be found in <a
 * href="https://developer.mozilla.org/en-US/docs/Web/CSS/flex">MDN official documentation</a>
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link FlexStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     FlexItem.create();
 * </pre>
 *
 * @see BaseDominoElement
 * @see FlexLayout
 */
public class FlexItem extends BaseDominoElement<HTMLDivElement, FlexItem> {

  private final HTMLDivElement element;
  private int order;
  private int flexGrow;
  private int flexShrink;
  private String flexBasis;
  private FlexAlign alignSelf;

  public FlexItem() {
    this(div().element());
  }

  public FlexItem(HTMLDivElement root) {
    element = root;
    init(this);
    css(FlexStyles.FLEX_ITEM);
  }

  /**
   * Creates new flex item with empty content
   *
   * @return new instance
   */
  public static FlexItem create() {
    return new FlexItem();
  }

  /**
   * Creates new flex item with {@code element} inside it
   *
   * @param element the child element
   * @return new instance
   */
  public static FlexItem from(HTMLDivElement element) {
    return new FlexItem(element);
  }

  /**
   * Sets the order of this item inside the layout, the order of the item calculates the position of
   * the item inside the layout
   *
   * @param order the position of the item inside the layout
   * @return same instance
   */
  public FlexItem setOrder(int order) {
    this.order = order;
    style().setProperty("order", String.valueOf(order));
    return this;
  }

  /** @return The order of this item */
  public int getOrder() {
    return order;
  }

  /**
   * Sets the grow of this item
   *
   * <p>More information can be found in <a
   * href="https://developer.mozilla.org/en-US/docs/Web/CSS/flex-grow">MDN official
   * documentation</a>
   *
   * @param flexGrow the value of the grow of this item
   * @return same instance
   */
  public FlexItem setFlexGrow(int flexGrow) {
    this.flexGrow = flexGrow;
    style().setProperty("flex-grow", String.valueOf(flexGrow));
    return this;
  }

  /**
   * Sets the shrink of this item
   *
   * <p>More information can be found in <a
   * href="https://developer.mozilla.org/en-US/docs/Web/CSS/flex-shrink">MDN official
   * documentation</a>
   *
   * @param flexShrink the value of the shrink of this item
   * @return same instance
   */
  public FlexItem setFlexShrink(int flexShrink) {
    this.flexShrink = flexShrink;
    style().setProperty("flex-shrink", String.valueOf(flexShrink));
    return this;
  }

  /**
   * Sets the basis of this item
   *
   * <p>More information can be found in <a
   * href="https://developer.mozilla.org/en-US/docs/Web/CSS/flex-basis">MDN official
   * documentation</a>
   *
   * @param flexBasis the value of the basis of this item
   * @return same instance
   */
  public FlexItem setFlexBasis(String flexBasis) {
    this.flexBasis = flexBasis;
    style().setProperty("flex-basis", flexBasis);
    return this;
  }

  /**
   * Sets the alignment of this item inside the layout
   *
   * @param alignSelf the {@link FlexAlign}
   * @return same instance
   */
  public FlexItem setAlignSelf(FlexAlign alignSelf) {
    this.alignSelf = alignSelf;
    style().setProperty("align-self", alignSelf.getValue());
    return this;
  }

  /**
   * Sets if the alignment of this item should be automatic
   *
   * @return same instance
   */
  public FlexItem setAutoAlign() {
    style().setProperty("align-self", "auto");
    return this;
  }

  /** @return The grow of this item */
  public int getFlexGrow() {
    return flexGrow;
  }

  /** @return The shrink of this item */
  public int getFlexShrink() {
    return flexShrink;
  }

  /** @return The basis of this item */
  public String getFlexBasis() {
    return flexBasis;
  }

  /** @return The alignment of this item */
  public FlexAlign getAlignSelf() {
    return alignSelf;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element;
  }
}
