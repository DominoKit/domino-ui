package org.dominokit.domino.ui.popover;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import elemental2.dom.Text;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Tooltip implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().css("tooltip").attr("role", "tooltip").asElement();
    private HTMLDivElement arrowElement = div().css("tooltip-arrow").asElement();
    private HTMLDivElement innerElement = div().css("tooltip-inner").asElement();
    private PopupPosition popupPosition = TOP;

    public Tooltip(HTMLElement targetElement, String text) {
        this(targetElement, new Text(text));
    }

    public Tooltip(HTMLElement targetElement, Node content) {
        element.appendChild(arrowElement);
        element.appendChild(innerElement);
        innerElement.appendChild(content);

        element.classList.add(popupPosition.getDirectionClass());

        targetElement.addEventListener(EventType.mouseenter.getName(), evt -> {
            evt.stopPropagation();
            document.body.appendChild(element);
            element.classList.remove("fade", "in");
            element.classList.add("fade", "in");
            popupPosition.position(element, targetElement);
            position(popupPosition);
        });

        ElementUtil.onDetach(targetElement, mutationRecord -> element.remove());

        targetElement.addEventListener(EventType.mouseleave.getName(), evt1 -> element.remove());

    }

    public static Tooltip create(HTMLElement target, String text) {
        return new Tooltip(target, text);
    }

    public static Tooltip create(HTMLElement target, Node content) {
        return new Tooltip(target, content);
    }

    public Tooltip position(PopupPosition position) {
        this.element.classList.remove(popupPosition.getDirectionClass());
        this.popupPosition = position;
        this.element.classList.add(popupPosition.getDirectionClass());

        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public HTMLDivElement getArrowElement() {
        return arrowElement;
    }

    public HTMLDivElement getInnerElement() {
        return innerElement;
    }

    public PopupPosition getPopupPosition() {
        return popupPosition;
    }

    public Tooltip setContent(Node content){
        ElementUtil.clear(innerElement);
        innerElement.appendChild(content);
        return this;
    }
}
