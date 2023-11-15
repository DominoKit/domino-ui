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
import static org.dominokit.domino.ui.utils.Domino.*;

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
 * A slide component used with {@link org.dominokit.domino.ui.carousel.Carousel}
 *
 * <p>The component provide the means to create an image slide with different types of image
 * elements or components
 *
 * @see BaseDominoElement
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
   * Creates an image slide from the provided image url
   *
   * @param imageSrc The string image source that will be used as the value for the img tag src
   *     attribute.
   */
  public Slide(String imageSrc) {
    this(img(imageSrc).element());
  }

  /**
   * Creates an image slide from the provided image element
   *
   * @param image The {@link elemental2.dom.HTMLImageElement} element to be used for the slide
   */
  public Slide(HTMLImageElement image) {
    this((HTMLElement) image);
  }

  /**
   * Creates an image slide from the provided picture element
   *
   * @param pictureElement The {@link elemental2.dom.HTMLPictureElement} element to be used for the
   *     slide.
   */
  public Slide(HTMLPictureElement pictureElement) {
    this((HTMLElement) pictureElement);
  }

  /**
   * Creates an image slide from the provided image component
   *
   * @param image The {@link ImageElement} element to be used for the slide.
   */
  public Slide(ImageElement image) {
    this(image.element());
  }

  /**
   * Creates an image slide from the provided picture component
   *
   * @param pictureElement The {@link PictureElement} element to be used for the slide.
   */
  public Slide(PictureElement pictureElement) {
    this(pictureElement.element());
  }

  /**
   * Factory method to create an image slide from the provided image url
   *
   * @param imageSrc The string image source that will be used as the value for the img tag src
   *     attribute.
   * @return new instance
   */
  public static Slide create(String imageSrc) {
    return new Slide(imageSrc);
  }

  /**
   * Factory method to create an image slide from the provided image element
   *
   * @param image The {@link elemental2.dom.HTMLImageElement} element to be used for the slide
   * @return new instance
   */
  public static Slide create(HTMLImageElement image) {
    return new Slide(image);
  }

  /**
   * Factory method to create an image slide from the provided picture element
   *
   * @param pictureElement The {@link elemental2.dom.HTMLPictureElement} element to be used for the
   *     slide.
   * @return new instance
   */
  public static Slide create(HTMLPictureElement pictureElement) {
    return new Slide(pictureElement);
  }

  /**
   * Factory method to create an image slide from the provided image component
   *
   * @param image The {@link ImageElement} element to be used for the slide.
   * @return new instance
   */
  public static Slide create(ImageElement image) {
    return new Slide(image);
  }

  /**
   * Factory method to create an image slide from the provided picture component
   *
   * @param pictureElement The {@link PictureElement} element to be used for the slide.
   * @return new instance
   */
  public static Slide create(PictureElement pictureElement) {
    return new Slide(pictureElement);
  }

  /** @dominokit-site-ignore {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return slideElement.element();
  }

  /**
   * Activates this slide. This will add {@link org.dominokit.domino.ui.style.GenericCss#dui_active}
   * style to the slide This method is a shortcut for <b>setActive(true)</b>
   *
   * @return same slide instance
   */
  public Slide activate() {
    setActive(true);
    return this;
  }

  /**
   * Deactivate this slide. This will remove {@link
   * org.dominokit.domino.ui.style.GenericCss#dui_active} style from the slide This method is a
   * shortcut for <b>setActive(false)</b>
   */
  void deActivate() {
    setActive(false);
  }

  /**
   * Change the style active state
   *
   * @param active a boolean, <b>true</b> to make the slide active, <b>false</b> make the slide
   *     inactive.
   */
  public void setActive(boolean active) {
    indicatorElement.addCss(BooleanCssClass.of(dui_active, active));
    addCss(BooleanCssClass.of(dui_active, active));
  }

  /**
   * Use to check if the slide is currently active or not.
   *
   * @return a boolean, <b>true</b> if the slide is active, <b>false</b> if the slide is not active.
   */
  public boolean isActive() {
    return dui_active.isAppliedTo(element());
  }

  /** @return This slide indicator element attached to the carousel slides indicators. */
  public DominoElement<HTMLLIElement> getIndicatorElement() {
    return elementOf(indicatorElement);
  }

  /**
   * Sets the slide title
   *
   * @param text the slide title text.
   * @return same slide instance
   */
  public Slide setLabel(String text) {
    slideLabelElement.get().textContent(text);
    return this;
  }

  /**
   * sets the slide description text
   *
   * @param text slide description text
   * @return same slide instance
   */
  public Slide setDescription(String text) {
    slideDescriptionElement.get().textContent(text);
    return this;
  }

  /** @return The {@link org.dominokit.domino.ui.elements.HeadingElement} of the slide title. */
  public HeadingElement getSlideLabelElement() {
    return slideLabelElement.get();
  }

  /**
   * Use to apply customizations to the slide title element without breaking the fluent API chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations
   * @return same carousel instance
   */
  public Slide withSlideLabelElement(ChildHandler<Slide, HeadingElement> handler) {
    handler.apply(this, slideLabelElement.get());
    return this;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.elements.ParagraphElement} of the slide description.
   */
  public ParagraphElement getSlideDescriptionElement() {
    return slideDescriptionElement.get();
  }

  /**
   * Use to apply customizations to the slide description element without breaking the fluent API
   * chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations
   * @return same carousel instance
   */
  public Slide withSlideDescriptionElement(ChildHandler<Slide, ParagraphElement> handler) {
    handler.apply(this, slideDescriptionElement.get());
    return this;
  }

  /**
   * Use to apply customizations to the slide caption element which holds the title and description
   * without breaking the fluent API chain.
   *
   * @param handler The {@link org.dominokit.domino.ui.utils.ChildHandler} applying the
   *     customizations
   * @return same carousel instance
   */
  public Slide withSlideCaptionElement(ChildHandler<Slide, DivElement> handler) {
    handler.apply(this, captionElement.get());
    return this;
  }

  /**
   * @return The {@link org.dominokit.domino.ui.elements.DivElement} that holds the title and
   *     description elements
   */
  public DivElement getCaptionElement() {
    return captionElement.get();
  }

  /** @return The element of the image of this slide. */
  public DominoElement<HTMLElement> getImageElement() {
    return elementOf(imageElement);
  }
}
