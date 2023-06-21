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

import elemental2.dom.HTMLElement;
import java.util.*;
import org.dominokit.domino.ui.elements.NavElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.i18n.PaginationLabels;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.HasChangeListeners;

/**
 * Base implementation for pagination
 *
 * @param <T> the type of the pagination
 * @author vegegoku
 * @version $Id: $Id
 */
public abstract class BasePagination<T extends BasePagination<T>>
    extends BaseDominoElement<HTMLElement, T>
    implements HasPagination<T>, PaginationStyles, HasChangeListeners<T, Integer> {

  protected NavElement pager;
  protected UListElement pagesList;

  protected UListElement pagesElement = ul().css("pagination");
  protected NavElement element = nav().appendChild(pagesElement);
  protected PagerNavItem activePage;
  protected List<PagerNavItem> allPages = new LinkedList<>();

  private final Set<ChangeListener<? super Integer>> pageChangeListeners = new HashSet<>();
  private boolean changeListenersPaused = false;

  protected String size = "pagination-default";

  protected int index = 1;
  protected boolean markActivePage = true;
  protected int pagesCount;
  protected int pageSize = 10;
  protected int totalCount = 0;

  protected PagerNavItem prevPage;
  protected PagerNavItem nextPage;
  protected PagerNavItem firstPage;
  protected PagerNavItem lastPage;

  protected PaginationLabels labels = DominoUIConfig.CONFIG.getDominoUILabels();

  /** Constructor for BasePagination. */
  public BasePagination() {
    pager = nav().addCss(dui_pager).appendChild(pagesList = ul().addCss(dui_pager_list));

    init((T) this);
    pagesList
        .appendChild(firstPage = PagerNavItem.nav(Icons.skip_previous()).collapse())
        .appendChild(prevPage = PagerNavItem.nav(Icons.chevron_left()))
        .appendChild(nextPage = PagerNavItem.nav(Icons.chevron_right()))
        .appendChild(lastPage = PagerNavItem.nav(Icons.skip_next()).collapse());
  }

  /**
   * showFirstLastPage.
   *
   * @param visible a boolean
   * @return a T object
   */
  public T showFirstLastPage(boolean visible) {
    firstPage.toggleDisplay(visible);
    lastPage.toggleDisplay(visible);
    return (T) this;
  }

  /**
   * showNextPrevPage.
   *
   * @param visible a boolean
   * @return a T object
   */
  public T showNextPrevPage(boolean visible) {
    nextPage.toggleDisplay(visible);
    prevPage.toggleDisplay(visible);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T updatePagesByTotalCount(int totalCount) {
    return updatePagesByTotalCount(totalCount, true);
  }

  /** {@inheritDoc} */
  @Override
  public T updatePagesByTotalCount(int totalCount, boolean silent) {
    int pages = (totalCount / this.pageSize) + (totalCount % this.pageSize > 0 ? 1 : 0);
    this.totalCount = totalCount;
    return updatePages(pages, this.pageSize, silent);
  }

  /** {@inheritDoc} */
  @Override
  public T updatePagesByTotalCount(int totalCount, int pageSize) {
    return updatePagesByTotalCount(totalCount, pageSize, true);
  }

  /** {@inheritDoc} */
  @Override
  public T updatePagesByTotalCount(int totalCount, int pageSize, boolean silent) {
    int pages = (totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0);
    this.totalCount = totalCount;
    return updatePages(pages, pageSize, silent);
  }

  /** {@inheritDoc} */
  @Override
  public T updatePages(int pages) {
    return updatePages(pages, true);
  }

  /** {@inheritDoc} */
  @Override
  public T updatePages(int pages, int pageSize) {
    return updatePages(pages, pageSize, true);
  }

  /** {@inheritDoc} */
  @Override
  public T gotoPage(int page) {
    return gotoPage(page, isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public T gotoPage(int page, boolean silent) {
    if (page > 0 && page <= pagesCount) {
      moveToPage(page, silent);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T nextPage() {
    return nextPage(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public T previousPage() {
    return previousPage(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public T nextPage(boolean silent) {
    moveToPage(index + 1, silent);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T previousPage(boolean silent) {
    moveToPage(index - 1, silent);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T gotoFirst() {
    return gotoFirst(false);
  }

  /** {@inheritDoc} */
  @Override
  public T gotoLast() {
    return gotoLast(false);
  }

  /** {@inheritDoc} */
  @Override
  public T gotoFirst(boolean silent) {
    if (this.pagesCount > 0) {
      return gotoPage(1, silent);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T gotoLast(boolean silent) {
    if (this.pagesCount > 0) {
      return gotoPage(pagesCount, silent);
    }
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T markActivePage() {
    this.markActivePage = true;
    gotoPage(activePage);
    return (T) this;
  }

  /**
   * A boolean to mark the active page automatically
   *
   * @param markActivePage true to mark the active page automatically, false otherwise
   * @return same instance
   */
  public T setMarkActivePage(boolean markActivePage) {
    this.markActivePage = markActivePage;
    if (!markActivePage) {
      activePage.removeCss("active");
    }

    return (T) this;
  }

  void gotoPage(PagerNavItem pagerNavItem) {
    if (nonNull(activePage)) {
      activePage.getLink().removeCss(dui_active);
    }
    if (nonNull(pagerNavItem)) {
      pagerNavItem.getLink().addCss(BooleanCssClass.of(dui_active, markActivePage));
      activePage = pagerNavItem;
    }
  }

  /** {@inheritDoc} */
  @Override
  public int getTotalCount() {
    return this.totalCount;
  }

  /** {@inheritDoc} */
  @Override
  public T setPageSize(int pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public int getPageSize() {
    return this.pageSize;
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

  /**
   * moveToPage.
   *
   * @param page a int
   * @param silent a boolean
   */
  protected abstract void moveToPage(int page, boolean silent);

  /** {@inheritDoc} */
  @Override
  public T pauseChangeListeners() {
    this.changeListenersPaused = true;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T resumeChangeListeners() {
    this.changeListenersPaused = false;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public T togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public Set<ChangeListener<? super Integer>> getChangeListeners() {
    return pageChangeListeners;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChangeListenersPaused() {
    return changeListenersPaused;
  }

  /** {@inheritDoc} */
  @Override
  public T triggerChangeListeners(Integer oldValue, Integer newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return pager.element();
  }
}
