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
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;
import static org.jboss.elemento.Elements.span;
import static org.jboss.elemento.Elements.ul;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.KeyboardNavigation;
import org.dominokit.domino.ui.utils.PopupsCloser;
import org.jboss.elemento.IsElement;

/**
 * The base component to create a menu like UI.
 *
 * @param <V> The type of the menu items value
 * @param <T> The type of the class extending from this base calss
 */
public abstract class AbstractMenu<V, T extends AbstractMenu<V, T>>
        extends BaseDominoElement<HTMLDivElement, T> {

    protected final SearchBox searchBox;
    protected FlexLayout menuElement = FlexLayout.create();

    protected final FlexItem<HTMLDivElement> headContainer =
            FlexItem.create().css("menu-container", "menu-head");
    protected final FlexItem<HTMLDivElement> searchContainer =
            FlexItem.create().css("menu-container", "menu-search");
    protected final FlexItem<HTMLDivElement> subHeaderContainer =
            FlexItem.create().css("menu-container", "menu-subheader");
    protected final FlexItem<HTMLDivElement> mainContainer =
            FlexItem.create().css("menu-container", "menu-main");
    protected final DominoElement<HTMLUListElement> itemsContainer = DominoElement.of(ul());
    protected final DominoElement<HTMLAnchorElement> addMissingElement =
            DominoElement.of(a())
                    .css("create-missing")
                    .setAttribute("tabindex", "0")
                    .setAttribute("aria-expanded", "true")
                    .setAttribute("href", "#");

    protected final MenuHeader<V, T> menuHeader;
    private HTMLElement focusElement;
    protected KeyboardNavigation<AbstractMenuItem<V, ?>> keyboardNavigation;

    protected boolean searchable;
    protected boolean caseSensitive = false;
    protected String createMissingLabel = "Create ";
    private MissingItemHandler<T> missingItemHandler;
    private DominoElement<HTMLLIElement> noResultElement = DominoElement.of(li().css("no-results"));

    protected List<AbstractMenuItem<V, ?>> menuItems = new ArrayList<>();
    protected boolean autoCloseOnSelect = true;
    protected final List<MenuItemSelectionHandler<V>> selectionHandlers = new ArrayList<>();
    protected boolean headerVisible = false;
    private AbstractDropMenu<V, ?> currentOpen;

    public AbstractMenu() {
        init((T) this);
        menuHeader = new MenuHeader<>(this);
        menuElement.setDirection(FlexDirection.TOP_TO_BOTTOM);
        searchBox = SearchBox.create().addSearchListener(this::onSearch);

        this.appendChild(headContainer.hide().appendChild(menuHeader))
                .appendChild(searchContainer)
                .appendChild(subHeaderContainer)
                .appendChild(mainContainer.setFlexGrow(1).appendChild(itemsContainer));
        menuElement.css("dom-ui", "menu", "menu-bordered");

        keyboardNavigation =
                KeyboardNavigation.create(menuItems)
                        .setTabOptions(new KeyboardNavigation.EventOptions(false, true))
                        .setTabHandler(
                                (event, item) -> {
                                    if (keyboardNavigation.isLastFocusableItem(item)) {
                                        event.preventDefault();
                                        if (isSearchable()) {
                                            searchBox.getTextBox().getInputElement().element().focus();
                                        } else {
                                            keyboardNavigation.focusTopFocusableItem();
                                        }
                                    }
                                })
                        .setEnterHandler((event, item) -> item.select())
                        .registerNavigationHandler("ArrowRight", (event, item) -> item.openSubMenu())
                        .onSelect((event, item) -> item.select())
                        .focusCondition(item -> !item.isCollapsed() && !item.isDisabled())
                        .onFocus(AbstractMenuItem::focus)
                        .onEscape(() -> {
                        });

        element.addEventListener("keydown", keyboardNavigation);

        KeyboardEvents.listenOnKeyDown(searchBox.getTextBox().getInputElement())
                .onArrowDown(
                        evt -> {
                            if (nonNull(missingItemHandler) && addMissingElement.isAttached()) {
                                addMissingElement.element().focus();
                            } else {
                                keyboardNavigation.focusAt(0);
                            }
                        });

        addMissingElement.addClickListener(
                evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();
                    onAddMissingElement();
                });
        KeyboardEvents.listenOnKeyDown(addMissingElement)
                .onEnter(
                        evt -> {
                            evt.preventDefault();
                            evt.stopPropagation();
                            onAddMissingElement();
                        });
    }

    private void onAddMissingElement() {
        missingItemHandler.onMissingItem(searchBox.getTextBox().getValue(), (T) this);
        onSearch(searchBox.getTextBox().getValue());
    }

    /**
     * Set the menu icon in the header, setting the icon will force the header to show up if not
     * visible
     *
     * @param icon Any Icon instance that extends from {@link BaseIcon}
     * @return the same menu instance
     */
    public T setIcon(BaseIcon<?> icon) {
        menuHeader.setIcon(icon);
        setHeaderVisible(true);
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
        menuHeader.setTitle(title);
        setHeaderVisible(true);
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
        menuHeader.appendAction(element);
        setHeaderVisible(true);
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
        menuHeader.appendAction(element);
        setHeaderVisible(true);
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
        subHeaderContainer.appendChild(element);
        autoHideShowSubHeader();
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
        subHeaderContainer.appendChild(element);
        autoHideShowSubHeader();
        return (T) this;
    }

    private void autoHideShowSubHeader() {
        subHeaderContainer.toggleDisplay(!subHeaderContainer.isEmptyElement());
    }

    /**
     * Appends a menu item to this menu
     *
     * @param menuItem {@link AbstractMenu}
     * @return same menu instance
     */
    public T appendChild(AbstractMenuItem<V, ?> menuItem) {
        if (nonNull(menuItem)) {
            itemsContainer.appendChild(menuItem);
            menuItems.add(menuItem);
            menuItem.setParent(this);
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
     * Appends a separator item to this menu, separator will show up as a simple border.
     *
     * @return same menu instance
     */
    public T appendSeparator() {
        this.itemsContainer.appendChild(DominoElement.of(li().add(span().css("ddi-separator"))));
        return (T) this;
    }

    /**
     * @return the {@link FlexItem} containing the {@link MenuHeader} component
     */
    public FlexItem<HTMLDivElement> getHeadContainer() {
        return headContainer;
    }

    /**
     * @return The {@link FlexItem} containing the sub-header the menu
     */
    public FlexItem<HTMLDivElement> getSubHeaderContainer() {
        return subHeaderContainer;
    }

    /**
     * @return the {@link FlexItem} that wrap this menu items container
     */
    public FlexItem<HTMLDivElement> getMainContainer() {
        return mainContainer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return menuElement.element();
    }

    private void clearSearch() {
        searchBox.clearSearch();
    }

    /**
     * If search is enabled, when search is trigger it will call this method.
     *
     * @param token String user input in the {@link SearchBox}
     * @return boolean, true if there is at least one menu item that matched the search token, else
     * will return false.
     */
    public boolean onSearch(String token) {
        boolean emptyToken = emptyToken(token);
        if (emptyToken) {
            this.removeCss("has-search");
            this.addMissingElement.remove();
        } else {
            this.css("has-search");
        }
        if (nonNull(missingItemHandler) && !emptyToken) {
            addMissingElement.setInnerHtml(getCreateMissingLabel() + "<b>" + token + "</b>");
            searchContainer.appendChild(addMissingElement);
        }
        long count =
                this.menuItems.stream()
                        .filter(dropDownItem -> dropDownItem.onSearch(token, isCaseSensitive()))
                        .count();

        if (count < 1 && menuItems.size() > 0) {
            this.itemsContainer.appendChild(
                    noResultElement.setInnerHtml("No results matched " + " <b>" + token + "</b>"));
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
    public DominoElement<HTMLLIElement> getNoResultElement() {
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
            this.noResultElement = DominoElement.of(noResultElement);
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

    /**
     * @return boolean, true if this menu search is case-sensitive
     */
    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public T setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return (T) this;
    }

    /**
     * @return the {@link HTMLElement} that should be focused by default when open the menu
     */
    public HTMLElement getFocusElement() {
        if (isNull(this.focusElement)) {
            if (isSearchable()) {
                return this.searchBox.getTextBox().getInputElement().element();
            } else if (!this.menuItems.isEmpty()) {
                return menuItems.get(0).getClickableElement();
            } else {
                return this.itemsContainer.element();
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

    /**
     * @return the {@link SearchBox} of the menu
     */
    public SearchBox getSearchBox() {
        return searchBox;
    }

    /**
     * @return The {@link FlexItem} that contains the search box of the menu
     */
    public FlexItem<HTMLDivElement> getSearchContainer() {
        return searchContainer;
    }

    /**
     * @return The {@link DominoElement} of the {@link HTMLUListElement} that contains the menu items.
     */
    public DominoElement<HTMLUListElement> getItemsContainer() {
        return itemsContainer;
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
    public MenuHeader<V, T> getMenuHeader() {
        return menuHeader;
    }

    /**
     * Change the visibility of the menu header
     *
     * @param visible boolean, True to show the header, false to hide it.
     * @return same menu instance
     */
    public T setHeaderVisible(boolean visible) {
        headContainer.toggleDisplay(visible);
        this.headerVisible = visible;
        return (T) this;
    }

    /**
     * @return boolean, true if search is enabled
     */
    public boolean isSearchable() {
        return searchable;
    }

    /**
     * Enable/Disable search
     *
     * @param searchable boolean, true to search box and enable search, false to hide the search box
     *                   and disable search.
     * @return same menu instance
     */
    public T setSearchable(boolean searchable) {
        if (searchable) {
            searchContainer.appendChild(searchBox);
        } else {
            searchContainer.clearElement();
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
     * @param silent   boolean, true to avoid triggering change handlers
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
     * @param index  int
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
     * @param key    String
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
    public T setAutoCloseOnSelect(boolean autoCloseOnSelect) {
        this.autoCloseOnSelect = autoCloseOnSelect;
        return (T) this;
    }

    protected void onItemSelected(AbstractMenuItem<V, ?> item) {
        if (isAutoCloseOnSelect() && !item.hasMenu()) {
            PopupsCloser.close();
        }
        selectionHandlers.forEach(selectionHandler -> selectionHandler.onItemSelected(item));
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
     * @param dropMenu {@link AbstractDropMenu} to open
     * @return same menu instance
     */
    public T openSubMenu(AbstractDropMenu<V, ?> dropMenu) {
        if (!Objects.equals(currentOpen, dropMenu)) {
            closeCurrentOpen();
        }
        dropMenu.open();
        setCurrentOpen(dropMenu);

        return (T) this;
    }

    void setCurrentOpen(AbstractDropMenu<V, ?> dropMenu) {
        this.currentOpen = dropMenu;
    }

    void closeCurrentOpen() {
        if (nonNull(currentOpen)) {
            currentOpen.close();
        }
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
}
