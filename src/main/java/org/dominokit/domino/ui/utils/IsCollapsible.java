package org.dominokit.domino.ui.utils;

public interface IsCollapsible<T> {
    /**
     * @return T
     * @deprecated use {@link #hide()}
     */
    @Deprecated
    default T collapse() {
        return hide();
    }

    /**
     * @return T
     * @deprecated use {@link #show()}
     */
    @Deprecated
    default T expand() {
        return show();
    }

    T show();

    T hide();

    T toggleDisplay();

    T toggleDisplay(boolean state);

    /**
     * @return boolean
     * @deprecated use {@link #isHidden()}
     */
    @Deprecated
    default boolean isCollapsed() {
        return isHidden();
    }

    boolean isHidden();
}
