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
 * Represents a vertical spin select component, allowing users to cycle through a set of items in a
 * vertical manner.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * VSpinSelect&lt;String&gt; spinSelect = VSpinSelect.create();
 * spinSelect.addItem("Item 1");
 * spinSelect.addItem("Item 2");
 * // Add more items as needed...
 * </pre>
 *
 * @param <T> The type of the items in this spin select.
 */
public class VSpinSelect<T> extends SpinSelect<T, VSpinSelect<T>> {

  /**
   * Creates a new VSpinSelect with default up and down icons.
   *
   * @param <T> the type of the items
   * @return a new instance of VSpinSelect
   */
  public static <T> VSpinSelect<T> create() {
    return new VSpinSelect<>();
  }

  /**
   * Creates a new VSpinSelect with the provided up and down icons.
   *
   * @param upIcon the up icon to use
   * @param downIcon the down icon to use
   * @param <T> the type of the items
   * @return a new instance of VSpinSelect
   */
  public static <T> VSpinSelect<T> create(Icon<?> upIcon, Icon<?> downIcon) {
    return new VSpinSelect<>(upIcon, downIcon);
  }

  /** Default constructor that initializes the VSpinSelect with default up and down icons. */
  public VSpinSelect() {
    this(
        DominoUIConfig.CONFIG.getUIConfig().getDefaultUpIconSupplier().get(),
        DominoUIConfig.CONFIG.getUIConfig().getDefaultDownIconSupplier().get());
  }

  /**
   * Constructor that initializes the VSpinSelect with the provided up and down icons.
   *
   * @param upIcon the up icon to use
   * @param downIcon the down icon to use
   */
  public VSpinSelect(Icon<?> upIcon, Icon<?> downIcon) {
    super(upIcon, downIcon);
    addCss(dui_spin_vertical);
    SwipeUtil.addSwipeListener(
        SwipeUtil.SwipeDirection.DOWN, contentPanel.element(), evt -> moveBack());
    SwipeUtil.addSwipeListener(
        SwipeUtil.SwipeDirection.UP, contentPanel.element(), evt -> moveForward());
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation sets the transform property to translate the content vertically based on
   * the given offset.
   */
  @Override
  protected void setTransformProperty(double offset) {
    contentPanel.setCssProperty("transform", "translate3d(0px, -" + offset + "%, 0px)");
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation adjusts the height of the items based on the current bounding rect of
   * the content panel.
   */
  @Override
  protected void fixElementsWidth() {
    DOMRect boundingClientRect = contentPanel.getBoundingClientRect();
    double totalHeight = boundingClientRect.height * items.size();
    contentPanel.setHeight(100 * items.size() + "%");

    items.forEach(
        spinItem -> spinItem.setHeight(((boundingClientRect.height / totalHeight) * 100) + "%"));
  }
}
