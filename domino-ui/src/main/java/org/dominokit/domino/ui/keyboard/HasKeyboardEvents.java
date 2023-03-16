package org.dominokit.domino.ui.keyboard;

public interface HasKeyboardEvents<T> {

    T onKeyDown(KeyEventsConsumer onKeyDown);

    T stopOnKeyDown();

    T onKeyUp(KeyEventsConsumer onKeyUp);

    T stopOnKeyUp();

    T onKeyPress(KeyEventsConsumer onKeyPress);

    T stopOnKeyPress();

    KeyboardEventOptions getKeyboardEventsOptions();

    /**
     * Sets the default {@link KeyboardEventOptions}
     *
     * @param defaultOptions the default {@link KeyboardEventOptions}
     * @return same instance
     */
    T setDefaultOptions(KeyboardEventOptions defaultOptions);
}
