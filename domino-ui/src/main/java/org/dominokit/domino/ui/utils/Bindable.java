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
 * An interface for objects that can be bound to an owner object of type T.
 *
 * @param <T> The type of the owner object to which this object can be bound.
 */
public interface Bindable<T> {

  /**
   * Binds this object to an owner of type T.
   *
   * @param owner The owner object to which this object will be bound.
   */
  void bindTo(T owner);
}
