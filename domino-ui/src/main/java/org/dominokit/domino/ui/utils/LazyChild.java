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
 * LazyChild class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class LazyChild<T extends IsElement<?>> extends BaseLazyInitializer<LazyChild<T>> {

  private T element;

  /**
   * of.
   *
   * @param element a T object
   * @param parent a {@link org.dominokit.domino.ui.IsElement} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public static <T extends IsElement<?>> LazyChild<T> of(T element, IsElement<?> parent) {
    return new LazyChild<>(element, () -> parent);
  }

  /**
   * of.
   *
   * @param element a T object
   * @param parent a {@link java.util.function.Supplier} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public static <T extends IsElement<?>> LazyChild<T> of(T element, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(element, parent);
  }

  /**
   * of.
   *
   * @param element a T object
   * @param parent a {@link org.dominokit.domino.ui.utils.LazyChild} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public static <T extends IsElement<?>> LazyChild<T> of(T element, LazyChild<?> parent) {
    return new LazyChild<>(element, parent);
  }

  /**
   * ofInsertFirst.
   *
   * @param element a T object
   * @param parent a {@link org.dominokit.domino.ui.IsElement} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      T element, IsElement<?> parent) {
    return new LazyChild<>(
        element, () -> parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * ofInsertFirst.
   *
   * @param element a T object
   * @param parent a {@link java.util.function.Supplier} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      T element, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(
        element, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * ofInsertFirst.
   *
   * @param element a T object
   * @param parent a {@link org.dominokit.domino.ui.utils.LazyChild} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(
      T element, LazyChild<?> parent) {
    return new LazyChild<>(
        element, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  /**
   * Constructor for LazyChild.
   *
   * @param element a T object
   * @param parent a {@link java.util.function.Supplier} object
   */
  public LazyChild(T element, Supplier<IsElement<?>> parent) {
    this(element, parent, (p, child) -> elements.elementOf(p).appendChild(child));
    this.element = element;
  }

  /**
   * Constructor for LazyChild.
   *
   * @param element a T object
   * @param parent a {@link java.util.function.Supplier} object
   * @param appendStrategy a {@link org.dominokit.domino.ui.utils.LazyChild.AppendStrategy} object
   */
  public LazyChild(T element, Supplier<IsElement<?>> parent, AppendStrategy<T> appendStrategy) {
    super(() -> appendStrategy.onAppend(parent.get().element(), element));
    this.element = element;
  }

  /**
   * Constructor for LazyChild.
   *
   * @param element a T object
   * @param parent a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public LazyChild(T element, LazyChild<?> parent) {
    this(element, parent, (p, child) -> elements.elementOf(p).appendChild(child));
  }

  /**
   * Constructor for LazyChild.
   *
   * @param element a T object
   * @param parent a {@link org.dominokit.domino.ui.utils.LazyChild} object
   * @param appendStrategy a {@link org.dominokit.domino.ui.utils.LazyChild.AppendStrategy} object
   */
  public LazyChild(T element, LazyChild<?> parent, AppendStrategy<T> appendStrategy) {
    super(() -> appendStrategy.onAppend(parent.get().element(), element));
    this.element = element;
  }

  /**
   * get.
   *
   * @return a T object
   */
  public T get() {
    apply();
    return element;
  }

  /**
   * remove.
   *
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public LazyChild<T> remove() {
    if (isInitialized()) {
      element.element().remove();
      reset();
    }
    return this;
  }

  /**
   * element.
   *
   * @return a T object
   */
  public T element() {
    return element;
  }

  /**
   * initOrRemove.
   *
   * @param state a boolean
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public LazyChild<T> initOrRemove(boolean state) {
    if (state) {
      get();
    } else {
      remove();
    }
    return this;
  }

  public interface AppendStrategy<C> {
    void onAppend(Element parent, C child);
  }
}
