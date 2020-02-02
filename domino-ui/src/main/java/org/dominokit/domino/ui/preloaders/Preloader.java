package org.dominokit.domino.ui.preloaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class Preloader extends BaseDominoElement<HTMLDivElement, Preloader> implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement spinnerLayer;

    private Size size = Size.large;
    private Color color = Color.RED;

    @PostConstruct
    void init() {
        init(this);
    }

    public static Preloader create() {
        return new Templated_Preloader();
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
