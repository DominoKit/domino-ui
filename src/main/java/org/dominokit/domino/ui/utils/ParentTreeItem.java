package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.tree.Tree;

public interface ParentTreeItem<T> {
    T getActiveItem();
    void setActiveItem(T activeItem);
    Tree getTreeRoot();
    boolean isAutoExpandFound();
}
