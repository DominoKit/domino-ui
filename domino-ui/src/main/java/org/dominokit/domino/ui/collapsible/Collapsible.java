package org.dominokit.domino.ui.collapsible;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Collapsible implements IsElement<HTMLElement>, IsCollapsible<Collapsible> {


    private final HTMLElement element;
    private final Style<HTMLElement, IsElement<HTMLElement>> style;

    private boolean collapsed = false;

    private List<HideCompletedHandler> hideHandlers;
    private List<ShowCompletedHandler> showHandlers = new ArrayList<>();

    public Collapsible(HTMLElement element) {
        this.element = element;
        style = Style.of(element);
    }

    public static Collapsible create(HTMLElement element) {
        return new Collapsible(element);
    }

    public static Collapsible create(IsElement<?> isElement) {
        return create(isElement.element());
    }

    @Override
    public Collapsible show() {
        onShowCompleted();
        style.removeProperty("display");
        DominoElement.of(element).removeAttribute("d-collapsed");
        this.collapsed = false;
        return this;
    }

    @Override
    public Collapsible hide() {
        style.setDisplay("none");
        DominoElement.of(element).setAttribute("d-collapsed", "true");
        onHideCompleted();
        this.collapsed = true;
        return this;
    }

    private void onHideCompleted() {
        if (nonNull(hideHandlers)) {
            hideHandlers.forEach(HideCompletedHandler::onHidden);
        }
    }

    private void onShowCompleted() {
        if (nonNull(showHandlers)) {
            showHandlers.forEach(ShowCompletedHandler::onShown);
        }
    }

    @Override
    public boolean isHidden() {
        return this.collapsed || DominoElement.of(element).hasAttribute("d-collapsed");
    }

    @Override
    public Collapsible toggleDisplay() {
        if (isHidden())
            show();
        else
            hide();
        return this;
    }


    @Override
    public Collapsible toggleDisplay(boolean state) {
        if (state) {
            show();
        } else {
            hide();
        }
        return this;
    }

    /**
     * @deprecated use {@link #addHideHandler(HideCompletedHandler)}
     */
    @Deprecated
    public Collapsible addCollapseHandler(CollapseCompletedHandler handler) {
        return addHideHandler(handler::onCollapsed);
    }

    /**
     * @deprecated use {@link #removeHideHandler(HideCompletedHandler)}
     */
    @Deprecated
    public void removeCollapseHandler(CollapseCompletedHandler handler) {
        removeHideHandler(handler::onCollapsed);
    }

    /**
     * @deprecated use {@link #addShowHandler(ShowCompletedHandler)}
     */
    @Deprecated
    public Collapsible addExpandHandler(ExpandCompletedHandler handler) {
        return addShowHandler(handler::onExpanded);
    }

    /**
     * @deprecated use {@link #removeShowHandler(ShowCompletedHandler)}
     */
    @Deprecated
    public void removeExpandHandler(ExpandCompletedHandler handler) {
        removeShowHandler(handler::onExpanded);
    }

    public Collapsible addHideHandler(HideCompletedHandler handler) {
        if (isNull(hideHandlers)) {
            hideHandlers = new ArrayList<>();
        }
        hideHandlers.add(handler);
        return this;
    }

    public void removeHideHandler(HideCompletedHandler handler) {
        if (nonNull(hideHandlers)) {
            hideHandlers.remove(handler);
        }
    }

    public Collapsible addShowHandler(ShowCompletedHandler handler) {
        if (isNull(showHandlers)) {
            showHandlers = new ArrayList<>();
        }
        showHandlers.add(handler);
        return this;
    }

    public void removeShowHandler(ShowCompletedHandler handler) {
        if (nonNull(showHandlers)) {
            showHandlers.remove(handler);
        }
    }


    @Override
    public HTMLElement element() {
        return element;
    }

    /**
     * @deprecated use {@link HideCompletedHandler()}
     */
    @Deprecated
    @FunctionalInterface
    public interface CollapseCompletedHandler {
        void onCollapsed();
    }

    /**
     * @deprecated use {@link ShowCompletedHandler()}
     */
    @Deprecated
    @FunctionalInterface
    public interface ExpandCompletedHandler {
        void onExpanded();
    }

    @FunctionalInterface
    public interface HideCompletedHandler {
        void onHidden();
    }

    @FunctionalInterface
    public interface ShowCompletedHandler {
        void onShown();
    }

}
