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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;

/**
 * A wrapper class for an existing icon, allowing it to be used as an Icon in Domino UI. This class
 * extends the Icon class and delegates its behavior to the provided icon.
 */
public class IconWrapper extends Icon<IconWrapper> {

  private final Icon<?> icon;

  /**
   * Creates an IconWrapper for the given icon.
   *
   * @param icon The icon to wrap.
   */
  public static IconWrapper of(Icon<?> icon) {
    return new IconWrapper(icon);
  }

  /**
   * Constructs an IconWrapper with the provided icon.
   *
   * @param icon The icon to wrap.
   */
  public IconWrapper(Icon<?> icon) {
    this.icon = icon;
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   * @return The HTML element of the wrapped icon.
   */
  @Override
  public HTMLElement element() {
    return icon.element();
  }

  /**
   * {@inheritDoc} Creates a copy of the IconWrapper with a copy of the wrapped icon.
   *
   * @return A new IconWrapper instance with a copy of the wrapped icon.
   */
  @Override
  public IconWrapper copy() {
    return new IconWrapper(icon.copy());
  }
}
