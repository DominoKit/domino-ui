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
import static org.dominokit.domino.ui.utils.PopupsCloser.DOMINO_UI_AUTO_CLOSABLE;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import java.util.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.ZIndexConfig;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.direction.BestSideUpDownDropDirection;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.menu.direction.MiddleOfScreenDropDirection;
import org.dominokit.domino.ui.menu.direction.MouseBestFitDirection;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.*;

/**
 * The base component to create a menu like UI.
 *
 * @param <V> The type of the menu items value
 * @author vegegoku
 * @version $Id: $Id
 */
public class Menu<V> extends BaseDominoElement<HTMLDivElement, Menu<V>>
    implements HasSelectionListeners<Menu<V>, AbstractMenuItem<V>, List<AbstractMenuItem<V>>>,
        IsPopup<Menu<V>>,
        HasComponentConfig<ZIndexConfig>,
        MenuStyles {

  /** Constant <code>ANY="*"</code> */
  public static final String ANY = "*";

  private final LazyChild<NavBar> menuHeader;
  private final LazyChild<DivElement> menuSearchContainer;
  private final LazyChild<SearchBox> searchBox;
  private final LazyChild<DivElement> menuSubHeader;
  private final UListElement menuItemsList;
  private final DivElement menuBody;
  private final LazyChild<AnchorElement> createMissingElement;
  private final LazyChild<MdiIcon> backIcon;
  private LazyChild<LIElement> noResultElement;
  protected DivElement menuElement;

  private HTMLElement focusElement;
  protected KeyboardNavigation<AbstractMenuItem<V>> keyboardNavigation;

  protected boolean searchable;
  protected boolean caseSensitive = false;
  protected String createMissingLabel = "Create ";
  private MissingItemHandler<V> missingItemHandler;

  protected List<AbstractMenuItem<V>> menuItems = new ArrayList<>();
  protected boolean autoCloseOnSelect = true;
  protected final Set<
          SelectionListener<? super AbstractMenuItem<V>, ? super List<AbstractMenuItem<V>>>>
      selectionListeners = new LinkedHashSet<>();
  protected final Set<
          SelectionListener<? super AbstractMenuItem<V>, ? super List<AbstractMenuItem<V>>>>
      deselectionListeners = new LinkedHashSet<>();

  private final List<AbstractMenuItem<V>> selectedValues = new ArrayList<>();
  protected boolean headerVisible = false;
  private Menu<V> currentOpen;

  private boolean smallScreen;
  private DropDirection dropDirection = new BestSideUpDownDropDirection();
  private final DropDirection contextMenuDropDirection = new MouseBestFitDirection();
  private final DropDirection smallScreenDropDirection = new MiddleOfScreenDropDirection();
  private DropDirection effectiveDropDirection = dropDirection;
  private Map<String, MenuTarget> targets = new HashMap<>();
  private MenuTarget lastTarget;
  private Element menuAppendTarget = document.body;
  private AppendStrategy appendStrategy = AppendStrategy.LAST;

  private Menu<V> parent;
  private AbstractMenuItem<V> parentItem;

  private boolean selectionListenersPaused = false;
  private boolean multiSelect = false;
  private boolean autoOpen = true;
  private EventListener repositionListener =
      evt -> {
        if (isOpened()) {
          position();
        }
      };

  private final EventListener openListener =
      evt -> {
        evt.stopPropagation();
        evt.preventDefault();
        lastTarget =
            targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.currentTarget)).getDominoId());
        if (isNull(lastTarget)) {
          lastTarget =
              targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.target)).getDominoId());
        }
        if (isAutoOpen()) {
          open(evt);
        }
      };
  private final DivElement backArrowContainer;
  private boolean contextMenu = false;
  private boolean useSmallScreensDirection = true;
  private boolean dropDown = false;
  private Set<OnAddItemHandler<V>> onAddItemHandlers = new HashSet<>();
  private boolean fitToTargetWidth = false;
  private boolean centerOnSmallScreens = false;

  /**
   * create.
   *
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public static <V> Menu<V> create() {
    return new Menu<>();
  }

  private OpenMenuCondition<V> openMenuCondition = (menu) -> true;

  /** Constructor for Menu. */
  public Menu() {
    menuElement = div().addCss(dui_menu);
    menuHeader = LazyChild.of(NavBar.create(), menuElement);
    menuSearchContainer = LazyChild.of(div().addCss(dui_menu_search), menuElement);
    searchBox = LazyChild.of(SearchBox.create().addCss(dui_menu_search_box), menuSearchContainer);
    backArrowContainer = div().addCss(dui_order_first, dui_menu_back_icon);
    init(this);

    EventListener addMissingEventListener =
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
          onAddMissingElement();
        };

    addClickListener(evt -> evt.stopPropagation());

    createMissingElement =
        LazyChild.of(
            a("#")
                .setAttribute("tabindex", "0")
                .setAttribute("aria-expanded", "true")
                .addCss(dui_menu_create_missing),
            menuSearchContainer);
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
                              DomGlobal.console.info("ON ARROW DOWN");
                              keyboardNavigation.focusTopFocusableItem();
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
                                String searchToken = searchBox.element().getTextBox().getValue();
                                boolean tokenPresent =
                                    nonNull(searchToken) && !searchToken.trim().isEmpty();
                                if (isAllowCreateMissing()
                                    && createMissingElement.element().isAttached()
                                    && tokenPresent) {
                                  createMissingElement.get().element().focus();
                                } else {
                                  keyboardNavigation.focusTopFocusableItem();
                                }
                              })
                          .onEscape(evt -> close()));
        });

    menuSubHeader = LazyChild.of(div().addCss(dui_menu_sub_header), menuElement);

    menuItemsList = ul().addCss(dui_menu_items_list);
    noResultElement = LazyChild.of(li().addCss(dui_menu_no_results, dui_order_last), menuItemsList);
    menuBody = div().addCss(dui_menu_body);
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

    MediaQuery.addOnSmallAndDownListener(
        () -> {
          if (centerOnSmallScreens) {
            this.smallScreen = true;
          }
        });
    MediaQuery.addOnMediumAndUpListener(
        () -> {
          if (centerOnSmallScreens) {
            this.smallScreen = false;
            backArrowContainer.remove();
          }
        });
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
  }

  private void onAddMissingElement() {
    if (nonNull(missingItemHandler)) {
      missingItemHandler.onMissingItem(searchBox.get().getTextBox().getValue(), this);
      onSearch(searchBox.get().getTextBox().getValue());
      createMissingElement.remove();
      keyboardNavigation.focusTopFocusableItem();
    }
  }

  /**
   * isCenterOnSmallScreens.
   *
   * @return a boolean
   */
  public boolean isCenterOnSmallScreens() {
    return centerOnSmallScreens;
  }

  /**
   * Setter for the field <code>centerOnSmallScreens</code>.
   *
   * @param centerOnSmallScreens a boolean
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setCenterOnSmallScreens(boolean centerOnSmallScreens) {
    this.centerOnSmallScreens = centerOnSmallScreens;
    return this;
  }

  /**
   * Set the menu icon in the header, setting the icon will force the header to show up if not
   * visible
   *
   * @param icon Any Icon instance that extends from {@link org.dominokit.domino.ui.icons.Icon}
   * @return the same menu instance
   */
  public Menu<V> setIcon(Icon<?> icon) {
    menuHeader.get().appendChild(PrefixAddOn.of(icon));
    return this;
  }

  /**
   * Set the menu title in the header, setting the title will force the header to show up if not
   * visible
   *
   * @param title String
   * @return same menu instance
   */
  public Menu<V> setTitle(String title) {
    menuHeader.get().setTitle(title);
    return this;
  }

  /**
   * Appends a child element to the menu subheader, the subheader will show up below the search and
   * before the menu items.
   *
   * @param addon {@link org.dominokit.domino.ui.utils.SubheaderAddon}
   * @return same menu instance
   */
  public Menu<V> appendChild(SubheaderAddon<?> addon) {
    menuSubHeader.get().appendChild(addon);
    return this;
  }

  /**
   * Appends a menu item to this menu
   *
   * @param menuItem {@link org.dominokit.domino.ui.menu.Menu}
   * @return same menu instance
   */
  public Menu<V> appendChild(AbstractMenuItem<V> menuItem) {
    if (nonNull(menuItem)) {
      menuItemsList.appendChild(menuItem);
      menuItems.add(menuItem);
      menuItem.setParent(this);
      onItemAdded(menuItem);
    }
    return this;
  }

  void onItemAdded(AbstractMenuItem<V> menuItem) {
    onAddItemHandlers.forEach(handler -> handler.onAdded(this, menuItem));
  }

  /**
   * Appends a menu item to this menu
   *
   * @param menuGroup {@link org.dominokit.domino.ui.menu.MenuItemsGroup}
   * @return same menu instance
   * @param groupHandler a {@link org.dominokit.domino.ui.menu.Menu.MenuItemsGroupHandler} object
   * @param <I> a I class
   */
  public <I extends AbstractMenuItem<V>> Menu<V> appendGroup(
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
   * Removes a menu item from this menu
   *
   * @param menuItem {@link org.dominokit.domino.ui.menu.Menu}
   * @return same menu instance
   */
  public Menu<V> removeItem(AbstractMenuItem<V> menuItem) {
    if (this.menuItems.contains(menuItem)) {
      menuItem.remove();
      this.menuItems.remove(menuItem);
    }
    return this;
  }

  /**
   * Removes all menu items from this menu
   *
   * @return same menu instance
   */
  public Menu<V> removeAll() {
    menuItems.forEach(BaseDominoElement::remove);
    menuItems.clear();
    closeCurrentOpen();
    currentOpen = null;
    return this;
  }

  /**
   * Appends a separator item to this menu, separator will show up as a simple border.
   *
   * @return same menu instance
   * @param separator a {@link org.dominokit.domino.ui.utils.Separator} object
   */
  public Menu<V> appendChild(Separator separator) {
    this.menuItemsList.appendChild(separator.addCss(dui_menu_separator));
    return this;
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
   * clearSelection.
   *
   * @param silent a boolean
   */
  public void clearSelection(boolean silent) {
    selectedValues.clear();
    if (!silent) {
      triggerDeselectionListeners(null, selectedValues);
    }
  }

  /**
   * If search is enabled, when search is trigger it will call this method.
   *
   * @param token String user input in the {@link org.dominokit.domino.ui.search.SearchBox}
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

    position();
    return count > 0;
  }

  /** @return String label that indicate the create missing items action */
  /**
   * Getter for the field <code>createMissingLabel</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getCreateMissingLabel() {
    return createMissingLabel;
  }

  /**
   * Sets the label that will appear when no elements match the search, default is "create"
   *
   * @param createMissingLabel String
   * @return same menu instance
   */
  public Menu<V> setCreateMissingLabel(String createMissingLabel) {
    if (isNull(createMissingLabel) || createMissingLabel.isEmpty()) {
      this.createMissingLabel = "Create ";
    } else {
      this.createMissingLabel = createMissingLabel;
    }
    return this;
  }

  private boolean emptyToken(String token) {
    return isNull(token) || token.isEmpty();
  }

  /** @return a List of {@link AbstractMenuItem} of this menu */
  /**
   * Getter for the field <code>menuItems</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<AbstractMenuItem<V>> getMenuItems() {
    return menuItems;
  }
  /** @return a List of {@link AbstractMenuItem} of this menu */
  /**
   * getFlatMenuItems.
   *
   * @return a {@link java.util.List} object
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
   * Getter for the field <code>noResultElement</code>.
   *
   * @return The {@link org.dominokit.domino.ui.utils.DominoElement} of the {@link
   *     elemental2.dom.HTMLLIElement} that is used to represent no results when search is applied
   */
  public LazyChild<LIElement> getNoResultElement() {
    return noResultElement;
  }

  /**
   * Sets a custom element to represent no results when search is applied.
   *
   * @param noResultElement {@link elemental2.dom.HTMLLIElement}
   * @return same menu instance
   */
  public Menu<V> setNoResultElement(HTMLLIElement noResultElement) {
    if (nonNull(noResultElement)) {
      this.noResultElement.remove();
      this.noResultElement =
          LazyChild.of(LIElement.of(noResultElement).addCss(dui_menu_no_results), menuItemsList);
    }
    return this;
  }

  /**
   * Sets a custom element to represent no results when search is applied.
   *
   * @param noResultElement {@link org.dominokit.domino.ui.IsElement} of {@link
   *     elemental2.dom.HTMLLIElement}
   * @return same menu instance
   */
  public Menu<V> setNoResultElement(IsElement<HTMLLIElement> noResultElement) {
    if (nonNull(noResultElement)) {
      setNoResultElement(noResultElement.element());
    }
    return this;
  }

  /** @return boolean, true if this menu search is case-sensitive */
  /**
   * isCaseSensitive.
   *
   * @return a boolean
   */
  public boolean isCaseSensitive() {
    return caseSensitive;
  }

  /**
   * Setter for the field <code>caseSensitive</code>.
   *
   * @param caseSensitive a boolean
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setCaseSensitive(boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
    return this;
  }

  /** @return the {@link HTMLElement} that should be focused by default when open the menu */
  /**
   * Getter for the field <code>focusElement</code>.
   *
   * @return a {@link elemental2.dom.HTMLElement} object
   */
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
   * @param focusElement {@link elemental2.dom.HTMLElement}
   * @return same menu instance
   */
  public Menu<V> setFocusElement(HTMLElement focusElement) {
    this.focusElement = focusElement;
    return this;
  }

  /**
   * Sets a custom element as the default focus element of the menu
   *
   * @param focusElement {@link org.dominokit.domino.ui.IsElement}
   * @return same menu instance
   */
  public Menu<V> setFocusElement(IsElement<? extends HTMLElement> focusElement) {
    return setFocusElement(focusElement.element());
  }

  /** @return the {@link SearchBox} of the menu */
  /**
   * Getter for the field <code>searchBox</code>.
   *
   * @return a {@link org.dominokit.domino.ui.search.SearchBox} object
   */
  public SearchBox getSearchBox() {
    return searchBox.get();
  }

  /** @return The {@link KeyboardNavigation} of the menu */
  /**
   * Getter for the field <code>keyboardNavigation</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.KeyboardNavigation} object
   */
  public KeyboardNavigation<AbstractMenuItem<V>> getKeyboardNavigation() {
    return keyboardNavigation;
  }

  /** @return The {@link NavBar} component of the menu */
  /**
   * Getter for the field <code>menuHeader</code>.
   *
   * @return a {@link org.dominokit.domino.ui.layout.NavBar} object
   */
  public NavBar getMenuHeader() {
    return menuHeader.get();
  }

  /**
   * Change the visibility of the menu header
   *
   * @param visible boolean, True to show the header, false to hide it.
   * @return same menu instance
   */
  public Menu<V> setHeaderVisible(boolean visible) {
    menuHeader.get().toggleDisplay(visible);
    this.headerVisible = visible;
    return this;
  }

  /** @return boolean, true if search is enabled */
  /**
   * isSearchable.
   *
   * @return a boolean
   */
  public boolean isSearchable() {
    return searchable;
  }

  /** @return boolean, true if search is enabled */
  /**
   * isAllowCreateMissing.
   *
   * @return a boolean
   */
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

  /**
   * Set a handler that will allow the user to handle a search that does not match any existing
   * items.
   *
   * @param missingItemHandler {@link org.dominokit.domino.ui.menu.MissingItemHandler}
   * @return same menu instance
   */
  public Menu<V> setMissingItemHandler(MissingItemHandler<V> missingItemHandler) {
    this.missingItemHandler = missingItemHandler;
    return this;
  }

  /**
   * Selects the specified menu item if it is one of this menu items
   *
   * @param menuItem {@link org.dominokit.domino.ui.menu.AbstractMenuItem}
   * @return same menu instance
   */
  public Menu<V> select(AbstractMenuItem<V> menuItem) {
    return select(menuItem, isSelectionListenersPaused());
  }

  /**
   * Selects the menu item at the specified index if exists
   *
   * @param menuItem {@link org.dominokit.domino.ui.menu.AbstractMenuItem}
   * @param silent boolean, true to avoid triggering change handlers
   * @return same menu instance
   */
  public Menu<V> select(AbstractMenuItem<V> menuItem, boolean silent) {
    menuItem.select(silent);
    return this;
  }

  /**
   * Selects the menu item at the specified index if exists
   *
   * @param index int
   * @return same menu instance
   */
  public Menu<V> selectAt(int index) {
    return selectAt(index, isSelectionListenersPaused());
  }

  /**
   * Selects the menu at the specified index if exists
   *
   * @param index int
   * @param silent boolean, true to avoid triggering change handlers
   * @return same menu instance
   */
  public Menu<V> selectAt(int index, boolean silent) {
    if (index < menuItems.size() && index >= 0) {
      select(menuItems.get(index), silent);
    }
    return this;
  }

  /**
   * Selects a menu item by its key if exists
   *
   * @param key String
   * @return same menu instance
   */
  public Menu<V> selectByKey(String key) {
    return selectByKey(key, false);
  }

  /**
   * Selects a menu item by its key if exists with ability to avoid triggering change handlers
   *
   * @param key String
   * @param silent boolean, true to avoid triggering change handlers
   * @return same menu instance
   */
  public Menu<V> selectByKey(String key, boolean silent) {
    for (AbstractMenuItem<V> menuItem : getMenuItems()) {
      if (menuItem.getKey().equals(key)) {
        select(menuItem, silent);
      }
    }
    return this;
  }

  /** @return boolean, true if the menu should close after selecting a menu item */
  /**
   * isAutoCloseOnSelect.
   *
   * @return a boolean
   */
  public boolean isAutoCloseOnSelect() {
    return autoCloseOnSelect;
  }

  /**
   * Setter for the field <code>autoCloseOnSelect</code>.
   *
   * @param autoCloseOnSelect boolean, if true the menu will close after selecting a menu item
   *     otherwise it remains open
   * @return same menu instance
   */
  public Menu<V> setAutoCloseOnSelect(boolean autoCloseOnSelect) {
    this.autoCloseOnSelect = autoCloseOnSelect;
    return this;
  }

  /**
   * isMultiSelect.
   *
   * @return a boolean
   */
  public boolean isMultiSelect() {
    return multiSelect;
  }

  /**
   * Setter for the field <code>multiSelect</code>.
   *
   * @param multiSelect a boolean
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    return this;
  }

  /**
   * isAutoOpen.
   *
   * @return a boolean
   */
  public boolean isAutoOpen() {
    return autoOpen;
  }

  /**
   * Setter for the field <code>autoOpen</code>.
   *
   * @param autoOpen a boolean
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setAutoOpen(boolean autoOpen) {
    this.autoOpen = autoOpen;
    return this;
  }

  /**
   * isFitToTargetWidth.
   *
   * @return a boolean
   */
  public boolean isFitToTargetWidth() {
    return fitToTargetWidth;
  }

  /**
   * Setter for the field <code>fitToTargetWidth</code>.
   *
   * @param fitToTargetWidth a boolean
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setFitToTargetWidth(boolean fitToTargetWidth) {
    this.fitToTargetWidth = fitToTargetWidth;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Menu<V> pauseSelectionListeners() {
    this.togglePauseSelectionListeners(true);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Menu<V> resumeSelectionListeners() {
    this.togglePauseSelectionListeners(false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Menu<V> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super AbstractMenuItem<V>, ? super List<AbstractMenuItem<V>>>>
      getSelectionListeners() {
    return selectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super AbstractMenuItem<V>, ? super List<AbstractMenuItem<V>>>>
      getDeselectionListeners() {
    return deselectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public Menu<V> triggerSelectionListeners(
      AbstractMenuItem<V> source, List<AbstractMenuItem<V>> selection) {
    selectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Menu<V> triggerDeselectionListeners(
      AbstractMenuItem<V> source, List<AbstractMenuItem<V>> selection) {
    deselectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public List<AbstractMenuItem<V>> getSelection() {
    return selectedValues;
  }

  /**
   * Adds/removes the outer borders of the menu, this will add/remove the <b>menu-bordered</b> style
   *
   * @param bordered boolean, true to show borders, false to remove them
   * @return same menu instance
   */
  public Menu<V> setBordered(boolean bordered) {
    removeCss("menu-bordered");
    if (bordered) {
      css("menu-bordered");
    }
    return this;
  }

  /**
   * Opens a sub menu that has this menu as its parent
   *
   * @param dropMenu {@link org.dominokit.domino.ui.menu.Menu} to open
   * @return same menu instance
   */
  public Menu<V> openSubMenu(Menu<V> dropMenu) {
    if (!Objects.equals(currentOpen, dropMenu)) {
      closeCurrentOpen();
    }
    dropMenu.open();
    setCurrentOpen(dropMenu);

    return this;
  }

  void setCurrentOpen(Menu<V> dropMenu) {
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
  /**
   * isOpened.
   *
   * @return a boolean
   */
  public boolean isOpened() {
    return isDropDown() && isAttached();
  }

  private void open(Event evt) {
    getEffectiveDropDirection().init(evt);
    open();
  }

  /**
   * Opens the menu with a boolean to indicate if the first element should be focused
   *
   * @param focus true to focus the first element
   */
  public void open(boolean focus) {
    if (isDropDown() && openMenuCondition.check(this)) {
      if (getTarget().isPresent()) {
        DominoElement<Element> targetElement = getTarget().get().getTargetElement();
        if (!(targetElement.isReadOnly() || targetElement.isDisabled())) {
          doOpen(focus);
        }
      } else {
        doOpen(focus);
      }
    }
  }

  private void doOpen(boolean focus) {
    getConfig().getZindexManager().onPopupOpen(this);
    if (isOpened()) {
      position();
    } else {
      closeOthers();
      if (isSearchable()) {
        searchBox.get().clearSearch();
      }
      triggerExpandListeners(this);
      onAttached(
          mutationRecord -> {
            position();
            if (focus) {
              focus();
            }
            elementOf(getMenuAppendTarget()).onDetached(targetDetach -> close());
          });
      appendStrategy.onAppend(getMenuAppendTarget(), element.element());
      onDetached(record -> close());
      if (smallScreen && nonNull(parent) && parent.isDropDown()) {
        parent.collapse();
        menuHeader.get().insertFirst(backArrowContainer);
      }
      show();
    }
  }

  private void position() {
    if (isDropDown() && isOpened()) {
      Optional<MenuTarget> menuTarget = getTarget();
      menuTarget.ifPresent(
          target -> {
            getEffectiveDropDirection()
                .position(element.element(), target.getTargetElement().element());
            if (fitToTargetWidth) {
              element.setWidth(
                  target.getTargetElement().element().getBoundingClientRect().width + "px");
            }
          });
    }
  }

  /**
   * Getter for the field <code>effectiveDropDirection</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.direction.DropDirection} object
   */
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

  /** focus. */
  public void focus() {
    getFocusElement().focus();
  }

  /**
   * getTarget.
   *
   * @return the {@link elemental2.dom.HTMLElement} that triggers this menu to open, and which the
   *     positioning of the menu will be based on.
   */
  public Optional<MenuTarget> getTarget() {
    if (isNull(lastTarget) && targets.size() == 1) {
      return targets.values().stream().findFirst();
    }
    return Optional.ofNullable(lastTarget);
  }

  /**
   * setTargetElement.
   *
   * @param targetElement The {@link org.dominokit.domino.ui.IsElement} that triggers this menu to
   *     open, and which the positioning of the menu will be based on.
   * @return same menu instance
   */
  public Menu<V> setTargetElement(IsElement<?> targetElement) {
    return setTargetElement(targetElement.element());
  }

  /**
   * setTargetElement.
   *
   * @param targetElement The {@link elemental2.dom.HTMLElement} that triggers this menu to open,
   *     and which the positioning of the menu will be based on.
   * @return same menu instance
   */
  public Menu<V> setTargetElement(Element targetElement) {
    setTarget(MenuTarget.of(targetElement));
    return this;
  }

  /**
   * setTarget.
   *
   * @param menuTarget a {@link org.dominokit.domino.ui.menu.MenuTarget} object
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setTarget(MenuTarget menuTarget) {
    this.targets
        .values()
        .forEach(
            target -> {
              target
                  .getTargetElement()
                  .removeEventListener(
                      isContextMenu() ? EventType.contextmenu.getName() : EventType.click.getName(),
                      openListener);
              target.getTargetElement().removeDetachObserver(menuTarget.getTargetDetachObserver());
            });
    this.targets.clear();
    return addTarget(menuTarget);
  }

  /**
   * addTarget.
   *
   * @param menuTarget a {@link org.dominokit.domino.ui.menu.MenuTarget} object
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> addTarget(MenuTarget menuTarget) {
    if (nonNull(menuTarget)) {
      this.targets.put(menuTarget.getTargetElement().getDominoId(), menuTarget);
      menuTarget.setTargetDetachObserver(
          mutationRecord -> {
            if (Objects.equals(menuTarget, lastTarget)) {
              close();
            }

            this.targets.remove(menuTarget.getTargetElement().getDominoId());
          });
      elementOf(menuTarget.getTargetElement()).onDetached(menuTarget.getTargetDetachObserver());
    }
    if (!this.targets.isEmpty()) {
      applyTargetListeners(menuTarget);
      setDropDown(true);
    } else {
      setDropDown(false);
    }
    return this;
  }

  /** @return the {@link HTMLElement} to which the menu will be appended to when opened. */
  /**
   * Getter for the field <code>menuAppendTarget</code>.
   *
   * @return a {@link elemental2.dom.Element} object
   */
  public Element getMenuAppendTarget() {
    return menuAppendTarget;
  }

  /**
   * set the {@link elemental2.dom.HTMLElement} to which the menu will be appended to when opened.
   *
   * @param appendTarget {@link elemental2.dom.HTMLElement}
   * @return same menu instance
   */
  public Menu<V> setMenuAppendTarget(Element appendTarget) {
    if (isNull(appendTarget)) {
      this.menuAppendTarget = document.body;
    } else {
      this.menuAppendTarget = appendTarget;
    }
    return this;
  }

  /**
   * Opens the menu
   *
   * @return same menu instance
   */
  public Menu<V> open() {
    if (isDropDown()) {
      open(true);
    }
    return this;
  }

  /**
   * Close the menu
   *
   * @return same menu instance
   */
  public Menu<V> close() {
    if (isDropDown()) {
      if (isOpened()) {
        this.remove();
        getTarget()
            .ifPresent(
                menuTarget -> {
                  menuTarget.getTargetElement().element().focus();
                });
        if (isSearchable()) {
          searchBox.get().clearSearch();
        }
        menuItems.forEach(AbstractMenuItem::onParentClosed);
        triggerCollapseListeners(this);
        if (smallScreen && nonNull(parent) && parent.isDropDown()) {
          parent.expand();
        }
      }
    }
    return this;
  }

  /** @return The current {@link DropDirection} of the menu */
  /**
   * Getter for the field <code>dropDirection</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.direction.DropDirection} object
   */
  public DropDirection getDropDirection() {
    return dropDirection;
  }

  /**
   * Sets the {@link org.dominokit.domino.ui.menu.direction.DropDirection} of the menu
   *
   * @param dropDirection {@link org.dominokit.domino.ui.menu.direction.DropDirection}
   * @return same menu instance
   */
  public Menu<V> setDropDirection(DropDirection dropDirection) {
    if (nonNull(this.dropDirection)) {
      this.dropDirection.cleanup(this.element());
    }

    if (nonNull(this.effectiveDropDirection)) {
      this.effectiveDropDirection.cleanup(this.element());
    }

    if (effectiveDropDirection.equals(this.dropDirection)) {
      this.dropDirection = dropDirection;
      this.effectiveDropDirection = this.dropDirection;
    } else {
      this.dropDirection = dropDirection;
    }
    return this;
  }

  void setParent(Menu<V> parent) {
    this.parent = parent;
  }

  /** @return the parent {@link Menu} of the menu */
  /**
   * Getter for the field <code>parent</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> getParent() {
    return parent;
  }

  void setParentItem(AbstractMenuItem<V> parentItem) {
    this.parentItem = parentItem;
  }

  /** @return the {@link AbstractMenuItem} that opens the menu */
  /**
   * Getter for the field <code>parentItem</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.AbstractMenuItem} object
   */
  public AbstractMenuItem<V> getParentItem() {
    return parentItem;
  }

  /** @return boolean, true if the menu is a context menu that will open on right click */
  /**
   * isContextMenu.
   *
   * @return a boolean
   */
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
  public Menu<V> setContextMenu(boolean contextMenu) {
    this.contextMenu = contextMenu;
    addCss(BooleanCssClass.of(dui_context_menu, contextMenu));
    targets.values().forEach(this::applyTargetListeners);
    return this;
  }

  private void applyTargetListeners(MenuTarget menuTarget) {
    if (isContextMenu()) {
      menuTarget.getTargetElement().removeEventListener(EventType.click.getName(), openListener);
      menuTarget.getTargetElement().addEventListener(EventType.contextmenu.getName(), openListener);
    } else {
      menuTarget
          .getTargetElement()
          .removeEventListener(EventType.contextmenu.getName(), openListener);
      menuTarget.getTargetElement().addEventListener(EventType.click.getName(), openListener);
    }
  }

  /**
   * onItemSelected.
   *
   * @param item a {@link org.dominokit.domino.ui.menu.AbstractMenuItem} object
   * @param silent a boolean
   */
  protected void onItemSelected(AbstractMenuItem<V> item, boolean silent) {
    if (nonNull(parent)) {
      parent.onItemSelected(item, silent);
    } else {
      if (isAutoCloseOnSelect() && !item.hasMenu()) {
        close();
        PopupsCloser.close();
      }
      if (!this.selectedValues.contains(item)) {
        if (!multiSelect && !this.selectedValues.isEmpty()) {
          this.selectedValues.get(0).deselect(silent);
          this.selectedValues.clear();
        }
        this.selectedValues.add(item);
        if (!silent) {
          triggerSelectionListeners(item, getSelection());
        }
      }
    }
  }

  /**
   * onItemDeselected.
   *
   * @param item a {@link org.dominokit.domino.ui.menu.AbstractMenuItem} object
   * @param silent a boolean
   */
  protected void onItemDeselected(AbstractMenuItem<V> item, boolean silent) {
    if (nonNull(parent)) {
      parent.onItemDeselected(item, silent);
    } else {
      if (isAutoCloseOnSelect() && !item.hasMenu()) {
        close();
        PopupsCloser.close();
      }
      this.selectedValues.remove(item);
      if (!silent) {
        triggerDeselectionListeners(item, getSelection());
      }
    }
  }

  /**
   * isUseSmallScreensDirection.
   *
   * @return boolean, true if use of small screens drop direction to the middle of screen is used or
   *     else false
   */
  public boolean isUseSmallScreensDirection() {
    return useSmallScreensDirection;
  }

  /**
   * Setter for the field <code>useSmallScreensDirection</code>.
   *
   * @param useSmallScreensDropDirection boolean, true to allow the switch to small screen middle of
   *     screen position, false to use the provided menu drop direction
   * @return same menu instance
   */
  public Menu<V> setUseSmallScreensDirection(boolean useSmallScreensDropDirection) {
    this.useSmallScreensDirection = useSmallScreensDropDirection;
    if (!useSmallScreensDropDirection && getEffectiveDropDirection() == smallScreenDropDirection) {
      this.effectiveDropDirection = dropDirection;
    }
    return this;
  }

  /**
   * isDropDown.
   *
   * @return a boolean
   */
  public boolean isDropDown() {
    return dropDown;
  }

  private void setDropDown(boolean dropdown) {
    if (dropdown) {
      this.setAttribute("domino-ui-root-menu", true).setAttribute(DOMINO_UI_AUTO_CLOSABLE, true);
      menuElement.elevate(Elevation.LEVEL_1);
      document.addEventListener("scroll", repositionListener, true);
    } else {
      this.removeAttribute("domino-ui-root-menu").removeAttribute(DOMINO_UI_AUTO_CLOSABLE);
      menuElement.elevate(Elevation.NONE);
      document.removeEventListener("scroll", repositionListener);
    }
    addCss(BooleanCssClass.of(dui_menu_drop, dropdown));
    this.dropDown = dropdown;
    setAutoClose(this.dropDown);
  }

  /**
   * addOnAddItemHandler.
   *
   * @param onAddItemHandler a {@link org.dominokit.domino.ui.menu.Menu.OnAddItemHandler} object
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> addOnAddItemHandler(OnAddItemHandler<V> onAddItemHandler) {
    if (nonNull(onAddItemHandler)) {
      this.onAddItemHandlers.add(onAddItemHandler);
    }
    return this;
  }

  /**
   * withHeader.
   *
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> withHeader() {
    menuHeader.get();
    return this;
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> withHeader(ChildHandler<Menu<V>, NavBar> handler) {
    handler.apply(this, menuHeader.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isModal() {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isAutoClose() {
    return Boolean.parseBoolean(getAttribute(DOMINO_UI_AUTO_CLOSABLE, "false"));
  }

  /**
   * setAutoClose.
   *
   * @param autoClose a boolean
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setAutoClose(boolean autoClose) {
    if (autoClose) {
      setAttribute(DOMINO_UI_AUTO_CLOSABLE, "true");
    } else {
      removeAttribute(DOMINO_UI_AUTO_CLOSABLE);
    }
    return this;
  }

  /**
   * Setter for the field <code>openMenuCondition</code>.
   *
   * @param openMenuCondition a {@link org.dominokit.domino.ui.menu.OpenMenuCondition} object
   * @return a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public Menu<V> setOpenMenuCondition(OpenMenuCondition<V> openMenuCondition) {
    if (isNull(openMenuCondition)) {
      this.openMenuCondition = menu -> true;
      return this;
    }
    this.openMenuCondition = openMenuCondition;
    return this;
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
  public interface MenuItemSelectionHandler<V> {
    /**
     * Will be called when a menu item is called
     *
     * @param menuItem The {@link AbstractMenuItem} selected
     */
    void onItemSelectionChange(AbstractMenuItem<V> menuItem, boolean selected);
  }

  @FunctionalInterface
  public interface MenuItemsGroupHandler<V, I extends AbstractMenuItem<V>> {
    void handle(MenuItemsGroup<V> initializedGroup);
  }

  public interface OnAddItemHandler<V> {
    void onAdded(Menu<V> menu, AbstractMenuItem<V> menuItem);
  }
}
