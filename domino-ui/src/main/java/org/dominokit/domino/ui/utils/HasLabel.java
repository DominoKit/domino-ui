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
 * Components that can have a label should implement this interface
 *
 * @param <T> the type of the implementing class
 */
public interface HasLabel<T> {

  /**
   * setLabel.
   *
   * @param label String component label
   * @return same implementing class instance
   */
  T setLabel(String label);

  /** @return String component label */
  /**
   * getLabel.
   *
   * @return a {@link java.lang.String} object
   */
  String getLabel();

  /**
   * labelForId.
   *
   * @param id a {@link java.lang.String} object
   * @return a T object
   */
  T labelForId(String id);
}
