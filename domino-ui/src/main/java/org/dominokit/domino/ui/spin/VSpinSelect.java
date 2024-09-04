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

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.SwipeUtil;

/**
 * A component provides vertical spin
 *
 * @param <T> the type of the object inside the spin
 */
@Deprecated
public class VSpinSelect<T> extends SpinSelect<T, VSpinSelect<T>> {

  /**
   * Creates new instance
   *
   * @param <T> the type of the object inside the spin
   * @return new instance
   */
  public static <T> VSpinSelect<T> create() {
    return new VSpinSelect<>();
  }

  /**
   * Creates new instance with back/forward icons
   *
   * @param backIcon the back {@link BaseIcon}
   * @param forwardIcon the forward {@link BaseIcon}
   * @param <T> the type of the object inside the spin
   * @return new instance
   */
  public static <T> VSpinSelect<T> create(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
    return new VSpinSelect<>(backIcon, forwardIcon);
  }

  public VSpinSelect() {
    this(Icons.ALL.keyboard_arrow_up(), Icons.ALL.keyboard_arrow_down());
  }

  public VSpinSelect(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
    super(backIcon, forwardIcon);
    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.DOWN, main.element(), evt -> moveBack());
    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.UP, main.element(), evt -> moveForward());
    setHeight("50px");
  }

  @Override
  protected void setTransformProperty(double offset) {
    contentPanel.setCssProperty("transform", "translate3d(0px, -" + offset + "%, 0px)");
  }

  @Override
  protected String getStyle() {
    return SpinStyles.V_SPIN;
  }

  @Override
  protected void fixElementsWidth() {
    DOMRect boundingClientRect = main.getBoundingClientRect();
    double totalHeight = boundingClientRect.height * items.size();
    contentPanel.setHeight(100 * items.size() + "%");

    items.forEach(
        spinItem -> spinItem.setHeight(((boundingClientRect.height / totalHeight) * 100) + "%"));
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
