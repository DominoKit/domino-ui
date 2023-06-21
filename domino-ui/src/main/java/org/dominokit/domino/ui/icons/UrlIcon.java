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

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.SwapCssClass;

/**
 * Url icon implementation
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class UrlIcon extends Icon<UrlIcon> implements CanChangeIcon<UrlIcon> {

  private final String url;

  private UrlIcon(String url, String name) {
    this(url, () -> name);
  }

  private UrlIcon(String url, CssClass name) {
    this.url = url;
    this.name = SwapCssClass.of(name);
    this.icon = elementOf(img(url).element());
    init(this);
  }

  /**
   * Creates an icon with a specific {@code url} and a name
   *
   * @param url the url of the icon to load from
   * @param name the name of the icon
   * @return new instance
   */
  public static UrlIcon create(String url, String name) {
    return new UrlIcon(url, name);
  }

  /** {@inheritDoc} */
  @Override
  public UrlIcon copy() {
    return new UrlIcon(url, name);
  }

  /** {@inheritDoc} */
  @Override
  public UrlIcon changeTo(UrlIcon icon) {
    removeCss(getName());
    addCss(icon.getName());
    return null;
  }
}
