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

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A component provides an item inside a {@link SpinSelect}
 *
 * @param <T> the type of the object inside the item
 */
public class SpinItem<T> extends BaseDominoElement<HTMLDivElement, SpinItem<T>> implements SpinStyles {

  private final T value;
  private final DivElement element;

  public SpinItem(T value) {
    this.value = value;
    element = div().addCss(dui_spin_item);
    init(this);
    addEventListener("transitionend", evt -> {
      if(spinActivating.isAppliedTo(this)){
        removeCss(spinActivating);
      }else if(spinExiting.isAppliedTo(this)){
        removeCss(spinExiting);
      }
    });
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
