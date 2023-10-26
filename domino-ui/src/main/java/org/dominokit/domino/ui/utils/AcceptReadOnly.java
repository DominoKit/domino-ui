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
 * The {@code AcceptReadOnly} interface defines methods for setting and checking the read-only state
 * of an object. Objects implementing this interface can be marked as read-only, which typically
 * means that they cannot be modified or edited by user interactions.
 *
 * @param <T> The type of object that can be marked as read-only or checked for read-only status.
 */
public interface AcceptReadOnly<T> {

  /**
   * Sets the read-only state of the object.
   *
   * @param readOnly {@code true} to mark the object as read-only, {@code false} to mark it as
   *     editable.
   * @return The object after setting the read-only state.
   */
  T setReadOnly(boolean readOnly);

  /**
   * Checks if the object is currently in a read-only state.
   *
   * @return {@code true} if the object is read-only, {@code false} if it is editable.
   */
  boolean isReadOnly();
}
