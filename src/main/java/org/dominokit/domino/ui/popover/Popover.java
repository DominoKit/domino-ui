package org.dominokit.domino.ui.popover;

import elemental2.dom.*;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static org.dominokit.domino.ui.popover.PopupPosition.TOP;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.h;

public class Popover implements IsElement<HTMLDivElement> {

    private static List<Popover> currentVisible=new ArrayList<>();

    private HTMLDivElement element = div().css("popover").attr("role", "tooltip").style("display: block;").asElement();
    private HTMLDivElement arrowElement = div().css("arrow").asElement();
    private HTMLHeadingElement headingElement = h(3).css("popover-title").asElement();
    private HTMLDivElement contentElement = div().css("popover-content").asElement();

    private PopupPosition popupPosition = TOP;

    private boolean visible = false;

    private boolean closeOthers=true;

    public Popover(HTMLElement target, String title, Node content) {

        element.appendChild(arrowElement);
        element.appendChild(headingElement);
        element.appendChild(contentElement);

        headingElement.appendChild(new Text(title));
        contentElement.appendChild(content);

        target.addEventListener(EventType.click.getName(), evt -> {
            if(nonNull(currentVisible) && closeOthers) {
                closeOthers();
            }
            evt.stopPropagation();
            open(target);
            currentVisible.add(Popover.this);
        });

        DomGlobal.document.addEventListener(EventType.click.getName(), evt -> {
            closeAll();
        });

        element.addEventListener(EventType.click.getName(), Event::stopPropagation);

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

    private void close() {
        asElement().remove();
        visible = false;
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
    public HTMLDivElement asElement() {
        return element;
    }
}
