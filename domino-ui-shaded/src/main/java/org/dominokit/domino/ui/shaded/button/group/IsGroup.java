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
package org.dominokit.domino.ui.shaded.button.group;

import org.dominokit.domino.ui.shaded.button.Button;
import org.dominokit.domino.ui.shaded.button.DropdownButton;

/**
 * this interface provide contract to implement different types of button groups
 *
 * @param <T> this is the same type that is implementing this interface for fluent API.
 */
@Deprecated
public interface IsGroup<T> {

  /**
   * Appends a button to the buttons group
   *
   * @param button {@link Button}
   * @return same instance
   */
  T appendChild(Button button);

  /**
   * Appends a dropdown button to the buttons group
   *
   * @param dropDown {@link DropdownButton}
   * @return same instabce
   */
  T appendChild(DropdownButton dropDown);

  /**
   * sets the buttons group as a vertical buttons group aligning the buttons vertically
   *
   * @return same instance
   */
  T verticalAlign();

  /**
   * sets the buttons group as a horizontal buttons group aligning the buttons horizontally
   *
   * @return same instance
   */
  T horizontalAlign();
}
