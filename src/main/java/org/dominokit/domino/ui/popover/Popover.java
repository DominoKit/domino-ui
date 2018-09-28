package org.dominokit.domino.ui.popover;

import elemental2.dom.*;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.h;

public class Popover extends BaseDominoElement<HTMLDivElement, Popover> implements Switchable<Popover> {

    private static List<Popover> currentVisible = new ArrayList<>();
    private final Text headerText;
    private final HTMLElement targetElement;

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("popover").attr("role", "tooltip").style("display: block;"));
    private DominoElement<HTMLDivElement> arrowElement = DominoElement.of(div().css("arrow"));
    private DominoElement<HTMLHeadingElement> headingElement = DominoElement.of(h(3).css("popover-title"));
    private DominoElement<HTMLDivElement> contentElement = DominoElement.of(div().css("popover-content"));

    private PopupPosition popupPosition = TOP;

    private boolean visible = false;

    private boolean closeOthers = true;
    private final EventListener showListener;
    private final EventListener closeListener;
    private boolean disabled = false;

    public Popover(HTMLElement target, String title, Node content) {
        this.targetElement = target;
        element.appendChild(arrowElement);
        element.appendChild(headingElement);
        element.appendChild(contentElement);
        headerText = TextNode.of(title);
        headingElement.appendChild(headerText);
        contentElement.appendChild(content);
        showListener = evt -> {
            evt.stopPropagation();
            show();
        };
        target.addEventListener(EventType.click.getName(), showListener);
        closeListener = evt -> closeAll();
        document.body.addEventListener(EventType.click.getName(), closeListener);
        element.addEventListener(EventType.click.getName(), Event::stopPropagation);
        ElementUtil.onDetach(targetElement, mutationRecord -> element.remove());
        init(this);
    }

    public void show() {
        if (isEnabled()) {
            if (nonNull(currentVisible) && closeOthers) {
                closeOthers();
            }
            open(targetElement);
            currentVisible.add(Popover.this);
        }
    }

    private void closeAll() {
        closeOthers();
    }

    private void closeOthers() {
        currentVisible.forEach(Popover::close);
        currentVisible.clear();
    }

    private void open(HTMLElement target) {
        if (visible) {
            close();
        } else {
            document.body.appendChild(element.asElement());
            element.style().remove("fade", "in");
            element.style().add("fade", "in");
            popupPosition.position(element.asElement(), target);
            position(popupPosition);
            visible = true;
        }
    }

    public void close() {
        asElement().remove();
        visible = false;
    }

    public void discard() {
        close();
        targetElement.removeEventListener(EventType.click.getName(), showListener);
        document.removeEventListener(EventType.click.getName(), closeListener);
    }

    public static Popover createPicker(HTMLElement target, Node content) {
        Popover popover = new Popover(target, "", content);
        popover.getHeadingElement().style().setDisplay("none");
        popover.getContentElement().style().setProperty("padding", "0px");

        return popover;
    }

    public static Popover createPicker(IsElement target, IsElement content) {
        Popover popover = new Popover(target.asElement(), "", content.asElement());
        popover.getHeadingElement().style().setDisplay("none");
        popover.getContentElement().style().setProperty("padding", "0px");

        return popover;
    }

    public static Popover create(HTMLElement target, String title, Node content) {
        return new Popover(target, title, content);
    }

    public static Popover create(HTMLElement target, String title, IsElement content) {
        return new Popover(target, title, content.asElement());
    }

    public static Popover create(IsElement target, String title, Node content) {
        return new Popover(target.asElement(), title, content);
    }

    public static Popover create(IsElement target, String title, IsElement content) {
        return new Popover(target.asElement(), title, content.asElement());
    }

    public Popover position(PopupPosition position) {
        this.element.style().remove(popupPosition.getDirectionClass());
        this.popupPosition = position;
        this.element.style().add(popupPosition.getDirectionClass());

        return this;
    }

    public Popover setCloseOthers(boolean closeOthers) {
        this.closeOthers = closeOthers;
        return this;
    }

    @Override
    public Popover enable() {
        this.disabled = false;
        return this;
    }

    @Override
    public Popover disable() {
        this.disabled = true;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }

    public DominoElement<HTMLHeadingElement> getHeadingElement() {
        return headingElement;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

    public DominoElement<HTMLDivElement> getContentElement() {
        return contentElement;
    }

    public Text getHeaderText() {
        return headerText;
    }
}
