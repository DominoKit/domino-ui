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

/** An interface providing component with pagination */
public interface HasPagination {
  /**
   * Go to a specific page number
   *
   * @param page the number of the page
   * @return same instance
   */
  HasPagination gotoPage(int page);

  /**
   * Go to a specific page number with boolean for notifying listeners or not
   *
   * @param page the number of the page
   * @param silent true to not notifying listeners
   * @return same instance
   */
  HasPagination gotoPage(int page, boolean silent);

  /**
   * Go to the next page of the current page
   *
   * @return same instance
   */
  HasPagination nextPage();

  /**
   * Go to the previous page of the current page
   *
   * @return same instance
   */
  HasPagination previousPage();

  /**
   * Go to the next page of the current page with boolean for notifying listeners or not
   *
   * @param silent true to not notifying listeners
   * @return same instance
   */
  HasPagination nextPage(boolean silent);

  /**
   * Go to the previous page of the current page with boolean for notifying listeners or not
   *
   * @param silent true to not notifying listeners
   * @return same instance
   */
  HasPagination previousPage(boolean silent);

  /**
   * Go to the first page
   *
   * @return same instance
   */
  HasPagination gotoFirst();

  /**
   * Go to the last page
   *
   * @return same instance
   */
  HasPagination gotoLast();

  /**
   * Go to the first page with boolean for notifying listeners or not
   *
   * @param silent true to not notifying listeners
   * @return same instance
   */
  HasPagination gotoFirst(boolean silent);

  /**
   * Go to the last page with boolean for notifying listeners or not
   *
   * @param silent true to not notifying listeners
   * @return same instance
   */
  HasPagination gotoLast(boolean silent);

  /**
   * Marks the current page as active
   *
   * @return same instance
   */
  HasPagination markActivePage();

  /**
   * Updates the number of pages for this pagination
   *
   * @param pages the new number of pages
   * @return same instance
   */
  HasPagination updatePages(int pages);

  /**
   * Updates the number of pages for this pagination
   *
   * @param pages the new number of pages
   * @param silent boolean flag to switch triggering the callback on/off for this call
   * @return same instance
   */
  HasPagination updatePages(int pages, boolean silent);

  /**
   * Updates the number of pages and the page size for this pagination
   *
   * @param pages the new number of pages
   * @param pageSize the new page size
   * @return same instance
   */
  HasPagination updatePages(int pages, int pageSize);

  /**
   * Updates the number of pages and the page size for this pagination
   *
   * @param pages the new number of pages
   * @param pageSize the new page size
   * @param silent boolean flag to switch triggering the callback on/off for this call
   * @return same instance
   */
  HasPagination updatePages(int pages, int pageSize, boolean silent);

  /**
   * Updates the number of pages by providing the total number of items, the calculation will be
   * based on the page size
   *
   * @param totalCount the total number of items
   * @return same instance
   */
  HasPagination updatePagesByTotalCount(int totalCount);

  /**
   * Updates the number of pages by providing the total number of items, the calculation will be
   * based on the page size
   *
   * @param totalCount the total number of items
   * @param silent boolean flag to switch triggering the callback on/off for this call
   * @return same instance
   */
  HasPagination updatePagesByTotalCount(int totalCount, boolean silent);

  /**
   * Updates the number of pages by providing the total number of items and the page size
   *
   * @param totalCount the total number of items
   * @param pageSize the new page size
   * @return same instance
   */
  HasPagination updatePagesByTotalCount(int totalCount, int pageSize);

  /**
   * Updates the number of pages by providing the total number of items and the page size
   *
   * @param totalCount the total number of items
   * @param pageSize the new page size
   * @param silent boolean flag to switch triggering the callback on/off for this call
   * @return same instance
   */
  HasPagination updatePagesByTotalCount(int totalCount, int pageSize, boolean silent);

  /** @return the total number of items */
  int getTotalCount();

  /**
   * Sets the page size
   *
   * @param pageSize the page size
   * @return same instance
   */
  HasPagination setPageSize(int pageSize);

  /** @return the page size */
  int getPageSize();

  /** @return the active page number */
  int activePage();

  /** @return the total number of pages */
  int getPagesCount();

  /**
   * Adds listener that will be called when a page is changed
   *
   * @param pageChangedCallBack A {@link PageChangedCallBack}
   * @return same instance
   */
  HasPagination onPageChanged(PageChangedCallBack pageChangedCallBack);

  /** A listener that will be called when the page is changed */
  @FunctionalInterface
  interface PageChangedCallBack {
    /** @param pageNumber the new selected page */
    void onPageChanged(int pageNumber);
  }
}
