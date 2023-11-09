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

/** The {@code PaginationLabels} interface provides labels and messages related to pagination. */
public interface PaginationLabels extends Labels {

  /**
   * Gets the label indicating the current page and the total number of pages.
   *
   * @param pagesCount The total number of pages.
   * @return A {@code String} representing the label indicating the current page and total pages
   *     count.
   */
  default String getPaginationCountLabel(int pagesCount) {
    return " of " + pagesCount + " Pages";
  }

  /**
   * Gets the label for the "Previous" pagination button.
   *
   * @return A {@code String} representing the label for the "Previous" button.
   */
  default String getPreviousLabel() {
    return "Previous";
  }

  /**
   * Gets the label for the "Next" pagination button.
   *
   * @return A {@code String} representing the label for the "Next" button.
   */
  default String getNextLabel() {
    return "Next";
  }
}
