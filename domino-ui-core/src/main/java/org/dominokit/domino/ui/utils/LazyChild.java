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

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Element;
import java.util.function.Supplier;
import org.dominokit.domino.ui.IsElement;

/**
 * The {@code LazyChild} class allows for the lazy initialization and management of child elements
 * within a parent element. Child elements are initialized on-demand, improving performance when
 * working with complex UI structures.
 *
 * @param <T> The type of the child element, which must implement the {@link
 *     org.dominokit.domino.ui.IsElement} interface.
 */
public class LazyChild<T extends IsElement<?>> extends BaseLazyInitializer<LazyChild<T>> {

  private SupplyOnce<T> supplyOnce;

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and parent element.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent The parent element to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(T element, IsElement<?> parent) {
    return new LazyChild<>(SupplyOnce.of(() -> element), () -> parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a supplier for
   * the parent element.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent A supplier that provides the parent element to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(T element, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(SupplyOnce.of(() -> element), parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a parent {@code
   * LazyChild}.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(T element, LazyChild<?> parent) {
    return new LazyChild<>(SupplyOnce.of(() -> element), parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and parent element,
   * inserting it as the first child.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent The parent element to which the child will be inserted as the first child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      T element, IsElement<?> parent) {
    return new LazyChild<>(
        SupplyOnce.of(() -> element),
        () -> parent,
        (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a supplier for
   * the parent element, inserting it as the first child.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent A supplier that provides the parent element to which the child will be inserted
   *     as the first child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      T element, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(
        SupplyOnce.of(() -> element),
        parent,
        (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a parent {@code
   * LazyChild}, inserting it as the first child.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent The parent {@code LazyChild} to which the child will be inserted as the first
   *     child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      T element, LazyChild<?> parent) {
    return new LazyChild<>(
        SupplyOnce.of(() -> element),
        parent,
        (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element and parent element
   * supplier.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent A supplier that provides the parent element to which the child will be added.
   */
  public LazyChild(T element, Supplier<IsElement<?>> parent) {
    this(
        SupplyOnce.of(() -> element),
        parent,
        (p, child) -> elements.elementOf(p).appendChild(child));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element, parent element
   * supplier, and append strategy.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent A supplier that provides the parent element to which the child will be added.
   * @param appendStrategy The strategy for adding the child element to the parent.
   */
  public LazyChild(T element, Supplier<IsElement<?>> parent, AppendStrategy<T> appendStrategy) {
    this(SupplyOnce.of(() -> element), parent, appendStrategy);
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element and a parent
   * {@code LazyChild}.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   */
  public LazyChild(T element, LazyChild<?> parent) {
    this(
        SupplyOnce.of(() -> element),
        parent,
        (p, child) -> elements.elementOf(p).appendChild(child));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element, parent {@code
   * LazyChild}, and append strategy.
   *
   * @param element The child element to be lazily initialized and managed.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   * @param appendStrategy The strategy for adding the child element to the parent.
   */
  public LazyChild(T element, LazyChild<?> parent, AppendStrategy<T> appendStrategy) {
    this(SupplyOnce.of(() -> element), parent, appendStrategy);
  }

  // ======================================

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and parent element.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent element to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(
      Supplier<T> supplier, IsElement<?> parent) {
    return new LazyChild<>(supplier, () -> parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a supplier for
   * the parent element.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(
      Supplier<T> supplier, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(supplier, parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a parent {@code
   * LazyChild}.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(
      Supplier<T> supplier, LazyChild<?> parent) {
    return new LazyChild<>(supplier, parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and parent element,
   * inserting it as the first child.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent element to which the child will be inserted as the first child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      Supplier<T> supplier, IsElement<?> parent) {
    return new LazyChild<>(
        supplier, () -> parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a supplier for
   * the parent element, inserting it as the first child.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be inserted
   *     as the first child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      Supplier<T> supplier, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(
        supplier, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a parent {@code
   * LazyChild}, inserting it as the first child.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be inserted as the first
   *     child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      Supplier<T> supplier, LazyChild<?> parent) {
    return new LazyChild<>(
        supplier, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element and parent element
   * supplier.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be added.
   */
  public LazyChild(Supplier<T> supplier, Supplier<IsElement<?>> parent) {
    this(supplier, parent, (p, child) -> elements.elementOf(p).appendChild(child));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element, parent element
   * supplier, and append strategy.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be added.
   * @param appendStrategy The strategy for adding the child element to the parent.
   */
  public LazyChild(
      Supplier<T> supplier, Supplier<IsElement<?>> parent, AppendStrategy<T> appendStrategy) {
    this(SupplyOnce.of(supplier), parent, appendStrategy);
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element and a parent
   * {@code LazyChild}.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   */
  public LazyChild(Supplier<T> supplier, LazyChild<?> parent) {
    this(supplier, parent, (p, child) -> elements.elementOf(p).appendChild(child));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element, parent {@code
   * LazyChild}, and append strategy.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   * @param appendStrategy The strategy for adding the child element to the parent.
   */
  public LazyChild(Supplier<T> supplier, LazyChild<?> parent, AppendStrategy<T> appendStrategy) {
    this(SupplyOnce.of(supplier), parent, appendStrategy);
  }

  // ======================================

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and parent element.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent element to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(
      SupplyOnce<T> supplier, IsElement<?> parent) {
    return new LazyChild<>(supplier, () -> parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a supplier for
   * the parent element.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(
      SupplyOnce<T> supplier, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(supplier, parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a parent {@code
   * LazyChild}.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> of(
      SupplyOnce<T> supplier, LazyChild<?> parent) {
    return new LazyChild<>(supplier, parent);
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and parent element,
   * inserting it as the first child.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent element to which the child will be inserted as the first child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      SupplyOnce<T> supplier, IsElement<?> parent) {
    return new LazyChild<>(
        supplier, () -> parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a supplier for
   * the parent element, inserting it as the first child.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be inserted
   *     as the first child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      SupplyOnce<T> supplier, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(
        supplier, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Creates a new {@code LazyChild} instance with the specified child element and a parent {@code
   * LazyChild}, inserting it as the first child.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be inserted as the first
   *     child.
   * @return A new {@code LazyChild} instance.
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      SupplyOnce<T> supplier, LazyChild<?> parent) {
    return new LazyChild<>(
        supplier, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element and parent element
   * supplier.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be added.
   */
  public LazyChild(SupplyOnce<T> supplier, Supplier<IsElement<?>> parent) {
    this(supplier, parent, (p, child) -> elements.elementOf(p).appendChild(child));
    this.supplyOnce = supplier;
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element, parent element
   * supplier, and append strategy.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent A supplier that provides the parent element to which the child will be added.
   * @param appendStrategy The strategy for adding the child element to the parent.
   */
  public LazyChild(
      SupplyOnce<T> supplier, Supplier<IsElement<?>> parent, AppendStrategy<T> appendStrategy) {
    super(() -> appendStrategy.onAppend(parent.get().element(), supplier.get()));
    this.supplyOnce = supplier;
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element and a parent
   * {@code LazyChild}.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   */
  public LazyChild(SupplyOnce<T> supplier, LazyChild<?> parent) {
    this(supplier, parent, (p, child) -> elements.elementOf(p).appendChild(child));
  }

  /**
   * Constructs a new {@code LazyChild} instance with the specified child element, parent {@code
   * LazyChild}, and append strategy.
   *
   * @param supplier the function to create the element only once {@link SupplyOnce}.
   * @param parent The parent {@code LazyChild} to which the child will be added.
   * @param appendStrategy The strategy for adding the child element to the parent.
   */
  public LazyChild(SupplyOnce<T> supplier, LazyChild<?> parent, AppendStrategy<T> appendStrategy) {
    super(() -> appendStrategy.onAppend(parent.get().element(), supplier.get()));
    this.supplyOnce = supplier;
  }

  /**
   * Gets the lazily initialized child element. If the child element has not been initialized, it
   * will be created and added to the parent element.
   *
   * @return The child element.
   */
  public T get() {
    apply();
    return supplyOnce.get();
  }

  /**
   * Removes the child element from its parent element. If the child element has not been
   * initialized, this method has no effect.
   *
   * @return This {@code LazyChild} instance.
   */
  public LazyChild<T> remove() {
    if (isInitialized()) {
      supplyOnce.get().element().remove();
      reset();
    }
    return this;
  }

  /**
   * Gets the child element without initializing it. If the child element has not been initialized,
   * this method returns {@code null}.
   *
   * @return The child element or {@code null} if not initialized.
   */
  public T element() {
    return supplyOnce.get();
  }

  /**
   * Initializes or removes the child element based on the specified state. If {@code state} is
   * {@code true}, the child element will be lazily initialized; otherwise, it will be removed from
   * the parent element.
   *
   * @param state {@code true} to initialize the child element, {@code false} to remove it.
   * @return This {@code LazyChild} instance.
   */
  public LazyChild<T> initOrRemove(boolean state) {
    if (state) {
      get();
    } else {
      remove();
    }
    return this;
  }

  /**
   * An interface for defining strategies to append a child element to a parent element.
   *
   * @param <C> The type of the child element.
   */
  public interface AppendStrategy<C> {
    /**
     * Appends the child element to the parent element.
     *
     * @param parent The parent element.
     * @param child The child element.
     */
    void onAppend(Element parent, C child);
  }
}
