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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import java.util.*;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.TreeConfig;
import org.dominokit.domino.ui.elements.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.StateChangeIcon;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.utils.*;

/**
 * Represents a tree item in a tree structure.
 *
 * <p>TreeItem is a component that can be used to build hierarchical tree structures. Each tree item
 * can have child tree items, and they can be expanded or collapsed. TreeItem supports icons,
 * selection, and filtering.
 *
 * <p>Usage example:
 *
 * <pre>
 * // Create a tree item with an icon and title
 * TreeItem<String> treeItem = new TreeItem<>(Icon.create("folder"), "Folder 1");
 *
 * // Add child tree items
 * TreeItem<String> childItem1 = TreeItem.create("Child 1");
 * TreeItem<String> childItem2 = TreeItem.create("Child 2");
 * treeItem.appendChild(childItem1);
 * treeItem.appendChild(childItem2);
 * </pre>
 *
 * @see BaseDominoElement
 */
public class TreeItem<T> extends BaseDominoElement<HTMLLIElement, TreeItem<T>>
    implements TreeParent<T>,
        CanActivate,
        CanDeactivate,
        HasClickableElement,
        TreeStyles,
        HasComponentConfig<TreeConfig>,
        HasSelectionListeners<TreeItem<T>, TreeItem<T>, TreeItem<T>> {

  private String title;
  private LIElement element;
  private final AnchorElement anchorElement;
  private final DivElement contentElement;
  private LazyChild<Icon<?>> itemIcon;
  private final LazyChild<SpanElement> textElement;
  private final List<TreeItem<T>> subItems = new LinkedList<>();
  private TreeItem<T> activeTreeItem;
  private TreeParent<T> parent;
  private final UListElement subTree;

  private T value;

  private ToggleTarget toggleTarget = ToggleTarget.ANY;

  private OriginalState originalState;
  private boolean selectionListenersPaused;
  private Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> selectionListeners =
      new HashSet<>();
  private Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> deselectionListeners =
      new HashSet<>();

  private final EventListener anchorListener =
      evt -> {
        if (ToggleTarget.ANY.equals(this.toggleTarget)) {
          evt.stopPropagation();
          if (isParent()) {
            toggle();
          }
          activateItem();
        }
      };

  private final EventListener iconListener =
      evt -> {
        if (ToggleTarget.ICON.equals(this.toggleTarget)) {
          evt.stopPropagation();
          if (isParent()) {
            toggle();
          }
          activateItem();
        }
      };

  /** Constructs a new TreeItem instance. */
  private TreeItem() {
    this.element =
        li().addCss(dui_tree_item)
            .appendChild(
                anchorElement =
                    a().removeHref()
                        .addCss(dui_tree_anchor)
                        .appendChild(contentElement = div().addCss(dui_tree_item_content)))
            .appendChild(subTree = ul().addCss(dui_tree_nav).hide());
    this.textElement = LazyChild.of(span().addCss(dui_tree_item_text), contentElement);
    init(this);

    setCollapseStrategy(getConfig().getTreeDefaultCollapseStrategy(this).get());
    setAttribute(Collapsible.DUI_COLLAPSED, "true");
  }

  /**
   * Constructs a new TreeItem instance with an icon and title.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param title The title of the tree item.
   */
  public TreeItem(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
    init();
  }

  /**
   * Constructs a new TreeItem instance with a title.
   *
   * @param title The title of the tree item.
   */
  public TreeItem(String title) {
    this();
    setTitle(title);
    init();
  }

  /**
   * Constructs a new TreeItem instance with an icon.
   *
   * @param icon The icon to be displayed for the tree item.
   */
  public TreeItem(Icon<?> icon) {
    this();
    setIcon(icon);
    init();
  }

  /**
   * Constructs a new TreeItem instance with a title and a value.
   *
   * @param title The title of the tree item.
   * @param value The value associated with the tree item.
   */
  public TreeItem(String title, T value) {
    this(title);
    this.value = value;
  }

  /**
   * Constructs a new TreeItem instance with an icon, title, and a value.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param title The title of the tree item.
   * @param value The value associated with the tree item.
   */
  public TreeItem(Icon<?> icon, String title, T value) {
    this(icon, title);
    this.value = value;
  }

  /**
   * Constructs a new TreeItem instance with an icon and a value.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param value The value associated with the tree item.
   */
  public TreeItem(Icon<?> icon, T value) {
    this(icon);
    this.value = value;
  }

  /**
   * Creates a new TreeItem instance with the given title.
   *
   * @param title The title of the tree item.
   * @return A new TreeItem instance with the specified title.
   */
  public static TreeItem<String> create(String title) {
    TreeItem<String> treeItem = new TreeItem<>(title);
    treeItem.value = title;
    return treeItem;
  }

  /**
   * Creates a new TreeItem instance with the given icon and title.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param title The title of the tree item.
   * @return A new TreeItem instance with the specified icon and title.
   */
  public static TreeItem<String> create(Icon<?> icon, String title) {
    TreeItem<String> treeItem = new TreeItem<>(icon, title);
    treeItem.value = title;
    return treeItem;
  }

  /**
   * Creates a new TreeItem instance with the given icon.
   *
   * @param icon The icon to be displayed for the tree item.
   * @return A new TreeItem instance with the specified icon.
   */
  public static TreeItem<String> create(Icon<?> icon) {
    TreeItem<String> treeItem = new TreeItem<>(icon);
    treeItem.value = "";
    return treeItem;
  }

  /**
   * Creates a new TreeItem instance with the given title and value.
   *
   * @param title The title of the tree item.
   * @param value The value associated with the tree item.
   * @param <T> The type of the value.
   * @return A new TreeItem instance with the specified title and value.
   */
  public static <T> TreeItem<T> create(String title, T value) {
    return new TreeItem<>(title, value);
  }

  /**
   * Creates a new TreeItem instance with the given icon, title, and value.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param title The title of the tree item.
   * @param value The value associated with the tree item.
   * @param <T> The type of the value.
   * @return A new TreeItem instance with the specified icon, title, and value.
   */
  public static <T> TreeItem<T> create(Icon<?> icon, String title, T value) {
    return new TreeItem<>(icon, title, value);
  }

  /**
   * Creates a new TreeItem instance with the given icon and value.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param value The value associated with the tree item.
   * @param <T> The type of the value.
   * @return A new TreeItem instance with the specified icon and value.
   */
  public static <T> TreeItem<T> create(Icon<?> icon, T value) {
    return new TreeItem<>(icon, value);
  }

  private void init() {
    addBeforeCollapseListener(() -> updateIcon(true));
    addBeforeExpandListener(() -> updateIcon(false));
    anchorElement.addClickListener(anchorListener);
    applyWaves();
  }

  private void applyWaves() {
    withWaves((item, waves) -> waves.setWaveStyle(WaveStyle.BLOCK));
  }

  private void activateItem() {
    if (nonNull(TreeItem.this.getActiveItem())) {
      TreeItem<T> source = this.activeTreeItem;
      this.activeTreeItem.deactivate();
      this.activeTreeItem = null;
      triggerDeselectionListeners(source, this);
    }
    if (getParent().isPresent()) {
      getParent().get().setActiveItem(this);
      triggerSelectionListeners(this, this);
    } else {
      getTreeRoot().setActiveItem(this);
    }
  }

  /**
   * Appends a child tree item to this tree item.
   *
   * @param treeItem The child tree item to append.
   * @return This tree item with the child tree item appended.
   */
  public TreeItem<T> appendChild(TreeItem<T> treeItem) {
    this.subItems.add(treeItem);
    subTree.appendChild(treeItem);
    treeItem.parent = this;
    treeItem.setToggleTarget(this.toggleTarget);
    updateIcon(isCollapsed());
    getParent()
        .ifPresent(
            p -> {
              if (nonNull(p.getTreeRoot())) {
                Tree.TreeItemIconSupplier<T> iconSupplier = p.getTreeRoot().getIconSupplier();
                if (nonNull(iconSupplier)) {
                  subItems.forEach(item -> item.onSuppliedIconChanged(iconSupplier));
                }
              }
            });
    return this;
  }

  public TreeItem<T> appendChild(TreeItem<T>... treeItems) {
    Arrays.stream(treeItems).forEach(this::appendChild);
    return this;
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(contentElement);
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(contentElement);
  }

  private void updateIcon(boolean collapsed) {
    if (nonNull(itemIcon) && itemIcon.isInitialized()) {
      if (itemIcon.element() instanceof ToggleIcon) {
        ((ToggleIcon<?, ?>) itemIcon.element()).toggle();
      } else if (itemIcon.element() instanceof StateChangeIcon) {
        StateChangeIcon<?, ?> icon = (StateChangeIcon<?, ?>) itemIcon.element();
        if (isParent()) {
          icon.setState(collapsed ? TreeItemIcon.STATE_COLLAPSED : TreeItemIcon.STATE_EXPANDED);
        } else {
          if (dui_active.isAppliedTo(this)) {
            icon.setState(TreeItemIcon.STATE_ACTIVE);
          } else {
            icon.setState(TreeItemIcon.STATE_LEAF);
          }
        }
      }
    }
  }

  /**
   * Adds a separator to this tree item.
   *
   * @return This tree item with a separator added.
   */
  public TreeItem<T> addSeparator() {
    subTree.appendChild(li().addCss(dui_separator));
    return this;
  }

  /**
   * Sets the toggle target for this tree item.
   *
   * @param toggleTarget The toggle target to set.
   * @return This tree item with the toggle target set.
   */
  public TreeItem<T> setToggleTarget(ToggleTarget toggleTarget) {
    if (nonNull(toggleTarget)) {

      this.toggleTarget = toggleTarget;
      if (ToggleTarget.ICON.equals(toggleTarget)) {
        removeWaves();
        if (nonNull(itemIcon) && itemIcon.isInitialized()) {
          itemIcon.get().setClickable(true).addEventListener("click", iconListener, true);
        }
      } else {
        applyWaves();
        if (nonNull(itemIcon) && itemIcon.isInitialized()) {
          itemIcon.get().setClickable(false).removeEventListener("click", iconListener);
          ;
        }
      }

      subItems.forEach(item -> item.setToggleTarget(toggleTarget));
    }
    return this;
  }

  private void toggle() {
    if (isParent()) {
      toggleCollapse();
    }
  }

  /**
   * Expands the tree node represented by this tree item.
   *
   * @return This tree item with the node expanded.
   */
  @Override
  public TreeItem<T> expandNode() {
    return show(false);
  }

  /**
   * Shows the tree node represented by this tree item.
   *
   * @param expandParent {@code true} to expand the parent nodes, {@code false} otherwise.
   * @return This tree item with the node shown.
   */
  public TreeItem<T> show(boolean expandParent) {
    if (isParent()) {
      super.expand();
    }
    if (expandParent) {
      getParent().ifPresent(itemParent -> itemParent.expandNode(true));
    }
    return this;
  }
  /**
   * Expands the tree node represented by this tree item. If the 'expandParent' parameter is true,
   * parent nodes will also be expanded. This method returns the current TreeItem instance.
   *
   * @param expandParent True to expand parent nodes, false to expand only the current node.
   * @return The current TreeItem instance.
   */
  @Override
  public TreeItem<T> expandNode(boolean expandParent) {
    return show(expandParent);
  }

  /**
   * Toggles the collapse/expand state of the tree item. If the tree item is a parent (i.e., it has
   * sub-items), it will toggle its collapse/expand state. This method returns the current TreeItem
   * instance.
   *
   * @return The current TreeItem instance.
   */
  @Override
  public TreeItem<T> toggleCollapse() {
    if (isParent()) {
      super.toggleCollapse();
    }
    return this;
  }

  /**
   * Returns the HTML list item element associated with this tree item.
   *
   * @return The HTML list item element associated with this tree item.
   */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }

  /**
   * Returns the currently active (selected) tree item within the tree structure.
   *
   * @return The currently active TreeItem instance.
   */
  @Override
  public TreeItem<T> getActiveItem() {
    return activeTreeItem;
  }

  /**
   * Returns the root of the tree structure to which this tree item belongs.
   *
   * @return The root Tree instance.
   */
  @Override
  public Tree<T> getTreeRoot() {
    return parent.getTreeRoot();
  }

  /**
   * Returns an optional parent of this tree item. If the parent exists and is a TreeItem, it
   * returns an Optional containing the parent; otherwise, it returns an empty Optional.
   *
   * @return An Optional containing the parent TreeItem or an empty Optional.
   */
  @Override
  public Optional<TreeParent<T>> getParent() {
    if (parent instanceof TreeItem) {
      return Optional.of(parent);
    } else {
      return Optional.empty();
    }
  }

  /**
   * Sets the currently active (selected) tree item within the tree structure.
   *
   * @param activeItem The TreeItem to set as the active item.
   */
  @Override
  public void setActiveItem(TreeItem<T> activeItem) {
    setActiveItem(activeItem, isSelectionListenersPaused());
  }

  /**
   * Sets the currently active (selected) tree item within the tree structure. The 'silent'
   * parameter allows you to control whether triggering selection and deselection listeners should
   * be done silently without notifications. This method returns void.
   *
   * @param activeItem The TreeItem to set as the active item.
   * @param silent True to suppress listener notifications; false to trigger listeners.
   */
  @Override
  public void setActiveItem(TreeItem<T> activeItem, boolean silent) {
    TreeItem<T> source = null;
    if (nonNull(activeItem)) {
      if (nonNull(this.activeTreeItem) && !this.activeTreeItem.equals(activeItem)) {
        source = this.activeTreeItem;
        this.activeTreeItem.deactivate();
      }
      this.activeTreeItem = activeItem;
      this.activeTreeItem.activate();
      getParent().ifPresent(itemParent -> itemParent.setActiveItem(this, true));
      if (!silent) {
        triggerSelectionListeners(activeItem, activeItem);
        getTreeRoot().triggerSelectionListeners(activeItem, activeItem);
        Optional.ofNullable(source)
            .ifPresent(
                item -> {
                  triggerDeselectionListeners(item, activeItem);
                  getTreeRoot().triggerDeselectionListeners(item, activeItem);
                });
      }
    }
  }

  /**
   * Returns the path to this tree item.
   *
   * @return A list of tree items representing the path to this item, starting from the root.
   */
  public List<TreeItem<T>> getPath() {
    List<TreeItem<T>> items = new ArrayList<>();
    items.add(this);
    Optional<TreeParent<T>> parent = getParent();

    while (parent.isPresent()) {
      items.add((TreeItem<T>) parent.get());
      parent = parent.get().getParent();
    }

    Collections.reverse(items);

    return items;
  }

  /**
   * Returns the values associated with the path to this tree item.
   *
   * @return A list of values representing the path to this item, starting from the root.
   */
  public List<T> getPathValues() {
    List<T> values = new ArrayList<>();
    values.add(this.getValue());
    Optional<TreeParent<T>> parent = getParent();

    while (parent.isPresent()) {
      values.add(((TreeItem<T>) parent.get()).getValue());
      parent = parent.get().getParent();
    }

    Collections.reverse(values);

    return values;
  }

  /**
   * Activates (selects) this tree item without activating its parent items. This method returns
   * void.
   */
  @Override
  public void activate() {
    activate(false);
  }

  /**
   * Activates (selects) this tree item. If 'activateParent' is true, it also activates its parent
   * items in the tree structure. This method returns void.
   *
   * @param activateParent True to activate parent items, false to activate only this item.
   */
  @Override
  public void activate(boolean activateParent) {
    addCss(dui_active);
    if (activateParent) {
      getParent().ifPresent(itemParent -> itemParent.setActiveItem(this));
    }
    updateIcon(isCollapsed());
  }

  /**
   * Deactivates (deselects) this tree item and any of its sub-items if it is a parent. If
   * auto-collapse is enabled in the tree root, it will collapse the tree item as well. This method
   * returns void.
   */
  @Override
  public void deactivate() {
    dui_active.remove(this);
    if (isParent()) {
      subItems.forEach(TreeItem::deactivate);
      if (getTreeRoot().isAutoCollapse()) {
        collapse();
      }
    }
    updateIcon(isCollapsed());
  }

  /**
   * Returns the clickable HTML anchor element associated with this tree item.
   *
   * @return The clickable HTML anchor element.
   */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return anchorElement.element();
  }

  /**
   * Sets the icon for this tree item. If the 'icon' parameter is not null, it replaces the existing
   * icon with the new one. This method returns the current TreeItem instance.
   *
   * @param icon The new icon to set.
   * @return The current TreeItem instance.
   */
  public TreeItem<T> setIcon(Icon<?> icon) {
    if (nonNull(itemIcon)) {
      if (itemIcon.isInitialized()) {
        itemIcon.remove();
      }
    }
    itemIcon = LazyChild.of(icon.addCss(dui_tree_item_icon), contentElement);
    itemIcon.whenInitialized(
        () -> {
          itemIcon.element().forEachChild(i -> i.addCss(dui_tree_item_icon));
        });
    itemIcon.whenInitialized(
        () -> {
          if (ToggleTarget.ICON.equals(this.toggleTarget)) {
            itemIcon.element().clickable();
          }
          itemIcon
              .element()
              .addClickListener(
                  evt -> {
                    if (ToggleTarget.ICON.equals(this.toggleTarget)) {
                      evt.stopPropagation();
                      toggle();
                    }
                    activateItem();
                  });
        });
    itemIcon.get();
    updateIcon(isCollapsed());

    return this;
  }

  /**
   * Checks if this tree item is a parent (has sub-items).
   *
   * @return True if this tree item is a parent, false otherwise.
   */
  boolean isParent() {
    return !subItems.isEmpty();
  }

  /**
   * Sets the parent tree node for this tree item.
   *
   * @param parentTree The parent tree node.
   */
  void setParent(TreeParent<T> parentTree) {
    this.parent = parentTree;
  }

  /**
   * Retrieves the title of this tree item.
   *
   * @return The title of this tree item.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Filters this tree item and its children based on a search token.
   *
   * @param searchToken The search token to filter by.
   * @return True if this tree item or any of its children match the search token, false otherwise.
   */
  public boolean filter(String searchToken) {
    boolean found;
    if (isNull(this.originalState)) {
      this.originalState = new OriginalState(isExpanded());
    }

    if (isParent()) {
      found = getFilter().filter(this, searchToken) | filterChildren(searchToken);
    } else {
      found = getFilter().filter(this, searchToken);
    }

    if (found) {
      dui_hidden.remove(this);
      if (isParent() && isAutoExpandFound() && isCollapsed()) {
        this.expandNode();
      }
      return true;
    } else {
      addCss(dui_hidden);
      return false;
    }
  }

  /**
   * Checks if this tree item should be automatically expanded when it's found during a search
   * operation.
   *
   * @return True if this tree item should be automatically expanded when found, false otherwise.
   */
  @Override
  public boolean isAutoExpandFound() {
    return getTreeRoot().isAutoExpandFound();
  }

  /**
   * Clears the filter applied to this tree item and its children, restoring their original state.
   */
  public void clearFilter() {
    if (nonNull(originalState)) {
      if (isExpanded() != originalState.expanded) {
        if (this.equals(this.getTreeRoot().getActiveItem())) {
          this.expandNode();
        } else {
          toggleCollapse(originalState.expanded);
        }
      }
      this.originalState = null;
    }
    dui_hidden.remove(this);
    subItems.forEach(TreeItem::clearFilter);
  }

  /**
   * Filters the children of this tree item based on a search token.
   *
   * @param searchToken The search token to filter children by.
   * @return True if any of the children match the search token, false otherwise.
   */
  public boolean filterChildren(String searchToken) {
    // We use the noneMatch here instead of anyMatch to make sure we are looping all children
    // instead of early exit on first matching one
    return subItems.stream().filter(treeItem -> treeItem.filter(searchToken)).count() > 0;
  }

  /** Collapses all sub-items under this tree item recursively. */
  public void collapseAll() {
    if (isParent() && !isCollapsed()) {
      addCss(dui_transition_none);
      subItems.forEach(TreeItem::collapseAll);
      collapse();
      dui_transition_none.remove(this);
    }
  }

  /** Expands all sub-items under this tree item recursively. */
  public void expandAll() {
    if (isParent() && isCollapsed()) {
      addCss(dui_transition_none);
      this.expandNode();
      subItems.forEach(TreeItem::expandAll);
      dui_transition_none.remove(this);
    }
  }

  /**
   * Retrieves the Waves effect element associated with this tree item.
   *
   * @return The Waves effect element.
   */
  @Override
  public Element getWavesElement() {
    return anchorElement.element();
  }

  /**
   * Checks if this tree item is a leaf (has no sub-items).
   *
   * @return True if this tree item is a leaf, false otherwise.
   */
  public boolean isLeaf() {
    return subItems.isEmpty();
  }

  /**
   * Gets the list of sub-items under this tree item.
   *
   * @return The list of sub-items.
   */
  @Override
  public List<TreeItem<T>> getSubItems() {
    return subItems;
  }

  /**
   * Selects (shows and activates) this tree item. This method expands the item and activates it.
   */
  public void select() {
    this.show(true).activate(true);
  }

  /**
   * Retrieves the value associated with this tree item.
   *
   * @return The value associated with this tree item.
   */
  public T getValue() {
    return value;
  }

  /**
   * Sets the value associated with this tree item.
   *
   * @param value The new value to set.
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Removes a sub-item from this tree item.
   *
   * @param item The sub-item to remove.
   */
  @Override
  public void removeItem(TreeItem<T> item) {
    if (subItems.contains(item)) {
      subItems.remove(item);
    }

    if (subItems.isEmpty()) {
      collapse();
    }
  }

  /**
   * Clears all sub-items from this tree item.
   *
   * @return The current TreeItem instance after clearing all sub-items.
   */
  public TreeItem<T> clear() {
    new ArrayList<>(subItems).forEach(TreeItem::remove);
    return this;
  }

  /**
   * Removes this tree item from its parent.
   *
   * @return The current TreeItem instance after removal.
   */
  @Override
  public TreeItem<T> remove() {
    getParent().ifPresent(itemParent -> itemParent.removeItem(this));
    return super.remove();
  }

  /**
   * Retrieves the filter associated with this tree item, which is typically inherited from its
   * parent.
   *
   * @return The filter associated with this tree item.
   */
  @Override
  public TreeItemFilter<TreeItem<T>> getFilter() {
    return parent.getFilter();
  }

  /**
   * Retrieves the text element associated with this tree item.
   *
   * @return The text element.
   */
  public SpanElement getTextElement() {
    return textElement.get();
  }

  /**
   * Sets the title of this tree item and updates the text content of the associated text element.
   *
   * @param title The new title to set.
   * @return The current TreeItem instance.
   */
  public TreeItem<T> setTitle(String title) {
    this.title = title;
    textElement.get().setTextContent(title);
    return this;
  }

  /**
   * Retrieves the UListElement` that represents the sub-tree of this tree item.
   *
   * @return The `UListElement` representing the sub-tree.
   */
  public UListElement getSubTree() {
    return subTree;
  }

  /**
   * Handles changes in the supplied icon for this tree item and its sub-items.
   *
   * @param iconSupplier The icon supplier responsible for creating icons.
   */
  void onSuppliedIconChanged(Tree.TreeItemIconSupplier<T> iconSupplier) {
    Icon<?> icon = iconSupplier.createIcon(this);
    if (nonNull(icon) && isNull(itemIcon)) {
      setIcon(icon);
      subItems.forEach(item -> item.onSuppliedIconChanged(iconSupplier));
    }
  }

  /**
   * Pauses selection listeners for this tree item.
   *
   * @return The current TreeItem instance after pausing selection listeners.
   */
  @Override
  public TreeItem<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /**
   * Resumes selection listeners for this tree item.
   *
   * @return The current TreeItem instance after resuming selection listeners.
   */
  @Override
  public TreeItem<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /**
   * Toggles the pause state of selection listeners.
   *
   * @param toggle True to pause selection listeners, false to resume them.
   * @return The current TreeItem instance after toggling selection listeners.
   */
  @Override
  public TreeItem<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /**
   * Retrieves the set of selection listeners associated with this tree item.
   *
   * @return The set of selection listeners.
   */
  @Override
  public Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>> getSelectionListeners() {
    return this.selectionListeners;
  }

  /**
   * Retrieves the set of deselection listeners associated with this tree item.
   *
   * @return The set of deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super TreeItem<T>, ? super TreeItem<T>>>
      getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /**
   * Checks if selection listeners for this tree item are currently paused.
   *
   * @return True if selection listeners are paused, false otherwise.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * Triggers selection listeners for this tree item when a selection event occurs.
   *
   * @param source The source tree item that triggered the event.
   * @param selection The selected tree item.
   * @return The current TreeItem instance after triggering selection listeners.
   */
  @Override
  public TreeItem<T> triggerSelectionListeners(TreeItem<T> source, TreeItem<T> selection) {
    if (!isSelectionListenersPaused()) {
      this.selectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /**
   * Triggers deselection listeners for this tree item when a deselection event occurs.
   *
   * @param source The source tree item that triggered the event.
   * @param selection The deselected tree item.
   * @return The current TreeItem instance after triggering deselection listeners.
   */
  @Override
  public TreeItem<T> triggerDeselectionListeners(TreeItem<T> source, TreeItem<T> selection) {
    if (!isSelectionListenersPaused()) {
      this.deselectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /**
   * Retrieves the selected tree item. In the context of a single tree item, this method returns the
   * current tree item itself.
   *
   * @return The selected tree item.
   */
  @Override
  public TreeItem<T> getSelection() {
    return this;
  }

  /**
   * A private inner class representing the original state of a tree item. This state includes
   * whether the tree item was expanded or collapsed.
   */
  private static class OriginalState {
    private boolean expanded;

    /**
     * Constructs an instance of OriginalState with the specified expanded state.
     *
     * @param expanded True if the tree item was expanded, false if it was collapsed.
     */
    public OriginalState(boolean expanded) {
      this.expanded = expanded;
    }
  }
}
