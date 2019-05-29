package org.dominokit.domino.ui.carousel;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.dominokit.domino.ui.carousel.CarouselStyles.*;
import static org.jboss.gwt.elemento.core.Elements.*;

public class Slide extends BaseDominoElement<HTMLDivElement, Slide> {

    private HTMLLIElement indicatorElement = li().asElement();
    private HTMLHeadingElement slideLabelElement = h(3).asElement();
    private HTMLParagraphElement slideDescriptionElement = p().asElement();
    private HTMLDivElement captionElement = div()
            .add(slideLabelElement)
            .add(slideDescriptionElement)
            .css(CAROUSEL_CAPTION)
            .asElement();

    private HTMLDivElement slideElement = div()
            .css(ITEM)
            .asElement();

    private HTMLImageElement imageElement;
    private boolean active = false;

    public Slide(String imageSrc) {
        this(img(imageSrc).asElement());
    }

    public Slide(HTMLImageElement image) {
        imageElement = image;
        slideElement.appendChild(image);
        init(this);
    }

    public Slide(String imageSrc, String label, String description) {
        this(img(imageSrc).asElement(), label, description);
    }

    public Slide(HTMLImageElement image, String label, String description) {
        this(image);
        slideLabelElement.textContent = label;
        slideDescriptionElement.textContent = description;
        slideElement.appendChild(captionElement);
        init(this);
    }

    public static Slide create(String imageSrc) {
        return new Slide(imageSrc);
    }

    public static Slide create(String imageSrc, String label, String description) {
        return new Slide(imageSrc, label, description);
    }

    public static Slide create(HTMLImageElement image) {
        return new Slide(image);
    }

    public static Slide create(HTMLImageElement image, String label, String description) {
        return new Slide(image, label, description);
    }

    public DominoElement<HTMLLIElement> getIndicatorElement() {
        return DominoElement.of(indicatorElement);
    }

    @Override
    public HTMLDivElement asElement() {
        return slideElement;
    }

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

    public Slide deActivate() {
        this.active = false;
        Style.of(indicatorElement).remove(ACTIVE);
        style().remove(ACTIVE);

        return this;
    }

    public void setActiveFlag(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public boolean hasActiveStyle() {
        return style().contains(ACTIVE);
    }

    public DominoElement<HTMLHeadingElement> getSlideLabelElement() {
        return DominoElement.of(slideLabelElement);
    }

    public DominoElement<HTMLParagraphElement> getSlideDescriptionElement() {
        return DominoElement.of(slideDescriptionElement);
    }

    public DominoElement<HTMLDivElement> getCaptionElement() {
        return DominoElement.of(captionElement);
    }

    public DominoElement<HTMLImageElement> getImageElement() {
        return DominoElement.of(imageElement);
    }
}