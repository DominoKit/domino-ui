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
package org.dominokit.domino.ui.carousel;

import static org.dominokit.domino.ui.utils.Domino.img;

import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.PictureElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLPictureElement;

/**
 * A slide component used with {@link org.dominokit.domino.ui.carousel.Carousel}
 *
 * <p>The component provide the means to create an image slide with different types of image
 * elements or components
 *
 * @see BaseDominoElement
 */
public class ImgSlide extends Slide {

  private ImgSlide(HTMLElement element) {
    super(element);
  }

  /**
   * Creates an image slide from the provided image url
   *
   * @param imageSrc The string image source that will be used as the value for the img tag src
   *     attribute.
   */
  public ImgSlide(String imageSrc) {
    this(img(imageSrc).element());
  }

  /**
   * Creates an image slide from the provided image element
   *
   * @param image The {@link elemental2.dom.HTMLImageElement} element to be used for the slide
   */
  public ImgSlide(HTMLImageElement image) {
    this((HTMLElement) image);
  }

  /**
   * Creates an image slide from the provided picture element
   *
   * @param pictureElement The {@link elemental2.dom.HTMLPictureElement} element to be used for the
   *     slide.
   */
  public ImgSlide(HTMLPictureElement pictureElement) {
    this((HTMLElement) pictureElement);
  }

  /**
   * Creates an image slide from the provided image component
   *
   * @param image The {@link ImageElement} element to be used for the slide.
   */
  public ImgSlide(ImageElement image) {
    this(image.element());
  }

  /**
   * Creates an image slide from the provided picture component
   *
   * @param pictureElement The {@link PictureElement} element to be used for the slide.
   */
  public ImgSlide(PictureElement pictureElement) {
    this(pictureElement.element());
  }

  /**
   * Factory method to create an image slide from the provided image url
   *
   * @param imageSrc The string image source that will be used as the value for the img tag src
   *     attribute.
   * @return new instance
   */
  public static ImgSlide create(String imageSrc) {
    return new ImgSlide(imageSrc);
  }

  /**
   * Factory method to create an image slide from the provided image element
   *
   * @param image The {@link elemental2.dom.HTMLImageElement} element to be used for the slide
   * @return new instance
   */
  public static ImgSlide create(HTMLImageElement image) {
    return new ImgSlide(image);
  }

  /**
   * Factory method to create an image slide from the provided picture element
   *
   * @param pictureElement The {@link elemental2.dom.HTMLPictureElement} element to be used for the
   *     slide.
   * @return new instance
   */
  public static ImgSlide create(HTMLPictureElement pictureElement) {
    return new ImgSlide(pictureElement);
  }

  /**
   * Factory method to create an image slide from the provided image component
   *
   * @param image The {@link ImageElement} element to be used for the slide.
   * @return new instance
   */
  public static ImgSlide create(ImageElement image) {
    return new ImgSlide(image);
  }

  /**
   * Factory method to create an image slide from the provided picture component
   *
   * @param pictureElement The {@link PictureElement} element to be used for the slide.
   * @return new instance
   */
  public static ImgSlide create(PictureElement pictureElement) {
    return new ImgSlide(pictureElement);
  }

  /** @return The element of the image of this slide. */
  public DominoElement<HTMLElement> getImageElement() {
    return getElement();
  }
}
