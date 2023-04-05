package org.dominokit.domino.ui.keyboard;

import elemental2.dom.EventListener;

import java.util.function.Supplier;

class KeyEventHandlerContext {
    final EventListener handler;
    final Supplier<KeyboardEventOptions> options;

    public KeyEventHandlerContext(EventListener handler, Supplier<KeyboardEventOptions> options) {
        this.handler = handler;
        this.options = options;
    }
}
