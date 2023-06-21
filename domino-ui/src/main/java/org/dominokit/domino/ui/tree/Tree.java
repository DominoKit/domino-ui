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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.dominokit.domino.ui.IsElement;
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
import org.dominokit.domino.ui.utils.TreeParent;

/**
 * A component provides a tree representation of elements
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.tree.TreeStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Tree hardwareTree =
 *         Tree.create("HARDWARE")
 *             .setToggleTarget(ToggleTarget.ICON)
 *             .addItemClickListener((treeItem) -&gt; DomGlobal.console.info(treeItem.getValue()))
 *             .appendChild(
 *                 TreeItem.create("Computer", Icons.laptop())
 *                     .addClickListener((evt) -&gt; Notification.create("Computer").show()))
 *             .appendChild(
 *                 TreeItem.create("Headset", Icons.headset())
 *                     .addClickListener((evt) -&gt; Notification.create("Headset").show()))
 *             .appendChild(
 *                 TreeItem.create("Keyboard", Icons.keyboard())
 *                     .addClickListener((evt) -&gt; Notification.create("Keyboard").show()))
 *             .appendChild(
 *                 TreeItem.create("Mouse", Icons.mouse())
 *                     .addClickListener((evt) -&gt; Notification.create("Mouse").show()))
 *             .addSeparator()
 *             .appendChild(
 *                 TreeItem.create("Laptop", Icons.laptop())
 *                     .addClickListener((evt) -&gt; Notification.create("Laptop").show()))
 *             .appendChild(
 *                 TreeItem.create("Smart phone", Icons.cellphone())
 *                     .addClickListener((evt) -&gt; Notification.create("Smart phone").show()))
 *             .appendChild(
 *                 TreeItem.create("Tablet", Icons.tablet())
 *                     .addClickListener((evt) -&gt; Notification.create("Tablet").show()))
 *             .appendChild(
 *                 TreeItem.create("Speaker", Icons.speaker())
 *                     .addClickListener((evt) -&gt; Notification.create("Speaker").show()));
 * </pre>
 *
 * @param <T> the type of the object
 * @see BaseDominoElement
 * @see TreeParent
 * @author vegegoku
 * @version $Id: $Id
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
  private DivElement bodyElement;
  private UListElement subTree;
  private LazyChild<TreeHeader> headerElement;
  private LazyChild<PostfixAddOn<?>> searchIcon;
  private TreeItemIconSupplier<T> iconSupplier;
  private boolean selectionListenersPaused;
  private final Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>>
      selectionListeners = new HashSet<>();
  private final Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>>
      deselectionListeners = new HashSet<>();

  /** Constructor for Tree. */
  public Tree() {
    element =
        div()
            .addCss(dui_tree)
            .appendChild(
                bodyElement =
                    div().addCss(dui_tree_body).appendChild(subTree = ul().addCss(dui_tree_nav)));
    headerElement = LazyChild.of(TreeHeader.create(), element);
    init(this);
  }

  /**
   * Constructor for Tree.
   *
   * @param treeTitle a {@link java.lang.String} object
   */
  public Tree(String treeTitle) {
    this();
    headerElement.get().setTitle(treeTitle);
  }

  /**
   * Constructor for Tree.
   *
   * @param treeTitle a {@link java.lang.String} object
   * @param value a T object
   */
  public Tree(String treeTitle, T value) {
    this(treeTitle);
    this.value = value;
  }

  /**
   * create.
   *
   * @param title the title of the tree
   * @param value the default selected value
   * @param <T> the type of the object
   * @return new instance
   */
  public static <T> Tree<T> create(String title, T value) {
    return new Tree<>(title, value);
  }

  /**
   * create.
   *
   * @param title the default selected value
   * @param <T> the type of the object
   * @return new instance
   */
  public static <T> Tree<T> create(String title) {
    return new Tree<>(title);
  }

  /**
   * create.
   *
   * @param <T> the type of the object
   * @return new instance
   */
  public static <T> Tree<T> create() {
    return new Tree<>();
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLElement getAppendTarget() {
    return subTree.element();
  }

  /**
   * Adds a new tree item
   *
   * @param treeItem a new {@link org.dominokit.domino.ui.tree.TreeItem}
   * @return same instance
   */
  public Tree<T> appendChild(TreeItem<T> treeItem) {
    super.appendChild(treeItem.element());
    treeItem.setParent(this);
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

  /**
   * setTreeItemIconSupplier.
   *
   * @param iconSupplier a {@link org.dominokit.domino.ui.tree.Tree.TreeItemIconSupplier} object
   * @return a {@link org.dominokit.domino.ui.tree.Tree} object
   */
  public Tree<T> setTreeItemIconSupplier(TreeItemIconSupplier<T> iconSupplier) {
    this.iconSupplier = iconSupplier;
    if (nonNull(this.iconSupplier)) {
      subItems.forEach(
          item -> {
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
   * @param toggleTarget the {@link org.dominokit.domino.ui.tree.ToggleTarget}
   * @return same instance
   */
  public Tree<T> setToggleTarget(ToggleTarget toggleTarget) {
    if (nonNull(toggleTarget)) {
      subItems.forEach(item -> item.setToggleTarget(toggleTarget));
      this.toggleTarget = toggleTarget;
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> getActiveItem() {
    return activeTreeItem;
  }

  /** {@inheritDoc} */
  @Override
  public void setActiveItem(TreeItem<T> activeItem) {
    setActiveItem(activeItem, false);
  }

  /** {@inheritDoc} */
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
          .ifPresent(
              item -> {
                triggerDeselectionListeners(item, activeItem);
                item.triggerDeselectionListeners(item, activeItem);
              });
    }
  }

  /** @return the header element */
  /**
   * getHeader.
   *
   * @return a {@link org.dominokit.domino.ui.tree.TreeHeader} object
   */
  public TreeHeader getHeader() {
    return headerElement.get();
  }

  /** @return the root element */
  /**
   * Getter for the field <code>subTree</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.UListElement} object
   */
  public UListElement getSubTree() {
    return subTree;
  }

  /** @return the title element */
  /**
   * getTitle.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SpanElement} object
   */
  public SpanElement getTitle() {
    return headerElement.get().getTitle();
  }

  /**
   * Enables the search
   *
   * @return same instance
   * @param searchable a boolean
   */
  public Tree<T> setSearchable(boolean searchable) {
    if (searchable) {

      if (isNull(search)) {
        search =
            LazyChild.of(
                Search.create(true).onSearch(Tree.this::filter).onClose(this::clearFilter),
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
                              subItems.stream()
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
   * @param foldingEnabled a boolean
   */
  public Tree<T> setFoldable(boolean foldingEnabled) {
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
    return this;
  }

  /** Expand all items */
  public void expandAll() {
    getSubItems().forEach(TreeItem::expandAll);
  }

  /** Collapse all items */
  public void collapseAll() {
    getSubItems().forEach(TreeItem::collapseAll);
  }

  /** Deactivate all items */
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

  /** {@inheritDoc} */
  @Override
  public boolean isAutoExpandFound() {
    return autoExpandFound;
  }

  /**
   * Sets if the items found by the search should be expanded automatically
   *
   * @param autoExpandFound true to expand automatically, false otherwise
   * @return a {@link org.dominokit.domino.ui.tree.Tree} object
   */
  public Tree<T> setAutoExpandFound(boolean autoExpandFound) {
    this.autoExpandFound = autoExpandFound;
    return this;
  }

  /** Clears all the filters */
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

  /** {@inheritDoc} */
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

  /**
   * setIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.tree.Tree} object
   */
  public Tree<T> setIcon(Icon<?> icon) {
    headerElement.get().setIcon(icon);
    return this;
  }

  /** @return true if deactivated items should be collapsed automatically */
  /**
   * isAutoCollapse.
   *
   * @return a boolean
   */
  public boolean isAutoCollapse() {
    return autoCollapse;
  }

  /** {@inheritDoc} */
  @Override
  public List<TreeItem<T>> getSubItems() {
    return new ArrayList<>(subItems);
  }

  /** {@inheritDoc} */
  @Override
  public TreeParent<T> expandNode(boolean expandParent) {
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeParent<T> expandNode() {
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Optional<TreeParent<T>> getParent() {
    return Optional.empty();
  }

  /** {@inheritDoc} */
  @Override
  public void activate() {}

  /** {@inheritDoc} */
  @Override
  public void activate(boolean activateParent) {}

  /** @return the search element */
  /**
   * Getter for the field <code>search</code>.
   *
   * @return a {@link java.util.Optional} object
   */
  public Optional<Search> getSearch() {
    if (nonNull(search) && search.isInitialized()) {
      return Optional.ofNullable(search.get());
    }
    return Optional.empty();
  }

  /** @return the search icon */
  /**
   * Getter for the field <code>searchIcon</code>.
   *
   * @return a {@link java.util.Optional} object
   */
  public Optional<PostfixAddOn<?>> getSearchIcon() {
    if (nonNull(searchIcon) && search.isInitialized()) {
      return Optional.of(searchIcon.get());
    }
    return Optional.empty();
  }

  /** @return the collapse all icon */
  /**
   * Getter for the field <code>collapseExpandAllIcon</code>.
   *
   * @return a {@link java.util.Optional} object
   */
  public Optional<PostfixAddOn<?>> getCollapseExpandAllIcon() {
    if (nonNull(collapseExpandAllIcon) && collapseExpandAllIcon.isInitialized()) {
      return Optional.of(collapseExpandAllIcon.get());
    }
    return Optional.empty();
  }

  /** @return the current value */
  /**
   * Getter for the field <code>value</code>.
   *
   * @return a T object
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

  /** @return the list of the items in the current active path */
  /**
   * getActivePath.
   *
   * @return a {@link java.util.List} object
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

  /** @return the list of values in the current active path */
  /**
   * getActivePathValues.
   *
   * @return a {@link java.util.List} object
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

  /** {@inheritDoc} */
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
   * @param filter a {@link org.dominokit.domino.ui.tree.TreeItemFilter}
   * @return same instance
   */
  public Tree<T> setFilter(TreeItemFilter<TreeItem<T>> filter) {
    this.filter = filter;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItemFilter<TreeItem<T>> getFilter() {
    return this.filter;
  }

  /** {@inheritDoc} */
  public Tree<T> setCollapseStrategy(CollapseStrategy collapseStrategy) {
    getSubItems().forEach(tTreeItem -> setCollapseStrategy(collapseStrategy));
    this.collapseStrategy = collapseStrategy;
    return this;
  }

  /**
   * Getter for the field <code>collapseStrategy</code>.
   *
   * @return a {@link org.dominokit.domino.ui.collapsible.CollapseStrategy} object
   */
  public CollapseStrategy getCollapseStrategy() {
    return collapseStrategy;
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.tree.Tree} object
   */
  public Tree<T> withHeader(ChildHandler<Tree<T>, TreeHeader> handler) {
    handler.apply(this, headerElement.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> getSelectionListeners() {
    return this.selectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>>
      getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> triggerSelectionListeners(TreeItem<T> source, TreeItem<T> selection) {
    if (!this.selectionListenersPaused) {
      this.selectionListeners.forEach(
          listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> triggerDeselectionListeners(TreeItem<T> source, TreeItem<T> selection) {
    if (!this.selectionListenersPaused) {
      this.deselectionListeners.forEach(
          listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> getSelection() {
    return this.activeTreeItem;
  }

  /** {@inheritDoc} */
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
