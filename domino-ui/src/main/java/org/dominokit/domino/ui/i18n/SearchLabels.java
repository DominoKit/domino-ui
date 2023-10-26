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
 * The {@code SearchLabels} interface provides labels for search-related components and messages.
 *
 * <p>Usage Example:
 *
 * <pre><code>
 * SearchComponent searchComponent = new SearchComponent();
 * searchComponent.setPlaceholder(searchLabels.getStartTyping());
 * </code></pre>
 *
 * @see Labels
 */
public interface SearchLabels extends Labels {

  /**
   * Gets the default placeholder text for a search input.
   *
   * @return The default placeholder text.
   */
  default String getStartTyping() {
    return "START TYPING...";
  }
}
