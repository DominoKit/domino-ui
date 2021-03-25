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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.thumbnails.ThumbnailStyles.CAPTION;
import static org.dominokit.domino.ui.thumbnails.ThumbnailStyles.THUMBNAIL;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.elemento.IsElement;

/**
 * A component which provides a showcase for images and any other elements with extra caption
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link ThumbnailStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     Thumbnail.create()
 *         .setContent(a().add(img(GWT.getModuleBaseURL() + "/images/image-gallery/1.jpg").css(Styles.img_responsive)))
 *         .appendCaptionChild(h(3).textContent("Thumbnail label"))
 *         .appendCaptionChild(Paragraph.create(SAMPLE_TEXT))
 *         .appendCaptionChild(Button.createPrimary("BUTTON"))
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Thumbnail extends BaseDominoElement<HTMLDivElement, Thumbnail> {

  private final HTMLDivElement element = div().css(THUMBNAIL).element();
  private final HTMLDivElement contentElement = div().element();
  private final HTMLDivElement captionElement = div().css(CAPTION).element();

  public Thumbnail() {
    element.appendChild(contentElement);
    init(this);
  }

  /** @return new instnace */
  public static Thumbnail create() {
    return new Thumbnail();
  }

  /** {@inheritDoc} */
  @Override
  public Thumbnail setContent(Node content) {
    ElementUtil.clear(contentElement);
    contentElement.appendChild(content);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Thumbnail setContent(IsElement<?> content) {
    return setContent(content.element());
  }

  /** @deprecated use {@link #appendCaptionChild(Node)} */
  @Deprecated
  public Thumbnail appendCaptionContent(Node content) {
    return appendCaptionChild(content);
  }

  /**
   * Adds a caption element
   *
   * @param content the {@link Node} caption
   * @return same instance
   */
  public Thumbnail appendCaptionChild(Node content) {
    if (isNull(captionElement.parentNode)) element.appendChild(captionElement);
    captionElement.appendChild(content);
    return this;
  }

  /**
   * Adds a caption element
   *
   * @param content the {@link IsElement} caption
   * @return same instance
   */
  public Thumbnail appendCaptionChild(IsElement<?> content) {
    return appendCaptionChild(content.element());
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element;
  }

  /** @return the content element */
  public DominoElement<HTMLDivElement> getContentElement() {
    return DominoElement.of(contentElement);
  }

  /** @return the caption container */
  public DominoElement<HTMLDivElement> getCaptionElement() {
    return DominoElement.of(captionElement);
  }
}
