/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.tree;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.search.Search;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.Separator;
import org.dominokit.domino.ui.utils.TreeParent;
import org.dominokit.domino.ui.IsElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * A component provides a tree representation of elements
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link TreeStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Tree hardwareTree =
 *         Tree.create("HARDWARE")
 *             .setToggleTarget(ToggleTarget.ICON)
 *             .addItemClickListener((treeItem) -&gt; DomGlobal.console.info(treeItem.getValue()))
 *             .appendChild(
 *                 TreeItem.create("Computer", Icons.ALL.laptop_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Computer").show()))
 *             .appendChild(
 *                 TreeItem.create("Headset", Icons.ALL.headset_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Headset").show()))
 *             .appendChild(
 *                 TreeItem.create("Keyboard", Icons.ALL.keyboard_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Keyboard").show()))
 *             .appendChild(
 *                 TreeItem.create("Mouse", Icons.ALL.mouse_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Mouse").show()))
 *             .addSeparator()
 *             .appendChild(
 *                 TreeItem.create("Laptop", Icons.ALL.laptop_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Laptop").show()))
 *             .appendChild(
 *                 TreeItem.create("Smart phone", Icons.ALL.cellphone_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Smart phone").show()))
 *             .appendChild(
 *                 TreeItem.create("Tablet", Icons.ALL.tablet_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Tablet").show()))
 *             .appendChild(
 *                 TreeItem.create("Speaker", Icons.ALL.speaker_mdi())
 *                     .addClickListener((evt) -&gt; Notification.create("Speaker").show()));
 * </pre>
 *
 * @param <T> the type of the object
 * @see BaseDominoElement
 * @see TreeParent
 */
public class Tree<T> extends BaseDominoElement<HTMLDivElement, Tree<T>>
        implements TreeParent<T>,
        IsElement<HTMLDivElement>,
        TreeStyles,
        HasSelectionListeners<Tree<T>, TreeItem<T>, TreeItem<T>> {

    private ToggleTarget toggleTarget = ToggleTarget.ANY;
    private TreeItemFilter<TreeItem<T>> filter =
            (treeItem, searchToken) ->
                    treeItem.getTitle().toLowerCase().contains(searchToken.toLowerCase());

    private TreeItem<T> activeTreeItem;

    private boolean autoCollapse = true;
    private final List<TreeItem<T>> subItems = new ArrayList<>();
    private boolean autoExpandFound;
    private LazyChild<Search> search;
    private LazyChild<PostfixAddOn<?>> collapseExpandAllIcon;

    private T value;

    private CollapseStrategy collapseStrategy;

    private DivElement element;
    private UListElement subTree;
    private LazyChild<TreeHeader> headerElement;
    private LazyChild<PostfixAddOn<?>> searchIcon;
    private TreeItemIconSupplier<T> iconSupplier;
    private boolean selectionListenersPaused;
    private final Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> selectionListeners = new HashSet<>();
    private final Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> deselectionListeners = new HashSet<>();

    public Tree() {
        element = div()
                .addCss(dui_tree)
                .appendChild(subTree = ul().addCss(dui_tree_nav));
        headerElement = LazyChild.ofInsertFirst(TreeHeader.create(), subTree);
        init(this);
    }

    public Tree(String treeTitle) {
        this();
        headerElement.get().setTitle(treeTitle);
    }

    public Tree(String treeTitle, T value) {
        this(treeTitle);
        this.value = value;
    }

    public Tree(T value) {
        this();
        this.value = value;
    }

    /**
     * @param title the title of the tree
     * @param value the default selected value
     * @param <T>   the type of the object
     * @return new instance
     */
    public static <T> Tree<T> create(String title, T value) {
        return new Tree<>(title, value);
    }

    /**
     * @param value the default selected value
     * @param <T>   the type of the object
     * @return new instance
     */
    public static <T> Tree<T> create(T value) {
        return new Tree<>(value);
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return subTree.element();
    }

    /**
     * Adds a new tree item
     *
     * @param treeItem a new {@link TreeItem}
     * @return same instance
     */
    public Tree<T> appendChild(TreeItem<T> treeItem) {
        super.appendChild(treeItem.element());
        treeItem.setParent(this);
        treeItem.setLevel(0);
        treeItem.setToggleTarget(this.toggleTarget);
        if (nonNull(collapseStrategy)) {
            treeItem.setCollapseStrategy(collapseStrategy);
        }
        this.subItems.add(treeItem);
        if (nonNull(iconSupplier)) {
            treeItem.onSuppliedIconChanged(iconSupplier);
        }
        return this;
    }

    public Tree<T> setTreeItemIconSupplier(TreeItemIconSupplier<T> iconSupplier) {
        this.iconSupplier = iconSupplier;
        if (nonNull(this.iconSupplier)) {
            subItems.forEach(item -> {
                item.onSuppliedIconChanged(iconSupplier);
            });
        }
        return this;
    }

    TreeItemIconSupplier<T> getIconSupplier() {
        return iconSupplier;
    }

    /**
     * Adds a new separator
     *
     * @return same instance
     */
    public Tree<T> addSeparator() {
        appendChild(Separator.create());
        return this;
    }

    /**
     * Sets what is the target for toggling an item
     *
     * @param toggleTarget the {@link ToggleTarget}
     * @return same instance
     */
    public Tree<T> setToggleTarget(ToggleTarget toggleTarget) {
        if (nonNull(toggleTarget)) {
            subItems.forEach(item -> item.setToggleTarget(toggleTarget));
            this.toggleTarget = toggleTarget;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeItem<T> getActiveItem() {
        return activeTreeItem;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void setActiveItem(TreeItem<T> activeItem) {
        setActiveItem(activeItem, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setActiveItem(TreeItem<T> activeItem, boolean silent) {
        TreeItem<T> source = null;
        if (nonNull(this.activeTreeItem) && !this.activeTreeItem.equals(activeItem)) {
            source = this.activeTreeItem;
            this.activeTreeItem.deactivate();
        }

        this.activeTreeItem = activeItem;
        this.activeTreeItem.activate();
        if (!silent) {
            triggerSelectionListeners(activeItem, activeItem);
            activeItem.triggerSelectionListeners(activeItem, activeItem);
            Optional.ofNullable(source)
                    .ifPresent(item -> {
                        triggerDeselectionListeners(item, activeItem);
                        item.triggerDeselectionListeners(item, activeItem);
                    });
        }
    }

    /**
     * @return the header element
     */
    public TreeHeader getHeader() {
        return headerElement.get();
    }

    /**
     * @return the root element
     */
    public UListElement getSubTree() {
        return subTree;
    }

    /**
     * @return the title element
     */
    public SpanElement getTitle() {
        return headerElement.get().getTitle();
    }

    /**
     * Enables the search
     *
     * @return same instance
     */
    public Tree<T> setSearchable(boolean searchable) {
        if (searchable) {

            if (isNull(search)) {
                search = LazyChild.of(Search.create(true)
                        .onSearch(Tree.this::filter)
                        .onClose(this::clearFilter), headerElement);

                search.whenInitialized(() -> {
                    search.element()
                            .getInputElement()
                            .onKeyDown(keyEvents -> {
                                keyEvents.onArrowDown(evt -> {
                                    subItems
                                            .stream()
                                            .filter(item -> !dui_hidden.isAppliedTo(item))
                                            .findFirst()
                                            .ifPresent(item -> item.getClickableElement().focus());
                                });
                            });
                });
            }

            if (isNull(searchIcon)) {
                searchIcon = LazyChild.of(PostfixAddOn.of(Icons.ALL.magnify_mdi()
                        .clickable()
                        .addClickListener(evt -> {
                            evt.stopPropagation();
                            search.get().open();
                        })
                ).addCss(dui_tree_header_item), headerElement.get().getContent());
            }
            searchIcon.get();
        } else {
            if (nonNull(searchIcon)) {
                searchIcon.remove();
            }

            if (nonNull(search)) {
                search.remove();
            }
        }
        return this;
    }

    /**
     * Adds the ability to expand/collapse all items
     *
     * @return same instance
     */
    public Tree<T> setFoldable(boolean foldingEnabled) {
        if (foldingEnabled) {
            if (isNull(collapseExpandAllIcon)) {
                collapseExpandAllIcon = LazyChild.of(PostfixAddOn.of(ToggleMdiIcon.create(Icons.ALL.fullscreen_mdi(), Icons.ALL.fullscreen_exit_mdi())
                        .clickable()
                                .apply(self -> self.addClickListener(evt -> {
                                    evt.stopPropagation();
                                    if(self.isToggled()){
                                        collapseAll();
                                    }else {
                                        expandAll();
                                    }
                                    self.toggle();
                                }))
                ).addCss(dui_tree_header_item), headerElement.get().getContent());
            }
            collapseExpandAllIcon.get();
        }else {
            if(nonNull(collapseExpandAllIcon)){
                collapseExpandAllIcon.remove();
            }
        }
        return this;
    }

    /**
     * Expand all items
     */
    public void expandAll() {
        getSubItems().forEach(TreeItem::expandAll);
    }

    /**
     * Collapse all items
     */
    public void collapseAll() {
        getSubItems().forEach(TreeItem::collapseAll);
    }

    /**
     * Deactivate all items
     */
    public void deactivateAll() {
        getSubItems().forEach(TreeItem::deactivate);
    }

    /**
     * Expand the items found by the search automatically
     *
     * @return same instance
     */
    public Tree<T> autoExpandFound() {
        this.autoExpandFound = true;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAutoExpandFound() {
        return autoExpandFound;
    }

    /**
     * Sets if the items found by the search should be expanded automatically
     *
     * @param autoExpandFound true to expand automatically, false otherwise
     */
    public Tree<T> setAutoExpandFound(boolean autoExpandFound) {
        this.autoExpandFound = autoExpandFound;
        return this;
    }

    /**
     * Clears all the filters
     */
    public void clearFilter() {
        subItems.forEach(TreeItem::clearFilter);
    }

    /**
     * Filter based on the search query
     *
     * @param searchToken the query
     */
    public void filter(String searchToken) {
        subItems.forEach(treeItem -> treeItem.filter(searchToken));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tree<T> getTreeRoot() {
        return this;
    }

    /**
     * Sets if item should be collapsed automatically when it is deactivated
     *
     * @param autoCollapse true to collapse automatically, false otherwise
     * @return same instance
     */
    public Tree<T> setAutoCollapse(boolean autoCollapse) {
        this.autoCollapse = autoCollapse;
        return this;
    }

    /**
     * Sets the title of the tree
     *
     * @param title the title text
     * @return same instance
     */
    public Tree<T> setTitle(String title) {
        headerElement.get().setTitle(title);
        return this;
    }

    public Tree<T> setIcon(Icon<?> icon) {
        headerElement.get().setIcon(icon);
        return this;
    }

    /**
     * @return true if deactivated items should be collapsed automatically
     */
    public boolean isAutoCollapse() {
        return autoCollapse;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TreeItem<T>> getSubItems() {
        return new ArrayList<>(subItems);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeParent<T> expandNode(boolean expandParent) {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeParent<T> expandNode() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<TreeParent<T>> getParent() {
        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void activate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void activate(boolean activateParent) {
    }

    /**
     * @return the search element
     */
    public Optional<Search> getSearch() {
        if (nonNull(search) && search.isInitialized()) {
            return Optional.ofNullable(search.get());
        }
        return Optional.empty();
    }

    /**
     * @return the search icon
     */
    public Optional<PostfixAddOn<?>> getSearchIcon() {
        if (nonNull(searchIcon) && search.isInitialized()) {
            return Optional.of(searchIcon.get());
        }
        return Optional.empty();
    }

    /**
     * @return the collapse all icon
     */
    public Optional<PostfixAddOn<?>> getCollapseExpandAllIcon() {
        if (nonNull(collapseExpandAllIcon) && collapseExpandAllIcon.isInitialized()) {
            return Optional.of(collapseExpandAllIcon.get());
        }
        return Optional.empty();
    }

    /**
     * @return the current value
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value
     *
     * @param value the new value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * @return the list of the items in the current active path
     */
    public List<TreeItem<T>> getActivePath() {
        List<TreeItem<T>> activeItems = new ArrayList<>();
        TreeItem<T> activeItem = getActiveItem();
        while (nonNull(activeItem)) {
            activeItems.add(activeItem);
            activeItem = activeItem.getActiveItem();
        }

        return activeItems;
    }

    /**
     * @return the list of values in the current active path
     */
    public List<T> getActivePathValues() {
        List<T> activeValues = new ArrayList<>();
        TreeItem<T> activeItem = getActiveItem();
        while (nonNull(activeItem)) {
            activeValues.add(activeItem.getValue());
            activeItem = activeItem.getActiveItem();
        }

        return activeValues;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeItem(TreeItem<T> item) {
        subItems.remove(item);
        item.remove();
    }

    /**
     * Remove all tree nodes
     *
     * @return same Tree instance
     */
    public Tree<T> clear() {
        subItems.forEach(TreeItem::remove);
        return this;
    }

    /**
     * Sets the filter that will be used when searching items, the default filter searches using the
     * title of the items
     *
     * @param filter a {@link TreeItemFilter}
     * @return same instance
     */
    public Tree<T> setFilter(TreeItemFilter<TreeItem<T>> filter) {
        this.filter = filter;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TreeItemFilter<TreeItem<T>> getFilter() {
        return this.filter;
    }

    public Tree<T> setCollapseStrategy(CollapseStrategy collapseStrategy) {
        getSubItems().forEach(tTreeItem -> setCollapseStrategy(collapseStrategy));
        this.collapseStrategy = collapseStrategy;
        return this;
    }

    public CollapseStrategy getCollapseStrategy() {
        return collapseStrategy;
    }

    public Tree<T> withHeader(ChildHandler<Tree<T>, TreeHeader> handler) {
        handler.apply(this, headerElement.get());
        return this;
    }

    @Override
    public Tree<T> pauseSelectionListeners() {
        this.selectionListenersPaused = true;
        return this;
    }

    @Override
    public Tree<T> resumeSelectionListeners() {
        this.selectionListenersPaused = false;
        return this;
    }

    @Override
    public Tree<T> togglePauseSelectionListeners(boolean toggle) {
        this.selectionListenersPaused = toggle;
        return this;
    }

    @Override
    public Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> getSelectionListeners() {
        return this.selectionListeners;
    }

    @Override
    public Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> getDeselectionListeners() {
        return this.deselectionListeners;
    }

    @Override
    public boolean isSelectionListenersPaused() {
        return this.selectionListenersPaused;
    }

    @Override
    public Tree<T> triggerSelectionListeners(TreeItem<T> source, TreeItem<T> selection) {
        if (!this.selectionListenersPaused) {
            this.selectionListeners.forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
        }
        return this;
    }

    @Override
    public Tree<T> triggerDeselectionListeners(TreeItem<T> source, TreeItem<T> selection) {
        if (!this.selectionListenersPaused) {
            this.deselectionListeners.forEach(listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
        }
        return this;
    }

    @Override
    public TreeItem<T> getSelection() {
        return this.activeTreeItem;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    /**
     * A listener to be called when clicking on item
     *
     * @param <T> the type of the object
     */
    public interface ItemClickListener<T> {
        void onTreeItemClicked(TreeItem<T> treeItem);
    }

    public interface TreeItemIconSupplier<T> {
        Icon<?> createIcon(TreeItem<T> item);
    }
}
