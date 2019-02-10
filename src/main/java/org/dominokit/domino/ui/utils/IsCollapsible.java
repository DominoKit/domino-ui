package org.dominokit.domino.ui.utils;

public interface IsCollapsible<T> {
    /**
     * @deprecated use {@link #hide()}
     * @return T
     */
    @Deprecated
    default T collapse(){
        return hide();
    }

    /**
     * @deprecated use {@link #show()}
     * @return T
     */
    @Deprecated
    default T expand(){
        return show();
    }

    T show();

    T hide();

    T toggleDisplay();

    T toggleDisplay(boolean state);

    boolean isCollapsed();
}
