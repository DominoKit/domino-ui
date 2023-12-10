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
package org.dominokit.domino.ui.spin;

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents an individual item in a spinning selection component.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * SpinItem&lt;String&gt; item = SpinItem.create("example");
 * </pre>
 *
 * @param <T> The type of the value represented by this item.
 * @see BaseDominoElement
 */
public class SpinItem<T> extends BaseDominoElement<HTMLDivElement, SpinItem<T>>
    implements SpinStyles {

  private final T value;
  private final DivElement element;

  /**
   * Constructs a new SpinItem with the given value.
   *
   * @param value The value represented by this item.
   */
  public SpinItem(T value) {
    this.value = value;
    element = div().addCss(dui_spin_item);
    init(this);
    addEventListener(
        "transitionend",
        evt -> {
          if (spinActivating.isAppliedTo(this)) {
            removeCss(spinActivating);
          } else if (spinExiting.isAppliedTo(this)) {
            removeCss(spinExiting);
          }
        });
  }

  /**
   * Static factory method to create a new instance of {@link SpinItem}.
   *
   * @param <T> The type of the value represented by this item.
   * @param value The value to create a SpinItem for.
   * @return A new instance of {@link SpinItem} representing the given value.
   */
  public static <T> SpinItem<T> create(T value) {
    return new SpinItem<>(value);
  }

  /**
   * Gets the value represented by this item.
   *
   * @return The value of this item.
   */
  public T getValue() {
    return value;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Overridden to return the HTMLDivElement associated with this {@link SpinItem}.
   *
   * @return The HTMLDivElement for this item.
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
