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

package org.dominokit.domino.ui.icons;

/**
 * The {@code CanChangeIcon} interface defines a contract for changing the icon of a component to a
 * new icon.
 *
 * @param <T> The type of the concrete class that implements this interface, typically an icon
 *     component.
 */
public interface CanChangeIcon<T extends Icon<T>> {

  /**
   * Changes the current icon to a new icon represented by the provided replacement.
   *
   * @param replacement The new icon to replace the current icon with.
   * @return The updated instance of the concrete class with the new icon applied.
   */
  T changeTo(T replacement);
}
