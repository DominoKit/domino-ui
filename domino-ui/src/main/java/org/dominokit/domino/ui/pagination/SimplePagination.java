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
import java.util.stream.IntStream;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.DominoElement;

/** A simple pagination implementation */
public class SimplePagination extends BasePagination<SimplePagination> {

  private DominoElement<HTMLAnchorElement> prevAnchor;
  private DominoElement<HTMLAnchorElement> nextAnchor;

  /** @return new instance */
  public static SimplePagination create() {
    return new SimplePagination();
  }

  /**
   * @param pages the number of pages
   * @return new instance
   */
  public static SimplePagination create(int pages) {
    return new SimplePagination(pages);
  }

  /**
   * @param pages the number of pages
   * @param pageSize the page size
   * @return new instance
   */
  public static SimplePagination create(int pages, int pageSize) {
    return new SimplePagination(pages, pageSize);
  }

  public SimplePagination() {
    this(0);
  }

  public SimplePagination(int pages) {
    this(pages, 10);
  }

  public SimplePagination(int pages, int pageSize) {
    this.pagesCount = pages;
    this.pageSize = pageSize;
    init(this);
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
    allPages.clear();
    pagesElement.clearElement();
    prevAnchor = DominoElement.of(a());
    prevElement =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                prevAnchor
                    .appendChild(Icons.ALL.chevron_left_mdi().clickable())
                    .addClickListener(event -> moveToPage(index - 1, false)));

    pagesElement.appendChild(prevElement);
    if (pages > 0) {
      IntStream.rangeClosed(1, pages)
          .forEach(
              p ->
                  DominoElement.of(li())
                      .css("page")
                      .apply(
                          element -> {
                            allPages.add(element);
                            pagesElement.appendChild(
                                element.appendChild(
                                    DominoElement.of(a())
                                        .setTextContent(p + "")
                                        .addClickListener(evt -> moveToPage(p, false))));
                          }));
    }

    nextAnchor = DominoElement.of(a());
    nextElement =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(
                nextAnchor
                    .appendChild(Icons.ALL.chevron_right_mdi().clickable())
                    .addClickListener(event -> moveToPage(index + 1, false)));

    if (pages > 0) {
      moveToPage(1, silent);
    }

    if (pages <= 0) {
      nextElement.disable();
      prevElement.disable();
      if (!silent) {
        pageChangedCallBack.onPageChanged(0);
      }
    }

    pagesElement.appendChild(nextElement);

    return this;
  }

  /** {@inheritDoc} */
  @Override
  protected void moveToPage(int page, boolean silent) {
    if (page > 0 && page <= pagesCount) {
      index = page;
      if (markActivePage) {
        gotoPage(allPages.get(page - 1));
      }

      if (!silent) {
        pageChangedCallBack.onPageChanged(page);
      }

      if (page == pagesCount) nextElement.disable();
      else nextElement.enable();

      if (page == 1) prevElement.disable();
      else prevElement.enable();
    }
  }

  /** @return The previous element */
  public DominoElement<HTMLAnchorElement> getPrevAnchor() {
    return prevAnchor;
  }

  /** @return The next element */
  public DominoElement<HTMLAnchorElement> getNextAnchor() {
    return nextAnchor;
  }
}
