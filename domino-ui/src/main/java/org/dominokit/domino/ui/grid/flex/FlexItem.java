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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * The {@code FlexItem} class represents a flex item that can be used within a flex container to
 * control its layout properties.
 *
 * @param <T> The type of the HTML element associated with the flex item.
 * @see BaseDominoElement
 */
public class FlexItem<T extends HTMLElement> extends BaseDominoElement<T, FlexItem<T>> {

  private final T element;
  private int order;
  private int flexGrow;
  private int flexShrink;
  private String flexBasis;
  private SwapCssClass alignSelf = SwapCssClass.of();

  /** Creates a new {@code FlexItem} with a default root element, which is a <div> element. */
  public FlexItem() {
    this((T) div().element());
  }

  /**
   * Creates a new {@code FlexItem} with the specified root element.
   *
   * @param root The root element associated with the flex item.
   */
  public FlexItem(T root) {
    element = root;
    init(this);
  }

  /**
   * Creates a new {@code FlexItem} with a default root element of type {@code HTMLDivElement}.
   *
   * @return A new {@code FlexItem} instance.
   */
  public static FlexItem<HTMLDivElement> create() {
    return new FlexItem<>();
  }

  /**
   * Creates a new {@code FlexItem} with the specified root element.
   *
   * @param element The root element associated with the flex item.
   * @param <T> The type of the HTML element.
   * @return A new {@code FlexItem} instance.
   */
  public static <T extends HTMLElement> FlexItem<T> of(T element) {
    return new FlexItem<>(element);
  }

  /**
   * Creates a new {@code FlexItem} from an {@code IsElement} instance.
   *
   * @param element The {@code IsElement} instance to create a {@code FlexItem} from.
   * @param <T> The type of the HTML element.
   * @return A new {@code FlexItem} instance.
   */
  public static <T extends HTMLElement> FlexItem<T> of(IsElement<T> element) {
    return new FlexItem<>(element.element());
  }

  /**
   * Sets the order property for the flex item.
   *
   * @param order The order value.
   * @return This {@code FlexItem} instance.
   */
  public FlexItem<T> setOrder(int order) {
    this.order = order;
    setCssProperty("order", String.valueOf(order));
    return this;
  }

  /**
   * Gets the order property of the flex item.
   *
   * @return The order value.
   */
  public int getOrder() {
    return order;
  }

  /**
   * Sets the flex-grow property for the flex item.
   *
   * @param flexGrow The flex-grow value.
   * @return This {@code FlexItem} instance.
   */
  public FlexItem<T> setFlexGrow(int flexGrow) {
    this.flexGrow = flexGrow;
    setCssProperty("flex-grow", String.valueOf(flexGrow));
    return this;
  }

  /**
   * Sets the flex-shrink property for the flex item.
   *
   * @param flexShrink The flex-shrink value.
   * @return This {@code FlexItem} instance.
   */
  public FlexItem<T> setFlexShrink(int flexShrink) {
    this.flexShrink = flexShrink;
    setCssProperty("flex-shrink", String.valueOf(flexShrink));
    return this;
  }

  /**
   * Sets the flex-basis property for the flex item.
   *
   * @param flexBasis The flex-basis value as a CSS string.
   * @return This {@code FlexItem} instance.
   */
  public FlexItem<T> setFlexBasis(String flexBasis) {
    this.flexBasis = flexBasis;
    setCssProperty("flex-basis", flexBasis);
    return this;
  }

  /**
   * Sets the align-self property for the flex item.
   *
   * @param alignSelf The {@code FlexAlignSelf} value to set.
   * @return This {@code FlexItem} instance.
   */
  public FlexItem<T> setAlignSelf(FlexAlignSelf alignSelf) {
    this.alignSelf.replaceWith(alignSelf).apply(this);
    return this;
  }

  /**
   * Sets the align-self property to 'auto' for the flex item.
   *
   * @return This {@code FlexItem} instance.
   */
  public FlexItem<T> setAutoAlign() {
    setAlignSelf(FlexAlignSelf.AUTO);
    return this;
  }

  /**
   * Gets the flex-grow property of the flex item.
   *
   * @return The flex-grow value.
   */
  public int getFlexGrow() {
    return flexGrow;
  }

  /**
   * Gets the flex-shrink property of the flex item.
   *
   * @return The flex-shrink value.
   */
  public int getFlexShrink() {
    return flexShrink;
  }

  /**
   * Gets the flex-basis property of the flex item.
   *
   * @return The flex-basis value as a CSS string.
   */
  public String getFlexBasis() {
    return flexBasis;
  }

  /**
   * Gets the align-self property of the flex item.
   *
   * @return The {@code CssClass} representing the align-self value.
   */
  public CssClass getAlignSelf() {
    return alignSelf;
  }

  /** {@inheritDoc} */
  @Override
  public T element() {
    return element;
  }
}
