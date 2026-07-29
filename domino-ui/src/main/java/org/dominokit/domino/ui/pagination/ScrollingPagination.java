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
import static org.dominokit.domino.ui.utils.Domino.text;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.PaginationConfig;
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
public class ScrollingPagination extends BasePagination<ScrollingPagination>
    implements HasComponentConfig<PaginationConfig> {

  private final int windowSize;
  private int windowIndex = 0;
  private boolean totalRecordVisible = false;
  private final PagerNavItem nextDots;
  private final PagerNavItem prevDots;
  protected PagerNavItem prevSet;
  protected PagerNavItem nextSet;
  private final PagerNavItem totalCountNavItem;
  private Map<Integer, PagerNavItem> activeWindow = new HashMap<>();
  private boolean compactMode = false;

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
    pagesList.addCss("dui-scrolling-pagination");
    pagesList.insertFirst(prevSet = PagerNavItem.nav(Icons.page_first()).collapse());
    pagesList.appendChild(nextSet = PagerNavItem.nav(Icons.page_last()).collapse());

    firstPage
        .setCssProperty("order", "-30")
        .expand()
        .getLink()
        .addClickListener(evt -> moveToPage(1, isChangeListenersPaused()))
        .onKeyDown(keyEvents -> keyEvents.onEnter(evt -> moveToPage(1, isChangeListenersPaused())));

    prevSet
        .setCssProperty("order", "-20")
        .expand()
        .getLink()
        .addClickListener(evt -> moveToPage((windowIndex * windowSize), isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(
                    evt -> moveToPage((windowIndex * windowSize), isChangeListenersPaused())));

    prevPage
        .setCssProperty("order", "-10")
        .getLink()
        .addClickListener(evt -> moveToPage(index - 1, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(index - 1, isChangeListenersPaused())));

    nextDots =
        PagerNavItem.create(text("..."))
            .setCssProperty("order", String.valueOf((pagesCount * 10) - 5))
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

    nextPage
        .setCssProperty("order", String.valueOf(getMaxPageOrder() + 30))
        .getLink()
        .addClickListener(evt -> moveToPage(index + 1, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(index + 1, isChangeListenersPaused())));

    nextSet
        .setCssProperty("order", String.valueOf(getMaxPageOrder() + 40))
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

    lastPage
        .setCssProperty("order", String.valueOf(getMaxPageOrder() + 50))
        .expand()
        .getLink()
        .addClickListener(evt -> moveToPage(pagesCount, isChangeListenersPaused()))
        .onKeyDown(
            keyEvents ->
                keyEvents.onEnter(evt -> moveToPage(pagesCount, isChangeListenersPaused())));

    prevDots =
        PagerNavItem.create(text("..."))
            .setCssProperty("order", "15")
            .addClickListener(
                evt -> moveToPage((windowIndex * windowSize), isChangeListenersPaused()))
            .onKeyDown(
                keyEvents ->
                    keyEvents.onEnter(
                        evt -> moveToPage((windowIndex * windowSize), isChangeListenersPaused())));

    totalCountNavItem =
        PagerNavItem.create(text("(" + this.getTotalCount() + ")"))
            .setCssProperty("order", String.valueOf(getMaxPageOrder() + 25));
    pagesList
        .appendChild(firstPage)
        .appendChild(prevSet)
        .appendChild(prevPage)
        .appendChild(prevDots)
        .appendChild(nextDots)
        .appendChild(nextPage)
        .appendChild(nextSet)
        .appendChild(lastPage)
        .appendChild(totalCountNavItem);
    updatePages(pages, pageSize);
    setCompactMode(getConfig().defaultCompactMode());
  }

  private int getMaxPageOrder() {
    return pagesCount * 10;
  }

  private boolean insureVisible() {
    return (pagesCount > windowSize) || !compactMode;
  }

  /**
   * Checks whether the pagination is in compact mode. In compact mode, certain navigation elements
   * such as "first", "previous set", "next set", and "last" are disabled to provide a simplified
   * and minimalistic pagination view.
   *
   * @return true if compact mode is enabled, false otherwise.
   */
  public boolean isCompactMode() {
    return compactMode;
  }

  /**
   * Sets the compact mode for the pagination. In compact mode, some navigation elements such as
   * "first", "previous set", "next set", and "last" are toggled off, and the pagination focuses on
   * a simplified view. The compact mode can be useful for saving space in the UI or displaying a
   * minimalistic view of pagination.
   *
   * @param compactMode {@code true} to enable compact mode, {@code false} to disable it.
   * @return This {@code ScrollingPagination} instance for method chaining.
   */
  public final ScrollingPagination setCompactMode(boolean compactMode) {
    this.compactMode = compactMode;
    firstPage.toggleDisplay(!compactMode);
    prevSet.toggleDisplay(!compactMode);
    nextSet.toggleDisplay(!compactMode);
    lastPage.toggleDisplay(!compactMode);
    scrollToWindow(windowIndex);
    return this;
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
    nextDots.setCssProperty("order", String.valueOf((pagesCount * 10) - 5));

    if (pages > 0) {
      scrollToWindow(0);
    }

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

  private void scrollToWindow(int windowIndex) {
    activeWindow.values().forEach(BaseDominoElement::remove);
    activeWindow.clear();
    addPage(1);
    addPage(pagesCount);
    IntStream.rangeClosed(
            (windowIndex * windowSize) + 1,
            Math.min((windowIndex * windowSize) + windowSize, pagesCount))
        .forEach(
            p -> {
              if (!activeWindow.containsKey(p)) {
                addPage(p);
              }
            });
    this.windowIndex = windowIndex;
    this.prevDots.toggleDisplay(windowIndex > 0);
    this.nextDots.toggleDisplay(windowIndex < pagesCount / windowSize - 1);
  }

  private void addPage(int p) {
    PagerNavItem page = createPageNavItem(p);
    pagesList.appendChild(page);
    activeWindow.put(p, page);
  }

  private PagerNavItem createPageNavItem(int p) {
    PagerNavItem page =
        PagerNavItem.page(p)
            .setCssProperty("order", String.valueOf(p * 10))
            .addClickListener(evt -> moveToPage(p, isChangeListenersPaused()))
            .onKeyDown(
                keyEvents -> keyEvents.onEnter(evt -> moveToPage(p, isChangeListenersPaused())));
    return page;
  }

  /** Clears all pages from the pagination. */
  private void clearPages() {
    activeWindow.values().forEach(BaseDominoElement::remove);
    activeWindow.clear();
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

      showPageWindow(page);

      index = page;
      if (markActivePage) {
        gotoPage(activeWindow.get(page));
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
    }
  }

  /**
   * Shows the window of pages based on the given page index.
   *
   * @param page The current page index.
   */
  private void showPageWindow(int page) {
    int pageWindowIndex = page % windowSize == 0 ? (page / windowSize) - 1 : page / windowSize;
    if (windowIndex != pageWindowIndex) {
      scrollToWindow(pageWindowIndex);
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
