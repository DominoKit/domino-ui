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
package org.dominokit.domino.ui.media;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * A component to display media such as images, video and audio
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link MediaStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     MediaObject.create()
 *                .setHeader("Media heading")
 *                .setLeftMedia(a().add(
 *                                  img("http://placehold.it/64x64")
 *                                      .attr("width", "64")
 *                                      .attr("height", "64")
 *                             )
 *                )
 *                .appendChild(TextNode.of(SAMPLE_TEXT))
 * </pre>
 *
 * @see BaseDominoElement
 */
public class MediaObject extends BaseDominoElement<HTMLDivElement, MediaObject>
    implements IsElement<HTMLDivElement> {

  private final HTMLHeadingElement mediaHeader =
      DominoElement.of(h(4)).css(MediaStyles.MEDIA_HEADING).element();

  private final HTMLDivElement mediaBody =
      DominoElement.of(div()).css(MediaStyles.MEDIA_BODY).add(mediaHeader).element();

  private final HTMLDivElement element =
      DominoElement.of(div()).css(MediaStyles.MEDIA).add(mediaBody).element();

  private DominoElement<HTMLDivElement> leftMedia;
  private DominoElement<HTMLDivElement> rightMedia;

  private MediaAlign leftAlign = MediaAlign.TOP;
  private MediaAlign rightAlign = MediaAlign.TOP;

  public MediaObject() {
    init(this);
  }

  /** @return new instance */
  public static MediaObject create() {
    return new MediaObject();
  }

  /**
   * Sets the header title of the media object
   *
   * @param header the header text
   * @return same instance
   */
  public MediaObject setHeader(String header) {
    mediaHeader.textContent = header;
    return this;
  }

  /**
   * Sets the media node at the left of this component
   *
   * @param content A media {@link Node}
   * @return same instance
   */
  public MediaObject setLeftMedia(Node content) {
    if (isNull(leftMedia)) {
      leftMedia = DominoElement.of(div()).css(MediaStyles.MEDIA_LEFT);
      insertBefore(leftMedia, mediaBody);
    }

    leftMedia.clearElement();
    leftMedia.appendChild(content);
    return this;
  }

  /**
   * Same as {@link MediaObject#setLeftMedia(Node)} but uses {@link IsElement} wrapper
   *
   * @param element A media {@link IsElement}
   * @return same instance
   */
  public MediaObject setLeftMedia(IsElement<?> element) {
    return setLeftMedia(element.element());
  }

  /**
   * Sets the media node at the right of this component
   *
   * @param content A media {@link Node}
   * @return same instance
   */
  public MediaObject setRightMedia(Node content) {
    if (isNull(rightMedia)) {
      rightMedia = DominoElement.of(div()).css(MediaStyles.MEDIA_RIGHT).css(Styles.pull_right);
      appendChild(rightMedia);
    }

    rightMedia.clearElement();
    rightMedia.appendChild(content);
    return this;
  }

  /**
   * Same as {@link MediaObject#setRightMedia(Node)} but uses {@link IsElement} wrapper
   *
   * @param element A media {@link IsElement}
   * @return same instance
   */
  public MediaObject setRightMedia(IsElement<?> element) {
    return setRightMedia(element.element());
  }

  /** {@inheritDoc} */
  @Override
  public MediaObject appendChild(Node content) {
    mediaBody.appendChild(content);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public MediaObject appendChild(IsElement<?> content) {
    return appendChild(content.element());
  }

  /**
   * Sets the alignment of the left media element
   *
   * @param align the {@link MediaAlign}
   * @return same instance
   */
  public MediaObject alignLeftMedia(MediaAlign align) {
    if (nonNull(leftMedia)) {
      leftMedia.removeCss(leftAlign.style);
      leftMedia.addCss(align.style);
      this.leftAlign = align;
    }
    return this;
  }

  /**
   * Sets the alignment of the right media element
   *
   * @param align the {@link MediaAlign}
   * @return same instance
   */
  public MediaObject alignRightMedia(MediaAlign align) {
    if (nonNull(rightMedia)) {
      rightMedia.removeCss(rightAlign.style);
      rightMedia.addCss(align.style);
      this.rightAlign = align;
    }
    return this;
  }

  /** @return The media element body */
  public DominoElement<HTMLDivElement> getMediaBody() {
    return DominoElement.of(mediaBody);
  }

  /** @return The media header element */
  public DominoElement<HTMLHeadingElement> getMediaHeader() {
    return DominoElement.of(mediaHeader);
  }

  /** @return The left media element */
  public DominoElement<HTMLDivElement> getLeftMedia() {
    return leftMedia;
  }

  /** @return The right media element */
  public DominoElement<HTMLDivElement> getRightMedia() {
    return rightMedia;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element;
  }

  /** An enum representing the alignment of the media elements */
  public enum MediaAlign {
    MIDDLE(MediaStyles.MEDIA_MIDDLE),
    BOTTOM(MediaStyles.MEDIA_BOTTOM),
    TOP(MediaStyles.MEDIA_TOP);

    private final String style;

    MediaAlign(String style) {
      this.style = style;
    }
  }
}
