package org.dominokit.domino.ui.preloaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

import static org.jboss.elemento.Elements.div;

/**
 * A component to show a loading indicator with different sizes and colors
 *
 * <p>example</p>
 *
 * <pre>
 * DominoElement.body()
 *         .appendChild(Preloader.create()
 *                 .setSize(Preloader.Size.large)
 *                 .setColor(Color.GREEN));
 * </pre>
 */
public class Preloader extends BaseDominoElement<HTMLDivElement, Preloader> implements IsElement<HTMLDivElement> {

    private final HTMLDivElement root;
    private final HTMLDivElement spinnerLayer;

    private Size size = Size.large;
    private Color color = Color.RED;

    /**
     *
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return root;
    }

    /**
     *
     * @return new Preloader instance
     */
    public static Preloader create() {
        return new Preloader();
    }

    /**
     *
     * @param size {@link Size}
     * @return same Preloader instance
     */
    public Preloader setSize(Size size) {
        style().remove(this.size.style);
        this.size = size;
        style().add(this.size.style);
        return this;
    }


    /**
     *
     * @param color {@link Color}
     * @return same Preloader instance
     */
    public Preloader setColor(Color color) {
        spinnerStyle().remove(this.color.getStyle().replace("col-", "pl-"));
        this.color = color;
        spinnerStyle().add(this.color.getStyle().replace("col-", "pl-"));
        return this;
    }

    private Style<HTMLDivElement, IsElement<HTMLDivElement>> spinnerStyle() {
        return Style.of(spinnerLayer);
    }

    /**
     * removes the loader from the dom tree
     * @return same Preloader instance
     */
    public Preloader stop() {
        element().remove();
        return this;
    }

    /**
     * An enum to list preloader sizes
     */
    public enum Size {
        xLarge(PreloaderStyles.pl_size_xl),
        large(PreloaderStyles.pl_size_l),
        medium(PreloaderStyles.pl_size_md),
        small(PreloaderStyles.pl_size_sm),
        xSmall(PreloaderStyles.pl_size_xs);

        private String style;

        /**
         *
         * @param style String css class for the loader size
         */
        Size(String style) {
            this.style = style;
        }
    }
}
