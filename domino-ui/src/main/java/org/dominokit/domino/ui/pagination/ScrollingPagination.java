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

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** A scrolling pagination implementation */
public class ScrollingPagination extends BasePagination<ScrollingPagination> {

  private DominoElement<HTMLLIElement> prevSet;
  private DominoElement<HTMLLIElement> firstPage;
  private DominoElement<HTMLLIElement> nextSet;
  private DominoElement<HTMLLIElement> lastPage;

  private DominoElement<HTMLLIElement> dotsElement;
  private DominoElement<HTMLLIElement> pagesCountPageElement;
  private DominoElement<HTMLAnchorElement> prevAnchor;
  private DominoElement<HTMLAnchorElement> prevSetAnchor;
  private DominoElement<HTMLAnchorElement> firstPageAnchor;
  private DominoElement<HTMLAnchorElement> dotsAnchor;
  private DominoElement<HTMLAnchorElement> nextAnchor;
  private DominoElement<HTMLAnchorElement> nextSetAnchor;
  private DominoElement<HTMLAnchorElement> lastPageAnchor;

  private final int windowSize;
  private int windowIndex = 0;
  private boolean totalRecordVisible = false;
  private Map<Integer, DominoElement<? extends HTMLElement>> activeWindow = new HashMap<>();

  /** @return new instance */
  public static ScrollingPagination create() {
    return new ScrollingPagination();
  }

  /**
   * @param pages the number of pages
   * @return new instance
   */
  public static ScrollingPagination create(int pages) {
    return new ScrollingPagination(pages);
  }

  /**
   * @param pages the number of pages
   * @param pageSize the page size
   * @return new instance
   */
  public static ScrollingPagination create(int pages, int pageSize) {
    return new ScrollingPagination(pages, pageSize);
  }

  /**
   * @param pages the number of pages
   * @param pageSize the page size
   * @param windowSize the number of pages to show in a window
   * @return new instance
   */
  public static ScrollingPagination create(int pages, int pageSize, int windowSize) {
    return new ScrollingPagination(pages, pageSize, windowSize);
  }

  public ScrollingPagination() {
    this(0, 10, 10);
  }

  public ScrollingPagination(int pages) {
    this(pages, 10, 10);
  }

  public ScrollingPagination(int pages, int pageSize) {
    this(pages, pageSize, 10);
  }

  public ScrollingPagination(int pages, int pageSize, int windowSize) {
    this.pagesCount = pages;
    this.pageSize = pageSize;
    this.windowSize = windowSize;
    init(this);
    updatePages(pages, pageSize);
  }

  /** {@inheritDoc} */
  @Override
  public ScrollingPagination updatePages(int pages, boolean silent) {
    return updatePages(pages, pageSize, silent);
  }

  /** {@inheritDoc} */
  @Override
  public ScrollingPagination updatePages(int pages, int pageSize, boolean silent) {
    this.pageSize = pageSize;
    this.pagesCount = pages;
    this.index = 1;

    prevAnchor = DominoElement.of(a());
    prevElement =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                prevAnchor
                    .appendChild(Icons.ALL.chevron_left().clickable())
                    .addClickListener(event -> moveToPage(index - 1, false)));

    prevSetAnchor = DominoElement.of(a());
    prevSet =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                prevSetAnchor
                    .appendChild(Icons.ALL.first_page().clickable())
                    .addClickListener(event -> moveToPage((windowIndex * windowSize), false)));

    firstPageAnchor = DominoElement.of(a());
    firstPage =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                firstPageAnchor
                    .appendChild(Icons.ALL.skip_previous().clickable())
                    .addClickListener(event -> moveToPage(1, false)));

    pagesElement
        .clearElement()
        .appendChild(firstPage)
        .appendChild(prevSet)
        .appendChild(prevElement);

    if (pages > 0) {
      scrollToWindow(0);
    }

    if (pages > windowSize) {
      dotsAnchor = DominoElement.of(a());
      dotsElement =
          DominoElement.of(li())
              .css("page")
              .appendChild(
                  dotsAnchor
                      .setTextContent("...")
                      .addClickListener(
                          evt -> moveToPage((windowIndex * windowSize) + windowSize + 1, false)));
      pagesElement.appendChild(dotsElement);
      pagesCountPageElement =
          DominoElement.of(li())
              .css("page")
              .appendChild(
                  DominoElement.of(a())
                      .setTextContent("" + pages)
                      .addClickListener(evt -> moveToPage(pages, false)));
      pagesElement.appendChild(pagesCountPageElement);
    }
    DominoElement<HTMLLIElement> recordsCountPageElement =
        DominoElement.of(li())
            .css("page")
            .appendChild(DominoElement.of(a()).setTextContent("(" + this.totalCount + ")"))
            .toggleDisplay(totalRecordVisible);
    pagesElement.appendChild(recordsCountPageElement);

    nextAnchor = DominoElement.of(a());
    nextElement =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                nextAnchor
                    .appendChild(Icons.ALL.chevron_right().clickable())
                    .addClickListener(event -> moveToPage(index + 1, false)));

    nextSetAnchor = DominoElement.of(a());
    nextSet =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                nextSetAnchor
                    .appendChild(Icons.ALL.last_page().clickable())
                    .addClickListener(
                        event -> moveToPage((windowIndex * windowSize) + windowSize + 1, false)));

    lastPageAnchor = DominoElement.of(a());
    lastPage =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                lastPageAnchor
                    .appendChild(Icons.ALL.skip_next().clickable())
                    .addClickListener(event -> moveToPage(pagesCount, false)));

    if (pages > 0) {
      moveToPage(1, silent);
    }

    if (pages <= 0) {
      nextElement.disable();
      nextSet.disable();
      lastPage.disable();
      prevElement.disable();
      prevSet.disable();
      firstPage.disable();
      if (!silent) {
        pageChangedCallBack.onPageChanged(0);
      }
    }

    pagesElement.appendChild(nextElement).appendChild(nextSet).appendChild(lastPage);

    return this;
  }

  private void scrollToWindow(int windowIndex) {
    activeWindow.values().forEach(BaseDominoElement::remove);
    activeWindow.clear();
    final DominoElement<? extends HTMLElement>[] lastPage = new DominoElement[1];
    IntStream.rangeClosed(
            (windowIndex * windowSize) + 1,
            Math.min((windowIndex * windowSize) + windowSize, pagesCount))
        .forEach(
            p -> {
              DominoElement.of(li())
                  .css("page")
                  .apply(
                      element -> {
                        element.appendChild(
                            DominoElement.of(a())
                                .setTextContent(p + "")
                                .apply(
                                    self -> {
                                      if (p > 9999) {
                                        self.addCss(Styles.ellipsis_text)
                                            .setTooltip(String.valueOf(p));
                                      }
                                    })
                                .addClickListener(evt -> moveToPage(p, false)));

                        if (activeWindow.isEmpty()) {
                          pagesElement.insertAfter(element, prevElement);
                        } else {
                          pagesElement.insertAfter(element, lastPage[0]);
                        }
                        lastPage[0] = element;
                        activeWindow.put(p, element);
                      });
            });
    this.windowIndex = windowIndex;
  }

  /** {@inheritDoc} */
  @Override
  protected void moveToPage(int page, boolean silent) {
    if (page > 0 && page <= pagesCount) {

      showPageWindow(page);

      index = page;
      if (markActivePage) {
        gotoPage(activeWindow.get(page));
      }

      if (!silent) {
        pageChangedCallBack.onPageChanged(page);
      }

      if (page == pagesCount) {
        nextElement.disable();
        nextSet.disable();
        lastPage.disable();
      } else {
        nextElement.enable();
        nextSet.enable();
        lastPage.enable();
      }

      if (page == 1) {
        prevElement.disable();
        prevSet.disable();
        firstPage.disable();
      } else {
        prevElement.enable();
        prevSet.enable();
        firstPage.enable();
      }
    }
  }

  private void showPageWindow(int page) {
    if (activeWindow.containsKey(page)) {
      return;
    }

    if (page % windowSize == 0) {
      scrollToWindow((page / windowSize) - 1);
    } else {
      scrollToWindow(page / windowSize);
    }
  }

  /** @return true if the total number of records is visible, false otherwise */
  public boolean isTotalRecordVisible() {
    return totalRecordVisible;
  }

  /**
   * @param totalRecordVisible true to show the total number of records
   * @return same instance
   */
  public ScrollingPagination setTotalRecordVisible(boolean totalRecordVisible) {
    this.totalRecordVisible = totalRecordVisible;
    return this;
  }

  /** @return the previous element */
  public DominoElement<HTMLAnchorElement> getPrevAnchor() {
    return prevAnchor;
  }

  /** @return the previous window element */
  public DominoElement<HTMLAnchorElement> getPrevSetAnchor() {
    return prevSetAnchor;
  }

  /** @return the first page element */
  public DominoElement<HTMLAnchorElement> getFirstPageAnchor() {
    return firstPageAnchor;
  }

  /** @return the dots element */
  public DominoElement<HTMLAnchorElement> getDotsAnchor() {
    return dotsAnchor;
  }

  /** @return the next element */
  public DominoElement<HTMLAnchorElement> getNextAnchor() {
    return nextAnchor;
  }

  /** @return the next window element */
  public DominoElement<HTMLAnchorElement> getNextSetAnchor() {
    return nextSetAnchor;
  }

  /** @return the last page element */
  public DominoElement<HTMLAnchorElement> getLastPageAnchor() {
    return lastPageAnchor;
  }
}
