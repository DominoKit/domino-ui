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

import elemental2.dom.HTMLElement;

/** IconWrapper class. */
public class IconWrapper extends Icon<IconWrapper> {

  private final Icon<?> icon;

  /**
   * of.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.icons.IconWrapper} object
   */
  public static IconWrapper of(Icon<?> icon) {
    return new IconWrapper(icon);
  }

  /**
   * Constructor for IconWrapper.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   */
  public IconWrapper(Icon<?> icon) {
    this.icon = icon;
    init(this);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return icon.element();
  }

  /** {@inheritDoc} */
  @Override
  public IconWrapper copy() {
    return new IconWrapper(icon.copy());
  }
}