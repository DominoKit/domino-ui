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
 * IsPopup interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface IsPopup<T> {
  /**
   * open.
   *
   * @return a T object
   */
  T open();

  /**
   * close.
   *
   * @return a T object
   */
  T close();

  /**
   * isModal.
   *
   * @return a boolean
   */
  boolean isModal();

  /**
   * isAutoClose.
   *
   * @return a boolean
   */
  boolean isAutoClose();

  /**
   * isDialog.
   *
   * @return a boolean
   */
  default boolean isDialog() {
    return false;
  }

  /**
   * setZIndex.
   *
   * @param zIndex a int
   * @return a T object
   */
  T setZIndex(int zIndex);

  /**
   * getZIndex.
   *
   * @return a int
   */
  int getZIndex();

  /** stealFocus. */
  default void stealFocus() {}
}
