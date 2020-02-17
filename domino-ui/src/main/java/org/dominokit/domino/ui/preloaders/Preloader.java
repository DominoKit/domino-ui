package org.dominokit.domino.ui.preloaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

import static org.jboss.elemento.Elements.div;

public class Preloader extends BaseDominoElement<HTMLDivElement, Preloader> implements IsElement<HTMLDivElement> {

    private final HTMLDivElement root;
    private final HTMLDivElement spinnerLayer;

    private Size size = Size.large;
    private Color color = Color.RED;

    public Preloader() {
        this.root = div().css("preloader", "pl-size-l")
                .add(spinnerLayer = div().css("spinner-layer", "pl-red")
                        .add(div().css("circle-clipper", "left")
                                .add(div().css("circle")))
                        .add(div().css("circle-clipper", "right")
                                .add(div().css("circle")))
                        .element())
                .element();
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return root;
    }

    public static Preloader create() {
        return new Preloader();
    }

    public Preloader setSize(Size size) {
        style().remove(this.size.style);
        this.size = size;
        style().add(this.size.style);
        return this;
    }


    public Preloader setColor(Color color) {
        spinnerStyle().remove(this.color.getStyle().replace("col-", "pl-"));
        this.color = color;
        spinnerStyle().add(this.color.getStyle().replace("col-", "pl-"));
        return this;
    }

    private Style<HTMLDivElement, IsElement<HTMLDivElement>> spinnerStyle() {
        return Style.of(spinnerLayer);
    }

    public Preloader stop() {
        element().remove();
        return this;
    }

    public enum Size {
        xLarge(PreloaderStyles.pl_size_xl),
        large(PreloaderStyles.pl_size_l),
        medium(PreloaderStyles.pl_size_md),
        small(PreloaderStyles.pl_size_sm),
        xSmall(PreloaderStyles.pl_size_xs);

        private String style;

        Size(String style) {
            this.style = style;
        }
    }
}
