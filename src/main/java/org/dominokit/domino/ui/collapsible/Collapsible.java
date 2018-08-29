package org.dominokit.domino.ui.collapsible;

import com.google.gwt.animation.client.Animation;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

public class Collapsible implements IsElement<HTMLElement>, IsCollapsible<Collapsible> {

    public final static int DEFAULT_DURATION = 300;

    private final HTMLElement element;
    private final Style<HTMLElement, IsElement<HTMLElement>> style;

    private boolean collapsed = false;
    private int elementHeight = 0;
    private int duration = DEFAULT_DURATION;

    private CollapseCompletedHandler onCollapsed = () -> {
    };
    private ExpandCompletedHandler onExpanded = () -> {
    };

    private List<CollapseCompletedHandler> collapseHandlers = new ArrayList<>();
    private List<ExpandCompletedHandler> expandHandlers = new ArrayList<>();

    public Collapsible(HTMLElement element) {
        this.element = element;
        style = Style.of(element);
        ElementUtil.onAttach(element, mutationRecord -> {
            updateHeight();
        });
    }

    public Collapsible(HTMLElement element, String key) {
        this.element = element;
        style = Style.of(element);
        ElementUtil.onAttach(element, mutationRecord -> {
            updateHeight();
        });
    }

    public static Collapsible create(HTMLElement element) {
        return new Collapsible(element);
    }

    public static Collapsible create(IsElement isElement) {
        return create(isElement.asElement());
    }

    public static Collapsible create(HTMLElement element, String key) {
        return new Collapsible(element, key);
    }

    public static Collapsible create(IsElement isElement, String key) {
        return create(isElement.asElement(), key);
    }

    @Override
    public Collapsible collapse() {
        return collapse(0);
    }

    @Override
    public Collapsible expand() {
        return expand(0);
    }

    public Collapsible collapse(int duration) {
        if (duration < 1) {
            style.setDisplay("none");
            onCollapseCompleted();
        }else {

            new Animation() {

                @Override
                protected void onStart() {
                    super.onStart();
                    style.css("collapsing");
                    updateHeight();
                    if (elementHeight == 0) {
                        completeCollapse();
                        cancel();
                    }
                }

                @Override
                protected void onUpdate(double progress) {
                    Double doubleHeight = new Double(elementHeight);
                    long newHeight = Math.round(doubleHeight - new Double(doubleHeight * progress));
                    style.setProperty("height", newHeight + "px");
                }

                @Override
                protected void onComplete() {
                    super.onComplete();
                    completeCollapse();
                }
            }.run(duration);
        }
        collapsed = true;

        return this;
    }

    private void completeCollapse() {
        style.setDisplay("none");
        style.removeProperty("height");
        style.removeCss("collapsing");
        onCollapseCompleted();
    }

    private void onCollapseCompleted() {
        onCollapsed.onCollapsed();
        collapseHandlers.forEach(CollapseCompletedHandler::onCollapsed);
    }

    public Collapsible expand(int duration) {

        if(duration<1){
            onExpandCompleted();
            style.removeProperty("display");
        }else {
            new Animation() {

                @Override
                protected void onStart() {
                    super.onStart();
                    style.setProperty("height", "0px");
                    style.css("collapsing");
                    style.removeProperty("display");
                    if (elementHeight == 0) {
                        cancel();
                        completeExpand();
                    }
                }

                @Override
                protected void onUpdate(double progress) {
                    style.setProperty("height", new Double(Math.round(new Double((elementHeight * progress)))).intValue() + "px");
                }

                @Override
                protected void onComplete() {
                    super.onComplete();
                    completeExpand();
                }
            }.run(duration);
        }
        this.collapsed = false;
        return this;
    }

    private void completeExpand() {
        style.removeProperty("height");
        style.removeCss("collapsing");
        onExpandCompleted();
        updateHeight();
    }

    private void onExpandCompleted() {
        onExpanded.onExpanded();
        expandHandlers.forEach(ExpandCompletedHandler::onExpanded);
    }

    public boolean isCollapsed() {
        return this.collapsed;
    }

    @Override
    public Collapsible toggle() {
        if (isCollapsed())
            expand();
        else
            collapse();
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

    public void removeExpandHandlr(ExpandCompletedHandler handler) {
        expandHandlers.remove(handler);
    }

    private void updateHeight() {
        elementHeight = element.offsetHeight;
        if (elementHeight < 300) {
            this.duration = 150;
        } else {
            this.duration = DEFAULT_DURATION;
        }
    }

    public int getDuration() {
        return duration;
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
