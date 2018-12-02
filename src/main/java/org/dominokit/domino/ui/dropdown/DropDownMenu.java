package org.dominokit.domino.ui.dropdown;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.*;

public class DropDownMenu extends BaseDominoElement<HTMLDivElement, DropDownMenu> {

    private MenuNavigation<DropdownAction, HTMLElement> menuNavigation;
    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("dropdown"));
    private DominoElement<HTMLUListElement> menuElement = DominoElement.of(ul().css("dropdown-menu"));
    private HTMLElement targetElement;
    private DropDownPosition position = DropDownPosition.BOTTOM;
    private DominoElement<HTMLDivElement> titleContainer = DominoElement.of(div()).addCss("dropdown-title-container");
    private DominoElement<HTMLDivElement> searchContainer = DominoElement.of(div().css("dropdown-search-container"));
    private DominoElement<HTMLInputElement> searchBox = DominoElement.of(input("text")
            .css("dropdown-search-box"));
    private DominoElement<HTMLElement> noSearchResultsElement;
    private String noMatchSearchResultText = "No results matched";
    private String noResultsElementDisplay;

    private List<DropdownAction> actions = new ArrayList<>();
    private boolean touchMoved;
    private List<CloseHandler> closeHandlers = new ArrayList<>();
    private boolean closeOnEscape;
    private boolean searchable;
    private boolean caseSensitiveSearch = false;
    private List<DropdownActionsGroup> groups = new ArrayList<>();

    public DropDownMenu(HTMLElement targetElement) {
        this.targetElement = targetElement;
        EventListener listener = evt -> closeAllMenus();
        document.addEventListener("click", listener);
        document.addEventListener("touchend", evt -> {
            if (!touchMoved) {
                closeAllMenus();
            }
            touchMoved = false;
        });
        document.addEventListener("touchmove", evt -> this.touchMoved = true);

        addMenuNavigationListener(targetElement);
        searchContainer.addEventListener("click", evt -> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        searchContainer.appendChild(FlexLayout.create()
                .appendChild(FlexItem.create()
                        .appendChild(Icons.ALL.search().styler(style -> style
                                .add(Styles.vertical_center))))
                .appendChild(FlexItem.create()
                        .setFlexGrow(1)
                        .appendChild(searchBox)
                ));

        element
                .appendChild(searchContainer)
                .appendChild(menuElement);

        setSearchable(false);

        KeyboardEvents.listenOn(searchBox)
                .setDefaultOptions(KeyboardEvents.KeyboardEventOptions.create().setPreventDefault(true))
                .onArrowUp(evt -> menuNavigation.focusAt(lastVisibleActionIndex()))
                .onArrowDown(evt -> menuNavigation.focusAt(firstVisibleActionIndex()))
                .onEscape(evt -> close());
        searchBox.addEventListener("input", evt -> {
            if (searchable) {
                doSearch();
            }
        });

        init(this);

        setNoSearchResultsElement(li().css("no-results").style("display: none;").asElement());
        menuElement.appendChild(noSearchResultsElement);

        titleContainer.addClickListener(Event::stopPropagation);
    }

    private int firstVisibleActionIndex() {
        for (int i = 0; i < actions.size(); i++) {
            if (!actions.get(i).isCollapsed()) {
                return i;
            }
        }
        return 0;
    }

    private int lastVisibleActionIndex() {
        for (int i = actions.size() - 1; i >= 0; i--) {
            if (!actions.get(i).isCollapsed()) {
                return i;
            }
        }
        return 0;
    }

    private void doSearch() {
        String searchValue = searchBox.asElement().value;
        boolean thereIsValues = false;
        for (DropdownAction action : actions) {
            boolean contains;
            if (caseSensitiveSearch)
                contains = action.getValue().contains(searchValue);
            else
                contains = action.getValue().toLowerCase().contains(searchValue.toLowerCase());

            if (!contains) {
                action.collapse();
            } else {
                thereIsValues = true;
                action.expand();
            }
        }
        if (thereIsValues) {
            noSearchResultsElement.collapse();
        } else {
            noSearchResultsElement.expand();
            noSearchResultsElement.setTextContent(noMatchSearchResultText + " \"" + searchValue + "\"");
        }
        groups.forEach(DropdownActionsGroup::changeVisibility);
    }

    private void addMenuNavigationListener(HTMLElement targetElement) {
        menuNavigation = MenuNavigation.create(actions, targetElement)
                .onSelect(DropdownAction::select)
                .focusCondition(item -> !item.isCollapsed())
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

    public static DropDownMenu create(IsElement targetElement) {
        return new DropDownMenu(targetElement.asElement());
    }

    public DropDownMenu appendChild(DropdownAction action) {
        action.addSelectionHandler(value -> close());
        actions.add(action);
        menuElement.appendChild(action.asElement());
        return this;
    }

    public DropDownMenu addAction(DropdownAction action) {
        return appendChild(action);
    }

    public DropDownMenu separator() {
        menuElement.appendChild(li().attr("role", "separator").css("divider"));
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
        if (hasActions()) {
            if (!document.body.contains(element.asElement())) {
                document.body.appendChild(element.asElement());
            }
            position.position(element.asElement(), targetElement);
            if (searchable) {
                searchBox.asElement().focus();
                clearSearch();
            }
        }
    }

    public void clearSearch() {
        searchBox.asElement().value = "";
        noSearchResultsElement.collapse();
        actions.forEach(DropdownAction::expand);
    }

    public boolean isOpened() {
        return document.body.contains(element.asElement());
    }

    public DropDownMenu setPosition(DropDownPosition position) {
        this.position = position;
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

    public DropDownMenu clearActions() {
        menuElement.clearElement();
        actions.clear();
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

    public List<DropdownAction> getActions() {
        return actions;
    }

    public DropDownMenu setCloseOnEscape(boolean closeOnEscape) {
        this.closeOnEscape = closeOnEscape;
        return this;
    }

    public DropDownMenu setSearchable(boolean searchable) {
        this.searchable = searchable;
        if (searchable) {
            searchContainer.expand();
        } else {
            searchContainer.collapse();
        }
        return this;
    }

    public DropDownMenu addGroup(DropdownActionsGroup group) {
        groups.add(group);
        menuElement.appendChild(group.asElement());
        group.addActionsTo(this);
        return this;
    }

    public DropDownMenu setTitle(String title) {
        if (!element.contains(titleContainer)) {
            element.insertFirst(titleContainer.appendChild(h(5).textContent(title)));
        }
        return this;
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

    @FunctionalInterface
    public interface CloseHandler {
        void onClose();
    }
}
