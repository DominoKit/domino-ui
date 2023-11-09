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
package org.dominokit.domino.ui.tabs;

import static org.dominokit.domino.ui.tabs.TabStyles.dui_tab_item;

import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a fill item for use in tab layouts.
 *
 * <p>This class provides functionality to create a filler item that grows and fills available space
 * inside a tabs layout. The main use case is to space out tabs or push certain tabs to the edge of
 * the container.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * TabsPanel tabsPanel = TabsPanel.create();
 * tabsPanel.appendChild(Tab.create(...));
 * tabsPanel.appendChild(FillItem.create());
 * tabsPanel.appendChild(Tab.create(...));
 * </pre>
 *
 * @see Tab
 * @see TabsPanel
 * @see BaseDominoElement
 */
public class FillItem extends BaseDominoElement<HTMLLIElement, FillItem> {

  private LIElement element;

  /**
   * Default constructor for the {@link FillItem} class.
   *
   * <p>This will create a new fill item and apply the appropriate styles.
   */
  public FillItem() {
    this.element = li().addCss(dui_tab_item, dui_grow_1);
    init(this);
  }

  /**
   * Static factory method to create a new instance of {@link FillItem}.
   *
   * @return a new instance of {@link FillItem}
   */
  public static FillItem create() {
    return new FillItem();
  }

  /**
   * Overrides the {@link BaseDominoElement#element()} method to return the underlying {@link
   * HTMLLIElement} representing the fill item.
   *
   * @return the underlying {@link HTMLLIElement} of the fill item
   */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }
}
