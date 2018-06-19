package org.dominokit.domino.ui.menu;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.HasActiveItem;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Menu implements IsElement<HTMLDivElement>, HasActiveItem<MenuItem> {

    private HTMLElement title = span().asElement();

    private HTMLLIElement header = li()
            .css("header", "menu-header")
            .add(title)
            .asElement();

    private HTMLUListElement root=ul()
            .css("list")
            .style("height: calc(100vh - 70px)")
            .add(header)
            .asElement();


    private final HTMLDivElement element = div()
            .css("menu")
            .style("overflow-x: hidden")
            .add(root)
            .asElement();

    private MenuItem activeMenuItem;

    public static Menu create(String title) {
        Menu menu = new Menu();
        menu.title.textContent = title;
        menu.root.style.height = CSSProperties.HeightUnionType.of("calc(100vh - 83px)");
        menu.asElement().style.height = CSSProperties.HeightUnionType.of("calc(100vh - 70px)");
        return menu;
    }

    public MenuItem addMenuItem(String title, Icon icon) {
        MenuItem menuItem = MenuItem.createRootItem(title, icon, this);
        root.appendChild(menuItem.asElement());
        return menuItem;
    }

    @Override
    public MenuItem getActiveItem() {
        return activeMenuItem;
    }

    @Override
    public void setActiveItem(MenuItem activeItem) {
        this.activeMenuItem = activeItem;
    }

    public HTMLLIElement getHeader() {
        return header;
    }

    public HTMLUListElement getRoot() {
        return root;
    }

    public HTMLElement getTitle() {
        return title;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
