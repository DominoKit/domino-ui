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

import static org.dominokit.domino.ui.utils.Domino.*;

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
 * The `Pager` class provides pagination controls for navigating between pages. It includes options
 * for going to the next and previous pages, as well as customizing the appearance and behavior of
 * the pager.
 *
 * <p>Usage example:
 *
 * <pre>
 * Pager pager = Pager.create()
 *     .onNext(() -> {
 *         // Handle next page action
 *     })
 *     .onPrevious(() -> {
 *         // Handle previous page action
 *     })
 *     .disableNext() // Disable the next page button
 *     .showArrows(); // Show arrow icons for navigation
 * </pre>
 *
 * @see BaseDominoElement
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

  /**
   * Creates a new instance of `Pager`.
   *
   * @return A new `Pager` instance.
   */
  public static Pager create() {
    return new Pager();
  }

  /**
   * Sets a callback to be executed when the "Next" button is clicked.
   *
   * @param nextCallback The callback to execute.
   * @return This `Pager` instance for method chaining.
   */
  public Pager onNext(PagerChangeCallback nextCallback) {
    this.onNext = nextCallback;
    return this;
  }

  /**
   * Sets a callback to be executed when the "Previous" button is clicked.
   *
   * @param previousCallback The callback to execute.
   * @return This `Pager` instance for method chaining.
   */
  public Pager onPrevious(PagerChangeCallback previousCallback) {
    this.onPrev = previousCallback;
    return this;
  }

  /**
   * Disables the "Next" button, preventing navigation to the next page.
   *
   * @return This `Pager` instance for method chaining.
   */
  public Pager disableNext() {
    this.allowNext = false;
    nextElement.disable();
    return this;
  }

  /**
   * Disables the "Previous" button, preventing navigation to the previous page.
   *
   * @return This `Pager` instance for method chaining.
   */
  public Pager disablePrevious() {
    this.allowPrev = false;
    prevElement.disable();
    return this;
  }

  /**
   * Enables the "Next" button, allowing navigation to the next page.
   *
   * @return This `Pager` instance for method chaining.
   */
  public Pager enableNext() {
    this.allowNext = true;
    nextElement.enable();
    return this;
  }

  /**
   * Enables the "Previous" button, allowing navigation to the previous page.
   *
   * @return This `Pager` instance for method chaining.
   */
  public Pager enablePrevious() {
    this.allowPrev = true;
    prevElement.enable();
    return this;
  }

  /**
   * Sets the text displayed on the "Next" button.
   *
   * @param text The text to display.
   * @return This `Pager` instance for method chaining.
   */
  public Pager nextText(String text) {
    nextText.textContent = text;
    return this;
  }

  /**
   * Sets the text displayed on the "Previous" button.
   *
   * @param text The text to display.
   * @return This `Pager` instance for method chaining.
   */
  public Pager previousText(String text) {
    prevText.textContent = text;
    return this;
  }

  /**
   * Shows arrow icons for navigation on the "Next" and "Previous" buttons.
   *
   * @return This `Pager` instance for method chaining.
   */
  public Pager showArrows() {
    prevArrow.expand();
    nextArrow.expand();
    return this;
  }

  /**
   * Hides arrow icons for navigation on the "Next" and "Previous" buttons.
   *
   * @return This `Pager` instance for method chaining.
   */
  public Pager hideArrows() {
    prevArrow.collapse();
    nextArrow.collapse();
    return this;
  }

  /**
   * Sets whether to show or hide arrow icons for navigation on the "Next" and "Previous" buttons.
   *
   * @param show `true` to show the arrows, `false` to hide them.
   * @return This `Pager` instance for method chaining.
   */
  public Pager setShowArrows(boolean show) {
    prevArrow.toggleDisplay(show);
    nextArrow.toggleDisplay(show);
    return this;
  }

  /**
   * Spreads the "Previous" and "Next" buttons apart if `spread` is `true`, or brings them closer
   * together if `spread` is `false`.
   *
   * @param spread `true` to spread the buttons apart, `false` to bring them closer together.
   * @return This `Pager` instance for method chaining.
   */
  public Pager spread(boolean spread) {
    BooleanCssClass.of(dui_navigator_previous, spread).apply(prevElement);
    BooleanCssClass.of(dui_navigator_next, spread).apply(nextElement);
    return this;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Retrieves the underlying HTML element associated with this Pager.
   * @return The HTML element representing this Pager.
   */
  @Override
  public HTMLElement element() {
    return element.element();
  }

  /** Callback interface for pager change events. */
  public interface PagerChangeCallback {
    /** Called when a pager change event occurs. */
    void onChange();
  }
}
