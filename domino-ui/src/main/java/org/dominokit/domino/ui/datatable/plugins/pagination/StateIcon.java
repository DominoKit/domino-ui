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

/** StateIcon class. */
public class StateIcon extends StateChangeIcon<IconWrapper, StateIcon> {

  /**
   * create.
   *
   * @param defaultIcon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.pagination.StateIcon} object
   */
  public static StateIcon create(Icon<?> defaultIcon) {
    return new StateIcon(defaultIcon);
  }

  /**
   * Constructor for StateIcon.
   *
   * @param defaultIcon a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public StateIcon(Icon<?> defaultIcon) {
    super(new IconWrapper(defaultIcon));
  }

  /** {@inheritDoc} */
  @Override
  public StateIcon copy() {
    StateIcon copy = new StateIcon(defaultIcon.copy());
    statesMap.forEach(copy::withState);
    return copy;
  }
}
