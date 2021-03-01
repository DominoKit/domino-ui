package org.dominokit.domino.ui.carousel;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.dominokit.domino.ui.carousel.CarouselStyles.*;
import static org.jboss.elemento.Elements.*;

/**
 * A component for an element for {@link Carousel}
 * <p>
 * Images can be added to the component with the ability to add label and description
 *
 * @see BaseDominoElement
 * @see Carousel
 */
public class Slide extends BaseDominoElement<HTMLDivElement, Slide> {

    private final HTMLLIElement indicatorElement = li().element();
    private final HTMLHeadingElement slideLabelElement = h(3).element();
    private final HTMLParagraphElement slideDescriptionElement = p().element();
    private final HTMLDivElement captionElement = div()
            .add(slideLabelElement)
            .add(slideDescriptionElement)
            .css(CAROUSEL_CAPTION)
            .element();

    private final HTMLDivElement slideElement = div()
            .css(ITEM)
            .element();

    private final HTMLImageElement imageElement;
    private boolean active = false;

    public Slide(String imageSrc) {
        this(img(imageSrc).element());
    }

    public Slide(HTMLImageElement image) {
        imageElement = image;
        slideElement.appendChild(image);
        init(this);
    }

    public Slide(String imageSrc, String label, String description) {
        this(img(imageSrc).element(), label, description);
    }

    public Slide(HTMLImageElement image, String label, String description) {
        this(image);
        slideLabelElement.textContent = label;
        slideDescriptionElement.textContent = description;
        slideElement.appendChild(captionElement);
        init(this);
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
     * Creates new slide with image source, label and description
     *
     * @param imageSrc    the url for the image
     * @param label       the image label
     * @param description the image description
     * @return new instance
     */
    public static Slide create(String imageSrc, String label, String description) {
        return new Slide(imageSrc, label, description);
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
     * Creates new slide with {@link HTMLImageElement}, label and description
     *
     * @param image       the {@link HTMLImageElement}
     * @param label       the image label
     * @param description the image description
     * @return new instance
     */
    public static Slide create(HTMLImageElement image, String label, String description) {
        return new Slide(image, label, description);
    }

    /**
     * @return The indicator element
     */
    public DominoElement<HTMLLIElement> getIndicatorElement() {
        return DominoElement.of(indicatorElement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return slideElement;
    }

    /**
     * Activates this slide. This will add {@link CarouselStyles#ACTIVE} style to the slide
     *
     * @return same instance
     */
    public Slide activate() {
        this.active = true;
        if (!Style.of(indicatorElement).contains(ACTIVE)) {
            Style.of(indicatorElement).add(ACTIVE);
        }
        if (!style().contains(ACTIVE)) {
            style().add(ACTIVE);
        }

        return this;
    }

    void deActivate() {
        this.active = false;
        Style.of(indicatorElement).remove(ACTIVE);
        style().remove(ACTIVE);

    }

    /**
     * Sets the slide to active without changing the styles
     *
     * @param active a boolean that indicates this slide is active
     */
    public void setActiveFlag(boolean active) {
        this.active = active;
    }

    /**
     * @return True if this slide is active, false otherwise
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Checks if this slide has {@link CarouselStyles#ACTIVE} style
     *
     * @return true if the slide has active style, false otherwise
     */
    public boolean hasActiveStyle() {
        return style().contains(ACTIVE);
    }

    /**
     * @return The slide label element
     */
    public DominoElement<HTMLHeadingElement> getSlideLabelElement() {
        return DominoElement.of(slideLabelElement);
    }

    /**
     * @return The slide description element
     */
    public DominoElement<HTMLParagraphElement> getSlideDescriptionElement() {
        return DominoElement.of(slideDescriptionElement);
    }

    /**
     * @return The slide caption element
     */
    public DominoElement<HTMLDivElement> getCaptionElement() {
        return DominoElement.of(captionElement);
    }

    /**
     * @return The image element
     */
    public DominoElement<HTMLImageElement> getImageElement() {
        return DominoElement.of(imageElement);
    }
}
