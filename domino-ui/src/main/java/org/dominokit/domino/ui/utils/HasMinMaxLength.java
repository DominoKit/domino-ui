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
 * HasMinMaxLength interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasMinMaxLength<T> {
  /** Constant <code>MAX_LENGTH="maxlength"</code> */
  String MAX_LENGTH = "maxlength";
  /** Constant <code>MIN_LENGTH="minlength"</code> */
  String MIN_LENGTH = "minlength";

  /**
   * getMaxLength.
   *
   * @return a int
   */
  int getMaxLength();

  /**
   * setMaxLength.
   *
   * @param maxLength a int
   * @return a T object
   */
  T setMaxLength(int maxLength);

  /**
   * getMinLength.
   *
   * @return a int
   */
  int getMinLength();

  /**
   * setMinLength.
   *
   * @param minLength a int
   * @return a T object
   */
  T setMinLength(int minLength);

  /**
   * getLength.
   *
   * @return a int
   */
  int getLength();
}
