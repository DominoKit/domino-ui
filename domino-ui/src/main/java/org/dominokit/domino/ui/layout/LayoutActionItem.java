package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;
import org.jboss.elemento.HtmlContentBuilder;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

public class LayoutActionItem extends BaseDominoElement<HTMLLIElement, LayoutActionItem> {
    private HtmlContentBuilder<HTMLAnchorElement> anchorElement = a().css("js-right-sidebar");
    private DominoElement<HTMLLIElement> li = DominoElement.of(li().css("pull-right")
            .add(anchorElement));

    public LayoutActionItem(BaseIcon<?> baseIcon) {
        this(baseIcon.element());
    }

    public LayoutActionItem(IsElement<?> isElement) {
        this(isElement.element());
    }

    public static LayoutActionItem create(BaseIcon<?> baseIcon){
        return new LayoutActionItem(baseIcon);
    }

    public static LayoutActionItem create(IsElement<?> isElement){
        return new LayoutActionItem(isElement);
    }

    public static LayoutActionItem create(Node node){
        return new LayoutActionItem(node);
    }

    public LayoutActionItem(Node content) {
        init(this);
        DominoElement.of(anchorElement)
                .appendChild(content);
    }

    @Override
    public HTMLElement getClickableElement() {
        return anchorElement.element();
    }

    @Override
    public HTMLLIElement element() {
        return li.element();
    }
}
