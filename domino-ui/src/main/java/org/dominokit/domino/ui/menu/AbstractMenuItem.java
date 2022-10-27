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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.MenuStyles.*;
import static org.jboss.elemento.Elements.a;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.menu.direction.BestFitSideDropDirection;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * The base implementation for {@link Menu} items
 *
 * @param <V> The type of the menu item value
 * @param <T> The type of the class extending from this class
 */
public class AbstractMenuItem<V, T extends AbstractMenuItem<V, T>>
    extends BaseDominoElement<HTMLLIElement, T>
    implements HasSelectionHandler<T, T>, HasDeselectionHandler<T>, TakesValue<V> {

  protected final DominoElement<HTMLLIElement> root;
  protected final DominoElement<HTMLAnchorElement> linkElement;

  protected Menu<V> parent;

  private final List<HasSelectionHandler.SelectionHandler<T>> selectionHandlers = new ArrayList<>();
  private final List<HasDeselectionHandler.DeselectionHandler> deselectionHandlers =
      new ArrayList<>();
  private String key;
  private V value;

  private LazyChild<IsElement<?>> indicatorIcon;

  Menu<V> menu;
  MenuItemsGroup<V, T> itemGroup;

  public AbstractMenuItem() {
    root = DominoElement.li().addCss(menu_item);

    linkElement =
        DominoElement.of(a("#"))
            .setAttribute("tabindex", "0")
            .setAttribute("aria-expanded", "true")
                .addCss(menu_item_anchor);
    root.appendChild(linkElement);

    indicatorIcon = createIndicator(Icons.ALL.menu_right_mdi());

    init((T) this);

    this.addEventListener(
        EventType.touchstart.getName(),
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          focus();
          openSubMenu();
        });
    this.addEventListener(EventType.touchend.getName(), this::onSelected);
    this.addEventListener(EventType.click.getName(), this::onSelected);
    this.addEventListener(EventType.mouseenter.getName(), evt -> openSubMenu());
  }

  private LazyChild<IsElement<?>> createIndicator(IsElement<?> element) {
    return LazyChild.of(DominoElement.of(element).addCss(menu_item_anchor, dui_clickable), root);
  }

  private void onSelected(Event evt) {
    evt.stopPropagation();
    evt.preventDefault();
    if(parent.isMultiSelect() && isSelected()){
      deselect();
    }else {
      select();
    }
  }

  /**
   * Appends a {@link IsElement} to the contentElement
   *
   * @param element {@link IsElement} to be appended to the component
   * @return same menu item instance
   */
  @Override
  public T appendChild(IsElement<?> element) {
    linkElement.appendChild(DominoElement.of(element));
    return (T) this;
  }

  @Override
  public T appendChild(Node node) {
    linkElement.appendChild(node);
    return (T) this;
  }

  /**
   * Apply a search token matching on the menu item
   *
   * @param token String search text
   * @param caseSensitive boolean, true if the search is case-sensitive
   * @return boolean, true if the menu item match the search token, false if not
   */
  public boolean onSearch(String token, boolean caseSensitive) {
    if (isNull(token) || token.isEmpty()) {
      this.show();
    } else {
      hide();
    }
    return false;
  }

  /**
   * Selects the menu item and trigger the select handlers
   *
   * @return same menu item instance
   */
  public T select() {
    return select(false);
  }

  /**
   * Deselects the menu item and trigger the selection handlers
   *
   * @return same menu item instance
   */
  public T deselect() {
    return deselect(false);
  }

  /**
   * Selects the menu item with the option to trigger/disable the select handlers
   *
   * @param silent boolean, true to avoid triggering the select handlers.
   * @return same menu item instance
   */
  public T select(boolean silent) {
    if (!isDisabled()) {
      addCss(menu_item_selected);
      setAttribute("selected", true);
      if (!silent) {
        selectionHandlers.forEach(handler -> handler.onSelection((T) this));
      }
      if(nonNull(parent)) {
        parent.onItemSelected(this);
      }
    }
    return (T) this;
  }

  /**
   * Deselect the menu item with the option to trigger/disable the select handlers
   *
   * @param silent boolean, true to avoid triggering the select handlers.
   * @return same menu item instance
   */
  public T deselect(boolean silent) {
    if (!isDisabled()) {
      menu_item_selected.remove(this);
      setAttribute("selected", false);
      if (!silent) {
        deselectionHandlers.forEach(DeselectionHandler::onDeselection);
      }
      if(nonNull(parent)) {
        parent.onItemDeselected(this);
      }
    }
    return (T) this;
  }

  /** @return boolean, true if the menu item is selected */
  public boolean isSelected() {
    return Optional.ofNullable(getAttribute("selected")).map(Boolean::parseBoolean).orElse(false);
  }

  /** {@inheritDoc} */
  @Override
  public T addSelectionHandler(HasSelectionHandler.SelectionHandler<T> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.add(selectionHandler);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T removeSelectionHandler(HasSelectionHandler.SelectionHandler<T> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.remove(selectionHandler);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T addDeselectionHandler(DeselectionHandler deselectionHandler) {
    if (nonNull(deselectionHandler)) {
      deselectionHandlers.add(deselectionHandler);
    }
    return (T) this;
  }

  /**
   * Force focus on the menu item
   *
   * @return same menu item instance
   */
  public T focus() {
    getClickableElement().focus();
    return (T) this;
  }

  void setParent(Menu<V> menu) {
    this.parent = menu;
  }

  /** @return String unique key of the menu item */
  public String getKey() {
    return key;
  }

  /**
   * @param key String unique key of the menu item
   * @return String menu iten unique key
   */
  public T setKey(String key) {
    this.key = key;
    return (T) this;
  }

  /** @return the value of the menu item */
  public V getValue() {
    return value;
  }

  /**
   * @param value the value of the meu item
   * @return same menu item instance
   */
  public void setValue(V value) {
    this.value = value;
  }

  /**
   * @param value the value of the meu item
   * @return same menu item instance
   */
  public T value(V value) {
    setValue(value);
    return (T) this;
  }

  /** @return the {@link FlexItem} that represent the current menu nesting indication. */
  public LazyChild<IsElement<?>> getNestingIndicator() {
    return indicatorIcon;
  }

  /**
   * Sets a custom menu nesting indicator
   *
   * @param nestingIndicator {@link FlexItem}
   * @return same menu item
   */
  public T setNestingIndicator(IsElement<?> nestingIndicator) {
    if (nonNull(nestingIndicator)) {
      indicatorIcon.remove();
      indicatorIcon = createIndicator(DominoElement.of(nestingIndicator));
      indicatorIcon.get();
    }
    return (T) this;
  }

  /**
   * Sets the sub-menu of the menu item
   *
   * @param menu {@link Menu}
   * @return same menu item
   */
  public T setMenu(Menu<V> menu) {
    this.menu = menu;
    if (nonNull(this.menu)) {
      this.menu.setAttribute("domino-sub-menu", true);
      this.menu.removeAttribute("domino-ui-root-menu");
      indicatorIcon.get();
      this.menu.setTargetElement(this);
      this.menu.setDropDirection(new BestFitSideDropDirection());
      this.menu.setParentItem(this);
    } else {
      this.indicatorIcon.remove();
    }
    return (T) this;
  }

  /** Opens the sub-menu of the menu item */
  public void openSubMenu() {
    if (nonNull(menu)) {
      DelayedExecution.execute(
          () -> {
            if (nonNull(parent)) {
              this.menu.setParent(parent);
              if (!this.parent.isDropDown()
                  || (this.parent.isDropDown() && this.parent.isOpened())) {
                this.parent.openSubMenu(this.menu);
              }
            }
          },
          200);
    } else {
      DelayedExecution.execute(
          () -> {
            if (nonNull(parent)) {
              parent.closeCurrentOpen();
            }
          },
          200);
    }
  }

  private void openSelfMenu() {
    PopupsCloser.close();
    this.menu.open();
    this.parent.setCurrentOpen(this.menu);
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

  T bindToGroup(MenuItemsGroup<V, T> group) {
    this.itemGroup = group;
    return (T) this;
  }

  T unbindGroup() {
    this.itemGroup= null;
    return (T) this;
  }

  public boolean isGrouped() {
    return Optional.ofNullable(this.itemGroup).isPresent();
  }

  /** @return The parent {@link Menu} of the menu item */
  public Menu<V> getParent() {
    return this.parent;
  }

  /** {@inheritDoc} */
  public boolean hasMenu() {
    return nonNull(this.menu);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getClickableElement() {
    return linkElement.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return root.element();
  }
}
