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

/**
 * The {@code Handler} functional interface represents a single-argument operation that takes an
 * input of type {@code T} and performs an action on it.
 *
 * <p>This functional interface is often used as a callback mechanism to handle or process objects
 * of a specific type {@code T}.
 *
 * @param <T> The type of the input argument.
 */
@FunctionalInterface
public interface Handler<T> {

  /**
   * Performs an operation on the given input of type {@code T}.
   *
   * @param target The input of type {@code T} on which the operation is performed.
   */
  void apply(T target);
}
