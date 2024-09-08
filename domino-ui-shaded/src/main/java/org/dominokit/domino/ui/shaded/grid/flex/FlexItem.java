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
package org.dominokit.domino.ui.shaded.grid.flex;

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

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
@Deprecated
public class FlexItem<T extends HTMLElement> extends BaseDominoElement<T, FlexItem<T>> {

  private final T element;
  private int order;
  private int flexGrow;
  private int flexShrink;
  private String flexBasis;
  private FlexAlign alignSelf;

  public FlexItem() {
    this((T) div().element());
  }

  public FlexItem(T root) {
    element = root;
    init(this);
    css(FlexStyles.FLEX_ITEM);
  }

  /**
   * Creates new flex item with empty content
   *
   * @return new instance
   */
  public static FlexItem<HTMLDivElement> create() {
    return new FlexItem<>();
  }

  /**
   * @deprecated use {@link #of(HTMLElement)} Creates new flex item with {@code element} inside it
   * @param element the child element
   * @return new instance
   */
  @Deprecated
  public static <T extends HTMLElement> FlexItem<T> from(T element) {
    return new FlexItem<>(element);
  }

  /**
   * @deprecated use {@link #of(IsElement)} Creates new flex item with {@code element} inside it
   * @param element the child element
   * @return new instance
   */
  @Deprecated
  public static <T extends HTMLElement> FlexItem<T> from(IsElement<T> element) {
    return new FlexItem<>(element.element());
  }

  /**
   * Creates new flex item with {@code element} inside it
   *
   * @param element the child element
   * @return new instance
   */
  public static <T extends HTMLElement> FlexItem<T> of(T element) {
    return new FlexItem<>(element);
  }

  /**
   * Creates new flex item with {@code element} inside it
   *
   * @param element the child element
   * @return new instance
   */
  public static <T extends HTMLElement> FlexItem<T> of(IsElement<T> element) {
    return new FlexItem<>(element.element());
  }

  /**
   * Sets the order of this item inside the layout, the order of the item calculates the position of
   * the item inside the layout
   *
   * @param order the position of the item inside the layout
   * @return same instance
   */
  public FlexItem<T> setOrder(int order) {
    this.order = order;
    setCssProperty("order", String.valueOf(order));
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
  public FlexItem<T> setFlexGrow(int flexGrow) {
    this.flexGrow = flexGrow;
    setCssProperty("flex-grow", String.valueOf(flexGrow));
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
  public FlexItem<T> setFlexShrink(int flexShrink) {
    this.flexShrink = flexShrink;
    setCssProperty("flex-shrink", String.valueOf(flexShrink));
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
  public FlexItem<T> setFlexBasis(String flexBasis) {
    this.flexBasis = flexBasis;
    setCssProperty("flex-basis", flexBasis);
    return this;
  }

  /**
   * Sets the alignment of this item inside the layout
   *
   * @param alignSelf the {@link FlexAlign}
   * @return same instance
   */
  public FlexItem<T> setAlignSelf(FlexAlign alignSelf) {
    this.alignSelf = alignSelf;
    setCssProperty("align-self", alignSelf.getValue());
    return this;
  }

  /**
   * Sets if the alignment of this item should be automatic
   *
   * @return same instance
   */
  public FlexItem<T> setAutoAlign() {
    setCssProperty("align-self", "auto");
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
  public T element() {
    return element;
  }
}
