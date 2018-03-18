package com.progressoft.brix.domino.ui.notifications;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import java.util.List;

import static elemental2.dom.DomGlobal.document;

public abstract class NotificationPosition implements Notification.Position {

    public static final String DATA_POSITION = "data-position";

    private final String selector;
    private final String positionProprety;

    protected NotificationPosition(String selector, String positionProprety) {
        this.selector = selector;
        this.positionProprety = positionProprety;
    }

    @Override
    public void onBeforeAttach(HTMLElement element) {
        element.setAttribute(DATA_POSITION, "20");
        element.setAttribute("data-notify-position", selector);
        onBeforePosition(element);
    }

    protected abstract void onBeforePosition(HTMLElement element);

    @Override
    public void onNewElement(HTMLElement element) {
        List<Element> elements = getElements();
        elements.forEach(e -> {
            HTMLElement htmlElement = (HTMLElement) Js.cast(e);
            int position = getDataPosition(htmlElement);
            if (htmlElement != element) {
                int newPosition = position + (element.offsetHeight + getOffsetPosition(element));
                htmlElement.setAttribute(DATA_POSITION, newPosition);
                htmlElement.style.setProperty(positionProprety, newPosition + "px");
            }
        });
    }

    protected abstract int getOffsetPosition(HTMLElement element);

    private int getDataPosition(HTMLElement htmlElement) {
        return Integer.parseInt(htmlElement.getAttribute(DATA_POSITION));
    }

    private List<Element> getElements() {
        return document.querySelectorAll("div[data-notify-position=" + selector + "]").asList();
    }

    @Override
    public void onRemoveElement(int dataPosition, int height) {
        List<Element> elements = getElements();
        elements.forEach(e -> {
            HTMLElement htmlElement = Js.cast(e);
            int position = getDataPosition(htmlElement);
            if (position > dataPosition) {
                int newPosition = position - height - 20;
                e.setAttribute(DATA_POSITION, newPosition);
                htmlElement.style.setProperty(positionProprety, newPosition + "px");
            }
        });
    }
}
