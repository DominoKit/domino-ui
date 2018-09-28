package org.dominokit.domino.ui.media;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

@Templated
public abstract class MediaObject extends BaseDominoElement<HTMLDivElement, MediaObject> implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement mediaBody;

    @DataElement
    HTMLHeadingElement mediaHeader;

    private DominoElement<HTMLDivElement> leftMedia;
    private DominoElement<HTMLDivElement> rightMedia;

    private MediaAlign leftAlign = MediaAlign.TOP;
    private MediaAlign rightAlign = MediaAlign.TOP;

    @PostConstruct
    void init() {
        init(this);
    }

    public static MediaObject create() {
        return new Templated_MediaObject();
    }

    public MediaObject setHeader(String header) {
        mediaHeader.textContent = header;
        return this;
    }

    public MediaObject setLeftMedia(Node content) {
        if (isNull(leftMedia)) {
            leftMedia = DominoElement.of(div().css("media-left"));
            insertBefore(leftMedia, mediaBody);
        }

        leftMedia.clearElement();
        leftMedia.appendChild(content);
        return this;
    }

    public MediaObject setLeftMedia(IsElement element) {
        return setLeftMedia(element.asElement());
    }

    public MediaObject setRightMedia(Node content) {
        if (isNull(rightMedia)) {
            rightMedia = DominoElement.of(div().css("media-right"));
            appendChild(rightMedia);
        }

        rightMedia.clearElement();
        rightMedia.appendChild(content);
        return this;
    }

    public MediaObject setRightMedia(IsElement element) {
        return setRightMedia(element.asElement());
    }

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public MediaObject appendContent(Node content) {
        return appendChild(content);
    }

    public MediaObject appendChild(Node content) {
        mediaBody.appendChild(content);
        return this;
    }

    public MediaObject appendChild(IsElement content) {
        return appendChild(content.asElement());
    }

    public MediaObject alignLeftMedia(MediaAlign align) {
        if (nonNull(leftMedia)) {
            leftMedia.style().remove(leftAlign.style);
            leftMedia.style().add(align.style);
            this.leftAlign = align;
        }
        return this;
    }

    public MediaObject alignRightMedia(MediaAlign align) {
        if (nonNull(rightMedia)) {
            rightMedia.style().remove(rightAlign.style);
            rightMedia.style().add(align.style);
            this.rightAlign = align;
        }
        return this;
    }

    public DominoElement<HTMLDivElement> getMediaBody() {
        return DominoElement.of(mediaBody);
    }

    public DominoElement<HTMLHeadingElement> getMediaHeader() {
        return DominoElement.of(mediaHeader);
    }

    public DominoElement<HTMLDivElement> getLeftMedia() {
        return leftMedia;
    }

    public DominoElement<HTMLDivElement> getRightMedia() {
        return rightMedia;
    }

    public enum MediaAlign {
        MIDDLE("media-middle"),
        BOTTOM("media-bottom"),
        TOP("media-top");

        private final String style;

        MediaAlign(String style) {
            this.style = style;
        }
    }
}
