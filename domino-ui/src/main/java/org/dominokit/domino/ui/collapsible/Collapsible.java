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

/**
 * A component to show and hide element
 * <p>
 *     Collapsible component can wrap any element to provide functionality to show and hide the wrapped element
 *     also it allows attaching callbacks when the element is shown/hidden
 *
 *     <pre>
 *         Collapsible.create(DominoElement.div().setTextContent("Hello world"))
 *         .addShowHandler(() -> DomGlobal.console.info("Div visible"))
 *         .addHideHandler(() -> DomGlobal.console.info("Div visible"));
 *     </pre>
 * </p>
 */
public class Collapsible implements IsElement<HTMLElement>, IsCollapsible<Collapsible> {

    private final HTMLElement element;
    private final Style<HTMLElement, IsElement<HTMLElement>> style;

    private boolean collapsed = false;

    private List<HideCompletedHandler> hideHandlers;
    private List<ShowCompletedHandler> showHandlers = new ArrayList<>();

    /**
     * Creates a collapsible wrapping the element
     * @param element {@link HTMLElement} to be wrapped in a collapsible
     */
    public Collapsible(HTMLElement element) {
        this.element = element;
        style = Style.of(element);
    }

    /**
     * A factory to create a collapsible wrapping the element
     * @param element {@link HTMLElement} to be wrapped in a collapsible
     */
    public static Collapsible create(HTMLElement element) {
        return new Collapsible(element);
    }

    /**
     * A factory to create a collapsible wrapping the element
     * @param isElement {@link IsElement} to be wrapped in a collapsible
     */
    public static Collapsible create(IsElement<?> isElement) {
        return create(isElement.element());
    }

    /**
     * Make the element visible and call any attached show handlers
     * @return same collapsible instance
     */
    @Override
    public Collapsible show() {
        onShowCompleted();
        style.removeProperty("display");
        DominoElement.of(element).removeAttribute("d-collapsed");
        this.collapsed = false;
        return this;
    }

    /**
     * Make the element hidden and call any attached hide handlers
     * @return same collapsible instance
     */
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

    /**
     * checks if the wrapped element is hidden
     * @return boolean, true if the element is hidden.
     */
    @Override
    public boolean isHidden() {
        return this.collapsed || DominoElement.of(element).hasAttribute("d-collapsed");
    }

    /**
     * toggle the element visibility, if its visible it hides it, otherwise it make it visible
     * @return same collapsible instance
     */
    @Override
    public Collapsible toggleDisplay() {
        if (isHidden())
            show();
        else
            hide();
        return this;
    }


    /**
     * toggle the element visibility based on the flag.
     * @param state boolean, if true make the element visible otherwise make it hidden
     * @return same collapsible instance
     */
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
     * Add handler to be called when ever the element changed state to hidden
     * @param handler {@link HideCompletedHandler}
     * @return same Collapsible instance
     */
    public Collapsible addHideHandler(HideCompletedHandler handler) {
        if (isNull(hideHandlers)) {
            hideHandlers = new ArrayList<>();
        }
        hideHandlers.add(handler);
        return this;
    }

    /**
     * removes the hide handler
     * @param handler {@link HideCompletedHandler}
     * @return same Collapsible instance
     */
    public void removeHideHandler(HideCompletedHandler handler) {
        if (nonNull(hideHandlers)) {
            hideHandlers.remove(handler);
        }
    }

    /**
     * Add handler to be called when ever the element changed state to visible
     * @param handler {@link ShowCompletedHandler}
     * @return same Collapsible instance
     */
    public Collapsible addShowHandler(ShowCompletedHandler handler) {
        if (isNull(showHandlers)) {
            showHandlers = new ArrayList<>();
        }
        showHandlers.add(handler);
        return this;
    }

    /**
     * removes the show handler
     * @param handler {@link ShowCompletedHandler}
     * @return same Collapsible instance
     */
    public void removeShowHandler(ShowCompletedHandler handler) {
        if (nonNull(showHandlers)) {
            showHandlers.remove(handler);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return element;
    }

    /**
     * A callback interface to attach some listener when finish hiding the element
     */
    @FunctionalInterface
    public interface HideCompletedHandler {
        void onHidden();
    }

    /**
     * A callback interface to attach some listener when showing an element.
     */
    @FunctionalInterface
    public interface ShowCompletedHandler {
        void onShown();
    }
}
