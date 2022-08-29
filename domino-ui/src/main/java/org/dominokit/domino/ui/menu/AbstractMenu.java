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
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.MenuStyles.*;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.direction.BestSideUpDownDropDirection;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.menu.direction.MiddleOfScreenDropDirection;
import org.dominokit.domino.ui.menu.direction.MouseBestFitDirection;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * The base component to create a menu like UI.
 *
 * @param <V> The type of the menu items value
 * @param <T> The type of the class extending from this base class
 */
public abstract class AbstractMenu<V, T extends AbstractMenu<V, T>>
    extends BaseDominoElement<HTMLDivElement, T> {

  private final LazyChild<MenuHeader> menuHeader;
  private final LazyChild<DominoElement<HTMLDivElement>> menuSearchContainer;
  private final LazyChild<SearchBox> searchBox;
  private final LazyChild<DominoElement<HTMLDivElement>> menuSubHeader;
  private final DominoElement<HTMLUListElement> menuItemsList;
  private final DominoElement<HTMLDivElement> menuBody;
  private final LazyChild<DominoElement<HTMLAnchorElement>> createMissingElement;
  private final LazyChild<MdiIcon> backIcon;
  private LazyChild<DominoElement<HTMLLIElement>> noResultElement;
  protected DominoElement<HTMLDivElement> menuElement;

  private HTMLElement focusElement;
  protected KeyboardNavigation<AbstractMenuItem<V, ?>> keyboardNavigation;

  protected boolean searchable;
  protected boolean caseSensitive = false;
  protected String createMissingLabel = "Create ";
  private MissingItemHandler<T> missingItemHandler;

  protected List<AbstractMenuItem<V, ?>> menuItems = new ArrayList<>();
  protected boolean autoCloseOnSelect = true;
  protected final List<MenuItemSelectionHandler<V>> selectionHandlers = new ArrayList<>();
  protected boolean headerVisible = false;
  private AbstractMenu<V, ?> currentOpen;

  private boolean smallScreen;
  private DropDirection dropDirection = new BestSideUpDownDropDirection();
  private final DropDirection contextMenuDropDirection = new MouseBestFitDirection();
  private final DropDirection smallScreenDropDirection = new MiddleOfScreenDropDirection();
  private DropDirection effectiveDropDirection = dropDirection;
  private HTMLElement targetElement;
  private HTMLElement appendTarget = document.body;
  private AppendStrategy appendStrategy = AppendStrategy.LAST;

  private final List<AbstractMenu.CloseHandler> closeHandlers = new ArrayList<>();
  private final List<AbstractMenu.OpenHandler> openHandlers = new ArrayList<>();

  private AbstractMenu<V, ?> parent;
  private AbstractMenuItem<V, ?> parentItem;
  private final EventListener openListener =
      evt -> {
        evt.stopPropagation();
        evt.preventDefault();
        getEffectiveDropDirection().init(evt);
        open();
      };
  private final FlexItem<HTMLDivElement> backArrowContainer =
      FlexItem.create().setOrder(0).css("back-arrow-icon").hide();
  private boolean contextMenu = false;
  private boolean useSmallScreensDirection = true;
  private boolean dropDown = false;

  private OnAddItemHandler<V, T> onAddItemHandler = (menu, menuItem) -> {};

  public AbstractMenu() {
    menuElement = DominoElement.div().addCss(MENU);
    menuHeader = LazyChild.of(new MenuHeader(), menuElement);
    menuSearchContainer = LazyChild.of(DominoElement.div().addCss(MENU_SEARCH), menuElement);
    searchBox = LazyChild.of(SearchBox.create(), menuSearchContainer);

    createMissingElement =
        LazyChild.of(
            DominoElement.a("#")
                .setAttribute("tabindex", "0")
                .setAttribute("aria-expanded", "true")
                .addCss(MENU_CREATE_MISSING),
            menuSearchContainer);
    createMissingElement.whenInitialized(
        () -> {
          createMissingElement
              .get()
              .addClickListener(
                  evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();
                    onAddMissingElement();
                  });

          KeyboardEvents.listenOnKeyDown(createMissingElement.get())
              .onEnter(
                  evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();
                    onAddMissingElement();
                  });
        });
    searchBox.whenInitialized(
        () -> {
          searchBox.get().addSearchListener(this::onSearch);
          KeyboardEvents.listenOnKeyDown(this.searchBox.get().getTextBox().getInputElement())
              .onArrowDown(
                  evt -> {
                    if (isAllowCreateMissing() && createMissingElement.get().isAttached()) {
                      createMissingElement.get().element().focus();
                    } else {
                      keyboardNavigation.focusAt(0);
                    }
                  });
        });

    menuSubHeader = LazyChild.of(DominoElement.div().addCss(MENU_SUB_HEADER), menuElement);

    menuItemsList = DominoElement.ul().addCss(MENU_ITEMS_LIST);
    noResultElement = LazyChild.of(DominoElement.li().addCss(MENU_NO_RESULTS), menuItemsList);
    menuBody = DominoElement.div().addCss(MENU_BODY);
    menuElement.appendChild(menuBody.appendChild(menuItemsList));

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
            .onEscape(this::close);

    element.addEventListener("keydown", keyboardNavigation);

    MediaQuery.addOnMediumAndDownListener(
        () -> {
          this.smallScreen = true;
        });
    MediaQuery.addOnLargeAndUpListener(
        () -> {
          this.smallScreen = false;
          menuHeader.get().toggleDisplay(headerVisible);
          backArrowContainer.hide();
        });
    backIcon = LazyChild.of(Icons.ALL.keyboard_backspace_mdi().addCss(MENU_BACK_ICON), menuHeader);
    backIcon.whenInitialized(
        () -> {
          backIcon
              .get()
              .clickable()
              .addClickListener(this::backToParent)
              .addEventListener("touchend", this::backToParent)
              .addEventListener("touchstart", Event::stopPropagation);
        });
  }

  private void onAddMissingElement() {
    missingItemHandler.onMissingItem(searchBox.get().getTextBox().getValue(), (T) this);
    onSearch(searchBox.get().getTextBox().getValue());
  }

  /**
   * Set the menu icon in the header, setting the icon will force the header to show up if not
   * visible
   *
   * @param icon Any Icon instance that extends from {@link BaseIcon}
   * @return the same menu instance
   */
  public T setIcon(BaseIcon<?> icon) {
    menuHeader.get().setIcon(icon);
    return (T) this;
  }

  /**
   * Set the menu title in the header, setting the title will force the header to show up if not
   * visible
   *
   * @param title String
   * @return same menu instance
   */
  public T setTitle(String title) {
    menuHeader.get().setTitle(title);
    return (T) this;
  }

  /**
   * Appends an element to menu actions bar, appending an action element will force the header to
   * show up if not visible
   *
   * @param element {@link HTMLElement}
   * @return same menu instance
   */
  public T appendAction(HTMLElement element) {
    menuHeader.get().appendAction(element);
    return (T) this;
  }

  /**
   * Appends an element to menu actions bar, appending an action element will force the header to
   * show up if not visible
   *
   * @param element {@link IsElement}
   * @return same menu instance
   */
  public T appendAction(IsElement<?> element) {
    menuHeader.get().appendAction(element);
    return (T) this;
  }

  /**
   * Appends a child element to the menu subheader, the subheader will show up below the search and
   * before the menu items.
   *
   * @param element {@link HTMLElement}
   * @return same menu instance
   */
  public T appendSubHeaderChild(HTMLElement element) {
    menuSubHeader.get().appendChild(element);
    return (T) this;
  }

  /**
   * Appends a child element to the menu subheader, the subheader will show up below the search and
   * before the menu items.
   *
   * @param element {@link IsElement}
   * @return same menu instance
   */
  public T appendSunHeaderChild(IsElement<?> element) {
    menuSubHeader.get().appendChild(element);
    return (T) this;
  }

  /**
   * Appends a menu item to this menu
   *
   * @param menuItem {@link AbstractMenu}
   * @return same menu instance
   */
  public T appendChild(AbstractMenuItem<V, ?> menuItem) {
    if (nonNull(menuItem)) {
      menuItemsList.appendChild(menuItem);
      menuItems.add(menuItem);
      menuItem.setParent(this);
      onAddItemHandler.onAdded(this, menuItem);
    }
    return (T) this;
  }

  /**
   * Appends a menu item to this menu
   *
   * @param menuGroup {@link MenuItemsGroup}
   * @return same menu instance
   */
  public <I extends AbstractMenuItem<V, I>, G extends MenuItemsGroup<V, I, G>> T appendGroup(
      G menuGroup, MenuItemsGroupHandler<V, I, G> groupHandler) {
    if (nonNull(menuGroup)) {
      menuItemsList.appendChild(menuGroup);
      menuItems.add(menuGroup);
      menuGroup.setParent(this);
      groupHandler.handle(menuGroup);
    }
    return (T) this;
  }

  /**
   * Removes a menu item from this menu
   *
   * @param menuItem {@link AbstractMenu}
   * @return same menu instance
   */
  public T removeItem(AbstractMenuItem<V, ?> menuItem) {
    if (this.menuItems.contains(menuItem)) {
      menuItem.remove();
      this.menuItems.remove(menuItem);
    }
    return (T) this;
  }

  /**
   * Removes all menu items from this menu
   *
   * @return same menu instance
   */
  public T removeAll() {
    menuItems.forEach(BaseDominoElement::remove);
    menuItems.clear();
    closeCurrentOpen();
    currentOpen = null;
    return (T) this;
  }

  /**
   * Appends a separator item to this menu, separator will show up as a simple border.
   *
   * @return same menu instance
   */
  public T appendSeparator() {
    this.menuItemsList.appendChild(
        DominoElement.li().add(DominoElement.span().addCss(MENU_SEPARATOR)));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return menuElement.element();
  }

  private void clearSearch() {
    searchBox.get().clearSearch();
  }

  /**
   * If search is enabled, when search is trigger it will call this method.
   *
   * @param token String user input in the {@link SearchBox}
   * @return boolean, true if there is at least one menu item that matched the search token, else
   *     will return false.
   */
  public boolean onSearch(String token) {
    this.menuItems.forEach(AbstractMenuItem::closeSubMenu);
    boolean emptyToken = emptyToken(token);
    if (emptyToken) {
      this.createMissingElement.remove();
    }
    if (isAllowCreateMissing() && !emptyToken) {
      createMissingElement.get().setInnerHtml(getCreateMissingLabel() + "<b>" + token + "</b>");
    }
    long count =
        this.menuItems.stream()
            .filter(menuItem -> !menuItem.isGrouped())
            .filter(dropDownItem -> dropDownItem.onSearch(token, isCaseSensitive()))
            .count();

    if (count < 1 && menuItems.size() > 0) {
      this.menuItemsList.appendChild(
          noResultElement.get().setInnerHtml("No results matched " + " <b>" + token + "</b>"));
    } else {
      noResultElement.remove();
    }
    return count > 0;
  }

  /** @return String label that indicate the create missing items action */
  public String getCreateMissingLabel() {
    return createMissingLabel;
  }

  /**
   * Sets the label that will appear when no elements match the search, default is "create"
   *
   * @param createMissingLabel String
   * @return same menu instance
   */
  public T setCreateMissingLabel(String createMissingLabel) {
    if (isNull(createMissingLabel) || createMissingLabel.isEmpty()) {
      this.createMissingLabel = "Create ";
    } else {
      this.createMissingLabel = createMissingLabel;
    }
    return (T) this;
  }

  private boolean emptyToken(String token) {
    return isNull(token) || token.isEmpty();
  }

  /** @return a List of {@link AbstractMenuItem} of this menu */
  public List<AbstractMenuItem<V, ?>> getMenuItems() {
    return menuItems;
  }

  /**
   * @return The {@link DominoElement} of the {@link HTMLLIElement} that is used to represent no
   *     results when search is applied
   */
  public LazyChild<DominoElement<HTMLLIElement>> getNoResultElement() {
    return noResultElement;
  }

  /**
   * Sets a custom element to represent no results when search is applied.
   *
   * @param noResultElement {@link HTMLLIElement}
   * @return same menu instance
   */
  public T setNoResultElement(HTMLLIElement noResultElement) {
    if (nonNull(noResultElement)) {
      this.noResultElement.remove();
      this.noResultElement =
          LazyChild.of(DominoElement.of(noResultElement).addCss(MENU_NO_RESULTS), menuItemsList);
    }
    return (T) this;
  }

  /**
   * Sets a custom element to represent no results when search is applied.
   *
   * @param noResultElement {@link IsElement} of {@link HTMLLIElement}
   * @return same menu instance
   */
  public T setNoResultElement(IsElement<HTMLLIElement> noResultElement) {
    if (nonNull(noResultElement)) {
      setNoResultElement(noResultElement.element());
    }
    return (T) this;
  }

  /** @return boolean, true if this menu search is case-sensitive */
  public boolean isCaseSensitive() {
    return caseSensitive;
  }

  public T setCaseSensitive(boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
    return (T) this;
  }

  /** @return the {@link HTMLElement} that should be focused by default when open the menu */
  public HTMLElement getFocusElement() {
    if (isNull(this.focusElement)) {
      if (isSearchable()) {
        return this.searchBox.get().getTextBox().getInputElement().element();
      } else if (!this.menuItems.isEmpty()) {
        return menuItems.get(0).getClickableElement();
      } else {
        return this.menuItemsList.element();
      }
    }
    return focusElement;
  }

  /**
   * Sets a custom element as the default focus element of the menu
   *
   * @param focusElement {@link HTMLElement}
   * @return same menu instance
   */
  public T setFocusElement(HTMLElement focusElement) {
    this.focusElement = focusElement;
    return (T) this;
  }

  /**
   * Sets a custom element as the default focus element of the menu
   *
   * @param focusElement {@link IsElement}
   * @return same menu instance
   */
  public T setFocusElement(IsElement<? extends HTMLElement> focusElement) {
    return setFocusElement(focusElement.element());
  }

  /** @return the {@link SearchBox} of the menu */
  public SearchBox getSearchBox() {
    return searchBox.get();
  }

  /** @return The {@link KeyboardNavigation} of the menu */
  public KeyboardNavigation<AbstractMenuItem<V, ?>> getKeyboardNavigation() {
    return keyboardNavigation;
  }

  /** @return The {@link MenuHeader} component of the menu */
  public MenuHeader getMenuHeader() {
    return menuHeader.get();
  }

  /**
   * Change the visibility of the menu header
   *
   * @param visible boolean, True to show the header, false to hide it.
   * @return same menu instance
   */
  public T setHeaderVisible(boolean visible) {
    menuHeader.get().toggleDisplay(visible);
    this.headerVisible = visible;
    return (T) this;
  }

  /** @return boolean, true if search is enabled */
  public boolean isSearchable() {
    return searchable;
  }

  /** @return boolean, true if search is enabled */
  public boolean isAllowCreateMissing() {
    return nonNull(missingItemHandler);
  }

  /**
   * Enable/Disable search
   *
   * @param searchable boolean, true to search box and enable search, false to hide the search box
   *     and disable search.
   * @return same menu instance
   */
  public T setSearchable(boolean searchable) {
    if (searchable) {
      menuSearchContainer.get();
    } else {
      menuSearchContainer.remove();
    }
    this.searchable = searchable;
    return (T) this;
  }

  /**
   * Set a handler that will allow the user to handle a search that does not match any existing
   * items.
   *
   * @param missingItemHandler {@link MissingItemHandler}
   * @return same menu instance
   */
  public T setMissingItemHandler(MissingItemHandler<T> missingItemHandler) {
    this.missingItemHandler = missingItemHandler;
    return (T) this;
  }

  /**
   * Selects the specified menu item if it is one of this menu items
   *
   * @param menuItem {@link AbstractMenuItem}
   * @return same menu instance
   */
  public T select(AbstractMenuItem<V, ?> menuItem) {
    return select(menuItem, false);
  }

  /**
   * Selects the menu item at the specified index if exists
   *
   * @param menuItem {@link AbstractMenuItem}
   * @param silent boolean, true to avoid triggering change handlers
   * @return same menu instance
   */
  public T select(AbstractMenuItem<V, ?> menuItem, boolean silent) {
    menuItem.select(silent);
    return (T) this;
  }

  /**
   * Selects the menu item at the specified index if exists
   *
   * @param index int
   * @return same menu instance
   */
  public T selectAt(int index) {
    return selectAt(index, false);
  }

  /**
   * Selects the menu at the specified index if exists
   *
   * @param index int
   * @param silent boolean, true to avoid triggering change handlers
   * @return same menu instance
   */
  public T selectAt(int index, boolean silent) {
    if (index < menuItems.size() && index >= 0) select(menuItems.get(index), silent);
    return (T) this;
  }

  /**
   * Selects a menu item by its key if exists
   *
   * @param key String
   * @return same menu instance
   */
  public T selectByKey(String key) {
    return selectByKey(key, false);
  }

  /**
   * Selects a menu item by its key if exists with ability to avoid triggering change handlers
   *
   * @param key String
   * @param silent boolean, true to avoid triggering change handlers
   * @return same menu instance
   */
  public T selectByKey(String key, boolean silent) {
    for (AbstractMenuItem<V, ?> menuItem : getMenuItems()) {
      if (menuItem.getKey().equals(key)) {
        select(menuItem, silent);
      }
    }
    return (T) this;
  }

  /** @return boolean, true if the menu should close after selecting a menu item */
  public boolean isAutoCloseOnSelect() {
    return autoCloseOnSelect;
  }

  /**
   * @param autoCloseOnSelect boolean, if true the menu will close after selecting a menu item
   *     otherwise it remains open
   * @return same menu instance
   */
  public T setAutoCloseOnSelect(boolean autoCloseOnSelect) {
    this.autoCloseOnSelect = autoCloseOnSelect;
    return (T) this;
  }

  /**
   * Adds/removes the outer borders of the menu, this will add/remove the <b>menu-bordered</b> style
   *
   * @param bordered boolean, true to show borders, false to remove them
   * @return same menu instance
   */
  public T setBordered(boolean bordered) {
    removeCss("menu-bordered");
    if (bordered) {
      css("menu-bordered");
    }
    return (T) this;
  }

  /**
   * Adds a global selection handler that will apply to all menu items
   *
   * @param selectionHandler {@link MenuItemSelectionHandler}
   * @return same menu instance
   */
  public T addSelectionHandler(MenuItemSelectionHandler<V> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.add(selectionHandler);
    }
    return (T) this;
  }

  /**
   * removes a global selection handler that was applied to all menu items
   *
   * @param selectionHandler {@link MenuItemSelectionHandler}
   * @return same menu instance
   */
  public T removeSelectionHandler(MenuItemSelectionHandler<V> selectionHandler) {
    if (nonNull(selectionHandler)) {
      selectionHandlers.remove(selectionHandler);
    }
    return (T) this;
  }

  /**
   * Opens a sub menu that has this menu as its parent
   *
   * @param dropMenu {@link AbstractMenu} to open
   * @return same menu instance
   */
  public T openSubMenu(AbstractMenu<V, ?> dropMenu) {
    if (!Objects.equals(currentOpen, dropMenu)) {
      closeCurrentOpen();
    }
    dropMenu.open();
    setCurrentOpen(dropMenu);

    return (T) this;
  }

  void setCurrentOpen(AbstractMenu<V, ?> dropMenu) {
    this.currentOpen = dropMenu;
  }

  void closeCurrentOpen() {
    if (nonNull(currentOpen)) {
      currentOpen.close();
    }
  }

  private void backToParent(Event evt) {
    evt.stopPropagation();
    evt.preventDefault();

    this.close();
    if (nonNull(parent)) {
      this.parent.open(true);
    }
  }

  /** @return True if the menu is opened, false otherwise */
  public boolean isOpened() {
    return isDropDown() && element.isAttached();
  }

  /**
   * Opens the menu with a boolean to indicate if the first element should be focused
   *
   * @param focus true to focus the first element
   */
  public void open(boolean focus) {
    if (isDropDown()) {
      if (isOpened()) {
        getEffectiveDropDirection().position(element.element(), getTargetElement());
      } else {
        closeOthers();
        searchBox.get().clearSearch();
        onAttached(
            mutationRecord -> {
              getEffectiveDropDirection().position(element.element(), getTargetElement());
              if (focus) {
                focus();
              }
              element.setCssProperty("z-index", ModalBackDrop.getNextZIndex() + 10 + "");
              openHandlers.forEach(OpenHandler::onOpen);
              DominoElement.of(getTargetElement()).onDetached(targetDetach -> close());
              DominoElement.of(getAppendTarget()).onDetached(targetDetach -> close());
            });

        appendStrategy.onAppend(getAppendTarget(), element.element());
        onDetached(record -> close());
        if (smallScreen && nonNull(parent) && parent.isDropDown()) {
          parent.hide();
          menuHeader.get().show();
          backArrowContainer.show();
        }
        show();
      }
    }
  }

  protected DropDirection getEffectiveDropDirection() {
    if (isUseSmallScreensDirection() && smallScreen) {
      return smallScreenDropDirection;
    } else {
      if (isContextMenu()) {
        return contextMenuDropDirection;
      } else {
        return dropDirection;
      }
    }
  }

  private void closeOthers() {
    if (this.hasAttribute("domino-sub-menu")
        && Boolean.parseBoolean(this.getAttribute("domino-sub-menu"))) {
      return;
    }
    PopupsCloser.close();
  }

  private void focus() {
    getFocusElement().focus();
  }

  /**
   * @return the {@link HTMLElement} that triggers this menu to open, and which the positioning of
   *     the menu will be based on.
   */
  public HTMLElement getTargetElement() {
    return targetElement;
  }

  /**
   * @param targetElement The {@link IsElement} that triggers this menu to open, and which the
   *     positioning of the menu will be based on.
   * @return same menu instance
   */
  public T setTargetElement(IsElement<?> targetElement) {
    return (T) setTargetElement(targetElement.element());
  }

  /**
   * @param targetElement The {@link HTMLElement} that triggers this menu to open, and which the
   *     positioning of the menu will be based on.
   * @return same menu instance
   */
  public T setTargetElement(HTMLElement targetElement) {
    if (nonNull(this.targetElement)) {
      this.targetElement.removeEventListener(
          isContextMenu() ? EventType.contextmenu.getName() : EventType.click.getName(),
          openListener);
    }
    this.targetElement = targetElement;
    if (nonNull(this.targetElement)) {
      applyTargetListeners();
      setDropDown(true);
    } else {
      setDropDown(false);
    }
    return (T) this;
  }

  /** @return the {@link HTMLElement} to which the menu will be appended to when opened. */
  public HTMLElement getAppendTarget() {
    return appendTarget;
  }

  /**
   * set the {@link HTMLElement} to which the menu will be appended to when opened.
   *
   * @param appendTarget {@link HTMLElement}
   * @return same menu instance
   */
  public T setAppendTarget(HTMLElement appendTarget) {
    if (isNull(appendTarget)) {
      this.appendTarget = document.body;
    } else {
      this.appendTarget = appendTarget;
    }
    return (T) this;
  }

  /**
   * Opens the menu
   *
   * @return same menu instance
   */
  public T open() {
    if (isDropDown()) {
      open(true);
    }
    return (T) this;
  }

  /**
   * Close the menu
   *
   * @return same menu instance
   */
  public T close() {
    if (isDropDown()) {
      if (isOpened()) {
        this.remove();
        getTargetElement().focus();
        searchBox.get().clearSearch();
        menuItems.forEach(AbstractMenuItem::onParentClosed);
        closeHandlers.forEach(CloseHandler::onClose);
        if (smallScreen && nonNull(parent) && parent.isDropDown()) {
          parent.show();
        }
      }
    }
    return (T) this;
  }

  /** @return The current {@link DropDirection} of the menu */
  public DropDirection getDropDirection() {
    return dropDirection;
  }

  /**
   * Sets the {@link DropDirection} of the menu
   *
   * @param dropDirection {@link DropDirection}
   * @return same menu instance
   */
  public T setDropDirection(DropDirection dropDirection) {
    if (effectiveDropDirection.equals(this.dropDirection)) {
      this.dropDirection = dropDirection;
      this.effectiveDropDirection = this.dropDirection;
    } else {
      this.dropDirection = dropDirection;
    }
    return (T) this;
  }

  /**
   * Adds a close handler to be called when the menu is closed
   *
   * @param closeHandler The {@link CloseHandler} to add
   * @return same instance
   */
  public T addCloseHandler(CloseHandler closeHandler) {
    closeHandlers.add(closeHandler);
    return (T) this;
  }

  /**
   * Removes a close handler
   *
   * @param closeHandler The {@link CloseHandler} to remove
   * @return same instance
   */
  public T removeCloseHandler(CloseHandler closeHandler) {
    closeHandlers.remove(closeHandler);
    return (T) this;
  }

  /**
   * Adds an open handler to be called when the menu is opened
   *
   * @param openHandler The {@link OpenHandler} to add
   * @return same instance
   */
  public T addOpenHandler(OpenHandler openHandler) {
    openHandlers.add(openHandler);
    return (T) this;
  }

  /**
   * Removes an open handler
   *
   * @param openHandler The {@link OpenHandler} to remove
   * @return same instance
   */
  public T removeOpenHandler(OpenHandler openHandler) {
    openHandlers.remove(openHandler);
    return (T) this;
  }

  void setParent(AbstractMenu<V, ?> parent) {
    this.parent = parent;
  }

  /** @return the parent {@link AbstractMenu} of the menu */
  public AbstractMenu<?, ?> getParent() {
    return (T) parent;
  }

  void setParentItem(AbstractMenuItem<V, ?> parentItem) {
    this.parentItem = parentItem;
  }

  /** @return the {@link AbstractMenuItem} that opens the menu */
  public AbstractMenuItem<V, ?> getParentItem() {
    return parentItem;
  }

  /** @return boolean, true if the menu is a context menu that will open on right click */
  public boolean isContextMenu() {
    return contextMenu;
  }

  /**
   * Set the menu as a context menu that will open when the target element got a right click instead
   * of a click
   *
   * @param contextMenu booleanm true to make the menu a context menu
   * @return same menu instance
   */
  public T setContextMenu(boolean contextMenu) {
    this.contextMenu = contextMenu;
    if (nonNull(targetElement)) {
      applyTargetListeners();
    }
    return (T) this;
  }

  private void applyTargetListeners() {
    if (isContextMenu()) {
      getTargetElement().removeEventListener(EventType.click.getName(), openListener);
      getTargetElement().addEventListener(EventType.contextmenu.getName(), openListener);
    } else {
      getTargetElement().removeEventListener(EventType.contextmenu.getName(), openListener);
      getTargetElement().addEventListener(EventType.click.getName(), openListener);
    }
  }

  protected void onItemSelected(AbstractMenuItem<V, ?> item) {
    if (nonNull(parent)) {
      parent.onItemSelected(item);
    } else {
      if (isAutoCloseOnSelect() && !item.hasMenu()) {
        PopupsCloser.close();
      }
      selectionHandlers.forEach(selectionHandler -> selectionHandler.onItemSelected(item));
    }
  }

  /**
   * @return boolean, tru if use of small screens drop direction to the middle of screen is used or
   *     else false
   */
  public boolean isUseSmallScreensDirection() {
    return useSmallScreensDirection;
  }

  /**
   * @param useSmallScreensDropDirection boolean, true to allow the switch to small screen middle of
   *     screen position, false to use the provided menu drop direction
   * @return same menu instance
   */
  public T setUseSmallScreensDirection(boolean useSmallScreensDropDirection) {
    this.useSmallScreensDirection = useSmallScreensDropDirection;
    if (!useSmallScreensDropDirection && getEffectiveDropDirection() == smallScreenDropDirection) {
      this.effectiveDropDirection = dropDirection;
    }
    return (T) this;
  }

  public boolean isDropDown() {
    return dropDown;
  }

  private void setDropDown(boolean dropdown) {
    if (dropdown) {
      this.setAttribute("domino-ui-root-menu", true)
          .setAttribute(PopupsCloser.DOMINO_UI_AUTO_CLOSABLE, true)
          .css("drop-menu");
      menuElement.elevate(Elevation.LEVEL_1);
    } else {
      this.removeAttribute("domino-ui-root-menu")
          .removeAttribute(PopupsCloser.DOMINO_UI_AUTO_CLOSABLE)
          .removeCss("drop-menu");
      menuElement.elevate(Elevation.NONE);
    }
    this.dropDown = dropdown;
  }

  public T setOnAddItemHandler(OnAddItemHandler<V, T> onAddItemHandler) {
    if (nonNull(onAddItemHandler)) {
      this.onAddItemHandler = onAddItemHandler;
    }
    return (T) this;
  }

  /** A handler that will be called when closing the menu */
  @FunctionalInterface
  public interface CloseHandler {
    /** Will be called when the menu is closed */
    void onClose();
  }

  /** A handler that will be called when opening the menu */
  @FunctionalInterface
  public interface OpenHandler {
    /** Will be called when the menu is opened */
    void onOpen();
  }

  /**
   * A functional interface to implement menu items selection handlers
   *
   * @param <V> V the type of the menu item value
   */
  @FunctionalInterface
  public interface MenuItemSelectionHandler<V> {
    /**
     * Will be called when a menu item is called
     *
     * @param menuItem The {@link AbstractMenuItem} selected
     */
    void onItemSelected(AbstractMenuItem<V, ?> menuItem);
  }

  @FunctionalInterface
  public interface MenuItemsGroupHandler<
      V, I extends AbstractMenuItem<V, I>, T extends MenuItemsGroup<V, I, T>> {
    void handle(MenuItemsGroup<V, I, T> initializedGroup);
  }

  public interface OnAddItemHandler<V, T extends AbstractMenu<V, T>> {
    void onAdded(
        AbstractMenu<V, T> menu, AbstractMenuItem<V, ? extends AbstractMenuItem<V, ?>> menuItem);
  }
}
