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
package org.dominokit.domino.ui.menu;

import static java.util.Objects.nonNull;

import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.menu.direction.BestFitSideDropDirection;
import org.dominokit.domino.ui.utils.DelayedExecution;
import org.dominokit.domino.ui.utils.PopupsCloser;
import org.jboss.elemento.EventType;

/**
 * And extended implementation of the {@link AbstractMenuItem} that allow the menu item to open a
 * sub-menu {@inheritDoc}
 */
public class AbstractDropMenuItem<V, T extends AbstractDropMenuItem<V, T>>
    extends AbstractMenuItem<V, T> {

  private final MdiIcon indicatorIcon = Icons.ALL.menu_right_mdi();
  private FlexItem<?> nestingIndicator =
      FlexItem.create().css("ddi-indicator").setOrder(Integer.MAX_VALUE).appendChild(indicatorIcon);

  private FlexItem<?> noIndicator =
      FlexItem.create().css("ddi-indicator").setOrder(Integer.MAX_VALUE);

  AbstractDropMenu<V, ?> menu;

  public AbstractDropMenuItem() {
    this.addEventListener(EventType.mouseenter.getName(), evt -> openSubMenu());
    this.addEventListener(
        "touchstart",
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
          focus();
          openSubMenu();
        });
    addRightAddOn(noIndicator);
  }

  /** @return the {@link FlexItem} that represent the current menu nesting indication. */
  public FlexItem<?> getNestingIndicator() {
    return nestingIndicator;
  }

  /**
   * Sets a custom menu nesting indicator
   *
   * @param nestingIndicator {@link FlexItem}
   * @return same menu item
   */
  public T setNestingIndicator(FlexItem<?> nestingIndicator) {
    if (nonNull(nestingIndicator)) {
      if (this.nestingIndicator.isAttached()) {
        nestingIndicator.remove();
      }

      noIndicator.remove();
      addRightAddOn(nestingIndicator.setOrder(Integer.MAX_VALUE).css("ddi-indicator"));
      this.nestingIndicator = nestingIndicator;
    }

    return (T) this;
  }

  /**
   * Sets the sub-menu of the menu item
   *
   * @param menu {@link AbstractDropMenu}
   * @return same menu item
   */
  public T setMenu(AbstractDropMenu<V, ?> menu) {
    this.menu = menu;
    if (nonNull(menu)) {
      this.menu.setAttribute("domino-sub-menu", true);
      this.menu.removeAttribute("domino-ui-root-menu");
      setNestingIndicator(nestingIndicator);
      this.menu.setTargetElement(this);
      this.menu.setDropDirection(new BestFitSideDropDirection());
    } else {
      this.nestingIndicator.remove();
    }
    this.menu.setParentItem(this);

    return (T) this;
  }

  /** Opens the sub-menu of the menu item */
  public void openSubMenu() {
    if (nonNull(menu)) {
      DelayedExecution.execute(
          () -> {
            if (nonNull(parent)) {
              this.menu.setParent(parent);
              if (parent instanceof AbstractDropMenu<?, ?>) {
                AbstractDropMenu<V, ?> parentDropDown = (AbstractDropMenu<V, ?>) this.parent;
                if (parentDropDown.isOpened()) {
                  parentDropDown.openSubMenu(this.menu);
                }
              } else {
                openSelfMenu();
              }
            }
          },
          200);
    }
  }

  private void openSelfMenu() {
    PopupsCloser.close();
    this.menu.open();
  }

  void onParentClosed() {
    closeSubMenu();
  }

  /**
   * Close the item sub-menu
   *
   * @return same menu item instance
   */
  public T closeSubMenu() {
    if (nonNull(this.menu)) {
      this.menu.close();
    }
    return (T) this;
  }

  /** @return The parent {@link AbstractMenu} of the menu item */
  public AbstractMenu<V, ?> getParent() {
    return this.parent;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasMenu() {
    return nonNull(this.menu);
  }
}
