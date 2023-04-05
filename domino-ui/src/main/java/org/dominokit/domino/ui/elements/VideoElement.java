package org.dominokit.domino.ui.elements;

import elemental2.dom.HTMLVideoElement;

public class VideoElement extends BaseElement<HTMLVideoElement, VideoElement> {
    public static VideoElement of(HTMLVideoElement e) {
        return new VideoElement(e);
    }

    public VideoElement(HTMLVideoElement element) {
        super(element);
    }
}