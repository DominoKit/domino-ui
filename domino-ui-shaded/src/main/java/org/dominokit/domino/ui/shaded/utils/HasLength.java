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
package org.dominokit.domino.ui.shaded.utils;

/**
 * Components that has a requirement to have a min and max length can implement this interface
 *
 * @param <T> The type of the class implementing this interface
 */
@Deprecated
public interface HasLength<T> {
  /**
   * @param maxLength int max allowed length
   * @return same implementation instance
   */
  T setMaxLength(int maxLength);

  /** @return int max allowed length */
  int getMaxLength();

  /**
   * @param minLength int min allowed length
   * @return same implementation instance
   */
  T setMinLength(int minLength);

  /** @return int min allowed length */
  int getMinLength();
}
