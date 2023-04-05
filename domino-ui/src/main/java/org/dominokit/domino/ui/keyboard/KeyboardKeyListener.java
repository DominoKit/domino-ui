package org.dominokit.domino.ui.keyboard;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.events.HasDefaultEventOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class KeyboardKeyListener implements EventListener, AcceptKeyEvents {

    public static final String ESCAPE = "escape";
    public static final String ARROWDOWN = "arrowdown";
    public static final String ARROWUP = "arrowup";
    public static final String ARROWRIGHT = "arrowright";
    public static final String ARROWLEFT = "arrowleft";
    public static final String ENTER = "enter";
    public static final String DELETE = "delete";
    public static final String SPACE = "space";
    public static final String TAB = "tab";
    public static final String BACKSPACE = "backspace";

    private final Map<String, List<KeyEventHandlerContext>> handlers = new HashMap<>();
    private final List<KeyEventHandlerContext> globalHandlers = new ArrayList<>();
    private HasDefaultEventOptions<KeyboardEventOptions> hasDefaultEventOptions;

    public KeyboardKeyListener(HasDefaultEventOptions<KeyboardEventOptions> hasDefaultEventOptions) {
        this.hasDefaultEventOptions = hasDefaultEventOptions;
    }

    @Override
    public void handleEvent(Event evt) {
        KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
        // ignore events without keycode (browser bug?)
        // example: picking value by keyboard from Chrome auto-suggest
        if (keyboardEvent.key == null) return;
        String key = keyboardEvent.key.toLowerCase();
        if(handlers.containsKey(key)) {
            callHandlers(handlers.get(key), evt);
        }
        callHandlers(globalHandlers, evt);
    }

    private void callHandlers(List<KeyEventHandlerContext> keyEventHandlerContexts, Event evt){
        KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
        keyEventHandlerContexts
                .stream()
                .filter(context ->
                        context.options.get().withCtrlKey == keyboardEvent.ctrlKey &&
                                context.options.get().withAltKey == keyboardEvent.altKey &&
                                context.options.get().withShiftKey == keyboardEvent.shiftKey &&
                                context.options.get().withMetaKey == keyboardEvent.metaKey &&
                                context.options.get().repeating == keyboardEvent.repeat)
                .forEach(context -> {
                    context.handler.handleEvent(keyboardEvent);
                    if (context.options.get().preventDefault) {
                        evt.preventDefault();
                    }
                    if (context.options.get().stopPropagation) {
                        evt.stopPropagation();
                    }
                });
    }

    @Override
    public AcceptKeyEvents onBackspace(EventListener handler) {
        return addHandler(BACKSPACE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onBackspace(KeyboardEventOptions options, EventListener handler) {
        return addHandler(BACKSPACE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onEscape(EventListener handler) {
        return addHandler(ESCAPE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onEscape(KeyboardEventOptions options, EventListener handler) {
        return addHandler(ESCAPE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onArrowUpDown(EventListener handler) {
        return onArrowUp(handler).onArrowDown(handler);
    }

    @Override
    public AcceptKeyEvents onArrowUpDown(KeyboardEventOptions options, EventListener handler) {
        return onArrowUp(options, handler).onArrowDown(options, handler);
    }

    @Override
    public AcceptKeyEvents onArrowDown(EventListener handler) {
        return addHandler(ARROWDOWN, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onArrowDown(KeyboardEventOptions options, EventListener handler) {
        return addHandler(ARROWDOWN, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onArrowUp(EventListener handler) {
        return addHandler(ARROWUP, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onArrowUp(KeyboardEventOptions options, EventListener handler) {
        return addHandler(ARROWUP, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onArrowRight(EventListener handler) {
        return addHandler(ARROWRIGHT, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onArrowRight(KeyboardEventOptions options, EventListener handler) {
        return addHandler(ARROWRIGHT, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onArrowLeft(EventListener handler) {
        return addHandler(ARROWLEFT, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onArrowLeft(KeyboardEventOptions options, EventListener handler) {
        return addHandler(ARROWLEFT, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onEnter(EventListener handler) {
        return addHandler(ENTER, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onEnter(KeyboardEventOptions options, EventListener handler) {
        return addHandler(ENTER, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onDelete(EventListener handler) {
        return addHandler(DELETE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onDelete(KeyboardEventOptions options, EventListener handler) {
        return addHandler(DELETE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onSpace(EventListener handler) {
        return addHandler(SPACE, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onSpace(KeyboardEventOptions options, EventListener handler) {
        return addHandler(SPACE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onTab(EventListener handler) {
        return addHandler(TAB, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onTab(KeyboardEventOptions options, EventListener handler) {
        return addHandler(TAB, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents on(String key, EventListener handler) {
        return addHandler(key, contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents on(String key, KeyboardEventOptions options, EventListener handler) {
        return addHandler(key, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents any(KeyboardEventOptions options, EventListener handler) {
        return addGlobalHandler(contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents any(EventListener handler) {
        return addGlobalHandler(contextOf(handler, () -> hasDefaultEventOptions.getOptions()));
    }

    private AcceptKeyEvents addHandler(String key, KeyEventHandlerContext keyEventHandlerContext) {
        if(!handlers.containsKey(key)){
            handlers.put(key, new ArrayList<>());
        }
        handlers.get(key).add(keyEventHandlerContext);
        return this;
    }
    private AcceptKeyEvents addGlobalHandler(KeyEventHandlerContext keyEventHandlerContext) {
        globalHandlers.add(keyEventHandlerContext);
        return this;
    }

    private KeyEventHandlerContext contextOf(EventListener handler, Supplier<KeyboardEventOptions> options) {
        return new KeyEventHandlerContext(handler, options);
    }

    @Override
    public AcceptKeyEvents clearAll() {
        handlers.clear();
        return this;
    }

    @Override
    public AcceptKeyEvents clear(String key) {
        if(handlers.containsKey(key)){
            handlers.get(key).clear();
        }
        return this;
    }
}
