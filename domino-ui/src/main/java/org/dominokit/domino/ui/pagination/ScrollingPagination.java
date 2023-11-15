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
import static org.dominokit.domino.ui.utils.Domino.*;

import java.util.stream.IntStream;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * ScrollingPagination provides a pagination component with a scrolling window of page numbers.
 *
 * <p>This pagination component allows you to navigate through a large set of pages with a scrolling
 * window of page numbers. It provides options to show the total record count and next/previous page
 * sets.
 *
 * <p>Usage Example:
 *
 * <pre>
 * ScrollingPagination pagination = ScrollingPagination.create(100, 10, 5);
 * pagination.showTotalRecordVisible(true);
 * pagination.showNextPrevSet(true);
 * pagination.onChange(page -> {
 *     // Handle page change event
 * });
 * </pre>
 */
public class ScrollingPagination extends BasePagination<ScrollingPagination> {

  private final int windowSize;
  private int windowIndex = 0;
  private boolean totalRecordVisible = false;
  private final PagerNavItem dots;
  private final PagerNavItem pagesTotalCount;
  protected PagerNavItem prevSet;
  protected PagerNavItem nextSet;
  private final PagerNavItem totalCountNavItem;

  /**
   * Creates a ScrollingPagination instance with default settings.
   *
   * @return a new ScrollingPagination instance.
   */
  public static ScrollingPagination create() {
    return new ScrollingPagination();
  }

  /**
   * Creates a ScrollingPagination instance with the specified number of pages.
   *
   * @param pages The total number of pages.
   * @return a new ScrollingPagination instance with the given number of pages.
   */
  public static ScrollingPagination create(int pages) {
    return new ScrollingPagination(pages);
  }

  /**
   * Creates a ScrollingPagination instance with the specified number of pages and page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @return a new ScrollingPagination instance with the given number of pages and page size.
   */
  public static ScrollingPagination create(int pages, int pageSize) {
    return new ScrollingPagination(pages, pageSize);
  }

  /**
   * Creates a ScrollingPagination instance with the specified number of pages, page size, and
   * window size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @param windowSize The size of the scrolling window.
   * @return a new ScrollingPagination instance with the given number of pages, page size, and
   *     window size.
   */
  public static ScrollingPagination create(int pages, int pageSize, int windowSize) {
    return new ScrollingPagination(pages, pageSize, windowSize);
  }

  /** Constructs a ScrollingPagination instance with default settings. */
  public ScrollingPagination() {
    this(0, 10, 10);
  }

  /**
   * Constructs a ScrollingPagination instance with the specified number of pages.
   *
   * @param pages The total number of pages.
   */
  public ScrollingPagination(int pages) {
    this(pages, 10, 10);
  }

  /**
   * Constructs a ScrollingPagination instance with the specified number of pages and page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   */
  public ScrollingPagination(int pages, int pageSize) {
    this(pages, pageSize, 10);
  }

  /**
   * Constructs a ScrollingPagination instance with the specified number of pages, page size, and
   * window size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @param windowSize The size of the scrolling window.
   */
  public ScrollingPagination(int pages, int pageSize, int windowSize) {
    this.pagesCount = pages;
    this.pageSize = pageSize;
    this.windowSize = windowSize;
    pagesList.insertFirst(prevSet = PagerNavItem.nav(Icons.page_first()).collapse());
    pagesList.appendChild(nextSet = PagerNavItem.nav(Icons.page_last()).collapse());

    prevPage
        .getLink()
        .addClickListener(evt -> moveToPage(index - 1, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(index - 1, isChangeListenersPaused())));

    firstPage
        .expand()
        .getLink()
        .addClickListener(evt -> moveToPage(1, isChangeListenersPaused()))
        .onKeyDown(keyEvents -> keyEvents.onEnter(evt -> moveToPage(1, isChangeListenersPaused())));
    prevSet
        .expand()
        .getLink()
        .addClickListener(evt -> moveToPage((windowIndex * windowSize), isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(
                    evt -> moveToPage((windowIndex * windowSize), isChangeListenersPaused())));

    nextPage
        .getLink()
        .addClickListener(evt -> moveToPage(index + 1, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(index + 1, isChangeListenersPaused())));

    lastPage
        .expand()
        .getLink()
        .addClickListener(evt -> moveToPage(allPages.size(), isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(allPages.size(), isChangeListenersPaused())));
    nextSet
        .expand()
        .getLink()
        .addClickListener(
            evt ->
                moveToPage((windowIndex * windowSize) + windowSize + 1, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(
                    evt ->
                        moveToPage(
                            (windowIndex * windowSize) + windowSize + 1,
                            isChangeListenersPaused())));

    dots =
        PagerNavItem.create(text("..."))
            .addClickListener(
                evt ->
                    moveToPage(
                        (windowIndex * windowSize) + windowSize + 1, isChangeListenersPaused()))
            .onKeyDown(
                keyEvents ->
                    keyEvents.onEnter(
                        evt ->
                            moveToPage(
                                (windowIndex * windowSize) + windowSize + 1,
                                isChangeListenersPaused())));

    pagesList.insertBefore(dots, nextPage);
    pagesTotalCount = PagerNavItem.create(text(pagesCount + ""));
    pagesList.insertAfter(pagesTotalCount, dots);

    totalCountNavItem = PagerNavItem.create(text("(" + this.getTotalCount() + ")"));
    pagesList.insertBefore(totalCountNavItem.toggleDisplay(totalRecordVisible), nextPage);

    updatePages(pages, pageSize);
  }

  /**
   * Updates the pagination with the specified number of pages and page size.
   *
   * @param pages The total number of pages.
   * @param silent If true, the change listeners won't be triggered.
   * @return This ScrollingPagination instance.
   */
  @Override
  public ScrollingPagination updatePages(int pages, boolean silent) {
    return updatePages(pages, pageSize, silent);
  }

  /**
   * Updates the pagination with the specified number of pages and page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @param silent If true, the change listeners won't be triggered.
   * @return This ScrollingPagination instance.
   */
  @Override
  public ScrollingPagination updatePages(int pages, int pageSize, boolean silent) {
    this.pageSize = pageSize;
    this.pagesCount = pages;
    this.index = 1;
    clearPages();

    if (pages > 0) {
      IntStream.rangeClosed(1, pages)
          .forEach(
              p -> {
                PagerNavItem page =
                    PagerNavItem.page(p)
                        .addClickListener(evt -> moveToPage(p, isChangeListenersPaused()))
                        .onKeyDown(
                            keyEvents ->
                                keyEvents.onEnter(evt -> moveToPage(p, isChangeListenersPaused())));

                if (p <= windowSize) {
                  if (allPages.isEmpty()) {
                    pagesList.insertAfter(page, prevPage);
                  } else {
                    pagesList.insertAfter(page, allPages.get(allPages.size() - 1));
                  }
                }
                allPages.add(page);
              });
    }

    dots.expand();

    pagesTotalCount.withLink(
        (parent, link) -> link.clearElement().appendChild(text(pagesCount + "")));
    totalCountNavItem.withLink(
        (parent, link) -> link.clearElement().appendChild(text("(" + getTotalCount() + ")")));

    if (pages > 0) {
      moveToPage(1, silent);
    }

    if (pages <= 0) {
      nextPage.disable();
      nextSet.disable();
      lastPage.disable();
      prevPage.disable();
      prevSet.disable();
      firstPage.disable();
      if (!silent) {
        triggerChangeListeners(null, 0);
      }
    }
    return this;
  }

  /** Clears all pages from the pagination. */
  private void clearPages() {
    allPages.forEach(BaseDominoElement::remove);
    allPages.clear();
  }

  /**
   * Moves to the specified page and triggers change listeners if not silent.
   *
   * @param page The target page to move to.
   * @param silent If true, change listeners won't be triggered.
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
        nextSet.disable();
        lastPage.disable();
      } else {
        nextPage.enable();
        nextSet.enable();
        lastPage.enable();
      }

      if (page == 1) {
        prevPage.disable();
        prevSet.disable();
        firstPage.disable();
      } else {
        prevPage.enable();
        prevSet.enable();
        firstPage.enable();
      }

      showPageWindow(page);
    }
  }

  /**
   * Shows the window of pages based on the given page index.
   *
   * @param page The current page index.
   */
  private void showPageWindow(int page) {
    if (page % windowSize == 0) {
      showWindow((page / windowSize) - 1);
    } else {
      showWindow(page / windowSize);
    }

    if (windowIndex == 0) {
      prevSet.disable();
    } else {
      prevSet.enable();
    }

    int windowCount = (allPages.size() / windowSize) + (allPages.size() % windowSize > 0 ? 1 : 0);
    if (windowIndex >= windowCount - 1) {
      nextSet.disable();
    } else {
      nextSet.enable();
    }
  }

  private void showWindow(int index) {
    if (index != this.windowIndex) {
      int windowMinLimit = windowIndex * windowSize;
      int windowMaxLimit = windowMinLimit + windowSize;

      for (int i = windowMinLimit; i < windowMaxLimit; i++) {
        if (i < allPages.size()) {
          allPages.get(i).remove();
        }
      }

      int targetWindowMinLimit = index * windowSize;
      int targetWindowMaxLimit = targetWindowMinLimit + windowSize;

      for (int i = targetWindowMinLimit; i < targetWindowMaxLimit; i++) {
        if (i < allPages.size()) {
          pagesList.insertBefore(allPages.get(i), dots);
        }
      }

      this.windowIndex = index;
    }
  }

  /**
   * Checks if the total record count is visible.
   *
   * @return True if the total record count is visible, false otherwise.
   */
  public boolean isTotalRecordVisible() {
    return totalRecordVisible;
  }

  /**
   * Sets the visibility of the total record count.
   *
   * @param totalRecordVisible True to make the total record count visible, false to hide it.
   * @return This ScrollingPagination instance.
   */
  public ScrollingPagination setTotalRecordVisible(boolean totalRecordVisible) {
    this.totalRecordVisible = totalRecordVisible;
    this.totalCountNavItem.toggleDisplay(this.totalRecordVisible);
    return this;
  }

  /**
   * Shows or hides the previous and next page set navigation.
   *
   * @param visible True to show the previous and next page set navigation, false to hide it.
   * @return This ScrollingPagination instance.
   */
  public ScrollingPagination showNextPrevSet(boolean visible) {
    prevSet.toggleDisplay(visible);
    nextSet.toggleDisplay(visible);
    return this;
  }
}
