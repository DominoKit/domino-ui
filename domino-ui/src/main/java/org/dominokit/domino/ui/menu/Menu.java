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

import java.util.*;

import org.checkerframework.checker.units.qual.A;
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
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * The base component to create a menu like UI.
 *
 * @param <V> The type of the menu items value
 */
public class Menu<V>
        extends BaseDominoElement<HTMLDivElement, Menu<V>> implements HasSelectionListeners<Menu<V>, AbstractMenuItem<V, ?>, List<AbstractMenuItem<V, ?>>> {

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
    private MissingItemHandler<V> missingItemHandler;

    protected List<AbstractMenuItem<V, ?>> menuItems = new ArrayList<>();
    protected boolean autoCloseOnSelect = true;
    protected final Set<SelectionListener<? super AbstractMenuItem<V, ?>, ? super List<AbstractMenuItem<V, ?>>>> selectionListeners = new LinkedHashSet<>();
    protected final Set<SelectionListener<? super AbstractMenuItem<V, ?>, ? super List<AbstractMenuItem<V, ?>>>> deselectionListeners = new LinkedHashSet<>();

    private final List<AbstractMenuItem<V, ?>> selectedValues = new ArrayList<>();
    protected boolean headerVisible = false;
    private Menu<V> currentOpen;

    private boolean smallScreen;
    private DropDirection dropDirection = new BestSideUpDownDropDirection();
    private final DropDirection contextMenuDropDirection = new MouseBestFitDirection();
    private final DropDirection smallScreenDropDirection = new MiddleOfScreenDropDirection();
    private DropDirection effectiveDropDirection = dropDirection;
    private HTMLElement targetElement;
    private HTMLElement appendTarget = document.body;
    private AppendStrategy appendStrategy = AppendStrategy.LAST;

    private final List<Menu.CloseHandler> closeHandlers = new ArrayList<>();
    private final List<Menu.OpenHandler> openHandlers = new ArrayList<>();

    private Menu<V> parent;
    private AbstractMenuItem<V, ?> parentItem;

    private boolean selectionListenersPaused = false;
    private boolean multiSelect = false;
    private boolean autoOpen = true;

    private final EventListener openListener =
            evt -> {
                evt.stopPropagation();
                evt.preventDefault();
                if(isAutoOpen()) {
                    open(evt);
                }
            };
    private final FlexItem<HTMLDivElement> backArrowContainer =
            FlexItem.create().setOrder(0).css("back-arrow-icon").hide();
    private boolean contextMenu = false;
    private boolean useSmallScreensDirection = true;
    private boolean dropDown = false;

    private OnAddItemHandler<V> onAddItemHandler = (menu, menuItem) -> {
    };
    private boolean fitToTargetWidth = false;

    public static <V> Menu<V> create() {
        return new Menu<>();
    }

    public Menu() {
        menuElement = DominoElement.div().addCss(MENU);
        menuHeader = LazyChild.of(new MenuHeader(), menuElement);
        menuSearchContainer = LazyChild.of(DominoElement.div().addCss(MENU_SEARCH), menuElement);
        searchBox = LazyChild.of(SearchBox.create(), menuSearchContainer);
        init(this);

        EventListener addMissingEventListener = evt -> {
            evt.preventDefault();
            evt.stopPropagation();
            onAddMissingElement();
        };

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
                            .element()
                            .removeEventListener("click", addMissingEventListener)
                            .addClickListener(addMissingEventListener);

                    KeyboardEvents.listenOnKeyDown(createMissingElement.element())
                            .clear()
                            .onEnter(addMissingEventListener)
                            .onTab(evt -> keyboardNavigation.focusTopFocusableItem())
                            .onArrowDown(evt -> keyboardNavigation.focusTopFocusableItem())
                    ;
                });
        searchBox.whenInitialized(
                () -> {
                    searchBox.element().addSearchListener(this::onSearch);
                    KeyboardEvents.listenOnKeyDown(this.searchBox.element().getTextBox().getInputElement())
                            .onArrowDown(
                                    evt -> {
                                        if (isAllowCreateMissing() && createMissingElement.get().isAttached()) {
                                            createMissingElement.get().element().focus();
                                        } else {
                                            keyboardNavigation.focusTopFocusableItem();
                                        }
                                    })
                            .onEscape(evt -> close());
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
                    backArrowContainer.remove();
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
        if (nonNull(missingItemHandler)) {
            missingItemHandler.onMissingItem(searchBox.get().getTextBox().getValue(), this);
            onSearch(searchBox.get().getTextBox().getValue());
            createMissingElement.remove();
            keyboardNavigation.focusTopFocusableItem();
        }
    }

    /**
     * Set the menu icon in the header, setting the icon will force the header to show up if not
     * visible
     *
     * @param icon Any Icon instance that extends from {@link BaseIcon}
     * @return the same menu instance
     */
    public Menu<V> setIcon(BaseIcon<?> icon) {
        menuHeader.get().setIcon(icon);
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
     * Appends an element to menu actions bar, appending an action element will force the header to
     * show up if not visible
     *
     * @param element {@link HTMLElement}
     * @return same menu instance
     */
    public Menu<V> appendAction(HTMLElement element) {
        menuHeader.get().appendAction(element);
        return this;
    }

    /**
     * Appends an element to menu actions bar, appending an action element will force the header to
     * show up if not visible
     *
     * @param element {@link IsElement}
     * @return same menu instance
     */
    public Menu<V> appendAction(IsElement<?> element) {
        menuHeader.get().appendAction(element);
        return this;
    }

    /**
     * Appends a child element to the menu subheader, the subheader will show up below the search and
     * before the menu items.
     *
     * @param element {@link HTMLElement}
     * @return same menu instance
     */
    public Menu<V> appendSubHeaderChild(HTMLElement element) {
        menuSubHeader.get().appendChild(element);
        return this;
    }

    /**
     * Appends a child element to the menu subheader, the subheader will show up below the search and
     * before the menu items.
     *
     * @param element {@link IsElement}
     * @return same menu instance
     */
    public Menu<V> appendSunHeaderChild(IsElement<?> element) {
        menuSubHeader.get().appendChild(element);
        return this;
    }

    /**
     * Appends a menu item to this menu
     *
     * @param menuItem {@link Menu}
     * @return same menu instance
     */
    public Menu<V> appendChild(AbstractMenuItem<V, ?> menuItem) {
        if (nonNull(menuItem)) {
            menuItemsList.appendChild(menuItem);
            menuItems.add(menuItem);
            menuItem.setParent(this);
            onItemAdded(menuItem);
        }
        return this;
    }

    void onItemAdded(AbstractMenuItem<V, ?> menuItem) {
        onAddItemHandler.onAdded(this, menuItem);
    }

    /**
     * Appends a menu item to this menu
     *
     * @param menuGroup {@link MenuItemsGroup}
     * @return same menu instance
     */
    public <I extends AbstractMenuItem<V, I>> Menu<V> appendGroup(
            MenuItemsGroup<V, I> menuGroup, MenuItemsGroupHandler<V, I> groupHandler) {
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
     * @param menuItem {@link Menu}
     * @return same menu instance
     */
    public Menu<V> removeItem(AbstractMenuItem<V, ?> menuItem) {
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
     */
    public Menu<V> appendSeparator() {
        this.menuItemsList.appendChild(
                DominoElement.li().add(DominoElement.span().addCss(MENU_SEPARATOR)));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return menuElement.element();
    }

    private void clearSearch() {
        searchBox.get().clearSearch();
    }

    public void clearSelection(boolean silent){
        selectedValues.clear();
        if(!silent){
           triggerDeselectionListeners(null, selectedValues);
        }
    }

    /**
     * If search is enabled, when search is trigger it will call this method.
     *
     * @param token String user input in the {@link SearchBox}
     * @return boolean, true if there is at least one menu item that matched the search token, else
     * will return false.
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

    /**
     * @return String label that indicate the create missing items action
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

    /**
     * @return a List of {@link AbstractMenuItem} of this menu
     */
    public List<AbstractMenuItem<V, ?>> getMenuItems() {
        return menuItems;
    }

    /**
     * @return The {@link DominoElement} of the {@link HTMLLIElement} that is used to represent no
     * results when search is applied
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
    public Menu<V> setNoResultElement(HTMLLIElement noResultElement) {
        if (nonNull(noResultElement)) {
            this.noResultElement.remove();
            this.noResultElement =
                    LazyChild.of(DominoElement.of(noResultElement).addCss(MENU_NO_RESULTS), menuItemsList);
        }
        return this;
    }

    /**
     * Sets a custom element to represent no results when search is applied.
     *
     * @param noResultElement {@link IsElement} of {@link HTMLLIElement}
     * @return same menu instance
     */
    public Menu<V> setNoResultElement(IsElement<HTMLLIElement> noResultElement) {
        if (nonNull(noResultElement)) {
            setNoResultElement(noResultElement.element());
        }
        return this;
    }

    /**
     * @return boolean, true if this menu search is case-sensitive
     */
    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public Menu<V> setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    /**
     * @return the {@link HTMLElement} that should be focused by default when open the menu
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
     * @param focusElement {@link HTMLElement}
     * @return same menu instance
     */
    public Menu<V> setFocusElement(HTMLElement focusElement) {
        this.focusElement = focusElement;
        return this;
    }

    /**
     * Sets a custom element as the default focus element of the menu
     *
     * @param focusElement {@link IsElement}
     * @return same menu instance
     */
    public Menu<V> setFocusElement(IsElement<? extends HTMLElement> focusElement) {
        return setFocusElement(focusElement.element());
    }

    /**
     * @return the {@link SearchBox} of the menu
     */
    public SearchBox getSearchBox() {
        return searchBox.get();
    }

    /**
     * @return The {@link KeyboardNavigation} of the menu
     */
    public KeyboardNavigation<AbstractMenuItem<V, ?>> getKeyboardNavigation() {
        return keyboardNavigation;
    }

    /**
     * @return The {@link MenuHeader} component of the menu
     */
    public MenuHeader getMenuHeader() {
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

    /**
     * @return boolean, true if search is enabled
     */
    public boolean isSearchable() {
        return searchable;
    }

    /**
     * @return boolean, true if search is enabled
     */
    public boolean isAllowCreateMissing() {
        return nonNull(missingItemHandler);
    }

    /**
     * Enable/Disable search
     *
     * @param searchable boolean, true to search box and enable search, false to hide the search box
     *                   and disable search.
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
     * @param missingItemHandler {@link MissingItemHandler}
     * @return same menu instance
     */
    public Menu<V> setMissingItemHandler(MissingItemHandler<V> missingItemHandler) {
        this.missingItemHandler = missingItemHandler;
        return this;
    }

    /**
     * Selects the specified menu item if it is one of this menu items
     *
     * @param menuItem {@link AbstractMenuItem}
     * @return same menu instance
     */
    public Menu<V> select(AbstractMenuItem<V, ?> menuItem) {
        return select(menuItem, isSelectionListenersPaused());
    }

    /**
     * Selects the menu item at the specified index if exists
     *
     * @param menuItem {@link AbstractMenuItem}
     * @param silent   boolean, true to avoid triggering change handlers
     * @return same menu instance
     */
    public Menu<V> select(AbstractMenuItem<V, ?> menuItem, boolean silent) {
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
     * @param index  int
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
     * @param key    String
     * @param silent boolean, true to avoid triggering change handlers
     * @return same menu instance
     */
    public Menu<V> selectByKey(String key, boolean silent) {
        for (AbstractMenuItem<V, ?> menuItem : getMenuItems()) {
            if (menuItem.getKey().equals(key)) {
                select(menuItem, silent);
            }
        }
        return this;
    }

    /**
     * @return boolean, true if the menu should close after selecting a menu item
     */
    public boolean isAutoCloseOnSelect() {
        return autoCloseOnSelect;
    }

    /**
     * @param autoCloseOnSelect boolean, if true the menu will close after selecting a menu item
     *                          otherwise it remains open
     * @return same menu instance
     */
    public Menu<V> setAutoCloseOnSelect(boolean autoCloseOnSelect) {
        this.autoCloseOnSelect = autoCloseOnSelect;
        return this;
    }

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public Menu<V> setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
        return this;
    }

    public boolean isAutoOpen() {
        return autoOpen;
    }

    public Menu<V> setAutoOpen(boolean autoOpen) {
        this.autoOpen = autoOpen;
        return this;
    }

    public boolean isFitToTargetWidth() {
        return fitToTargetWidth;
    }

    public Menu<V> setFitToTargetWidth(boolean fitToTargetWidth) {
        this.fitToTargetWidth = fitToTargetWidth;
        return this;
    }

    @Override
    public Menu<V> pauseSelectionListeners() {
        this.togglePauseSelectionListeners(true);
        return this;
    }

    @Override
    public Menu<V> resumeSelectionListeners() {
        this.togglePauseSelectionListeners(false);
        return this;
    }

    @Override
    public Menu<V> togglePauseSelectionListeners(boolean toggle) {
        this.selectionListenersPaused = toggle;
        return this;
    }

    @Override
    public Set<SelectionListener<? super AbstractMenuItem<V, ?>, ? super List<AbstractMenuItem<V, ?>>>> getSelectionListeners() {
        return selectionListeners;
    }

    @Override
    public Set<SelectionListener<? super AbstractMenuItem<V, ?>, ? super List<AbstractMenuItem<V, ?>>>> getDeselectionListeners() {
        return deselectionListeners;
    }

    @Override
    public boolean isSelectionListenersPaused() {
        return this.selectionListenersPaused;
    }

    @Override
    public Menu<V> triggerSelectionListeners(AbstractMenuItem<V, ?> source, List<AbstractMenuItem<V, ?>> selection) {
        selectionListeners.forEach(listener -> listener.onSelectionSelection(Optional.ofNullable(source), selection));
        return this;
    }

    @Override
    public Menu<V> triggerDeselectionListeners(AbstractMenuItem<V, ?> source, List<AbstractMenuItem<V, ?>> selection) {
        deselectionListeners.forEach(listener -> listener.onSelectionSelection(Optional.ofNullable(source), selection));
        return this;
    }

    @Override
    public List<AbstractMenuItem<V, ?>> getSelected() {
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
     * @param dropMenu {@link Menu} to open
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

    /**
     * @return True if the menu is opened, false otherwise
     */
    public boolean isOpened() {
        return isDropDown() && element.isAttached();
    }

    private void open(Event evt){
        getEffectiveDropDirection().init(evt);
        open();
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
                if(isSearchable()) {
                    searchBox.get().clearSearch();
                }
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
                if(fitToTargetWidth){
                    element.setWidth(getAppendTarget().getBoundingClientRect().width+"px") ;
                }
                appendStrategy.onAppend(getAppendTarget(), element.element());
                onDetached(record -> close());
                if (smallScreen && nonNull(parent) && parent.isDropDown()) {
                    parent.hide();
                    menuHeader.get().insertFirst(backArrowContainer);
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

    public void focus() {
        getFocusElement().focus();
    }

    /**
     * @return the {@link HTMLElement} that triggers this menu to open, and which the positioning of
     * the menu will be based on.
     */
    public HTMLElement getTargetElement() {
        return targetElement;
    }

    /**
     * @param targetElement The {@link IsElement} that triggers this menu to open, and which the
     *                      positioning of the menu will be based on.
     * @return same menu instance
     */
    public Menu<V> setTargetElement(IsElement<?> targetElement) {
        return setTargetElement(targetElement.element());
    }

    /**
     * @param targetElement The {@link HTMLElement} that triggers this menu to open, and which the
     *                      positioning of the menu will be based on.
     * @return same menu instance
     */
    public Menu<V> setTargetElement(HTMLElement targetElement) {
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
        return this;
    }

    /**
     * @return the {@link HTMLElement} to which the menu will be appended to when opened.
     */
    public HTMLElement getAppendTarget() {
        return appendTarget;
    }

    /**
     * set the {@link HTMLElement} to which the menu will be appended to when opened.
     *
     * @param appendTarget {@link HTMLElement}
     * @return same menu instance
     */
    public Menu<V> setAppendTarget(HTMLElement appendTarget) {
        if (isNull(appendTarget)) {
            this.appendTarget = document.body;
        } else {
            this.appendTarget = appendTarget;
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
                getTargetElement().focus();
                if(isSearchable()) {
                    searchBox.get().clearSearch();
                }
                menuItems.forEach(AbstractMenuItem::onParentClosed);
                closeHandlers.forEach(CloseHandler::onClose);
                if (smallScreen && nonNull(parent) && parent.isDropDown()) {
                    parent.show();
                }
            }
        }
        return this;
    }

    /**
     * @return The current {@link DropDirection} of the menu
     */
    public DropDirection getDropDirection() {
        return dropDirection;
    }

    /**
     * Sets the {@link DropDirection} of the menu
     *
     * @param dropDirection {@link DropDirection}
     * @return same menu instance
     */
    public Menu<V> setDropDirection(DropDirection dropDirection) {
        if (effectiveDropDirection.equals(this.dropDirection)) {
            this.dropDirection = dropDirection;
            this.effectiveDropDirection = this.dropDirection;
        } else {
            this.dropDirection = dropDirection;
        }
        return this;
    }

    /**
     * Adds a close handler to be called when the menu is closed
     *
     * @param closeHandler The {@link CloseHandler} to add
     * @return same instance
     */
    public Menu<V> addCloseHandler(CloseHandler closeHandler) {
        closeHandlers.add(closeHandler);
        return this;
    }

    /**
     * Removes a close handler
     *
     * @param closeHandler The {@link CloseHandler} to remove
     * @return same instance
     */
    public Menu<V> removeCloseHandler(CloseHandler closeHandler) {
        closeHandlers.remove(closeHandler);
        return this;
    }

    /**
     * Adds an open handler to be called when the menu is opened
     *
     * @param openHandler The {@link OpenHandler} to add
     * @return same instance
     */
    public Menu<V> addOpenHandler(OpenHandler openHandler) {
        openHandlers.add(openHandler);
        return this;
    }

    /**
     * Removes an open handler
     *
     * @param openHandler The {@link OpenHandler} to remove
     * @return same instance
     */
    public Menu<V> removeOpenHandler(OpenHandler openHandler) {
        openHandlers.remove(openHandler);
        return this;
    }

    void setParent(Menu<V> parent) {
        this.parent = parent;
    }

    /**
     * @return the parent {@link Menu} of the menu
     */
    public Menu<V> getParent() {
        return parent;
    }

    void setParentItem(AbstractMenuItem<V, ?> parentItem) {
        this.parentItem = parentItem;
    }

    /**
     * @return the {@link AbstractMenuItem} that opens the menu
     */
    public AbstractMenuItem<V, ?> getParentItem() {
        return parentItem;
    }

    /**
     * @return boolean, true if the menu is a context menu that will open on right click
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
        if (nonNull(targetElement)) {
            applyTargetListeners();
        }
        return this;
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
                close();
                PopupsCloser.close();
            }
            if (!multiSelect && !this.selectedValues.isEmpty()) {
                this.selectedValues.get(0).deselect(false);
                this.selectedValues.clear();
            }
            this.selectedValues.add(item);
            triggerSelectionListeners(item, getSelected());
        }
    }

    protected void onItemDeselected(AbstractMenuItem<V, ?> item) {
        if (nonNull(parent)) {
            parent.onItemDeselected(item);
        } else {
            if (isAutoCloseOnSelect() && !item.hasMenu()) {
                close();
                PopupsCloser.close();
            }
            this.selectedValues.remove(item);
            triggerDeselectionListeners(item, getSelected());
        }
    }

    /**
     * @return boolean, true if use of small screens drop direction to the middle of screen is used or
     * else false
     */
    public boolean isUseSmallScreensDirection() {
        return useSmallScreensDirection;
    }

    /**
     * @param useSmallScreensDropDirection boolean, true to allow the switch to small screen middle of
     *                                     screen position, false to use the provided menu drop direction
     * @return same menu instance
     */
    public Menu<V> setUseSmallScreensDirection(boolean useSmallScreensDropDirection) {
        this.useSmallScreensDirection = useSmallScreensDropDirection;
        if (!useSmallScreensDropDirection && getEffectiveDropDirection() == smallScreenDropDirection) {
            this.effectiveDropDirection = dropDirection;
        }
        return this;
    }

    public boolean isDropDown() {
        return dropDown;
    }

    private void setDropDown(boolean dropdown) {
        if (dropdown) {
            this.setAttribute("domino-ui-root-menu", true)
                    .setAttribute(PopupsCloser.DOMINO_UI_AUTO_CLOSABLE, true);
            menuElement.elevate(Elevation.LEVEL_1);
        } else {
            this.removeAttribute("domino-ui-root-menu")
                    .removeAttribute(PopupsCloser.DOMINO_UI_AUTO_CLOSABLE);
            menuElement.elevate(Elevation.NONE);
        }
        addCss(BooleanCssClass.of(MENU_DROP, dropdown));
        this.dropDown = dropdown;
    }

    public Menu<V> setOnAddItemHandler(OnAddItemHandler<V> onAddItemHandler) {
        if (nonNull(onAddItemHandler)) {
            this.onAddItemHandler = onAddItemHandler;
        }
        return this;
    }

    /**
     * A handler that will be called when closing the menu
     */
    @FunctionalInterface
    public interface CloseHandler {
        /**
         * Will be called when the menu is closed
         */
        void onClose();
    }

    /**
     * A handler that will be called when opening the menu
     */
    @FunctionalInterface
    public interface OpenHandler {
        /**
         * Will be called when the menu is opened
         */
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
        void onItemSelectionChange(AbstractMenuItem<V, ?> menuItem, boolean selected);
    }

    @FunctionalInterface
    public interface MenuItemsGroupHandler<V, I extends AbstractMenuItem<V, I>> {
        void handle(MenuItemsGroup<V, I> initializedGroup);
    }

    public interface OnAddItemHandler<V> {
        void onAdded(
                Menu<V> menu, AbstractMenuItem<V, ? extends AbstractMenuItem<V, ?>> menuItem);
    }
}
