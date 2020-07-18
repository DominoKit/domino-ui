package org.dominokit.domino.ui.popover;

import elemental2.dom.*;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;

public class Popover extends BaseDominoElement<HTMLDivElement, Popover> implements Switchable<Popover> {

    private static List<Popover> currentVisible = new ArrayList<>();
    private final Text headerText;
    private final HTMLElement targetElement;

    private DominoElement<HTMLDivElement> element = DominoElement.of(div()
            .css("popover")
            .attr("role", "tooltip")
            .style("display: block;"))
            .elevate(Elevation.LEVEL_1);
    private DominoElement<HTMLDivElement> arrowElement = DominoElement.of(div().css("arrow"));
    private DominoElement<HTMLHeadingElement> headingElement = DominoElement.of(h(3).css("popover-title"));
    private DominoElement<HTMLDivElement> contentElement = DominoElement.of(div().css("popover-content"));

    private PopupPosition popupPosition = TOP;

    private boolean visible = false;

    private boolean closeOthers = true;
    private final EventListener showListener;
    private final EventListener closeListener;
    private boolean disabled = false;
    private String positionClass;
    private boolean closeOnEscp = true;
    private boolean closeOnScroll = true;

    private final List<OpenHandler> openHandlers= new ArrayList<>();
    private final List<CloseHandler> closeHandlers= new ArrayList<>();


    static {
        document.body.addEventListener(EventType.click.getName(), evt-> Popover.closeAll());
    }

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

        element.addEventListener(EventType.click.getName(), Event::stopPropagation);
        ElementUtil.onDetach(targetElement, mutationRecord -> {
            if (visible) {
                close();
            }
            element.remove();
        });
        init(this);

        onDetached(mutationRecord -> {
            document.body.removeEventListener(EventType.keydown.getName(), closeListener);
        });
    }

    @Override
    public Popover show() {
        if (isEnabled()) {
            if (closeOthers) {
                closeOthers();
            }
            open(targetElement);
            element.style().setZIndex(ModalBackDrop.getNextZIndex());
            ModalBackDrop.push(this);
            openHandlers.forEach(OpenHandler::onOpen);
        }

        return this;
    }

    private static void closeAll() {
        closeOthers();
    }

    private static void closeOthers() {
        ModalBackDrop.closePopovers();
    }

    private void open(HTMLElement target) {
        if (visible) {
            close();
        } else {
            document.body.appendChild(element.element());
            element.style().remove("fade", "in");
            element.style().add("fade", "in");
            popupPosition.position(element.element(), target);
            position(popupPosition);
            visible = true;
            if (closeOnEscp) {
                KeyboardEvents.listenOn(document.body)
                        .onEscape(closeListener);
            }
        }
    }

    public void close() {
        element().remove();
        visible = false;
        document.body.removeEventListener(EventType.keydown.getName(), closeListener);
        ModalBackDrop.popPopOver();
        closeHandlers.forEach(CloseHandler::onClose);
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
        Popover popover = new Popover(target.element(), "", content.element());
        popover.getHeadingElement().style().setDisplay("none");
        popover.getContentElement().style().setProperty("padding", "0px");

        return popover;
    }

    public static Popover create(HTMLElement target, String title, Node content) {
        return new Popover(target, title, content);
    }

    public static Popover create(HTMLElement target, String title, IsElement content) {
        return new Popover(target, title, content.element());
    }

    public static Popover create(IsElement target, String title, Node content) {
        return new Popover(target.element(), title, content);
    }

    public static Popover create(IsElement target, String title, IsElement content) {
        return new Popover(target.element(), title, content.element());
    }

    public Popover position(PopupPosition position) {
        this.element.style().remove(this.positionClass);
        this.popupPosition = position;
        this.positionClass = position.getDirectionClass();
        this.element.style().add(this.positionClass);

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

    public Popover closeOnEscp(boolean closeOnEscp) {
        this.closeOnEscp = closeOnEscp;
        return this;
    }

    public Popover closeOnScroll(boolean closeOnScroll) {
        this.closeOnScroll = closeOnScroll;
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public DominoElement<HTMLDivElement> getContentElement() {
        return contentElement;
    }

    public Text getHeaderText() {
        return headerText;
    }

    public boolean isCloseOnScroll() {
        return closeOnScroll;
    }

    public Popover addOpenListener(OpenHandler openHandler) {
        this.openHandlers.add(openHandler);
        return this;
    }

    public Popover addCloseListener(CloseHandler closeHandler) {
        this.closeHandlers.add(closeHandler);
        return this;
    }

    public Popover removeOpenHandler(OpenHandler openHandler) {
        this.openHandlers.remove(openHandler);
        return this;
    }

    public Popover removeCloseHandler(CloseHandler closeHandler) {
        this.closeHandlers.remove(closeHandler);
        return this;
    }

    @FunctionalInterface
    public interface OpenHandler {
        void onOpen();
    }

    @FunctionalInterface
    public interface CloseHandler {
        void onClose();
    }
}
