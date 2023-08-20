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

import static org.dominokit.domino.ui.carousel.CarouselStyles.slide;
import static org.dominokit.domino.ui.carousel.CarouselStyles.slide_caption;
import static org.dominokit.domino.ui.carousel.CarouselStyles.slide_indicator;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLImageElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLPictureElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeadingElement;
import org.dominokit.domino.ui.elements.ImageElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.elements.ParagraphElement;
import org.dominokit.domino.ui.elements.PictureElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A component for an element for {@link org.dominokit.domino.ui.carousel.Carousel}
 *
 * <p>Images can be added to the component with the ability to add label and description
 *
 * @see BaseDominoElement
 * @see Carousel
 */
public class Slide extends BaseDominoElement<HTMLDivElement, Slide> {

  private final LIElement indicatorElement;
  private final LazyChild<HeadingElement> slideLabelElement;
  private final LazyChild<ParagraphElement> slideDescriptionElement;
  private final LazyChild<DivElement> captionElement;

  private final DivElement slideElement;

  private final DominoElement<HTMLElement> imageElement;

  private Slide(HTMLElement element) {
    slideElement = div().addCss(slide).appendChild(imageElement = elementOf(element));

    indicatorElement = li().addCss(slide_indicator);

    captionElement = LazyChild.of(div().addCss(slide_caption), slideElement);
    slideLabelElement = LazyChild.of(h(3), captionElement);
    slideDescriptionElement = LazyChild.of(p(), captionElement);
    init(this);
  }

  /**
   * Constructor for Slide.
   *
   * @param imageSrc a {@link java.lang.String} object
   */
  public Slide(String imageSrc) {
    this(elements.img(imageSrc).element());
  }

  /**
   * Constructor for Slide.
   *
   * @param image a {@link elemental2.dom.HTMLImageElement} object
   */
  public Slide(HTMLImageElement image) {
    this((HTMLElement) image);
  }

  /**
   * Constructor for Slide.
   *
   * @param pictureElement a {@link elemental2.dom.HTMLPictureElement} object
   */
  public Slide(HTMLPictureElement pictureElement) {
    this((HTMLElement) pictureElement);
  }

  /**
   * Constructor for Slide.
   *
   * @param image a {@link org.dominokit.domino.ui.elements.ImageElement} object
   */
  public Slide(ImageElement image) {
    this(image.element());
  }

  /**
   * Constructor for Slide.
   *
   * @param pictureElement a {@link org.dominokit.domino.ui.elements.PictureElement} object
   */
  public Slide(PictureElement pictureElement) {
    this(pictureElement.element());
  }

  /**
   * Creates new slide with image source
   *
   * @param imageSrc the url for the image
   * @return new instance
   */
  public static Slide create(String imageSrc) {
    return new Slide(imageSrc);
  }

  /**
   * Creates new slide with {@link elemental2.dom.HTMLImageElement}
   *
   * @param image the {@link elemental2.dom.HTMLImageElement}
   * @return new instance
   */
  public static Slide create(HTMLImageElement image) {
    return new Slide(image);
  }

  /**
   * Creates new slide with {@link elemental2.dom.HTMLPictureElement}
   *
   * @param pictureElement the {@link elemental2.dom.HTMLPictureElement}
   * @return new instance
   */
  public static Slide create(HTMLPictureElement pictureElement) {
    return new Slide(pictureElement);
  }

  /**
   * Creates new slide with {@link org.dominokit.domino.ui.elements.ImageElement}
   *
   * @param image the {@link org.dominokit.domino.ui.elements.ImageElement}
   * @return new instance
   */
  public static Slide create(ImageElement image) {
    return new Slide(image);
  }

  /**
   * Creates new slide with {@link org.dominokit.domino.ui.elements.PictureElement}
   *
   * @param pictureElement the {@link org.dominokit.domino.ui.elements.PictureElement}
   * @return new instance
   */
  public static Slide create(PictureElement pictureElement) {
    return new Slide(pictureElement);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return slideElement.element();
  }

  /**
   * Activates this slide. This will add {@link org.dominokit.domino.ui.style.GenericCss#dui_active}
   * style to the slide
   *
   * @return same instance
   */
  public Slide activate() {
    setActive(true);
    return this;
  }

  void deActivate() {
    setActive(false);
  }

  /**
   * Sets the slide to active without changing the styles
   *
   * @param active a boolean that indicates this slide is active
   */
  public void setActive(boolean active) {
    indicatorElement.addCss(BooleanCssClass.of(dui_active, active));
    addCss(BooleanCssClass.of(dui_active, active));
  }

  /** @return True if this slide is active, false otherwise */
  /**
   * isActive.
   *
   * @return a boolean
   */
  public boolean isActive() {
    return dui_active.isAppliedTo(element());
  }

  /** @return The indicator element */
  /**
   * Getter for the field <code>indicatorElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  public DominoElement<HTMLLIElement> getIndicatorElement() {
    return elementOf(indicatorElement);
  }

  /**
   * setLabel.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.carousel.Slide} object
   */
  public Slide setLabel(String text) {
    slideLabelElement.get().textContent(text);
    return this;
  }

  /**
   * setDescription.
   *
   * @param text a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.carousel.Slide} object
   */
  public Slide setDescription(String text) {
    slideDescriptionElement.get().textContent(text);
    return this;
  }

  /** @return The slide label element */
  /**
   * Getter for the field <code>slideLabelElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HeadingElement} object
   */
  public HeadingElement getSlideLabelElement() {
    return slideLabelElement.get();
  }

  /** @return The slide label element */
  /**
   * withSlideLabelElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.carousel.Slide} object
   */
  public Slide withSlideLabelElement(ChildHandler<Slide, HeadingElement> handler) {
    handler.apply(this, slideLabelElement.get());
    return this;
  }

  /** @return The slide description element */
  /**
   * Getter for the field <code>slideDescriptionElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.ParagraphElement} object
   */
  public ParagraphElement getSlideDescriptionElement() {
    return slideDescriptionElement.get();
  }

  /**
   * withSlideDescriptionElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.carousel.Slide} object
   */
  public Slide withSlideDescriptionElement(ChildHandler<Slide, ParagraphElement> handler) {
    handler.apply(this, slideDescriptionElement.get());
    return this;
  }

  /**
   * withSlideCaptionElement.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.carousel.Slide} object
   */
  public Slide withSlideCaptionElement(ChildHandler<Slide, DivElement> handler) {
    handler.apply(this, captionElement.get());
    return this;
  }

  /** @return The slide caption element */
  /**
   * Getter for the field <code>captionElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getCaptionElement() {
    return captionElement.get();
  }

  /** @return The image element */
  /**
   * Getter for the field <code>imageElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  public DominoElement<HTMLElement> getImageElement() {
    return elementOf(imageElement);
  }
}
