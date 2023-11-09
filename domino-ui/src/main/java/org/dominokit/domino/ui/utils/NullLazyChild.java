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
import org.dominokit.domino.ui.IsElement;

/**
 * The {@code NullLazyChild} class represents a lazy-initialized child element that always returns
 * null. This class is typically used when you need a placeholder or null object for a child
 * element.
 *
 * @param <T> The type of child element.
 */
public class NullLazyChild<T extends IsElement<?>> extends LazyChild<T> {

  /**
   * Creates a new instance of {@code NullLazyChild}.
   *
   * @param <T> The type of child element.
   * @return A new instance of {@code NullLazyChild}.
   */
  public static <T extends IsElement<?>> NullLazyChild<T> of() {
    return new NullLazyChild<T>();
  }

  /**
   * Constructs a new {@code NullLazyChild} instance with a null child element and a null parent
   * supplier.
   */
  public NullLazyChild() {
    super((T) null, (Supplier<IsElement<?>>) null);
  }

  /**
   * Always returns null. This method is used to obtain the child element, which is always null in
   * this case.
   *
   * @return Always returns null.
   */
  public T get() {
    return null;
  }

  /**
   * Returns the current instance of {@code NullLazyChild}. No action is performed.
   *
   * @return The current instance of {@code NullLazyChild}.
   */
  public NullLazyChild<T> remove() {
    return this;
  }

  /**
   * Always returns null. This method is used to obtain the child element, which is always null in
   * this case.
   *
   * @return Always returns null.
   */
  public T element() {
    return null;
  }

  /**
   * Overrides the {@code onReset} method and returns the current instance of {@code NullLazyChild}.
   * No action is performed.
   *
   * @param function A lambda function that is not used.
   * @return The current instance of {@code NullLazyChild}.
   */
  @Override
  public LazyChild<T> onReset(LambdaFunction function) {
    return this;
  }

  /**
   * Overrides the {@code doOnce} method and returns the current instance of {@code NullLazyChild}.
   * No action is performed.
   *
   * @param function A lambda function that is not used.
   * @return The current instance of {@code NullLazyChild}.
   */
  @Override
  public LazyChild<T> doOnce(LambdaFunction function) {
    return this;
  }

  /**
   * Overrides the {@code whenInitialized} method and returns the current instance of {@code
   * NullLazyChild}. No action is performed.
   *
   * @param functions An array of lambda functions that are not used.
   * @return The current instance of {@code NullLazyChild}.
   */
  @Override
  public LazyChild<T> whenInitialized(LambdaFunction... functions) {
    return this;
  }

  /**
   * Always returns {@code false}. This method is used to check if the lazy child is initialized,
   * which is never the case here.
   *
   * @return Always returns {@code false}.
   */
  @Override
  public boolean isInitialized() {
    return false;
  }

  /**
   * Returns the current instance of {@code NullLazyChild}. No action is performed.
   *
   * @param state A boolean value (true or false) that is not used.
   * @return The current instance of {@code NullLazyChild}.
   */
  public NullLazyChild<T> initOrRemove(boolean state) {
    return this;
  }
}
