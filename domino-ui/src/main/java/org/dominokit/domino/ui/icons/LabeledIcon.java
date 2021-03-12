package org.dominokit.domino.ui.icons;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.span;

/**
 * Icon with a label
 * <p>
 * This component makes sure that the label and the icon fits together
 *
 * @see BaseDominoElement
 */
public class LabeledIcon extends BaseDominoElement<HTMLDivElement, LabeledIcon> {

    private final HTMLDivElement element = div().css(IconsStyles.LABELED_ICON).element();

    public LabeledIcon(BaseIcon<?> icon, String text) {
        this(icon, text, IconPosition.LEFT);
    }

    public LabeledIcon(BaseIcon<?> icon, String text, IconPosition position) {
        HTMLElement leftSpan = span().css(IconsStyles.LEFT_NODE).element();
        HTMLElement rightSpan = span().css(IconsStyles.RIGHT_NODE).element();
        position.placeElements(leftSpan, rightSpan, icon, TextNode.of(text));
        element.appendChild(leftSpan);
        element.appendChild(rightSpan);
    }

    /**
     * Creates an icon with a label text
     *
     * @param icon the {@link BaseIcon}
     * @param text the label of the icon
     * @return new instance
     */
    public static LabeledIcon create(BaseIcon<?> icon, String text) {
        return new LabeledIcon(icon, text);
    }

    /**
     * Creates an icon with a label text with providing the position of the icon to either left or right
     *
     * @param icon     the {@link BaseIcon}
     * @param text     the label of the icon
     * @param position the {@link IconPosition}
     * @return new instance
     */
    public static LabeledIcon create(BaseIcon<?> icon, String text, IconPosition position) {
        return new LabeledIcon(icon, text, position);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }

    /**
     * An enum representing the position of the icon related to the label
     */
    public enum IconPosition {
        /**
         * position the icon to the left
         */
        LEFT((left, right, icon, text) -> {
            left.appendChild(icon.element());
            right.appendChild(text);
            left.classList.add(IconsStyles.ICON_NODE);
            right.classList.add(IconsStyles.TEXT_NODE);
        }),

        /**
         * position the icon to the right
         */
        RIGHT((left, right, icon, text) -> {
            left.appendChild(text);
            right.appendChild(icon.element());
            right.classList.add(IconsStyles.ICON_NODE);
            left.classList.add(IconsStyles.TEXT_NODE);
        });

        private final ElementsPlacement elementsPlacement;

        IconPosition(ElementsPlacement elementsPlacement) {
            this.elementsPlacement = elementsPlacement;
        }

        /**
         * Position the elements
         *
         * @param left the left container
         * @param right the right container
         * @param icon the icon
         * @param text the label
         */
        public void placeElements(HTMLElement left, HTMLElement right, BaseIcon<?> icon, Text text) {
            elementsPlacement.placeElements(left, right, icon, text);
        }
    }

    @FunctionalInterface
    private interface ElementsPlacement {
        void placeElements(HTMLElement left, HTMLElement right, BaseIcon<?> icon, Text text);
    }
}
