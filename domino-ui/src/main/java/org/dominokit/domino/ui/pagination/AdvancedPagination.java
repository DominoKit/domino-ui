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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import java.util.stream.IntStream;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Represents an advanced pagination component that provides various navigation options for moving
 * between pages. It includes a dropdown select for direct page selection in addition to the
 * standard navigation buttons.
 *
 * <p>Usage Example:
 *
 * <pre><code>
 * AdvancedPagination pagination = AdvancedPagination.create(10, 20);
 * pagination.addPageChangeListener((oldPage, newPage) -> {
 *     // Handle page change event
 * });
 * HTMLElement paginationElement = pagination.element();
 * document.body.appendChild(paginationElement);
 * </code></pre>
 */
public class AdvancedPagination extends BasePagination<AdvancedPagination> {

  private Select<Integer> pagesSelect;
  private PagerNavItem totalPagesCount;

  /**
   * Creates a new instance of {@link AdvancedPagination} with default settings.
   *
   * @return A new instance of {@link AdvancedPagination}.
   */
  public static AdvancedPagination create() {
    return new AdvancedPagination();
  }

  /**
   * Creates a new instance of {@link AdvancedPagination} with the specified number of pages.
   *
   * @param pages The total number of pages.
   * @return A new instance of {@link AdvancedPagination}.
   */
  public static AdvancedPagination create(int pages) {
    return new AdvancedPagination(pages);
  }

  /**
   * Creates a new instance of {@link AdvancedPagination} with the specified number of pages and
   * page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @return A new instance of {@link AdvancedPagination}.
   */
  public static AdvancedPagination create(int pages, int pageSize) {
    return new AdvancedPagination(pages, pageSize);
  }

  /** Creates a new instance of {@link AdvancedPagination} with default settings. */
  public AdvancedPagination() {
    this(0, 10);
  }

  /**
   * Creates a new instance of {@link AdvancedPagination} with the specified number of pages.
   *
   * @param pages The total number of pages.
   */
  public AdvancedPagination(int pages) {
    this(pages, 10);
  }

  /**
   * Creates a new instance of {@link AdvancedPagination} with the specified number of pages and
   * page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   */
  public AdvancedPagination(int pages, int pageSize) {
    this.pagesCount = pages;
    this.pageSize = pageSize;

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

    pagesSelect =
        Select.<Integer>create()
            .addChangeListener(
                (oldValue, newValue) -> moveToPage(newValue, isChangeListenersPaused()));

    pagesList.insertAfter(
        PagerNavItem.create(pagesSelect)
            .withLink((parent, link) -> link.addCss(dui_pagination_select)),
        prevPage);
    totalPagesCount =
        PagerNavItem.create(text(labels.getPaginationCountLabel(pagesCount)))
            .withLink((parent, link) -> link.addCss(dui_page_count));
    pagesList.insertBefore(totalPagesCount, nextPage);

    updatePages(pages, pageSize, isChangeListenersPaused());
  }

  /**
   * Updates the pagination component with the specified number of pages.
   *
   * @param pages The total number of pages.
   * @param silent If true, the change listeners will not be triggered; otherwise, they will be
   *     notified.
   * @return This {@link AdvancedPagination} instance for method chaining.
   */
  @Override
  public AdvancedPagination updatePages(int pages, boolean silent) {
    return updatePages(pages, pageSize, silent);
  }

  /**
   * Updates the pagination component with the specified number of pages and page size.
   *
   * @param pages The total number of pages.
   * @param pageSize The number of items per page.
   * @param silent If true, the change listeners will not be triggered; otherwise, they will be
   *     notified.
   * @return This {@link AdvancedPagination} instance for method chaining.
   */
  @Override
  public AdvancedPagination updatePages(int pages, int pageSize, boolean silent) {
    this.pageSize = pageSize;
    this.pagesCount = pages;
    this.index = 1;
    allPages.clear();
    pagesSelect.removeAllOptions();
    if (pages > 0) {
      IntStream.rangeClosed(1, pages)
          .forEach(
              p -> {
                pagesSelect.appendItem(
                    page -> SelectOption.create(String.valueOf(p), p, String.valueOf(p)), p);
                allPages.add(PagerNavItem.page(p));
              });
    }

    totalPagesCount.withLink(
        (parent, link) ->
            link.clearElement().appendChild(text(labels.getPaginationCountLabel(pagesCount))));

    if (pages > 0) {
      moveToPage(1, silent);
    }

    if (pages <= 0) {
      prevPage.disable();
      firstPage.disable();
      nextPage.disable();
      lastPage.disable();
      if (!silent) {
        triggerChangeListeners(null, 0);
      }
    }
    return this;
  }

  private void addListenerToElement(
      DominoElement<? extends HTMLElement> element, EventListener listener) {
    element.addClickListener(listener);
    element.onKeyDown(keyEvents -> keyEvents.onEnter(listener));
  }

  /**
   * Moves the pagination to the specified page.
   *
   * @param page The target page number.
   * @param silent If true, the change listeners will not be triggered; otherwise, they will be
   *     notified.
   */
  @Override
  protected void moveToPage(int page, boolean silent) {
    PagerNavItem oldPage = activePage;
    if (page > 0 && page <= pagesCount) {
      index = page;
      if (!silent) {
        triggerChangeListeners(nonNull(oldPage) ? oldPage.getPage() : null, page);
      }

      if (page == pagesCount) {
        nextPage.disable();
        lastPage.disable();
      } else {
        nextPage.enable();
        lastPage.enable();
      }

      if (page == 1) {
        prevPage.disable();
        firstPage.disable();
      } else {
        prevPage.enable();
        firstPage.enable();
      }

      pagesSelect.withPauseChangeListenersToggle(true, select -> pagesSelect.selectAt(page - 1));
    }
  }

  /**
   * Gets the Select component used for direct page selection.
   *
   * @return The {@link Select} component for page selection.
   */
  public Select<Integer> getPagesSelect() {
    return pagesSelect;
  }

  /**
   * Allows customizing the {@link Select} component used for direct page selection.
   *
   * @param handler A {@link ChildHandler} for configuring the {@link Select} component.
   * @return This {@link AdvancedPagination} instance for method chaining.
   */
  public AdvancedPagination withPagesSelect(
      ChildHandler<AdvancedPagination, Select<Integer>> handler) {
    handler.apply(this, pagesSelect);
    return this;
  }
}
