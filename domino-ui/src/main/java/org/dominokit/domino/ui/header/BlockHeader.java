package org.dominokit.domino.ui.header;

import elemental2.dom.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class BlockHeader extends BaseDominoElement<HTMLDivElement, BlockHeader> {

    private HTMLDivElement element = div().css(BlockHeaderStyles.BLOCK_HEADER).element();
    private HTMLHeadingElement headerElement = h(2).element();
    private HTMLElement descriptionElement;
    private Text headerText = TextNode.empty();
    private Text descriptionText = TextNode.empty();

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

    public static BlockHeader create(String header, String description) {
        return new BlockHeader(header, description);
    }

    public static BlockHeader create(String header) {
        return new BlockHeader(header);
    }


    public BlockHeader appendChild(Node content) {
        if (isNull(descriptionElement))
            createDescriptionElement("");
        descriptionElement.appendChild(content);
        return this;
    }

    public BlockHeader appendChild(IsElement content) {
        return appendChild(content.element());
    }

    public BlockHeader invert() {
        if (nonNull(descriptionElement)) {
            descriptionElement.remove();
            element.insertBefore(descriptionElement, headerElement);
        }

        return this;
    }

    public BlockHeader appendText(String text) {
        return appendChild(DomGlobal.document.createTextNode(text));
    }

    public BlockHeader setHeader(String header) {
        headerText.textContent = header;
        return this;
    }

    public DominoElement<HTMLHeadingElement> getHeaderElement() {
        return DominoElement.of(headerElement);
    }

    public DominoElement<HTMLElement> getDescriptionElement() {
        return DominoElement.of(descriptionElement);
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
