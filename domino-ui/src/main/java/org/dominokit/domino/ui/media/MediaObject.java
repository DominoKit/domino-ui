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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A component to display media such as images, video and audio
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link
 * org.dominokit.domino.ui.media.MediaStyles}
 *
 * @see BaseDominoElement
 * @author vegegoku
 * @version $Id: $Id
 */
public class MediaObject extends BaseDominoElement<HTMLDivElement, MediaObject>
    implements MediaStyles {

  private final DivElement element;

  private final LazyChild<DivElement> leftMedia;
  private final LazyChild<DivElement> rightMedia;
  private final LazyChild<DivElement> mediaBody;
  private final LazyChild<HeadingElement> mediaHeader;

  /** Constructor for MediaObject. */
  public MediaObject() {
    element = div().addCss(dui_media);
    leftMedia = LazyChild.of(div().addCss(dui_media_object, dui_media_left), element);
    mediaBody = LazyChild.of(div().addCss(dui_media_body), element);
    rightMedia = LazyChild.of(div().addCss(dui_media_object, dui_media_right), mediaBody);
    mediaHeader = LazyChild.of(h(4).addCss(dui_media_heading), mediaBody);
    init(this);
  }

  /** @return new instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.media.MediaObject} object
   */
  public static MediaObject create() {
    return new MediaObject();
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLElement getAppendTarget() {
    return mediaBody.get().element();
  }

  /**
   * Sets the header title of the media object
   *
   * @param header the header text
   * @return same instance
   */
  public MediaObject setHeader(String header) {
    mediaHeader.get().setTextContent(header);
    return this;
  }

  /**
   * Sets the media node at the left of this component
   *
   * @param content A media {@link elemental2.dom.Node}
   * @return same instance
   */
  public MediaObject setLeftMedia(Node content) {
    leftMedia.get().clearElement().appendChild(content);
    return this;
  }

  /**
   * Same as {@link org.dominokit.domino.ui.media.MediaObject#setLeftMedia(Node)} but uses {@link
   * org.dominokit.domino.ui.IsElement} wrapper
   *
   * @param element A media {@link org.dominokit.domino.ui.IsElement}
   * @return same instance
   */
  public MediaObject setLeftMedia(IsElement<?> element) {
    return setLeftMedia(element.element());
  }

  /**
   * Sets the media node at the right of this component
   *
   * @param content A media {@link elemental2.dom.Node}
   * @return same instance
   */
  public MediaObject setRightMedia(Node content) {
    rightMedia.get().clearElement().appendChild(content);
    return this;
  }

  /**
   * Same as {@link org.dominokit.domino.ui.media.MediaObject#setRightMedia(Node)} but uses {@link
   * org.dominokit.domino.ui.IsElement} wrapper
   *
   * @param element A media {@link org.dominokit.domino.ui.IsElement}
   * @return same instance
   */
  public MediaObject setRightMedia(IsElement<?> element) {
    return setRightMedia(element.element());
  }

  /** @return The media element body */
  /**
   * Getter for the field <code>mediaBody</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getMediaBody() {
    return mediaBody.get();
  }

  /** @return The media header element */
  /**
   * Getter for the field <code>mediaHeader</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HeadingElement} object
   */
  public HeadingElement getMediaHeader() {
    return mediaHeader.get();
  }

  /** @return The left media element */
  /**
   * Getter for the field <code>leftMedia</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getLeftMedia() {
    return leftMedia.get();
  }

  /** @return The right media element */
  /**
   * Getter for the field <code>rightMedia</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getRightMedia() {
    return rightMedia.get();
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.media.MediaObject} object
   */
  public MediaObject withHeader(ChildHandler<MediaObject, HeadingElement> handler) {
    handler.apply(this, mediaHeader.get());
    return this;
  }

  /**
   * withMediaBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.media.MediaObject} object
   */
  public MediaObject withMediaBody(ChildHandler<MediaObject, DivElement> handler) {
    handler.apply(this, mediaBody.get());
    return this;
  }

  /**
   * withLeftMedia.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.media.MediaObject} object
   */
  public MediaObject withLeftMedia(ChildHandler<MediaObject, DivElement> handler) {
    handler.apply(this, leftMedia.get());
    return this;
  }

  /**
   * withRightMedia.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.media.MediaObject} object
   */
  public MediaObject withRightMedia(ChildHandler<MediaObject, DivElement> handler) {
    handler.apply(this, rightMedia.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
