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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import java.util.stream.IntStream;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;

/** An advanced pagination implementation */
public class AdvancedPagination extends BasePagination<AdvancedPagination> {

  private Select<Integer> pagesSelect;
  private PagerNavItem totalPagesCount;

  /** @return new instance */
  public static AdvancedPagination create() {
    return new AdvancedPagination();
  }

  /**
   * @param pages the number of pages
   * @return new instance
   */
  public static AdvancedPagination create(int pages) {
    return new AdvancedPagination(pages);
  }

  /**
   * @param pages the number of pages
   * @param pageSize the page size
   * @return new instance
   */
  public static AdvancedPagination create(int pages, int pageSize) {
    return new AdvancedPagination(pages, pageSize);
  }

  public AdvancedPagination() {
    this(0, 10);
  }

  public AdvancedPagination(int pages) {
    this(pages, 10);
  }

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

  /** {@inheritDoc} */
  @Override
  public AdvancedPagination updatePages(int pages, boolean silent) {
    return updatePages(pages, pageSize, silent);
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
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

  public Select<Integer> getPagesSelect() {
    return pagesSelect;
  }

  public AdvancedPagination withPagesSelect(
      ChildHandler<AdvancedPagination, Select<Integer>> handler) {
    handler.apply(this, pagesSelect);
    return this;
  }
}
