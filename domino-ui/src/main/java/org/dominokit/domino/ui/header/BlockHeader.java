package org.dominokit.domino.ui.header;

import elemental2.dom.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.*;

/**
 * A component provides a header text with a description in a predefined style
 * <p>
 * Customize the component can be done by overwriting classes provided by {@link BlockHeaderStyles}
 *
 * <p>For example: </p>
 * <pre>
 *     BlockHeader.create("Header", "Description");
 * </pre>
 *
 * @see BaseDominoElement
 */
public class BlockHeader extends BaseDominoElement<HTMLDivElement, BlockHeader> {

    private final HTMLDivElement element = div().css(BlockHeaderStyles.BLOCK_HEADER).element();
    private final HTMLHeadingElement headerElement = h(2).element();
    private HTMLElement descriptionElement;
    private final Text headerText = TextNode.empty();
    private final Text descriptionText = TextNode.empty();

    private BlockHeader(String header) {
        this(header, null);
    }

    private BlockHeader(String header, String description) {
        headerText.textContent = header;
        headerElement.appendChild(headerText);
        element.appendChild(headerElement);

        if (nonNull(description)) {
            createDescriptionElement(description);
        }
        init(this);
    }

    private void createDescriptionElement(String description) {
        descriptionText.textContent = description;
        descriptionElement = small().add(descriptionText).element();
        headerElement.appendChild(descriptionElement);
    }

    /**
     * Creates a header with a description
     *
     * @param header      the header text
     * @param description the description text
     * @return new instance
     */
    public static BlockHeader create(String header, String description) {
        return new BlockHeader(header, description);
    }

    /**
     * Creates a header
     *
     * @param header the header text
     * @return new instance
     */
    public static BlockHeader create(String header) {
        return new BlockHeader(header);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockHeader appendChild(Node content) {
        if (isNull(descriptionElement))
            createDescriptionElement("");
        descriptionElement.appendChild(content);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BlockHeader appendChild(IsElement<?> content) {
        return appendChild(content.element());
    }

    /**
     * Change the positions of the header and description elements by setting the header under the description
     *
     * @return same instance
     */
    public BlockHeader invert() {
        if (nonNull(descriptionElement)) {
            descriptionElement.remove();
            element.insertBefore(descriptionElement, headerElement);
        }

        return this;
    }

    /**
     * Adds text as a child to this component
     *
     * @param text the text
     * @return same instance
     */
    public BlockHeader appendText(String text) {
        return appendChild(DomGlobal.document.createTextNode(text));
    }

    /**
     * Sets the header text
     *
     * @param header the new text
     * @return same instance
     */
    public BlockHeader setHeader(String header) {
        headerText.textContent = header;
        return this;
    }

    /**
     * @return The header element
     */
    public DominoElement<HTMLHeadingElement> getHeaderElement() {
        return DominoElement.of(headerElement);
    }

    /**
     * @return The description element
     */
    public DominoElement<HTMLElement> getDescriptionElement() {
        return DominoElement.of(descriptionElement);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }
}
