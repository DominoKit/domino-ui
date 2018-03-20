package org.dominokit.domino.ui.popover;

import elemental2.dom.*;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Tooltip implements IsElement<HTMLDivElement> {

    private HTMLDivElement element=div().css("tooltip").attr("role","tooltip").asElement();
    private HTMLDivElement arrowElement =div().css("tooltip-arrow").asElement();
    private HTMLDivElement innerElement =div().css("tooltip-inner").asElement();
    private PopupPosition popupPosition =TOP;

    public Tooltip(HTMLElement target, String text) {
        this(target, new Text(text));
    }

    public Tooltip(HTMLElement target, Node content) {
        element.appendChild(arrowElement);
        element.appendChild(innerElement);
        innerElement.appendChild(content);

        element.classList.add(popupPosition.getDirectionClass());

        target.addEventListener(EventType.mouseenter.getName(), evt -> {
            DomGlobal.document.body.appendChild(element);
            element.classList.remove("fade", "in");
            element.classList.add("fade","in");
            popupPosition.position(element, target);
            position(popupPosition);
        });

        target.addEventListener(EventType.mouseout.getName(), evt -> {
            element.remove();
        });
    }

    public static Tooltip create(HTMLElement target, String text){
        return new Tooltip(target, text);
    }

    public static Tooltip create(HTMLElement target, Node content){
        return new Tooltip(target, content);
    }

    public Tooltip position(PopupPosition position){
        this.element.classList.remove(popupPosition.getDirectionClass());
        this.popupPosition =position;
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
}
