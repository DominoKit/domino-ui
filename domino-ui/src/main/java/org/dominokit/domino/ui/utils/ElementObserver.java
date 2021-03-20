package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.ObserverCallback;

/**
 * Obeserving an element Attach/Detach cycle should return an implementation of this interface that holds information about the element being observed
 */
public interface ElementObserver {
    /**
     *
     * @return String unique attach/detach id assigned to the element
     */
    String attachId();

    /**
     *
     * @return the {@link HTMLElement} being observed
     */
    HTMLElement observedElement();

    /**
     *
     * @return the {@link ObserverCallback} to be called when the element is attached/detached
     */
    ObserverCallback callback();

    /**
     * Clean-up and remove the observe listeners for this element
     */
    void remove();
}