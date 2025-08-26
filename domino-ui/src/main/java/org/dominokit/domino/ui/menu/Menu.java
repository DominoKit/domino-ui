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
import static org.dominokit.domino.ui.menu.direction.DropDirection.DUI_POSITION_FALLBACK;
import static org.dominokit.domino.ui.style.DisplayCss.dui_elevation_1;
import static org.dominokit.domino.ui.style.DisplayCss.dui_elevation_none;
import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_order_first;
import static org.dominokit.domino.ui.utils.Domino.dui_order_last;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.li;
import static org.dominokit.domino.ui.utils.Domino.ul;
import static org.dominokit.domino.ui.utils.PopupsCloser.DOMINO_UI_AUTO_CLOSABLE;

import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.KeyboardEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.MenuConfig;
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
import org.dominokit.domino.ui.menu.direction.*;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

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
public class Menu<V> extends BaseDominoElement<HTMLDivElement, Menu<V>>
    implements HasSelectionListeners<Menu<V>, AbstractMenuItem<V>, List<AbstractMenuItem<V>>>,
        IsPopup<Menu<V>>,
        HasComponentConfig<MenuConfig>,
        MenuStyles {

  public static final String ANY = "*";
  public static final String DUI_AUTO_CLEAR_SELECTION = "dui-auto-clear-selection";

  private final LazyChild<NavBar> menuHeader;
  private final LazyChild<DivElement> menuSearchContainer;
  private final LazyChild<SearchBox> searchBox;
  private final LazyChild<DivElement> menuSubHeader;
  private UListElement menuItemsList;
  private final DivElement menuBody;
  private final LazyChild<DivElement> menuFooter;
  private final LazyChild<AnchorElement> createMissingElement;
  private final LazyChild<MdiIcon> backIcon;
  private final EventListener closeOnScrollListener;
  private LazyChild<LIElement> noResultElement;
  protected DivElement menuElement;

  private HTMLElement focusElement;
  protected KeyboardNavigation<AbstractMenuItem<V>> keyboardNavigation;

  protected boolean searchable;
  protected boolean caseSensitive = false;
  protected String createMissingLabel =
      DominoUIConfig.CONFIG.getUIConfig().getMissingItemCreateLabel();
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
  private Map<String, MenuTarget> targets;
  private MenuTarget lastTarget;
  private DominoElement<Element> menuAppendTarget;
  private AppendStrategy appendStrategy = AppendStrategy.LAST;

  private Menu<V> parent;
  private AbstractMenuItem<V> parentItem;

  private boolean selectionListenersPaused = false;
  private boolean multiSelect = false;
  private boolean autoOpen = true;
  private boolean preserveSelectionStyles = true;
  private boolean startScrollFollow = false;
  private EventListener repositionListener =
      evt -> {
        if (isOpened() && startScrollFollow && evt.target != menuItemsList.element()) {
          startScrollFollow = false;
          position();
        }
      };
  private Set<OnBeforeOpenListener<? super Menu<V>>> onBeforeOpenListeners;

  private final EventListener openListener =
      evt -> {
        evt.stopPropagation();
        evt.preventDefault();

        MenuTarget newTarget =
            targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.currentTarget)).getDominoId());
        if (isNull(newTarget)) {
          newTarget =
              targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.target)).getDominoId());
        }
        if (!Objects.equals(newTarget, lastTarget)) {
          if (nonNull(lastTarget)) {
            lastTarget.getTargetElement().removeCss(dui_context_menu_target_open);
            getSelection().forEach(item -> item.deselect(true));
          }
          newTarget.getTargetElement().addCss(dui_context_menu_target_open);
        } else {
          if (nonNull(lastTarget)
              && lastTarget.getTargetElement().hasAttribute(DUI_AUTO_CLEAR_SELECTION)) {
            if ("true"
                .equals(lastTarget.getTargetElement().getAttribute(DUI_AUTO_CLEAR_SELECTION))) {
              getSelection().forEach(item -> item.deselect(true));
            }
          }
        }

        lastTarget = newTarget;
        if (isAutoOpen()) {
          if (isOpened() && !isContextMenu()) {
            close();
          } else {
            open(evt);
          }
        }
      };

  private final EventListener autoCloseListener =
      evt -> {
        if (isAutoClose()) {
          remove();
        }
      };
  private final DivElement backArrowContainer;
  private boolean contextMenu = false;
  private boolean useSmallScreensDirection = true;
  private boolean dropDown = false;
  private Set<OnAddItemHandler<V>> onAddItemHandlers = new HashSet<>();
  private boolean fitToTargetWidth = false;
  private boolean centerOnSmallScreens = false;

  private EventListener lostFocusListener;
  private boolean closeOnBlur = DominoUIConfig.CONFIG.isClosePopupOnBlur();
  private OpenMenuCondition<V> openMenuCondition = (menu) -> true;
  private List<MediaQuery.MediaQueryListenerRecord> mediaQueryRecords = new ArrayList<>();
  private EventListener windowResizeListener;
  private MutationObserverCallback onAttachHandler;
  private boolean shouldFocus;
  private MutationObserverCallback onDetachHandler;
  private SingleSelectionMode selectionMode = SingleSelectionMode.RESELECT;
  private MutationObserverCallback onAppendTargetDetach;
  private boolean autoFocus = true;

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
    menuElement = div().addCss(dui_menu);
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
    noResultElement = LazyChild.of(li().addCss(dui_menu_no_results, dui_order_last), menuItemsList);
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

  public void focusFirstMatch(String token) {
    findOptionStarsWith(token).ifPresent(AbstractMenuItem::focus);
  }

  public Optional<AbstractMenuItem<V>> findOptionStarsWith(String token) {
    return this.menuItems.stream()
        .filter(menuItem -> !menuItem.isGrouped())
        .filter(dropDownItem -> dropDownItem.startsWith(token))
        .findFirst();
  }

  /**
   * Handles the behavior when an expected menu item is missing.
   *
   * <p>If a missing item handler is set, this method triggers the handler's onMissingItem method,
   * performs a search with the current value of the search box, and then removes the create missing
   * element and focuses on the top focusable item in the menu.
   */
  private void onAddMissingElement() {
    if (nonNull(missingItemHandler)) {
      missingItemHandler.onMissingItem(searchBox.get().getTextBox().getValue(), this);
      onSearch(searchBox.get().getTextBox().getValue());
      createMissingElement.remove();
      keyboardNavigation.focusTopFocusableItem();
    }
  }

  /**
   * Determines if the menu is set to be centered on small screen devices.
   *
   * @return true if the menu should be centered on small screens, false otherwise.
   */
  public boolean isCenterOnSmallScreens() {
    return centerOnSmallScreens;
  }

  /**
   * Sets the behavior for the menu to be centered or not on small screen devices.
   *
   * @param centerOnSmallScreens true to center the menu on small screens, false otherwise.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setCenterOnSmallScreens(boolean centerOnSmallScreens) {
    this.centerOnSmallScreens = centerOnSmallScreens;
    return this;
  }

  /**
   * Allows adding an icon to the menu header.
   *
   * @param icon The icon to be set.
   * @return The current Menu instance.
   */
  public Menu<V> setIcon(Icon<?> icon) {
    menuHeader.get().appendChild(PrefixAddOn.of(icon));
    return this;
  }

  /**
   * Sets the title for the menu header.
   *
   * @param title The title to be set.
   * @return The current Menu instance.
   */
  public Menu<V> setTitle(String title) {
    menuHeader.get().setTitle(title);
    return this;
  }

  /**
   * Appends a subheader addon to the menu.
   *
   * @param addon The subheader addon to be added.
   * @return The current Menu instance.
   */
  public Menu<V> appendChild(SubheaderAddon<?> addon) {
    menuSubHeader.get().appendChild(addon);
    return this;
  }

  public Menu<V> appendChild(SubheaderAddon<?>... addons) {
    Arrays.stream(addons).forEach(this::appendChild);
    return this;
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

  private void afterAddItem(AbstractMenuItem<V> menuItem) {
    menuItem.setParent(this);
    onItemAdded(menuItem);
  }

  void onItemAdded(AbstractMenuItem<V> menuItem) {
    onAddItemHandlers.forEach(handler -> handler.onAdded(this, menuItem));
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
      menuItem.remove();
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
    menuItems.forEach(BaseDominoElement::remove);
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

  /**
   * Gets the label used when an item is not found during a search.
   *
   * @return the label string.
   */
  public String getCreateMissingLabel() {
    return createMissingLabel;
  }

  /**
   * Sets the label to be displayed when an item is not found during a search.
   *
   * @param createMissingLabel the label string.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setCreateMissingLabel(String createMissingLabel) {
    if (isNull(createMissingLabel) || createMissingLabel.isEmpty()) {
      this.createMissingLabel = getConfig().getMissingItemCreateLabel();
    } else {
      this.createMissingLabel = createMissingLabel;
    }
    return this;
  }

  /**
   * Determines if the provided search token is empty or null.
   *
   * @param token the search string.
   * @return true if the token is null or empty, false otherwise.
   */
  private boolean emptyToken(String token) {
    return isNull(token) || token.isEmpty();
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
   * Retrieves the element used to display a "no results" message when a search yields no results.
   *
   * @return the "no results" element wrapped in a {@link LazyChild} container.
   */
  public LazyChild<LIElement> getNoResultElement() {
    return noResultElement;
  }

  /**
   * Sets the element used to display a "no results" message when a search yields no results.
   *
   * @param noResultElement the HTMLLIElement to be used for displaying "no results".
   * @return The current {@link Menu} instance.
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
   * Sets the element used to display a "no results" message when a search yields no results.
   *
   * @param noResultElement the IsElement wrapping an HTMLLIElement to be used for displaying "no
   *     results".
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setNoResultElement(IsElement<HTMLLIElement> noResultElement) {
    if (nonNull(noResultElement)) {
      setNoResultElement(noResultElement.element());
    }
    return this;
  }

  /**
   * Checks if the menu's search functionality is case-sensitive.
   *
   * @return true if the search is case-sensitive, false otherwise.
   */
  public boolean isCaseSensitive() {
    return caseSensitive;
  }

  /**
   * Sets the menu's search functionality to be case-sensitive or not.
   *
   * @param caseSensitive a boolean indicating whether to enable or disable case-sensitivity.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setCaseSensitive(boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
    return this;
  }

  /**
   * Retrieves the current focus element of the menu.
   *
   * <p>The focus element is determined based on the following criteria: - If a custom focus element
   * has been set, it will be returned. - If the menu is searchable, the search box input will be
   * the focus element. - If the menu contains menu items, the first item will be the focus element.
   * - Otherwise, the root element of the menu items list will be the focus element.
   *
   * @return the current focus element of the menu.
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
   * Sets the focus element for the menu.
   *
   * @param focusElement the HTMLElement to set as the focus element.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setFocusElement(HTMLElement focusElement) {
    this.focusElement = focusElement;
    return this;
  }

  /**
   * Sets the focus element for the menu.
   *
   * @param focusElement the IsElement wrapping an HTMLElement to be set as the focus element.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setFocusElement(IsElement<? extends HTMLElement> focusElement) {
    return setFocusElement(focusElement.element());
  }

  /**
   * Retrieves the search box component used within the menu.
   *
   * @return the {@link SearchBox} instance.
   */
  public SearchBox getSearchBox() {
    return searchBox.get();
  }

  /**
   * Retrieves the keyboard navigation handler for the menu items.
   *
   * @return the keyboard navigation instance.
   */
  public KeyboardNavigation<AbstractMenuItem<V>> getKeyboardNavigation() {
    return keyboardNavigation;
  }

  /**
   * Retrieves the header component of the menu.
   *
   * @return the {@link NavBar} instance representing the menu's header.
   */
  public NavBar getMenuHeader() {
    return menuHeader.get();
  }

  /**
   * Toggles the visibility of the menu's header.
   *
   * @param visible true to make the header visible, false to hide it.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setHeaderVisible(boolean visible) {
    menuHeader.get().toggleDisplay(visible);
    this.headerVisible = visible;
    return this;
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
   * Checks if the menu allows for the creation of missing items.
   *
   * @return true if missing items can be created, false otherwise.
   */
  public boolean isAllowCreateMissing() {
    return nonNull(missingItemHandler);
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

  /**
   * Sets the handler for missing items in the menu. When set, it allows the creation of missing
   * items.
   *
   * @param missingItemHandler the handler to manage missing items.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setMissingItemHandler(MissingItemHandler<V> missingItemHandler) {
    this.missingItemHandler = missingItemHandler;
    return this;
  }

  /**
   * Selects a given menu item.
   *
   * @param menuItem The menu item to select.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> select(AbstractMenuItem<V> menuItem) {
    return select(menuItem, isSelectionListenersPaused());
  }

  /**
   * Selects a given menu item with the option to silence selection events.
   *
   * @param menuItem The menu item to select.
   * @param silent If true, selection listeners will be paused; otherwise, they will be active.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> select(AbstractMenuItem<V> menuItem, boolean silent) {
    menuItem.select(silent);
    return this;
  }

  /**
   * Selects a menu item at a specified index.
   *
   * @param index The index of the menu item to select.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> selectAt(int index) {
    return selectAt(index, isSelectionListenersPaused());
  }

  /**
   * Selects a menu item at a specified index with the option to silence selection events.
   *
   * @param index The index of the menu item to select.
   * @param silent If true, selection listeners will be paused; otherwise, they will be active.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> selectAt(int index, boolean silent) {
    if (index < menuItems.size() && index >= 0) {
      select(menuItems.get(index), silent);
    }
    return this;
  }

  /**
   * Selects a menu item by its key identifier.
   *
   * @param key The key identifier of the menu item to select.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> selectByKey(String key) {
    return selectByKey(key, false);
  }

  /**
   * Selects a menu item by its key identifier with the option to silence selection events.
   *
   * @param key The key identifier of the menu item to select.
   * @param silent If true, selection listeners will be paused; otherwise, they will be active.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> selectByKey(String key, boolean silent) {
    for (AbstractMenuItem<V> menuItem : getMenuItems()) {
      if (menuItem.getKey().equals(key)) {
        select(menuItem, silent);
      }
    }
    return this;
  }

  /**
   * Checks if the menu is set to automatically close upon selection of an item.
   *
   * @return true if the menu will auto-close on selection, false otherwise.
   */
  public boolean isAutoCloseOnSelect() {
    return autoCloseOnSelect;
  }

  /**
   * Sets whether the menu should automatically close upon selecting an item.
   *
   * @param autoCloseOnSelect If true, the menu will auto-close on selection.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setAutoCloseOnSelect(boolean autoCloseOnSelect) {
    this.autoCloseOnSelect = autoCloseOnSelect;
    return this;
  }

  /**
   * Checks if the menu supports selecting multiple items simultaneously.
   *
   * @return true if the menu supports multi-selection, false otherwise.
   */
  public boolean isMultiSelect() {
    return multiSelect;
  }

  /**
   * Enables or disables the ability to select multiple items in the menu.
   *
   * @param multiSelect If true, multi-selection will be enabled.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    return this;
  }

  /**
   * Checks if the menu is set to automatically open.
   *
   * @return true if the menu will auto-open, false otherwise.
   */
  public boolean isAutoOpen() {
    return autoOpen;
  }

  /**
   * Sets whether the menu should automatically open.
   *
   * @param autoOpen If true, the menu will auto-open.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setAutoOpen(boolean autoOpen) {
    this.autoOpen = autoOpen;
    return this;
  }

  /**
   * Checks if the menu is set to fit the width of its target.
   *
   * @return true if the menu fits the target width, false otherwise.
   */
  public boolean isFitToTargetWidth() {
    return fitToTargetWidth;
  }

  /**
   * Sets whether the menu should fit the width of its target.
   *
   * @param fitToTargetWidth If true, the menu will fit the target width.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setFitToTargetWidth(boolean fitToTargetWidth) {
    this.fitToTargetWidth = fitToTargetWidth;
    return this;
  }

  /**
   * Pauses the selection listeners of the menu.
   *
   * @return The current {@link Menu} instance.
   */
  @Override
  public Menu<V> pauseSelectionListeners() {
    this.togglePauseSelectionListeners(true);
    return this;
  }

  /**
   * Resumes the paused selection listeners of the menu.
   *
   * @return The current {@link Menu} instance.
   */
  @Override
  public Menu<V> resumeSelectionListeners() {
    this.togglePauseSelectionListeners(false);
    return this;
  }

  /**
   * Toggles the pause state of the selection listeners.
   *
   * @param toggle If true, pauses the selection listeners; if false, resumes them.
   * @return The current {@link Menu} instance.
   */
  @Override
  public Menu<V> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /**
   * Retrieves the set of selection listeners associated with the menu.
   *
   * @return A set of selection listeners.
   */
  @Override
  public Set<SelectionListener<? super AbstractMenuItem<V>, ? super List<AbstractMenuItem<V>>>>
      getSelectionListeners() {
    return selectionListeners;
  }

  /**
   * Retrieves the set of deselection listeners associated with the menu.
   *
   * @return A set of deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super AbstractMenuItem<V>, ? super List<AbstractMenuItem<V>>>>
      getDeselectionListeners() {
    return deselectionListeners;
  }

  /**
   * Checks if the selection listeners of the menu are currently paused.
   *
   * @return true if the selection listeners are paused, false otherwise.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * Triggers the selection listeners of the menu.
   *
   * @param source The source menu item that caused the selection.
   * @param selection A list of selected menu items.
   * @return The current {@link Menu} instance.
   */
  @Override
  public Menu<V> triggerSelectionListeners(
      AbstractMenuItem<V> source, List<AbstractMenuItem<V>> selection) {
    selectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Triggers the deselection listeners of the menu.
   *
   * @param source The source menu item that caused the deselection.
   * @param selection A list of deselected menu items.
   * @return The current {@link Menu} instance.
   */
  @Override
  public Menu<V> triggerDeselectionListeners(
      AbstractMenuItem<V> source, List<AbstractMenuItem<V>> selection) {
    deselectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Returns the current selection of menu items.
   *
   * @return A list of currently selected menu items.
   */
  @Override
  public List<AbstractMenuItem<V>> getSelection() {
    return selectedValues;
  }

  /**
   * Sets the menu to have a bordered appearance.
   *
   * @param bordered If true, the menu will have a border; if false, it will not.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setBordered(boolean bordered) {
    removeCss("menu-bordered");
    if (bordered) {
      css("menu-bordered");
    }
    return this;
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

  private boolean hasVisibleItems() {
    for (int index = 0; index < menuItems.size(); index++) {
      if (menuItems.get(index).isVisible()) {
        return true;
      }
    }
    return false;
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
   * Checks if the menu is currently open.
   *
   * @return true if the menu is open, false otherwise.
   */
  public boolean isOpened() {
    return isDropDown() && isAttached();
  }

  /**
   * Opens the menu based on a triggering event.
   *
   * @param evt The event that triggered the open action.
   */
  private void open(Event evt) {
    getEffectiveDropDirection().init(evt);
    open();
  }

  /**
   * Opens the menu and optionally sets focus on it.
   *
   * @param focus If true, the menu will be focused upon opening.
   */
  public void open(boolean focus) {
    triggerOnBeforeOpenListeners();
    if (isDropDown() && openMenuCondition.check(this)) {
      if (getTarget().isPresent()) {
        DominoElement<Element> targetElement = getTarget().get().getTargetElement();
        targetElement.addCss(dui_context_menu_target_open);
        if (!(targetElement.isReadOnly() || targetElement.isDisabled())) {
          doOpen(focus);
        }
      } else {
        doOpen(focus);
      }
    }
  }

  /**
   * Opens the menu and manages the necessary UI changes and events.
   *
   * @param focus If true, the menu will be focused upon opening.
   */
  private void doOpen(boolean focus) {
    getConfig().getZindexManager().onPopupOpen(this);
    if (isOpened()) {
      position();
    } else {
      closeOthers();
      if (isSearchable()) {
        searchBox.get().clearSearch();
      }
      triggerOpenListeners(this);
      shouldFocus = focus;
      removeAttachObserver(onAttachHandler);
      onAttached(onAttachHandler);
      appendStrategy.onAppend(getMenuAppendTarget().element(), element.element());
      removeDetachObserver(onDetachHandler);
      onDetached(onDetachHandler);
      if (smallScreen && nonNull(parent) && parent.isDropDown()) {
        parent.collapse();
        menuHeader.get().insertFirst(backArrowContainer);
      }
      show();
      getMenuAppendTarget().onDetached(onAppendTargetDetach);
    }
  }

  public Menu<V> triggerOnBeforeOpenListeners() {
    if (isDropDown()) {
      getOnBeforeOpenListeners().forEach(listener -> listener.onBeforeOpen(this));
    }
    return this;
  }

  /** Adjusts the position of the menu relative to its target element. */
  private void position() {
    if (isDropDown() && isOpened()) {
      Optional<MenuTarget> menuTarget = getTarget();
      menuTarget.ifPresent(
          target -> {
            getEffectiveDropDirection()
                .position(
                    DropDirectionContext.of(
                        element.element(), target.getTargetElement().element(), fitToTargetWidth));
            DomGlobal.setTimeout(p -> startScrollFollow = true);
          });
    }
  }

  /**
   * Determines the effective drop direction of the menu based on various conditions.
   *
   * @return The drop direction for the menu.
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

  /** Closes other menus if they are opened. */
  private void closeOthers() {
    if (this.hasAttribute("domino-sub-menu")
        && Boolean.parseBoolean(this.getAttribute("domino-sub-menu"))) {
      return;
    }
    PopupsCloser.close();
  }

  /** Sets the focus on the menu. */
  public void focus() {
    getFocusElement().focus();
  }

  /**
   * Gets the current target element for the menu.
   *
   * @return An optional containing the menu target, or empty if no target is set.
   */
  public Optional<MenuTarget> getTarget() {
    if (isNull(lastTarget) && targets().size() == 1) {
      return targets().values().stream().findFirst();
    }
    return Optional.ofNullable(lastTarget);
  }

  /**
   * Sets the target element for the menu.
   *
   * @param targetElement The element to be set as the menu's target.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setTargetElement(IsElement<?> targetElement) {
    return setTargetElement(targetElement.element());
  }

  /**
   * Sets the target element for the menu.
   *
   * @param targetElement The element to be set as the menu's target.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setTargetElement(Element targetElement) {
    if (nonNull(targetElement)) {
      setTarget(MenuTarget.of(targetElement));
    } else {
      clearTargets();
    }
    return this;
  }

  /**
   * Sets the target element for the menu.
   *
   * @param targetElement The element to be set as the menu's target.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> addTargetElement(Element targetElement) {
    if (nonNull(targetElement)) {
      addTarget(MenuTarget.of(targetElement));
    } else {
      clearTargets();
    }
    return this;
  }

  /**
   * Sets the menu target.
   *
   * @param menuTarget The {@link MenuTarget} instance representing the menu's target.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setTarget(MenuTarget menuTarget) {
    clearTargets();
    return addTarget(menuTarget);
  }

  public Menu<V> clearTargets() {
    new ArrayList<>(this.targets().values()).forEach(this::removeTarget);
    return this;
  }

  /**
   * Adds a new target for the menu.
   *
   * @param menuTarget The new target to add.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> addTarget(MenuTarget menuTarget) {
    if (nonNull(menuTarget)) {
      this.targets().put(menuTarget.getTargetElement().getDominoId(), menuTarget);
      MutationObserverCallback detachCallback =
          MutationObserverCallback.doOnce(
              mutationRecord -> {
                if (Objects.equals(menuTarget, lastTarget)) {
                  close();
                }
                removeTarget(menuTarget);
              });
      menuTarget.setTargetDetachObserver(detachCallback);

      MutationObserverCallback attachCallback =
          MutationObserverCallback.doOnce(
              mutationRecord -> {
                Menu.this.targets().put(menuTarget.getTargetElement().getDominoId(), menuTarget);
              });

      menuTarget.setTargetAttachObserver(attachCallback);

      menuTarget.setObservers();
    }
    if (!this.targets().isEmpty()) {
      applyTargetListeners(menuTarget);
      setDropDown(true);
    } else {
      setDropDown(false);
    }
    return this;
  }

  /**
   * Removes a single menu target.
   *
   * @param target the target to be removed
   * @return same menu instance
   */
  public Menu<V> removeTarget(MenuTarget target) {
    if (nonNull(target) && targets().containsKey(target.getTargetElement().getDominoId())) {
      MenuTarget menuTarget = targets().get(target.getTargetElement().getDominoId());
      menuTarget
          .getTargetElement()
          .removeEventListener(
              isContextMenu() ? EventType.contextmenu.getName() : EventType.click.getName(),
              openListener);
      targets.remove(menuTarget.getTargetElement().getDominoId());
      DominoElement<Element> targetElement = menuTarget.getTargetElement();

      targetElement.onAttached(
          MutationObserverCallback.doOnce(
              mutationRecord -> {
                if (!targets().containsKey(targetElement.getDominoId())) {
                  addTargetElement(targetElement.element());
                }
              }));

      menuTarget.cleanUp();
      if (Objects.equals(lastTarget, menuTarget)) {
        this.lastTarget = null;
      }
    }
    return this;
  }

  /**
   * Gets the element to which the menu is appended in the DOM.
   *
   * @return The append target element.
   */
  public DominoElement<Element> getMenuAppendTarget() {
    return menuAppendTarget;
  }

  /**
   * Sets the element to which the menu will be appended in the DOM.
   *
   * @param appendTarget The new append target element.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setMenuAppendTarget(Element appendTarget) {
    if (isNull(appendTarget)) {
      this.menuAppendTarget = elementOf(document.body);
    } else {
      this.menuAppendTarget = elementOf(appendTarget);
    }
    return this;
  }

  /**
   * Opens the menu if it is a dropdown type.
   *
   * @return The current {@link Menu} instance.
   */
  public Menu<V> open() {
    if (isDropDown()) {
      open(isAutoFocus());
    }
    return this;
  }

  /**
   * Closes the menu if it is a dropdown type and if it is currently open.
   *
   * @return The current {@link Menu} instance.
   */
  public Menu<V> close() {
    if (isDropDown()) {
      if (isOpened()) {
        this.remove();
        removeAttribute(DUI_POSITION_FALLBACK);
        getTarget()
            .ifPresent(
                menuTarget -> {
                  menuTarget.getTargetElement().element().focus();
                  menuTarget.getTargetElement().removeCss(dui_context_menu_target_open);
                });
        if (isSearchable()) {
          searchBox.get().clearSearch();
        }
        menuItems.forEach(AbstractMenuItem::onParentClosed);
        if (smallScreen && nonNull(parent) && parent.isDropDown()) {
          parent.expand();
        }
      }
      removeCssProperty(SpaceChecker.MAX_HEIGHT);
      removeCssProperty(SpaceChecker.MAX_WIDTH);
      getMenuAppendTarget().removeDetachObserver(onAppendTargetDetach);
    }
    return this;
  }

  /**
   * Retrieves the direction in which the menu will drop when opened.
   *
   * @return The current drop direction for the menu.
   */
  public DropDirection getDropDirection() {
    return dropDirection;
  }

  /**
   * Sets the direction in which the menu will drop when opened.
   *
   * @param dropDirection The desired drop direction.
   * @return The current {@link Menu} instance.
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

  /**
   * Checks if the menu is set as a context menu.
   *
   * @return {@code true} if the menu is a context menu, {@code false} otherwise.
   */
  public boolean isContextMenu() {
    return contextMenu;
  }

  /**
   * Sets the menu as a context menu or not.
   *
   * @param contextMenu {@code true} to set the menu as a context menu, {@code false} otherwise.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setContextMenu(boolean contextMenu) {
    this.contextMenu = contextMenu;
    addCss(BooleanCssClass.of(dui_context_menu, contextMenu));
    targets().values().forEach(this::applyTargetListeners);
    return this;
  }

  /**
   * Applies the appropriate event listeners to the target element based on whether the menu is a
   * context menu or not.
   *
   * @param menuTarget The target menu to which the listeners should bce applied.
   */
  private void applyTargetListeners(MenuTarget menuTarget) {
    if (nonNull(menuTarget)) {
      if (isContextMenu()) {
        menuTarget.getTargetElement().removeEventListener(EventType.click.getName(), openListener);
        menuTarget
            .getTargetElement()
            .addEventListener(EventType.contextmenu.getName(), openListener);
      } else {
        menuTarget
            .getTargetElement()
            .removeEventListener(EventType.contextmenu.getName(), openListener);
        menuTarget.getTargetElement().addEventListener(EventType.click.getName(), openListener);
      }
    }
  }

  /**
   * Handles the event when an item is selected in the menu.
   *
   * @param item The item that was selected.
   * @param silent Indicates whether the selection was silent or should trigger events.
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
          new ArrayList<>(this.selectedValues)
              .stream()
                  .filter(menuItem -> DeselectionMode.DESELECT == menuItem.getDeselectionMode())
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

  /**
   * Handles the event when an item is deselected in the menu.
   *
   * @param item The item that was deselected.
   * @param silent Indicates whether the deselection was silent or should trigger events.
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
   * Checks if the menu is configured to use the small screens direction for dropping.
   *
   * @return {@code true} if the menu uses the small screens direction, {@code false} otherwise.
   */
  public boolean isUseSmallScreensDirection() {
    return useSmallScreensDirection;
  }

  /**
   * Sets whether the menu should use the small screens drop direction.
   *
   * @param useSmallScreensDropDirection {@code true} to enable small screens drop direction, {@code
   *     false} otherwise.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setUseSmallScreensDirection(boolean useSmallScreensDropDirection) {
    this.useSmallScreensDirection = useSmallScreensDropDirection;
    if (!useSmallScreensDropDirection && getEffectiveDropDirection() == smallScreenDropDirection) {
      this.effectiveDropDirection = dropDirection;
    }
    return this;
  }

  /**
   * Determines if the menu acts as a drop-down or a context menu.
   *
   * @return {@code true} if the menu acts as a drop-down or a context menu, {@code false}
   *     otherwise.
   */
  public boolean isDropDown() {
    return dropDown || isContextMenu();
  }

  /**
   * Sets the menu's behavior to be a dropdown or not. It also adjusts attributes and listeners
   * accordingly.
   *
   * @param dropdown {@code true} to set the menu as a dropdown, {@code false} otherwise.
   */
  private void setDropDown(boolean dropdown) {
    if (dropdown) {
      this.setAttribute("domino-ui-root-menu", true).setAttribute(DOMINO_UI_AUTO_CLOSABLE, true);
      menuElement.addCss(dui_elevation_1);
    } else {
      this.removeAttribute("domino-ui-root-menu").removeAttribute(DOMINO_UI_AUTO_CLOSABLE);
      menuElement.addCss(dui_elevation_none);
      document.removeEventListener("scroll", repositionListener);
    }
    addCss(BooleanCssClass.of(dui_menu_drop, dropdown));
    this.dropDown = dropdown;
    setAutoClose(this.dropDown);
  }

  /**
   * Adds a handler that is triggered when a new item is added to the menu.
   *
   * @param onAddItemHandler The handler to add.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> addOnAddItemHandler(OnAddItemHandler<V> onAddItemHandler) {
    if (nonNull(onAddItemHandler)) {
      this.onAddItemHandlers.add(onAddItemHandler);
    }
    return this;
  }

  /**
   * Configures the menu to include a header.
   *
   * @return The current {@link Menu} instance.
   */
  public Menu<V> withHeader() {
    menuHeader.get();
    return this;
  }

  /**
   * Configures the menu to include a customized header.
   *
   * @param handler A handler to customize the header.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> withHeader(ChildHandler<Menu<V>, NavBar> handler) {
    handler.apply(this, menuHeader.get());
    return this;
  }

  /**
   * Checks if the menu is modal.
   *
   * @return {@code false} since the menu isn't a modal.
   */
  @Override
  public boolean isModal() {
    return false;
  }

  /**
   * Checks if the menu is set to auto-close.
   *
   * @return {@code true} if the menu is set to auto-close, {@code false} otherwise.
   */
  @Override
  public boolean isAutoClose() {
    return Boolean.parseBoolean(getAttribute(DOMINO_UI_AUTO_CLOSABLE, "false"));
  }

  /**
   * Sets the auto-close behavior for the menu.
   *
   * @param autoClose {@code true} to set the menu to auto-close, {@code false} otherwise.
   * @return The current {@link Menu} instance.
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
   * Sets the condition for opening the menu.
   *
   * @param openMenuCondition A condition that needs to be met for the menu to open. If null,
   *     defaults to always allow the menu to open.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setOpenMenuCondition(OpenMenuCondition<V> openMenuCondition) {
    if (isNull(openMenuCondition)) {
      this.openMenuCondition = menu -> true;
      return this;
    }
    this.openMenuCondition = openMenuCondition;
    return this;
  }

  /**
   * Checks if the menu is set to close when it loses focus.
   *
   * @return {@code true} if the menu is set to close on blur, {@code false} otherwise.
   */
  public boolean isCloseOnBlur() {
    return closeOnBlur;
  }

  /**
   * Sets the close-on-blur behavior for the menu.
   *
   * @param closeOnBlur {@code true} to set the menu to close when it loses focus, {@code false}
   *     otherwise.
   * @return The current {@link Menu} instance.
   */
  public Menu<V> setCloseOnBlur(boolean closeOnBlur) {
    this.closeOnBlur = closeOnBlur;
    return this;
  }

  public Menu<V> setCloseOnScroll(boolean closeOnScroll) {
    if (!closeOnScroll) {
      window.removeEventListener("scroll", closeOnScrollListener);
    }
    setAttribute("d-close-on-scroll", closeOnScroll);
    return this;
  }

  private boolean isCloseOnScroll() {
    return hasAttribute("d-close-on-scroll")
        && "true".equalsIgnoreCase(getAttribute("d-close-on-scroll"));
  }

  private Map<String, MenuTarget> targets() {
    if (isNull(this.targets)) {
      this.targets = new HashMap<>();
    }
    return this.targets;
  }

  /**
   * @return boolean true if the selection style should be preserved after the menu item loses the
   *     selection focus, otherwise false.
   */
  public boolean isPreserveSelectionStyles() {
    return preserveSelectionStyles;
  }

  /**
   * if true selecting an Item in the menu will preserve the selection style when the menu loses the
   * focus.
   *
   * @param preserveSelectionStyles boolean, true to preserve the style, false to remove the style.
   * @return same Menu instance.
   */
  public Menu<V> setPreserveSelectionStyles(boolean preserveSelectionStyles) {
    this.preserveSelectionStyles = preserveSelectionStyles;
    return this;
  }

  @Override
  public ZIndexLayer getZIndexLayer() {
    if (isDropDown()) {
      return getTarget()
          .map(t -> t.getTargetElement().getZIndexLayer())
          .orElse(ZIndexLayer.Z_LAYER_1);
    }
    return super.getZIndexLayer();
  }

  /**
   * Retrieves the set of {@link OpenListener}s registered for this element.
   *
   * @return A set of {@link OpenListener} instances.
   */
  public Set<OnBeforeOpenListener<? super Menu<V>>> getOnBeforeOpenListeners() {
    return onBeforeOpenListeners();
  }

  private Set<OnBeforeOpenListener<? super Menu<V>>> onBeforeOpenListeners() {
    if (isNull(this.onBeforeOpenListeners)) {
      this.onBeforeOpenListeners = new HashSet<>();
    }
    return onBeforeOpenListeners;
  }

  /**
   * Adds an open event listener to the element.
   *
   * @param onBeforeOpenListener The open event listener to be added.
   * @return The element with the open event listener added.
   */
  public Menu<V> addOnBeforeOpenListener(
      OnBeforeOpenListener<? super Menu<V>> onBeforeOpenListener) {
    getOnBeforeOpenListeners().add(onBeforeOpenListener);
    return this;
  }

  /**
   * Removes a close event listener from the element.
   *
   * @param onBeforeOpenListener The close event listener to be removed.
   * @return The element with the close event listener removed.
   */
  public Menu<V> removeOnBeforeOpenListener(
      OnBeforeOpenListener<? super Menu<V>> onBeforeOpenListener) {
    getOnBeforeOpenListeners().remove(onBeforeOpenListener);
    return this;
  }

  public SingleSelectionMode getSelectionMode() {
    return selectionMode;
  }

  public Menu<V> setSelectionMode(SingleSelectionMode selectionMode) {
    this.selectionMode = selectionMode;
    return this;
  }

  public Menu<V> setAutoFocus(boolean autoFocus) {
    this.autoFocus = autoFocus;
    return this;
  }

  public boolean isAutoFocus() {
    return autoFocus;
  }

  SingleSelectionMode getEffectiveSelectionMode() {
    if (SingleSelectionMode.INHERIT.equals(getSelectionMode())) {
      return isNull(parent)
          ? config().getUIConfig().getDefaultSelectionMode()
          : parent.getEffectiveSelectionMode();
    }
    return getSelectionMode();
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

  /** Represents a handler called when a new item is added to the menu. */
  public interface OnAddItemHandler<V> {

    /**
     * Called when a new menu item is added.
     *
     * @param menu The menu to which the item was added.
     * @param menuItem The added menu item.
     */
    void onAdded(Menu<V> menu, AbstractMenuItem<V> menuItem);
  }

  public interface OnBeforeOpenListener<T> {
    void onBeforeOpen(T target);
  }
}
