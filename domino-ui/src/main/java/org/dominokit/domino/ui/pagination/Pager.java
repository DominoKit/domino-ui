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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.elements.NavElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.i18n.HasLabels;
import org.dominokit.domino.ui.i18n.PaginationLabels;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component which provides a simple navigation between a list of elements using next/previous
 * elements
 *
 * <p>For example:
 *
 * <pre>
 *     Pager.create()
 *          .onNext(() -> DomGlobal.console.info("Going to next page."))
 *          .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
 * </pre>
 *
 * @see BaseDominoElement
 * @author vegegoku
 * @version $Id: $Id
 */
public class Pager extends BaseDominoElement<HTMLElement, Pager>
    implements PaginationStyles, HasLabels<PaginationLabels> {

  private final NavElement element;
  private final PagerNavItem nextElement;
  private final PagerNavItem prevElement;
  private final SpanElement prevArrow;
  private final SpanElement nextArrow;

  private final Text nextText;
  private final Text prevText;

  private PagerChangeCallback onNext = () -> {};
  private PagerChangeCallback onPrev = () -> {};

  private boolean allowNext = true;
  private boolean allowPrev = true;

  /** Constructor for Pager. */
  public Pager() {
    EventListener goNext =
        evt -> {
          if (allowNext) {
            onNext.onChange();
          }
        };
    EventListener goPrevious =
        evt -> {
          if (allowPrev) {
            onPrev.onChange();
          }
        };
    element =
        nav()
            .addCss(dui_pager)
            .appendChild(
                ul().addCss(dui_pager_list, dui_navigator)
                    .appendChild(
                        prevElement =
                            PagerNavItem.create()
                                .withLink((parent, link) -> link.addCss(dui_navigator_nav))
                                .appendChild(prevArrow = span().textContent("←"))
                                .appendChild(prevText = text(getLabels().getPreviousLabel()))
                                .addClickListener(goPrevious)
                                .onKeyDown(keyEvents -> keyEvents.onEnter(goPrevious)))
                    .appendChild(
                        nextElement =
                            PagerNavItem.create()
                                .withLink((parent, link) -> link.addCss(dui_navigator_nav))
                                .appendChild(nextText = text(getLabels().getNextLabel()))
                                .appendChild(nextArrow = span().textContent("→"))
                                .addClickListener(goNext)
                                .onKeyDown(keyEvents -> keyEvents.onEnter(goNext))));
    init(this);
  }

  /** @return new instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.pagination.Pager} object
   */
  public static Pager create() {
    return new Pager();
  }

  /**
   * Sets the handler that will be called when next element is clicked
   *
   * @param nextCallback the {@link org.dominokit.domino.ui.pagination.Pager.PagerChangeCallback}
   * @return same instance
   */
  public Pager onNext(PagerChangeCallback nextCallback) {
    this.onNext = nextCallback;
    return this;
  }

  /**
   * Sets the handler that will be called when previous element is clicked
   *
   * @param previousCallback the {@link
   *     org.dominokit.domino.ui.pagination.Pager.PagerChangeCallback}
   * @return same instance
   */
  public Pager onPrevious(PagerChangeCallback previousCallback) {
    this.onPrev = previousCallback;
    return this;
  }

  /**
   * Disables the next element
   *
   * @return same instance
   */
  public Pager disableNext() {
    this.allowNext = false;
    nextElement.disable();
    return this;
  }

  /**
   * Disables the previous element
   *
   * @return same instance
   */
  public Pager disablePrevious() {
    this.allowPrev = false;
    prevElement.disable();
    return this;
  }

  /**
   * Enables the next element
   *
   * @return same instance
   */
  public Pager enableNext() {
    this.allowNext = true;
    nextElement.enable();
    return this;
  }

  /**
   * Enables the previous element
   *
   * @return same instance
   */
  public Pager enablePrevious() {
    this.allowPrev = true;
    prevElement.enable();
    return this;
  }

  /**
   * Sets the text of the next element
   *
   * @param text the new text
   * @return same instance
   */
  public Pager nextText(String text) {
    nextText.textContent = text;
    return this;
  }

  /**
   * Sets the text of the previous element
   *
   * @param text the new text
   * @return same instance
   */
  public Pager previousText(String text) {
    prevText.textContent = text;
    return this;
  }

  /**
   * Shows arrows next to the navigation elements
   *
   * @return same instance
   */
  public Pager showArrows() {
    prevArrow.expand();
    nextArrow.expand();
    return this;
  }

  /**
   * hides arrows next to the navigation elements
   *
   * @return same instance
   */
  public Pager hideArrows() {
    prevArrow.collapse();
    nextArrow.collapse();
    return this;
  }

  /**
   * setShowArrows.
   *
   * @param show a boolean
   * @return a {@link org.dominokit.domino.ui.pagination.Pager} object
   */
  public Pager setShowArrows(boolean show) {
    prevArrow.toggleDisplay(show);
    nextArrow.toggleDisplay(show);
    return this;
  }

  /**
   * spread.
   *
   * @param spread a boolean
   * @return a {@link org.dominokit.domino.ui.pagination.Pager} object
   */
  public Pager spread(boolean spread) {
    BooleanCssClass.of(dui_navigator_previous, spread).apply(prevElement);
    BooleanCssClass.of(dui_navigator_next, spread).apply(nextElement);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /** A handler that will be called when the navigation is changed */
  public interface PagerChangeCallback {
    void onChange();
  }
}
