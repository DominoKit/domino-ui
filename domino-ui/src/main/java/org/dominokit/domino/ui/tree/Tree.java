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

public class Tree<V> extends TreeRoot<V, TreeItem<V>, Tree<V>, TreeItem<V>> {

  /**
   * Creates a new instance of Tree with the specified title and associated data value.
   *
   * @param title The title of the tree.
   * @param value The data value associated with the tree.
   * @param <V> The type of data associated with each tree item.
   * @return A new Tree instance.
   */
  public static <V> Tree<V> create(String title, V value) {
    return new Tree<>(title, value);
  }

  /**
   * Creates a new instance of Tree with the specified title.
   *
   * @param title The title of the tree.
   * @param <V> The type of data associated with each tree item.
   * @return A new Tree instance.
   */
  public static <V> Tree<V> create(String title) {
    return new Tree<>(title);
  }

  /**
   * Creates a new empty instance of Tree.
   *
   * @param <V> The type of data associated with each tree item.
   * @return A new Tree instance.
   */
  public static <V> Tree<V> create() {
    return new Tree<>();
  }

  /** Creates a new empty tree. */
  public Tree() {
    super();
  }

  /**
   * Creates a new tree with the given title.
   *
   * @param treeTitle The title of the tree.
   */
  public Tree(String treeTitle) {
    super(treeTitle);
  }

  /**
   * Creates a new tree with the given title and associated data value.
   *
   * @param treeTitle The title of the tree.
   * @param value The data value associated with the tree.
   */
  public Tree(String treeTitle, V value) {
    super(treeTitle, value);
  }

  /**
   * Gets the currently selected tree item in the tree.
   *
   * @return The currently selected tree item, or {@code null} if none is selected.
   */
  @Override
  public TreeItem<V> getSelection() {
    return this.getActiveNode();
  }

  @Override
  public void onActiveNodeChanged(TreeItem<V> source, TreeItem<V> selection, boolean silent) {
    withPauseSelectionListenersToggle(
        silent,
        field -> {
          triggerSelectionListeners(source, selection);
        });
  }
}
