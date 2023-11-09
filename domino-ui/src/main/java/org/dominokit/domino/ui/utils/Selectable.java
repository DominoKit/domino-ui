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
 * The {@code Selectable} interface represents an object that can be selected or deselected. It
 * provides methods to manipulate the selection state and query the current selection status.
 *
 * <p>Implementing classes or objects that implement this interface should provide mechanisms to
 * track and manage their selection state.
 *
 * <p>This interface defines the following methods to work with selection:
 *
 * <ul>
 *   <li>{@link #select()}: Selects the object.
 *   <li>{@link #deselect()}: Deselects the object.
 *   <li>{@link #select(boolean)}: Selects the object, optionally in silent mode (without triggering
 *       events).
 *   <li>{@link #deselect(boolean)}: Deselects the object, optionally in silent mode (without
 *       triggering events).
 *   <li>{@link #isSelected()}: Checks if the object is currently selected.
 *   <li>{@link #isSelectable()}: Checks if the object is selectable.
 *   <li>{@link #setSelectable(boolean)}: Sets the object's selectability status.
 *   <li>{@link #setSelected(boolean)}: Sets the object as selected or deselected.
 *   <li>{@link #setSelected(boolean, boolean)}: Sets the object as selected or deselected,
 *       optionally in silent mode (without triggering events).
 *   <li>{@link #toggleSelect()}: Toggles the selection state of the object.
 *   <li>{@link #toggleSelect(boolean)}: Toggles the selection state of the object, optionally in
 *       silent mode.
 * </ul>
 *
 * <p>Implementing classes should provide proper implementations of these methods to manage
 * selection and selectability as per their specific requirements.
 *
 * @param <T> The type of the object that can be selected or deselected.
 */
public interface Selectable<T> {

  /**
   * Selects the object.
   *
   * @return The reference to the object after selection.
   */
  T select();

  /**
   * Deselects the object.
   *
   * @return The reference to the object after deselection.
   */
  T deselect();

  /**
   * Selects the object, optionally in silent mode (without triggering events).
   *
   * @param silent {@code true} to select silently, {@code false} to trigger events.
   * @return The reference to the object after selection.
   */
  T select(boolean silent);

  /**
   * Deselects the object, optionally in silent mode (without triggering events).
   *
   * @param silent {@code true} to deselect silently, {@code false} to trigger events.
   * @return The reference to the object after deselection.
   */
  T deselect(boolean silent);

  /**
   * Checks if the object is currently selected.
   *
   * @return {@code true} if the object is selected, {@code false} otherwise.
   */
  boolean isSelected();

  /**
   * Checks if the object is selectable.
   *
   * @return {@code true} if the object is selectable, {@code false} otherwise.
   */
  boolean isSelectable();

  /**
   * Sets the object's selectability status.
   *
   * @param selectable {@code true} to make the object selectable, {@code false} to make it
   *     unselectable.
   * @return The reference to the object after setting selectability.
   */
  T setSelectable(boolean selectable);

  /**
   * Sets the object as selected or deselected.
   *
   * @param selected {@code true} to select the object, {@code false} to deselect it.
   * @return The reference to the object after setting the selection state.
   */
  T setSelected(boolean selected);

  /**
   * Sets the object as selected or deselected, optionally in silent mode (without triggering
   * events).
   *
   * @param selected {@code true} to select the object, {@code false} to deselect it.
   * @param silent {@code true} to perform the operation silently, {@code false} to trigger events.
   * @return The reference to the object after setting the selection state.
   */
  T setSelected(boolean selected, boolean silent);

  /**
   * Toggles the selection state of the object.
   *
   * @return The reference to the object after toggling the selection state.
   */
  default T toggleSelect() {
    return setSelected(!isSelected());
  }

  /**
   * Toggles the selection state of the object, optionally in silent mode.
   *
   * @param silent {@code true} to toggle silently, {@code false} to trigger events.
   * @return The reference to the object after toggling the selection state.
   */
  default T toggleSelect(boolean silent) {
    return setSelected(!isSelected(), silent);
  }
}
