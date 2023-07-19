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

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.TreeConfig;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.StateChangeIcon;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.CanActivate;
import org.dominokit.domino.ui.utils.CanDeactivate;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.TreeParent;

/**
 * A component representing the tree item
 *
 * @param <T> the type of the value object inside the item
 * @see TreeParent
 * @see CanActivate
 * @see CanDeactivate
 * @see HasClickableElement
 * @author vegegoku
 * @version $Id: $Id
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

  private TreeItem() {
    this.element =
        li().addCss(dui_tree_item)
            .appendChild(
                anchorElement =
                    a().addCss(dui_tree_anchor)
                        .appendChild(contentElement = div().addCss(dui_tree_item_content)))
            .appendChild(subTree = ul().addCss(dui_tree_nav).hide());
    this.textElement = LazyChild.of(span().addCss(dui_tree_item_text), contentElement);
    init(this);

    setCollapseStrategy(getConfig().getTreeDefaultCollapseStrategy(this).get());
    setAttribute(Collapsible.DUI_COLLAPSED, "true");
  }

  /**
   * Constructor for TreeItem.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @param title a {@link java.lang.String} object
   */
  public TreeItem(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
    init();
  }

  /**
   * Constructor for TreeItem.
   *
   * @param title a {@link java.lang.String} object
   */
  public TreeItem(String title) {
    this();
    setTitle(title);
    init();
  }

  /**
   * Constructor for TreeItem.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public TreeItem(Icon<?> icon) {
    this();
    setIcon(icon);
    init();
  }

  /**
   * Constructor for TreeItem.
   *
   * @param title a {@link java.lang.String} object
   * @param value a T object
   */
  public TreeItem(String title, T value) {
    this(title);
    this.value = value;
  }

  /**
   * Constructor for TreeItem.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @param title a {@link java.lang.String} object
   * @param value a T object
   */
  public TreeItem(Icon<?> icon, String title, T value) {
    this(icon, title);
    this.value = value;
  }

  /**
   * Constructor for TreeItem.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @param value a T object
   */
  public TreeItem(Icon<?> icon, T value) {
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
   * @param icon the item's {@link org.dominokit.domino.ui.icons.Icon}
   * @param title the title of the item
   * @return new instance
   */
  public static TreeItem<String> create(Icon<?> icon, String title) {
    TreeItem<String> treeItem = new TreeItem<>(icon, title);
    treeItem.value = title;
    return treeItem;
  }

  /**
   * Creates new tree item with an icon
   *
   * @param icon the item's {@link org.dominokit.domino.ui.icons.Icon}
   * @return new instance
   */
  public static TreeItem<String> create(Icon<?> icon) {
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
   * @param icon the item's {@link org.dominokit.domino.ui.icons.Icon}
   * @param value the value of the item
   * @param <T> the type of the value
   * @return new instance
   */
  public static <T> TreeItem<T> create(Icon<?> icon, String title, T value) {
    return new TreeItem<>(icon, title, value);
  }

  /**
   * Creates new tree item with an icon and a value
   *
   * @param icon the item's {@link org.dominokit.domino.ui.icons.Icon}
   * @param value the value of the item
   * @param <T> the type of the value
   * @return new instance
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
    getParent().ifPresent(itemParent -> itemParent.setActiveItem(this));
    triggerSelectionListeners(this, this);
  }

  /**
   * Adds a child item to this one
   *
   * @param treeItem the child {@link org.dominokit.domino.ui.tree.TreeItem}
   * @return same instance
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

  /**
   * appendChild.
   *
   * @param postfixAddOn a {@link org.dominokit.domino.ui.utils.PostfixAddOn} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeItem} object
   */
  public TreeItem<T> appendChild(PostfixAddOn<?> postfixAddOn) {
    contentElement.appendChild(postfixAddOn);
    return this;
  }

  /**
   * appendChild.
   *
   * @param prefixAddOn a {@link org.dominokit.domino.ui.utils.PrefixAddOn} object
   * @return a {@link org.dominokit.domino.ui.tree.TreeItem} object
   */
  public TreeItem<T> appendChild(PrefixAddOn<?> prefixAddOn) {
    contentElement.appendChild(prefixAddOn);
    return this;
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
   * Adds new separator
   *
   * @return same instance
   */
  public TreeItem<T> addSeparator() {
    subTree.appendChild(li().addCss(dui_separator));
    return this;
  }

  /**
   * Sets what is the target for toggling an item
   *
   * @param toggleTarget the {@link org.dominokit.domino.ui.tree.ToggleTarget}
   * @return same instance
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

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> expandNode() {
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
      super.expand();
    }
    if (expandParent) {
      getParent().ifPresent(itemParent -> itemParent.expandNode(true));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> expandNode(boolean expandParent) {
    return show(expandParent);
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> toggleCollapse() {
    if (isParent()) {
      super.toggleCollapse();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> getActiveItem() {
    return activeTreeItem;
  }

  /** {@inheritDoc} */
  @Override
  public Tree<T> getTreeRoot() {
    return parent.getTreeRoot();
  }

  /** {@inheritDoc} */
  @Override
  public Optional<TreeParent<T>> getParent() {
    if (parent instanceof TreeItem) {
      return Optional.of(parent);
    } else {
      return Optional.empty();
    }
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

  /** @return A list of tree items representing the path for this item */
  /**
   * getPath.
   *
   * @return a {@link java.util.List} object
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

  /** @return A list of values representing the path for this item */
  /**
   * getPathValues.
   *
   * @return a {@link java.util.List} object
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

  /** {@inheritDoc} */
  @Override
  public void activate() {
    activate(false);
  }

  /** {@inheritDoc} */
  @Override
  public void activate(boolean activateParent) {
    addCss(dui_active);
    if (activateParent) {
      getParent().ifPresent(itemParent -> itemParent.setActiveItem(this));
    }
    updateIcon(isCollapsed());
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return anchorElement.element();
  }

  /**
   * Sets the icon of the item
   *
   * @param icon the new {@link org.dominokit.domino.ui.icons.Icon}
   * @return same instance
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

  boolean isParent() {
    return !subItems.isEmpty();
  }

  void setParent(TreeParent<T> parentMenu) {
    this.parent = parentMenu;
  }

  /** @return the title of the item */
  /**
   * Getter for the field <code>title</code>.
   *
   * @return a {@link java.lang.String} object
   */
  public String getTitle() {
    return title;
  }

  /**
   * Filter this item based on the search token
   *
   * @param searchToken the search token
   * @return true if this item should be shown, false otherwise
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

  /** {@inheritDoc} */
  @Override
  public boolean isAutoExpandFound() {
    return getTreeRoot().isAutoExpandFound();
  }

  /** Clears the filter applied */
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
   * Filters the children and make sure the filter is applied to all children
   *
   * @param searchToken the search token
   * @return true of one of the children matches the search token, false otherwise
   */
  public boolean filterChildren(String searchToken) {
    // We use the noneMatch here instead of anyMatch to make sure we are looping all children
    // instead of early exit on first matching one
    return subItems.stream().filter(treeItem -> treeItem.filter(searchToken)).count() > 0;
  }

  /** Collapse all children */
  public void collapseAll() {
    if (isParent() && !isCollapsed()) {
      addCss(dui_transition_none);
      subItems.forEach(TreeItem::collapseAll);
      collapse();
      dui_transition_none.remove(this);
    }
  }

  /** Expand all children */
  public void expandAll() {
    if (isParent() && isCollapsed()) {
      addCss(dui_transition_none);
      this.expandNode();
      subItems.forEach(TreeItem::expandAll);
      dui_transition_none.remove(this);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Element getWavesElement() {
    return anchorElement.element();
  }

  /** @return true if this item does not have children, false otherwise */
  /**
   * isLeaf.
   *
   * @return a boolean
   */
  public boolean isLeaf() {
    return subItems.isEmpty();
  }

  /** @return the list of all sub {@link TreeItem} */
  /** {@inheritDoc} */
  @Override
  public List<TreeItem<T>> getSubItems() {
    return subItems;
  }

  /** Selects this item, the item will be shown and activated */
  public void select() {
    this.show(true).activate(true);
  }

  /** @return the value of the item */
  /**
   * Getter for the field <code>value</code>.
   *
   * @return a T object
   */
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

  /** {@inheritDoc} */
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
   * Remove all the TreeItem sub-items.
   *
   * @return same TreeItem instance
   */
  public TreeItem<T> clear() {
    new ArrayList<>(subItems).forEach(TreeItem::remove);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> remove() {
    getParent().ifPresent(itemParent -> itemParent.removeItem(this));
    return super.remove();
  }

  /** {@inheritDoc} */
  @Override
  public TreeItemFilter<TreeItem<T>> getFilter() {
    return parent.getFilter();
  }

  /** @return The {@link HTMLElement} that contains the title of this TreeItem */
  /**
   * Getter for the field <code>textElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SpanElement} object
   */
  public SpanElement getTextElement() {
    return textElement.get();
  }

  /**
   * Change the title of a TreeItem, If the TreeItem was created without a value and the title is
   * used as a value then it will not change when the title is changed to change the value a call to
   * {@link #setValue(T)} should be called
   *
   * @param title String title to set
   * @return same TreeItem instance
   */
  public TreeItem<T> setTitle(String title) {
    this.title = title;
    textElement.get().setTextContent(title);
    return this;
  }

  /** @return the {@link HTMLUListElement} that contains the tree items */
  /**
   * Getter for the field <code>subTree</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.UListElement} object
   */
  public UListElement getSubTree() {
    return subTree;
  }

  void onSuppliedIconChanged(Tree.TreeItemIconSupplier<T> iconSupplier) {
    Icon<?> icon = iconSupplier.createIcon(this);
    if (nonNull(icon) && isNull(itemIcon)) {
      setIcon(icon);
      subItems.forEach(item -> item.onSuppliedIconChanged(iconSupplier));
    }
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> togglePauseSelectionListeners(boolean toggle) {
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
  public TreeItem<T> triggerSelectionListeners(TreeItem<T> source, TreeItem<T> selection) {
    if (!isSelectionListenersPaused()) {
      this.selectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> triggerDeselectionListeners(TreeItem<T> source, TreeItem<T> selection) {
    if (!isSelectionListenersPaused()) {
      this.deselectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> getSelection() {
    return this;
  }

  private static class OriginalState {
    private boolean expanded;

    public OriginalState(boolean expanded) {
      this.expanded = expanded;
    }
  }
}
