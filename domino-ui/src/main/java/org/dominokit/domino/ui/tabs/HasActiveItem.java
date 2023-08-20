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
package org.dominokit.domino.ui.tabs;

/**
 * Components that can have a single active item should implement this interface
 *
 * @param <T> the type of the item that can be activated/deactivated
 */
public interface HasActiveItem<T> {
  /**
   * getActiveItem.
   *
   * @return a T object
   */
  T getActiveItem();

  /**
   * setActiveItem.
   *
   * @param activeItem a T object
   */
  void setActiveItem(T activeItem);
}
