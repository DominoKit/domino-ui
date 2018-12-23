package org.dominokit.domino.ui.collapsible;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class Collapsible implements IsElement<HTMLElement>, IsCollapsible<Collapsible> {


    private final HTMLElement element;
    private final Style<HTMLElement, IsElement<HTMLElement>> style;

    private boolean collapsed = false;

    private CollapseCompletedHandler onCollapsed = () -> {
    };
    private ExpandCompletedHandler onExpanded = () -> {
    };

    private List<CollapseCompletedHandler> collapseHandlers = new ArrayList<>();
    private List<ExpandCompletedHandler> expandHandlers = new ArrayList<>();

    public Collapsible(HTMLElement element) {
        this.element = element;
        style = Style.of(element);
    }

    public static Collapsible create(HTMLElement element) {
        return new Collapsible(element);
    }

    public static Collapsible create(IsElement isElement) {
        return create(isElement.asElement());
    }

    @Override
    public Collapsible collapse() {
        style.setDisplay("none");
        onCollapseCompleted();
        this.collapsed = true;
        return this;
    }

    @Override
    public Collapsible expand() {
        onExpandCompleted();
        style.removeProperty("display");
        this.collapsed = false;
        return this;
    }

    private void onCollapseCompleted() {
        onCollapsed.onCollapsed();
        collapseHandlers.forEach(CollapseCompletedHandler::onCollapsed);
    }

    private void onExpandCompleted() {
        onExpanded.onExpanded();
        expandHandlers.forEach(ExpandCompletedHandler::onExpanded);
    }

    public boolean isCollapsed() {
        return this.collapsed;
    }

    @Override
    public Collapsible toggleDisplay() {
        if (isCollapsed())
            expand();
        else
            collapse();
        return this;
    }


    @Override
    public Collapsible toggleDisplay(boolean state) {
        if(state){
            expand();
        }else{
            collapse();
        }
        return this;
    }

    void setOnCollapsed(CollapseCompletedHandler onCollapsed) {
        this.onCollapsed = onCollapsed;
    }

    void setOnExpanded(ExpandCompletedHandler onExpanded) {
        this.onExpanded = onExpanded;
    }

    public Collapsible addCollapseHandler(CollapseCompletedHandler handler) {
        collapseHandlers.add(handler);
        return this;
    }

    public void removeCollapseHandler(CollapseCompletedHandler handler) {
        collapseHandlers.remove(handler);
    }

    public Collapsible addExpandHandler(ExpandCompletedHandler handler) {
        expandHandlers.add(handler);
        return this;
    }

    public void removeExpandHandler(ExpandCompletedHandler handler) {
        expandHandlers.remove(handler);
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }

    @FunctionalInterface
    public interface CollapseCompletedHandler {
        void onCollapsed();
    }

    @FunctionalInterface
    public interface ExpandCompletedHandler {
        void onExpanded();
    }


}
