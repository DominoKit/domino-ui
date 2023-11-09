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
package org.dominokit.domino.ui.layout;

import org.dominokit.domino.ui.style.CssClass;

/**
 * The {@code NavBarStyles} interface provides CSS classes for styling elements within a navigation
 * bar (navbar) component.
 */
public interface NavBarStyles {

  /** Represents the CSS class for the main navigation bar container. */
  CssClass dui_nav_bar = () -> "dui-nav-bar";

  /** Represents the CSS class for the navigation bar add-on or extension. */
  CssClass dui_nav_add_on = () -> "dui-nav-addon";

  /** Represents the CSS class for the navigation bar title. */
  CssClass dui_nav_title = () -> "dui-nav-title";

  /** Represents the CSS class for the navigation bar body content. */
  CssClass dui_nav_body = () -> "dui-nav-body";

  /** Represents the CSS class for the navigation bar utility section. */
  CssClass dui_nav_utility = () -> "dui-nav-utility";

  /** Represents the CSS class for the navigation bar description text. */
  CssClass dui_nav_description = () -> "dui-nav-description";
}
