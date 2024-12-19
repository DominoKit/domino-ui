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

import static java.util.Objects.nonNull;

import java.util.Optional;
import org.dominokit.domino.ui.icons.Icon;

public class TreeItem<V> extends TreeNode<V, TreeItem<V>, TreeItem<V>> {

  /**
   * Creates a new TreeItem instance with the given title.
   *
   * @param title The title of the tree item.
   * @return A new TreeItem instance with the specified title.
   */
  public static TreeItem<String> create(String title) {
    TreeItem<String> treeItem = new TreeItem<>(title);
    treeItem.setValue(title);
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
    treeItem.setValue(title);
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
    treeItem.setValue("");
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

  /**
   * Constructs a new TreeItem instance with an icon and title.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param title The title of the tree item.
   */
  public TreeItem(Icon<?> icon, String title) {
    super(icon, title);
  }

  /**
   * Constructs a new TreeItem instance with a title.
   *
   * @param title The title of the tree item.
   */
  public TreeItem(String title) {
    super(title);
  }

  /**
   * Constructs a new TreeItem instance with an icon.
   *
   * @param icon The icon to be displayed for the tree item.
   */
  public TreeItem(Icon<?> icon) {
    super(icon);
  }

  /**
   * Constructs a new TreeItem instance with a title and a value.
   *
   * @param title The title of the tree item.
   * @param value The value associated with the tree item.
   */
  public TreeItem(String title, V value) {
    super(title, value);
  }

  /**
   * Constructs a new TreeItem instance with an icon, title, and a value.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param title The title of the tree item.
   * @param value The value associated with the tree item.
   */
  public TreeItem(Icon<?> icon, String title, V value) {
    super(icon, title, value);
  }

  /**
   * Constructs a new TreeItem instance with an icon and a value.
   *
   * @param icon The icon to be displayed for the tree item.
   * @param value The value associated with the tree item.
   */
  public TreeItem(Icon<?> icon, V value) {
    super(icon, value);
  }

  /**
   * Retrieves the selected tree item. In the context of a single tree item, this method returns the
   * current tree item itself.
   *
   * @return The selected tree item.
   */
  @Override
  public TreeItem<V> getSelection() {
    return this;
  }

  @Override
  protected void activateNode() {
    if (nonNull(this.getActiveNode())) {
      TreeItem<V> source = this.activeNode;
      this.activeNode.deactivate();
      this.activeNode = null;
      triggerDeselectionListeners(source, getSelection());
    }
    if (getParent().isPresent()) {
      getParent().get().setActiveNode(this);
      triggerSelectionListeners(this, getSelection());
    } else {
      getRootNode().setActiveNode(this);
    }
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
  public void setActiveNode(TreeItem<V> activeItem, boolean silent) {
    TreeItem<V> source = null;
    if (nonNull(activeItem)) {
      if (nonNull(this.activeNode) && !this.activeNode.equals(activeItem)) {
        source = this.activeNode;
        this.activeNode.deactivate();
      }
      this.activeNode = activeItem;
      this.activeNode.activate();
      getParent().ifPresent(itemParent -> itemParent.setActiveNode(this, true));
      if (!silent) {
        triggerSelectionListeners(activeItem, getSelection());
        getRootNode().onActiveNodeChanged(activeItem, getSelection(), silent);
        Optional.ofNullable(source)
            .ifPresent(
                item -> {
                  triggerDeselectionListeners(item, getSelection());
                  getRootNode().onDeselectionChanged(item, getSelection());
                });
      }
    }
  }
}
