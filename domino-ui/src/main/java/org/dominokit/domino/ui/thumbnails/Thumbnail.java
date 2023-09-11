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
 * A component which provides a showcase for images and any other elements with extra caption
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.thumbnails.ThumbnailStyles}
 *
 * @see BaseDominoElement
 */
public class Thumbnail extends BaseDominoElement<HTMLDivElement, Thumbnail>
    implements ThumbnailStyles {

  private final DivElement element;
  private final DivElement head;
  private final LazyChild<DivElement> title;
  private final DivElement body;

  private final LazyChild<DivElement> tail;
  private final LazyChild<DivElement> footer;

  private SwapCssClass directionCss = SwapCssClass.of();

  /** Constructor for Thumbnail. */
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

  /** @return new instnace */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public static Thumbnail create() {
    return new Thumbnail();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getAppendTarget() {
    return body.element();
  }

  /**
   * setDirection.
   *
   * @param direction a {@link org.dominokit.domino.ui.thumbnails.ThumbnailDirection} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail setDirection(ThumbnailDirection direction) {
    addCss(directionCss.replaceWith(direction));
    return this;
  }

  /**
   * appendChild.
   *
   * @param img a {@link elemental2.dom.HTMLImageElement} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail appendChild(HTMLImageElement img) {
    elements.elementOf(img).addCss(dui_thumbnail_img);
    return super.appendChild(img);
  }

  /** {@inheritDoc} */
  public Thumbnail appendChild(IsElement<?> element) {
    if (element.element() instanceof HTMLImageElement
        || element.element() instanceof HTMLPictureElement) {
      elements.elementOf(element).addCss(dui_thumbnail_img);
    }
    return super.appendChild(element);
  }

  /** {@inheritDoc} */
  public Thumbnail appendChild(Node node) {
    if (node instanceof HTMLImageElement || node instanceof HTMLPictureElement) {
      elements.elementOf(Js.<HTMLElement>uncheckedCast(node)).addCss(dui_thumbnail_img);
    }
    return super.appendChild(node);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withHeader(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, head);
    return this;
  }

  /**
   * withTitle.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withTitle(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, title.get());
    return this;
  }

  /**
   * withTitle.
   *
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withTitle() {
    title.get();
    return this;
  }

  /**
   * withTail.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withTail(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, tail.get());
    return this;
  }

  /**
   * withTail.
   *
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withTail() {
    tail.get();
    return this;
  }

  /**
   * appendChild.
   *
   * @param footerContent a {@link org.dominokit.domino.ui.utils.FooterContent} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail appendChild(FooterContent<?> footerContent) {
    footer.get().appendChild(footerContent);
    return this;
  }

  /**
   * appendChild.
   *
   * @param headerContent a {@link org.dominokit.domino.ui.utils.HeaderContent} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail appendChild(HeaderContent<?> headerContent) {
    title.get().appendChild(headerContent);
    return this;
  }

  /**
   * withFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withFooter(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * withFooter.
   *
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withFooter() {
    footer.get();
    return this;
  }

  /**
   * withBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.thumbnails.Thumbnail} object
   */
  public Thumbnail withBody(ChildHandler<Thumbnail, DivElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * getHeader.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getHeader() {
    return head;
  }

  /**
   * Getter for the field <code>title</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getTitle() {
    return title.get();
  }

  /**
   * Getter for the field <code>body</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getBody() {
    return body;
  }

  /**
   * Getter for the field <code>tail</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getTail() {
    return tail.get();
  }

  /**
   * Getter for the field <code>footer</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getFooter() {
    return footer.get();
  }
}
