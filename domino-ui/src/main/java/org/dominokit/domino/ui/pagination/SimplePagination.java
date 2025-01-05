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

import static java.util.Objects.nonNull;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * SimplePagination is a basic implementation of pagination controls in Domino UI. It allows users
 * to navigate through a list of pages with next, previous, and direct page navigation options. This
 * class extends {@link BasePagination} to provide common pagination functionality.
 *
 * <p><strong>Usage Example:</strong>
 *
 * <pre>
 * SimplePagination pagination = SimplePagination.create(5, 10)
 *     .addPageChangeListener(new HasPagination.PaginationPageChangeListener() {
 *         {@literal @}Override
 *         public void onPageChanged(int pageNumber) {
 *             // Handle page change event
 *         }
 *     });
 * </pre>
 */
public class SimplePagination extends BasePagination<SimplePagination> {

  private List<PagerNavItem> allPages = new LinkedList<>();

  /**
   * Creates a new instance of SimplePagination with default settings (0 pages and a page size of
   * 10).
   *
   * @return A new SimplePagination instance.
   */
  public static SimplePagination create() {
    return new SimplePagination();
  }

  /**
   * Creates a new instance of SimplePagination with the specified number of pages and a default
   * page size of 10.
   *
   * @param pages The total number of pages.
   * @return A new SimplePagination instance.
   */
  public static SimplePagination create(int pages) {
    return new SimplePagination(pages);
  }

  /**
   * Creates a new instance of SimplePagination with the specified number of pages and page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @return A new SimplePagination instance.
   */
  public static SimplePagination create(int pages, int pageSize) {
    return new SimplePagination(pages, pageSize);
  }

  /**
   * Creates a new instance of SimplePagination with default settings (0 pages and a page size of
   * 10).
   */
  public SimplePagination() {
    this(0);
  }

  /**
   * Creates a new instance of SimplePagination with the specified number of pages and a default
   * page size of 10.
   *
   * @param pages The total number of pages.
   */
  public SimplePagination(int pages) {
    this(pages, 10);
  }

  /**
   * Creates a new instance of SimplePagination with the specified number of pages and page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   */
  public SimplePagination(int pages, int pageSize) {
    this.pagesCount = pages;
    this.pageSize = pageSize;

    prevPage
        .getLink()
        .addClickListener(evt -> moveToPage(index - 1, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(index - 1, isChangeListenersPaused())));
    nextPage
        .getLink()
        .addClickListener(evt -> moveToPage(index + 1, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(index + 1, isChangeListenersPaused())));

    updatePages(pages, pageSize);
  }

  /**
   * Updates the pagination with the specified number of pages.
   *
   * @param pages The new total number of pages.
   * @param silent If true, change listeners won't be triggered.
   * @return The SimplePagination instance.
   */
  @Override
  public SimplePagination updatePages(int pages, boolean silent) {
    return updatePages(pages, pageSize, silent);
  }

  /**
   * Updates the pagination with the specified number of pages and page size.
   *
   * @param pages The new total number of pages.
   * @param pageSize The new page size.
   * @param silent If true, change listeners won't be triggered.
   * @return The SimplePagination instance.
   */
  @Override
  public SimplePagination updatePages(int pages, int pageSize, boolean silent) {
    this.pageSize = pageSize;
    this.pagesCount = pages;
    this.index = 1;
    clearPages();

    if (pages > 0) {
      IntStream.rangeClosed(1, pages)
          .mapToObj(PagerNavItem::page)
          .forEach(
              pagerNavItem -> {
                pagerNavItem
                    .addClickListener(
                        evt -> moveToPage(pagerNavItem.getPage(), isChangeListenersPaused()))
                    .onKeyDown(
                        keyEvents ->
                            keyEvents.onEnter(
                                evt ->
                                    moveToPage(pagerNavItem.getPage(), isChangeListenersPaused())));
                if (allPages.isEmpty()) {
                  pagesList.insertAfter(pagerNavItem, prevPage);
                } else {
                  pagesList.insertAfter(pagerNavItem, allPages.get(allPages.size() - 1));
                }
                allPages.add(pagerNavItem);
              });
    }

    if (pages <= 0) {
      prevPage.disable();
      nextPage.disable();
      if (!silent) {
        triggerChangeListeners(null, 0);
      }
    } else {
      moveToPage(1, silent);
    }

    return this;
  }

  /**
   * Clears all the page elements in the pagination component.
   *
   * @implNote This method removes all page elements from the pagination.
   */
  private void clearPages() {
    allPages.forEach(BaseDominoElement::remove);
    allPages.clear();
  }

  /**
   * Moves the pagination to the specified page.
   *
   * @param page The page number to move to.
   * @param silent If {@code true}, change listeners won't be triggered; otherwise, they will.
   * @implNote This method updates the active page, triggers change listeners if not silent, and
   *     enables/disables next and previous page navigation based on the current page.
   */
  @Override
  protected void moveToPage(int page, boolean silent) {
    PagerNavItem oldPage = activePage;
    if (page > 0 && page <= pagesCount) {
      index = page;
      if (markActivePage) {
        gotoPage(allPages.get(page - 1));
      }

      if (!silent) {
        triggerChangeListeners(nonNull(oldPage) ? oldPage.getPage() : null, page);
      }

      if (page == pagesCount) {
        nextPage.disable();
      } else {
        nextPage.enable();
      }

      if (page > 1) {
        prevPage.enable();
      } else {
        prevPage.disable();
      }
    }
  }
}
