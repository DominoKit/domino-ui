package org.dominokit.domino.ui.keyboard;

public class KeyboardEventOptions {
    boolean preventDefault = false;
    boolean stopPropagation = false;
    boolean withCtrlKey;
    boolean withAltKey;
    boolean withShiftKey;
    boolean withMetaKey;
    boolean repeating;

    /**
     * @return new instance
     */
    public static KeyboardEventOptions create() {
        return new KeyboardEventOptions();
    }

    /**
     * Sets if prevent default behaviour is enabled or not
     *
     * @param preventDefault true to prevent default, false otherwise
     * @return same instance
     */
    public KeyboardEventOptions setPreventDefault(boolean preventDefault) {
        this.preventDefault = preventDefault;
        return this;
    }

    /**
     * Sets if stop event propagation is enabled or not
     *
     * @param stopPropagation true to stop propagation, false otherwise
     * @return same instance
     */
    public KeyboardEventOptions setStopPropagation(boolean stopPropagation) {
        this.stopPropagation = stopPropagation;
        return this;
    }


    public KeyboardEventOptions setWithCtrlKey(boolean withCtrlKey) {
        this.withCtrlKey = withCtrlKey;
        return this;
    }

    public KeyboardEventOptions setWithAltKey(boolean withAltKey) {
        this.withAltKey = withAltKey;
        return this;
    }

    public KeyboardEventOptions setWithShiftKey(boolean withShiftKey) {
        this.withShiftKey = withShiftKey;
        return this;
    }

    public KeyboardEventOptions setWithMetaKey(boolean withMetaKey) {
        this.withMetaKey = withMetaKey;
        return this;
    }

    public KeyboardEventOptions setRepeating(boolean repeating) {
        this.repeating = repeating;
        return this;
    }
}
