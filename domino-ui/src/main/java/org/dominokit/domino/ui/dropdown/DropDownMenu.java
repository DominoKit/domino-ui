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
package org.dominokit.domino.ui.dropdown;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.input;
import static org.jboss.elemento.Elements.li;
import static org.jboss.elemento.Elements.ul;

import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLUListElement;
import elemental2.dom.Node;
import elemental2.dom.NodeList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * @deprecated use a derivative from {@link org.dominokit.domino.ui.menu.AbstractMenu} A component
 *     which provides a dropdown menu relative to an element
 *     <p>The menu can have different actions and can be placed at specific position
 *     <p>Customize the component can be done by overwriting classes provided by {@link
 *     DropDownStyles}
 *     <p>For example:
 *     <pre>
 *      DropDownMenu.create(element)
 *                 .addAction(DropdownAction.create("action 1"))
 *                 .open();
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 */
@Deprecated
@Deprecated
public class DropDownMenu extends BaseDominoElement<HTMLDivElement, DropDownMenu>
    implements HasBackground<DropDownMenu>, IsPopup<DropDownMenu> {

  private KeyboardNavigation<DropdownAction<?>> keyboardNavigation;
  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div()).css(DropDownStyles.DROPDOWN);
  private final DominoElement<HTMLUListElement> menuElement =
      DominoElement.of(ul()).css(DropDownStyles.DROPDOWN_MENU);
  private final HTMLElement targetElement;
  private DropDownPosition position = DropDownPosition.BOTTOM;
  private final DominoElement<HTMLDivElement> titleContainer =
      DominoElement.of(div()).addCss(DropDownStyles.DROPDOWN_TITLE_CONTAINER);
  private final DominoElement<HTMLDivElement> searchContainer =
      DominoElement.of(div()).css(DropDownStyles.DROPDOWN_SEARCH_CONTAINER);
  private final DominoElement<HTMLInputElement> searchBox =
      DominoElement.of(input("text")).css(DropDownStyles.DROPDOWN_SEARCH_BOX);
  private DominoElement<HTMLElement> noSearchResultsElement;
  private MdiIcon createIcon;
  private String noMatchSearchResultText = "No results matched";

  private final List<DropdownAction<?>> actions = new ArrayList<>();
  private static boolean touchMoved;
  private final List<CloseHandler> closeHandlers = new ArrayList<>();
  private final List<OpenHandler> openHandlers = new ArrayList<>();
  private boolean searchable = false;
  private boolean creatable = false;
  private boolean caseSensitiveSearch = false;
  private final List<DropdownActionsGroup<?>> groups = new ArrayList<>();
  private Color background;
  private HTMLElement appendTarget = document.body;
  private AppendStrategy appendStrategy = AppendStrategy.LAST;
  private SearchFilter searchFilter =
      (searchText, dropdownAction, caseSensitive) -> {
        if (caseSensitive) {
          return dropdownAction.getContent().textContent.contains(searchText);
        } else {
          return dropdownAction
              .getContent()
              .textContent
              .toLowerCase()
              .contains(searchText.toLowerCase());
        }
      };
  private OnAdd addListener = (String search) -> {};

  private LazyInitializer dropDownMenuInitializer;

  static {
    document.addEventListener(EventType.click.getName(), evt -> DropDownMenu.closeAllMenus());
    document.addEventListener(
        EventType.touchmove.getName(),
        evt -> DropDownMenu.touchMoved = true,
        EventOptions.of().setPassive(true).get());
    document.addEventListener(
        EventType.touchend.getName(),
        evt -> {
          if (!DropDownMenu.touchMoved) {
            closeAllMenus();
          }
          DropDownMenu.touchMoved = false;
        });
  }

  public DropDownMenu(HTMLElement targetElement) {
    this.targetElement = targetElement;

    init(this);

    dropDownMenuInitializer =
        new LazyInitializer(
            () -> {
              element.appendChild(searchContainer).appendChild(menuElement);
              menuElement.setAttribute("role", "listbox");
              element.addEventListener(
                  EventType.touchend, Event::stopPropagation, EventOptions.of().setPassive(true));
              element.addEventListener(
                  EventType.touchmove, Event::stopPropagation, EventOptions.of().setPassive(true));
              element.addEventListener(
                  EventType.touchstart, Event::stopPropagation, EventOptions.of().setPassive(true));

              addMenuNavigationListener();
              searchContainer.addClickListener(
                  evt -> {
                    evt.preventDefault();
                    evt.stopPropagation();
                  });
              createIcon = Icons.ALL.plus_mdi().clickable();
              searchContainer
                  .toggleDisplay(this.searchable)
                  .appendChild(
                      FlexLayout.create()
                          .appendChild(
                              FlexItem.create().appendChild(Icons.ALL.magnify_mdi().clickable()))
                          .appendChild(FlexItem.create().setFlexGrow(1).appendChild(searchBox))
                          .appendChild(
                              FlexItem.create()
                                  .appendChild(
                                      createIcon
                                          .setAttribute("tabindex", "0")
                                          .setAttribute("aria-expanded", "true")
                                          .setAttribute("href", "#")
                                          .toggleDisplay(this.creatable)
                                          .addClickListener(
                                              evt ->
                                                  addListener.onAdd(searchBox.element().value)))));

              KeyboardEvents.listenOnKeyDown(createIcon)
                  .setDefaultOptions(
                      KeyboardEvents.KeyboardEventOptions.create()
                          .setPreventDefault(true)
                          .setStopPropagation(true))
                  .onEnter(evt -> addListener.onAdd(searchBox.element().value));

              KeyboardEvents.listenOnKeyDown(searchBox)
                  .setDefaultOptions(
                      KeyboardEvents.KeyboardEventOptions.create()
                          .setPreventDefault(true)
                          .setStopPropagation(true))
                  .onArrowUp(evt -> keyboardNavigation.focusAt(lastVisibleActionIndex()))
                  .onArrowDown(evt -> keyboardNavigation.focusAt(firstVisibleActionIndex()))
                  .onEscape(evt -> close())
                  .onEnter(evt -> selectFirstSearchResult());
              searchBox.addEventListener(
                  "input",
                  evt -> {
                    if (searchable) {
                      doSearch();
                    }
                  });

              setNoSearchResultsElement(
                  DominoElement.of(li()).css(DropDownStyles.NO_RESULTS).hide().element());
              menuElement.appendChild(noSearchResultsElement);

              titleContainer.addClickListener(Event::stopPropagation);
            });
  }

  private void selectFirstSearchResult() {
    List<DropdownAction<?>> filteredAction = getFilteredAction();
    if (!filteredAction.isEmpty()) {
      selectAt(actions.indexOf(filteredAction.get(0)));
      filteredAction.get(0).select();
    }
  }

  private int firstVisibleActionIndex() {
    for (int i = 0; i < actions.size(); i++) {
      if (actions.get(i).isExpanded()) {
        return i;
      }
    }
    return 0;
  }

  private int lastVisibleActionIndex() {
    for (int i = actions.size() - 1; i >= 0; i--) {
      if (actions.get(i).isExpanded()) {
        return i;
      }
    }
    return 0;
  }

  private void doSearch() {
    String searchValue = searchBox.element().value;
    boolean thereIsValues = false;
    for (DropdownAction<?> action : actions) {

      action.setFilteredOut(false);
      boolean contains = searchFilter.filter(searchValue, action, caseSensitiveSearch);
      contains = contains && !action.isExcludeFromSearchResults();

      if (!contains) {
        action.filter();
      } else {
        thereIsValues = true;
        action.deFilter();
      }
    }

    if (!searchValue.isEmpty() && creatable) {
      createIcon.active();
    } else {
      createIcon.inactive();
    }

    if (thereIsValues) {
      noSearchResultsElement.hide();
    } else {
      noSearchResultsElement.show();
      noSearchResultsElement.setTextContent(noMatchSearchResultText + " \"" + searchValue + "\"");
    }
    groups.forEach(DropdownActionsGroup::changeVisibility);
  }

  /** @return All {@link DropdownAction} filtered based on the search criteria */
  public List<DropdownAction<?>> getFilteredAction() {
    return actions.stream()
        .filter(dropdownAction -> !dropdownAction.isFilteredOut())
        .collect(Collectors.toList());
  }

  private void addMenuNavigationListener() {
    keyboardNavigation =
        KeyboardNavigation.create(actions)
            .onSelect((event, dropdownAction) -> dropdownAction.select())
            .focusCondition(IsCollapsible::isExpanded)
            .onFocus(
                item -> {
                  if (isOpened()) {
                    item.focus();
                  }
                })
            .onEscape(this::close);

    element.addEventListener("keydown", keyboardNavigation);
  }

  /** Closes all current opened menus */
  public static void closeAllMenus() {
    NodeList<Element> elementsByName = document.body.querySelectorAll(".dropdown");
    for (int i = 0; i < elementsByName.length; i++) {
      HTMLElement item = Js.uncheckedCast(elementsByName.item(i));
      close(item);
    }
  }

  private static void close(HTMLElement item) {
    item.remove();
  }

  /**
   * Creates drop down menu relative to {@code targetElement}.
   *
   * <p>The target element will be used to position the menu according to its location
   *
   * @param targetElement The target {@link HTMLElement}
   * @return new instance
   */
  public static DropDownMenu create(HTMLElement targetElement) {
    return new DropDownMenu(targetElement);
  }

  /**
   * Same as {@link DropDownMenu#create(HTMLElement)} but accepts a wrapper {@link IsElement}
   *
   * @param targetElement The {@link IsElement}
   * @return new instance
   */
  public static DropDownMenu create(IsElement<?> targetElement) {
    return new DropDownMenu(targetElement.element());
  }

  /**
   * Inserts an action at the first index
   *
   * @param action The {@link DropdownAction} to add
   * @return same instance
   */
  public DropDownMenu insertFirst(DropdownAction<?> action) {
    dropDownMenuInitializer.doOnce(
        () -> {
          action.addSelectionHandler(
              value -> {
                if (action.isAutoClose()) {
                  close();
                }
              });
          actions.add(0, action);
          menuElement.insertFirst(action.element());
        });
    return this;
  }

  /**
   * Adds an action
   *
   * @param action The {@link DropdownAction} to add
   * @return same instance
   */
  public DropDownMenu appendChild(DropdownAction<?> action) {
    dropDownMenuInitializer.doOnce(
        () -> {
          action.addSelectionHandler(
              value -> {
                if (action.isAutoClose()) {
                  close();
                }
              });
          actions.add(action);
          action.setBackground(this.background);
          menuElement.appendChild(action.element());
        });
    return this;
  }

  /** Use {@link DropDownMenu#appendChild(DropdownAction)} instead */
  @Deprecated
  public DropDownMenu addAction(DropdownAction<?> action) {
    return appendChild(action);
  }

  /**
   * Adds a separator element
   *
   * @return same instance
   */
  public DropDownMenu separator() {
    dropDownMenuInitializer.doOnce(
        () ->
            menuElement.appendChild(
                DominoElement.of(li()).attr("role", "separator").css(DropDownStyles.DIVIDER)));

    return this;
  }

  /** {@inheritDoc} */
  @Override
  public DropDownMenu appendChild(Node child) {
    element.appendChild(child);
    return this;
  }

  /** Closes the menu */
  public DropDownMenu close() {
    if (isOpened()) {
      element.remove();
      closeHandlers.forEach(CloseHandler::onClose);
    }
    return this;
  }

  /** Opens the menu */
  public DropDownMenu open() {
    return open(true);
  }

  /**
   * Opens the menu with a boolean to indicate if the first element should be focused
   *
   * @param focus true to focus the first element
   */
  public DropDownMenu open(boolean focus) {
    dropDownMenuInitializer.apply();
    if (hasActions() || creatable) {
      onAttached(
          mutationRecord -> {
            position.position(element.element(), targetElement);
            if (searchable) {
              searchBox.element().focus();
              clearSearch();
            } else if (focus) {
              focus();
            }

            config().getZindexManager().onPopupOpen(this);
            openHandlers.forEach(OpenHandler::onOpen);

            DominoElement.of(targetElement).onDetached(targetDetach -> close());

            onDetached(
                detachRecord -> {
                  closeHandlers.forEach(CloseHandler::onClose);
                });
          });

      if (!appendTarget.contains(element.element())) {
        appendStrategy.onAppend(appendTarget, element.element());
      }
    }
    return this;
  }

  @Override
  public boolean isModal() {
    return false;
  }

  @Override
  public boolean isAutoClose() {
    return true;
  }

  /** Clears the current search */
  public void clearSearch() {
    dropDownMenuInitializer.ifInitialized(
        () -> {
          searchBox.element().value = "";
          noSearchResultsElement.hide();
          createIcon.inactive();
          actions.forEach(DropdownAction::show);
        });
  }

  /** @return True if the menu is opened, false otherwise */
  public boolean isOpened() {
    return element.isAttached();
  }

  /**
   * Sets the position of the menu
   *
   * @param position The new {@link DropDownPosition}
   * @return same instance
   */
  public DropDownMenu setPosition(DropDownPosition position) {
    this.position = position;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * Clears all the actions
   *
   * @return same instance
   */
  public DropDownMenu clearActions() {
    dropDownMenuInitializer.apply();
    menuElement.clearElement();
    actions.clear();
    groups.clear();
    menuElement.appendChild(noSearchResultsElement);
    return this;
  }

  /** @return True if it is has actions, false otherwise */
  public boolean hasActions() {
    return !actions.isEmpty();
  }

  /**
   * Focuses an action at a specific {@code index}
   *
   * @param index the index of the action
   * @return same instance
   */
  public DropDownMenu selectAt(int index) {
    if (index >= 0 && index < actions.size()) {
      keyboardNavigation.focusAt(index);
    }
    return this;
  }

  /**
   * Adds a close handler to be called when the menu is closed
   *
   * @param closeHandler The {@link CloseHandler} to add
   * @return same instance
   */
  public DropDownMenu addCloseHandler(CloseHandler closeHandler) {
    closeHandlers.add(closeHandler);
    return this;
  }

  /**
   * Removes a close handler
   *
   * @param closeHandler The {@link CloseHandler} to remove
   * @return same instance
   */
  public DropDownMenu removeCloseHandler(CloseHandler closeHandler) {
    closeHandlers.remove(closeHandler);
    return this;
  }

  /**
   * Adds an open handler to be called when the menu is opened
   *
   * @param openHandler The {@link OpenHandler} to add
   * @return same instance
   */
  public DropDownMenu addOpenHandler(OpenHandler openHandler) {
    openHandlers.add(openHandler);
    return this;
  }

  /**
   * Removes an open handler
   *
   * @param openHandler The {@link OpenHandler} to remove
   * @return same instance
   */
  public DropDownMenu removeOpenHandler(OpenHandler openHandler) {
    openHandlers.remove(openHandler);
    return this;
  }

  /** @return All the actions */
  public List<DropdownAction<?>> getActions() {
    return actions;
  }

  /**
   * Sets if the menu is searchable or not. Searchable menu will filter the actions based on the
   * search criteria provided in the search element
   *
   * @param searchable true if this menu is searchable, false otherwise
   * @return same instance
   */
  public DropDownMenu setSearchable(boolean searchable) {
    this.searchable = searchable;
    dropDownMenuInitializer.whenInitialized(() -> searchContainer.toggleDisplay(this.searchable));
    return this;
  }

  /**
   * Sets if the menu accepts creating new actions on the fly.
   *
   * <p>By configuring the menu as creatable means that the user can create a new action by setting
   * the action text and then adding it directly to the actions list
   *
   * @param creatable true if the menu accepts creating new actions on the fly, false otherwise
   * @return same instance
   */
  public DropDownMenu setCreatable(boolean creatable) {
    this.creatable = creatable;
    dropDownMenuInitializer.ifInitialized(() -> createIcon.toggleDisplay(this.creatable));

    return this;
  }

  /**
   * Set the text which is displayed in case nothing is found at a searchable {@link DropDownMenu}
   * Default is "No results matched".
   *
   * @param text the new text
   * @return same instance
   */
  public DropDownMenu setNoMatchSearchResultText(String text) {
    this.noMatchSearchResultText = text;
    return this;
  }

  /**
   * Adds a listener that will be called when a new action is added
   *
   * @param onAdd the {@link OnAdd} listener to add
   * @return same instance
   */
  public DropDownMenu setOnAddListener(OnAdd onAdd) {
    this.addListener = onAdd;
    return this;
  }

  /**
   * Adds new group of actions to this menu as a one unit
   *
   * @param group the {@link DropdownActionsGroup} to add
   * @return same instance
   */
  public DropDownMenu addGroup(DropdownActionsGroup<?> group) {
    dropDownMenuInitializer.doOnce(
        () -> {
          groups.add(group);
          menuElement.appendChild(group.element());
        });
    group.bindTo(this);
    return this;
  }

  /**
   * Sets the title of this menu
   *
   * @param title the title text
   * @return same instance
   */
  public DropDownMenu setTitle(String title) {
    if (!element.contains(titleContainer)) {
      element.insertFirst(titleContainer.appendChild(h(5).textContent(title)));
    }
    return this;
  }

  /**
   * Sets the target element for this menu that will be positioned according to its location
   *
   * @param appendTarget the new target element
   * @return same instance
   */
  public DropDownMenu setAppendTarget(HTMLElement appendTarget) {
    if (nonNull(appendTarget)) {
      this.appendTarget = appendTarget;
    }
    return this;
  }

  /** @return The current target element */
  public HTMLElement getAppendTarget() {
    return this.appendTarget;
  }

  /**
   * Sets the strategy for adding the menu to the target element.
   *
   * @param appendStrategy the {@link AppendStrategy}
   * @return same instance
   */
  public DropDownMenu setAppendStrategy(AppendStrategy appendStrategy) {
    if (nonNull(appendStrategy)) {
      this.appendStrategy = appendStrategy;
    }
    return this;
  }

  /** @return The current {@link AppendStrategy} */
  public AppendStrategy getAppendStrategy() {
    return this.appendStrategy;
  }

  /** @return The no search result element */
  public DominoElement<HTMLElement> getNoSearchResultsElement() {
    return noSearchResultsElement;
  }

  /**
   * Sets the no search result element which will be shown when there is no results found according
   * to the search criteria
   *
   * @param noSearchResultsElement the new no search results element
   */
  public void setNoSearchResultsElement(HTMLElement noSearchResultsElement) {
    this.noSearchResultsElement = DominoElement.of(noSearchResultsElement);
  }

  /** @return True if the search is case sensitive, false otherwise */
  public boolean isCaseSensitiveSearch() {
    return caseSensitiveSearch;
  }

  /**
   * Sets if the search is case sensitive
   *
   * @param caseSensitiveSearch true if search is case sensitive, false otherwise
   */
  public void setCaseSensitiveSearch(boolean caseSensitiveSearch) {
    this.caseSensitiveSearch = caseSensitiveSearch;
  }

  /** @return The menu container element */
  public DominoElement<HTMLUListElement> getMenuElement() {
    return menuElement;
  }

  /** {@inheritDoc} */
  @Override
  public DropDownMenu setBackground(Color background) {
    if (nonNull(background)) {
      if (nonNull(this.background)) {
        getMenuElement().removeCss(this.background.getBackground());
      }
      getMenuElement().addCss(background.getBackground());
      this.background = background;
      actions.forEach(dropdownAction -> dropdownAction.setBackground(background));
    }
    return this;
  }

  /** @return The search element container */
  public DominoElement<HTMLDivElement> getSearchContainer() {
    return searchContainer;
  }

  /** Sets focus at the first element of the menu */
  public void focus() {
    dropDownMenuInitializer.apply();
    keyboardNavigation.focusAt(0);
  }

  /** @return The current search filter */
  public SearchFilter getSearchFilter() {
    return searchFilter;
  }

  /**
   * Sets the search filter strategy that will be called to filter the actions based on the search
   * value
   *
   * @param searchFilter The new {@link SearchFilter}
   * @return same instance
   */
  public DropDownMenu setSearchFilter(SearchFilter searchFilter) {
    if (nonNull(searchFilter)) {
      this.searchFilter = searchFilter;
    }
    return this;
  }

  public DominoElement<HTMLInputElement> getSearchBox() {
    return searchBox;
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

  /** The search filter strategy which will filter the actions based on the search criteria */
  @FunctionalInterface
  public interface SearchFilter {
    /**
     * Checks if the {@code dropdownAction} should be displayed or not based on the {@code
     * searchText}
     *
     * @param searchText the search criteria
     * @param dropdownAction the {@link DropdownAction}
     * @param caseSensitive case sensitive search or not
     * @return true if the action should be displayed, false otherwise
     */
    boolean filter(String searchText, DropdownAction<?> dropdownAction, boolean caseSensitive);
  }

  /** A handler that will be called when adding a new action */
  @FunctionalInterface
  public interface OnAdd {
    /**
     * Will be called when a new action is added
     *
     * @param input the content of the action
     */
    void onAdd(String input);
  }
}
