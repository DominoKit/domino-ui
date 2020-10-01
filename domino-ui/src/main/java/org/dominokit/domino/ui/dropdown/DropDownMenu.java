package org.dominokit.domino.ui.dropdown;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

public class DropDownMenu extends BaseDominoElement<HTMLDivElement, DropDownMenu> implements HasBackground<DropDownMenu> {

    private MenuNavigation<DropdownAction<?>> menuNavigation;
    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(DropDownStyles.DROPDOWN));
    private DominoElement<HTMLUListElement> menuElement = DominoElement.of(ul().css(DropDownStyles.DROPDOWN_MENU));
    private HTMLElement targetElement;
    private DropDownPosition position = DropDownPosition.BOTTOM;
    private DominoElement<HTMLDivElement> titleContainer = DominoElement.of(div()).addCss(DropDownStyles.DROPDOWN_TITLE_CONTAINER);
    private DominoElement<HTMLDivElement> searchContainer = DominoElement.of(div().css(DropDownStyles.DROPDOWN_SEARCH_CONTAINER));
    private DominoElement<HTMLInputElement> searchBox = DominoElement.of(input("text")
            .css(DropDownStyles.DROPDOWN_SEARCH_BOX));
    private DominoElement<HTMLElement> noSearchResultsElement;
    private String noMatchSearchResultText = "No results matched";

    private List<DropdownAction<?>> actions = new ArrayList<>();
    private static boolean touchMoved;
    private List<CloseHandler> closeHandlers = new ArrayList<>();
    private List<OpenHandler> openHandlers = new ArrayList<>();
    private boolean closeOnEscape;
    private boolean searchable;
    private boolean caseSensitiveSearch = false;
    private List<DropdownActionsGroup<?>> groups = new ArrayList<>();
    private Color background;
    private HTMLElement appendTarget = document.body;
    private AppendStrategy appendStrategy = AppendStrategy.LAST;
    private SearchFilter searchFilter = (searchText, dropdownAction, caseSensitive) -> {
        if (caseSensitive) {
            return dropdownAction.getContent().textContent.contains(searchText);
        } else {
            return dropdownAction.getContent().textContent.toLowerCase().contains(searchText.toLowerCase());
        }
    };

    static {
        document.addEventListener(EventType.click.getName(), evt -> DropDownMenu.closeAllMenus());
        document.addEventListener(EventType.touchmove.getName(), evt -> DropDownMenu.touchMoved = true);
        document.addEventListener(EventType.touchend.getName(), evt -> {
            if (!DropDownMenu.touchMoved) {
                closeAllMenus();
            }
            DropDownMenu.touchMoved = false;
        });
    }

    public DropDownMenu(HTMLElement targetElement) {
        this.targetElement = targetElement;

        init(this);

        menuElement.setAttribute("role", "listbox");

        element.addEventListener(EventType.touchend, Event::stopPropagation);
        element.addEventListener(EventType.touchmove, Event::stopPropagation);
        element.addEventListener(EventType.touchstart, Event::stopPropagation);

        addMenuNavigationListener();
        searchContainer.addClickListener(evt -> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        searchContainer.appendChild(FlexLayout.create()
                .appendChild(FlexItem.create()
                        .appendChild(Icons.ALL.search())
                )
                .appendChild(FlexItem.create()
                        .setFlexGrow(1)
                        .appendChild(searchBox)
                ));

        element
                .appendChild(searchContainer)
                .appendChild(menuElement);

        setSearchable(false);

        KeyboardEvents.listenOn(searchBox)
                .setDefaultOptions(KeyboardEvents.KeyboardEventOptions.create()
                        .setPreventDefault(true)
                        .setStopPropagation(true))
                .onArrowUp(evt -> menuNavigation.focusAt(lastVisibleActionIndex()))
                .onArrowDown(evt -> menuNavigation.focusAt(firstVisibleActionIndex()))
                .onEscape(evt -> close())
                .onEnter(evt -> selectFirstSearchResult());
        searchBox.addEventListener("input", evt -> {
            if (searchable) {
                doSearch();
            }
        });

        setNoSearchResultsElement(DominoElement.of(li().css(DropDownStyles.NO_RESULTS))
                .hide()
                .element());
        menuElement.appendChild(noSearchResultsElement);

        titleContainer.addClickListener(Event::stopPropagation);
    }

    private void selectFirstSearchResult() {
        List<DropdownAction<?>> filteredAction = getFilteredAction();
        if (!filteredAction.isEmpty()) {
            selectAt(actions.indexOf(filteredAction.get(0)));
            filteredAction.get(0)
                    .select();
        }
    }

    private int firstVisibleActionIndex() {
        for (int i = 0; i < actions.size(); i++) {
            if (!actions.get(i).isHidden()) {
                return i;
            }
        }
        return 0;
    }

    private int lastVisibleActionIndex() {
        for (int i = actions.size() - 1; i >= 0; i--) {
            if (!actions.get(i).isHidden()) {
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
        if (thereIsValues) {
            noSearchResultsElement.hide();
        } else {
            noSearchResultsElement.show();
            noSearchResultsElement.setTextContent(noMatchSearchResultText + " \"" + searchValue + "\"");
        }
        groups.forEach(DropdownActionsGroup::changeVisibility);
    }

    public List<DropdownAction<?>> getFilteredAction() {
        return actions
                .stream()
                .filter(dropdownAction -> !dropdownAction.isFilteredOut())
                .collect(Collectors.toList());
    }

    private void addMenuNavigationListener() {
        menuNavigation = MenuNavigation.create(actions)
                .onSelect(DropdownAction::select)
                .focusCondition(item -> !item.isHidden())
                .onFocus(item -> {
                    if (isOpened()) {
                        item.focus();
                    }
                })
                .onEscape(this::close);

        element.addEventListener("keydown", menuNavigation);
    }

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

    public static DropDownMenu create(HTMLElement targetElement) {
        return new DropDownMenu(targetElement);
    }

    public static DropDownMenu create(IsElement<?> targetElement) {
        return new DropDownMenu(targetElement.element());
    }

    public DropDownMenu insertFirst(DropdownAction<?> action) {
        action.addSelectionHandler(value -> {
            if (action.isAutoClose()) {
                close();
            }
        });
        actions.add(0, action);
        menuElement.insertFirst(action.element());
        return this;
    }

    public DropDownMenu appendChild(DropdownAction<?> action) {
        action.addSelectionHandler(value -> {
            if (action.isAutoClose()) {
                close();
            }
        });
        actions.add(action);
        menuElement.appendChild(action.element());
        action.setBackground(this.background);
        return this;
    }

    public DropDownMenu addAction(DropdownAction<?> action) {
        return appendChild(action);
    }

    public DropDownMenu separator() {
        menuElement.appendChild(li().attr("role", "separator")
                .css(DropDownStyles.DIVIDER));
        return this;
    }

    public DropDownMenu appendChild(Node child) {
        element.appendChild(child);
        return this;
    }

    public void close() {
        element.remove();
        closeHandlers.forEach(CloseHandler::onClose);
    }

    public void open() {
        open(true);
    }

    public void open(boolean focus) {
        if (hasActions()) {
            onAttached(mutationRecord -> {
                position.position(element.element(), targetElement);
                if (searchable) {
                    searchBox.element().focus();
                    clearSearch();
                } else if (focus) {
                    focus();
                }

                element.style().setProperty("z-index", ModalBackDrop.getNextZIndex() + 10 + "");
                openHandlers.forEach(OpenHandler::onOpen);

                DominoElement.of(targetElement)
                        .onDetached(targetDetach -> close());

                onDetached(detachRecord -> {
                    closeHandlers.forEach(CloseHandler::onClose);
                });
            });

            if (!appendTarget.contains(element.element())) {
                appendStrategy.onAppend(appendTarget, element.element());
            }
        }
    }

    public void clearSearch() {
        searchBox.element().value = "";
        noSearchResultsElement.hide();
        actions.forEach(DropdownAction::show);
    }

    public boolean isOpened() {
        return element.isAttached();
    }

    public DropDownMenu setPosition(DropDownPosition position) {
        this.position = position;
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public DropDownMenu clearActions() {
        menuElement.clearElement();
        actions.clear();
        groups.clear();
        menuElement.appendChild(noSearchResultsElement);
        return this;
    }

    public boolean hasActions() {
        return !actions.isEmpty();
    }

    public DropDownMenu selectAt(int index) {
        if (index >= 0 && index < actions.size()) {
            menuNavigation.focusAt(index);
        }
        return this;
    }

    public DropDownMenu addCloseHandler(CloseHandler closeHandler) {
        closeHandlers.add(closeHandler);
        return this;
    }

    public DropDownMenu removeCloseHandler(CloseHandler closeHandler) {
        closeHandlers.remove(closeHandler);
        return this;
    }

    public DropDownMenu addOpenHandler(OpenHandler openHandler) {
        openHandlers.add(openHandler);
        return this;
    }

    public DropDownMenu removeOpenHandler(OpenHandler openHandler) {
        openHandlers.remove(openHandler);
        return this;
    }

    public List<DropdownAction<?>> getActions() {
        return actions;
    }

    public DropDownMenu setCloseOnEscape(boolean closeOnEscape) {
        this.closeOnEscape = closeOnEscape;
        return this;
    }

    public DropDownMenu setSearchable(boolean searchable) {
        this.searchable = searchable;
        if (searchable) {
            searchContainer.show();
        } else {
            searchContainer.hide();
        }
        return this;
    }

    public DropDownMenu addGroup(DropdownActionsGroup<?> group) {
        groups.add(group);
        menuElement.appendChild(group.element());
        group.bindTo(this);
        return this;
    }

    public DropDownMenu setTitle(String title) {
        if (!element.contains(titleContainer)) {
            element.insertFirst(titleContainer.appendChild(h(5).textContent(title)));
        }
        return this;
    }

    public DropDownMenu setAppendTarget(HTMLElement appendTarget) {
        if (nonNull(appendTarget)) {
            this.appendTarget = appendTarget;
        }
        return this;
    }

    public HTMLElement getAppendTarget() {
        return this.appendTarget;
    }

    public DropDownMenu setAppendStrategy(AppendStrategy appendStrategy) {
        if (nonNull(appendStrategy)) {
            this.appendStrategy = appendStrategy;
        }
        return this;
    }

    public AppendStrategy getAppendStrategy() {
        return this.appendStrategy;
    }

    public DominoElement<HTMLElement> getNoSearchResultsElement() {
        return noSearchResultsElement;
    }

    public void setNoSearchResultsElement(HTMLElement noSearchResultsElement) {
        this.noSearchResultsElement = DominoElement.of(noSearchResultsElement);
    }

    public boolean isCaseSensitiveSearch() {
        return caseSensitiveSearch;
    }

    public void setCaseSensitiveSearch(boolean caseSensitiveSearch) {
        this.caseSensitiveSearch = caseSensitiveSearch;
    }

    public DominoElement<HTMLUListElement> getMenuElement() {
        return menuElement;
    }

    @Override
    public DropDownMenu setBackground(Color background) {
        if (nonNull(this.background)) {
            getMenuElement().removeCss(this.background.getBackground());
        }
        getMenuElement().addCss(background.getBackground());
        this.background = background;
        actions.forEach(dropdownAction -> dropdownAction.setBackground(background));
        return this;
    }

    public DominoElement<HTMLDivElement> getSearchContainer() {
        return searchContainer;
    }

    public void focus() {
        menuNavigation.focusAt(0);
    }

    public SearchFilter getSearchFilter() {
        return searchFilter;
    }

    public DropDownMenu setSearchFilter(SearchFilter searchFilter) {
        if (nonNull(searchFilter)) {
            this.searchFilter = searchFilter;
        }
        return this;
    }

    @FunctionalInterface
    public interface CloseHandler {
        void onClose();
    }

    @FunctionalInterface
    public interface OpenHandler {
        void onOpen();
    }

    @FunctionalInterface
    public interface AppendStrategy {
        void onAppend(HTMLElement target, HTMLElement menu);

        AppendStrategy FIRST = (target, menu) -> DominoElement.of(target).insertFirst(menu);
        AppendStrategy LAST = (target, menu) -> DominoElement.of(target).appendChild(menu);
    }

    @FunctionalInterface
    public interface SearchFilter {
        boolean filter(String searchText, DropdownAction<?> dropdownAction, boolean caseSensitive);
    }
}
