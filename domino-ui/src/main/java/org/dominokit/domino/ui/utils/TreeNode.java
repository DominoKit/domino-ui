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
package org.dominokit.domino.ui.utils;

import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * An interface representing a tree node. The interface does not contain any client specific code,
 * hence it is also suitable for backend java code.
 */
public interface TreeNode {
  /** @return the parent of this tree node */
  TreeNode getParentNode();

  /** @return the children of this tree node */
  <T extends TreeNode> List<T> getChildNodes();

  /**
   * @param predicate a predicate to test with
   * @return an {@code Optional} tree node matching the given predicate
   */
  default <T extends TreeNode> Optional<T> findAny(Predicate<TreeNode> predicate) {
    if (!skipped() && predicate.test(this)) return Optional.of((T) this);

    for (TreeNode childNode : getChildNodes()) {
      Optional<T> found = childNode.findAny(predicate);

      if (found.isPresent()) return found;
    }

    return Optional.empty();

    // Maybe just use java stream findAny method, or it has here poor performance?
    // return this.<T>flatMap().filter(predicate).findAny();
  }

  /**
   * @param predicate a predicate to test with
   * @return a {@code Stream} of descendant tree nodes matching the given predicate
   */
  default <T extends TreeNode> Stream<T> findAll(Predicate<TreeNode> predicate) {
    return this.<T>flatMap().filter(predicate);
  }

  /** @return a {@code Stream} of descendant tree nodes of this tree node */
  default <T extends TreeNode> Stream<T> flatMap() {
    Stream<T> stream = getChildNodes().stream().flatMap(TreeNode::flatMap);

    if (skipped()) return stream;

    return Stream.concat(Stream.of((T) this), stream);
  }

  /**
   * Create an array of predicate, based on a single creator, each predicate in array corresponding
   * with the value with the same index of the given values array.
   *
   * @param creator predicate creator
   * @param values predicate argument
   * @return an array of predicate, created by given creator and given values
   */
  default <T> Predicate<TreeNode>[] createPredicates(
      Function<T, Predicate<TreeNode>> creator, T... values) {
    Predicate<TreeNode>[] predicates = new Predicate[values.length];

    for (int i = 0; i < values.length; i++) {
      predicates[i] = creator.apply(values[i]);
    }

    return predicates;
  }

  /** @see #findExact(int, Predicate[]) */
  default <T extends TreeNode> Optional<T> findExact(Predicate<TreeNode>... predicates) {
    return findExact(0, predicates);
  }

  /**
   * Find an {@link Optional} tree node matching the last predicate of given predicates array, while
   * its parent matching the second-to-last, its grandparent matching the third-to-last, etc.
   *
   * <p>You may consider using predicates array similar to a file path /root/child1/grandchild,
   * which allows you to find the grandchild under child1, not the grandchild under child2.
   *
   * <p>If your tree model is set up that all your tree nodes can be unique identified by a
   * predicate, you may consider using {@link #findAny(Predicate)} instead.
   *
   * @param level corresponding with the index of a predicates array
   * @param predicates a predicates array to test with
   * @return an {@code Optional} tree node matching the last predicate of the given predicates array
   */
  default <T extends TreeNode> Optional<T> findExact(int level, Predicate<TreeNode>... predicates) {
    if (skipped() || level < predicates.length && predicates[level].test(this)) {
      if (!skipped() && ++level == predicates.length) return Optional.of((T) this);

      for (TreeNode childNode : getChildNodes()) {
        Optional<T> found = childNode.findExact(level, predicates);

        if (found.isPresent()) return found;
      }
    }

    return Optional.empty();
  }

  /**
   * @return if this tree node should be excluded by diverse loop operations like {@link
   *     #flatMap()}, {@link #findAny(Predicate)}, {@link #findExact(int, Predicate[])}, {@link
   *     #search(BiPredicate)}. Usually a root node should be excluded by a loop operation.
   */
  default boolean skipped() {
    return false;
  }

  /**
   * @param node a node to test with
   * @return a boolean value indicating whether a node is a descendant of a given node
   */
  default boolean contains(TreeNode node) {
    return findAny(n -> n == node).isPresent();
  }

  /**
   * Search this three node and all its descendant tree nodes. A {@link BiPredicate} is used, which
   * also holds an indicator if there is any match in its descendant tree nodes.
   *
   * @param predicate a predicate to test with
   * @return a boolean value indication whether there is any match of this tree node and its
   *     descendant tree nodes against the given predicate
   */
  default boolean search(BiPredicate<TreeNode, Boolean> predicate) {
    boolean found = false;

    for (TreeNode childNode : getChildNodes()) {
      found |= childNode.search(predicate);
    }

    return !skipped() && predicate.test(this, found);
  }

  /** @return the root of this tree node */
  default TreeNode getRootNode() {
    TreeNode parentNode = getParentNode();

    if (parentNode == null) return this;

    return parentNode.getRootNode();
  }

  /** @return a boolean value indicating of this tree node has child tree nodes or not */
  default boolean hasChildNodes() {
    return getChildNodes().size() > 0;
  }

  /**
   * @param node a child tree node to be appended to the end of the child tree node list of this
   *     tree node
   * @return the appended tree node
   */
  default TreeNode appendChild(TreeNode node) {
    getChildNodes().add(node);

    return node;
  }

  /**
   * @param node a child tree node to be removed from this tree node
   * @return the removed tree node
   */
  default TreeNode removeChild(TreeNode node) {
    getChildNodes().remove(node);

    return node;
  }

  /**
   * Iterate from the give tree node towards its ancestor node
   *
   * @param treeNode the start tree node, inclusive
   * @param predicate the predicate to test with
   * @param consumer the consumer to use with
   */
  static void iterate(
      TreeNode treeNode, Predicate<TreeNode> predicate, Consumer<TreeNode> consumer) {
    while (predicate.test(treeNode)) {
      consumer.accept(treeNode);
      treeNode = treeNode.getParentNode();
    }
  }
}
