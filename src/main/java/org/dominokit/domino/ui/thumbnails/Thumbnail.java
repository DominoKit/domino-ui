package org.dominokit.domino.ui.thumbnails;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class Thumbnail extends DominoElement<HTMLDivElement, Thumbnail> implements IsElement<HTMLDivElement> {

    private HTMLDivElement element = div().css("thumbnail").asElement();
    private HTMLDivElement contentElement = div().asElement();
    private HTMLDivElement captionElement = div().css("caption").asElement();

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
        return setContent(content.asElement());
    }

    /**
     * @deprecated use {@link #appendCaptionChild(Node)}
     * @param content
     * @return
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
        return appendCaptionChild(content.asElement());
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getContentElement() {
        return DominoElement.of(contentElement);
    }

    public DominoElement<HTMLDivElement, IsElement<HTMLDivElement>> getCaptionElement() {
        return DominoElement.of(captionElement);
    }
}
