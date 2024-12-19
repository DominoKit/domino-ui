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
import static org.dominokit.domino.ui.style.GenericCss.dui_active;
import static org.dominokit.domino.ui.style.GenericCss.dui_transition_none;
import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.li;
import static org.dominokit.domino.ui.utils.Domino.span;
import static org.dominokit.domino.ui.utils.Domino.ul;

import elemental2.dom.Element;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.dominokit.domino.ui.utils.HasSelectionListeners;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.utils.PostfixElement;
import org.dominokit.domino.ui.utils.PrefixElement;
import org.dominokit.domino.ui.utils.Separator;

public abstract class TreeNode<V, N extends TreeNode<V, N, S>, S>
    extends BaseDominoElement<HTMLLIElement, N>
    implements IsParentNode<V, N, S>,
        TreeStyles,
        HasComponentConfig<TreeConfig>,
        HasSelectionListeners<N, N, S> {

  protected IsParentNode<V, N, S> parent;
  private ToggleTarget toggleTarget = ToggleTarget.ANY;
  private LazyChild<Icon<?>> nodeIcon;
  private final List<N> subNodes = new LinkedList<>();
  protected N activeNode;

  private String title;
  private LIElement element;
  private final AnchorElement anchorElement;
  private final DivElement contentElement;
  private final LazyChild<SpanElement> textElement;
  private final UListElement subTree;

  private V value;
  private OriginalState originalState;

  private boolean selectionListenersPaused = false;
  private Set<SelectionListener<? super N, ? super S>> selectionListeners = new HashSet<>();
  private Set<SelectionListener<? super N, ? super S>> deselectionListeners = new HashSet<>();

  private final EventListener anchorListener =
      evt -> {
        if (ToggleTarget.ANY.equals(this.toggleTarget)) {
          evt.stopPropagation();
          if (isParent()) {
            toggle();
          }
          activateNode();
        }
      };

  private final EventListener iconListener =
      evt -> {
        if (ToggleTarget.ICON.equals(this.toggleTarget)) {
          evt.stopPropagation();
          if (isParent()) {
            toggle();
          }
          activateNode();
        }
      };

  private TreeNode() {
    this.element =
        li().addCss(dui_tree_item)
            .appendChild(
                anchorElement =
                    a().removeHref()
                        .addCss(dui_tree_anchor)
                        .appendChild(contentElement = div().addCss(dui_tree_item_content)))
            .appendChild(subTree = ul().addCss(dui_tree_nav).hide());
    this.textElement = LazyChild.of(span().addCss(dui_tree_item_text), contentElement);
    init((N) this);

    setCollapseStrategy(getConfig().getTreeDefaultCollapseStrategy(this).get());
    setAttribute(Collapsible.DUI_COLLAPSED, "true");
  }

  /**
   * Constructs a new TreeItem instance with an icon and title.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param title The title of the tree item.
   */
  public TreeNode(Icon<?> icon, String title) {
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
  public TreeNode(String title) {
    this();
    setTitle(title);
    init();
  }

  /**
   * Constructs a new TreeItem instance with an icon.
   *
   * @param icon The icon to be displayed for the tree item.
   */
  public TreeNode(Icon<?> icon) {
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
  public TreeNode(String title, V value) {
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
  public TreeNode(Icon<?> icon, String title, V value) {
    this(icon, title);
    this.value = value;
  }

  /**
   * Constructs a new TreeItem instance with an icon and a value.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param value The value associated with the tree item.
   */
  public TreeNode(Icon<?> icon, V value) {
    this(icon);
    this.value = value;
  }

  protected void init() {
    addBeforeCollapseListener(() -> updateIcon(true));
    addBeforeExpandListener(() -> updateIcon(false));
    anchorElement.addClickListener(anchorListener);
    applyWaves();
  }

  /**
   * Sets the title of this tree item and updates the text content of the associated text element.
   *
   * @param title The new title to set.
   * @return The current TreeItem instance.
   */
  public N setTitle(String title) {
    this.title = title;
    textElement.get().setTextContent(title);
    return (N) this;
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
   * Sets the parent tree node for this tree item.
   *
   * @param parentNode The parent tree node.
   */
  void setParent(IsParentNode<V, N, S> parentNode) {
    this.parent = parentNode;
  }

  protected abstract void activateNode();

  /**
   * Deactivates (deselects) this tree item and any of its sub-items if it is a parent. If
   * auto-collapse is enabled in the tree root, it will collapse the tree item as well. This method
   * returns void.
   */
  public void deactivate() {
    dui_active.remove(this);
    if (isParent()) {
      subNodes.forEach(TreeNode::deactivate);
      if (getRootNode().isAutoCollapse()) {
        collapse();
      }
    }
    updateIcon(isCollapsed());
  }

  /**
   * Appends a child tree item to this tree item.
   *
   * @param node The child tree item to append.
   * @return This tree item with the child tree item appended.
   */
  public N appendChild(N node) {
    this.subNodes.add(node);
    subTree.appendChild(node);
    node.parent = this;
    node.setToggleTarget(this.toggleTarget);
    updateIcon(isCollapsed());
    getParent()
        .ifPresent(
            p -> {
              if (nonNull(p.getRootNode())) {
                NodeIconSupplier<V, N, S> iconSupplier = p.getRootNode().getIconSupplier();
                if (nonNull(iconSupplier)) {
                  subNodes.forEach(item -> item.onSuppliedIconChanged(iconSupplier));
                }
              }
            });
    return (N) this;
  }

  public N appendChild(N... treeItems) {
    Arrays.stream(treeItems).forEach(this::appendChild);
    return (N) this;
  }

  /**
   * Removes a sub-item from this tree item.
   *
   * @param item The sub-item to remove.
   */
  public void removeNode(N item) {
    if (subNodes.contains(item)) {
      subNodes.remove(item);
    }

    if (subNodes.isEmpty()) {
      collapse();
    }
  }

  /**
   * Clears all sub-items from this tree item.
   *
   * @return The current TreeItem instance after clearing all sub-items.
   */
  public N clear() {
    new ArrayList<>(subNodes).forEach(TreeNode::remove);
    return (N) this;
  }

  /**
   * Removes this tree item from its parent.
   *
   * @return The current TreeItem instance after removal.
   */
  @Override
  public N remove() {
    getParent().ifPresent(itemParent -> itemParent.removeNode((N) this));
    return (N) super.remove();
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
    if (nonNull(nodeIcon) && nodeIcon.isInitialized()) {
      if (nodeIcon.element() instanceof ToggleIcon) {
        ((ToggleIcon<?, ?>) nodeIcon.element()).toggle();
      } else if (nodeIcon.element() instanceof StateChangeIcon) {
        StateChangeIcon<?, ?> icon = (StateChangeIcon<?, ?>) nodeIcon.element();
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
  public N appendChild(Separator separator) {
    subTree.appendChild(separator);
    return (N) this;
  }

  /**
   * Returns the root of the tree structure to which this tree item belongs.
   *
   * @return The root Tree instance.
   */
  @Override
  public RootNode<V, N, S> getRootNode() {
    return parent.getRootNode();
  }

  /**
   * Returns an optional parent of this tree item. If the parent exists and is a TreeItem, it
   * returns an Optional containing the parent; otherwise, it returns an empty Optional.
   *
   * @return An Optional containing the parent TreeItem or an empty Optional.
   */
  public Optional<IsParentNode<V, N, S>> getParent() {
    if (parent instanceof TreeNode) {
      return Optional.of(parent);
    } else {
      return Optional.empty();
    }
  }

  /**
   * Sets the currently active (selected) tree item within the tree structure.
   *
   * @param activeNode The TreeItem to set as the active item.
   */
  public void setActiveNode(N activeNode) {
    setActiveNode(activeNode, isSelectionListenersPaused());
  }

  /**
   * Returns the path to this tree item.
   *
   * @return A list of tree items representing the path to this item, starting from the root.
   */
  public List<N> getPath() {
    List<N> items = new ArrayList<>();
    items.add((N) this);
    Optional<IsParentNode<V, N, S>> parent = getParent();

    while (parent.isPresent()) {
      items.add((N) parent.get());
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
  public List<V> getPathValues() {
    List<V> values = new ArrayList<>();
    values.add(this.getValue());
    Optional<IsParentNode<V, N, S>> parent = getParent();

    while (parent.isPresent()) {
      values.add(((N) parent.get()).getValue());
      parent = parent.get().getParent();
    }

    Collections.reverse(values);

    return values;
  }

  /**
   * Gets the list of sub-items under this tree item.
   *
   * @return The list of sub-items.
   */
  public List<N> getSubNodes() {
    return subNodes;
  }

  /**
   * Expands (shows and activates) this tree item. This method expands the item and activates it.
   */
  public void expandAndActivate() {
    this.show(true).activate(true);
  }

  /**
   * Activates (selects) this tree item without activating its parent items. This method returns
   * void.
   */
  public void activate() {
    activate(false);
  }

  /**
   * Activates (selects) this tree item. If 'activateParent' is true, it also activates its parent
   * items in the tree structure. This method returns void.
   *
   * @param activateParent True to activate parent items, false to activate only this item.
   */
  public void activate(boolean activateParent) {
    addCss(dui_active);
    if (activateParent) {
      getParent().ifPresent(parent -> parent.setActiveNode((N) this));
    }
    updateIcon(isCollapsed());
  }

  /**
   * Returns the currently active (selected) tree item within the tree structure.
   *
   * @return The currently active TreeItem instance.
   */
  public N getActiveNode() {
    return activeNode;
  }

  /**
   * Sets the toggle target for this tree item.
   *
   * @param toggleTarget The toggle target to set.
   * @return This tree item with the toggle target set.
   */
  public TreeNode<V, N, S> setToggleTarget(ToggleTarget toggleTarget) {
    if (nonNull(toggleTarget)) {

      this.toggleTarget = toggleTarget;
      if (ToggleTarget.ICON.equals(toggleTarget)) {
        removeWaves();
        if (nonNull(nodeIcon) && nodeIcon.isInitialized()) {
          nodeIcon.get().setClickable(true).addEventListener("click", iconListener, true);
        }
      } else {
        applyWaves();
        if (nonNull(nodeIcon) && nodeIcon.isInitialized()) {
          nodeIcon.get().setClickable(false).removeEventListener("click", iconListener);
        }
      }

      subNodes.forEach(item -> item.setToggleTarget(toggleTarget));
    }
    return this;
  }

  private void toggle() {
    if (isParent()) {
      toggleCollapse();
    }
  }

  /**
   * Checks if this tree item is a parent (has sub-items).
   *
   * @return True if this tree item is a parent, false otherwise.
   */
  boolean isParent() {
    return !subNodes.isEmpty();
  }

  /**
   * Checks if this tree item is a leaf (has no sub-items).
   *
   * @return True if this tree item is a leaf, false otherwise.
   */
  public boolean isLeaf() {
    return subNodes.isEmpty();
  }

  protected void applyWaves() {
    withWaves((item, waves) -> waves.setWaveStyle(WaveStyle.BLOCK));
  }

  /**
   * Handles changes in the supplied icon for this tree item and its sub-items.
   *
   * @param iconSupplier The icon supplier responsible for creating icons.
   */
  void onSuppliedIconChanged(NodeIconSupplier<V, N, S> iconSupplier) {
    Icon<?> icon = iconSupplier.createIcon((N) this);
    if (nonNull(icon) && isNull(nodeIcon)) {
      setIcon(icon);
      subNodes.forEach(item -> item.onSuppliedIconChanged(iconSupplier));
    }
  }

  /**
   * Sets the icon for this tree item. If the 'icon' parameter is not null, it replaces the existing
   * icon with the new one. This method returns the current TreeItem instance.
   *
   * @param icon The new icon to set.
   * @return The current TreeItem instance.
   */
  public N setIcon(Icon<?> icon) {
    if (nonNull(nodeIcon)) {
      if (nodeIcon.isInitialized()) {
        nodeIcon.remove();
      }
    }
    nodeIcon = LazyChild.of(icon.addCss(dui_tree_item_icon), contentElement);
    nodeIcon.whenInitialized(
        () -> {
          nodeIcon.element().forEachChild(i -> i.addCss(dui_tree_item_icon));
        });
    nodeIcon.whenInitialized(
        () -> {
          if (ToggleTarget.ICON.equals(this.toggleTarget)) {
            nodeIcon.element().clickable();
          }
          nodeIcon
              .element()
              .addClickListener(
                  evt -> {
                    if (ToggleTarget.ICON.equals(this.toggleTarget)) {
                      evt.stopPropagation();
                      toggle();
                    }
                    activateNode();
                  });
        });
    nodeIcon.get();
    updateIcon(isCollapsed());

    return (N) this;
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

  /** Collapses all sub-items under this tree item recursively. */
  public void collapseAll() {
    if (isParent() && !isCollapsed()) {
      addCss(dui_transition_none);
      subNodes.forEach(TreeNode::collapseAll);
      collapse();
      dui_transition_none.remove(this);
    }
  }

  /** Expands all sub-items under this tree item recursively. */
  public void expandAll() {
    if (isParent() && isCollapsed()) {
      addCss(dui_transition_none);
      this.expandNode();
      subNodes.forEach(TreeNode::expandAll);
      dui_transition_none.remove(this);
    }
  }

  /**
   * Expands the tree node represented by this tree item.
   *
   * @return This tree item with the node expanded.
   */
  @Override
  public N expandNode() {
    return show(false);
  }

  /**
   * Expands the tree node represented by this tree item. If the 'expandParent' parameter is true,
   * parent nodes will also be expanded. This method returns the current TreeItem instance.
   *
   * @param expandParent True to expand parent nodes, false to expand only the current node.
   * @return The current TreeItem instance.
   */
  @Override
  public N expandNode(boolean expandParent) {
    return show(expandParent);
  }

  /**
   * Shows the tree node represented by this tree item.
   *
   * @param expandParent {@code true} to expand the parent nodes, {@code false} otherwise.
   * @return This tree item with the node shown.
   */
  public N show(boolean expandParent) {
    if (isParent()) {
      super.expand();
    }
    if (expandParent) {
      getParent().ifPresent(itemParent -> itemParent.expandNode(true));
    }
    return (N) this;
  }

  /**
   * Clears the filter applied to this tree item and its children, restoring their original state.
   */
  public void clearFilter() {
    if (nonNull(originalState)) {
      if (isExpanded() != originalState.expanded) {
        if (this.equals(this.getRootNode().getActiveNode())) {
          this.expandNode();
        } else {
          toggleCollapse(originalState.expanded);
        }
      }
      this.originalState = null;
    }
    dui_hidden.remove(this);
    subNodes.forEach(TreeNode::clearFilter);
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
      this.originalState = new TreeNode.OriginalState(isExpanded());
    }

    if (isParent()) {
      found = getFilter().filter((N) this, searchToken) | filterChildren(searchToken);
    } else {
      found = getFilter().filter((N) this, searchToken);
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
   * Filters the children of this tree item based on a search token.
   *
   * @param searchToken The search token to filter children by.
   * @return True if any of the children match the search token, false otherwise.
   */
  public boolean filterChildren(String searchToken) {
    // We use the noneMatch here instead of anyMatch to make sure we are looping all children
    // instead of early exit on first matching one
    return subNodes.stream().filter(treeItem -> treeItem.filter(searchToken)).count() > 0;
  }

  /**
   * Checks if this tree item should be automatically expanded when it's found during a search
   * operation.
   *
   * @return True if this tree item should be automatically expanded when found, false otherwise.
   */
  public boolean isAutoExpandFound() {
    return getRootNode().isAutoExpandFound();
  }

  /**
   * Retrieves the filter associated with this tree item, which is typically inherited from its
   * parent.
   *
   * @return The filter associated with this tree item.
   */
  public TreeItemFilter<N> getFilter() {
    return parent.getFilter();
  }

  /**
   * Retrieves the value associated with this tree item.
   *
   * @return The value associated with this tree item.
   */
  public V getValue() {
    return value;
  }

  /**
   * Sets the value associated with this tree item.
   *
   * @param value The new value to set.
   */
  public void setValue(V value) {
    this.value = value;
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
   * Retrieves the text element associated with this tree item.
   *
   * @return The text element.
   */
  public SpanElement getTextElement() {
    return textElement.get();
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
   * Pauses selection listeners for this tree item.
   *
   * @return The current TreeItem instance after pausing selection listeners.
   */
  @Override
  public N pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return (N) this;
  }

  /**
   * Resumes selection listeners for this tree item.
   *
   * @return The current TreeItem instance after resuming selection listeners.
   */
  @Override
  public N resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return (N) this;
  }

  /**
   * Toggles the pause state of selection listeners.
   *
   * @param toggle True to pause selection listeners, false to resume them.
   * @return The current TreeItem instance after toggling selection listeners.
   */
  @Override
  public N togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return (N) this;
  }

  /**
   * Retrieves the set of selection listeners associated with this tree item.
   *
   * @return The set of selection listeners.
   */
  @Override
  public Set<SelectionListener<? super N, ? super S>> getSelectionListeners() {
    return this.selectionListeners;
  }

  /**
   * Retrieves the set of deselection listeners associated with this tree item.
   *
   * @return The set of deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super N, ? super S>> getDeselectionListeners() {
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
  public N triggerSelectionListeners(N source, S selection) {
    if (!isSelectionListenersPaused()) {
      this.selectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return (N) this;
  }

  /**
   * Triggers deselection listeners for this tree item when a deselection event occurs.
   *
   * @param source The source tree item that triggered the event.
   * @param selection The deselected tree item.
   * @return The current TreeItem instance after triggering deselection listeners.
   */
  @Override
  public N triggerDeselectionListeners(N source, S selection) {
    if (!isSelectionListenersPaused()) {
      this.deselectionListeners.forEach(
          selectionListener ->
              selectionListener.onSelectionChanged(Optional.ofNullable(source), selection));
    }
    return (N) this;
  }

  @Override
  public HTMLLIElement element() {
    return this.element.element();
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
