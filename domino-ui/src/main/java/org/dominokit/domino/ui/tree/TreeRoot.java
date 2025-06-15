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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.DisplayCss.dui_hidden;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.ul;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.search.Search;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.Separator;

public abstract class TreeRoot<V, N extends TreeNode<V, N, S>, C extends TreeRoot<V, N, C, S>, S>
    extends BaseDominoElement<HTMLDivElement, C>
    implements TreeStyles,
        IsParentNode<V, N, S>,
        RootNode<V, N, S>,
        HasSelectionListeners<C, N, S> {

  private final List<N> subNodes = new ArrayList<>();
  private final DivElement rootElement;
  private final DivElement bodyElement;
  private final UListElement subTree;
  private final LazyChild<TreeHeader> headerElement;
  private ToggleTarget toggleTarget = ToggleTarget.ANY;
  private CollapseStrategy collapseStrategy;
  private boolean autoCollapse = true;
  private boolean autoExpandFound = true;
  private LazyChild<PostfixAddOn<?>> collapseExpandAllIcon;
  private NodeIconSupplier<V, N, S> iconSupplier;
  protected N activeNode;
  private V value;

  private LazyChild<PostfixAddOn<?>> searchIcon;
  private LazyChild<Search> search;
  private TreeItemFilter<N> filter =
      (treeItem, searchToken) ->
          treeItem.getTitle().toLowerCase().contains(searchToken.toLowerCase());

  private boolean selectionListenersPaused;
  private final Set<SelectionListener<? super N, ? super S>> selectionListeners = new HashSet<>();
  private final Set<SelectionListener<? super N, ? super S>> deselectionListeners = new HashSet<>();

  public TreeRoot() {
    this.rootElement =
        div()
            .addCss(dui_tree)
            .appendChild(
                bodyElement =
                    div().addCss(dui_tree_body).appendChild(subTree = ul().addCss(dui_tree_nav)));
    headerElement = LazyChild.of(TreeHeader.create(), rootElement);
    init((C) this);
  }

  /**
   * Creates a new tree with the given title.
   *
   * @param treeTitle The title of the tree.
   */
  public TreeRoot(String treeTitle) {
    this();
    headerElement.get().setTitle(treeTitle);
  }

  /**
   * Creates a new tree with the given title and associated data value.
   *
   * @param treeTitle The title of the tree.
   * @param value The data value associated with the tree.
   */
  public TreeRoot(String treeTitle, V value) {
    this(treeTitle);
    this.value = value;
  }

  /**
   * Sets the title of this tree.
   *
   * @param title The title to set.
   * @return This `Tree` instance for method chaining.
   */
  public C setTitle(String title) {
    headerElement.get().setTitle(title);
    return (C) this;
  }

  /**
   * Appends a child tree item to this tree.
   *
   * @param node The tree item to append.
   * @return This Tree instance for method chaining.
   */
  public C appendChild(N node) {
    super.appendChild(node.element());
    node.setParent(this);
    node.setToggleTarget(this.toggleTarget);
    if (nonNull(collapseStrategy)) {
      node.setCollapseStrategy(collapseStrategy);
    }
    this.subNodes.add(node);
    if (nonNull(iconSupplier)) {
      node.onSuppliedIconChanged(iconSupplier);
    }
    return (C) this;
  }

  public C appendChild(N... nodes) {
    Arrays.stream(nodes).forEach(this::appendChild);
    return (C) this;
  }

  /**
   * Sets a custom icon supplier for tree items in this tree. The icon supplier provides icons for
   * each tree item based on its content.
   *
   * @param iconSupplier The custom icon supplier to set.
   * @return This {@code Tree} instance for method chaining.
   */
  public C setNodeIconSupplier(NodeIconSupplier<V, N, S> iconSupplier) {
    this.iconSupplier = iconSupplier;
    if (nonNull(this.iconSupplier)) {
      subNodes.forEach(
          item -> {
            item.onSuppliedIconChanged(iconSupplier);
          });
    }
    return (C) this;
  }

  /** @deprecated use {@link #setNodeIconSupplier(NodeIconSupplier)} */
  @Deprecated
  public C setTreeItemIconSupplier(NodeIconSupplier<V, N, S> iconSupplier) {
    return setNodeIconSupplier(iconSupplier);
  }

  /**
   * Gets the custom icon supplier set for this tree. The icon supplier provides icons for each tree
   * item based on its content.
   *
   * @return The custom icon supplier for tree items, or {@code null} if not set.
   */
  public NodeIconSupplier<V, N, S> getIconSupplier() {
    return iconSupplier;
  }

  /**
   * Appends a separator to this tree.
   *
   * @return This Tree instance for method chaining.
   */
  public C appendChild(Separator separator) {
    super.appendChild(separator);
    return (C) this;
  }

  public C addSeparator() {
    appendChild(Separator.create());
    return (C) this;
  }

  /**
   * Sets the toggle target for this tree.
   *
   * @param toggleTarget The toggle target to set.
   * @return This `Tree` instance for method chaining.
   */
  public C setToggleTarget(ToggleTarget toggleTarget) {
    if (nonNull(toggleTarget)) {
      subNodes.forEach(item -> item.setToggleTarget(toggleTarget));
      this.toggleTarget = toggleTarget;
    }
    return (C) this;
  }

  /**
   * Gets the currently active tree item in this tree.
   *
   * @return The currently active tree item, or {@code null} if none is active.
   */
  @Override
  public N getActiveNode() {
    return activeNode;
  }

  /**
   * Sets the currently active tree item in this tree. The tree item will be activated, and any
   * previously active item will be deactivated.
   *
   * @param node The tree item to set as active.
   */
  @Override
  public void setActiveNode(N node) {
    setActiveNode(node, false);
  }

  /**
   * Returns a reference to the root tree within which this tree is contained. Since a tree is
   * self-contained and typically not nested within other trees, this method returns a reference to
   * the current tree instance.
   *
   * @return A reference to the current tree instance.
   */
  @Override
  public RootNode<V, N, S> getRootNode() {
    return this;
  }

  /**
   * Returns an empty optional, as this tree does not have a parent tree.
   *
   * @return An empty optional.
   */
  public Optional<IsParentNode<V, N, S>> getParent() {
    return Optional.empty();
  }

  /**
   * Sets the currently active tree item in this tree with an option to suppress selection events.
   * The tree item will be activated, and any previously active item will be deactivated.
   *
   * @param node The tree item to set as active.
   * @param silent {@code true} to suppress selection events, {@code false} otherwise.
   */
  @Override
  public void setActiveNode(N node, boolean silent) {
    N source = null;
    if (nonNull(this.activeNode) && !this.activeNode.equals(node)) {
      source = this.activeNode;
      this.activeNode.deactivate();
    }

    this.activeNode = node;
    this.activeNode.doActivate();
    if (!silent) {
      triggerSelectionListeners(node, getSelection());
      this.activeNode.triggerSelectionListeners(node, getSelection());
      Optional.ofNullable(source)
          .ifPresent(
              item -> {
                triggerDeselectionListeners(item, getSelection());
                item.triggerDeselectionListeners(item, getSelection());
              });
    }
  }

  @Override
  public boolean isAutoCollapse() {
    return autoCollapse;
  }

  /**
   * Gets the header of this tree.
   *
   * @return The `TreeHeader` of this tree.
   */
  public TreeHeader getHeader() {
    return headerElement.get();
  }

  /**
   * Gets the sub-tree element of this tree.
   *
   * @return The sub-tree element.
   */
  public UListElement getSubTree() {
    return subTree;
  }

  /**
   * Gets the title element of this tree's header.
   *
   * @return The title element.
   */
  public SpanElement getTitle() {
    return headerElement.get().getTitle();
  }

  /**
   * Sets whether this tree is searchable.
   *
   * @param searchable `true` to enable search functionality, `false` otherwise.
   * @return This `Tree` instance for method chaining.
   */
  public C setSearchable(boolean searchable) {
    if (searchable) {
      if (isNull(search)) {
        search =
            LazyChild.of(
                Search.create(true).onSearch(TreeRoot.this::filter).onClose(this::clearFilter),
                headerElement);

        search.whenInitialized(
            () -> {
              search
                  .element()
                  .getInputElement()
                  .onKeyDown(
                      keyEvents -> {
                        keyEvents.onArrowDown(
                            evt -> {
                              subNodes.stream()
                                  .filter(item -> !dui_hidden.isAppliedTo(item))
                                  .findFirst()
                                  .ifPresent(item -> item.getClickableElement().focus());
                            });
                      });
            });
      }

      if (isNull(searchIcon)) {
        searchIcon =
            LazyChild.of(
                PostfixAddOn.of(
                        Icons.magnify()
                            .clickable()
                            .addClickListener(
                                evt -> {
                                  evt.stopPropagation();
                                  search.get().open();
                                }))
                    .addCss(dui_tree_header_item),
                headerElement.get().getContent());
      }
      search.get();
      searchIcon.get();
    } else {
      if (nonNull(searchIcon)) {
        searchIcon.remove();
      }

      if (nonNull(search)) {
        search.remove();
      }
    }
    return (C) this;
  }

  /**
   * Sets whether this tree is foldable.
   *
   * @param foldingEnabled `true` to enable folding functionality, `false` otherwise.
   * @return This `Tree` instance for method chaining.
   */
  public C setFoldable(boolean foldingEnabled) {
    if (foldingEnabled) {
      if (isNull(collapseExpandAllIcon)) {
        collapseExpandAllIcon =
            LazyChild.of(
                PostfixAddOn.of(
                        ToggleMdiIcon.create(Icons.fullscreen(), Icons.fullscreen_exit())
                            .clickable()
                            .apply(
                                self ->
                                    self.addClickListener(
                                        evt -> {
                                          evt.stopPropagation();
                                          if (self.isToggled()) {
                                            collapseAll();
                                          } else {
                                            expandAll();
                                          }
                                          self.toggle();
                                        })))
                    .addCss(dui_tree_header_item),
                headerElement.get().getContent());
      }
      collapseExpandAllIcon.get();
    } else {
      if (nonNull(collapseExpandAllIcon)) {
        collapseExpandAllIcon.remove();
      }
    }
    return (C) this;
  }

  /** Expands all tree items in this tree. */
  public void expandAll() {
    getSubNodes().forEach(TreeNode::expandAll);
  }

  /** Collapses all tree items in this tree. */
  public void collapseAll() {
    getSubNodes().forEach(TreeNode::collapseAll);
  }

  /**
   * Sets whether this tree should automatically collapse when a new item is selected.
   *
   * @param autoCollapse `true` to automatically collapse the tree, `false` otherwise.
   * @return This `Tree` instance for method chaining.
   */
  public C setAutoCollapse(boolean autoCollapse) {
    this.autoCollapse = autoCollapse;
    return (C) this;
  }

  /** Deactivates all tree items in this tree. */
  public void deactivateAll() {
    getSubNodes().forEach(TreeNode::deactivate);
  }

  /**
   * Returns a list of sub-items contained within this tree. The sub-items are represented as
   * instances of {@link org.dominokit.domino.ui.tree.TreeItem}.
   *
   * @return A list of sub-items contained within this tree.
   */
  public List<N> getSubNodes() {
    return new ArrayList<>(subNodes);
  }

  /**
   * Enables automatic expansion of found tree items when using the search feature.
   *
   * @return This tree instance to allow method chaining.
   */
  public C autoExpandFound() {
    this.autoExpandFound = true;
    return (C) this;
  }

  /**
   * Checks if automatic expansion of found tree items is enabled when using the search feature.
   *
   * @return {@code true} if automatic expansion is enabled, {@code false} otherwise.
   */
  public boolean isAutoExpandFound() {
    return autoExpandFound;
  }

  /**
   * Sets whether to auto-expand found items in the tree.
   *
   * @param autoExpandFound `true` to auto-expand found items, `false` otherwise.
   * @return This `Tree` instance for method chaining.
   */
  public C setAutoExpandFound(boolean autoExpandFound) {
    this.autoExpandFound = autoExpandFound;
    return (C) this;
  }

  /**
   * Sets the icon for this tree.
   *
   * @param icon The icon to set.
   * @return This `Tree` instance for method chaining.
   */
  public C setIcon(Icon<?> icon) {
    headerElement.get().setIcon(icon);
    return (C) this;
  }

  /** Clears the search filter applied to tree items in this tree. */
  public void clearFilter() {
    subNodes.forEach(TreeNode::clearFilter);
  }

  /**
   * Filters tree items in this tree based on the given search token.
   *
   * @param searchToken The search token to filter tree items.
   */
  public void filter(String searchToken) {
    subNodes.forEach(treeItem -> treeItem.filter(searchToken));
  }

  /**
   * Gets the current filter used for searching within the tree.
   *
   * @return The current filter applied to the tree items for searching.
   */
  public TreeItemFilter<N> getFilter() {
    return this.filter;
  }

  /**
   * Sets a filter for tree items in this tree.s
   *
   * @param filter The filter to set.
   * @return This `Tree` instance for method chaining.
   */
  public C setFilter(TreeItemFilter<N> filter) {
    this.filter = filter;
    return (C) this;
  }

  /**
   * Gets the search input field associated with this tree if it is searchable.
   *
   * @return An `Optional` containing the search input field, or empty if not searchable.
   */
  public Optional<Search> getSearch() {
    setSearchable(true);
    if (nonNull(search) && search.isInitialized()) {
      return Optional.ofNullable(search.get());
    }
    return Optional.empty();
  }

  /**
   * Gets the search icon associated with this tree if it is searchable.
   *
   * @return An `Optional` containing the search icon, or empty if not searchable.
   */
  public Optional<PostfixAddOn<?>> getSearchIcon() {
    setSearchable(true);
    if (nonNull(searchIcon) && search.isInitialized()) {
      return Optional.of(searchIcon.get());
    }
    return Optional.empty();
  }

  public C withSearch(ChildHandler<C, Search> handler) {
    setSearchable(true);
    handler.apply((C) this, search.get());
    return (C) this;
  }

  public C withSearchIcon(ChildHandler<C, PostfixAddOn<?>> handler) {
    setSearchable(true);
    handler.apply((C) this, searchIcon.get());
    return (C) this;
  }

  /**
   * Gets the collapse/expand all icon associated with this tree if it is foldable.
   *
   * @return An `Optional` containing the collapse/expand all icon, or empty if not foldable.
   */
  public Optional<PostfixAddOn<?>> getCollapseExpandAllIcon() {
    if (nonNull(collapseExpandAllIcon) && collapseExpandAllIcon.isInitialized()) {
      return Optional.of(collapseExpandAllIcon.get());
    }
    return Optional.empty();
  }

  /**
   * Gets the value associated with this tree.
   *
   * @return The value associated with this tree.
   */
  public V getValue() {
    return value;
  }

  /**
   * Sets the value associated with this tree.
   *
   * @param value The value to set.
   */
  public void setValue(V value) {
    this.value = value;
  }

  /**
   * Gets a list of active tree items in the path from the root to the currently active item.
   *
   * @return A list of active tree items.
   */
  public List<N> getActivePath() {
    List<N> activeNodes = new ArrayList<>();
    N activeNode = getActiveNode();
    while (nonNull(activeNode)) {
      activeNodes.add(activeNode);
      activeNode = activeNode.getActiveNode();
    }

    return activeNodes;
  }

  /**
   * Gets a list of values associated with active tree items in the path from the root to the
   * currently active item.
   *
   * @return A list of values associated with active tree items.
   */
  public List<V> getActivePathValues() {
    List<V> activeValues = new ArrayList<>();
    N activeNode = getActiveNode();
    while (nonNull(activeNode)) {
      activeValues.add(activeNode.getValue());
      activeNode = activeNode.getActiveNode();
    }

    return activeValues;
  }

  /**
   * Removes the specified tree item from this tree. This method removes the tree item from the list
   * of sub-items and calls the {@link org.dominokit.domino.ui.tree.TreeItem#remove()} method on the
   * item to detach it from the DOM.
   *
   * @param item The tree item to be removed.
   */
  public void removeNode(N item) {
    subNodes.remove(item);
    item.remove();
  }

  /**
   * Clears all child items from this tree.
   *
   * @return This `Tree` instance for method chaining.
   */
  public C clear() {
    subNodes.forEach(TreeNode::remove);
    return (C) this;
  }

  /**
   * Gets the collapse strategy set for this tree.
   *
   * @return The collapse strategy.
   */
  public CollapseStrategy getCollapseStrategy() {
    return collapseStrategy;
  }

  /**
   * Sets the collapse strategy for all tree items in this tree.
   *
   * @param collapseStrategy The collapse strategy to set.
   * @return This `Tree` instance for method chaining.
   */
  public C setCollapseStrategy(CollapseStrategy collapseStrategy) {
    getSubNodes().forEach(tTreeItem -> setCollapseStrategy(collapseStrategy));
    this.collapseStrategy = collapseStrategy;
    return (C) this;
  }

  /**
   * Configures the header of this tree using a `ChildHandler`.
   *
   * @param handler The `ChildHandler` to configure the header.
   * @return This `Tree` instance for method chaining.
   */
  public C withHeader(ChildHandler<C, TreeHeader> handler) {
    handler.apply((C) this, headerElement.get());
    return (C) this;
  }

  /**
   * Expands the node within the tree, indicating that it should be expanded or collapsed. This
   * method has no effect on the root tree.
   *
   * @param expandParent {@code true} to expand the parent node, {@code false} to collapse it.
   * @return A reference to this tree.
   */
  @Override
  public C expandNode(boolean expandParent) {
    return (C) this;
  }

  /**
   * Expands the node within the tree. This method has no effect on the root tree.
   *
   * @return A reference to this tree.
   */
  @Override
  public C expandNode() {
    return (C) this;
  }

  /**
   * Collapse the node within the tree, indicating that it should be expanded or collapsed. This
   * method has no effect on the root tree.
   *
   * @param collapseParent {@code true} to collapse the parent node, {@code false} to expand it.
   * @return A reference to this tree.
   */
  @Override
  public C collapseNode(boolean collapseParent) {
    return (C) this;
  }

  /**
   * Collapse the node within the tree. This method has no effect on the root tree.
   *
   * @return A reference to this tree.
   */
  @Override
  public C collapseNode() {
    return (C) this;
  }

  /**
   * Pauses the selection listeners of the tree, preventing them from reacting to selection events.
   *
   * @return The current tree instance with selection listeners paused or resumed based on the
   *     toggle value.
   */
  @Override
  public C pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return (C) this;
  }

  /**
   * Resumes the paused selection listeners of the tree, allowing them to react to selection events.
   *
   * @return The current tree instance with selection listeners resumed.
   */
  @Override
  public C resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return (C) this;
  }

  /**
   * Toggles the pause state of selection listeners of the tree.
   *
   * @param toggle {@code true} to pause the listeners, {@code false} to resume them.
   * @return The current tree instance with selection listeners paused or resumed based on the
   *     toggle value.
   */
  @Override
  public C togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return (C) this;
  }

  /**
   * Gets the set of selection listeners registered with the tree.
   *
   * @return A set containing selection listeners.
   */
  @Override
  public Set<SelectionListener<? super N, ? super S>> getSelectionListeners() {
    return this.selectionListeners;
  }

  /**
   * Gets the set of deselection listeners registered with the tree.
   *
   * @return A set containing deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super N, ? super S>> getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /**
   * Checks if the selection listeners of the tree are currently paused.
   *
   * @return {@code true} if selection listeners are paused, {@code false} otherwise.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * Triggers selection listeners with the provided source and selection tree items.
   *
   * @param source The source tree item that triggered the selection.
   * @param selection The selected tree item.
   * @return The current tree instance with selection listeners triggered.
   */
  @Override
  public C triggerSelectionListeners(N source, S selection) {
    if (!this.selectionListenersPaused) {
      this.selectionListeners.forEach(
          listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return (C) this;
  }

  /**
   * Triggers deselection listeners with the provided source and deselected tree items.
   *
   * @param source The source tree item that triggered the deselection.
   * @param selection The deselected tree item.
   * @return The current tree instance with deselection listeners triggered.
   */
  @Override
  public C triggerDeselectionListeners(N source, S selection) {
    if (!this.selectionListenersPaused) {
      this.deselectionListeners.forEach(
          listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return (C) this;
  }

  @Override
  public void onDeselectionChanged(N source, S selection) {
    triggerDeselectionListeners(source, selection);
  }

  @Override
  public HTMLElement getAppendTarget() {
    return subTree.element();
  }

  @Override
  public HTMLDivElement element() {
    return rootElement.element();
  }
}
