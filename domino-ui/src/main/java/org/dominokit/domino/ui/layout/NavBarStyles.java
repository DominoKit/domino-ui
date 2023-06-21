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
 * NavBarStyles interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface NavBarStyles {

  /** Constant <code>dui_nav_bar</code> */
  CssClass dui_nav_bar = () -> "dui-nav-bar";
  /** Constant <code>dui_nav_add_on</code> */
  CssClass dui_nav_add_on = () -> "dui-nav-addon";
  /** Constant <code>dui_nav_title</code> */
  CssClass dui_nav_title = () -> "dui-nav-title";
  /** Constant <code>dui_nav_utility</code> */
  CssClass dui_nav_utility = () -> "dui-nav-utility";
  /** Constant <code>dui_nav_description</code> */
  CssClass dui_nav_description = () -> "dui-nav-description";
}
