package org.dominokit.domino.ui.dropdown;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.List;

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.utils.ElementUtil.*;

public class MenuNavigation<V extends IsElement> implements EventListener {

    private final List<V> items;
    private FocusHandler<V> focusHandler;
    private SelectHandler<V> selectHandler;
    private FocusCondition<V> focusCondition;
    private EscapeHandler escapeHandler;

    public MenuNavigation(List<V> items) {
        this.items = items;
    }

    public static <V extends IsElement> MenuNavigation<V> create(List<V> items) {
        return new MenuNavigation<>(items);
    }

    public MenuNavigation<V> onFocus(FocusHandler<V> focusHandler) {
        this.focusHandler = focusHandler;
        return this;
    }

    public MenuNavigation<V> onSelect(SelectHandler<V> selectHandler) {
        this.selectHandler = selectHandler;
        return this;
    }

    public MenuNavigation<V> onEscape(EscapeHandler escapeHandler) {
        this.escapeHandler = escapeHandler;
        return this;
    }

    public MenuNavigation<V> focusCondition(FocusCondition<V> focusCondition) {
        this.focusCondition = focusCondition;
        return this;
    }

    @Override
    public void handleEvent(Event evt) {
        KeyboardEvent keyboardEvent = (KeyboardEvent) evt;
        HTMLElement element = Js.uncheckedCast(keyboardEvent.target);
        for (V item : items) {
            if (item.element().contains(element)) {
                if (isArrowUp(keyboardEvent)) {
                    focusPrevious(item);
                } else if (isArrowDown(keyboardEvent)) {
                    focusNext(item);
                } else if (isEscapeKey(keyboardEvent)) {
                    escapeHandler.onEscape();
                }

                if (isEnterKey(keyboardEvent) ||
                        isSpaceKey(keyboardEvent)
                        || isTabKey(keyboardEvent)) {
                    selectHandler.doSelect(item);
                }
                evt.preventDefault();
            }
        }
    }

    private void focusNext(V item) {
        int nextIndex = items.indexOf(item) + 1;
        int size = items.size();
        if (nextIndex >= size) {
            focusTopFocusableItem();
        } else {
            for (int i = nextIndex; i < size; i++) {
                V itemToFocus = items.get(i);
                if (shouldFocus((V) itemToFocus)) {
                    doFocus(itemToFocus);
                    return;
                }
            }
            focusTopFocusableItem();
        }
    }

    private boolean shouldFocus(V itemToFocus) {
        return isNull(focusCondition) || focusCondition.shouldFocus(itemToFocus);
    }

    private void focusTopFocusableItem() {
        for (V item : items) {
            if (shouldFocus(item)) {
                doFocus(item);
                break;
            }
        }
    }

    private void focusBottomFocusableItem() {
        for (int i = items.size() - 1; i >= 0; i--) {
            V itemToFocus = items.get(i);
            if (shouldFocus(itemToFocus)) {
                doFocus(itemToFocus);
                break;
            }
        }
    }

    private void focusPrevious(V item) {
        int nextIndex = items.indexOf(item) - 1;
        if (nextIndex < 0) {
            focusBottomFocusableItem();
        } else {
            for (int i = nextIndex; i >= 0; i--) {
                V itemToFocus = items.get(i);
                if (shouldFocus(itemToFocus)) {
                    doFocus(itemToFocus);
                    return;
                }
            }
            focusBottomFocusableItem();
        }
    }

    private void doFocus(V item) {
        focusHandler.doFocus(item);
    }

    public void focusAt(int index) {
        if (!items.isEmpty()) {
            V item = items.get(index);
            doFocus(item);
        }
    }

    @FunctionalInterface
    public interface FocusHandler<V extends IsElement> {
        void doFocus(V item);
    }

    @FunctionalInterface
    public interface SelectHandler<V extends IsElement> {
        void doSelect(V item);

    }

    @FunctionalInterface
    public interface EscapeHandler {
        void onEscape();
    }

    @FunctionalInterface
    public interface FocusCondition<V extends IsElement> {
        boolean shouldFocus(V item);
    }
}
