package org.dominokit.domino.ui.tree;

@FunctionalInterface
public interface TreeItemFilter<T> {
    boolean filter(T treeItem, String searchToken);
}
