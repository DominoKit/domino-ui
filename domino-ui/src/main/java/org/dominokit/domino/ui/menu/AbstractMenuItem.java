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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.core.JsDate;
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
import org.dominokit.domino.ui.style.ConditionalCssClass;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;

/**
 * Represents a general purpose menu item that can be used in different types of menus.
 *
 * <p>Usage example:
 *
 * <pre>
 * AbstractMenuItem<String> item = new AbstractMenuItem<>();
 * item.setKey("item1").withValue("Value1");
 * </pre>
 *
 * @param <V> the type parameter defining the value of the menu item
 * @see BaseDominoElement
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
  protected boolean selectable = true;

  protected MenuSearchFilter searchFilter = (token, caseSensitive) -> false;

  /** Default constructor to create a menu item. */
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
    double[] startTime = new double[] {0};

    this.addEventListener(
        EventType.touchstart.getName(),
        evt -> {
          startTime[0] = JsDate.now();
          focus();
          openSubMenu();
        });
    this.addEventListener(
        EventType.touchend.getName(),
        evt -> {
          evt.stopPropagation();
          double endTime = JsDate.now();
          double diff = endTime - startTime[0];
          if (diff < 200) {
            evt.preventDefault();
            onSelected(evt);
          }
        });
    this.addEventListener(
        EventType.click.getName(),
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          onSelected(evt);
        });
    this.addEventListener(EventType.mouseenter.getName(), evt -> openSubMenu());
  }

  /**
   * Creates an indicator for the menu item.
   *
   * <p>This is used for visual indication, typically for sub-menu expansions or other visual cues.
   *
   * @param element the visual element representing the indicator
   * @return a lazy child representation of the indicator for later instantiation
   */
  private LazyChild<IsElement<?>> createIndicator(IsElement<?> element) {
    return LazyChild.of(elementOf(element), nestedIndicatorElement);
  }

  /**
   * Determines whether the menu item is selectable.
   *
   * @return true if the item is selectable, false otherwise
   */
  public boolean isSelectable() {
    return selectable;
  }

  /**
   * Sets the selectable property of the menu item.
   *
   * @param selectable true to make the item selectable, false otherwise
   * @param <T> the type of the menu item
   * @return the current instance of the menu item
   */
  public <T extends AbstractMenuItem<V>> T setSelectable(boolean selectable) {
    this.selectable = selectable;
    return (T) this;
  }

  private void onSelected(Event evt) {
    if (parent.isMultiSelect() && isSelected()) {
      deselect();
    } else {
      select();
    }
  }

  /**
   * Gets the target element to which child elements can be appended.
   *
   * @return the body element of the menu item
   */
  @Override
  public Element getAppendTarget() {
    return bodyElement.element();
  }

  /**
   * Determines whether the menu item is searchable.
   *
   * @return true if the item is searchable, false otherwise
   */
  public boolean isSearchable() {
    return searchable;
  }

  /**
   * Sets the searchable property of the menu item.
   *
   * @param searchable true to make the item searchable, false otherwise
   * @param <T> the type of the menu item
   * @return the current instance of the menu item
   */
  public <T extends AbstractMenuItem<V>> T setSearchable(boolean searchable) {
    this.searchable = searchable;
    return (T) this;
  }

  /**
   * Performs a search on the menu item based on the given token.
   *
   * <p>This method typically determines the visibility of the menu item based on the search token.
   *
   * @param token the search token or keyword
   * @param caseSensitive determines if the search should consider case sensitivity
   * @return always returns {@code false}; the reason for this should be provided based on the
   *     method's context
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
   * Selects the menu item without notifying the selection handlers.
   *
   * @return the current instance of the menu item
   */
  public AbstractMenuItem<V> select() {
    return select(false);
  }

  /**
   * Deselects the menu item without notifying the deselection handlers.
   *
   * @return the current instance of the menu item
   */
  public AbstractMenuItem<V> deselect() {
    return deselect(false);
  }

  /**
   * Selects the menu item.
   *
   * <p>Adds selection styling and notifies the selection handlers if not silent.
   *
   * @param silent if {@code true}, the selection handlers won't be notified
   * @return the current instance of the menu item
   */
  public <T extends AbstractMenuItem<V>> T select(boolean silent) {
    if (!isDisabled() && isSelectable()) {
      addCss(
          ConditionalCssClass.of(dui_menu_item_selected, () -> parent.isPreserveSelectionStyles()));
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
   * Deselects the menu item.
   *
   * <p>Removes selection styling and notifies the deselection handlers if not silent.
   *
   * @param silent if {@code true}, the deselection handlers won't be notified
   * @return the current instance of the menu item
   */
  public <T extends AbstractMenuItem<V>> T deselect(boolean silent) {
    if (!isDisabled() && isSelectable()) {
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

  /**
   * Checks if the menu item is currently selected.
   *
   * @return {@code true} if the menu item is selected, {@code false} otherwise
   */
  public boolean isSelected() {
    return Optional.ofNullable(getAttribute("selected")).map(Boolean::parseBoolean).orElse(false);
  }

  /**
   * Adds a selection handler to the menu item.
   *
   * <p>The provided handler will be invoked when the menu item is selected.
   *
   * @param selectionHandler the handler to be added
   * @return the current instance of the menu item
   */
  @Override
  public AbstractMenuItem<V> addSelectionHandler(
      HasSelectionHandler.SelectionHandler<AbstractMenuItem<V>> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.add(selectionHandler);
    }
    return this;
  }

  /**
   * Removes a previously added selection handler from the menu item.
   *
   * @param selectionHandler the handler to be removed
   * @return the current instance of the menu item
   */
  @Override
  public AbstractMenuItem<V> removeSelectionHandler(
      HasSelectionHandler.SelectionHandler<AbstractMenuItem<V>> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.remove(selectionHandler);
    }
    return this;
  }

  /**
   * Adds a deselection handler to the menu item.
   *
   * <p>The provided handler will be invoked when the menu item is deselected.
   *
   * @param deselectionHandler the handler to be added
   * @return the current instance of the menu item
   */
  @Override
  public AbstractMenuItem<V> addDeselectionHandler(DeselectionHandler deselectionHandler) {
    if (nonNull(deselectionHandler)) {
      deselectionHandlers.add(deselectionHandler);
    }
    return this;
  }

  /**
   * Sets focus on the clickable element of the menu item.
   *
   * @return the current instance of the menu item
   */
  public AbstractMenuItem<V> focus() {
    getClickableElement().focus();
    return this;
  }

  /**
   * Sets the parent menu for this menu item.
   *
   * @param menu the parent menu
   */
  void setParent(Menu<V> menu) {
    this.parent = menu;
  }

  /**
   * Retrieves the key associated with this menu item.
   *
   * @return the key of the menu item
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets the key for this menu item.
   *
   * <p>This can be useful for programmatically distinguishing menu items.
   *
   * @param key the key to set
   * @return the current instance of the menu item with the specified key set
   */
  public <T extends AbstractMenuItem<V>> T setKey(String key) {
    this.key = key;
    return (T) this;
  }

  /**
   * Retrieves the value associated with this menu item.
   *
   * @return the value of the menu item
   */
  public V getValue() {
    return value;
  }

  /**
   * Sets the value for this menu item.
   *
   * <p>This can represent any associated data or context for the item.
   *
   * @param value the value to set
   */
  public void setValue(V value) {
    this.value = value;
  }

  /**
   * Assigns a value to the menu item and returns the item instance.
   *
   * <p>This is a fluid API method to allow chained calls.
   *
   * @param value the value to set
   * @return the current instance of the menu item with the specified value set
   */
  public <T extends AbstractMenuItem<V>> T withValue(V value) {
    setValue(value);
    return (T) this;
  }

  /**
   * Retrieves the nesting indicator for this menu item.
   *
   * <p>The nesting indicator typically indicates sub-menu existence.
   *
   * @return the current nesting indicator of the menu item
   */
  public LazyChild<IsElement<?>> getNestingIndicator() {
    return indicatorIcon;
  }

  /**
   * Sets a new nesting indicator for the menu item.
   *
   * <p>This replaces the existing nesting indicator with the provided one.
   *
   * @param nestingIndicator the new nesting indicator element
   * @return the current instance of the menu item with the specified nesting indicator set
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
   * Sets a sub-menu for this menu item.
   *
   * @param menu the sub-menu to be associated with this item
   * @return the current instance of the menu item with the specified sub-menu set
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

  /**
   * Opens the sub-menu associated with this menu item. If there's no sub-menu, it will close the
   * current open menu after a delay.
   */
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

  /** Opens the associated sub-menu immediately, closing other popups. */
  private void openSelfMenu() {
    PopupsCloser.close();
    this.menu.open();
    this.parent.setCurrentOpen(this.menu);
  }

  /** Callback for when the parent menu is closed. */
  void onParentClosed() {
    closeSubMenu();
  }

  /**
   * Closes the associated sub-menu of this menu item.
   *
   * @return the current instance of the menu item
   */
  public AbstractMenuItem<V> closeSubMenu() {
    if (nonNull(this.menu)) {
      this.menu.close();
    }
    return this;
  }

  /**
   * Binds this menu item to a specific menu item group.
   *
   * @param group the menu item group to bind to
   * @return the current instance of the menu item bound to the specified group
   */
  AbstractMenuItem<V> bindToGroup(MenuItemsGroup<V> group) {
    this.itemGroup = group;
    return this;
  }

  /**
   * Unbinds this menu item from any associated menu item group.
   *
   * @return the current instance of the menu item unbound from any group
   */
  AbstractMenuItem<V> unbindGroup() {
    this.itemGroup = null;
    return this;
  }

  /**
   * Checks if the menu item is associated with a menu item group.
   *
   * @return true if the menu item is part of a group, false otherwise
   */
  public boolean isGrouped() {
    return Optional.ofNullable(this.itemGroup).isPresent();
  }

  /**
   * Retrieves the parent menu of this menu item.
   *
   * @return the parent menu of this item
   */
  public Menu<V> getParent() {
    return this.parent;
  }

  /**
   * Determines if this menu item has an associated sub-menu.
   *
   * @return true if there is a sub-menu, false otherwise
   */
  public boolean hasMenu() {
    return nonNull(this.menu);
  }

  /**
   * Retrieves the clickable element associated with this menu item.
   *
   * @return the HTML element that can be clicked to trigger this menu item
   */
  @Override
  public HTMLElement getClickableElement() {
    return linkElement.element();
  }

  /**
   * Appends a child to the postfix element.
   *
   * @param postfixAddOn the postfix add-on to append
   * @param <T> the type of the menu item
   * @return the current instance of the menu item
   */
  public <T extends AbstractMenuItem<V>> T appendChild(PostfixAddOn<?> postfixAddOn) {
    postfixElement.appendChild(postfixAddOn);
    return (T) this;
  }

  /**
   * Appends a child to the prefix element.
   *
   * @param prefixAddOn the prefix add-on to append
   * @param <T> the type of the menu item
   * @return the current instance of the menu item
   */
  public <T extends AbstractMenuItem<V>> T appendChild(PrefixAddOn<?> prefixAddOn) {
    prefixElement.appendChild(prefixAddOn);
    return (T) this;
  }

  /**
   * Retrieves the current {@link MenuSearchFilter} used for search operations.
   *
   * @return the current {@link MenuSearchFilter}
   */
  public MenuSearchFilter getSearchFilter() {
    return searchFilter;
  }

  /**
   * Sets the {@link MenuSearchFilter} to be used during search operations.
   *
   * @param searchFilter the search filter to set
   * @return this Menu item instance for chaining
   */
  public <T extends AbstractMenuItem<V>> T setSearchFilter(MenuSearchFilter searchFilter) {
    this.searchFilter = searchFilter;
    return (T) this;
  }

  /**
   * Check if the menu item text starts with a specific string
   *
   * @param character the text to check against.
   * @return boolean, <b>true</b> if the menu item starts with the text, <b>false</b> otherwise.
   */
  public boolean startsWith(String character) {
    return false;
  }

  /**
   * Returns the underlying DOM element.
   *
   * @return the DOM element of the menu item
   */
  @Override
  public HTMLLIElement element() {
    return root.element();
  }
}
