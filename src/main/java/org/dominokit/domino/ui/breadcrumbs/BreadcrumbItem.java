package org.dominokit.domino.ui.breadcrumbs;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.TextNode;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class BreadcrumbItem extends BaseDominoElement<HTMLLIElement, BreadcrumbItem> implements HasClickableElement {

    private DominoElement<HTMLLIElement> element = DominoElement.of(li().asElement());
    private DominoElement<HTMLAnchorElement> anchorElement = DominoElement.of(a());
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
        init(this);
        this.textElement = TextNode.of(text);
        if (nonNull(icon)) {
            this.icon = icon;
            this.anchorElement.appendChild(icon);
        }
        this.anchorElement.appendChild(textElement);
        element.appendChild(anchorElement);
        init(this);
    }

    public static BreadcrumbItem create(String text) {
        return new BreadcrumbItem(text);
    }

    public static BreadcrumbItem create(Icon icon, String text) {
        return new BreadcrumbItem(text, icon);
    }

    public BreadcrumbItem activate() {
        if (!active) {
            element.style().add("active");
            textElement.remove();
            anchorElement.remove();
            if (nonNull(icon)) {
                icon.asElement().remove();
                element.appendChild(icon);
            }
            element.appendChild(textElement);
            this.active = true;
        }

        return this;
    }

    public BreadcrumbItem deActivate() {
        if (active) {
            element.style().remove("active");
            textElement.remove();
            if (nonNull(icon)) {
                icon.remove();
                anchorElement.appendChild(icon);
            }
            anchorElement.appendChild(textElement);
            element.appendChild(anchorElement);
            this.active = false;
        }

        return this;
    }

    public BreadcrumbItem setActive(boolean active) {
        if (active) {
            return activate();
        } else {
            return deActivate();
        }
    }

    @Override
    public HTMLLIElement asElement() {
        return element.asElement();
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return anchorElement.asElement();
    }

    public Text getTextElement() {
        return textElement;
    }

    public Icon getIcon() {
        return icon;
    }

    public boolean isActive() {
        return active;
    }
}