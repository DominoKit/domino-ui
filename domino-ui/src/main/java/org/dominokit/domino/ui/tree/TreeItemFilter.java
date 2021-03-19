package org.dominokit.domino.ui.tree;

/**
 * An interface for filtering the tree item based on a search token
 *
 * @param <T> the type of the value
 */
@FunctionalInterface
public interface TreeItemFilter<T> {
    /**
     * @param treeItem    the tree item to filter
     * @param searchToken the search token
     * @return true if the item should be shown, false otherwise
     */
    boolean filter(T treeItem, String searchToken);
}
