package org.dominokit.domino.ui.header;

import elemental2.dom.*;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class BlockHeader extends BaseDominoElement<HTMLDivElement, BlockHeader> {

    private HTMLDivElement element = div().css("block-header").asElement();
    private HTMLHeadingElement headerElement = h(2).asElement();
    private HTMLElement descriptionElement;
    private Text headerText = DomGlobal.document.createTextNode("");
    private Text descriptionText = DomGlobal.document.createTextNode("");

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
        descriptionElement = small().add(descriptionText).asElement();
        headerElement.appendChild(descriptionElement);
    }

    public static BlockHeader create(String header, String description) {
        return new BlockHeader(header, description);
    }

    public static BlockHeader create(String header) {
        return new BlockHeader(header);
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public BlockHeader appendContent(Node content) {
        return appendChild(content);
    }

    public BlockHeader appendChild(Node content) {
        if (isNull(descriptionElement))
            createDescriptionElement("");
        descriptionElement.appendChild(content);
        return this;
    }

    public BlockHeader appendChild(IsElement content) {
        return appendChild(content.asElement());
    }

    public BlockHeader invert() {
        if (nonNull(descriptionElement)) {
            descriptionElement.remove();
            element.insertBefore(descriptionElement, headerElement);
        }

        return this;
    }

    public BlockHeader appendText(String text) {
        return appendContent(DomGlobal.document.createTextNode(text));
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
    public HTMLDivElement asElement() {
        return element;
    }
}
