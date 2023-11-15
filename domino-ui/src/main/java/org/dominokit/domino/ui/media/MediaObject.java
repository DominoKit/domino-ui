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

import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.h;

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
 * Represents a media object commonly used for displaying media content with an optional header and
 * descriptions.
 *
 * <p>It allows configuration for left and right media objects alongside a central media body.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * MediaObject media = MediaObject.create()
 *    .setHeader("Sample Header")
 *    .setLeftMedia(someElement)
 *    .setRightMedia(someOtherElement);
 * </pre>
 */
public class MediaObject extends BaseDominoElement<HTMLDivElement, MediaObject>
    implements MediaStyles {

  private final DivElement element;

  private final LazyChild<DivElement> leftMedia;
  private final LazyChild<DivElement> rightMedia;
  private final LazyChild<DivElement> mediaBody;
  private final LazyChild<HeadingElement> mediaHeader;

  /** Creates a new instance of {@link MediaObject}. */
  public MediaObject() {
    element = div().addCss(dui_media);
    leftMedia = LazyChild.of(div().addCss(dui_media_object, dui_media_left), element);
    mediaBody = LazyChild.of(div().addCss(dui_media_body), element);
    rightMedia = LazyChild.of(div().addCss(dui_media_object, dui_media_right), mediaBody);
    mediaHeader = LazyChild.of(h(4).addCss(dui_media_heading), mediaBody);
    init(this);
  }

  /**
   * Creates a new instance of {@link MediaObject}.
   *
   * @return The newly created media object.
   */
  public static MediaObject create() {
    return new MediaObject();
  }

  /**
   * Retrieves the target element where new content can be appended.
   *
   * @return The HTML element of the media body.
   */
  @Override
  public HTMLElement getAppendTarget() {
    return mediaBody.get().element();
  }

  /**
   * Sets the header text for the media object.
   *
   * @param header The header text.
   * @return The current media object instance.
   */
  public MediaObject setHeader(String header) {
    mediaHeader.get().setTextContent(header);
    return this;
  }

  /**
   * Sets the left media content using a node.
   *
   * @param content The node to be set as left media content.
   * @return The current media object instance.
   */
  public MediaObject setLeftMedia(Node content) {
    leftMedia.get().clearElement().appendChild(content);
    return this;
  }

  /**
   * Sets the left media content using an {@link IsElement}.
   *
   * @param element The element to be set as left media content.
   * @return The current media object instance.
   */
  public MediaObject setLeftMedia(IsElement<?> element) {
    return setLeftMedia(element.element());
  }

  /**
   * Sets the right media content using a node.
   *
   * @param content The node to be set as right media content.
   * @return The current media object instance.
   */
  public MediaObject setRightMedia(Node content) {
    rightMedia.get().clearElement().appendChild(content);
    return this;
  }

  /**
   * Sets the right media content using an {@link IsElement}.
   *
   * @param element The element to be set as right media content.
   * @return The current media object instance.
   */
  public MediaObject setRightMedia(IsElement<?> element) {
    return setRightMedia(element.element());
  }

  /**
   * Retrieves the media body of the media object.
   *
   * @return The div element of the media body.
   */
  public DivElement getMediaBody() {
    return mediaBody.get();
  }

  /**
   * Retrieves the header of the media object.
   *
   * @return The heading element of the media header.
   */
  public HeadingElement getMediaHeader() {
    return mediaHeader.get();
  }

  /**
   * Retrieves the left media content of the media object.
   *
   * @return The div element of the left media content.
   */
  public DivElement getLeftMedia() {
    return leftMedia.get();
  }

  /**
   * Retrieves the right media content of the media object.
   *
   * @return The div element of the right media content.
   */
  public DivElement getRightMedia() {
    return rightMedia.get();
  }

  /**
   * Configures the media header using a handler.
   *
   * @param handler A handler that accepts the current media object instance and its media header.
   * @return The current media object instance.
   */
  public MediaObject withHeader(ChildHandler<MediaObject, HeadingElement> handler) {
    handler.apply(this, mediaHeader.get());
    return this;
  }

  /**
   * Configures the media body using a handler.
   *
   * @param handler A handler that accepts the current media object instance and its media body.
   * @return The current media object instance.
   */
  public MediaObject withMediaBody(ChildHandler<MediaObject, DivElement> handler) {
    handler.apply(this, mediaBody.get());
    return this;
  }

  /**
   * Configures the left media content using a handler.
   *
   * @param handler A handler that accepts the current media object instance and its left media
   *     content.
   * @return The current media object instance.
   */
  public MediaObject withLeftMedia(ChildHandler<MediaObject, DivElement> handler) {
    handler.apply(this, leftMedia.get());
    return this;
  }

  /**
   * Configures the right media content using a handler.
   *
   * @param handler A handler that accepts the current media object instance and its right media
   *     content.
   * @return The current media object instance.
   */
  public MediaObject withRightMedia(ChildHandler<MediaObject, DivElement> handler) {
    handler.apply(this, rightMedia.get());
    return this;
  }

  /**
   * Retrieves the root element of the media object.
   *
   * @return The root {@link HTMLDivElement} of this media object.
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
