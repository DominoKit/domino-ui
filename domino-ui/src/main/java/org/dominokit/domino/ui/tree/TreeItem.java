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
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import elemental2.dom.EventListener;
import java.util.*;
import java.util.function.Predicate;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/**
 * A component representing the tree item
 *
 * @param <T> the type of the value object inside the item
 * @see WavesElement
 * @see CanActivate
 * @see CanDeactivate
 * @see HasClickableElement
 */
public class TreeItem<T> extends WavesElement<HTMLLIElement, TreeItem<T>>
    implements TreeNode, CanActivate, CanDeactivate {

  private String title;
  private HTMLLIElement element;
  private final DominoElement<HTMLAnchorElement> anchorElement;
  private final List<TreeItem<T>> childItems = new ArrayList<>();
  private TreeNode parentNode;
  private Collapsible collapsible;

  private HTMLUListElement childrenContainer;
  private BaseIcon<?> icon;
  private BaseIcon<?> activeIcon;
  private BaseIcon<?> originalIcon;

  private BaseIcon<?> expandIcon;

  private T value;

  private int level = 1;
  private int levelPadding = 15;

  private ToggleTarget toggleTarget = ToggleTarget.ANY;
  private final DominoElement<HTMLElement> indicatorContainer =
      DominoElement.of(span()).css("tree-indicator");
  private HTMLElement titleElement;
  private OriginalState originalState;

  public TreeItem(String title, BaseIcon<?> icon) {
    this.title = title;
    setIcon(icon);
    titleElement = DominoElement.of(span()).css("title").textContent(title).element();
    DominoElement<HTMLElement> toggleContainer = DominoElement.of(span()).css("tree-tgl-icn");
    this.anchorElement =
        DominoElement.of(a())
            .add(this.icon)
            .add(
                DominoElement.of(div())
                    .css(Styles.ellipsis_text)
                    .style("margin-top: 2px;")
                    .add(titleElement))
            .add(
                toggleContainer
                    .appendChild(
                        Icons.ALL
                            .plus_mdi()
                            .size18()
                            .css("tree-tgl-collapsed")
                            .clickable()
                            .addClickListener(
                                evt -> {
                                  evt.stopPropagation();
                                  toggle();
                                  setActiveItem();
                                }))
                    .appendChild(
                        Icons.ALL
                            .minus_mdi()
                            .size18()
                            .css("tree-tgl-expanded")
                            .clickable()
                            .addClickListener(
                                evt -> {
                                  evt.stopPropagation();
                                  toggle();
                                  setActiveItem();
                                })))
            .add(indicatorContainer);
    init();
  }

  public TreeItem(String title) {
    this(title, Icons.ALL.folder().setCssProperty("visibility", "hidden"));
  }

  public TreeItem(BaseIcon<?> icon) {
    setIcon(icon);
    this.anchorElement = DominoElement.of(a().add(this.icon));
    init();
  }

  public TreeItem(String title, T value) {
    this(title);
    this.value = value;
  }

  public TreeItem(String title, BaseIcon<?> icon, T value) {
    this(title, icon);
    this.value = value;
  }

  public TreeItem(BaseIcon<?> icon, T value) {
    this(icon);
    this.value = value;
  }

  /**
   * Creates new tree item with a title
   *
   * @param title the title of the item
   * @return new instance
   */
  public static TreeItem<String> create(String title) {
    TreeItem<String> treeItem = new TreeItem<>(title);
    treeItem.value = title;
    return treeItem;
  }

  /**
   * Creates new tree item with a title and an icon
   *
   * @param title the title of the item
   * @param icon the item's {@link BaseIcon}
   * @return new instance
   */
  public static TreeItem<String> create(String title, BaseIcon<?> icon) {
    TreeItem<String> treeItem = new TreeItem<>(title, icon);
    treeItem.value = title;
    return treeItem;
  }

  /**
   * Creates new tree item with an icon
   *
   * @param icon the item's {@link BaseIcon}
   * @return new instance
   */
  public static TreeItem<String> create(BaseIcon<?> icon) {
    TreeItem<String> treeItem = new TreeItem<>(icon);
    treeItem.value = "";
    return treeItem;
  }

  /**
   * Creates new tree item with a title and a value
   *
   * @param title the title of the item
   * @param value the value of the item
   * @param <T> the type of the value
   * @return new instance
   */
  public static <T> TreeItem<T> create(String title, T value) {
    return new TreeItem<>(title, value);
  }

  /**
   * Creates new tree item with a title, an icon and a value
   *
   * @param title the title of the item
   * @param icon the item's {@link BaseIcon}
   * @param value the value of the item
   * @param <T> the type of the value
   * @return new instance
   */
  public static <T> TreeItem<T> create(String title, BaseIcon<?> icon, T value) {
    return new TreeItem<>(title, icon, value);
  }

  /**
   * Creates new tree item with an icon and a value
   *
   * @param icon the item's {@link BaseIcon}
   * @param value the value of the item
   * @param <T> the type of the value
   * @return new instance
   */
  public static <T> TreeItem<T> create(BaseIcon<?> icon, T value) {
    return new TreeItem<>(icon, value);
  }

  private void init() {
    this.element = li().element();
    this.element.appendChild(anchorElement.element());
    childrenContainer = DominoElement.of(ul()).css("ml-tree").element();
    element().appendChild(childrenContainer);
    collapsible =
        Collapsible.create(childrenContainer)
            .setStrategy(DominoUIConfig.INSTANCE.getDefaultTreeCollapseStrategySupplier().get(this))
            .addHideHandler(
                () -> {
                  anchorElement.removeCss("toggled");
                  restoreIcon();
                })
            .addShowHandler(
                () -> {
                  anchorElement.addCss("toggled");
                  replaceIcon(expandIcon);
                })
            .hide();
    anchorElement.addEventListener(
        "click",
        evt -> {
          if (ToggleTarget.ANY.equals(this.toggleTarget) && isParent()) {
            toggle();
          }
          setActiveItem();
        });
    init(this);
    setToggleTarget(ToggleTarget.ANY);
    setWaveColor(WaveColor.THEME);
    applyWaveStyle(WaveStyle.BLOCK);
  }

  /**
   * This method is internally used by a tree item self to notify its root node {@link Tree} that
   * this item should be the active one in the tree.
   */
  private void setActiveItem() {
    getRootNode().setActiveItem(this);
  }

  /**
   * Adds a child item to this one
   *
   * @param treeItem the child {@link TreeItem}
   * @return same instance
   */
  public TreeItem<T> appendChild(TreeItem<T> treeItem) {
    appendChild((TreeNode) treeItem);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeNode appendChild(TreeNode node) {
    TreeItem<T> treeItem = (TreeItem<T>) node;
    this.childItems.add(treeItem);
    childrenContainer.appendChild(treeItem.element());
    anchorElement.addCss("tree-toggle");
    treeItem.parentNode = this;
    treeItem.setLevel(level + 1);
    treeItem.addCss("tree-leaf");
    Style.of(this.element()).removeCss("tree-leaf");
    treeItem.setToggleTarget(this.toggleTarget);
    treeItem.setLevelPadding(levelPadding);
    this.style().addCss("tree-item-parent");
    return node;
  }

  /**
   * Adds new separator
   *
   * @return same instance
   */
  public TreeItem<T> addSeparator() {
    childrenContainer.appendChild(DominoElement.of(li()).css("separator").add(a()).element());
    return this;
  }

  /**
   * Sets what is the target for toggling an item
   *
   * @param toggleTarget the {@link ToggleTarget}
   * @return same instance
   */
  public TreeItem<T> setToggleTarget(ToggleTarget toggleTarget) {
    if (nonNull(toggleTarget)) {
      if (nonNull(this.toggleTarget)) {
        this.removeCss(this.toggleTarget.getStyle());
      }

      this.toggleTarget = toggleTarget;
      this.css(this.toggleTarget.getStyle());
      if (ToggleTarget.ICON.equals(toggleTarget)) {
        if (nonNull(icon)) {
          icon.setClickable(true);
        }
      } else {
        if (nonNull(icon)) {
          icon.setClickable(false);
        }
      }

      childItems.forEach(item -> item.setToggleTarget(toggleTarget));
    }
    return this;
  }

  private void toggle() {
    if (isParent()) {
      collapsible.toggleDisplay();
    }
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> show() {
    return show(false);
  }

  /**
   * Shows the item
   *
   * @param expandParent true to expand the parent of the item
   * @return same instance
   */
  public TreeItem<T> show(boolean expandParent) {
    if (isParent()) {
      collapsible.show();
    }
    if (expandParent) {
      getParent().ifPresent(parent -> parent.expand(true));
    }
    return this;
  }

  /**
   * Expands the tree item
   *
   * @return same instance
   */
  public TreeItem<T> expand() {
    return show();
  }

  /**
   * Expands the tree item
   *
   * @param expandParent true to expand the parent of the item
   * @return same instance
   */
  public TreeItem<T> expand(boolean expandParent) {
    return show(expandParent);
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> hide() {
    if (isParent()) {
      collapsible.hide();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> toggleDisplay() {
    if (isParent()) {
      collapsible.toggleDisplay();
    }
    return this;
  }

  /** @deprecated use {@link #isCollapsed()} {@inheritDoc} */
  @Override
  @Deprecated
  public boolean isHidden() {
    return collapsible.isCollapsed();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isCollapsed() {
    return collapsible.isCollapsed();
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> addHideListener(Collapsible.HideCompletedHandler handler) {
    collapsible.addHideHandler(handler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> removeHideListener(Collapsible.HideCompletedHandler handler) {
    collapsible.removeHideHandler(handler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> addShowListener(Collapsible.ShowCompletedHandler handler) {
    collapsible.addShowHandler(handler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> removeShowListener(Collapsible.ShowCompletedHandler handler) {
    collapsible.removeShowHandler(handler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element;
  }

  /**
   * @return the current active value
   * @deprecated use {@link Tree#getActiveItem()} instead
   */
  @Deprecated
  public TreeItem<T> getActiveItem() {
    return getRootNode().getActiveItem();
  }

  /** @return The {@link Tree} */
  public Tree<T> getTreeRoot() {
    return getRootNode();
  }

  /** @return the parent item */
  public Optional<TreeItem<T>> getParent() {
    if (parentNode instanceof TreeItem) {
      return Optional.of((TreeItem<T>) parentNode);
    } else {
      return Optional.empty();
    }
  }

  /**
   * Activates the item representing the value
   *
   * @param activeItem the value of the item to activate
   * @deprecated use {@link Tree#setActiveItem(TreeItem)} instead
   */
  @Deprecated
  public void setActiveItem(TreeItem<T> activeItem) {
    setActiveItem(activeItem, false);
  }

  /**
   * Activates the item representing the value
   *
   * @param activeItem the value of the item to activate
   * @param silent true to not notify listeners
   * @deprecated use {@link Tree#setActiveItem(TreeItem, boolean)} instead
   */
  @Deprecated
  public void setActiveItem(TreeItem<T> activeItem, boolean silent) {
    getRootNode().setActiveItem(activeItem, silent);
  }

  /** @return A list of tree items representing the path for this item */
  public List<TreeItem<T>> getPath() {
    List<TreeItem<T>> items = Tree.getBubblingPath(this);

    Collections.reverse(items);

    return items;
  }

  /** @return A list of values representing the path for this item */
  public List<T> getPathValues() {
    List<T> values = Tree.getBubblingPathValues(this);

    Collections.reverse(values);

    return values;
  }

  /** Activates the component, GUI effect only */
  @Override
  public void activate() {
    Style.of(element()).addCss("active");
    if (isNull(expandIcon) || collapsible.isCollapsed() || !isParent()) {
      replaceIcon(this.activeIcon);
    }
    if (isParent() && collapsible.isCollapsed()) collapsible.show();
  }

  /**
   * Activates the item
   *
   * @param activateParent true to activate parent
   * @deprecated use either {@link #activate()} or {@link Tree#setActiveItem(TreeItem)} instead
   */
  @Deprecated
  public void activate(boolean activateParent) {
    if (activateParent) setActiveItem();
    else activate();
  }

  private void replaceIcon(BaseIcon<?> newIcon) {
    if (nonNull(newIcon)) {
      if (nonNull(icon)) {
        icon.remove();
      }
      anchorElement.insertFirst(newIcon);
      this.icon = newIcon;
    }
  }

  /** Deactivate the component, GUI effect only */
  @Override
  public void deactivate() {
    deactivate(getRootNode().isAutoCollapse());
  }

  /**
   * Deactivate the component, GUI effect only
   *
   * @param autoCollapse indicator if item should be collapsed automatically
   */
  public void deactivate(boolean autoCollapse) {
    Style.of(element()).removeCss("active");
    if (isNull(expandIcon) || collapsible.isCollapsed() || !isParent()) {
      restoreIcon();
    }
    if (isParent()) {
      childItems.forEach(subItem -> subItem.deactivate(autoCollapse));
      if (autoCollapse) {
        collapsible.hide();
      }
    }
  }

  private void restoreIcon() {
    if (nonNull(originalIcon)) {
      icon.remove();
      anchorElement.insertFirst(originalIcon);
      this.icon = originalIcon;
    } else {
      if (nonNull(icon)) {
        icon.remove();
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return anchorElement.element();
  }

  /** {@inheritDoc} */
  public TreeItem<T> addClickListener(EventListener listener) {
    getClickableElement().addEventListener(EventType.click.getName(), listener);
    return this;
  }

  /**
   * Sets the icon of the item
   *
   * @param icon the new {@link BaseIcon}
   * @return same instance
   */
  public TreeItem<T> setIcon(BaseIcon<?> icon) {
    this.icon = icon;
    this.originalIcon = icon.copy();
    if (icon.element().style.visibility.equals("hidden")) {
      this.originalIcon.setCssProperty("visibility", "hidden");
    }
    this.originalIcon.addClickListener(
        evt -> {
          if (ToggleTarget.ICON.equals(this.toggleTarget)) {
            evt.stopPropagation();
            toggle();
          }
          setActiveItem();
        });
    return this;
  }

  /**
   * Sets the icon that will be shown when the item is active
   *
   * @param activeIcon the {@link BaseIcon}
   * @return same instance
   */
  public TreeItem<T> setActiveIcon(BaseIcon<?> activeIcon) {
    this.activeIcon = activeIcon;
    return this;
  }

  /**
   * Sets the expand icon
   *
   * @param expandIcon the {@link BaseIcon}
   * @return same instance
   */
  public TreeItem<T> setExpandIcon(BaseIcon<?> expandIcon) {
    this.expandIcon = expandIcon;
    return this;
  }

  boolean isParent() {
    return !childItems.isEmpty();
  }

  void setParent(TreeNode parentTreeNode) {
    this.parentNode = parentTreeNode;
  }

  /** @return the title of the item */
  public String getTitle() {
    return title;
  }

  /**
   * Find any descendant tree item matching the given item value
   *
   * @param value a value being searched
   * @return an {@code Optional} tree item matching the given item value
   */
  public Optional<TreeItem<T>> findAny(T value) {
    return findAny(getRootNode().createFinderPredicate(value));
  }

  /**
   * Filter this item based on the search token
   *
   * @param searchToken the search token
   * @return true if this item should be shown, false otherwise
   */
  public boolean filter(String searchToken) {
    return filter(createFilterPredicate(searchToken));
  }

  /**
   * Filter this item based on the given predicate
   *
   * @param predicate a predicate to test with
   * @return true if this item should be shown, false otherwise
   */
  public boolean filter(Predicate<TreeNode> predicate) {
    return search(
        (node, found) -> {
          if (isNull(this.originalState)) {
            this.originalState = new OriginalState(collapsible.isExpanded());
          }

          if (found || predicate.test(node)) {
            Style.of(element).removeCssProperty("display");
            if (isParent() && collapsible.isCollapsed()) {
              collapsible.show();
            }
            return true;
          } else {
            Style.of(element).setDisplay("none");
            return false;
          }
        });
  }

  /**
   * @return true if automatic expanding is enabled when finding items in search
   */
  public boolean isAutoExpandFound() {
    return getRootNode().isAutoExpandFound();
  }

  /** Clears the filter applied */
  public void clearFilter() {
    if (nonNull(originalState)) {
      DomGlobal.requestAnimationFrame(
          timestamp -> {
            if (collapsible.isExpanded() != originalState.expanded) {
              if (this.equals(getRootNode().getActiveItem())) {
                collapsible.show();
              } else {
                collapsible.toggleDisplay(originalState.expanded);
              }
            }
            this.originalState = null;
          });
    }
    Style.of(element).removeCssProperty("display");
    childItems.forEach(TreeItem::clearFilter);
  }

  /**
   * Filters the children and make sure the filter is applied to all children
   *
   * @param searchToken the search token
   * @return true of one of the children matches the search token, false otherwise
   */
  public boolean filterChildren(String searchToken) {
    // We use the noneMatch here instead of anyMatch to make sure we are looping all children
    // instead of early exit on first matching one
    return childItems.stream().filter(treeItem -> treeItem.filter(searchToken)).count() > 0;
  }

  /** Collapse all children */
  public void collapseAll() {
    if (isParent() && !collapsible.isCollapsed()) {
      hide();
      childItems.forEach(TreeItem::collapseAll);
    }
  }

  /** Expand all children */
  public void expandAll() {
    if (isParent() && collapsible.isCollapsed()) {
      show();
      childItems.forEach(TreeItem::expandAll);
    }
  }

  /**
   * Sets the level of this item
   *
   * @param level the new level
   * @return same instance
   */
  public TreeItem<T> setLevel(int level) {
    this.level = level;
    updateLevelPadding();

    if (isParent()) {
      childItems.forEach(treeItem -> treeItem.setLevel(level + 1));
    }

    return this;
  }

  /**
   * Sets the level padding of this item
   *
   * @param levelPadding the new level padding
   * @return same instance
   */
  public TreeItem<T> setLevelPadding(int levelPadding) {
    this.levelPadding = levelPadding;
    updateLevelPadding();

    if (isParent()) {
      childItems.forEach(treeItem -> treeItem.setLevelPadding(levelPadding));
    }

    return this;
  }

  private void updateLevelPadding() {
    anchorElement.style().setPaddingLeft(px.of(level * levelPadding));
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getWavesElement() {
    return anchorElement.element();
  }

  /** @return true if this item does not have children, false otherwise */
  public boolean isLeaf() {
    return childItems.isEmpty();
  }

  /** @return the children of this item */
  public List<TreeItem<T>> getSubItems() {
    return getChildNodes();
  }

  /**
   * Selects this item, the item will be shown and activated, effectively set this tree item as the
   * active one of the tree
   */
  public void select() {
    setActiveItem();
  }

  /** @return the value of the item */
  public T getValue() {
    return value;
  }

  /**
   * Sets the value of the item
   *
   * @param value the value
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Removes item
   *
   * @param item the item value
   */
  public void removeItem(TreeItem<T> item) {
    removeChild((TreeNode) item);
  }

  private void removeParentStyle() {
    style().removeCss("tree-item-parent");
  }

  /**
   * Remove all the child tree items.
   *
   * @return same instance
   */
  public TreeItem<T> clear() {
    Tree tree = getRootNode();

    // Remember the current active path of the root tree
    List<TreeItem<T>> activePath = tree.getActiveBubblingPath();

    // Update HTML DOM
    childItems.stream().forEach(TreeItem::remove);

    childItems.clear();

    removeParentStyle();

    // Either this tree item or one of its descendants is the active tree item of the root tree.
    // Since all the descendants of the tree item are cleared now, this one should be automatically
    // the active one.
    if (activePath.contains(this)) tree.setActiveItem(this);

    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeNode removeChild(TreeNode node) {
    Tree<T> tree = getRootNode();

    // Remember the current active path of the root tree
    List<TreeItem<T>> activePath = tree.getActiveBubblingPath();

    if (childItems.remove(node)) {
      // Update HTML DOM
      ((TreeItem<T>) node).remove();

      if (childItems.isEmpty()) removeParentStyle();

      // Either the node being removed or one of its descendants is the active tree item of the root
      // tree. Since the node is removed, its parent node, namely this one, should be automatically
      // the active one.
      if (activePath.contains(node)) tree.setActiveItem(this);
    }

    return node;
  }

  /**
   * Replace original override remove() method, a convenient way to remove this tree item from the
   * tree
   *
   * @return same instance
   */
  public TreeItem<T> removeFromTree() {
    return (TreeItem<T>) getParentNode().removeChild(this);
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> remove() {
    // This method overriding can be removed in the future.
    // Before it invokes its parent tree item to remove itself. This is confusing, since you mix
    // logical list remove operation with DOM remove operation in one remove method, both parent and
    // child are the same type instance (TreeItem). Keep it a pure original DOM remove operation is
    // probably better. For a logical and DOM remove, you can use new added removeFromTree method.
    return super.remove();
  }

  /**
   * Sets the content indicator for this item
   *
   * @param indicatorContent a {@link Node}
   * @return same instance
   */
  public TreeItem<T> setIndicatorContent(Node indicatorContent) {
    indicatorContainer.clearElement();
    if (nonNull(indicatorContent)) {
      indicatorContainer.appendChild(indicatorContent);
    }
    return this;
  }

  /**
   * Sets the content indicator for this item
   *
   * @param element a {@link IsElement}
   * @return same instance
   */
  public TreeItem<T> setIndicatorContent(IsElement<?> element) {
    setIndicatorContent(element.element());
    return this;
  }

  /**
   * Clears the content indicator
   *
   * @return same instance
   */
  public TreeItem<T> clearIndicator() {
    indicatorContainer.clearElement();
    return this;
  }

  public Predicate<TreeNode> createFilterPredicate(String searchToken) {
    return getRootNode().createFilterPredicate(searchToken);
  }

  /** {@inheritDoc} */
  @Override
  public Collapsible getCollapsible() {
    return collapsible;
  }

  /** @return the content indicator container */
  public DominoElement<HTMLElement> getIndicatorContainer() {
    return indicatorContainer;
  }

  /** @return The {@link HTMLElement} that contains the title of this TreeItem */
  public DominoElement<HTMLElement> getTitleElement() {
    return DominoElement.of(titleElement);
  }

  /**
   * Change the title of a TreeItem, If the TreeItem was created without a value and the title is
   * used as a value then it will not change when the title is changed to change the value a call to
   * {@link #setValue(T)} should be called
   *
   * @param title string title to set
   * @return same instance
   */
  public TreeItem<T> setTitle(String title) {
    this.title = title;
    getTitleElement().setTextContent(title);
    return this;
  }

  public HTMLUListElement getChildrenContainer() {
    return childrenContainer;
  }

  /** {@inheritDoc} */
  @Override
  public TreeNode getParentNode() {
    return parentNode;
  }

  /** {@inheritDoc} */
  @Override
  public List<TreeItem<T>> getChildNodes() {
    return childItems;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> getRootNode() {
    return (Tree<T>) TreeNode.super.getRootNode();
  }

  private static class OriginalState {
    private boolean expanded;

    public OriginalState(boolean expanded) {
      this.expanded = expanded;
    }
  }
}
