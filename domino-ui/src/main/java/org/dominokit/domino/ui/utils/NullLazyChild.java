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
import org.jboss.elemento.IsElement;

public class NullLazyChild<T extends IsElement<?>> extends LazyChild<T> {

  public static <T extends IsElement<?>> NullLazyChild<T> of() {
    return new NullLazyChild<T>();
  }

  public NullLazyChild() {
    super((T) null, (Supplier<IsElement<?>>) null);
  }

  public T get() {
    return null;
  }

  public NullLazyChild<T> remove() {
    return this;
  }

  public T element() {
    return null;
  }

  @Override
  public LazyChild<T> onReset(LambdaFunction function) {
    return this;
  }

  @Override
  public LazyChild<T> doOnce(LambdaFunction function) {
    return this;
  }

  @Override
  public LazyChild<T> whenInitialized(LambdaFunction... functions) {
    return this;
  }

  @Override
  public boolean isInitialized() {
    return false;
  }

  public NullLazyChild<T> initOrRemove(boolean state) {
    return this;
  }
}
