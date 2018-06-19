package org.dominokit.domino.ui.preloaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class Preloader implements IsElement<HTMLDivElement> {

    private HTMLDivElement spinnerLayer = div()
            .css("spinner-layer", "pl-red")
            .add(div()
                    .css("circle-clipper", "left")
                    .add(div().css("circle")))
            .add(div()
                    .css("circle-clipper", "right")
                    .add(div().css("circle")))
            .asElement();


    private HTMLDivElement element = div()
            .css("preloader", "pl-size-l")
            .add(spinnerLayer)
            .asElement();

    private Size size = Size.large;
    private Color color = Color.RED;

    public static Preloader create() {
        return new Preloader();
    }

    public Preloader setSize(Size size) {
        asElement().classList.remove(this.size.style);
        this.size = size;
        asElement().classList.add(this.size.style);
        return this;
    }


    public Preloader setColor(Color color) {
        spinnerLayer.classList.remove(this.color.getStyle().replace("col-", "pl-"));
        this.color = color;
        spinnerLayer.classList.add(this.color.getStyle().replace("col-", "pl-"));
        return this;
    }

    public Preloader stop() {
        asElement().remove();
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public enum Size {
        xLarge("pl-size-xl"),
        large("pl-size-l"),
        medium("pl-size-md"),
        small("pl-size-sm"),
        xSmall("pl-size-xs");

        private String style;

        Size(String style) {
            this.style = style;
        }
    }
}
