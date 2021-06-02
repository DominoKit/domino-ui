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
 * @see ParentTreeItem
 * @see CanActivate
 * @see CanDeactivate
 * @see HasClickableElement
 */
public class TreeItem<T> extends WavesElement<HTMLLIElement, TreeItem<T>>
    implements ParentTreeItem<TreeItem<T>>, CanActivate, CanDeactivate, HasClickableElement {

  private String title;
  private HTMLLIElement element;
  private final DominoElement<HTMLAnchorElement> anchorElement;
  private final List<TreeItem<T>> subItems = new LinkedList<>();
  private TreeItem<T> activeTreeItem;
  private ParentTreeItem<TreeItem<T>> parent;
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
      DominoElement.of(span().css("tree-indicator"));

  public TreeItem(String title, BaseIcon<?> icon) {
    this.title = title;
    setIcon(icon);
    HTMLElement titleElement = span().css("title").textContent(title).element();
    DominoElement<HTMLElement> toggleContainer = DominoElement.of(span().css("tree-tgl-icn"));
    this.anchorElement =
        DominoElement.of(
            a().add(this.icon)
                .add(div().css(Styles.ellipsis_text).style("margin-top: 2px;").add(titleElement))
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
                                      activateItem();
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
                                      activateItem();
                                    })))
                .add(indicatorContainer));
    init();
  }

  public TreeItem(String title) {
    this(title, Icons.ALL.folder().styler(style -> style.setProperty("visibility", "hidden")));
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
    childrenContainer = ul().css("ml-tree").element();
    element().appendChild(childrenContainer);
    collapsible =
        Collapsible.create(childrenContainer)
            .addHideHandler(
                () -> {
                  Style.of(anchorElement).remove("toggled");
                  restoreIcon();
                })
            .addShowHandler(
                () -> {
                  Style.of(anchorElement).add("toggled");
                  replaceIcon(expandIcon);
                })
            .hide();
    anchorElement.addEventListener(
        "click",
        evt -> {
          if (ToggleTarget.ANY.equals(this.toggleTarget) && isParent()) {
            toggle();
          }
          activateItem();
        });
    init(this);
    setToggleTarget(ToggleTarget.ANY);
    setWaveColor(WaveColor.THEME);
    applyWaveStyle(WaveStyle.BLOCK);
  }

  private void activateItem() {
    if (nonNull(TreeItem.this.getActiveItem())) {
      TreeItem.this.activeTreeItem.deactivate();
      TreeItem.this.activeTreeItem = null;
    }
    parent.setActiveItem(TreeItem.this);
  }

  /**
   * Adds a child item to this one
   *
   * @param treeItem the child {@link TreeItem}
   * @return same instance
   */
  public TreeItem<T> appendChild(TreeItem<T> treeItem) {
    this.subItems.add(treeItem);
    childrenContainer.appendChild(treeItem.element());
    Style.of(anchorElement).add("tree-toggle");
    treeItem.parent = this;
    treeItem.setLevel(level + 1);
    Style.of(treeItem).add("tree-leaf");
    Style.of(this.element()).remove("tree-leaf");
    treeItem.setToggleTarget(this.toggleTarget);
    treeItem.setLevelPadding(levelPadding);
    this.style.add("tree-item-parent");
    return this;
  }

  /**
   * Adds new separator
   *
   * @return same instance
   */
  public TreeItem<T> addSeparator() {
    childrenContainer.appendChild(li().css("separator").add(a()).element());
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

      subItems.forEach(item -> item.setToggleTarget(toggleTarget));
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
    if (expandParent && nonNull(parent)) {
      parent.expand(true);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> expand() {
    return show();
  }

  /** {@inheritDoc} */
  @Override
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

  /** {@inheritDoc} */
  @Override
  public boolean isHidden() {
    return collapsible.isHidden();
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

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> getActiveItem() {
    return activeTreeItem;
  }

  /** {@inheritDoc} */
  @Override
  public Tree getTreeRoot() {
    return parent.getTreeRoot();
  }

  /** {@inheritDoc} */
  @Override
  public Optional<TreeItem<T>> getParent() {
    if (parent instanceof TreeItem) {
      return Optional.of((TreeItem<T>) parent);
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
    if (nonNull(activeItem)) {
      if (nonNull(this.activeTreeItem) && !this.activeTreeItem.equals(activeItem)) {
        this.activeTreeItem.deactivate();
      }
      this.activeTreeItem = activeItem;
      this.activeTreeItem.activate();
      parent.setActiveItem(this, true);
      if (!silent) {
        getTreeRoot().onTreeItemClicked(activeItem);
      }
    }
  }

  /** @return A list of tree items representing the path for this item */
  public List<TreeItem<T>> getPath() {
    List<TreeItem<T>> items = new ArrayList<>();
    items.add(this);
    Optional<TreeItem<T>> parent = getParent();

    while (parent.isPresent()) {
      items.add(parent.get());
      parent = parent.get().getParent();
    }

    Collections.reverse(items);

    return items;
  }

  /** @return A list of values representing the path for this item */
  public List<T> getPathValues() {
    List<T> values = new ArrayList<>();
    values.add(this.getValue());
    Optional<TreeItem<T>> parent = getParent();

    while (parent.isPresent()) {
      values.add(parent.get().getValue());
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
    Style.of(element()).add("active");
    if (isNull(expandIcon) || collapsible.isHidden() || !isParent()) {
      replaceIcon(this.activeIcon);
    }

    if (activateParent && nonNull(parent)) {
      parent.setActiveItem(this);
    }
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

  /** {@inheritDoc} */
  @Override
  public void deactivate() {
    Style.of(element()).remove("active");
    if (isNull(expandIcon) || collapsible.isHidden() || !isParent()) {
      restoreIcon();
    }
    if (isParent()) {
      subItems.forEach(TreeItem::deactivate);
      if (getTreeRoot().isAutoCollapse()) {
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
      this.originalIcon.styler(style -> style.setProperty("visibility", "hidden"));
    }
    this.originalIcon.addClickListener(
        evt -> {
          if (ToggleTarget.ICON.equals(this.toggleTarget)) {
            evt.stopPropagation();
            toggle();
          }
          activateItem();
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
    return !subItems.isEmpty();
  }

  void setParent(ParentTreeItem<TreeItem<T>> parentMenu) {
    this.parent = parentMenu;
  }

  /** @return the title of the item */
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
    if (isParent()) {
      found = getFilter().filter(this, searchToken) | filterChildren(searchToken);
    } else {
      found = getFilter().filter(this, searchToken);
    }

    if (found) {
      Style.of(element).removeProperty("display");
      if (isParent() && isAutoExpandFound() && collapsible.isHidden()) {
        collapsible.show();
      }
      return true;
    } else {
      Style.of(element).setDisplay("none");
      return false;
    }
  }

  /** {@inheritDoc} */
  @Override
  public boolean isAutoExpandFound() {
    return parent.isAutoExpandFound();
  }

  /** Clears the filter applied */
  public void clearFilter() {
    Style.of(element).removeProperty("display");
    subItems.forEach(TreeItem::clearFilter);
  }

  /**
   * Filters the children
   *
   * @param searchToken the search token
   * @return true of one of the children matches the search token, false otherwise
   */
  public boolean filterChildren(String searchToken) {
    return subItems.stream().anyMatch(treeItem -> treeItem.filter(searchToken));
  }

  /** Collapse all children */
  public void collapseAll() {
    if (isParent() && !collapsible.isHidden()) {
      hide();
      subItems.forEach(TreeItem::collapseAll);
    }
  }

  /** Expand all children */
  public void expandAll() {
    if (isParent() && collapsible.isHidden()) {
      show();
      subItems.forEach(TreeItem::expandAll);
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
      subItems.forEach(treeItem -> treeItem.setLevel(level + 1));
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
      subItems.forEach(treeItem -> treeItem.setLevelPadding(levelPadding));
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
    return subItems.isEmpty();
  }

  /** @return the list of all sub {@link TreeItem} */
  @Override
  public List<TreeItem<T>> getSubItems() {
    return new ArrayList<>(subItems);
  }

  /** Selects this item, the item will be shown and activated */
  public void select() {
    this.show(true).activate(true);
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

  /** {@inheritDoc} */
  @Override
  public void removeItem(TreeItem<T> item) {
    subItems.remove(item);
    item.remove();
  }

  /** {@inheritDoc} */
  @Override
  public TreeItem<T> remove() {
    if (parent.getSubItems().contains(this)) {
      parent.removeItem(this);
      if (parent.getSubItems().isEmpty() && parent instanceof TreeItem) {
        ((TreeItem<T>) parent).style.remove("tree-item-parent");
      }
    }
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

  /** {@inheritDoc} */
  @Override
  public TreeItemFilter<TreeItem<T>> getFilter() {
    return parent.getFilter();
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
}
