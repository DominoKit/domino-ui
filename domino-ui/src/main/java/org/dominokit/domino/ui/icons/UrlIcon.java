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

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.SwapCssClass;

/**
 * Represents an icon loaded from a URL. It can change its appearance by switching to another
 * URL-based icon.
 */
public class UrlIcon extends Icon<UrlIcon> implements CanChangeIcon<UrlIcon> {

  private final String url;

  /**
   * Constructs a UrlIcon with the given URL and icon name.
   *
   * @param url The URL of the icon image.
   * @param name The name of the icon.
   */
  private UrlIcon(String url, String name) {
    this(url, () -> name);
  }

  /**
   * Constructs a UrlIcon with the given URL and icon name defined as a CssClass.
   *
   * @param url The URL of the icon image.
   * @param name The name of the icon as a CssClass.
   */
  private UrlIcon(String url, CssClass name) {
    this.url = url;
    this.name = SwapCssClass.of(name);
    this.icon = elementOf(img(url).element());
    init(this);
  }

  /**
   * Creates a new UrlIcon instance with the provided URL and icon name.
   *
   * @param url The URL of the icon image.
   * @param name The name of the icon.
   * @return A new UrlIcon instance.
   */
  public static UrlIcon create(String url, String name) {
    return new UrlIcon(url, name);
  }

  /**
   * Creates a new UrlIcon instance with the same URL and icon name as this UrlIcon.
   *
   * @return A new UrlIcon instance.
   */
  @Override
  public UrlIcon copy() {
    return new UrlIcon(url, name);
  }

  /**
   * Changes the icon to another UrlIcon by removing the current CSS class name and adding the CSS
   * class name of the provided UrlIcon.
   *
   * @param icon The UrlIcon to change to.
   * @return The same UrlIcon instance after changing the icon.
   */
  @Override
  public UrlIcon changeTo(UrlIcon icon) {
    removeCss(getName());
    addCss(icon.getName());
    return null;
  }
}
