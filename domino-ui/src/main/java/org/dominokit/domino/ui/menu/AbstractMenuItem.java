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

import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.BestFitSideDropDirection;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;

/**
 * The base implementation for {@link org.dominokit.domino.ui.menu.Menu} items
 *
 * @param <V> The type of the menu item value
 */
public class AbstractMenuItem<V> extends BaseDominoElement<HTMLLIElement, AbstractMenuItem<V>>
    implements HasSelectionHandler<AbstractMenuItem<V>, AbstractMenuItem<V>>,
        HasDeselectionHandler<AbstractMenuItem<V>>,
        TakesValue<V>,
        MenuStyles {

  protected final LIElement root;
  protected final AnchorElement linkElement;

  protected Menu<V> parent;

  private final List<HasSelectionHandler.SelectionHandler<AbstractMenuItem<V>>> selectionHandlers =
      new ArrayList<>();
  private final List<HasDeselectionHandler.DeselectionHandler> deselectionHandlers =
      new ArrayList<>();
  private String key;
  private V value;

  private LazyChild<IsElement<?>> indicatorIcon;

  Menu<V> menu;
  MenuItemsGroup<V> itemGroup;

  protected DivElement prefixElement;
  protected DivElement bodyElement;
  protected DivElement postfixElement;
  protected DivElement nestedIndicatorElement;
  protected boolean searchable = true;

  /** Constructor for AbstractMenuItem. */
  public AbstractMenuItem() {
    root = li().addCss(dui_menu_item);

    linkElement =
        a("#")
            .setAttribute("tabindex", "0")
            .setAttribute("aria-expanded", "true")
            .addCss(dui_menu_item_anchor)
            .appendChild(prefixElement = div().addCss(dui_menu_item_prefix))
            .appendChild(bodyElement = div().addCss(dui_menu_item_body))
            .appendChild(postfixElement = div().addCss(dui_menu_item_postfix))
            .appendChild(nestedIndicatorElement = div().addCss(dui_menu_item_nested_indicator));
    root.appendChild(linkElement);

    indicatorIcon = createIndicator(Icons.menu_right());

    init(this);

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
    return LazyChild.of(elementOf(element), nestedIndicatorElement);
  }

  private void onSelected(Event evt) {
    evt.stopPropagation();
    evt.preventDefault();
    if (parent.isMultiSelect() && isSelected()) {
      deselect();
    } else {
      select();
    }
  }

  /** {@inheritDoc} */
  @Override
  public Element getAppendTarget() {
    return bodyElement.element();
  }

  /**
   * isSearchable.
   *
   * @return a boolean
   */
  public boolean isSearchable() {
    return searchable;
  }

  /**
   * Setter for the field <code>searchable</code>.
   *
   * @param searchable a boolean
   * @param <T> a T class
   * @return a T object
   */
  public <T extends AbstractMenuItem<V>> T setSearchable(boolean searchable) {
    this.searchable = searchable;
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
  public AbstractMenuItem<V> select() {
    return select(false);
  }

  /**
   * Deselects the menu item and trigger the selection handlers
   *
   * @return same menu item instance
   */
  public AbstractMenuItem<V> deselect() {
    return deselect(false);
  }

  /**
   * Selects the menu item with the option to trigger/disable the select handlers
   *
   * @param silent boolean, true to avoid triggering the select handlers.
   * @return same menu item instance
   * @param <T> a T class
   */
  public <T extends AbstractMenuItem<V>> T select(boolean silent) {
    if (!isDisabled()) {
      addCss(dui_menu_item_selected);
      setAttribute("selected", true);
      if (!silent) {
        selectionHandlers.forEach(handler -> handler.onSelection(this));
      }
      if (nonNull(parent)) {
        parent.onItemSelected(this, silent);
      }
    }
    return (T) this;
  }

  /**
   * Deselect the menu item with the option to trigger/disable the select handlers
   *
   * @param silent boolean, true to avoid triggering the select handlers.
   * @return same menu item instance
   * @param <T> a T class
   */
  public <T extends AbstractMenuItem<V>> T deselect(boolean silent) {
    if (!isDisabled()) {
      dui_menu_item_selected.remove(this);
      setAttribute("selected", false);
      if (!silent) {
        deselectionHandlers.forEach(DeselectionHandler::onDeselection);
      }
      if (nonNull(parent)) {
        parent.onItemDeselected(this, silent);
      }
    }
    return (T) this;
  }

  /** @return boolean, true if the menu item is selected */
  /**
   * isSelected.
   *
   * @return a boolean
   */
  public boolean isSelected() {
    return Optional.ofNullable(getAttribute("selected")).map(Boolean::parseBoolean).orElse(false);
  }

  /** {@inheritDoc} */
  @Override
  public AbstractMenuItem<V> addSelectionHandler(
      HasSelectionHandler.SelectionHandler<AbstractMenuItem<V>> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.add(selectionHandler);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public AbstractMenuItem<V> removeSelectionHandler(
      HasSelectionHandler.SelectionHandler<AbstractMenuItem<V>> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.remove(selectionHandler);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public AbstractMenuItem<V> addDeselectionHandler(DeselectionHandler deselectionHandler) {
    if (nonNull(deselectionHandler)) {
      deselectionHandlers.add(deselectionHandler);
    }
    return this;
  }

  /**
   * Force focus on the menu item
   *
   * @return same menu item instance
   */
  public AbstractMenuItem<V> focus() {
    getClickableElement().focus();
    return this;
  }

  void setParent(Menu<V> menu) {
    this.parent = menu;
  }

  /** @return String unique key of the menu item */
  /**
   * Getter for the field <code>key</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getKey() {
    return key;
  }

  /**
   * Setter for the field <code>key</code>.
   *
   * @param key String unique key of the menu item
   * @return String menu iten unique key
   * @param <T> a T class
   */
  public <T extends AbstractMenuItem<V>> T setKey(String key) {
    this.key = key;
    return (T) this;
  }

  /** @return the value of the menu item */
  /**
   * Getter for the field <code>value</code>.
   *
   * @return a V object
   */
  public V getValue() {
    return value;
  }

  /**
   * Setter for the field <code>value</code>.
   *
   * @param value the value of the meu item
   */
  public void setValue(V value) {
    this.value = value;
  }

  /**
   * withValue.
   *
   * @param value the value of the meu item
   * @return same menu item instance
   * @param <T> a T class
   */
  public <T extends AbstractMenuItem<V>> T withValue(V value) {
    setValue(value);
    return (T) this;
  }

  /** @return the {@link Element} that represent the current menu nesting indication. */
  /**
   * getNestingIndicator.
   *
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public LazyChild<IsElement<?>> getNestingIndicator() {
    return indicatorIcon;
  }

  /**
   * Sets a custom menu nesting indicator
   *
   * @param nestingIndicator {@link elemental2.dom.Element}
   * @return same menu item
   */
  public AbstractMenuItem<V> setNestingIndicator(IsElement<?> nestingIndicator) {
    if (nonNull(nestingIndicator)) {
      indicatorIcon.remove();
      indicatorIcon = createIndicator(elementOf(nestingIndicator));
      indicatorIcon.get();
    }
    return this;
  }

  /**
   * Sets the sub-menu of the menu item
   *
   * @param menu {@link org.dominokit.domino.ui.menu.Menu}
   * @return same menu item
   */
  public AbstractMenuItem<V> setMenu(Menu<V> menu) {
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
    return this;
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
  public AbstractMenuItem<V> closeSubMenu() {
    if (nonNull(this.menu)) {
      this.menu.close();
    }
    return this;
  }

  AbstractMenuItem<V> bindToGroup(MenuItemsGroup<V> group) {
    this.itemGroup = group;
    return this;
  }

  AbstractMenuItem<V> unbindGroup() {
    this.itemGroup = null;
    return this;
  }

  /**
   * isGrouped.
   *
   * @return a boolean
   */
  public boolean isGrouped() {
    return Optional.ofNullable(this.itemGroup).isPresent();
  }

  /** @return The parent {@link Menu} of the menu item */
  /**
   * Getter for the field <code>parent</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> getParent() {
    return this.parent;
  }

  /**
   * {@inheritDoc}
   *
   * @return a boolean
   */
  public boolean hasMenu() {
    return nonNull(this.menu);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getClickableElement() {
    return linkElement.element();
  }

  /**
   * appendChild.
   *
   * @param postfixAddOn a {@link org.dominokit.domino.ui.utils.PostfixAddOn} object
   * @param <T> a T class
   * @return a T object
   */
  public <T extends AbstractMenuItem<V>> T appendChild(PostfixAddOn<?> postfixAddOn) {
    postfixElement.appendChild(postfixAddOn);
    return (T) this;
  }

  /**
   * appendChild.
   *
   * @param prefixAddOn a {@link org.dominokit.domino.ui.utils.PrefixAddOn} object
   * @param <T> a T class
   * @return a T object
   */
  public <T extends AbstractMenuItem<V>> T appendChild(PrefixAddOn<?> prefixAddOn) {
    prefixElement.appendChild(prefixAddOn);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return root.element();
  }
}
