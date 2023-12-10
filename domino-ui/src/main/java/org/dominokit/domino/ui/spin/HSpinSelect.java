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

import elemental2.dom.DOMRect;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.SwipeUtil;

/**
 * This class represents a horizontal spin select component. It allows users to cycle through a set
 * of items in a horizontal fashion.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * HSpinSelect&lt;String&gt; spinSelect = HSpinSelect.create();
 * spinSelect.addItem("Item 1");
 * spinSelect.addItem("Item 2");
 * // Add more items as needed...
 * </pre>
 *
 * @param <T> The type of the items in this spin select.
 */
public class HSpinSelect<T> extends SpinSelect<T, HSpinSelect<T>> {

  /**
   * Creates a new HSpinSelect with default back and forward icons.
   *
   * @param <T> the type of the items
   * @return a new instance of HSpinSelect
   */
  public static <T> HSpinSelect<T> create() {
    return new HSpinSelect<>();
  }

  /**
   * Creates a new HSpinSelect with the provided back and forward icons.
   *
   * @param backIcon the back icon to use
   * @param forwardIcon the forward icon to use
   * @param <T> the type of the items
   * @return a new instance of HSpinSelect
   */
  public static <T> HSpinSelect<T> create(Icon<?> backIcon, Icon<?> forwardIcon) {
    return new HSpinSelect<>(backIcon, forwardIcon);
  }

  /** Default constructor that initializes the HSpinSelect with default back and forward icons. */
  public HSpinSelect() {
    this(
        DominoUIConfig.CONFIG.getUIConfig().getDefaultBackIconSupplier().get(),
        DominoUIConfig.CONFIG.getUIConfig().getDefaultForwardIconSupplier().get());
  }

  /**
   * Constructor that initializes the HSpinSelect with the provided back and forward icons.
   *
   * @param backIcon the back icon to use
   * @param forwardIcon the forward icon to use
   */
  public HSpinSelect(Icon<?> backIcon, Icon<?> forwardIcon) {
    super(backIcon, forwardIcon);
    addCss(dui_spin_horizontal);
    SwipeUtil.addSwipeListener(
        SwipeUtil.SwipeDirection.RIGHT, contentPanel.element(), evt -> moveBack());
    SwipeUtil.addSwipeListener(
        SwipeUtil.SwipeDirection.LEFT, contentPanel.element(), evt -> moveForward());
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation adjusts the width of the items based on the current bounding rect of the
   * content panel.
   */
  @Override
  protected void fixElementsWidth() {
    DOMRect boundingClientRect = contentPanel.getBoundingClientRect();
    double totalWidth = boundingClientRect.width * items.size();
    contentPanel.setWidth(100 * items.size() + "%");

    items.forEach(
        spinItem -> spinItem.setWidth(((boundingClientRect.width / totalWidth) * 100) + "%"));
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation sets the transform property to translate the content horizontally based
   * on the given offset.
   */
  @Override
  protected void setTransformProperty(double offset) {
    contentPanel.setCssProperty("transform", "translate3d(-" + offset + "%, 0px, 0px)");
  }
}
