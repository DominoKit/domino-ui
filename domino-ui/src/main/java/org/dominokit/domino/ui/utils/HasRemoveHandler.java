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
 * A component that can be removed should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 */
@FunctionalInterface
public interface HasRemoveHandler<T> {

  /**
   * adds a remove handler to the component
   *
   * @param removeHandler {@link org.dominokit.domino.ui.utils.HasRemoveHandler.RemoveHandler}
   * @return same implementing component
   */
  T addRemoveHandler(RemoveHandler<T> removeHandler);

  /** a function to handle removing of the component */
  interface RemoveHandler<T> {
    /** Will be called when the component is being removed */
    void onRemove(T component);
  }
}
