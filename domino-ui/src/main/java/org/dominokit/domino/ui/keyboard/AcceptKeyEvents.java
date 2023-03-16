package org.dominokit.domino.ui.keyboard;

import elemental2.dom.EventListener;

public interface AcceptKeyEvents {

    /**
     * On ctrl + backspace buttons pressed
     *
     * @param backspaceHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onBackspace(EventListener backspaceHandler);

    /**
     * On ctrl + backspace buttons pressed with options
     *
     * @param backspaceHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onBackspace(
            EventListener backspaceHandler, KeyboardEventOptions options);

    // ---------------- handlers ----------------
    /**
     * On escape button pressed
     *
     * @param escapeHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onEscape(EventListener escapeHandler);

    /**
     * On escape button pressed with {@code options}
     *
     * @param escapeHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onEscape(EventListener escapeHandler, KeyboardEventOptions options);

    /**
     * On arrow up or arrow down buttons pressed
     *
     * @param arrowDownHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onArrowUpDown(EventListener arrowDownHandler);

    /**
     * On arrow up or arrow down buttons pressed with options
     *
     * @param arrowDownHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onArrowUpDown(
            EventListener arrowDownHandler, KeyboardEventOptions options);

    /**
     * On arrow down button pressed
     *
     * @param arrowDownHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onArrowDown(EventListener arrowDownHandler);

    /**
     * On arrow down button pressed with options
     *
     * @param arrowDownHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onArrowDown(
            EventListener arrowDownHandler, KeyboardEventOptions options);

    /**
     * On arrow up button pressed with options
     *
     * @param arrowUpHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onArrowUp(EventListener arrowUpHandler);

    /**
     * On arrow up button pressed with options
     *
     * @param arrowUpHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onArrowUp(EventListener arrowUpHandler, KeyboardEventOptions options);

    /**
     * On enter button pressed
     *
     * @param enterHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onEnter(EventListener enterHandler);

    /**
     * On enter button pressed with options
     *
     * @param enterHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onEnter(EventListener enterHandler, KeyboardEventOptions options);

    /**
     * On delete button pressed
     *
     * @param deleteHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onDelete(EventListener deleteHandler);

    /**
     * On delete button pressed with options
     *
     * @param deleteHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onDelete(EventListener deleteHandler, KeyboardEventOptions options);

    /**
     * On space button pressed
     *
     * @param spaceHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onSpace(EventListener spaceHandler);

    /**
     * On space button pressed with options
     *
     * @param spaceHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onSpace(EventListener spaceHandler, KeyboardEventOptions options);

    /**
     * On tab button pressed
     *
     * @param tabHandler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents onTab(EventListener tabHandler);

    /**
     * On tab button pressed with options
     *
     * @param tabHandler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents onTab(EventListener tabHandler, KeyboardEventOptions options);

    /**
     * On key button pressed with options
     *
     * @param handler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents on(String key, EventListener handler, KeyboardEventOptions options);

    /**
     * On key button pressed
     *
     * @param handler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents on(String key, EventListener handler);
    /**
     * On key pressed with options
     *
     * @param handler the {@link EventListener} to call
     * @param options the {@link KeyboardEventOptions}
     * @return same instance
     */
    AcceptKeyEvents any(EventListener handler, KeyboardEventOptions options);

    /**
     * On key pressed
     *
     * @param handler the {@link EventListener} to call
     * @return same instance
     */
    AcceptKeyEvents any(EventListener handler);

    AcceptKeyEvents clearAll();
    AcceptKeyEvents clear(String key);
}
