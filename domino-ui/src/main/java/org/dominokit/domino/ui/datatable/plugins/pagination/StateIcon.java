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

package org.dominokit.domino.ui.datatable.plugins.pagination;

import org.dominokit.domino.ui.icons.*;

/**
 * The {@code StateIcon} class is used to represent an icon that can change its appearance based on
 * different states. It extends {@link StateChangeIcon}, allowing you to define multiple states and
 * corresponding icons.
 *
 * <p>You can create instances of {@code StateIcon} using the {@link #create(Icon) create} method.
 *
 * <p>Example usage:
 *
 * <pre>
 * // Create a StateIcon with a default icon
 * StateIcon stateIcon = StateIcon.create(Icons.check());
 *
 * // Define different states and their corresponding icons
 * stateIcon
 *     .withState("active", Icons.star()) // Icon for the "active" state
 *     .withState("inactive", Icons.star_border()) // Icon for the "inactive" state
 *     .withState("disabled", Icons.block()) // Icon for the "disabled" state
 *     .withState("selected", Icons.check_circle()); // Icon for the "selected" state
 *
 * // Set the current state of the icon
 * stateIcon.setState("active");
 * </pre>
 *
 * @see StateChangeIcon
 */
public class StateIcon extends StateChangeIcon<IconWrapper, StateIcon> {

  /**
   * Creates a new {@code StateIcon} instance with the provided default icon.
   *
   * @param defaultIcon The default icon to be used when no state is set.
   * @return A new {@code StateIcon} instance.
   */
  public static StateIcon create(Icon<?> defaultIcon) {
    return new StateIcon(defaultIcon);
  }

  /**
   * Constructs a {@code StateIcon} with the provided default icon.
   *
   * @param defaultIcon The default icon to be used when no state is set.
   */
  public StateIcon(Icon<?> defaultIcon) {
    super(new IconWrapper(defaultIcon));
  }

  /**
   * Creates a copy of this {@code StateIcon} with the same default icon and states.
   *
   * @return A new {@code StateIcon} instance with the same properties.
   */
  @Override
  public StateIcon copy() {
    StateIcon copy = new StateIcon(defaultIcon.copy());
    statesMap.forEach(copy::withState);
    return copy;
  }
}
