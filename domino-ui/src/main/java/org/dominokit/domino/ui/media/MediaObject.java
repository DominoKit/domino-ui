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
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;
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
    implements MediaStyles {

  /*
    <div class="dui dui-media">
      <div class="dui dui-media-object"><a><img src="https://placehold.jp/64x64.png"></a></div>
      <div class="dui dui-media-body">
          <h4 class="dui dui-media-heading">Media heading</h4>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
      </div>
  </div>
     */
  private final DominoElement<HTMLDivElement> element;

  private final LazyChild<DominoElement<HTMLDivElement>> leftMedia;
  private final LazyChild<DominoElement<HTMLDivElement>> rightMedia;
  private final LazyChild<DominoElement<HTMLDivElement>> mediaBody;
  private final LazyChild<DominoElement<HTMLHeadingElement>> mediaHeader;

  public MediaObject() {
    element = DominoElement.div().addCss(dui_media);
    leftMedia = LazyChild.of(DominoElement.div().addCss(dui_media_object, dui_media_left), element);
    mediaBody = LazyChild.of(DominoElement.div().addCss(dui_media_body), element);
    rightMedia =
        LazyChild.of(DominoElement.div().addCss(dui_media_object, dui_media_right), mediaBody);
    mediaHeader = LazyChild.of(DominoElement.h4().addCss(dui_media_heading), mediaBody);
    init(this);
  }

  /** @return new instance */
  public static MediaObject create() {
    return new MediaObject();
  }

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
   * @param content A media {@link Node}
   * @return same instance
   */
  public MediaObject setLeftMedia(Node content) {
    leftMedia.get().clearElement().appendChild(content);
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
    rightMedia.get().clearElement().appendChild(content);
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

  /** @return The media element body */
  public DominoElement<HTMLDivElement> getMediaBody() {
    return mediaBody.get();
  }

  /** @return The media header element */
  public DominoElement<HTMLHeadingElement> getMediaHeader() {
    return mediaHeader.get();
  }

  /** @return The left media element */
  public DominoElement<HTMLDivElement> getLeftMedia() {
    return leftMedia.get();
  }

  /** @return The right media element */
  public DominoElement<HTMLDivElement> getRightMedia() {
    return rightMedia.get();
  }

  public MediaObject withHeader(
      ChildHandler<MediaObject, DominoElement<HTMLHeadingElement>> handler) {
    handler.apply(this, mediaHeader.get());
    return this;
  }

  public MediaObject withMediaBody(
      ChildHandler<MediaObject, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, mediaBody.get());
    return this;
  }

  public MediaObject withLeftMedia(
      ChildHandler<MediaObject, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, leftMedia.get());
    return this;
  }

  public MediaObject withRightMedia(
      ChildHandler<MediaObject, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, rightMedia.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
