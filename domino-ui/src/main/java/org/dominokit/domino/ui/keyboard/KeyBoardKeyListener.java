package org.dominokit.domino.ui.keyboard;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class KeyBoardKeyListener implements EventListener, AcceptKeyEvents {

    public static final String ESCAPE = "escape";
    public static final String ARROWDOWN = "arrowdown";
    public static final String ARROWUP = "arrowup";
    public static final String ENTER = "enter";
    public static final String DELETE = "delete";
    public static final String SPACE = "space";
    public static final String TAB = "tab";
    public static final String BACKSPACE = "backspace";

    private final Map<String, List<HandlerContext>> handlers = new HashMap<>();
    private final List<HandlerContext> globalHandlers = new ArrayList<>();
    private HasDefaultOptions hasDefaultOptions;

    public KeyBoardKeyListener(HasDefaultOptions hasDefaultOptions) {
        this.hasDefaultOptions = hasDefaultOptions;
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

    private void callHandlers(List<HandlerContext> handlerContexts, Event evt){
        KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
        handlerContexts
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
        return addHandler(BACKSPACE, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onBackspace(EventListener handler, KeyboardEventOptions options) {
        return addHandler(BACKSPACE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onEscape(EventListener handler) {
        return addHandler(ESCAPE, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onEscape(EventListener handler, KeyboardEventOptions options) {
        return addHandler(ESCAPE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onArrowUpDown(EventListener handler) {
        return onArrowUp(handler).onArrowDown(handler);
    }

    @Override
    public AcceptKeyEvents onArrowUpDown(EventListener handler, KeyboardEventOptions options) {
        return onArrowUp(handler,options).onArrowDown(handler, options);
    }

    @Override
    public AcceptKeyEvents onArrowDown(EventListener handler) {
        return addHandler(ARROWDOWN, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onArrowDown(EventListener handler, KeyboardEventOptions options) {
        return addHandler(ARROWDOWN, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onArrowUp(EventListener handler) {
        return addHandler(ARROWUP, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onArrowUp(EventListener handler, KeyboardEventOptions options) {
        return addHandler(ARROWUP, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onEnter(EventListener handler) {
        return addHandler(ENTER, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onEnter(EventListener handler, KeyboardEventOptions options) {
        return addHandler(ENTER, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onDelete(EventListener handler) {
        return addHandler(DELETE, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onDelete(EventListener handler, KeyboardEventOptions options) {
        return addHandler(DELETE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onSpace(EventListener handler) {
        return addHandler(SPACE, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onSpace(EventListener handler, KeyboardEventOptions options) {
        return addHandler(SPACE, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents onTab(EventListener handler) {
        return addHandler(TAB, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents onTab(EventListener handler, KeyboardEventOptions options) {
        return addHandler(TAB, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents on(String key, EventListener handler) {
        return addHandler(key, contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    @Override
    public AcceptKeyEvents on(String key, EventListener handler, KeyboardEventOptions options) {
        return addHandler(key, contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents any(EventListener handler, KeyboardEventOptions options) {
        return addGlobalHandler(contextOf(handler, () -> options));
    }

    @Override
    public AcceptKeyEvents any(EventListener handler) {
        return addGlobalHandler(contextOf(handler, () -> hasDefaultOptions.getOptions()));
    }

    private AcceptKeyEvents addHandler(String key, HandlerContext handlerContext) {
        if(!handlers.containsKey(key)){
            handlers.put(key, new ArrayList<>());
        }
        handlers.get(key).add(handlerContext);
        return this;
    }
    private AcceptKeyEvents addGlobalHandler(HandlerContext handlerContext) {
        globalHandlers.add(handlerContext);
        return this;
    }

    private HandlerContext contextOf(EventListener handler, Supplier<KeyboardEventOptions> options) {
        return new HandlerContext(handler, options);
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
