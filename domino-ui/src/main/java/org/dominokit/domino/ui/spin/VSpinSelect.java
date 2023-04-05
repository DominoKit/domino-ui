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
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.SwipeUtil;

/**
 * A component provides vertical spin
 *
 * @param <T> the type of the object inside the spin
 */
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
   * @param backIcon the back {@link Icon}
   * @param forwardIcon the forward {@link Icon}
   * @param <T> the type of the object inside the spin
   * @return new instance
   */
  public static <T> VSpinSelect<T> create(Icon<?> backIcon, Icon<?> forwardIcon) {
    return new VSpinSelect<>(backIcon, forwardIcon);
  }

  public VSpinSelect() {
    this(DominoUIConfig.CONFIG.getUIConfig().getDefaultUpIconSupplier().get()
            , DominoUIConfig.CONFIG.getUIConfig().getDefaultDownIconSupplier().get()
    );
  }

  public VSpinSelect(Icon<?> backIcon, Icon<?> forwardIcon) {
    super(backIcon, forwardIcon);
    addCss(dui_spin_vertical);
    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.DOWN, contentPanel.element(), evt -> moveBack());
    SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.UP, contentPanel.element(), evt -> moveForward());
  }

  @Override
  protected void setTransformProperty(double offset) {
    contentPanel.setCssProperty("transform", "translate3d(0px, -" + offset + "%, 0px)");
  }

  @Override
  protected void fixElementsWidth() {
    DOMRect boundingClientRect = contentPanel.getBoundingClientRect();
    double totalHeight = boundingClientRect.height * items.size();
    contentPanel.setHeight(100 * items.size() + "%");

    items.forEach(
        spinItem -> spinItem.setHeight(((boundingClientRect.height / totalHeight) * 100) + "%"));
  }

}
