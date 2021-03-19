package org.dominokit.domino.ui.utils;

import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItemFilter;

import java.util.List;
import java.util.Optional;

/**
 * An interface representing a parent tree item
 *
 * @param <T> the type of the object
 */
public interface ParentTreeItem<T> {
    /**
     * @return The current active value
     */
    T getActiveItem();

    /**
     * Activates the item representing the value
     *
     * @param activeItem the value of the item to activate
     */
    void setActiveItem(T activeItem);

    /**
     * Activates the item representing the value
     *
     * @param activeItem the value of the item to activate
     * @param silent     true to not notify listeners
     */
    void setActiveItem(T activeItem, boolean silent);

    /**
     * @return The {@link Tree}
     */
    Tree getTreeRoot();

    /**
     * @return true if automatic expanding is enabled when finding items in search
     */
    boolean isAutoExpandFound();

    /**
     * Expands the tree item
     *
     * @return same instance
     */
    ParentTreeItem<T> expand();

    /**
     * Expands the tree item
     *
     * @param expandParent true to expand the parent of the item
     * @return same instance
     */
    ParentTreeItem<T> expand(boolean expandParent);

    /**
     * Activates the item
     */
    void activate();

    /**
     * Activates the item
     *
     * @param activateParent true to activate parent
     */
    void activate(boolean activateParent);

    /**
     * @return the parent item
     */
    Optional<T> getParent();

    /**
     * Removes item
     *
     * @param item the item value
     */
    void removeItem(T item);

    /**
     * @return the children of this item
     */
    List<T> getSubItems();

    /**
     * @return the {@link TreeItemFilter}
     */
    TreeItemFilter<T> getFilter();
}
