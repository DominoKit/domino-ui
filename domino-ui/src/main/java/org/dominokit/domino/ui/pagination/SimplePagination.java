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

import java.util.stream.IntStream;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A simple pagination implementation
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class SimplePagination extends BasePagination<SimplePagination> {

  /** @return new instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.pagination.SimplePagination} object
   */
  public static SimplePagination create() {
    return new SimplePagination();
  }

  /**
   * create.
   *
   * @param pages the number of pages
   * @return new instance
   */
  public static SimplePagination create(int pages) {
    return new SimplePagination(pages);
  }

  /**
   * create.
   *
   * @param pages the number of pages
   * @param pageSize the page size
   * @return new instance
   */
  public static SimplePagination create(int pages, int pageSize) {
    return new SimplePagination(pages, pageSize);
  }

  /** Constructor for SimplePagination. */
  public SimplePagination() {
    this(0);
  }

  /**
   * Constructor for SimplePagination.
   *
   * @param pages a int
   */
  public SimplePagination(int pages) {
    this(pages, 10);
  }

  /**
   * Constructor for SimplePagination.
   *
   * @param pages a int
   * @param pageSize a int
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

  /** {@inheritDoc} */
  @Override
  public SimplePagination updatePages(int pages, boolean silent) {
    return updatePages(pages, pageSize, silent);
  }

  /** {@inheritDoc} */
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

  private void clearPages() {
    allPages.forEach(BaseDominoElement::remove);
    allPages.clear();
  }

  /** {@inheritDoc} */
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
