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

/**
 * An abstract base class for creating tree items (nodes) in a hierarchical tree structure.
 *
 * <p>Key responsibilities:
 *
 * <ul>
 *   <li>Maintaining and rendering a list of child nodes
 *   <li>Supporting activation (e.g., selection or highlighting) of the node
 *   <li>Managing collapse/expand behavior for child nodes (if any)
 *   <li>Customizable icon logic (which can change on expand/collapse)
 *   <li>Filtering of nodes (for searching or hiding certain items)
 *   <li>Selection event listeners (if implementing classes require selection logic)
 *   <li>Integration with a {@link TreeConfig} for configuring default behaviors (collapsing, icon
 *       strategy, etc.)
 * </ul>
 *
 * <p>Typical usage involves subclassing to implement a specific kind of tree node (e.g., see {@link
 * org.dominokit.domino.ui.tree.TreeItem}).
 *
 * @param <V> the data type associated with each node
 * @param <N> the type of the node itself (for fluent API use)
 * @param <S> the selection type or structure, commonly the node type or a list of nodes
 */
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
  private final Set<SelectionListener<? super N, ? super S>> selectionListeners = new HashSet<>();
  private final Set<SelectionListener<? super N, ? super S>> deselectionListeners = new HashSet<>();

  /**
   * Internal event listener for clicks on the anchor area (when {@link ToggleTarget#ANY} is in
   * effect).
   */
  private final EventListener anchorListener =
      evt -> {
        if (ToggleTarget.ANY.equals(this.toggleTarget)) {
          evt.stopPropagation();
          onActivation();
        }
      };

  /**
   * Handles the logic when a tree node is "activated" (clicked or otherwise triggered), toggling
   * expand/collapse if it's a parent node and then calling {@link #activateNode()} to highlight the
   * node.
   */
  private void onActivation() {
    if (isParent()) {
      toggle();
    }
    activateNode();
  }

  /**
   * Internal event listener for clicks on the node icon (when {@link ToggleTarget#ICON} is in
   * effect).
   */
  private final EventListener iconListener =
      evt -> {
        if (ToggleTarget.ICON.equals(this.toggleTarget)) {
          evt.stopPropagation();
          onActivation();
        }
      };

  /**
   * Base constructor that sets up the core DOM elements (list item, anchor, content, subtree list)
   * and default behavior (collapsed, wave effect, etc.).
   */
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

    // default collapsible strategy
    setCollapseStrategy(getConfig().getTreeDefaultCollapseStrategy(this).get());
    setAttribute(Collapsible.DUI_COLLAPSED, "true");
  }

  /**
   * Constructs a new {@code TreeNode} with an icon and a title.
   *
   * @param icon the icon to display
   * @param title the text label for this node
   */
  public TreeNode(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
    init();
  }

  /**
   * Constructs a new {@code TreeNode} with a title only (no icon).
   *
   * @param title the text label for this node
   */
  public TreeNode(String title) {
    this();
    setTitle(title);
    init();
  }

  /**
   * Constructs a new {@code TreeNode} with an icon only (no title).
   *
   * @param icon the icon to display
   */
  public TreeNode(Icon<?> icon) {
    this();
    setIcon(icon);
    init();
  }

  /**
   * Constructs a new {@code TreeNode} with a title and a data value.
   *
   * @param title the text label for this node
   * @param value the data value associated with the node
   */
  public TreeNode(String title, V value) {
    this(title);
    this.value = value;
  }

  /**
   * Constructs a new {@code TreeNode} with an icon, title, and a data value.
   *
   * @param icon the icon to display
   * @param title the text label
   * @param value the data value
   */
  public TreeNode(Icon<?> icon, String title, V value) {
    this(icon, title);
    this.value = value;
  }

  /**
   * Constructs a new {@code TreeNode} with an icon and a data value (no title).
   *
   * @param icon the icon to display
   * @param value the data value
   */
  public TreeNode(Icon<?> icon, V value) {
    this(icon);
    this.value = value;
  }

  /**
   * Allows post-construction initialization logic. By default, sets up listeners for collapsing and
   * expanding events, plus a click listener on the anchor element. Subclasses can override or
   * extend this method for further setup.
   */
  protected void init() {
    addBeforeCollapseListener(() -> updateIcon(true));
    addBeforeExpandListener(() -> updateIcon(false));
    anchorElement.addClickListener(anchorListener);
    applyWaves();
  }

  /**
   * Sets the visible label (title) of this node.
   *
   * @param title the title text
   * @return this node (for fluent API)
   */
  public N setTitle(String title) {
    this.title = title;
    textElement.get().setTextContent(title);
    return (N) this;
  }

  /**
   * Retrieves the current title (visible label) for this node.
   *
   * @return the title string
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the parent node of this item (e.g., another node or a root). Internal use within the tree
   * structure.
   *
   * @param parentNode the parent node
   */
  void setParent(IsParentNode<V, N, S> parentNode) {
    this.parent = parentNode;
  }

  /**
   * Subclasses must implement how a node is "activated" (e.g., highlighting or selection). Called
   * after we ensure toggling is done for a parent node.
   */
  protected abstract void activateNode();

  /**
   * Deactivates this node if it's currently active, removing the {@code dui_active} CSS class. If
   * this node has child nodes, they are also deactivated, and if the tree is configured for auto
   * collapse, the node collapses. Updates the icon accordingly.
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
   * Adds a child node to this node, re-parenting the child. Also updates the icon if this node was
   * previously a leaf. If the tree's root has an icon supplier, it's applied to new child nodes as
   * well.
   *
   * @param node the child node to add
   * @return this node (for fluent API)
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

  /**
   * Adds multiple child nodes at once.
   *
   * @param treeItems the child nodes to add
   * @return this node (for fluent API)
   */
  public N appendChild(N... treeItems) {
    Arrays.stream(treeItems).forEach(this::appendChild);
    return (N) this;
  }

  /**
   * Removes a specified child node from this node. If no children remain after removal, the node is
   * collapsed.
   *
   * @param item the child node to remove
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
   * Removes all child nodes from this node.
   *
   * @return this node (for fluent API)
   */
  public N clear() {
    new ArrayList<>(subNodes).forEach(TreeNode::remove);
    return (N) this;
  }

  /**
   * Removes this node from its parent, if it has one.
   *
   * @return this node (for fluent API)
   */
  @Override
  public N remove() {
    getParent().ifPresent(itemParent -> itemParent.removeNode((N) this));
    return (N) super.remove();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns a {@link PrefixElement} that wraps the node's content area, allowing insertion of
   * custom elements (e.g., icons) before the text.
   */
  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(contentElement);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns a {@link PostfixElement} that wraps the node's content area, allowing insertion of
   * custom elements (e.g., badges) after the text.
   */
  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(contentElement);
  }

  /**
   * Updates the icon state for this node based on whether it's expanded, collapsed, or active. If
   * the icon is a {@link ToggleIcon}, it toggles; if it's a {@link StateChangeIcon}, updates the
   * state accordingly.
   *
   * @param collapsed {@code true} if the node is collapsed, {@code false} if expanded
   */
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
   * Inserts a separator (e.g., a horizontal line or spacing) into the subtree of this node.
   *
   * @param separator a {@link Separator} object
   * @return this node (for fluent API)
   */
  public N appendChild(Separator separator) {
    subTree.appendChild(separator);
    return (N) this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the root of the entire tree structure. Typically used for configuration or top-level
   * behaviors.
   */
  @Override
  public RootNode<V, N, S> getRootNode() {
    return parent.getRootNode();
  }

  /**
   * Retrieves this node's optional parent. If the parent is a {@code TreeNode}, returns a non-empty
   * {@link Optional}; otherwise, it may be empty if this node is top-level.
   *
   * @return an {@link Optional} containing the parent node if it exists
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
   * Retrieves a list of nodes forming the path from the root to this node, including this node.
   *
   * @return an ordered list of nodes from the tree root to this node
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
   * Retrieves a list of values from the root to this node, including this node's value.
   *
   * @return an ordered list of values from the tree root to this node
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
   * Returns the direct children of this node (sub-nodes).
   *
   * @return a list of child nodes
   */
  public List<N> getSubNodes() {
    return subNodes;
  }

  /**
   * Activates (selects) this tree item without activating its parent items. This method returns
   * void.
   */
  public void doActivate() {
    doActivate(false);
  }

  /**
   * Activates this node in the UI, optionally indicating whether parent nodes should also be
   * expanded or marked active. Primarily for internal use.
   *
   * @param activateParent whether to propagate activation up the tree
   */
  protected void doActivate(boolean activateParent) {
    addCss(dui_active);
    if (activateParent) {
      getParent().ifPresent(parent -> parent.setActiveNode((N) this));
    }
    updateIcon(isCollapsed());
  }

  /**
   * Activates this node, showing it if necessary and performing the default "onActivation" logic.
   *
   * @return this node (for fluent API)
   */
  public N activate() {
    this.show(true);
    onActivation();
    return (N) this;
  }

  /**
   * @return this node
   * @deprecated use {@link #activate()}
   */
  @Deprecated
  public N select() {
    activate();
    return (N) this;
  }

  /**
   * Retrieves the currently active (or highlighted) child node of this node, or {@code null} if
   * none is active.
   *
   * @return the active node, or null
   */
  public N getActiveNode() {
    return activeNode;
  }

  /**
   * Sets the target that toggles expand/collapse behavior. If {@link ToggleTarget#ICON} is chosen,
   * wave effects are removed from the anchor area, and the node icon becomes clickable instead.
   *
   * @param toggleTarget the new toggle target
   * @return this node (for fluent API)
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

  /** Toggles expand/collapse if this node has child nodes; otherwise, no operation. */
  private void toggle() {
    if (isParent()) {
      toggleCollapse();
    }
  }

  /**
   * Checks if this node has one or more children.
   *
   * @return {@code true} if it has children, {@code false} otherwise
   */
  boolean isParent() {
    return !subNodes.isEmpty();
  }

  /**
   * Checks if this node is a leaf, meaning it has no children.
   *
   * @return {@code true} if no children, {@code false} otherwise
   */
  public boolean isLeaf() {
    return subNodes.isEmpty();
  }

  /**
   * Applies a wave effect (hover ripple) to the anchor. Subclasses can override or disable this if
   * needed.
   */
  protected void applyWaves() {
    withWaves((item, waves) -> waves.setWaveStyle(WaveStyle.BLOCK));
  }

  /**
   * Called when the tree's icon supplier changes, updating this node's icon accordingly, then
   * recursing into child nodes. No operation if the new icon is null.
   *
   * @param iconSupplier a supplier that provides icons for nodes
   */
  void onSuppliedIconChanged(NodeIconSupplier<V, N, S> iconSupplier) {
    Icon<?> icon = iconSupplier.createIcon((N) this);
    if (nonNull(icon) && isNull(nodeIcon)) {
      setIcon(icon);
      subNodes.forEach(item -> item.onSuppliedIconChanged(iconSupplier));
    }
  }

  /**
   * Sets (or replaces) this node's icon. If an icon was previously set, it is removed. The new icon
   * is appended to the content element, and click logic is updated based on the current toggle
   * target.
   *
   * @param icon the new icon to display
   * @return this node (for fluent API)
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
   * {@inheritDoc}
   *
   * <p>Returns the anchor element for the node, which is used for wave effects (unless toggle
   * target is icon-only).
   */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return anchorElement.element();
  }

  /** Recursively collapses this node and all child sub-nodes. */
  public void collapseAll() {
    if (isParent() && !isCollapsed()) {
      addCss(dui_transition_none);
      subNodes.forEach(TreeNode::collapseAll);
      collapse();
      dui_transition_none.remove(this);
    }
  }

  /** Recursively expands this node and all child sub-nodes. */
  public void expandAll() {
    if (isParent() && isCollapsed()) {
      addCss(dui_transition_none);
      this.expandNode();
      subNodes.forEach(TreeNode::expandAll);
      dui_transition_none.remove(this);
    }
  }

  /**
   * Expands this node (shows children if any) by calling {@link #expand()} from {@link
   * Collapsible}.
   *
   * @return this node (for fluent API)
   */
  @Override
  public N expandNode() {
    return show(false);
  }

  /**
   * Expands this node. If {@code expandParent} is {@code true}, also expands all ancestors.
   *
   * @param expandParent whether to expand parent nodes too
   * @return this node (for fluent API)
   */
  @Override
  public N expandNode(boolean expandParent) {
    return show(expandParent);
  }

  /**
   * Ensures this node is shown (expanded) in the tree. Optionally expands the parent chain, then
   * calls {@link #expand()} if this node has children.
   *
   * @param expandParent if true, parent nodes are also expanded
   * @return this node (for fluent API)
   */
  public N show(boolean expandParent) {
    if (expandParent) {
      getParent().ifPresent(itemParent -> itemParent.expandNode(true));
    }

    if (isParent()) {
      super.expand();
    }
    return (N) this;
  }

  /**
   * Clears any previously applied filter state (restoring collapsed/expanded state and visibility)
   * for this node and its children.
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
   * Filters this node (and possibly its children) against a search token, showing nodes that match
   * or have matching descendants. If a match is found, the node is revealed, otherwise hidden.
   *
   * @param searchToken the token to search for
   * @return true if this node or any child matches the search token, false otherwise
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
   * Filters child nodes recursively, returning {@code true} if any child node matches.
   *
   * @param searchToken the token to filter by
   * @return true if any child matches, false otherwise
   */
  public boolean filterChildren(String searchToken) {
    return subNodes.stream().filter(treeItem -> treeItem.filter(searchToken)).count() > 0;
  }

  /**
   * Indicates whether matching nodes should automatically be expanded (when found by a filter).
   *
   * @return true if auto-expand is enabled for found nodes
   */
  public boolean isAutoExpandFound() {
    return getRootNode().isAutoExpandFound();
  }

  /**
   * Retrieves the filter logic from the parent or root node.
   *
   * @return a {@link TreeItemFilter} used to evaluate matches
   */
  public TreeItemFilter<N> getFilter() {
    return parent.getFilter();
  }

  /**
   * Gets the data value associated with this node.
   *
   * @return the node's value
   */
  public V getValue() {
    return value;
  }

  /**
   * Sets a data value for this node.
   *
   * @param value the new value
   */
  public void setValue(V value) {
    this.value = value;
  }

  /**
   * {@inheritDoc}
   *
   * <p>By default, wave effects apply to the anchor, unless {@link ToggleTarget#ICON} is selected.
   */
  @Override
  public Element getWavesElement() {
    return anchorElement.element();
  }

  /**
   * Gets the {@link SpanElement} holding the text content (the "label") of this node.
   *
   * @return the text element
   */
  public SpanElement getTextElement() {
    return textElement.get();
  }

  /**
   * Retrieves the unordered list element that holds this node's children.
   *
   * @return the sub-tree element
   */
  public UListElement getSubTree() {
    return subTree;
  }

  /**
   * Pauses any selection (activation) listeners for this node, so changes do not trigger events.
   *
   * @return this node
   */
  @Override
  public N pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return (N) this;
  }

  /**
   * Resumes any selection (activation) listeners previously paused.
   *
   * @return this node
   */
  @Override
  public N resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return (N) this;
  }

  /**
   * Toggles the paused state of selection listeners.
   *
   * @param toggle if true, listeners are paused; if false, they are resumed
   * @return this node
   */
  @Override
  public N togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return (N) this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the set of selection listeners associated with this node.
   */
  @Override
  public Set<SelectionListener<? super N, ? super S>> getSelectionListeners() {
    return this.selectionListeners;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the set of deselection listeners associated with this node.
   */
  @Override
  public Set<SelectionListener<? super N, ? super S>> getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Indicates whether selection listeners are currently paused.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return this.selectionListenersPaused;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Notifies all registered selection listeners of a selection event, unless listeners are
   * paused.
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
   * {@inheritDoc}
   *
   * <p>Notifies all registered deselection listeners of a deselection event, unless listeners are
   * paused.
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

  /**
   * {@inheritDoc}
   *
   * <p>Returns the underlying {@code <li>} element for this node.
   */
  @Override
  public HTMLLIElement element() {
    return this.element.element();
  }

  /**
   * Stores this node's original expanded/collapsed state before any filter was applied, so it can
   * be restored via {@link #clearFilter()}.
   */
  private static class OriginalState {
    private final boolean expanded;

    /**
     * Constructs an {@code OriginalState} representing the node's expand/collapse state.
     *
     * @param expanded {@code true} if originally expanded, {@code false} if collapsed
     */
    public OriginalState(boolean expanded) {
      this.expanded = expanded;
    }
  }
}
