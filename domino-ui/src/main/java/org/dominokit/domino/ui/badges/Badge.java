package org.dominokit.domino.ui.badges;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.TextNode;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.span;

/**
 * Displays small label with color.
 *
 * <p>
 * This component provides a small label that has background color and a text.
 * Customize the component can be done by overwriting classes provided by {@link BadgeStyles}
 *
 * <p>For example: </p>
 * <pre>
 *     Badge.create("label")
 * </pre>
 *
 * @see BaseDominoElement
 * @see HasBackground
 */
public class Badge extends BaseDominoElement<HTMLElement, Badge> implements HasBackground<Badge> {

    private final DominoElement<HTMLElement> badgeElement = DominoElement.of(span()
            .css(BadgeStyles.BADGE))
            .elevate(Elevation.LEVEL_1);
    private final Text textNode = TextNode.empty();
    private Color badgeBackground;

    public Badge() {
        init(this);
        appendChild(textNode);
    }

    /**
     * Creates badge with {@code content}
     *
     * @param content the text to be added to the badge
     * @return new badge instance
     */
    public static Badge create(String content) {
        Badge badge = new Badge();
        badge.setText(content);
        return badge;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLElement element() {
        return badgeElement.element();
    }

    /**
     * Sets the text content of the badge
     *
     * @param text the new content
     * @return same instance
     */
    public Badge setText(String text) {
        textNode.textContent = text;
        return this;
    }

    /**
     * Position the element to the right of its parent
     *
     * @return same instance
     */
    public Badge pullRight() {
        style().pullRight();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Badge setBackground(Color badgeBackground) {
        if (nonNull(this.badgeBackground)) {
            badgeElement.style().remove(this.badgeBackground.getBackground());
        }

        this.badgeBackground = badgeBackground;
        badgeElement.style().add(this.badgeBackground.getBackground());
        return this;
    }
}
