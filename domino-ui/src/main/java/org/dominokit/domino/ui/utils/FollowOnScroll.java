package org.dominokit.domino.ui.utils;

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.document;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

public class FollowOnScroll {

    private final EventListener repositionListener;

    public FollowOnScroll(HTMLElement targetElement, ScrollFollower scrollFollower) {
        repositionListener =
                evt -> {
                    if (scrollFollower.isFollowerOpen()) {
                        scrollFollower.positionFollower();
                    }
                };
        elements.elementOf(targetElement)
                .onDetached(mutationRecord -> stop());
    }

    public void start(){
        document.addEventListener("scroll", repositionListener, true);
    }

    public void stop(){
        document.removeEventListener("scroll", repositionListener, true);
    }

    public interface ScrollFollower {
        boolean isFollowerOpen();
        void positionFollower();
    }
}
