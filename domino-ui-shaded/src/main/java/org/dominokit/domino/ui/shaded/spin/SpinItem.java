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
package org.dominokit.domino.ui.shaded.spin;

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * A component provides an item inside a {@link SpinSelect}
 *
 * @param <T> the type of the object inside the item
 */
@Deprecated
public class SpinItem<T> extends BaseDominoElement<HTMLDivElement, SpinItem<T>> {

  private final T value;
  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div()).css(SpinStyles.SPIN_ITEM);

  public SpinItem(T value) {
    this.value = value;
    init(this);
  }

  public SpinItem(T value, Node content) {
    this(value);
    setContent(content);
  }

  public SpinItem(T value, IsElement<?> content) {
    this(value);
    setContent(content);
  }

  /**
   * Creates new instance with a value
   *
   * @param value the value
   * @param <T> the type of the object inside the item
   * @return new instance
   */
  public static <T> SpinItem<T> create(T value) {
    return new SpinItem<>(value);
  }

  /**
   * Creates new instance with a value and a content node
   *
   * @param value the value
   * @param content the content {@link Node}
   * @param <T> the type of the object inside the item
   * @return new instance
   */
  public static <T> SpinItem<T> create(T value, Node content) {
    return new SpinItem<>(value, content);
  }

  /**
   * Creates new instance with a value and a content node
   *
   * @param value the value
   * @param content the content {@link Node}
   * @param <T> the type of the object inside the item
   * @return new instance
   */
  public static <T> SpinItem<T> create(T value, IsElement<?> content) {
    return new SpinItem<>(value, content);
  }

  /** @return the value of the item */
  public T getValue() {
    return value;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
