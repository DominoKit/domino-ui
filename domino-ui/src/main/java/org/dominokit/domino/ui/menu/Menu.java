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

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_order_first;
import static org.dominokit.domino.ui.utils.Domino.dui_order_last;
import static org.dominokit.domino.ui.utils.Domino.li;
import static org.dominokit.domino.ui.utils.Domino.ul;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.base.BaseMenu;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.utils.AnyElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.KeyboardNavigation;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PopupsCloser;
import org.dominokit.domino.ui.utils.Separator;
import org.dominokit.domino.ui.utils.SupplyOnce;

/**
 * Represents a UI Menu component that supports different configurations, items, and behaviors.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * Menu<String> myMenu = Menu.create()
 *    .setTitle("My Menu")
 *    .setIcon(Icons.ALL.menu())
 *    .appendChild(new MenuItem<>("Menu Item 1"));
 * </pre>
 *
 * @param <V> The type of the item value that the menu holds.
 * @see BaseDominoElement
 */
public class Menu<V> extends BaseMenu<V, Menu<V>, AbstractMenuItem<V>, AbstractMenuItem<V>> {

  private UListElement menuItemsList;
  private final DivElement menuBody;
  private final LazyChild<DivElement> menuFooter;

  private final LazyChild<MdiIcon> backIcon;
  protected DivElement menuElement;

  protected List<AbstractMenuItem<V>> menuItems = new ArrayList<>();

  private Menu<V> currentOpen;

  private Menu<V> parent;
  private AbstractMenuItem<V> parentItem;

  private final DivElement backArrowContainer;
  private boolean searchable;

  /**
   * Factory method to create a new Menu instance.
   *
   * @param <V> The type of the menu item value.
   * @return A new menu instance.
   */
  public static <V> Menu<V> create() {
    return new Menu<>();
  }

  /** Default constructor to initialize the Menu component. */
  public Menu() {
    menuElement = div().addCss(dui_menu).setAttribute("role", "menu");
    setMenuAppendTarget(document.body);
    menuHeader = LazyChild.of(NavBar.create(), menuElement);
    menuSearchContainer = LazyChild.of(div().addCss(dui_menu_search), menuElement);
    searchBox =
        LazyChild.of(
            SupplyOnce.of(() -> SearchBox.create().addCss(dui_menu_search_box)),
            menuSearchContainer);
    backArrowContainer = div().addCss(dui_order_first, dui_menu_back_icon);
    init(this);
    closeOnScrollListener = evt -> close();

    onAttached(
        (mutationRecord) -> {
          if (isCloseOnScroll()) {
            window.addEventListener("scroll", closeOnScrollListener, true);
          }
        });

    onDetached(
        (mutationRecord) -> {
          if (isCloseOnScroll()) {
            window.removeEventListener("scroll", closeOnScrollListener, true);
          }
        });

    windowResizeListener = evt -> position();
    nowAndWhenAttached(
        () -> {
          if (isDropDown()) {
            window.addEventListener("resize", windowResizeListener);
          }
        });
    onDetached(
        (mutationRecord) -> {
          if (isDropDown()) {
            window.removeEventListener("resize", windowResizeListener);
          }
        });

    EventListener addMissingEventListener =
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
          onAddMissingElement();
        };

    onKeyDown(
        keyEvents -> {
          keyEvents.alphanumeric(
              evt -> {
                KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
                focusFirstMatch(keyboardEvent.key);
              });
        });

    menuSubHeader = LazyChild.of(div().addCss(dui_menu_sub_header), menuElement);

    menuItemsList = ul().addCss(dui_menu_items_list);
    noResultElement =
        LazyChild.of(
            AnyElement.of(li()).addCss(dui_menu_no_results, dui_order_last), menuItemsList);
    menuBody = div().addCss(dui_menu_body);
    menuElement.appendChild(menuBody.appendChild(menuItemsList));

    menuFooter = LazyChild.of(div().addCss(dui_menu_footer), menuBody);

    createMissingElement =
        LazyChild.of(
            a("#")
                .setAttribute("tabindex", "0")
                .setAttribute("aria-expanded", "true")
                .addCss(dui_menu_create_missing),
            menuFooter);
    createMissingElement.whenInitialized(
        () -> {
          createMissingElement
              .element()
              .removeEventListener("click", addMissingEventListener)
              .addClickListener(addMissingEventListener);

          createMissingElement
              .element()
              .onKeyDown(
                  keyEvents -> {
                    keyEvents
                        .clearAll()
                        .onEnter(addMissingEventListener)
                        .onTab(evt -> keyboardNavigation.focusTopFocusableItem())
                        .onArrowDown(
                            evt -> {
                              evt.stopPropagation();
                              evt.preventDefault();
                              if (isSearchable()) {
                                this.searchBox
                                    .get()
                                    .getTextBox()
                                    .getInputElement()
                                    .element()
                                    .focus();
                              } else {
                                keyboardNavigation.focusTopFocusableItem();
                              }
                            })
                        .onArrowUp(
                            evt -> {
                              evt.stopPropagation();
                              evt.preventDefault();
                              keyboardNavigation.focusBottomFocusableItem();
                            });
                  });
        });

    searchBox.whenInitialized(
        () -> {
          searchBox.element().addSearchListener(this::onSearch);
          this.searchBox
              .element()
              .getTextBox()
              .getInputElement()
              .onKeyDown(
                  keyEvents ->
                      keyEvents
                          .onArrowDown(
                              evt -> {
                                evt.stopPropagation();
                                evt.preventDefault();
                                Optional<AbstractMenuItem<V>> topFocusableItem =
                                    keyboardNavigation.getTopFocusableItem();
                                if (topFocusableItem.isPresent()) {
                                  keyboardNavigation.focusTopFocusableItem();
                                } else {
                                  if (isAllowCreateMissing()
                                      && createMissingElement.element().isAttached()) {
                                    createMissingElement.get().element().focus();
                                  }
                                }
                              })
                          .onArrowUp(
                              evt -> {
                                evt.stopPropagation();
                                evt.preventDefault();
                                if (isAllowCreateMissing()
                                    && createMissingElement.element().isAttached()) {
                                  createMissingElement.get().element().focus();
                                } else {
                                  keyboardNavigation.focusBottomFocusableItem();
                                }
                              })
                          .onEscape(evt -> close())
                          .onEnter(
                              evt ->
                                  keyboardNavigation
                                      .getTopFocusableItem()
                                      .ifPresent(AbstractMenuItem::select)));
        });

    keyboardNavigation =
        KeyboardNavigation.create(menuItems)
            .setTabOptions(new KeyboardNavigation.EventOptions(false, true))
            .setTabHandler(
                (event, item) -> {
                  if (keyboardNavigation.isLastFocusableItem(item)) {
                    event.preventDefault();
                    if (isSearchable()) {
                      this.searchBox.get().getTextBox().getInputElement().element().focus();
                    } else {
                      keyboardNavigation.focusTopFocusableItem();
                    }
                  }
                })
            .setEnterHandler((event, item) -> item.select())
            .registerNavigationHandler("ArrowRight", (event, item) -> item.openSubMenu())
            .registerNavigationHandler(
                "ArrowLeft",
                (event, item) -> {
                  if (nonNull(getParentItem())) {
                    getParentItem().focus();
                    this.close();
                  }
                })
            .onSelect((event, item) -> item.select())
            .focusCondition(item -> !item.isCollapsed() && !item.isDisabled())
            .onFocus(
                item -> {
                  if (isDropDown()) {
                    if (isOpened()) {
                      item.focus();
                    }
                  } else {
                    item.focus();
                  }
                })
            .onEscape(this::close)
            .setOnEndReached(
                navigation -> {
                  if (isAllowCreateMissing() && createMissingElement.element().isAttached()) {
                    createMissingElement.get().element().focus();
                  } else if (isSearchable()) {
                    this.searchBox.get().getTextBox().getInputElement().element().focus();
                  } else {
                    navigation.focusTopFocusableItem();
                  }
                })
            .setOnStartReached(
                navigation -> {
                  if (isSearchable()) {
                    this.searchBox.get().getTextBox().getInputElement().element().focus();
                  } else if (isAllowCreateMissing()
                      && createMissingElement.element().isAttached()) {
                    createMissingElement.get().element().focus();
                  } else {
                    navigation.focusBottomFocusableItem();
                  }
                });
    ;

    element.addEventListener("keydown", keyboardNavigation);

    backIcon = LazyChild.of(Icons.keyboard_backspace().addCss(dui_menu_back_icon), menuHeader);
    backIcon.whenInitialized(
        () -> {
          backIcon
              .get()
              .clickable()
              .addClickListener(this::backToParent)
              .addEventListener("touchend", this::backToParent)
              .addEventListener("touchstart", Event::stopPropagation);
        });

    lostFocusListener =
        evt -> {
          if (isDropDown() && isCloseOnBlur()) {
            DomGlobal.setTimeout(
                p0 -> {
                  Element e = DomGlobal.document.activeElement;
                  if (getTarget().isPresent()) {
                    Element target = getTarget().get().getTargetElement().element();
                    if (!(target.contains(e)
                        || e.equals(target)
                        || this.element().contains(e)
                        || e.equals(this.element()))) {
                      close();
                    }
                  } else {
                    if (!(this.element().contains(e) || e.equals(this.element()))) {
                      close();
                    }
                  }
                },
                0);
          }
        };

    nowAndWhenAttached(
        () -> {
          document.addEventListener(PopupsCloser.DUI_AUTO_CLOSE, autoCloseListener);
          mediaQueryRecords.add(
              MediaQuery.addOnSmallAndDownListener(
                  () -> {
                    if (centerOnSmallScreens) {
                      this.smallScreen = true;
                    }
                  }));

          mediaQueryRecords.add(
              MediaQuery.addOnMediumAndUpListener(
                  () -> {
                    if (centerOnSmallScreens) {
                      this.smallScreen = false;
                      backArrowContainer.remove();
                    }
                  }));

          DomGlobal.document.body.addEventListener("blur", lostFocusListener, true);
          if (this.dropDown) {
            document.addEventListener("scroll", repositionListener, true);
          }
        });

    nowAndWhenDetached(
        () -> {
          DomGlobal.document.body.removeEventListener("blur", lostFocusListener, true);
          document.removeEventListener("scroll", repositionListener, true);
          mediaQueryRecords.forEach(MediaQuery.MediaQueryListenerRecord::remove);
          document.removeEventListener(PopupsCloser.DUI_AUTO_CLOSE, autoCloseListener);
        });

    this.addEventListener(EventType.touchstart.getName(), Event::stopPropagation);
    this.addEventListener(EventType.touchend.getName(), Event::stopPropagation);

    onAttachHandler =
        (mutationRecord) -> {
          position();
          if (shouldFocus) {
            focus();
          }
        };

    onDetachHandler =
        (mutationRecord) -> {
          close();
          if (isDropDown()) {
            triggerCloseListeners(this);
          }
        };
  }

  @Override
  public void focusFirstMatch(String token) {
    findOptionStarsWith(token).ifPresent(AbstractMenuItem::focus);
  }

  @Override
  public Optional<AbstractMenuItem<V>> findOptionStarsWith(String token) {
    return this.menuItems.stream()
        .filter(menuItem -> !menuItem.isGrouped())
        .filter(dropDownItem -> dropDownItem.startsWith(token))
        .findFirst();
  }

  /**
   * Appends a menu item to the menu.
   *
   * @param menuItem The menu item to be added.
   * @return The current Menu instance.
   */
  public Menu<V> appendChild(AbstractMenuItem<V> menuItem) {
    if (nonNull(menuItem)) {
      if (menuItem instanceof MenuItemsGroup) {
        appendChild((MenuItemsGroup<V>) menuItem, group -> {});
      } else {
        menuItemsList.appendChild(menuItem);
        menuItems.add(menuItem);
        afterAddItem(menuItem);
      }
    }
    return this;
  }

  public Menu<V> appendChild(AbstractMenuItem<V>... menuItems) {
    Arrays.stream(menuItems).forEach(this::appendChild);
    return this;
  }

  /**
   * Inserts a menu item to the menu at the specified index, the index should be within the valid
   * range otherwise an exception is thrown.
   *
   * @param index The index to insert the menu item at.
   * @param menuItem The menu item to be added.
   * @return The current Menu instance.
   */
  public Menu<V> insertChild(int index, AbstractMenuItem<V> menuItem) {
    if (nonNull(menuItem)) {
      if (index < 0 || (index > 0 && index >= menuItemsList.getChildElementCount())) {
        throw new IndexOutOfBoundsException(
            "Could not insert menu item at index ["
                + index
                + "], index out of range [0,"
                + (menuItemsList.getChildElementCount() - 1)
                + "]");
      }
      if (menuItemsList.getChildElementCount() > 0) {
        DominoElement<Element> elementDominoElement = menuItemsList.childElements().get(index);
        menuItemsList.insertBefore(menuItem, elementDominoElement);
        menuItems.add(index, menuItem);
      } else {
        menuItemsList.appendChild(menuItem);
        menuItems.add(menuItem);
      }
      afterAddItem(menuItem);
    }
    return this;
  }

  /**
   * Appends a menu items group to the menu with a provided handler.
   *
   * @param <I> The type of the abstract menu item.
   * @param menuGroup The menu items group to be added.
   * @param groupHandler The handler for the menu items group.
   * @return The current Menu instance.
   */
  public <I extends AbstractMenuItem<V>> Menu<V> appendChild(
      MenuItemsGroup<V> menuGroup, MenuItemsGroupHandler<V, I> groupHandler) {
    if (nonNull(menuGroup)) {
      menuItemsList.appendChild(menuGroup);
      menuItems.add(menuGroup);
      menuGroup.setParent(this);
      groupHandler.handle(menuGroup);
    }
    return this;
  }

  /**
   * Inserts a menu items group to the menu at the specified index, the index should be within the
   * valid range otherwise an exception is thrown.
   *
   * @param index The index to insert the menu items group at.
   * @param <I> The type of the abstract menu item.
   * @param menuGroup The menu items group to be added.
   * @param groupHandler The handler for the menu items group.
   * @return The current Menu instance.
   */
  public <I extends AbstractMenuItem<V>> Menu<V> insertGroup(
      int index, MenuItemsGroup<V> menuGroup, MenuItemsGroupHandler<V, I> groupHandler) {
    if (nonNull(menuGroup)) {

      if (index < 0 || (index > 0 && index >= menuItemsList.getChildElementCount())) {
        throw new IndexOutOfBoundsException(
            "Could not insert menu item at index ["
                + index
                + "], index out of range [0,"
                + (menuItemsList.getChildElementCount() - 1)
                + "]");
      }
      if (menuItemsList.getChildElementCount() > 0) {
        DominoElement<Element> elementDominoElement = menuItemsList.childElements().get(index);
        menuItemsList.insertBefore(menuGroup, elementDominoElement);
        menuItems.add(index, menuGroup);
      } else {
        menuItemsList.appendChild(menuGroup);
        menuItems.add(menuGroup);
      }
      menuGroup.setParent(this);
      groupHandler.handle(menuGroup);
    }
    return this;
  }

  /**
   * Removes a menu item from the menu.
   *
   * @param menuItem The menu item to be removed.
   * @return The current Menu instance.
   */
  public Menu<V> removeItem(AbstractMenuItem<V> menuItem) {
    if (this.menuItems.contains(menuItem)) {
      menuItem.doRemove();
      this.menuItems.remove(menuItem);
    }
    return this;
  }

  /**
   * Removes a menu item from the menu at the specified index.
   *
   * @param index the index of the menu item to be removed.
   * @return The current Menu instance.
   */
  public Menu<V> removeItemAt(int index) {
    return removeItem(menuItems.get(index));
  }

  /**
   * Removes all items and sub-items from the menu.
   *
   * @return The current Menu instance.
   */
  public Menu<V> removeAll() {
    new ArrayList<>(menuItems).forEach(this::removeItem);
    menuItems.clear();
    closeCurrentOpen();
    currentOpen = null;
    menuItemsList
        .querySelectorAll("." + dui_menu_separator.getCssClass())
        .forEach(BaseDominoElement::remove);
    return this;
  }

  /**
   * Appends a separator to the menu.
   *
   * @param separator The separator to be added.
   * @return The current Menu instance.
   */
  public Menu<V> appendChild(Separator separator) {
    this.menuItemsList.appendChild(separator.addCss(dui_menu_separator));
    return this;
  }

  /**
   * Inserts a separator to the menu at the specified index, the index should be within the valid
   * range otherwise an exception is thrown.
   *
   * @param index The index to insert the separator at.
   * @param separator The separator to be added.
   * @return The current Menu instance.
   */
  public Menu<V> insertChild(int index, Separator separator) {
    if (nonNull(separator)) {
      if (index < 0 || (index > 0 && index >= menuItemsList.getChildElementCount())) {
        throw new IndexOutOfBoundsException(
            "Could not insert menu item at index ["
                + index
                + "], index out of range [0,"
                + (menuItemsList.getChildElementCount() - 1)
                + "]");
      }

      if (menuItemsList.getChildElementCount() > 0) {
        DominoElement<Element> elementDominoElement = menuItemsList.childElements().get(index);
        menuItemsList.insertBefore(separator, elementDominoElement);
      } else {
        this.menuItemsList.appendChild(separator.addCss(dui_menu_separator));
      }
    }

    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Retrieves the main HTMLDivElement element representing this menu.
   *
   * @return the main HTMLDivElement element.
   */
  @Override
  public HTMLDivElement element() {
    return menuElement.element();
  }

  /** Clears the contents of the search box within the menu. */
  private void clearSearch() {
    searchBox.get().clearSearch();
  }

  /**
   * Clears the current selection of menu items.
   *
   * @param silent if true, does not trigger the deselection listeners; otherwise, does.
   */
  public void clearSelection(boolean silent) {
    selectedValues.clear();
    if (!silent) {
      triggerDeselectionListeners(null, selectedValues);
    }
  }

  /**
   * Filters the menu items based on a given search token.
   *
   * <p>If no results match, a "no results" message is displayed.
   *
   * @param token the string to use for filtering the menu items.
   * @return true if one or more items match the search token, false otherwise.
   */
  public boolean onSearch(String token) {
    this.menuItems.forEach(AbstractMenuItem::closeSubMenu);
    boolean emptyToken = emptyToken(token);
    if (emptyToken) {
      this.createMissingElement.remove();
    }
    if (isAllowCreateMissing() && !emptyToken) {
      createMissingElement.get().setInnerHtml(getConfig().getMissingItemCreateMessage(token));
    }
    long count =
        this.menuItems.stream()
            .filter(menuItem -> !menuItem.isGrouped())
            .filter(dropDownItem -> dropDownItem.onSearch(token, isCaseSensitive()))
            .count();

    if (count < 1 && menuItems.size() > 0) {
      this.menuItemsList.appendChild(
          noResultElement.get().setInnerHtml(getConfig().getNoResultMatchMessage(token)));
    } else {
      noResultElement.remove();
    }

    position();
    return count > 0;
  }

  @Override
  protected void afterAddItem(AbstractMenuItem<V> item) {
    item.setParent(this);
    onItemAdded(item);
  }

  /**
   * Retrieves the list of direct menu items (excluding sub-menu items) contained in this menu.
   *
   * @return the list of direct menu items.
   */
  public List<AbstractMenuItem<V>> getMenuItems() {
    return menuItems;
  }

  /**
   * Retrieves a flattened list of all menu items, including items within groups.
   *
   * <p>This method will return both direct menu items and those that are part of a {@link
   * MenuItemsGroup}.
   *
   * @return a flattened list of all menu items.
   */
  public List<AbstractMenuItem<V>> getFlatMenuItems() {
    List<AbstractMenuItem<V>> items = new ArrayList<>();
    menuItems.forEach(
        item -> {
          if (item instanceof MenuItemsGroup) {
            ((MenuItemsGroup<?>) item)
                .getMenuItems()
                .forEach(subItem -> items.add((AbstractMenuItem<V>) subItem));
          } else {
            items.add(item);
          }
        });
    return items;
  }

  /**
   * Opens the specified submenu and closes the currently open submenu.
   *
   * @param dropMenu The submenu to open.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> openSubMenu(Menu<V> dropMenu) {
    if (dropMenu.hasVisibleItems()) {
      if (!Objects.equals(currentOpen, dropMenu)) {
        closeCurrentOpen();
      }
      dropMenu.open();
      setCurrentOpen(dropMenu);
    }

    return this;
  }

  /**
   * Sets the current open submenu.
   *
   * @param dropMenu The submenu to be set as currently open.
   */
  void setCurrentOpen(Menu<V> dropMenu) {
    this.currentOpen = dropMenu;
  }

  /** Closes the currently open submenu. */
  void closeCurrentOpen() {
    if (nonNull(currentOpen)) {
      currentOpen.close();
    }
  }

  /**
   * Closes the current menu and reopens its parent menu.
   *
   * @param evt The event that triggered the action.
   */
  private void backToParent(Event evt) {
    evt.stopPropagation();
    evt.preventDefault();

    this.close();
    if (nonNull(parent)) {
      this.parent.open(isAutoFocus());
    }
  }

  /**
   * Sets the parent menu for the current menu. This is typically used for sub-menus.
   *
   * @param parent The parent menu.
   */
  void setParent(Menu<V> parent) {
    this.parent = parent;
  }

  /**
   * Retrieves the parent menu of the current menu.
   *
   * @return The parent menu or null if there isn't any.
   */
  public Menu<V> getParent() {
    return parent;
  }

  /**
   * Sets the menu item that acts as the parent for the current menu.
   *
   * @param parentItem The parent menu item.
   */
  void setParentItem(AbstractMenuItem<V> parentItem) {
    this.parentItem = parentItem;
  }

  /**
   * Retrieves the menu item that acts as the parent for the current menu.
   *
   * @return The parent menu item or null if there isn't any.
   */
  public AbstractMenuItem<V> getParentItem() {
    return parentItem;
  }

  @Override
  protected IsElement<? extends Element> getNoResultParentElement() {
    return this.menuItemsList;
  }

  @Override
  protected HTMLElement getListFocusElement() {
    if (!this.menuItems.isEmpty()) {
      return menuItems.get(0).getClickableElement();
    } else {
      return this.menuItemsList.element();
    }
  }

  @Override
  public Menu<V> selectAt(int index, boolean silent) {
    if (index < menuItems.size() && index >= 0) {
      select(menuItems.get(index), silent);
    }
    return this;
  }

  @Override
  public Menu<V> selectByKey(String key, boolean silent) {
    for (AbstractMenuItem<V> menuItem : getMenuItems()) {
      if (menuItem.getKey().equals(key)) {
        select(menuItem, silent);
      }
    }
    return this;
  }

  @Override
  protected boolean hasVisibleItems() {
    for (int index = 0; index < menuItems.size(); index++) {
      if (menuItems.get(index).isVisible()) {
        return true;
      }
    }
    return false;
  }

  @Override
  protected void onOpenForSmallScreen() {
    if (nonNull(parent) && parent.isDropDown()) {
      parent.collapse();
      menuHeader.get().insertFirst(backArrowContainer);
    }
  }

  @Override
  public SingleSelectionMode getEffectiveSelectionMode() {
    if (SingleSelectionMode.INHERIT.equals(this.selectionMode)) {
      return isNull(parent)
          ? config().getUIConfig().getDefaultSelectionMode()
          : parent.getEffectiveSelectionMode();
    }
    return this.selectionMode;
  }

  protected DivElement getMenuElement() {
    return menuElement;
  }

  @Override
  protected void onItemSelected(AbstractMenuItem<V> item, boolean silent, boolean shouldClose) {
    if (nonNull(parent)) {
      parent.onItemSelected(item, silent, shouldClose);
    } else {
      if (shouldClose && isAutoCloseOnSelect() && !item.hasMenu()) {
        close();
        PopupsCloser.close();
      }
      if (!this.selectedValues.contains(item)) {
        if (!multiSelect && !this.selectedValues.isEmpty()) {
          new ArrayList<>(this.selectedValues)
              .forEach(
                  menuItem -> {
                    menuItem.deselect(silent);
                    this.selectedValues.remove(menuItem);
                  });
        }
        this.selectedValues.add(item);
        if (!silent) {
          triggerSelectionListeners(item, getSelection());
        }
      }
    }
  }

  @Override
  protected void onItemDeselected(AbstractMenuItem<V> item, boolean silent, boolean shouldClose) {
    if (nonNull(parent)) {
      parent.onItemDeselected(item, silent, shouldClose);
    } else {
      if (shouldClose && isAutoCloseOnSelect() && !item.hasMenu()) {
        close();
        PopupsCloser.close();
      }
      this.selectedValues.remove(item);
      if (!silent) {
        triggerDeselectionListeners(item, getSelection());
      }
    }
  }

  @Override
  protected void onClosed() {
    menuItems.forEach(AbstractMenuItem::onParentClosed);
    if (smallScreen && nonNull(parent) && parent.isDropDown()) {
      parent.expand();
    }
  }

  /**
   * Checks if the menu has a search functionality enabled.
   *
   * @return true if the menu is searchable, false otherwise.
   */
  public boolean isSearchable() {
    return searchable;
  }

  /**
   * Enables or disables the search functionality within the menu.
   *
   * @param searchable true to enable search, false to disable.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setSearchable(boolean searchable) {
    if (searchable) {
      searchBox.get();
    } else {
      searchBox.remove();
      menuSearchContainer.remove();
    }
    this.searchable = searchable;
    return this;
  }

  public boolean isRootMenu() {
    return isNull(parentItem);
  }

  @Override
  protected Element getMenuListElement() {
    return menuItemsList.element();
  }

  /** Represents a handler for a group of menu items. */
  @FunctionalInterface
  public interface MenuItemsGroupHandler<V, I extends AbstractMenuItem<V>> {

    /**
     * Handles the group of menu items.
     *
     * @param initializedGroup The group of menu items.
     */
    void handle(MenuItemsGroup<V> initializedGroup);
  }
}
