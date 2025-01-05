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

import static org.jboss.elemento.Elements.*;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Base implementation for pagination
 *
 * @param <T> the type of the pagination
 */
public abstract class BasePagination<T extends BasePagination<T>>
    extends BaseDominoElement<HTMLElement, T> implements HasPagination {

  protected DominoElement<HTMLUListElement> pagesElement = DominoElement.of(ul()).css("pagination");
  protected DominoElement<HTMLElement> element = DominoElement.of(nav()).add(pagesElement);
  protected DominoElement<? extends HTMLElement> activePage = DominoElement.of(li());
  protected DominoElement<? extends HTMLElement> prevElement;
  protected DominoElement<? extends HTMLElement> nextElement;

  protected PageChangedCallBack pageChangedCallBack = pageIndex -> {};
  protected String size = "pagination-default";

  protected int index = 1;
  protected boolean markActivePage = true;
  protected int pagesCount;
  protected int pageSize = 10;
  protected int totalCount = 0;

  /** {@inheritDoc} */
  @Override
  public HasPagination updatePagesByTotalCount(int totalCount) {
    return updatePagesByTotalCount(totalCount, true);
  }

  /** {@inheritDoc} */
  @Override
  public HasPagination updatePagesByTotalCount(int totalCount, boolean silent) {
    int pages = (totalCount / this.pageSize) + (totalCount % this.pageSize > 0 ? 1 : 0);
    this.totalCount = totalCount;
    return updatePages(pages, this.pageSize, silent);
  }

  /** {@inheritDoc} */
  @Override
  public HasPagination updatePagesByTotalCount(int totalCount, int pageSize) {
    return updatePagesByTotalCount(totalCount, pageSize, true);
  }

  /** {@inheritDoc} */
  @Override
  public HasPagination updatePagesByTotalCount(int totalCount, int pageSize, boolean silent) {
    int pages = (totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0);
    this.totalCount = totalCount;
    return updatePages(pages, pageSize, silent);
  }

  @Override
  public HasPagination updatePages(int pages) {
    return updatePages(pages, true);
  }

  @Override
  public HasPagination updatePages(int pages, int pageSize) {
    return updatePages(pages, pageSize, true);
  }

  /** {@inheritDoc} */
  @Override
  public T gotoPage(int page) {
    return gotoPage(page, false);
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
    return nextPage(false);
  }

  /** {@inheritDoc} */
  @Override
  public T previousPage() {
    return previousPage(false);
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

  void gotoPage(DominoElement<? extends HTMLElement> li) {
    activePage.removeCss("active");
    activePage = li;
    if (markActivePage) {
      activePage.addCss("active");
    }
  }

  /** {@inheritDoc} */
  @Override
  public T onPageChanged(PageChangedCallBack pageChangedCallBack) {
    this.pageChangedCallBack = pageChangedCallBack;
    return (T) this;
  }

  /**
   * Sets the size to large
   *
   * @return same instance
   */
  public T large() {
    return setSize("pagination-lg");
  }

  /**
   * Sets the size to small
   *
   * @return same instance
   */
  public T small() {
    return setSize("pagination-sm");
  }

  private T setSize(String sizeStyle) {
    pagesElement.removeCss(size);
    pagesElement.addCss(sizeStyle);
    size = sizeStyle;
    return (T) this;
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

  protected abstract void moveToPage(int page, boolean silent);

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }
}
