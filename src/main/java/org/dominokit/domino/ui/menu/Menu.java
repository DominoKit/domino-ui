package org.dominokit.domino.ui.menu;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Waves;
import org.dominokit.domino.ui.utils.HasActiveItem;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class Menu implements IsElement<HTMLDivElement>, HasActiveItem<MenuItem> {

    @DataElement
    HTMLUListElement root;

    @DataElement
    HTMLElement title;

    @DataElement
    HTMLLIElement header;

    private MenuItem activeMenuItem;

    public static Menu create(String title) {
        Templated_Menu menu = new Templated_Menu();
        menu.title.textContent = title;
        menu.root.style.height= CSSProperties.HeightUnionType.of("calc(100vh - 83px)");
        menu.asElement().style.height= CSSProperties.HeightUnionType.of("calc(100vh - 70px)");
        return menu;
    }

    public MenuItem addMenuItem(String title, Icon icon) {
        MenuItem menuItem=MenuItem.createRootItem(title, icon, this);
        root.appendChild(menuItem.asElement());
        return menuItem;
    }

    @Override
    public MenuItem getActiveItem() {
        return activeMenuItem;
    }

    @Override
    public void setActiveItem(MenuItem activeItem) {
        this.activeMenuItem=activeItem;
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
}
