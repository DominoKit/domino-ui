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
package org.dominokit.domino.ui.forms.suggest;

import org.dominokit.domino.ui.IsElement;

/**
 * An interface for components that can handle the selection and deselection of suggestion options.
 *
 * @param <T> The type of data associated with the suggestion options.
 * @param <E> The type of UI element that represents the suggestion options.
 * @param <O> The type of suggestion options.
 */
public interface HasSuggestOptions<T, E extends IsElement<?>, O extends Option<T, E, O>> {

  /**
   * Handles the selection of a suggestion option.
   *
   * @param suggestion The suggestion option that was selected.
   */
  void onOptionSelected(O suggestion);

  /**
   * Handles the deselection of a suggestion option.
   *
   * @param suggestion The suggestion option that was deselected.
   */
  void onOptionDeselected(O suggestion);
}
