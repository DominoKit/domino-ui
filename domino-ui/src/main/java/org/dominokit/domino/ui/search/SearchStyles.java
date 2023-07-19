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
package org.dominokit.domino.ui.search;

import org.dominokit.domino.ui.style.CssClass;

/**
 * Constants class for the Search component css classes names
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface SearchStyles {

  /** Constant <code>dui_quick_search</code> */
  CssClass dui_quick_search = () -> "dui-quick-search";
  /** Constant <code>dui_quick_search_container</code> */
  CssClass dui_quick_search_container = () -> "dui-quick-search-container";
  /** Constant <code>dui_search_bar</code> */
  CssClass dui_search_bar = () -> "dui-search-bar";
  /** Constant <code>dui_search_bar_container</code> */
  CssClass dui_search_bar_container = () -> "dui-search-bar-container";

  //  public static final String search_bar = "search-bar";
  //  public static final String search_icon = "search-icon";
  //  public static final String close_search = "close-search";
  //  public static final String open = "open";
}
