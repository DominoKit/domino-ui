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

import elemental2.dom.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.utils.DominoElement;

/** An advanced pagination implementation */
public class AdvancedPagination extends BasePagination<AdvancedPagination> {

  private DominoElement<HTMLLIElement> firstPage;
  private DominoElement<HTMLLIElement> lastPage;

  private DominoElement<HTMLAnchorElement> prevAnchor;
  private DominoElement<HTMLAnchorElement> firstPageAnchor;
  private DominoElement<HTMLAnchorElement> nextAnchor;
  private DominoElement<HTMLAnchorElement> lastPageAnchor;
  private Select<Integer> pagesSelect;

  private Function<Integer, String> pagesCountTextHandler =
      pagesCount -> " of " + pagesCount + " Pages";

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
    init(this);
    updatePages(pages, pageSize);
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

    prevAnchor = DominoElement.of(a());
    prevElement =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(prevAnchor.appendChild(Icons.ALL.chevron_left_mdi().clickable()));

    addListenerToElement(prevAnchor, event -> moveToPage(index - 1, false));

    firstPageAnchor = DominoElement.of(a());
    firstPage =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(firstPageAnchor.appendChild(Icons.ALL.skip_previous_mdi().clickable()));

    addListenerToElement(firstPageAnchor, event -> moveToPage(1, false));

    pagesElement.clearElement().appendChild(firstPage).appendChild(prevElement);

    pagesSelect =
        Select.<Integer>create()
            .styler(style -> style.setMarginBottom("0px"))
            .addSelectionHandler(option -> moveToPage(option.getValue(), false));

    if (pages > 0) {
      IntStream.rangeClosed(1, pages)
          .forEach(
              p -> {
                pagesSelect.appendChild(
                    SelectOption.create(p, p + "")
                        .apply(element -> allPages.add(DominoElement.of(element.element()))));
              });
    }

    pagesElement.appendChild(
        DominoElement.of(li())
            .appendChild(a().style("margin-left: 10px; margin-right: 10px;").add(pagesSelect)));
    pagesElement.appendChild(
        DominoElement.of(li())
            .appendChild(
                DominoElement.of(a())
                    .css("adv-page-count")
                    .textContent(pagesCountTextHandler.apply(pages))));

    nextAnchor = DominoElement.of(a());
    nextElement =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(nextAnchor.appendChild(Icons.ALL.chevron_right_mdi().clickable()));

    addListenerToElement(nextAnchor, event -> moveToPage(index + 1, false));

    lastPageAnchor = DominoElement.of(a());
    lastPage =
        DominoElement.of(li())
            .css("page-nav")
            .appendChild(lastPageAnchor.appendChild(Icons.ALL.skip_next_mdi().clickable()));

    addListenerToElement(
        lastPageAnchor,
        event -> {
          DomGlobal.console.info("going to last page : " + allPages.size());
          moveToPage(allPages.size(), false);
        });

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

    pagesElement.appendChild(nextElement).appendChild(lastPage);
    return this;
  }

  private void addListenerToElement(
      DominoElement<? extends HTMLElement> element, EventListener listener) {
    element.addClickListener(listener);
    KeyboardEvents.listenOnKeyDown(element).onEnter(listener);
  }

  /** {@inheritDoc} */
  @Override
  protected void moveToPage(int page, boolean silent) {
    if (page > 0 && page <= pagesCount) {

      index = page;

      if (!silent) {
        pageChangedCallBack.onPageChanged(page);
      }

      if (page == pagesCount) {
        nextElement.disable();
        lastPage.disable();

        nextAnchor.removeAttribute("tabindex");
        lastPageAnchor.removeAttribute("tabindex");
      } else {
        nextElement.enable();
        lastPage.enable();

        nextAnchor.setAttribute("tabindex", "0");
        lastPageAnchor.setAttribute("tabindex", "0");
      }

      if (page == 1) {
        prevElement.disable();
        firstPage.disable();

        prevAnchor.removeAttribute("tabindex");
        firstPageAnchor.removeAttribute("tabindex");
      } else {
        prevElement.enable();
        firstPage.enable();

        prevAnchor.setAttribute("tabindex", "0");
        firstPageAnchor.setAttribute("tabindex", "0");
      }

      pagesSelect.selectAt(page - 1, true);
    }
  }

  /** @return the previous element */
  public DominoElement<HTMLAnchorElement> getPrevAnchor() {
    return prevAnchor;
  }

  /** @return the first page element */
  public DominoElement<HTMLAnchorElement> getFirstPageAnchor() {
    return firstPageAnchor;
  }

  /** @return the next element */
  public DominoElement<HTMLAnchorElement> getNextAnchor() {
    return nextAnchor;
  }

  /** @return the last page element */
  public DominoElement<HTMLAnchorElement> getLastPageAnchor() {
    return lastPageAnchor;
  }

  /**
   * Sets the text of total number of pages
   *
   * @param pagesCountTextHandler a {@link Function} that returns the text based on the current page
   */
  public void setPagesCountTextHandler(Function<Integer, String> pagesCountTextHandler) {
    this.pagesCountTextHandler = pagesCountTextHandler;
  }
}
