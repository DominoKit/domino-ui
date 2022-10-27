package org.dominokit.domino.ui.utils;

import java.util.Set;

public interface CollapsibleElement<T> {

    T setCollapsible(boolean collapsible);
    T toggleCollapse();
    T toggleCollapse(boolean collapse);
    T expand();
    T collapse();
    boolean isCollapsed();
    Set<CollapseHandler<T>> getCollapseHandlers();
    Set<ExpandHandler<T>> getExpandHandlers();

    default T addCollapseHandler(CollapseHandler<T> handler){
        getCollapseHandlers().add(handler);
        return (T) this;
    }

    default T addExpandHandler(ExpandHandler<T> handler){
        getExpandHandlers().add(handler);
        return (T) this;
    }

    default T removeCollapseHandler(CollapseHandler<T> handler){
        getCollapseHandlers().remove(handler);
        return (T) this;
    }

    default T removeExpandHandler(ExpandHandler<T> handler){
        getExpandHandlers().remove(handler);
        return (T) this;
    }

    @FunctionalInterface
    interface CollapseHandler<T> {
        void onCollapsed(T element);
    }

    /** A callback interface to attach some listener when showing an element. */
    @FunctionalInterface
    interface ExpandHandler<T> {
        void onExpanded(T element);
    }

}
