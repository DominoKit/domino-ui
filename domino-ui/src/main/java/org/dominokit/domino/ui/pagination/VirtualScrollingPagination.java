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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.utils.HasChangeListeners;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A virtual implementation of {@link HasPagination} that does not render any DOM elements. This can
 * be used to manage pagination state for virtualized components.
 */
public class VirtualScrollingPagination
    implements HasPagination<VirtualScrollingPagination>,
        HasChangeListeners<VirtualScrollingPagination, Integer> {

  private static final Logger LOGGER = LoggerFactory.getLogger(VirtualScrollingPagination.class);

  private int index = 1;
  private int pageSize = 10;
  private int pagesCount = 0;
  private int totalCount = 0;
  private boolean changeListenersPaused = false;
  private final Set<ChangeListener<? super Integer>> changeListeners = new HashSet<>();

  /**
   * Creates a new instance of {@link VirtualScrollingPagination} with default settings.
   *
   * @return A new instance of {@link VirtualScrollingPagination}.
   */
  public static VirtualScrollingPagination create() {
    return new VirtualScrollingPagination();
  }

  /**
   * Creates a new instance of {@link VirtualScrollingPagination} with the specified number of
   * pages.
   *
   * @param pages The total number of pages.
   * @return A new instance of {@link VirtualScrollingPagination}.
   */
  public static VirtualScrollingPagination create(int pages) {
    return new VirtualScrollingPagination().updatePages(pages);
  }

  /**
   * Creates a new instance of {@link VirtualScrollingPagination} with the specified number of pages
   * and page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @return A new instance of {@link VirtualScrollingPagination}.
   */
  public static VirtualScrollingPagination create(int pages, int pageSize) {
    return new VirtualScrollingPagination().updatePages(pages, pageSize);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoPage(int page) {
    return gotoPage(page, false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoPage(int page, boolean silent) {
    if (page > 0 && page <= pagesCount && index != page) {
      int oldPage = index;
      index = page;
      if (!silent) {
        triggerChangeListeners(oldPage, index);
      }
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination nextPage() {
    return nextPage(false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination previousPage() {
    return previousPage(false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination nextPage(boolean silent) {
    return gotoPage(index + 1, silent);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination previousPage(boolean silent) {
    return gotoPage(index - 1, silent);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoFirst() {
    return gotoFirst(false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoLast() {
    return gotoLast(false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoFirst(boolean silent) {
    return gotoPage(1, silent);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoLast(boolean silent) {
    return gotoPage(pagesCount, silent);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoPageByRecordIndex(int index) {
    return gotoPageByRecordIndex(index, false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination gotoPageByRecordIndex(int index, boolean silent) {
    if (index < 0 || index >= totalCount) {
      LOGGER.warn(
          "Record index "
              + index
              + " is out of range. Total count is "
              + totalCount
              + ". Navigation ignored.");
      return this;
    }
    int page = (index / pageSize) + 1;
    return gotoPage(page, silent);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination markActivePage() {
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePages(int pages) {
    return updatePages(pages, false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePages(int pages, boolean silent) {
    return updatePages(pages, pageSize, silent);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePages(int pages, int pageSize) {
    return updatePages(pages, pageSize, false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePages(int pages, int pageSize, boolean silent) {
    int oldPage = this.index;
    this.pageSize = pageSize;
    this.pagesCount = pages;
    this.index = pages > 0 ? 1 : 0;
    if (!silent) {
      triggerChangeListeners(oldPage, this.index);
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePagesByTotalCount(int totalCount) {
    return updatePagesByTotalCount(totalCount, false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePagesByTotalCount(int totalCount, boolean silent) {
    return updatePagesByTotalCount(totalCount, pageSize, silent);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePagesByTotalCount(int totalCount, int pageSize) {
    return updatePagesByTotalCount(totalCount, pageSize, false);
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination updatePagesByTotalCount(
      int totalCount, int pageSize, boolean silent) {
    this.totalCount = totalCount;
    this.pageSize = pageSize;
    int pages = (int) Math.ceil((double) totalCount / (double) pageSize);
    return updatePages(pages, pageSize, silent);
  }

  /** {@inheritDoc} */
  @Override
  public int getTotalCount() {
    return totalCount;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination setPageSize(int pageSize) {
    this.pageSize = pageSize;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public int getPageSize() {
    return pageSize;
  }

  /** {@inheritDoc} */
  @Override
  public int activePage() {
    return index;
  }

  /** {@inheritDoc} */
  @Override
  public int getPagesCount() {
    return pagesCount;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination pauseChangeListeners() {
    this.changeListenersPaused = true;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination resumeChangeListeners() {
    this.changeListenersPaused = false;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<ChangeListener<? super Integer>> getChangeListeners() {
    return changeListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChangeListenersPaused() {
    return changeListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public VirtualScrollingPagination triggerChangeListeners(Integer oldValue, Integer newValue) {
    if (!changeListenersPaused) {
      new ArrayList<>(changeListeners)
          .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    }
    return this;
  }
}
