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
 * A component that can have a readonly mode should implement this interface
 *
 * @param <T> the type of the class implementing this interface
 */
public interface IsReadOnly<T> {
  /**
   * @param readOnly boolean, if true switch the component to readonly mode, otherwise switch out
   *     off readonly mode
   * @return same instance of the implementing class
   */
  T setReadOnly(boolean readOnly);

  /** @return boolean, if true then the component is in readonly mode, otherwise it is not. */
  boolean isReadOnly();
}
