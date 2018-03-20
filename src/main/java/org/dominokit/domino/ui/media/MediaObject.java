package org.dominokit.domino.ui.media;

import org.dominokit.domino.ui.utils.ElementUtil;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

@Templated
public abstract class MediaObject implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLDivElement mediaBody;

    @DataElement
    HTMLHeadingElement mediaHeader;

    private HTMLDivElement leftMedia;
    private HTMLDivElement rightMedia;

    private MediaAlign leftAlign = MediaAlign.TOP;
    private MediaAlign rightAlign = MediaAlign.TOP;

    public static MediaObject create() {
        return new Templated_MediaObject();
    }

    public MediaObject setHeader(String header) {
        mediaHeader.textContent = header;
        return this;
    }

    public MediaObject setLeftMedia(Node content) {
        if (isNull(leftMedia)) {
            leftMedia = div().css("media-left").asElement();
            asElement().insertBefore(leftMedia, mediaBody);
        }

        ElementUtil.clear(leftMedia);
        leftMedia.appendChild(content);
        return this;
    }

    public MediaObject setRightMedia(Node content) {
        if (isNull(rightMedia)) {
            rightMedia = div().css("media-right").asElement();
            asElement().appendChild(rightMedia);
        }

        ElementUtil.clear(rightMedia);
        rightMedia.appendChild(content);
        return this;
    }

    public MediaObject appendContent(Node content) {
        mediaBody.appendChild(content);
        return this;
    }

    public MediaObject alignLeftMedia(MediaAlign align) {
        if (nonNull(leftMedia)) {
            leftMedia.classList.remove(leftAlign.style);
            leftMedia.classList.add(align.style);
            this.leftAlign = align;
        }
        return this;
    }

    public MediaObject alignRightMedia(MediaAlign align) {
        if (nonNull(rightMedia)) {
            rightMedia.classList.remove(rightAlign.style);
            rightMedia.classList.add(align.style);
            this.rightAlign = align;
        }
        return this;
    }

    public HTMLDivElement getMediaBody() {
        return mediaBody;
    }

    public HTMLHeadingElement getMediaHeader() {
        return mediaHeader;
    }

    public HTMLDivElement getLeftMedia() {
        return leftMedia;
    }

    public HTMLDivElement getRightMedia() {
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
