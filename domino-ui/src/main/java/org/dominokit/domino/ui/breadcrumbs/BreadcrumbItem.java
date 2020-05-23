package org.dominokit.domino.ui.breadcrumbs;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.TextNode;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

public class BreadcrumbItem extends BaseDominoElement<HTMLLIElement, BreadcrumbItem> implements HasClickableElement {

    private DominoElement<HTMLLIElement> element = DominoElement.of(li().element());
    private DominoElement<HTMLAnchorElement> anchorElement = DominoElement.of(a());
    private Text textElement;
    private BaseIcon icon;
    private boolean active = false;

    private BreadcrumbItem(String text) {
        init(text, null);
    }

    private BreadcrumbItem(String text, BaseIcon<?> icon) {
        init(text, icon);
    }

    private void init(String text, BaseIcon<?> icon) {
        init(this);
        this.textElement = TextNode.of(text);
        if (nonNull(icon)) {
            this.icon = icon;
            this.anchorElement.appendChild(icon);
        }
        this.anchorElement.appendChild(textElement);
        element.appendChild(anchorElement);
        anchorElement.setAttribute("tabindex", "0");
    }

    public static BreadcrumbItem create(String text) {
        return new BreadcrumbItem(text);
    }

    public static BreadcrumbItem create(BaseIcon<?> icon, String text) {
        return new BreadcrumbItem(text, icon);
    }

    public BreadcrumbItem activate() {
        if (!active) {
            element.style().add(BreadcrumbStyles.ACTIVE);
            textElement.remove();
            anchorElement.remove();
            if (nonNull(icon)) {
                icon.element().remove();
                element.appendChild(icon);
            }
            element.appendChild(textElement);
            this.active = true;
        }

        return this;
    }

    public BreadcrumbItem deActivate() {
        if (active) {
            element.style().remove(BreadcrumbStyles.ACTIVE);
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
    public HTMLLIElement element() {
        return element.element();
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return anchorElement.element();
    }

    public Text getTextElement() {
        return textElement;
    }

    public BaseIcon getIcon() {
        return icon;
    }

    public boolean isActive() {
        return active;
    }
}