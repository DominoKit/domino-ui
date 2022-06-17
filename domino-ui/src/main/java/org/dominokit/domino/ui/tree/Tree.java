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
 */
public class Tree<T> extends BaseDominoElement<HTMLDivElement, Tree<T>>
    implements TreeNode<TreeItem<T>>, HasChangeHandlers<Tree<T>, TreeItem<T>> {

  private final HTMLElement title = DominoElement.of(span()).css(TITLE).element();
  private ToggleTarget toggleTarget = ToggleTarget.ANY;
  private TreeItemFilter<TreeItem<T>> filter =
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
   */
  public Tree<T> appendChild(TreeItem<T> treeItem) {
    root.appendChild(treeItem.element());
    treeItem.setParent(this);
    treeItem.setLevel(1);
    treeItem.setLevelPadding(levelPadding);
    treeItem.setToggleTarget(this.toggleTarget);
    if (nonNull(collapseStrategy)) {
      treeItem.setCollapseStrategy(collapseStrategy);
    }
    this.childTreeItems.add(treeItem);
    return this;
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

  /** @return The current active value */
  public TreeItem<T> getActiveItem() {
    return activeTreeItem;
  }

  /**
   * Activates the item representing the value
   *
   * @param activeItem the value of the item to activate
   */
  public void setActiveItem(TreeItem<T> activeItem) {
    setActiveItem(activeItem, false);
  }

  /**
   * Activates the activeTreeItem representing the value
   *
   * @param activeTreeItem the value of the activeTreeItem to activate
   * @param silent true to not notify listeners
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
    do {
      consumer.accept((TreeItem<T>) treeNode);
    } while ((treeNode = treeNode.getParentNode()) instanceof TreeItem);
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
   * Filter based on the search query
   *
   * @param searchToken the query
   */
  public void filter(String searchToken) {
    childTreeItems.forEach(treeItem -> treeItem.filter(searchToken, getFilter()));
  }

  /** @deprecated No replacement */
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
   * @deprecated Use {@link #getChildNodes()} instead
   * @return the children of this item
   */
  @Deprecated
  public List<TreeItem<T>> getSubItems() {
    return getChildNodes();
  }

  /** @deprecated No replacement */
  @Deprecated
  public Tree<T> expand(boolean expandParent) {
    return this;
  }

  /** @deprecated No replacement */
  @Deprecated
  public Tree<T> expand() {
    return this;
  }

  /** @deprecated No replacement */
  @Deprecated
  public Optional<TreeItem<T>> getParent() {
    return Optional.empty();
  }

  /** @deprecated No replacement */
  @Deprecated
  public void activate() {}

  /** @deprecated No replacement */
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
   * @deprecated Use {@link HasChangeHandlers#addChangeHandler(ChangeHandler)} instead
   * @param itemClickListener a {@link ItemClickListener}
   * @return same instance
   */
  @Deprecated
  public Tree<T> addItemClickListener(ItemClickListener<T> itemClickListener) {
    this.itemsClickListeners.add(itemClickListener);
    return this;
  }

  /**
   * Removes a click listener
   *
   * @deprecated Use {@link HasChangeHandlers#removeChangeHandler(ChangeHandler)} instead
   * @param itemClickListener a {@link ItemClickListener} to be removed
   * @return same instance
   */
  @Deprecated
  public Tree<T> removeItemClickListener(ItemClickListener<T> itemClickListener) {
    this.itemsClickListeners.remove(itemClickListener);
    return this;
  }

  /** @return the list of the items in the current active path */
  public List<TreeItem<T>> getActivePath() {
    List<TreeItem<T>> activeItems = getBubblingPath(activeTreeItem);

    Collections.reverse(activeItems);

    return activeItems;
  }

  /**
   * @param treeNode The start item, inclusive.
   * @return the list of the items in the current active path, from inner TreeItem to outermost
   *     TreeItem
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
   * @param treeNode The start item, inclusive.
   * @return the list of values in the current active path, from inner TreeItem value to outermost
   *     TreeItem value
   */
  public List<T> getBubblingPathValues(TreeNode treeNode) {
    List<T> activeValues = new ArrayList<>();

    iterateTreeItem(treeNode, item -> activeValues.add(item.getValue()));

    return activeValues;
  }

  /** Clear all direct children of the tree, effectively reset the tree */
  public void clear() {
    childTreeItems.stream().forEach(TreeItem::remove);
    childTreeItems.clear();
  }

  /**
   * Removes item
   *
   * @deprecated Use {@link #removeChild(TreeItem<T>)} instead
   * @param item the item value
   */
  @Deprecated
  public void removeItem(TreeItem<T> item) {
    removeChild(item);
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> removeChild(TreeItem<T> node) {
    getChildNodes().remove(node);

    return node.remove();
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

  /** @return the {@link TreeItemFilter} */
  public TreeItemFilter<TreeItem<T>> getFilter() {
    return this.filter;
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

  @Override
  public TreeNode<TreeItem<T>> getParentNode() {
    // A tree instance does not have a parent node
    return null;
  }

  @Override
  public List<TreeItem<T>> getChildNodes() {
    return childTreeItems;
  }

  /**
   * A listener to be called when clicking on item
   *
   * @deprecated Use {@link ChangeHandler#onValueChanged(Object)} instead
   * @param <T> the type of the object
   */
  @Deprecated
  public interface ItemClickListener<T> {
    void onTreeItemClicked(TreeItem<T> treeItem);
  }
}
