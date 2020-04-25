package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.jboss.elemento.ObserverCallback;

public interface ElementObserver {

        String attachId();

        HTMLElement observedElement();

        ObserverCallback callback();

        void remove();
    }