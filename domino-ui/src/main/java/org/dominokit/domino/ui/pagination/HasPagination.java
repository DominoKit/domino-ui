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
package org.dominokit.domino.ui.pagination;

/**
 * Represents an interface for elements that have pagination functionality.
 *
 * <p>This interface provides methods to navigate through pages, update the number of pages, get the
 * current active page, and more.
 *
 * @param <T> the type of the implementing class, used to return the current instance for chaining
 *     methods
 */
public interface HasPagination<T extends HasPagination<T>> {

  /**
   * Navigates to a specific page number.
   *
   * @param page the target page number
   * @return the current instance
   */
  T gotoPage(int page);

  /**
   * Navigates to a specific page number, with an option to do it silently.
   *
   * @param page the target page number
   * @param silent if true, the navigation will be silent without triggering some events
   * @return the current instance
   */
  T gotoPage(int page, boolean silent);

  /**
   * Navigates to the next page.
   *
   * @return the current instance
   */
  T nextPage();

  /**
   * Navigates to the previous page.
   *
   * @return the current instance
   */
  T previousPage();

  /**
   * Navigates to the next page, with an option to do it silently.
   *
   * @param silent if true, the navigation will be silent without triggering some events
   * @return the current instance
   */
  T nextPage(boolean silent);

  /**
   * Navigates to the previous page, with an option to do it silently.
   *
   * @param silent if true, the navigation will be silent without triggering some events
   * @return the current instance
   */
  T previousPage(boolean silent);

  /**
   * Navigates to the first page.
   *
   * @return the current instance
   */
  T gotoFirst();

  /**
   * Navigates to the last page.
   *
   * @return the current instance
   */
  T gotoLast();

  /**
   * Navigates to the first page, with an option to do it silently.
   *
   * @param silent if true, the navigation will be silent without triggering some events
   * @return the current instance
   */
  T gotoFirst(boolean silent);

  /**
   * Navigates to the last page, with an option to do it silently.
   *
   * @param silent if true, the navigation will be silent without triggering some events
   * @return the current instance
   */
  T gotoLast(boolean silent);

  /**
   * Marks the currently active page.
   *
   * @return the current instance
   */
  T markActivePage();

  /**
   * Updates the number of pages without changing the page size.
   *
   * @param pages the new total number of pages
   * @return the current instance
   */
  T updatePages(int pages);

  /**
   * Updates the number of pages, with an option to do it silently.
   *
   * @param pages the new total number of pages
   * @param silent if true, the update will be silent without triggering some events
   * @return the current instance
   */
  T updatePages(int pages, boolean silent);

  /**
   * Updates the number of pages and the page size.
   *
   * @param pages the new total number of pages
   * @param pageSize the new page size
   * @return the current instance
   */
  T updatePages(int pages, int pageSize);

  /**
   * Updates the number of pages and the page size, with an option to do it silently.
   *
   * @param pages the new total number of pages
   * @param pageSize the new page size
   * @param silent if true, the update will be silent without triggering some events
   * @return the current instance
   */
  T updatePages(int pages, int pageSize, boolean silent);

  /**
   * Updates the number of pages based on the total count and the current page size.
   *
   * @param totalCount the new total count
   * @return the current instance
   */
  T updatePagesByTotalCount(int totalCount);

  /**
   * Updates the number of pages based on the total count and the current page size, with an option
   * to do it silently.
   *
   * @param totalCount the new total count
   * @param silent if true, the update will be silent without triggering some events
   * @return the current instance
   */
  T updatePagesByTotalCount(int totalCount, boolean silent);

  /**
   * Updates the number of pages based on the total count and a specified page size.
   *
   * @param totalCount the new total count
   * @param pageSize the new page size
   * @return the current instance
   */
  T updatePagesByTotalCount(int totalCount, int pageSize);

  /**
   * Updates the number of pages based on the total count and a specified page size, with an option
   * to do it silently.
   *
   * @param totalCount the new total count
   * @param pageSize the new page size
   * @param silent if true, the update will be silent without triggering some events
   * @return the current instance
   */
  T updatePagesByTotalCount(int totalCount, int pageSize, boolean silent);

  /**
   * Gets the total count of items across all pages.
   *
   * @return the total count
   */
  int getTotalCount();

  /**
   * Sets the page size.
   *
   * @param pageSize the new page size
   * @return the current instance
   */
  T setPageSize(int pageSize);

  /**
   * Gets the current page size.
   *
   * @return the current page size
   */
  int getPageSize();

  /**
   * Gets the currently active page number.
   *
   * @return the active page number
   */
  int activePage();

  /**
   * Gets the total number of pages.
   *
   * @return the total number of pages
   */
  int getPagesCount();

  /** Listener for page change events. */
  @FunctionalInterface
  interface PaginationPageChangeListener {

    /**
     * Called when the page number is changed.
     *
     * @param pageNumber the new active page number
     */
    void onPageChanged(int pageNumber);
  }
}
