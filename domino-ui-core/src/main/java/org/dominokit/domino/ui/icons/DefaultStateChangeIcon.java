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

/** Core state-change composition for icons supplied by any pack. */
public class DefaultStateChangeIcon extends StateChangeIcon<IconWrapper, DefaultStateChangeIcon> {

  public static DefaultStateChangeIcon of(IsIcon<?> defaultIcon) {
    return new DefaultStateChangeIcon(defaultIcon);
  }

  public DefaultStateChangeIcon(IsIcon<?> defaultIcon) {
    super(IconWrapper.of(defaultIcon));
  }

  public DefaultStateChangeIcon withIconState(String state, IsIcon<?> icon) {
    return withState(state, IconWrapper.of(icon));
  }

  @Override
  public DefaultStateChangeIcon copy() {
    DefaultStateChangeIcon copy = new DefaultStateChangeIcon(defaultIcon.copy());
    statesMap.forEach((state, icon) -> copy.withState(state, icon.copy()));
    if (!"default".equals(currentState)) copy.setState(currentState);
    return copy;
  }
}
