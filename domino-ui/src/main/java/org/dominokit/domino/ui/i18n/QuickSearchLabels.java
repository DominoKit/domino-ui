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
package org.dominokit.domino.ui.i18n;

/**
 * The {@code QuickSearchLabels} interface provides labels and messages related to quick search
 * functionality.
 */
public interface QuickSearchLabels extends Labels {

  /**
   * Gets the default placeholder text for the quick search input field.
   *
   * @return A {@code String} representing the default placeholder text for the quick search input
   *     field.
   */
  default String defaultQuickSearchPlaceHolder() {
    return "Search";
  }

  /**
   * Gets the default tooltip text for the "Clear search" action in quick search.
   *
   * @return A {@code String} representing the default tooltip text for the "Clear search" action.
   */
  default String defaultQuickSearchClearToolTip() {
    return "Clear search";
  }
}
