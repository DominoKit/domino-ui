package org.dominokit.domino.ui.carousel;

import elemental2.dom.*;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.*;

public class Slide implements IsElement<HTMLDivElement> {

    private HTMLLIElement indicatorElement = li().asElement();
    private HTMLHeadingElement slideLabelElement = h(3).asElement();
    private HTMLParagraphElement slideDescriptionElement = p().asElement();
    private HTMLDivElement captionElement = div()
            .add(slideLabelElement)
            .add(slideDescriptionElement)
            .css("carousel-caption")
            .asElement();

    private HTMLDivElement slideElement = div()
            .css("item")
            .asElement();

    HTMLImageElement imageElement;
    private boolean active = false;

    public Slide(String imageSrc) {
        this(img(imageSrc).asElement());
    }

    public Slide(HTMLImageElement image) {
        imageElement = image;
        slideElement.appendChild(image);

    }

    public Slide(String imageSrc, String label, String description) {
        this(img(imageSrc).asElement(), label, description);
    }

    public Slide(HTMLImageElement image, String label, String description) {
        this(image);
        slideLabelElement.textContent = label;
        slideDescriptionElement.textContent = description;
        slideElement.appendChild(captionElement);
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

    public HTMLLIElement getIndicatorElement() {
        return indicatorElement;
    }

    @Override
    public HTMLDivElement asElement() {
        return slideElement;
    }

    public Slide activate() {
        this.active = true;
        if (!Style.of(indicatorElement).hasClass("active")) {
            Style.of(indicatorElement).css("active");
        }
        if (!Style.of(this).hasClass("active")) {
            Style.of(this).css("active");
        }

        return this;
    }

    public Slide deActivate() {
        this.active = false;
        Style.of(indicatorElement).removeClass("active");
        Style.of(this).removeClass("active");

        return this;
    }

    public void setActiveFlag(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public boolean hasActiveStyle() {
        return Style.of(this).hasClass("active");
    }
}