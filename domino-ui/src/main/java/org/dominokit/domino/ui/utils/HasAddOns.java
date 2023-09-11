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

/** HasAddOns interface. */
public interface HasAddOns<T> {
  /**
   * appendChild.
   *
   * @param prefix a {@link org.dominokit.domino.ui.utils.PrefixAddOn} object
   * @return a T object
   */
  T appendChild(PrefixAddOn<?> prefix);

  /**
   * appendChild.
   *
   * @param addon a {@link org.dominokit.domino.ui.utils.PostfixAddOn} object
   * @return a T object
   */
  T appendChild(PostfixAddOn<?> addon);

  /**
   * appendChild.
   *
   * @param addon a {@link org.dominokit.domino.ui.utils.PrimaryAddOn} object
   * @return a T object
   */
  T appendChild(PrimaryAddOn<?> addon);
}
