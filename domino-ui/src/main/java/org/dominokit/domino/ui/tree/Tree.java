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
import static org.dominokit.domino.ui.tree.TreeStyles.*;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import org.dominokit.domino.ui.collapsible.CollapseStrategy;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.search.Search;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.dominokit.domino.ui.utils.TreeNode;

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
 *             .addChangeHandler((treeItem) -&gt; DomGlobal.console.info(treeItem.getValue()))
 *             .addChangeHandler((treeItem) -&gt; Notification.create(treeItem.getTitle()).show()))
 *             .appendChild(TreeItem.create("Computer", Icons.ALL.laptop_mdi()))
 *             .appendChild(TreeItem.create("Headset", Icons.ALL.headset_mdi()))
 *             .appendChild(TreeItem.create("Keyboard", Icons.ALL.keyboard_mdi()))
 *             .appendChild(TreeItem.create("Mouse", Icons.ALL.mouse_mdi()))
 *             .addSeparator()
 *             .appendChild(TreeItem.create("Laptop", Icons.ALL.laptop_mdi()))
 *             .appendChild(TreeItem.create("Smart phone", Icons.ALL.cellphone_mdi()))
 *             .appendChild(TreeItem.create("Tablet", Icons.ALL.tablet_mdi()))
 *             .appendChild(TreeItem.create("Speaker", Icons.ALL.speaker_mdi()));
 * </pre>
 *
 * @param <T> the type of the object
 * @see BaseDominoElement
 */
public class Tree<T> extends BaseDominoElement<HTMLDivElement, Tree<T>>
    implements TreeNode, HasChangeHandlers<Tree<T>, TreeItem<T>> {

  private final HTMLElement title = DominoElement.of(span()).css(TITLE).element();
  private ToggleTarget toggleTarget = ToggleTarget.ANY;

  private Function<String, Predicate<TreeNode>> filter;

  @Deprecated
  private TreeItemFilter<TreeItem<T>> filterOld =
      (treeItem, searchToken) ->
          treeItem.getTitle().toLowerCase().contains(searchToken.toLowerCase());

  private final HTMLLIElement header =
      DominoElement.of(li()).css(HEADER).css(MENU_HEADER).add(title).element();

  private final HTMLUListElement root = DominoElement.of(ul()).add(header).css(LIST).element();

  private final HTMLDivElement menu =
      DominoElement.of(div()).style("overflow-x: hidden").css(MENU).add(root).element();

  /* The real active tree item, not necessary being a direct child but well a descendant of the tree. */
  private TreeItem<T> activeTreeItem;

  private boolean autoCollapse = true;
  private final List<TreeItem<T>> childTreeItems = new ArrayList<>();
  private boolean autoExpandFound;
  private ColorScheme colorScheme;
  private Search search;
  private Icon searchIcon;
  private Icon collapseAllIcon;
  private Icon expandAllIcon;
  private int levelPadding = 15;

  private T value;

  private final List<ChangeHandler<? super TreeItem<T>>> changeHandlers = new ArrayList<>();
  @Deprecated private final List<ItemClickListener<T>> itemsClickListeners = new ArrayList<>();
  private CollapseStrategy collapseStrategy;

  public Tree() {
    this("");
  }

  public Tree(String treeTitle) {
    init(this);
    if (isNull(treeTitle) || treeTitle.trim().isEmpty()) {
      DominoElement.of(header).hide();
    }
    title.textContent = treeTitle;
  }

  public Tree(String treeTitle, T value) {
    this(treeTitle);
    this.value = value;
  }

  public Tree(T value) {
    this("");
    this.value = value;
  }

  /**
   * @param title the title of the tree
   * @return new instance
   */
  public static Tree<String> create(String title) {
    return new Tree<>(title);
  }

  /** @return new instance without title */
  public static Tree<String> create() {
    Tree<String> tree = new Tree<>();
    DominoElement.of(tree.header).hide();
    return tree;
  }

  /**
   * @param title the title of the tree
   * @param value the default selected value
   * @param <T> the type of the object
   * @return new instance
   */
  public static <T> Tree<T> create(String title, T value) {
    return new Tree<>(title, value);
  }

  /**
   * @param value the default selected value
   * @param <T> the type of the object
   * @return new instance
   */
  public static <T> Tree<T> create(T value) {
    return new Tree<>(value);
  }

  /**
   * Adds a new tree item
   *
   * @param treeItem a new {@link TreeItem}
   * @return same instance
   * @deprecated use {@link #appendChild(TreeNode)} instead
   */
  @Deprecated
  public Tree<T> appendChild(TreeItem<T> treeItem) {
    appendChild((TreeNode) treeItem);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeNode appendChild(TreeNode node) {
    TreeItem<T> treeItem = (TreeItem<T>) node;
    root.appendChild(treeItem.element());
    treeItem.setParent(this);
    treeItem.setLevel(1);
    treeItem.setLevelPadding(levelPadding);
    treeItem.setToggleTarget(this.toggleTarget);
    if (nonNull(collapseStrategy)) {
      treeItem.setCollapseStrategy(collapseStrategy);
    }
    this.childTreeItems.add(treeItem);
    return node;
  }

  /**
   * Adds a new separator
   *
   * @return same instance
   */
  public Tree<T> addSeparator() {
    root.appendChild(DominoElement.of(li()).css("gap").css("separator").add(a()).element());
    return this;
  }

  /**
   * Adds spaces between items
   *
   * @return same instance
   */
  public Tree<T> addGap() {
    root.appendChild(DominoElement.of(li()).css("gap").add(a()).element());
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
      childTreeItems.forEach(item -> item.setToggleTarget(toggleTarget));
      this.toggleTarget = toggleTarget;
    }
    return this;
  }

  /**
   * Sets level padding for item
   *
   * @param levelPadding string with padding for item
   * @return same instance
   */
  public Tree<T> setLevelPadding(int levelPadding) {
    this.levelPadding = levelPadding;
    childTreeItems.forEach(item -> item.setLevelPadding(levelPadding));

    return this;
  }

  /**
   * Sets the color scheme for the tree
   *
   * @param colorScheme the {@link ColorScheme}
   * @return same instance
   */
  public Tree<T> setColorScheme(ColorScheme colorScheme) {
    if (nonNull(this.colorScheme)) {
      removeCss(colorScheme.color().getBackground());
      DominoElement.of(header).removeCss(this.colorScheme.darker_3().getBackground());
    }
    this.colorScheme = colorScheme;

    addCss(colorScheme.color().getBackground());
    DominoElement.of(header).addCss(this.colorScheme.darker_3().getBackground());
    return this;
  }

  /** @return the current active tree item */
  public TreeItem<T> getActiveItem() {
    return activeTreeItem;
  }

  /**
   * Activates the given tree item
   *
   * @param activeItem the tree item to activate
   */
  public void setActiveItem(TreeItem<T> activeItem) {
    setActiveItem(activeItem, false);
  }

  /**
   * Activates the given tree item
   *
   * @param activeTreeItem the tree item to activate
   * @param silent true to not notify change handlers
   */
  public void setActiveItem(TreeItem<T> activeTreeItem, boolean silent) {
    // The contains operation is not cheap, check it only by debug mode when assert is enabled.
    assert contains(activeTreeItem);

    if (Objects.equals(this.activeTreeItem, activeTreeItem)) return;

    if (nonNull(this.activeTreeItem)) this.activeTreeItem.deactivate(autoCollapse);

    this.activeTreeItem = activeTreeItem;

    iterateActiveTreeItem(TreeItem::activate);

    if (!silent) {
      changeHandlers.forEach(changeHandler -> changeHandler.onValueChanged(this.activeTreeItem));
      /* Backward compatibility, can be deleted if deprecated interface/method is removed in new release. */
      itemsClickListeners.forEach(
          itemClickListener -> itemClickListener.onTreeItemClicked(this.activeTreeItem));
    }
  }

  protected void iterateTreeItem(TreeNode treeNode, Consumer<TreeItem<T>> consumer) {
    while (treeNode instanceof TreeItem) {
      consumer.accept((TreeItem<T>) treeNode);

      treeNode = treeNode.getParentNode();
    }
  }

  protected void iterateActiveTreeItem(Consumer<TreeItem<T>> consumer) {
    iterateTreeItem(activeTreeItem, consumer);
  }

  /** @return the header element */
  public DominoElement<HTMLLIElement> getHeader() {
    return DominoElement.of(header);
  }

  /** @return the root element */
  public DominoElement<HTMLUListElement> getRoot() {
    return DominoElement.of(root);
  }

  /** @return the title element */
  public DominoElement<HTMLElement> getTitle() {
    return DominoElement.of(title);
  }

  /**
   * Sets the height of the tree to be automatic based on the content
   *
   * @return same instance
   */
  public Tree<T> autoHeight() {
    root.style.height = CSSProperties.HeightUnionType.of("calc(100vh - 83px)");
    element().style.height = CSSProperties.HeightUnionType.of("calc(100vh - 70px)");
    return this;
  }

  /**
   * Sets the height of the tree to be automatic based on the content with an offset
   *
   * @param offset the offset value
   * @return same instance
   */
  public Tree<T> autoHeight(int offset) {
    root.style.height = CSSProperties.HeightUnionType.of("calc(100vh - " + offset + 13 + "px)");
    element().style.height = CSSProperties.HeightUnionType.of("calc(100vh - " + offset + "px)");
    return this;
  }

  /**
   * Enables the search
   *
   * @return same instance
   */
  public Tree<T> enableSearch() {
    search =
        Search.create(true)
            .styler(style -> style.setHeight(Unit.px.of(40)))
            .onSearch(Tree.this::filter)
            .onClose(this::clearFilter);

    searchIcon =
        Icons.ALL
            .search()
            .setMarginBottom("0px")
            .setMarginTop("0px")
            .addCss(Styles.pull_right)
            .setCssProperty("cursor", "pointer");

    this.header.appendChild(search.element());
    this.header.appendChild(searchIcon.element());
    searchIcon.element().addEventListener("click", evt -> search.open());

    return this;
  }

  /**
   * Adds the ability to expand/collapse all items
   *
   * @return same instance
   */
  public Tree<T> enableFolding() {
    collapseAllIcon =
        Icons.ALL
            .fullscreen_exit()
            .setMarginBottom("0px")
            .setMarginTop("0px")
            .addCss(Styles.pull_right)
            .setCssProperty("cursor", "pointer");

    collapseAllIcon.element().addEventListener("click", evt -> collapseAll());

    expandAllIcon =
        Icons.ALL
            .fullscreen()
            .setMarginBottom("0px")
            .setMarginTop("0px")
            .addCss(Styles.pull_right)
            .setCssProperty("cursor", "pointer");

    expandAllIcon.element().addEventListener("click", evt -> expandAll());

    header.appendChild(expandAllIcon.element());
    header.appendChild(collapseAllIcon.element());
    return this;
  }

  /** Expand all items */
  public void expandAll() {
    getChildNodes().forEach(TreeItem::expandAll);
  }

  /** Collapse all items */
  public void collapseAll() {
    getChildNodes().forEach(TreeItem::collapseAll);
  }

  /** Deactivate all items */
  public void deactivateAll() {
    getChildNodes().forEach(subItem -> subItem.deactivate(autoCollapse));
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

  /** @return true if automatic expanding is enabled when finding items in search */
  public boolean isAutoExpandFound() {
    return autoExpandFound;
  }

  /**
   * Sets if the items found by the search should be expanded automatically
   *
   * @param autoExpandFound true to expand automatically, false otherwise
   */
  public void setAutoExpandFound(boolean autoExpandFound) {
    this.autoExpandFound = autoExpandFound;
  }

  /** Clears all the filters */
  public void clearFilter() {
    childTreeItems.forEach(TreeItem::clearFilter);
  }

  /**
   * Find any descendant tree item matching the given item value
   *
   * @param value a value being searched
   * @return an {@code Optional} tree item matching the given item value
   */
  public Optional<TreeItem<T>> find(T value) {
    return findAny(item -> Objects.equals(value, ((TreeItem<?>) item).getValue()));
  }

  /**
   * Filter based on the search query
   *
   * @param searchToken the query
   */
  public void filter(String searchToken) {
    Predicate<TreeNode> predicate = createFilter(searchToken);
    childTreeItems.forEach(treeItem -> treeItem.filter(predicate));
  }

  /** @deprecated no replacement */
  @Deprecated
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
    getTitle().setTextContent(title);
    if (getHeader().isCollapsed()) {
      getHeader().show();
    }
    return this;
  }

  /** @return true if deactivated items should be collapsed automatically */
  public boolean isAutoCollapse() {
    return autoCollapse;
  }

  /**
   * @deprecated use {@link #getChildNodes()} instead
   * @return the children of this item
   */
  @Deprecated
  public List<TreeItem<T>> getSubItems() {
    return getChildNodes();
  }

  /** @deprecated no replacement */
  @Deprecated
  public Tree<T> expand(boolean expandParent) {
    return this;
  }

  /** @deprecated no replacement */
  @Deprecated
  public Tree<T> expand() {
    return this;
  }

  /** @deprecated no replacement */
  @Deprecated
  public Optional<TreeItem<T>> getParent() {
    return Optional.empty();
  }

  /** @deprecated no replacement */
  @Deprecated
  public void activate() {}

  /** @deprecated no replacement */
  @Deprecated
  public void activate(boolean activateParent) {}

  /** @return the search element */
  public Search getSearch() {
    return search;
  }

  /** @return the search icon */
  public Icon getSearchIcon() {
    return searchIcon;
  }

  /** @return the collapse all icon */
  public Icon getCollapseAllIcon() {
    return collapseAllIcon;
  }

  /** @return the expand all icon */
  public Icon getExpandAllIcon() {
    return expandAllIcon;
  }

  /** @return the current value */
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
   * Adds a click listener to be called when item is clicked
   *
   * @param itemClickListener a {@link ItemClickListener}
   * @return same instance
   * @deprecated use {@link HasChangeHandlers#addChangeHandler(ChangeHandler)} instead
   */
  @Deprecated
  public Tree<T> addItemClickListener(ItemClickListener<T> itemClickListener) {
    this.itemsClickListeners.add(itemClickListener);
    return this;
  }

  /**
   * Removes a click listener
   *
   * @param itemClickListener a {@link ItemClickListener} to be removed
   * @return same instance
   * @deprecated use {@link HasChangeHandlers#removeChangeHandler(ChangeHandler)} instead
   */
  @Deprecated
  public Tree<T> removeItemClickListener(ItemClickListener<T> itemClickListener) {
    this.itemsClickListeners.remove(itemClickListener);
    return this;
  }

  /** @return the list of the items in the current active path */
  public List<TreeItem<T>> getActivePath() {
    List<TreeItem<T>> activeItems = getActiveBubblingPath();

    Collections.reverse(activeItems);

    return activeItems;
  }

  /**
   * @return the list of the items in the current active path, from inner tree item to outermost
   *     tree item
   */
  public List<TreeItem<T>> getActiveBubblingPath() {
    return getBubblingPath(activeTreeItem);
  }

  /**
   * @param treeNode the start item, inclusive.
   * @return the list of the items in the current active path, from inner tree item to outermost
   *     tree item
   */
  public List<TreeItem<T>> getBubblingPath(TreeNode treeNode) {
    List<TreeItem<T>> activeItems = new ArrayList<>();

    iterateTreeItem(treeNode, activeItems::add);

    return activeItems;
  }

  /** @return the list of values in the current active path */
  public List<T> getActivePathValues() {
    List<T> activeValues = getBubblingPathValues(activeTreeItem);

    Collections.reverse(activeValues);

    return activeValues;
  }

  /**
   * @param treeNode the start item, inclusive.
   * @return the list of values in the current active path, from inner tree item value to outermost
   *     tree item value
   */
  public List<T> getBubblingPathValues(TreeNode treeNode) {
    List<T> activeValues = new ArrayList<>();

    iterateTreeItem(treeNode, item -> activeValues.add(item.getValue()));

    return activeValues;
  }

  /** Clear all direct children of the tree, effectively reset the tree */
  public void clear() {
    childTreeItems.forEach(TreeItem::remove);
    childTreeItems.clear();

    setActiveItem(null);
  }

  /**
   * Removes item
   *
   * @param item the item value
   * @deprecated use {@link #removeChild(TreeNode)} instead
   */
  @Deprecated
  public void removeItem(TreeItem<T> item) {
    removeChild((TreeNode) item);
  }

  /** {@inheritDoc} */
  @Override
  public TreeNode removeChild(TreeNode node) {
    // Remember the current active path of the tree
    List<TreeItem<T>> activePath = getActiveBubblingPath();

    if (getChildNodes().remove(node)) {
      // Update HTML DOM
      ((TreeItem<?>) node).remove();

      // Either the node being removed or one of its descendants is the active tree item of the
      // tree. Since the node is removed and its parent node is self this tree, we should announce
      // that there is no more active tree item at this moment.
      if (activePath.contains(node)) setActiveItem(null);
    }

    return node;
  }

  /**
   * Sets the filter that will be used when searching items, the default filter searches using the
   * title of the items
   *
   * @param filter a {@link TreeItemFilter}
   * @return same instance
   * @deprecated use {@link #setFilter(Function)}} instead
   */
  @Deprecated
  public Tree<T> setFilter(TreeItemFilter<TreeItem<T>> filter) {
    this.filterOld = filter;
    return this;
  }

  public Tree<T> setFilter(Function<String, Predicate<TreeNode>> filterCreator) {
    this.filter = filterCreator;
    return this;
  }

  /**
   * @return the {@link TreeItemFilter}
   * @deprecated use {@link #createFilter(String)} instead
   */
  @Deprecated
  public TreeItemFilter<TreeItem<T>> getFilter() {
    return this.filterOld;
  }

  public Predicate<TreeNode> createFilter(String searchToken) {
    if (filter == null)
      return treeNode ->
          ((TreeItem<?>) treeNode).getTitle().toLowerCase().contains(searchToken.toLowerCase());

    return filter.apply(searchToken);
  }

  public Tree<T> setCollapseStrategy(CollapseStrategy collapseStrategy) {
    getChildNodes().forEach(tTreeItem -> setCollapseStrategy(collapseStrategy));
    this.collapseStrategy = collapseStrategy;
    return this;
  }

  public CollapseStrategy getCollapseStrategy() {
    return collapseStrategy;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return menu;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> addChangeHandler(ChangeHandler<? super TreeItem<T>> changeHandler) {
    changeHandlers.add(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> removeChangeHandler(ChangeHandler<? super TreeItem<T>> changeHandler) {
    changeHandlers.remove(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeHandler(ChangeHandler<? super TreeItem<T>> changeHandler) {
    return changeHandlers.contains(changeHandler);
  }

  /** {@inheritDoc} */
  @Override
  public TreeNode getParentNode() {
    // A tree instance does not have a parent node
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public List<TreeItem<T>> getChildNodes() {
    return childTreeItems;
  }

  /**
   * A listener to be called when clicking on item
   *
   * @param <T> the type of the object
   * @deprecated use {@link ChangeHandler#onValueChanged(Object)} instead
   */
  @Deprecated
  public interface ItemClickListener<T> {
    void onTreeItemClicked(TreeItem<T> treeItem);
  }
}
