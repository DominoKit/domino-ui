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
 * The {@code HasAddOns} interface defines methods for appending various types of add-ons to an
 * object of type {@code T}.
 *
 * @param <T> The type to which add-ons can be appended.
 */
public interface HasAddOns<T> {

  /**
   * Appends a prefix add-on to the object of type {@code T}.
   *
   * @param prefix The {@code PrefixAddOn} to append as a prefix add-on.
   * @return The modified object of type {@code T} with the prefix add-on appended.
   */
  T appendChild(PrefixAddOn<?> prefix);

  /**
   * Appends a postfix add-on to the object of type {@code T}.
   *
   * @param addon The {@code PostfixAddOn} to append as a postfix add-on.
   * @return The modified object of type {@code T} with the postfix add-on appended.
   */
  T appendChild(PostfixAddOn<?> addon);

  /**
   * Appends a primary add-on to the object of type {@code T}.
   *
   * @param addon The {@code PrimaryAddOn} to append as a primary add-on.
   * @return The modified object of type {@code T} with the primary add-on appended.
   */
  T appendChild(PrimaryAddOn<?> addon);
}
