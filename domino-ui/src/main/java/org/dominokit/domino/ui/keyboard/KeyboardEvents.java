package org.dominokit.domino.ui.keyboard;

import elemental2.dom.EventListener;
import elemental2.dom.KeyboardEvent;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.jboss.elemento.IsElement;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public class KeyboardEvents<T extends Node> {

    public static final String ESCAPE = "escape";
    public static final String KEYDOWN = "keydown";
    public static final String ARROWDOWN = "arrowdown";
    public static final String ARROWUP = "arrowup";
    public static final String ENTER = "enter";
    public static final String DELETE = "delete";
    public static final String SPACE = "space";
    public static final String TAB = "tab";
    public static final String BACKSPACE = "backspace";

    private Map<String, HandlerContext> handlers = new HashMap<>();
    private Map<String, HandlerContext> ctrlHandlers = new HashMap<>();
    private KeyboardEventOptions defaultOptions = KeyboardEventOptions.create();

    public KeyboardEvents(T element) {
        element.addEventListener(KEYDOWN, evt -> {
            KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
            String key = keyboardEvent.key.toLowerCase();
            HandlerContext handlerContext = null;
            if (keyboardEvent.ctrlKey && ctrlHandlers.containsKey(key)) {
                handlerContext = ctrlHandlers.get(key);
            } else if (handlers.containsKey(key)) {
                handlerContext = handlers.get(key);
            }

            if (nonNull(handlerContext)) {
                handlerContext.handler.handleEvent(evt);
                if (handlerContext.options.preventDefault) {
                    evt.preventDefault();
                }
                if (handlerContext.options.stopPropagation) {
                    evt.stopPropagation();
                }
            }
        });
    }

    public static <T extends Node> KeyboardEvents listenOn(T element) {
        return new KeyboardEvents<>(element);
    }

    public static KeyboardEvents listenOn(IsElement element) {
        return new KeyboardEvents<>(element.element());
    }

    // ---------------- handlers ----------------
    public KeyboardEvents<T> onEscape(EventListener escapeHandler) {
        return onEscape(escapeHandler, defaultOptions());
    }

    public KeyboardEvents<T> onEscape(EventListener escapeHandler, KeyboardEventOptions options) {
        return addHandler(ESCAPE, contextOf(escapeHandler, options));
    }

    public KeyboardEvents<T> onArrowUpDown(EventListener arrowDownHandler) {
        return onArrowUp(arrowDownHandler).onArrowDown(arrowDownHandler);
    }

    public KeyboardEvents<T> onArrowUpDown(EventListener arrowDownHandler, KeyboardEventOptions options) {
        return onArrowUp(arrowDownHandler, options).onArrowDown(arrowDownHandler, options);
    }


    public KeyboardEvents<T> onArrowDown(EventListener arrowDownHandler) {
        return onArrowDown(arrowDownHandler, defaultOptions());
    }

    public KeyboardEvents<T> onArrowDown(EventListener arrowDownHandler, KeyboardEventOptions options) {
        return addHandler(ARROWDOWN, contextOf(arrowDownHandler, options));
    }

    public KeyboardEvents<T> onArrowUp(EventListener arrowUpHandler) {
        return onArrowUp(arrowUpHandler, defaultOptions());
    }

    public KeyboardEvents<T> onArrowUp(EventListener arrowUpHandler, KeyboardEventOptions options) {
        return addHandler(ARROWUP, contextOf(arrowUpHandler, options));
    }

    public KeyboardEvents<T> onEnter(EventListener enterHandler) {
        return onEnter(enterHandler, defaultOptions());
    }

    public KeyboardEvents<T> onEnter(EventListener enterHandler, KeyboardEventOptions options) {
        return addHandler(ENTER, contextOf(enterHandler, options));
    }

    public KeyboardEvents<T> onDelete(EventListener deleteHandler) {
        return onDelete(deleteHandler, defaultOptions());
    }

    public KeyboardEvents<T> onDelete(EventListener deleteHandler, KeyboardEventOptions options) {
        return addHandler(DELETE, contextOf(deleteHandler, options));
    }

    public KeyboardEvents<T> onSpace(EventListener spaceHandler) {
        return onSpace(spaceHandler, defaultOptions());
    }

    public KeyboardEvents<T> onSpace(EventListener spaceHandler, KeyboardEventOptions options) {
        return addHandler(SPACE, contextOf(spaceHandler, options));
    }

    public KeyboardEvents<T> onTab(EventListener tabHandler) {
        return onTab(tabHandler, defaultOptions());
    }

    public KeyboardEvents<T> onTab(EventListener tabHandler, KeyboardEventOptions options) {
        return addHandler(TAB, contextOf(tabHandler, options));
    }

    private KeyboardEvents<T> addHandler(String type, HandlerContext handlerContext) {
        handlers.put(type, handlerContext);
        return this;
    }

    // ---------------- ctrl handlers ----------------
    public KeyboardEvents<T> onCtrlBackspace(EventListener ctrlBackspaceHandler) {
        return onCtrlBackspace(ctrlBackspaceHandler, defaultOptions());
    }

    public KeyboardEvents<T> onCtrlBackspace(EventListener ctrlBackspaceHandler, KeyboardEventOptions options) {
        return addCtrlHandler(BACKSPACE, contextOf(ctrlBackspaceHandler, options));
    }

    public KeyboardEvents<T> setDefaultOptions(KeyboardEventOptions defaultOptions) {
        this.defaultOptions = defaultOptions;
        return this;
    }

    private KeyboardEvents<T> addCtrlHandler(String type, HandlerContext handlerContext) {
        ctrlHandlers.put(type, handlerContext);
        return this;
    }

    private HandlerContext contextOf(EventListener handler, KeyboardEventOptions options) {
        return new HandlerContext(handler, options);
    }

    private KeyboardEventOptions defaultOptions() {
        return defaultOptions;
    }

    public static class KeyboardEventOptions {
        private boolean preventDefault = false;
        private boolean stopPropagation = false;

        public static KeyboardEventOptions create() {
            return new KeyboardEventOptions();
        }

        public KeyboardEventOptions setPreventDefault(boolean preventDefault) {
            this.preventDefault = preventDefault;
            return this;
        }

        public KeyboardEventOptions setStopPropagation(boolean stopPropagation) {
            this.stopPropagation = stopPropagation;
            return this;
        }
    }

    private static class HandlerContext {
        private EventListener handler;
        private KeyboardEventOptions options;

        public HandlerContext(EventListener handler, KeyboardEventOptions options) {
            this.handler = handler;
            this.options = options;
        }
    }
}
