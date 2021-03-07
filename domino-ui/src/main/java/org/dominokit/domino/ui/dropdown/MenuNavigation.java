package org.dominokit.domino.ui.dropdown;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.KeyboardEvent;
import jsinterop.base.Js;
import org.jboss.elemento.IsElement;

import java.util.List;

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.utils.ElementUtil.*;

/**
 * A helper class to ease the keyboard navigation of a menu
 *
 * @param <V> The element type
 * @see IsElement
 * @see EventListener
 */
public class MenuNavigation<V extends IsElement<?>> implements EventListener {

    private final List<V> items;
    private FocusHandler<V> focusHandler;
    private SelectHandler<V> selectHandler;
    private FocusCondition<V> focusCondition;
    private EscapeHandler escapeHandler;

    public MenuNavigation(List<V> items) {
        this.items = items;
    }

    /**
     * Creates new navigation for a menu contains a list of items
     *
     * @param items the items of the menu
     * @param <V>   the element type
     * @return new instance
     */
    public static <V extends IsElement<?>> MenuNavigation<V> create(List<V> items) {
        return new MenuNavigation<>(items);
    }

    /**
     * Sets a handler which will be called when an item gets focused
     *
     * @param focusHandler A {@link FocusHandler}
     * @return same instance
     */
    public MenuNavigation<V> onFocus(FocusHandler<V> focusHandler) {
        this.focusHandler = focusHandler;
        return this;
    }

    /**
     * Sets a handler which will be called when an item gets selected
     *
     * @param selectHandler A {@link SelectHandler}
     * @return same instance
     */
    public MenuNavigation<V> onSelect(SelectHandler<V> selectHandler) {
        this.selectHandler = selectHandler;
        return this;
    }

    /**
     * Sets a handler which will be called when escape key is pressed
     *
     * @param escapeHandler A {@link EscapeHandler}
     * @return same instance
     */
    public MenuNavigation<V> onEscape(EscapeHandler escapeHandler) {
        this.escapeHandler = escapeHandler;
        return this;
    }

    /**
     * Adds a condition which evaluates if an item should be focused or not
     *
     * @param focusCondition a condition returns true if an item should be focused, false otherwise
     * @return same instance
     */
    public MenuNavigation<V> focusCondition(FocusCondition<V> focusCondition) {
        this.focusCondition = focusCondition;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(Event evt) {
        KeyboardEvent keyboardEvent = (KeyboardEvent) evt;
        evt.stopPropagation();
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

    /**
     * Focuses an item at a specific {@code index}
     *
     * @param index the index of the item
     */
    public void focusAt(int index) {
        if (!items.isEmpty()) {
            V item = items.get(index);
            doFocus(item);
        }
    }

    /**
     * Focus handler to be called when an item gets focused
     *
     * @param <V> the item type
     */
    @FunctionalInterface
    public interface FocusHandler<V> {
        /**
         * Will be called when {@code item} gets focused
         *
         * @param item the focused item
         */
        void doFocus(V item);
    }

    /**
     * Selection handler to be called when an item gets selected
     *
     * @param <V> the item type
     */
    @FunctionalInterface
    public interface SelectHandler<V> {
        /**
         * Will be called when {@code item} gets selected
         *
         * @param item the selected item
         */
        void doSelect(V item);

    }

    /**
     * Escape handler to be called when escape key is pressed
     */
    @FunctionalInterface
    public interface EscapeHandler {
        /**
         * Will be called when the escape key is pressed
         */
        void onEscape();
    }

    /**
     * A condition which evaluates if an item should be focused or not
     *
     * @param <V> the item type
     */
    @FunctionalInterface
    public interface FocusCondition<V> {
        /**
         * Returns true if the item should be focused, false otherwise
         *
         * @param item the item
         * @return true if the item should be focused, false otherwise
         */
        boolean shouldFocus(V item);
    }
}
