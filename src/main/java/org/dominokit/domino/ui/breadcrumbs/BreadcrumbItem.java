package org.dominokit.domino.ui.breadcrumbs;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.HasClickableElement;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class BreadcrumbItem implements IsElement<HTMLLIElement>, HasClickableElement {

    private HTMLLIElement element = li().asElement();
    private HTMLAnchorElement anchorElement=a().asElement();
    private Text textElement;
    private Icon icon;
    private boolean active = false;

    private BreadcrumbItem(String text) {
        this.textElement = new Text(text);
        this.anchorElement.appendChild(textElement);
        element.appendChild(anchorElement);
    }

    private BreadcrumbItem(Icon icon, String text) {
        this.icon = icon;
        this.textElement = new Text(text);
        this.anchorElement.appendChild(icon.asElement());
        this.anchorElement.appendChild(textElement);
        element.appendChild(anchorElement);
    }

    public static BreadcrumbItem create(String text) {
        return new BreadcrumbItem(text);
    }

    public static BreadcrumbItem create(Icon icon, String text) {
        return new BreadcrumbItem(icon, text);
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