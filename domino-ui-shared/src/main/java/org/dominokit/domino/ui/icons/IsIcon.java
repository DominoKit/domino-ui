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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;

/**
 * A renderer-neutral icon contract shared by Domino UI and optional icon packs.
 *
 * <p>Implementations keep an HTML element as their root. SVG based packs can place an SVG element
 * inside that root, while font based packs can render their ligature text there.
 *
 * @param <T> the concrete icon type
 */
public interface IsIcon<T extends IsIcon<T>> extends IsElement<HTMLElement> {

  /** Creates a new icon with the same icon and presentation options. */
  T copy();

  /** Returns the pack-specific icon name or semantic role used to create this icon. */
  String getName();

  /** Returns an attribute from the icon root element. */
  String getAttribute(String name);

  /** Sets an attribute on the icon root element. */
  T setAttribute(String name, String value);

  /** Adds CSS classes to the icon root. */
  T addCss(String... cssClasses);

  /** Adds a CSS class to the icon root. */
  T addCss(CssClass cssClass);

  /** Adds a CSS class from the shared style API to the icon root. */
  T addCss(HasCssClass cssClass);

  /** Removes a CSS class from the icon root. */
  T removeCss(String cssClass);

  /** Adds a click listener to this icon. */
  T addClickListener(EventListener listener);

  /** Sets an accessible label for this icon. */
  T setAriaLabel(String label);

  /** Makes this icon keyboard and pointer accessible as a button. */
  T clickable();

  /** Makes this icon clickable, optionally adding the waves effect. */
  T clickable(boolean withWaves);

  /** Sets whether this icon is clickable. */
  T setClickable(boolean clickable);

  /** Applies or removes the shared square treatment. */
  T setSquare(boolean square);

  /** Applies or removes the shared border treatment. */
  T setBordered(boolean bordered);

  /** Applies or removes the shared surface treatment. */
  T setSurface(boolean surface);
}
