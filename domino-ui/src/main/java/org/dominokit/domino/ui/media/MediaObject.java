package org.dominokit.domino.ui.media;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;

public class MediaObject extends BaseDominoElement<HTMLDivElement, MediaObject> implements IsElement<HTMLDivElement> {

    private HTMLHeadingElement mediaHeader = h(4)
            .css(MediaStyles.MEDIA_HEADING)
            .element();

    private HTMLDivElement mediaBody = div()
            .css(MediaStyles.MEDIA_BODY)
            .add(mediaHeader)
            .element();

    private HTMLDivElement element = div()
            .css(MediaStyles.MEDIA)
            .add(mediaBody)
            .element();

    private DominoElement<HTMLDivElement> leftMedia;
    private DominoElement<HTMLDivElement> rightMedia;

    private MediaAlign leftAlign = MediaAlign.TOP;
    private MediaAlign rightAlign = MediaAlign.TOP;

    public MediaObject() {
        init(this);
    }

    public static MediaObject create() {
        return new MediaObject();
    }

    public MediaObject setHeader(String header) {
        mediaHeader.textContent = header;
        return this;
    }

    public MediaObject setLeftMedia(Node content) {
        if (isNull(leftMedia)) {
            leftMedia = DominoElement.of(div().css(MediaStyles.MEDIA_LEFT));
            insertBefore(leftMedia, mediaBody);
        }

        leftMedia.clearElement();
        leftMedia.appendChild(content);
        return this;
    }

    public MediaObject setLeftMedia(IsElement element) {
        return setLeftMedia(element.element());
    }

    public MediaObject setRightMedia(Node content) {
        if (isNull(rightMedia)) {
            rightMedia = DominoElement.of(div().css(MediaStyles.MEDIA_RIGHT).css(Styles.pull_right));
            appendChild(rightMedia);
        }

        rightMedia.clearElement();
        rightMedia.appendChild(content);
        return this;
    }

    public MediaObject setRightMedia(IsElement element) {
        return setRightMedia(element.element());
    }

    public MediaObject appendChild(Node content) {
        mediaBody.appendChild(content);
        return this;
    }

    public MediaObject appendChild(IsElement content) {
        return appendChild(content.element());
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

    @Override
    public HTMLDivElement element() {
        return element;
    }

    public enum MediaAlign {
        MIDDLE(MediaStyles.MEDIA_MIDDLE),
        BOTTOM(MediaStyles.MEDIA_BOTTOM),
        TOP(MediaStyles.MEDIA_TOP);

        private final String style;

        MediaAlign(String style) {
            this.style = style;
        }
    }
}
