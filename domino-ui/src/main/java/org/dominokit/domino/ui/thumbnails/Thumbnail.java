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
package org.dominokit.domino.ui.thumbnails;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLPictureElement;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.FooterContent;
import org.dominokit.domino.ui.utils.HeaderContent;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A component that represents a thumbnail, often used to display condensed content. It provides a
 * way to display a small representation of an extended card or media object. It's flexible enough
 * to be used in both image and non-image content.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * Thumbnail thumbnail = Thumbnail.create()
 *    .appendChild(someImageElement)
 *    .withTitle(titleHandler)
 *    .withBody(bodyHandler);
 * </pre>
 *
 * @see BaseDominoElement
 * @see ThumbnailStyles
 * @see BaseDominoElement
 */
public class Thumbnail extends BaseDominoElement<HTMLDivElement, Thumbnail>
    implements ThumbnailStyles {

  // Main thumbnail component elements
  private final DivElement element;
  private final DivElement head;
  private final LazyChild<DivElement> title;
  private final DivElement body;

  private final LazyChild<DivElement> tail;
  private final LazyChild<DivElement> footer;

  // For swapping between different thumbnail directions (like horizontal vs vertical)
  private SwapCssClass directionCss = SwapCssClass.of();

  /** Initializes the Thumbnail component with default structure and styles. */
  public Thumbnail() {
    this.element =
        div()
            .addCss(dui_thumbnail)
            .appendChild(
                head =
                    div()
                        .addCss(dui_thumbnail_head)
                        .appendChild(body = div().addCss(dui_thumbnail_body)));
    title = LazyChild.of(div().addCss(dui_thumbnail_title), head);
    tail = LazyChild.of(div().addCss(dui_thumbnail_tail), element);
    footer = LazyChild.of(div().addCss(dui_thumbnail_footer), tail);

    init(this);
  }

  /**
   * Factory method to create a new Thumbnail instance.
   *
   * @return a new Thumbnail instance.
   */
  public static Thumbnail create() {
    return new Thumbnail();
  }

  /**
   * Returns the HTMLElement where new child elements should be appended.
   *
   * @return the main body HTMLElement of the thumbnail.
   */
  @Override
  public HTMLElement getAppendTarget() {
    return body.element();
  }

  /**
   * Sets the visual direction of the thumbnail.
   *
   * @param direction the direction the thumbnail should take. This affects its visual appearance.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail setDirection(ThumbnailDirection direction) {
    addCss(directionCss.replaceWith(direction));
    return this;
  }

  /**
   * Appends an image to the thumbnail and applies the necessary styling.
   *
   * @param img the image element to be appended.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail appendChild(HTMLImageElement img) {
    elementOf(img).addCss(dui_thumbnail_img);
    return super.appendChild(img);
  }

  /**
   * Appends a child element to the thumbnail. If the child is an image or picture, it applies the
   * necessary styling.
   *
   * @param element the element to be appended.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail appendChild(IsElement<?> element) {
    if (element.element() instanceof HTMLImageElement
        || element.element() instanceof HTMLPictureElement) {
      elementOf(element).addCss(dui_thumbnail_img);
    }
    return super.appendChild(element);
  }

  /**
   * Appends a child node to the thumbnail. If the node is an image or picture, it applies the
   * necessary styling.
   *
   * @param node the node to be appended.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail appendChild(Node node) {
    if (node instanceof HTMLImageElement || node instanceof HTMLPictureElement) {
      elementOf(Js.<HTMLElement>uncheckedCast(node)).addCss(dui_thumbnail_img);
    }
    return super.appendChild(node);
  }

  /**
   * Returns the main div element representing the thumbnail.
   *
   * @return the main HTMLDivElement of the thumbnail.
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * Applies the provided handler to the header of the thumbnail.
   *
   * @param handler the handler that will be applied to the thumbnail header.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withHeader(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, head);
    return this;
  }

  /**
   * Applies the provided handler to the title of the thumbnail.
   *
   * @param handler the handler that will be applied to the thumbnail title.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withTitle(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, title.get());
    return this;
  }

  /**
   * Ensures the title element is initialized.
   *
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withTitle() {
    title.get();
    return this;
  }

  /**
   * Applies the provided handler to the tail of the thumbnail.
   *
   * @param handler the handler that will be applied to the thumbnail tail.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withTail(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, tail.get());
    return this;
  }

  /**
   * Ensures the tail element is initialized.
   *
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withTail() {
    tail.get();
    return this;
  }

  /**
   * Appends the provided footer content to the footer of the thumbnail.
   *
   * @param footerContent the footer content to be appended.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail appendChild(FooterContent<?> footerContent) {
    footer.get().appendChild(footerContent);
    return this;
  }

  /**
   * Appends the provided header content to the title of the thumbnail.
   *
   * @param headerContent the header content to be appended.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail appendChild(HeaderContent<?> headerContent) {
    title.get().appendChild(headerContent);
    return this;
  }

  /**
   * Applies the provided handler to the footer of the thumbnail.
   *
   * @param handler the handler that will be applied to the thumbnail footer.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withFooter(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * Ensures the footer element is initialized.
   *
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withFooter() {
    footer.get();
    return this;
  }

  /**
   * Applies the provided handler to the body of the thumbnail.
   *
   * @param handler the handler that will be applied to the thumbnail body.
   * @return the current Thumbnail instance for method chaining.
   */
  public Thumbnail withBody(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * Returns the header div element of the thumbnail.
   *
   * @return the header div element.
   */
  public DivElement getHeader() {
    return head;
  }

  /**
   * Returns the title div element of the thumbnail.
   *
   * @return the title div element.
   */
  public DivElement getTitle() {
    return title.get();
  }

  /**
   * Returns the body div element of the thumbnail.
   *
   * @return the body div element.
   */
  public DivElement getBody() {
    return body;
  }

  /**
   * Returns the tail div element of the thumbnail.
   *
   * @return the tail div element.
   */
  public DivElement getTail() {
    return tail.get();
  }

  /**
   * Returns the footer div element of the thumbnail.
   *
   * @return the footer div element.
   */
  public DivElement getFooter() {
    return footer.get();
  }
}
