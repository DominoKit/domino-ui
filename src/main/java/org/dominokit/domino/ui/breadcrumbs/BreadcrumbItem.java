package org.dominokit.domino.ui.breadcrumbs;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class BreadcrumbItem extends DominoElement<BreadcrumbItem> implements IsElement<HTMLLIElement>, HasClickableElement {

    private HTMLLIElement element = li().asElement();
    private HTMLAnchorElement anchorElement=a().asElement();
    private Text textElement;
    private Icon icon;
    private boolean active = false;

    private BreadcrumbItem(String text) {
        init(text, null);
    }

    private BreadcrumbItem(String text, Icon icon) {
        init(text, icon);
    }

    private void init(String text, Icon icon) {
        this.textElement = new Text(text);
        if(nonNull(icon)) {
            this.icon = icon;
            this.anchorElement.appendChild(icon.asElement());
        }
        this.anchorElement.appendChild(textElement);
        element.appendChild(anchorElement);
        initCollapsible(this);
    }

    public static BreadcrumbItem create(String text) {
        return new BreadcrumbItem(text);
    }

    public static BreadcrumbItem create(Icon icon, String text) {
        return new BreadcrumbItem(text, icon);
    }

    public void activate() {
        if (!active) {
            element.classList.add("active");
            textElement.remove();
            anchorElement.remove();
            if (nonNull(icon)) {
                icon.asElement().remove();
                element.appendChild(icon.asElement());
            }
            element.appendChild(textElement);
            this.active = true;
        }
    }

    public void deActivate() {
        if (active) {
            element.classList.remove("active");
            textElement.remove();
            if (nonNull(icon)) {
                icon.asElement().remove();
                anchorElement.appendChild(icon.asElement());
            }
            anchorElement.appendChild(textElement);
            element.appendChild(anchorElement);
            this.active = false;
        }
    }

    public BreadcrumbItem onClick(EventListener onClick){
        getClickableElement().addEventListener("click", onClick);
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }

    @Override
    public HTMLElement getClickableElement() {
        return anchorElement;
    }
}