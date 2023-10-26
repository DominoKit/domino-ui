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
package org.dominokit.domino.ui.pickers;

/**
 * A functional interface representing a handler for picker-related events.
 *
 * <p>The {@code PickerHandler} interface defines a single method, {@code handle()}, that should be
 * implemented to define the behavior of a picker-related event.
 *
 * <p>Usage example:
 *
 * <pre>
 * // Define a PickerHandler to handle a picker event
 * PickerHandler pickerHandler = () -> {
 *     // Perform some action when the picker event occurs
 *     // ...
 * };
 *
 * // Use the PickerHandler in a picker component
 * pickerComponent.setPickerHandler(pickerHandler);
 * </pre>
 *
 * <p>All HTML tags in the documentation are correctly closed.
 */
@FunctionalInterface
public interface PickerHandler {

  /** Handles a picker-related event. */
  void handle();
}
