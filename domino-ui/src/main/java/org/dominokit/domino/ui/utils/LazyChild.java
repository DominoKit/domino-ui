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

import java.util.function.Supplier;

import elemental2.dom.Element;
import org.dominokit.domino.ui.IsElement;

import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

public class LazyChild<T extends IsElement<?>> extends BaseLazyInitializer<LazyChild<T>> {

  private T element;

  public static <T extends IsElement<?>> LazyChild<T> of(T element, IsElement<?> parent) {
    return new LazyChild<>(element, () -> parent);
  }

  public static <T extends IsElement<?>> LazyChild<T> of(T element, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(element, parent);
  }

  public static <T extends IsElement<?>> LazyChild<T> of(T element, LazyChild<?> parent) {
    return new LazyChild<>(element, parent);
  }

  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(T element, IsElement<?> parent) {
    return new LazyChild<>(element, () -> parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(T element, Supplier<IsElement<?>> parent) {
    return new LazyChild<>(element, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  public static <T extends IsElement<?>> LazyChild<T> ofInsertFirst(T element, LazyChild<?> parent) {
    return new LazyChild<>(element, parent, (p, child) -> elements.elementOf(p).insertFirst(child.element()));
  }

  public LazyChild(T element, Supplier<IsElement<?>> parent) {
    this(element, parent, (p, child) -> elements.elementOf(p).appendChild(child));
    this.element = element;
  }

  public LazyChild(T element, Supplier<IsElement<?>> parent, AppendStrategy<T> appendStrategy) {
    super(() -> appendStrategy.onAppend(parent.get().element(), element));
    this.element = element;
  }

  public LazyChild(T element, LazyChild<?> parent) {
    this(element, parent, (p, child) -> elements.elementOf(p).appendChild(child));
  }

  public LazyChild(T element, LazyChild<?> parent, AppendStrategy<T> appendStrategy) {
    super(() -> appendStrategy.onAppend(parent.get().element(), element));
    this.element = element;
  }

  public T get() {
    apply();
    return element;
  }

  public LazyChild<T> remove() {
    if (isInitialized()) {
      element.element().remove();
      reset();
    }
    return this;
  }

  public T element() {
    return element;
  }

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
