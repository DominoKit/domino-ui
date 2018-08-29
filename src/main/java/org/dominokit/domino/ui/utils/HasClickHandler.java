package org.dominokit.domino.ui.utils;

public interface HasClickHandler<T> {

    T addClickHandler(ClickHandler clickHandler);

    interface ClickHandler {
        void onClick();
    }
}
