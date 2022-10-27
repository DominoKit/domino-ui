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

import elemental2.dom.*;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

import static org.dominokit.domino.ui.carousel.CarouselStyles.*;
import static org.jboss.elemento.Elements.img;

/**
 * A component for an element for {@link Carousel}
 *
 * <p>Images can be added to the component with the ability to add label and description
 *
 * @see BaseDominoElement
 * @see Carousel
 */
public class Slide extends BaseDominoElement<HTMLDivElement, Slide> {

    private final DominoElement<HTMLLIElement> indicatorElement;
    private final LazyChild<DominoElement<HTMLHeadingElement>> slideLabelElement;
    private final LazyChild<DominoElement<HTMLParagraphElement>> slideDescriptionElement;
    private final LazyChild<DominoElement<HTMLDivElement>> captionElement;

    private final DominoElement<HTMLDivElement> slideElement;

    private final DominoElement<HTMLElement> imageElement;

    private Slide(HTMLElement element) {
        slideElement = DominoElement.div()
                .addCss(slide)
                .appendChild(imageElement = DominoElement.of(element));

        indicatorElement = DominoElement.li().addCss(slide_indicator);

        captionElement = LazyChild.of(DominoElement.div().addCss(slide_caption), slideElement);
        slideLabelElement = LazyChild.of(DominoElement.h(3), captionElement);
        slideDescriptionElement = LazyChild.of(DominoElement.p(), captionElement);
        init(this);
    }

    public Slide(String imageSrc) {
        this(img(imageSrc).element());
    }

    public Slide(HTMLImageElement image) {
        this((HTMLElement) image);
    }

    public Slide(HTMLPictureElement pictureElement) {
        this((HTMLElement) pictureElement);
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
     * Creates new slide with {@link HTMLImageElement}
     *
     * @param image the {@link HTMLImageElement}
     * @return new instance
     */
    public static Slide create(HTMLImageElement image) {
        return new Slide(image);
    }

    /**
     * Creates new slide with {@link HTMLPictureElement}
     *
     * @param pictureElement the {@link HTMLPictureElement}
     * @return new instance
     */
    public static Slide create(HTMLPictureElement pictureElement) {
        return new Slide(pictureElement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return slideElement.element();
    }

    /**
     * Activates this slide. This will add {@link org.dominokit.domino.ui.style.GenericCss#dui_active_element} style to the slide
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
        indicatorElement.addCss(BooleanCssClass.of(dui_active_element, active));
        addCss(BooleanCssClass.of(dui_active_element, active));
    }

    /**
     * @return True if this slide is active, false otherwise
     */
    public boolean isActive() {
        return dui_active_element.isAppliedTo(element());
    }

    /**
     * @return The indicator element
     */
    public DominoElement<HTMLLIElement> getIndicatorElement() {
        return DominoElement.of(indicatorElement);
    }

    public Slide setLabel(String text){
        slideLabelElement.get().textContent(text);
        return this;
    }

    public Slide setDescription(String text){
        slideDescriptionElement.get().textContent(text);
        return this;
    }

    /**
     * @return The slide label element
     */
    public DominoElement<HTMLHeadingElement> getSlideLabelElement() {
        return slideLabelElement.get();
    }

    /**
     * @return The slide label element
     */
    public Slide withSlideLabelElement(ChildHandler<Slide, DominoElement<HTMLHeadingElement>> handler) {
        handler.apply(this, slideLabelElement.get());
        return this;
    }

    /**
     * @return The slide description element
     */
    public DominoElement<HTMLParagraphElement> getSlideDescriptionElement() {
        return slideDescriptionElement.get();
    }

    public Slide withSlideDescriptionElement(ChildHandler<Slide, DominoElement<HTMLParagraphElement>> handler) {
        handler.apply(this, slideDescriptionElement.get());
        return this;
    }


    public Slide withSlideCaptionElement(ChildHandler<Slide, DominoElement<HTMLDivElement>> handler) {
        handler.apply(this, captionElement.get());
        return this;
    }

    /**
     * @return The slide caption element
     */
    public DominoElement<HTMLDivElement> getCaptionElement() {
        return captionElement.get();
    }

    /**
     * @return The image element
     */
    public DominoElement<HTMLElement> getImageElement() {
        return DominoElement.of(imageElement);
    }
}
