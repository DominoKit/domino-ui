package org.dominokit.domino.ui.thumbnails;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.elemento.IsElement;

import static java.util.Objects.isNull;
import static org.jboss.elemento.Elements.div;

public class Thumbnail extends BaseDominoElement<HTMLDivElement, Thumbnail> {

    private HTMLDivElement element = div().css("thumbnail").element();
    private HTMLDivElement contentElement = div().element();
    private HTMLDivElement captionElement = div().css("caption").element();

    public Thumbnail() {
        element.appendChild(contentElement);
        init(this);
    }

    public static Thumbnail create() {
        return new Thumbnail();
    }

    public Thumbnail setContent(Node content) {
        ElementUtil.clear(contentElement);
        contentElement.appendChild(content);
        return this;
    }

    public Thumbnail setContent(IsElement content) {
        return setContent(content.element());
    }

    /**
     * @deprecated use {@link #appendCaptionChild(Node)}
     */
    @Deprecated
    public Thumbnail appendCaptionContent(Node content) {
        return appendCaptionChild(content);
    }

    public Thumbnail appendCaptionChild(Node content) {
        if (isNull(captionElement.parentNode))
            element.appendChild(captionElement);
        captionElement.appendChild(content);
        return this;
    }

    public Thumbnail appendCaptionChild(IsElement content) {
        return appendCaptionChild(content.element());
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }

    public DominoElement<HTMLDivElement> getContentElement() {
        return DominoElement.of(contentElement);
    }

    public DominoElement<HTMLDivElement> getCaptionElement() {
        return DominoElement.of(captionElement);
    }
}
