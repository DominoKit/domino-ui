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
package org.dominokit.domino.ui.shaded.menu;

import static java.util.Objects.isNull;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.shaded.grid.flex.FlexDirection;
import org.dominokit.domino.ui.shaded.grid.flex.FlexItem;
import org.dominokit.domino.ui.shaded.grid.flex.FlexLayout;
import org.dominokit.domino.ui.shaded.icons.BaseIcon;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.TextNode;
import org.jboss.elemento.IsElement;

/**
 * Menu header component for {@link AbstractMenu}, the header is hidden by default unless it is
 * explicitly set to visible or the user attached any header element.
 */
@Deprecated
public class MenuHeader<V, T extends AbstractMenu<V, T>>
    extends BaseDominoElement<HTMLDivElement, MenuHeader<V, T>> {

  private final FlexLayout root = FlexLayout.create().css("menu-header");

  private final FlexItem<HTMLDivElement> iconContainer =
      FlexItem.create().setOrder(1).css("header-icon");
  protected final FlexLayout leftAddOnsContainer = FlexLayout.create();
  private final FlexItem<HTMLDivElement> titleContainer =
      FlexItem.create().setOrder(2).css("header-title");
  private final FlexItem<HTMLDivElement> actionsContainer =
      FlexItem.create().setOrder(3).css("header-actions");
  private final FlexLayout actionsElement =
      FlexLayout.create().css("actions-element").setGap("4px");
  private AbstractMenu<V, T> menu;

  public MenuHeader(AbstractMenu<V, T> menu) {
    init(this);
    this.menu = menu;

    root.setDirection(FlexDirection.LEFT_TO_RIGHT)
        .appendChild(FlexItem.create().appendChild(leftAddOnsContainer.appendChild(iconContainer)))
        .appendChild(titleContainer.setFlexGrow(1))
        .appendChild(actionsContainer.appendChild(actionsElement));
  }

  /**
   * Set the menu header icon
   *
   * @param icon {@link BaseIcon}
   * @return same header instance
   */
  public MenuHeader<V, T> setIcon(BaseIcon<?> icon) {
    if (isNull(icon)) {
      iconContainer.clearElement();
    } else {
      iconContainer.appendChild(icon);
    }
    return this;
  }

  /**
   * Set the menu header title
   *
   * @param title String
   * @return same header instance
   */
  public MenuHeader<V, T> setTitle(String title) {
    if (isNull(title)) {
      titleContainer.clearElement();
    } else {
      titleContainer.clearElement().appendChild(TextNode.of(title));
    }
    return this;
  }

  /**
   * Appends an element as an action to the header actions bar
   *
   * @param element {@link HTMLElement}
   * @return same header instance
   */
  public MenuHeader<V, T> appendAction(HTMLElement element) {
    actionsElement.appendChild(FlexItem.of(element).css("header-action"));
    return this;
  }

  /**
   * Appends an element as an action to the header actions bar
   *
   * @param element {@link IsElement}
   * @return same header instance
   */
  public MenuHeader<V, T> appendAction(IsElement<?> element) {
    actionsElement.appendChild(FlexItem.of(element).css("header-action"));
    return this;
  }

  /** @return The {@link FlexItem} containing the header icon */
  public FlexItem<HTMLDivElement> getIconContainer() {
    return iconContainer;
  }

  /** @return The {@link FlexItem} containing the header title */
  public FlexItem<HTMLDivElement> getTitleContainer() {
    return titleContainer;
  }

  /** @return The {@link FlexItem} that warps the header actions container */
  public FlexItem<HTMLDivElement> getActionsContainer() {
    return actionsContainer;
  }

  /** @return The {@link FlexItem} containing the header actions elements */
  public FlexLayout getActionsElement() {
    return actionsElement;
  }

  /** @return The {@link AbstractMenu} of the header component */
  public AbstractMenu<V, T> getMenu() {
    return menu;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
