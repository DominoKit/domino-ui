package org.dominokit.domino.ui.popover;

import elemental2.dom.*;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.Switchable;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.h;

public class Popover implements IsElement<HTMLDivElement>, Switchable<Popover> {

    private static List<Popover> currentVisible=new ArrayList<>();
    private final Text headerText;
    private final HTMLElement targetElement;

    private HTMLDivElement element = div().css("popover").attr("role", "tooltip").style("display: block;").asElement();
    private HTMLDivElement arrowElement = div().css("arrow").asElement();
    private HTMLHeadingElement headingElement = h(3).css("popover-title").asElement();
    private HTMLDivElement contentElement = div().css("popover-content").asElement();

    private PopupPosition popupPosition = TOP;

    private boolean visible = false;

    private boolean closeOthers=true;
    private final EventListener showListener;
    private final EventListener closeListener;
    private boolean disabled=false;

    public Popover(HTMLElement target, String title, Node content) {

        this.targetElement=target;

        element.appendChild(arrowElement);
        element.appendChild(headingElement);
        element.appendChild(contentElement);

        headerText = new Text(title);
        headingElement.appendChild(headerText);
        contentElement.appendChild(content);

        showListener = evt -> {
            evt.stopPropagation();
            show();
        };
        target.addEventListener(EventType.click.getName(), showListener);

        closeListener = evt -> closeAll();
        DomGlobal.document.body.addEventListener(EventType.click.getName(), closeListener);

        element.addEventListener(EventType.click.getName(), Event::stopPropagation);

        ElementUtil.onDetach(targetElement, mutationRecord -> element.remove());

    }

    public void show() {
        if(isEnabled()) {
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
            DomGlobal.document.body.appendChild(element);
            element.classList.remove("fade", "in");
            element.classList.add("fade", "in");
            popupPosition.position(element, target);
            position(popupPosition);
            visible = true;
        }
    }

    public void close() {
        asElement().remove();
        visible = false;
    }

    public void discard(){
        close();
        targetElement.removeEventListener(EventType.click.getName(), showListener);
        DomGlobal.document.removeEventListener(EventType.click.getName(), closeListener);
    }

    public static Popover createPicker(HTMLElement target, Node content) {
        Popover popover = new Popover(target, "", content);
        popover.getHeadingElement().style.display="none";
        popover.getContentElement().style.setProperty("padding","0px");

        return popover;
    }

    public static Popover create(HTMLElement target, String title, Node content) {
        return new Popover(target, title, content);
    }

    public Popover position(PopupPosition position) {
        this.element.classList.remove(popupPosition.getDirectionClass());
        this.popupPosition = position;
        this.element.classList.add(popupPosition.getDirectionClass());

        return this;
    }

    public Popover setCloseOthers(boolean closeOthers){
        this.closeOthers=closeOthers;
        return this;
    }

    @Override
    public Popover enable() {
        this.disabled=false;
        return this;
    }

    @Override
    public Popover disable() {
        this.disabled=true;
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }

    public HTMLHeadingElement getHeadingElement() {
        return headingElement;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public Text getHeaderText() {
        return headerText;
    }

    public HTMLDivElement getContentElement() {
        return contentElement;
    }
}
