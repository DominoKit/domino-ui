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

import elemental2.dom.HTMLElement;
import java.util.*;
import org.dominokit.domino.ui.elements.NavElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.i18n.PaginationLabels;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.HasChangeListeners;

/**
 * BasePagination provides a base implementation for pagination components in Domino UI. It supports
 * features like navigating to pages, updating pages by total count, and more.
 *
 * <p>Usage example:
 *
 * <pre>
 * // Create a pagination component
 * BasePagination pagination = new BasePagination() {
 *     // Override the moveToPage method to implement navigation logic
 *     protected void moveToPage(int page, boolean silent) {
 *         // Your implementation here
 *     }
 * };
 *
 * // Add pagination to a container element
 * container.appendChild(pagination.element());
 *
 * // Update the pagination with total count and page size
 * pagination.updatePagesByTotalCount(100);
 * </pre>
 *
 * @param <T> The concrete type of the pagination component.
 * @see BaseDominoElement
 */
public abstract class BasePagination<T extends BasePagination<T>>
    extends BaseDominoElement<HTMLElement, T>
    implements HasPagination<T>, PaginationStyles, HasChangeListeners<T, Integer> {

  protected NavElement pager;
  protected UListElement pagesList;
  protected PagerNavItem activePage;

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

  /** Creates a new BasePagination instance. */
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
   * Shows or hides the "First" and "Last" page navigation buttons.
   *
   * @param visible {@code true} to show, {@code false} to hide.
   * @return The BasePagination instance.
   */
  public T showFirstLastPage(boolean visible) {
    firstPage.toggleDisplay(visible);
    lastPage.toggleDisplay(visible);
    return (T) this;
  }

  /**
   * Shows or hides the "Next" and "Previous" page navigation buttons.
   *
   * @param visible {@code true} to show, {@code false} to hide.
   * @return The BasePagination instance.
   */
  public T showNextPrevPage(boolean visible) {
    nextPage.toggleDisplay(visible);
    prevPage.toggleDisplay(visible);
    return (T) this;
  }

  /**
   * Updates the pagination based on the total count of items. This method calculates the number of
   * pages based on the total count and the current page size, and then updates the pagination
   * accordingly.
   *
   * @param totalCount The total count of items.
   * @return The BasePagination instance.
   */
  @Override
  public T updatePagesByTotalCount(int totalCount) {
    return updatePagesByTotalCount(totalCount, true);
  }

  /**
   * Updates the pagination based on the total count of items. This method calculates the number of
   * pages based on the total count and the current page size, and then updates the pagination
   * accordingly.
   *
   * @param totalCount The total count of items.
   * @param silent {@code true} to update silently (without triggering listeners), {@code false}
   *     otherwise.
   * @return The BasePagination instance.
   */
  @Override
  public T updatePagesByTotalCount(int totalCount, boolean silent) {
    int pages = (totalCount / this.pageSize) + (totalCount % this.pageSize > 0 ? 1 : 0);
    this.totalCount = totalCount;
    return updatePages(pages, this.pageSize, silent);
  }

  /**
   * Updates the pagination based on the total count of items and a custom page size. This method
   * calculates the number of pages based on the total count and the specified page size, and then
   * updates the pagination accordingly.
   *
   * @param totalCount The total count of items.
   * @param pageSize The custom page size.
   * @return The BasePagination instance.
   */
  @Override
  public T updatePagesByTotalCount(int totalCount, int pageSize) {
    return updatePagesByTotalCount(totalCount, pageSize, true);
  }

  /**
   * Updates the pagination based on the total count of items and a custom page size. This method
   * calculates the number of pages based on the total count and the specified page size, and then
   * updates the pagination accordingly.
   *
   * @param totalCount The total count of items.
   * @param pageSize The custom page size.
   * @param silent {@code true} to update silently (without triggering listeners), {@code false}
   *     otherwise.
   * @return The BasePagination instance.
   */
  @Override
  public T updatePagesByTotalCount(int totalCount, int pageSize, boolean silent) {
    int pages = (totalCount / pageSize) + (totalCount % pageSize > 0 ? 1 : 0);
    this.totalCount = totalCount;
    return updatePages(pages, pageSize, silent);
  }

  /**
   * Updates the pagination with the specified number of pages. This method updates the pagination
   * with the given number of pages and the current page size.
   *
   * @param pages The number of pages.
   * @return The BasePagination instance.
   */
  @Override
  public T updatePages(int pages) {
    return updatePages(pages, true);
  }

  /**
   * Updates the pagination with the specified number of pages and a custom page size. This method
   * updates the pagination with the given number of pages and the specified page size.
   *
   * @param pages The number of pages.
   * @param pageSize The custom page size.
   * @return The BasePagination instance.
   */
  @Override
  public T updatePages(int pages, int pageSize) {
    return updatePages(pages, pageSize, true);
  }

  /**
   * Navigates to the specified page. If the provided page number is within the valid page range,
   * this method will move the pagination to the specified page.
   *
   * @param page The page number to navigate to.
   * @return The BasePagination instance.
   */
  @Override
  public T gotoPage(int page) {
    return gotoPage(page, isChangeListenersPaused());
  }

  /**
   * Navigates to the specified page. If the provided page number is within the valid page range,
   * this method will move the pagination to the specified page.
   *
   * @param page The page number to navigate to.
   * @param silent {@code true} to navigate silently (without triggering listeners), {@code false}
   *     otherwise.
   * @return The BasePagination instance.
   */
  @Override
  public T gotoPage(int page, boolean silent) {
    if (page > 0 && page <= pagesCount) {
      moveToPage(page, silent);
    }
    return (T) this;
  }

  /**
   * Navigates to the next page.
   *
   * @return The BasePagination instance.
   */
  @Override
  public T nextPage() {
    return nextPage(isChangeListenersPaused());
  }

  /**
   * Navigates to the previous page.
   *
   * @return The BasePagination instance.
   */
  @Override
  public T previousPage() {
    return previousPage(isChangeListenersPaused());
  }

  /**
   * Navigates to the next page.
   *
   * @param silent {@code true} to navigate silently (without triggering listeners), {@code false}
   *     otherwise.
   * @return The BasePagination instance.
   */
  @Override
  public T nextPage(boolean silent) {
    moveToPage(index + 1, silent);
    return (T) this;
  }

  /**
   * Navigates to the previous page.
   *
   * @param silent {@code true} to navigate silently (without triggering listeners), {@code false}
   *     otherwise.
   * @return The BasePagination instance.
   */
  @Override
  public T previousPage(boolean silent) {
    moveToPage(index - 1, silent);
    return (T) this;
  }

  /**
   * Navigates to the first page.
   *
   * @return The BasePagination instance.
   */
  @Override
  public T gotoFirst() {
    return gotoFirst(false);
  }

  /**
   * Navigates to the last page.
   *
   * @return The BasePagination instance.
   */
  @Override
  public T gotoLast() {
    return gotoLast(false);
  }

  /**
   * Navigates to the first page.
   *
   * @param silent {@code true} to navigate silently (without triggering listeners), {@code false}
   *     otherwise.
   * @return The BasePagination instance.
   */
  @Override
  public T gotoFirst(boolean silent) {
    if (this.pagesCount > 0) {
      return gotoPage(1, silent);
    }
    return (T) this;
  }

  /**
   * Navigates to the last page.
   *
   * @param silent {@code true} to navigate silently (without triggering listeners), {@code false}
   *     otherwise.
   * @return The BasePagination instance.
   */
  @Override
  public T gotoLast(boolean silent) {
    if (this.pagesCount > 0) {
      return gotoPage(pagesCount, silent);
    }
    return (T) this;
  }

  /**
   * Marks the currently active page as active by adding the "active" CSS class. If the
   * "markActivePage" property is set to {@code true}, this method is automatically called when
   * navigating between pages.
   *
   * @return The BasePagination instance.
   */
  @Override
  public T markActivePage() {
    this.markActivePage = true;
    gotoPage(activePage);
    return (T) this;
  }

  /**
   * Sets whether to mark the active page with the "active" CSS class.
   *
   * @param markActivePage {@code true} to mark the active page as active, {@code false} to remove
   *     the "active" class.
   * @return The BasePagination instance.
   */
  public T setMarkActivePage(boolean markActivePage) {
    this.markActivePage = markActivePage;
    if (!markActivePage) {
      activePage.removeCss("active");
    }

    return (T) this;
  }

  /**
   * Internal method to navigate to a specific page and mark it as active.
   *
   * @param pagerNavItem The PagerNavItem representing the page to be marked as active.
   */
  void gotoPage(PagerNavItem pagerNavItem) {
    if (nonNull(activePage)) {
      activePage.getLink().removeCss(dui_active);
    }
    if (nonNull(pagerNavItem)) {
      pagerNavItem.getLink().addCss(BooleanCssClass.of(dui_active, markActivePage));
      activePage = pagerNavItem;
    }
  }

  /**
   * Gets the total count of items.
   *
   * @return The total count of items.
   */
  @Override
  public int getTotalCount() {
    return this.totalCount;
  }

  /**
   * Sets the page size for pagination.
   *
   * @param pageSize The page size.
   * @return The BasePagination instance.
   */
  @Override
  public T setPageSize(int pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }

  /**
   * Gets the page size for pagination.
   *
   * @return The page size.
   */
  @Override
  public int getPageSize() {
    return this.pageSize;
  }

  /**
   * Gets the active page index.
   *
   * @return The active page index.
   */
  @Override
  public int activePage() {
    return index;
  }

  /**
   * Gets the total number of pages.
   *
   * @return The total number of pages.
   */
  @Override
  public int getPagesCount() {
    return pagesCount;
  }

  /**
   * Configures the navigation element of the pagination using a custom child handler.
   *
   * @param handler A {@link ChildHandler} to configure the navigation element.
   * @return The BasePagination instance.
   */
  public T withNavElement(ChildHandler<T, NavElement> handler) {
    handler.apply((T) this, pager);
    return (T) this;
  }

  /**
   * Configures the page list element of the pagination using a custom child handler.
   *
   * @param handler A {@link ChildHandler} to configure the page list element.
   * @return The BasePagination instance.
   */
  public T withPageList(ChildHandler<T, UListElement> handler) {
    handler.apply((T) this, pagesList);
    return (T) this;
  }

  /**
   * Configures the previous page navigation element of the pagination using a custom child handler.
   *
   * @param handler A {@link ChildHandler} to configure the previous page navigation element.
   * @return The BasePagination instance.
   */
  public T withPrevPageNav(ChildHandler<T, PagerNavItem> handler) {
    handler.apply((T) this, prevPage);
    return (T) this;
  }

  /**
   * Configures the next page navigation element of the pagination using a custom child handler.
   *
   * @param handler A {@link ChildHandler} to configure the next page navigation element.
   * @return The BasePagination instance.
   */
  public T withNextPageNav(ChildHandler<T, PagerNavItem> handler) {
    handler.apply((T) this, nextPage);
    return (T) this;
  }

  /**
   * Configures the first page navigation element of the pagination using a custom child handler.
   *
   * @param handler A {@link ChildHandler} to configure the first page navigation element.
   * @return The BasePagination instance.
   */
  public T withFirstPageNav(ChildHandler<T, PagerNavItem> handler) {
    handler.apply((T) this, firstPage);
    return (T) this;
  }

  /**
   * Configures the last page navigation element of the pagination using a custom child handler.
   *
   * @param handler A {@link ChildHandler} to configure the last page navigation element.
   * @return The BasePagination instance.
   */
  public T withLastPageNav(ChildHandler<T, PagerNavItem> handler) {
    handler.apply((T) this, lastPage);
    return (T) this;
  }

  /**
   * Moves to the specified page, triggering change listeners if not silent. Subclasses should
   * implement this method to perform the actual page navigation.
   *
   * @param page The target page number.
   * @param silent If true, change listeners won't be triggered.
   */
  protected abstract void moveToPage(int page, boolean silent);

  /**
   * Pauses change listeners for this pagination component.
   *
   * @return The BasePagination instance.
   */
  @Override
  public T pauseChangeListeners() {
    this.changeListenersPaused = true;
    return (T) this;
  }

  /**
   * Resumes change listeners for this pagination component.
   *
   * @return The BasePagination instance.
   */
  @Override
  public T resumeChangeListeners() {
    this.changeListenersPaused = false;
    return (T) this;
  }

  /**
   * Toggles the state of change listeners for this pagination component.
   *
   * @param toggle If true, change listeners will be paused; otherwise, they will be resumed.
   * @return The BasePagination instance.
   */
  @Override
  public T togglePauseChangeListeners(boolean toggle) {
    this.changeListenersPaused = toggle;
    return (T) this;
  }

  /**
   * Gets the set of change listeners registered for this pagination component.
   *
   * @return A set of {@link ChangeListener} objects.
   */
  @Override
  public Set<ChangeListener<? super Integer>> getChangeListeners() {
    return pageChangeListeners;
  }

  /**
   * Checks if change listeners for this pagination component are currently paused.
   *
   * @return True if change listeners are paused, false otherwise.
   */
  @Override
  public boolean isChangeListenersPaused() {
    return changeListenersPaused;
  }

  /**
   * Triggers change listeners with the old and new values.
   *
   * @param oldValue The old value before the change.
   * @param newValue The new value after the change.
   * @return The BasePagination instance.
   */
  @Override
  public T triggerChangeListeners(Integer oldValue, Integer newValue) {
    getChangeListeners()
        .forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return (T) this;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Gets the underlying HTML element representing the pagination component.
   * @return The HTML element.
   */
  @Override
  public HTMLElement element() {
    return pager.element();
  }
}
