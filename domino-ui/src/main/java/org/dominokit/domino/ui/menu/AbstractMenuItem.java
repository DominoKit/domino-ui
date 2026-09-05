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
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import java.util.*;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.base.IsMenuItem;
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
public class AbstractMenuItem<V> extends BaseDominoElement<HTMLElement, AbstractMenuItem<V>>
    implements HasSelectionListeners<AbstractMenuItem<V>, AbstractMenuItem<V>, AbstractMenuItem<V>>,
        HasSelectionMode<AbstractMenuItem<V>>,
        TakesValue<V>,
        MenuStyles,
        IsMenuItem<V, AbstractMenuItem<V>, AbstractMenuItem<V>>,
        Selectable<AbstractMenuItem<V>>,
        HasParent<Menu<V>>,
        HasMenu<Menu<V>> {

  protected final LIElement root;
  protected final AnchorElement linkElement;

  protected Menu<V> parent;

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
  public SingleSelectionMode selectionMode = SingleSelectionMode.INHERIT;

  private boolean selectionListenersPaused = false;
  private Set<SelectionListener<? super AbstractMenuItem<V>, ? super AbstractMenuItem<V>>>
      selectionListeners;
  private Set<SelectionListener<? super AbstractMenuItem<V>, ? super AbstractMenuItem<V>>>
      deselectionListeners;

  /** Default constructor to create a menu item. */
  public AbstractMenuItem() {
    root = li().addCss(dui_menu_item);

    linkElement =
        a("#")
            .setAttribute("tabindex", "0")
            .setAttribute("role", "menuitem")
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
            onSelected();
          }
        });
    this.addEventListener(
        EventType.click.getName(),
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          onSelected();
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
    return LazyChild.of(element, nestedIndicatorElement);
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
   * @return the current instance of the menu item
   */
  public AbstractMenuItem<V> setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  private void onSelected() {
    onSelected(false);
  }

  private void onSelected(boolean silent) {
    boolean selected = isSelected();
    SingleSelectionMode mode = getEffectiveSelectionMode();

    // If we’re in multi-select & already selected, or in TOGGLE mode → deselect
    if ((nonNull(parent) && parent.isMultiSelect() && selected)
        || (selected && mode == SingleSelectionMode.TOGGLE)) {
      deselect(silent);
    }
    // Otherwise, if not selected (always select) or in RESELECT mode (re-select) → select
    else if (!selected || mode == SingleSelectionMode.RESELECT) {
      select(silent);
    }
  }

  /**
   * Sets the selection state of this item.
   *
   * @param selected true to select, false to deselect
   * @return this item (for chaining)
   */
  public AbstractMenuItem<V> setSelected(boolean selected) {
    return setSelected(selected, false);
  }

  /**
   * Sets the selection state of this item, optionally silencing events.
   *
   * <p>When selected is true, selection logic obeys the current {@link
   * #getEffectiveSelectionMode()}.
   *
   * @param selected true to select, false to deselect
   * @param silent if true, selection/deselection handlers and listeners are not notified
   * @return this item (for chaining)
   */
  public AbstractMenuItem<V> setSelected(boolean selected, boolean silent) {
    if (selected) {
      onSelected(silent);
    } else {
      deselect(silent);
    }
    return this;
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
   * @return the current instance of the menu item
   */
  public AbstractMenuItem<V> setSearchable(boolean searchable) {
    this.searchable = searchable;
    return this;
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
  public AbstractMenuItem<V> select(boolean silent) {
    if (!isDisabled() && isSelectable()) {
      addCss(
          ConditionalCssClass.of(
              dui_menu_item_selected, () -> nonNull(parent) && parent.isPreserveSelectionStyles()));
      setAttribute("selected", true);
      if (!silent) {
        triggerSelectionListeners(this, getSelection());
      }
      if (nonNull(parent)) {
        parent.onItemSelected(this, silent, parent.isOpened());
      }
    }
    return this;
  }

  /**
   * Deselects the menu item.
   *
   * <p>Removes selection styling and notifies the deselection handlers if not silent.
   *
   * @param silent if {@code true}, the deselection handlers won't be notified
   * @return the current instance of the menu item
   */
  public AbstractMenuItem<V> deselect(boolean silent) {
    if (!isDisabled() && isSelectable()) {
      dui_menu_item_selected.remove(this);
      setAttribute("selected", false);
      if (!silent) {
        triggerDeselectionListeners(this, getSelection());
      }
      if (nonNull(parent)) {
        parent.onItemDeselected(this, silent, parent.isOpened());
      }
    }
    return this;
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
      linkElement
          .setAttribute("aria-haspopup", true)
          .setAttribute("aria-expanded", false)
          .setAttribute("aria-controls", this.menu.getDominoId());
      this.menu
          .addOpenListener(opened -> linkElement.setAttribute("aria-expanded", true))
          .addCloseListener(closed -> linkElement.setAttribute("aria-expanded", false));
    } else {
      this.indicatorIcon.remove();
      linkElement.removeAttribute("aria-haspopup");
      linkElement.removeAttribute("aria-expanded");
      linkElement.removeAttribute("aria-controls");
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

  @Override
  public boolean isRootItem() {
    return isNull(parent) || getParent().isRootMenu();
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

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(prefixElement);
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(postfixElement);
  }

  /**
   * Allows customizing the indicator container element.
   *
   * @param handler a handler that receives this menu item and the indicator container element
   * @return this item (for chaining)
   */
  public AbstractMenuItem<V> withIndicatorContainer(
      ChildHandler<AbstractMenuItem<V>, DivElement> handler) {
    handler.apply(this, nestedIndicatorElement);
    return this;
  }

  /**
   * Allows customizing the body element that contains the content of the item.
   *
   * @param handler a handler that receives this menu item and the body element
   * @return this item (for chaining)
   */
  public AbstractMenuItem<V> withBodyElement(
      ChildHandler<AbstractMenuItem<V>, DivElement> handler) {
    handler.apply(this, bodyElement);
    return this;
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
  public AbstractMenuItem<V> setSearchFilter(MenuSearchFilter searchFilter) {
    this.searchFilter = searchFilter;
    return this;
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
   * Sets the selection mode behavior for single selection scenarios.
   *
   * @param selectionMode the selection mode to apply; use {@link SingleSelectionMode#INHERIT} to
   *     inherit from the parent menu
   * @return this item (for chaining)
   */
  public AbstractMenuItem<V> setSelectionMode(SingleSelectionMode selectionMode) {
    this.selectionMode = selectionMode;
    return this;
  }

  /**
   * Resolves the effective {@link SingleSelectionMode} for this item.
   *
   * <p>If this item is configured with {@link SingleSelectionMode#INHERIT}, the value is resolved
   * from the parent menu (falling back to {@link SingleSelectionMode#RESELECT} if no parent is
   * present). Otherwise, returns the explicitly configured value.
   *
   * @return the effective selection mode to be used
   */
  public SingleSelectionMode getEffectiveSelectionMode() {
    if (SingleSelectionMode.INHERIT.equals(this.selectionMode)) {
      return isNull(parent) ? SingleSelectionMode.RESELECT : parent.getEffectiveSelectionMode();
    }
    return this.selectionMode;
  }

  /**
   * Temporarily pauses notifying selection/deselection listeners registered via {@link
   * #getSelectionListeners()} and {@link #getDeselectionListeners()}.
   *
   * @return this item (for chaining)
   */
  @Override
  public AbstractMenuItem<V> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /**
   * Resumes notifying selection/deselection listeners after a previous {@link
   * #pauseSelectionListeners()}.
   *
   * @return this item (for chaining)
   */
  @Override
  public AbstractMenuItem<V> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /**
   * Toggles the paused state for selection/deselection listeners.
   *
   * @param toggle true to pause listeners, false to resume them
   * @return this item (for chaining)
   */
  @Override
  public AbstractMenuItem<V> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /**
   * Lazily returns the set of selection listeners that will be notified on selection changes.
   *
   * @return a mutable set of selection listeners (never null)
   */
  @Override
  public Set<SelectionListener<? super AbstractMenuItem<V>, ? super AbstractMenuItem<V>>>
      getSelectionListeners() {
    if (isNull(this.selectionListeners)) {
      this.selectionListeners = new HashSet<>();
    }
    return this.selectionListeners;
  }

  /**
   * Lazily returns the set of deselection listeners that will be notified on selection changes.
   *
   * @return a mutable set of deselection listeners (never null)
   */
  @Override
  public Set<SelectionListener<? super AbstractMenuItem<V>, ? super AbstractMenuItem<V>>>
      getDeselectionListeners() {
    if (isNull(this.deselectionListeners)) {
      this.deselectionListeners = new HashSet<>();
    }
    return this.deselectionListeners;
  }

  /**
   * Indicates whether selection/deselection listeners are currently paused.
   *
   * @return true if listeners are paused, false otherwise
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * Notifies all registered selection listeners about a new selection.
   *
   * @param source the item that initiated the change (optional)
   * @param selection the item that is currently selected
   * @return this item (for chaining)
   */
  @Override
  public AbstractMenuItem<V> triggerSelectionListeners(
      AbstractMenuItem<V> source, AbstractMenuItem<V> selection) {
    getSelectionListeners()
        .forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Notifies all registered deselection listeners about a deselection event.
   *
   * @param source the item that initiated the change (optional)
   * @param selection the item that was deselected
   * @return this item (for chaining)
   */
  @Override
  public AbstractMenuItem<V> triggerDeselectionListeners(
      AbstractMenuItem<V> source, AbstractMenuItem<V> selection) {
    getDeselectionListeners()
        .forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Returns this item if it is currently selected; otherwise returns null.
   *
   * @return the selected item (this), or null if not selected
   */
  @Override
  public AbstractMenuItem<V> getSelection() {
    if (isSelected()) {
      return this;
    }
    return null;
  }

  @Override
  public Menu<V> getMenu() {
    return this.menu;
  }

  @Override
  public AbstractMenuItem<V> remove() {
    if (nonNull(parent)) {
      parent.removeItem(this);
    } else {
      return super.remove();
    }
    return this;
  }

  void doRemove() {
    super.remove();
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
