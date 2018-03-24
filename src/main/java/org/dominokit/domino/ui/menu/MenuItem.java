package org.dominokit.domino.ui.menu;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.WaveColor;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.CanActivate;
import org.dominokit.domino.ui.utils.CanDeactivate;
import org.dominokit.domino.ui.utils.HasActiveItem;
import org.dominokit.domino.ui.utils.HasClickableElement;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class MenuItem extends WavesElement<MenuItem, HTMLAnchorElement> implements IsElement<HTMLLIElement>, HasActiveItem<MenuItem>, CanActivate, CanDeactivate, HasClickableElement {

    private final String title;
    private final boolean isRoot;
    private HTMLLIElement element;
    private HTMLAnchorElement menuAnchor;
    private List<MenuItem> subItems = new LinkedList<>();
    private MenuItem activeMenuItem;
    private HasActiveItem<MenuItem> parent;
    private boolean active = false;
    private boolean toggled = false;

    private HTMLUListElement childrenContainer;

    private MenuItem(String title, HTMLLIElement element, HTMLAnchorElement menuAnchor, HasActiveItem parent, boolean isRoot) {
        this.element = element;
        this.menuAnchor = menuAnchor;
        this.parent = parent;
        this.title = title;
        this.isRoot = isRoot;
        element.appendChild(menuAnchor);
        super.init(this, menuAnchor);
        setWaveColor(WaveColor.THEME);
        applyWaveStyle(WaveStyle.BLOCK);
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }

    @Override
    public MenuItem getActiveItem() {
        return activeMenuItem;
    }

    @Override
    public void setActiveItem(MenuItem activeItem) {
        this.activeMenuItem = activeItem;
    }


    static MenuItem createRootItem(String title, Icon icon, HasActiveItem parent) {
        HTMLAnchorElement anchor = createAnchor();
        anchor.appendChild(icon.asElement());
        anchor.appendChild(span().textContent(title).asElement());

        return create(title, parent, anchor, true);
    }

    private static HTMLAnchorElement createAnchor() {
        return a().asElement();
    }

    static MenuItem createLeafItem(String title, HasActiveItem parent) {
        HTMLAnchorElement anchor = createAnchor();
        anchor.textContent = title;

        return create(title, parent, anchor, false);
    }

    private static MenuItem create(String title, HasActiveItem parent, HTMLAnchorElement anchor, boolean b) {
        MenuItem menuItem = new MenuItem(title, li().asElement(), anchor, parent, b);
        menuItem.menuAnchor.addEventListener("click", e -> {
            if (!menuItem.equals(parent.getActiveItem())) {
                menuItem.activate();
            }
            menuItem.toggle();
        });
        return menuItem;
    }

    private void toggle() {
        if (!subItems.isEmpty()) {
            if (toggled) {
                menuAnchor.classList.remove("toggled");
                hideChildren();
            } else {
                menuAnchor.classList.add("toggled");
                showChildren();
            }

            toggled = !toggled;
        } else {
            if (!toggled) {
                menuAnchor.classList.add("toggled");
                toggled = true;
            }
        }
    }

    public MenuItem addMenuItem(String title) {
        MenuItem menuItem = createLeafItem(title, this);
        if (subItems.isEmpty())
            prepareForChildren();

        subItems.add(menuItem);
        childrenContainer.appendChild(menuItem.asElement());
        return menuItem;
    }

    private void prepareForChildren() {
        childrenContainer = ul().css("ml-menu").asElement();
        hideChildren();
        menuAnchor.classList.add("menu-toggle");
        if (!isRoot) {
            menuAnchor.textContent = "";
            menuAnchor.appendChild(span().textContent(title).asElement());
        }
        asElement().appendChild(childrenContainer);
    }

    @Override
    public void activate() {
        if (nonNull(parent.getActiveItem())) {
            if (parent.getActiveItem().toggled) {
                parent.getActiveItem().toggle();
            }
            parent.getActiveItem().deactivate();
        }
        element.classList.add("active");
        parent.setActiveItem(this);

        this.active = true;
    }


    private void hideChildren() {
        childrenContainer.style.display = "none";
    }

    private void showChildren() {
        childrenContainer.style.display = "block";
    }

    @Override
    public void deactivate() {
        if (this.active) {
            element.classList.remove("active");
            if (nonNull(getActiveItem())) {

                getActiveItem().menuAnchor.classList.remove("toggled");
                getActiveItem().toggled = false;
                if(!getActiveItem().subItems.isEmpty())
                    getActiveItem().hideChildren();
                getActiveItem().deactivate();
            }

            parent.setActiveItem(null);

            this.active = false;
        }
    }

    @Override
    public HTMLElement getClickableElement() {
        return menuAnchor;
    }
}
