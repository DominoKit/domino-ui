package com.progressoft.brix.domino.ui.menu;

import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.style.Waves;
import com.progressoft.brix.domino.ui.utils.HasActiveItem;
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
        Waves.init();
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
